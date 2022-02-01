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
    AppMethodBeat.i(219652);
    d = null;
    i = new ReentrantLock();
    j = new ReentrantLock();
    l = null;
    a = new q.1();
    m = null;
    n = new Long[][] { { Long.valueOf(44006L), Long.valueOf(39094008L) }, { Long.valueOf(44005L), Long.valueOf(39094008L) }, { Long.valueOf(43910L), Long.valueOf(38917816L) }, { Long.valueOf(44027L), Long.valueOf(39094008L) }, { Long.valueOf(44028L), Long.valueOf(39094008L) }, { Long.valueOf(44029L), Long.valueOf(39094008L) }, { Long.valueOf(44030L), Long.valueOf(39094008L) }, { Long.valueOf(44032L), Long.valueOf(39094008L) }, { Long.valueOf(44033L), Long.valueOf(39094008L) }, { Long.valueOf(44034L), Long.valueOf(39094008L) }, { Long.valueOf(43909L), Long.valueOf(38917816L) } };
    b = false;
    c = new q.2();
    o = 0;
    p = false;
    AppMethodBeat.o(219652);
  }
  
  private q()
  {
    AppMethodBeat.i(219483);
    this.e = 0;
    this.h = false;
    this.k = false;
    if (m == null) {
      m = new Handler(o.a().getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(219663);
          QbSdk.setTBSInstallingStatus(true);
          switch (paramAnonymousMessage.what)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(219663);
            return;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
            paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
            q.a(q.this, (Context)paramAnonymousMessage[0], (String)paramAnonymousMessage[1], ((Integer)paramAnonymousMessage[2]).intValue());
            AppMethodBeat.o(219663);
            return;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
            paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
            q.a(q.this, (Context)paramAnonymousMessage[0], (Context)paramAnonymousMessage[1], ((Integer)paramAnonymousMessage[2]).intValue());
            AppMethodBeat.o(219663);
            return;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
            paramAnonymousMessage = (Object[])paramAnonymousMessage.obj;
            q.this.b((Context)paramAnonymousMessage[0], (Bundle)paramAnonymousMessage[1]);
            AppMethodBeat.o(219663);
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
    AppMethodBeat.o(219483);
  }
  
  private void A(Context paramContext)
  {
    AppMethodBeat.i(219628);
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
    if (!x(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      AppMethodBeat.o(219628);
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
      AppMethodBeat.o(219628);
      return;
      TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is " + i1 + " getTbsCoreShareDecoupleCoreVersion is " + a().i(paramContext) + " getTbsCoreInstalledVerInNolock is " + a().j(paramContext));
    }
  }
  
  private void B(Context paramContext)
  {
    AppMethodBeat.i(219629);
    TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
    com.tencent.smtt.utils.f.a(r(paramContext), false);
    AppMethodBeat.o(219629);
  }
  
  private void C(Context paramContext)
  {
    AppMethodBeat.i(219632);
    TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
    File localFile1 = f(paramContext, 0);
    File localFile2 = r(paramContext);
    if ((localFile1 == null) || (localFile2 == null))
    {
      TbsLog.i("TbsInstaller", "renameTbsCoreShareDir return,tmpTbsCoreUnzipDir=" + localFile1 + "tbsSharePath=" + localFile2);
      AppMethodBeat.o(219632);
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
      AppMethodBeat.o(219632);
      return;
      label152:
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(231, " ");
    }
  }
  
  private void D(Context paramContext)
  {
    AppMethodBeat.i(219635);
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
    File localFile1 = f(paramContext, 1);
    File localFile2 = r(paramContext);
    if ((localFile1 == null) || (localFile2 == null))
    {
      AppMethodBeat.o(219635);
      return;
    }
    localFile1.renameTo(localFile2);
    g(paramContext, false);
    AppMethodBeat.o(219635);
  }
  
  private void E(Context paramContext)
  {
    AppMethodBeat.i(219636);
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
    File localFile1 = f(paramContext, 5);
    File localFile2 = r(paramContext);
    if ((localFile1 == null) || (localFile2 == null))
    {
      AppMethodBeat.o(219636);
      return;
    }
    localFile1.renameTo(localFile2);
    g(paramContext, false);
    AppMethodBeat.o(219636);
  }
  
  private void F(Context paramContext)
  {
    AppMethodBeat.i(219637);
    TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
    File localFile = f(paramContext, 0);
    if (localFile != null) {
      com.tencent.smtt.utils.f.a(localFile, false);
    }
    n.a(paramContext).c(0, 5);
    n.a(paramContext).c(-1);
    QbSdk.a(paramContext, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    AppMethodBeat.o(219637);
  }
  
  /* Error */
  static q a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 356
    //   6: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 54	com/tencent/smtt/sdk/q:d	Lcom/tencent/smtt/sdk/q;
    //   12: ifnonnull +25 -> 37
    //   15: ldc 2
    //   17: monitorenter
    //   18: getstatic 54	com/tencent/smtt/sdk/q:d	Lcom/tencent/smtt/sdk/q;
    //   21: ifnonnull +13 -> 34
    //   24: new 2	com/tencent/smtt/sdk/q
    //   27: dup
    //   28: invokespecial 357	com/tencent/smtt/sdk/q:<init>	()V
    //   31: putstatic 54	com/tencent/smtt/sdk/q:d	Lcom/tencent/smtt/sdk/q;
    //   34: ldc 2
    //   36: monitorexit
    //   37: getstatic 54	com/tencent/smtt/sdk/q:d	Lcom/tencent/smtt/sdk/q;
    //   40: astore_0
    //   41: ldc_w 356
    //   44: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: ldc_w 356
    //   59: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   3	18	64	finally
    //   37	47	64	finally
    //   53	64	64	finally
  }
  
  /* Error */
  private void a(int paramInt, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 361
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 291	java/io/File
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 366	java/io/File:delete	()Z
    //   17: pop
    //   18: ldc 149
    //   20: new 231	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 368
    //   27: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_2
    //   31: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 370
    //   37: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: iconst_1
    //   44: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   47: new 291	java/io/File
    //   50: dup
    //   51: aload_3
    //   52: invokestatic 376	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   55: ldc_w 378
    //   58: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 384	java/io/File:canRead	()Z
    //   66: ifeq +149 -> 215
    //   69: new 291	java/io/File
    //   72: dup
    //   73: aload_2
    //   74: ldc_w 386
    //   77: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   80: astore_2
    //   81: new 388	java/util/Properties
    //   84: dup
    //   85: invokespecial 389	java/util/Properties:<init>	()V
    //   88: astore 4
    //   90: new 391	java/io/BufferedInputStream
    //   93: dup
    //   94: new 393	java/io/FileInputStream
    //   97: dup
    //   98: aload_2
    //   99: invokespecial 396	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   102: invokespecial 399	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   105: astore_3
    //   106: aload 4
    //   108: aload_3
    //   109: invokevirtual 402	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   112: new 404	java/io/BufferedOutputStream
    //   115: dup
    //   116: new 406	java/io/FileOutputStream
    //   119: dup
    //   120: aload_2
    //   121: invokespecial 407	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   124: invokespecial 410	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   127: astore_2
    //   128: aload 4
    //   130: ldc_w 412
    //   133: ldc_w 414
    //   136: invokevirtual 418	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   139: pop
    //   140: aload 4
    //   142: aload_2
    //   143: aconst_null
    //   144: invokevirtual 422	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   147: ldc 149
    //   149: ldc_w 424
    //   152: iconst_1
    //   153: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   156: aload_2
    //   157: invokevirtual 427	java/io/BufferedOutputStream:close	()V
    //   160: aload_3
    //   161: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   164: ldc_w 361
    //   167: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: astore_2
    //   172: ldc_w 361
    //   175: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: return
    //   179: astore_2
    //   180: aconst_null
    //   181: astore_2
    //   182: aconst_null
    //   183: astore_3
    //   184: aload_2
    //   185: ifnull +7 -> 192
    //   188: aload_2
    //   189: invokevirtual 427	java/io/BufferedOutputStream:close	()V
    //   192: aload_3
    //   193: ifnull +22 -> 215
    //   196: aload_3
    //   197: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   200: ldc_w 361
    //   203: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: return
    //   207: astore_2
    //   208: ldc_w 361
    //   211: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: return
    //   215: ldc_w 361
    //   218: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: return
    //   222: astore_2
    //   223: goto -63 -> 160
    //   226: astore_2
    //   227: goto -35 -> 192
    //   230: astore_2
    //   231: aconst_null
    //   232: astore_2
    //   233: goto -49 -> 184
    //   236: astore 4
    //   238: goto -54 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	q
    //   0	241	1	paramInt	int
    //   0	241	2	paramString	String
    //   0	241	3	paramContext	Context
    //   88	53	4	localProperties	java.util.Properties
    //   236	1	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   160	164	171	java/io/IOException
    //   90	106	179	finally
    //   196	200	207	java/io/IOException
    //   156	160	222	java/io/IOException
    //   188	192	226	java/io/IOException
    //   106	128	230	finally
    //   128	156	236	finally
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(219524);
    if (!w(paramContext))
    {
      if (a(paramContext, "core_unzip_tmp"))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
        TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
        AppMethodBeat.o(219524);
        return;
      }
      if (a(paramContext, "core_share_backup_tmp"))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
        TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
        AppMethodBeat.o(219524);
        return;
      }
      if (a(paramContext, "core_copy_tmp"))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
        TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
      }
    }
    AppMethodBeat.o(219524);
  }
  
  /* Error */
  private void a(Context paramContext1, Context paramContext2, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 467
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   10: sipush -524
    //   13: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   16: aload_0
    //   17: aload_2
    //   18: invokevirtual 472	com/tencent/smtt/sdk/q:d	(Landroid/content/Context;)Z
    //   21: ifeq +10 -> 31
    //   24: ldc_w 467
    //   27: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: return
    //   31: ldc 149
    //   33: ldc_w 474
    //   36: iload_3
    //   37: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   40: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   43: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: getstatic 482	android/os/Build$VERSION:SDK_INT	I
    //   49: bipush 11
    //   51: if_icmplt +73 -> 124
    //   54: aload_2
    //   55: ldc_w 484
    //   58: iconst_4
    //   59: invokevirtual 488	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   62: astore 15
    //   64: aload 15
    //   66: ldc_w 490
    //   69: iconst_m1
    //   70: invokeinterface 206 3 0
    //   75: iload_3
    //   76: if_icmpne +61 -> 137
    //   79: ldc 149
    //   81: new 231	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 492
    //   88: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: iload_3
    //   92: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: ldc_w 494
    //   98: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_1
    //   108: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   111: sipush -525
    //   114: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   117: ldc_w 467
    //   120: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: return
    //   124: aload_2
    //   125: ldc_w 484
    //   128: iconst_0
    //   129: invokevirtual 488	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   132: astore 15
    //   134: goto -70 -> 64
    //   137: aload_0
    //   138: aload_2
    //   139: invokevirtual 497	com/tencent/smtt/sdk/q:u	(Landroid/content/Context;)Z
    //   142: ifne +20 -> 162
    //   145: aload_1
    //   146: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   149: sipush -526
    //   152: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   155: ldc_w 467
    //   158: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: return
    //   162: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   165: invokeinterface 502 1 0
    //   170: istore 8
    //   172: ldc 149
    //   174: ldc_w 504
    //   177: iload 8
    //   179: invokestatic 302	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   182: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   185: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: iload 8
    //   190: ifeq +2039 -> 2229
    //   193: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   196: invokevirtual 507	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   199: aconst_null
    //   200: astore 16
    //   202: aload_2
    //   203: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   206: ldc_w 509
    //   209: invokevirtual 512	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   212: istore 4
    //   214: aload_2
    //   215: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   218: ldc_w 514
    //   221: invokevirtual 516	com/tencent/smtt/sdk/n:b	(Ljava/lang/String;)I
    //   224: istore 5
    //   226: iload 4
    //   228: iload_3
    //   229: if_icmpne +49 -> 278
    //   232: getstatic 519	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   235: sipush 220
    //   238: invokeinterface 524 2 0
    //   243: aload_1
    //   244: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   247: sipush -528
    //   250: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   253: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   256: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   259: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   262: invokeinterface 528 1 0
    //   267: aload_0
    //   268: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   271: ldc_w 467
    //   274: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: return
    //   278: aload_0
    //   279: aload_2
    //   280: invokevirtual 214	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;)I
    //   283: istore 6
    //   285: ldc 149
    //   287: ldc_w 532
    //   290: iload 6
    //   292: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   295: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   298: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: iload 6
    //   303: iload_3
    //   304: if_icmpne +65 -> 369
    //   307: getstatic 519	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   310: sipush 220
    //   313: invokeinterface 524 2 0
    //   318: aload_1
    //   319: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   322: sipush -528
    //   325: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   328: ldc 149
    //   330: ldc_w 534
    //   333: iload 6
    //   335: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   338: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   341: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   347: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   350: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   353: invokeinterface 528 1 0
    //   358: aload_0
    //   359: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   362: ldc_w 467
    //   365: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: return
    //   369: aload_2
    //   370: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   373: invokevirtual 537	com/tencent/smtt/sdk/n:b	()I
    //   376: istore 7
    //   378: iload 7
    //   380: ifle +1916 -> 2296
    //   383: iload_3
    //   384: iload 7
    //   386: if_icmpgt +6 -> 392
    //   389: goto +1907 -> 2296
    //   392: aload_0
    //   393: aload_2
    //   394: invokevirtual 539	com/tencent/smtt/sdk/q:p	(Landroid/content/Context;)V
    //   397: goto +1913 -> 2310
    //   400: iconst_m1
    //   401: istore 4
    //   403: aload_0
    //   404: aload_2
    //   405: invokevirtual 539	com/tencent/smtt/sdk/q:p	(Landroid/content/Context;)V
    //   408: ldc 149
    //   410: ldc_w 541
    //   413: iconst_1
    //   414: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   417: aload_2
    //   418: invokestatic 543	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   421: ifne +91 -> 512
    //   424: invokestatic 548	com/tencent/smtt/utils/r:a	()J
    //   427: lstore 11
    //   429: aload_2
    //   430: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   433: invokevirtual 551	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   436: lstore 13
    //   438: aload_1
    //   439: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   442: sipush -529
    //   445: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   448: aload_2
    //   449: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   452: sipush 210
    //   455: new 231	java/lang/StringBuilder
    //   458: dup
    //   459: ldc_w 553
    //   462: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   465: lload 11
    //   467: invokevirtual 556	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   470: ldc_w 558
    //   473: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: lload 13
    //   478: invokevirtual 556	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   481: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   487: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   490: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   493: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   496: invokeinterface 528 1 0
    //   501: aload_0
    //   502: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   505: ldc_w 467
    //   508: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: return
    //   512: iload 4
    //   514: ifle +77 -> 591
    //   517: aload_2
    //   518: invokestatic 188	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   521: ifne +19 -> 540
    //   524: aload_2
    //   525: invokestatic 562	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   528: ifeq +12 -> 540
    //   531: iload_3
    //   532: aload_0
    //   533: aload_2
    //   534: invokevirtual 212	com/tencent/smtt/sdk/q:i	(Landroid/content/Context;)I
    //   537: if_icmpne +54 -> 591
    //   540: ldc 149
    //   542: new 231	java/lang/StringBuilder
    //   545: dup
    //   546: ldc_w 564
    //   549: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   552: aload_0
    //   553: aload_2
    //   554: invokevirtual 212	com/tencent/smtt/sdk/q:i	(Landroid/content/Context;)I
    //   557: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   566: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   569: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   572: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   575: invokeinterface 528 1 0
    //   580: aload_0
    //   581: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   584: ldc_w 467
    //   587: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   590: return
    //   591: iload 4
    //   593: ifne +83 -> 676
    //   596: aload_2
    //   597: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   600: ldc_w 566
    //   603: invokevirtual 512	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   606: istore 4
    //   608: iload 4
    //   610: iconst_2
    //   611: if_icmple +51 -> 662
    //   614: aload_2
    //   615: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   618: sipush 211
    //   621: ldc_w 568
    //   624: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   627: aload_1
    //   628: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   631: sipush -530
    //   634: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   637: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   640: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   643: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   646: invokeinterface 528 1 0
    //   651: aload_0
    //   652: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   655: ldc_w 467
    //   658: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   661: return
    //   662: aload_2
    //   663: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   666: ldc_w 566
    //   669: iload 4
    //   671: iconst_1
    //   672: iadd
    //   673: invokevirtual 185	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   676: aload_0
    //   677: aload_1
    //   678: invokevirtual 270	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   681: astore 17
    //   683: aload_2
    //   684: invokestatic 188	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   687: ifne +218 -> 905
    //   690: aload_2
    //   691: invokestatic 562	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   694: ifeq +196 -> 890
    //   697: aload_0
    //   698: aload_2
    //   699: invokevirtual 571	com/tencent/smtt/sdk/q:q	(Landroid/content/Context;)Ljava/io/File;
    //   702: astore 15
    //   704: aload 15
    //   706: astore 16
    //   708: aload 17
    //   710: ifnull +1418 -> 2128
    //   713: aload 16
    //   715: ifnull +1413 -> 2128
    //   718: aload_2
    //   719: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   722: iload_3
    //   723: iconst_0
    //   724: invokevirtual 180	com/tencent/smtt/sdk/n:a	(II)V
    //   727: new 573	com/tencent/smtt/utils/q
    //   730: dup
    //   731: invokespecial 574	com/tencent/smtt/utils/q:<init>	()V
    //   734: astore 15
    //   736: aload 15
    //   738: aload 17
    //   740: invokevirtual 576	com/tencent/smtt/utils/q:a	(Ljava/io/File;)V
    //   743: invokestatic 581	java/lang/System:currentTimeMillis	()J
    //   746: lstore 11
    //   748: aload_1
    //   749: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   752: sipush -551
    //   755: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   758: aload 17
    //   760: aload 16
    //   762: getstatic 115	com/tencent/smtt/sdk/q:c	Ljava/io/FileFilter;
    //   765: invokestatic 584	com/tencent/smtt/utils/f:a	(Ljava/io/File;Ljava/io/File;Ljava/io/FileFilter;)Z
    //   768: istore 8
    //   770: aload_2
    //   771: invokestatic 562	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   774: ifeq +7 -> 781
    //   777: aload_2
    //   778: invokestatic 586	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   781: ldc 149
    //   783: new 231	java/lang/StringBuilder
    //   786: dup
    //   787: ldc_w 588
    //   790: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   793: invokestatic 581	java/lang/System:currentTimeMillis	()J
    //   796: lload 11
    //   798: lsub
    //   799: invokevirtual 556	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   802: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   808: iload 8
    //   810: ifeq +1269 -> 2079
    //   813: aload 15
    //   815: aload 17
    //   817: invokevirtual 590	com/tencent/smtt/utils/q:b	(Ljava/io/File;)V
    //   820: aload 15
    //   822: invokevirtual 592	com/tencent/smtt/utils/q:a	()Z
    //   825: ifne +95 -> 920
    //   828: ldc 149
    //   830: ldc_w 594
    //   833: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   836: aload 16
    //   838: iconst_1
    //   839: invokestatic 275	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   842: aload_2
    //   843: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   846: sipush 213
    //   849: ldc_w 596
    //   852: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   855: aload_1
    //   856: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   859: sipush -531
    //   862: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   865: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   868: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   871: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   874: invokeinterface 528 1 0
    //   879: aload_0
    //   880: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   883: ldc_w 467
    //   886: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   889: return
    //   890: aload_0
    //   891: aload_2
    //   892: iconst_1
    //   893: invokevirtual 282	com/tencent/smtt/sdk/q:f	(Landroid/content/Context;I)Ljava/io/File;
    //   896: astore 15
    //   898: aload 15
    //   900: astore 16
    //   902: goto -194 -> 708
    //   905: aload_0
    //   906: aload_2
    //   907: iconst_1
    //   908: invokevirtual 282	com/tencent/smtt/sdk/q:f	(Landroid/content/Context;I)Ljava/io/File;
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
    //   935: new 291	java/io/File
    //   938: dup
    //   939: aload 16
    //   941: ldc_w 598
    //   944: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   947: astore 17
    //   949: new 388	java/util/Properties
    //   952: dup
    //   953: invokespecial 389	java/util/Properties:<init>	()V
    //   956: astore 15
    //   958: aload 17
    //   960: invokevirtual 601	java/io/File:exists	()Z
    //   963: ifeq +222 -> 1185
    //   966: new 391	java/io/BufferedInputStream
    //   969: dup
    //   970: new 393	java/io/FileInputStream
    //   973: dup
    //   974: aload 17
    //   976: invokespecial 396	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   979: invokespecial 399	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   982: astore 17
    //   984: aload 15
    //   986: aload 17
    //   988: invokevirtual 402	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   991: iload 9
    //   993: istore 8
    //   995: aload 17
    //   997: astore 18
    //   999: aload 15
    //   1001: astore 17
    //   1003: iload 8
    //   1005: istore 9
    //   1007: aload 18
    //   1009: ifnull +1276 -> 2285
    //   1012: aload 18
    //   1014: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   1017: ldc 149
    //   1019: ldc_w 603
    //   1022: iload 8
    //   1024: invokestatic 302	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1027: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1030: invokestatic 605	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1033: iload 8
    //   1035: ifeq +1244 -> 2279
    //   1038: aload 16
    //   1040: invokevirtual 609	java/io/File:listFiles	()[Ljava/io/File;
    //   1043: astore 17
    //   1045: aload_1
    //   1046: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1049: sipush -552
    //   1052: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
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
    //   1080: ldc_w 598
    //   1083: aload 18
    //   1085: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   1088: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1091: ifne +53 -> 1144
    //   1094: aload 18
    //   1096: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   1099: ldc_w 614
    //   1102: invokevirtual 618	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1105: ifne +39 -> 1144
    //   1108: ldc_w 386
    //   1111: aload 18
    //   1113: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   1116: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1119: ifne +25 -> 1144
    //   1122: aload 18
    //   1124: invokevirtual 621	java/io/File:isDirectory	()Z
    //   1127: ifne +17 -> 1144
    //   1130: aload 18
    //   1132: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   1135: ldc_w 623
    //   1138: invokevirtual 618	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1141: ifeq +181 -> 1322
    //   1144: ldc 149
    //   1146: new 231	java/lang/StringBuilder
    //   1149: dup
    //   1150: ldc_w 625
    //   1153: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1156: aload 18
    //   1158: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   1161: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: ldc_w 627
    //   1167: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1173: invokestatic 605	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1214: ifnull +1071 -> 2285
    //   1217: aload 18
    //   1219: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   1222: goto -205 -> 1017
    //   1225: astore 17
    //   1227: goto -210 -> 1017
    //   1230: astore 15
    //   1232: aload 19
    //   1234: astore 17
    //   1236: aload 17
    //   1238: ifnull +8 -> 1246
    //   1241: aload 17
    //   1243: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   1246: ldc_w 467
    //   1249: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1252: aload 15
    //   1254: athrow
    //   1255: astore 15
    //   1257: aload_2
    //   1258: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1261: sipush 215
    //   1264: aload 15
    //   1266: invokevirtual 259	java/lang/Exception:toString	()Ljava/lang/String;
    //   1269: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1272: aload_1
    //   1273: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1276: sipush -537
    //   1279: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1282: aload 16
    //   1284: iconst_0
    //   1285: invokestatic 275	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   1288: aload_2
    //   1289: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1292: iconst_0
    //   1293: iconst_m1
    //   1294: invokevirtual 180	com/tencent/smtt/sdk/n:a	(II)V
    //   1297: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1300: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1303: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1306: invokeinterface 528 1 0
    //   1311: aload_0
    //   1312: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   1315: ldc_w 467
    //   1318: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1321: return
    //   1322: aload 18
    //   1324: invokestatic 632	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   1327: astore 19
    //   1329: aload 15
    //   1331: aload 18
    //   1333: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   1336: ldc_w 634
    //   1339: invokevirtual 638	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1342: astore 20
    //   1344: aload 20
    //   1346: ldc_w 634
    //   1349: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1352: ifne +51 -> 1403
    //   1355: aload 19
    //   1357: aload 20
    //   1359: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1362: ifeq +41 -> 1403
    //   1365: ldc 149
    //   1367: new 231	java/lang/StringBuilder
    //   1370: dup
    //   1371: ldc_w 640
    //   1374: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1377: aload 18
    //   1379: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   1382: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: ldc_w 642
    //   1388: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1394: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1397: iconst_1
    //   1398: istore 9
    //   1400: goto -224 -> 1176
    //   1403: iconst_0
    //   1404: istore 10
    //   1406: ldc 149
    //   1408: new 231	java/lang/StringBuilder
    //   1411: dup
    //   1412: ldc_w 644
    //   1415: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1418: aload 18
    //   1420: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   1423: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: ldc_w 646
    //   1429: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: aload 20
    //   1434: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: ldc_w 648
    //   1440: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1443: aload 19
    //   1445: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1451: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1454: ldc 149
    //   1456: ldc_w 650
    //   1459: iload 10
    //   1461: invokestatic 302	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1464: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1467: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1470: iload 8
    //   1472: ifeq +70 -> 1542
    //   1475: iload 10
    //   1477: ifne +65 -> 1542
    //   1480: ldc 149
    //   1482: ldc_w 652
    //   1485: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1488: aload 16
    //   1490: iconst_1
    //   1491: invokestatic 275	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   1494: aload_2
    //   1495: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1498: sipush 213
    //   1501: ldc_w 654
    //   1504: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1507: aload_1
    //   1508: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1511: sipush -532
    //   1514: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1517: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1520: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1523: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1526: invokeinterface 528 1 0
    //   1531: aload_0
    //   1532: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   1535: ldc_w 467
    //   1538: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1541: return
    //   1542: ldc 149
    //   1544: ldc_w 656
    //   1547: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1550: aload_0
    //   1551: aload_2
    //   1552: iconst_1
    //   1553: invokespecial 333	com/tencent/smtt/sdk/q:g	(Landroid/content/Context;Z)V
    //   1556: aload_1
    //   1557: invokestatic 660	com/tencent/smtt/sdk/m:d	(Landroid/content/Context;)Ljava/io/File;
    //   1560: astore 17
    //   1562: aload 17
    //   1564: ifnull +255 -> 1819
    //   1567: aload 17
    //   1569: invokevirtual 601	java/io/File:exists	()Z
    //   1572: ifeq +247 -> 1819
    //   1575: aload_2
    //   1576: invokestatic 663	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1579: ifeq +395 -> 1974
    //   1582: ldc_w 665
    //   1585: astore 15
    //   1587: new 291	java/io/File
    //   1590: dup
    //   1591: aload 17
    //   1593: aload 15
    //   1595: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1598: astore 15
    //   1600: aload_2
    //   1601: invokestatic 667	com/tencent/smtt/utils/r:c	(Landroid/content/Context;)Z
    //   1604: ifeq +379 -> 1983
    //   1607: iconst_0
    //   1608: istore 9
    //   1610: aload_2
    //   1611: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1614: getfield 198	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1617: ldc 200
    //   1619: iconst_0
    //   1620: invokeinterface 206 3 0
    //   1625: istore 4
    //   1627: aload_2
    //   1628: iconst_0
    //   1629: invokestatic 671	com/tencent/smtt/sdk/TbsShareManager:getTbsStableCoreVersion	(Landroid/content/Context;I)I
    //   1632: istore 5
    //   1634: aload 15
    //   1636: invokestatic 674	com/tencent/smtt/utils/a:b	(Ljava/io/File;)I
    //   1639: istore 6
    //   1641: ldc 149
    //   1643: new 231	java/lang/StringBuilder
    //   1646: dup
    //   1647: ldc_w 676
    //   1650: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1653: iload 4
    //   1655: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1658: ldc_w 678
    //   1661: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: iload 5
    //   1666: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1669: ldc_w 680
    //   1672: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1675: iload 6
    //   1677: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1680: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1683: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1686: iload 9
    //   1688: istore 8
    //   1690: iload 5
    //   1692: iload 4
    //   1694: if_icmpge +23 -> 1717
    //   1697: iload 9
    //   1699: istore 8
    //   1701: iload 4
    //   1703: iload 6
    //   1705: if_icmpne +12 -> 1717
    //   1708: iconst_1
    //   1709: istore 8
    //   1711: aload 15
    //   1713: aload_2
    //   1714: invokestatic 683	com/tencent/smtt/sdk/m:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1717: ldc_w 685
    //   1720: iload 8
    //   1722: invokestatic 302	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1725: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1728: astore 15
    //   1730: new 231	java/lang/StringBuilder
    //   1733: dup
    //   1734: invokespecial 686	java/lang/StringBuilder:<init>	()V
    //   1737: aload 15
    //   1739: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1742: ldc_w 688
    //   1745: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1748: iload 4
    //   1750: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1753: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1756: astore 15
    //   1758: new 231	java/lang/StringBuilder
    //   1761: dup
    //   1762: invokespecial 686	java/lang/StringBuilder:<init>	()V
    //   1765: aload 15
    //   1767: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1770: ldc_w 690
    //   1773: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1776: iload 5
    //   1778: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1781: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1784: astore 15
    //   1786: aload_2
    //   1787: ldc_w 692
    //   1790: new 231	java/lang/StringBuilder
    //   1793: dup
    //   1794: invokespecial 686	java/lang/StringBuilder:<init>	()V
    //   1797: aload 15
    //   1799: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1802: ldc_w 694
    //   1805: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1808: iload 6
    //   1810: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1813: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1816: invokestatic 697	com/tencent/smtt/utils/r:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   1819: aload_2
    //   1820: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1823: iload_3
    //   1824: iconst_1
    //   1825: invokevirtual 180	com/tencent/smtt/sdk/n:a	(II)V
    //   1828: aload_0
    //   1829: getfield 130	com/tencent/smtt/sdk/q:k	Z
    //   1832: ifeq +187 -> 2019
    //   1835: aload_2
    //   1836: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1839: sipush 220
    //   1842: ldc_w 699
    //   1845: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1848: aload_1
    //   1849: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1852: sipush -533
    //   1855: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1858: ldc 149
    //   1860: ldc_w 701
    //   1863: iload_3
    //   1864: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1867: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1870: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1873: getstatic 482	android/os/Build$VERSION:SDK_INT	I
    //   1876: bipush 11
    //   1878: if_icmplt +157 -> 2035
    //   1881: aload_2
    //   1882: ldc_w 484
    //   1885: iconst_4
    //   1886: invokevirtual 488	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1889: astore 15
    //   1891: aload 15
    //   1893: invokeinterface 705 1 0
    //   1898: astore 15
    //   1900: aload 15
    //   1902: ldc_w 707
    //   1905: iconst_0
    //   1906: invokeinterface 713 3 0
    //   1911: pop
    //   1912: aload 15
    //   1914: ldc_w 715
    //   1917: iconst_0
    //   1918: invokeinterface 713 3 0
    //   1923: pop
    //   1924: aload 15
    //   1926: ldc_w 717
    //   1929: iload_3
    //   1930: invokeinterface 713 3 0
    //   1935: pop
    //   1936: aload 15
    //   1938: invokeinterface 720 1 0
    //   1943: pop
    //   1944: aload_2
    //   1945: invokestatic 721	com/tencent/smtt/utils/r:a	(Landroid/content/Context;)Z
    //   1948: pop
    //   1949: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1952: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1955: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1958: invokeinterface 528 1 0
    //   1963: aload_0
    //   1964: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   1967: ldc_w 467
    //   1970: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1973: return
    //   1974: iconst_0
    //   1975: invokestatic 724	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   1978: astore 15
    //   1980: goto -393 -> 1587
    //   1983: aload 15
    //   1985: aload_2
    //   1986: invokestatic 683	com/tencent/smtt/sdk/m:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1989: goto -170 -> 1819
    //   1992: astore_1
    //   1993: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1996: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1999: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   2002: invokeinterface 528 1 0
    //   2007: aload_0
    //   2008: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   2011: ldc_w 467
    //   2014: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2017: aload_1
    //   2018: athrow
    //   2019: aload_2
    //   2020: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2023: sipush 220
    //   2026: ldc_w 726
    //   2029: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2032: goto -184 -> 1848
    //   2035: aload_2
    //   2036: ldc_w 484
    //   2039: iconst_0
    //   2040: invokevirtual 488	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2043: astore 15
    //   2045: goto -154 -> 1891
    //   2048: astore 15
    //   2050: ldc 149
    //   2052: new 231	java/lang/StringBuilder
    //   2055: dup
    //   2056: ldc_w 728
    //   2059: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2062: aload 15
    //   2064: invokestatic 734	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2067: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2070: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2073: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2076: goto -132 -> 1944
    //   2079: ldc 149
    //   2081: ldc_w 736
    //   2084: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2087: aload_2
    //   2088: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   2091: iload_3
    //   2092: iconst_2
    //   2093: invokevirtual 180	com/tencent/smtt/sdk/n:a	(II)V
    //   2096: aload 16
    //   2098: iconst_0
    //   2099: invokestatic 275	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   2102: aload_1
    //   2103: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2106: sipush -534
    //   2109: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2112: aload_2
    //   2113: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2116: sipush 212
    //   2119: ldc_w 738
    //   2122: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2125: goto -176 -> 1949
    //   2128: aload 17
    //   2130: ifnonnull +26 -> 2156
    //   2133: aload_2
    //   2134: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2137: sipush 213
    //   2140: ldc_w 740
    //   2143: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2146: aload_1
    //   2147: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2150: sipush -535
    //   2153: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2156: aload 16
    //   2158: ifnonnull -209 -> 1949
    //   2161: aload_2
    //   2162: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2165: sipush 214
    //   2168: ldc_w 742
    //   2171: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2174: aload_1
    //   2175: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2178: sipush -536
    //   2181: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2184: goto -235 -> 1949
    //   2187: astore_1
    //   2188: ldc 149
    //   2190: new 231	java/lang/StringBuilder
    //   2193: dup
    //   2194: ldc_w 744
    //   2197: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2200: aload_1
    //   2201: invokevirtual 747	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2204: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2207: ldc_w 749
    //   2210: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2213: aload_1
    //   2214: invokevirtual 753	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   2217: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2220: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2223: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2226: goto -929 -> 1297
    //   2229: aload_0
    //   2230: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   2233: aload_1
    //   2234: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2237: sipush -538
    //   2240: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2243: ldc_w 467
    //   2246: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2249: return
    //   2250: astore 17
    //   2252: goto -1006 -> 1246
    //   2255: astore 15
    //   2257: goto -1000 -> 1257
    //   2260: astore 15
    //   2262: goto -1026 -> 1236
    //   2265: astore 17
    //   2267: goto -1063 -> 1204
    //   2270: astore 18
    //   2272: aload 17
    //   2274: astore 18
    //   2276: goto -1072 -> 1204
    //   2279: iconst_1
    //   2280: istore 10
    //   2282: goto -828 -> 1454
    //   2285: aload 17
    //   2287: astore 15
    //   2289: iload 9
    //   2291: istore 8
    //   2293: goto -1276 -> 1017
    //   2296: iload 4
    //   2298: ifle +12 -> 2310
    //   2301: iload_3
    //   2302: iload 4
    //   2304: if_icmple +6 -> 2310
    //   2307: goto -1915 -> 392
    //   2310: iload 5
    //   2312: istore 4
    //   2314: iload 5
    //   2316: iconst_3
    //   2317: if_icmpne -1900 -> 417
    //   2320: iload 5
    //   2322: istore 4
    //   2324: iload 6
    //   2326: ifle -1909 -> 417
    //   2329: iload_3
    //   2330: iload 6
    //   2332: if_icmpgt -1932 -> 400
    //   2335: iload 5
    //   2337: istore 4
    //   2339: iload_3
    //   2340: ldc_w 754
    //   2343: if_icmpne -1926 -> 417
    //   2346: goto -1946 -> 400
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2349	0	this	q
    //   0	2349	1	paramContext1	Context
    //   0	2349	2	paramContext2	Context
    //   0	2349	3	paramInt	int
    //   212	2126	4	i1	int
    //   224	2112	5	i2	int
    //   283	2050	6	i3	int
    //   376	11	7	i4	int
    //   170	2122	8	bool1	boolean
    //   927	1363	9	bool2	boolean
    //   924	1357	10	bool3	boolean
    //   427	370	11	l1	long
    //   436	41	13	l2	long
    //   62	938	15	localObject1	Object
    //   1199	1	15	localException1	Exception
    //   1202	3	15	localObject2	Object
    //   1230	23	15	localObject3	Object
    //   1255	75	15	localException2	Exception
    //   1585	459	15	localObject4	Object
    //   2048	15	15	localThrowable	Throwable
    //   2255	1	15	localException3	Exception
    //   2260	1	15	localObject5	Object
    //   2287	1	15	localObject6	Object
    //   200	1957	16	localObject7	Object
    //   681	393	17	localObject8	Object
    //   1194	1	17	localIOException1	java.io.IOException
    //   1206	1	17	localObject9	Object
    //   1225	1	17	localIOException2	java.io.IOException
    //   1234	895	17	localObject10	Object
    //   2250	1	17	localIOException3	java.io.IOException
    //   2265	21	17	localException4	Exception
    //   933	486	18	localObject11	Object
    //   2270	1	18	localException5	Exception
    //   2274	1	18	localException6	Exception
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
    //   1587	1607	1255	java/lang/Exception
    //   1610	1686	1255	java/lang/Exception
    //   1711	1717	1255	java/lang/Exception
    //   1717	1819	1255	java/lang/Exception
    //   1819	1848	1255	java/lang/Exception
    //   1848	1891	1255	java/lang/Exception
    //   1944	1949	1255	java/lang/Exception
    //   1974	1980	1255	java/lang/Exception
    //   1983	1989	1255	java/lang/Exception
    //   2019	2032	1255	java/lang/Exception
    //   2035	2045	1255	java/lang/Exception
    //   2050	2076	1255	java/lang/Exception
    //   2079	2125	1255	java/lang/Exception
    //   2133	2156	1255	java/lang/Exception
    //   2161	2184	1255	java/lang/Exception
    //   202	226	1992	finally
    //   232	253	1992	finally
    //   278	301	1992	finally
    //   307	344	1992	finally
    //   369	378	1992	finally
    //   392	397	1992	finally
    //   403	417	1992	finally
    //   417	487	1992	finally
    //   517	540	1992	finally
    //   540	566	1992	finally
    //   596	608	1992	finally
    //   614	637	1992	finally
    //   662	676	1992	finally
    //   676	704	1992	finally
    //   718	781	1992	finally
    //   781	808	1992	finally
    //   813	865	1992	finally
    //   890	898	1992	finally
    //   905	913	1992	finally
    //   1012	1017	1992	finally
    //   1017	1033	1992	finally
    //   1038	1055	1992	finally
    //   1065	1073	1992	finally
    //   1080	1144	1992	finally
    //   1144	1176	1992	finally
    //   1217	1222	1992	finally
    //   1241	1246	1992	finally
    //   1246	1255	1992	finally
    //   1257	1282	1992	finally
    //   1282	1297	1992	finally
    //   1322	1397	1992	finally
    //   1406	1454	1992	finally
    //   1454	1470	1992	finally
    //   1480	1517	1992	finally
    //   1542	1562	1992	finally
    //   1567	1582	1992	finally
    //   1587	1607	1992	finally
    //   1610	1686	1992	finally
    //   1711	1717	1992	finally
    //   1717	1819	1992	finally
    //   1819	1848	1992	finally
    //   1848	1891	1992	finally
    //   1944	1949	1992	finally
    //   1974	1980	1992	finally
    //   1983	1989	1992	finally
    //   2019	2032	1992	finally
    //   2035	2045	1992	finally
    //   2050	2076	1992	finally
    //   2079	2125	1992	finally
    //   2133	2156	1992	finally
    //   2161	2184	1992	finally
    //   2188	2226	1992	finally
    //   1891	1944	2048	finally
    //   1282	1297	2187	java/lang/Exception
    //   1241	1246	2250	java/io/IOException
    //   202	226	2255	java/lang/Exception
    //   232	253	2255	java/lang/Exception
    //   278	301	2255	java/lang/Exception
    //   307	344	2255	java/lang/Exception
    //   369	378	2255	java/lang/Exception
    //   392	397	2255	java/lang/Exception
    //   403	417	2255	java/lang/Exception
    //   417	487	2255	java/lang/Exception
    //   517	540	2255	java/lang/Exception
    //   540	566	2255	java/lang/Exception
    //   596	608	2255	java/lang/Exception
    //   614	637	2255	java/lang/Exception
    //   662	676	2255	java/lang/Exception
    //   676	704	2255	java/lang/Exception
    //   890	898	2255	java/lang/Exception
    //   905	913	2255	java/lang/Exception
    //   984	991	2260	finally
    //   958	984	2265	java/lang/Exception
    //   984	991	2270	java/lang/Exception
  }
  
  /* Error */
  private boolean a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: ldc_w 765
    //   6: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 149
    //   11: ldc_w 767
    //   14: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_2
    //   18: invokestatic 769	com/tencent/smtt/utils/f:c	(Ljava/io/File;)Z
    //   21: ifne +34 -> 55
    //   24: aload_1
    //   25: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   28: sipush 204
    //   31: ldc_w 771
    //   34: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   37: aload_1
    //   38: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   41: sipush -520
    //   44: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   47: ldc_w 765
    //   50: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: iconst_0
    //   54: ireturn
    //   55: aload_1
    //   56: invokestatic 376	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   59: astore 8
    //   61: iload_3
    //   62: ifeq +85 -> 147
    //   65: new 291	java/io/File
    //   68: dup
    //   69: aload 8
    //   71: ldc_w 773
    //   74: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   77: astore 8
    //   79: aload 8
    //   81: invokevirtual 601	java/io/File:exists	()Z
    //   84: ifeq +15 -> 99
    //   87: aload_1
    //   88: invokestatic 562	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   91: ifne +8 -> 99
    //   94: aload 8
    //   96: invokestatic 774	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   99: iload_3
    //   100: ifeq +95 -> 195
    //   103: aload_0
    //   104: aload_1
    //   105: iconst_2
    //   106: invokevirtual 282	com/tencent/smtt/sdk/q:f	(Landroid/content/Context;I)Ljava/io/File;
    //   109: astore 8
    //   111: aload 8
    //   113: ifnonnull +93 -> 206
    //   116: aload_1
    //   117: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   120: sipush 205
    //   123: ldc_w 776
    //   126: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   129: aload_1
    //   130: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   133: sipush -521
    //   136: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   139: ldc_w 765
    //   142: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: iconst_0
    //   146: ireturn
    //   147: new 291	java/io/File
    //   150: dup
    //   151: aload 8
    //   153: ldc_w 378
    //   156: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   159: astore 8
    //   161: goto -82 -> 79
    //   164: astore 8
    //   166: ldc 149
    //   168: new 231	java/lang/StringBuilder
    //   171: dup
    //   172: ldc_w 778
    //   175: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: aload 8
    //   180: invokestatic 734	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   183: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: goto -93 -> 99
    //   195: aload_0
    //   196: aload_1
    //   197: iconst_0
    //   198: invokevirtual 282	com/tencent/smtt/sdk/q:f	(Landroid/content/Context;I)Ljava/io/File;
    //   201: astore 8
    //   203: goto -92 -> 111
    //   206: aload 8
    //   208: invokestatic 780	com/tencent/smtt/utils/f:a	(Ljava/io/File;)Z
    //   211: pop
    //   212: iload_3
    //   213: ifeq +9 -> 222
    //   216: aload 8
    //   218: iconst_1
    //   219: invokestatic 275	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   222: aload_2
    //   223: aload 8
    //   225: invokestatic 783	com/tencent/smtt/utils/f:a	(Ljava/io/File;Ljava/io/File;)Z
    //   228: istore 7
    //   230: iload 7
    //   232: istore 6
    //   234: iload 7
    //   236: ifeq +12 -> 248
    //   239: aload_0
    //   240: aload 8
    //   242: aload_1
    //   243: invokespecial 786	com/tencent/smtt/sdk/q:a	(Ljava/io/File;Landroid/content/Context;)Z
    //   246: istore 6
    //   248: iload_3
    //   249: ifeq +81 -> 330
    //   252: aload 8
    //   254: invokevirtual 790	java/io/File:list	()[Ljava/lang/String;
    //   257: astore_2
    //   258: iconst_0
    //   259: istore 4
    //   261: iload 4
    //   263: aload_2
    //   264: arraylength
    //   265: if_icmpge +47 -> 312
    //   268: new 291	java/io/File
    //   271: dup
    //   272: aload 8
    //   274: aload_2
    //   275: iload 4
    //   277: aaload
    //   278: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   281: astore 9
    //   283: aload 9
    //   285: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   288: ldc_w 614
    //   291: invokevirtual 618	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   294: ifeq +9 -> 303
    //   297: aload 9
    //   299: invokevirtual 366	java/io/File:delete	()Z
    //   302: pop
    //   303: iload 4
    //   305: iconst_1
    //   306: iadd
    //   307: istore 4
    //   309: goto -48 -> 261
    //   312: new 291	java/io/File
    //   315: dup
    //   316: aload_1
    //   317: invokestatic 793	com/tencent/smtt/sdk/q:t	(Landroid/content/Context;)Ljava/io/File;
    //   320: ldc_w 795
    //   323: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   326: invokevirtual 366	java/io/File:delete	()Z
    //   329: pop
    //   330: iload 6
    //   332: ifne +61 -> 393
    //   335: aload 8
    //   337: invokestatic 774	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   340: aload_1
    //   341: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   344: sipush -522
    //   347: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   350: ldc 149
    //   352: new 231	java/lang/StringBuilder
    //   355: dup
    //   356: ldc_w 797
    //   359: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   362: aload 8
    //   364: invokevirtual 601	java/io/File:exists	()Z
    //   367: invokevirtual 800	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   370: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: ldc 149
    //   378: ldc_w 802
    //   381: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   384: ldc_w 765
    //   387: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   390: iload 6
    //   392: ireturn
    //   393: aload_0
    //   394: aload_1
    //   395: iconst_1
    //   396: invokespecial 333	com/tencent/smtt/sdk/q:g	(Landroid/content/Context;Z)V
    //   399: iload_3
    //   400: ifeq -24 -> 376
    //   403: aload_0
    //   404: aload_1
    //   405: invokevirtual 571	com/tencent/smtt/sdk/q:q	(Landroid/content/Context;)Ljava/io/File;
    //   408: astore_2
    //   409: aload_2
    //   410: iconst_1
    //   411: invokestatic 275	com/tencent/smtt/utils/f:a	(Ljava/io/File;Z)V
    //   414: aload 8
    //   416: aload_2
    //   417: invokevirtual 295	java/io/File:renameTo	(Ljava/io/File;)Z
    //   420: pop
    //   421: aload_1
    //   422: invokestatic 586	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   425: goto -49 -> 376
    //   428: astore_2
    //   429: aload_1
    //   430: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   433: sipush -523
    //   436: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   439: aload_1
    //   440: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   443: sipush 206
    //   446: aload_2
    //   447: invokevirtual 805	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   450: aload 8
    //   452: ifnull +256 -> 708
    //   455: aload 8
    //   457: invokevirtual 601	java/io/File:exists	()Z
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
    //   481: invokestatic 774	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   484: ldc 149
    //   486: new 231	java/lang/StringBuilder
    //   489: dup
    //   490: ldc_w 807
    //   493: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   496: aload 8
    //   498: invokevirtual 601	java/io/File:exists	()Z
    //   501: invokevirtual 800	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   504: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: ldc 149
    //   512: ldc_w 802
    //   515: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   518: ldc_w 765
    //   521: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   524: iconst_0
    //   525: ireturn
    //   526: astore_1
    //   527: ldc 149
    //   529: new 231	java/lang/StringBuilder
    //   532: dup
    //   533: ldc_w 809
    //   536: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   539: aload_1
    //   540: invokestatic 734	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   543: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: goto -42 -> 510
    //   555: astore_2
    //   556: aload_1
    //   557: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   560: sipush -523
    //   563: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   566: aload_1
    //   567: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   570: sipush 207
    //   573: aload_2
    //   574: invokevirtual 805	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   577: aload 8
    //   579: ifnull +123 -> 702
    //   582: aload 8
    //   584: invokevirtual 601	java/io/File:exists	()Z
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
    //   607: invokestatic 774	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   610: ldc 149
    //   612: new 231	java/lang/StringBuilder
    //   615: dup
    //   616: ldc_w 807
    //   619: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   622: aload 8
    //   624: invokevirtual 601	java/io/File:exists	()Z
    //   627: invokevirtual 800	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   630: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: ldc 149
    //   638: ldc_w 802
    //   641: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: ldc_w 765
    //   647: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   650: iconst_0
    //   651: ireturn
    //   652: astore_1
    //   653: ldc 149
    //   655: new 231	java/lang/StringBuilder
    //   658: dup
    //   659: ldc_w 809
    //   662: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   665: aload_1
    //   666: invokestatic 734	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   669: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   678: goto -42 -> 636
    //   681: astore_1
    //   682: ldc 149
    //   684: ldc_w 802
    //   687: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   690: ldc_w 765
    //   693: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   55	61	164	finally
    //   65	79	164	finally
    //   79	99	164	finally
    //   147	161	164	finally
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
    //   479	510	526	finally
    //   206	212	555	java/lang/Exception
    //   216	222	555	java/lang/Exception
    //   222	230	555	java/lang/Exception
    //   239	248	555	java/lang/Exception
    //   252	258	555	java/lang/Exception
    //   261	303	555	java/lang/Exception
    //   335	376	555	java/lang/Exception
    //   393	399	555	java/lang/Exception
    //   403	425	555	java/lang/Exception
    //   605	636	652	finally
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
    AppMethodBeat.i(219530);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), paramString);
    if (!paramContext.exists())
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #1");
      AppMethodBeat.o(219530);
      return false;
    }
    if (!new File(paramContext, "tbs.conf").exists())
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #2");
      AppMethodBeat.o(219530);
      return false;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #3");
    AppMethodBeat.o(219530);
    return true;
  }
  
  /* Error */
  private boolean a(File paramFile, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc_w 817
    //   6: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 149
    //   11: new 231	java/lang/StringBuilder
    //   14: dup
    //   15: ldc_w 819
    //   18: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: aload_1
    //   22: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc_w 821
    //   28: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_2
    //   32: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: new 291	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: ldc_w 598
    //   49: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   52: astore_2
    //   53: new 388	java/util/Properties
    //   56: dup
    //   57: invokespecial 389	java/util/Properties:<init>	()V
    //   60: astore 6
    //   62: aload_2
    //   63: invokevirtual 601	java/io/File:exists	()Z
    //   66: ifeq +197 -> 263
    //   69: new 391	java/io/BufferedInputStream
    //   72: dup
    //   73: new 393	java/io/FileInputStream
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 396	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 399	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore_2
    //   85: aload 6
    //   87: aload_2
    //   88: invokevirtual 402	java/util/Properties:load	(Ljava/io/InputStream;)V
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
    //   111: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   114: iload 5
    //   116: istore 4
    //   118: aload 6
    //   120: astore_2
    //   121: ldc 149
    //   123: ldc_w 823
    //   126: iload 4
    //   128: invokestatic 302	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   131: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   134: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: iload 4
    //   139: ifeq +417 -> 556
    //   142: aload_1
    //   143: invokevirtual 609	java/io/File:listFiles	()[Ljava/io/File;
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
    //   160: ldc_w 598
    //   163: aload 6
    //   165: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   168: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifne +53 -> 224
    //   174: aload 6
    //   176: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   179: ldc_w 614
    //   182: invokevirtual 618	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   185: ifne +39 -> 224
    //   188: ldc_w 386
    //   191: aload 6
    //   193: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   196: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifne +25 -> 224
    //   202: aload 6
    //   204: invokevirtual 621	java/io/File:isDirectory	()Z
    //   207: ifne +17 -> 224
    //   210: aload 6
    //   212: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   215: ldc_w 623
    //   218: invokevirtual 618	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   221: ifeq +101 -> 322
    //   224: ldc 149
    //   226: new 231	java/lang/StringBuilder
    //   229: dup
    //   230: ldc_w 625
    //   233: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   236: aload 6
    //   238: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   241: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 627
    //   247: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 605	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   285: invokevirtual 428	java/io/BufferedInputStream:close	()V
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
    //   311: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   314: ldc_w 817
    //   317: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aload_1
    //   321: athrow
    //   322: aload 6
    //   324: invokestatic 632	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   327: astore 7
    //   329: aload_2
    //   330: aload 6
    //   332: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   335: ldc_w 634
    //   338: invokevirtual 638	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   341: astore 8
    //   343: aload 8
    //   345: ldc_w 634
    //   348: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   351: ifne +48 -> 399
    //   354: aload 8
    //   356: aload 7
    //   358: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifeq +38 -> 399
    //   364: ldc 149
    //   366: new 231	java/lang/StringBuilder
    //   369: dup
    //   370: ldc_w 640
    //   373: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   376: aload 6
    //   378: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   381: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc_w 642
    //   387: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: goto -140 -> 256
    //   399: ldc 149
    //   401: new 231	java/lang/StringBuilder
    //   404: dup
    //   405: ldc_w 644
    //   408: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   411: aload 6
    //   413: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   416: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: ldc_w 646
    //   422: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 8
    //   427: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: ldc_w 648
    //   433: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload 7
    //   438: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: iconst_0
    //   448: istore 5
    //   450: ldc 149
    //   452: ldc_w 825
    //   455: iload 5
    //   457: invokestatic 302	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   460: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   463: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: iload 4
    //   468: ifeq +24 -> 492
    //   471: iload 5
    //   473: ifne +19 -> 492
    //   476: ldc 149
    //   478: ldc_w 827
    //   481: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: ldc_w 817
    //   487: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   490: iconst_0
    //   491: ireturn
    //   492: ldc 149
    //   494: ldc_w 829
    //   497: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: ldc_w 817
    //   503: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  private void b(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: ldc_w 830
    //   6: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   13: sipush -501
    //   16: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 472	com/tencent/smtt/sdk/q:d	(Landroid/content/Context;)Z
    //   24: ifeq +29 -> 53
    //   27: ldc 149
    //   29: ldc_w 832
    //   32: iconst_1
    //   33: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   36: aload_1
    //   37: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   40: sipush -502
    //   43: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   46: ldc_w 830
    //   49: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: ldc 149
    //   55: ldc_w 834
    //   58: aload_2
    //   59: invokestatic 837	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   62: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: ldc 149
    //   70: ldc_w 839
    //   73: iload_3
    //   74: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   77: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   80: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: ldc 149
    //   85: new 231	java/lang/StringBuilder
    //   88: dup
    //   89: ldc_w 841
    //   92: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload_1
    //   96: invokevirtual 318	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   99: getfield 844	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   102: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: ldc 149
    //   113: new 231	java/lang/StringBuilder
    //   116: dup
    //   117: ldc_w 846
    //   120: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: invokestatic 851	android/os/Process:myPid	()I
    //   126: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: ldc 149
    //   137: new 231	java/lang/StringBuilder
    //   140: dup
    //   141: ldc_w 853
    //   144: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: invokestatic 859	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   150: invokevirtual 860	java/lang/Thread:getName	()Ljava/lang/String;
    //   153: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: getstatic 482	android/os/Build$VERSION:SDK_INT	I
    //   165: bipush 11
    //   167: if_icmplt +73 -> 240
    //   170: aload_1
    //   171: ldc_w 484
    //   174: iconst_4
    //   175: invokevirtual 488	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   178: astore 14
    //   180: aload 14
    //   182: ldc_w 490
    //   185: iconst_m1
    //   186: invokeinterface 206 3 0
    //   191: iload_3
    //   192: if_icmpne +61 -> 253
    //   195: ldc 149
    //   197: new 231	java/lang/StringBuilder
    //   200: dup
    //   201: ldc_w 862
    //   204: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   207: iload_3
    //   208: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: ldc_w 494
    //   214: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_1
    //   224: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   227: sipush -503
    //   230: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   233: ldc_w 830
    //   236: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: return
    //   240: aload_1
    //   241: ldc_w 484
    //   244: iconst_0
    //   245: invokevirtual 488	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   248: astore 14
    //   250: goto -70 -> 180
    //   253: aload_1
    //   254: invokestatic 543	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   257: ifne +73 -> 330
    //   260: invokestatic 548	com/tencent/smtt/utils/r:a	()J
    //   263: lstore 9
    //   265: aload_1
    //   266: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   269: invokevirtual 551	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   272: lstore 11
    //   274: aload_1
    //   275: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   278: sipush -504
    //   281: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   284: aload_1
    //   285: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   288: sipush 210
    //   291: new 231	java/lang/StringBuilder
    //   294: dup
    //   295: ldc_w 864
    //   298: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   301: lload 9
    //   303: invokevirtual 556	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   306: ldc_w 558
    //   309: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: lload 11
    //   314: invokevirtual 556	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   317: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   323: ldc_w 830
    //   326: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: return
    //   330: aload_0
    //   331: aload_1
    //   332: invokevirtual 497	com/tencent/smtt/sdk/q:u	(Landroid/content/Context;)Z
    //   335: ifne +20 -> 355
    //   338: aload_1
    //   339: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   342: sipush -505
    //   345: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   348: ldc_w 830
    //   351: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: return
    //   355: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   358: invokeinterface 502 1 0
    //   363: istore 13
    //   365: ldc 149
    //   367: ldc_w 866
    //   370: iload 13
    //   372: invokestatic 302	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   375: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   378: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: iload 13
    //   383: ifeq +1886 -> 2269
    //   386: aload_1
    //   387: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   390: sipush -507
    //   393: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   396: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   399: invokevirtual 507	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   402: aload_1
    //   403: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   406: ldc_w 509
    //   409: invokevirtual 512	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   412: istore 4
    //   414: aload_1
    //   415: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   418: invokevirtual 537	com/tencent/smtt/sdk/n:b	()I
    //   421: istore 5
    //   423: ldc 149
    //   425: ldc_w 868
    //   428: iload 4
    //   430: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   433: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   436: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: ldc 149
    //   441: ldc_w 870
    //   444: iload 5
    //   446: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   449: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   452: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: ldc 149
    //   457: ldc_w 872
    //   460: iload_3
    //   461: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   464: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   467: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: iload 5
    //   472: ifle +1885 -> 2357
    //   475: iload_3
    //   476: iload 5
    //   478: if_icmpgt +6 -> 484
    //   481: goto +1876 -> 2357
    //   484: aload_0
    //   485: aload_1
    //   486: invokevirtual 539	com/tencent/smtt/sdk/q:p	(Landroid/content/Context;)V
    //   489: aload_1
    //   490: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   493: invokevirtual 874	com/tencent/smtt/sdk/n:c	()I
    //   496: istore 5
    //   498: aload_0
    //   499: aload_1
    //   500: invokevirtual 214	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;)I
    //   503: istore 6
    //   505: ldc 149
    //   507: ldc_w 876
    //   510: iload 5
    //   512: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   515: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   518: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: ldc 149
    //   523: ldc_w 878
    //   526: iload 6
    //   528: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   531: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   534: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   537: iload 5
    //   539: iflt +156 -> 695
    //   542: iload 5
    //   544: iconst_2
    //   545: if_icmpge +150 -> 695
    //   548: ldc 149
    //   550: ldc_w 880
    //   553: iconst_1
    //   554: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   557: iconst_1
    //   558: istore 4
    //   560: iload 5
    //   562: istore 6
    //   564: iload 4
    //   566: istore 5
    //   568: aload_1
    //   569: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   572: sipush -508
    //   575: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   578: ldc 149
    //   580: ldc_w 882
    //   583: iload 6
    //   585: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   588: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   591: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: iload 6
    //   596: ifgt +1156 -> 1752
    //   599: ldc 149
    //   601: ldc_w 884
    //   604: iconst_1
    //   605: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   608: aload_1
    //   609: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   612: sipush -509
    //   615: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   618: iload 5
    //   620: ifeq +157 -> 777
    //   623: aload_1
    //   624: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   627: ldc_w 886
    //   630: invokevirtual 512	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   633: istore 4
    //   635: iload 4
    //   637: bipush 10
    //   639: if_icmple +127 -> 766
    //   642: aload_1
    //   643: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   646: sipush 201
    //   649: ldc_w 888
    //   652: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   655: aload_0
    //   656: aload_1
    //   657: invokespecial 890	com/tencent/smtt/sdk/q:F	(Landroid/content/Context;)V
    //   660: aload_1
    //   661: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   664: sipush -510
    //   667: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   670: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   673: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   676: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   679: invokeinterface 528 1 0
    //   684: aload_0
    //   685: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   688: ldc_w 830
    //   691: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   725: ldc_w 754
    //   728: if_icmpne +20 -> 748
    //   731: iconst_m1
    //   732: istore 4
    //   734: aload_0
    //   735: aload_1
    //   736: invokevirtual 539	com/tencent/smtt/sdk/q:p	(Landroid/content/Context;)V
    //   739: ldc 149
    //   741: ldc_w 892
    //   744: iconst_1
    //   745: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   748: iconst_0
    //   749: istore 5
    //   751: iload 4
    //   753: istore 6
    //   755: goto -187 -> 568
    //   758: astore_1
    //   759: ldc_w 830
    //   762: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   765: return
    //   766: aload_1
    //   767: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   770: iload 4
    //   772: iconst_1
    //   773: iadd
    //   774: invokevirtual 894	com/tencent/smtt/sdk/n:b	(I)V
    //   777: aload_2
    //   778: ifnonnull +80 -> 858
    //   781: aload_1
    //   782: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   785: ldc_w 896
    //   788: invokevirtual 898	com/tencent/smtt/sdk/n:d	(Ljava/lang/String;)Ljava/lang/String;
    //   791: astore 15
    //   793: aload 15
    //   795: astore 14
    //   797: aload 15
    //   799: ifnonnull +62 -> 861
    //   802: aload_1
    //   803: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   806: sipush 202
    //   809: ldc_w 900
    //   812: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   815: aload_1
    //   816: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   819: sipush -511
    //   822: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   825: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   828: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   831: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   834: invokeinterface 528 1 0
    //   839: aload_0
    //   840: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   843: ldc_w 830
    //   846: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   849: return
    //   850: astore_1
    //   851: ldc_w 830
    //   854: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   857: return
    //   858: aload_2
    //   859: astore 14
    //   861: ldc 149
    //   863: ldc_w 902
    //   866: aload 14
    //   868: invokestatic 837	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   871: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   874: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   877: aload_0
    //   878: aload_1
    //   879: aload 14
    //   881: invokevirtual 905	com/tencent/smtt/sdk/q:c	(Landroid/content/Context;Ljava/lang/String;)I
    //   884: istore 8
    //   886: iload 8
    //   888: ifne +59 -> 947
    //   891: aload_1
    //   892: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   895: sipush -512
    //   898: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   901: aload_1
    //   902: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   905: sipush 203
    //   908: ldc_w 907
    //   911: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   914: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   917: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   920: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   923: invokeinterface 528 1 0
    //   928: aload_0
    //   929: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   932: ldc_w 830
    //   935: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   938: return
    //   939: astore_1
    //   940: ldc_w 830
    //   943: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   946: return
    //   947: aload_1
    //   948: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   951: ldc_w 896
    //   954: aload 14
    //   956: invokevirtual 909	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   959: aload_1
    //   960: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   963: iload 8
    //   965: iconst_0
    //   966: invokevirtual 346	com/tencent/smtt/sdk/n:c	(II)V
    //   969: aload_1
    //   970: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   973: sipush -548
    //   976: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   979: aload_1
    //   980: invokestatic 562	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   983: ifeq +70 -> 1053
    //   986: aload_0
    //   987: aload_1
    //   988: new 291	java/io/File
    //   991: dup
    //   992: aload 14
    //   994: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   997: iconst_1
    //   998: invokespecial 911	com/tencent/smtt/sdk/q:a	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1001: ifne +115 -> 1116
    //   1004: aload_1
    //   1005: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1008: sipush 207
    //   1011: ldc_w 913
    //   1014: getstatic 919	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_INSTALL_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   1017: invokevirtual 922	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;Lcom/tencent/smtt/sdk/TbsLogReport$EventType;)V
    //   1020: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1023: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1026: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1029: invokeinterface 528 1 0
    //   1034: aload_0
    //   1035: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   1038: ldc_w 830
    //   1041: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1044: return
    //   1045: astore_1
    //   1046: ldc_w 830
    //   1049: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1052: return
    //   1053: aload_0
    //   1054: aload_1
    //   1055: new 291	java/io/File
    //   1058: dup
    //   1059: aload 14
    //   1061: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   1064: invokespecial 925	com/tencent/smtt/sdk/q:b	(Landroid/content/Context;Ljava/io/File;)Z
    //   1067: ifne +49 -> 1116
    //   1070: aload_1
    //   1071: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1074: sipush 207
    //   1077: ldc_w 913
    //   1080: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1083: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1086: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1089: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1092: invokeinterface 528 1 0
    //   1097: aload_0
    //   1098: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   1101: ldc_w 830
    //   1104: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1107: return
    //   1108: astore_1
    //   1109: ldc_w 830
    //   1112: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1115: return
    //   1116: iload 5
    //   1118: ifeq +142 -> 1260
    //   1121: aload_1
    //   1122: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1125: ldc_w 927
    //   1128: invokevirtual 516	com/tencent/smtt/sdk/n:b	(Ljava/lang/String;)I
    //   1131: istore 4
    //   1133: iload 4
    //   1135: iconst_5
    //   1136: if_icmple +113 -> 1249
    //   1139: aload_1
    //   1140: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1143: sipush 223
    //   1146: ldc_w 929
    //   1149: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1152: aload_1
    //   1153: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1156: sipush -553
    //   1159: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1162: aload_0
    //   1163: aload_1
    //   1164: invokespecial 890	com/tencent/smtt/sdk/q:F	(Landroid/content/Context;)V
    //   1167: aload_1
    //   1168: invokestatic 931	com/tencent/smtt/sdk/m:e	(Landroid/content/Context;)V
    //   1171: aload_1
    //   1172: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1175: getfield 935	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1178: ldc_w 937
    //   1181: getstatic 943	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1184: invokeinterface 949 3 0
    //   1189: pop
    //   1190: aload_1
    //   1191: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1194: getfield 935	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1197: ldc_w 951
    //   1200: getstatic 943	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1203: invokeinterface 949 3 0
    //   1208: pop
    //   1209: aload_1
    //   1210: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1213: invokevirtual 953	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1216: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1219: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1222: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1225: invokeinterface 528 1 0
    //   1230: aload_0
    //   1231: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   1234: ldc_w 830
    //   1237: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1240: return
    //   1241: astore_1
    //   1242: ldc_w 830
    //   1245: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1248: return
    //   1249: aload_1
    //   1250: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1253: iload 4
    //   1255: iconst_1
    //   1256: iadd
    //   1257: invokevirtual 955	com/tencent/smtt/sdk/n:d	(I)V
    //   1260: ldc 149
    //   1262: ldc_w 957
    //   1265: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1268: invokestatic 960	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	()Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1271: getfield 198	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1274: ldc_w 962
    //   1277: iconst_0
    //   1278: invokeinterface 206 3 0
    //   1283: istore 4
    //   1285: aload_0
    //   1286: aload_1
    //   1287: invokevirtual 214	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;)I
    //   1290: ifeq +357 -> 1647
    //   1293: aload_1
    //   1294: ldc_w 964
    //   1297: aconst_null
    //   1298: invokestatic 967	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1301: astore 14
    //   1303: aload 14
    //   1305: ifnull +1046 -> 2351
    //   1308: aload 14
    //   1310: instanceof 939
    //   1313: ifeq +1038 -> 2351
    //   1316: aload 14
    //   1318: checkcast 939	java/lang/Boolean
    //   1321: invokevirtual 970	java/lang/Boolean:booleanValue	()Z
    //   1324: istore 13
    //   1326: iload 13
    //   1328: ifeq +319 -> 1647
    //   1331: new 972	android/os/Bundle
    //   1334: dup
    //   1335: invokespecial 973	android/os/Bundle:<init>	()V
    //   1338: astore 14
    //   1340: aload 14
    //   1342: ldc_w 975
    //   1345: iload 4
    //   1347: invokevirtual 977	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1350: aload_1
    //   1351: invokestatic 562	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1354: ifeq +89 -> 1443
    //   1357: aload 14
    //   1359: ldc_w 979
    //   1362: aload_0
    //   1363: aload_1
    //   1364: invokevirtual 571	com/tencent/smtt/sdk/q:q	(Landroid/content/Context;)Ljava/io/File;
    //   1367: invokevirtual 982	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1370: invokevirtual 985	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1373: aload_1
    //   1374: ldc_w 987
    //   1377: aload 14
    //   1379: invokestatic 967	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1382: astore 14
    //   1384: aload 14
    //   1386: ifnonnull +121 -> 1507
    //   1389: ldc 149
    //   1391: ldc_w 989
    //   1394: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1397: aload_1
    //   1398: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1401: sipush 222
    //   1404: ldc_w 991
    //   1407: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1410: iconst_0
    //   1411: istore 4
    //   1413: iload 4
    //   1415: ifne +232 -> 1647
    //   1418: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1421: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1424: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1427: invokeinterface 528 1 0
    //   1432: aload_0
    //   1433: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   1436: ldc_w 830
    //   1439: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1442: return
    //   1443: aload 14
    //   1445: ldc_w 979
    //   1448: aload_0
    //   1449: aload_1
    //   1450: iconst_0
    //   1451: invokevirtual 282	com/tencent/smtt/sdk/q:f	(Landroid/content/Context;I)Ljava/io/File;
    //   1454: invokevirtual 982	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1457: invokevirtual 985	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1460: goto -87 -> 1373
    //   1463: astore_1
    //   1464: iconst_0
    //   1465: istore_3
    //   1466: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1469: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1472: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1475: invokeinterface 528 1 0
    //   1480: aload_0
    //   1481: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   1484: iload_3
    //   1485: ifeq +14 -> 1499
    //   1488: getstatic 519	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   1491: sipush 232
    //   1494: invokeinterface 524 2 0
    //   1499: ldc_w 830
    //   1502: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1505: aload_1
    //   1506: athrow
    //   1507: aload 14
    //   1509: instanceof 939
    //   1512: ifeq +55 -> 1567
    //   1515: aload 14
    //   1517: checkcast 939	java/lang/Boolean
    //   1520: invokevirtual 970	java/lang/Boolean:booleanValue	()Z
    //   1523: ifeq +17 -> 1540
    //   1526: ldc 149
    //   1528: ldc_w 993
    //   1531: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1534: iconst_1
    //   1535: istore 4
    //   1537: goto -124 -> 1413
    //   1540: ldc 149
    //   1542: ldc_w 995
    //   1545: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1548: aload_1
    //   1549: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1552: sipush 222
    //   1555: ldc_w 995
    //   1558: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1561: iconst_0
    //   1562: istore 4
    //   1564: goto -151 -> 1413
    //   1567: aload 14
    //   1569: instanceof 972
    //   1572: ifeq +9 -> 1581
    //   1575: iconst_1
    //   1576: istore 4
    //   1578: goto -165 -> 1413
    //   1581: aload 14
    //   1583: instanceof 442
    //   1586: ifeq +47 -> 1633
    //   1589: ldc 149
    //   1591: new 231	java/lang/StringBuilder
    //   1594: dup
    //   1595: ldc_w 997
    //   1598: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1601: aload 14
    //   1603: checkcast 442	java/lang/Throwable
    //   1606: invokestatic 734	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1609: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1615: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1618: aload_1
    //   1619: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1622: sipush 222
    //   1625: aload 14
    //   1627: checkcast 442	java/lang/Throwable
    //   1630: invokevirtual 805	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   1633: iconst_0
    //   1634: istore 4
    //   1636: goto -223 -> 1413
    //   1639: astore_1
    //   1640: ldc_w 830
    //   1643: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1646: return
    //   1647: ldc 149
    //   1649: ldc_w 999
    //   1652: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1655: aload_1
    //   1656: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1659: iload 8
    //   1661: iconst_1
    //   1662: invokevirtual 346	com/tencent/smtt/sdk/n:c	(II)V
    //   1665: iload 8
    //   1667: istore 4
    //   1669: iload 6
    //   1671: iconst_2
    //   1672: if_icmpge +561 -> 2233
    //   1675: iload 5
    //   1677: ifeq +207 -> 1884
    //   1680: aload_1
    //   1681: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1684: ldc_w 1001
    //   1687: invokevirtual 512	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   1690: istore 5
    //   1692: iload 5
    //   1694: bipush 10
    //   1696: if_icmple +177 -> 1873
    //   1699: aload_1
    //   1700: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1703: sipush 208
    //   1706: ldc_w 1003
    //   1709: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1712: aload_1
    //   1713: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1716: sipush -514
    //   1719: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1722: aload_0
    //   1723: aload_1
    //   1724: invokespecial 890	com/tencent/smtt/sdk/q:F	(Landroid/content/Context;)V
    //   1727: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1730: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1733: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1736: invokeinterface 528 1 0
    //   1741: aload_0
    //   1742: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   1745: ldc_w 830
    //   1748: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1751: return
    //   1752: aload_1
    //   1753: invokestatic 562	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1756: ifeq +103 -> 1859
    //   1759: aload_2
    //   1760: ifnonnull +80 -> 1840
    //   1763: aload_1
    //   1764: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1767: ldc_w 896
    //   1770: invokevirtual 898	com/tencent/smtt/sdk/n:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1773: astore 15
    //   1775: aload 15
    //   1777: astore 14
    //   1779: aload 15
    //   1781: ifnonnull +62 -> 1843
    //   1784: aload_1
    //   1785: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1788: sipush 202
    //   1791: ldc_w 900
    //   1794: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1797: aload_1
    //   1798: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1801: sipush -511
    //   1804: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1807: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1810: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1813: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1816: invokeinterface 528 1 0
    //   1821: aload_0
    //   1822: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   1825: ldc_w 830
    //   1828: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1831: return
    //   1832: astore_1
    //   1833: ldc_w 830
    //   1836: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1839: return
    //   1840: aload_2
    //   1841: astore 14
    //   1843: aload_0
    //   1844: aload_1
    //   1845: new 291	java/io/File
    //   1848: dup
    //   1849: aload 14
    //   1851: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   1854: iconst_1
    //   1855: invokespecial 911	com/tencent/smtt/sdk/q:a	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1858: pop
    //   1859: iconst_0
    //   1860: istore 4
    //   1862: goto -193 -> 1669
    //   1865: astore_1
    //   1866: ldc_w 830
    //   1869: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1872: return
    //   1873: aload_1
    //   1874: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1877: iload 5
    //   1879: iconst_1
    //   1880: iadd
    //   1881: invokevirtual 1005	com/tencent/smtt/sdk/n:a	(I)V
    //   1884: aload_1
    //   1885: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1888: sipush -549
    //   1891: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1894: aload_0
    //   1895: aload_1
    //   1896: iconst_0
    //   1897: invokespecial 1008	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;I)Z
    //   1900: ifne +46 -> 1946
    //   1903: aload_1
    //   1904: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1907: sipush -515
    //   1910: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1913: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1916: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1919: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1922: invokeinterface 528 1 0
    //   1927: aload_0
    //   1928: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   1931: ldc_w 830
    //   1934: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1937: return
    //   1938: astore_1
    //   1939: ldc_w 830
    //   1942: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1945: return
    //   1946: aload_1
    //   1947: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1950: iload 4
    //   1952: iconst_2
    //   1953: invokevirtual 346	com/tencent/smtt/sdk/n:c	(II)V
    //   1956: ldc 149
    //   1958: ldc_w 1010
    //   1961: iconst_1
    //   1962: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1965: aload_1
    //   1966: invokestatic 1011	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)V
    //   1969: aload_1
    //   1970: invokestatic 1012	com/tencent/smtt/sdk/m:b	(Landroid/content/Context;)V
    //   1973: ldc 149
    //   1975: ldc_w 1014
    //   1978: iload_3
    //   1979: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1982: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1985: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1988: aload_1
    //   1989: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1992: sipush -516
    //   1995: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1998: getstatic 482	android/os/Build$VERSION:SDK_INT	I
    //   2001: bipush 11
    //   2003: if_icmplt +155 -> 2158
    //   2006: aload_1
    //   2007: ldc_w 484
    //   2010: iconst_4
    //   2011: invokevirtual 488	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2014: astore 14
    //   2016: aload 14
    //   2018: invokeinterface 705 1 0
    //   2023: astore 14
    //   2025: aload 14
    //   2027: ldc_w 707
    //   2030: iconst_0
    //   2031: invokeinterface 713 3 0
    //   2036: pop
    //   2037: aload 14
    //   2039: ldc_w 715
    //   2042: iconst_0
    //   2043: invokeinterface 713 3 0
    //   2048: pop
    //   2049: aload 14
    //   2051: ldc_w 717
    //   2054: iload_3
    //   2055: invokeinterface 713 3 0
    //   2060: pop
    //   2061: aload 14
    //   2063: invokeinterface 720 1 0
    //   2068: pop
    //   2069: aload_1
    //   2070: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2073: sipush -517
    //   2076: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2079: iload_3
    //   2080: ldc_w 754
    //   2083: if_icmpne +10 -> 2093
    //   2086: aload_0
    //   2087: iload_3
    //   2088: aload_2
    //   2089: aload_1
    //   2090: invokespecial 1016	com/tencent/smtt/sdk/q:a	(ILjava/lang/String;Landroid/content/Context;)V
    //   2093: aload_0
    //   2094: getfield 130	com/tencent/smtt/sdk/q:k	Z
    //   2097: ifeq +115 -> 2212
    //   2100: aload_1
    //   2101: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2104: aload_0
    //   2105: aload_1
    //   2106: invokespecial 1019	com/tencent/smtt/sdk/q:v	(Landroid/content/Context;)I
    //   2109: ldc_w 699
    //   2112: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2115: iload 7
    //   2117: istore_3
    //   2118: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2121: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2124: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   2127: invokeinterface 528 1 0
    //   2132: aload_0
    //   2133: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   2136: iload_3
    //   2137: ifeq +125 -> 2262
    //   2140: getstatic 519	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   2143: sipush 232
    //   2146: invokeinterface 524 2 0
    //   2151: ldc_w 830
    //   2154: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2157: return
    //   2158: aload_1
    //   2159: ldc_w 484
    //   2162: iconst_0
    //   2163: invokevirtual 488	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2166: astore 14
    //   2168: goto -152 -> 2016
    //   2171: astore 14
    //   2173: ldc 149
    //   2175: new 231	java/lang/StringBuilder
    //   2178: dup
    //   2179: ldc_w 1021
    //   2182: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2185: aload 14
    //   2187: invokestatic 734	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2190: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2193: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2196: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2199: aload_1
    //   2200: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2203: sipush -518
    //   2206: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2209: goto -130 -> 2079
    //   2212: aload_1
    //   2213: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2216: aload_0
    //   2217: aload_1
    //   2218: invokespecial 1019	com/tencent/smtt/sdk/q:v	(Landroid/content/Context;)I
    //   2221: ldc_w 726
    //   2224: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2227: iload 7
    //   2229: istore_3
    //   2230: goto -112 -> 2118
    //   2233: iload 6
    //   2235: iconst_2
    //   2236: if_icmpne +110 -> 2346
    //   2239: getstatic 519	com/tencent/smtt/sdk/QbSdk:l	Lcom/tencent/smtt/sdk/TbsListener;
    //   2242: sipush 200
    //   2245: invokeinterface 524 2 0
    //   2250: iload 7
    //   2252: istore_3
    //   2253: goto -135 -> 2118
    //   2256: astore_1
    //   2257: iconst_1
    //   2258: istore_3
    //   2259: goto -793 -> 1466
    //   2262: ldc_w 830
    //   2265: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2268: return
    //   2269: aload_1
    //   2270: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2273: sipush -519
    //   2276: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2279: aload_0
    //   2280: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   2283: ldc_w 830
    //   2286: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2289: return
    //   2290: astore_1
    //   2291: goto -155 -> 2136
    //   2294: astore_2
    //   2295: goto -811 -> 1484
    //   2298: astore_2
    //   2299: goto -819 -> 1480
    //   2302: astore_1
    //   2303: goto -171 -> 2132
    //   2306: astore_1
    //   2307: goto -380 -> 1927
    //   2310: astore_1
    //   2311: goto -570 -> 1741
    //   2314: astore_1
    //   2315: goto -494 -> 1821
    //   2318: astore_1
    //   2319: goto -887 -> 1432
    //   2322: astore_1
    //   2323: goto -1093 -> 1230
    //   2326: astore_1
    //   2327: goto -1230 -> 1097
    //   2330: astore_1
    //   2331: goto -1297 -> 1034
    //   2334: astore_1
    //   2335: goto -1407 -> 928
    //   2338: astore_1
    //   2339: goto -1500 -> 839
    //   2342: astore_1
    //   2343: goto -1659 -> 684
    //   2346: iconst_0
    //   2347: istore_3
    //   2348: goto -230 -> 2118
    //   2351: iconst_0
    //   2352: istore 13
    //   2354: goto -1028 -> 1326
    //   2357: iload 4
    //   2359: ifle -1870 -> 489
    //   2362: iload_3
    //   2363: iload 4
    //   2365: if_icmple -1876 -> 489
    //   2368: goto -1884 -> 484
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2371	0	this	q
    //   0	2371	1	paramContext	Context
    //   0	2371	2	paramString	String
    //   0	2371	3	paramInt	int
    //   412	1954	4	i1	int
    //   421	1460	5	i2	int
    //   503	1734	6	i3	int
    //   1	2250	7	i4	int
    //   884	782	8	i5	int
    //   263	39	9	l1	long
    //   272	41	11	l2	long
    //   363	1990	13	bool	boolean
    //   178	1989	14	localObject	Object
    //   2171	15	14	localThrowable	Throwable
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
    //   1946	2016	1463	finally
    //   2086	2093	1463	finally
    //   2093	2115	1463	finally
    //   2158	2168	1463	finally
    //   2173	2209	1463	finally
    //   2212	2227	1463	finally
    //   1432	1436	1639	java/lang/Exception
    //   1821	1825	1832	java/lang/Exception
    //   1741	1745	1865	java/lang/Exception
    //   1927	1931	1938	java/lang/Exception
    //   2016	2079	2171	finally
    //   2239	2250	2256	finally
    //   2132	2136	2290	java/lang/Exception
    //   1480	1484	2294	java/lang/Exception
    //   1466	1480	2298	java/lang/Exception
    //   2118	2132	2302	java/lang/Exception
    //   1913	1927	2306	java/lang/Exception
    //   1727	1741	2310	java/lang/Exception
    //   1807	1821	2314	java/lang/Exception
    //   1418	1432	2318	java/lang/Exception
    //   1216	1230	2322	java/lang/Exception
    //   1083	1097	2326	java/lang/Exception
    //   1020	1034	2330	java/lang/Exception
    //   914	928	2334	java/lang/Exception
    //   825	839	2338	java/lang/Exception
    //   670	684	2342	java/lang/Exception
  }
  
  private boolean b(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(219609);
    boolean bool = a(paramContext, paramFile, false);
    AppMethodBeat.o(219609);
    return bool;
  }
  
  /* Error */
  private int c(Context paramContext, Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 1024
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 209	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   9: aload_1
    //   10: iconst_0
    //   11: invokespecial 333	com/tencent/smtt/sdk/q:g	(Landroid/content/Context;Z)V
    //   14: aload_1
    //   15: aload_2
    //   16: invokestatic 1027	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   19: astore 8
    //   21: ldc 149
    //   23: ldc_w 1029
    //   26: aload 8
    //   28: invokestatic 837	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   31: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   34: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload 8
    //   39: ldc_w 1031
    //   42: invokevirtual 1033	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   45: istore 4
    //   47: iload 4
    //   49: ifne +546 -> 595
    //   52: aload_2
    //   53: ldc_w 1035
    //   56: invokevirtual 1038	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore 8
    //   61: aload_2
    //   62: ldc_w 1040
    //   65: invokevirtual 1033	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   68: istore 5
    //   70: aload_2
    //   71: ldc_w 1042
    //   74: invokevirtual 1033	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   77: istore_3
    //   78: iload_3
    //   79: iconst_1
    //   80: if_icmpne +369 -> 449
    //   83: new 291	java/io/File
    //   86: dup
    //   87: aload_1
    //   88: ldc_w 308
    //   91: iconst_4
    //   92: iconst_1
    //   93: invokestatic 1045	com/tencent/smtt/utils/f:a	(Landroid/content/Context;Ljava/lang/String;IZ)Ljava/lang/String;
    //   96: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: astore_2
    //   100: aload_1
    //   101: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   104: astore 8
    //   106: aload 8
    //   108: getfield 198	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   111: ldc_w 1047
    //   114: iconst_0
    //   115: invokeinterface 206 3 0
    //   120: istore 6
    //   122: aload_2
    //   123: invokevirtual 609	java/io/File:listFiles	()[Ljava/io/File;
    //   126: astore 9
    //   128: iconst_0
    //   129: iload 6
    //   131: invokestatic 1050	com/tencent/smtt/utils/a:a	(ZI)Ljava/lang/String;
    //   134: invokestatic 1056	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   137: astore 10
    //   139: aload 9
    //   141: arraylength
    //   142: istore 7
    //   144: iconst_0
    //   145: istore 4
    //   147: iload 4
    //   149: iload 7
    //   151: if_icmpge +51 -> 202
    //   154: aload 9
    //   156: iload 4
    //   158: aaload
    //   159: astore 11
    //   161: aload 10
    //   163: aload 11
    //   165: invokevirtual 612	java/io/File:getName	()Ljava/lang/String;
    //   168: invokevirtual 1060	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   171: invokevirtual 1065	java/util/regex/Matcher:find	()Z
    //   174: ifeq +472 -> 646
    //   177: aload 11
    //   179: invokevirtual 1068	java/io/File:isFile	()Z
    //   182: ifeq +464 -> 646
    //   185: aload 11
    //   187: invokevirtual 601	java/io/File:exists	()Z
    //   190: ifeq +456 -> 646
    //   193: aload 11
    //   195: invokevirtual 366	java/io/File:delete	()Z
    //   198: pop
    //   199: goto +447 -> 646
    //   202: new 291	java/io/File
    //   205: dup
    //   206: aload_2
    //   207: new 231	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 686	java/lang/StringBuilder:<init>	()V
    //   214: iconst_0
    //   215: iload 6
    //   217: invokestatic 1050	com/tencent/smtt/utils/a:a	(ZI)Ljava/lang/String;
    //   220: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc_w 1070
    //   226: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 8
    //   231: getfield 198	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   234: ldc_w 1072
    //   237: iconst_0
    //   238: invokeinterface 206 3 0
    //   243: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   252: astore_2
    //   253: aload_2
    //   254: invokevirtual 601	java/io/File:exists	()Z
    //   257: ifne +8 -> 265
    //   260: aload_2
    //   261: invokevirtual 1075	java/io/File:createNewFile	()Z
    //   264: pop
    //   265: aload_1
    //   266: iload 6
    //   268: invokestatic 671	com/tencent/smtt/sdk/TbsShareManager:getTbsStableCoreVersion	(Landroid/content/Context;I)I
    //   271: istore 4
    //   273: ldc_w 1077
    //   276: iload 4
    //   278: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   281: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   284: astore_2
    //   285: aload_1
    //   286: ldc_w 1079
    //   289: new 231	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 686	java/lang/StringBuilder:<init>	()V
    //   296: aload_2
    //   297: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc_w 1081
    //   303: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: iload 5
    //   308: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   311: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 697	com/tencent/smtt/utils/r:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   317: ldc 149
    //   319: new 231	java/lang/StringBuilder
    //   322: dup
    //   323: ldc_w 1083
    //   326: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   329: iload_3
    //   330: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: ldc_w 1085
    //   336: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: iload 5
    //   341: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: ldc_w 1087
    //   347: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: iload 4
    //   352: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: iload 5
    //   363: iload 4
    //   365: if_icmpeq +102 -> 467
    //   368: ldc 149
    //   370: new 231	java/lang/StringBuilder
    //   373: dup
    //   374: ldc_w 1089
    //   377: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   380: iload 5
    //   382: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: ldc_w 1091
    //   388: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: iload 4
    //   393: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   396: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: aload_1
    //   403: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   406: sipush 240
    //   409: new 231	java/lang/StringBuilder
    //   412: dup
    //   413: ldc_w 1093
    //   416: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   419: iload 5
    //   421: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   424: ldc_w 1095
    //   427: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: iload 4
    //   432: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   435: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   441: ldc_w 1024
    //   444: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   447: iconst_1
    //   448: ireturn
    //   449: aload_0
    //   450: new 291	java/io/File
    //   453: dup
    //   454: aload 8
    //   456: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   459: invokevirtual 1097	com/tencent/smtt/sdk/q:a	(Ljava/io/File;)I
    //   462: istore 4
    //   464: goto -147 -> 317
    //   467: iconst_0
    //   468: istore 5
    //   470: iload_3
    //   471: iconst_1
    //   472: if_icmpne +21 -> 493
    //   475: aload_1
    //   476: ldc_w 1099
    //   479: ldc_w 1101
    //   482: iload 4
    //   484: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   487: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   490: invokestatic 697	com/tencent/smtt/utils/r:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   493: aload_1
    //   494: invokestatic 562	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   497: ifeq +35 -> 532
    //   500: ldc 149
    //   502: ldc_w 1103
    //   505: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: aload_1
    //   509: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   512: sipush 237
    //   515: ldc_w 634
    //   518: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   521: iload 5
    //   523: istore_3
    //   524: ldc_w 1024
    //   527: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   530: iload_3
    //   531: ireturn
    //   532: ldc 149
    //   534: ldc_w 1105
    //   537: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: aload_1
    //   541: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   544: sipush 236
    //   547: ldc_w 634
    //   550: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   553: iload 5
    //   555: istore_3
    //   556: goto -32 -> 524
    //   559: astore_2
    //   560: iconst_1
    //   561: istore_3
    //   562: aload_1
    //   563: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   566: sipush 239
    //   569: new 231	java/lang/StringBuilder
    //   572: dup
    //   573: ldc_w 1107
    //   576: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   579: aload_2
    //   580: invokestatic 734	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   583: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   592: goto -68 -> 524
    //   595: iconst_1
    //   596: istore_3
    //   597: aload_2
    //   598: ldc_w 1035
    //   601: invokevirtual 1038	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   604: astore_2
    //   605: aload_2
    //   606: invokestatic 1113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   609: ifne +14 -> 623
    //   612: new 291	java/io/File
    //   615: dup
    //   616: aload_2
    //   617: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   620: invokestatic 774	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   623: aload_1
    //   624: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   627: iload 4
    //   629: ldc_w 1115
    //   632: iload 4
    //   634: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   637: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   640: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   643: goto -119 -> 524
    //   646: iload 4
    //   648: iconst_1
    //   649: iadd
    //   650: istore 4
    //   652: goto -505 -> 147
    //   655: astore_2
    //   656: iconst_0
    //   657: istore_3
    //   658: goto -580 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	this	q
    //   0	661	1	paramContext	Context
    //   0	661	2	paramBundle	Bundle
    //   77	581	3	i1	int
    //   45	606	4	i2	int
    //   68	486	5	i3	int
    //   120	147	6	i4	int
    //   142	10	7	i5	int
    //   19	436	8	localObject	Object
    //   126	29	9	arrayOfFile	File[]
    //   137	25	10	localPattern	java.util.regex.Pattern
    //   159	35	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   6	47	559	java/lang/Exception
    //   52	70	559	java/lang/Exception
    //   83	144	559	java/lang/Exception
    //   161	199	559	java/lang/Exception
    //   202	265	559	java/lang/Exception
    //   265	317	559	java/lang/Exception
    //   317	361	559	java/lang/Exception
    //   368	441	559	java/lang/Exception
    //   449	464	559	java/lang/Exception
    //   475	493	559	java/lang/Exception
    //   493	521	559	java/lang/Exception
    //   532	553	559	java/lang/Exception
    //   597	623	559	java/lang/Exception
    //   623	643	559	java/lang/Exception
    //   70	78	655	finally
  }
  
  /* Error */
  private boolean c(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: ldc_w 1116
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: new 14	com/tencent/smtt/sdk/q$5
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 1119	com/tencent/smtt/sdk/q$5:<init>	(Lcom/tencent/smtt/sdk/q;)V
    //   15: invokevirtual 1122	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   18: astore 6
    //   20: aload 6
    //   22: arraylength
    //   23: istore 4
    //   25: getstatic 482	android/os/Build$VERSION:SDK_INT	I
    //   28: bipush 16
    //   30: if_icmpge +33 -> 63
    //   33: aload_1
    //   34: invokevirtual 1125	android/content/Context:getPackageName	()Ljava/lang/String;
    //   37: ifnull +26 -> 63
    //   40: aload_1
    //   41: invokevirtual 1125	android/content/Context:getPackageName	()Ljava/lang/String;
    //   44: ldc_w 1127
    //   47: invokevirtual 1130	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   50: istore 5
    //   52: iload 5
    //   54: ifeq +9 -> 63
    //   57: ldc2_w 1131
    //   60: invokestatic 1136	java/lang/Thread:sleep	(J)V
    //   63: aload_1
    //   64: invokevirtual 1140	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   67: astore 7
    //   69: iconst_0
    //   70: istore_3
    //   71: iload_3
    //   72: iload 4
    //   74: if_icmpge +60 -> 134
    //   77: ldc 149
    //   79: new 231	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 1142
    //   86: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: aload 6
    //   91: iload_3
    //   92: aaload
    //   93: invokevirtual 982	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   96: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: new 1144	dalvik/system/DexClassLoader
    //   108: dup
    //   109: aload 6
    //   111: iload_3
    //   112: aaload
    //   113: invokevirtual 982	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   116: aload_2
    //   117: invokevirtual 982	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   120: aconst_null
    //   121: aload 7
    //   123: invokespecial 1147	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   126: pop
    //   127: iload_3
    //   128: iconst_1
    //   129: iadd
    //   130: istore_3
    //   131: goto -60 -> 71
    //   134: ldc_w 1116
    //   137: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: iconst_1
    //   141: ireturn
    //   142: astore_2
    //   143: aload_1
    //   144: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   147: sipush 209
    //   150: aload_2
    //   151: invokevirtual 259	java/lang/Exception:toString	()Ljava/lang/String;
    //   154: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   157: ldc 149
    //   159: ldc_w 1149
    //   162: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: ldc_w 1116
    //   168: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   8: ldc_w 1151
    //   11: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: ldc 149
    //   16: ldc_w 1153
    //   19: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 497	com/tencent/smtt/sdk/q:u	(Landroid/content/Context;)Z
    //   27: istore 7
    //   29: iload 7
    //   31: ifne +16 -> 47
    //   34: ldc_w 1151
    //   37: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iload 6
    //   42: istore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_2
    //   46: ireturn
    //   47: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   50: invokevirtual 1154	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   53: istore 6
    //   55: ldc 149
    //   57: ldc_w 1156
    //   60: iload 6
    //   62: invokestatic 302	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   65: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iload 6
    //   73: ifeq +212 -> 285
    //   76: aload_1
    //   77: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   80: ldc_w 1158
    //   83: invokevirtual 516	com/tencent/smtt/sdk/n:b	(Ljava/lang/String;)I
    //   86: istore_3
    //   87: aload_0
    //   88: iconst_0
    //   89: aload_1
    //   90: invokevirtual 1161	com/tencent/smtt/sdk/q:a	(ZLandroid/content/Context;)I
    //   93: istore 4
    //   95: ldc 149
    //   97: ldc_w 1163
    //   100: iload_3
    //   101: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   104: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: ldc 149
    //   112: ldc_w 1165
    //   115: iload 4
    //   117: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   120: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   123: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: iload_3
    //   127: iconst_1
    //   128: if_icmpne +152 -> 280
    //   131: iload 4
    //   133: ifne +50 -> 183
    //   136: ldc 149
    //   138: ldc_w 1167
    //   141: iconst_1
    //   142: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   145: aload_0
    //   146: aload_1
    //   147: invokespecial 1170	com/tencent/smtt/sdk/q:z	(Landroid/content/Context;)V
    //   150: iload 5
    //   152: istore_2
    //   153: iload_2
    //   154: istore 5
    //   156: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   159: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   162: iload_2
    //   163: istore 5
    //   165: aload_0
    //   166: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   169: ldc_w 1151
    //   172: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: goto -132 -> 43
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    //   183: iload_2
    //   184: ifeq +96 -> 280
    //   187: ldc 149
    //   189: ldc_w 1172
    //   192: iconst_1
    //   193: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   196: aload_0
    //   197: aload_1
    //   198: invokespecial 1170	com/tencent/smtt/sdk/q:z	(Landroid/content/Context;)V
    //   201: iload 5
    //   203: istore_2
    //   204: goto -51 -> 153
    //   207: astore 8
    //   209: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   212: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   215: ldc_w 1151
    //   218: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload 8
    //   223: athrow
    //   224: astore 8
    //   226: iconst_0
    //   227: istore 5
    //   229: aload_1
    //   230: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   233: sipush 215
    //   236: aload 8
    //   238: invokevirtual 1173	java/lang/Throwable:toString	()Ljava/lang/String;
    //   241: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   244: aload_1
    //   245: new 231	java/lang/StringBuilder
    //   248: dup
    //   249: ldc_w 1175
    //   252: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   255: aload 8
    //   257: invokestatic 734	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   260: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 355	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
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
    //   207	15	8	localObject1	Object
    //   224	32	8	localThrowable	Throwable
    //   275	1	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	22	178	finally
    //   34	40	178	finally
    //   169	175	178	finally
    //   229	269	178	finally
    //   76	126	207	finally
    //   136	150	207	finally
    //   187	201	207	finally
    //   22	29	224	finally
    //   47	71	224	finally
    //   209	224	224	finally
    //   156	162	275	finally
    //   165	169	275	finally
  }
  
  private boolean d(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(219646);
    try
    {
      Object localObject1 = new File(paramFile, "tbs_sdk_extension_dex.jar");
      Object localObject2 = new File(paramFile, "tbs_sdk_extension_dex.dex");
      Object localObject3 = paramContext.getClassLoader();
      new DexClassLoader(((File)localObject1).getAbsolutePath(), paramFile.getAbsolutePath(), null, (ClassLoader)localObject3);
      localObject1 = f.a(paramContext, ((File)localObject2).getAbsolutePath());
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, "can not find oat command");
        AppMethodBeat.o(219646);
        return false;
      }
      paramFile = paramFile.listFiles(new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          AppMethodBeat.i(219638);
          boolean bool = paramAnonymousFile.getName().endsWith(".jar");
          AppMethodBeat.o(219638);
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
      AppMethodBeat.o(219646);
      return true;
    }
    catch (Exception paramFile)
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, paramFile);
      AppMethodBeat.o(219646);
    }
    return false;
  }
  
  private boolean d(Context paramContext, boolean paramBoolean)
  {
    boolean bool2 = false;
    bool1 = true;
    for (;;)
    {
      boolean bool3;
      int i1;
      int i2;
      label153:
      label162:
      try
      {
        AppMethodBeat.i(219506);
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
      }
      finally {}
      for (;;)
      {
        try
        {
          bool3 = u(paramContext);
          if (!bool3)
          {
            AppMethodBeat.o(219506);
            paramBoolean = bool2;
            return paramBoolean;
          }
          bool2 = i.tryLock();
          TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy Locked =".concat(String.valueOf(bool2)));
          if (!bool2) {
            continue;
          }
        }
        finally
        {
          bool1 = false;
          paramBoolean = false;
          break label153;
          paramBoolean = false;
          break label162;
        }
        try
        {
          i1 = n.a(paramContext).b("copy_status");
          i2 = a(false, paramContext);
          TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy copyStatus =".concat(String.valueOf(i1)));
          TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =".concat(String.valueOf(i2)));
          if (i1 != 1) {
            continue;
          }
          if (i2 == 0)
          {
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0", true);
            A(paramContext);
            paramBoolean = bool1;
            bool1 = paramBoolean;
          }
        }
        finally
        {
          i.unlock();
          AppMethodBeat.o(219506);
        }
      }
      try
      {
        i.unlock();
        bool1 = paramBoolean;
        b();
      }
      finally
      {
        for (;;)
        {
          try
          {
            TbsLogReport.getInstance(paramContext).setInstallErrorCode(215, localThrowable.toString());
            QbSdk.a(paramContext, "TbsInstaller::enableTbsCoreFromCopy exception:" + Log.getStackTraceString(localThrowable));
            paramBoolean = bool1;
          }
          finally
          {
            AppMethodBeat.o(219506);
          }
        }
      }
      AppMethodBeat.o(219506);
      continue;
      if (!paramBoolean) {
        break label289;
      }
      TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0", true);
      A(paramContext);
      paramBoolean = bool1;
    }
  }
  
  private boolean e(Context paramContext, String paramString)
  {
    AppMethodBeat.i(219608);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null)
      {
        AppMethodBeat.o(219608);
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
      AppMethodBeat.o(219608);
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
    //   8: ldc_w 1255
    //   11: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_1
    //   15: ifnull +35 -> 50
    //   18: ldc_w 308
    //   21: aload_1
    //   22: invokevirtual 314	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   25: invokevirtual 318	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   28: getfield 324	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   31: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +16 -> 50
    //   37: aload_1
    //   38: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   41: sipush 229
    //   44: ldc_w 330
    //   47: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   50: ldc 149
    //   52: ldc_w 1257
    //   55: iload_2
    //   56: invokestatic 302	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   59: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   62: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: ldc 149
    //   67: ldc_w 1259
    //   70: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: aload_1
    //   75: invokevirtual 497	com/tencent/smtt/sdk/q:u	(Landroid/content/Context;)Z
    //   78: istore 7
    //   80: iload 7
    //   82: ifne +16 -> 98
    //   85: ldc_w 1255
    //   88: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: iload 6
    //   93: istore_2
    //   94: aload_0
    //   95: monitorexit
    //   96: iload_2
    //   97: ireturn
    //   98: ldc 149
    //   100: ldc_w 1261
    //   103: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   109: invokevirtual 1154	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   112: istore 6
    //   114: ldc 149
    //   116: ldc_w 1263
    //   119: iload 6
    //   121: invokestatic 302	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   124: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   127: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: iload 6
    //   132: ifeq +176 -> 308
    //   135: aload_1
    //   136: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   139: invokevirtual 874	com/tencent/smtt/sdk/n:c	()I
    //   142: istore_3
    //   143: ldc 149
    //   145: ldc_w 1265
    //   148: iload_3
    //   149: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   152: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   155: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload_0
    //   159: iconst_0
    //   160: aload_1
    //   161: invokevirtual 1161	com/tencent/smtt/sdk/q:a	(ZLandroid/content/Context;)I
    //   164: istore 4
    //   166: iload_3
    //   167: iconst_2
    //   168: if_icmpne +135 -> 303
    //   171: ldc 149
    //   173: ldc_w 1267
    //   176: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: iload 4
    //   181: ifne +50 -> 231
    //   184: ldc 149
    //   186: ldc_w 1269
    //   189: iconst_0
    //   190: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   193: aload_0
    //   194: aload_1
    //   195: invokespecial 1272	com/tencent/smtt/sdk/q:y	(Landroid/content/Context;)V
    //   198: iload 5
    //   200: istore_2
    //   201: iload_2
    //   202: istore 5
    //   204: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   207: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   210: iload_2
    //   211: istore 5
    //   213: aload_0
    //   214: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   217: ldc_w 1255
    //   220: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: goto -129 -> 94
    //   226: astore_1
    //   227: aload_0
    //   228: monitorexit
    //   229: aload_1
    //   230: athrow
    //   231: iload_2
    //   232: ifeq +71 -> 303
    //   235: ldc 149
    //   237: ldc_w 1274
    //   240: iconst_0
    //   241: invokestatic 373	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   244: aload_0
    //   245: aload_1
    //   246: invokespecial 1272	com/tencent/smtt/sdk/q:y	(Landroid/content/Context;)V
    //   249: iload 5
    //   251: istore_2
    //   252: goto -51 -> 201
    //   255: astore 8
    //   257: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   260: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   263: ldc_w 1255
    //   266: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload 8
    //   271: athrow
    //   272: astore 8
    //   274: iconst_0
    //   275: istore 5
    //   277: aload_1
    //   278: ldc_w 1276
    //   281: aload 8
    //   283: invokestatic 837	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   286: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   289: invokestatic 355	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
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
    AppMethodBeat.i(219579);
    if (paramContext == null)
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(225, "setTmpFolderCoreToRead context is null");
      AppMethodBeat.o(219579);
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
        AppMethodBeat.o(219579);
        return;
      }
    }
    catch (Exception localException)
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(225, "setTmpFolderCoreToRead Exception message is " + localException.getMessage() + " Exception cause is " + localException.getCause());
      AppMethodBeat.o(219579);
      return;
    }
    com.tencent.smtt.utils.f.b(localException);
    label123:
    AppMethodBeat.o(219579);
  }
  
  private void h(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(219591);
    TbsLog.i("TbsInstaller", "proceedTpatchStatus,result=".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      QbSdk.setTBSInstallingStatus(false);
      AppMethodBeat.o(219591);
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
    AppMethodBeat.i(219616);
    File localFile1 = a().f(paramContext, paramInt);
    a().g(paramContext, true);
    File localFile2 = q(paramContext);
    com.tencent.smtt.utils.f.a(localFile2, true);
    localFile1.renameTo(localFile2);
    TbsShareManager.b(paramContext);
    AppMethodBeat.o(219616);
  }
  
  private boolean j(Context paramContext, int paramInt)
  {
    int i3 = 0;
    AppMethodBeat.i(219619);
    TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt start - dirMode: ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    try
    {
      TbsLog.e("TbsInstaller", "doDexoptOrDexoat mode error: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(219619);
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
      AppMethodBeat.o(219619);
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
      finally
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
        AppMethodBeat.o(219619);
        return true;
        TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
        bool = c(paramContext, localFile);
        AppMethodBeat.o(219619);
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
      if ((i2 == 0) || (!d(paramContext, localFile))) {
        continue;
      }
      TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoatForArtVm");
      AppMethodBeat.o(219619);
      return true;
      localFile = f(paramContext, 1);
      continue;
      localFile = r(paramContext);
    }
  }
  
  static File t(Context paramContext)
  {
    AppMethodBeat.i(219641);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_private");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(219641);
      return null;
    }
    AppMethodBeat.o(219641);
    return paramContext;
  }
  
  private int v(Context paramContext)
  {
    int i1 = 1;
    AppMethodBeat.i(219567);
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
      AppMethodBeat.o(219567);
      return 234;
      i1 = 0;
    }
    AppMethodBeat.o(219567);
    return 221;
    label57:
    if (bool)
    {
      AppMethodBeat.o(219567);
      return 233;
    }
    AppMethodBeat.o(219567);
    return 200;
  }
  
  private static boolean w(Context paramContext)
  {
    AppMethodBeat.i(219573);
    if (paramContext == null)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #1");
      AppMethodBeat.o(219573);
      return true;
    }
    try
    {
      if (new File(QbSdk.getTbsFolderDir(paramContext), "tmp_folder_core_to_read.conf").exists())
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #2");
        AppMethodBeat.o(219573);
        return true;
      }
      TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #3");
      AppMethodBeat.o(219573);
      return false;
    }
    catch (Exception paramContext)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #4");
      AppMethodBeat.o(219573);
    }
    return true;
  }
  
  private boolean x(Context paramContext)
  {
    AppMethodBeat.i(219621);
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
        AppMethodBeat.o(219621);
        return false;
      }
    }
    finally
    {
      for (;;)
      {
        boolean bool = true;
        continue;
        l = com.tencent.smtt.utils.f.f(paramContext);
      }
      label88:
      TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
      AppMethodBeat.o(219621);
    }
    return true;
  }
  
  private void y(Context paramContext)
  {
    AppMethodBeat.i(219623);
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
    if (!x(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      AppMethodBeat.o(219623);
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
      finally
      {
        int i1;
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from unzip:" + localObject.toString());
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
      AppMethodBeat.o(219623);
      return;
      TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
    }
  }
  
  private void z(Context paramContext)
  {
    AppMethodBeat.i(219625);
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
    if (!x(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      AppMethodBeat.o(219625);
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
      AppMethodBeat.o(219625);
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
    //   0: ldc_w 1405
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: ldc 149
    //   11: ldc_w 1407
    //   14: aload_1
    //   15: invokestatic 837	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   21: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: new 291	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: ldc_w 386
    //   32: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 601	java/io/File:exists	()Z
    //   40: istore_3
    //   41: iload_3
    //   42: ifne +11 -> 53
    //   45: ldc_w 1405
    //   48: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_0
    //   52: ireturn
    //   53: new 388	java/util/Properties
    //   56: dup
    //   57: invokespecial 389	java/util/Properties:<init>	()V
    //   60: astore 5
    //   62: new 391	java/io/BufferedInputStream
    //   65: dup
    //   66: new 393	java/io/FileInputStream
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 396	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   74: invokespecial 399	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   77: astore_1
    //   78: aload 5
    //   80: aload_1
    //   81: invokevirtual 402	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   84: aload_1
    //   85: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   88: aload 5
    //   90: ldc_w 1409
    //   93: invokevirtual 1410	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 4
    //   98: aload 4
    //   100: ifnonnull +15 -> 115
    //   103: aload_1
    //   104: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   107: ldc_w 1405
    //   110: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: iconst_0
    //   114: ireturn
    //   115: aload 4
    //   117: invokestatic 1413	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   120: istore_2
    //   121: aload_1
    //   122: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   125: ldc_w 1405
    //   128: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: iload_2
    //   132: ireturn
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_1
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   144: ldc_w 1405
    //   147: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_0
    //   151: ireturn
    //   152: astore_1
    //   153: aload 4
    //   155: ifnull +8 -> 163
    //   158: aload 4
    //   160: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   163: ldc_w 1405
    //   166: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0: ldc_w 1414
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 1414
    //   13: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_0
    //   17: ireturn
    //   18: aconst_null
    //   19: astore 4
    //   21: new 291	java/io/File
    //   24: dup
    //   25: new 291	java/io/File
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: ldc_w 386
    //   36: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 601	java/io/File:exists	()Z
    //   44: istore_3
    //   45: iload_3
    //   46: ifne +11 -> 57
    //   49: ldc_w 1414
    //   52: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_0
    //   56: ireturn
    //   57: new 388	java/util/Properties
    //   60: dup
    //   61: invokespecial 389	java/util/Properties:<init>	()V
    //   64: astore 5
    //   66: new 391	java/io/BufferedInputStream
    //   69: dup
    //   70: new 393	java/io/FileInputStream
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 396	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   78: invokespecial 399	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: astore_1
    //   82: aload 5
    //   84: aload_1
    //   85: invokevirtual 402	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   88: aload_1
    //   89: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   92: aload 5
    //   94: ldc_w 1409
    //   97: invokevirtual 1410	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 4
    //   102: aload 4
    //   104: ifnonnull +15 -> 119
    //   107: aload_1
    //   108: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   111: ldc_w 1414
    //   114: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: iconst_0
    //   118: ireturn
    //   119: aload 4
    //   121: invokestatic 1413	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   124: istore_2
    //   125: aload_1
    //   126: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   129: ldc_w 1414
    //   132: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: iload_2
    //   136: ireturn
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   148: ldc_w 1414
    //   151: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: iconst_0
    //   155: ireturn
    //   156: astore_1
    //   157: aload 4
    //   159: ifnull +8 -> 167
    //   162: aload 4
    //   164: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   167: ldc_w 1414
    //   170: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(219653);
    if ((paramBoolean) || (((Integer)a.get()).intValue() <= 0)) {
      a.set(Integer.valueOf(j(paramContext)));
    }
    int i1 = ((Integer)a.get()).intValue();
    AppMethodBeat.o(219653);
    return i1;
  }
  
  File a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(219783);
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
      AppMethodBeat.o(219783);
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
    AppMethodBeat.o(219783);
    return null;
    label212:
    AppMethodBeat.o(219783);
    return paramContext;
  }
  
  File a(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(219778);
    paramContext = new File(paramFile, "core_share_decouple");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(219778);
      return null;
    }
    AppMethodBeat.o(219778);
    return paramContext;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(219670);
    g(paramContext, true);
    n.a(paramContext).c(paramInt, 2);
    AppMethodBeat.o(219670);
  }
  
  void a(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(219683);
    if ((paramBundle == null) || (paramContext == null))
    {
      AppMethodBeat.o(219683);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = new Object[] { paramContext, paramBundle };
    m.sendMessage(localMessage);
    AppMethodBeat.o(219683);
  }
  
  void a(Context paramContext, File paramFile, int paramInt)
  {
    AppMethodBeat.i(219686);
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmp,ctx=" + paramContext + "File=" + paramFile + "coreVersion=" + paramInt);
    if ((paramFile == null) || (paramContext == null))
    {
      AppMethodBeat.o(219686);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 4;
    localMessage.obj = new Object[] { paramContext, paramFile, Integer.valueOf(paramInt) };
    m.sendMessage(localMessage);
    AppMethodBeat.o(219686);
  }
  
  void a(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(219664);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=".concat(String.valueOf(paramString)));
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=".concat(String.valueOf(paramInt)));
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramContext, paramString, Integer.valueOf(paramInt) };
    m.sendMessage(localMessage);
    AppMethodBeat.o(219664);
  }
  
  void a(Context paramContext, boolean paramBoolean)
  {
    int i5 = 0;
    AppMethodBeat.i(219657);
    if (paramBoolean) {}
    String str;
    int i4;
    int i3;
    int i1;
    int i2;
    try
    {
      this.k = true;
      TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
      TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + android.os.Process.myPid());
      TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
      paramBoolean = u(paramContext);
      if (!paramBoolean)
      {
        AppMethodBeat.o(219657);
        return;
      }
      str = null;
      paramBoolean = i.tryLock();
      if (!paramBoolean) {
        break label438;
      }
      i6 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_responsecode", 0);
    }
    finally
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
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          break label317;
        }
        c(paramContext, TbsShareManager.a(paramContext, false));
        AppMethodBeat.o(219657);
        return;
      }
      finally
      {
        i.unlock();
        AppMethodBeat.o(219657);
      }
      paramContext = finally;
      AppMethodBeat.o(219657);
      return;
    }
    label317:
    int i6;
    if ((i6 != 1) && (i6 != 2) && (i6 != 4)) {}
    for (;;)
    {
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
      AppMethodBeat.o(219657);
      return;
      label438:
      i1 = 0;
      i2 = -1;
      i3 = 0;
      i4 = -1;
      break;
      i5 = 1;
    }
  }
  
  /* Error */
  public boolean a(final Context paramContext1, final Context paramContext2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1510
    //   5: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 149
    //   10: ldc_w 1512
    //   13: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: getstatic 119	com/tencent/smtt/sdk/q:p	Z
    //   19: iconst_1
    //   20: if_icmpne +13 -> 33
    //   23: ldc_w 1510
    //   26: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iconst_1
    //   32: ireturn
    //   33: iconst_1
    //   34: putstatic 119	com/tencent/smtt/sdk/q:p	Z
    //   37: new 8	com/tencent/smtt/sdk/q$4
    //   40: dup
    //   41: aload_0
    //   42: aload_2
    //   43: aload_1
    //   44: invokespecial 1515	com/tencent/smtt/sdk/q$4:<init>	(Lcom/tencent/smtt/sdk/q;Landroid/content/Context;Landroid/content/Context;)V
    //   47: invokevirtual 1518	com/tencent/smtt/sdk/q$4:start	()V
    //   50: ldc_w 1510
    //   53: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(219704);
    try
    {
      if (paramContext.getPackageName() != paramString)
      {
        boolean bool = TbsPVConfig.getInstance(paramContext).isEnableNoCoreGray();
        if (bool)
        {
          AppMethodBeat.o(219704);
          return null;
        }
      }
      paramContext = paramContext.createPackageContext(paramString, 2);
      AppMethodBeat.o(219704);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(219704);
    }
    return null;
  }
  
  File b(Context paramContext1, Context paramContext2)
  {
    AppMethodBeat.i(219773);
    paramContext1 = TbsOneGreyInfoHelper.getCoreDir(paramContext1);
    AppMethodBeat.o(219773);
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
      com.tencent.smtt.utils.f.a(this.f, this.g);
      this.e = 0;
      label180:
      AppMethodBeat.o(54372);
    }
  }
  
  /* Error */
  void b(Context paramContext, Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 1565
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 149
    //   8: new 231	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 1567
    //   15: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: invokestatic 859	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   21: invokevirtual 860	java/lang/Thread:getName	()Ljava/lang/String;
    //   24: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: new 442	java/lang/Throwable
    //   30: dup
    //   31: invokespecial 1546	java/lang/Throwable:<init>	()V
    //   34: invokestatic 734	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   37: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 472	com/tencent/smtt/sdk/q:d	(Landroid/content/Context;)Z
    //   51: ifeq +20 -> 71
    //   54: aload_1
    //   55: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   58: sipush -539
    //   61: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   64: ldc_w 1565
    //   67: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: return
    //   71: ldc 149
    //   73: ldc_w 1569
    //   76: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_2
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: ifnonnull +10 -> 94
    //   87: ldc_w 1565
    //   90: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: return
    //   94: aload_1
    //   95: invokestatic 543	com/tencent/smtt/utils/f:b	(Landroid/content/Context;)Z
    //   98: ifne +73 -> 171
    //   101: invokestatic 548	com/tencent/smtt/utils/r:a	()J
    //   104: lstore 9
    //   106: aload_1
    //   107: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   110: invokevirtual 551	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   113: lstore 7
    //   115: aload_1
    //   116: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   119: sipush 210
    //   122: new 231	java/lang/StringBuilder
    //   125: dup
    //   126: ldc_w 1571
    //   129: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: lload 9
    //   134: invokevirtual 556	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: ldc_w 558
    //   140: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: lload 7
    //   145: invokevirtual 556	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   148: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   154: aload_1
    //   155: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   158: sipush -540
    //   161: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   164: ldc_w 1565
    //   167: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: aload_0
    //   172: aload_1
    //   173: invokevirtual 497	com/tencent/smtt/sdk/q:u	(Landroid/content/Context;)Z
    //   176: ifne +20 -> 196
    //   179: aload_1
    //   180: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   183: sipush -541
    //   186: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   189: ldc_w 1565
    //   192: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: return
    //   196: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   199: invokeinterface 502 1 0
    //   204: istore 11
    //   206: ldc 149
    //   208: ldc_w 1573
    //   211: iload 11
    //   213: invokestatic 302	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   216: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   219: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: iload 11
    //   224: ifeq +2197 -> 2421
    //   227: aload_1
    //   228: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   231: getfield 198	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   234: ldc_w 962
    //   237: iconst_0
    //   238: invokeinterface 206 3 0
    //   243: istore 5
    //   245: aconst_null
    //   246: astore 17
    //   248: aconst_null
    //   249: astore 18
    //   251: aconst_null
    //   252: astore 15
    //   254: aconst_null
    //   255: astore 16
    //   257: aconst_null
    //   258: astore 12
    //   260: aload 15
    //   262: astore 13
    //   264: aload 16
    //   266: astore 14
    //   268: iconst_1
    //   269: invokestatic 1293	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   272: iload 5
    //   274: iconst_5
    //   275: if_icmpeq +9 -> 284
    //   278: iload 5
    //   280: iconst_3
    //   281: if_icmpne +651 -> 932
    //   284: aload 15
    //   286: astore 13
    //   288: aload 16
    //   290: astore 14
    //   292: aload_0
    //   293: aload_1
    //   294: aload_2
    //   295: invokespecial 1575	com/tencent/smtt/sdk/q:c	(Landroid/content/Context;Landroid/os/Bundle;)I
    //   298: istore_3
    //   299: aload 17
    //   301: astore 13
    //   303: iload_3
    //   304: istore 4
    //   306: ldc 149
    //   308: ldc_w 1577
    //   311: iload_3
    //   312: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   315: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   318: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: iload_3
    //   322: iconst_1
    //   323: if_icmpne +119 -> 442
    //   326: aload 17
    //   328: astore 13
    //   330: iload_3
    //   331: istore 4
    //   333: aload_1
    //   334: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   337: ldc 182
    //   339: invokevirtual 512	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   342: istore 6
    //   344: aload 17
    //   346: astore 13
    //   348: iload_3
    //   349: istore 4
    //   351: aload_1
    //   352: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   355: ldc 182
    //   357: iload 6
    //   359: iconst_1
    //   360: iadd
    //   361: invokevirtual 185	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   364: aload 17
    //   366: astore 13
    //   368: iload_3
    //   369: istore 4
    //   371: aload_2
    //   372: ldc_w 1579
    //   375: invokevirtual 1038	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   378: astore_2
    //   379: aload 17
    //   381: astore 13
    //   383: iload_3
    //   384: istore 4
    //   386: aload_2
    //   387: ldc_w 1581
    //   390: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   393: ifeq +212 -> 605
    //   396: aload 17
    //   398: astore 13
    //   400: iload_3
    //   401: istore 4
    //   403: invokestatic 1585	com/tencent/smtt/utils/b:b	()Z
    //   406: ifeq +67 -> 473
    //   409: aload 17
    //   411: astore 13
    //   413: iload_3
    //   414: istore 4
    //   416: aload_1
    //   417: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   420: ldc_w 1587
    //   423: iconst_1
    //   424: invokevirtual 185	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   427: aload 17
    //   429: astore 13
    //   431: iload_3
    //   432: istore 4
    //   434: ldc 149
    //   436: ldc_w 1589
    //   439: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   445: invokeinterface 528 1 0
    //   450: aload_0
    //   451: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   454: iload 5
    //   456: iconst_5
    //   457: if_icmpne +293 -> 750
    //   460: aload_0
    //   461: aload_1
    //   462: iload_3
    //   463: invokespecial 1591	com/tencent/smtt/sdk/q:h	(Landroid/content/Context;I)V
    //   466: ldc_w 1565
    //   469: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   472: return
    //   473: aload 17
    //   475: astore 13
    //   477: iload_3
    //   478: istore 4
    //   480: aload_1
    //   481: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   484: ldc_w 1593
    //   487: iconst_1
    //   488: invokevirtual 185	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   491: aload 17
    //   493: astore 13
    //   495: iload_3
    //   496: istore 4
    //   498: ldc 149
    //   500: ldc_w 1595
    //   503: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   506: goto -64 -> 442
    //   509: astore_2
    //   510: aload 12
    //   512: astore 13
    //   514: iload_3
    //   515: istore 4
    //   517: ldc 149
    //   519: new 231	java/lang/StringBuilder
    //   522: dup
    //   523: ldc_w 1597
    //   526: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   529: aload_2
    //   530: invokestatic 734	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   533: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   542: aload 12
    //   544: astore 13
    //   546: aload_1
    //   547: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   550: sipush -543
    //   553: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   556: aload 12
    //   558: astore 13
    //   560: aload_1
    //   561: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   564: sipush 218
    //   567: aload_2
    //   568: invokevirtual 259	java/lang/Exception:toString	()Ljava/lang/String;
    //   571: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   574: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   577: invokeinterface 528 1 0
    //   582: aload_0
    //   583: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   586: iload 5
    //   588: iconst_5
    //   589: if_icmpne +1416 -> 2005
    //   592: aload_0
    //   593: aload_1
    //   594: iconst_1
    //   595: invokespecial 1591	com/tencent/smtt/sdk/q:h	(Landroid/content/Context;I)V
    //   598: ldc_w 1565
    //   601: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   604: return
    //   605: aload 17
    //   607: astore 13
    //   609: iload_3
    //   610: istore 4
    //   612: aload_2
    //   613: ldc_w 1599
    //   616: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   619: ifeq +78 -> 697
    //   622: aload 17
    //   624: astore 13
    //   626: iload_3
    //   627: istore 4
    //   629: aload_1
    //   630: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   633: ldc_w 1593
    //   636: iconst_1
    //   637: invokevirtual 185	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   640: aload 17
    //   642: astore 13
    //   644: iload_3
    //   645: istore 4
    //   647: ldc 149
    //   649: ldc_w 1595
    //   652: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   655: goto -213 -> 442
    //   658: astore_2
    //   659: iload 4
    //   661: istore_3
    //   662: aload 13
    //   664: astore 12
    //   666: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   669: invokeinterface 528 1 0
    //   674: aload_0
    //   675: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   678: iload 5
    //   680: iconst_5
    //   681: if_icmpne +1415 -> 2096
    //   684: aload_0
    //   685: aload_1
    //   686: iload_3
    //   687: invokespecial 1591	com/tencent/smtt/sdk/q:h	(Landroid/content/Context;I)V
    //   690: ldc_w 1565
    //   693: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   696: return
    //   697: aload 17
    //   699: astore 13
    //   701: iload_3
    //   702: istore 4
    //   704: aload_2
    //   705: ldc_w 1601
    //   708: invokevirtual 328	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   711: ifeq -269 -> 442
    //   714: aload 17
    //   716: astore 13
    //   718: iload_3
    //   719: istore 4
    //   721: aload_1
    //   722: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   725: ldc_w 1587
    //   728: iconst_1
    //   729: invokevirtual 185	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   732: aload 17
    //   734: astore 13
    //   736: iload_3
    //   737: istore 4
    //   739: ldc 149
    //   741: ldc_w 1589
    //   744: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: goto -305 -> 442
    //   750: iload_3
    //   751: ifne +68 -> 819
    //   754: ldc 149
    //   756: ldc_w 1603
    //   759: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   762: aload_1
    //   763: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   766: ldc_w 1379
    //   769: iconst_0
    //   770: invokevirtual 185	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   773: aload_1
    //   774: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   777: sipush -544
    //   780: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   783: aload_1
    //   784: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   787: iconst_0
    //   788: iconst_m1
    //   789: invokevirtual 346	com/tencent/smtt/sdk/n:c	(II)V
    //   792: aload_1
    //   793: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   796: iconst_1
    //   797: invokevirtual 348	com/tencent/smtt/sdk/n:c	(I)V
    //   800: new 1605	java/lang/NullPointerException
    //   803: dup
    //   804: invokespecial 1606	java/lang/NullPointerException:<init>	()V
    //   807: athrow
    //   808: iconst_0
    //   809: invokestatic 1293	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   812: ldc_w 1565
    //   815: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   818: return
    //   819: iload_3
    //   820: iconst_2
    //   821: if_icmpne +14 -> 835
    //   824: ldc 149
    //   826: ldc_w 1608
    //   829: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   832: goto -24 -> 808
    //   835: aload_1
    //   836: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   839: sipush -546
    //   842: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   845: ldc 149
    //   847: ldc_w 1610
    //   850: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   853: aload_1
    //   854: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   857: getfield 935	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   860: ldc_w 937
    //   863: getstatic 943	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   866: invokeinterface 949 3 0
    //   871: pop
    //   872: aload_1
    //   873: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   876: invokevirtual 953	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   879: aload_1
    //   880: invokestatic 562	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   883: ifeq +26 -> 909
    //   886: aload_1
    //   887: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   890: sipush 235
    //   893: ldc_w 1612
    //   896: iload_3
    //   897: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   900: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   903: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   906: goto -98 -> 808
    //   909: aload_1
    //   910: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   913: sipush 217
    //   916: ldc_w 1614
    //   919: iload_3
    //   920: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   923: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   926: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   929: goto -121 -> 808
    //   932: aload 15
    //   934: astore 13
    //   936: aload 16
    //   938: astore 14
    //   940: aload_0
    //   941: aload_1
    //   942: invokevirtual 214	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;)I
    //   945: ifle +22 -> 967
    //   948: aload 15
    //   950: astore 13
    //   952: aload 16
    //   954: astore 14
    //   956: aload_1
    //   957: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   960: invokevirtual 1337	com/tencent/smtt/sdk/n:d	()I
    //   963: iconst_1
    //   964: if_icmpne +65 -> 1029
    //   967: aload 15
    //   969: astore 13
    //   971: aload 16
    //   973: astore 14
    //   975: iconst_0
    //   976: invokestatic 1293	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   979: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   982: invokeinterface 528 1 0
    //   987: aload_0
    //   988: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   991: iload 5
    //   993: iconst_5
    //   994: if_icmpne +16 -> 1010
    //   997: aload_0
    //   998: aload_1
    //   999: iconst_2
    //   1000: invokespecial 1591	com/tencent/smtt/sdk/q:h	(Landroid/content/Context;I)V
    //   1003: ldc_w 1565
    //   1006: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1009: return
    //   1010: ldc 149
    //   1012: ldc_w 1608
    //   1015: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1018: iconst_0
    //   1019: invokestatic 1293	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1022: ldc_w 1565
    //   1025: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1028: return
    //   1029: iload 5
    //   1031: iconst_1
    //   1032: if_icmpeq +15 -> 1047
    //   1035: iload 5
    //   1037: iconst_2
    //   1038: if_icmpeq +9 -> 1047
    //   1041: iload 5
    //   1043: iconst_4
    //   1044: if_icmpne +304 -> 1348
    //   1047: iconst_1
    //   1048: istore_3
    //   1049: iload_3
    //   1050: ifne +1432 -> 2482
    //   1053: iload 5
    //   1055: ifeq +1427 -> 2482
    //   1058: aload 15
    //   1060: astore 13
    //   1062: aload 16
    //   1064: astore 14
    //   1066: aload_1
    //   1067: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1070: ldc_w 1379
    //   1073: invokevirtual 512	com/tencent/smtt/sdk/n:c	(Ljava/lang/String;)I
    //   1076: istore_3
    //   1077: iload_3
    //   1078: iconst_5
    //   1079: if_icmple +293 -> 1372
    //   1082: aload 15
    //   1084: astore 13
    //   1086: aload 16
    //   1088: astore 14
    //   1090: ldc 149
    //   1092: ldc_w 1616
    //   1095: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1098: aload 15
    //   1100: astore 13
    //   1102: aload 16
    //   1104: astore 14
    //   1106: aload_2
    //   1107: ldc_w 1618
    //   1110: invokevirtual 1038	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1113: astore 12
    //   1115: aload 15
    //   1117: astore 13
    //   1119: aload 16
    //   1121: astore 14
    //   1123: aload_2
    //   1124: ldc_w 1035
    //   1127: invokevirtual 1038	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1130: astore 17
    //   1132: aload 15
    //   1134: astore 13
    //   1136: aload 16
    //   1138: astore 14
    //   1140: aload_2
    //   1141: ldc_w 1620
    //   1144: invokevirtual 1038	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1147: astore_2
    //   1148: aload 15
    //   1150: astore 13
    //   1152: aload 16
    //   1154: astore 14
    //   1156: aload 12
    //   1158: invokestatic 1113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1161: ifne +23 -> 1184
    //   1164: aload 15
    //   1166: astore 13
    //   1168: aload 16
    //   1170: astore 14
    //   1172: new 291	java/io/File
    //   1175: dup
    //   1176: aload 12
    //   1178: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   1181: invokestatic 774	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   1184: aload 15
    //   1186: astore 13
    //   1188: aload 16
    //   1190: astore 14
    //   1192: aload 17
    //   1194: invokestatic 1113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1197: ifne +23 -> 1220
    //   1200: aload 15
    //   1202: astore 13
    //   1204: aload 16
    //   1206: astore 14
    //   1208: new 291	java/io/File
    //   1211: dup
    //   1212: aload 17
    //   1214: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   1217: invokestatic 774	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   1220: aload 15
    //   1222: astore 13
    //   1224: aload 16
    //   1226: astore 14
    //   1228: aload_2
    //   1229: invokestatic 1113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1232: ifne +22 -> 1254
    //   1235: aload 15
    //   1237: astore 13
    //   1239: aload 16
    //   1241: astore 14
    //   1243: new 291	java/io/File
    //   1246: dup
    //   1247: aload_2
    //   1248: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   1251: invokestatic 774	com/tencent/smtt/utils/f:b	(Ljava/io/File;)V
    //   1254: aload 15
    //   1256: astore 13
    //   1258: aload 16
    //   1260: astore 14
    //   1262: aload_1
    //   1263: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1266: getfield 935	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1269: ldc_w 937
    //   1272: getstatic 943	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1275: invokeinterface 949 3 0
    //   1280: pop
    //   1281: aload 15
    //   1283: astore 13
    //   1285: aload 16
    //   1287: astore 14
    //   1289: aload_1
    //   1290: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1293: invokevirtual 953	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1296: aload 15
    //   1298: astore 13
    //   1300: aload 16
    //   1302: astore 14
    //   1304: aload_1
    //   1305: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1308: sipush 224
    //   1311: ldc_w 1622
    //   1314: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1317: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1320: invokeinterface 528 1 0
    //   1325: aload_0
    //   1326: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   1329: iload 5
    //   1331: iconst_5
    //   1332: if_icmpne +21 -> 1353
    //   1335: aload_0
    //   1336: aload_1
    //   1337: iconst_2
    //   1338: invokespecial 1591	com/tencent/smtt/sdk/q:h	(Landroid/content/Context;I)V
    //   1341: ldc_w 1565
    //   1344: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1347: return
    //   1348: iconst_0
    //   1349: istore_3
    //   1350: goto -301 -> 1049
    //   1353: ldc 149
    //   1355: ldc_w 1608
    //   1358: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1361: iconst_0
    //   1362: invokestatic 1293	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1365: ldc_w 1565
    //   1368: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1371: return
    //   1372: aload 15
    //   1374: astore 13
    //   1376: aload 16
    //   1378: astore 14
    //   1380: aload_1
    //   1381: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1384: ldc_w 1379
    //   1387: iload_3
    //   1388: iconst_1
    //   1389: iadd
    //   1390: invokevirtual 185	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   1393: aload 15
    //   1395: astore 13
    //   1397: aload 16
    //   1399: astore 14
    //   1401: aload_1
    //   1402: invokestatic 793	com/tencent/smtt/sdk/q:t	(Landroid/content/Context;)Ljava/io/File;
    //   1405: astore 12
    //   1407: aload 12
    //   1409: ifnull +1073 -> 2482
    //   1412: aload 15
    //   1414: astore 13
    //   1416: aload 16
    //   1418: astore 14
    //   1420: new 291	java/io/File
    //   1423: dup
    //   1424: aload 12
    //   1426: ldc_w 795
    //   1429: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1432: astore 12
    //   1434: aload 15
    //   1436: astore 13
    //   1438: aload 16
    //   1440: astore 14
    //   1442: aload 12
    //   1444: invokevirtual 601	java/io/File:exists	()Z
    //   1447: ifeq +1035 -> 2482
    //   1450: aload 15
    //   1452: astore 13
    //   1454: aload 16
    //   1456: astore 14
    //   1458: aload 12
    //   1460: invokevirtual 384	java/io/File:canRead	()Z
    //   1463: ifeq +1019 -> 2482
    //   1466: aload 15
    //   1468: astore 13
    //   1470: aload 16
    //   1472: astore 14
    //   1474: invokestatic 209	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1477: aload_1
    //   1478: iconst_0
    //   1479: invokespecial 333	com/tencent/smtt/sdk/q:g	(Landroid/content/Context;Z)V
    //   1482: aload 15
    //   1484: astore 13
    //   1486: aload 16
    //   1488: astore 14
    //   1490: aload_1
    //   1491: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1494: sipush -550
    //   1497: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1500: aload 15
    //   1502: astore 13
    //   1504: aload 16
    //   1506: astore 14
    //   1508: aload_1
    //   1509: aload_2
    //   1510: invokestatic 1027	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   1513: astore 12
    //   1515: aload 12
    //   1517: ifnonnull +79 -> 1596
    //   1520: aload 12
    //   1522: astore 13
    //   1524: aload_1
    //   1525: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1528: sipush 228
    //   1531: new 231	java/lang/StringBuilder
    //   1534: dup
    //   1535: ldc_w 1624
    //   1538: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1541: aload_2
    //   1542: ldc_w 1040
    //   1545: invokevirtual 1033	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1548: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1551: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1554: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1557: iconst_1
    //   1558: istore 4
    //   1560: aload 12
    //   1562: astore 13
    //   1564: getstatic 63	com/tencent/smtt/sdk/q:j	Ljava/util/concurrent/locks/Lock;
    //   1567: invokeinterface 528 1 0
    //   1572: aload_0
    //   1573: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   1576: iload 5
    //   1578: iconst_5
    //   1579: if_icmpne +102 -> 1681
    //   1582: aload_0
    //   1583: aload_1
    //   1584: iload 4
    //   1586: invokespecial 1591	com/tencent/smtt/sdk/q:h	(Landroid/content/Context;I)V
    //   1589: ldc_w 1565
    //   1592: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1595: return
    //   1596: aload 12
    //   1598: astore 13
    //   1600: aload 12
    //   1602: astore 14
    //   1604: aload 12
    //   1606: ldc_w 1031
    //   1609: invokevirtual 1033	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1612: istore_3
    //   1613: iload_3
    //   1614: istore 4
    //   1616: aload 12
    //   1618: astore 13
    //   1620: iload_3
    //   1621: ifeq -57 -> 1564
    //   1624: aload_1
    //   1625: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1628: sipush 228
    //   1631: new 231	java/lang/StringBuilder
    //   1634: dup
    //   1635: ldc_w 1626
    //   1638: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1641: iload_3
    //   1642: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1645: ldc_w 1628
    //   1648: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: aload_2
    //   1652: ldc_w 1040
    //   1655: invokevirtual 1033	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1658: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1661: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1664: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1667: iload_3
    //   1668: istore 4
    //   1670: aload 12
    //   1672: astore 13
    //   1674: goto -110 -> 1564
    //   1677: astore_2
    //   1678: goto -1168 -> 510
    //   1681: iload 4
    //   1683: ifne +206 -> 1889
    //   1686: ldc 149
    //   1688: ldc_w 1603
    //   1691: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1694: aload_1
    //   1695: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1698: ldc_w 1379
    //   1701: iconst_0
    //   1702: invokevirtual 185	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   1705: aload_1
    //   1706: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1709: sipush -544
    //   1712: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1715: aload_1
    //   1716: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1719: iconst_0
    //   1720: iconst_m1
    //   1721: invokevirtual 346	com/tencent/smtt/sdk/n:c	(II)V
    //   1724: aload_1
    //   1725: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1728: iconst_1
    //   1729: invokevirtual 348	com/tencent/smtt/sdk/n:c	(I)V
    //   1732: aload 13
    //   1734: ldc_w 1630
    //   1737: invokevirtual 1038	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1740: astore_2
    //   1741: aload_1
    //   1742: invokestatic 667	com/tencent/smtt/utils/r:c	(Landroid/content/Context;)Z
    //   1745: ifeq +129 -> 1874
    //   1748: aload_1
    //   1749: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1752: getfield 198	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1755: ldc 200
    //   1757: iconst_0
    //   1758: invokeinterface 206 3 0
    //   1763: istore 4
    //   1765: aload 13
    //   1767: ldc_w 1632
    //   1770: invokevirtual 1033	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1773: istore_3
    //   1774: ldc 149
    //   1776: new 231	java/lang/StringBuilder
    //   1779: dup
    //   1780: ldc_w 1634
    //   1783: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1786: iload_3
    //   1787: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1790: ldc_w 1636
    //   1793: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1796: iload 4
    //   1798: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1801: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1804: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1807: iload_3
    //   1808: iload 4
    //   1810: if_icmpne +24 -> 1834
    //   1813: ldc_w 1638
    //   1816: ldc_w 1640
    //   1819: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1822: new 291	java/io/File
    //   1825: dup
    //   1826: aload_2
    //   1827: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   1830: aload_1
    //   1831: invokestatic 683	com/tencent/smtt/sdk/m:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1834: aload_0
    //   1835: aload_1
    //   1836: aload_2
    //   1837: aload 13
    //   1839: ldc_w 1632
    //   1842: invokevirtual 1033	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1845: invokespecial 763	com/tencent/smtt/sdk/q:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1848: aload_1
    //   1849: invokestatic 562	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1852: ifeq +11 -> 1863
    //   1855: aload_1
    //   1856: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   1859: iconst_m1
    //   1860: invokevirtual 348	com/tencent/smtt/sdk/n:c	(I)V
    //   1863: iconst_0
    //   1864: invokestatic 1293	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1867: ldc_w 1565
    //   1870: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1873: return
    //   1874: new 291	java/io/File
    //   1877: dup
    //   1878: aload_2
    //   1879: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   1882: aload_1
    //   1883: invokestatic 683	com/tencent/smtt/sdk/m:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1886: goto -52 -> 1834
    //   1889: iload 4
    //   1891: iconst_2
    //   1892: if_icmpne +14 -> 1906
    //   1895: ldc 149
    //   1897: ldc_w 1608
    //   1900: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1903: goto -40 -> 1863
    //   1906: aload_1
    //   1907: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1910: sipush -546
    //   1913: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1916: ldc 149
    //   1918: ldc_w 1610
    //   1921: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1924: aload_1
    //   1925: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1928: getfield 935	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1931: ldc_w 937
    //   1934: getstatic 943	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1937: invokeinterface 949 3 0
    //   1942: pop
    //   1943: aload_1
    //   1944: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1947: invokevirtual 953	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1950: aload_1
    //   1951: invokestatic 562	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1954: ifeq +27 -> 1981
    //   1957: aload_1
    //   1958: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1961: sipush 235
    //   1964: ldc_w 1612
    //   1967: iload 4
    //   1969: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1972: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1975: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1978: goto -115 -> 1863
    //   1981: aload_1
    //   1982: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1985: sipush 217
    //   1988: ldc_w 1614
    //   1991: iload 4
    //   1993: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1996: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1999: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2002: goto -139 -> 1863
    //   2005: aload_1
    //   2006: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2009: sipush -546
    //   2012: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2015: ldc 149
    //   2017: ldc_w 1610
    //   2020: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2023: aload_1
    //   2024: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2027: getfield 935	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2030: ldc_w 937
    //   2033: getstatic 943	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2036: invokeinterface 949 3 0
    //   2041: pop
    //   2042: aload_1
    //   2043: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2046: invokevirtual 953	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2049: aload_1
    //   2050: invokestatic 562	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   2053: ifeq +27 -> 2080
    //   2056: aload_1
    //   2057: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2060: sipush 235
    //   2063: ldc_w 1642
    //   2066: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2069: iconst_0
    //   2070: invokestatic 1293	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   2073: ldc_w 1565
    //   2076: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2079: return
    //   2080: aload_1
    //   2081: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2084: sipush 217
    //   2087: ldc_w 1644
    //   2090: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2093: goto -24 -> 2069
    //   2096: iload_3
    //   2097: ifne +211 -> 2308
    //   2100: ldc 149
    //   2102: ldc_w 1603
    //   2105: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2108: aload_1
    //   2109: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   2112: ldc_w 1379
    //   2115: iconst_0
    //   2116: invokevirtual 185	com/tencent/smtt/sdk/n:a	(Ljava/lang/String;I)V
    //   2119: aload_1
    //   2120: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2123: sipush -544
    //   2126: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2129: aload_1
    //   2130: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   2133: iconst_0
    //   2134: iconst_m1
    //   2135: invokevirtual 346	com/tencent/smtt/sdk/n:c	(II)V
    //   2138: aload_1
    //   2139: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   2142: iconst_1
    //   2143: invokevirtual 348	com/tencent/smtt/sdk/n:c	(I)V
    //   2146: aload 12
    //   2148: ldc_w 1630
    //   2151: invokevirtual 1038	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2154: astore 13
    //   2156: aload_1
    //   2157: invokestatic 667	com/tencent/smtt/utils/r:c	(Landroid/content/Context;)Z
    //   2160: ifeq +132 -> 2292
    //   2163: aload_1
    //   2164: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2167: getfield 198	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2170: ldc 200
    //   2172: iconst_0
    //   2173: invokeinterface 206 3 0
    //   2178: istore_3
    //   2179: aload 12
    //   2181: ldc_w 1632
    //   2184: invokevirtual 1033	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2187: istore 4
    //   2189: ldc 149
    //   2191: new 231	java/lang/StringBuilder
    //   2194: dup
    //   2195: ldc_w 1634
    //   2198: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2201: iload 4
    //   2203: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2206: ldc_w 1636
    //   2209: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2212: iload_3
    //   2213: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2216: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2219: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2222: iload 4
    //   2224: iload_3
    //   2225: if_icmpne +25 -> 2250
    //   2228: ldc_w 1638
    //   2231: ldc_w 1640
    //   2234: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2237: new 291	java/io/File
    //   2240: dup
    //   2241: aload 13
    //   2243: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   2246: aload_1
    //   2247: invokestatic 683	com/tencent/smtt/sdk/m:a	(Ljava/io/File;Landroid/content/Context;)V
    //   2250: aload_0
    //   2251: aload_1
    //   2252: aload 13
    //   2254: aload 12
    //   2256: ldc_w 1632
    //   2259: invokevirtual 1033	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2262: invokespecial 763	com/tencent/smtt/sdk/q:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   2265: aload_1
    //   2266: invokestatic 562	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   2269: ifeq +11 -> 2280
    //   2272: aload_1
    //   2273: invokestatic 177	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/n;
    //   2276: iconst_m1
    //   2277: invokevirtual 348	com/tencent/smtt/sdk/n:c	(I)V
    //   2280: iconst_0
    //   2281: invokestatic 1293	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   2284: ldc_w 1565
    //   2287: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2290: aload_2
    //   2291: athrow
    //   2292: new 291	java/io/File
    //   2295: dup
    //   2296: aload 13
    //   2298: invokespecial 362	java/io/File:<init>	(Ljava/lang/String;)V
    //   2301: aload_1
    //   2302: invokestatic 683	com/tencent/smtt/sdk/m:a	(Ljava/io/File;Landroid/content/Context;)V
    //   2305: goto -55 -> 2250
    //   2308: iload_3
    //   2309: iconst_2
    //   2310: if_icmpne +14 -> 2324
    //   2313: ldc 149
    //   2315: ldc_w 1608
    //   2318: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2321: goto -41 -> 2280
    //   2324: aload_1
    //   2325: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2328: sipush -546
    //   2331: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2334: ldc 149
    //   2336: ldc_w 1610
    //   2339: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2342: aload_1
    //   2343: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2346: getfield 935	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2349: ldc_w 937
    //   2352: getstatic 943	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2355: invokeinterface 949 3 0
    //   2360: pop
    //   2361: aload_1
    //   2362: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2365: invokevirtual 953	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2368: aload_1
    //   2369: invokestatic 562	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   2372: ifeq +26 -> 2398
    //   2375: aload_1
    //   2376: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2379: sipush 235
    //   2382: ldc_w 1612
    //   2385: iload_3
    //   2386: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2389: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2392: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2395: goto -115 -> 2280
    //   2398: aload_1
    //   2399: invokestatic 256	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2402: sipush 217
    //   2405: ldc_w 1614
    //   2408: iload_3
    //   2409: invokestatic 477	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2412: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2415: invokevirtual 263	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2418: goto -138 -> 2280
    //   2421: aload_1
    //   2422: invokestatic 194	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2425: sipush -547
    //   2428: invokevirtual 470	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2431: aload_0
    //   2432: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   2435: ldc_w 1565
    //   2438: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2441: return
    //   2442: astore_2
    //   2443: iconst_2
    //   2444: istore_3
    //   2445: aload 13
    //   2447: astore 12
    //   2449: goto -1783 -> 666
    //   2452: astore_2
    //   2453: iconst_1
    //   2454: istore_3
    //   2455: aload 13
    //   2457: astore 12
    //   2459: goto -1793 -> 666
    //   2462: astore_2
    //   2463: goto -1797 -> 666
    //   2466: astore_2
    //   2467: iconst_2
    //   2468: istore_3
    //   2469: aload 14
    //   2471: astore 12
    //   2473: goto -1963 -> 510
    //   2476: astore_2
    //   2477: iconst_1
    //   2478: istore_3
    //   2479: goto -1969 -> 510
    //   2482: iconst_2
    //   2483: istore 4
    //   2485: aload 18
    //   2487: astore 13
    //   2489: goto -925 -> 1564
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2492	0	this	q
    //   0	2492	1	paramContext	Context
    //   0	2492	2	paramBundle	Bundle
    //   298	2181	3	i1	int
    //   304	2180	4	i2	int
    //   243	1337	5	i3	int
    //   342	19	6	i4	int
    //   113	31	7	l1	long
    //   104	29	9	l2	long
    //   204	19	11	bool	boolean
    //   258	2214	12	localObject1	Object
    //   262	2226	13	localObject2	Object
    //   266	2204	14	localObject3	Object
    //   252	1249	15	localObject4	Object
    //   255	1250	16	localObject5	Object
    //   246	967	17	str	String
    //   249	2237	18	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   306	321	509	java/lang/Exception
    //   333	344	509	java/lang/Exception
    //   351	364	509	java/lang/Exception
    //   371	379	509	java/lang/Exception
    //   386	396	509	java/lang/Exception
    //   403	409	509	java/lang/Exception
    //   416	427	509	java/lang/Exception
    //   434	442	509	java/lang/Exception
    //   480	491	509	java/lang/Exception
    //   498	506	509	java/lang/Exception
    //   612	622	509	java/lang/Exception
    //   629	640	509	java/lang/Exception
    //   647	655	509	java/lang/Exception
    //   704	714	509	java/lang/Exception
    //   721	732	509	java/lang/Exception
    //   739	747	509	java/lang/Exception
    //   306	321	658	finally
    //   333	344	658	finally
    //   351	364	658	finally
    //   371	379	658	finally
    //   386	396	658	finally
    //   403	409	658	finally
    //   416	427	658	finally
    //   434	442	658	finally
    //   480	491	658	finally
    //   498	506	658	finally
    //   517	542	658	finally
    //   612	622	658	finally
    //   629	640	658	finally
    //   647	655	658	finally
    //   704	714	658	finally
    //   721	732	658	finally
    //   739	747	658	finally
    //   1624	1667	1677	java/lang/Exception
    //   268	272	2442	finally
    //   292	299	2442	finally
    //   940	948	2442	finally
    //   956	967	2442	finally
    //   975	979	2442	finally
    //   1066	1077	2442	finally
    //   1090	1098	2442	finally
    //   1106	1115	2442	finally
    //   1123	1132	2442	finally
    //   1140	1148	2442	finally
    //   1156	1164	2442	finally
    //   1172	1184	2442	finally
    //   1192	1200	2442	finally
    //   1208	1220	2442	finally
    //   1228	1235	2442	finally
    //   1243	1254	2442	finally
    //   1262	1281	2442	finally
    //   1289	1296	2442	finally
    //   1304	1317	2442	finally
    //   1380	1393	2442	finally
    //   1401	1407	2442	finally
    //   1420	1434	2442	finally
    //   1442	1450	2442	finally
    //   1458	1466	2442	finally
    //   1474	1482	2442	finally
    //   1490	1500	2442	finally
    //   1508	1515	2442	finally
    //   1604	1613	2442	finally
    //   546	556	2452	finally
    //   560	574	2452	finally
    //   1524	1557	2452	finally
    //   1624	1667	2462	finally
    //   268	272	2466	java/lang/Exception
    //   292	299	2466	java/lang/Exception
    //   940	948	2466	java/lang/Exception
    //   956	967	2466	java/lang/Exception
    //   975	979	2466	java/lang/Exception
    //   1066	1077	2466	java/lang/Exception
    //   1090	1098	2466	java/lang/Exception
    //   1106	1115	2466	java/lang/Exception
    //   1123	1132	2466	java/lang/Exception
    //   1140	1148	2466	java/lang/Exception
    //   1156	1164	2466	java/lang/Exception
    //   1172	1184	2466	java/lang/Exception
    //   1192	1200	2466	java/lang/Exception
    //   1208	1220	2466	java/lang/Exception
    //   1228	1235	2466	java/lang/Exception
    //   1243	1254	2466	java/lang/Exception
    //   1262	1281	2466	java/lang/Exception
    //   1289	1296	2466	java/lang/Exception
    //   1304	1317	2466	java/lang/Exception
    //   1380	1393	2466	java/lang/Exception
    //   1401	1407	2466	java/lang/Exception
    //   1420	1434	2466	java/lang/Exception
    //   1442	1450	2466	java/lang/Exception
    //   1458	1466	2466	java/lang/Exception
    //   1474	1482	2466	java/lang/Exception
    //   1490	1500	2466	java/lang/Exception
    //   1508	1515	2466	java/lang/Exception
    //   1604	1613	2466	java/lang/Exception
    //   1524	1557	2476	java/lang/Exception
  }
  
  void b(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(219662);
    TbsLog.v("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.v("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded currentProcessId=" + android.os.Process.myPid());
    TbsLog.v("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded currentThreadName=" + Thread.currentThread().getName());
    if (QbSdk.b)
    {
      AppMethodBeat.o(219662);
      return;
    }
    if (Build.VERSION.SDK_INT < 8)
    {
      TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
      AppMethodBeat.o(219662);
      return;
    }
    TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #1 ");
    File localFile;
    if ((TbsShareManager.isThirdPartyApp(paramContext)) && (n.a(paramContext).b("remove_old_core") == 1) && (paramBoolean)) {
      localFile = a().r(paramContext);
    }
    try
    {
      com.tencent.smtt.utils.f.b(localFile);
      TbsLog.i("TbsInstaller", "thirdAPP success--> delete old core_share Directory");
      label175:
      n.a(paramContext).a("remove_old_core", 0);
      if (w(paramContext))
      {
        TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #2 ");
        if ((a(paramContext, "core_unzip_tmp")) && (e(paramContext, paramBoolean)))
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!", true);
          AppMethodBeat.o(219662);
          return;
        }
        if ((a(paramContext, "core_share_backup_tmp")) && (f(paramContext, paramBoolean)))
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!", true);
          AppMethodBeat.o(219662);
          return;
        }
        if ((a(paramContext, "core_copy_tmp")) && (d(paramContext, paramBoolean)))
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!", true);
          AppMethodBeat.o(219662);
          return;
        }
        if ((a(paramContext, "tpatch_tmp")) && (c(paramContext, paramBoolean)))
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch!!", true);
          AppMethodBeat.o(219662);
          return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
        AppMethodBeat.o(219662);
        return;
      }
      AppMethodBeat.o(219662);
      return;
    }
    finally
    {
      break label175;
    }
  }
  
  public boolean b(Context paramContext)
  {
    AppMethodBeat.i(219659);
    if (w(paramContext))
    {
      if ((a(paramContext, "core_unzip_tmp")) || (a(paramContext, "core_share_backup_tmp")) || (a(paramContext, "core_copy_tmp")) || (a(paramContext, "tpatch_tmp")))
      {
        AppMethodBeat.o(219659);
        return true;
      }
      AppMethodBeat.o(219659);
      return false;
    }
    AppMethodBeat.o(219659);
    return false;
  }
  
  boolean b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(219679);
    if (TbsDownloader.getOverSea(paramContext))
    {
      AppMethodBeat.o(219679);
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
      AppMethodBeat.o(219679);
      return true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
    AppMethodBeat.o(219679);
    return false;
  }
  
  public boolean b(Context paramContext, File paramFile, int paramInt)
  {
    AppMethodBeat.i(219706);
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
    boolean bool = a(paramContext, paramFile, false);
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is ".concat(String.valueOf(bool)));
    if (bool) {
      a().a(paramContext, paramInt);
    }
    AppMethodBeat.o(219706);
    return bool;
  }
  
  int c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(219728);
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramContext != null)
    {
      int i1 = paramContext.versionCode;
      AppMethodBeat.o(219728);
      return i1;
    }
    AppMethodBeat.o(219728);
    return 0;
  }
  
  File c(Context paramContext1, Context paramContext2)
  {
    AppMethodBeat.i(219777);
    paramContext2 = new File(QbSdk.getTbsFolderDir(paramContext2), "core_share_decouple");
    if ((!paramContext2.isDirectory()) && ((paramContext1 == null) || (!TbsShareManager.isThirdPartyApp(paramContext1))) && (!paramContext2.mkdir()))
    {
      AppMethodBeat.o(219777);
      return null;
    }
    AppMethodBeat.o(219777);
    return paramContext2;
  }
  
  public void c(Context paramContext)
  {
    AppMethodBeat.i(219667);
    g(paramContext, true);
    n.a(paramContext).c(i(paramContext), 2);
    AppMethodBeat.o(219667);
  }
  
  void c(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(219700);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
    if (paramInt <= 0)
    {
      AppMethodBeat.o(219700);
      return;
    }
    int i1 = j(paramContext);
    if (i1 == paramInt)
    {
      AppMethodBeat.o(219700);
      return;
    }
    Context localContext = TbsShareManager.e(paramContext);
    if ((localContext != null) || (TbsShareManager.getHostCorePathAppDefined() != null))
    {
      TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
      a(paramContext, localContext);
      AppMethodBeat.o(219700);
      return;
    }
    if (i1 <= 0)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
      QbSdk.a(paramContext, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
    }
    AppMethodBeat.o(219700);
  }
  
  public Context d(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(219724);
    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=".concat(String.valueOf(paramInt)));
    if (paramInt <= 0)
    {
      AppMethodBeat.o(219724);
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
      AppMethodBeat.o(219724);
      return localContext;
    }
    AppMethodBeat.o(219724);
    return null;
  }
  
  /* Error */
  public String d(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 1750
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 1113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 1750
    //   16: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: new 291	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 270	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   30: ldc_w 386
    //   33: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   36: astore_1
    //   37: aload_1
    //   38: invokevirtual 601	java/io/File:exists	()Z
    //   41: istore_3
    //   42: iload_3
    //   43: ifne +11 -> 54
    //   46: ldc_w 1750
    //   49: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aconst_null
    //   53: areturn
    //   54: new 388	java/util/Properties
    //   57: dup
    //   58: invokespecial 389	java/util/Properties:<init>	()V
    //   61: astore 4
    //   63: new 391	java/io/BufferedInputStream
    //   66: dup
    //   67: new 393	java/io/FileInputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 396	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   75: invokespecial 399	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   78: astore_1
    //   79: aload 4
    //   81: aload_1
    //   82: invokevirtual 402	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   85: aload_1
    //   86: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   89: aload 4
    //   91: aload_2
    //   92: invokevirtual 1410	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore_2
    //   96: aload_1
    //   97: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   100: ldc_w 1750
    //   103: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_2
    //   107: areturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +7 -> 119
    //   115: aload_1
    //   116: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   119: ldc_w 1750
    //   122: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   138: ldc_w 1750
    //   141: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 1751
    //   5: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 291	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 270	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   17: ldc_w 386
    //   20: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore 5
    //   25: aload 5
    //   27: invokevirtual 601	java/io/File:exists	()Z
    //   30: ifne +11 -> 41
    //   33: ldc_w 1751
    //   36: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: iconst_0
    //   40: ireturn
    //   41: new 388	java/util/Properties
    //   44: dup
    //   45: invokespecial 389	java/util/Properties:<init>	()V
    //   48: astore 6
    //   50: new 391	java/io/BufferedInputStream
    //   53: dup
    //   54: new 393	java/io/FileInputStream
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 396	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 399	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore_1
    //   67: aload 6
    //   69: aload_1
    //   70: invokevirtual 402	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload 6
    //   75: ldc_w 412
    //   78: ldc_w 1753
    //   81: invokevirtual 638	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   84: invokestatic 1756	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   87: invokevirtual 970	java/lang/Boolean:booleanValue	()Z
    //   90: istore 4
    //   92: iload 4
    //   94: ifeq +135 -> 229
    //   97: invokestatic 581	java/lang/System:currentTimeMillis	()J
    //   100: aload 5
    //   102: invokevirtual 1759	java/io/File:lastModified	()J
    //   105: lsub
    //   106: ldc2_w 1760
    //   109: lcmp
    //   110: ifle +61 -> 171
    //   113: iconst_1
    //   114: istore_3
    //   115: ldc 149
    //   117: new 231	java/lang/StringBuilder
    //   120: dup
    //   121: ldc_w 1763
    //   124: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: iload 4
    //   129: invokevirtual 800	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   132: ldc_w 1765
    //   135: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iload_3
    //   139: invokevirtual 800	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   142: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: iload_3
    //   149: ifne +27 -> 176
    //   152: iload 4
    //   154: iload_2
    //   155: iand
    //   156: istore 4
    //   158: aload_1
    //   159: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   162: ldc_w 1751
    //   165: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   194: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   197: iload_3
    //   198: istore 4
    //   200: goto -38 -> 162
    //   203: astore_1
    //   204: iload_3
    //   205: istore 4
    //   207: goto -45 -> 162
    //   210: astore_1
    //   211: goto -49 -> 162
    //   214: astore 5
    //   216: iconst_0
    //   217: istore_3
    //   218: goto -32 -> 186
    //   221: astore 5
    //   223: iload 4
    //   225: istore_3
    //   226: goto -40 -> 186
    //   229: iconst_0
    //   230: istore_3
    //   231: goto -116 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	q
    //   0	234	1	paramContext	Context
    //   1	177	2	bool1	boolean
    //   114	117	3	bool2	boolean
    //   90	134	4	bool3	boolean
    //   23	78	5	localFile	File
    //   214	1	5	localObject1	Object
    //   221	1	5	localObject2	Object
    //   48	26	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   50	67	181	finally
    //   193	197	203	java/io/IOException
    //   158	162	210	java/io/IOException
    //   67	92	214	finally
    //   97	113	221	finally
    //   115	148	221	finally
  }
  
  int e(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(219745);
    paramInt = a(f(paramContext, paramInt));
    AppMethodBeat.o(219745);
    return paramInt;
  }
  
  /* Error */
  public void e(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 1767
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 291	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 270	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   15: ldc_w 386
    //   18: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore_1
    //   22: new 388	java/util/Properties
    //   25: dup
    //   26: invokespecial 389	java/util/Properties:<init>	()V
    //   29: astore_3
    //   30: new 391	java/io/BufferedInputStream
    //   33: dup
    //   34: new 393	java/io/FileInputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 396	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 399	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_2
    //   46: aload_3
    //   47: aload_2
    //   48: invokevirtual 402	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   51: new 404	java/io/BufferedOutputStream
    //   54: dup
    //   55: new 406	java/io/FileOutputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 407	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 410	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   66: astore_1
    //   67: aload_3
    //   68: ldc_w 412
    //   71: ldc_w 1753
    //   74: invokevirtual 418	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   77: pop
    //   78: aload_3
    //   79: aload_1
    //   80: aconst_null
    //   81: invokevirtual 422	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   84: aload_1
    //   85: invokevirtual 427	java/io/BufferedOutputStream:close	()V
    //   88: aload_2
    //   89: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   92: ldc_w 1767
    //   95: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: return
    //   99: astore_1
    //   100: ldc_w 1767
    //   103: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: return
    //   107: astore_1
    //   108: ldc_w 1767
    //   111: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_2
    //   120: aload_1
    //   121: ifnull +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 427	java/io/BufferedOutputStream:close	()V
    //   128: aload_2
    //   129: ifnull +22 -> 151
    //   132: aload_2
    //   133: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   136: ldc_w 1767
    //   139: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: return
    //   143: astore_1
    //   144: ldc_w 1767
    //   147: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: ldc_w 1767
    //   154: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: return
    //   158: astore_1
    //   159: goto -71 -> 88
    //   162: astore_1
    //   163: goto -35 -> 128
    //   166: astore_1
    //   167: aconst_null
    //   168: astore_1
    //   169: goto -49 -> 120
    //   172: astore_3
    //   173: goto -53 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	q
    //   0	176	1	paramContext	Context
    //   45	88	2	localBufferedInputStream	java.io.BufferedInputStream
    //   29	50	3	localProperties	java.util.Properties
    //   172	1	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   88	92	99	java/io/IOException
    //   6	30	107	finally
    //   84	88	107	finally
    //   88	92	107	finally
    //   92	98	107	finally
    //   100	106	107	finally
    //   124	128	107	finally
    //   132	136	107	finally
    //   136	142	107	finally
    //   144	150	107	finally
    //   30	46	115	finally
    //   132	136	143	java/io/IOException
    //   84	88	158	java/io/IOException
    //   124	128	162	java/io/IOException
    //   46	67	166	finally
    //   67	84	172	finally
  }
  
  File f(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(219782);
    paramContext = a(paramContext, paramInt, true);
    AppMethodBeat.o(219782);
    return paramContext;
  }
  
  public boolean f(Context paramContext)
  {
    AppMethodBeat.i(219712);
    for (;;)
    {
      int i1;
      try
      {
        Object localObject = new File(com.tencent.smtt.utils.f.a(paramContext, 4), TbsDownloader.getBackupFileName(true));
        File localFile1 = a().f(paramContext, 2);
        com.tencent.smtt.utils.f.a(localFile1);
        com.tencent.smtt.utils.f.a(localFile1, true);
        com.tencent.smtt.utils.f.a((File)localObject, localFile1);
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
          AppMethodBeat.o(219712);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(219712);
        return false;
      }
      i1 += 1;
    }
  }
  
  boolean g(Context paramContext)
  {
    AppMethodBeat.i(219719);
    if (TbsShareManager.getHostCorePathAppDefined() != null)
    {
      AppMethodBeat.o(219719);
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
          AppMethodBeat.o(219719);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.mm"))
      {
        bool = localSignature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499");
        if (!bool)
        {
          AppMethodBeat.o(219719);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.mobileqq"))
      {
        bool = localSignature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049");
        if (!bool)
        {
          AppMethodBeat.o(219719);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.tbs"))
      {
        bool = localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a");
        if (!bool)
        {
          AppMethodBeat.o(219719);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.qzone"))
      {
        bool = localSignature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677");
        if (!bool)
        {
          AppMethodBeat.o(219719);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.qqpimsecure"))
      {
        bool = localSignature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
        if (!bool)
        {
          AppMethodBeat.o(219719);
          return false;
        }
      }
    }
    catch (Exception paramContext)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
      AppMethodBeat.o(219719);
      return false;
    }
    AppMethodBeat.o(219719);
    return true;
  }
  
  boolean g(Context paramContext, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(219784);
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
          AppMethodBeat.o(219784);
          return true;
        }
        TbsLog.e("TbsInstaller", "321");
        AppMethodBeat.o(219784);
        return false;
      }
      localFile = r(paramContext);
    }
    finally
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
      AppMethodBeat.o(219784);
      return bool1;
      if (!bool3) {
        com.tencent.smtt.utils.f.b(QbSdk.getTbsFolderDir(paramContext));
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
    AppMethodBeat.i(219734);
    int i1 = 1;
    try
    {
      boolean bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
      i1 = bool;
    }
    finally
    {
      label17:
      break label17;
    }
    if ((i1 != 0) && (l != null))
    {
      com.tencent.smtt.utils.f.a(paramContext, l);
      TbsLog.d("TbsInstaller", "releaseTbsCoreRenameFileLock ##!");
    }
    AppMethodBeat.o(219734);
  }
  
  /* Error */
  int i(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 1846
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: new 291	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 571	com/tencent/smtt/sdk/q:q	(Landroid/content/Context;)Ljava/io/File;
    //   18: ldc_w 386
    //   21: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 601	java/io/File:exists	()Z
    //   29: istore_3
    //   30: iload_3
    //   31: ifne +11 -> 42
    //   34: ldc_w 1846
    //   37: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_0
    //   41: ireturn
    //   42: new 388	java/util/Properties
    //   45: dup
    //   46: invokespecial 389	java/util/Properties:<init>	()V
    //   49: astore 5
    //   51: new 391	java/io/BufferedInputStream
    //   54: dup
    //   55: new 393	java/io/FileInputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 396	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 399	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore_1
    //   67: aload 5
    //   69: aload_1
    //   70: invokevirtual 402	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload_1
    //   74: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   77: aload 5
    //   79: ldc_w 1409
    //   82: invokevirtual 1410	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 4
    //   87: aload 4
    //   89: ifnonnull +15 -> 104
    //   92: aload_1
    //   93: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   96: ldc_w 1846
    //   99: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: iconst_0
    //   103: ireturn
    //   104: aload 4
    //   106: invokestatic 1413	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   109: istore_2
    //   110: aload_1
    //   111: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   114: ldc_w 1846
    //   117: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: iload_2
    //   121: ireturn
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_1
    //   125: aload_1
    //   126: ifnull +7 -> 133
    //   129: aload_1
    //   130: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   133: ldc_w 1846
    //   136: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_1
    //   142: aload 4
    //   144: ifnull +8 -> 152
    //   147: aload 4
    //   149: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   152: ldc_w 1846
    //   155: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0: ldc_w 1847
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 149
    //   8: ldc_w 1849
    //   11: invokestatic 605	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: new 291	java/io/File
    //   17: dup
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 270	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   23: ldc_w 386
    //   26: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 601	java/io/File:exists	()Z
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +11 -> 47
    //   39: ldc_w 1847
    //   42: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iconst_0
    //   46: ireturn
    //   47: new 388	java/util/Properties
    //   50: dup
    //   51: invokespecial 389	java/util/Properties:<init>	()V
    //   54: astore 5
    //   56: new 391	java/io/BufferedInputStream
    //   59: dup
    //   60: new 393	java/io/FileInputStream
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 396	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   68: invokespecial 399	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore 4
    //   73: aload 4
    //   75: astore_1
    //   76: aload 5
    //   78: aload 4
    //   80: invokevirtual 402	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   83: aload 4
    //   85: astore_1
    //   86: aload 4
    //   88: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   91: aload 4
    //   93: astore_1
    //   94: aload 5
    //   96: ldc_w 1409
    //   99: invokevirtual 1410	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 5
    //   104: aload 5
    //   106: ifnonnull +45 -> 151
    //   109: aload 4
    //   111: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   114: ldc_w 1847
    //   117: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: iconst_0
    //   121: ireturn
    //   122: astore_1
    //   123: ldc 149
    //   125: new 231	java/lang/StringBuilder
    //   128: dup
    //   129: ldc_w 1851
    //   132: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload_1
    //   136: invokevirtual 1852	java/io/IOException:toString	()Ljava/lang/String;
    //   139: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: goto -34 -> 114
    //   151: aload 4
    //   153: astore_1
    //   154: aload 5
    //   156: invokestatic 1413	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   159: istore_2
    //   160: aload 4
    //   162: astore_1
    //   163: getstatic 117	com/tencent/smtt/sdk/q:o	I
    //   166: ifne +10 -> 176
    //   169: aload 4
    //   171: astore_1
    //   172: iload_2
    //   173: putstatic 117	com/tencent/smtt/sdk/q:o	I
    //   176: aload 4
    //   178: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   181: ldc_w 1847
    //   184: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: iload_2
    //   188: ireturn
    //   189: astore_1
    //   190: ldc 149
    //   192: new 231	java/lang/StringBuilder
    //   195: dup
    //   196: ldc_w 1851
    //   199: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: aload_1
    //   203: invokevirtual 1852	java/io/IOException:toString	()Ljava/lang/String;
    //   206: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: goto -34 -> 181
    //   218: astore 5
    //   220: aconst_null
    //   221: astore 4
    //   223: aload 4
    //   225: astore_1
    //   226: ldc 149
    //   228: new 231	java/lang/StringBuilder
    //   231: dup
    //   232: ldc_w 1854
    //   235: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   238: aload 5
    //   240: invokevirtual 259	java/lang/Exception:toString	()Ljava/lang/String;
    //   243: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload 4
    //   254: ifnull +8 -> 262
    //   257: aload 4
    //   259: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   262: ldc_w 1847
    //   265: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: iconst_0
    //   269: ireturn
    //   270: astore_1
    //   271: ldc 149
    //   273: new 231	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 1851
    //   280: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload_1
    //   284: invokevirtual 1852	java/io/IOException:toString	()Ljava/lang/String;
    //   287: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: goto -34 -> 262
    //   299: astore 4
    //   301: aconst_null
    //   302: astore_1
    //   303: aload_1
    //   304: ifnull +7 -> 311
    //   307: aload_1
    //   308: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   311: ldc_w 1847
    //   314: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: aload 4
    //   319: athrow
    //   320: astore_1
    //   321: ldc 149
    //   323: new 231	java/lang/StringBuilder
    //   326: dup
    //   327: ldc_w 1851
    //   330: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   333: aload_1
    //   334: invokevirtual 1852	java/io/IOException:toString	()Ljava/lang/String;
    //   337: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    AppMethodBeat.i(219762);
    if (o != 0)
    {
      i1 = o;
      AppMethodBeat.o(219762);
      return i1;
    }
    int i1 = j(paramContext);
    AppMethodBeat.o(219762);
    return i1;
  }
  
  void l(Context paramContext)
  {
    AppMethodBeat.i(219765);
    if (o != 0)
    {
      AppMethodBeat.o(219765);
      return;
    }
    o = j(paramContext);
    AppMethodBeat.o(219765);
  }
  
  boolean m(Context paramContext)
  {
    AppMethodBeat.i(219766);
    if (!new File(r(paramContext), "tbs.conf").exists())
    {
      AppMethodBeat.o(219766);
      return false;
    }
    AppMethodBeat.o(219766);
    return true;
  }
  
  /* Error */
  int n(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 1858
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 497	com/tencent/smtt/sdk/q:u	(Landroid/content/Context;)Z
    //   11: ifne +11 -> 22
    //   14: ldc_w 1858
    //   17: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_m1
    //   21: ireturn
    //   22: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   25: invokevirtual 1154	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   28: istore_3
    //   29: ldc 149
    //   31: ldc_w 1860
    //   34: iload_3
    //   35: invokestatic 302	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   38: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: iload_3
    //   45: ifeq +536 -> 581
    //   48: new 291	java/io/File
    //   51: dup
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 270	com/tencent/smtt/sdk/q:r	(Landroid/content/Context;)Ljava/io/File;
    //   57: ldc_w 386
    //   60: invokespecial 381	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual 601	java/io/File:exists	()Z
    //   68: istore_3
    //   69: iload_3
    //   70: ifne +49 -> 119
    //   73: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   76: invokevirtual 1863	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   79: ifeq +9 -> 88
    //   82: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   85: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   88: aload_0
    //   89: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   92: ldc_w 1858
    //   95: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: iconst_0
    //   99: ireturn
    //   100: astore_1
    //   101: ldc 149
    //   103: ldc_w 1865
    //   106: aload_1
    //   107: invokestatic 837	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   110: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   113: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: goto -28 -> 88
    //   119: new 388	java/util/Properties
    //   122: dup
    //   123: invokespecial 389	java/util/Properties:<init>	()V
    //   126: astore 5
    //   128: new 391	java/io/BufferedInputStream
    //   131: dup
    //   132: new 393	java/io/FileInputStream
    //   135: dup
    //   136: aload_1
    //   137: invokespecial 396	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   140: invokespecial 399	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   143: astore 4
    //   145: aload 4
    //   147: astore_1
    //   148: aload 5
    //   150: aload 4
    //   152: invokevirtual 402	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   155: aload 4
    //   157: astore_1
    //   158: aload 4
    //   160: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   163: aload 4
    //   165: astore_1
    //   166: aload 5
    //   168: ldc_w 1409
    //   171: invokevirtual 1410	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   174: astore 5
    //   176: aload 5
    //   178: ifnonnull +83 -> 261
    //   181: aload 4
    //   183: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   186: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   189: invokevirtual 1863	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   192: ifeq +9 -> 201
    //   195: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   198: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   201: aload_0
    //   202: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   205: ldc_w 1858
    //   208: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: iconst_0
    //   212: ireturn
    //   213: astore_1
    //   214: ldc 149
    //   216: new 231	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 1867
    //   223: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload_1
    //   227: invokevirtual 1852	java/io/IOException:toString	()Ljava/lang/String;
    //   230: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: goto -53 -> 186
    //   242: astore_1
    //   243: ldc 149
    //   245: ldc_w 1865
    //   248: aload_1
    //   249: invokestatic 837	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   252: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   255: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: goto -57 -> 201
    //   261: aload 4
    //   263: astore_1
    //   264: getstatic 70	com/tencent/smtt/sdk/q:a	Ljava/lang/ThreadLocal;
    //   267: aload 5
    //   269: invokestatic 1413	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   272: invokestatic 221	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   275: invokevirtual 227	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   278: aload 4
    //   280: astore_1
    //   281: getstatic 70	com/tencent/smtt/sdk/q:a	Ljava/lang/ThreadLocal;
    //   284: invokevirtual 1419	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   287: checkcast 218	java/lang/Integer
    //   290: invokevirtual 1422	java/lang/Integer:intValue	()I
    //   293: istore_2
    //   294: aload 4
    //   296: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   299: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   302: invokevirtual 1863	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   305: ifeq +9 -> 314
    //   308: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   311: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   314: aload_0
    //   315: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   318: ldc_w 1858
    //   321: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: iload_2
    //   325: ireturn
    //   326: astore_1
    //   327: ldc 149
    //   329: new 231	java/lang/StringBuilder
    //   332: dup
    //   333: ldc_w 1867
    //   336: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   339: aload_1
    //   340: invokevirtual 1852	java/io/IOException:toString	()Ljava/lang/String;
    //   343: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: goto -53 -> 299
    //   355: astore_1
    //   356: ldc 149
    //   358: ldc_w 1865
    //   361: aload_1
    //   362: invokestatic 837	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   365: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   368: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: goto -57 -> 314
    //   374: astore 5
    //   376: aconst_null
    //   377: astore 4
    //   379: aload 4
    //   381: astore_1
    //   382: ldc 149
    //   384: new 231	java/lang/StringBuilder
    //   387: dup
    //   388: ldc_w 1869
    //   391: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: aload 5
    //   396: invokevirtual 259	java/lang/Exception:toString	()Ljava/lang/String;
    //   399: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: aload 4
    //   410: ifnull +8 -> 418
    //   413: aload 4
    //   415: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   418: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   421: invokevirtual 1863	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   424: ifeq +9 -> 433
    //   427: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   430: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   433: aload_0
    //   434: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   437: ldc_w 1858
    //   440: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   443: iconst_0
    //   444: ireturn
    //   445: astore_1
    //   446: ldc 149
    //   448: new 231	java/lang/StringBuilder
    //   451: dup
    //   452: ldc_w 1867
    //   455: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   458: aload_1
    //   459: invokevirtual 1852	java/io/IOException:toString	()Ljava/lang/String;
    //   462: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: goto -53 -> 418
    //   474: astore_1
    //   475: ldc 149
    //   477: ldc_w 1865
    //   480: aload_1
    //   481: invokestatic 837	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   484: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   487: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   490: goto -57 -> 433
    //   493: astore 4
    //   495: aconst_null
    //   496: astore_1
    //   497: aload_1
    //   498: ifnull +7 -> 505
    //   501: aload_1
    //   502: invokevirtual 428	java/io/BufferedInputStream:close	()V
    //   505: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   508: invokevirtual 1863	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   511: ifeq +9 -> 520
    //   514: getstatic 61	com/tencent/smtt/sdk/q:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   517: invokevirtual 527	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   520: aload_0
    //   521: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   524: ldc_w 1858
    //   527: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   530: aload 4
    //   532: athrow
    //   533: astore_1
    //   534: ldc 149
    //   536: new 231	java/lang/StringBuilder
    //   539: dup
    //   540: ldc_w 1867
    //   543: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   546: aload_1
    //   547: invokevirtual 1852	java/io/IOException:toString	()Ljava/lang/String;
    //   550: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: goto -54 -> 505
    //   562: astore_1
    //   563: ldc 149
    //   565: ldc_w 1865
    //   568: aload_1
    //   569: invokestatic 837	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   572: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   575: invokestatic 453	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: goto -58 -> 520
    //   581: aload_0
    //   582: invokevirtual 530	com/tencent/smtt/sdk/q:b	()V
    //   585: ldc_w 1858
    //   588: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   73	88	100	finally
    //   181	186	213	java/io/IOException
    //   186	201	242	finally
    //   294	299	326	java/io/IOException
    //   299	314	355	finally
    //   48	69	374	java/lang/Exception
    //   119	145	374	java/lang/Exception
    //   413	418	445	java/io/IOException
    //   418	433	474	finally
    //   48	69	493	finally
    //   119	145	493	finally
    //   501	505	533	java/io/IOException
    //   505	520	562	finally
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
    return true;
  }
  
  void p(Context paramContext)
  {
    AppMethodBeat.i(219771);
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
      com.tencent.smtt.utils.f.a(f(paramContext, 0), true);
      com.tencent.smtt.utils.f.a(f(paramContext, 1), true);
    }
    AppMethodBeat.o(219771);
  }
  
  File q(Context paramContext)
  {
    AppMethodBeat.i(219775);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_share_decouple");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(219775);
      return null;
    }
    AppMethodBeat.o(219775);
    return paramContext;
  }
  
  File r(Context paramContext)
  {
    AppMethodBeat.i(219780);
    paramContext = b(paramContext, paramContext);
    AppMethodBeat.o(219780);
    return paramContext;
  }
  
  File s(Context paramContext)
  {
    AppMethodBeat.i(219781);
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "share");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(219781);
      return null;
    }
    AppMethodBeat.o(219781);
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
    //   4: ldc_w 1881
    //   7: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc 149
    //   12: new 231	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 1883
    //   19: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: invokestatic 859	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   25: invokevirtual 1551	java/lang/Thread:getId	()J
    //   28: invokevirtual 556	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   31: ldc_w 749
    //   34: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_0
    //   38: getfield 126	com/tencent/smtt/sdk/q:e	I
    //   41: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 605	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: getfield 126	com/tencent/smtt/sdk/q:e	I
    //   54: ifle +31 -> 85
    //   57: ldc 149
    //   59: ldc_w 1885
    //   62: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_0
    //   66: aload_0
    //   67: getfield 126	com/tencent/smtt/sdk/q:e	I
    //   70: iconst_1
    //   71: iadd
    //   72: putfield 126	com/tencent/smtt/sdk/q:e	I
    //   75: ldc_w 1881
    //   78: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: monitorexit
    //   83: iload_2
    //   84: ireturn
    //   85: aload_0
    //   86: aload_1
    //   87: iconst_1
    //   88: ldc_w 1887
    //   91: invokestatic 1890	com/tencent/smtt/utils/f:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   94: putfield 1561	com/tencent/smtt/sdk/q:g	Ljava/io/FileOutputStream;
    //   97: aload_0
    //   98: getfield 1561	com/tencent/smtt/sdk/q:g	Ljava/io/FileOutputStream;
    //   101: ifnull +41 -> 142
    //   104: aload_0
    //   105: aload_1
    //   106: aload_0
    //   107: getfield 1561	com/tencent/smtt/sdk/q:g	Ljava/io/FileOutputStream;
    //   110: invokestatic 1893	com/tencent/smtt/utils/f:a	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   113: putfield 1559	com/tencent/smtt/sdk/q:f	Ljava/nio/channels/FileLock;
    //   116: aload_0
    //   117: getfield 1559	com/tencent/smtt/sdk/q:f	Ljava/nio/channels/FileLock;
    //   120: ifnonnull +41 -> 161
    //   123: ldc 149
    //   125: ldc_w 1895
    //   128: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: ldc_w 1881
    //   134: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iconst_0
    //   138: istore_2
    //   139: goto -58 -> 81
    //   142: ldc 149
    //   144: ldc_w 1897
    //   147: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: ldc_w 1881
    //   153: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_0
    //   157: istore_2
    //   158: goto -77 -> 81
    //   161: ldc 149
    //   163: ldc_w 1899
    //   166: invokestatic 156	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: aload_0
    //   171: getfield 126	com/tencent/smtt/sdk/q:e	I
    //   174: iconst_1
    //   175: iadd
    //   176: putfield 126	com/tencent/smtt/sdk/q:e	I
    //   179: ldc_w 1881
    //   182: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.q
 * JD-Core Version:    0.7.0.1
 */