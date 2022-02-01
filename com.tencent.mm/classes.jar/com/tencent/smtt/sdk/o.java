package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class o
{
  public static ThreadLocal<Integer> a;
  static boolean b;
  static final FileFilter c;
  private static o d;
  private static final ReentrantLock i;
  private static final Lock j;
  private static FileLock l;
  private static Handler m;
  private static final Long[][] n;
  private static int o;
  private static boolean p;
  private int e;
  private FileLock f;
  private FileOutputStream g;
  private boolean h;
  private boolean k;
  
  static
  {
    AppMethodBeat.i(55292);
    d = null;
    i = new ReentrantLock();
    j = new ReentrantLock();
    l = null;
    a = new o.1();
    m = null;
    Long[] arrayOfLong1 = { Long.valueOf(44005L), Long.valueOf(39094008L) };
    Long[] arrayOfLong2 = { Long.valueOf(44029L), Long.valueOf(39094008L) };
    Long[] arrayOfLong3 = { Long.valueOf(44033L), Long.valueOf(39094008L) };
    Long[] arrayOfLong4 = { Long.valueOf(44034L), Long.valueOf(39094008L) };
    n = new Long[][] { { Long.valueOf(44006L), Long.valueOf(39094008L) }, arrayOfLong1, { Long.valueOf(43910L), Long.valueOf(38917816L) }, { Long.valueOf(44027L), Long.valueOf(39094008L) }, { Long.valueOf(44028L), Long.valueOf(39094008L) }, arrayOfLong2, { Long.valueOf(44030L), Long.valueOf(39094008L) }, { Long.valueOf(44032L), Long.valueOf(39094008L) }, arrayOfLong3, arrayOfLong4, { Long.valueOf(43909L), Long.valueOf(38917816L) } };
    b = false;
    c = new o.2();
    o = 0;
    p = false;
    AppMethodBeat.o(55292);
  }
  
  private o()
  {
    AppMethodBeat.i(55214);
    this.e = 0;
    this.h = false;
    this.k = false;
    if (m == null) {
      m = new Handler(m.a().getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(55115);
          QbSdk.setTBSInstallingStatus(true);
          switch (paramAnonymousMessage.what)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(55115);
            return;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
            paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
            o.a(o.this, (Context)paramAnonymousMessage[0], (String)paramAnonymousMessage[1], ((Integer)paramAnonymousMessage[2]).intValue());
            AppMethodBeat.o(55115);
            return;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
            paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
            o.a(o.this, (Context)paramAnonymousMessage[0], (Context)paramAnonymousMessage[1], ((Integer)paramAnonymousMessage[2]).intValue());
            AppMethodBeat.o(55115);
            return;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
            paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
            o.this.b((Context)paramAnonymousMessage[0], (Bundle)paramAnonymousMessage[1]);
            AppMethodBeat.o(55115);
            return;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_UNZIP_TBS_CORE");
            Object[] arrayOfObject = (Object[])paramAnonymousMessage.obj;
            o.this.b((Context)arrayOfObject[0], (File)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
            QbSdk.setTBSInstallingStatus(false);
            super.handleMessage(paramAnonymousMessage);
          }
        }
      };
    }
    AppMethodBeat.o(55214);
  }
  
  private void A(Context paramContext)
  {
    AppMethodBeat.i(55270);
    TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
    f.a(q(paramContext), false);
    AppMethodBeat.o(55270);
  }
  
  private void B(Context paramContext)
  {
    AppMethodBeat.i(55271);
    TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
    File localFile1 = f(paramContext, 0);
    File localFile2 = q(paramContext);
    if ((localFile1 == null) || (localFile2 == null))
    {
      TbsLog.i("TbsInstaller", "renameTbsCoreShareDir return,tmpTbsCoreUnzipDir=" + localFile1 + "tbsSharePath=" + localFile2);
      AppMethodBeat.o(55271);
      return;
    }
    boolean bool = localFile1.renameTo(localFile2);
    TbsLog.i("TbsInstaller", "renameTbsCoreShareDir rename success=".concat(String.valueOf(bool)));
    if ((paramContext != null) && ("com.tencent.mm".equals(paramContext.getApplicationContext().getApplicationInfo().packageName)))
    {
      if (!bool) {
        break label143;
      }
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(230, " ");
    }
    for (;;)
    {
      g(paramContext, false);
      AppMethodBeat.o(55271);
      return;
      label143:
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(231, " ");
    }
  }
  
  private void C(Context paramContext)
  {
    AppMethodBeat.i(55273);
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
    File localFile1 = f(paramContext, 1);
    File localFile2 = q(paramContext);
    if ((localFile1 == null) || (localFile2 == null))
    {
      AppMethodBeat.o(55273);
      return;
    }
    localFile1.renameTo(localFile2);
    g(paramContext, false);
    AppMethodBeat.o(55273);
  }
  
  private void D(Context paramContext)
  {
    AppMethodBeat.i(55274);
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
    File localFile1 = f(paramContext, 5);
    File localFile2 = q(paramContext);
    if ((localFile1 == null) || (localFile2 == null))
    {
      AppMethodBeat.o(55274);
      return;
    }
    localFile1.renameTo(localFile2);
    g(paramContext, false);
    AppMethodBeat.o(55274);
  }
  
  private void E(Context paramContext)
  {
    AppMethodBeat.i(55275);
    TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
    File localFile = f(paramContext, 0);
    if (localFile != null) {
      f.a(localFile, false);
    }
    l.a(paramContext).c(0, 5);
    l.a(paramContext).c(-1);
    QbSdk.a(paramContext, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    AppMethodBeat.o(55275);
  }
  
  /* Error */
  static o a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 277
    //   6: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 56	com/tencent/smtt/sdk/o:d	Lcom/tencent/smtt/sdk/o;
    //   12: ifnonnull +25 -> 37
    //   15: ldc 2
    //   17: monitorenter
    //   18: getstatic 56	com/tencent/smtt/sdk/o:d	Lcom/tencent/smtt/sdk/o;
    //   21: ifnonnull +13 -> 34
    //   24: new 2	com/tencent/smtt/sdk/o
    //   27: dup
    //   28: invokespecial 278	com/tencent/smtt/sdk/o:<init>	()V
    //   31: putstatic 56	com/tencent/smtt/sdk/o:d	Lcom/tencent/smtt/sdk/o;
    //   34: ldc 2
    //   36: monitorexit
    //   37: getstatic 56	com/tencent/smtt/sdk/o:d	Lcom/tencent/smtt/sdk/o;
    //   40: astore_0
    //   41: ldc_w 277
    //   44: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: ldc_w 277
    //   59: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_0
    //   63: athrow
    //   64: astore_0
    //   65: ldc 2
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   40	11	0	localo	o
    //   52	11	0	localObject1	Object
    //   64	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	34	52	finally
    //   34	37	52	finally
    //   53	56	52	finally
    //   3	18	64	finally
    //   37	47	64	finally
    //   56	64	64	finally
  }
  
  /* Error */
  private void a(int paramInt, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 284
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 194	java/io/File
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 289	java/io/File:delete	()Z
    //   17: pop
    //   18: ldc 149
    //   20: new 174	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 291
    //   27: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_2
    //   31: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 293
    //   37: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: iconst_1
    //   44: invokestatic 296	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   47: new 194	java/io/File
    //   50: dup
    //   51: aload_3
    //   52: invokestatic 299	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   55: ldc_w 301
    //   58: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 307	java/io/File:canRead	()Z
    //   66: ifeq +181 -> 247
    //   69: new 194	java/io/File
    //   72: dup
    //   73: aload_2
    //   74: ldc_w 309
    //   77: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   80: astore_2
    //   81: new 311	java/util/Properties
    //   84: dup
    //   85: invokespecial 312	java/util/Properties:<init>	()V
    //   88: astore 4
    //   90: new 314	java/io/BufferedInputStream
    //   93: dup
    //   94: new 316	java/io/FileInputStream
    //   97: dup
    //   98: aload_2
    //   99: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   102: invokespecial 322	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   105: astore_3
    //   106: aload 4
    //   108: aload_3
    //   109: invokevirtual 325	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   112: new 327	java/io/BufferedOutputStream
    //   115: dup
    //   116: new 329	java/io/FileOutputStream
    //   119: dup
    //   120: aload_2
    //   121: invokespecial 330	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   124: invokespecial 333	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   127: astore_2
    //   128: aload 4
    //   130: ldc_w 335
    //   133: ldc_w 337
    //   136: invokevirtual 341	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   139: pop
    //   140: aload 4
    //   142: aload_2
    //   143: aconst_null
    //   144: invokevirtual 345	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   147: ldc 149
    //   149: ldc_w 347
    //   152: iconst_1
    //   153: invokestatic 296	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   156: aload_2
    //   157: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   160: aload_3
    //   161: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   164: ldc_w 284
    //   167: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: astore_2
    //   172: ldc_w 284
    //   175: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: return
    //   179: astore_2
    //   180: aconst_null
    //   181: astore_2
    //   182: aconst_null
    //   183: astore_3
    //   184: aload_2
    //   185: ifnull +7 -> 192
    //   188: aload_2
    //   189: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   192: aload_3
    //   193: ifnull +54 -> 247
    //   196: aload_3
    //   197: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   200: ldc_w 284
    //   203: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: return
    //   207: astore_2
    //   208: ldc_w 284
    //   211: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: return
    //   215: astore_2
    //   216: aconst_null
    //   217: astore_3
    //   218: aconst_null
    //   219: astore 4
    //   221: aload_3
    //   222: ifnull +7 -> 229
    //   225: aload_3
    //   226: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   229: aload 4
    //   231: ifnull +8 -> 239
    //   234: aload 4
    //   236: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   239: ldc_w 284
    //   242: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aload_2
    //   246: athrow
    //   247: ldc_w 284
    //   250: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: return
    //   254: astore_2
    //   255: goto -95 -> 160
    //   258: astore_2
    //   259: goto -67 -> 192
    //   262: astore_3
    //   263: goto -34 -> 229
    //   266: astore_3
    //   267: goto -28 -> 239
    //   270: astore_2
    //   271: aconst_null
    //   272: astore 5
    //   274: aload_3
    //   275: astore 4
    //   277: aload 5
    //   279: astore_3
    //   280: goto -59 -> 221
    //   283: astore 5
    //   285: aload_2
    //   286: astore 6
    //   288: aload_3
    //   289: astore 4
    //   291: aload 5
    //   293: astore_2
    //   294: aload 6
    //   296: astore_3
    //   297: goto -76 -> 221
    //   300: astore_2
    //   301: aconst_null
    //   302: astore_2
    //   303: goto -119 -> 184
    //   306: astore 4
    //   308: goto -124 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	o
    //   0	311	1	paramInt	int
    //   0	311	2	paramString	String
    //   0	311	3	paramContext	Context
    //   88	202	4	localObject1	Object
    //   306	1	4	localThrowable	Throwable
    //   272	6	5	localObject2	Object
    //   283	9	5	localObject3	Object
    //   286	9	6	str	String
    // Exception table:
    //   from	to	target	type
    //   160	164	171	java/io/IOException
    //   90	106	179	java/lang/Throwable
    //   196	200	207	java/io/IOException
    //   90	106	215	finally
    //   156	160	254	java/io/IOException
    //   188	192	258	java/io/IOException
    //   225	229	262	java/io/IOException
    //   234	239	266	java/io/IOException
    //   106	128	270	finally
    //   128	156	283	finally
    //   106	128	300	java/lang/Throwable
    //   128	156	306	java/lang/Throwable
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(55221);
    if (!v(paramContext))
    {
      if (a(paramContext, "core_unzip_tmp"))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
        TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
        AppMethodBeat.o(55221);
        return;
      }
      if (a(paramContext, "core_share_backup_tmp"))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
        TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
        AppMethodBeat.o(55221);
        return;
      }
      if (a(paramContext, "core_copy_tmp"))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
        TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
      }
    }
    AppMethodBeat.o(55221);
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private void a(Context paramContext1, Context paramContext2, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 394
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   10: sipush -524
    //   13: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   16: aload_0
    //   17: aload_2
    //   18: invokevirtual 404	com/tencent/smtt/sdk/o:c	(Landroid/content/Context;)Z
    //   21: ifeq +10 -> 31
    //   24: ldc_w 394
    //   27: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: return
    //   31: ldc 149
    //   33: ldc_w 406
    //   36: iload_3
    //   37: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   40: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   43: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: getstatic 414	android/os/Build$VERSION:SDK_INT	I
    //   49: bipush 11
    //   51: if_icmplt +73 -> 124
    //   54: aload_2
    //   55: ldc_w 416
    //   58: iconst_4
    //   59: invokevirtual 420	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   62: astore 15
    //   64: aload 15
    //   66: ldc_w 422
    //   69: iconst_m1
    //   70: invokeinterface 428 3 0
    //   75: iload_3
    //   76: if_icmpne +61 -> 137
    //   79: ldc 149
    //   81: new 174	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 430
    //   88: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: iload_3
    //   92: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: ldc_w 435
    //   98: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_1
    //   108: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   111: sipush -525
    //   114: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   117: ldc_w 394
    //   120: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: return
    //   124: aload_2
    //   125: ldc_w 416
    //   128: iconst_0
    //   129: invokevirtual 420	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   132: astore 15
    //   134: goto -70 -> 64
    //   137: aload_0
    //   138: aload_2
    //   139: invokevirtual 438	com/tencent/smtt/sdk/o:t	(Landroid/content/Context;)Z
    //   142: ifne +20 -> 162
    //   145: aload_1
    //   146: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   149: sipush -526
    //   152: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   155: ldc_w 394
    //   158: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: return
    //   162: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   165: invokeinterface 443 1 0
    //   170: istore 8
    //   172: ldc 149
    //   174: ldc_w 445
    //   177: iload 8
    //   179: invokestatic 205	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   182: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   185: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: iload 8
    //   190: ifeq +1813 -> 2003
    //   193: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   196: invokevirtual 448	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   199: aconst_null
    //   200: astore 16
    //   202: aload_2
    //   203: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   206: ldc_w 450
    //   209: invokevirtual 453	com/tencent/smtt/sdk/l:c	(Ljava/lang/String;)I
    //   212: istore 4
    //   214: aload_2
    //   215: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   218: ldc_w 455
    //   221: invokevirtual 457	com/tencent/smtt/sdk/l:b	(Ljava/lang/String;)I
    //   224: istore 5
    //   226: iload 4
    //   228: iload_3
    //   229: if_icmpne +49 -> 278
    //   232: getstatic 460	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   235: sipush 220
    //   238: invokeinterface 465 2 0
    //   243: aload_1
    //   244: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   247: sipush -528
    //   250: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   253: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   256: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   259: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   262: invokeinterface 469 1 0
    //   267: aload_0
    //   268: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   271: ldc_w 394
    //   274: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: return
    //   278: aload_0
    //   279: aload_2
    //   280: invokevirtual 474	com/tencent/smtt/sdk/o:i	(Landroid/content/Context;)I
    //   283: istore 6
    //   285: ldc 149
    //   287: ldc_w 476
    //   290: iload 6
    //   292: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   295: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   298: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: iload 6
    //   303: iload_3
    //   304: if_icmpne +65 -> 369
    //   307: getstatic 460	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   310: sipush 220
    //   313: invokeinterface 465 2 0
    //   318: aload_1
    //   319: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   322: sipush -528
    //   325: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   328: ldc 149
    //   330: ldc_w 478
    //   333: iload 6
    //   335: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   338: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   341: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   347: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   350: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   353: invokeinterface 469 1 0
    //   358: aload_0
    //   359: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   362: ldc_w 394
    //   365: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: return
    //   369: aload_2
    //   370: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   373: invokevirtual 481	com/tencent/smtt/sdk/l:b	()I
    //   376: istore 7
    //   378: iload 7
    //   380: ifle +1690 -> 2070
    //   383: iload_3
    //   384: iload 7
    //   386: if_icmpgt +6 -> 392
    //   389: goto +1681 -> 2070
    //   392: aload_0
    //   393: aload_2
    //   394: invokevirtual 483	com/tencent/smtt/sdk/o:o	(Landroid/content/Context;)V
    //   397: goto +1687 -> 2084
    //   400: iconst_m1
    //   401: istore 4
    //   403: aload_0
    //   404: aload_2
    //   405: invokevirtual 483	com/tencent/smtt/sdk/o:o	(Landroid/content/Context;)V
    //   408: ldc 149
    //   410: ldc_w 485
    //   413: iconst_1
    //   414: invokestatic 296	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   417: aload_2
    //   418: invokestatic 487	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   421: ifne +91 -> 512
    //   424: invokestatic 492	com/tencent/smtt/utils/q:a	()J
    //   427: lstore 11
    //   429: aload_2
    //   430: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   433: invokevirtual 495	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   436: lstore 13
    //   438: aload_1
    //   439: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   442: sipush -529
    //   445: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   448: aload_2
    //   449: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   452: sipush 210
    //   455: new 174	java/lang/StringBuilder
    //   458: dup
    //   459: ldc_w 497
    //   462: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   465: lload 11
    //   467: invokevirtual 500	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   470: ldc_w 502
    //   473: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: lload 13
    //   478: invokevirtual 500	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   481: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   487: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   490: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   493: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   496: invokeinterface 469 1 0
    //   501: aload_0
    //   502: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   505: ldc_w 394
    //   508: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: return
    //   512: iload 4
    //   514: ifle +77 -> 591
    //   517: aload_2
    //   518: invokestatic 507	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   521: ifne +19 -> 540
    //   524: aload_2
    //   525: invokestatic 511	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   528: ifeq +12 -> 540
    //   531: iload_3
    //   532: aload_0
    //   533: aload_2
    //   534: invokevirtual 513	com/tencent/smtt/sdk/o:h	(Landroid/content/Context;)I
    //   537: if_icmpne +54 -> 591
    //   540: ldc 149
    //   542: new 174	java/lang/StringBuilder
    //   545: dup
    //   546: ldc_w 515
    //   549: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   552: aload_0
    //   553: aload_2
    //   554: invokevirtual 513	com/tencent/smtt/sdk/o:h	(Landroid/content/Context;)I
    //   557: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   566: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   569: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   572: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   575: invokeinterface 469 1 0
    //   580: aload_0
    //   581: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   584: ldc_w 394
    //   587: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   590: return
    //   591: iload 4
    //   593: ifne +83 -> 676
    //   596: aload_2
    //   597: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   600: ldc_w 517
    //   603: invokevirtual 453	com/tencent/smtt/sdk/l:c	(Ljava/lang/String;)I
    //   606: istore 4
    //   608: iload 4
    //   610: iconst_2
    //   611: if_icmple +51 -> 662
    //   614: aload_2
    //   615: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   618: sipush 211
    //   621: ldc_w 519
    //   624: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   627: aload_1
    //   628: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   631: sipush -530
    //   634: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   637: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   640: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   643: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   646: invokeinterface 469 1 0
    //   651: aload_0
    //   652: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   655: ldc_w 394
    //   658: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   661: return
    //   662: aload_2
    //   663: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   666: ldc_w 517
    //   669: iload 4
    //   671: iconst_1
    //   672: iadd
    //   673: invokevirtual 522	com/tencent/smtt/sdk/l:a	(Ljava/lang/String;I)V
    //   676: aload_0
    //   677: aload_1
    //   678: invokevirtual 160	com/tencent/smtt/sdk/o:q	(Landroid/content/Context;)Ljava/io/File;
    //   681: astore 17
    //   683: aload_2
    //   684: invokestatic 507	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   687: ifne +218 -> 905
    //   690: aload_2
    //   691: invokestatic 511	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   694: ifeq +196 -> 890
    //   697: aload_0
    //   698: aload_2
    //   699: invokevirtual 524	com/tencent/smtt/sdk/o:p	(Landroid/content/Context;)Ljava/io/File;
    //   702: astore 15
    //   704: aload 15
    //   706: astore 16
    //   708: aload 17
    //   710: ifnull +1192 -> 1902
    //   713: aload 16
    //   715: ifnull +1187 -> 1902
    //   718: aload_2
    //   719: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   722: iload_3
    //   723: iconst_0
    //   724: invokevirtual 526	com/tencent/smtt/sdk/l:a	(II)V
    //   727: new 528	com/tencent/smtt/utils/p
    //   730: dup
    //   731: invokespecial 529	com/tencent/smtt/utils/p:<init>	()V
    //   734: astore 15
    //   736: aload 15
    //   738: aload 17
    //   740: invokevirtual 531	com/tencent/smtt/utils/p:a	(Ljava/io/File;)V
    //   743: invokestatic 536	java/lang/System:currentTimeMillis	()J
    //   746: lstore 11
    //   748: aload_1
    //   749: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   752: sipush -551
    //   755: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   758: aload 17
    //   760: aload 16
    //   762: getstatic 117	com/tencent/smtt/sdk/o:c	Ljava/io/FileFilter;
    //   765: invokestatic 539	com/tencent/smtt/utils/f:a	(Ljava/io/File;Ljava/io/File;Ljava/io/FileFilter;)Z
    //   768: istore 8
    //   770: aload_2
    //   771: invokestatic 511	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   774: ifeq +7 -> 781
    //   777: aload_2
    //   778: invokestatic 541	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   781: ldc 149
    //   783: new 174	java/lang/StringBuilder
    //   786: dup
    //   787: ldc_w 543
    //   790: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   793: invokestatic 536	java/lang/System:currentTimeMillis	()J
    //   796: lload 11
    //   798: lsub
    //   799: invokevirtual 500	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   802: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   808: iload 8
    //   810: ifeq +1043 -> 1853
    //   813: aload 15
    //   815: aload 17
    //   817: invokevirtual 545	com/tencent/smtt/utils/p:b	(Ljava/io/File;)V
    //   820: aload 15
    //   822: invokevirtual 547	com/tencent/smtt/utils/p:a	()Z
    //   825: ifne +95 -> 920
    //   828: ldc 149
    //   830: ldc_w 549
    //   833: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   836: aload 16
    //   838: iconst_1
    //   839: invokestatic 165	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   842: aload_2
    //   843: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   846: sipush 213
    //   849: ldc_w 551
    //   852: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   855: aload_1
    //   856: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   859: sipush -531
    //   862: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   865: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   868: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   871: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   874: invokeinterface 469 1 0
    //   879: aload_0
    //   880: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   883: ldc_w 394
    //   886: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   889: return
    //   890: aload_0
    //   891: aload_2
    //   892: iconst_1
    //   893: invokevirtual 172	com/tencent/smtt/sdk/o:f	(Landroid/content/Context;I)Ljava/io/File;
    //   896: astore 15
    //   898: aload 15
    //   900: astore 16
    //   902: goto -194 -> 708
    //   905: aload_0
    //   906: aload_2
    //   907: iconst_1
    //   908: invokevirtual 172	com/tencent/smtt/sdk/o:f	(Landroid/content/Context;I)Ljava/io/File;
    //   911: astore 15
    //   913: aload 15
    //   915: astore 16
    //   917: goto -209 -> 708
    //   920: iconst_1
    //   921: istore 8
    //   923: iconst_1
    //   924: istore 10
    //   926: iconst_1
    //   927: istore 9
    //   929: aconst_null
    //   930: astore 19
    //   932: aconst_null
    //   933: astore 18
    //   935: new 194	java/io/File
    //   938: dup
    //   939: aload 16
    //   941: ldc_w 553
    //   944: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   947: astore 17
    //   949: new 311	java/util/Properties
    //   952: dup
    //   953: invokespecial 312	java/util/Properties:<init>	()V
    //   956: astore 15
    //   958: aload 17
    //   960: invokevirtual 556	java/io/File:exists	()Z
    //   963: ifeq +222 -> 1185
    //   966: new 314	java/io/BufferedInputStream
    //   969: dup
    //   970: new 316	java/io/FileInputStream
    //   973: dup
    //   974: aload 17
    //   976: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   979: invokespecial 322	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   982: astore 17
    //   984: aload 15
    //   986: aload 17
    //   988: invokevirtual 325	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   991: iload 9
    //   993: istore 8
    //   995: aload 17
    //   997: astore 18
    //   999: aload 15
    //   1001: astore 17
    //   1003: iload 8
    //   1005: istore 9
    //   1007: aload 18
    //   1009: ifnull +1050 -> 2059
    //   1012: aload 18
    //   1014: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   1017: ldc 149
    //   1019: ldc_w 558
    //   1022: iload 8
    //   1024: invokestatic 205	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1027: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1030: invokestatic 560	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1033: iload 8
    //   1035: ifeq +1018 -> 2053
    //   1038: aload 16
    //   1040: invokevirtual 564	java/io/File:listFiles	()[Ljava/io/File;
    //   1043: astore 17
    //   1045: aload_1
    //   1046: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1049: sipush -552
    //   1052: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1055: iconst_0
    //   1056: istore 4
    //   1058: iconst_1
    //   1059: istore 9
    //   1061: iload 9
    //   1063: istore 10
    //   1065: iload 4
    //   1067: aload 17
    //   1069: arraylength
    //   1070: if_icmpge +384 -> 1454
    //   1073: aload 17
    //   1075: iload 4
    //   1077: aaload
    //   1078: astore 18
    //   1080: ldc_w 553
    //   1083: aload 18
    //   1085: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   1088: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1091: ifne +53 -> 1144
    //   1094: aload 18
    //   1096: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   1099: ldc_w 569
    //   1102: invokevirtual 573	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1105: ifne +39 -> 1144
    //   1108: ldc_w 309
    //   1111: aload 18
    //   1113: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   1116: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1119: ifne +25 -> 1144
    //   1122: aload 18
    //   1124: invokevirtual 576	java/io/File:isDirectory	()Z
    //   1127: ifne +17 -> 1144
    //   1130: aload 18
    //   1132: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   1135: ldc_w 578
    //   1138: invokevirtual 573	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1141: ifeq +181 -> 1322
    //   1144: ldc 149
    //   1146: new 174	java/lang/StringBuilder
    //   1149: dup
    //   1150: ldc_w 580
    //   1153: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1156: aload 18
    //   1158: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   1161: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: ldc_w 582
    //   1167: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1173: invokestatic 560	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1176: iload 4
    //   1178: iconst_1
    //   1179: iadd
    //   1180: istore 4
    //   1182: goto -121 -> 1061
    //   1185: iconst_0
    //   1186: istore 8
    //   1188: aconst_null
    //   1189: astore 18
    //   1191: goto -192 -> 999
    //   1194: astore 17
    //   1196: goto -179 -> 1017
    //   1199: astore 15
    //   1201: aconst_null
    //   1202: astore 15
    //   1204: aload 15
    //   1206: astore 17
    //   1208: iload 10
    //   1210: istore 9
    //   1212: aload 18
    //   1214: ifnull +845 -> 2059
    //   1217: aload 18
    //   1219: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   1222: goto -205 -> 1017
    //   1225: astore 17
    //   1227: goto -210 -> 1017
    //   1230: astore 15
    //   1232: aload 19
    //   1234: astore 17
    //   1236: aload 17
    //   1238: ifnull +8 -> 1246
    //   1241: aload 17
    //   1243: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   1246: ldc_w 394
    //   1249: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1252: aload 15
    //   1254: athrow
    //   1255: astore 15
    //   1257: aload_2
    //   1258: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1261: sipush 215
    //   1264: aload 15
    //   1266: invokevirtual 583	java/lang/Exception:toString	()Ljava/lang/String;
    //   1269: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1272: aload_1
    //   1273: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1276: sipush -537
    //   1279: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1282: aload 16
    //   1284: iconst_0
    //   1285: invokestatic 165	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   1288: aload_2
    //   1289: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1292: iconst_0
    //   1293: iconst_m1
    //   1294: invokevirtual 526	com/tencent/smtt/sdk/l:a	(II)V
    //   1297: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1300: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1303: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   1306: invokeinterface 469 1 0
    //   1311: aload_0
    //   1312: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1315: ldc_w 394
    //   1318: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1321: return
    //   1322: aload 18
    //   1324: invokestatic 588	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   1327: astore 19
    //   1329: aload 15
    //   1331: aload 18
    //   1333: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   1336: ldc_w 590
    //   1339: invokevirtual 594	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1342: astore 20
    //   1344: aload 20
    //   1346: ldc_w 590
    //   1349: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1352: ifne +51 -> 1403
    //   1355: aload 19
    //   1357: aload 20
    //   1359: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1362: ifeq +41 -> 1403
    //   1365: ldc 149
    //   1367: new 174	java/lang/StringBuilder
    //   1370: dup
    //   1371: ldc_w 596
    //   1374: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1377: aload 18
    //   1379: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   1382: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: ldc_w 598
    //   1388: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1394: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1397: iconst_1
    //   1398: istore 9
    //   1400: goto -224 -> 1176
    //   1403: iconst_0
    //   1404: istore 10
    //   1406: ldc 149
    //   1408: new 174	java/lang/StringBuilder
    //   1411: dup
    //   1412: ldc_w 600
    //   1415: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1418: aload 18
    //   1420: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   1423: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: ldc_w 602
    //   1429: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: aload 20
    //   1434: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: ldc_w 604
    //   1440: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1443: aload 19
    //   1445: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1451: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1454: ldc 149
    //   1456: ldc_w 606
    //   1459: iload 10
    //   1461: invokestatic 205	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1464: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1467: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1470: iload 8
    //   1472: ifeq +70 -> 1542
    //   1475: iload 10
    //   1477: ifne +65 -> 1542
    //   1480: ldc 149
    //   1482: ldc_w 608
    //   1485: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1488: aload 16
    //   1490: iconst_1
    //   1491: invokestatic 165	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   1494: aload_2
    //   1495: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1498: sipush 213
    //   1501: ldc_w 610
    //   1504: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1507: aload_1
    //   1508: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1511: sipush -532
    //   1514: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1517: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1520: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1523: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   1526: invokeinterface 469 1 0
    //   1531: aload_0
    //   1532: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1535: ldc_w 394
    //   1538: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1541: return
    //   1542: ldc 149
    //   1544: ldc_w 612
    //   1547: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1550: aload_0
    //   1551: aload_2
    //   1552: iconst_1
    //   1553: invokespecial 246	com/tencent/smtt/sdk/o:g	(Landroid/content/Context;Z)V
    //   1556: aload_1
    //   1557: invokestatic 616	com/tencent/smtt/sdk/k:b	(Landroid/content/Context;)Ljava/io/File;
    //   1560: astore 17
    //   1562: aload 17
    //   1564: ifnull +38 -> 1602
    //   1567: aload 17
    //   1569: invokevirtual 556	java/io/File:exists	()Z
    //   1572: ifeq +30 -> 1602
    //   1575: aload_2
    //   1576: invokestatic 619	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1579: ifeq +178 -> 1757
    //   1582: ldc_w 621
    //   1585: astore 15
    //   1587: new 194	java/io/File
    //   1590: dup
    //   1591: aload 17
    //   1593: aload 15
    //   1595: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1598: aload_2
    //   1599: invokestatic 624	com/tencent/smtt/sdk/k:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1602: aload_2
    //   1603: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1606: iload_3
    //   1607: iconst_1
    //   1608: invokevirtual 526	com/tencent/smtt/sdk/l:a	(II)V
    //   1611: aload_0
    //   1612: getfield 132	com/tencent/smtt/sdk/o:k	Z
    //   1615: ifeq +151 -> 1766
    //   1618: aload_2
    //   1619: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1622: sipush 220
    //   1625: ldc_w 626
    //   1628: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1631: aload_1
    //   1632: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1635: sipush -533
    //   1638: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1641: ldc 149
    //   1643: ldc_w 628
    //   1646: iload_3
    //   1647: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1650: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1653: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1656: getstatic 414	android/os/Build$VERSION:SDK_INT	I
    //   1659: bipush 11
    //   1661: if_icmplt +148 -> 1809
    //   1664: aload_2
    //   1665: ldc_w 416
    //   1668: iconst_4
    //   1669: invokevirtual 420	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1672: astore 15
    //   1674: aload 15
    //   1676: invokeinterface 632 1 0
    //   1681: astore 15
    //   1683: aload 15
    //   1685: ldc_w 634
    //   1688: iconst_0
    //   1689: invokeinterface 640 3 0
    //   1694: pop
    //   1695: aload 15
    //   1697: ldc_w 642
    //   1700: iconst_0
    //   1701: invokeinterface 640 3 0
    //   1706: pop
    //   1707: aload 15
    //   1709: ldc_w 644
    //   1712: iload_3
    //   1713: invokeinterface 640 3 0
    //   1718: pop
    //   1719: aload 15
    //   1721: invokeinterface 647 1 0
    //   1726: pop
    //   1727: aload_2
    //   1728: invokestatic 648	com/tencent/smtt/utils/q:a	(Landroid/content/Context;)Z
    //   1731: pop
    //   1732: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1735: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1738: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   1741: invokeinterface 469 1 0
    //   1746: aload_0
    //   1747: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1750: ldc_w 394
    //   1753: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1756: return
    //   1757: iconst_0
    //   1758: invokestatic 651	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   1761: astore 15
    //   1763: goto -176 -> 1587
    //   1766: aload_2
    //   1767: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1770: sipush 220
    //   1773: ldc_w 653
    //   1776: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1779: goto -148 -> 1631
    //   1782: astore_1
    //   1783: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1786: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1789: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   1792: invokeinterface 469 1 0
    //   1797: aload_0
    //   1798: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1801: ldc_w 394
    //   1804: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1807: aload_1
    //   1808: athrow
    //   1809: aload_2
    //   1810: ldc_w 416
    //   1813: iconst_0
    //   1814: invokevirtual 420	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1817: astore 15
    //   1819: goto -145 -> 1674
    //   1822: astore 15
    //   1824: ldc 149
    //   1826: new 174	java/lang/StringBuilder
    //   1829: dup
    //   1830: ldc_w 655
    //   1833: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1836: aload 15
    //   1838: invokestatic 661	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1841: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1847: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1850: goto -123 -> 1727
    //   1853: ldc 149
    //   1855: ldc_w 663
    //   1858: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1861: aload_2
    //   1862: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1865: iload_3
    //   1866: iconst_2
    //   1867: invokevirtual 526	com/tencent/smtt/sdk/l:a	(II)V
    //   1870: aload 16
    //   1872: iconst_0
    //   1873: invokestatic 165	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   1876: aload_1
    //   1877: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1880: sipush -534
    //   1883: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1886: aload_2
    //   1887: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1890: sipush 212
    //   1893: ldc_w 665
    //   1896: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1899: goto -167 -> 1732
    //   1902: aload 17
    //   1904: ifnonnull +26 -> 1930
    //   1907: aload_2
    //   1908: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1911: sipush 213
    //   1914: ldc_w 667
    //   1917: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1920: aload_1
    //   1921: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1924: sipush -535
    //   1927: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1930: aload 16
    //   1932: ifnonnull -200 -> 1732
    //   1935: aload_2
    //   1936: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1939: sipush 214
    //   1942: ldc_w 669
    //   1945: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1948: aload_1
    //   1949: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1952: sipush -536
    //   1955: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1958: goto -226 -> 1732
    //   1961: astore_1
    //   1962: ldc 149
    //   1964: new 174	java/lang/StringBuilder
    //   1967: dup
    //   1968: ldc_w 671
    //   1971: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1974: aload_1
    //   1975: invokevirtual 674	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1978: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1981: ldc_w 676
    //   1984: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1987: aload_1
    //   1988: invokevirtual 680	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   1991: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1994: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1997: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2000: goto -703 -> 1297
    //   2003: aload_0
    //   2004: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   2007: aload_1
    //   2008: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2011: sipush -538
    //   2014: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2017: ldc_w 394
    //   2020: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2023: return
    //   2024: astore 17
    //   2026: goto -780 -> 1246
    //   2029: astore 15
    //   2031: goto -774 -> 1257
    //   2034: astore 15
    //   2036: goto -800 -> 1236
    //   2039: astore 17
    //   2041: goto -837 -> 1204
    //   2044: astore 18
    //   2046: aload 17
    //   2048: astore 18
    //   2050: goto -846 -> 1204
    //   2053: iconst_1
    //   2054: istore 10
    //   2056: goto -602 -> 1454
    //   2059: aload 17
    //   2061: astore 15
    //   2063: iload 9
    //   2065: istore 8
    //   2067: goto -1050 -> 1017
    //   2070: iload 4
    //   2072: ifle +12 -> 2084
    //   2075: iload_3
    //   2076: iload 4
    //   2078: if_icmple +6 -> 2084
    //   2081: goto -1689 -> 392
    //   2084: iload 5
    //   2086: istore 4
    //   2088: iload 5
    //   2090: iconst_3
    //   2091: if_icmpne -1674 -> 417
    //   2094: iload 5
    //   2096: istore 4
    //   2098: iload 6
    //   2100: ifle -1683 -> 417
    //   2103: iload_3
    //   2104: iload 6
    //   2106: if_icmpgt -1706 -> 400
    //   2109: iload 5
    //   2111: istore 4
    //   2113: iload_3
    //   2114: ldc_w 681
    //   2117: if_icmpne -1700 -> 417
    //   2120: goto -1720 -> 400
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2123	0	this	o
    //   0	2123	1	paramContext1	Context
    //   0	2123	2	paramContext2	Context
    //   0	2123	3	paramInt	int
    //   212	1900	4	i1	int
    //   224	1886	5	i2	int
    //   283	1824	6	i3	int
    //   376	11	7	i4	int
    //   170	1896	8	bool1	boolean
    //   927	1137	9	bool2	boolean
    //   924	1131	10	bool3	boolean
    //   427	370	11	l1	long
    //   436	41	13	l2	long
    //   62	938	15	localObject1	Object
    //   1199	1	15	localException1	Exception
    //   1202	3	15	localObject2	Object
    //   1230	23	15	localObject3	Object
    //   1255	75	15	localException2	Exception
    //   1585	233	15	localObject4	Object
    //   1822	15	15	localThrowable	Throwable
    //   2029	1	15	localException3	Exception
    //   2034	1	15	localObject5	Object
    //   2061	1	15	localObject6	Object
    //   200	1731	16	localObject7	Object
    //   681	393	17	localObject8	Object
    //   1194	1	17	localIOException1	java.io.IOException
    //   1206	1	17	localObject9	Object
    //   1225	1	17	localIOException2	java.io.IOException
    //   1234	669	17	localObject10	Object
    //   2024	1	17	localIOException3	java.io.IOException
    //   2039	21	17	localException4	Exception
    //   933	486	18	localObject11	Object
    //   2044	1	18	localException5	Exception
    //   2048	1	18	localException6	Exception
    //   930	514	19	str1	String
    //   1342	91	20	str2	String
    // Exception table:
    //   from	to	target	type
    //   1012	1017	1194	java/io/IOException
    //   935	958	1199	java/lang/Exception
    //   1217	1222	1225	java/io/IOException
    //   935	958	1230	finally
    //   958	984	1230	finally
    //   718	781	1255	java/lang/Exception
    //   781	808	1255	java/lang/Exception
    //   813	865	1255	java/lang/Exception
    //   1012	1017	1255	java/lang/Exception
    //   1017	1033	1255	java/lang/Exception
    //   1038	1055	1255	java/lang/Exception
    //   1065	1073	1255	java/lang/Exception
    //   1080	1144	1255	java/lang/Exception
    //   1144	1176	1255	java/lang/Exception
    //   1217	1222	1255	java/lang/Exception
    //   1241	1246	1255	java/lang/Exception
    //   1246	1255	1255	java/lang/Exception
    //   1322	1397	1255	java/lang/Exception
    //   1406	1454	1255	java/lang/Exception
    //   1454	1470	1255	java/lang/Exception
    //   1480	1517	1255	java/lang/Exception
    //   1542	1562	1255	java/lang/Exception
    //   1567	1582	1255	java/lang/Exception
    //   1587	1602	1255	java/lang/Exception
    //   1602	1631	1255	java/lang/Exception
    //   1631	1674	1255	java/lang/Exception
    //   1674	1727	1255	java/lang/Exception
    //   1727	1732	1255	java/lang/Exception
    //   1757	1763	1255	java/lang/Exception
    //   1766	1779	1255	java/lang/Exception
    //   1809	1819	1255	java/lang/Exception
    //   1824	1850	1255	java/lang/Exception
    //   1853	1899	1255	java/lang/Exception
    //   1907	1930	1255	java/lang/Exception
    //   1935	1958	1255	java/lang/Exception
    //   202	226	1782	finally
    //   232	253	1782	finally
    //   278	301	1782	finally
    //   307	344	1782	finally
    //   369	378	1782	finally
    //   392	397	1782	finally
    //   403	417	1782	finally
    //   417	487	1782	finally
    //   517	540	1782	finally
    //   540	566	1782	finally
    //   596	608	1782	finally
    //   614	637	1782	finally
    //   662	676	1782	finally
    //   676	704	1782	finally
    //   718	781	1782	finally
    //   781	808	1782	finally
    //   813	865	1782	finally
    //   890	898	1782	finally
    //   905	913	1782	finally
    //   1012	1017	1782	finally
    //   1017	1033	1782	finally
    //   1038	1055	1782	finally
    //   1065	1073	1782	finally
    //   1080	1144	1782	finally
    //   1144	1176	1782	finally
    //   1217	1222	1782	finally
    //   1241	1246	1782	finally
    //   1246	1255	1782	finally
    //   1257	1282	1782	finally
    //   1282	1297	1782	finally
    //   1322	1397	1782	finally
    //   1406	1454	1782	finally
    //   1454	1470	1782	finally
    //   1480	1517	1782	finally
    //   1542	1562	1782	finally
    //   1567	1582	1782	finally
    //   1587	1602	1782	finally
    //   1602	1631	1782	finally
    //   1631	1674	1782	finally
    //   1674	1727	1782	finally
    //   1727	1732	1782	finally
    //   1757	1763	1782	finally
    //   1766	1779	1782	finally
    //   1809	1819	1782	finally
    //   1824	1850	1782	finally
    //   1853	1899	1782	finally
    //   1907	1930	1782	finally
    //   1935	1958	1782	finally
    //   1962	2000	1782	finally
    //   1674	1727	1822	java/lang/Throwable
    //   1282	1297	1961	java/lang/Exception
    //   1241	1246	2024	java/io/IOException
    //   202	226	2029	java/lang/Exception
    //   232	253	2029	java/lang/Exception
    //   278	301	2029	java/lang/Exception
    //   307	344	2029	java/lang/Exception
    //   369	378	2029	java/lang/Exception
    //   392	397	2029	java/lang/Exception
    //   403	417	2029	java/lang/Exception
    //   417	487	2029	java/lang/Exception
    //   517	540	2029	java/lang/Exception
    //   540	566	2029	java/lang/Exception
    //   596	608	2029	java/lang/Exception
    //   614	637	2029	java/lang/Exception
    //   662	676	2029	java/lang/Exception
    //   676	704	2029	java/lang/Exception
    //   890	898	2029	java/lang/Exception
    //   905	913	2029	java/lang/Exception
    //   984	991	2034	finally
    //   958	984	2039	java/lang/Exception
    //   984	991	2044	java/lang/Exception
  }
  
  private boolean a(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(55245);
    boolean bool = a(paramContext, paramFile, false);
    AppMethodBeat.o(55245);
    return bool;
  }
  
  /* Error */
  private boolean a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: ldc_w 697
    //   6: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 149
    //   11: ldc_w 699
    //   14: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_2
    //   18: invokestatic 701	com/tencent/smtt/utils/f:c	(Ljava/io/File;)Z
    //   21: ifne +34 -> 55
    //   24: aload_1
    //   25: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   28: sipush 204
    //   31: ldc_w 703
    //   34: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   37: aload_1
    //   38: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   41: sipush -520
    //   44: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   47: ldc_w 697
    //   50: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: iconst_0
    //   54: ireturn
    //   55: aload_1
    //   56: invokestatic 299	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   59: astore 8
    //   61: iload_3
    //   62: ifeq +85 -> 147
    //   65: new 194	java/io/File
    //   68: dup
    //   69: aload 8
    //   71: ldc_w 705
    //   74: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   77: astore 8
    //   79: aload 8
    //   81: invokevirtual 556	java/io/File:exists	()Z
    //   84: ifeq +15 -> 99
    //   87: aload_1
    //   88: invokestatic 511	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   91: ifne +8 -> 99
    //   94: aload 8
    //   96: invokestatic 706	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   99: iload_3
    //   100: ifeq +95 -> 195
    //   103: aload_0
    //   104: aload_1
    //   105: iconst_2
    //   106: invokevirtual 172	com/tencent/smtt/sdk/o:f	(Landroid/content/Context;I)Ljava/io/File;
    //   109: astore 8
    //   111: aload 8
    //   113: ifnonnull +93 -> 206
    //   116: aload_1
    //   117: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   120: sipush 205
    //   123: ldc_w 708
    //   126: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   129: aload_1
    //   130: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   133: sipush -521
    //   136: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   139: ldc_w 697
    //   142: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: iconst_0
    //   146: ireturn
    //   147: new 194	java/io/File
    //   150: dup
    //   151: aload 8
    //   153: ldc_w 301
    //   156: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   159: astore 8
    //   161: goto -82 -> 79
    //   164: astore 8
    //   166: ldc 149
    //   168: new 174	java/lang/StringBuilder
    //   171: dup
    //   172: ldc_w 710
    //   175: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: aload 8
    //   180: invokestatic 661	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   183: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: goto -93 -> 99
    //   195: aload_0
    //   196: aload_1
    //   197: iconst_0
    //   198: invokevirtual 172	com/tencent/smtt/sdk/o:f	(Landroid/content/Context;I)Ljava/io/File;
    //   201: astore 8
    //   203: goto -92 -> 111
    //   206: aload 8
    //   208: invokestatic 712	com/tencent/smtt/utils/f:a	(Ljava/io/File;)Z
    //   211: pop
    //   212: iload_3
    //   213: ifeq +9 -> 222
    //   216: aload 8
    //   218: iconst_1
    //   219: invokestatic 165	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   222: aload_2
    //   223: aload 8
    //   225: invokestatic 715	com/tencent/smtt/utils/f:a	(Ljava/io/File;Ljava/io/File;)Z
    //   228: istore 7
    //   230: iload 7
    //   232: istore 6
    //   234: iload 7
    //   236: ifeq +12 -> 248
    //   239: aload_0
    //   240: aload 8
    //   242: aload_1
    //   243: invokespecial 718	com/tencent/smtt/sdk/o:a	(Ljava/io/File;Landroid/content/Context;)Z
    //   246: istore 6
    //   248: iload_3
    //   249: ifeq +81 -> 330
    //   252: aload 8
    //   254: invokevirtual 722	java/io/File:list	()[Ljava/lang/String;
    //   257: astore_2
    //   258: iconst_0
    //   259: istore 4
    //   261: iload 4
    //   263: aload_2
    //   264: arraylength
    //   265: if_icmpge +47 -> 312
    //   268: new 194	java/io/File
    //   271: dup
    //   272: aload 8
    //   274: aload_2
    //   275: iload 4
    //   277: aaload
    //   278: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   281: astore 9
    //   283: aload 9
    //   285: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   288: ldc_w 569
    //   291: invokevirtual 573	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   294: ifeq +9 -> 303
    //   297: aload 9
    //   299: invokevirtual 289	java/io/File:delete	()Z
    //   302: pop
    //   303: iload 4
    //   305: iconst_1
    //   306: iadd
    //   307: istore 4
    //   309: goto -48 -> 261
    //   312: new 194	java/io/File
    //   315: dup
    //   316: aload_1
    //   317: invokestatic 725	com/tencent/smtt/sdk/o:s	(Landroid/content/Context;)Ljava/io/File;
    //   320: ldc_w 727
    //   323: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   326: invokevirtual 289	java/io/File:delete	()Z
    //   329: pop
    //   330: iload 6
    //   332: ifne +61 -> 393
    //   335: aload 8
    //   337: invokestatic 706	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   340: aload_1
    //   341: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   344: sipush -522
    //   347: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   350: ldc 149
    //   352: new 174	java/lang/StringBuilder
    //   355: dup
    //   356: ldc_w 729
    //   359: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   362: aload 8
    //   364: invokevirtual 556	java/io/File:exists	()Z
    //   367: invokevirtual 732	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   370: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: ldc 149
    //   378: ldc_w 734
    //   381: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   384: ldc_w 697
    //   387: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   390: iload 6
    //   392: ireturn
    //   393: aload_0
    //   394: aload_1
    //   395: iconst_1
    //   396: invokespecial 246	com/tencent/smtt/sdk/o:g	(Landroid/content/Context;Z)V
    //   399: iload_3
    //   400: ifeq -24 -> 376
    //   403: aload_0
    //   404: aload_1
    //   405: invokevirtual 524	com/tencent/smtt/sdk/o:p	(Landroid/content/Context;)Ljava/io/File;
    //   408: astore_2
    //   409: aload_2
    //   410: iconst_1
    //   411: invokestatic 165	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   414: aload 8
    //   416: aload_2
    //   417: invokevirtual 198	java/io/File:renameTo	(Ljava/io/File;)Z
    //   420: pop
    //   421: aload_1
    //   422: invokestatic 541	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   425: goto -49 -> 376
    //   428: astore_2
    //   429: aload_1
    //   430: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   433: sipush -523
    //   436: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   439: aload_1
    //   440: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   443: sipush 206
    //   446: aload_2
    //   447: invokevirtual 737	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   450: aload 8
    //   452: ifnull +256 -> 708
    //   455: aload 8
    //   457: invokevirtual 556	java/io/File:exists	()Z
    //   460: istore_3
    //   461: iload_3
    //   462: ifeq +246 -> 708
    //   465: iload 5
    //   467: istore 4
    //   469: iload 4
    //   471: ifeq +39 -> 510
    //   474: aload 8
    //   476: ifnull +34 -> 510
    //   479: aload 8
    //   481: invokestatic 706	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   484: ldc 149
    //   486: new 174	java/lang/StringBuilder
    //   489: dup
    //   490: ldc_w 739
    //   493: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   496: aload 8
    //   498: invokevirtual 556	java/io/File:exists	()Z
    //   501: invokevirtual 732	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   504: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: ldc 149
    //   512: ldc_w 734
    //   515: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   518: ldc_w 697
    //   521: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   524: iconst_0
    //   525: ireturn
    //   526: astore_1
    //   527: ldc 149
    //   529: new 174	java/lang/StringBuilder
    //   532: dup
    //   533: ldc_w 741
    //   536: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   539: aload_1
    //   540: invokestatic 661	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   543: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: goto -42 -> 510
    //   555: astore_2
    //   556: aload_1
    //   557: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   560: sipush -523
    //   563: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   566: aload_1
    //   567: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   570: sipush 207
    //   573: aload_2
    //   574: invokevirtual 737	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   577: aload 8
    //   579: ifnull +123 -> 702
    //   582: aload 8
    //   584: invokevirtual 556	java/io/File:exists	()Z
    //   587: istore_3
    //   588: iload_3
    //   589: ifeq +113 -> 702
    //   592: iconst_1
    //   593: istore 4
    //   595: iload 4
    //   597: ifeq +39 -> 636
    //   600: aload 8
    //   602: ifnull +34 -> 636
    //   605: aload 8
    //   607: invokestatic 706	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   610: ldc 149
    //   612: new 174	java/lang/StringBuilder
    //   615: dup
    //   616: ldc_w 739
    //   619: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   622: aload 8
    //   624: invokevirtual 556	java/io/File:exists	()Z
    //   627: invokevirtual 732	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   630: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: ldc 149
    //   638: ldc_w 734
    //   641: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: ldc_w 697
    //   647: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   650: iconst_0
    //   651: ireturn
    //   652: astore_1
    //   653: ldc 149
    //   655: new 174	java/lang/StringBuilder
    //   658: dup
    //   659: ldc_w 741
    //   662: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   665: aload_1
    //   666: invokestatic 661	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   669: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   678: goto -42 -> 636
    //   681: astore_1
    //   682: ldc 149
    //   684: ldc_w 734
    //   687: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   690: ldc_w 697
    //   693: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   696: aload_1
    //   697: athrow
    //   698: astore_2
    //   699: goto -369 -> 330
    //   702: iconst_0
    //   703: istore 4
    //   705: goto -110 -> 595
    //   708: iconst_0
    //   709: istore 4
    //   711: goto -242 -> 469
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	714	0	this	o
    //   0	714	1	paramContext	Context
    //   0	714	2	paramFile	File
    //   0	714	3	paramBoolean	boolean
    //   259	451	4	i1	int
    //   1	465	5	i2	int
    //   232	159	6	bool1	boolean
    //   228	7	7	bool2	boolean
    //   59	101	8	localFile1	File
    //   164	15	8	localThrowable	Throwable
    //   201	422	8	localFile2	File
    //   281	17	9	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   55	61	164	java/lang/Throwable
    //   65	79	164	java/lang/Throwable
    //   79	99	164	java/lang/Throwable
    //   147	161	164	java/lang/Throwable
    //   206	212	428	java/io/IOException
    //   216	222	428	java/io/IOException
    //   222	230	428	java/io/IOException
    //   239	248	428	java/io/IOException
    //   252	258	428	java/io/IOException
    //   261	303	428	java/io/IOException
    //   312	330	428	java/io/IOException
    //   335	376	428	java/io/IOException
    //   393	399	428	java/io/IOException
    //   403	425	428	java/io/IOException
    //   479	510	526	java/lang/Throwable
    //   206	212	555	java/lang/Exception
    //   216	222	555	java/lang/Exception
    //   222	230	555	java/lang/Exception
    //   239	248	555	java/lang/Exception
    //   252	258	555	java/lang/Exception
    //   261	303	555	java/lang/Exception
    //   335	376	555	java/lang/Exception
    //   393	399	555	java/lang/Exception
    //   403	425	555	java/lang/Exception
    //   605	636	652	java/lang/Throwable
    //   206	212	681	finally
    //   216	222	681	finally
    //   222	230	681	finally
    //   239	248	681	finally
    //   252	258	681	finally
    //   261	303	681	finally
    //   312	330	681	finally
    //   335	376	681	finally
    //   393	399	681	finally
    //   403	425	681	finally
    //   429	450	681	finally
    //   455	461	681	finally
    //   556	577	681	finally
    //   582	588	681	finally
    //   312	330	698	java/lang/Exception
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(55223);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), paramString);
    if (!paramContext.exists())
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #1");
      AppMethodBeat.o(55223);
      return false;
    }
    if (!new File(paramContext, "tbs.conf").exists())
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #2");
      AppMethodBeat.o(55223);
      return false;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #3");
    AppMethodBeat.o(55223);
    return true;
  }
  
  /* Error */
  private boolean a(File paramFile, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc_w 749
    //   6: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 149
    //   11: new 174	java/lang/StringBuilder
    //   14: dup
    //   15: ldc_w 751
    //   18: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: aload_1
    //   22: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc_w 753
    //   28: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_2
    //   32: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: new 194	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: ldc_w 553
    //   49: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   52: astore_2
    //   53: new 311	java/util/Properties
    //   56: dup
    //   57: invokespecial 312	java/util/Properties:<init>	()V
    //   60: astore 6
    //   62: aload_2
    //   63: invokevirtual 556	java/io/File:exists	()Z
    //   66: ifeq +197 -> 263
    //   69: new 314	java/io/BufferedInputStream
    //   72: dup
    //   73: new 316	java/io/FileInputStream
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 322	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore_2
    //   85: aload 6
    //   87: aload_2
    //   88: invokevirtual 325	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   91: iconst_1
    //   92: istore 5
    //   94: aload_2
    //   95: astore 7
    //   97: aload 6
    //   99: astore_2
    //   100: iload 5
    //   102: istore 4
    //   104: aload 7
    //   106: ifnull +15 -> 121
    //   109: aload 7
    //   111: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   114: iload 5
    //   116: istore 4
    //   118: aload 6
    //   120: astore_2
    //   121: ldc 149
    //   123: ldc_w 755
    //   126: iload 4
    //   128: invokestatic 205	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   131: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   134: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: iload 4
    //   139: ifeq +417 -> 556
    //   142: aload_1
    //   143: invokevirtual 564	java/io/File:listFiles	()[Ljava/io/File;
    //   146: astore_1
    //   147: iconst_0
    //   148: istore_3
    //   149: iload_3
    //   150: aload_1
    //   151: arraylength
    //   152: if_icmpge +404 -> 556
    //   155: aload_1
    //   156: iload_3
    //   157: aaload
    //   158: astore 6
    //   160: ldc_w 553
    //   163: aload 6
    //   165: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   168: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifne +53 -> 224
    //   174: aload 6
    //   176: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   179: ldc_w 569
    //   182: invokevirtual 573	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   185: ifne +39 -> 224
    //   188: ldc_w 309
    //   191: aload 6
    //   193: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   196: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifne +25 -> 224
    //   202: aload 6
    //   204: invokevirtual 576	java/io/File:isDirectory	()Z
    //   207: ifne +17 -> 224
    //   210: aload 6
    //   212: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   215: ldc_w 578
    //   218: invokevirtual 573	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   221: ifeq +101 -> 322
    //   224: ldc 149
    //   226: new 174	java/lang/StringBuilder
    //   229: dup
    //   230: ldc_w 580
    //   233: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   236: aload 6
    //   238: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   241: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 582
    //   247: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 560	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: iload_3
    //   257: iconst_1
    //   258: iadd
    //   259: istore_3
    //   260: goto -111 -> 149
    //   263: aconst_null
    //   264: astore 7
    //   266: iconst_0
    //   267: istore 5
    //   269: goto -172 -> 97
    //   272: astore_2
    //   273: aconst_null
    //   274: astore_2
    //   275: aconst_null
    //   276: astore 6
    //   278: aload 6
    //   280: ifnull +282 -> 562
    //   283: aload 6
    //   285: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   288: iconst_1
    //   289: istore 4
    //   291: goto -170 -> 121
    //   294: astore 6
    //   296: iconst_1
    //   297: istore 4
    //   299: goto -178 -> 121
    //   302: astore_1
    //   303: aload 7
    //   305: astore_2
    //   306: aload_2
    //   307: ifnull +7 -> 314
    //   310: aload_2
    //   311: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   314: ldc_w 749
    //   317: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aload_1
    //   321: athrow
    //   322: aload 6
    //   324: invokestatic 588	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   327: astore 7
    //   329: aload_2
    //   330: aload 6
    //   332: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   335: ldc_w 590
    //   338: invokevirtual 594	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   341: astore 8
    //   343: aload 8
    //   345: ldc_w 590
    //   348: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   351: ifne +48 -> 399
    //   354: aload 8
    //   356: aload 7
    //   358: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifeq +38 -> 399
    //   364: ldc 149
    //   366: new 174	java/lang/StringBuilder
    //   369: dup
    //   370: ldc_w 596
    //   373: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   376: aload 6
    //   378: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   381: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc_w 598
    //   387: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: goto -140 -> 256
    //   399: ldc 149
    //   401: new 174	java/lang/StringBuilder
    //   404: dup
    //   405: ldc_w 600
    //   408: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   411: aload 6
    //   413: invokevirtual 567	java/io/File:getName	()Ljava/lang/String;
    //   416: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: ldc_w 602
    //   422: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 8
    //   427: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: ldc_w 604
    //   433: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 7
    //   438: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: iconst_0
    //   448: istore 5
    //   450: ldc 149
    //   452: ldc_w 757
    //   455: iload 5
    //   457: invokestatic 205	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   460: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   463: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: iload 4
    //   468: ifeq +24 -> 492
    //   471: iload 5
    //   473: ifne +19 -> 492
    //   476: ldc 149
    //   478: ldc_w 759
    //   481: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: ldc_w 749
    //   487: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   490: iconst_0
    //   491: ireturn
    //   492: ldc 149
    //   494: ldc_w 761
    //   497: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: ldc_w 749
    //   503: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   506: iconst_1
    //   507: ireturn
    //   508: astore_2
    //   509: aload 6
    //   511: astore_2
    //   512: iload 5
    //   514: istore 4
    //   516: goto -395 -> 121
    //   519: astore_2
    //   520: goto -206 -> 314
    //   523: astore_1
    //   524: goto -218 -> 306
    //   527: astore_2
    //   528: aconst_null
    //   529: astore 7
    //   531: aload 6
    //   533: astore_2
    //   534: aload 7
    //   536: astore 6
    //   538: goto -260 -> 278
    //   541: astore 7
    //   543: aload_2
    //   544: astore 7
    //   546: aload 6
    //   548: astore_2
    //   549: aload 7
    //   551: astore 6
    //   553: goto -275 -> 278
    //   556: iconst_1
    //   557: istore 5
    //   559: goto -109 -> 450
    //   562: iconst_1
    //   563: istore 4
    //   565: goto -444 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	568	0	this	o
    //   0	568	1	paramFile	File
    //   0	568	2	paramContext	Context
    //   148	112	3	i1	int
    //   102	462	4	bool1	boolean
    //   92	466	5	bool2	boolean
    //   60	224	6	localProperties	java.util.Properties
    //   294	238	6	localIOException	java.io.IOException
    //   536	16	6	localObject1	Object
    //   1	534	7	localObject2	Object
    //   541	1	7	localException	Exception
    //   544	6	7	localContext	Context
    //   341	85	8	str	String
    // Exception table:
    //   from	to	target	type
    //   41	62	272	java/lang/Exception
    //   283	288	294	java/io/IOException
    //   41	62	302	finally
    //   62	85	302	finally
    //   109	114	508	java/io/IOException
    //   310	314	519	java/io/IOException
    //   85	91	523	finally
    //   62	85	527	java/lang/Exception
    //   85	91	541	java/lang/Exception
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private void b(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: ldc_w 762
    //   6: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   13: sipush -501
    //   16: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 404	com/tencent/smtt/sdk/o:c	(Landroid/content/Context;)Z
    //   24: ifeq +29 -> 53
    //   27: ldc 149
    //   29: ldc_w 764
    //   32: iconst_1
    //   33: invokestatic 296	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   36: aload_1
    //   37: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   40: sipush -502
    //   43: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   46: ldc_w 762
    //   49: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: ldc 149
    //   55: ldc_w 766
    //   58: aload_2
    //   59: invokestatic 769	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   62: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: ldc 149
    //   70: ldc_w 771
    //   73: iload_3
    //   74: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   77: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   80: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: ldc 149
    //   85: new 174	java/lang/StringBuilder
    //   88: dup
    //   89: ldc_w 773
    //   92: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload_1
    //   96: invokevirtual 221	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   99: getfield 776	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   102: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: ldc 149
    //   113: new 174	java/lang/StringBuilder
    //   116: dup
    //   117: ldc_w 778
    //   120: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: invokestatic 783	android/os/Process:myPid	()I
    //   126: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: ldc 149
    //   137: new 174	java/lang/StringBuilder
    //   140: dup
    //   141: ldc_w 785
    //   144: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: invokestatic 791	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   150: invokevirtual 792	java/lang/Thread:getName	()Ljava/lang/String;
    //   153: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: getstatic 414	android/os/Build$VERSION:SDK_INT	I
    //   165: bipush 11
    //   167: if_icmplt +73 -> 240
    //   170: aload_1
    //   171: ldc_w 416
    //   174: iconst_4
    //   175: invokevirtual 420	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   178: astore 14
    //   180: aload 14
    //   182: ldc_w 422
    //   185: iconst_m1
    //   186: invokeinterface 428 3 0
    //   191: iload_3
    //   192: if_icmpne +61 -> 253
    //   195: ldc 149
    //   197: new 174	java/lang/StringBuilder
    //   200: dup
    //   201: ldc_w 794
    //   204: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   207: iload_3
    //   208: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: ldc_w 435
    //   214: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_1
    //   224: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   227: sipush -503
    //   230: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   233: ldc_w 762
    //   236: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: return
    //   240: aload_1
    //   241: ldc_w 416
    //   244: iconst_0
    //   245: invokevirtual 420	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   248: astore 14
    //   250: goto -70 -> 180
    //   253: aload_1
    //   254: invokestatic 487	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   257: ifne +73 -> 330
    //   260: invokestatic 492	com/tencent/smtt/utils/q:a	()J
    //   263: lstore 9
    //   265: aload_1
    //   266: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   269: invokevirtual 495	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   272: lstore 11
    //   274: aload_1
    //   275: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   278: sipush -504
    //   281: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   284: aload_1
    //   285: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   288: sipush 210
    //   291: new 174	java/lang/StringBuilder
    //   294: dup
    //   295: ldc_w 796
    //   298: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   301: lload 9
    //   303: invokevirtual 500	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   306: ldc_w 502
    //   309: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: lload 11
    //   314: invokevirtual 500	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   317: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   323: ldc_w 762
    //   326: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: return
    //   330: aload_0
    //   331: aload_1
    //   332: invokevirtual 438	com/tencent/smtt/sdk/o:t	(Landroid/content/Context;)Z
    //   335: ifne +20 -> 355
    //   338: aload_1
    //   339: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   342: sipush -505
    //   345: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   348: ldc_w 762
    //   351: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: return
    //   355: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   358: invokeinterface 443 1 0
    //   363: istore 13
    //   365: ldc 149
    //   367: ldc_w 798
    //   370: iload 13
    //   372: invokestatic 205	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   375: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   378: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: iload 13
    //   383: ifeq +1878 -> 2261
    //   386: aload_1
    //   387: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   390: sipush -507
    //   393: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   396: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   399: invokevirtual 448	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   402: aload_1
    //   403: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   406: ldc_w 450
    //   409: invokevirtual 453	com/tencent/smtt/sdk/l:c	(Ljava/lang/String;)I
    //   412: istore 4
    //   414: aload_1
    //   415: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   418: invokevirtual 481	com/tencent/smtt/sdk/l:b	()I
    //   421: istore 5
    //   423: ldc 149
    //   425: ldc_w 800
    //   428: iload 4
    //   430: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   433: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   436: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: ldc 149
    //   441: ldc_w 802
    //   444: iload 5
    //   446: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   449: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   452: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: ldc 149
    //   457: ldc_w 804
    //   460: iload_3
    //   461: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   464: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   467: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: iload 5
    //   472: ifle +1877 -> 2349
    //   475: iload_3
    //   476: iload 5
    //   478: if_icmpgt +6 -> 484
    //   481: goto +1868 -> 2349
    //   484: aload_0
    //   485: aload_1
    //   486: invokevirtual 483	com/tencent/smtt/sdk/o:o	(Landroid/content/Context;)V
    //   489: aload_1
    //   490: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   493: invokevirtual 806	com/tencent/smtt/sdk/l:c	()I
    //   496: istore 5
    //   498: aload_0
    //   499: aload_1
    //   500: invokevirtual 474	com/tencent/smtt/sdk/o:i	(Landroid/content/Context;)I
    //   503: istore 6
    //   505: ldc 149
    //   507: ldc_w 808
    //   510: iload 5
    //   512: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   515: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   518: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: ldc 149
    //   523: ldc_w 810
    //   526: iload 6
    //   528: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   531: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   534: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   537: iload 5
    //   539: iflt +156 -> 695
    //   542: iload 5
    //   544: iconst_2
    //   545: if_icmpge +150 -> 695
    //   548: ldc 149
    //   550: ldc_w 812
    //   553: iconst_1
    //   554: invokestatic 296	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   557: iconst_1
    //   558: istore 4
    //   560: iload 5
    //   562: istore 6
    //   564: iload 4
    //   566: istore 5
    //   568: aload_1
    //   569: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   572: sipush -508
    //   575: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   578: ldc 149
    //   580: ldc_w 814
    //   583: iload 6
    //   585: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   588: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   591: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: iload 6
    //   596: ifgt +1156 -> 1752
    //   599: ldc 149
    //   601: ldc_w 816
    //   604: iconst_1
    //   605: invokestatic 296	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   608: aload_1
    //   609: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   612: sipush -509
    //   615: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   618: iload 5
    //   620: ifeq +157 -> 777
    //   623: aload_1
    //   624: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   627: ldc_w 818
    //   630: invokevirtual 453	com/tencent/smtt/sdk/l:c	(Ljava/lang/String;)I
    //   633: istore 4
    //   635: iload 4
    //   637: bipush 10
    //   639: if_icmple +127 -> 766
    //   642: aload_1
    //   643: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   646: sipush 201
    //   649: ldc_w 820
    //   652: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   655: aload_0
    //   656: aload_1
    //   657: invokespecial 822	com/tencent/smtt/sdk/o:E	(Landroid/content/Context;)V
    //   660: aload_1
    //   661: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   664: sipush -510
    //   667: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   670: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   673: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   676: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   679: invokeinterface 469 1 0
    //   684: aload_0
    //   685: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   688: ldc_w 762
    //   691: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   694: return
    //   695: iload 5
    //   697: istore 4
    //   699: iload 5
    //   701: iconst_3
    //   702: if_icmpne +46 -> 748
    //   705: iload 5
    //   707: istore 4
    //   709: iload 6
    //   711: iflt +37 -> 748
    //   714: iload_3
    //   715: iload 6
    //   717: if_icmpgt +14 -> 731
    //   720: iload 5
    //   722: istore 4
    //   724: iload_3
    //   725: ldc_w 681
    //   728: if_icmpne +20 -> 748
    //   731: iconst_m1
    //   732: istore 4
    //   734: aload_0
    //   735: aload_1
    //   736: invokevirtual 483	com/tencent/smtt/sdk/o:o	(Landroid/content/Context;)V
    //   739: ldc 149
    //   741: ldc_w 824
    //   744: iconst_1
    //   745: invokestatic 296	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   748: iconst_0
    //   749: istore 5
    //   751: iload 4
    //   753: istore 6
    //   755: goto -187 -> 568
    //   758: astore_1
    //   759: ldc_w 762
    //   762: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   765: return
    //   766: aload_1
    //   767: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   770: iload 4
    //   772: iconst_1
    //   773: iadd
    //   774: invokevirtual 826	com/tencent/smtt/sdk/l:b	(I)V
    //   777: aload_2
    //   778: ifnonnull +80 -> 858
    //   781: aload_1
    //   782: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   785: ldc_w 828
    //   788: invokevirtual 830	com/tencent/smtt/sdk/l:d	(Ljava/lang/String;)Ljava/lang/String;
    //   791: astore 15
    //   793: aload 15
    //   795: astore 14
    //   797: aload 15
    //   799: ifnonnull +62 -> 861
    //   802: aload_1
    //   803: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   806: sipush 202
    //   809: ldc_w 832
    //   812: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   815: aload_1
    //   816: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   819: sipush -511
    //   822: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   825: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   828: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   831: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   834: invokeinterface 469 1 0
    //   839: aload_0
    //   840: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   843: ldc_w 762
    //   846: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   849: return
    //   850: astore_1
    //   851: ldc_w 762
    //   854: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   857: return
    //   858: aload_2
    //   859: astore 14
    //   861: ldc 149
    //   863: ldc_w 834
    //   866: aload 14
    //   868: invokestatic 769	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   871: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   874: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   877: aload_0
    //   878: aload_1
    //   879: aload 14
    //   881: invokevirtual 837	com/tencent/smtt/sdk/o:c	(Landroid/content/Context;Ljava/lang/String;)I
    //   884: istore 8
    //   886: iload 8
    //   888: ifne +59 -> 947
    //   891: aload_1
    //   892: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   895: sipush -512
    //   898: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   901: aload_1
    //   902: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   905: sipush 203
    //   908: ldc_w 839
    //   911: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   914: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   917: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   920: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   923: invokeinterface 469 1 0
    //   928: aload_0
    //   929: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   932: ldc_w 762
    //   935: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   938: return
    //   939: astore_1
    //   940: ldc_w 762
    //   943: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   946: return
    //   947: aload_1
    //   948: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   951: ldc_w 828
    //   954: aload 14
    //   956: invokevirtual 841	com/tencent/smtt/sdk/l:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   959: aload_1
    //   960: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   963: iload 8
    //   965: iconst_0
    //   966: invokevirtual 266	com/tencent/smtt/sdk/l:c	(II)V
    //   969: aload_1
    //   970: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   973: sipush -548
    //   976: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   979: aload_1
    //   980: invokestatic 511	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   983: ifeq +70 -> 1053
    //   986: aload_0
    //   987: aload_1
    //   988: new 194	java/io/File
    //   991: dup
    //   992: aload 14
    //   994: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   997: iconst_1
    //   998: invokespecial 696	com/tencent/smtt/sdk/o:a	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1001: ifne +115 -> 1116
    //   1004: aload_1
    //   1005: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1008: sipush 207
    //   1011: ldc_w 843
    //   1014: getstatic 849	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_INSTALL_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   1017: invokevirtual 852	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;Lcom/tencent/smtt/sdk/TbsLogReport$EventType;)V
    //   1020: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1023: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1026: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   1029: invokeinterface 469 1 0
    //   1034: aload_0
    //   1035: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1038: ldc_w 762
    //   1041: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1044: return
    //   1045: astore_1
    //   1046: ldc_w 762
    //   1049: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1052: return
    //   1053: aload_0
    //   1054: aload_1
    //   1055: new 194	java/io/File
    //   1058: dup
    //   1059: aload 14
    //   1061: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   1064: invokespecial 854	com/tencent/smtt/sdk/o:a	(Landroid/content/Context;Ljava/io/File;)Z
    //   1067: ifne +49 -> 1116
    //   1070: aload_1
    //   1071: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1074: sipush 207
    //   1077: ldc_w 843
    //   1080: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1083: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1086: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1089: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   1092: invokeinterface 469 1 0
    //   1097: aload_0
    //   1098: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1101: ldc_w 762
    //   1104: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1107: return
    //   1108: astore_1
    //   1109: ldc_w 762
    //   1112: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1115: return
    //   1116: iload 5
    //   1118: ifeq +142 -> 1260
    //   1121: aload_1
    //   1122: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1125: ldc_w 856
    //   1128: invokevirtual 457	com/tencent/smtt/sdk/l:b	(Ljava/lang/String;)I
    //   1131: istore 4
    //   1133: iload 4
    //   1135: iconst_5
    //   1136: if_icmple +113 -> 1249
    //   1139: aload_1
    //   1140: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1143: sipush 223
    //   1146: ldc_w 858
    //   1149: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1152: aload_1
    //   1153: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1156: sipush -553
    //   1159: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1162: aload_0
    //   1163: aload_1
    //   1164: invokespecial 822	com/tencent/smtt/sdk/o:E	(Landroid/content/Context;)V
    //   1167: aload_1
    //   1168: invokestatic 860	com/tencent/smtt/sdk/k:c	(Landroid/content/Context;)V
    //   1171: aload_1
    //   1172: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1175: getfield 864	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1178: ldc_w 866
    //   1181: getstatic 872	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1184: invokeinterface 878 3 0
    //   1189: pop
    //   1190: aload_1
    //   1191: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1194: getfield 864	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1197: ldc_w 880
    //   1200: getstatic 872	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1203: invokeinterface 878 3 0
    //   1208: pop
    //   1209: aload_1
    //   1210: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1213: invokevirtual 882	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1216: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1219: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1222: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   1225: invokeinterface 469 1 0
    //   1230: aload_0
    //   1231: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1234: ldc_w 762
    //   1237: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1240: return
    //   1241: astore_1
    //   1242: ldc_w 762
    //   1245: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1248: return
    //   1249: aload_1
    //   1250: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1253: iload 4
    //   1255: iconst_1
    //   1256: iadd
    //   1257: invokevirtual 884	com/tencent/smtt/sdk/l:d	(I)V
    //   1260: ldc 149
    //   1262: ldc_w 886
    //   1265: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1268: invokestatic 889	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	()Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1271: getfield 893	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1274: ldc_w 895
    //   1277: iconst_0
    //   1278: invokeinterface 428 3 0
    //   1283: istore 4
    //   1285: aload_0
    //   1286: aload_1
    //   1287: invokevirtual 474	com/tencent/smtt/sdk/o:i	(Landroid/content/Context;)I
    //   1290: ifeq +357 -> 1647
    //   1293: aload_1
    //   1294: ldc_w 897
    //   1297: aconst_null
    //   1298: invokestatic 900	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1301: astore 14
    //   1303: aload 14
    //   1305: ifnull +1038 -> 2343
    //   1308: aload 14
    //   1310: instanceof 868
    //   1313: ifeq +1030 -> 2343
    //   1316: aload 14
    //   1318: checkcast 868	java/lang/Boolean
    //   1321: invokevirtual 903	java/lang/Boolean:booleanValue	()Z
    //   1324: istore 13
    //   1326: iload 13
    //   1328: ifeq +319 -> 1647
    //   1331: new 905	android/os/Bundle
    //   1334: dup
    //   1335: invokespecial 906	android/os/Bundle:<init>	()V
    //   1338: astore 14
    //   1340: aload 14
    //   1342: ldc_w 908
    //   1345: iload 4
    //   1347: invokevirtual 910	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1350: aload_1
    //   1351: invokestatic 511	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1354: ifeq +89 -> 1443
    //   1357: aload 14
    //   1359: ldc_w 912
    //   1362: aload_0
    //   1363: aload_1
    //   1364: invokevirtual 524	com/tencent/smtt/sdk/o:p	(Landroid/content/Context;)Ljava/io/File;
    //   1367: invokevirtual 915	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1370: invokevirtual 918	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1373: aload_1
    //   1374: ldc_w 920
    //   1377: aload 14
    //   1379: invokestatic 900	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1382: astore 14
    //   1384: aload 14
    //   1386: ifnonnull +121 -> 1507
    //   1389: ldc 149
    //   1391: ldc_w 922
    //   1394: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1397: aload_1
    //   1398: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1401: sipush 222
    //   1404: ldc_w 924
    //   1407: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1410: iconst_0
    //   1411: istore 4
    //   1413: iload 4
    //   1415: ifne +232 -> 1647
    //   1418: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1421: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1424: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   1427: invokeinterface 469 1 0
    //   1432: aload_0
    //   1433: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1436: ldc_w 762
    //   1439: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1442: return
    //   1443: aload 14
    //   1445: ldc_w 912
    //   1448: aload_0
    //   1449: aload_1
    //   1450: iconst_0
    //   1451: invokevirtual 172	com/tencent/smtt/sdk/o:f	(Landroid/content/Context;I)Ljava/io/File;
    //   1454: invokevirtual 915	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1457: invokevirtual 918	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1460: goto -87 -> 1373
    //   1463: astore_1
    //   1464: iconst_0
    //   1465: istore_3
    //   1466: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1469: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1472: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   1475: invokeinterface 469 1 0
    //   1480: aload_0
    //   1481: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1484: iload_3
    //   1485: ifeq +14 -> 1499
    //   1488: getstatic 460	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   1491: sipush 232
    //   1494: invokeinterface 465 2 0
    //   1499: ldc_w 762
    //   1502: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1505: aload_1
    //   1506: athrow
    //   1507: aload 14
    //   1509: instanceof 868
    //   1512: ifeq +55 -> 1567
    //   1515: aload 14
    //   1517: checkcast 868	java/lang/Boolean
    //   1520: invokevirtual 903	java/lang/Boolean:booleanValue	()Z
    //   1523: ifeq +17 -> 1540
    //   1526: ldc 149
    //   1528: ldc_w 926
    //   1531: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1534: iconst_1
    //   1535: istore 4
    //   1537: goto -124 -> 1413
    //   1540: ldc 149
    //   1542: ldc_w 928
    //   1545: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1548: aload_1
    //   1549: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1552: sipush 222
    //   1555: ldc_w 928
    //   1558: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1561: iconst_0
    //   1562: istore 4
    //   1564: goto -151 -> 1413
    //   1567: aload 14
    //   1569: instanceof 905
    //   1572: ifeq +9 -> 1581
    //   1575: iconst_1
    //   1576: istore 4
    //   1578: goto -165 -> 1413
    //   1581: aload 14
    //   1583: instanceof 281
    //   1586: ifeq +47 -> 1633
    //   1589: ldc 149
    //   1591: new 174	java/lang/StringBuilder
    //   1594: dup
    //   1595: ldc_w 930
    //   1598: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1601: aload 14
    //   1603: checkcast 281	java/lang/Throwable
    //   1606: invokestatic 661	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1609: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1615: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1618: aload_1
    //   1619: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1622: sipush 222
    //   1625: aload 14
    //   1627: checkcast 281	java/lang/Throwable
    //   1630: invokevirtual 737	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   1633: iconst_0
    //   1634: istore 4
    //   1636: goto -223 -> 1413
    //   1639: astore_1
    //   1640: ldc_w 762
    //   1643: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1646: return
    //   1647: ldc 149
    //   1649: ldc_w 932
    //   1652: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1655: aload_1
    //   1656: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1659: iload 8
    //   1661: iconst_1
    //   1662: invokevirtual 266	com/tencent/smtt/sdk/l:c	(II)V
    //   1665: iload 8
    //   1667: istore 4
    //   1669: iload 6
    //   1671: iconst_2
    //   1672: if_icmpge +553 -> 2225
    //   1675: iload 5
    //   1677: ifeq +207 -> 1884
    //   1680: aload_1
    //   1681: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1684: ldc_w 934
    //   1687: invokevirtual 453	com/tencent/smtt/sdk/l:c	(Ljava/lang/String;)I
    //   1690: istore 5
    //   1692: iload 5
    //   1694: bipush 10
    //   1696: if_icmple +177 -> 1873
    //   1699: aload_1
    //   1700: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1703: sipush 208
    //   1706: ldc_w 936
    //   1709: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1712: aload_1
    //   1713: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1716: sipush -514
    //   1719: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1722: aload_0
    //   1723: aload_1
    //   1724: invokespecial 822	com/tencent/smtt/sdk/o:E	(Landroid/content/Context;)V
    //   1727: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1730: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1733: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   1736: invokeinterface 469 1 0
    //   1741: aload_0
    //   1742: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1745: ldc_w 762
    //   1748: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1751: return
    //   1752: aload_1
    //   1753: invokestatic 511	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1756: ifeq +103 -> 1859
    //   1759: aload_2
    //   1760: ifnonnull +80 -> 1840
    //   1763: aload_1
    //   1764: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1767: ldc_w 828
    //   1770: invokevirtual 830	com/tencent/smtt/sdk/l:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1773: astore 15
    //   1775: aload 15
    //   1777: astore 14
    //   1779: aload 15
    //   1781: ifnonnull +62 -> 1843
    //   1784: aload_1
    //   1785: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1788: sipush 202
    //   1791: ldc_w 832
    //   1794: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1797: aload_1
    //   1798: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1801: sipush -511
    //   1804: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1807: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1810: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1813: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   1816: invokeinterface 469 1 0
    //   1821: aload_0
    //   1822: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1825: ldc_w 762
    //   1828: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1831: return
    //   1832: astore_1
    //   1833: ldc_w 762
    //   1836: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1839: return
    //   1840: aload_2
    //   1841: astore 14
    //   1843: aload_0
    //   1844: aload_1
    //   1845: new 194	java/io/File
    //   1848: dup
    //   1849: aload 14
    //   1851: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   1854: iconst_1
    //   1855: invokespecial 696	com/tencent/smtt/sdk/o:a	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1858: pop
    //   1859: iconst_0
    //   1860: istore 4
    //   1862: goto -193 -> 1669
    //   1865: astore_1
    //   1866: ldc_w 762
    //   1869: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1872: return
    //   1873: aload_1
    //   1874: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1877: iload 5
    //   1879: iconst_1
    //   1880: iadd
    //   1881: invokevirtual 938	com/tencent/smtt/sdk/l:a	(I)V
    //   1884: aload_1
    //   1885: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1888: sipush -549
    //   1891: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1894: aload_0
    //   1895: aload_1
    //   1896: iconst_0
    //   1897: invokespecial 941	com/tencent/smtt/sdk/o:j	(Landroid/content/Context;I)Z
    //   1900: ifne +46 -> 1946
    //   1903: aload_1
    //   1904: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1907: sipush -515
    //   1910: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1913: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1916: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1919: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   1922: invokeinterface 469 1 0
    //   1927: aload_0
    //   1928: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1931: ldc_w 762
    //   1934: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1937: return
    //   1938: astore_1
    //   1939: ldc_w 762
    //   1942: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1945: return
    //   1946: aload_1
    //   1947: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1950: iload 4
    //   1952: iconst_2
    //   1953: invokevirtual 266	com/tencent/smtt/sdk/l:c	(II)V
    //   1956: ldc 149
    //   1958: ldc_w 943
    //   1961: iconst_1
    //   1962: invokestatic 296	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1965: ldc 149
    //   1967: ldc_w 945
    //   1970: iload_3
    //   1971: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1974: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1977: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1980: aload_1
    //   1981: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1984: sipush -516
    //   1987: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1990: getstatic 414	android/os/Build$VERSION:SDK_INT	I
    //   1993: bipush 11
    //   1995: if_icmplt +155 -> 2150
    //   1998: aload_1
    //   1999: ldc_w 416
    //   2002: iconst_4
    //   2003: invokevirtual 420	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2006: astore 14
    //   2008: aload 14
    //   2010: invokeinterface 632 1 0
    //   2015: astore 14
    //   2017: aload 14
    //   2019: ldc_w 634
    //   2022: iconst_0
    //   2023: invokeinterface 640 3 0
    //   2028: pop
    //   2029: aload 14
    //   2031: ldc_w 642
    //   2034: iconst_0
    //   2035: invokeinterface 640 3 0
    //   2040: pop
    //   2041: aload 14
    //   2043: ldc_w 644
    //   2046: iload_3
    //   2047: invokeinterface 640 3 0
    //   2052: pop
    //   2053: aload 14
    //   2055: invokeinterface 647 1 0
    //   2060: pop
    //   2061: aload_1
    //   2062: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2065: sipush -517
    //   2068: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2071: iload_3
    //   2072: ldc_w 681
    //   2075: if_icmpne +10 -> 2085
    //   2078: aload_0
    //   2079: iload_3
    //   2080: aload_2
    //   2081: aload_1
    //   2082: invokespecial 947	com/tencent/smtt/sdk/o:a	(ILjava/lang/String;Landroid/content/Context;)V
    //   2085: aload_0
    //   2086: getfield 132	com/tencent/smtt/sdk/o:k	Z
    //   2089: ifeq +115 -> 2204
    //   2092: aload_1
    //   2093: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2096: aload_0
    //   2097: aload_1
    //   2098: invokespecial 950	com/tencent/smtt/sdk/o:u	(Landroid/content/Context;)I
    //   2101: ldc_w 626
    //   2104: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2107: iload 7
    //   2109: istore_3
    //   2110: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2113: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2116: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   2119: invokeinterface 469 1 0
    //   2124: aload_0
    //   2125: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   2128: iload_3
    //   2129: ifeq +125 -> 2254
    //   2132: getstatic 460	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   2135: sipush 232
    //   2138: invokeinterface 465 2 0
    //   2143: ldc_w 762
    //   2146: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2149: return
    //   2150: aload_1
    //   2151: ldc_w 416
    //   2154: iconst_0
    //   2155: invokevirtual 420	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2158: astore 14
    //   2160: goto -152 -> 2008
    //   2163: astore 14
    //   2165: ldc 149
    //   2167: new 174	java/lang/StringBuilder
    //   2170: dup
    //   2171: ldc_w 952
    //   2174: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2177: aload 14
    //   2179: invokestatic 661	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2182: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2185: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2188: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2191: aload_1
    //   2192: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2195: sipush -518
    //   2198: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2201: goto -130 -> 2071
    //   2204: aload_1
    //   2205: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2208: aload_0
    //   2209: aload_1
    //   2210: invokespecial 950	com/tencent/smtt/sdk/o:u	(Landroid/content/Context;)I
    //   2213: ldc_w 653
    //   2216: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2219: iload 7
    //   2221: istore_3
    //   2222: goto -112 -> 2110
    //   2225: iload 6
    //   2227: iconst_2
    //   2228: if_icmpne +110 -> 2338
    //   2231: getstatic 460	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   2234: sipush 200
    //   2237: invokeinterface 465 2 0
    //   2242: iload 7
    //   2244: istore_3
    //   2245: goto -135 -> 2110
    //   2248: astore_1
    //   2249: iconst_1
    //   2250: istore_3
    //   2251: goto -785 -> 1466
    //   2254: ldc_w 762
    //   2257: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2260: return
    //   2261: aload_1
    //   2262: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2265: sipush -519
    //   2268: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2271: aload_0
    //   2272: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   2275: ldc_w 762
    //   2278: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2281: return
    //   2282: astore_1
    //   2283: goto -155 -> 2128
    //   2286: astore_2
    //   2287: goto -803 -> 1484
    //   2290: astore_2
    //   2291: goto -811 -> 1480
    //   2294: astore_1
    //   2295: goto -171 -> 2124
    //   2298: astore_1
    //   2299: goto -372 -> 1927
    //   2302: astore_1
    //   2303: goto -562 -> 1741
    //   2306: astore_1
    //   2307: goto -486 -> 1821
    //   2310: astore_1
    //   2311: goto -879 -> 1432
    //   2314: astore_1
    //   2315: goto -1085 -> 1230
    //   2318: astore_1
    //   2319: goto -1222 -> 1097
    //   2322: astore_1
    //   2323: goto -1289 -> 1034
    //   2326: astore_1
    //   2327: goto -1399 -> 928
    //   2330: astore_1
    //   2331: goto -1492 -> 839
    //   2334: astore_1
    //   2335: goto -1651 -> 684
    //   2338: iconst_0
    //   2339: istore_3
    //   2340: goto -230 -> 2110
    //   2343: iconst_0
    //   2344: istore 13
    //   2346: goto -1020 -> 1326
    //   2349: iload 4
    //   2351: ifle -1862 -> 489
    //   2354: iload_3
    //   2355: iload 4
    //   2357: if_icmple -1868 -> 489
    //   2360: goto -1876 -> 484
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2363	0	this	o
    //   0	2363	1	paramContext	Context
    //   0	2363	2	paramString	String
    //   0	2363	3	paramInt	int
    //   412	1946	4	i1	int
    //   421	1460	5	i2	int
    //   503	1726	6	i3	int
    //   1	2242	7	i4	int
    //   884	782	8	i5	int
    //   263	39	9	l1	long
    //   272	41	11	l2	long
    //   363	1982	13	bool	boolean
    //   178	1981	14	localObject	Object
    //   2163	15	14	localThrowable	Throwable
    //   791	989	15	str	String
    // Exception table:
    //   from	to	target	type
    //   684	688	758	java/lang/Exception
    //   839	843	850	java/lang/Exception
    //   928	932	939	java/lang/Exception
    //   1034	1038	1045	java/lang/Exception
    //   1097	1101	1108	java/lang/Exception
    //   1230	1234	1241	java/lang/Exception
    //   402	470	1463	finally
    //   484	489	1463	finally
    //   489	537	1463	finally
    //   548	557	1463	finally
    //   568	594	1463	finally
    //   599	618	1463	finally
    //   623	635	1463	finally
    //   642	670	1463	finally
    //   734	748	1463	finally
    //   766	777	1463	finally
    //   781	793	1463	finally
    //   802	825	1463	finally
    //   861	886	1463	finally
    //   891	914	1463	finally
    //   947	1020	1463	finally
    //   1053	1083	1463	finally
    //   1121	1133	1463	finally
    //   1139	1216	1463	finally
    //   1249	1260	1463	finally
    //   1260	1303	1463	finally
    //   1308	1326	1463	finally
    //   1331	1373	1463	finally
    //   1373	1384	1463	finally
    //   1389	1410	1463	finally
    //   1443	1460	1463	finally
    //   1507	1534	1463	finally
    //   1540	1561	1463	finally
    //   1567	1575	1463	finally
    //   1581	1633	1463	finally
    //   1647	1665	1463	finally
    //   1680	1692	1463	finally
    //   1699	1727	1463	finally
    //   1752	1759	1463	finally
    //   1763	1775	1463	finally
    //   1784	1807	1463	finally
    //   1843	1859	1463	finally
    //   1873	1884	1463	finally
    //   1884	1913	1463	finally
    //   1946	2008	1463	finally
    //   2008	2071	1463	finally
    //   2078	2085	1463	finally
    //   2085	2107	1463	finally
    //   2150	2160	1463	finally
    //   2165	2201	1463	finally
    //   2204	2219	1463	finally
    //   1432	1436	1639	java/lang/Exception
    //   1821	1825	1832	java/lang/Exception
    //   1741	1745	1865	java/lang/Exception
    //   1927	1931	1938	java/lang/Exception
    //   2008	2071	2163	java/lang/Throwable
    //   2231	2242	2248	finally
    //   2124	2128	2282	java/lang/Exception
    //   1480	1484	2286	java/lang/Exception
    //   1466	1480	2290	java/lang/Exception
    //   2110	2124	2294	java/lang/Exception
    //   1913	1927	2298	java/lang/Exception
    //   1727	1741	2302	java/lang/Exception
    //   1807	1821	2306	java/lang/Exception
    //   1418	1432	2310	java/lang/Exception
    //   1216	1230	2314	java/lang/Exception
    //   1083	1097	2318	java/lang/Exception
    //   1020	1034	2322	java/lang/Exception
    //   914	928	2326	java/lang/Exception
    //   825	839	2330	java/lang/Exception
    //   670	684	2334	java/lang/Exception
  }
  
  /* Error */
  private boolean b(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: ldc_w 953
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: new 16	com/tencent/smtt/sdk/o$6
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 956	com/tencent/smtt/sdk/o$6:<init>	(Lcom/tencent/smtt/sdk/o;)V
    //   15: invokevirtual 959	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   18: astore 6
    //   20: aload 6
    //   22: arraylength
    //   23: istore 4
    //   25: getstatic 414	android/os/Build$VERSION:SDK_INT	I
    //   28: bipush 16
    //   30: if_icmpge +33 -> 63
    //   33: aload_1
    //   34: invokevirtual 962	android/content/Context:getPackageName	()Ljava/lang/String;
    //   37: ifnull +26 -> 63
    //   40: aload_1
    //   41: invokevirtual 962	android/content/Context:getPackageName	()Ljava/lang/String;
    //   44: ldc_w 964
    //   47: invokevirtual 967	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   50: istore 5
    //   52: iload 5
    //   54: ifeq +9 -> 63
    //   57: ldc2_w 968
    //   60: invokestatic 973	java/lang/Thread:sleep	(J)V
    //   63: aload_1
    //   64: invokevirtual 977	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   67: astore 7
    //   69: iconst_0
    //   70: istore_3
    //   71: iload_3
    //   72: iload 4
    //   74: if_icmpge +60 -> 134
    //   77: ldc 149
    //   79: new 174	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 979
    //   86: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: aload 6
    //   91: iload_3
    //   92: aaload
    //   93: invokevirtual 915	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   96: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: new 981	dalvik/system/DexClassLoader
    //   108: dup
    //   109: aload 6
    //   111: iload_3
    //   112: aaload
    //   113: invokevirtual 915	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   116: aload_2
    //   117: invokevirtual 915	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   120: aconst_null
    //   121: aload 7
    //   123: invokespecial 984	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   126: pop
    //   127: iload_3
    //   128: iconst_1
    //   129: iadd
    //   130: istore_3
    //   131: goto -60 -> 71
    //   134: ldc_w 953
    //   137: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: iconst_1
    //   141: ireturn
    //   142: astore_2
    //   143: aload_1
    //   144: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   147: sipush 209
    //   150: aload_2
    //   151: invokevirtual 583	java/lang/Exception:toString	()Ljava/lang/String;
    //   154: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   157: ldc 149
    //   159: ldc_w 986
    //   162: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: ldc_w 953
    //   168: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: iconst_0
    //   172: ireturn
    //   173: astore 7
    //   175: goto -112 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	o
    //   0	178	1	paramContext	Context
    //   0	178	2	paramFile	File
    //   70	61	3	i1	int
    //   23	52	4	i2	int
    //   50	3	5	bool	boolean
    //   18	92	6	arrayOfFile	File[]
    //   67	55	7	localClassLoader	ClassLoader
    //   173	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   6	52	142	java/lang/Exception
    //   63	69	142	java/lang/Exception
    //   77	127	142	java/lang/Exception
    //   57	63	173	java/lang/Exception
  }
  
  private int c(Context paramContext, Bundle paramBundle)
  {
    i1 = 0;
    AppMethodBeat.i(55239);
    for (;;)
    {
      try
      {
        Object localObject = QbSdk.a(paramContext, paramBundle);
        TbsLog.i("TbsInstaller", "tpatch finished,ret is".concat(String.valueOf(localObject)));
        i2 = ((Bundle)localObject).getInt("patch_result");
        if (i2 != 0) {
          continue;
        }
        localObject = paramBundle.getString("new_apk_location");
        i2 = paramBundle.getInt("new_core_ver");
        int i3 = a(new File((String)localObject));
        if (i2 != i3)
        {
          TbsLog.i("TbsInstaller", "version not equals!!!" + i2 + "patchVersion:" + i3);
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(240, "version=" + i2 + ",patchVersion=" + i3);
          AppMethodBeat.o(55239);
          return 1;
        }
        paramBundle = new File(paramBundle.getString("backup_apk"));
        localObject = b.a(paramContext, true, paramBundle);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(localObject))
        {
          TbsLog.i("TbsInstaller", "tpatch sig not equals!!!" + paramBundle + "signature:" + (String)localObject);
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(241, "version=" + i2 + ",patchVersion=" + i3);
          f.b(paramBundle);
          AppMethodBeat.o(55239);
          return 0;
        }
        if (!TbsDownloader.a(paramContext)) {
          continue;
        }
        TbsLog.i("TbsInstaller", "Tpatch decouple success!");
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(237, "");
      }
      catch (Exception paramBundle)
      {
        int i2;
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(239, "patch exception" + Log.getStackTraceString(paramBundle));
        i1 = 1;
        continue;
        paramBundle = paramBundle.getString("new_apk_location");
        if (TextUtils.isEmpty(paramBundle)) {
          continue;
        }
        f.b(new File(paramBundle));
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(i2, "tpatch fail,patch error_code=".concat(String.valueOf(i2)));
        i1 = 1;
        continue;
      }
      AppMethodBeat.o(55239);
      return i1;
      TbsLog.i("TbsInstaller", "Tpatch success!");
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(236, "");
    }
  }
  
  private boolean c(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(55289);
    try
    {
      Object localObject1 = new File(paramFile, "tbs_sdk_extension_dex.jar");
      Object localObject2 = new File(paramFile, "tbs_sdk_extension_dex.dex");
      Object localObject3 = paramContext.getClassLoader();
      new DexClassLoader(((File)localObject1).getAbsolutePath(), paramFile.getAbsolutePath(), null, (ClassLoader)localObject3);
      localObject1 = d.a(paramContext, ((File)localObject2).getAbsolutePath());
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, "can not find oat command");
        AppMethodBeat.o(55289);
        return false;
      }
      paramFile = paramFile.listFiles(new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          AppMethodBeat.i(54990);
          boolean bool = paramAnonymousFile.getName().endsWith(".jar");
          AppMethodBeat.o(54990);
          return bool;
        }
      });
      int i2 = paramFile.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localObject2 = paramFile[i1];
        localObject2 = ((File)localObject2).getName().substring(0, ((File)localObject2).getName().length() - 4);
        localObject3 = ((String)localObject1).replaceAll("tbs_sdk_extension_dex", (String)localObject2);
        localObject2 = "/system/bin/dex2oat " + (String)localObject3 + " --dex-location=" + a().q(paramContext) + File.separator + (String)localObject2 + ".jar";
        Runtime.getRuntime().exec((String)localObject2).waitFor();
        i1 += 1;
      }
      AppMethodBeat.o(55289);
      return true;
    }
    catch (Exception paramFile)
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, paramFile);
      AppMethodBeat.o(55289);
    }
    return false;
  }
  
  /* Error */
  private boolean c(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 5
    //   6: aload_0
    //   7: monitorenter
    //   8: ldc_w 1095
    //   11: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: ldc 149
    //   16: ldc_w 1097
    //   19: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 438	com/tencent/smtt/sdk/o:t	(Landroid/content/Context;)Z
    //   27: istore 7
    //   29: iload 7
    //   31: ifne +16 -> 47
    //   34: ldc_w 1095
    //   37: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iload 6
    //   42: istore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_2
    //   46: ireturn
    //   47: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   50: invokevirtual 1098	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   53: istore 6
    //   55: ldc 149
    //   57: ldc_w 1100
    //   60: iload 6
    //   62: invokestatic 205	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   65: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iload 6
    //   73: ifeq +212 -> 285
    //   76: aload_1
    //   77: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   80: ldc_w 1102
    //   83: invokevirtual 457	com/tencent/smtt/sdk/l:b	(Ljava/lang/String;)I
    //   86: istore_3
    //   87: aload_0
    //   88: iconst_0
    //   89: aload_1
    //   90: invokevirtual 1105	com/tencent/smtt/sdk/o:a	(ZLandroid/content/Context;)I
    //   93: istore 4
    //   95: ldc 149
    //   97: ldc_w 1107
    //   100: iload_3
    //   101: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   104: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: ldc 149
    //   112: ldc_w 1109
    //   115: iload 4
    //   117: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   120: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   123: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: iload_3
    //   127: iconst_1
    //   128: if_icmpne +152 -> 280
    //   131: iload 4
    //   133: ifne +50 -> 183
    //   136: ldc 149
    //   138: ldc_w 1111
    //   141: iconst_1
    //   142: invokestatic 296	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   145: aload_0
    //   146: aload_1
    //   147: invokespecial 1114	com/tencent/smtt/sdk/o:y	(Landroid/content/Context;)V
    //   150: iload 5
    //   152: istore_2
    //   153: iload_2
    //   154: istore 5
    //   156: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   159: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   162: iload_2
    //   163: istore 5
    //   165: aload_0
    //   166: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   169: ldc_w 1095
    //   172: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: goto -132 -> 43
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    //   183: iload_2
    //   184: ifeq +96 -> 280
    //   187: ldc 149
    //   189: ldc_w 1116
    //   192: iconst_1
    //   193: invokestatic 296	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   196: aload_0
    //   197: aload_1
    //   198: invokespecial 1114	com/tencent/smtt/sdk/o:y	(Landroid/content/Context;)V
    //   201: iload 5
    //   203: istore_2
    //   204: goto -51 -> 153
    //   207: astore 8
    //   209: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   212: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   215: ldc_w 1095
    //   218: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload 8
    //   223: athrow
    //   224: astore 8
    //   226: iconst_0
    //   227: istore 5
    //   229: aload_1
    //   230: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   233: sipush 215
    //   236: aload 8
    //   238: invokevirtual 1117	java/lang/Throwable:toString	()Ljava/lang/String;
    //   241: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   244: aload_1
    //   245: new 174	java/lang/StringBuilder
    //   248: dup
    //   249: ldc_w 1119
    //   252: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   255: aload 8
    //   257: invokestatic 661	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   260: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 275	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   269: iload 5
    //   271: istore_2
    //   272: goto -103 -> 169
    //   275: astore 8
    //   277: goto -48 -> 229
    //   280: iconst_0
    //   281: istore_2
    //   282: goto -129 -> 153
    //   285: iconst_0
    //   286: istore_2
    //   287: goto -125 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	o
    //   0	290	1	paramContext	Context
    //   0	290	2	paramBoolean	boolean
    //   86	43	3	i1	int
    //   93	39	4	i2	int
    //   4	266	5	bool1	boolean
    //   1	71	6	bool2	boolean
    //   27	3	7	bool3	boolean
    //   207	15	8	localObject	Object
    //   224	32	8	localThrowable1	Throwable
    //   275	1	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	22	178	finally
    //   22	29	178	finally
    //   34	40	178	finally
    //   47	71	178	finally
    //   156	162	178	finally
    //   165	169	178	finally
    //   169	175	178	finally
    //   209	224	178	finally
    //   229	269	178	finally
    //   76	126	207	finally
    //   136	150	207	finally
    //   187	201	207	finally
    //   22	29	224	java/lang/Throwable
    //   47	71	224	java/lang/Throwable
    //   209	224	224	java/lang/Throwable
    //   156	162	275	java/lang/Throwable
    //   165	169	275	java/lang/Throwable
  }
  
  /* Error */
  private boolean d(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 5
    //   6: aload_0
    //   7: monitorenter
    //   8: ldc_w 1120
    //   11: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: ldc 149
    //   16: ldc_w 1122
    //   19: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 438	com/tencent/smtt/sdk/o:t	(Landroid/content/Context;)Z
    //   27: istore 7
    //   29: iload 7
    //   31: ifne +16 -> 47
    //   34: ldc_w 1120
    //   37: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iload 6
    //   42: istore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_2
    //   46: ireturn
    //   47: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   50: invokevirtual 1098	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   53: istore 6
    //   55: ldc 149
    //   57: ldc_w 1124
    //   60: iload 6
    //   62: invokestatic 205	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   65: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iload 6
    //   73: ifeq +221 -> 294
    //   76: aload_1
    //   77: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   80: ldc_w 455
    //   83: invokevirtual 457	com/tencent/smtt/sdk/l:b	(Ljava/lang/String;)I
    //   86: istore_3
    //   87: aload_0
    //   88: iconst_0
    //   89: aload_1
    //   90: invokevirtual 1105	com/tencent/smtt/sdk/o:a	(ZLandroid/content/Context;)I
    //   93: istore 4
    //   95: ldc 149
    //   97: ldc_w 1126
    //   100: iload_3
    //   101: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   104: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: ldc 149
    //   112: ldc_w 1128
    //   115: iload 4
    //   117: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   120: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   123: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: iload_3
    //   127: iconst_1
    //   128: if_icmpne +161 -> 289
    //   131: iload 4
    //   133: ifne +50 -> 183
    //   136: ldc 149
    //   138: ldc_w 1130
    //   141: iconst_1
    //   142: invokestatic 296	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   145: aload_0
    //   146: aload_1
    //   147: invokespecial 1133	com/tencent/smtt/sdk/o:z	(Landroid/content/Context;)V
    //   150: iload 5
    //   152: istore_2
    //   153: iload_2
    //   154: istore 5
    //   156: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   159: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   162: iload_2
    //   163: istore 5
    //   165: aload_0
    //   166: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   169: ldc_w 1120
    //   172: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: goto -132 -> 43
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    //   183: iload_2
    //   184: ifeq +105 -> 289
    //   187: ldc 149
    //   189: ldc_w 1135
    //   192: iconst_1
    //   193: invokestatic 296	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   196: aload_0
    //   197: aload_1
    //   198: invokespecial 1133	com/tencent/smtt/sdk/o:z	(Landroid/content/Context;)V
    //   201: iload 5
    //   203: istore_2
    //   204: goto -51 -> 153
    //   207: astore 8
    //   209: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   212: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   215: ldc_w 1120
    //   218: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload 8
    //   223: athrow
    //   224: astore 8
    //   226: iconst_0
    //   227: istore 5
    //   229: aload_1
    //   230: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   233: sipush 215
    //   236: aload 8
    //   238: invokevirtual 1117	java/lang/Throwable:toString	()Ljava/lang/String;
    //   241: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   244: aload_1
    //   245: new 174	java/lang/StringBuilder
    //   248: dup
    //   249: ldc_w 1137
    //   252: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   255: aload 8
    //   257: invokestatic 661	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   260: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 275	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   269: iload 5
    //   271: istore_2
    //   272: goto -103 -> 169
    //   275: astore_1
    //   276: ldc_w 1120
    //   279: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: aload_1
    //   283: athrow
    //   284: astore 8
    //   286: goto -57 -> 229
    //   289: iconst_0
    //   290: istore_2
    //   291: goto -138 -> 153
    //   294: iconst_0
    //   295: istore_2
    //   296: goto -134 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	o
    //   0	299	1	paramContext	Context
    //   0	299	2	paramBoolean	boolean
    //   86	43	3	i1	int
    //   93	39	4	i2	int
    //   4	266	5	bool1	boolean
    //   1	71	6	bool2	boolean
    //   27	3	7	bool3	boolean
    //   207	15	8	localObject	Object
    //   224	32	8	localThrowable1	Throwable
    //   284	1	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	22	178	finally
    //   34	40	178	finally
    //   169	175	178	finally
    //   276	284	178	finally
    //   76	126	207	finally
    //   136	150	207	finally
    //   187	201	207	finally
    //   22	29	224	java/lang/Throwable
    //   47	71	224	java/lang/Throwable
    //   209	224	224	java/lang/Throwable
    //   22	29	275	finally
    //   47	71	275	finally
    //   156	162	275	finally
    //   165	169	275	finally
    //   209	224	275	finally
    //   229	269	275	finally
    //   156	162	284	java/lang/Throwable
    //   165	169	284	java/lang/Throwable
  }
  
  private boolean e(Context paramContext, String paramString)
  {
    AppMethodBeat.i(55242);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null)
      {
        AppMethodBeat.o(55242);
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
      AppMethodBeat.o(55242);
    }
    return false;
  }
  
  /* Error */
  private boolean e(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: ldc_w 1151
    //   11: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_1
    //   15: ifnull +33 -> 48
    //   18: ldc 211
    //   20: aload_1
    //   21: invokevirtual 217	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   24: invokevirtual 221	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   27: getfield 227	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   30: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +15 -> 48
    //   36: aload_1
    //   37: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   40: sipush 229
    //   43: ldc 239
    //   45: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   48: ldc 149
    //   50: ldc_w 1153
    //   53: iload_2
    //   54: invokestatic 205	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   57: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   60: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: ldc 149
    //   65: ldc_w 1155
    //   68: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: aload_1
    //   73: invokevirtual 438	com/tencent/smtt/sdk/o:t	(Landroid/content/Context;)Z
    //   76: istore 7
    //   78: iload 7
    //   80: ifne +16 -> 96
    //   83: ldc_w 1151
    //   86: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: iload 6
    //   91: istore_2
    //   92: aload_0
    //   93: monitorexit
    //   94: iload_2
    //   95: ireturn
    //   96: ldc 149
    //   98: ldc_w 1157
    //   101: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   107: invokevirtual 1098	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   110: istore 6
    //   112: ldc 149
    //   114: ldc_w 1159
    //   117: iload 6
    //   119: invokestatic 205	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   122: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   125: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: iload 6
    //   130: ifeq +176 -> 306
    //   133: aload_1
    //   134: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   137: invokevirtual 806	com/tencent/smtt/sdk/l:c	()I
    //   140: istore_3
    //   141: ldc 149
    //   143: ldc_w 1161
    //   146: iload_3
    //   147: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   150: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   153: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload_0
    //   157: iconst_0
    //   158: aload_1
    //   159: invokevirtual 1105	com/tencent/smtt/sdk/o:a	(ZLandroid/content/Context;)I
    //   162: istore 4
    //   164: iload_3
    //   165: iconst_2
    //   166: if_icmpne +135 -> 301
    //   169: ldc 149
    //   171: ldc_w 1163
    //   174: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: iload 4
    //   179: ifne +50 -> 229
    //   182: ldc 149
    //   184: ldc_w 1165
    //   187: iconst_0
    //   188: invokestatic 296	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   191: aload_0
    //   192: aload_1
    //   193: invokespecial 1168	com/tencent/smtt/sdk/o:x	(Landroid/content/Context;)V
    //   196: iload 5
    //   198: istore_2
    //   199: iload_2
    //   200: istore 5
    //   202: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   205: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   208: iload_2
    //   209: istore 5
    //   211: aload_0
    //   212: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   215: ldc_w 1151
    //   218: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: goto -129 -> 92
    //   224: astore_1
    //   225: aload_0
    //   226: monitorexit
    //   227: aload_1
    //   228: athrow
    //   229: iload_2
    //   230: ifeq +71 -> 301
    //   233: ldc 149
    //   235: ldc_w 1170
    //   238: iconst_0
    //   239: invokestatic 296	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   242: aload_0
    //   243: aload_1
    //   244: invokespecial 1168	com/tencent/smtt/sdk/o:x	(Landroid/content/Context;)V
    //   247: iload 5
    //   249: istore_2
    //   250: goto -51 -> 199
    //   253: astore 8
    //   255: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   258: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   261: ldc_w 1151
    //   264: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: aload 8
    //   269: athrow
    //   270: astore 8
    //   272: iconst_0
    //   273: istore 5
    //   275: aload_1
    //   276: ldc_w 1172
    //   279: aload 8
    //   281: invokestatic 769	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   284: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   287: invokestatic 275	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   290: iload 5
    //   292: istore_2
    //   293: goto -78 -> 215
    //   296: astore 8
    //   298: goto -23 -> 275
    //   301: iconst_0
    //   302: istore_2
    //   303: goto -104 -> 199
    //   306: iconst_0
    //   307: istore_2
    //   308: goto -100 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	o
    //   0	311	1	paramContext	Context
    //   0	311	2	paramBoolean	boolean
    //   140	27	3	i1	int
    //   162	16	4	i2	int
    //   1	290	5	bool1	boolean
    //   4	125	6	bool2	boolean
    //   76	3	7	bool3	boolean
    //   253	15	8	localObject	Object
    //   270	10	8	localException1	Exception
    //   296	1	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	14	224	finally
    //   18	48	224	finally
    //   48	71	224	finally
    //   71	78	224	finally
    //   83	89	224	finally
    //   96	128	224	finally
    //   202	208	224	finally
    //   211	215	224	finally
    //   215	221	224	finally
    //   255	270	224	finally
    //   275	290	224	finally
    //   133	164	253	finally
    //   169	177	253	finally
    //   182	196	253	finally
    //   233	247	253	finally
    //   71	78	270	java/lang/Exception
    //   96	128	270	java/lang/Exception
    //   255	270	270	java/lang/Exception
    //   202	208	296	java/lang/Exception
    //   211	215	296	java/lang/Exception
  }
  
  private boolean f(Context paramContext, boolean paramBoolean)
  {
    return false;
  }
  
  private void g(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(55231);
    if (paramContext == null)
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(225, "setTmpFolderCoreToRead context is null");
      AppMethodBeat.o(55231);
      return;
    }
    try
    {
      File localFile = new File(QbSdk.getTbsFolderDir(paramContext), "tmp_folder_core_to_read.conf");
      if (paramBoolean)
      {
        if (localFile.exists()) {
          break label123;
        }
        localFile.createNewFile();
        AppMethodBeat.o(55231);
        return;
      }
    }
    catch (Exception localException)
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(225, "setTmpFolderCoreToRead Exception message is " + localException.getMessage() + " Exception cause is " + localException.getCause());
      AppMethodBeat.o(55231);
      return;
    }
    f.b(localException);
    label123:
    AppMethodBeat.o(55231);
  }
  
  private void h(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55238);
    TbsLog.i("TbsInstaller", "proceedTpatchStatus,result=".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      QbSdk.setTBSInstallingStatus(false);
      AppMethodBeat.o(55238);
      return;
      if (TbsDownloader.a(paramContext))
      {
        i(paramContext, 6);
      }
      else
      {
        g(paramContext, true);
        paramInt = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version", 0);
        l.a(paramContext).b(paramInt, 1);
      }
    }
  }
  
  private void i(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55249);
    File localFile1 = a().f(paramContext, paramInt);
    a().g(paramContext, true);
    File localFile2 = p(paramContext);
    f.a(localFile2, true);
    localFile1.renameTo(localFile2);
    TbsShareManager.b(paramContext);
    AppMethodBeat.o(55249);
  }
  
  private boolean j(Context paramContext, int paramInt)
  {
    int i3 = 0;
    AppMethodBeat.i(55250);
    TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt start - dirMode: ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    try
    {
      TbsLog.e("TbsInstaller", "doDexoptOrDexoat mode error: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(55250);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        File localFile;
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(209, localException.toString());
        continue;
        paramInt = 0;
        continue;
        int i1 = 0;
      }
    }
    bool = TbsDownloader.a(paramContext);
    if (bool)
    {
      AppMethodBeat.o(55250);
      return true;
    }
    localFile = f(paramContext, 0);
    for (;;)
    {
      try
      {
        String str = System.getProperty("java.vm.version");
        if (str == null) {
          break label333;
        }
        bool = str.startsWith("2");
        if (!bool) {
          break label333;
        }
        paramInt = 1;
      }
      catch (Throwable localThrowable)
      {
        int i2;
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, localThrowable);
        paramInt = 0;
        continue;
        if (paramInt == 0) {
          continue;
        }
        TbsLog.i("TbsInstaller", "doTbsDexOpt -- is ART mode, skip!");
        TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
        AppMethodBeat.o(55250);
        return true;
        TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
        bool = b(paramContext, localFile);
        AppMethodBeat.o(55250);
        return bool;
      }
      if (Build.VERSION.SDK_INT != 23) {
        break label338;
      }
      i1 = 1;
      bool = TbsDownloadConfig.getInstance(paramContext).mPreferences.getBoolean("tbs_stop_preoat", false);
      i2 = i3;
      if (paramInt != 0)
      {
        i2 = i3;
        if (i1 != 0)
        {
          i2 = i3;
          if (!bool) {
            i2 = 1;
          }
        }
      }
      if ((i2 == 0) || (!c(paramContext, localFile))) {
        continue;
      }
      TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoatForArtVm");
      AppMethodBeat.o(55250);
      return true;
      localFile = f(paramContext, 1);
      continue;
      localFile = q(paramContext);
    }
  }
  
  static File s(Context paramContext)
  {
    AppMethodBeat.i(55282);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_private");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(55282);
      return null;
    }
    AppMethodBeat.o(55282);
    return paramContext;
  }
  
  private int u(Context paramContext)
  {
    int i1 = 1;
    AppMethodBeat.i(55226);
    if (l.a(paramContext).d() == 1) {}
    boolean bool;
    for (;;)
    {
      bool = TbsDownloader.a(paramContext);
      if (i1 == 0) {
        break label57;
      }
      if (!bool) {
        break;
      }
      AppMethodBeat.o(55226);
      return 234;
      i1 = 0;
    }
    AppMethodBeat.o(55226);
    return 221;
    label57:
    if (bool)
    {
      AppMethodBeat.o(55226);
      return 233;
    }
    AppMethodBeat.o(55226);
    return 200;
  }
  
  private static boolean v(Context paramContext)
  {
    AppMethodBeat.i(55230);
    if (paramContext == null)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #1");
      AppMethodBeat.o(55230);
      return true;
    }
    try
    {
      if (new File(QbSdk.getTbsFolderDir(paramContext), "tmp_folder_core_to_read.conf").exists())
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #2");
        AppMethodBeat.o(55230);
        return true;
      }
      TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #3");
      AppMethodBeat.o(55230);
      return false;
    }
    catch (Exception paramContext)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #4");
      AppMethodBeat.o(55230);
    }
    return true;
  }
  
  private boolean w(Context paramContext)
  {
    AppMethodBeat.i(55256);
    TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
    try
    {
      bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
      TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #2  enabled is ".concat(String.valueOf(bool)));
      if (!bool)
      {
        l = v.a().a(paramContext);
        if (l != null) {
          break label88;
        }
        TbsLog.i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
        AppMethodBeat.o(55256);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        boolean bool = true;
        continue;
        l = f.f(paramContext);
      }
      label88:
      TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
      AppMethodBeat.o(55256);
    }
    return true;
  }
  
  private void x(Context paramContext)
  {
    AppMethodBeat.i(55257);
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
    if (!w(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      AppMethodBeat.o(55257);
      return;
    }
    for (;;)
    {
      try
      {
        A(paramContext);
        B(paramContext);
        TbsLog.i("TbsInstaller", "after renameTbsCoreShareDir");
        if (TbsShareManager.isThirdPartyApp(paramContext)) {
          continue;
        }
        TbsLog.i("TbsInstaller", "prepare to shareTbsCore");
        TbsShareManager.a(paramContext);
        l.a(paramContext).a(0);
        l.a(paramContext).b(0);
        l.a(paramContext).d(0);
        l.a(paramContext).a("incrupdate_retry_num", 0);
        l.a(paramContext).c(0, 3);
        l.a(paramContext).a("");
        l.a(paramContext).a("tpatch_num", 0);
        l.a(paramContext).c(-1);
        if (!TbsShareManager.isThirdPartyApp(paramContext))
        {
          i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
          if ((i1 <= 0) || (i1 == a().h(paramContext)) || (i1 != a().i(paramContext))) {
            continue;
          }
          n(paramContext);
        }
      }
      catch (Throwable localThrowable)
      {
        int i1;
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from unzip:" + localThrowable.toString());
        TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        continue;
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is " + i1 + " getTbsCoreShareDecoupleCoreVersion is " + a().h(paramContext) + " getTbsCoreInstalledVerInNolock is " + a().i(paramContext));
        continue;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsShareManager.writeCoreInfoForThirdPartyApp(paramContext, m(paramContext), true);
      }
      a.set(Integer.valueOf(0));
      o = 0;
      g(paramContext);
      AppMethodBeat.o(55257);
      return;
      TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
    }
  }
  
  private void y(Context paramContext)
  {
    AppMethodBeat.i(55258);
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
    if (!w(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      AppMethodBeat.o(55258);
      return;
    }
    try
    {
      A(paramContext);
      D(paramContext);
      TbsShareManager.a(paramContext);
      l.a(paramContext).b(0, -1);
      l.a(paramContext).a("tpatch_num", 0);
      a.set(Integer.valueOf(0));
      g(paramContext);
      AppMethodBeat.o(55258);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(242, "exception when renameing from tpatch:" + localException.toString());
      }
    }
  }
  
  private void z(Context paramContext)
  {
    AppMethodBeat.i(55259);
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
    if (!w(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      AppMethodBeat.o(55259);
      return;
    }
    for (;;)
    {
      try
      {
        A(paramContext);
        C(paramContext);
        TbsShareManager.a(paramContext);
        l.a(paramContext).a(0, 3);
        l.a(paramContext).a("tpatch_num", 0);
        if (!TbsShareManager.isThirdPartyApp(paramContext))
        {
          i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
          if ((i1 <= 0) || (i1 == a().h(paramContext)) || (i1 != a().i(paramContext))) {
            continue;
          }
          n(paramContext);
        }
        a.set(Integer.valueOf(0));
      }
      catch (Exception localException)
      {
        int i1;
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from copy:" + localException.toString());
        continue;
      }
      g(paramContext);
      AppMethodBeat.o(55259);
      return;
      TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is " + i1 + " getTbsCoreShareDecoupleCoreVersion is " + a().h(paramContext) + " getTbsCoreInstalledVerInNolock is " + a().i(paramContext));
    }
  }
  
  /* Error */
  int a(File paramFile)
  {
    // Byte code:
    //   0: ldc_w 1347
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: ldc 149
    //   11: ldc_w 1349
    //   14: aload_1
    //   15: invokestatic 769	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   21: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: new 194	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: ldc_w 309
    //   32: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 556	java/io/File:exists	()Z
    //   40: istore_3
    //   41: iload_3
    //   42: ifne +11 -> 53
    //   45: ldc_w 1347
    //   48: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_0
    //   52: ireturn
    //   53: new 311	java/util/Properties
    //   56: dup
    //   57: invokespecial 312	java/util/Properties:<init>	()V
    //   60: astore 5
    //   62: new 314	java/io/BufferedInputStream
    //   65: dup
    //   66: new 316	java/io/FileInputStream
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   74: invokespecial 322	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   77: astore_1
    //   78: aload 5
    //   80: aload_1
    //   81: invokevirtual 325	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   84: aload_1
    //   85: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   88: aload 5
    //   90: ldc_w 1351
    //   93: invokevirtual 1352	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 4
    //   98: aload 4
    //   100: ifnonnull +15 -> 115
    //   103: aload_1
    //   104: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   107: ldc_w 1347
    //   110: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: iconst_0
    //   114: ireturn
    //   115: aload 4
    //   117: invokestatic 1355	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   120: istore_2
    //   121: aload_1
    //   122: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   125: ldc_w 1347
    //   128: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: iload_2
    //   132: ireturn
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_1
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   144: ldc_w 1347
    //   147: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_0
    //   151: ireturn
    //   152: astore_1
    //   153: aload 4
    //   155: ifnull +8 -> 163
    //   158: aload 4
    //   160: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   163: ldc_w 1347
    //   166: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_1
    //   170: athrow
    //   171: astore_1
    //   172: goto -65 -> 107
    //   175: astore_1
    //   176: goto -51 -> 125
    //   179: astore_1
    //   180: goto -36 -> 144
    //   183: astore 4
    //   185: goto -22 -> 163
    //   188: astore 5
    //   190: aload_1
    //   191: astore 4
    //   193: aload 5
    //   195: astore_1
    //   196: goto -43 -> 153
    //   199: astore 4
    //   201: goto -65 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	o
    //   0	204	1	paramFile	File
    //   120	12	2	i1	int
    //   40	2	3	bool	boolean
    //   7	152	4	str	String
    //   183	1	4	localIOException	java.io.IOException
    //   191	1	4	localFile	File
    //   199	1	4	localException	Exception
    //   60	29	5	localProperties	java.util.Properties
    //   188	6	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	41	133	java/lang/Exception
    //   53	78	133	java/lang/Exception
    //   9	41	152	finally
    //   53	78	152	finally
    //   103	107	171	java/io/IOException
    //   121	125	175	java/io/IOException
    //   140	144	179	java/io/IOException
    //   158	163	183	java/io/IOException
    //   78	98	188	finally
    //   115	121	188	finally
    //   78	98	199	java/lang/Exception
    //   115	121	199	java/lang/Exception
  }
  
  /* Error */
  int a(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1356
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 1356
    //   13: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_0
    //   17: ireturn
    //   18: aconst_null
    //   19: astore 4
    //   21: new 194	java/io/File
    //   24: dup
    //   25: new 194	java/io/File
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: ldc_w 309
    //   36: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 556	java/io/File:exists	()Z
    //   44: istore_3
    //   45: iload_3
    //   46: ifne +11 -> 57
    //   49: ldc_w 1356
    //   52: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_0
    //   56: ireturn
    //   57: new 311	java/util/Properties
    //   60: dup
    //   61: invokespecial 312	java/util/Properties:<init>	()V
    //   64: astore 5
    //   66: new 314	java/io/BufferedInputStream
    //   69: dup
    //   70: new 316	java/io/FileInputStream
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   78: invokespecial 322	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: astore_1
    //   82: aload 5
    //   84: aload_1
    //   85: invokevirtual 325	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   88: aload_1
    //   89: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   92: aload 5
    //   94: ldc_w 1351
    //   97: invokevirtual 1352	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 4
    //   102: aload 4
    //   104: ifnonnull +15 -> 119
    //   107: aload_1
    //   108: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   111: ldc_w 1356
    //   114: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: iconst_0
    //   118: ireturn
    //   119: aload 4
    //   121: invokestatic 1355	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   124: istore_2
    //   125: aload_1
    //   126: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   129: ldc_w 1356
    //   132: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: iload_2
    //   136: ireturn
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   148: ldc_w 1356
    //   151: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: iconst_0
    //   155: ireturn
    //   156: astore_1
    //   157: aload 4
    //   159: ifnull +8 -> 167
    //   162: aload 4
    //   164: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   167: ldc_w 1356
    //   170: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: aload_1
    //   174: athrow
    //   175: astore_1
    //   176: goto -65 -> 111
    //   179: astore_1
    //   180: goto -51 -> 129
    //   183: astore_1
    //   184: goto -36 -> 148
    //   187: astore 4
    //   189: goto -22 -> 167
    //   192: astore 5
    //   194: aload_1
    //   195: astore 4
    //   197: aload 5
    //   199: astore_1
    //   200: goto -43 -> 157
    //   203: astore 4
    //   205: goto -65 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	o
    //   0	208	1	paramString	String
    //   124	12	2	i1	int
    //   44	2	3	bool	boolean
    //   19	144	4	str1	String
    //   187	1	4	localIOException	java.io.IOException
    //   195	1	4	str2	String
    //   203	1	4	localException	Exception
    //   64	29	5	localProperties	java.util.Properties
    //   192	6	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	45	137	java/lang/Exception
    //   57	82	137	java/lang/Exception
    //   21	45	156	finally
    //   57	82	156	finally
    //   107	111	175	java/io/IOException
    //   125	129	179	java/io/IOException
    //   144	148	183	java/io/IOException
    //   162	167	187	java/io/IOException
    //   82	102	192	finally
    //   119	125	192	finally
    //   82	102	203	java/lang/Exception
    //   119	125	203	java/lang/Exception
  }
  
  public int a(boolean paramBoolean, Context paramContext)
  {
    AppMethodBeat.i(55216);
    if ((paramBoolean) || (((Integer)a.get()).intValue() <= 0)) {
      a.set(Integer.valueOf(i(paramContext)));
    }
    int i1 = ((Integer)a.get()).intValue();
    AppMethodBeat.o(55216);
    return i1;
  }
  
  File a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(55284);
    File localFile = QbSdk.getTbsFolderDir(paramContext);
    paramContext = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      TbsLog.i("TbsInstaller", "type=" + paramInt + "needMakeDir=" + paramBoolean + "folder=" + paramContext);
      paramContext = new File(localFile, paramContext);
      if (paramContext.isDirectory()) {
        break label212;
      }
      if (!paramBoolean) {
        break;
      }
      if (paramContext.mkdir()) {
        break label212;
      }
      TbsLog.i("TbsInstaller", "getCoreDir,mkdir false");
      AppMethodBeat.o(55284);
      return null;
      paramContext = "core_unzip_tmp";
      continue;
      paramContext = "core_unzip_tmp_decouple";
      continue;
      paramContext = "core_share_backup";
      continue;
      paramContext = "core_share_backup_tmp";
      continue;
      paramContext = "core_copy_tmp";
      continue;
      paramContext = "tpatch_tmp";
      continue;
      paramContext = "tpatch_decouple_tmp";
    }
    TbsLog.i("TbsInstaller", "getCoreDir,no need mkdir");
    AppMethodBeat.o(55284);
    return null;
    label212:
    AppMethodBeat.o(55284);
    return paramContext;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55228);
    g(paramContext, true);
    l.a(paramContext).c(paramInt, 2);
    AppMethodBeat.o(55228);
  }
  
  void a(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(55235);
    if ((paramBundle == null) || (paramContext == null))
    {
      AppMethodBeat.o(55235);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = new Object[] { paramContext, paramBundle };
    m.sendMessage(localMessage);
    AppMethodBeat.o(55235);
  }
  
  void a(Context paramContext, File paramFile, int paramInt)
  {
    AppMethodBeat.i(55236);
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmp,ctx=" + paramContext + "File=" + paramFile + "coreVersion=" + paramInt);
    if ((paramFile == null) || (paramContext == null))
    {
      AppMethodBeat.o(55236);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 4;
    localMessage.obj = new Object[] { paramContext, paramFile, Integer.valueOf(paramInt) };
    m.sendMessage(localMessage);
    AppMethodBeat.o(55236);
  }
  
  void a(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(55224);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=".concat(String.valueOf(paramString)));
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=".concat(String.valueOf(paramInt)));
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramContext, paramString, Integer.valueOf(paramInt) };
    m.sendMessage(localMessage);
    AppMethodBeat.o(55224);
  }
  
  void a(Context paramContext, boolean paramBoolean)
  {
    int i5 = 0;
    AppMethodBeat.i(55220);
    if (paramBoolean) {
      this.k = true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
    if (!t(paramContext))
    {
      AppMethodBeat.o(55220);
      return;
    }
    String str = null;
    if (i.tryLock()) {}
    for (;;)
    {
      try
      {
        i4 = l.a(paramContext).c();
        i3 = l.a(paramContext).b();
        str = l.a(paramContext).d("install_apk_path");
        i1 = l.a(paramContext).c("copy_core_ver");
        i2 = l.a(paramContext).b("copy_status");
        i.unlock();
        b();
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=".concat(String.valueOf(i4)));
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=".concat(String.valueOf(i3)));
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=".concat(String.valueOf(str)));
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=".concat(String.valueOf(i1)));
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=".concat(String.valueOf(i2)));
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          c(paramContext, TbsShareManager.a(paramContext, false));
          AppMethodBeat.o(55220);
          return;
        }
      }
      finally
      {
        i.unlock();
        AppMethodBeat.o(55220);
      }
      int i6 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_responsecode", 0);
      if ((i6 == 1) || (i6 == 2) || (i6 == 4)) {
        i5 = 1;
      }
      if ((i5 == 0) && (i6 != 0) && (i6 != 5))
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("operation", 10001);
        a(paramContext, localBundle);
      }
      if ((i4 >= 0) && (i4 < 2)) {
        a(paramContext, str, i3);
      }
      if (i2 == 0) {
        b(paramContext, i1);
      }
      AppMethodBeat.o(55220);
      return;
      int i1 = 0;
      int i2 = -1;
      int i3 = 0;
      int i4 = -1;
    }
  }
  
  /* Error */
  public boolean a(final Context paramContext1, final Context paramContext2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1450
    //   5: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 149
    //   10: ldc_w 1452
    //   13: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: getstatic 121	com/tencent/smtt/sdk/o:p	Z
    //   19: iconst_1
    //   20: if_icmpne +13 -> 33
    //   23: ldc_w 1450
    //   26: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iconst_1
    //   32: ireturn
    //   33: iconst_1
    //   34: putstatic 121	com/tencent/smtt/sdk/o:p	Z
    //   37: new 8	com/tencent/smtt/sdk/o$4
    //   40: dup
    //   41: aload_0
    //   42: aload_2
    //   43: aload_1
    //   44: invokespecial 1455	com/tencent/smtt/sdk/o$4:<init>	(Lcom/tencent/smtt/sdk/o;Landroid/content/Context;Landroid/content/Context;)V
    //   47: invokevirtual 1458	com/tencent/smtt/sdk/o$4:start	()V
    //   50: ldc_w 1450
    //   53: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -27 -> 29
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	o
    //   0	64	1	paramContext1	Context
    //   0	64	2	paramContext2	Context
    // Exception table:
    //   from	to	target	type
    //   2	29	59	finally
    //   33	56	59	finally
  }
  
  public boolean a(Context paramContext, File[] paramArrayOfFile)
  {
    return false;
  }
  
  Context b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(55243);
    try
    {
      if (paramContext.getPackageName() != paramString)
      {
        boolean bool = TbsPVConfig.getInstance(paramContext).isEnableNoCoreGray();
        if (bool)
        {
          AppMethodBeat.o(55243);
          return null;
        }
      }
      paramContext = paramContext.createPackageContext(paramString, 2);
      AppMethodBeat.o(55243);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(55243);
    }
    return null;
  }
  
  File b(Context paramContext1, Context paramContext2)
  {
    AppMethodBeat.i(55277);
    paramContext1 = TbsOneGreyInfoHelper.getCoreDir(paramContext1);
    AppMethodBeat.o(55277);
    return paramContext1;
  }
  
  void b()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(55287);
        if (this.e <= 0)
        {
          TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock currentTbsFileLockStackCount=" + this.e + "call stack:" + Log.getStackTraceString(new Throwable()));
          AppMethodBeat.o(55287);
          return;
        }
        TbsLog.d("TbsInstaller", "releaseTbsInstallingFileLock,current Thread Id=" + Thread.currentThread().getId() + "currentTbsFileLockStackCount=" + this.e);
        if (this.e > 1)
        {
          TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
          this.e -= 1;
          AppMethodBeat.o(55287);
          continue;
        }
        if (this.e != 1) {
          break label180;
        }
      }
      finally {}
      TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
      f.a(this.f, this.g);
      this.e = 0;
      label180:
      AppMethodBeat.o(55287);
    }
  }
  
  public void b(Context paramContext)
  {
    AppMethodBeat.i(55227);
    g(paramContext, true);
    l.a(paramContext).c(h(paramContext), 2);
    AppMethodBeat.o(55227);
  }
  
  /* Error */
  void b(Context paramContext, Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 1506
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 149
    //   8: new 174	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 1508
    //   15: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: invokestatic 791	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   21: invokevirtual 792	java/lang/Thread:getName	()Ljava/lang/String;
    //   24: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: new 281	java/lang/Throwable
    //   30: dup
    //   31: invokespecial 1486	java/lang/Throwable:<init>	()V
    //   34: invokestatic 661	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   37: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 404	com/tencent/smtt/sdk/o:c	(Landroid/content/Context;)Z
    //   51: ifeq +20 -> 71
    //   54: aload_1
    //   55: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   58: sipush -539
    //   61: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   64: ldc_w 1506
    //   67: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: return
    //   71: ldc 149
    //   73: ldc_w 1510
    //   76: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_2
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: ifnonnull +10 -> 94
    //   87: ldc_w 1506
    //   90: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: return
    //   94: aload_1
    //   95: invokestatic 487	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   98: ifne +73 -> 171
    //   101: invokestatic 492	com/tencent/smtt/utils/q:a	()J
    //   104: lstore 7
    //   106: aload_1
    //   107: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   110: invokevirtual 495	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   113: lstore 9
    //   115: aload_1
    //   116: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   119: sipush 210
    //   122: new 174	java/lang/StringBuilder
    //   125: dup
    //   126: ldc_w 1512
    //   129: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: lload 7
    //   134: invokevirtual 500	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: ldc_w 502
    //   140: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: lload 9
    //   145: invokevirtual 500	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   148: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   154: aload_1
    //   155: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   158: sipush -540
    //   161: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   164: ldc_w 1506
    //   167: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: aload_0
    //   172: aload_1
    //   173: invokevirtual 438	com/tencent/smtt/sdk/o:t	(Landroid/content/Context;)Z
    //   176: ifne +20 -> 196
    //   179: aload_1
    //   180: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   183: sipush -541
    //   186: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   189: ldc_w 1506
    //   192: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: return
    //   196: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   199: invokeinterface 443 1 0
    //   204: istore 11
    //   206: ldc 149
    //   208: ldc_w 1514
    //   211: iload 11
    //   213: invokestatic 205	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   216: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   219: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: iload 11
    //   224: ifeq +1713 -> 1937
    //   227: aload_1
    //   228: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   231: getfield 893	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   234: ldc_w 895
    //   237: iconst_0
    //   238: invokeinterface 428 3 0
    //   243: istore 5
    //   245: aconst_null
    //   246: astore 16
    //   248: aconst_null
    //   249: astore 12
    //   251: aconst_null
    //   252: astore 18
    //   254: aconst_null
    //   255: astore 15
    //   257: aconst_null
    //   258: astore 17
    //   260: aload 12
    //   262: astore 13
    //   264: aload 15
    //   266: astore 14
    //   268: iconst_1
    //   269: invokestatic 1192	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   272: iload 5
    //   274: iconst_5
    //   275: if_icmpne +283 -> 558
    //   278: aload 12
    //   280: astore 13
    //   282: aload 15
    //   284: astore 14
    //   286: aload_0
    //   287: aload_1
    //   288: aload_2
    //   289: invokespecial 1516	com/tencent/smtt/sdk/o:c	(Landroid/content/Context;Landroid/os/Bundle;)I
    //   292: istore 4
    //   294: iload 4
    //   296: iconst_1
    //   297: if_icmpne +43 -> 340
    //   300: aload 18
    //   302: astore 13
    //   304: iload 4
    //   306: istore_3
    //   307: aload_1
    //   308: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   311: ldc_w 1293
    //   314: invokevirtual 453	com/tencent/smtt/sdk/l:c	(Ljava/lang/String;)I
    //   317: istore 6
    //   319: aload 18
    //   321: astore 13
    //   323: iload 4
    //   325: istore_3
    //   326: aload_1
    //   327: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   330: ldc_w 1293
    //   333: iload 6
    //   335: iconst_1
    //   336: iadd
    //   337: invokevirtual 522	com/tencent/smtt/sdk/l:a	(Ljava/lang/String;I)V
    //   340: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   343: invokeinterface 469 1 0
    //   348: aload_0
    //   349: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   352: iload 5
    //   354: iconst_5
    //   355: if_icmpne +17 -> 372
    //   358: aload_0
    //   359: aload_1
    //   360: iload 4
    //   362: invokespecial 1518	com/tencent/smtt/sdk/o:h	(Landroid/content/Context;I)V
    //   365: ldc_w 1506
    //   368: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   371: return
    //   372: iload 4
    //   374: ifne +68 -> 442
    //   377: ldc 149
    //   379: ldc_w 1520
    //   382: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: aload_1
    //   386: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   389: ldc_w 1289
    //   392: iconst_0
    //   393: invokevirtual 522	com/tencent/smtt/sdk/l:a	(Ljava/lang/String;I)V
    //   396: aload_1
    //   397: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   400: sipush -544
    //   403: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   406: aload_1
    //   407: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   410: iconst_0
    //   411: iconst_m1
    //   412: invokevirtual 266	com/tencent/smtt/sdk/l:c	(II)V
    //   415: aload_1
    //   416: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   419: iconst_1
    //   420: invokevirtual 268	com/tencent/smtt/sdk/l:c	(I)V
    //   423: new 1522	java/lang/NullPointerException
    //   426: dup
    //   427: invokespecial 1523	java/lang/NullPointerException:<init>	()V
    //   430: athrow
    //   431: iconst_0
    //   432: invokestatic 1192	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   435: ldc_w 1506
    //   438: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   441: return
    //   442: iload 4
    //   444: iconst_2
    //   445: if_icmpne +14 -> 459
    //   448: ldc 149
    //   450: ldc_w 1525
    //   453: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: goto -25 -> 431
    //   459: aload_1
    //   460: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   463: sipush -546
    //   466: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   469: ldc 149
    //   471: ldc_w 1527
    //   474: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: aload_1
    //   478: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   481: getfield 864	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   484: ldc_w 866
    //   487: getstatic 872	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   490: invokeinterface 878 3 0
    //   495: pop
    //   496: aload_1
    //   497: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   500: invokevirtual 882	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   503: aload_1
    //   504: invokestatic 511	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   507: ifeq +27 -> 534
    //   510: aload_1
    //   511: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   514: sipush 235
    //   517: ldc_w 1529
    //   520: iload 4
    //   522: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   525: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   528: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   531: goto -100 -> 431
    //   534: aload_1
    //   535: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   538: sipush 217
    //   541: ldc_w 1531
    //   544: iload 4
    //   546: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   549: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   552: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   555: goto -124 -> 431
    //   558: aload 12
    //   560: astore 13
    //   562: aload 15
    //   564: astore 14
    //   566: aload_0
    //   567: aload_1
    //   568: invokevirtual 474	com/tencent/smtt/sdk/o:i	(Landroid/content/Context;)I
    //   571: ifle +22 -> 593
    //   574: aload 12
    //   576: astore 13
    //   578: aload 15
    //   580: astore 14
    //   582: aload_1
    //   583: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   586: invokevirtual 1238	com/tencent/smtt/sdk/l:d	()I
    //   589: iconst_1
    //   590: if_icmpne +65 -> 655
    //   593: aload 12
    //   595: astore 13
    //   597: aload 15
    //   599: astore 14
    //   601: iconst_0
    //   602: invokestatic 1192	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   605: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   608: invokeinterface 469 1 0
    //   613: aload_0
    //   614: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   617: iload 5
    //   619: iconst_5
    //   620: if_icmpne +16 -> 636
    //   623: aload_0
    //   624: aload_1
    //   625: iconst_2
    //   626: invokespecial 1518	com/tencent/smtt/sdk/o:h	(Landroid/content/Context;I)V
    //   629: ldc_w 1506
    //   632: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   635: return
    //   636: ldc 149
    //   638: ldc_w 1525
    //   641: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: iconst_0
    //   645: invokestatic 1192	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   648: ldc_w 1506
    //   651: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   654: return
    //   655: iload 5
    //   657: iconst_1
    //   658: if_icmpeq +15 -> 673
    //   661: iload 5
    //   663: iconst_2
    //   664: if_icmpeq +9 -> 673
    //   667: iload 5
    //   669: iconst_4
    //   670: if_icmpne +304 -> 974
    //   673: iconst_1
    //   674: istore_3
    //   675: iload_3
    //   676: ifne +1331 -> 2007
    //   679: iload 5
    //   681: ifeq +1326 -> 2007
    //   684: aload 12
    //   686: astore 13
    //   688: aload 15
    //   690: astore 14
    //   692: aload_1
    //   693: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   696: ldc_w 1289
    //   699: invokevirtual 453	com/tencent/smtt/sdk/l:c	(Ljava/lang/String;)I
    //   702: istore_3
    //   703: iload_3
    //   704: iconst_5
    //   705: if_icmple +293 -> 998
    //   708: aload 12
    //   710: astore 13
    //   712: aload 15
    //   714: astore 14
    //   716: ldc 149
    //   718: ldc_w 1533
    //   721: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   724: aload 12
    //   726: astore 13
    //   728: aload 15
    //   730: astore 14
    //   732: aload_2
    //   733: ldc_w 1535
    //   736: invokevirtual 1002	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   739: astore 17
    //   741: aload 12
    //   743: astore 13
    //   745: aload 15
    //   747: astore 14
    //   749: aload_2
    //   750: ldc_w 999
    //   753: invokevirtual 1002	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   756: astore 16
    //   758: aload 12
    //   760: astore 13
    //   762: aload 15
    //   764: astore 14
    //   766: aload_2
    //   767: ldc_w 1537
    //   770: invokevirtual 1002	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   773: astore_2
    //   774: aload 12
    //   776: astore 13
    //   778: aload 15
    //   780: astore 14
    //   782: aload 17
    //   784: invokestatic 1040	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   787: ifne +23 -> 810
    //   790: aload 12
    //   792: astore 13
    //   794: aload 15
    //   796: astore 14
    //   798: new 194	java/io/File
    //   801: dup
    //   802: aload 17
    //   804: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   807: invokestatic 706	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   810: aload 12
    //   812: astore 13
    //   814: aload 15
    //   816: astore 14
    //   818: aload 16
    //   820: invokestatic 1040	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   823: ifne +23 -> 846
    //   826: aload 12
    //   828: astore 13
    //   830: aload 15
    //   832: astore 14
    //   834: new 194	java/io/File
    //   837: dup
    //   838: aload 16
    //   840: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   843: invokestatic 706	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   846: aload 12
    //   848: astore 13
    //   850: aload 15
    //   852: astore 14
    //   854: aload_2
    //   855: invokestatic 1040	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   858: ifne +22 -> 880
    //   861: aload 12
    //   863: astore 13
    //   865: aload 15
    //   867: astore 14
    //   869: new 194	java/io/File
    //   872: dup
    //   873: aload_2
    //   874: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   877: invokestatic 706	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   880: aload 12
    //   882: astore 13
    //   884: aload 15
    //   886: astore 14
    //   888: aload_1
    //   889: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   892: getfield 864	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   895: ldc_w 866
    //   898: getstatic 872	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   901: invokeinterface 878 3 0
    //   906: pop
    //   907: aload 12
    //   909: astore 13
    //   911: aload 15
    //   913: astore 14
    //   915: aload_1
    //   916: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   919: invokevirtual 882	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   922: aload 12
    //   924: astore 13
    //   926: aload 15
    //   928: astore 14
    //   930: aload_1
    //   931: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   934: sipush 224
    //   937: ldc_w 1539
    //   940: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   943: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   946: invokeinterface 469 1 0
    //   951: aload_0
    //   952: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   955: iload 5
    //   957: iconst_5
    //   958: if_icmpne +21 -> 979
    //   961: aload_0
    //   962: aload_1
    //   963: iconst_2
    //   964: invokespecial 1518	com/tencent/smtt/sdk/o:h	(Landroid/content/Context;I)V
    //   967: ldc_w 1506
    //   970: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   973: return
    //   974: iconst_0
    //   975: istore_3
    //   976: goto -301 -> 675
    //   979: ldc 149
    //   981: ldc_w 1525
    //   984: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   987: iconst_0
    //   988: invokestatic 1192	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   991: ldc_w 1506
    //   994: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   997: return
    //   998: aload 12
    //   1000: astore 13
    //   1002: aload 15
    //   1004: astore 14
    //   1006: aload_1
    //   1007: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1010: ldc_w 1289
    //   1013: iload_3
    //   1014: iconst_1
    //   1015: iadd
    //   1016: invokevirtual 522	com/tencent/smtt/sdk/l:a	(Ljava/lang/String;I)V
    //   1019: aload 12
    //   1021: astore 13
    //   1023: aload 15
    //   1025: astore 14
    //   1027: aload_1
    //   1028: invokestatic 725	com/tencent/smtt/sdk/o:s	(Landroid/content/Context;)Ljava/io/File;
    //   1031: astore 16
    //   1033: aload 16
    //   1035: ifnull +972 -> 2007
    //   1038: aload 12
    //   1040: astore 13
    //   1042: aload 15
    //   1044: astore 14
    //   1046: new 194	java/io/File
    //   1049: dup
    //   1050: aload 16
    //   1052: ldc_w 727
    //   1055: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1058: invokevirtual 556	java/io/File:exists	()Z
    //   1061: ifeq +946 -> 2007
    //   1064: aload 12
    //   1066: astore 13
    //   1068: aload 15
    //   1070: astore 14
    //   1072: aload_1
    //   1073: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1076: sipush -550
    //   1079: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1082: aload 12
    //   1084: astore 13
    //   1086: aload 15
    //   1088: astore 14
    //   1090: aload_1
    //   1091: aload_2
    //   1092: invokestatic 991	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   1095: astore 12
    //   1097: aload 12
    //   1099: ifnonnull +79 -> 1178
    //   1102: aload 12
    //   1104: astore 13
    //   1106: aload_1
    //   1107: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1110: sipush 228
    //   1113: new 174	java/lang/StringBuilder
    //   1116: dup
    //   1117: ldc_w 1541
    //   1120: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1123: aload_2
    //   1124: ldc_w 1004
    //   1127: invokevirtual 997	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1130: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1133: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1136: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1139: iconst_1
    //   1140: istore 4
    //   1142: aload 12
    //   1144: astore 13
    //   1146: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   1149: invokeinterface 469 1 0
    //   1154: aload_0
    //   1155: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1158: iload 5
    //   1160: iconst_5
    //   1161: if_icmpne +191 -> 1352
    //   1164: aload_0
    //   1165: aload_1
    //   1166: iload 4
    //   1168: invokespecial 1518	com/tencent/smtt/sdk/o:h	(Landroid/content/Context;I)V
    //   1171: ldc_w 1506
    //   1174: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1177: return
    //   1178: aload 12
    //   1180: astore 13
    //   1182: aload 12
    //   1184: astore 14
    //   1186: aload 12
    //   1188: ldc_w 995
    //   1191: invokevirtual 997	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1194: istore_3
    //   1195: iload_3
    //   1196: istore 4
    //   1198: aload 12
    //   1200: astore 13
    //   1202: iload_3
    //   1203: ifeq -57 -> 1146
    //   1206: aload_1
    //   1207: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1210: sipush 228
    //   1213: new 174	java/lang/StringBuilder
    //   1216: dup
    //   1217: ldc_w 1543
    //   1220: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1223: iload_3
    //   1224: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1227: ldc_w 1545
    //   1230: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: aload_2
    //   1234: ldc_w 1004
    //   1237: invokevirtual 997	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1240: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1243: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1246: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1249: iload_3
    //   1250: istore 4
    //   1252: aload 12
    //   1254: astore 13
    //   1256: goto -110 -> 1146
    //   1259: astore_2
    //   1260: aload 12
    //   1262: astore 13
    //   1264: ldc 149
    //   1266: new 174	java/lang/StringBuilder
    //   1269: dup
    //   1270: ldc_w 1547
    //   1273: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1276: aload_2
    //   1277: invokestatic 661	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1280: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1286: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1289: aload 12
    //   1291: astore 13
    //   1293: aload_1
    //   1294: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1297: sipush -543
    //   1300: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1303: aload 12
    //   1305: astore 13
    //   1307: aload_1
    //   1308: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1311: sipush 218
    //   1314: aload_2
    //   1315: invokevirtual 583	java/lang/Exception:toString	()Ljava/lang/String;
    //   1318: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1321: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   1324: invokeinterface 469 1 0
    //   1329: aload_0
    //   1330: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1333: iload 5
    //   1335: iconst_5
    //   1336: if_icmpne +244 -> 1580
    //   1339: aload_0
    //   1340: aload_1
    //   1341: iconst_1
    //   1342: invokespecial 1518	com/tencent/smtt/sdk/o:h	(Landroid/content/Context;I)V
    //   1345: ldc_w 1506
    //   1348: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1351: return
    //   1352: iload 4
    //   1354: ifne +110 -> 1464
    //   1357: ldc 149
    //   1359: ldc_w 1520
    //   1362: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1365: aload_1
    //   1366: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1369: ldc_w 1289
    //   1372: iconst_0
    //   1373: invokevirtual 522	com/tencent/smtt/sdk/l:a	(Ljava/lang/String;I)V
    //   1376: aload_1
    //   1377: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1380: sipush -544
    //   1383: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1386: aload_1
    //   1387: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1390: iconst_0
    //   1391: iconst_m1
    //   1392: invokevirtual 266	com/tencent/smtt/sdk/l:c	(II)V
    //   1395: aload_1
    //   1396: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1399: iconst_1
    //   1400: invokevirtual 268	com/tencent/smtt/sdk/l:c	(I)V
    //   1403: aload 13
    //   1405: ldc_w 1549
    //   1408: invokevirtual 1002	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1411: astore_2
    //   1412: new 194	java/io/File
    //   1415: dup
    //   1416: aload_2
    //   1417: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   1420: aload_1
    //   1421: invokestatic 624	com/tencent/smtt/sdk/k:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1424: aload_0
    //   1425: aload_1
    //   1426: aload_2
    //   1427: aload 13
    //   1429: ldc_w 1551
    //   1432: invokevirtual 997	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1435: invokespecial 691	com/tencent/smtt/sdk/o:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1438: aload_1
    //   1439: invokestatic 511	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1442: ifeq +11 -> 1453
    //   1445: aload_1
    //   1446: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1449: iconst_m1
    //   1450: invokevirtual 268	com/tencent/smtt/sdk/l:c	(I)V
    //   1453: iconst_0
    //   1454: invokestatic 1192	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1457: ldc_w 1506
    //   1460: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1463: return
    //   1464: iload 4
    //   1466: iconst_2
    //   1467: if_icmpne +14 -> 1481
    //   1470: ldc 149
    //   1472: ldc_w 1525
    //   1475: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1478: goto -25 -> 1453
    //   1481: aload_1
    //   1482: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1485: sipush -546
    //   1488: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1491: ldc 149
    //   1493: ldc_w 1527
    //   1496: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1499: aload_1
    //   1500: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1503: getfield 864	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1506: ldc_w 866
    //   1509: getstatic 872	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1512: invokeinterface 878 3 0
    //   1517: pop
    //   1518: aload_1
    //   1519: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1522: invokevirtual 882	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1525: aload_1
    //   1526: invokestatic 511	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1529: ifeq +27 -> 1556
    //   1532: aload_1
    //   1533: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1536: sipush 235
    //   1539: ldc_w 1529
    //   1542: iload 4
    //   1544: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1547: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1550: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1553: goto -100 -> 1453
    //   1556: aload_1
    //   1557: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1560: sipush 217
    //   1563: ldc_w 1531
    //   1566: iload 4
    //   1568: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1571: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1574: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1577: goto -124 -> 1453
    //   1580: aload_1
    //   1581: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1584: sipush -546
    //   1587: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1590: ldc 149
    //   1592: ldc_w 1527
    //   1595: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1598: aload_1
    //   1599: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1602: getfield 864	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1605: ldc_w 866
    //   1608: getstatic 872	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1611: invokeinterface 878 3 0
    //   1616: pop
    //   1617: aload_1
    //   1618: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1621: invokevirtual 882	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1624: aload_1
    //   1625: invokestatic 511	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1628: ifeq +27 -> 1655
    //   1631: aload_1
    //   1632: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1635: sipush 235
    //   1638: ldc_w 1553
    //   1641: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1644: iconst_0
    //   1645: invokestatic 1192	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1648: ldc_w 1506
    //   1651: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1654: return
    //   1655: aload_1
    //   1656: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1659: sipush 217
    //   1662: ldc_w 1555
    //   1665: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1668: goto -24 -> 1644
    //   1671: astore_2
    //   1672: iconst_2
    //   1673: istore_3
    //   1674: aload 13
    //   1676: astore 12
    //   1678: getstatic 65	com/tencent/smtt/sdk/o:j	Ljava/util/concurrent/locks/Lock;
    //   1681: invokeinterface 469 1 0
    //   1686: aload_0
    //   1687: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1690: iload 5
    //   1692: iconst_5
    //   1693: if_icmpne +16 -> 1709
    //   1696: aload_0
    //   1697: aload_1
    //   1698: iload_3
    //   1699: invokespecial 1518	com/tencent/smtt/sdk/o:h	(Landroid/content/Context;I)V
    //   1702: ldc_w 1506
    //   1705: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1708: return
    //   1709: iload_3
    //   1710: ifne +114 -> 1824
    //   1713: ldc 149
    //   1715: ldc_w 1520
    //   1718: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1721: aload_1
    //   1722: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1725: ldc_w 1289
    //   1728: iconst_0
    //   1729: invokevirtual 522	com/tencent/smtt/sdk/l:a	(Ljava/lang/String;I)V
    //   1732: aload_1
    //   1733: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1736: sipush -544
    //   1739: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1742: aload_1
    //   1743: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1746: iconst_0
    //   1747: iconst_m1
    //   1748: invokevirtual 266	com/tencent/smtt/sdk/l:c	(II)V
    //   1751: aload_1
    //   1752: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1755: iconst_1
    //   1756: invokevirtual 268	com/tencent/smtt/sdk/l:c	(I)V
    //   1759: aload 12
    //   1761: ldc_w 1549
    //   1764: invokevirtual 1002	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1767: astore 13
    //   1769: new 194	java/io/File
    //   1772: dup
    //   1773: aload 13
    //   1775: invokespecial 285	java/io/File:<init>	(Ljava/lang/String;)V
    //   1778: aload_1
    //   1779: invokestatic 624	com/tencent/smtt/sdk/k:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1782: aload_0
    //   1783: aload_1
    //   1784: aload 13
    //   1786: aload 12
    //   1788: ldc_w 1551
    //   1791: invokevirtual 997	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1794: invokespecial 691	com/tencent/smtt/sdk/o:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1797: aload_1
    //   1798: invokestatic 511	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1801: ifeq +11 -> 1812
    //   1804: aload_1
    //   1805: invokestatic 263	com/tencent/smtt/sdk/l:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/l;
    //   1808: iconst_m1
    //   1809: invokevirtual 268	com/tencent/smtt/sdk/l:c	(I)V
    //   1812: iconst_0
    //   1813: invokestatic 1192	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1816: ldc_w 1506
    //   1819: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1822: aload_2
    //   1823: athrow
    //   1824: iload_3
    //   1825: iconst_2
    //   1826: if_icmpne +14 -> 1840
    //   1829: ldc 149
    //   1831: ldc_w 1525
    //   1834: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1837: goto -25 -> 1812
    //   1840: aload_1
    //   1841: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1844: sipush -546
    //   1847: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1850: ldc 149
    //   1852: ldc_w 1527
    //   1855: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1858: aload_1
    //   1859: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1862: getfield 864	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1865: ldc_w 866
    //   1868: getstatic 872	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1871: invokeinterface 878 3 0
    //   1876: pop
    //   1877: aload_1
    //   1878: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1881: invokevirtual 882	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1884: aload_1
    //   1885: invokestatic 511	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1888: ifeq +26 -> 1914
    //   1891: aload_1
    //   1892: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1895: sipush 235
    //   1898: ldc_w 1529
    //   1901: iload_3
    //   1902: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1905: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1908: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1911: goto -99 -> 1812
    //   1914: aload_1
    //   1915: invokestatic 237	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1918: sipush 217
    //   1921: ldc_w 1531
    //   1924: iload_3
    //   1925: invokestatic 409	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1928: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1931: invokevirtual 243	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1934: goto -122 -> 1812
    //   1937: aload_1
    //   1938: invokestatic 399	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1941: sipush -547
    //   1944: invokevirtual 402	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1947: aload_0
    //   1948: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   1951: ldc_w 1506
    //   1954: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1957: return
    //   1958: astore_2
    //   1959: aload 13
    //   1961: astore 12
    //   1963: goto -285 -> 1678
    //   1966: astore_2
    //   1967: iconst_1
    //   1968: istore_3
    //   1969: aload 13
    //   1971: astore 12
    //   1973: goto -295 -> 1678
    //   1976: astore_2
    //   1977: goto -299 -> 1678
    //   1980: astore_2
    //   1981: iconst_2
    //   1982: istore_3
    //   1983: aload 14
    //   1985: astore 12
    //   1987: goto -727 -> 1260
    //   1990: astore_2
    //   1991: aload 16
    //   1993: astore 12
    //   1995: iload 4
    //   1997: istore_3
    //   1998: goto -738 -> 1260
    //   2001: astore_2
    //   2002: iconst_1
    //   2003: istore_3
    //   2004: goto -744 -> 1260
    //   2007: iconst_2
    //   2008: istore 4
    //   2010: aload 17
    //   2012: astore 13
    //   2014: goto -868 -> 1146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2017	0	this	o
    //   0	2017	1	paramContext	Context
    //   0	2017	2	paramBundle	Bundle
    //   306	1698	3	i1	int
    //   292	1717	4	i2	int
    //   243	1451	5	i3	int
    //   317	20	6	i4	int
    //   104	29	7	l1	long
    //   113	31	9	l2	long
    //   204	19	11	bool	boolean
    //   249	1745	12	localObject1	Object
    //   262	1751	13	localObject2	Object
    //   266	1718	14	localObject3	Object
    //   255	832	15	localObject4	Object
    //   246	1746	16	localObject5	Object
    //   258	1753	17	str	String
    //   252	68	18	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   1206	1249	1259	java/lang/Exception
    //   268	272	1671	finally
    //   286	294	1671	finally
    //   566	574	1671	finally
    //   582	593	1671	finally
    //   601	605	1671	finally
    //   692	703	1671	finally
    //   716	724	1671	finally
    //   732	741	1671	finally
    //   749	758	1671	finally
    //   766	774	1671	finally
    //   782	790	1671	finally
    //   798	810	1671	finally
    //   818	826	1671	finally
    //   834	846	1671	finally
    //   854	861	1671	finally
    //   869	880	1671	finally
    //   888	907	1671	finally
    //   915	922	1671	finally
    //   930	943	1671	finally
    //   1006	1019	1671	finally
    //   1027	1033	1671	finally
    //   1046	1064	1671	finally
    //   1072	1082	1671	finally
    //   1090	1097	1671	finally
    //   1186	1195	1671	finally
    //   307	319	1958	finally
    //   326	340	1958	finally
    //   1264	1289	1958	finally
    //   1106	1139	1966	finally
    //   1293	1303	1966	finally
    //   1307	1321	1966	finally
    //   1206	1249	1976	finally
    //   268	272	1980	java/lang/Exception
    //   286	294	1980	java/lang/Exception
    //   566	574	1980	java/lang/Exception
    //   582	593	1980	java/lang/Exception
    //   601	605	1980	java/lang/Exception
    //   692	703	1980	java/lang/Exception
    //   716	724	1980	java/lang/Exception
    //   732	741	1980	java/lang/Exception
    //   749	758	1980	java/lang/Exception
    //   766	774	1980	java/lang/Exception
    //   782	790	1980	java/lang/Exception
    //   798	810	1980	java/lang/Exception
    //   818	826	1980	java/lang/Exception
    //   834	846	1980	java/lang/Exception
    //   854	861	1980	java/lang/Exception
    //   869	880	1980	java/lang/Exception
    //   888	907	1980	java/lang/Exception
    //   915	922	1980	java/lang/Exception
    //   930	943	1980	java/lang/Exception
    //   1006	1019	1980	java/lang/Exception
    //   1027	1033	1980	java/lang/Exception
    //   1046	1064	1980	java/lang/Exception
    //   1072	1082	1980	java/lang/Exception
    //   1090	1097	1980	java/lang/Exception
    //   1186	1195	1980	java/lang/Exception
    //   307	319	1990	java/lang/Exception
    //   326	340	1990	java/lang/Exception
    //   1106	1139	2001	java/lang/Exception
  }
  
  void b(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(55222);
    TbsLog.v("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.v("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded currentProcessId=" + android.os.Process.myPid());
    TbsLog.v("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded currentThreadName=" + Thread.currentThread().getName());
    if (QbSdk.b)
    {
      AppMethodBeat.o(55222);
      return;
    }
    if (Build.VERSION.SDK_INT < 8)
    {
      TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
      AppMethodBeat.o(55222);
      return;
    }
    TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #1 ");
    File localFile;
    if ((TbsShareManager.isThirdPartyApp(paramContext)) && (l.a(paramContext).b("remove_old_core") == 1) && (paramBoolean)) {
      localFile = a().q(paramContext);
    }
    try
    {
      f.b(localFile);
      TbsLog.i("TbsInstaller", "thirdAPP success--> delete old core_share Directory");
      label175:
      l.a(paramContext).a("remove_old_core", 0);
      if (v(paramContext))
      {
        TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #2 ");
        if ((a(paramContext, "core_unzip_tmp")) && (e(paramContext, paramBoolean)))
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!", true);
          AppMethodBeat.o(55222);
          return;
        }
        if ((a(paramContext, "core_share_backup_tmp")) && (f(paramContext, paramBoolean)))
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!", true);
          AppMethodBeat.o(55222);
          return;
        }
        if ((a(paramContext, "core_copy_tmp")) && (d(paramContext, paramBoolean)))
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!", true);
          AppMethodBeat.o(55222);
          return;
        }
        if ((a(paramContext, "tpatch_tmp")) && (c(paramContext, paramBoolean)))
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch!!", true);
          AppMethodBeat.o(55222);
          return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
        AppMethodBeat.o(55222);
        return;
      }
      AppMethodBeat.o(55222);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label175;
    }
  }
  
  boolean b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55234);
    if (TbsDownloader.getOverSea(paramContext))
    {
      AppMethodBeat.o(55234);
      return false;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=".concat(String.valueOf(paramInt)));
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
    Context localContext = d(paramContext, paramInt);
    if (localContext != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = new Object[] { localContext, paramContext, Integer.valueOf(paramInt) };
      m.sendMessage(localMessage);
      AppMethodBeat.o(55234);
      return true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
    AppMethodBeat.o(55234);
    return false;
  }
  
  public boolean b(Context paramContext, File paramFile, int paramInt)
  {
    AppMethodBeat.i(55244);
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
    boolean bool = a(paramContext, paramFile, false);
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is ".concat(String.valueOf(bool)));
    if (bool) {
      a().a(paramContext, paramInt);
    }
    AppMethodBeat.o(55244);
    return bool;
  }
  
  int c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(55254);
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramContext != null)
    {
      int i1 = paramContext.versionCode;
      AppMethodBeat.o(55254);
      return i1;
    }
    AppMethodBeat.o(55254);
    return 0;
  }
  
  File c(Context paramContext1, Context paramContext2)
  {
    AppMethodBeat.i(55279);
    paramContext2 = new File(QbSdk.getTbsFolderDir(paramContext2), "core_share_decouple");
    if ((!paramContext2.isDirectory()) && ((paramContext1 == null) || (!TbsShareManager.isThirdPartyApp(paramContext1))) && (!paramContext2.mkdir()))
    {
      AppMethodBeat.o(55279);
      return null;
    }
    AppMethodBeat.o(55279);
    return paramContext2;
  }
  
  void c(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55240);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
    if (paramInt <= 0)
    {
      AppMethodBeat.o(55240);
      return;
    }
    int i1 = i(paramContext);
    if (i1 == paramInt)
    {
      AppMethodBeat.o(55240);
      return;
    }
    Context localContext = TbsShareManager.e(paramContext);
    if ((localContext != null) || (TbsShareManager.getHostCorePathAppDefined() != null))
    {
      TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
      a(paramContext, localContext);
      AppMethodBeat.o(55240);
      return;
    }
    if (i1 <= 0)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
      QbSdk.a(paramContext, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
    }
    AppMethodBeat.o(55240);
  }
  
  /* Error */
  boolean c(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 1639
    //   5: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 194	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 160	com/tencent/smtt/sdk/o:q	(Landroid/content/Context;)Ljava/io/File;
    //   17: ldc_w 309
    //   20: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore 5
    //   25: aload 5
    //   27: invokevirtual 556	java/io/File:exists	()Z
    //   30: ifne +11 -> 41
    //   33: ldc_w 1639
    //   36: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: iconst_0
    //   40: ireturn
    //   41: new 311	java/util/Properties
    //   44: dup
    //   45: invokespecial 312	java/util/Properties:<init>	()V
    //   48: astore 6
    //   50: new 314	java/io/BufferedInputStream
    //   53: dup
    //   54: new 316	java/io/FileInputStream
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 322	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore_1
    //   67: aload 6
    //   69: aload_1
    //   70: invokevirtual 325	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload 6
    //   75: ldc_w 335
    //   78: ldc_w 1641
    //   81: invokevirtual 594	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   84: invokestatic 1644	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   87: invokevirtual 903	java/lang/Boolean:booleanValue	()Z
    //   90: istore 4
    //   92: iload 4
    //   94: ifeq +165 -> 259
    //   97: invokestatic 536	java/lang/System:currentTimeMillis	()J
    //   100: aload 5
    //   102: invokevirtual 1647	java/io/File:lastModified	()J
    //   105: lsub
    //   106: ldc2_w 1648
    //   109: lcmp
    //   110: ifle +61 -> 171
    //   113: iconst_1
    //   114: istore_3
    //   115: ldc 149
    //   117: new 174	java/lang/StringBuilder
    //   120: dup
    //   121: ldc_w 1651
    //   124: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: iload 4
    //   129: invokevirtual 732	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   132: ldc_w 1653
    //   135: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iload_3
    //   139: invokevirtual 732	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   142: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: iload_3
    //   149: ifne +27 -> 176
    //   152: iload 4
    //   154: iload_2
    //   155: iand
    //   156: istore 4
    //   158: aload_1
    //   159: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   162: ldc_w 1639
    //   165: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: iload 4
    //   170: ireturn
    //   171: iconst_0
    //   172: istore_3
    //   173: goto -58 -> 115
    //   176: iconst_0
    //   177: istore_2
    //   178: goto -26 -> 152
    //   181: astore_1
    //   182: aconst_null
    //   183: astore_1
    //   184: iconst_0
    //   185: istore_3
    //   186: iload_3
    //   187: istore 4
    //   189: aload_1
    //   190: ifnull -28 -> 162
    //   193: aload_1
    //   194: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   197: iload_3
    //   198: istore 4
    //   200: goto -38 -> 162
    //   203: astore_1
    //   204: iload_3
    //   205: istore 4
    //   207: goto -45 -> 162
    //   210: astore 5
    //   212: aconst_null
    //   213: astore_1
    //   214: aload_1
    //   215: ifnull +7 -> 222
    //   218: aload_1
    //   219: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   222: ldc_w 1639
    //   225: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload 5
    //   230: athrow
    //   231: astore_1
    //   232: goto -70 -> 162
    //   235: astore_1
    //   236: goto -14 -> 222
    //   239: astore 5
    //   241: goto -27 -> 214
    //   244: astore 5
    //   246: iconst_0
    //   247: istore_3
    //   248: goto -62 -> 186
    //   251: astore 5
    //   253: iload 4
    //   255: istore_3
    //   256: goto -70 -> 186
    //   259: iconst_0
    //   260: istore_3
    //   261: goto -146 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	o
    //   0	264	1	paramContext	Context
    //   1	177	2	bool1	boolean
    //   114	147	3	bool2	boolean
    //   90	164	4	bool3	boolean
    //   23	78	5	localFile	File
    //   210	19	5	localObject1	Object
    //   239	1	5	localObject2	Object
    //   244	1	5	localThrowable1	Throwable
    //   251	1	5	localThrowable2	Throwable
    //   48	26	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   50	67	181	java/lang/Throwable
    //   193	197	203	java/io/IOException
    //   50	67	210	finally
    //   158	162	231	java/io/IOException
    //   218	222	235	java/io/IOException
    //   67	92	239	finally
    //   97	113	239	finally
    //   115	148	239	finally
    //   67	92	244	java/lang/Throwable
    //   97	113	251	java/lang/Throwable
    //   115	148	251	java/lang/Throwable
  }
  
  public Context d(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55253);
    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=".concat(String.valueOf(paramInt)));
    if (paramInt <= 0)
    {
      AppMethodBeat.o(55253);
      return null;
    }
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int i1 = 0;
    if (i1 < arrayOfString.length)
    {
      Context localContext;
      if ((!paramContext.getPackageName().equalsIgnoreCase(arrayOfString[i1])) && (e(paramContext, arrayOfString[i1])))
      {
        localContext = b(paramContext, arrayOfString[i1]);
        if (localContext != null)
        {
          if (f(localContext)) {
            break label136;
          }
          TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + arrayOfString[i1] + " illegal signature go on next");
        }
      }
      label136:
      int i2;
      do
      {
        i1 += 1;
        break;
        i2 = i(localContext);
        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=".concat(String.valueOf(i2)));
      } while ((i2 == 0) || (i2 != paramInt));
      TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + arrayOfString[i1]);
      AppMethodBeat.o(55253);
      return localContext;
    }
    AppMethodBeat.o(55253);
    return null;
  }
  
  /* Error */
  public String d(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 1674
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 1040	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 1674
    //   16: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: new 194	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 160	com/tencent/smtt/sdk/o:q	(Landroid/content/Context;)Ljava/io/File;
    //   30: ldc_w 309
    //   33: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   36: astore_1
    //   37: aload_1
    //   38: invokevirtual 556	java/io/File:exists	()Z
    //   41: istore_3
    //   42: iload_3
    //   43: ifne +11 -> 54
    //   46: ldc_w 1674
    //   49: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aconst_null
    //   53: areturn
    //   54: new 311	java/util/Properties
    //   57: dup
    //   58: invokespecial 312	java/util/Properties:<init>	()V
    //   61: astore 4
    //   63: new 314	java/io/BufferedInputStream
    //   66: dup
    //   67: new 316	java/io/FileInputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   75: invokespecial 322	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   78: astore_1
    //   79: aload 4
    //   81: aload_1
    //   82: invokevirtual 325	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   85: aload_1
    //   86: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   89: aload 4
    //   91: aload_2
    //   92: invokevirtual 1352	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore_2
    //   96: aload_1
    //   97: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   100: ldc_w 1674
    //   103: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_2
    //   107: areturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +7 -> 119
    //   115: aload_1
    //   116: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   119: ldc_w 1674
    //   122: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   138: ldc_w 1674
    //   141: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_1
    //   145: athrow
    //   146: astore_1
    //   147: goto -47 -> 100
    //   150: astore_1
    //   151: goto -32 -> 119
    //   154: astore_2
    //   155: goto -17 -> 138
    //   158: astore_2
    //   159: aload_1
    //   160: astore 4
    //   162: aload_2
    //   163: astore_1
    //   164: aload 4
    //   166: astore_2
    //   167: goto -37 -> 130
    //   170: astore_2
    //   171: goto -60 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	o
    //   0	174	1	paramContext	Context
    //   0	174	2	paramString	String
    //   41	2	3	bool	boolean
    //   61	104	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	42	108	java/lang/Exception
    //   54	79	108	java/lang/Exception
    //   21	42	127	finally
    //   54	79	127	finally
    //   96	100	146	java/io/IOException
    //   115	119	150	java/io/IOException
    //   134	138	154	java/io/IOException
    //   79	96	158	finally
    //   79	96	170	java/lang/Exception
  }
  
  /* Error */
  public void d(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 1675
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 194	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 160	com/tencent/smtt/sdk/o:q	(Landroid/content/Context;)Ljava/io/File;
    //   15: ldc_w 309
    //   18: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore_1
    //   22: new 311	java/util/Properties
    //   25: dup
    //   26: invokespecial 312	java/util/Properties:<init>	()V
    //   29: astore_3
    //   30: new 314	java/io/BufferedInputStream
    //   33: dup
    //   34: new 316	java/io/FileInputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 322	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_2
    //   46: aload_3
    //   47: aload_2
    //   48: invokevirtual 325	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   51: new 327	java/io/BufferedOutputStream
    //   54: dup
    //   55: new 329	java/io/FileOutputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 330	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 333	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   66: astore_1
    //   67: aload_3
    //   68: ldc_w 335
    //   71: ldc_w 1641
    //   74: invokevirtual 341	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   77: pop
    //   78: aload_3
    //   79: aload_1
    //   80: aconst_null
    //   81: invokevirtual 345	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   84: aload_1
    //   85: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   88: aload_2
    //   89: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   92: ldc_w 1675
    //   95: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: return
    //   99: astore_1
    //   100: ldc_w 1675
    //   103: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: return
    //   107: astore_1
    //   108: ldc_w 1675
    //   111: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_2
    //   120: aload_1
    //   121: ifnull +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   128: aload_2
    //   129: ifnull +51 -> 180
    //   132: aload_2
    //   133: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   136: ldc_w 1675
    //   139: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: return
    //   143: astore_1
    //   144: ldc_w 1675
    //   147: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: astore_1
    //   152: aconst_null
    //   153: astore_2
    //   154: aconst_null
    //   155: astore_3
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   172: ldc_w 1675
    //   175: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aload_1
    //   179: athrow
    //   180: ldc_w 1675
    //   183: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: return
    //   187: astore_1
    //   188: goto -100 -> 88
    //   191: astore_1
    //   192: goto -64 -> 128
    //   195: astore_2
    //   196: goto -32 -> 164
    //   199: astore_2
    //   200: goto -28 -> 172
    //   203: astore_1
    //   204: aconst_null
    //   205: astore 4
    //   207: aload_2
    //   208: astore_3
    //   209: aload 4
    //   211: astore_2
    //   212: goto -56 -> 156
    //   215: astore 4
    //   217: aload_1
    //   218: astore 5
    //   220: aload_2
    //   221: astore_3
    //   222: aload 4
    //   224: astore_1
    //   225: aload 5
    //   227: astore_2
    //   228: goto -72 -> 156
    //   231: astore_1
    //   232: aconst_null
    //   233: astore_1
    //   234: goto -114 -> 120
    //   237: astore_3
    //   238: goto -118 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	o
    //   0	241	1	paramContext	Context
    //   45	116	2	localBufferedInputStream	java.io.BufferedInputStream
    //   195	1	2	localIOException1	java.io.IOException
    //   199	9	2	localIOException2	java.io.IOException
    //   211	17	2	localObject1	Object
    //   29	193	3	localObject2	Object
    //   237	1	3	localThrowable	Throwable
    //   205	5	4	localObject3	Object
    //   215	8	4	localObject4	Object
    //   218	8	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   88	92	99	java/io/IOException
    //   6	30	107	java/lang/Throwable
    //   84	88	107	java/lang/Throwable
    //   88	92	107	java/lang/Throwable
    //   92	98	107	java/lang/Throwable
    //   100	106	107	java/lang/Throwable
    //   124	128	107	java/lang/Throwable
    //   132	136	107	java/lang/Throwable
    //   136	142	107	java/lang/Throwable
    //   144	150	107	java/lang/Throwable
    //   160	164	107	java/lang/Throwable
    //   168	172	107	java/lang/Throwable
    //   172	180	107	java/lang/Throwable
    //   30	46	115	java/lang/Throwable
    //   132	136	143	java/io/IOException
    //   30	46	151	finally
    //   84	88	187	java/io/IOException
    //   124	128	191	java/io/IOException
    //   160	164	195	java/io/IOException
    //   168	172	199	java/io/IOException
    //   46	67	203	finally
    //   67	84	215	finally
    //   46	67	231	java/lang/Throwable
    //   67	84	237	java/lang/Throwable
  }
  
  int e(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55261);
    paramInt = a(f(paramContext, paramInt));
    AppMethodBeat.o(55261);
    return paramInt;
  }
  
  public boolean e(Context paramContext)
  {
    AppMethodBeat.i(55248);
    for (;;)
    {
      int i1;
      try
      {
        Object localObject = new File(f.a(paramContext, 4), TbsDownloader.getBackupFileName(true));
        File localFile1 = a().f(paramContext, 2);
        f.a(localFile1);
        f.a(localFile1, true);
        f.a((File)localObject, localFile1);
        localObject = localFile1.list();
        i1 = 0;
        if (i1 < localObject.length)
        {
          File localFile2 = new File(localFile1, localObject[i1]);
          if (localFile2.getName().endsWith(".dex")) {
            localFile2.delete();
          }
        }
        else
        {
          i(paramContext, 2);
          AppMethodBeat.o(55248);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(55248);
        return false;
      }
      i1 += 1;
    }
  }
  
  File f(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(55283);
    paramContext = a(paramContext, paramInt, true);
    AppMethodBeat.o(55283);
    return paramContext;
  }
  
  boolean f(Context paramContext)
  {
    AppMethodBeat.i(55252);
    if (TbsShareManager.getHostCorePathAppDefined() != null)
    {
      AppMethodBeat.o(55252);
      return true;
    }
    try
    {
      Signature localSignature = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0];
      boolean bool;
      if (paramContext.getPackageName().equals("com.tencent.mtt"))
      {
        bool = localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a");
        if (!bool)
        {
          AppMethodBeat.o(55252);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.mm"))
      {
        bool = localSignature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499");
        if (!bool)
        {
          AppMethodBeat.o(55252);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.mobileqq"))
      {
        bool = localSignature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049");
        if (!bool)
        {
          AppMethodBeat.o(55252);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.tbs"))
      {
        bool = localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a");
        if (!bool)
        {
          AppMethodBeat.o(55252);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.qzone"))
      {
        bool = localSignature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677");
        if (!bool)
        {
          AppMethodBeat.o(55252);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.qqpimsecure"))
      {
        bool = localSignature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
        if (!bool)
        {
          AppMethodBeat.o(55252);
          return false;
        }
      }
    }
    catch (Exception paramContext)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
      AppMethodBeat.o(55252);
      return false;
    }
    AppMethodBeat.o(55252);
    return true;
  }
  
  public void g(Context paramContext)
  {
    AppMethodBeat.i(55255);
    int i1 = 1;
    try
    {
      boolean bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
      i1 = bool;
    }
    catch (Throwable localThrowable)
    {
      label17:
      break label17;
    }
    if ((i1 != 0) && (l != null))
    {
      f.a(paramContext, l);
      TbsLog.d("TbsInstaller", "releaseTbsCoreRenameFileLock ##!");
    }
    AppMethodBeat.o(55255);
  }
  
  boolean g(Context paramContext, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(55285);
    try
    {
      bool3 = TbsShareManager.isThirdPartyApp(paramContext);
      if (bool3)
      {
        if (TbsShareManager.j(paramContext))
        {
          localFile = new File(TbsShareManager.c(paramContext));
          bool1 = localFile.getAbsolutePath().contains("com.tencent.tbs");
          if (!bool1) {
            break label324;
          }
          AppMethodBeat.o(55285);
          return true;
        }
        TbsLog.e("TbsInstaller", "321");
        AppMethodBeat.o(55285);
        return false;
      }
      localFile = q(paramContext);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        boolean bool3;
        File localFile;
        Long[][] arrayOfLong1;
        int i2;
        int i1;
        Long[] arrayOfLong;
        label217:
        TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getMessage is " + paramContext.getMessage());
        TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getCause is " + paramContext.getCause());
        boolean bool1 = false;
        continue;
        continue;
        i1 += 1;
      }
    }
    if (localFile != null)
    {
      arrayOfLong1 = n;
      i2 = arrayOfLong1.length;
      i1 = 0;
      bool1 = bool2;
      if (i1 < i2)
      {
        arrayOfLong = arrayOfLong1[i1];
        if (paramInt != arrayOfLong[0].intValue()) {
          break label327;
        }
        localFile = new File(localFile, "libmttwebview.so");
        if ((!localFile.exists()) || (localFile.length() != arrayOfLong[1].longValue())) {
          break label217;
        }
        TbsLog.d("TbsInstaller", "check so success: " + paramInt + "; file: " + localFile);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(55285);
      return bool1;
      if (!bool3) {
        f.b(QbSdk.getTbsFolderDir(paramContext));
      }
      a.set(Integer.valueOf(0));
      TbsLog.e("TbsInstaller", "322");
      bool1 = false;
      continue;
      TbsLog.e("TbsInstaller", "323");
      bool1 = false;
    }
  }
  
  /* Error */
  int h(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 1754
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: new 194	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 524	com/tencent/smtt/sdk/o:p	(Landroid/content/Context;)Ljava/io/File;
    //   18: ldc_w 309
    //   21: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 556	java/io/File:exists	()Z
    //   29: istore_3
    //   30: iload_3
    //   31: ifne +11 -> 42
    //   34: ldc_w 1754
    //   37: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_0
    //   41: ireturn
    //   42: new 311	java/util/Properties
    //   45: dup
    //   46: invokespecial 312	java/util/Properties:<init>	()V
    //   49: astore 5
    //   51: new 314	java/io/BufferedInputStream
    //   54: dup
    //   55: new 316	java/io/FileInputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 322	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore_1
    //   67: aload 5
    //   69: aload_1
    //   70: invokevirtual 325	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload_1
    //   74: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   77: aload 5
    //   79: ldc_w 1351
    //   82: invokevirtual 1352	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 4
    //   87: aload 4
    //   89: ifnonnull +15 -> 104
    //   92: aload_1
    //   93: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   96: ldc_w 1754
    //   99: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: iconst_0
    //   103: ireturn
    //   104: aload 4
    //   106: invokestatic 1355	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   109: istore_2
    //   110: aload_1
    //   111: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   114: ldc_w 1754
    //   117: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: iload_2
    //   121: ireturn
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_1
    //   125: aload_1
    //   126: ifnull +7 -> 133
    //   129: aload_1
    //   130: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   133: ldc_w 1754
    //   136: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_1
    //   142: aload 4
    //   144: ifnull +8 -> 152
    //   147: aload 4
    //   149: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   152: ldc_w 1754
    //   155: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_1
    //   159: athrow
    //   160: astore_1
    //   161: goto -65 -> 96
    //   164: astore_1
    //   165: goto -51 -> 114
    //   168: astore_1
    //   169: goto -36 -> 133
    //   172: astore 4
    //   174: goto -22 -> 152
    //   177: astore 5
    //   179: aload_1
    //   180: astore 4
    //   182: aload 5
    //   184: astore_1
    //   185: goto -43 -> 142
    //   188: astore 4
    //   190: goto -65 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	o
    //   0	193	1	paramContext	Context
    //   109	12	2	i1	int
    //   29	2	3	bool	boolean
    //   7	141	4	str	String
    //   172	1	4	localIOException	java.io.IOException
    //   180	1	4	localContext	Context
    //   188	1	4	localException	Exception
    //   49	29	5	localProperties	java.util.Properties
    //   177	6	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	30	122	java/lang/Exception
    //   42	67	122	java/lang/Exception
    //   9	30	141	finally
    //   42	67	141	finally
    //   92	96	160	java/io/IOException
    //   110	114	164	java/io/IOException
    //   129	133	168	java/io/IOException
    //   147	152	172	java/io/IOException
    //   67	87	177	finally
    //   104	110	177	finally
    //   67	87	188	java/lang/Exception
    //   104	110	188	java/lang/Exception
  }
  
  /* Error */
  int i(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 1755
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 149
    //   8: ldc_w 1757
    //   11: invokestatic 560	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: new 194	java/io/File
    //   17: dup
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 160	com/tencent/smtt/sdk/o:q	(Landroid/content/Context;)Ljava/io/File;
    //   23: ldc_w 309
    //   26: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 556	java/io/File:exists	()Z
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +11 -> 47
    //   39: ldc_w 1755
    //   42: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iconst_0
    //   46: ireturn
    //   47: new 311	java/util/Properties
    //   50: dup
    //   51: invokespecial 312	java/util/Properties:<init>	()V
    //   54: astore 5
    //   56: new 314	java/io/BufferedInputStream
    //   59: dup
    //   60: new 316	java/io/FileInputStream
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   68: invokespecial 322	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore 4
    //   73: aload 4
    //   75: astore_1
    //   76: aload 5
    //   78: aload 4
    //   80: invokevirtual 325	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   83: aload 4
    //   85: astore_1
    //   86: aload 4
    //   88: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   91: aload 4
    //   93: astore_1
    //   94: aload 5
    //   96: ldc_w 1351
    //   99: invokevirtual 1352	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 5
    //   104: aload 5
    //   106: ifnonnull +45 -> 151
    //   109: aload 4
    //   111: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   114: ldc_w 1755
    //   117: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: iconst_0
    //   121: ireturn
    //   122: astore_1
    //   123: ldc 149
    //   125: new 174	java/lang/StringBuilder
    //   128: dup
    //   129: ldc_w 1759
    //   132: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload_1
    //   136: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   139: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: goto -34 -> 114
    //   151: aload 4
    //   153: astore_1
    //   154: aload 5
    //   156: invokestatic 1355	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   159: istore_2
    //   160: aload 4
    //   162: astore_1
    //   163: getstatic 119	com/tencent/smtt/sdk/o:o	I
    //   166: ifne +10 -> 176
    //   169: aload 4
    //   171: astore_1
    //   172: iload_2
    //   173: putstatic 119	com/tencent/smtt/sdk/o:o	I
    //   176: aload 4
    //   178: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   181: ldc_w 1755
    //   184: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: iload_2
    //   188: ireturn
    //   189: astore_1
    //   190: ldc 149
    //   192: new 174	java/lang/StringBuilder
    //   195: dup
    //   196: ldc_w 1759
    //   199: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: aload_1
    //   203: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   206: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: goto -34 -> 181
    //   218: astore 5
    //   220: aconst_null
    //   221: astore 4
    //   223: aload 4
    //   225: astore_1
    //   226: ldc 149
    //   228: new 174	java/lang/StringBuilder
    //   231: dup
    //   232: ldc_w 1762
    //   235: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   238: aload 5
    //   240: invokevirtual 583	java/lang/Exception:toString	()Ljava/lang/String;
    //   243: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload 4
    //   254: ifnull +8 -> 262
    //   257: aload 4
    //   259: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   262: ldc_w 1755
    //   265: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: iconst_0
    //   269: ireturn
    //   270: astore_1
    //   271: ldc 149
    //   273: new 174	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 1759
    //   280: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload_1
    //   284: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   287: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: goto -34 -> 262
    //   299: astore 4
    //   301: aconst_null
    //   302: astore_1
    //   303: aload_1
    //   304: ifnull +7 -> 311
    //   307: aload_1
    //   308: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   311: ldc_w 1755
    //   314: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: aload 4
    //   319: athrow
    //   320: astore_1
    //   321: ldc 149
    //   323: new 174	java/lang/StringBuilder
    //   326: dup
    //   327: ldc_w 1759
    //   330: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   333: aload_1
    //   334: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   337: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: goto -35 -> 311
    //   349: astore 4
    //   351: goto -48 -> 303
    //   354: astore 5
    //   356: goto -133 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	o
    //   0	359	1	paramContext	Context
    //   159	29	2	i1	int
    //   34	2	3	bool	boolean
    //   71	187	4	localBufferedInputStream	java.io.BufferedInputStream
    //   299	19	4	localObject1	Object
    //   349	1	4	localObject2	Object
    //   54	101	5	localObject3	Object
    //   218	21	5	localException1	Exception
    //   354	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   109	114	122	java/io/IOException
    //   176	181	189	java/io/IOException
    //   14	35	218	java/lang/Exception
    //   47	73	218	java/lang/Exception
    //   257	262	270	java/io/IOException
    //   14	35	299	finally
    //   47	73	299	finally
    //   307	311	320	java/io/IOException
    //   76	83	349	finally
    //   86	91	349	finally
    //   94	104	349	finally
    //   154	160	349	finally
    //   163	169	349	finally
    //   172	176	349	finally
    //   226	252	349	finally
    //   76	83	354	java/lang/Exception
    //   86	91	354	java/lang/Exception
    //   94	104	354	java/lang/Exception
    //   154	160	354	java/lang/Exception
    //   163	169	354	java/lang/Exception
    //   172	176	354	java/lang/Exception
  }
  
  int j(Context paramContext)
  {
    AppMethodBeat.i(55266);
    if (o != 0)
    {
      i1 = o;
      AppMethodBeat.o(55266);
      return i1;
    }
    int i1 = i(paramContext);
    AppMethodBeat.o(55266);
    return i1;
  }
  
  void k(Context paramContext)
  {
    AppMethodBeat.i(55267);
    if (o != 0)
    {
      AppMethodBeat.o(55267);
      return;
    }
    o = i(paramContext);
    AppMethodBeat.o(55267);
  }
  
  boolean l(Context paramContext)
  {
    AppMethodBeat.i(55268);
    if (!new File(q(paramContext), "tbs.conf").exists())
    {
      AppMethodBeat.o(55268);
      return false;
    }
    AppMethodBeat.o(55268);
    return true;
  }
  
  /* Error */
  int m(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 1766
    //   3: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 438	com/tencent/smtt/sdk/o:t	(Landroid/content/Context;)Z
    //   11: ifne +11 -> 22
    //   14: ldc_w 1766
    //   17: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_m1
    //   21: ireturn
    //   22: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   25: invokevirtual 1098	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   28: istore_3
    //   29: ldc 149
    //   31: ldc_w 1768
    //   34: iload_3
    //   35: invokestatic 205	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   38: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: iload_3
    //   45: ifeq +536 -> 581
    //   48: new 194	java/io/File
    //   51: dup
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 160	com/tencent/smtt/sdk/o:q	(Landroid/content/Context;)Ljava/io/File;
    //   57: ldc_w 309
    //   60: invokespecial 304	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual 556	java/io/File:exists	()Z
    //   68: istore_3
    //   69: iload_3
    //   70: ifne +49 -> 119
    //   73: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   76: invokevirtual 1771	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   79: ifeq +9 -> 88
    //   82: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   85: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   88: aload_0
    //   89: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   92: ldc_w 1766
    //   95: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: iconst_0
    //   99: ireturn
    //   100: astore_1
    //   101: ldc 149
    //   103: ldc_w 1773
    //   106: aload_1
    //   107: invokestatic 769	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   110: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   113: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: goto -28 -> 88
    //   119: new 311	java/util/Properties
    //   122: dup
    //   123: invokespecial 312	java/util/Properties:<init>	()V
    //   126: astore 5
    //   128: new 314	java/io/BufferedInputStream
    //   131: dup
    //   132: new 316	java/io/FileInputStream
    //   135: dup
    //   136: aload_1
    //   137: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   140: invokespecial 322	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   143: astore 4
    //   145: aload 4
    //   147: astore_1
    //   148: aload 5
    //   150: aload 4
    //   152: invokevirtual 325	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   155: aload 4
    //   157: astore_1
    //   158: aload 4
    //   160: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   163: aload 4
    //   165: astore_1
    //   166: aload 5
    //   168: ldc_w 1351
    //   171: invokevirtual 1352	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   174: astore 5
    //   176: aload 5
    //   178: ifnonnull +83 -> 261
    //   181: aload 4
    //   183: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   186: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   189: invokevirtual 1771	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   192: ifeq +9 -> 201
    //   195: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   198: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   201: aload_0
    //   202: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   205: ldc_w 1766
    //   208: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: iconst_0
    //   212: ireturn
    //   213: astore_1
    //   214: ldc 149
    //   216: new 174	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 1775
    //   223: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload_1
    //   227: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   230: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: goto -53 -> 186
    //   242: astore_1
    //   243: ldc 149
    //   245: ldc_w 1773
    //   248: aload_1
    //   249: invokestatic 769	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   252: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   255: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: goto -57 -> 201
    //   261: aload 4
    //   263: astore_1
    //   264: getstatic 72	com/tencent/smtt/sdk/o:a	Ljava/lang/ThreadLocal;
    //   267: aload 5
    //   269: invokestatic 1355	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   272: invokestatic 1308	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   275: invokevirtual 1314	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   278: aload 4
    //   280: astore_1
    //   281: getstatic 72	com/tencent/smtt/sdk/o:a	Ljava/lang/ThreadLocal;
    //   284: invokevirtual 1361	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   287: checkcast 1305	java/lang/Integer
    //   290: invokevirtual 1364	java/lang/Integer:intValue	()I
    //   293: istore_2
    //   294: aload 4
    //   296: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   299: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   302: invokevirtual 1771	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   305: ifeq +9 -> 314
    //   308: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   311: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   314: aload_0
    //   315: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   318: ldc_w 1766
    //   321: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: iload_2
    //   325: ireturn
    //   326: astore_1
    //   327: ldc 149
    //   329: new 174	java/lang/StringBuilder
    //   332: dup
    //   333: ldc_w 1775
    //   336: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   339: aload_1
    //   340: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   343: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: goto -53 -> 299
    //   355: astore_1
    //   356: ldc 149
    //   358: ldc_w 1773
    //   361: aload_1
    //   362: invokestatic 769	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   365: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   368: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: goto -57 -> 314
    //   374: astore 5
    //   376: aconst_null
    //   377: astore 4
    //   379: aload 4
    //   381: astore_1
    //   382: ldc 149
    //   384: new 174	java/lang/StringBuilder
    //   387: dup
    //   388: ldc_w 1777
    //   391: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: aload 5
    //   396: invokevirtual 583	java/lang/Exception:toString	()Ljava/lang/String;
    //   399: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: aload 4
    //   410: ifnull +8 -> 418
    //   413: aload 4
    //   415: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   418: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   421: invokevirtual 1771	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   424: ifeq +9 -> 433
    //   427: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   430: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   433: aload_0
    //   434: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   437: ldc_w 1766
    //   440: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   443: iconst_0
    //   444: ireturn
    //   445: astore_1
    //   446: ldc 149
    //   448: new 174	java/lang/StringBuilder
    //   451: dup
    //   452: ldc_w 1775
    //   455: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   458: aload_1
    //   459: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   462: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: goto -53 -> 418
    //   474: astore_1
    //   475: ldc 149
    //   477: ldc_w 1773
    //   480: aload_1
    //   481: invokestatic 769	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   484: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   487: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   490: goto -57 -> 433
    //   493: astore 4
    //   495: aconst_null
    //   496: astore_1
    //   497: aload_1
    //   498: ifnull +7 -> 505
    //   501: aload_1
    //   502: invokevirtual 351	java/io/BufferedInputStream:close	()V
    //   505: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   508: invokevirtual 1771	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   511: ifeq +9 -> 520
    //   514: getstatic 63	com/tencent/smtt/sdk/o:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   517: invokevirtual 468	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   520: aload_0
    //   521: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   524: ldc_w 1766
    //   527: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   530: aload 4
    //   532: athrow
    //   533: astore_1
    //   534: ldc 149
    //   536: new 174	java/lang/StringBuilder
    //   539: dup
    //   540: ldc_w 1775
    //   543: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   546: aload_1
    //   547: invokevirtual 1760	java/io/IOException:toString	()Ljava/lang/String;
    //   550: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: goto -54 -> 505
    //   562: astore_1
    //   563: ldc 149
    //   565: ldc_w 1773
    //   568: aload_1
    //   569: invokestatic 769	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   572: invokevirtual 209	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   575: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: goto -58 -> 520
    //   581: aload_0
    //   582: invokevirtual 471	com/tencent/smtt/sdk/o:b	()V
    //   585: ldc_w 1766
    //   588: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   591: iconst_0
    //   592: ireturn
    //   593: astore 4
    //   595: goto -98 -> 497
    //   598: astore 5
    //   600: goto -221 -> 379
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	this	o
    //   0	603	1	paramContext	Context
    //   293	32	2	i1	int
    //   28	42	3	bool	boolean
    //   143	271	4	localBufferedInputStream	java.io.BufferedInputStream
    //   493	38	4	localObject1	Object
    //   593	1	4	localObject2	Object
    //   126	142	5	localObject3	Object
    //   374	21	5	localException1	Exception
    //   598	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   73	88	100	java/lang/Throwable
    //   181	186	213	java/io/IOException
    //   186	201	242	java/lang/Throwable
    //   294	299	326	java/io/IOException
    //   299	314	355	java/lang/Throwable
    //   48	69	374	java/lang/Exception
    //   119	145	374	java/lang/Exception
    //   413	418	445	java/io/IOException
    //   418	433	474	java/lang/Throwable
    //   48	69	493	finally
    //   119	145	493	finally
    //   501	505	533	java/io/IOException
    //   505	520	562	java/lang/Throwable
    //   148	155	593	finally
    //   158	163	593	finally
    //   166	176	593	finally
    //   264	278	593	finally
    //   281	294	593	finally
    //   382	408	593	finally
    //   148	155	598	java/lang/Exception
    //   158	163	598	java/lang/Exception
    //   166	176	598	java/lang/Exception
    //   264	278	598	java/lang/Exception
    //   281	294	598	java/lang/Exception
  }
  
  public boolean n(Context paramContext)
  {
    AppMethodBeat.i(55272);
    TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
    File localFile1 = q(paramContext);
    File localFile2 = p(paramContext);
    try
    {
      f.a(localFile2, true);
      f.a(localFile1, localFile2, new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          AppMethodBeat.i(55189);
          if ((!paramAnonymousFile.getName().endsWith(".dex")) && (!paramAnonymousFile.getName().endsWith(".jar_is_first_load_dex_flag_file")))
          {
            AppMethodBeat.o(55189);
            return true;
          }
          AppMethodBeat.o(55189);
          return false;
        }
      });
      TbsShareManager.b(paramContext);
      TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
      AppMethodBeat.o(55272);
      return true;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(55272);
    }
    return false;
  }
  
  void o(Context paramContext)
  {
    AppMethodBeat.i(55276);
    TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
    l.a(paramContext).a(0);
    l.a(paramContext).b(0);
    l.a(paramContext).d(0);
    l.a(paramContext).a("incrupdate_retry_num", 0);
    if (!TbsDownloader.a(paramContext))
    {
      l.a(paramContext).c(0, -1);
      l.a(paramContext).a("");
      l.a(paramContext).a("copy_retry_num", 0);
      l.a(paramContext).c(-1);
      l.a(paramContext).a(0, -1);
      f.a(f(paramContext, 0), true);
      f.a(f(paramContext, 1), true);
    }
    AppMethodBeat.o(55276);
  }
  
  File p(Context paramContext)
  {
    AppMethodBeat.i(55278);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_share_decouple");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(55278);
      return null;
    }
    AppMethodBeat.o(55278);
    return paramContext;
  }
  
  File q(Context paramContext)
  {
    AppMethodBeat.i(55280);
    paramContext = b(paramContext, paramContext);
    AppMethodBeat.o(55280);
    return paramContext;
  }
  
  File r(Context paramContext)
  {
    AppMethodBeat.i(55281);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "share");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(55281);
      return null;
    }
    AppMethodBeat.o(55281);
    return paramContext;
  }
  
  /* Error */
  boolean t(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 1795
    //   7: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc 149
    //   12: new 174	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 1797
    //   19: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: invokestatic 791	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   25: invokevirtual 1491	java/lang/Thread:getId	()J
    //   28: invokevirtual 500	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   31: ldc_w 676
    //   34: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: getfield 128	com/tencent/smtt/sdk/o:e	I
    //   41: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 560	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 128	com/tencent/smtt/sdk/o:e	I
    //   54: ifle +31 -> 85
    //   57: ldc 149
    //   59: ldc_w 1799
    //   62: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_0
    //   66: aload_0
    //   67: getfield 128	com/tencent/smtt/sdk/o:e	I
    //   70: iconst_1
    //   71: iadd
    //   72: putfield 128	com/tencent/smtt/sdk/o:e	I
    //   75: ldc_w 1795
    //   78: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: monitorexit
    //   83: iload_2
    //   84: ireturn
    //   85: aload_0
    //   86: aload_1
    //   87: iconst_1
    //   88: ldc_w 1801
    //   91: invokestatic 1804	com/tencent/smtt/utils/f:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   94: putfield 1501	com/tencent/smtt/sdk/o:g	Ljava/io/FileOutputStream;
    //   97: aload_0
    //   98: getfield 1501	com/tencent/smtt/sdk/o:g	Ljava/io/FileOutputStream;
    //   101: ifnull +41 -> 142
    //   104: aload_0
    //   105: aload_1
    //   106: aload_0
    //   107: getfield 1501	com/tencent/smtt/sdk/o:g	Ljava/io/FileOutputStream;
    //   110: invokestatic 1807	com/tencent/smtt/utils/f:a	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   113: putfield 1499	com/tencent/smtt/sdk/o:f	Ljava/nio/channels/FileLock;
    //   116: aload_0
    //   117: getfield 1499	com/tencent/smtt/sdk/o:f	Ljava/nio/channels/FileLock;
    //   120: ifnonnull +41 -> 161
    //   123: ldc 149
    //   125: ldc_w 1809
    //   128: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: ldc_w 1795
    //   134: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iconst_0
    //   138: istore_2
    //   139: goto -58 -> 81
    //   142: ldc 149
    //   144: ldc_w 1811
    //   147: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: ldc_w 1795
    //   153: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_0
    //   157: istore_2
    //   158: goto -77 -> 81
    //   161: ldc 149
    //   163: ldc_w 1813
    //   166: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: aload_0
    //   171: getfield 128	com/tencent/smtt/sdk/o:e	I
    //   174: iconst_1
    //   175: iadd
    //   176: putfield 128	com/tencent/smtt/sdk/o:e	I
    //   179: ldc_w 1795
    //   182: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: goto -104 -> 81
    //   188: astore_1
    //   189: aload_0
    //   190: monitorexit
    //   191: aload_1
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	o
    //   0	193	1	paramContext	Context
    //   1	157	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	81	188	finally
    //   85	137	188	finally
    //   142	156	188	finally
    //   161	185	188	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.o
 * JD-Core Version:    0.7.0.1
 */