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

class q
{
  public static ThreadLocal<Integer> a;
  static boolean b;
  static final FileFilter c;
  private static q d;
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
    AppMethodBeat.i(192677);
    d = null;
    i = new ReentrantLock();
    j = new ReentrantLock();
    l = null;
    a = new q.1();
    m = null;
    Long[] arrayOfLong1 = { Long.valueOf(44006L), Long.valueOf(39094008L) };
    Long[] arrayOfLong2 = { Long.valueOf(44030L), Long.valueOf(39094008L) };
    n = new Long[][] { arrayOfLong1, { Long.valueOf(44005L), Long.valueOf(39094008L) }, { Long.valueOf(43910L), Long.valueOf(38917816L) }, { Long.valueOf(44027L), Long.valueOf(39094008L) }, { Long.valueOf(44028L), Long.valueOf(39094008L) }, { Long.valueOf(44029L), Long.valueOf(39094008L) }, arrayOfLong2, { Long.valueOf(44032L), Long.valueOf(39094008L) }, { Long.valueOf(44033L), Long.valueOf(39094008L) }, { Long.valueOf(44034L), Long.valueOf(39094008L) }, { Long.valueOf(43909L), Long.valueOf(38917816L) } };
    b = false;
    c = new FileFilter()
    {
      public final boolean accept(File paramAnonymousFile)
      {
        AppMethodBeat.i(192595);
        paramAnonymousFile = paramAnonymousFile.getName();
        if (paramAnonymousFile == null)
        {
          AppMethodBeat.o(192595);
          return false;
        }
        if (paramAnonymousFile.endsWith(".jar_is_first_load_dex_flag_file"))
        {
          AppMethodBeat.o(192595);
          return false;
        }
        if ((Build.VERSION.SDK_INT >= 21) && (paramAnonymousFile.endsWith(".dex")))
        {
          AppMethodBeat.o(192595);
          return false;
        }
        if ((Build.VERSION.SDK_INT >= 26) && (paramAnonymousFile.endsWith(".prof")))
        {
          AppMethodBeat.o(192595);
          return false;
        }
        if ((Build.VERSION.SDK_INT >= 26) && (paramAnonymousFile.equals("oat")))
        {
          AppMethodBeat.o(192595);
          return false;
        }
        AppMethodBeat.o(192595);
        return true;
      }
    };
    o = 0;
    p = false;
    AppMethodBeat.o(192677);
  }
  
  private q()
  {
    AppMethodBeat.i(192599);
    this.e = 0;
    this.h = false;
    this.k = false;
    if (m == null) {
      m = new Handler(o.a().getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(192708);
          QbSdk.setTBSInstallingStatus(true);
          switch (paramAnonymousMessage.what)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(192708);
            return;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
            paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
            q.a(q.this, (Context)paramAnonymousMessage[0], (String)paramAnonymousMessage[1], ((Integer)paramAnonymousMessage[2]).intValue());
            AppMethodBeat.o(192708);
            return;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
            paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
            q.a(q.this, (Context)paramAnonymousMessage[0], (Context)paramAnonymousMessage[1], ((Integer)paramAnonymousMessage[2]).intValue());
            AppMethodBeat.o(192708);
            return;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
            paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
            q.this.b((Context)paramAnonymousMessage[0], (Bundle)paramAnonymousMessage[1]);
            AppMethodBeat.o(192708);
            return;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_UNZIP_TBS_CORE");
            Object[] arrayOfObject = (Object[])paramAnonymousMessage.obj;
            q.this.b((Context)arrayOfObject[0], (File)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
            QbSdk.setTBSInstallingStatus(false);
            super.handleMessage(paramAnonymousMessage);
          }
        }
      };
    }
    AppMethodBeat.o(192599);
  }
  
  private void A(Context paramContext)
  {
    AppMethodBeat.i(192645);
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
    if (!x(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      AppMethodBeat.o(192645);
      return;
    }
    for (;;)
    {
      try
      {
        B(paramContext);
        D(paramContext);
        TbsShareManager.a(paramContext);
        n.a(paramContext).a(0, 3);
        n.a(paramContext).a("tpatch_num", 0);
        if (!TbsShareManager.isThirdPartyApp(paramContext))
        {
          i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
          if ((i1 <= 0) || (i1 == a().i(paramContext)) || (i1 != a().j(paramContext))) {
            continue;
          }
          o(paramContext);
        }
        a.set(Integer.valueOf(0));
      }
      catch (Exception localException)
      {
        int i1;
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from copy:" + localException.toString());
        continue;
      }
      h(paramContext);
      AppMethodBeat.o(192645);
      return;
      TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is " + i1 + " getTbsCoreShareDecoupleCoreVersion is " + a().i(paramContext) + " getTbsCoreInstalledVerInNolock is " + a().j(paramContext));
    }
  }
  
  private void B(Context paramContext)
  {
    AppMethodBeat.i(192656);
    TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
    f.a(r(paramContext), false);
    AppMethodBeat.o(192656);
  }
  
  private void C(Context paramContext)
  {
    AppMethodBeat.i(192657);
    TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
    File localFile1 = f(paramContext, 0);
    File localFile2 = r(paramContext);
    if ((localFile1 == null) || (localFile2 == null))
    {
      TbsLog.i("TbsInstaller", "renameTbsCoreShareDir return,tmpTbsCoreUnzipDir=" + localFile1 + "tbsSharePath=" + localFile2);
      AppMethodBeat.o(192657);
      return;
    }
    boolean bool = localFile1.renameTo(localFile2);
    TbsLog.i("TbsInstaller", "renameTbsCoreShareDir rename success=".concat(String.valueOf(bool)));
    if ((paramContext != null) && ("com.tencent.mm".equals(paramContext.getApplicationContext().getApplicationInfo().packageName)))
    {
      if (!bool) {
        break label152;
      }
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(230, " ");
    }
    for (;;)
    {
      g(paramContext, false);
      AppMethodBeat.o(192657);
      return;
      label152:
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(231, " ");
    }
  }
  
  private void D(Context paramContext)
  {
    AppMethodBeat.i(192659);
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
    File localFile1 = f(paramContext, 1);
    File localFile2 = r(paramContext);
    if ((localFile1 == null) || (localFile2 == null))
    {
      AppMethodBeat.o(192659);
      return;
    }
    localFile1.renameTo(localFile2);
    g(paramContext, false);
    AppMethodBeat.o(192659);
  }
  
  private void E(Context paramContext)
  {
    AppMethodBeat.i(192660);
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
    File localFile1 = f(paramContext, 5);
    File localFile2 = r(paramContext);
    if ((localFile1 == null) || (localFile2 == null))
    {
      AppMethodBeat.o(192660);
      return;
    }
    localFile1.renameTo(localFile2);
    g(paramContext, false);
    AppMethodBeat.o(192660);
  }
  
  private void F(Context paramContext)
  {
    AppMethodBeat.i(192661);
    TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
    File localFile = f(paramContext, 0);
    if (localFile != null) {
      f.a(localFile, false);
    }
    n.a(paramContext).c(0, 5);
    n.a(paramContext).c(-1);
    QbSdk.a(paramContext, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    AppMethodBeat.o(192661);
  }
  
  /* Error */
  static q a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 358
    //   6: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 58	com/tencent/smtt/sdk/q:d	Lcom/tencent/smtt/sdk/q;
    //   12: ifnonnull +25 -> 37
    //   15: ldc 2
    //   17: monitorenter
    //   18: getstatic 58	com/tencent/smtt/sdk/q:d	Lcom/tencent/smtt/sdk/q;
    //   21: ifnonnull +13 -> 34
    //   24: new 2	com/tencent/smtt/sdk/q
    //   27: dup
    //   28: invokespecial 359	com/tencent/smtt/sdk/q:<init>	()V
    //   31: putstatic 58	com/tencent/smtt/sdk/q:d	Lcom/tencent/smtt/sdk/q;
    //   34: ldc 2
    //   36: monitorexit
    //   37: getstatic 58	com/tencent/smtt/sdk/q:d	Lcom/tencent/smtt/sdk/q;
    //   40: astore_0
    //   41: ldc_w 358
    //   44: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: ldc_w 358
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
    //   40	11	0	localq	q
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
    //   0: ldc_w 365
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 293	java/io/File
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 366	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 370	java/io/File:delete	()Z
    //   17: pop
    //   18: ldc 151
    //   20: new 233	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 372
    //   27: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_2
    //   31: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 374
    //   37: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: iconst_1
    //   44: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   47: new 293	java/io/File
    //   50: dup
    //   51: aload_3
    //   52: invokestatic 380	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   55: ldc_w 382
    //   58: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 388	java/io/File:canRead	()Z
    //   66: ifeq +181 -> 247
    //   69: new 293	java/io/File
    //   72: dup
    //   73: aload_2
    //   74: ldc_w 390
    //   77: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   80: astore_2
    //   81: new 392	java/util/Properties
    //   84: dup
    //   85: invokespecial 393	java/util/Properties:<init>	()V
    //   88: astore 4
    //   90: new 395	java/io/BufferedInputStream
    //   93: dup
    //   94: new 397	java/io/FileInputStream
    //   97: dup
    //   98: aload_2
    //   99: invokespecial 400	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   102: invokespecial 403	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   105: astore_3
    //   106: aload 4
    //   108: aload_3
    //   109: invokevirtual 406	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   112: new 408	java/io/BufferedOutputStream
    //   115: dup
    //   116: new 410	java/io/FileOutputStream
    //   119: dup
    //   120: aload_2
    //   121: invokespecial 411	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   124: invokespecial 414	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   127: astore_2
    //   128: aload 4
    //   130: ldc_w 416
    //   133: ldc_w 418
    //   136: invokevirtual 422	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   139: pop
    //   140: aload 4
    //   142: aload_2
    //   143: aconst_null
    //   144: invokevirtual 426	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   147: ldc 151
    //   149: ldc_w 428
    //   152: iconst_1
    //   153: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   156: aload_2
    //   157: invokevirtual 431	java/io/BufferedOutputStream:close	()V
    //   160: aload_3
    //   161: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   164: ldc_w 365
    //   167: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: astore_2
    //   172: ldc_w 365
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
    //   189: invokevirtual 431	java/io/BufferedOutputStream:close	()V
    //   192: aload_3
    //   193: ifnull +54 -> 247
    //   196: aload_3
    //   197: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   200: ldc_w 365
    //   203: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: return
    //   207: astore_2
    //   208: ldc_w 365
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
    //   226: invokevirtual 431	java/io/BufferedOutputStream:close	()V
    //   229: aload 4
    //   231: ifnull +8 -> 239
    //   234: aload 4
    //   236: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   239: ldc_w 365
    //   242: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aload_2
    //   246: athrow
    //   247: ldc_w 365
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
    //   0	311	0	this	q
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
    AppMethodBeat.i(192606);
    if (!w(paramContext))
    {
      if (a(paramContext, "core_unzip_tmp"))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
        TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
        AppMethodBeat.o(192606);
        return;
      }
      if (a(paramContext, "core_share_backup_tmp"))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
        TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
        AppMethodBeat.o(192606);
        return;
      }
      if (a(paramContext, "core_copy_tmp"))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
        TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
      }
    }
    AppMethodBeat.o(192606);
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private void a(Context paramContext1, Context paramContext2, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 472
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   10: sipush -524
    //   13: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   16: aload_0
    //   17: aload_2
    //   18: invokevirtual 477	com/tencent/smtt/sdk/q:d	(Landroid/content/Context;)Z
    //   21: ifeq +10 -> 31
    //   24: ldc_w 472
    //   27: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: return
    //   31: ldc 151
    //   33: ldc_w 479
    //   36: iload_3
    //   37: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   40: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   43: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: getstatic 487	android/os/Build$VERSION:SDK_INT	I
    //   49: bipush 11
    //   51: if_icmplt +73 -> 124
    //   54: aload_2
    //   55: ldc_w 489
    //   58: iconst_4
    //   59: invokevirtual 493	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   62: astore 15
    //   64: aload 15
    //   66: ldc_w 495
    //   69: iconst_m1
    //   70: invokeinterface 208 3 0
    //   75: iload_3
    //   76: if_icmpne +61 -> 137
    //   79: ldc 151
    //   81: new 233	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 497
    //   88: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: iload_3
    //   92: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: ldc_w 499
    //   98: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_1
    //   108: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   111: sipush -525
    //   114: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   117: ldc_w 472
    //   120: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: return
    //   124: aload_2
    //   125: ldc_w 489
    //   128: iconst_0
    //   129: invokevirtual 493	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   132: astore 15
    //   134: goto -70 -> 64
    //   137: aload_0
    //   138: aload_2
    //   139: invokevirtual 502	com/tencent/smtt/sdk/q:u	(Landroid/content/Context;)Z
    //   142: ifne +20 -> 162
    //   145: aload_1
    //   146: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   149: sipush -526
    //   152: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   155: ldc_w 472
    //   158: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: return
    //   162: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   165: invokeinterface 507 1 0
    //   170: istore 8
    //   172: ldc 151
    //   174: ldc_w 509
    //   177: iload 8
    //   179: invokestatic 304	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   182: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   185: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: iload 8
    //   190: ifeq +1813 -> 2003
    //   193: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   196: invokevirtual 512	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   199: aconst_null
    //   200: astore 16
    //   202: aload_2
    //   203: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   206: ldc_w 514
    //   209: invokevirtual 517	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   212: istore 4
    //   214: aload_2
    //   215: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   218: ldc_w 519
    //   221: invokevirtual 521	com/tencent/smtt/sdk/n:b	(Ljava/lang/String;)I
    //   224: istore 5
    //   226: iload 4
    //   228: iload_3
    //   229: if_icmpne +49 -> 278
    //   232: getstatic 524	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   235: sipush 220
    //   238: invokeinterface 529 2 0
    //   243: aload_1
    //   244: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   247: sipush -528
    //   250: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   253: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   256: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   259: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   262: invokeinterface 533 1 0
    //   267: aload_0
    //   268: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   271: ldc_w 472
    //   274: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: return
    //   278: aload_0
    //   279: aload_2
    //   280: invokevirtual 216	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;)I
    //   283: istore 6
    //   285: ldc 151
    //   287: ldc_w 537
    //   290: iload 6
    //   292: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   295: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   298: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: iload 6
    //   303: iload_3
    //   304: if_icmpne +65 -> 369
    //   307: getstatic 524	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   310: sipush 220
    //   313: invokeinterface 529 2 0
    //   318: aload_1
    //   319: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   322: sipush -528
    //   325: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   328: ldc 151
    //   330: ldc_w 539
    //   333: iload 6
    //   335: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   338: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   341: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   347: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   350: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   353: invokeinterface 533 1 0
    //   358: aload_0
    //   359: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   362: ldc_w 472
    //   365: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: return
    //   369: aload_2
    //   370: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   373: invokevirtual 542	com/tencent/smtt/sdk/n:b	()I
    //   376: istore 7
    //   378: iload 7
    //   380: ifle +1690 -> 2070
    //   383: iload_3
    //   384: iload 7
    //   386: if_icmpgt +6 -> 392
    //   389: goto +1681 -> 2070
    //   392: aload_0
    //   393: aload_2
    //   394: invokevirtual 544	com/tencent/smtt/sdk/q:p	(Landroid/content/Context;)V
    //   397: goto +1687 -> 2084
    //   400: iconst_m1
    //   401: istore 4
    //   403: aload_0
    //   404: aload_2
    //   405: invokevirtual 544	com/tencent/smtt/sdk/q:p	(Landroid/content/Context;)V
    //   408: ldc 151
    //   410: ldc_w 546
    //   413: iconst_1
    //   414: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   417: aload_2
    //   418: invokestatic 548	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   421: ifne +91 -> 512
    //   424: invokestatic 553	com/tencent/smtt/utils/q:a	()J
    //   427: lstore 11
    //   429: aload_2
    //   430: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   433: invokevirtual 556	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   436: lstore 13
    //   438: aload_1
    //   439: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   442: sipush -529
    //   445: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   448: aload_2
    //   449: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   452: sipush 210
    //   455: new 233	java/lang/StringBuilder
    //   458: dup
    //   459: ldc_w 558
    //   462: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   465: lload 11
    //   467: invokevirtual 561	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   470: ldc_w 563
    //   473: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: lload 13
    //   478: invokevirtual 561	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   481: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   487: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   490: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   493: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   496: invokeinterface 533 1 0
    //   501: aload_0
    //   502: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   505: ldc_w 472
    //   508: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: return
    //   512: iload 4
    //   514: ifle +77 -> 591
    //   517: aload_2
    //   518: invokestatic 190	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   521: ifne +19 -> 540
    //   524: aload_2
    //   525: invokestatic 567	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   528: ifeq +12 -> 540
    //   531: iload_3
    //   532: aload_0
    //   533: aload_2
    //   534: invokevirtual 214	com/tencent/smtt/sdk/q:i	(Landroid/content/Context;)I
    //   537: if_icmpne +54 -> 591
    //   540: ldc 151
    //   542: new 233	java/lang/StringBuilder
    //   545: dup
    //   546: ldc_w 569
    //   549: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   552: aload_0
    //   553: aload_2
    //   554: invokevirtual 214	com/tencent/smtt/sdk/q:i	(Landroid/content/Context;)I
    //   557: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   566: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   569: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   572: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   575: invokeinterface 533 1 0
    //   580: aload_0
    //   581: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   584: ldc_w 472
    //   587: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   590: return
    //   591: iload 4
    //   593: ifne +83 -> 676
    //   596: aload_2
    //   597: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   600: ldc_w 571
    //   603: invokevirtual 517	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   606: istore 4
    //   608: iload 4
    //   610: iconst_2
    //   611: if_icmple +51 -> 662
    //   614: aload_2
    //   615: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   618: sipush 211
    //   621: ldc_w 573
    //   624: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   627: aload_1
    //   628: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   631: sipush -530
    //   634: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   637: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   640: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   643: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   646: invokeinterface 533 1 0
    //   651: aload_0
    //   652: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   655: ldc_w 472
    //   658: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   661: return
    //   662: aload_2
    //   663: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   666: ldc_w 571
    //   669: iload 4
    //   671: iconst_1
    //   672: iadd
    //   673: invokevirtual 187	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   676: aload_0
    //   677: aload_1
    //   678: invokevirtual 272	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   681: astore 17
    //   683: aload_2
    //   684: invokestatic 190	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   687: ifne +218 -> 905
    //   690: aload_2
    //   691: invokestatic 567	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   694: ifeq +196 -> 890
    //   697: aload_0
    //   698: aload_2
    //   699: invokevirtual 576	com/tencent/smtt/sdk/q:q	(Landroid/content/Context;)Ljava/io/File;
    //   702: astore 15
    //   704: aload 15
    //   706: astore 16
    //   708: aload 17
    //   710: ifnull +1192 -> 1902
    //   713: aload 16
    //   715: ifnull +1187 -> 1902
    //   718: aload_2
    //   719: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   722: iload_3
    //   723: iconst_0
    //   724: invokevirtual 182	com/tencent/smtt/sdk/n:a	(II)V
    //   727: new 578	com/tencent/smtt/utils/p
    //   730: dup
    //   731: invokespecial 579	com/tencent/smtt/utils/p:<init>	()V
    //   734: astore 15
    //   736: aload 15
    //   738: aload 17
    //   740: invokevirtual 581	com/tencent/smtt/utils/p:a	(Ljava/io/File;)V
    //   743: invokestatic 586	java/lang/System:currentTimeMillis	()J
    //   746: lstore 11
    //   748: aload_1
    //   749: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   752: sipush -551
    //   755: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   758: aload 17
    //   760: aload 16
    //   762: getstatic 117	com/tencent/smtt/sdk/q:c	Ljava/io/FileFilter;
    //   765: invokestatic 589	com/tencent/smtt/utils/f:a	(Ljava/io/File;Ljava/io/File;Ljava/io/FileFilter;)Z
    //   768: istore 8
    //   770: aload_2
    //   771: invokestatic 567	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   774: ifeq +7 -> 781
    //   777: aload_2
    //   778: invokestatic 591	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   781: ldc 151
    //   783: new 233	java/lang/StringBuilder
    //   786: dup
    //   787: ldc_w 593
    //   790: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   793: invokestatic 586	java/lang/System:currentTimeMillis	()J
    //   796: lload 11
    //   798: lsub
    //   799: invokevirtual 561	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   802: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   808: iload 8
    //   810: ifeq +1043 -> 1853
    //   813: aload 15
    //   815: aload 17
    //   817: invokevirtual 595	com/tencent/smtt/utils/p:b	(Ljava/io/File;)V
    //   820: aload 15
    //   822: invokevirtual 597	com/tencent/smtt/utils/p:a	()Z
    //   825: ifne +95 -> 920
    //   828: ldc 151
    //   830: ldc_w 599
    //   833: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   836: aload 16
    //   838: iconst_1
    //   839: invokestatic 277	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   842: aload_2
    //   843: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   846: sipush 213
    //   849: ldc_w 601
    //   852: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   855: aload_1
    //   856: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   859: sipush -531
    //   862: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   865: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   868: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   871: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   874: invokeinterface 533 1 0
    //   879: aload_0
    //   880: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   883: ldc_w 472
    //   886: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   889: return
    //   890: aload_0
    //   891: aload_2
    //   892: iconst_1
    //   893: invokevirtual 284	com/tencent/smtt/sdk/q:f	(Landroid/content/Context;I)Ljava/io/File;
    //   896: astore 15
    //   898: aload 15
    //   900: astore 16
    //   902: goto -194 -> 708
    //   905: aload_0
    //   906: aload_2
    //   907: iconst_1
    //   908: invokevirtual 284	com/tencent/smtt/sdk/q:f	(Landroid/content/Context;I)Ljava/io/File;
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
    //   935: new 293	java/io/File
    //   938: dup
    //   939: aload 16
    //   941: ldc_w 603
    //   944: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   947: astore 17
    //   949: new 392	java/util/Properties
    //   952: dup
    //   953: invokespecial 393	java/util/Properties:<init>	()V
    //   956: astore 15
    //   958: aload 17
    //   960: invokevirtual 606	java/io/File:exists	()Z
    //   963: ifeq +222 -> 1185
    //   966: new 395	java/io/BufferedInputStream
    //   969: dup
    //   970: new 397	java/io/FileInputStream
    //   973: dup
    //   974: aload 17
    //   976: invokespecial 400	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   979: invokespecial 403	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   982: astore 17
    //   984: aload 15
    //   986: aload 17
    //   988: invokevirtual 406	java/util/Properties:load	(Ljava/io/InputStream;)V
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
    //   1014: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   1017: ldc 151
    //   1019: ldc_w 608
    //   1022: iload 8
    //   1024: invokestatic 304	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1027: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1030: invokestatic 610	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1033: iload 8
    //   1035: ifeq +1018 -> 2053
    //   1038: aload 16
    //   1040: invokevirtual 614	java/io/File:listFiles	()[Ljava/io/File;
    //   1043: astore 17
    //   1045: aload_1
    //   1046: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1049: sipush -552
    //   1052: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
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
    //   1080: ldc_w 603
    //   1083: aload 18
    //   1085: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   1088: invokevirtual 330	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1091: ifne +53 -> 1144
    //   1094: aload 18
    //   1096: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   1099: ldc_w 619
    //   1102: invokevirtual 623	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1105: ifne +39 -> 1144
    //   1108: ldc_w 390
    //   1111: aload 18
    //   1113: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   1116: invokevirtual 330	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1119: ifne +25 -> 1144
    //   1122: aload 18
    //   1124: invokevirtual 626	java/io/File:isDirectory	()Z
    //   1127: ifne +17 -> 1144
    //   1130: aload 18
    //   1132: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   1135: ldc_w 628
    //   1138: invokevirtual 623	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1141: ifeq +181 -> 1322
    //   1144: ldc 151
    //   1146: new 233	java/lang/StringBuilder
    //   1149: dup
    //   1150: ldc_w 630
    //   1153: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1156: aload 18
    //   1158: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   1161: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: ldc_w 632
    //   1167: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1173: invokestatic 610	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1219: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   1222: goto -205 -> 1017
    //   1225: astore 17
    //   1227: goto -210 -> 1017
    //   1230: astore 15
    //   1232: aload 19
    //   1234: astore 17
    //   1236: aload 17
    //   1238: ifnull +8 -> 1246
    //   1241: aload 17
    //   1243: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   1246: ldc_w 472
    //   1249: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1252: aload 15
    //   1254: athrow
    //   1255: astore 15
    //   1257: aload_2
    //   1258: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1261: sipush 215
    //   1264: aload 15
    //   1266: invokevirtual 261	java/lang/Exception:toString	()Ljava/lang/String;
    //   1269: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1272: aload_1
    //   1273: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1276: sipush -537
    //   1279: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1282: aload 16
    //   1284: iconst_0
    //   1285: invokestatic 277	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   1288: aload_2
    //   1289: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1292: iconst_0
    //   1293: iconst_m1
    //   1294: invokevirtual 182	com/tencent/smtt/sdk/n:a	(II)V
    //   1297: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1300: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1303: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1306: invokeinterface 533 1 0
    //   1311: aload_0
    //   1312: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1315: ldc_w 472
    //   1318: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1321: return
    //   1322: aload 18
    //   1324: invokestatic 637	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   1327: astore 19
    //   1329: aload 15
    //   1331: aload 18
    //   1333: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   1336: ldc_w 639
    //   1339: invokevirtual 643	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1342: astore 20
    //   1344: aload 20
    //   1346: ldc_w 639
    //   1349: invokevirtual 330	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1352: ifne +51 -> 1403
    //   1355: aload 19
    //   1357: aload 20
    //   1359: invokevirtual 330	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1362: ifeq +41 -> 1403
    //   1365: ldc 151
    //   1367: new 233	java/lang/StringBuilder
    //   1370: dup
    //   1371: ldc_w 645
    //   1374: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1377: aload 18
    //   1379: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   1382: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: ldc_w 647
    //   1388: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1394: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1397: iconst_1
    //   1398: istore 9
    //   1400: goto -224 -> 1176
    //   1403: iconst_0
    //   1404: istore 10
    //   1406: ldc 151
    //   1408: new 233	java/lang/StringBuilder
    //   1411: dup
    //   1412: ldc_w 649
    //   1415: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1418: aload 18
    //   1420: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   1423: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: ldc_w 651
    //   1429: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: aload 20
    //   1434: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: ldc_w 653
    //   1440: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1443: aload 19
    //   1445: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1451: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1454: ldc 151
    //   1456: ldc_w 655
    //   1459: iload 10
    //   1461: invokestatic 304	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1464: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1467: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1470: iload 8
    //   1472: ifeq +70 -> 1542
    //   1475: iload 10
    //   1477: ifne +65 -> 1542
    //   1480: ldc 151
    //   1482: ldc_w 657
    //   1485: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1488: aload 16
    //   1490: iconst_1
    //   1491: invokestatic 277	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   1494: aload_2
    //   1495: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1498: sipush 213
    //   1501: ldc_w 659
    //   1504: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1507: aload_1
    //   1508: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1511: sipush -532
    //   1514: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1517: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1520: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1523: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1526: invokeinterface 533 1 0
    //   1531: aload_0
    //   1532: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1535: ldc_w 472
    //   1538: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1541: return
    //   1542: ldc 151
    //   1544: ldc_w 661
    //   1547: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1550: aload_0
    //   1551: aload_2
    //   1552: iconst_1
    //   1553: invokespecial 335	com/tencent/smtt/sdk/q:g	(Landroid/content/Context;Z)V
    //   1556: aload_1
    //   1557: invokestatic 665	com/tencent/smtt/sdk/m:b	(Landroid/content/Context;)Ljava/io/File;
    //   1560: astore 17
    //   1562: aload 17
    //   1564: ifnull +38 -> 1602
    //   1567: aload 17
    //   1569: invokevirtual 606	java/io/File:exists	()Z
    //   1572: ifeq +30 -> 1602
    //   1575: aload_2
    //   1576: invokestatic 668	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1579: ifeq +178 -> 1757
    //   1582: ldc_w 670
    //   1585: astore 15
    //   1587: new 293	java/io/File
    //   1590: dup
    //   1591: aload 17
    //   1593: aload 15
    //   1595: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1598: aload_2
    //   1599: invokestatic 673	com/tencent/smtt/sdk/m:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1602: aload_2
    //   1603: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1606: iload_3
    //   1607: iconst_1
    //   1608: invokevirtual 182	com/tencent/smtt/sdk/n:a	(II)V
    //   1611: aload_0
    //   1612: getfield 132	com/tencent/smtt/sdk/q:k	Z
    //   1615: ifeq +151 -> 1766
    //   1618: aload_2
    //   1619: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1622: sipush 220
    //   1625: ldc_w 675
    //   1628: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1631: aload_1
    //   1632: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1635: sipush -533
    //   1638: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1641: ldc 151
    //   1643: ldc_w 677
    //   1646: iload_3
    //   1647: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1650: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1653: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1656: getstatic 487	android/os/Build$VERSION:SDK_INT	I
    //   1659: bipush 11
    //   1661: if_icmplt +148 -> 1809
    //   1664: aload_2
    //   1665: ldc_w 489
    //   1668: iconst_4
    //   1669: invokevirtual 493	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1672: astore 15
    //   1674: aload 15
    //   1676: invokeinterface 681 1 0
    //   1681: astore 15
    //   1683: aload 15
    //   1685: ldc_w 683
    //   1688: iconst_0
    //   1689: invokeinterface 689 3 0
    //   1694: pop
    //   1695: aload 15
    //   1697: ldc_w 691
    //   1700: iconst_0
    //   1701: invokeinterface 689 3 0
    //   1706: pop
    //   1707: aload 15
    //   1709: ldc_w 693
    //   1712: iload_3
    //   1713: invokeinterface 689 3 0
    //   1718: pop
    //   1719: aload 15
    //   1721: invokeinterface 696 1 0
    //   1726: pop
    //   1727: aload_2
    //   1728: invokestatic 697	com/tencent/smtt/utils/q:a	(Landroid/content/Context;)Z
    //   1731: pop
    //   1732: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1735: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1738: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1741: invokeinterface 533 1 0
    //   1746: aload_0
    //   1747: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1750: ldc_w 472
    //   1753: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1756: return
    //   1757: iconst_0
    //   1758: invokestatic 700	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   1761: astore 15
    //   1763: goto -176 -> 1587
    //   1766: aload_2
    //   1767: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1770: sipush 220
    //   1773: ldc_w 702
    //   1776: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1779: goto -148 -> 1631
    //   1782: astore_1
    //   1783: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1786: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1789: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1792: invokeinterface 533 1 0
    //   1797: aload_0
    //   1798: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1801: ldc_w 472
    //   1804: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1807: aload_1
    //   1808: athrow
    //   1809: aload_2
    //   1810: ldc_w 489
    //   1813: iconst_0
    //   1814: invokevirtual 493	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1817: astore 15
    //   1819: goto -145 -> 1674
    //   1822: astore 15
    //   1824: ldc 151
    //   1826: new 233	java/lang/StringBuilder
    //   1829: dup
    //   1830: ldc_w 704
    //   1833: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1836: aload 15
    //   1838: invokestatic 710	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1841: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1847: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1850: goto -123 -> 1727
    //   1853: ldc 151
    //   1855: ldc_w 712
    //   1858: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1861: aload_2
    //   1862: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1865: iload_3
    //   1866: iconst_2
    //   1867: invokevirtual 182	com/tencent/smtt/sdk/n:a	(II)V
    //   1870: aload 16
    //   1872: iconst_0
    //   1873: invokestatic 277	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   1876: aload_1
    //   1877: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1880: sipush -534
    //   1883: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1886: aload_2
    //   1887: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1890: sipush 212
    //   1893: ldc_w 714
    //   1896: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1899: goto -167 -> 1732
    //   1902: aload 17
    //   1904: ifnonnull +26 -> 1930
    //   1907: aload_2
    //   1908: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1911: sipush 213
    //   1914: ldc_w 716
    //   1917: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1920: aload_1
    //   1921: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1924: sipush -535
    //   1927: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1930: aload 16
    //   1932: ifnonnull -200 -> 1732
    //   1935: aload_2
    //   1936: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1939: sipush 214
    //   1942: ldc_w 718
    //   1945: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1948: aload_1
    //   1949: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1952: sipush -536
    //   1955: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1958: goto -226 -> 1732
    //   1961: astore_1
    //   1962: ldc 151
    //   1964: new 233	java/lang/StringBuilder
    //   1967: dup
    //   1968: ldc_w 720
    //   1971: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1974: aload_1
    //   1975: invokevirtual 723	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1978: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1981: ldc_w 725
    //   1984: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1987: aload_1
    //   1988: invokevirtual 729	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   1991: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1994: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1997: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2000: goto -703 -> 1297
    //   2003: aload_0
    //   2004: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   2007: aload_1
    //   2008: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2011: sipush -538
    //   2014: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2017: ldc_w 472
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
    //   2114: ldc_w 730
    //   2117: if_icmpne -1700 -> 417
    //   2120: goto -1720 -> 400
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2123	0	this	q
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
    AppMethodBeat.i(192631);
    boolean bool = a(paramContext, paramFile, false);
    AppMethodBeat.o(192631);
    return bool;
  }
  
  /* Error */
  private boolean a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: ldc_w 746
    //   6: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 151
    //   11: ldc_w 748
    //   14: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_2
    //   18: invokestatic 750	com/tencent/smtt/utils/f:c	(Ljava/io/File;)Z
    //   21: ifne +34 -> 55
    //   24: aload_1
    //   25: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   28: sipush 204
    //   31: ldc_w 752
    //   34: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   37: aload_1
    //   38: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   41: sipush -520
    //   44: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   47: ldc_w 746
    //   50: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: iconst_0
    //   54: ireturn
    //   55: aload_1
    //   56: invokestatic 380	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   59: astore 8
    //   61: iload_3
    //   62: ifeq +85 -> 147
    //   65: new 293	java/io/File
    //   68: dup
    //   69: aload 8
    //   71: ldc_w 754
    //   74: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   77: astore 8
    //   79: aload 8
    //   81: invokevirtual 606	java/io/File:exists	()Z
    //   84: ifeq +15 -> 99
    //   87: aload_1
    //   88: invokestatic 567	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   91: ifne +8 -> 99
    //   94: aload 8
    //   96: invokestatic 755	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   99: iload_3
    //   100: ifeq +95 -> 195
    //   103: aload_0
    //   104: aload_1
    //   105: iconst_2
    //   106: invokevirtual 284	com/tencent/smtt/sdk/q:f	(Landroid/content/Context;I)Ljava/io/File;
    //   109: astore 8
    //   111: aload 8
    //   113: ifnonnull +93 -> 206
    //   116: aload_1
    //   117: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   120: sipush 205
    //   123: ldc_w 757
    //   126: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   129: aload_1
    //   130: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   133: sipush -521
    //   136: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   139: ldc_w 746
    //   142: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: iconst_0
    //   146: ireturn
    //   147: new 293	java/io/File
    //   150: dup
    //   151: aload 8
    //   153: ldc_w 382
    //   156: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   159: astore 8
    //   161: goto -82 -> 79
    //   164: astore 8
    //   166: ldc 151
    //   168: new 233	java/lang/StringBuilder
    //   171: dup
    //   172: ldc_w 759
    //   175: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: aload 8
    //   180: invokestatic 710	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   183: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: goto -93 -> 99
    //   195: aload_0
    //   196: aload_1
    //   197: iconst_0
    //   198: invokevirtual 284	com/tencent/smtt/sdk/q:f	(Landroid/content/Context;I)Ljava/io/File;
    //   201: astore 8
    //   203: goto -92 -> 111
    //   206: aload 8
    //   208: invokestatic 761	com/tencent/smtt/utils/f:a	(Ljava/io/File;)Z
    //   211: pop
    //   212: iload_3
    //   213: ifeq +9 -> 222
    //   216: aload 8
    //   218: iconst_1
    //   219: invokestatic 277	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   222: aload_2
    //   223: aload 8
    //   225: invokestatic 764	com/tencent/smtt/utils/f:a	(Ljava/io/File;Ljava/io/File;)Z
    //   228: istore 7
    //   230: iload 7
    //   232: istore 6
    //   234: iload 7
    //   236: ifeq +12 -> 248
    //   239: aload_0
    //   240: aload 8
    //   242: aload_1
    //   243: invokespecial 767	com/tencent/smtt/sdk/q:a	(Ljava/io/File;Landroid/content/Context;)Z
    //   246: istore 6
    //   248: iload_3
    //   249: ifeq +81 -> 330
    //   252: aload 8
    //   254: invokevirtual 771	java/io/File:list	()[Ljava/lang/String;
    //   257: astore_2
    //   258: iconst_0
    //   259: istore 4
    //   261: iload 4
    //   263: aload_2
    //   264: arraylength
    //   265: if_icmpge +47 -> 312
    //   268: new 293	java/io/File
    //   271: dup
    //   272: aload 8
    //   274: aload_2
    //   275: iload 4
    //   277: aaload
    //   278: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   281: astore 9
    //   283: aload 9
    //   285: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   288: ldc_w 619
    //   291: invokevirtual 623	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   294: ifeq +9 -> 303
    //   297: aload 9
    //   299: invokevirtual 370	java/io/File:delete	()Z
    //   302: pop
    //   303: iload 4
    //   305: iconst_1
    //   306: iadd
    //   307: istore 4
    //   309: goto -48 -> 261
    //   312: new 293	java/io/File
    //   315: dup
    //   316: aload_1
    //   317: invokestatic 774	com/tencent/smtt/sdk/q:t	(Landroid/content/Context;)Ljava/io/File;
    //   320: ldc_w 776
    //   323: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   326: invokevirtual 370	java/io/File:delete	()Z
    //   329: pop
    //   330: iload 6
    //   332: ifne +61 -> 393
    //   335: aload 8
    //   337: invokestatic 755	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   340: aload_1
    //   341: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   344: sipush -522
    //   347: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   350: ldc 151
    //   352: new 233	java/lang/StringBuilder
    //   355: dup
    //   356: ldc_w 778
    //   359: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   362: aload 8
    //   364: invokevirtual 606	java/io/File:exists	()Z
    //   367: invokevirtual 781	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   370: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: ldc 151
    //   378: ldc_w 783
    //   381: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   384: ldc_w 746
    //   387: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   390: iload 6
    //   392: ireturn
    //   393: aload_0
    //   394: aload_1
    //   395: iconst_1
    //   396: invokespecial 335	com/tencent/smtt/sdk/q:g	(Landroid/content/Context;Z)V
    //   399: iload_3
    //   400: ifeq -24 -> 376
    //   403: aload_0
    //   404: aload_1
    //   405: invokevirtual 576	com/tencent/smtt/sdk/q:q	(Landroid/content/Context;)Ljava/io/File;
    //   408: astore_2
    //   409: aload_2
    //   410: iconst_1
    //   411: invokestatic 277	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   414: aload 8
    //   416: aload_2
    //   417: invokevirtual 297	java/io/File:renameTo	(Ljava/io/File;)Z
    //   420: pop
    //   421: aload_1
    //   422: invokestatic 591	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   425: goto -49 -> 376
    //   428: astore_2
    //   429: aload_1
    //   430: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   433: sipush -523
    //   436: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   439: aload_1
    //   440: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   443: sipush 206
    //   446: aload_2
    //   447: invokevirtual 786	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   450: aload 8
    //   452: ifnull +256 -> 708
    //   455: aload 8
    //   457: invokevirtual 606	java/io/File:exists	()Z
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
    //   481: invokestatic 755	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   484: ldc 151
    //   486: new 233	java/lang/StringBuilder
    //   489: dup
    //   490: ldc_w 788
    //   493: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   496: aload 8
    //   498: invokevirtual 606	java/io/File:exists	()Z
    //   501: invokevirtual 781	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   504: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: ldc 151
    //   512: ldc_w 783
    //   515: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   518: ldc_w 746
    //   521: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   524: iconst_0
    //   525: ireturn
    //   526: astore_1
    //   527: ldc 151
    //   529: new 233	java/lang/StringBuilder
    //   532: dup
    //   533: ldc_w 790
    //   536: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   539: aload_1
    //   540: invokestatic 710	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   543: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: goto -42 -> 510
    //   555: astore_2
    //   556: aload_1
    //   557: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   560: sipush -523
    //   563: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   566: aload_1
    //   567: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   570: sipush 207
    //   573: aload_2
    //   574: invokevirtual 786	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   577: aload 8
    //   579: ifnull +123 -> 702
    //   582: aload 8
    //   584: invokevirtual 606	java/io/File:exists	()Z
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
    //   607: invokestatic 755	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   610: ldc 151
    //   612: new 233	java/lang/StringBuilder
    //   615: dup
    //   616: ldc_w 788
    //   619: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   622: aload 8
    //   624: invokevirtual 606	java/io/File:exists	()Z
    //   627: invokevirtual 781	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   630: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: ldc 151
    //   638: ldc_w 783
    //   641: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: ldc_w 746
    //   647: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   650: iconst_0
    //   651: ireturn
    //   652: astore_1
    //   653: ldc 151
    //   655: new 233	java/lang/StringBuilder
    //   658: dup
    //   659: ldc_w 790
    //   662: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   665: aload_1
    //   666: invokestatic 710	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   669: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   678: goto -42 -> 636
    //   681: astore_1
    //   682: ldc 151
    //   684: ldc_w 783
    //   687: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   690: ldc_w 746
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
    //   0	714	0	this	q
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
    AppMethodBeat.i(192609);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), paramString);
    if (!paramContext.exists())
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #1");
      AppMethodBeat.o(192609);
      return false;
    }
    if (!new File(paramContext, "tbs.conf").exists())
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #2");
      AppMethodBeat.o(192609);
      return false;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #3");
    AppMethodBeat.o(192609);
    return true;
  }
  
  /* Error */
  private boolean a(File paramFile, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc_w 798
    //   6: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 151
    //   11: new 233	java/lang/StringBuilder
    //   14: dup
    //   15: ldc_w 800
    //   18: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: aload_1
    //   22: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc_w 802
    //   28: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_2
    //   32: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: new 293	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: ldc_w 603
    //   49: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   52: astore_2
    //   53: new 392	java/util/Properties
    //   56: dup
    //   57: invokespecial 393	java/util/Properties:<init>	()V
    //   60: astore 6
    //   62: aload_2
    //   63: invokevirtual 606	java/io/File:exists	()Z
    //   66: ifeq +197 -> 263
    //   69: new 395	java/io/BufferedInputStream
    //   72: dup
    //   73: new 397	java/io/FileInputStream
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 400	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 403	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore_2
    //   85: aload 6
    //   87: aload_2
    //   88: invokevirtual 406	java/util/Properties:load	(Ljava/io/InputStream;)V
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
    //   111: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   114: iload 5
    //   116: istore 4
    //   118: aload 6
    //   120: astore_2
    //   121: ldc 151
    //   123: ldc_w 804
    //   126: iload 4
    //   128: invokestatic 304	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   131: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   134: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: iload 4
    //   139: ifeq +417 -> 556
    //   142: aload_1
    //   143: invokevirtual 614	java/io/File:listFiles	()[Ljava/io/File;
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
    //   160: ldc_w 603
    //   163: aload 6
    //   165: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   168: invokevirtual 330	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifne +53 -> 224
    //   174: aload 6
    //   176: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   179: ldc_w 619
    //   182: invokevirtual 623	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   185: ifne +39 -> 224
    //   188: ldc_w 390
    //   191: aload 6
    //   193: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   196: invokevirtual 330	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifne +25 -> 224
    //   202: aload 6
    //   204: invokevirtual 626	java/io/File:isDirectory	()Z
    //   207: ifne +17 -> 224
    //   210: aload 6
    //   212: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   215: ldc_w 628
    //   218: invokevirtual 623	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   221: ifeq +101 -> 322
    //   224: ldc 151
    //   226: new 233	java/lang/StringBuilder
    //   229: dup
    //   230: ldc_w 630
    //   233: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   236: aload 6
    //   238: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   241: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 632
    //   247: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 610	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   285: invokevirtual 432	java/io/BufferedInputStream:close	()V
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
    //   311: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   314: ldc_w 798
    //   317: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aload_1
    //   321: athrow
    //   322: aload 6
    //   324: invokestatic 637	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   327: astore 7
    //   329: aload_2
    //   330: aload 6
    //   332: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   335: ldc_w 639
    //   338: invokevirtual 643	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   341: astore 8
    //   343: aload 8
    //   345: ldc_w 639
    //   348: invokevirtual 330	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   351: ifne +48 -> 399
    //   354: aload 8
    //   356: aload 7
    //   358: invokevirtual 330	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifeq +38 -> 399
    //   364: ldc 151
    //   366: new 233	java/lang/StringBuilder
    //   369: dup
    //   370: ldc_w 645
    //   373: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   376: aload 6
    //   378: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   381: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc_w 647
    //   387: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: goto -140 -> 256
    //   399: ldc 151
    //   401: new 233	java/lang/StringBuilder
    //   404: dup
    //   405: ldc_w 649
    //   408: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   411: aload 6
    //   413: invokevirtual 617	java/io/File:getName	()Ljava/lang/String;
    //   416: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: ldc_w 651
    //   422: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 8
    //   427: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: ldc_w 653
    //   433: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 7
    //   438: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: iconst_0
    //   448: istore 5
    //   450: ldc 151
    //   452: ldc_w 806
    //   455: iload 5
    //   457: invokestatic 304	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   460: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   463: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: iload 4
    //   468: ifeq +24 -> 492
    //   471: iload 5
    //   473: ifne +19 -> 492
    //   476: ldc 151
    //   478: ldc_w 808
    //   481: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: ldc_w 798
    //   487: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   490: iconst_0
    //   491: ireturn
    //   492: ldc 151
    //   494: ldc_w 810
    //   497: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: ldc_w 798
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
    //   0	568	0	this	q
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
    //   3: ldc_w 811
    //   6: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   13: sipush -501
    //   16: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 477	com/tencent/smtt/sdk/q:d	(Landroid/content/Context;)Z
    //   24: ifeq +29 -> 53
    //   27: ldc 151
    //   29: ldc_w 813
    //   32: iconst_1
    //   33: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   36: aload_1
    //   37: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   40: sipush -502
    //   43: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   46: ldc_w 811
    //   49: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: ldc 151
    //   55: ldc_w 815
    //   58: aload_2
    //   59: invokestatic 818	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   62: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: ldc 151
    //   70: ldc_w 820
    //   73: iload_3
    //   74: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   77: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   80: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: ldc 151
    //   85: new 233	java/lang/StringBuilder
    //   88: dup
    //   89: ldc_w 822
    //   92: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload_1
    //   96: invokevirtual 320	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   99: getfield 825	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   102: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: ldc 151
    //   113: new 233	java/lang/StringBuilder
    //   116: dup
    //   117: ldc_w 827
    //   120: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: invokestatic 832	android/os/Process:myPid	()I
    //   126: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: ldc 151
    //   137: new 233	java/lang/StringBuilder
    //   140: dup
    //   141: ldc_w 834
    //   144: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: invokestatic 840	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   150: invokevirtual 841	java/lang/Thread:getName	()Ljava/lang/String;
    //   153: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: getstatic 487	android/os/Build$VERSION:SDK_INT	I
    //   165: bipush 11
    //   167: if_icmplt +73 -> 240
    //   170: aload_1
    //   171: ldc_w 489
    //   174: iconst_4
    //   175: invokevirtual 493	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   178: astore 14
    //   180: aload 14
    //   182: ldc_w 495
    //   185: iconst_m1
    //   186: invokeinterface 208 3 0
    //   191: iload_3
    //   192: if_icmpne +61 -> 253
    //   195: ldc 151
    //   197: new 233	java/lang/StringBuilder
    //   200: dup
    //   201: ldc_w 843
    //   204: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   207: iload_3
    //   208: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: ldc_w 499
    //   214: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_1
    //   224: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   227: sipush -503
    //   230: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   233: ldc_w 811
    //   236: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: return
    //   240: aload_1
    //   241: ldc_w 489
    //   244: iconst_0
    //   245: invokevirtual 493	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   248: astore 14
    //   250: goto -70 -> 180
    //   253: aload_1
    //   254: invokestatic 548	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   257: ifne +73 -> 330
    //   260: invokestatic 553	com/tencent/smtt/utils/q:a	()J
    //   263: lstore 9
    //   265: aload_1
    //   266: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   269: invokevirtual 556	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   272: lstore 11
    //   274: aload_1
    //   275: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   278: sipush -504
    //   281: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   284: aload_1
    //   285: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   288: sipush 210
    //   291: new 233	java/lang/StringBuilder
    //   294: dup
    //   295: ldc_w 845
    //   298: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   301: lload 9
    //   303: invokevirtual 561	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   306: ldc_w 563
    //   309: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: lload 11
    //   314: invokevirtual 561	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   317: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   323: ldc_w 811
    //   326: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: return
    //   330: aload_0
    //   331: aload_1
    //   332: invokevirtual 502	com/tencent/smtt/sdk/q:u	(Landroid/content/Context;)Z
    //   335: ifne +20 -> 355
    //   338: aload_1
    //   339: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   342: sipush -505
    //   345: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   348: ldc_w 811
    //   351: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: return
    //   355: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   358: invokeinterface 507 1 0
    //   363: istore 13
    //   365: ldc 151
    //   367: ldc_w 847
    //   370: iload 13
    //   372: invokestatic 304	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   375: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   378: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: iload 13
    //   383: ifeq +1878 -> 2261
    //   386: aload_1
    //   387: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   390: sipush -507
    //   393: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   396: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   399: invokevirtual 512	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   402: aload_1
    //   403: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   406: ldc_w 514
    //   409: invokevirtual 517	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   412: istore 4
    //   414: aload_1
    //   415: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   418: invokevirtual 542	com/tencent/smtt/sdk/n:b	()I
    //   421: istore 5
    //   423: ldc 151
    //   425: ldc_w 849
    //   428: iload 4
    //   430: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   433: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   436: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: ldc 151
    //   441: ldc_w 851
    //   444: iload 5
    //   446: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   449: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   452: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: ldc 151
    //   457: ldc_w 853
    //   460: iload_3
    //   461: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   464: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   467: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: iload 5
    //   472: ifle +1877 -> 2349
    //   475: iload_3
    //   476: iload 5
    //   478: if_icmpgt +6 -> 484
    //   481: goto +1868 -> 2349
    //   484: aload_0
    //   485: aload_1
    //   486: invokevirtual 544	com/tencent/smtt/sdk/q:p	(Landroid/content/Context;)V
    //   489: aload_1
    //   490: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   493: invokevirtual 855	com/tencent/smtt/sdk/n:c	()I
    //   496: istore 5
    //   498: aload_0
    //   499: aload_1
    //   500: invokevirtual 216	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;)I
    //   503: istore 6
    //   505: ldc 151
    //   507: ldc_w 857
    //   510: iload 5
    //   512: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   515: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   518: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: ldc 151
    //   523: ldc_w 859
    //   526: iload 6
    //   528: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   531: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   534: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   537: iload 5
    //   539: iflt +156 -> 695
    //   542: iload 5
    //   544: iconst_2
    //   545: if_icmpge +150 -> 695
    //   548: ldc 151
    //   550: ldc_w 861
    //   553: iconst_1
    //   554: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   557: iconst_1
    //   558: istore 4
    //   560: iload 5
    //   562: istore 6
    //   564: iload 4
    //   566: istore 5
    //   568: aload_1
    //   569: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   572: sipush -508
    //   575: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   578: ldc 151
    //   580: ldc_w 863
    //   583: iload 6
    //   585: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   588: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   591: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: iload 6
    //   596: ifgt +1156 -> 1752
    //   599: ldc 151
    //   601: ldc_w 865
    //   604: iconst_1
    //   605: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   608: aload_1
    //   609: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   612: sipush -509
    //   615: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   618: iload 5
    //   620: ifeq +157 -> 777
    //   623: aload_1
    //   624: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   627: ldc_w 867
    //   630: invokevirtual 517	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   633: istore 4
    //   635: iload 4
    //   637: bipush 10
    //   639: if_icmple +127 -> 766
    //   642: aload_1
    //   643: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   646: sipush 201
    //   649: ldc_w 869
    //   652: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   655: aload_0
    //   656: aload_1
    //   657: invokespecial 871	com/tencent/smtt/sdk/q:F	(Landroid/content/Context;)V
    //   660: aload_1
    //   661: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   664: sipush -510
    //   667: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   670: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   673: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   676: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   679: invokeinterface 533 1 0
    //   684: aload_0
    //   685: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   688: ldc_w 811
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
    //   725: ldc_w 730
    //   728: if_icmpne +20 -> 748
    //   731: iconst_m1
    //   732: istore 4
    //   734: aload_0
    //   735: aload_1
    //   736: invokevirtual 544	com/tencent/smtt/sdk/q:p	(Landroid/content/Context;)V
    //   739: ldc 151
    //   741: ldc_w 873
    //   744: iconst_1
    //   745: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   748: iconst_0
    //   749: istore 5
    //   751: iload 4
    //   753: istore 6
    //   755: goto -187 -> 568
    //   758: astore_1
    //   759: ldc_w 811
    //   762: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   765: return
    //   766: aload_1
    //   767: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   770: iload 4
    //   772: iconst_1
    //   773: iadd
    //   774: invokevirtual 875	com/tencent/smtt/sdk/n:b	(I)V
    //   777: aload_2
    //   778: ifnonnull +80 -> 858
    //   781: aload_1
    //   782: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   785: ldc_w 877
    //   788: invokevirtual 879	com/tencent/smtt/sdk/n:d	(Ljava/lang/String;)Ljava/lang/String;
    //   791: astore 15
    //   793: aload 15
    //   795: astore 14
    //   797: aload 15
    //   799: ifnonnull +62 -> 861
    //   802: aload_1
    //   803: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   806: sipush 202
    //   809: ldc_w 881
    //   812: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   815: aload_1
    //   816: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   819: sipush -511
    //   822: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   825: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   828: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   831: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   834: invokeinterface 533 1 0
    //   839: aload_0
    //   840: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   843: ldc_w 811
    //   846: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   849: return
    //   850: astore_1
    //   851: ldc_w 811
    //   854: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   857: return
    //   858: aload_2
    //   859: astore 14
    //   861: ldc 151
    //   863: ldc_w 883
    //   866: aload 14
    //   868: invokestatic 818	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   871: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   874: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   877: aload_0
    //   878: aload_1
    //   879: aload 14
    //   881: invokevirtual 886	com/tencent/smtt/sdk/q:c	(Landroid/content/Context;Ljava/lang/String;)I
    //   884: istore 8
    //   886: iload 8
    //   888: ifne +59 -> 947
    //   891: aload_1
    //   892: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   895: sipush -512
    //   898: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   901: aload_1
    //   902: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   905: sipush 203
    //   908: ldc_w 888
    //   911: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   914: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   917: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   920: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   923: invokeinterface 533 1 0
    //   928: aload_0
    //   929: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   932: ldc_w 811
    //   935: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   938: return
    //   939: astore_1
    //   940: ldc_w 811
    //   943: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   946: return
    //   947: aload_1
    //   948: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   951: ldc_w 877
    //   954: aload 14
    //   956: invokevirtual 890	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   959: aload_1
    //   960: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   963: iload 8
    //   965: iconst_0
    //   966: invokevirtual 348	com/tencent/smtt/sdk/n:c	(II)V
    //   969: aload_1
    //   970: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   973: sipush -548
    //   976: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   979: aload_1
    //   980: invokestatic 567	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   983: ifeq +70 -> 1053
    //   986: aload_0
    //   987: aload_1
    //   988: new 293	java/io/File
    //   991: dup
    //   992: aload 14
    //   994: invokespecial 366	java/io/File:<init>	(Ljava/lang/String;)V
    //   997: iconst_1
    //   998: invokespecial 745	com/tencent/smtt/sdk/q:a	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1001: ifne +115 -> 1116
    //   1004: aload_1
    //   1005: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1008: sipush 207
    //   1011: ldc_w 892
    //   1014: getstatic 898	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_INSTALL_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   1017: invokevirtual 901	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;Lcom/tencent/smtt/sdk/TbsLogReport$EventType;)V
    //   1020: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1023: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1026: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1029: invokeinterface 533 1 0
    //   1034: aload_0
    //   1035: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1038: ldc_w 811
    //   1041: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1044: return
    //   1045: astore_1
    //   1046: ldc_w 811
    //   1049: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1052: return
    //   1053: aload_0
    //   1054: aload_1
    //   1055: new 293	java/io/File
    //   1058: dup
    //   1059: aload 14
    //   1061: invokespecial 366	java/io/File:<init>	(Ljava/lang/String;)V
    //   1064: invokespecial 903	com/tencent/smtt/sdk/q:a	(Landroid/content/Context;Ljava/io/File;)Z
    //   1067: ifne +49 -> 1116
    //   1070: aload_1
    //   1071: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1074: sipush 207
    //   1077: ldc_w 892
    //   1080: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1083: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1086: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1089: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1092: invokeinterface 533 1 0
    //   1097: aload_0
    //   1098: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1101: ldc_w 811
    //   1104: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1107: return
    //   1108: astore_1
    //   1109: ldc_w 811
    //   1112: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1115: return
    //   1116: iload 5
    //   1118: ifeq +142 -> 1260
    //   1121: aload_1
    //   1122: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1125: ldc_w 905
    //   1128: invokevirtual 521	com/tencent/smtt/sdk/n:b	(Ljava/lang/String;)I
    //   1131: istore 4
    //   1133: iload 4
    //   1135: iconst_5
    //   1136: if_icmple +113 -> 1249
    //   1139: aload_1
    //   1140: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1143: sipush 223
    //   1146: ldc_w 907
    //   1149: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1152: aload_1
    //   1153: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1156: sipush -553
    //   1159: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1162: aload_0
    //   1163: aload_1
    //   1164: invokespecial 871	com/tencent/smtt/sdk/q:F	(Landroid/content/Context;)V
    //   1167: aload_1
    //   1168: invokestatic 909	com/tencent/smtt/sdk/m:c	(Landroid/content/Context;)V
    //   1171: aload_1
    //   1172: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1175: getfield 913	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1178: ldc_w 915
    //   1181: getstatic 921	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1184: invokeinterface 927 3 0
    //   1189: pop
    //   1190: aload_1
    //   1191: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1194: getfield 913	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1197: ldc_w 929
    //   1200: getstatic 921	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1203: invokeinterface 927 3 0
    //   1208: pop
    //   1209: aload_1
    //   1210: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1213: invokevirtual 931	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1216: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1219: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1222: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1225: invokeinterface 533 1 0
    //   1230: aload_0
    //   1231: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1234: ldc_w 811
    //   1237: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1240: return
    //   1241: astore_1
    //   1242: ldc_w 811
    //   1245: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1248: return
    //   1249: aload_1
    //   1250: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1253: iload 4
    //   1255: iconst_1
    //   1256: iadd
    //   1257: invokevirtual 933	com/tencent/smtt/sdk/n:d	(I)V
    //   1260: ldc 151
    //   1262: ldc_w 935
    //   1265: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1268: invokestatic 938	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	()Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1271: getfield 200	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1274: ldc_w 940
    //   1277: iconst_0
    //   1278: invokeinterface 208 3 0
    //   1283: istore 4
    //   1285: aload_0
    //   1286: aload_1
    //   1287: invokevirtual 216	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;)I
    //   1290: ifeq +357 -> 1647
    //   1293: aload_1
    //   1294: ldc_w 942
    //   1297: aconst_null
    //   1298: invokestatic 945	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1301: astore 14
    //   1303: aload 14
    //   1305: ifnull +1038 -> 2343
    //   1308: aload 14
    //   1310: instanceof 917
    //   1313: ifeq +1030 -> 2343
    //   1316: aload 14
    //   1318: checkcast 917	java/lang/Boolean
    //   1321: invokevirtual 948	java/lang/Boolean:booleanValue	()Z
    //   1324: istore 13
    //   1326: iload 13
    //   1328: ifeq +319 -> 1647
    //   1331: new 950	android/os/Bundle
    //   1334: dup
    //   1335: invokespecial 951	android/os/Bundle:<init>	()V
    //   1338: astore 14
    //   1340: aload 14
    //   1342: ldc_w 953
    //   1345: iload 4
    //   1347: invokevirtual 955	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1350: aload_1
    //   1351: invokestatic 567	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1354: ifeq +89 -> 1443
    //   1357: aload 14
    //   1359: ldc_w 957
    //   1362: aload_0
    //   1363: aload_1
    //   1364: invokevirtual 576	com/tencent/smtt/sdk/q:q	(Landroid/content/Context;)Ljava/io/File;
    //   1367: invokevirtual 960	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1370: invokevirtual 963	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1373: aload_1
    //   1374: ldc_w 965
    //   1377: aload 14
    //   1379: invokestatic 945	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1382: astore 14
    //   1384: aload 14
    //   1386: ifnonnull +121 -> 1507
    //   1389: ldc 151
    //   1391: ldc_w 967
    //   1394: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1397: aload_1
    //   1398: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1401: sipush 222
    //   1404: ldc_w 969
    //   1407: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1410: iconst_0
    //   1411: istore 4
    //   1413: iload 4
    //   1415: ifne +232 -> 1647
    //   1418: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1421: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1424: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1427: invokeinterface 533 1 0
    //   1432: aload_0
    //   1433: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1436: ldc_w 811
    //   1439: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1442: return
    //   1443: aload 14
    //   1445: ldc_w 957
    //   1448: aload_0
    //   1449: aload_1
    //   1450: iconst_0
    //   1451: invokevirtual 284	com/tencent/smtt/sdk/q:f	(Landroid/content/Context;I)Ljava/io/File;
    //   1454: invokevirtual 960	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1457: invokevirtual 963	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1460: goto -87 -> 1373
    //   1463: astore_1
    //   1464: iconst_0
    //   1465: istore_3
    //   1466: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1469: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1472: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1475: invokeinterface 533 1 0
    //   1480: aload_0
    //   1481: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1484: iload_3
    //   1485: ifeq +14 -> 1499
    //   1488: getstatic 524	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   1491: sipush 232
    //   1494: invokeinterface 529 2 0
    //   1499: ldc_w 811
    //   1502: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1505: aload_1
    //   1506: athrow
    //   1507: aload 14
    //   1509: instanceof 917
    //   1512: ifeq +55 -> 1567
    //   1515: aload 14
    //   1517: checkcast 917	java/lang/Boolean
    //   1520: invokevirtual 948	java/lang/Boolean:booleanValue	()Z
    //   1523: ifeq +17 -> 1540
    //   1526: ldc 151
    //   1528: ldc_w 971
    //   1531: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1534: iconst_1
    //   1535: istore 4
    //   1537: goto -124 -> 1413
    //   1540: ldc 151
    //   1542: ldc_w 973
    //   1545: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1548: aload_1
    //   1549: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1552: sipush 222
    //   1555: ldc_w 973
    //   1558: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1561: iconst_0
    //   1562: istore 4
    //   1564: goto -151 -> 1413
    //   1567: aload 14
    //   1569: instanceof 950
    //   1572: ifeq +9 -> 1581
    //   1575: iconst_1
    //   1576: istore 4
    //   1578: goto -165 -> 1413
    //   1581: aload 14
    //   1583: instanceof 362
    //   1586: ifeq +47 -> 1633
    //   1589: ldc 151
    //   1591: new 233	java/lang/StringBuilder
    //   1594: dup
    //   1595: ldc_w 975
    //   1598: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1601: aload 14
    //   1603: checkcast 362	java/lang/Throwable
    //   1606: invokestatic 710	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1609: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1615: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1618: aload_1
    //   1619: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1622: sipush 222
    //   1625: aload 14
    //   1627: checkcast 362	java/lang/Throwable
    //   1630: invokevirtual 786	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   1633: iconst_0
    //   1634: istore 4
    //   1636: goto -223 -> 1413
    //   1639: astore_1
    //   1640: ldc_w 811
    //   1643: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1646: return
    //   1647: ldc 151
    //   1649: ldc_w 977
    //   1652: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1655: aload_1
    //   1656: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1659: iload 8
    //   1661: iconst_1
    //   1662: invokevirtual 348	com/tencent/smtt/sdk/n:c	(II)V
    //   1665: iload 8
    //   1667: istore 4
    //   1669: iload 6
    //   1671: iconst_2
    //   1672: if_icmpge +553 -> 2225
    //   1675: iload 5
    //   1677: ifeq +207 -> 1884
    //   1680: aload_1
    //   1681: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1684: ldc_w 979
    //   1687: invokevirtual 517	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   1690: istore 5
    //   1692: iload 5
    //   1694: bipush 10
    //   1696: if_icmple +177 -> 1873
    //   1699: aload_1
    //   1700: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1703: sipush 208
    //   1706: ldc_w 981
    //   1709: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1712: aload_1
    //   1713: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1716: sipush -514
    //   1719: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1722: aload_0
    //   1723: aload_1
    //   1724: invokespecial 871	com/tencent/smtt/sdk/q:F	(Landroid/content/Context;)V
    //   1727: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1730: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1733: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1736: invokeinterface 533 1 0
    //   1741: aload_0
    //   1742: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1745: ldc_w 811
    //   1748: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1751: return
    //   1752: aload_1
    //   1753: invokestatic 567	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1756: ifeq +103 -> 1859
    //   1759: aload_2
    //   1760: ifnonnull +80 -> 1840
    //   1763: aload_1
    //   1764: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1767: ldc_w 877
    //   1770: invokevirtual 879	com/tencent/smtt/sdk/n:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1773: astore 15
    //   1775: aload 15
    //   1777: astore 14
    //   1779: aload 15
    //   1781: ifnonnull +62 -> 1843
    //   1784: aload_1
    //   1785: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1788: sipush 202
    //   1791: ldc_w 881
    //   1794: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1797: aload_1
    //   1798: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1801: sipush -511
    //   1804: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1807: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1810: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1813: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1816: invokeinterface 533 1 0
    //   1821: aload_0
    //   1822: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1825: ldc_w 811
    //   1828: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1831: return
    //   1832: astore_1
    //   1833: ldc_w 811
    //   1836: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1839: return
    //   1840: aload_2
    //   1841: astore 14
    //   1843: aload_0
    //   1844: aload_1
    //   1845: new 293	java/io/File
    //   1848: dup
    //   1849: aload 14
    //   1851: invokespecial 366	java/io/File:<init>	(Ljava/lang/String;)V
    //   1854: iconst_1
    //   1855: invokespecial 745	com/tencent/smtt/sdk/q:a	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1858: pop
    //   1859: iconst_0
    //   1860: istore 4
    //   1862: goto -193 -> 1669
    //   1865: astore_1
    //   1866: ldc_w 811
    //   1869: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1872: return
    //   1873: aload_1
    //   1874: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1877: iload 5
    //   1879: iconst_1
    //   1880: iadd
    //   1881: invokevirtual 983	com/tencent/smtt/sdk/n:a	(I)V
    //   1884: aload_1
    //   1885: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1888: sipush -549
    //   1891: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1894: aload_0
    //   1895: aload_1
    //   1896: iconst_0
    //   1897: invokespecial 986	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;I)Z
    //   1900: ifne +46 -> 1946
    //   1903: aload_1
    //   1904: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1907: sipush -515
    //   1910: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1913: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1916: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1919: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1922: invokeinterface 533 1 0
    //   1927: aload_0
    //   1928: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1931: ldc_w 811
    //   1934: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1937: return
    //   1938: astore_1
    //   1939: ldc_w 811
    //   1942: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1945: return
    //   1946: aload_1
    //   1947: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1950: iload 4
    //   1952: iconst_2
    //   1953: invokevirtual 348	com/tencent/smtt/sdk/n:c	(II)V
    //   1956: ldc 151
    //   1958: ldc_w 988
    //   1961: iconst_1
    //   1962: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1965: ldc 151
    //   1967: ldc_w 990
    //   1970: iload_3
    //   1971: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1974: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1977: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1980: aload_1
    //   1981: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1984: sipush -516
    //   1987: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1990: getstatic 487	android/os/Build$VERSION:SDK_INT	I
    //   1993: bipush 11
    //   1995: if_icmplt +155 -> 2150
    //   1998: aload_1
    //   1999: ldc_w 489
    //   2002: iconst_4
    //   2003: invokevirtual 493	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2006: astore 14
    //   2008: aload 14
    //   2010: invokeinterface 681 1 0
    //   2015: astore 14
    //   2017: aload 14
    //   2019: ldc_w 683
    //   2022: iconst_0
    //   2023: invokeinterface 689 3 0
    //   2028: pop
    //   2029: aload 14
    //   2031: ldc_w 691
    //   2034: iconst_0
    //   2035: invokeinterface 689 3 0
    //   2040: pop
    //   2041: aload 14
    //   2043: ldc_w 693
    //   2046: iload_3
    //   2047: invokeinterface 689 3 0
    //   2052: pop
    //   2053: aload 14
    //   2055: invokeinterface 696 1 0
    //   2060: pop
    //   2061: aload_1
    //   2062: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2065: sipush -517
    //   2068: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2071: iload_3
    //   2072: ldc_w 730
    //   2075: if_icmpne +10 -> 2085
    //   2078: aload_0
    //   2079: iload_3
    //   2080: aload_2
    //   2081: aload_1
    //   2082: invokespecial 992	com/tencent/smtt/sdk/q:a	(ILjava/lang/String;Landroid/content/Context;)V
    //   2085: aload_0
    //   2086: getfield 132	com/tencent/smtt/sdk/q:k	Z
    //   2089: ifeq +115 -> 2204
    //   2092: aload_1
    //   2093: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2096: aload_0
    //   2097: aload_1
    //   2098: invokespecial 995	com/tencent/smtt/sdk/q:v	(Landroid/content/Context;)I
    //   2101: ldc_w 675
    //   2104: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2107: iload 7
    //   2109: istore_3
    //   2110: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2113: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2116: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   2119: invokeinterface 533 1 0
    //   2124: aload_0
    //   2125: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   2128: iload_3
    //   2129: ifeq +125 -> 2254
    //   2132: getstatic 524	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   2135: sipush 232
    //   2138: invokeinterface 529 2 0
    //   2143: ldc_w 811
    //   2146: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2149: return
    //   2150: aload_1
    //   2151: ldc_w 489
    //   2154: iconst_0
    //   2155: invokevirtual 493	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2158: astore 14
    //   2160: goto -152 -> 2008
    //   2163: astore 14
    //   2165: ldc 151
    //   2167: new 233	java/lang/StringBuilder
    //   2170: dup
    //   2171: ldc_w 997
    //   2174: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2177: aload 14
    //   2179: invokestatic 710	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2182: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2185: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2188: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2191: aload_1
    //   2192: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2195: sipush -518
    //   2198: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2201: goto -130 -> 2071
    //   2204: aload_1
    //   2205: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2208: aload_0
    //   2209: aload_1
    //   2210: invokespecial 995	com/tencent/smtt/sdk/q:v	(Landroid/content/Context;)I
    //   2213: ldc_w 702
    //   2216: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2219: iload 7
    //   2221: istore_3
    //   2222: goto -112 -> 2110
    //   2225: iload 6
    //   2227: iconst_2
    //   2228: if_icmpne +110 -> 2338
    //   2231: getstatic 524	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   2234: sipush 200
    //   2237: invokeinterface 529 2 0
    //   2242: iload 7
    //   2244: istore_3
    //   2245: goto -135 -> 2110
    //   2248: astore_1
    //   2249: iconst_1
    //   2250: istore_3
    //   2251: goto -785 -> 1466
    //   2254: ldc_w 811
    //   2257: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2260: return
    //   2261: aload_1
    //   2262: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2265: sipush -519
    //   2268: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2271: aload_0
    //   2272: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   2275: ldc_w 811
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
    //   0	2363	0	this	q
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
    //   0: ldc_w 998
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: new 18	com/tencent/smtt/sdk/q$6
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 1001	com/tencent/smtt/sdk/q$6:<init>	(Lcom/tencent/smtt/sdk/q;)V
    //   15: invokevirtual 1004	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   18: astore 6
    //   20: aload 6
    //   22: arraylength
    //   23: istore 4
    //   25: getstatic 487	android/os/Build$VERSION:SDK_INT	I
    //   28: bipush 16
    //   30: if_icmpge +33 -> 63
    //   33: aload_1
    //   34: invokevirtual 1007	android/content/Context:getPackageName	()Ljava/lang/String;
    //   37: ifnull +26 -> 63
    //   40: aload_1
    //   41: invokevirtual 1007	android/content/Context:getPackageName	()Ljava/lang/String;
    //   44: ldc_w 1009
    //   47: invokevirtual 1012	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   50: istore 5
    //   52: iload 5
    //   54: ifeq +9 -> 63
    //   57: ldc2_w 1013
    //   60: invokestatic 1018	java/lang/Thread:sleep	(J)V
    //   63: aload_1
    //   64: invokevirtual 1022	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   67: astore 7
    //   69: iconst_0
    //   70: istore_3
    //   71: iload_3
    //   72: iload 4
    //   74: if_icmpge +60 -> 134
    //   77: ldc 151
    //   79: new 233	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 1024
    //   86: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: aload 6
    //   91: iload_3
    //   92: aaload
    //   93: invokevirtual 960	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   96: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: new 1026	dalvik/system/DexClassLoader
    //   108: dup
    //   109: aload 6
    //   111: iload_3
    //   112: aaload
    //   113: invokevirtual 960	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   116: aload_2
    //   117: invokevirtual 960	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   120: aconst_null
    //   121: aload 7
    //   123: invokespecial 1029	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   126: pop
    //   127: iload_3
    //   128: iconst_1
    //   129: iadd
    //   130: istore_3
    //   131: goto -60 -> 71
    //   134: ldc_w 998
    //   137: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: iconst_1
    //   141: ireturn
    //   142: astore_2
    //   143: aload_1
    //   144: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   147: sipush 209
    //   150: aload_2
    //   151: invokevirtual 261	java/lang/Exception:toString	()Ljava/lang/String;
    //   154: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   157: ldc 151
    //   159: ldc_w 1031
    //   162: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: ldc_w 998
    //   168: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: iconst_0
    //   172: ireturn
    //   173: astore 7
    //   175: goto -112 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	q
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
    AppMethodBeat.i(192625);
    for (;;)
    {
      try
      {
        a().g(paramContext, false);
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
          AppMethodBeat.o(192625);
          return 1;
        }
        paramBundle = new File(paramBundle.getString("backup_apk"));
        localObject = b.a(paramContext, true, paramBundle);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(localObject))
        {
          TbsLog.i("TbsInstaller", "tpatch sig not equals!!!" + paramBundle + "signature:" + (String)localObject);
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(241, "version=" + i2 + ",patchVersion=" + i3);
          f.b(paramBundle);
          AppMethodBeat.o(192625);
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
      AppMethodBeat.o(192625);
      return i1;
      TbsLog.i("TbsInstaller", "Tpatch success!");
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(236, "");
    }
  }
  
  private boolean c(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(192674);
    try
    {
      Object localObject1 = new File(paramFile, "tbs_sdk_extension_dex.jar");
      Object localObject2 = new File(paramFile, "tbs_sdk_extension_dex.dex");
      Object localObject3 = paramContext.getClassLoader();
      new DexClassLoader(((File)localObject1).getAbsolutePath(), paramFile.getAbsolutePath(), null, (ClassLoader)localObject3);
      localObject1 = e.a(paramContext, ((File)localObject2).getAbsolutePath());
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, "can not find oat command");
        AppMethodBeat.o(192674);
        return false;
      }
      paramFile = paramFile.listFiles(new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          AppMethodBeat.i(192574);
          boolean bool = paramAnonymousFile.getName().endsWith(".jar");
          AppMethodBeat.o(192574);
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
        localObject2 = "/system/bin/dex2oat " + (String)localObject3 + " --dex-location=" + a().r(paramContext) + File.separator + (String)localObject2 + ".jar";
        Runtime.getRuntime().exec((String)localObject2).waitFor();
        i1 += 1;
      }
      AppMethodBeat.o(192674);
      return true;
    }
    catch (Exception paramFile)
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, paramFile);
      AppMethodBeat.o(192674);
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
    //   8: ldc_w 1138
    //   11: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: ldc 151
    //   16: ldc_w 1140
    //   19: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 502	com/tencent/smtt/sdk/q:u	(Landroid/content/Context;)Z
    //   27: istore 7
    //   29: iload 7
    //   31: ifne +16 -> 47
    //   34: ldc_w 1138
    //   37: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iload 6
    //   42: istore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_2
    //   46: ireturn
    //   47: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   50: invokevirtual 1141	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   53: istore 6
    //   55: ldc 151
    //   57: ldc_w 1143
    //   60: iload 6
    //   62: invokestatic 304	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   65: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iload 6
    //   73: ifeq +212 -> 285
    //   76: aload_1
    //   77: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   80: ldc_w 1145
    //   83: invokevirtual 521	com/tencent/smtt/sdk/n:b	(Ljava/lang/String;)I
    //   86: istore_3
    //   87: aload_0
    //   88: iconst_0
    //   89: aload_1
    //   90: invokevirtual 1148	com/tencent/smtt/sdk/q:a	(ZLandroid/content/Context;)I
    //   93: istore 4
    //   95: ldc 151
    //   97: ldc_w 1150
    //   100: iload_3
    //   101: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   104: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: ldc 151
    //   112: ldc_w 1152
    //   115: iload 4
    //   117: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   120: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   123: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: iload_3
    //   127: iconst_1
    //   128: if_icmpne +152 -> 280
    //   131: iload 4
    //   133: ifne +50 -> 183
    //   136: ldc 151
    //   138: ldc_w 1154
    //   141: iconst_1
    //   142: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   145: aload_0
    //   146: aload_1
    //   147: invokespecial 1157	com/tencent/smtt/sdk/q:z	(Landroid/content/Context;)V
    //   150: iload 5
    //   152: istore_2
    //   153: iload_2
    //   154: istore 5
    //   156: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   159: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   162: iload_2
    //   163: istore 5
    //   165: aload_0
    //   166: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   169: ldc_w 1138
    //   172: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: goto -132 -> 43
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    //   183: iload_2
    //   184: ifeq +96 -> 280
    //   187: ldc 151
    //   189: ldc_w 1159
    //   192: iconst_1
    //   193: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   196: aload_0
    //   197: aload_1
    //   198: invokespecial 1157	com/tencent/smtt/sdk/q:z	(Landroid/content/Context;)V
    //   201: iload 5
    //   203: istore_2
    //   204: goto -51 -> 153
    //   207: astore 8
    //   209: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   212: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   215: ldc_w 1138
    //   218: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload 8
    //   223: athrow
    //   224: astore 8
    //   226: iconst_0
    //   227: istore 5
    //   229: aload_1
    //   230: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   233: sipush 215
    //   236: aload 8
    //   238: invokevirtual 1160	java/lang/Throwable:toString	()Ljava/lang/String;
    //   241: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   244: aload_1
    //   245: new 233	java/lang/StringBuilder
    //   248: dup
    //   249: ldc_w 1162
    //   252: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   255: aload 8
    //   257: invokestatic 710	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   260: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 357	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
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
    //   0	290	0	this	q
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
    //   8: ldc_w 1163
    //   11: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: ldc 151
    //   16: ldc_w 1165
    //   19: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 502	com/tencent/smtt/sdk/q:u	(Landroid/content/Context;)Z
    //   27: istore 7
    //   29: iload 7
    //   31: ifne +16 -> 47
    //   34: ldc_w 1163
    //   37: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iload 6
    //   42: istore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_2
    //   46: ireturn
    //   47: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   50: invokevirtual 1141	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   53: istore 6
    //   55: ldc 151
    //   57: ldc_w 1167
    //   60: iload 6
    //   62: invokestatic 304	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   65: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iload 6
    //   73: ifeq +221 -> 294
    //   76: aload_1
    //   77: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   80: ldc_w 519
    //   83: invokevirtual 521	com/tencent/smtt/sdk/n:b	(Ljava/lang/String;)I
    //   86: istore_3
    //   87: aload_0
    //   88: iconst_0
    //   89: aload_1
    //   90: invokevirtual 1148	com/tencent/smtt/sdk/q:a	(ZLandroid/content/Context;)I
    //   93: istore 4
    //   95: ldc 151
    //   97: ldc_w 1169
    //   100: iload_3
    //   101: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   104: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: ldc 151
    //   112: ldc_w 1171
    //   115: iload 4
    //   117: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   120: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   123: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: iload_3
    //   127: iconst_1
    //   128: if_icmpne +161 -> 289
    //   131: iload 4
    //   133: ifne +50 -> 183
    //   136: ldc 151
    //   138: ldc_w 1173
    //   141: iconst_1
    //   142: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   145: aload_0
    //   146: aload_1
    //   147: invokespecial 1175	com/tencent/smtt/sdk/q:A	(Landroid/content/Context;)V
    //   150: iload 5
    //   152: istore_2
    //   153: iload_2
    //   154: istore 5
    //   156: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   159: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   162: iload_2
    //   163: istore 5
    //   165: aload_0
    //   166: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   169: ldc_w 1163
    //   172: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: goto -132 -> 43
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    //   183: iload_2
    //   184: ifeq +105 -> 289
    //   187: ldc 151
    //   189: ldc_w 1177
    //   192: iconst_1
    //   193: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   196: aload_0
    //   197: aload_1
    //   198: invokespecial 1175	com/tencent/smtt/sdk/q:A	(Landroid/content/Context;)V
    //   201: iload 5
    //   203: istore_2
    //   204: goto -51 -> 153
    //   207: astore 8
    //   209: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   212: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   215: ldc_w 1163
    //   218: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload 8
    //   223: athrow
    //   224: astore 8
    //   226: iconst_0
    //   227: istore 5
    //   229: aload_1
    //   230: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   233: sipush 215
    //   236: aload 8
    //   238: invokevirtual 1160	java/lang/Throwable:toString	()Ljava/lang/String;
    //   241: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   244: aload_1
    //   245: new 233	java/lang/StringBuilder
    //   248: dup
    //   249: ldc_w 1179
    //   252: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   255: aload 8
    //   257: invokestatic 710	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   260: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 357	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   269: iload 5
    //   271: istore_2
    //   272: goto -103 -> 169
    //   275: astore_1
    //   276: ldc_w 1163
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
    //   0	299	0	this	q
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
    AppMethodBeat.i(192628);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null)
      {
        AppMethodBeat.o(192628);
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
      AppMethodBeat.o(192628);
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
    //   8: ldc_w 1193
    //   11: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_1
    //   15: ifnull +35 -> 50
    //   18: ldc_w 310
    //   21: aload_1
    //   22: invokevirtual 316	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   25: invokevirtual 320	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   28: getfield 326	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   31: invokevirtual 330	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +16 -> 50
    //   37: aload_1
    //   38: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   41: sipush 229
    //   44: ldc_w 332
    //   47: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   50: ldc 151
    //   52: ldc_w 1195
    //   55: iload_2
    //   56: invokestatic 304	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   59: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   62: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: ldc 151
    //   67: ldc_w 1197
    //   70: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: aload_1
    //   75: invokevirtual 502	com/tencent/smtt/sdk/q:u	(Landroid/content/Context;)Z
    //   78: istore 7
    //   80: iload 7
    //   82: ifne +16 -> 98
    //   85: ldc_w 1193
    //   88: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: iload 6
    //   93: istore_2
    //   94: aload_0
    //   95: monitorexit
    //   96: iload_2
    //   97: ireturn
    //   98: ldc 151
    //   100: ldc_w 1199
    //   103: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   109: invokevirtual 1141	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   112: istore 6
    //   114: ldc 151
    //   116: ldc_w 1201
    //   119: iload 6
    //   121: invokestatic 304	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   124: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   127: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: iload 6
    //   132: ifeq +176 -> 308
    //   135: aload_1
    //   136: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   139: invokevirtual 855	com/tencent/smtt/sdk/n:c	()I
    //   142: istore_3
    //   143: ldc 151
    //   145: ldc_w 1203
    //   148: iload_3
    //   149: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   152: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   155: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload_0
    //   159: iconst_0
    //   160: aload_1
    //   161: invokevirtual 1148	com/tencent/smtt/sdk/q:a	(ZLandroid/content/Context;)I
    //   164: istore 4
    //   166: iload_3
    //   167: iconst_2
    //   168: if_icmpne +135 -> 303
    //   171: ldc 151
    //   173: ldc_w 1205
    //   176: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: iload 4
    //   181: ifne +50 -> 231
    //   184: ldc 151
    //   186: ldc_w 1207
    //   189: iconst_0
    //   190: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   193: aload_0
    //   194: aload_1
    //   195: invokespecial 1210	com/tencent/smtt/sdk/q:y	(Landroid/content/Context;)V
    //   198: iload 5
    //   200: istore_2
    //   201: iload_2
    //   202: istore 5
    //   204: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   207: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   210: iload_2
    //   211: istore 5
    //   213: aload_0
    //   214: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   217: ldc_w 1193
    //   220: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: goto -129 -> 94
    //   226: astore_1
    //   227: aload_0
    //   228: monitorexit
    //   229: aload_1
    //   230: athrow
    //   231: iload_2
    //   232: ifeq +71 -> 303
    //   235: ldc 151
    //   237: ldc_w 1212
    //   240: iconst_0
    //   241: invokestatic 377	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   244: aload_0
    //   245: aload_1
    //   246: invokespecial 1210	com/tencent/smtt/sdk/q:y	(Landroid/content/Context;)V
    //   249: iload 5
    //   251: istore_2
    //   252: goto -51 -> 201
    //   255: astore 8
    //   257: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   260: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   263: ldc_w 1193
    //   266: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload 8
    //   271: athrow
    //   272: astore 8
    //   274: iconst_0
    //   275: istore 5
    //   277: aload_1
    //   278: ldc_w 1214
    //   281: aload 8
    //   283: invokestatic 818	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   286: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   289: invokestatic 357	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   292: iload 5
    //   294: istore_2
    //   295: goto -78 -> 217
    //   298: astore 8
    //   300: goto -23 -> 277
    //   303: iconst_0
    //   304: istore_2
    //   305: goto -104 -> 201
    //   308: iconst_0
    //   309: istore_2
    //   310: goto -100 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	q
    //   0	313	1	paramContext	Context
    //   0	313	2	paramBoolean	boolean
    //   142	27	3	i1	int
    //   164	16	4	i2	int
    //   1	292	5	bool1	boolean
    //   4	127	6	bool2	boolean
    //   78	3	7	bool3	boolean
    //   255	15	8	localObject	Object
    //   272	10	8	localException1	Exception
    //   298	1	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	14	226	finally
    //   18	50	226	finally
    //   50	73	226	finally
    //   73	80	226	finally
    //   85	91	226	finally
    //   98	130	226	finally
    //   204	210	226	finally
    //   213	217	226	finally
    //   217	223	226	finally
    //   257	272	226	finally
    //   277	292	226	finally
    //   135	166	255	finally
    //   171	179	255	finally
    //   184	198	255	finally
    //   235	249	255	finally
    //   73	80	272	java/lang/Exception
    //   98	130	272	java/lang/Exception
    //   257	272	272	java/lang/Exception
    //   204	210	298	java/lang/Exception
    //   213	217	298	java/lang/Exception
  }
  
  private boolean f(Context paramContext, boolean paramBoolean)
  {
    return false;
  }
  
  private void g(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(192617);
    if (paramContext == null)
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(225, "setTmpFolderCoreToRead context is null");
      AppMethodBeat.o(192617);
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
        AppMethodBeat.o(192617);
        return;
      }
    }
    catch (Exception localException)
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(225, "setTmpFolderCoreToRead Exception message is " + localException.getMessage() + " Exception cause is " + localException.getCause());
      AppMethodBeat.o(192617);
      return;
    }
    f.b(localException);
    label123:
    AppMethodBeat.o(192617);
  }
  
  private void h(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(192624);
    TbsLog.i("TbsInstaller", "proceedTpatchStatus,result=".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      QbSdk.setTBSInstallingStatus(false);
      AppMethodBeat.o(192624);
      return;
      if (TbsDownloader.a(paramContext))
      {
        i(paramContext, 6);
      }
      else
      {
        g(paramContext, true);
        paramInt = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version", 0);
        n.a(paramContext).b(paramInt, 1);
      }
    }
  }
  
  private void i(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(192635);
    File localFile1 = a().f(paramContext, paramInt);
    a().g(paramContext, true);
    File localFile2 = q(paramContext);
    f.a(localFile2, true);
    localFile1.renameTo(localFile2);
    TbsShareManager.b(paramContext);
    AppMethodBeat.o(192635);
  }
  
  private boolean j(Context paramContext, int paramInt)
  {
    int i3 = 0;
    AppMethodBeat.i(192636);
    TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt start - dirMode: ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    try
    {
      TbsLog.e("TbsInstaller", "doDexoptOrDexoat mode error: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(192636);
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
      AppMethodBeat.o(192636);
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
        AppMethodBeat.o(192636);
        return true;
        TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
        bool = b(paramContext, localFile);
        AppMethodBeat.o(192636);
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
      AppMethodBeat.o(192636);
      return true;
      localFile = f(paramContext, 1);
      continue;
      localFile = r(paramContext);
    }
  }
  
  static File t(Context paramContext)
  {
    AppMethodBeat.i(192668);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_private");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(192668);
      return null;
    }
    AppMethodBeat.o(192668);
    return paramContext;
  }
  
  private int v(Context paramContext)
  {
    int i1 = 1;
    AppMethodBeat.i(192612);
    if (n.a(paramContext).d() == 1) {}
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
      AppMethodBeat.o(192612);
      return 234;
      i1 = 0;
    }
    AppMethodBeat.o(192612);
    return 221;
    label57:
    if (bool)
    {
      AppMethodBeat.o(192612);
      return 233;
    }
    AppMethodBeat.o(192612);
    return 200;
  }
  
  private static boolean w(Context paramContext)
  {
    AppMethodBeat.i(192616);
    if (paramContext == null)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #1");
      AppMethodBeat.o(192616);
      return true;
    }
    try
    {
      if (new File(QbSdk.getTbsFolderDir(paramContext), "tmp_folder_core_to_read.conf").exists())
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #2");
        AppMethodBeat.o(192616);
        return true;
      }
      TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #3");
      AppMethodBeat.o(192616);
      return false;
    }
    catch (Exception paramContext)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #4");
      AppMethodBeat.o(192616);
    }
    return true;
  }
  
  private boolean x(Context paramContext)
  {
    AppMethodBeat.i(192642);
    TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
    try
    {
      bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
      TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #2  enabled is ".concat(String.valueOf(bool)));
      if (!bool)
      {
        l = x.a().a(paramContext);
        if (l != null) {
          break label88;
        }
        TbsLog.i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
        AppMethodBeat.o(192642);
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
      AppMethodBeat.o(192642);
    }
    return true;
  }
  
  private void y(Context paramContext)
  {
    AppMethodBeat.i(192643);
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
    if (!x(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      AppMethodBeat.o(192643);
      return;
    }
    for (;;)
    {
      try
      {
        B(paramContext);
        C(paramContext);
        TbsLog.i("TbsInstaller", "after renameTbsCoreShareDir");
        if (TbsShareManager.isThirdPartyApp(paramContext)) {
          continue;
        }
        TbsLog.i("TbsInstaller", "prepare to shareTbsCore");
        TbsShareManager.a(paramContext);
        n.a(paramContext).a(0);
        n.a(paramContext).b(0);
        n.a(paramContext).d(0);
        n.a(paramContext).a("incrupdate_retry_num", 0);
        n.a(paramContext).c(0, 3);
        n.a(paramContext).a("");
        n.a(paramContext).a("tpatch_num", 0);
        n.a(paramContext).c(-1);
        if (!TbsShareManager.isThirdPartyApp(paramContext))
        {
          i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
          if ((i1 <= 0) || (i1 == a().i(paramContext)) || (i1 != a().j(paramContext))) {
            continue;
          }
          o(paramContext);
        }
      }
      catch (Throwable localThrowable)
      {
        int i1;
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from unzip:" + localThrowable.toString());
        TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        continue;
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is " + i1 + " getTbsCoreShareDecoupleCoreVersion is " + a().i(paramContext) + " getTbsCoreInstalledVerInNolock is " + a().j(paramContext));
        continue;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsShareManager.writeCoreInfoForThirdPartyApp(paramContext, n(paramContext), true);
      }
      a.set(Integer.valueOf(0));
      o = 0;
      h(paramContext);
      AppMethodBeat.o(192643);
      return;
      TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
    }
  }
  
  private void z(Context paramContext)
  {
    AppMethodBeat.i(192644);
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
    if (!x(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      AppMethodBeat.o(192644);
      return;
    }
    try
    {
      B(paramContext);
      E(paramContext);
      TbsShareManager.a(paramContext);
      n.a(paramContext).b(0, -1);
      n.a(paramContext).a("tpatch_num", 0);
      a.set(Integer.valueOf(0));
      h(paramContext);
      AppMethodBeat.o(192644);
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
  
  /* Error */
  int a(File paramFile)
  {
    // Byte code:
    //   0: ldc_w 1348
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: ldc 151
    //   11: ldc_w 1350
    //   14: aload_1
    //   15: invokestatic 818	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   21: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: new 293	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: ldc_w 390
    //   32: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 606	java/io/File:exists	()Z
    //   40: istore_3
    //   41: iload_3
    //   42: ifne +11 -> 53
    //   45: ldc_w 1348
    //   48: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_0
    //   52: ireturn
    //   53: new 392	java/util/Properties
    //   56: dup
    //   57: invokespecial 393	java/util/Properties:<init>	()V
    //   60: astore 5
    //   62: new 395	java/io/BufferedInputStream
    //   65: dup
    //   66: new 397	java/io/FileInputStream
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 400	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   74: invokespecial 403	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   77: astore_1
    //   78: aload 5
    //   80: aload_1
    //   81: invokevirtual 406	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   84: aload_1
    //   85: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   88: aload 5
    //   90: ldc_w 1352
    //   93: invokevirtual 1353	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 4
    //   98: aload 4
    //   100: ifnonnull +15 -> 115
    //   103: aload_1
    //   104: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   107: ldc_w 1348
    //   110: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: iconst_0
    //   114: ireturn
    //   115: aload 4
    //   117: invokestatic 1356	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   120: istore_2
    //   121: aload_1
    //   122: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   125: ldc_w 1348
    //   128: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: iload_2
    //   132: ireturn
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_1
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   144: ldc_w 1348
    //   147: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_0
    //   151: ireturn
    //   152: astore_1
    //   153: aload 4
    //   155: ifnull +8 -> 163
    //   158: aload 4
    //   160: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   163: ldc_w 1348
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
    //   0	204	0	this	q
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
    //   0: ldc_w 1357
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 1357
    //   13: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_0
    //   17: ireturn
    //   18: aconst_null
    //   19: astore 4
    //   21: new 293	java/io/File
    //   24: dup
    //   25: new 293	java/io/File
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 366	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: ldc_w 390
    //   36: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 606	java/io/File:exists	()Z
    //   44: istore_3
    //   45: iload_3
    //   46: ifne +11 -> 57
    //   49: ldc_w 1357
    //   52: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_0
    //   56: ireturn
    //   57: new 392	java/util/Properties
    //   60: dup
    //   61: invokespecial 393	java/util/Properties:<init>	()V
    //   64: astore 5
    //   66: new 395	java/io/BufferedInputStream
    //   69: dup
    //   70: new 397	java/io/FileInputStream
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 400	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   78: invokespecial 403	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: astore_1
    //   82: aload 5
    //   84: aload_1
    //   85: invokevirtual 406	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   88: aload_1
    //   89: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   92: aload 5
    //   94: ldc_w 1352
    //   97: invokevirtual 1353	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 4
    //   102: aload 4
    //   104: ifnonnull +15 -> 119
    //   107: aload_1
    //   108: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   111: ldc_w 1357
    //   114: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: iconst_0
    //   118: ireturn
    //   119: aload 4
    //   121: invokestatic 1356	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   124: istore_2
    //   125: aload_1
    //   126: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   129: ldc_w 1357
    //   132: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: iload_2
    //   136: ireturn
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   148: ldc_w 1357
    //   151: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: iconst_0
    //   155: ireturn
    //   156: astore_1
    //   157: aload 4
    //   159: ifnull +8 -> 167
    //   162: aload 4
    //   164: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   167: ldc_w 1357
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
    //   0	208	0	this	q
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
    AppMethodBeat.i(192601);
    if ((paramBoolean) || (((Integer)a.get()).intValue() <= 0)) {
      a.set(Integer.valueOf(j(paramContext)));
    }
    int i1 = ((Integer)a.get()).intValue();
    AppMethodBeat.o(192601);
    return i1;
  }
  
  File a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(192670);
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
      AppMethodBeat.o(192670);
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
    AppMethodBeat.o(192670);
    return null;
    label212:
    AppMethodBeat.o(192670);
    return paramContext;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(192614);
    g(paramContext, true);
    n.a(paramContext).c(paramInt, 2);
    AppMethodBeat.o(192614);
  }
  
  void a(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(192621);
    if ((paramBundle == null) || (paramContext == null))
    {
      AppMethodBeat.o(192621);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = new Object[] { paramContext, paramBundle };
    m.sendMessage(localMessage);
    AppMethodBeat.o(192621);
  }
  
  void a(Context paramContext, File paramFile, int paramInt)
  {
    AppMethodBeat.i(192622);
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmp,ctx=" + paramContext + "File=" + paramFile + "coreVersion=" + paramInt);
    if ((paramFile == null) || (paramContext == null))
    {
      AppMethodBeat.o(192622);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 4;
    localMessage.obj = new Object[] { paramContext, paramFile, Integer.valueOf(paramInt) };
    m.sendMessage(localMessage);
    AppMethodBeat.o(192622);
  }
  
  void a(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(192610);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=".concat(String.valueOf(paramString)));
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=".concat(String.valueOf(paramInt)));
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramContext, paramString, Integer.valueOf(paramInt) };
    m.sendMessage(localMessage);
    AppMethodBeat.o(192610);
  }
  
  void a(Context paramContext, boolean paramBoolean)
  {
    int i5 = 0;
    AppMethodBeat.i(192605);
    if (paramBoolean) {
      this.k = true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
    if (!u(paramContext))
    {
      AppMethodBeat.o(192605);
      return;
    }
    String str = null;
    if (i.tryLock()) {}
    for (;;)
    {
      try
      {
        i4 = n.a(paramContext).c();
        i3 = n.a(paramContext).b();
        str = n.a(paramContext).d("install_apk_path");
        i1 = n.a(paramContext).c("copy_core_ver");
        i2 = n.a(paramContext).b("copy_status");
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
          AppMethodBeat.o(192605);
          return;
        }
      }
      finally
      {
        i.unlock();
        AppMethodBeat.o(192605);
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
      AppMethodBeat.o(192605);
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
    //   2: ldc_w 1451
    //   5: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 151
    //   10: ldc_w 1453
    //   13: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: getstatic 121	com/tencent/smtt/sdk/q:p	Z
    //   19: iconst_1
    //   20: if_icmpne +13 -> 33
    //   23: ldc_w 1451
    //   26: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iconst_1
    //   32: ireturn
    //   33: iconst_1
    //   34: putstatic 121	com/tencent/smtt/sdk/q:p	Z
    //   37: new 10	com/tencent/smtt/sdk/q$4
    //   40: dup
    //   41: aload_0
    //   42: aload_2
    //   43: aload_1
    //   44: invokespecial 1456	com/tencent/smtt/sdk/q$4:<init>	(Lcom/tencent/smtt/sdk/q;Landroid/content/Context;Landroid/content/Context;)V
    //   47: invokevirtual 1459	com/tencent/smtt/sdk/q$4:start	()V
    //   50: ldc_w 1451
    //   53: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -27 -> 29
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	q
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
    AppMethodBeat.i(192629);
    try
    {
      if (paramContext.getPackageName() != paramString)
      {
        boolean bool = TbsPVConfig.getInstance(paramContext).isEnableNoCoreGray();
        if (bool)
        {
          AppMethodBeat.o(192629);
          return null;
        }
      }
      paramContext = paramContext.createPackageContext(paramString, 2);
      AppMethodBeat.o(192629);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(192629);
    }
    return null;
  }
  
  File b(Context paramContext1, Context paramContext2)
  {
    AppMethodBeat.i(192663);
    paramContext1 = TbsOneGreyInfoHelper.getCoreDir(paramContext1);
    AppMethodBeat.o(192663);
    return paramContext1;
  }
  
  void b()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54372);
        if (this.e <= 0)
        {
          TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock currentTbsFileLockStackCount=" + this.e + "call stack:" + Log.getStackTraceString(new Throwable()));
          AppMethodBeat.o(54372);
          return;
        }
        TbsLog.d("TbsInstaller", "releaseTbsInstallingFileLock,current Thread Id=" + Thread.currentThread().getId() + "currentTbsFileLockStackCount=" + this.e);
        if (this.e > 1)
        {
          TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
          this.e -= 1;
          AppMethodBeat.o(54372);
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
      AppMethodBeat.o(54372);
    }
  }
  
  /* Error */
  void b(Context paramContext, Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 1506
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 151
    //   8: new 233	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 1508
    //   15: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: invokestatic 840	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   21: invokevirtual 841	java/lang/Thread:getName	()Ljava/lang/String;
    //   24: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: new 362	java/lang/Throwable
    //   30: dup
    //   31: invokespecial 1487	java/lang/Throwable:<init>	()V
    //   34: invokestatic 710	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   37: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 477	com/tencent/smtt/sdk/q:d	(Landroid/content/Context;)Z
    //   51: ifeq +20 -> 71
    //   54: aload_1
    //   55: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   58: sipush -539
    //   61: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   64: ldc_w 1506
    //   67: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: return
    //   71: ldc 151
    //   73: ldc_w 1510
    //   76: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_2
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: ifnonnull +10 -> 94
    //   87: ldc_w 1506
    //   90: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: return
    //   94: aload_1
    //   95: invokestatic 548	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   98: ifne +73 -> 171
    //   101: invokestatic 553	com/tencent/smtt/utils/q:a	()J
    //   104: lstore 7
    //   106: aload_1
    //   107: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   110: invokevirtual 556	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   113: lstore 9
    //   115: aload_1
    //   116: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   119: sipush 210
    //   122: new 233	java/lang/StringBuilder
    //   125: dup
    //   126: ldc_w 1512
    //   129: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: lload 7
    //   134: invokevirtual 561	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: ldc_w 563
    //   140: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: lload 9
    //   145: invokevirtual 561	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   148: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   154: aload_1
    //   155: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   158: sipush -540
    //   161: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   164: ldc_w 1506
    //   167: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: aload_0
    //   172: aload_1
    //   173: invokevirtual 502	com/tencent/smtt/sdk/q:u	(Landroid/content/Context;)Z
    //   176: ifne +20 -> 196
    //   179: aload_1
    //   180: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   183: sipush -541
    //   186: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   189: ldc_w 1506
    //   192: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: return
    //   196: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   199: invokeinterface 507 1 0
    //   204: istore 11
    //   206: ldc 151
    //   208: ldc_w 1514
    //   211: iload 11
    //   213: invokestatic 304	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   216: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   219: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: iload 11
    //   224: ifeq +1751 -> 1975
    //   227: aload_1
    //   228: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   231: getfield 200	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   234: ldc_w 940
    //   237: iconst_0
    //   238: invokeinterface 208 3 0
    //   243: istore 5
    //   245: aconst_null
    //   246: astore 16
    //   248: aconst_null
    //   249: astore 15
    //   251: aconst_null
    //   252: astore 18
    //   254: aconst_null
    //   255: astore 12
    //   257: aconst_null
    //   258: astore 17
    //   260: aload 15
    //   262: astore 13
    //   264: aload 12
    //   266: astore 14
    //   268: iconst_1
    //   269: invokestatic 1234	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   272: iload 5
    //   274: iconst_5
    //   275: if_icmpne +274 -> 549
    //   278: aload 15
    //   280: astore 13
    //   282: aload 12
    //   284: astore 14
    //   286: aload_0
    //   287: aload_1
    //   288: aload_2
    //   289: invokespecial 1516	com/tencent/smtt/sdk/q:c	(Landroid/content/Context;Landroid/os/Bundle;)I
    //   292: istore_3
    //   293: iload_3
    //   294: iconst_1
    //   295: if_icmpne +41 -> 336
    //   298: aload 18
    //   300: astore 13
    //   302: iload_3
    //   303: istore 4
    //   305: aload_1
    //   306: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   309: ldc 184
    //   311: invokevirtual 517	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   314: istore 6
    //   316: aload 18
    //   318: astore 13
    //   320: iload_3
    //   321: istore 4
    //   323: aload_1
    //   324: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   327: ldc 184
    //   329: iload 6
    //   331: iconst_1
    //   332: iadd
    //   333: invokevirtual 187	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   336: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   339: invokeinterface 533 1 0
    //   344: aload_0
    //   345: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   348: iload 5
    //   350: iconst_5
    //   351: if_icmpne +16 -> 367
    //   354: aload_0
    //   355: aload_1
    //   356: iload_3
    //   357: invokespecial 1518	com/tencent/smtt/sdk/q:h	(Landroid/content/Context;I)V
    //   360: ldc_w 1506
    //   363: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   366: return
    //   367: iload_3
    //   368: ifne +68 -> 436
    //   371: ldc 151
    //   373: ldc_w 1520
    //   376: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: aload_1
    //   380: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   383: ldc_w 1322
    //   386: iconst_0
    //   387: invokevirtual 187	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   390: aload_1
    //   391: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   394: sipush -544
    //   397: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   400: aload_1
    //   401: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   404: iconst_0
    //   405: iconst_m1
    //   406: invokevirtual 348	com/tencent/smtt/sdk/n:c	(II)V
    //   409: aload_1
    //   410: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   413: iconst_1
    //   414: invokevirtual 350	com/tencent/smtt/sdk/n:c	(I)V
    //   417: new 1522	java/lang/NullPointerException
    //   420: dup
    //   421: invokespecial 1523	java/lang/NullPointerException:<init>	()V
    //   424: athrow
    //   425: iconst_0
    //   426: invokestatic 1234	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   429: ldc_w 1506
    //   432: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   435: return
    //   436: iload_3
    //   437: iconst_2
    //   438: if_icmpne +14 -> 452
    //   441: ldc 151
    //   443: ldc_w 1525
    //   446: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   449: goto -24 -> 425
    //   452: aload_1
    //   453: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   456: sipush -546
    //   459: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   462: ldc 151
    //   464: ldc_w 1527
    //   467: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: aload_1
    //   471: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   474: getfield 913	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   477: ldc_w 915
    //   480: getstatic 921	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   483: invokeinterface 927 3 0
    //   488: pop
    //   489: aload_1
    //   490: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   493: invokevirtual 931	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   496: aload_1
    //   497: invokestatic 567	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   500: ifeq +26 -> 526
    //   503: aload_1
    //   504: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   507: sipush 235
    //   510: ldc_w 1529
    //   513: iload_3
    //   514: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   517: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   520: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   523: goto -98 -> 425
    //   526: aload_1
    //   527: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   530: sipush 217
    //   533: ldc_w 1531
    //   536: iload_3
    //   537: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   540: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   543: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   546: goto -121 -> 425
    //   549: aload 15
    //   551: astore 13
    //   553: aload 12
    //   555: astore 14
    //   557: aload_0
    //   558: aload_1
    //   559: invokevirtual 216	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;)I
    //   562: ifle +22 -> 584
    //   565: aload 15
    //   567: astore 13
    //   569: aload 12
    //   571: astore 14
    //   573: aload_1
    //   574: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   577: invokevirtual 1280	com/tencent/smtt/sdk/n:d	()I
    //   580: iconst_1
    //   581: if_icmpne +65 -> 646
    //   584: aload 15
    //   586: astore 13
    //   588: aload 12
    //   590: astore 14
    //   592: iconst_0
    //   593: invokestatic 1234	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   596: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   599: invokeinterface 533 1 0
    //   604: aload_0
    //   605: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   608: iload 5
    //   610: iconst_5
    //   611: if_icmpne +16 -> 627
    //   614: aload_0
    //   615: aload_1
    //   616: iconst_2
    //   617: invokespecial 1518	com/tencent/smtt/sdk/q:h	(Landroid/content/Context;I)V
    //   620: ldc_w 1506
    //   623: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   626: return
    //   627: ldc 151
    //   629: ldc_w 1525
    //   632: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: iconst_0
    //   636: invokestatic 1234	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   639: ldc_w 1506
    //   642: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   645: return
    //   646: iload 5
    //   648: iconst_1
    //   649: if_icmpeq +15 -> 664
    //   652: iload 5
    //   654: iconst_2
    //   655: if_icmpeq +9 -> 664
    //   658: iload 5
    //   660: iconst_4
    //   661: if_icmpne +304 -> 965
    //   664: iconst_1
    //   665: istore_3
    //   666: iload_3
    //   667: ifne +1378 -> 2045
    //   670: iload 5
    //   672: ifeq +1373 -> 2045
    //   675: aload 15
    //   677: astore 13
    //   679: aload 12
    //   681: astore 14
    //   683: aload_1
    //   684: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   687: ldc_w 1322
    //   690: invokevirtual 517	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   693: istore_3
    //   694: iload_3
    //   695: iconst_5
    //   696: if_icmple +293 -> 989
    //   699: aload 15
    //   701: astore 13
    //   703: aload 12
    //   705: astore 14
    //   707: ldc 151
    //   709: ldc_w 1533
    //   712: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   715: aload 15
    //   717: astore 13
    //   719: aload 12
    //   721: astore 14
    //   723: aload_2
    //   724: ldc_w 1535
    //   727: invokevirtual 1047	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   730: astore 16
    //   732: aload 15
    //   734: astore 13
    //   736: aload 12
    //   738: astore 14
    //   740: aload_2
    //   741: ldc_w 1044
    //   744: invokevirtual 1047	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   747: astore 17
    //   749: aload 15
    //   751: astore 13
    //   753: aload 12
    //   755: astore 14
    //   757: aload_2
    //   758: ldc_w 1537
    //   761: invokevirtual 1047	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   764: astore_2
    //   765: aload 15
    //   767: astore 13
    //   769: aload 12
    //   771: astore 14
    //   773: aload 16
    //   775: invokestatic 1085	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   778: ifne +23 -> 801
    //   781: aload 15
    //   783: astore 13
    //   785: aload 12
    //   787: astore 14
    //   789: new 293	java/io/File
    //   792: dup
    //   793: aload 16
    //   795: invokespecial 366	java/io/File:<init>	(Ljava/lang/String;)V
    //   798: invokestatic 755	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   801: aload 15
    //   803: astore 13
    //   805: aload 12
    //   807: astore 14
    //   809: aload 17
    //   811: invokestatic 1085	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   814: ifne +23 -> 837
    //   817: aload 15
    //   819: astore 13
    //   821: aload 12
    //   823: astore 14
    //   825: new 293	java/io/File
    //   828: dup
    //   829: aload 17
    //   831: invokespecial 366	java/io/File:<init>	(Ljava/lang/String;)V
    //   834: invokestatic 755	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   837: aload 15
    //   839: astore 13
    //   841: aload 12
    //   843: astore 14
    //   845: aload_2
    //   846: invokestatic 1085	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   849: ifne +22 -> 871
    //   852: aload 15
    //   854: astore 13
    //   856: aload 12
    //   858: astore 14
    //   860: new 293	java/io/File
    //   863: dup
    //   864: aload_2
    //   865: invokespecial 366	java/io/File:<init>	(Ljava/lang/String;)V
    //   868: invokestatic 755	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   871: aload 15
    //   873: astore 13
    //   875: aload 12
    //   877: astore 14
    //   879: aload_1
    //   880: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   883: getfield 913	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   886: ldc_w 915
    //   889: getstatic 921	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   892: invokeinterface 927 3 0
    //   897: pop
    //   898: aload 15
    //   900: astore 13
    //   902: aload 12
    //   904: astore 14
    //   906: aload_1
    //   907: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   910: invokevirtual 931	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   913: aload 15
    //   915: astore 13
    //   917: aload 12
    //   919: astore 14
    //   921: aload_1
    //   922: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   925: sipush 224
    //   928: ldc_w 1539
    //   931: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   934: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   937: invokeinterface 533 1 0
    //   942: aload_0
    //   943: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   946: iload 5
    //   948: iconst_5
    //   949: if_icmpne +21 -> 970
    //   952: aload_0
    //   953: aload_1
    //   954: iconst_2
    //   955: invokespecial 1518	com/tencent/smtt/sdk/q:h	(Landroid/content/Context;I)V
    //   958: ldc_w 1506
    //   961: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   964: return
    //   965: iconst_0
    //   966: istore_3
    //   967: goto -301 -> 666
    //   970: ldc 151
    //   972: ldc_w 1525
    //   975: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   978: iconst_0
    //   979: invokestatic 1234	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   982: ldc_w 1506
    //   985: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   988: return
    //   989: aload 15
    //   991: astore 13
    //   993: aload 12
    //   995: astore 14
    //   997: aload_1
    //   998: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1001: ldc_w 1322
    //   1004: iload_3
    //   1005: iconst_1
    //   1006: iadd
    //   1007: invokevirtual 187	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   1010: aload 15
    //   1012: astore 13
    //   1014: aload 12
    //   1016: astore 14
    //   1018: aload_1
    //   1019: invokestatic 774	com/tencent/smtt/sdk/q:t	(Landroid/content/Context;)Ljava/io/File;
    //   1022: astore 16
    //   1024: aload 16
    //   1026: ifnull +1019 -> 2045
    //   1029: aload 15
    //   1031: astore 13
    //   1033: aload 12
    //   1035: astore 14
    //   1037: new 293	java/io/File
    //   1040: dup
    //   1041: aload 16
    //   1043: ldc_w 776
    //   1046: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1049: astore 16
    //   1051: aload 15
    //   1053: astore 13
    //   1055: aload 12
    //   1057: astore 14
    //   1059: aload 16
    //   1061: invokevirtual 606	java/io/File:exists	()Z
    //   1064: ifeq +981 -> 2045
    //   1067: aload 15
    //   1069: astore 13
    //   1071: aload 12
    //   1073: astore 14
    //   1075: aload 16
    //   1077: invokevirtual 388	java/io/File:canRead	()Z
    //   1080: ifeq +965 -> 2045
    //   1083: aload 15
    //   1085: astore 13
    //   1087: aload 12
    //   1089: astore 14
    //   1091: invokestatic 211	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1094: aload_1
    //   1095: iconst_0
    //   1096: invokespecial 335	com/tencent/smtt/sdk/q:g	(Landroid/content/Context;Z)V
    //   1099: aload 15
    //   1101: astore 13
    //   1103: aload 12
    //   1105: astore 14
    //   1107: aload_1
    //   1108: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1111: sipush -550
    //   1114: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1117: aload 15
    //   1119: astore 13
    //   1121: aload 12
    //   1123: astore 14
    //   1125: aload_1
    //   1126: aload_2
    //   1127: invokestatic 1036	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   1130: astore 12
    //   1132: aload 12
    //   1134: ifnonnull +79 -> 1213
    //   1137: aload 12
    //   1139: astore 13
    //   1141: aload_1
    //   1142: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1145: sipush 228
    //   1148: new 233	java/lang/StringBuilder
    //   1151: dup
    //   1152: ldc_w 1541
    //   1155: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1158: aload_2
    //   1159: ldc_w 1049
    //   1162: invokevirtual 1042	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1165: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1168: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1171: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1174: iconst_1
    //   1175: istore 4
    //   1177: aload 12
    //   1179: astore 13
    //   1181: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1184: invokeinterface 533 1 0
    //   1189: aload_0
    //   1190: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1193: iload 5
    //   1195: iconst_5
    //   1196: if_icmpne +194 -> 1390
    //   1199: aload_0
    //   1200: aload_1
    //   1201: iload 4
    //   1203: invokespecial 1518	com/tencent/smtt/sdk/q:h	(Landroid/content/Context;I)V
    //   1206: ldc_w 1506
    //   1209: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1212: return
    //   1213: aload 12
    //   1215: astore 13
    //   1217: aload 12
    //   1219: astore 14
    //   1221: aload 12
    //   1223: ldc_w 1040
    //   1226: invokevirtual 1042	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1229: istore_3
    //   1230: iload_3
    //   1231: istore 4
    //   1233: aload 12
    //   1235: astore 13
    //   1237: iload_3
    //   1238: ifeq -57 -> 1181
    //   1241: aload_1
    //   1242: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1245: sipush 228
    //   1248: new 233	java/lang/StringBuilder
    //   1251: dup
    //   1252: ldc_w 1543
    //   1255: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1258: iload_3
    //   1259: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1262: ldc_w 1545
    //   1265: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: aload_2
    //   1269: ldc_w 1049
    //   1272: invokevirtual 1042	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1275: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1278: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1281: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1284: iload_3
    //   1285: istore 4
    //   1287: aload 12
    //   1289: astore 13
    //   1291: goto -110 -> 1181
    //   1294: astore_2
    //   1295: aload 12
    //   1297: astore 13
    //   1299: iload_3
    //   1300: istore 4
    //   1302: ldc 151
    //   1304: new 233	java/lang/StringBuilder
    //   1307: dup
    //   1308: ldc_w 1547
    //   1311: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1314: aload_2
    //   1315: invokestatic 710	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1318: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1324: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1327: aload 12
    //   1329: astore 13
    //   1331: aload_1
    //   1332: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1335: sipush -543
    //   1338: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1341: aload 12
    //   1343: astore 13
    //   1345: aload_1
    //   1346: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1349: sipush 218
    //   1352: aload_2
    //   1353: invokevirtual 261	java/lang/Exception:toString	()Ljava/lang/String;
    //   1356: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1359: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1362: invokeinterface 533 1 0
    //   1367: aload_0
    //   1368: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1371: iload 5
    //   1373: iconst_5
    //   1374: if_icmpne +244 -> 1618
    //   1377: aload_0
    //   1378: aload_1
    //   1379: iconst_1
    //   1380: invokespecial 1518	com/tencent/smtt/sdk/q:h	(Landroid/content/Context;I)V
    //   1383: ldc_w 1506
    //   1386: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1389: return
    //   1390: iload 4
    //   1392: ifne +110 -> 1502
    //   1395: ldc 151
    //   1397: ldc_w 1520
    //   1400: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1403: aload_1
    //   1404: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1407: ldc_w 1322
    //   1410: iconst_0
    //   1411: invokevirtual 187	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   1414: aload_1
    //   1415: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1418: sipush -544
    //   1421: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1424: aload_1
    //   1425: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1428: iconst_0
    //   1429: iconst_m1
    //   1430: invokevirtual 348	com/tencent/smtt/sdk/n:c	(II)V
    //   1433: aload_1
    //   1434: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1437: iconst_1
    //   1438: invokevirtual 350	com/tencent/smtt/sdk/n:c	(I)V
    //   1441: aload 13
    //   1443: ldc_w 1549
    //   1446: invokevirtual 1047	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1449: astore_2
    //   1450: new 293	java/io/File
    //   1453: dup
    //   1454: aload_2
    //   1455: invokespecial 366	java/io/File:<init>	(Ljava/lang/String;)V
    //   1458: aload_1
    //   1459: invokestatic 673	com/tencent/smtt/sdk/m:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1462: aload_0
    //   1463: aload_1
    //   1464: aload_2
    //   1465: aload 13
    //   1467: ldc_w 1551
    //   1470: invokevirtual 1042	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1473: invokespecial 740	com/tencent/smtt/sdk/q:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1476: aload_1
    //   1477: invokestatic 567	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1480: ifeq +11 -> 1491
    //   1483: aload_1
    //   1484: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1487: iconst_m1
    //   1488: invokevirtual 350	com/tencent/smtt/sdk/n:c	(I)V
    //   1491: iconst_0
    //   1492: invokestatic 1234	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1495: ldc_w 1506
    //   1498: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1501: return
    //   1502: iload 4
    //   1504: iconst_2
    //   1505: if_icmpne +14 -> 1519
    //   1508: ldc 151
    //   1510: ldc_w 1525
    //   1513: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1516: goto -25 -> 1491
    //   1519: aload_1
    //   1520: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1523: sipush -546
    //   1526: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1529: ldc 151
    //   1531: ldc_w 1527
    //   1534: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1537: aload_1
    //   1538: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1541: getfield 913	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1544: ldc_w 915
    //   1547: getstatic 921	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1550: invokeinterface 927 3 0
    //   1555: pop
    //   1556: aload_1
    //   1557: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1560: invokevirtual 931	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1563: aload_1
    //   1564: invokestatic 567	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1567: ifeq +27 -> 1594
    //   1570: aload_1
    //   1571: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1574: sipush 235
    //   1577: ldc_w 1529
    //   1580: iload 4
    //   1582: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1585: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1588: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1591: goto -100 -> 1491
    //   1594: aload_1
    //   1595: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1598: sipush 217
    //   1601: ldc_w 1531
    //   1604: iload 4
    //   1606: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1609: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1612: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1615: goto -124 -> 1491
    //   1618: aload_1
    //   1619: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1622: sipush -546
    //   1625: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1628: ldc 151
    //   1630: ldc_w 1527
    //   1633: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1636: aload_1
    //   1637: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1640: getfield 913	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1643: ldc_w 915
    //   1646: getstatic 921	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1649: invokeinterface 927 3 0
    //   1654: pop
    //   1655: aload_1
    //   1656: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1659: invokevirtual 931	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1662: aload_1
    //   1663: invokestatic 567	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1666: ifeq +27 -> 1693
    //   1669: aload_1
    //   1670: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1673: sipush 235
    //   1676: ldc_w 1553
    //   1679: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1682: iconst_0
    //   1683: invokestatic 1234	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1686: ldc_w 1506
    //   1689: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1692: return
    //   1693: aload_1
    //   1694: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1697: sipush 217
    //   1700: ldc_w 1555
    //   1703: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1706: goto -24 -> 1682
    //   1709: astore_2
    //   1710: iconst_2
    //   1711: istore_3
    //   1712: aload 13
    //   1714: astore 12
    //   1716: getstatic 67	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1719: invokeinterface 533 1 0
    //   1724: aload_0
    //   1725: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1728: iload 5
    //   1730: iconst_5
    //   1731: if_icmpne +16 -> 1747
    //   1734: aload_0
    //   1735: aload_1
    //   1736: iload_3
    //   1737: invokespecial 1518	com/tencent/smtt/sdk/q:h	(Landroid/content/Context;I)V
    //   1740: ldc_w 1506
    //   1743: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1746: return
    //   1747: iload_3
    //   1748: ifne +114 -> 1862
    //   1751: ldc 151
    //   1753: ldc_w 1520
    //   1756: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1759: aload_1
    //   1760: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1763: ldc_w 1322
    //   1766: iconst_0
    //   1767: invokevirtual 187	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   1770: aload_1
    //   1771: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1774: sipush -544
    //   1777: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1780: aload_1
    //   1781: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1784: iconst_0
    //   1785: iconst_m1
    //   1786: invokevirtual 348	com/tencent/smtt/sdk/n:c	(II)V
    //   1789: aload_1
    //   1790: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1793: iconst_1
    //   1794: invokevirtual 350	com/tencent/smtt/sdk/n:c	(I)V
    //   1797: aload 12
    //   1799: ldc_w 1549
    //   1802: invokevirtual 1047	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1805: astore 13
    //   1807: new 293	java/io/File
    //   1810: dup
    //   1811: aload 13
    //   1813: invokespecial 366	java/io/File:<init>	(Ljava/lang/String;)V
    //   1816: aload_1
    //   1817: invokestatic 673	com/tencent/smtt/sdk/m:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1820: aload_0
    //   1821: aload_1
    //   1822: aload 13
    //   1824: aload 12
    //   1826: ldc_w 1551
    //   1829: invokevirtual 1042	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1832: invokespecial 740	com/tencent/smtt/sdk/q:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1835: aload_1
    //   1836: invokestatic 567	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1839: ifeq +11 -> 1850
    //   1842: aload_1
    //   1843: invokestatic 179	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1846: iconst_m1
    //   1847: invokevirtual 350	com/tencent/smtt/sdk/n:c	(I)V
    //   1850: iconst_0
    //   1851: invokestatic 1234	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1854: ldc_w 1506
    //   1857: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1860: aload_2
    //   1861: athrow
    //   1862: iload_3
    //   1863: iconst_2
    //   1864: if_icmpne +14 -> 1878
    //   1867: ldc 151
    //   1869: ldc_w 1525
    //   1872: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1875: goto -25 -> 1850
    //   1878: aload_1
    //   1879: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1882: sipush -546
    //   1885: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1888: ldc 151
    //   1890: ldc_w 1527
    //   1893: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1896: aload_1
    //   1897: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1900: getfield 913	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1903: ldc_w 915
    //   1906: getstatic 921	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1909: invokeinterface 927 3 0
    //   1914: pop
    //   1915: aload_1
    //   1916: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1919: invokevirtual 931	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1922: aload_1
    //   1923: invokestatic 567	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1926: ifeq +26 -> 1952
    //   1929: aload_1
    //   1930: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1933: sipush 235
    //   1936: ldc_w 1529
    //   1939: iload_3
    //   1940: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1943: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1946: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1949: goto -99 -> 1850
    //   1952: aload_1
    //   1953: invokestatic 258	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1956: sipush 217
    //   1959: ldc_w 1531
    //   1962: iload_3
    //   1963: invokestatic 482	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1966: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1969: invokevirtual 265	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1972: goto -122 -> 1850
    //   1975: aload_1
    //   1976: invokestatic 196	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1979: sipush -547
    //   1982: invokevirtual 475	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1985: aload_0
    //   1986: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   1989: ldc_w 1506
    //   1992: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1995: return
    //   1996: astore_2
    //   1997: aload 13
    //   1999: astore 12
    //   2001: iload 4
    //   2003: istore_3
    //   2004: goto -288 -> 1716
    //   2007: astore_2
    //   2008: iconst_1
    //   2009: istore_3
    //   2010: aload 13
    //   2012: astore 12
    //   2014: goto -298 -> 1716
    //   2017: astore_2
    //   2018: goto -302 -> 1716
    //   2021: astore_2
    //   2022: iconst_2
    //   2023: istore_3
    //   2024: aload 14
    //   2026: astore 12
    //   2028: goto -733 -> 1295
    //   2031: astore_2
    //   2032: aload 16
    //   2034: astore 12
    //   2036: goto -741 -> 1295
    //   2039: astore_2
    //   2040: iconst_1
    //   2041: istore_3
    //   2042: goto -747 -> 1295
    //   2045: iconst_2
    //   2046: istore 4
    //   2048: aload 17
    //   2050: astore 13
    //   2052: goto -871 -> 1181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2055	0	this	q
    //   0	2055	1	paramContext	Context
    //   0	2055	2	paramBundle	Bundle
    //   292	1750	3	i1	int
    //   303	1744	4	i2	int
    //   243	1489	5	i3	int
    //   314	19	6	i4	int
    //   104	29	7	l1	long
    //   113	31	9	l2	long
    //   204	19	11	bool	boolean
    //   255	1780	12	localObject1	Object
    //   262	1789	13	localObject2	Object
    //   266	1759	14	localObject3	Object
    //   249	869	15	localObject4	Object
    //   246	1787	16	localObject5	Object
    //   258	1791	17	str	String
    //   252	65	18	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   1241	1284	1294	java/lang/Exception
    //   268	272	1709	finally
    //   286	293	1709	finally
    //   557	565	1709	finally
    //   573	584	1709	finally
    //   592	596	1709	finally
    //   683	694	1709	finally
    //   707	715	1709	finally
    //   723	732	1709	finally
    //   740	749	1709	finally
    //   757	765	1709	finally
    //   773	781	1709	finally
    //   789	801	1709	finally
    //   809	817	1709	finally
    //   825	837	1709	finally
    //   845	852	1709	finally
    //   860	871	1709	finally
    //   879	898	1709	finally
    //   906	913	1709	finally
    //   921	934	1709	finally
    //   997	1010	1709	finally
    //   1018	1024	1709	finally
    //   1037	1051	1709	finally
    //   1059	1067	1709	finally
    //   1075	1083	1709	finally
    //   1091	1099	1709	finally
    //   1107	1117	1709	finally
    //   1125	1132	1709	finally
    //   1221	1230	1709	finally
    //   305	316	1996	finally
    //   323	336	1996	finally
    //   1302	1327	1996	finally
    //   1141	1174	2007	finally
    //   1331	1341	2007	finally
    //   1345	1359	2007	finally
    //   1241	1284	2017	finally
    //   268	272	2021	java/lang/Exception
    //   286	293	2021	java/lang/Exception
    //   557	565	2021	java/lang/Exception
    //   573	584	2021	java/lang/Exception
    //   592	596	2021	java/lang/Exception
    //   683	694	2021	java/lang/Exception
    //   707	715	2021	java/lang/Exception
    //   723	732	2021	java/lang/Exception
    //   740	749	2021	java/lang/Exception
    //   757	765	2021	java/lang/Exception
    //   773	781	2021	java/lang/Exception
    //   789	801	2021	java/lang/Exception
    //   809	817	2021	java/lang/Exception
    //   825	837	2021	java/lang/Exception
    //   845	852	2021	java/lang/Exception
    //   860	871	2021	java/lang/Exception
    //   879	898	2021	java/lang/Exception
    //   906	913	2021	java/lang/Exception
    //   921	934	2021	java/lang/Exception
    //   997	1010	2021	java/lang/Exception
    //   1018	1024	2021	java/lang/Exception
    //   1037	1051	2021	java/lang/Exception
    //   1059	1067	2021	java/lang/Exception
    //   1075	1083	2021	java/lang/Exception
    //   1091	1099	2021	java/lang/Exception
    //   1107	1117	2021	java/lang/Exception
    //   1125	1132	2021	java/lang/Exception
    //   1221	1230	2021	java/lang/Exception
    //   305	316	2031	java/lang/Exception
    //   323	336	2031	java/lang/Exception
    //   1141	1174	2039	java/lang/Exception
  }
  
  void b(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(192608);
    TbsLog.v("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.v("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded currentProcessId=" + android.os.Process.myPid());
    TbsLog.v("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded currentThreadName=" + Thread.currentThread().getName());
    if (QbSdk.b)
    {
      AppMethodBeat.o(192608);
      return;
    }
    if (Build.VERSION.SDK_INT < 8)
    {
      TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
      AppMethodBeat.o(192608);
      return;
    }
    TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #1 ");
    File localFile;
    if ((TbsShareManager.isThirdPartyApp(paramContext)) && (n.a(paramContext).b("remove_old_core") == 1) && (paramBoolean)) {
      localFile = a().r(paramContext);
    }
    try
    {
      f.b(localFile);
      TbsLog.i("TbsInstaller", "thirdAPP success--> delete old core_share Directory");
      label175:
      n.a(paramContext).a("remove_old_core", 0);
      if (w(paramContext))
      {
        TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #2 ");
        if ((a(paramContext, "core_unzip_tmp")) && (e(paramContext, paramBoolean)))
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!", true);
          AppMethodBeat.o(192608);
          return;
        }
        if ((a(paramContext, "core_share_backup_tmp")) && (f(paramContext, paramBoolean)))
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!", true);
          AppMethodBeat.o(192608);
          return;
        }
        if ((a(paramContext, "core_copy_tmp")) && (d(paramContext, paramBoolean)))
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!", true);
          AppMethodBeat.o(192608);
          return;
        }
        if ((a(paramContext, "tpatch_tmp")) && (c(paramContext, paramBoolean)))
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch!!", true);
          AppMethodBeat.o(192608);
          return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
        AppMethodBeat.o(192608);
        return;
      }
      AppMethodBeat.o(192608);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label175;
    }
  }
  
  public boolean b(Context paramContext)
  {
    AppMethodBeat.i(192607);
    if (w(paramContext))
    {
      if ((a(paramContext, "core_unzip_tmp")) || (a(paramContext, "core_share_backup_tmp")) || (a(paramContext, "core_copy_tmp")) || (a(paramContext, "tpatch_tmp")))
      {
        AppMethodBeat.o(192607);
        return true;
      }
      AppMethodBeat.o(192607);
      return false;
    }
    AppMethodBeat.o(192607);
    return false;
  }
  
  boolean b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(192620);
    if (TbsDownloader.getOverSea(paramContext))
    {
      AppMethodBeat.o(192620);
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
      AppMethodBeat.o(192620);
      return true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
    AppMethodBeat.o(192620);
    return false;
  }
  
  public boolean b(Context paramContext, File paramFile, int paramInt)
  {
    AppMethodBeat.i(192630);
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
    boolean bool = a(paramContext, paramFile, false);
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is ".concat(String.valueOf(bool)));
    if (bool) {
      a().a(paramContext, paramInt);
    }
    AppMethodBeat.o(192630);
    return bool;
  }
  
  int c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(192640);
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramContext != null)
    {
      int i1 = paramContext.versionCode;
      AppMethodBeat.o(192640);
      return i1;
    }
    AppMethodBeat.o(192640);
    return 0;
  }
  
  File c(Context paramContext1, Context paramContext2)
  {
    AppMethodBeat.i(192665);
    paramContext2 = new File(QbSdk.getTbsFolderDir(paramContext2), "core_share_decouple");
    if ((!paramContext2.isDirectory()) && ((paramContext1 == null) || (!TbsShareManager.isThirdPartyApp(paramContext1))) && (!paramContext2.mkdir()))
    {
      AppMethodBeat.o(192665);
      return null;
    }
    AppMethodBeat.o(192665);
    return paramContext2;
  }
  
  public void c(Context paramContext)
  {
    AppMethodBeat.i(192613);
    g(paramContext, true);
    n.a(paramContext).c(i(paramContext), 2);
    AppMethodBeat.o(192613);
  }
  
  void c(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(192626);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
    if (paramInt <= 0)
    {
      AppMethodBeat.o(192626);
      return;
    }
    int i1 = j(paramContext);
    if (i1 == paramInt)
    {
      AppMethodBeat.o(192626);
      return;
    }
    Context localContext = TbsShareManager.e(paramContext);
    if ((localContext != null) || (TbsShareManager.getHostCorePathAppDefined() != null))
    {
      TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
      a(paramContext, localContext);
      AppMethodBeat.o(192626);
      return;
    }
    if (i1 <= 0)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
      QbSdk.a(paramContext, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
    }
    AppMethodBeat.o(192626);
  }
  
  public Context d(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(192639);
    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=".concat(String.valueOf(paramInt)));
    if (paramInt <= 0)
    {
      AppMethodBeat.o(192639);
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
          if (g(localContext)) {
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
        i2 = j(localContext);
        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=".concat(String.valueOf(i2)));
      } while ((i2 == 0) || (i2 != paramInt));
      TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + arrayOfString[i1]);
      AppMethodBeat.o(192639);
      return localContext;
    }
    AppMethodBeat.o(192639);
    return null;
  }
  
  /* Error */
  public String d(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 1661
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 1085	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 1661
    //   16: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: new 293	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 272	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   30: ldc_w 390
    //   33: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   36: astore_1
    //   37: aload_1
    //   38: invokevirtual 606	java/io/File:exists	()Z
    //   41: istore_3
    //   42: iload_3
    //   43: ifne +11 -> 54
    //   46: ldc_w 1661
    //   49: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aconst_null
    //   53: areturn
    //   54: new 392	java/util/Properties
    //   57: dup
    //   58: invokespecial 393	java/util/Properties:<init>	()V
    //   61: astore 4
    //   63: new 395	java/io/BufferedInputStream
    //   66: dup
    //   67: new 397	java/io/FileInputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 400	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   75: invokespecial 403	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   78: astore_1
    //   79: aload 4
    //   81: aload_1
    //   82: invokevirtual 406	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   85: aload_1
    //   86: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   89: aload 4
    //   91: aload_2
    //   92: invokevirtual 1353	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore_2
    //   96: aload_1
    //   97: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   100: ldc_w 1661
    //   103: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_2
    //   107: areturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +7 -> 119
    //   115: aload_1
    //   116: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   119: ldc_w 1661
    //   122: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   138: ldc_w 1661
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
    //   0	174	0	this	q
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
  boolean d(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 1662
    //   5: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 293	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 272	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   17: ldc_w 390
    //   20: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore 5
    //   25: aload 5
    //   27: invokevirtual 606	java/io/File:exists	()Z
    //   30: ifne +11 -> 41
    //   33: ldc_w 1662
    //   36: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: iconst_0
    //   40: ireturn
    //   41: new 392	java/util/Properties
    //   44: dup
    //   45: invokespecial 393	java/util/Properties:<init>	()V
    //   48: astore 6
    //   50: new 395	java/io/BufferedInputStream
    //   53: dup
    //   54: new 397	java/io/FileInputStream
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 400	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 403	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore_1
    //   67: aload 6
    //   69: aload_1
    //   70: invokevirtual 406	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload 6
    //   75: ldc_w 416
    //   78: ldc_w 1664
    //   81: invokevirtual 643	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   84: invokestatic 1667	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   87: invokevirtual 948	java/lang/Boolean:booleanValue	()Z
    //   90: istore 4
    //   92: iload 4
    //   94: ifeq +165 -> 259
    //   97: invokestatic 586	java/lang/System:currentTimeMillis	()J
    //   100: aload 5
    //   102: invokevirtual 1670	java/io/File:lastModified	()J
    //   105: lsub
    //   106: ldc2_w 1671
    //   109: lcmp
    //   110: ifle +61 -> 171
    //   113: iconst_1
    //   114: istore_3
    //   115: ldc 151
    //   117: new 233	java/lang/StringBuilder
    //   120: dup
    //   121: ldc_w 1674
    //   124: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: iload 4
    //   129: invokevirtual 781	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   132: ldc_w 1676
    //   135: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iload_3
    //   139: invokevirtual 781	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   142: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: iload_3
    //   149: ifne +27 -> 176
    //   152: iload 4
    //   154: iload_2
    //   155: iand
    //   156: istore 4
    //   158: aload_1
    //   159: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   162: ldc_w 1662
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
    //   194: invokevirtual 432	java/io/BufferedInputStream:close	()V
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
    //   219: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   222: ldc_w 1662
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
    //   0	264	0	this	q
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
  
  int e(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(192647);
    paramInt = a(f(paramContext, paramInt));
    AppMethodBeat.o(192647);
    return paramInt;
  }
  
  /* Error */
  public void e(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 1679
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 293	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 272	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   15: ldc_w 390
    //   18: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore_1
    //   22: new 392	java/util/Properties
    //   25: dup
    //   26: invokespecial 393	java/util/Properties:<init>	()V
    //   29: astore_3
    //   30: new 395	java/io/BufferedInputStream
    //   33: dup
    //   34: new 397	java/io/FileInputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 400	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 403	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_2
    //   46: aload_3
    //   47: aload_2
    //   48: invokevirtual 406	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   51: new 408	java/io/BufferedOutputStream
    //   54: dup
    //   55: new 410	java/io/FileOutputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 411	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 414	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   66: astore_1
    //   67: aload_3
    //   68: ldc_w 416
    //   71: ldc_w 1664
    //   74: invokevirtual 422	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   77: pop
    //   78: aload_3
    //   79: aload_1
    //   80: aconst_null
    //   81: invokevirtual 426	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   84: aload_1
    //   85: invokevirtual 431	java/io/BufferedOutputStream:close	()V
    //   88: aload_2
    //   89: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   92: ldc_w 1679
    //   95: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: return
    //   99: astore_1
    //   100: ldc_w 1679
    //   103: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: return
    //   107: astore_1
    //   108: ldc_w 1679
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
    //   125: invokevirtual 431	java/io/BufferedOutputStream:close	()V
    //   128: aload_2
    //   129: ifnull +51 -> 180
    //   132: aload_2
    //   133: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   136: ldc_w 1679
    //   139: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: return
    //   143: astore_1
    //   144: ldc_w 1679
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
    //   161: invokevirtual 431	java/io/BufferedOutputStream:close	()V
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   172: ldc_w 1679
    //   175: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aload_1
    //   179: athrow
    //   180: ldc_w 1679
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
    //   0	241	0	this	q
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
  
  File f(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(192669);
    paramContext = a(paramContext, paramInt, true);
    AppMethodBeat.o(192669);
    return paramContext;
  }
  
  public boolean f(Context paramContext)
  {
    AppMethodBeat.i(192634);
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
          AppMethodBeat.o(192634);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(192634);
        return false;
      }
      i1 += 1;
    }
  }
  
  boolean g(Context paramContext)
  {
    AppMethodBeat.i(192638);
    if (TbsShareManager.getHostCorePathAppDefined() != null)
    {
      AppMethodBeat.o(192638);
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
          AppMethodBeat.o(192638);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.mm"))
      {
        bool = localSignature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499");
        if (!bool)
        {
          AppMethodBeat.o(192638);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.mobileqq"))
      {
        bool = localSignature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049");
        if (!bool)
        {
          AppMethodBeat.o(192638);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.tbs"))
      {
        bool = localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a");
        if (!bool)
        {
          AppMethodBeat.o(192638);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.qzone"))
      {
        bool = localSignature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677");
        if (!bool)
        {
          AppMethodBeat.o(192638);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.qqpimsecure"))
      {
        bool = localSignature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
        if (!bool)
        {
          AppMethodBeat.o(192638);
          return false;
        }
      }
    }
    catch (Exception paramContext)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
      AppMethodBeat.o(192638);
      return false;
    }
    AppMethodBeat.o(192638);
    return true;
  }
  
  boolean g(Context paramContext, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(192671);
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
          AppMethodBeat.o(192671);
          return true;
        }
        TbsLog.e("TbsInstaller", "321");
        AppMethodBeat.o(192671);
        return false;
      }
      localFile = r(paramContext);
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
      AppMethodBeat.o(192671);
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
  
  public void h(Context paramContext)
  {
    AppMethodBeat.i(192641);
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
    AppMethodBeat.o(192641);
  }
  
  /* Error */
  int i(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 1756
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: new 293	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 576	com/tencent/smtt/sdk/q:q	(Landroid/content/Context;)Ljava/io/File;
    //   18: ldc_w 390
    //   21: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 606	java/io/File:exists	()Z
    //   29: istore_3
    //   30: iload_3
    //   31: ifne +11 -> 42
    //   34: ldc_w 1756
    //   37: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_0
    //   41: ireturn
    //   42: new 392	java/util/Properties
    //   45: dup
    //   46: invokespecial 393	java/util/Properties:<init>	()V
    //   49: astore 5
    //   51: new 395	java/io/BufferedInputStream
    //   54: dup
    //   55: new 397	java/io/FileInputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 400	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 403	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore_1
    //   67: aload 5
    //   69: aload_1
    //   70: invokevirtual 406	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload_1
    //   74: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   77: aload 5
    //   79: ldc_w 1352
    //   82: invokevirtual 1353	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 4
    //   87: aload 4
    //   89: ifnonnull +15 -> 104
    //   92: aload_1
    //   93: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   96: ldc_w 1756
    //   99: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: iconst_0
    //   103: ireturn
    //   104: aload 4
    //   106: invokestatic 1356	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   109: istore_2
    //   110: aload_1
    //   111: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   114: ldc_w 1756
    //   117: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: iload_2
    //   121: ireturn
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_1
    //   125: aload_1
    //   126: ifnull +7 -> 133
    //   129: aload_1
    //   130: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   133: ldc_w 1756
    //   136: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_1
    //   142: aload 4
    //   144: ifnull +8 -> 152
    //   147: aload 4
    //   149: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   152: ldc_w 1756
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
    //   0	193	0	this	q
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
  int j(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 1757
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 151
    //   8: ldc_w 1759
    //   11: invokestatic 610	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: new 293	java/io/File
    //   17: dup
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 272	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   23: ldc_w 390
    //   26: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 606	java/io/File:exists	()Z
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +11 -> 47
    //   39: ldc_w 1757
    //   42: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iconst_0
    //   46: ireturn
    //   47: new 392	java/util/Properties
    //   50: dup
    //   51: invokespecial 393	java/util/Properties:<init>	()V
    //   54: astore 5
    //   56: new 395	java/io/BufferedInputStream
    //   59: dup
    //   60: new 397	java/io/FileInputStream
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 400	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   68: invokespecial 403	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore 4
    //   73: aload 4
    //   75: astore_1
    //   76: aload 5
    //   78: aload 4
    //   80: invokevirtual 406	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   83: aload 4
    //   85: astore_1
    //   86: aload 4
    //   88: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   91: aload 4
    //   93: astore_1
    //   94: aload 5
    //   96: ldc_w 1352
    //   99: invokevirtual 1353	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 5
    //   104: aload 5
    //   106: ifnonnull +45 -> 151
    //   109: aload 4
    //   111: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   114: ldc_w 1757
    //   117: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: iconst_0
    //   121: ireturn
    //   122: astore_1
    //   123: ldc 151
    //   125: new 233	java/lang/StringBuilder
    //   128: dup
    //   129: ldc_w 1761
    //   132: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload_1
    //   136: invokevirtual 1762	java/io/IOException:toString	()Ljava/lang/String;
    //   139: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: goto -34 -> 114
    //   151: aload 4
    //   153: astore_1
    //   154: aload 5
    //   156: invokestatic 1356	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   159: istore_2
    //   160: aload 4
    //   162: astore_1
    //   163: getstatic 119	com/tencent/smtt/sdk/q:o	I
    //   166: ifne +10 -> 176
    //   169: aload 4
    //   171: astore_1
    //   172: iload_2
    //   173: putstatic 119	com/tencent/smtt/sdk/q:o	I
    //   176: aload 4
    //   178: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   181: ldc_w 1757
    //   184: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: iload_2
    //   188: ireturn
    //   189: astore_1
    //   190: ldc 151
    //   192: new 233	java/lang/StringBuilder
    //   195: dup
    //   196: ldc_w 1761
    //   199: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: aload_1
    //   203: invokevirtual 1762	java/io/IOException:toString	()Ljava/lang/String;
    //   206: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: goto -34 -> 181
    //   218: astore 5
    //   220: aconst_null
    //   221: astore 4
    //   223: aload 4
    //   225: astore_1
    //   226: ldc 151
    //   228: new 233	java/lang/StringBuilder
    //   231: dup
    //   232: ldc_w 1764
    //   235: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   238: aload 5
    //   240: invokevirtual 261	java/lang/Exception:toString	()Ljava/lang/String;
    //   243: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload 4
    //   254: ifnull +8 -> 262
    //   257: aload 4
    //   259: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   262: ldc_w 1757
    //   265: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: iconst_0
    //   269: ireturn
    //   270: astore_1
    //   271: ldc 151
    //   273: new 233	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 1761
    //   280: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload_1
    //   284: invokevirtual 1762	java/io/IOException:toString	()Ljava/lang/String;
    //   287: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: goto -34 -> 262
    //   299: astore 4
    //   301: aconst_null
    //   302: astore_1
    //   303: aload_1
    //   304: ifnull +7 -> 311
    //   307: aload_1
    //   308: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   311: ldc_w 1757
    //   314: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: aload 4
    //   319: athrow
    //   320: astore_1
    //   321: ldc 151
    //   323: new 233	java/lang/StringBuilder
    //   326: dup
    //   327: ldc_w 1761
    //   330: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   333: aload_1
    //   334: invokevirtual 1762	java/io/IOException:toString	()Ljava/lang/String;
    //   337: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: goto -35 -> 311
    //   349: astore 4
    //   351: goto -48 -> 303
    //   354: astore 5
    //   356: goto -133 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	q
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
  
  int k(Context paramContext)
  {
    AppMethodBeat.i(192652);
    if (o != 0)
    {
      i1 = o;
      AppMethodBeat.o(192652);
      return i1;
    }
    int i1 = j(paramContext);
    AppMethodBeat.o(192652);
    return i1;
  }
  
  void l(Context paramContext)
  {
    AppMethodBeat.i(192653);
    if (o != 0)
    {
      AppMethodBeat.o(192653);
      return;
    }
    o = j(paramContext);
    AppMethodBeat.o(192653);
  }
  
  boolean m(Context paramContext)
  {
    AppMethodBeat.i(192654);
    if (!new File(r(paramContext), "tbs.conf").exists())
    {
      AppMethodBeat.o(192654);
      return false;
    }
    AppMethodBeat.o(192654);
    return true;
  }
  
  /* Error */
  int n(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 1768
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 502	com/tencent/smtt/sdk/q:u	(Landroid/content/Context;)Z
    //   11: ifne +11 -> 22
    //   14: ldc_w 1768
    //   17: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_m1
    //   21: ireturn
    //   22: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   25: invokevirtual 1141	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   28: istore_3
    //   29: ldc 151
    //   31: ldc_w 1770
    //   34: iload_3
    //   35: invokestatic 304	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   38: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: iload_3
    //   45: ifeq +536 -> 581
    //   48: new 293	java/io/File
    //   51: dup
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 272	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   57: ldc_w 390
    //   60: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual 606	java/io/File:exists	()Z
    //   68: istore_3
    //   69: iload_3
    //   70: ifne +49 -> 119
    //   73: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   76: invokevirtual 1773	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   79: ifeq +9 -> 88
    //   82: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   85: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   88: aload_0
    //   89: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   92: ldc_w 1768
    //   95: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: iconst_0
    //   99: ireturn
    //   100: astore_1
    //   101: ldc 151
    //   103: ldc_w 1775
    //   106: aload_1
    //   107: invokestatic 818	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   110: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   113: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: goto -28 -> 88
    //   119: new 392	java/util/Properties
    //   122: dup
    //   123: invokespecial 393	java/util/Properties:<init>	()V
    //   126: astore 5
    //   128: new 395	java/io/BufferedInputStream
    //   131: dup
    //   132: new 397	java/io/FileInputStream
    //   135: dup
    //   136: aload_1
    //   137: invokespecial 400	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   140: invokespecial 403	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   143: astore 4
    //   145: aload 4
    //   147: astore_1
    //   148: aload 5
    //   150: aload 4
    //   152: invokevirtual 406	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   155: aload 4
    //   157: astore_1
    //   158: aload 4
    //   160: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   163: aload 4
    //   165: astore_1
    //   166: aload 5
    //   168: ldc_w 1352
    //   171: invokevirtual 1353	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   174: astore 5
    //   176: aload 5
    //   178: ifnonnull +83 -> 261
    //   181: aload 4
    //   183: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   186: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   189: invokevirtual 1773	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   192: ifeq +9 -> 201
    //   195: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   198: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   201: aload_0
    //   202: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   205: ldc_w 1768
    //   208: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: iconst_0
    //   212: ireturn
    //   213: astore_1
    //   214: ldc 151
    //   216: new 233	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 1777
    //   223: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload_1
    //   227: invokevirtual 1762	java/io/IOException:toString	()Ljava/lang/String;
    //   230: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: goto -53 -> 186
    //   242: astore_1
    //   243: ldc 151
    //   245: ldc_w 1775
    //   248: aload_1
    //   249: invokestatic 818	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   252: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   255: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: goto -57 -> 201
    //   261: aload 4
    //   263: astore_1
    //   264: getstatic 74	com/tencent/smtt/sdk/q:a	Ljava/lang/ThreadLocal;
    //   267: aload 5
    //   269: invokestatic 1356	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   272: invokestatic 223	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   275: invokevirtual 229	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   278: aload 4
    //   280: astore_1
    //   281: getstatic 74	com/tencent/smtt/sdk/q:a	Ljava/lang/ThreadLocal;
    //   284: invokevirtual 1362	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   287: checkcast 220	java/lang/Integer
    //   290: invokevirtual 1365	java/lang/Integer:intValue	()I
    //   293: istore_2
    //   294: aload 4
    //   296: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   299: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   302: invokevirtual 1773	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   305: ifeq +9 -> 314
    //   308: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   311: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   314: aload_0
    //   315: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   318: ldc_w 1768
    //   321: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: iload_2
    //   325: ireturn
    //   326: astore_1
    //   327: ldc 151
    //   329: new 233	java/lang/StringBuilder
    //   332: dup
    //   333: ldc_w 1777
    //   336: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   339: aload_1
    //   340: invokevirtual 1762	java/io/IOException:toString	()Ljava/lang/String;
    //   343: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: goto -53 -> 299
    //   355: astore_1
    //   356: ldc 151
    //   358: ldc_w 1775
    //   361: aload_1
    //   362: invokestatic 818	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   365: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   368: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: goto -57 -> 314
    //   374: astore 5
    //   376: aconst_null
    //   377: astore 4
    //   379: aload 4
    //   381: astore_1
    //   382: ldc 151
    //   384: new 233	java/lang/StringBuilder
    //   387: dup
    //   388: ldc_w 1779
    //   391: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: aload 5
    //   396: invokevirtual 261	java/lang/Exception:toString	()Ljava/lang/String;
    //   399: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: aload 4
    //   410: ifnull +8 -> 418
    //   413: aload 4
    //   415: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   418: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   421: invokevirtual 1773	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   424: ifeq +9 -> 433
    //   427: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   430: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   433: aload_0
    //   434: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   437: ldc_w 1768
    //   440: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   443: iconst_0
    //   444: ireturn
    //   445: astore_1
    //   446: ldc 151
    //   448: new 233	java/lang/StringBuilder
    //   451: dup
    //   452: ldc_w 1777
    //   455: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   458: aload_1
    //   459: invokevirtual 1762	java/io/IOException:toString	()Ljava/lang/String;
    //   462: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: goto -53 -> 418
    //   474: astore_1
    //   475: ldc 151
    //   477: ldc_w 1775
    //   480: aload_1
    //   481: invokestatic 818	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   484: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   487: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   490: goto -57 -> 433
    //   493: astore 4
    //   495: aconst_null
    //   496: astore_1
    //   497: aload_1
    //   498: ifnull +7 -> 505
    //   501: aload_1
    //   502: invokevirtual 432	java/io/BufferedInputStream:close	()V
    //   505: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   508: invokevirtual 1773	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   511: ifeq +9 -> 520
    //   514: getstatic 65	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   517: invokevirtual 532	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   520: aload_0
    //   521: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   524: ldc_w 1768
    //   527: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   530: aload 4
    //   532: athrow
    //   533: astore_1
    //   534: ldc 151
    //   536: new 233	java/lang/StringBuilder
    //   539: dup
    //   540: ldc_w 1777
    //   543: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   546: aload_1
    //   547: invokevirtual 1762	java/io/IOException:toString	()Ljava/lang/String;
    //   550: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: goto -54 -> 505
    //   562: astore_1
    //   563: ldc 151
    //   565: ldc_w 1775
    //   568: aload_1
    //   569: invokestatic 818	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   572: invokevirtual 308	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   575: invokestatic 455	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: goto -58 -> 520
    //   581: aload_0
    //   582: invokevirtual 535	com/tencent/smtt/sdk/q:b	()V
    //   585: ldc_w 1768
    //   588: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   591: iconst_0
    //   592: ireturn
    //   593: astore 4
    //   595: goto -98 -> 497
    //   598: astore 5
    //   600: goto -221 -> 379
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	this	q
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
  
  public boolean o(Context paramContext)
  {
    AppMethodBeat.i(192658);
    TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
    File localFile1 = r(paramContext);
    File localFile2 = q(paramContext);
    try
    {
      f.a(localFile2, true);
      f.a(localFile1, localFile2, new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          AppMethodBeat.i(192553);
          if ((!paramAnonymousFile.getName().endsWith(".dex")) && (!paramAnonymousFile.getName().endsWith(".jar_is_first_load_dex_flag_file")))
          {
            AppMethodBeat.o(192553);
            return true;
          }
          AppMethodBeat.o(192553);
          return false;
        }
      });
      TbsShareManager.b(paramContext);
      TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
      AppMethodBeat.o(192658);
      return true;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(192658);
    }
    return false;
  }
  
  void p(Context paramContext)
  {
    AppMethodBeat.i(192662);
    TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
    n.a(paramContext).a(0);
    n.a(paramContext).b(0);
    n.a(paramContext).d(0);
    n.a(paramContext).a("incrupdate_retry_num", 0);
    if (!TbsDownloader.a(paramContext))
    {
      n.a(paramContext).c(0, -1);
      n.a(paramContext).a("");
      n.a(paramContext).a("copy_retry_num", 0);
      n.a(paramContext).c(-1);
      n.a(paramContext).a(0, -1);
      f.a(f(paramContext, 0), true);
      f.a(f(paramContext, 1), true);
    }
    AppMethodBeat.o(192662);
  }
  
  File q(Context paramContext)
  {
    AppMethodBeat.i(192664);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_share_decouple");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(192664);
      return null;
    }
    AppMethodBeat.o(192664);
    return paramContext;
  }
  
  File r(Context paramContext)
  {
    AppMethodBeat.i(192666);
    paramContext = b(paramContext, paramContext);
    AppMethodBeat.o(192666);
    return paramContext;
  }
  
  File s(Context paramContext)
  {
    AppMethodBeat.i(192667);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "share");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(192667);
      return null;
    }
    AppMethodBeat.o(192667);
    return paramContext;
  }
  
  /* Error */
  boolean u(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 1797
    //   7: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc 151
    //   12: new 233	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 1799
    //   19: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: invokestatic 840	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   25: invokevirtual 1492	java/lang/Thread:getId	()J
    //   28: invokevirtual 561	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   31: ldc_w 725
    //   34: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: getfield 128	com/tencent/smtt/sdk/q:e	I
    //   41: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 610	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 128	com/tencent/smtt/sdk/q:e	I
    //   54: ifle +31 -> 85
    //   57: ldc 151
    //   59: ldc_w 1801
    //   62: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_0
    //   66: aload_0
    //   67: getfield 128	com/tencent/smtt/sdk/q:e	I
    //   70: iconst_1
    //   71: iadd
    //   72: putfield 128	com/tencent/smtt/sdk/q:e	I
    //   75: ldc_w 1797
    //   78: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: monitorexit
    //   83: iload_2
    //   84: ireturn
    //   85: aload_0
    //   86: aload_1
    //   87: iconst_1
    //   88: ldc_w 1803
    //   91: invokestatic 1806	com/tencent/smtt/utils/f:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   94: putfield 1502	com/tencent/smtt/sdk/q:g	Ljava/io/FileOutputStream;
    //   97: aload_0
    //   98: getfield 1502	com/tencent/smtt/sdk/q:g	Ljava/io/FileOutputStream;
    //   101: ifnull +41 -> 142
    //   104: aload_0
    //   105: aload_1
    //   106: aload_0
    //   107: getfield 1502	com/tencent/smtt/sdk/q:g	Ljava/io/FileOutputStream;
    //   110: invokestatic 1809	com/tencent/smtt/utils/f:a	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   113: putfield 1500	com/tencent/smtt/sdk/q:f	Ljava/nio/channels/FileLock;
    //   116: aload_0
    //   117: getfield 1500	com/tencent/smtt/sdk/q:f	Ljava/nio/channels/FileLock;
    //   120: ifnonnull +41 -> 161
    //   123: ldc 151
    //   125: ldc_w 1811
    //   128: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: ldc_w 1797
    //   134: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iconst_0
    //   138: istore_2
    //   139: goto -58 -> 81
    //   142: ldc 151
    //   144: ldc_w 1813
    //   147: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: ldc_w 1797
    //   153: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_0
    //   157: istore_2
    //   158: goto -77 -> 81
    //   161: ldc 151
    //   163: ldc_w 1815
    //   166: invokestatic 158	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: aload_0
    //   171: getfield 128	com/tencent/smtt/sdk/q:e	I
    //   174: iconst_1
    //   175: iadd
    //   176: putfield 128	com/tencent/smtt/sdk/q:e	I
    //   179: ldc_w 1797
    //   182: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: goto -104 -> 81
    //   188: astore_1
    //   189: aload_0
    //   190: monitorexit
    //   191: aload_1
    //   192: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	q
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
 * Qualified Name:     com.tencent.smtt.sdk.q
 * JD-Core Version:    0.7.0.1
 */