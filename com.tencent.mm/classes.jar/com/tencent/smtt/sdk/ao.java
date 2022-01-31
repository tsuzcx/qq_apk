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
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ao
{
  public static ThreadLocal<Integer> a;
  static boolean b;
  static final FileFilter c;
  private static ao d;
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
    AppMethodBeat.i(139351);
    d = null;
    i = new ReentrantLock();
    j = new ReentrantLock();
    l = null;
    a = new ap();
    m = null;
    Long[] arrayOfLong1 = { Long.valueOf(44006L), Long.valueOf(39094008L) };
    Long[] arrayOfLong2 = { Long.valueOf(44005L), Long.valueOf(39094008L) };
    Long[] arrayOfLong3 = { Long.valueOf(43910L), Long.valueOf(38917816L) };
    Long[] arrayOfLong4 = { Long.valueOf(44027L), Long.valueOf(39094008L) };
    Long[] arrayOfLong5 = { Long.valueOf(44028L), Long.valueOf(39094008L) };
    Long[] arrayOfLong6 = { Long.valueOf(44029L), Long.valueOf(39094008L) };
    Long[] arrayOfLong7 = { Long.valueOf(44032L), Long.valueOf(39094008L) };
    Long[] arrayOfLong8 = { Long.valueOf(44033L), Long.valueOf(39094008L) };
    Long[] arrayOfLong9 = { Long.valueOf(44034L), Long.valueOf(39094008L) };
    Long[] arrayOfLong10 = { Long.valueOf(43909L), Long.valueOf(38917816L) };
    n = new Long[][] { arrayOfLong1, arrayOfLong2, arrayOfLong3, arrayOfLong4, arrayOfLong5, arrayOfLong6, { Long.valueOf(44030L), Long.valueOf(39094008L) }, arrayOfLong7, arrayOfLong8, arrayOfLong9, arrayOfLong10 };
    b = false;
    c = new aq();
    o = 0;
    p = false;
    AppMethodBeat.o(139351);
  }
  
  private ao()
  {
    AppMethodBeat.i(139275);
    this.e = 0;
    this.h = false;
    this.k = false;
    if (m == null) {
      m = new ar(this, am.a().getLooper());
    }
    AppMethodBeat.o(139275);
  }
  
  private void A(Context paramContext)
  {
    AppMethodBeat.i(139330);
    TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
    k.a(q(paramContext), false);
    AppMethodBeat.o(139330);
  }
  
  private void B(Context paramContext)
  {
    AppMethodBeat.i(139331);
    TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
    File localFile1 = f(paramContext, 0);
    File localFile2 = q(paramContext);
    if ((localFile1 == null) || (localFile2 == null))
    {
      TbsLog.i("TbsInstaller", "renameTbsCoreShareDir return,tmpTbsCoreUnzipDir=" + localFile1 + "tbsSharePath=" + localFile2);
      AppMethodBeat.o(139331);
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
      AppMethodBeat.o(139331);
      return;
      label143:
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(231, " ");
    }
  }
  
  private void C(Context paramContext)
  {
    AppMethodBeat.i(139333);
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
    File localFile1 = f(paramContext, 1);
    File localFile2 = q(paramContext);
    if ((localFile1 == null) || (localFile2 == null))
    {
      AppMethodBeat.o(139333);
      return;
    }
    localFile1.renameTo(localFile2);
    g(paramContext, false);
    AppMethodBeat.o(139333);
  }
  
  private void D(Context paramContext)
  {
    AppMethodBeat.i(139334);
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
    File localFile1 = f(paramContext, 5);
    File localFile2 = q(paramContext);
    if ((localFile1 == null) || (localFile2 == null))
    {
      AppMethodBeat.o(139334);
      return;
    }
    localFile1.renameTo(localFile2);
    g(paramContext, false);
    AppMethodBeat.o(139334);
  }
  
  private void E(Context paramContext)
  {
    AppMethodBeat.i(139335);
    TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
    File localFile = f(paramContext, 0);
    if (localFile != null) {
      k.a(localFile, false);
    }
    aj.a(paramContext).c(0, 5);
    aj.a(paramContext).c(-1);
    QbSdk.a(paramContext, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    AppMethodBeat.o(139335);
  }
  
  /* Error */
  static ao a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 265
    //   6: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 42	com/tencent/smtt/sdk/ao:d	Lcom/tencent/smtt/sdk/ao;
    //   12: ifnonnull +25 -> 37
    //   15: ldc 2
    //   17: monitorenter
    //   18: getstatic 42	com/tencent/smtt/sdk/ao:d	Lcom/tencent/smtt/sdk/ao;
    //   21: ifnonnull +13 -> 34
    //   24: new 2	com/tencent/smtt/sdk/ao
    //   27: dup
    //   28: invokespecial 266	com/tencent/smtt/sdk/ao:<init>	()V
    //   31: putstatic 42	com/tencent/smtt/sdk/ao:d	Lcom/tencent/smtt/sdk/ao;
    //   34: ldc 2
    //   36: monitorexit
    //   37: getstatic 42	com/tencent/smtt/sdk/ao:d	Lcom/tencent/smtt/sdk/ao;
    //   40: astore_0
    //   41: ldc_w 265
    //   44: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: ldc_w 265
    //   59: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_0
    //   63: athrow
    //   64: astore_0
    //   65: ldc 2
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   40	11	0	localao	ao
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
    //   0: ldc_w 272
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 182	java/io/File
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 277	java/io/File:delete	()Z
    //   17: pop
    //   18: ldc 137
    //   20: new 162	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 279
    //   27: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_2
    //   31: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 281
    //   37: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: iconst_1
    //   44: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   47: new 182	java/io/File
    //   50: dup
    //   51: aload_3
    //   52: ldc_w 286
    //   55: iconst_0
    //   56: invokevirtual 290	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   59: ldc_w 292
    //   62: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   65: astore_2
    //   66: aload_2
    //   67: invokevirtual 298	java/io/File:canRead	()Z
    //   70: ifeq +181 -> 251
    //   73: new 182	java/io/File
    //   76: dup
    //   77: aload_2
    //   78: ldc_w 300
    //   81: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   84: astore_2
    //   85: new 302	java/util/Properties
    //   88: dup
    //   89: invokespecial 303	java/util/Properties:<init>	()V
    //   92: astore 4
    //   94: new 305	java/io/BufferedInputStream
    //   97: dup
    //   98: new 307	java/io/FileInputStream
    //   101: dup
    //   102: aload_2
    //   103: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   106: invokespecial 313	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   109: astore_3
    //   110: aload 4
    //   112: aload_3
    //   113: invokevirtual 316	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   116: new 318	java/io/BufferedOutputStream
    //   119: dup
    //   120: new 320	java/io/FileOutputStream
    //   123: dup
    //   124: aload_2
    //   125: invokespecial 321	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   128: invokespecial 324	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   131: astore_2
    //   132: aload 4
    //   134: ldc_w 326
    //   137: ldc_w 328
    //   140: invokevirtual 332	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   143: pop
    //   144: aload 4
    //   146: aload_2
    //   147: aconst_null
    //   148: invokevirtual 336	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   151: ldc 137
    //   153: ldc_w 338
    //   156: iconst_1
    //   157: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   160: aload_2
    //   161: invokevirtual 341	java/io/BufferedOutputStream:close	()V
    //   164: aload_3
    //   165: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   168: ldc_w 272
    //   171: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: return
    //   175: astore_2
    //   176: ldc_w 272
    //   179: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: return
    //   183: astore_2
    //   184: aconst_null
    //   185: astore_2
    //   186: aconst_null
    //   187: astore_3
    //   188: aload_2
    //   189: ifnull +7 -> 196
    //   192: aload_2
    //   193: invokevirtual 341	java/io/BufferedOutputStream:close	()V
    //   196: aload_3
    //   197: ifnull +54 -> 251
    //   200: aload_3
    //   201: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   204: ldc_w 272
    //   207: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: return
    //   211: astore_2
    //   212: ldc_w 272
    //   215: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: return
    //   219: astore_2
    //   220: aconst_null
    //   221: astore_3
    //   222: aconst_null
    //   223: astore 4
    //   225: aload_3
    //   226: ifnull +7 -> 233
    //   229: aload_3
    //   230: invokevirtual 341	java/io/BufferedOutputStream:close	()V
    //   233: aload 4
    //   235: ifnull +8 -> 243
    //   238: aload 4
    //   240: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   243: ldc_w 272
    //   246: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: aload_2
    //   250: athrow
    //   251: ldc_w 272
    //   254: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: return
    //   258: astore_2
    //   259: goto -95 -> 164
    //   262: astore_2
    //   263: goto -67 -> 196
    //   266: astore_3
    //   267: goto -34 -> 233
    //   270: astore_3
    //   271: goto -28 -> 243
    //   274: astore_2
    //   275: aconst_null
    //   276: astore 5
    //   278: aload_3
    //   279: astore 4
    //   281: aload 5
    //   283: astore_3
    //   284: goto -59 -> 225
    //   287: astore 5
    //   289: aload_2
    //   290: astore 6
    //   292: aload_3
    //   293: astore 4
    //   295: aload 5
    //   297: astore_2
    //   298: aload 6
    //   300: astore_3
    //   301: goto -76 -> 225
    //   304: astore_2
    //   305: aconst_null
    //   306: astore_2
    //   307: goto -119 -> 188
    //   310: astore 4
    //   312: goto -124 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	ao
    //   0	315	1	paramInt	int
    //   0	315	2	paramString	String
    //   0	315	3	paramContext	Context
    //   92	202	4	localObject1	Object
    //   310	1	4	localThrowable	Throwable
    //   276	6	5	localObject2	Object
    //   287	9	5	localObject3	Object
    //   290	9	6	str	String
    // Exception table:
    //   from	to	target	type
    //   164	168	175	java/io/IOException
    //   94	110	183	java/lang/Throwable
    //   200	204	211	java/io/IOException
    //   94	110	219	finally
    //   160	164	258	java/io/IOException
    //   192	196	262	java/io/IOException
    //   229	233	266	java/io/IOException
    //   238	243	270	java/io/IOException
    //   110	132	274	finally
    //   132	160	287	finally
    //   110	132	304	java/lang/Throwable
    //   132	160	310	java/lang/Throwable
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(139282);
    if (!v(paramContext))
    {
      if (a(paramContext, "core_unzip_tmp"))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
        TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
        AppMethodBeat.o(139282);
        return;
      }
      if (a(paramContext, "core_share_backup_tmp"))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
        TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
        AppMethodBeat.o(139282);
        return;
      }
      if (a(paramContext, "core_copy_tmp"))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
        TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
      }
    }
    AppMethodBeat.o(139282);
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private void a(Context paramContext1, Context paramContext2, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 384
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   10: sipush -524
    //   13: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   16: aload_0
    //   17: aload_2
    //   18: invokevirtual 394	com/tencent/smtt/sdk/ao:c	(Landroid/content/Context;)Z
    //   21: ifeq +10 -> 31
    //   24: ldc_w 384
    //   27: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: return
    //   31: ldc 137
    //   33: ldc_w 396
    //   36: iload_3
    //   37: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   40: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   43: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: getstatic 404	android/os/Build$VERSION:SDK_INT	I
    //   49: bipush 11
    //   51: if_icmplt +73 -> 124
    //   54: aload_2
    //   55: ldc_w 406
    //   58: iconst_4
    //   59: invokevirtual 410	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   62: astore 14
    //   64: aload 14
    //   66: ldc_w 412
    //   69: iconst_m1
    //   70: invokeinterface 418 3 0
    //   75: iload_3
    //   76: if_icmpne +61 -> 137
    //   79: ldc 137
    //   81: new 162	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 420
    //   88: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: iload_3
    //   92: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: ldc_w 425
    //   98: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_1
    //   108: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   111: sipush -525
    //   114: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   117: ldc_w 384
    //   120: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: return
    //   124: aload_2
    //   125: ldc_w 406
    //   128: iconst_0
    //   129: invokevirtual 410	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   132: astore 14
    //   134: goto -70 -> 64
    //   137: aload_0
    //   138: aload_2
    //   139: invokevirtual 428	com/tencent/smtt/sdk/ao:t	(Landroid/content/Context;)Z
    //   142: ifne +20 -> 162
    //   145: aload_1
    //   146: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   149: sipush -526
    //   152: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   155: ldc_w 384
    //   158: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: return
    //   162: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   165: invokeinterface 433 1 0
    //   170: istore 8
    //   172: ldc 137
    //   174: ldc_w 435
    //   177: iload 8
    //   179: invokestatic 193	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   182: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   185: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: iload 8
    //   190: ifeq +1785 -> 1975
    //   193: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   196: invokevirtual 438	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   199: aconst_null
    //   200: astore 15
    //   202: aload_2
    //   203: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   206: ldc_w 440
    //   209: invokevirtual 443	com/tencent/smtt/sdk/aj:c	(Ljava/lang/String;)I
    //   212: istore 4
    //   214: aload_2
    //   215: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   218: ldc_w 445
    //   221: invokevirtual 447	com/tencent/smtt/sdk/aj:b	(Ljava/lang/String;)I
    //   224: istore 5
    //   226: iload 4
    //   228: iload_3
    //   229: if_icmpne +49 -> 278
    //   232: getstatic 450	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   235: sipush 220
    //   238: invokeinterface 455 2 0
    //   243: aload_1
    //   244: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   247: sipush -528
    //   250: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   253: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   256: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   259: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   262: invokeinterface 459 1 0
    //   267: aload_0
    //   268: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   271: ldc_w 384
    //   274: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: return
    //   278: aload_0
    //   279: aload_2
    //   280: invokevirtual 464	com/tencent/smtt/sdk/ao:i	(Landroid/content/Context;)I
    //   283: istore 6
    //   285: ldc 137
    //   287: ldc_w 466
    //   290: iload 6
    //   292: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   295: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   298: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: iload 6
    //   303: iload_3
    //   304: if_icmpne +65 -> 369
    //   307: getstatic 450	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   310: sipush 220
    //   313: invokeinterface 455 2 0
    //   318: aload_1
    //   319: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   322: sipush -528
    //   325: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   328: ldc 137
    //   330: ldc_w 468
    //   333: iload 6
    //   335: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   338: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   341: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   347: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   350: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   353: invokeinterface 459 1 0
    //   358: aload_0
    //   359: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   362: ldc_w 384
    //   365: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: return
    //   369: aload_2
    //   370: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   373: invokevirtual 471	com/tencent/smtt/sdk/aj:b	()I
    //   376: istore 7
    //   378: iload 7
    //   380: ifle +1662 -> 2042
    //   383: iload_3
    //   384: iload 7
    //   386: if_icmpgt +6 -> 392
    //   389: goto +1653 -> 2042
    //   392: aload_0
    //   393: aload_2
    //   394: invokevirtual 473	com/tencent/smtt/sdk/ao:o	(Landroid/content/Context;)V
    //   397: goto +1659 -> 2056
    //   400: iconst_m1
    //   401: istore 4
    //   403: aload_0
    //   404: aload_2
    //   405: invokevirtual 473	com/tencent/smtt/sdk/ao:o	(Landroid/content/Context;)V
    //   408: ldc 137
    //   410: ldc_w 475
    //   413: iconst_1
    //   414: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   417: aload_2
    //   418: invokestatic 477	com/tencent/smtt/utils/k:b	(Landroid/content/Context;)Z
    //   421: ifne +91 -> 512
    //   424: invokestatic 482	com/tencent/smtt/utils/y:a	()J
    //   427: lstore 10
    //   429: aload_2
    //   430: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   433: invokevirtual 485	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   436: lstore 12
    //   438: aload_1
    //   439: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   442: sipush -529
    //   445: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   448: aload_2
    //   449: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   452: sipush 210
    //   455: new 162	java/lang/StringBuilder
    //   458: dup
    //   459: ldc_w 487
    //   462: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   465: lload 10
    //   467: invokevirtual 490	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   470: ldc_w 492
    //   473: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: lload 12
    //   478: invokevirtual 490	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   481: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   487: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   490: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   493: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   496: invokeinterface 459 1 0
    //   501: aload_0
    //   502: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   505: ldc_w 384
    //   508: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: return
    //   512: iload 4
    //   514: ifle +77 -> 591
    //   517: aload_2
    //   518: invokestatic 497	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   521: ifne +19 -> 540
    //   524: aload_2
    //   525: invokestatic 501	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   528: ifeq +12 -> 540
    //   531: iload_3
    //   532: aload_0
    //   533: aload_2
    //   534: invokevirtual 503	com/tencent/smtt/sdk/ao:h	(Landroid/content/Context;)I
    //   537: if_icmpne +54 -> 591
    //   540: ldc 137
    //   542: new 162	java/lang/StringBuilder
    //   545: dup
    //   546: ldc_w 505
    //   549: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   552: aload_0
    //   553: aload_2
    //   554: invokevirtual 503	com/tencent/smtt/sdk/ao:h	(Landroid/content/Context;)I
    //   557: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   566: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   569: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   572: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   575: invokeinterface 459 1 0
    //   580: aload_0
    //   581: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   584: ldc_w 384
    //   587: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   590: return
    //   591: iload 4
    //   593: ifne +83 -> 676
    //   596: aload_2
    //   597: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   600: ldc_w 507
    //   603: invokevirtual 443	com/tencent/smtt/sdk/aj:c	(Ljava/lang/String;)I
    //   606: istore 4
    //   608: iload 4
    //   610: iconst_2
    //   611: if_icmple +51 -> 662
    //   614: aload_2
    //   615: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   618: sipush 211
    //   621: ldc_w 509
    //   624: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   627: aload_1
    //   628: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   631: sipush -530
    //   634: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   637: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   640: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   643: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   646: invokeinterface 459 1 0
    //   651: aload_0
    //   652: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   655: ldc_w 384
    //   658: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   661: return
    //   662: aload_2
    //   663: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   666: ldc_w 507
    //   669: iload 4
    //   671: iconst_1
    //   672: iadd
    //   673: invokevirtual 512	com/tencent/smtt/sdk/aj:a	(Ljava/lang/String;I)V
    //   676: aload_0
    //   677: aload_1
    //   678: invokevirtual 148	com/tencent/smtt/sdk/ao:q	(Landroid/content/Context;)Ljava/io/File;
    //   681: astore 16
    //   683: aload_2
    //   684: invokestatic 497	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   687: ifne +218 -> 905
    //   690: aload_2
    //   691: invokestatic 501	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   694: ifeq +196 -> 890
    //   697: aload_0
    //   698: aload_2
    //   699: invokevirtual 514	com/tencent/smtt/sdk/ao:p	(Landroid/content/Context;)Ljava/io/File;
    //   702: astore 14
    //   704: aload 14
    //   706: astore 15
    //   708: aload 16
    //   710: ifnull +1164 -> 1874
    //   713: aload 15
    //   715: ifnull +1159 -> 1874
    //   718: aload_2
    //   719: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   722: iload_3
    //   723: iconst_0
    //   724: invokevirtual 516	com/tencent/smtt/sdk/aj:a	(II)V
    //   727: new 518	com/tencent/smtt/utils/x
    //   730: dup
    //   731: invokespecial 519	com/tencent/smtt/utils/x:<init>	()V
    //   734: astore 14
    //   736: aload 14
    //   738: aload 16
    //   740: invokevirtual 521	com/tencent/smtt/utils/x:a	(Ljava/io/File;)V
    //   743: invokestatic 526	java/lang/System:currentTimeMillis	()J
    //   746: lstore 10
    //   748: aload_1
    //   749: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   752: sipush -551
    //   755: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   758: aload 16
    //   760: aload 15
    //   762: getstatic 103	com/tencent/smtt/sdk/ao:c	Ljava/io/FileFilter;
    //   765: invokestatic 529	com/tencent/smtt/utils/k:a	(Ljava/io/File;Ljava/io/File;Ljava/io/FileFilter;)Z
    //   768: istore 8
    //   770: aload_2
    //   771: invokestatic 501	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   774: ifeq +7 -> 781
    //   777: aload_2
    //   778: invokestatic 531	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   781: ldc 137
    //   783: new 162	java/lang/StringBuilder
    //   786: dup
    //   787: ldc_w 533
    //   790: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   793: invokestatic 526	java/lang/System:currentTimeMillis	()J
    //   796: lload 10
    //   798: lsub
    //   799: invokevirtual 490	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   802: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   808: iload 8
    //   810: ifeq +1015 -> 1825
    //   813: aload 14
    //   815: aload 16
    //   817: invokevirtual 535	com/tencent/smtt/utils/x:b	(Ljava/io/File;)V
    //   820: aload 14
    //   822: invokevirtual 537	com/tencent/smtt/utils/x:a	()Z
    //   825: ifne +95 -> 920
    //   828: ldc 137
    //   830: ldc_w 539
    //   833: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   836: aload 15
    //   838: iconst_1
    //   839: invokestatic 153	com/tencent/smtt/utils/k:a	(Ljava/io/File;Z)V
    //   842: aload_2
    //   843: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   846: sipush 213
    //   849: ldc_w 541
    //   852: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   855: aload_1
    //   856: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   859: sipush -531
    //   862: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   865: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   868: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   871: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   874: invokeinterface 459 1 0
    //   879: aload_0
    //   880: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   883: ldc_w 384
    //   886: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   889: return
    //   890: aload_0
    //   891: aload_2
    //   892: iconst_1
    //   893: invokevirtual 160	com/tencent/smtt/sdk/ao:f	(Landroid/content/Context;I)Ljava/io/File;
    //   896: astore 14
    //   898: aload 14
    //   900: astore 15
    //   902: goto -194 -> 708
    //   905: aload_0
    //   906: aload_2
    //   907: iconst_1
    //   908: invokevirtual 160	com/tencent/smtt/sdk/ao:f	(Landroid/content/Context;I)Ljava/io/File;
    //   911: astore 14
    //   913: aload 14
    //   915: astore 15
    //   917: goto -209 -> 708
    //   920: iconst_1
    //   921: istore 4
    //   923: iconst_1
    //   924: istore 6
    //   926: iconst_1
    //   927: istore 5
    //   929: aconst_null
    //   930: astore 18
    //   932: aconst_null
    //   933: astore 17
    //   935: new 182	java/io/File
    //   938: dup
    //   939: aload 15
    //   941: ldc_w 543
    //   944: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   947: astore 16
    //   949: new 302	java/util/Properties
    //   952: dup
    //   953: invokespecial 303	java/util/Properties:<init>	()V
    //   956: astore 14
    //   958: aload 16
    //   960: invokevirtual 546	java/io/File:exists	()Z
    //   963: ifeq +276 -> 1239
    //   966: new 305	java/io/BufferedInputStream
    //   969: dup
    //   970: new 307	java/io/FileInputStream
    //   973: dup
    //   974: aload 16
    //   976: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   979: invokespecial 313	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   982: astore 16
    //   984: aload 14
    //   986: aload 16
    //   988: invokevirtual 316	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   991: iload 5
    //   993: istore 4
    //   995: aload 16
    //   997: astore 17
    //   999: aload 14
    //   1001: astore 16
    //   1003: iload 4
    //   1005: istore 5
    //   1007: aload 17
    //   1009: ifnull +1022 -> 2031
    //   1012: aload 17
    //   1014: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   1017: iload 4
    //   1019: ifeq +1006 -> 2025
    //   1022: aload 15
    //   1024: invokevirtual 550	java/io/File:listFiles	()[Ljava/io/File;
    //   1027: astore 16
    //   1029: aload_1
    //   1030: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1033: sipush -552
    //   1036: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1039: iconst_0
    //   1040: istore 5
    //   1042: iconst_1
    //   1043: istore 8
    //   1045: iload 8
    //   1047: istore 9
    //   1049: iload 5
    //   1051: aload 16
    //   1053: arraylength
    //   1054: if_icmpge +373 -> 1427
    //   1057: aload 16
    //   1059: iload 5
    //   1061: aaload
    //   1062: astore 17
    //   1064: iload 8
    //   1066: istore 9
    //   1068: ldc_w 543
    //   1071: aload 17
    //   1073: invokevirtual 553	java/io/File:getName	()Ljava/lang/String;
    //   1076: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1079: ifne +147 -> 1226
    //   1082: iload 8
    //   1084: istore 9
    //   1086: aload 17
    //   1088: invokevirtual 553	java/io/File:getName	()Ljava/lang/String;
    //   1091: ldc_w 555
    //   1094: invokevirtual 559	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1097: ifne +129 -> 1226
    //   1100: iload 8
    //   1102: istore 9
    //   1104: ldc_w 300
    //   1107: aload 17
    //   1109: invokevirtual 553	java/io/File:getName	()Ljava/lang/String;
    //   1112: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1115: ifne +111 -> 1226
    //   1118: iload 8
    //   1120: istore 9
    //   1122: aload 17
    //   1124: invokevirtual 562	java/io/File:isDirectory	()Z
    //   1127: ifne +99 -> 1226
    //   1130: iload 8
    //   1132: istore 9
    //   1134: aload 17
    //   1136: invokevirtual 553	java/io/File:getName	()Ljava/lang/String;
    //   1139: ldc_w 564
    //   1142: invokevirtual 559	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1145: ifne +81 -> 1226
    //   1148: aload 17
    //   1150: invokestatic 569	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   1153: astore 18
    //   1155: aload 14
    //   1157: aload 17
    //   1159: invokevirtual 553	java/io/File:getName	()Ljava/lang/String;
    //   1162: ldc_w 571
    //   1165: invokevirtual 575	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1168: astore 19
    //   1170: aload 19
    //   1172: ldc_w 571
    //   1175: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1178: ifne +198 -> 1376
    //   1181: aload 18
    //   1183: aload 19
    //   1185: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1188: ifeq +188 -> 1376
    //   1191: ldc 137
    //   1193: new 162	java/lang/StringBuilder
    //   1196: dup
    //   1197: ldc_w 577
    //   1200: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1203: aload 17
    //   1205: invokevirtual 553	java/io/File:getName	()Ljava/lang/String;
    //   1208: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: ldc_w 579
    //   1214: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1220: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1223: iconst_1
    //   1224: istore 9
    //   1226: iload 5
    //   1228: iconst_1
    //   1229: iadd
    //   1230: istore 5
    //   1232: iload 9
    //   1234: istore 8
    //   1236: goto -191 -> 1045
    //   1239: iconst_0
    //   1240: istore 4
    //   1242: aconst_null
    //   1243: astore 17
    //   1245: goto -246 -> 999
    //   1248: astore 16
    //   1250: goto -233 -> 1017
    //   1253: astore 14
    //   1255: aconst_null
    //   1256: astore 14
    //   1258: aload 14
    //   1260: astore 16
    //   1262: iload 6
    //   1264: istore 5
    //   1266: aload 17
    //   1268: ifnull +763 -> 2031
    //   1271: aload 17
    //   1273: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   1276: goto -259 -> 1017
    //   1279: astore 16
    //   1281: goto -264 -> 1017
    //   1284: astore 14
    //   1286: aload 18
    //   1288: astore 16
    //   1290: aload 16
    //   1292: ifnull +8 -> 1300
    //   1295: aload 16
    //   1297: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   1300: ldc_w 384
    //   1303: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1306: aload 14
    //   1308: athrow
    //   1309: astore 14
    //   1311: aload_2
    //   1312: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1315: sipush 215
    //   1318: aload 14
    //   1320: invokevirtual 580	java/lang/Exception:toString	()Ljava/lang/String;
    //   1323: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1326: aload_1
    //   1327: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1330: sipush -537
    //   1333: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1336: aload 15
    //   1338: iconst_0
    //   1339: invokestatic 153	com/tencent/smtt/utils/k:a	(Ljava/io/File;Z)V
    //   1342: aload_2
    //   1343: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1346: iconst_0
    //   1347: iconst_m1
    //   1348: invokevirtual 516	com/tencent/smtt/sdk/aj:a	(II)V
    //   1351: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1354: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1357: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   1360: invokeinterface 459 1 0
    //   1365: aload_0
    //   1366: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1369: ldc_w 384
    //   1372: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1375: return
    //   1376: iconst_0
    //   1377: istore 9
    //   1379: ldc 137
    //   1381: new 162	java/lang/StringBuilder
    //   1384: dup
    //   1385: ldc_w 582
    //   1388: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1391: aload 17
    //   1393: invokevirtual 553	java/io/File:getName	()Ljava/lang/String;
    //   1396: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: ldc_w 584
    //   1402: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: aload 19
    //   1407: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: ldc_w 586
    //   1413: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: aload 18
    //   1418: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1424: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1427: ldc 137
    //   1429: ldc_w 588
    //   1432: iload 9
    //   1434: invokestatic 193	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   1437: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1440: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1443: iload 4
    //   1445: ifeq +70 -> 1515
    //   1448: iload 9
    //   1450: ifne +65 -> 1515
    //   1453: ldc 137
    //   1455: ldc_w 590
    //   1458: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1461: aload 15
    //   1463: iconst_1
    //   1464: invokestatic 153	com/tencent/smtt/utils/k:a	(Ljava/io/File;Z)V
    //   1467: aload_2
    //   1468: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1471: sipush 213
    //   1474: ldc_w 592
    //   1477: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1480: aload_1
    //   1481: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1484: sipush -532
    //   1487: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1490: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1493: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1496: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   1499: invokeinterface 459 1 0
    //   1504: aload_0
    //   1505: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1508: ldc_w 384
    //   1511: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1514: return
    //   1515: ldc 137
    //   1517: ldc_w 594
    //   1520: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1523: aload_0
    //   1524: aload_2
    //   1525: iconst_1
    //   1526: invokespecial 234	com/tencent/smtt/sdk/ao:g	(Landroid/content/Context;Z)V
    //   1529: aload_1
    //   1530: invokestatic 598	com/tencent/smtt/sdk/ah:b	(Landroid/content/Context;)Ljava/io/File;
    //   1533: astore 16
    //   1535: aload 16
    //   1537: ifnull +38 -> 1575
    //   1540: aload 16
    //   1542: invokevirtual 546	java/io/File:exists	()Z
    //   1545: ifeq +30 -> 1575
    //   1548: aload_2
    //   1549: invokestatic 601	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1552: ifeq +178 -> 1730
    //   1555: ldc_w 603
    //   1558: astore 14
    //   1560: new 182	java/io/File
    //   1563: dup
    //   1564: aload 16
    //   1566: aload 14
    //   1568: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1571: aload_2
    //   1572: invokestatic 606	com/tencent/smtt/sdk/ah:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1575: aload_2
    //   1576: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1579: iload_3
    //   1580: iconst_1
    //   1581: invokevirtual 516	com/tencent/smtt/sdk/aj:a	(II)V
    //   1584: aload_0
    //   1585: getfield 118	com/tencent/smtt/sdk/ao:k	Z
    //   1588: ifeq +150 -> 1738
    //   1591: aload_2
    //   1592: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1595: sipush 220
    //   1598: ldc_w 608
    //   1601: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1604: aload_1
    //   1605: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1608: sipush -533
    //   1611: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1614: ldc 137
    //   1616: ldc_w 610
    //   1619: iload_3
    //   1620: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1623: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1626: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1629: getstatic 404	android/os/Build$VERSION:SDK_INT	I
    //   1632: bipush 11
    //   1634: if_icmplt +147 -> 1781
    //   1637: aload_2
    //   1638: ldc_w 406
    //   1641: iconst_4
    //   1642: invokevirtual 410	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1645: astore 14
    //   1647: aload 14
    //   1649: invokeinterface 614 1 0
    //   1654: astore 14
    //   1656: aload 14
    //   1658: ldc_w 616
    //   1661: iconst_0
    //   1662: invokeinterface 622 3 0
    //   1667: pop
    //   1668: aload 14
    //   1670: ldc_w 624
    //   1673: iconst_0
    //   1674: invokeinterface 622 3 0
    //   1679: pop
    //   1680: aload 14
    //   1682: ldc_w 626
    //   1685: iload_3
    //   1686: invokeinterface 622 3 0
    //   1691: pop
    //   1692: aload 14
    //   1694: invokeinterface 629 1 0
    //   1699: pop
    //   1700: aload_2
    //   1701: invokestatic 630	com/tencent/smtt/utils/y:a	(Landroid/content/Context;)Z
    //   1704: pop
    //   1705: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1708: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1711: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   1714: invokeinterface 459 1 0
    //   1719: aload_0
    //   1720: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1723: ldc_w 384
    //   1726: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1729: return
    //   1730: ldc_w 632
    //   1733: astore 14
    //   1735: goto -175 -> 1560
    //   1738: aload_2
    //   1739: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1742: sipush 220
    //   1745: ldc_w 634
    //   1748: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1751: goto -147 -> 1604
    //   1754: astore_1
    //   1755: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1758: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1761: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   1764: invokeinterface 459 1 0
    //   1769: aload_0
    //   1770: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1773: ldc_w 384
    //   1776: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1779: aload_1
    //   1780: athrow
    //   1781: aload_2
    //   1782: ldc_w 406
    //   1785: iconst_0
    //   1786: invokevirtual 410	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1789: astore 14
    //   1791: goto -144 -> 1647
    //   1794: astore 14
    //   1796: ldc 137
    //   1798: new 162	java/lang/StringBuilder
    //   1801: dup
    //   1802: ldc_w 636
    //   1805: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1808: aload 14
    //   1810: invokestatic 642	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1813: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1816: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1819: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1822: goto -122 -> 1700
    //   1825: ldc 137
    //   1827: ldc_w 644
    //   1830: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1833: aload_2
    //   1834: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1837: iload_3
    //   1838: iconst_2
    //   1839: invokevirtual 516	com/tencent/smtt/sdk/aj:a	(II)V
    //   1842: aload 15
    //   1844: iconst_0
    //   1845: invokestatic 153	com/tencent/smtt/utils/k:a	(Ljava/io/File;Z)V
    //   1848: aload_1
    //   1849: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1852: sipush -534
    //   1855: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1858: aload_2
    //   1859: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1862: sipush 212
    //   1865: ldc_w 646
    //   1868: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1871: goto -166 -> 1705
    //   1874: aload 16
    //   1876: ifnonnull +26 -> 1902
    //   1879: aload_2
    //   1880: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1883: sipush 213
    //   1886: ldc_w 648
    //   1889: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1892: aload_1
    //   1893: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1896: sipush -535
    //   1899: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1902: aload 15
    //   1904: ifnonnull -199 -> 1705
    //   1907: aload_2
    //   1908: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1911: sipush 214
    //   1914: ldc_w 650
    //   1917: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1920: aload_1
    //   1921: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1924: sipush -536
    //   1927: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1930: goto -225 -> 1705
    //   1933: astore_1
    //   1934: ldc 137
    //   1936: new 162	java/lang/StringBuilder
    //   1939: dup
    //   1940: ldc_w 652
    //   1943: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1946: aload_1
    //   1947: invokevirtual 655	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1950: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1953: ldc_w 657
    //   1956: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1959: aload_1
    //   1960: invokevirtual 661	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   1963: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1966: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1969: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1972: goto -621 -> 1351
    //   1975: aload_0
    //   1976: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1979: aload_1
    //   1980: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1983: sipush -538
    //   1986: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1989: ldc_w 384
    //   1992: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1995: return
    //   1996: astore 16
    //   1998: goto -698 -> 1300
    //   2001: astore 14
    //   2003: goto -692 -> 1311
    //   2006: astore 14
    //   2008: goto -718 -> 1290
    //   2011: astore 16
    //   2013: goto -755 -> 1258
    //   2016: astore 17
    //   2018: aload 16
    //   2020: astore 17
    //   2022: goto -764 -> 1258
    //   2025: iconst_1
    //   2026: istore 9
    //   2028: goto -601 -> 1427
    //   2031: aload 16
    //   2033: astore 14
    //   2035: iload 5
    //   2037: istore 4
    //   2039: goto -1022 -> 1017
    //   2042: iload 4
    //   2044: ifle +12 -> 2056
    //   2047: iload_3
    //   2048: iload 4
    //   2050: if_icmple +6 -> 2056
    //   2053: goto -1661 -> 392
    //   2056: iload 5
    //   2058: istore 4
    //   2060: iload 5
    //   2062: iconst_3
    //   2063: if_icmpne -1646 -> 417
    //   2066: iload 5
    //   2068: istore 4
    //   2070: iload 6
    //   2072: ifle -1655 -> 417
    //   2075: iload_3
    //   2076: iload 6
    //   2078: if_icmpgt -1678 -> 400
    //   2081: iload 5
    //   2083: istore 4
    //   2085: iload_3
    //   2086: ldc_w 662
    //   2089: if_icmpne -1672 -> 417
    //   2092: goto -1692 -> 400
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2095	0	this	ao
    //   0	2095	1	paramContext1	Context
    //   0	2095	2	paramContext2	Context
    //   0	2095	3	paramInt	int
    //   212	1872	4	i1	int
    //   224	1858	5	i2	int
    //   283	1796	6	i3	int
    //   376	11	7	i4	int
    //   170	1065	8	bool1	boolean
    //   1047	980	9	bool2	boolean
    //   427	370	10	l1	long
    //   436	41	12	l2	long
    //   62	1094	14	localObject1	Object
    //   1253	1	14	localException1	Exception
    //   1256	3	14	localObject2	Object
    //   1284	23	14	localObject3	Object
    //   1309	10	14	localException2	Exception
    //   1558	232	14	localObject4	Object
    //   1794	15	14	localThrowable	Throwable
    //   2001	1	14	localException3	Exception
    //   2006	1	14	localObject5	Object
    //   2033	1	14	localObject6	Object
    //   200	1703	15	localObject7	Object
    //   681	377	16	localObject8	Object
    //   1248	1	16	localIOException1	java.io.IOException
    //   1260	1	16	localObject9	Object
    //   1279	1	16	localIOException2	java.io.IOException
    //   1288	587	16	localObject10	Object
    //   1996	1	16	localIOException3	java.io.IOException
    //   2011	21	16	localException4	Exception
    //   933	459	17	localObject11	Object
    //   2016	1	17	localException5	Exception
    //   2020	1	17	localException6	Exception
    //   930	487	18	str1	String
    //   1168	238	19	str2	String
    // Exception table:
    //   from	to	target	type
    //   1012	1017	1248	java/io/IOException
    //   935	958	1253	java/lang/Exception
    //   1271	1276	1279	java/io/IOException
    //   935	958	1284	finally
    //   958	984	1284	finally
    //   718	781	1309	java/lang/Exception
    //   781	808	1309	java/lang/Exception
    //   813	865	1309	java/lang/Exception
    //   1012	1017	1309	java/lang/Exception
    //   1022	1039	1309	java/lang/Exception
    //   1049	1057	1309	java/lang/Exception
    //   1068	1082	1309	java/lang/Exception
    //   1086	1100	1309	java/lang/Exception
    //   1104	1118	1309	java/lang/Exception
    //   1122	1130	1309	java/lang/Exception
    //   1134	1223	1309	java/lang/Exception
    //   1271	1276	1309	java/lang/Exception
    //   1295	1300	1309	java/lang/Exception
    //   1300	1309	1309	java/lang/Exception
    //   1379	1427	1309	java/lang/Exception
    //   1427	1443	1309	java/lang/Exception
    //   1453	1490	1309	java/lang/Exception
    //   1515	1535	1309	java/lang/Exception
    //   1540	1555	1309	java/lang/Exception
    //   1560	1575	1309	java/lang/Exception
    //   1575	1604	1309	java/lang/Exception
    //   1604	1647	1309	java/lang/Exception
    //   1647	1700	1309	java/lang/Exception
    //   1700	1705	1309	java/lang/Exception
    //   1738	1751	1309	java/lang/Exception
    //   1781	1791	1309	java/lang/Exception
    //   1796	1822	1309	java/lang/Exception
    //   1825	1871	1309	java/lang/Exception
    //   1879	1902	1309	java/lang/Exception
    //   1907	1930	1309	java/lang/Exception
    //   202	226	1754	finally
    //   232	253	1754	finally
    //   278	301	1754	finally
    //   307	344	1754	finally
    //   369	378	1754	finally
    //   392	397	1754	finally
    //   403	417	1754	finally
    //   417	487	1754	finally
    //   517	540	1754	finally
    //   540	566	1754	finally
    //   596	608	1754	finally
    //   614	637	1754	finally
    //   662	676	1754	finally
    //   676	704	1754	finally
    //   718	781	1754	finally
    //   781	808	1754	finally
    //   813	865	1754	finally
    //   890	898	1754	finally
    //   905	913	1754	finally
    //   1012	1017	1754	finally
    //   1022	1039	1754	finally
    //   1049	1057	1754	finally
    //   1068	1082	1754	finally
    //   1086	1100	1754	finally
    //   1104	1118	1754	finally
    //   1122	1130	1754	finally
    //   1134	1223	1754	finally
    //   1271	1276	1754	finally
    //   1295	1300	1754	finally
    //   1300	1309	1754	finally
    //   1311	1336	1754	finally
    //   1336	1351	1754	finally
    //   1379	1427	1754	finally
    //   1427	1443	1754	finally
    //   1453	1490	1754	finally
    //   1515	1535	1754	finally
    //   1540	1555	1754	finally
    //   1560	1575	1754	finally
    //   1575	1604	1754	finally
    //   1604	1647	1754	finally
    //   1647	1700	1754	finally
    //   1700	1705	1754	finally
    //   1738	1751	1754	finally
    //   1781	1791	1754	finally
    //   1796	1822	1754	finally
    //   1825	1871	1754	finally
    //   1879	1902	1754	finally
    //   1907	1930	1754	finally
    //   1934	1972	1754	finally
    //   1647	1700	1794	java/lang/Throwable
    //   1336	1351	1933	java/lang/Exception
    //   1295	1300	1996	java/io/IOException
    //   202	226	2001	java/lang/Exception
    //   232	253	2001	java/lang/Exception
    //   278	301	2001	java/lang/Exception
    //   307	344	2001	java/lang/Exception
    //   369	378	2001	java/lang/Exception
    //   392	397	2001	java/lang/Exception
    //   403	417	2001	java/lang/Exception
    //   417	487	2001	java/lang/Exception
    //   517	540	2001	java/lang/Exception
    //   540	566	2001	java/lang/Exception
    //   596	608	2001	java/lang/Exception
    //   614	637	2001	java/lang/Exception
    //   662	676	2001	java/lang/Exception
    //   676	704	2001	java/lang/Exception
    //   890	898	2001	java/lang/Exception
    //   905	913	2001	java/lang/Exception
    //   984	991	2006	finally
    //   958	984	2011	java/lang/Exception
    //   984	991	2016	java/lang/Exception
  }
  
  private boolean a(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(139305);
    boolean bool = a(paramContext, paramFile, false);
    AppMethodBeat.o(139305);
    return bool;
  }
  
  /* Error */
  private boolean a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: ldc_w 678
    //   6: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 137
    //   11: ldc_w 680
    //   14: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_2
    //   18: invokestatic 682	com/tencent/smtt/utils/k:c	(Ljava/io/File;)Z
    //   21: ifne +34 -> 55
    //   24: aload_1
    //   25: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   28: sipush 204
    //   31: ldc_w 684
    //   34: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   37: aload_1
    //   38: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   41: sipush -520
    //   44: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   47: ldc_w 678
    //   50: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: iconst_0
    //   54: ireturn
    //   55: aload_1
    //   56: ldc_w 286
    //   59: iconst_0
    //   60: invokevirtual 290	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   63: astore 8
    //   65: iload_3
    //   66: ifeq +85 -> 151
    //   69: new 182	java/io/File
    //   72: dup
    //   73: aload 8
    //   75: ldc_w 686
    //   78: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   81: astore 8
    //   83: aload 8
    //   85: invokevirtual 546	java/io/File:exists	()Z
    //   88: ifeq +15 -> 103
    //   91: aload_1
    //   92: invokestatic 501	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   95: ifne +8 -> 103
    //   98: aload 8
    //   100: invokestatic 687	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   103: iload_3
    //   104: ifeq +95 -> 199
    //   107: aload_0
    //   108: aload_1
    //   109: iconst_2
    //   110: invokevirtual 160	com/tencent/smtt/sdk/ao:f	(Landroid/content/Context;I)Ljava/io/File;
    //   113: astore 8
    //   115: aload 8
    //   117: ifnonnull +93 -> 210
    //   120: aload_1
    //   121: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   124: sipush 205
    //   127: ldc_w 689
    //   130: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   133: aload_1
    //   134: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   137: sipush -521
    //   140: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   143: ldc_w 678
    //   146: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: iconst_0
    //   150: ireturn
    //   151: new 182	java/io/File
    //   154: dup
    //   155: aload 8
    //   157: ldc_w 292
    //   160: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   163: astore 8
    //   165: goto -82 -> 83
    //   168: astore 8
    //   170: ldc 137
    //   172: new 162	java/lang/StringBuilder
    //   175: dup
    //   176: ldc_w 691
    //   179: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: aload 8
    //   184: invokestatic 642	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   187: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: goto -93 -> 103
    //   199: aload_0
    //   200: aload_1
    //   201: iconst_0
    //   202: invokevirtual 160	com/tencent/smtt/sdk/ao:f	(Landroid/content/Context;I)Ljava/io/File;
    //   205: astore 8
    //   207: goto -92 -> 115
    //   210: aload 8
    //   212: invokestatic 693	com/tencent/smtt/utils/k:a	(Ljava/io/File;)Z
    //   215: pop
    //   216: iload_3
    //   217: ifeq +9 -> 226
    //   220: aload 8
    //   222: iconst_1
    //   223: invokestatic 153	com/tencent/smtt/utils/k:a	(Ljava/io/File;Z)V
    //   226: aload_2
    //   227: aload 8
    //   229: invokestatic 696	com/tencent/smtt/utils/k:a	(Ljava/io/File;Ljava/io/File;)Z
    //   232: istore 7
    //   234: iload 7
    //   236: istore 6
    //   238: iload 7
    //   240: ifeq +12 -> 252
    //   243: aload_0
    //   244: aload 8
    //   246: aload_1
    //   247: invokespecial 699	com/tencent/smtt/sdk/ao:a	(Ljava/io/File;Landroid/content/Context;)Z
    //   250: istore 6
    //   252: iload_3
    //   253: ifeq +81 -> 334
    //   256: aload 8
    //   258: invokevirtual 703	java/io/File:list	()[Ljava/lang/String;
    //   261: astore_2
    //   262: iconst_0
    //   263: istore 4
    //   265: iload 4
    //   267: aload_2
    //   268: arraylength
    //   269: if_icmpge +47 -> 316
    //   272: new 182	java/io/File
    //   275: dup
    //   276: aload 8
    //   278: aload_2
    //   279: iload 4
    //   281: aaload
    //   282: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   285: astore 9
    //   287: aload 9
    //   289: invokevirtual 553	java/io/File:getName	()Ljava/lang/String;
    //   292: ldc_w 555
    //   295: invokevirtual 559	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   298: ifeq +9 -> 307
    //   301: aload 9
    //   303: invokevirtual 277	java/io/File:delete	()Z
    //   306: pop
    //   307: iload 4
    //   309: iconst_1
    //   310: iadd
    //   311: istore 4
    //   313: goto -48 -> 265
    //   316: new 182	java/io/File
    //   319: dup
    //   320: aload_1
    //   321: invokestatic 706	com/tencent/smtt/sdk/ao:s	(Landroid/content/Context;)Ljava/io/File;
    //   324: ldc_w 708
    //   327: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   330: invokevirtual 277	java/io/File:delete	()Z
    //   333: pop
    //   334: iload 6
    //   336: ifne +61 -> 397
    //   339: aload 8
    //   341: invokestatic 687	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   344: aload_1
    //   345: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   348: sipush -522
    //   351: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   354: ldc 137
    //   356: new 162	java/lang/StringBuilder
    //   359: dup
    //   360: ldc_w 710
    //   363: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   366: aload 8
    //   368: invokevirtual 546	java/io/File:exists	()Z
    //   371: invokevirtual 713	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   374: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: ldc 137
    //   382: ldc_w 715
    //   385: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: ldc_w 678
    //   391: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: iload 6
    //   396: ireturn
    //   397: aload_0
    //   398: aload_1
    //   399: iconst_1
    //   400: invokespecial 234	com/tencent/smtt/sdk/ao:g	(Landroid/content/Context;Z)V
    //   403: iload_3
    //   404: ifeq -24 -> 380
    //   407: aload_0
    //   408: aload_1
    //   409: invokevirtual 514	com/tencent/smtt/sdk/ao:p	(Landroid/content/Context;)Ljava/io/File;
    //   412: astore_2
    //   413: aload_2
    //   414: iconst_1
    //   415: invokestatic 153	com/tencent/smtt/utils/k:a	(Ljava/io/File;Z)V
    //   418: aload 8
    //   420: aload_2
    //   421: invokevirtual 186	java/io/File:renameTo	(Ljava/io/File;)Z
    //   424: pop
    //   425: aload_1
    //   426: invokestatic 531	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   429: goto -49 -> 380
    //   432: astore_2
    //   433: aload_1
    //   434: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   437: sipush -523
    //   440: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   443: aload_1
    //   444: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   447: sipush 206
    //   450: aload_2
    //   451: invokevirtual 718	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   454: aload 8
    //   456: ifnull +256 -> 712
    //   459: aload 8
    //   461: invokevirtual 546	java/io/File:exists	()Z
    //   464: istore_3
    //   465: iload_3
    //   466: ifeq +246 -> 712
    //   469: iload 5
    //   471: istore 4
    //   473: iload 4
    //   475: ifeq +39 -> 514
    //   478: aload 8
    //   480: ifnull +34 -> 514
    //   483: aload 8
    //   485: invokestatic 687	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   488: ldc 137
    //   490: new 162	java/lang/StringBuilder
    //   493: dup
    //   494: ldc_w 720
    //   497: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   500: aload 8
    //   502: invokevirtual 546	java/io/File:exists	()Z
    //   505: invokevirtual 713	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   508: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: ldc 137
    //   516: ldc_w 715
    //   519: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   522: ldc_w 678
    //   525: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   528: iconst_0
    //   529: ireturn
    //   530: astore_1
    //   531: ldc 137
    //   533: new 162	java/lang/StringBuilder
    //   536: dup
    //   537: ldc_w 722
    //   540: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   543: aload_1
    //   544: invokestatic 642	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   547: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: goto -42 -> 514
    //   559: astore_2
    //   560: aload_1
    //   561: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   564: sipush -523
    //   567: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   570: aload_1
    //   571: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   574: sipush 207
    //   577: aload_2
    //   578: invokevirtual 718	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   581: aload 8
    //   583: ifnull +123 -> 706
    //   586: aload 8
    //   588: invokevirtual 546	java/io/File:exists	()Z
    //   591: istore_3
    //   592: iload_3
    //   593: ifeq +113 -> 706
    //   596: iconst_1
    //   597: istore 4
    //   599: iload 4
    //   601: ifeq +39 -> 640
    //   604: aload 8
    //   606: ifnull +34 -> 640
    //   609: aload 8
    //   611: invokestatic 687	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   614: ldc 137
    //   616: new 162	java/lang/StringBuilder
    //   619: dup
    //   620: ldc_w 720
    //   623: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   626: aload 8
    //   628: invokevirtual 546	java/io/File:exists	()Z
    //   631: invokevirtual 713	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   634: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   640: ldc 137
    //   642: ldc_w 715
    //   645: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   648: ldc_w 678
    //   651: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   654: iconst_0
    //   655: ireturn
    //   656: astore_1
    //   657: ldc 137
    //   659: new 162	java/lang/StringBuilder
    //   662: dup
    //   663: ldc_w 722
    //   666: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   669: aload_1
    //   670: invokestatic 642	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   673: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   682: goto -42 -> 640
    //   685: astore_1
    //   686: ldc 137
    //   688: ldc_w 715
    //   691: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   694: ldc_w 678
    //   697: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   700: aload_1
    //   701: athrow
    //   702: astore_2
    //   703: goto -369 -> 334
    //   706: iconst_0
    //   707: istore 4
    //   709: goto -110 -> 599
    //   712: iconst_0
    //   713: istore 4
    //   715: goto -242 -> 473
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	718	0	this	ao
    //   0	718	1	paramContext	Context
    //   0	718	2	paramFile	File
    //   0	718	3	paramBoolean	boolean
    //   263	451	4	i1	int
    //   1	469	5	i2	int
    //   236	159	6	bool1	boolean
    //   232	7	7	bool2	boolean
    //   63	101	8	localFile1	File
    //   168	15	8	localThrowable	Throwable
    //   205	422	8	localFile2	File
    //   285	17	9	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   55	65	168	java/lang/Throwable
    //   69	83	168	java/lang/Throwable
    //   83	103	168	java/lang/Throwable
    //   151	165	168	java/lang/Throwable
    //   210	216	432	java/io/IOException
    //   220	226	432	java/io/IOException
    //   226	234	432	java/io/IOException
    //   243	252	432	java/io/IOException
    //   256	262	432	java/io/IOException
    //   265	307	432	java/io/IOException
    //   316	334	432	java/io/IOException
    //   339	380	432	java/io/IOException
    //   397	403	432	java/io/IOException
    //   407	429	432	java/io/IOException
    //   483	514	530	java/lang/Throwable
    //   210	216	559	java/lang/Exception
    //   220	226	559	java/lang/Exception
    //   226	234	559	java/lang/Exception
    //   243	252	559	java/lang/Exception
    //   256	262	559	java/lang/Exception
    //   265	307	559	java/lang/Exception
    //   339	380	559	java/lang/Exception
    //   397	403	559	java/lang/Exception
    //   407	429	559	java/lang/Exception
    //   609	640	656	java/lang/Throwable
    //   210	216	685	finally
    //   220	226	685	finally
    //   226	234	685	finally
    //   243	252	685	finally
    //   256	262	685	finally
    //   265	307	685	finally
    //   316	334	685	finally
    //   339	380	685	finally
    //   397	403	685	finally
    //   407	429	685	finally
    //   433	454	685	finally
    //   459	465	685	finally
    //   560	581	685	finally
    //   586	592	685	finally
    //   316	334	702	java/lang/Exception
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(139284);
    paramContext = new File(paramContext.getDir("tbs", 0), paramString);
    if (!paramContext.exists())
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #1");
      AppMethodBeat.o(139284);
      return false;
    }
    if (!new File(paramContext, "tbs.conf").exists())
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #2");
      AppMethodBeat.o(139284);
      return false;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #3");
    AppMethodBeat.o(139284);
    return true;
  }
  
  /* Error */
  private boolean a(File paramFile, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc_w 730
    //   6: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 137
    //   11: new 162	java/lang/StringBuilder
    //   14: dup
    //   15: ldc_w 732
    //   18: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: aload_1
    //   22: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc_w 734
    //   28: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_2
    //   32: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: new 182	java/io/File
    //   44: dup
    //   45: aload_1
    //   46: ldc_w 543
    //   49: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   52: astore_2
    //   53: new 302	java/util/Properties
    //   56: dup
    //   57: invokespecial 303	java/util/Properties:<init>	()V
    //   60: astore 6
    //   62: aload_2
    //   63: invokevirtual 546	java/io/File:exists	()Z
    //   66: ifeq +239 -> 305
    //   69: new 305	java/io/BufferedInputStream
    //   72: dup
    //   73: new 307	java/io/FileInputStream
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 313	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore_2
    //   85: aload 6
    //   87: aload_2
    //   88: invokevirtual 316	java/util/Properties:load	(Ljava/io/InputStream;)V
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
    //   111: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   114: iload 5
    //   116: istore 4
    //   118: aload 6
    //   120: astore_2
    //   121: ldc 137
    //   123: ldc_w 736
    //   126: iload 4
    //   128: invokestatic 193	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   131: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   134: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: iload 4
    //   139: ifeq +382 -> 521
    //   142: aload_1
    //   143: invokevirtual 550	java/io/File:listFiles	()[Ljava/io/File;
    //   146: astore_1
    //   147: iconst_0
    //   148: istore_3
    //   149: iload_3
    //   150: aload_1
    //   151: arraylength
    //   152: if_icmpge +369 -> 521
    //   155: aload_1
    //   156: iload_3
    //   157: aaload
    //   158: astore 6
    //   160: ldc_w 543
    //   163: aload 6
    //   165: invokevirtual 553	java/io/File:getName	()Ljava/lang/String;
    //   168: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifne +127 -> 298
    //   174: aload 6
    //   176: invokevirtual 553	java/io/File:getName	()Ljava/lang/String;
    //   179: ldc_w 555
    //   182: invokevirtual 559	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   185: ifne +113 -> 298
    //   188: ldc_w 300
    //   191: aload 6
    //   193: invokevirtual 553	java/io/File:getName	()Ljava/lang/String;
    //   196: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifne +99 -> 298
    //   202: aload 6
    //   204: invokevirtual 562	java/io/File:isDirectory	()Z
    //   207: ifne +91 -> 298
    //   210: aload 6
    //   212: invokevirtual 553	java/io/File:getName	()Ljava/lang/String;
    //   215: ldc_w 564
    //   218: invokevirtual 559	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   221: ifne +77 -> 298
    //   224: aload 6
    //   226: invokestatic 569	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   229: astore 7
    //   231: aload_2
    //   232: aload 6
    //   234: invokevirtual 553	java/io/File:getName	()Ljava/lang/String;
    //   237: ldc_w 571
    //   240: invokevirtual 575	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   243: astore 8
    //   245: aload 8
    //   247: ldc_w 571
    //   250: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   253: ifne +111 -> 364
    //   256: aload 8
    //   258: aload 7
    //   260: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   263: ifeq +101 -> 364
    //   266: ldc 137
    //   268: new 162	java/lang/StringBuilder
    //   271: dup
    //   272: ldc_w 577
    //   275: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   278: aload 6
    //   280: invokevirtual 553	java/io/File:getName	()Ljava/lang/String;
    //   283: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc_w 579
    //   289: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: iload_3
    //   299: iconst_1
    //   300: iadd
    //   301: istore_3
    //   302: goto -153 -> 149
    //   305: aconst_null
    //   306: astore 7
    //   308: iconst_0
    //   309: istore 5
    //   311: goto -214 -> 97
    //   314: astore_2
    //   315: aconst_null
    //   316: astore_2
    //   317: aconst_null
    //   318: astore 6
    //   320: aload 6
    //   322: ifnull +205 -> 527
    //   325: aload 6
    //   327: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   330: iconst_1
    //   331: istore 4
    //   333: goto -212 -> 121
    //   336: astore 6
    //   338: iconst_1
    //   339: istore 4
    //   341: goto -220 -> 121
    //   344: astore_1
    //   345: aload 7
    //   347: astore_2
    //   348: aload_2
    //   349: ifnull +7 -> 356
    //   352: aload_2
    //   353: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   356: ldc_w 730
    //   359: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   362: aload_1
    //   363: athrow
    //   364: ldc 137
    //   366: new 162	java/lang/StringBuilder
    //   369: dup
    //   370: ldc_w 582
    //   373: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   376: aload 6
    //   378: invokevirtual 553	java/io/File:getName	()Ljava/lang/String;
    //   381: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc_w 584
    //   387: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 8
    //   392: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: ldc_w 586
    //   398: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload 7
    //   403: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: iconst_0
    //   413: istore 5
    //   415: ldc 137
    //   417: ldc_w 738
    //   420: iload 5
    //   422: invokestatic 193	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   425: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   428: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: iload 4
    //   433: ifeq +24 -> 457
    //   436: iload 5
    //   438: ifne +19 -> 457
    //   441: ldc 137
    //   443: ldc_w 740
    //   446: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   449: ldc_w 730
    //   452: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   455: iconst_0
    //   456: ireturn
    //   457: ldc 137
    //   459: ldc_w 742
    //   462: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: ldc_w 730
    //   468: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   471: iconst_1
    //   472: ireturn
    //   473: astore_2
    //   474: aload 6
    //   476: astore_2
    //   477: iload 5
    //   479: istore 4
    //   481: goto -360 -> 121
    //   484: astore_2
    //   485: goto -129 -> 356
    //   488: astore_1
    //   489: goto -141 -> 348
    //   492: astore_2
    //   493: aconst_null
    //   494: astore 7
    //   496: aload 6
    //   498: astore_2
    //   499: aload 7
    //   501: astore 6
    //   503: goto -183 -> 320
    //   506: astore 7
    //   508: aload_2
    //   509: astore 7
    //   511: aload 6
    //   513: astore_2
    //   514: aload 7
    //   516: astore 6
    //   518: goto -198 -> 320
    //   521: iconst_1
    //   522: istore 5
    //   524: goto -109 -> 415
    //   527: iconst_1
    //   528: istore 4
    //   530: goto -409 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	this	ao
    //   0	533	1	paramFile	File
    //   0	533	2	paramContext	Context
    //   148	154	3	i1	int
    //   102	427	4	bool1	boolean
    //   92	431	5	bool2	boolean
    //   60	266	6	localProperties	java.util.Properties
    //   336	161	6	localIOException	java.io.IOException
    //   501	16	6	localObject1	Object
    //   1	499	7	localObject2	Object
    //   506	1	7	localException	Exception
    //   509	6	7	localContext	Context
    //   243	148	8	str	String
    // Exception table:
    //   from	to	target	type
    //   41	62	314	java/lang/Exception
    //   325	330	336	java/io/IOException
    //   41	62	344	finally
    //   62	85	344	finally
    //   109	114	473	java/io/IOException
    //   352	356	484	java/io/IOException
    //   85	91	488	finally
    //   62	85	492	java/lang/Exception
    //   85	91	506	java/lang/Exception
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private void b(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: ldc_w 743
    //   6: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   13: sipush -501
    //   16: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 394	com/tencent/smtt/sdk/ao:c	(Landroid/content/Context;)Z
    //   24: ifeq +29 -> 53
    //   27: ldc 137
    //   29: ldc_w 745
    //   32: iconst_1
    //   33: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   36: aload_1
    //   37: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   40: sipush -502
    //   43: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   46: ldc_w 743
    //   49: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: ldc 137
    //   55: ldc_w 747
    //   58: aload_2
    //   59: invokestatic 750	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   62: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: ldc 137
    //   70: ldc_w 752
    //   73: iload_3
    //   74: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   77: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   80: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: ldc 137
    //   85: new 162	java/lang/StringBuilder
    //   88: dup
    //   89: ldc_w 754
    //   92: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload_1
    //   96: invokevirtual 209	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   99: getfield 757	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   102: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: ldc 137
    //   113: new 162	java/lang/StringBuilder
    //   116: dup
    //   117: ldc_w 759
    //   120: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: invokestatic 764	android/os/Process:myPid	()I
    //   126: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: ldc 137
    //   137: new 162	java/lang/StringBuilder
    //   140: dup
    //   141: ldc_w 766
    //   144: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: invokestatic 772	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   150: invokevirtual 773	java/lang/Thread:getName	()Ljava/lang/String;
    //   153: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: getstatic 404	android/os/Build$VERSION:SDK_INT	I
    //   165: bipush 11
    //   167: if_icmplt +73 -> 240
    //   170: aload_1
    //   171: ldc_w 406
    //   174: iconst_4
    //   175: invokevirtual 410	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   178: astore 14
    //   180: aload 14
    //   182: ldc_w 412
    //   185: iconst_m1
    //   186: invokeinterface 418 3 0
    //   191: iload_3
    //   192: if_icmpne +61 -> 253
    //   195: ldc 137
    //   197: new 162	java/lang/StringBuilder
    //   200: dup
    //   201: ldc_w 775
    //   204: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   207: iload_3
    //   208: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: ldc_w 425
    //   214: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_1
    //   224: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   227: sipush -503
    //   230: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   233: ldc_w 743
    //   236: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: return
    //   240: aload_1
    //   241: ldc_w 406
    //   244: iconst_0
    //   245: invokevirtual 410	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   248: astore 14
    //   250: goto -70 -> 180
    //   253: aload_1
    //   254: invokestatic 477	com/tencent/smtt/utils/k:b	(Landroid/content/Context;)Z
    //   257: ifne +73 -> 330
    //   260: invokestatic 482	com/tencent/smtt/utils/y:a	()J
    //   263: lstore 9
    //   265: aload_1
    //   266: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   269: invokevirtual 485	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   272: lstore 11
    //   274: aload_1
    //   275: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   278: sipush -504
    //   281: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   284: aload_1
    //   285: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   288: sipush 210
    //   291: new 162	java/lang/StringBuilder
    //   294: dup
    //   295: ldc_w 777
    //   298: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   301: lload 9
    //   303: invokevirtual 490	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   306: ldc_w 492
    //   309: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: lload 11
    //   314: invokevirtual 490	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   317: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   323: ldc_w 743
    //   326: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: return
    //   330: aload_0
    //   331: aload_1
    //   332: invokevirtual 428	com/tencent/smtt/sdk/ao:t	(Landroid/content/Context;)Z
    //   335: ifne +20 -> 355
    //   338: aload_1
    //   339: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   342: sipush -505
    //   345: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   348: ldc_w 743
    //   351: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: return
    //   355: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   358: invokeinterface 433 1 0
    //   363: istore 13
    //   365: ldc 137
    //   367: ldc_w 779
    //   370: iload 13
    //   372: invokestatic 193	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   375: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   378: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: iload 13
    //   383: ifeq +1878 -> 2261
    //   386: aload_1
    //   387: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   390: sipush -507
    //   393: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   396: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   399: invokevirtual 438	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   402: aload_1
    //   403: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   406: ldc_w 440
    //   409: invokevirtual 443	com/tencent/smtt/sdk/aj:c	(Ljava/lang/String;)I
    //   412: istore 4
    //   414: aload_1
    //   415: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   418: invokevirtual 471	com/tencent/smtt/sdk/aj:b	()I
    //   421: istore 5
    //   423: ldc 137
    //   425: ldc_w 781
    //   428: iload 4
    //   430: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   433: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   436: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: ldc 137
    //   441: ldc_w 783
    //   444: iload 5
    //   446: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   449: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   452: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: ldc 137
    //   457: ldc_w 785
    //   460: iload_3
    //   461: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   464: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   467: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: iload 5
    //   472: ifle +1877 -> 2349
    //   475: iload_3
    //   476: iload 5
    //   478: if_icmpgt +6 -> 484
    //   481: goto +1868 -> 2349
    //   484: aload_0
    //   485: aload_1
    //   486: invokevirtual 473	com/tencent/smtt/sdk/ao:o	(Landroid/content/Context;)V
    //   489: aload_1
    //   490: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   493: invokevirtual 787	com/tencent/smtt/sdk/aj:c	()I
    //   496: istore 5
    //   498: aload_0
    //   499: aload_1
    //   500: invokevirtual 464	com/tencent/smtt/sdk/ao:i	(Landroid/content/Context;)I
    //   503: istore 6
    //   505: ldc 137
    //   507: ldc_w 789
    //   510: iload 5
    //   512: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   515: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   518: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: ldc 137
    //   523: ldc_w 791
    //   526: iload 6
    //   528: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   531: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   534: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   537: iload 5
    //   539: iflt +156 -> 695
    //   542: iload 5
    //   544: iconst_2
    //   545: if_icmpge +150 -> 695
    //   548: ldc 137
    //   550: ldc_w 793
    //   553: iconst_1
    //   554: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   557: iconst_1
    //   558: istore 4
    //   560: iload 5
    //   562: istore 6
    //   564: iload 4
    //   566: istore 5
    //   568: aload_1
    //   569: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   572: sipush -508
    //   575: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   578: ldc 137
    //   580: ldc_w 795
    //   583: iload 6
    //   585: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   588: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   591: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: iload 6
    //   596: ifgt +1156 -> 1752
    //   599: ldc 137
    //   601: ldc_w 797
    //   604: iconst_1
    //   605: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   608: aload_1
    //   609: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   612: sipush -509
    //   615: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   618: iload 5
    //   620: ifeq +157 -> 777
    //   623: aload_1
    //   624: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   627: ldc_w 799
    //   630: invokevirtual 443	com/tencent/smtt/sdk/aj:c	(Ljava/lang/String;)I
    //   633: istore 4
    //   635: iload 4
    //   637: bipush 10
    //   639: if_icmple +127 -> 766
    //   642: aload_1
    //   643: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   646: sipush 201
    //   649: ldc_w 801
    //   652: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   655: aload_0
    //   656: aload_1
    //   657: invokespecial 803	com/tencent/smtt/sdk/ao:E	(Landroid/content/Context;)V
    //   660: aload_1
    //   661: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   664: sipush -510
    //   667: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   670: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   673: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   676: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   679: invokeinterface 459 1 0
    //   684: aload_0
    //   685: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   688: ldc_w 743
    //   691: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   694: return
    //   695: iload 5
    //   697: istore 4
    //   699: iload 5
    //   701: iconst_3
    //   702: if_icmpne +46 -> 748
    //   705: iload 5
    //   707: istore 4
    //   709: iload 6
    //   711: ifle +37 -> 748
    //   714: iload_3
    //   715: iload 6
    //   717: if_icmpgt +14 -> 731
    //   720: iload 5
    //   722: istore 4
    //   724: iload_3
    //   725: ldc_w 662
    //   728: if_icmpne +20 -> 748
    //   731: iconst_m1
    //   732: istore 4
    //   734: aload_0
    //   735: aload_1
    //   736: invokevirtual 473	com/tencent/smtt/sdk/ao:o	(Landroid/content/Context;)V
    //   739: ldc 137
    //   741: ldc_w 805
    //   744: iconst_1
    //   745: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   748: iconst_0
    //   749: istore 5
    //   751: iload 4
    //   753: istore 6
    //   755: goto -187 -> 568
    //   758: astore_1
    //   759: ldc_w 743
    //   762: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   765: return
    //   766: aload_1
    //   767: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   770: iload 4
    //   772: iconst_1
    //   773: iadd
    //   774: invokevirtual 807	com/tencent/smtt/sdk/aj:b	(I)V
    //   777: aload_2
    //   778: ifnonnull +80 -> 858
    //   781: aload_1
    //   782: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   785: ldc_w 809
    //   788: invokevirtual 811	com/tencent/smtt/sdk/aj:d	(Ljava/lang/String;)Ljava/lang/String;
    //   791: astore 15
    //   793: aload 15
    //   795: astore 14
    //   797: aload 15
    //   799: ifnonnull +62 -> 861
    //   802: aload_1
    //   803: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   806: sipush 202
    //   809: ldc_w 813
    //   812: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   815: aload_1
    //   816: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   819: sipush -511
    //   822: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   825: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   828: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   831: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   834: invokeinterface 459 1 0
    //   839: aload_0
    //   840: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   843: ldc_w 743
    //   846: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   849: return
    //   850: astore_1
    //   851: ldc_w 743
    //   854: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   857: return
    //   858: aload_2
    //   859: astore 14
    //   861: ldc 137
    //   863: ldc_w 815
    //   866: aload 14
    //   868: invokestatic 750	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   871: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   874: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   877: aload_0
    //   878: aload_1
    //   879: aload 14
    //   881: invokevirtual 818	com/tencent/smtt/sdk/ao:c	(Landroid/content/Context;Ljava/lang/String;)I
    //   884: istore 8
    //   886: iload 8
    //   888: ifne +59 -> 947
    //   891: aload_1
    //   892: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   895: sipush -512
    //   898: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   901: aload_1
    //   902: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   905: sipush 203
    //   908: ldc_w 820
    //   911: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   914: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   917: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   920: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   923: invokeinterface 459 1 0
    //   928: aload_0
    //   929: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   932: ldc_w 743
    //   935: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   938: return
    //   939: astore_1
    //   940: ldc_w 743
    //   943: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   946: return
    //   947: aload_1
    //   948: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   951: ldc_w 809
    //   954: aload 14
    //   956: invokevirtual 822	com/tencent/smtt/sdk/aj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   959: aload_1
    //   960: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   963: iload 8
    //   965: iconst_0
    //   966: invokevirtual 254	com/tencent/smtt/sdk/aj:c	(II)V
    //   969: aload_1
    //   970: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   973: sipush -548
    //   976: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   979: aload_1
    //   980: invokestatic 501	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   983: ifeq +70 -> 1053
    //   986: aload_0
    //   987: aload_1
    //   988: new 182	java/io/File
    //   991: dup
    //   992: aload 14
    //   994: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   997: iconst_1
    //   998: invokespecial 677	com/tencent/smtt/sdk/ao:a	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1001: ifne +115 -> 1116
    //   1004: aload_1
    //   1005: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1008: sipush 207
    //   1011: ldc_w 824
    //   1014: getstatic 830	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_INSTALL_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   1017: invokevirtual 833	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;Lcom/tencent/smtt/sdk/TbsLogReport$EventType;)V
    //   1020: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1023: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1026: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   1029: invokeinterface 459 1 0
    //   1034: aload_0
    //   1035: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1038: ldc_w 743
    //   1041: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1044: return
    //   1045: astore_1
    //   1046: ldc_w 743
    //   1049: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1052: return
    //   1053: aload_0
    //   1054: aload_1
    //   1055: new 182	java/io/File
    //   1058: dup
    //   1059: aload 14
    //   1061: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   1064: invokespecial 835	com/tencent/smtt/sdk/ao:a	(Landroid/content/Context;Ljava/io/File;)Z
    //   1067: ifne +49 -> 1116
    //   1070: aload_1
    //   1071: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1074: sipush 207
    //   1077: ldc_w 824
    //   1080: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1083: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1086: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1089: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   1092: invokeinterface 459 1 0
    //   1097: aload_0
    //   1098: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1101: ldc_w 743
    //   1104: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1107: return
    //   1108: astore_1
    //   1109: ldc_w 743
    //   1112: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1115: return
    //   1116: iload 5
    //   1118: ifeq +142 -> 1260
    //   1121: aload_1
    //   1122: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1125: ldc_w 837
    //   1128: invokevirtual 447	com/tencent/smtt/sdk/aj:b	(Ljava/lang/String;)I
    //   1131: istore 4
    //   1133: iload 4
    //   1135: iconst_5
    //   1136: if_icmple +113 -> 1249
    //   1139: aload_1
    //   1140: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1143: sipush 223
    //   1146: ldc_w 839
    //   1149: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1152: aload_1
    //   1153: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1156: sipush -553
    //   1159: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1162: aload_0
    //   1163: aload_1
    //   1164: invokespecial 803	com/tencent/smtt/sdk/ao:E	(Landroid/content/Context;)V
    //   1167: aload_1
    //   1168: invokestatic 841	com/tencent/smtt/sdk/ah:c	(Landroid/content/Context;)V
    //   1171: aload_1
    //   1172: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1175: getfield 844	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1178: ldc_w 846
    //   1181: getstatic 852	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1184: invokeinterface 858 3 0
    //   1189: pop
    //   1190: aload_1
    //   1191: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1194: getfield 844	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1197: ldc_w 860
    //   1200: getstatic 852	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1203: invokeinterface 858 3 0
    //   1208: pop
    //   1209: aload_1
    //   1210: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1213: invokevirtual 862	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1216: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1219: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1222: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   1225: invokeinterface 459 1 0
    //   1230: aload_0
    //   1231: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1234: ldc_w 743
    //   1237: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1240: return
    //   1241: astore_1
    //   1242: ldc_w 743
    //   1245: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1248: return
    //   1249: aload_1
    //   1250: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1253: iload 4
    //   1255: iconst_1
    //   1256: iadd
    //   1257: invokevirtual 864	com/tencent/smtt/sdk/aj:d	(I)V
    //   1260: ldc 137
    //   1262: ldc_w 866
    //   1265: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1268: invokestatic 869	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	()Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1271: getfield 873	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1274: ldc_w 875
    //   1277: iconst_0
    //   1278: invokeinterface 418 3 0
    //   1283: istore 4
    //   1285: aload_0
    //   1286: aload_1
    //   1287: invokevirtual 464	com/tencent/smtt/sdk/ao:i	(Landroid/content/Context;)I
    //   1290: ifeq +357 -> 1647
    //   1293: aload_1
    //   1294: ldc_w 877
    //   1297: aconst_null
    //   1298: invokestatic 880	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1301: astore 14
    //   1303: aload 14
    //   1305: ifnull +1038 -> 2343
    //   1308: aload 14
    //   1310: instanceof 848
    //   1313: ifeq +1030 -> 2343
    //   1316: aload 14
    //   1318: checkcast 848	java/lang/Boolean
    //   1321: invokevirtual 883	java/lang/Boolean:booleanValue	()Z
    //   1324: istore 13
    //   1326: iload 13
    //   1328: ifeq +319 -> 1647
    //   1331: new 885	android/os/Bundle
    //   1334: dup
    //   1335: invokespecial 886	android/os/Bundle:<init>	()V
    //   1338: astore 14
    //   1340: aload 14
    //   1342: ldc_w 888
    //   1345: iload 4
    //   1347: invokevirtual 890	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1350: aload_1
    //   1351: invokestatic 501	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1354: ifeq +89 -> 1443
    //   1357: aload 14
    //   1359: ldc_w 892
    //   1362: aload_0
    //   1363: aload_1
    //   1364: invokevirtual 514	com/tencent/smtt/sdk/ao:p	(Landroid/content/Context;)Ljava/io/File;
    //   1367: invokevirtual 895	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1370: invokevirtual 898	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1373: aload_1
    //   1374: ldc_w 900
    //   1377: aload 14
    //   1379: invokestatic 880	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1382: astore 14
    //   1384: aload 14
    //   1386: ifnonnull +121 -> 1507
    //   1389: ldc 137
    //   1391: ldc_w 902
    //   1394: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1397: aload_1
    //   1398: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1401: sipush 222
    //   1404: ldc_w 904
    //   1407: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1410: iconst_0
    //   1411: istore 4
    //   1413: iload 4
    //   1415: ifne +232 -> 1647
    //   1418: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1421: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1424: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   1427: invokeinterface 459 1 0
    //   1432: aload_0
    //   1433: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1436: ldc_w 743
    //   1439: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1442: return
    //   1443: aload 14
    //   1445: ldc_w 892
    //   1448: aload_0
    //   1449: aload_1
    //   1450: iconst_0
    //   1451: invokevirtual 160	com/tencent/smtt/sdk/ao:f	(Landroid/content/Context;I)Ljava/io/File;
    //   1454: invokevirtual 895	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1457: invokevirtual 898	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1460: goto -87 -> 1373
    //   1463: astore_1
    //   1464: iconst_0
    //   1465: istore_3
    //   1466: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1469: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1472: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   1475: invokeinterface 459 1 0
    //   1480: aload_0
    //   1481: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1484: iload_3
    //   1485: ifeq +14 -> 1499
    //   1488: getstatic 450	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   1491: sipush 232
    //   1494: invokeinterface 455 2 0
    //   1499: ldc_w 743
    //   1502: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1505: aload_1
    //   1506: athrow
    //   1507: aload 14
    //   1509: instanceof 848
    //   1512: ifeq +55 -> 1567
    //   1515: aload 14
    //   1517: checkcast 848	java/lang/Boolean
    //   1520: invokevirtual 883	java/lang/Boolean:booleanValue	()Z
    //   1523: ifeq +17 -> 1540
    //   1526: ldc 137
    //   1528: ldc_w 906
    //   1531: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1534: iconst_1
    //   1535: istore 4
    //   1537: goto -124 -> 1413
    //   1540: ldc 137
    //   1542: ldc_w 908
    //   1545: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1548: aload_1
    //   1549: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1552: sipush 222
    //   1555: ldc_w 908
    //   1558: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1561: iconst_0
    //   1562: istore 4
    //   1564: goto -151 -> 1413
    //   1567: aload 14
    //   1569: instanceof 885
    //   1572: ifeq +9 -> 1581
    //   1575: iconst_1
    //   1576: istore 4
    //   1578: goto -165 -> 1413
    //   1581: aload 14
    //   1583: instanceof 269
    //   1586: ifeq +47 -> 1633
    //   1589: ldc 137
    //   1591: new 162	java/lang/StringBuilder
    //   1594: dup
    //   1595: ldc_w 910
    //   1598: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1601: aload 14
    //   1603: checkcast 269	java/lang/Throwable
    //   1606: invokestatic 642	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1609: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1615: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1618: aload_1
    //   1619: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1622: sipush 222
    //   1625: aload 14
    //   1627: checkcast 269	java/lang/Throwable
    //   1630: invokevirtual 718	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   1633: iconst_0
    //   1634: istore 4
    //   1636: goto -223 -> 1413
    //   1639: astore_1
    //   1640: ldc_w 743
    //   1643: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1646: return
    //   1647: ldc 137
    //   1649: ldc_w 912
    //   1652: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1655: aload_1
    //   1656: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1659: iload 8
    //   1661: iconst_1
    //   1662: invokevirtual 254	com/tencent/smtt/sdk/aj:c	(II)V
    //   1665: iload 8
    //   1667: istore 4
    //   1669: iload 6
    //   1671: iconst_2
    //   1672: if_icmpge +553 -> 2225
    //   1675: iload 5
    //   1677: ifeq +207 -> 1884
    //   1680: aload_1
    //   1681: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1684: ldc_w 914
    //   1687: invokevirtual 443	com/tencent/smtt/sdk/aj:c	(Ljava/lang/String;)I
    //   1690: istore 5
    //   1692: iload 5
    //   1694: bipush 10
    //   1696: if_icmple +177 -> 1873
    //   1699: aload_1
    //   1700: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1703: sipush 208
    //   1706: ldc_w 916
    //   1709: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1712: aload_1
    //   1713: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1716: sipush -514
    //   1719: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1722: aload_0
    //   1723: aload_1
    //   1724: invokespecial 803	com/tencent/smtt/sdk/ao:E	(Landroid/content/Context;)V
    //   1727: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1730: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1733: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   1736: invokeinterface 459 1 0
    //   1741: aload_0
    //   1742: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1745: ldc_w 743
    //   1748: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1751: return
    //   1752: aload_1
    //   1753: invokestatic 501	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1756: ifeq +103 -> 1859
    //   1759: aload_2
    //   1760: ifnonnull +80 -> 1840
    //   1763: aload_1
    //   1764: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1767: ldc_w 809
    //   1770: invokevirtual 811	com/tencent/smtt/sdk/aj:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1773: astore 15
    //   1775: aload 15
    //   1777: astore 14
    //   1779: aload 15
    //   1781: ifnonnull +62 -> 1843
    //   1784: aload_1
    //   1785: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1788: sipush 202
    //   1791: ldc_w 813
    //   1794: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1797: aload_1
    //   1798: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1801: sipush -511
    //   1804: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1807: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1810: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1813: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   1816: invokeinterface 459 1 0
    //   1821: aload_0
    //   1822: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1825: ldc_w 743
    //   1828: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1831: return
    //   1832: astore_1
    //   1833: ldc_w 743
    //   1836: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1839: return
    //   1840: aload_2
    //   1841: astore 14
    //   1843: aload_0
    //   1844: aload_1
    //   1845: new 182	java/io/File
    //   1848: dup
    //   1849: aload 14
    //   1851: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   1854: iconst_1
    //   1855: invokespecial 677	com/tencent/smtt/sdk/ao:a	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1858: pop
    //   1859: iconst_0
    //   1860: istore 4
    //   1862: goto -193 -> 1669
    //   1865: astore_1
    //   1866: ldc_w 743
    //   1869: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1872: return
    //   1873: aload_1
    //   1874: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1877: iload 5
    //   1879: iconst_1
    //   1880: iadd
    //   1881: invokevirtual 918	com/tencent/smtt/sdk/aj:a	(I)V
    //   1884: aload_1
    //   1885: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1888: sipush -549
    //   1891: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1894: aload_0
    //   1895: aload_1
    //   1896: iconst_0
    //   1897: invokespecial 921	com/tencent/smtt/sdk/ao:j	(Landroid/content/Context;I)Z
    //   1900: ifne +46 -> 1946
    //   1903: aload_1
    //   1904: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1907: sipush -515
    //   1910: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1913: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1916: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1919: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   1922: invokeinterface 459 1 0
    //   1927: aload_0
    //   1928: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1931: ldc_w 743
    //   1934: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1937: return
    //   1938: astore_1
    //   1939: ldc_w 743
    //   1942: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1945: return
    //   1946: aload_1
    //   1947: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1950: iload 4
    //   1952: iconst_2
    //   1953: invokevirtual 254	com/tencent/smtt/sdk/aj:c	(II)V
    //   1956: ldc 137
    //   1958: ldc_w 923
    //   1961: iconst_1
    //   1962: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1965: ldc 137
    //   1967: ldc_w 925
    //   1970: iload_3
    //   1971: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1974: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1977: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1980: aload_1
    //   1981: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1984: sipush -516
    //   1987: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1990: getstatic 404	android/os/Build$VERSION:SDK_INT	I
    //   1993: bipush 11
    //   1995: if_icmplt +155 -> 2150
    //   1998: aload_1
    //   1999: ldc_w 406
    //   2002: iconst_4
    //   2003: invokevirtual 410	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2006: astore 14
    //   2008: aload 14
    //   2010: invokeinterface 614 1 0
    //   2015: astore 14
    //   2017: aload 14
    //   2019: ldc_w 616
    //   2022: iconst_0
    //   2023: invokeinterface 622 3 0
    //   2028: pop
    //   2029: aload 14
    //   2031: ldc_w 624
    //   2034: iconst_0
    //   2035: invokeinterface 622 3 0
    //   2040: pop
    //   2041: aload 14
    //   2043: ldc_w 626
    //   2046: iload_3
    //   2047: invokeinterface 622 3 0
    //   2052: pop
    //   2053: aload 14
    //   2055: invokeinterface 629 1 0
    //   2060: pop
    //   2061: aload_1
    //   2062: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2065: sipush -517
    //   2068: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2071: iload_3
    //   2072: ldc_w 662
    //   2075: if_icmpne +10 -> 2085
    //   2078: aload_0
    //   2079: iload_3
    //   2080: aload_2
    //   2081: aload_1
    //   2082: invokespecial 927	com/tencent/smtt/sdk/ao:a	(ILjava/lang/String;Landroid/content/Context;)V
    //   2085: aload_0
    //   2086: getfield 118	com/tencent/smtt/sdk/ao:k	Z
    //   2089: ifeq +115 -> 2204
    //   2092: aload_1
    //   2093: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2096: aload_0
    //   2097: aload_1
    //   2098: invokespecial 930	com/tencent/smtt/sdk/ao:u	(Landroid/content/Context;)I
    //   2101: ldc_w 608
    //   2104: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2107: iload 7
    //   2109: istore_3
    //   2110: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2113: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2116: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   2119: invokeinterface 459 1 0
    //   2124: aload_0
    //   2125: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   2128: iload_3
    //   2129: ifeq +125 -> 2254
    //   2132: getstatic 450	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   2135: sipush 232
    //   2138: invokeinterface 455 2 0
    //   2143: ldc_w 743
    //   2146: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2149: return
    //   2150: aload_1
    //   2151: ldc_w 406
    //   2154: iconst_0
    //   2155: invokevirtual 410	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2158: astore 14
    //   2160: goto -152 -> 2008
    //   2163: astore 14
    //   2165: ldc 137
    //   2167: new 162	java/lang/StringBuilder
    //   2170: dup
    //   2171: ldc_w 932
    //   2174: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2177: aload 14
    //   2179: invokestatic 642	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2182: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2185: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2188: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2191: aload_1
    //   2192: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2195: sipush -518
    //   2198: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2201: goto -130 -> 2071
    //   2204: aload_1
    //   2205: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2208: aload_0
    //   2209: aload_1
    //   2210: invokespecial 930	com/tencent/smtt/sdk/ao:u	(Landroid/content/Context;)I
    //   2213: ldc_w 634
    //   2216: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2219: iload 7
    //   2221: istore_3
    //   2222: goto -112 -> 2110
    //   2225: iload 6
    //   2227: iconst_2
    //   2228: if_icmpne +110 -> 2338
    //   2231: getstatic 450	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   2234: sipush 200
    //   2237: invokeinterface 455 2 0
    //   2242: iload 7
    //   2244: istore_3
    //   2245: goto -135 -> 2110
    //   2248: astore_1
    //   2249: iconst_1
    //   2250: istore_3
    //   2251: goto -785 -> 1466
    //   2254: ldc_w 743
    //   2257: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2260: return
    //   2261: aload_1
    //   2262: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2265: sipush -519
    //   2268: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2271: aload_0
    //   2272: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   2275: ldc_w 743
    //   2278: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	2363	0	this	ao
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
    //   0: ldc_w 933
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: new 935	com/tencent/smtt/sdk/aw
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 938	com/tencent/smtt/sdk/aw:<init>	(Lcom/tencent/smtt/sdk/ao;)V
    //   15: invokevirtual 941	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   18: astore 6
    //   20: aload 6
    //   22: arraylength
    //   23: istore 4
    //   25: getstatic 404	android/os/Build$VERSION:SDK_INT	I
    //   28: bipush 16
    //   30: if_icmpge +33 -> 63
    //   33: aload_1
    //   34: invokevirtual 944	android/content/Context:getPackageName	()Ljava/lang/String;
    //   37: ifnull +26 -> 63
    //   40: aload_1
    //   41: invokevirtual 944	android/content/Context:getPackageName	()Ljava/lang/String;
    //   44: ldc_w 946
    //   47: invokevirtual 949	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   50: istore 5
    //   52: iload 5
    //   54: ifeq +9 -> 63
    //   57: ldc2_w 950
    //   60: invokestatic 955	java/lang/Thread:sleep	(J)V
    //   63: aload_1
    //   64: invokevirtual 959	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   67: astore 7
    //   69: iconst_0
    //   70: istore_3
    //   71: iload_3
    //   72: iload 4
    //   74: if_icmpge +60 -> 134
    //   77: ldc 137
    //   79: new 162	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 961
    //   86: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: aload 6
    //   91: iload_3
    //   92: aaload
    //   93: invokevirtual 895	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   96: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: new 963	dalvik/system/DexClassLoader
    //   108: dup
    //   109: aload 6
    //   111: iload_3
    //   112: aaload
    //   113: invokevirtual 895	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   116: aload_2
    //   117: invokevirtual 895	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   120: aconst_null
    //   121: aload 7
    //   123: invokespecial 966	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   126: pop
    //   127: iload_3
    //   128: iconst_1
    //   129: iadd
    //   130: istore_3
    //   131: goto -60 -> 71
    //   134: ldc_w 933
    //   137: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: iconst_1
    //   141: ireturn
    //   142: astore_2
    //   143: aload_1
    //   144: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   147: sipush 209
    //   150: aload_2
    //   151: invokevirtual 580	java/lang/Exception:toString	()Ljava/lang/String;
    //   154: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   157: ldc 137
    //   159: ldc_w 968
    //   162: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: ldc_w 933
    //   168: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: iconst_0
    //   172: ireturn
    //   173: astore 7
    //   175: goto -112 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	ao
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
    AppMethodBeat.i(139299);
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
          AppMethodBeat.o(139299);
          return 1;
        }
        paramBundle = new File(paramBundle.getString("backup_apk"));
        localObject = b.a(paramContext, true, paramBundle);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(localObject))
        {
          TbsLog.i("TbsInstaller", "tpatch sig not equals!!!" + paramBundle + "signature:" + (String)localObject);
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(241, "version=" + i2 + ",patchVersion=" + i3);
          k.b(paramBundle);
          AppMethodBeat.o(139299);
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
        k.b(new File(paramBundle));
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(i2, "tpatch fail,patch error_code=".concat(String.valueOf(i2)));
        i1 = 1;
        continue;
      }
      AppMethodBeat.o(139299);
      return i1;
      TbsLog.i("TbsInstaller", "Tpatch success!");
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(236, "");
    }
  }
  
  private boolean c(Context paramContext, File paramFile)
  {
    AppMethodBeat.i(139348);
    try
    {
      Object localObject1 = new File(paramFile, "tbs_sdk_extension_dex.jar");
      Object localObject2 = new File(paramFile, "tbs_sdk_extension_dex.dex");
      Object localObject3 = paramContext.getClassLoader();
      new DexClassLoader(((File)localObject1).getAbsolutePath(), paramFile.getAbsolutePath(), null, (ClassLoader)localObject3);
      localObject1 = g.a(paramContext, ((File)localObject2).getAbsolutePath());
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, "can not find oat command");
        AppMethodBeat.o(139348);
        return false;
      }
      paramFile = paramFile.listFiles(new ax(this));
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
      AppMethodBeat.o(139348);
      return true;
    }
    catch (Exception paramFile)
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, paramFile);
      AppMethodBeat.o(139348);
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
    //   8: ldc_w 1079
    //   11: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: ldc 137
    //   16: ldc_w 1081
    //   19: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 428	com/tencent/smtt/sdk/ao:t	(Landroid/content/Context;)Z
    //   27: istore 7
    //   29: iload 7
    //   31: ifne +16 -> 47
    //   34: ldc_w 1079
    //   37: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iload 6
    //   42: istore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_2
    //   46: ireturn
    //   47: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   50: invokevirtual 1082	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   53: istore 6
    //   55: ldc 137
    //   57: ldc_w 1084
    //   60: iload 6
    //   62: invokestatic 193	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   65: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iload 6
    //   73: ifeq +212 -> 285
    //   76: aload_1
    //   77: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   80: ldc_w 1086
    //   83: invokevirtual 447	com/tencent/smtt/sdk/aj:b	(Ljava/lang/String;)I
    //   86: istore_3
    //   87: aload_0
    //   88: iconst_0
    //   89: aload_1
    //   90: invokevirtual 1089	com/tencent/smtt/sdk/ao:a	(ZLandroid/content/Context;)I
    //   93: istore 4
    //   95: ldc 137
    //   97: ldc_w 1091
    //   100: iload_3
    //   101: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   104: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: ldc 137
    //   112: ldc_w 1093
    //   115: iload 4
    //   117: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   120: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   123: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: iload_3
    //   127: iconst_1
    //   128: if_icmpne +152 -> 280
    //   131: iload 4
    //   133: ifne +50 -> 183
    //   136: ldc 137
    //   138: ldc_w 1095
    //   141: iconst_1
    //   142: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   145: aload_0
    //   146: aload_1
    //   147: invokespecial 1098	com/tencent/smtt/sdk/ao:y	(Landroid/content/Context;)V
    //   150: iload 5
    //   152: istore_2
    //   153: iload_2
    //   154: istore 5
    //   156: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   159: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   162: iload_2
    //   163: istore 5
    //   165: aload_0
    //   166: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   169: ldc_w 1079
    //   172: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: goto -132 -> 43
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    //   183: iload_2
    //   184: ifeq +96 -> 280
    //   187: ldc 137
    //   189: ldc_w 1100
    //   192: iconst_1
    //   193: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   196: aload_0
    //   197: aload_1
    //   198: invokespecial 1098	com/tencent/smtt/sdk/ao:y	(Landroid/content/Context;)V
    //   201: iload 5
    //   203: istore_2
    //   204: goto -51 -> 153
    //   207: astore 8
    //   209: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   212: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   215: ldc_w 1079
    //   218: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload 8
    //   223: athrow
    //   224: astore 8
    //   226: iconst_0
    //   227: istore 5
    //   229: aload_1
    //   230: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   233: sipush 215
    //   236: aload 8
    //   238: invokevirtual 1101	java/lang/Throwable:toString	()Ljava/lang/String;
    //   241: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   244: aload_1
    //   245: new 162	java/lang/StringBuilder
    //   248: dup
    //   249: ldc_w 1103
    //   252: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   255: aload 8
    //   257: invokestatic 642	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   260: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 263	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
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
    //   0	290	0	this	ao
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
    //   8: ldc_w 1104
    //   11: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: ldc 137
    //   16: ldc_w 1106
    //   19: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 428	com/tencent/smtt/sdk/ao:t	(Landroid/content/Context;)Z
    //   27: istore 7
    //   29: iload 7
    //   31: ifne +16 -> 47
    //   34: ldc_w 1104
    //   37: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iload 6
    //   42: istore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_2
    //   46: ireturn
    //   47: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   50: invokevirtual 1082	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   53: istore 6
    //   55: ldc 137
    //   57: ldc_w 1108
    //   60: iload 6
    //   62: invokestatic 193	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   65: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iload 6
    //   73: ifeq +221 -> 294
    //   76: aload_1
    //   77: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   80: ldc_w 445
    //   83: invokevirtual 447	com/tencent/smtt/sdk/aj:b	(Ljava/lang/String;)I
    //   86: istore_3
    //   87: aload_0
    //   88: iconst_0
    //   89: aload_1
    //   90: invokevirtual 1089	com/tencent/smtt/sdk/ao:a	(ZLandroid/content/Context;)I
    //   93: istore 4
    //   95: ldc 137
    //   97: ldc_w 1110
    //   100: iload_3
    //   101: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   104: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   107: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: ldc 137
    //   112: ldc_w 1112
    //   115: iload 4
    //   117: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   120: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   123: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: iload_3
    //   127: iconst_1
    //   128: if_icmpne +161 -> 289
    //   131: iload 4
    //   133: ifne +50 -> 183
    //   136: ldc 137
    //   138: ldc_w 1114
    //   141: iconst_1
    //   142: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   145: aload_0
    //   146: aload_1
    //   147: invokespecial 1117	com/tencent/smtt/sdk/ao:z	(Landroid/content/Context;)V
    //   150: iload 5
    //   152: istore_2
    //   153: iload_2
    //   154: istore 5
    //   156: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   159: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   162: iload_2
    //   163: istore 5
    //   165: aload_0
    //   166: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   169: ldc_w 1104
    //   172: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: goto -132 -> 43
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    //   183: iload_2
    //   184: ifeq +105 -> 289
    //   187: ldc 137
    //   189: ldc_w 1119
    //   192: iconst_1
    //   193: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   196: aload_0
    //   197: aload_1
    //   198: invokespecial 1117	com/tencent/smtt/sdk/ao:z	(Landroid/content/Context;)V
    //   201: iload 5
    //   203: istore_2
    //   204: goto -51 -> 153
    //   207: astore 8
    //   209: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   212: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   215: ldc_w 1104
    //   218: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload 8
    //   223: athrow
    //   224: astore 8
    //   226: iconst_0
    //   227: istore 5
    //   229: aload_1
    //   230: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   233: sipush 215
    //   236: aload 8
    //   238: invokevirtual 1101	java/lang/Throwable:toString	()Ljava/lang/String;
    //   241: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   244: aload_1
    //   245: new 162	java/lang/StringBuilder
    //   248: dup
    //   249: ldc_w 1121
    //   252: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   255: aload 8
    //   257: invokestatic 642	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   260: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 263	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   269: iload 5
    //   271: istore_2
    //   272: goto -103 -> 169
    //   275: astore_1
    //   276: ldc_w 1104
    //   279: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	299	0	this	ao
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
    AppMethodBeat.i(139302);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null)
      {
        AppMethodBeat.o(139302);
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
      AppMethodBeat.o(139302);
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
    //   8: ldc_w 1135
    //   11: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_1
    //   15: ifnull +33 -> 48
    //   18: ldc 199
    //   20: aload_1
    //   21: invokevirtual 205	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   24: invokevirtual 209	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   27: getfield 215	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   30: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +15 -> 48
    //   36: aload_1
    //   37: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   40: sipush 229
    //   43: ldc 227
    //   45: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   48: ldc 137
    //   50: ldc_w 1137
    //   53: iload_2
    //   54: invokestatic 193	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   57: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   60: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: ldc 137
    //   65: ldc_w 1139
    //   68: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: aload_1
    //   73: invokevirtual 428	com/tencent/smtt/sdk/ao:t	(Landroid/content/Context;)Z
    //   76: istore 7
    //   78: iload 7
    //   80: ifne +16 -> 96
    //   83: ldc_w 1135
    //   86: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: iload 6
    //   91: istore_2
    //   92: aload_0
    //   93: monitorexit
    //   94: iload_2
    //   95: ireturn
    //   96: ldc 137
    //   98: ldc_w 1141
    //   101: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   107: invokevirtual 1082	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   110: istore 6
    //   112: ldc 137
    //   114: ldc_w 1143
    //   117: iload 6
    //   119: invokestatic 193	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   122: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   125: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: iload 6
    //   130: ifeq +176 -> 306
    //   133: aload_1
    //   134: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   137: invokevirtual 787	com/tencent/smtt/sdk/aj:c	()I
    //   140: istore_3
    //   141: ldc 137
    //   143: ldc_w 1145
    //   146: iload_3
    //   147: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   150: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   153: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload_0
    //   157: iconst_0
    //   158: aload_1
    //   159: invokevirtual 1089	com/tencent/smtt/sdk/ao:a	(ZLandroid/content/Context;)I
    //   162: istore 4
    //   164: iload_3
    //   165: iconst_2
    //   166: if_icmpne +135 -> 301
    //   169: ldc 137
    //   171: ldc_w 1147
    //   174: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: iload 4
    //   179: ifne +50 -> 229
    //   182: ldc 137
    //   184: ldc_w 1149
    //   187: iconst_0
    //   188: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   191: aload_0
    //   192: aload_1
    //   193: invokespecial 1152	com/tencent/smtt/sdk/ao:x	(Landroid/content/Context;)V
    //   196: iload 5
    //   198: istore_2
    //   199: iload_2
    //   200: istore 5
    //   202: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   205: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   208: iload_2
    //   209: istore 5
    //   211: aload_0
    //   212: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   215: ldc_w 1135
    //   218: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: goto -129 -> 92
    //   224: astore_1
    //   225: aload_0
    //   226: monitorexit
    //   227: aload_1
    //   228: athrow
    //   229: iload_2
    //   230: ifeq +71 -> 301
    //   233: ldc 137
    //   235: ldc_w 1154
    //   238: iconst_0
    //   239: invokestatic 284	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   242: aload_0
    //   243: aload_1
    //   244: invokespecial 1152	com/tencent/smtt/sdk/ao:x	(Landroid/content/Context;)V
    //   247: iload 5
    //   249: istore_2
    //   250: goto -51 -> 199
    //   253: astore 8
    //   255: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   258: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   261: ldc_w 1135
    //   264: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: aload 8
    //   269: athrow
    //   270: astore 8
    //   272: iconst_0
    //   273: istore 5
    //   275: aload_1
    //   276: ldc_w 1156
    //   279: aload 8
    //   281: invokestatic 750	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   284: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   287: invokestatic 263	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
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
    //   0	311	0	this	ao
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
    AppMethodBeat.i(139292);
    if (paramContext == null)
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(225, "setTmpFolderCoreToRead context is null");
      AppMethodBeat.o(139292);
      return;
    }
    try
    {
      File localFile = new File(paramContext.getDir("tbs", 0), "tmp_folder_core_to_read.conf");
      if (paramBoolean)
      {
        if (localFile.exists()) {
          break label127;
        }
        localFile.createNewFile();
        AppMethodBeat.o(139292);
        return;
      }
    }
    catch (Exception localException)
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(225, "setTmpFolderCoreToRead Exception message is " + localException.getMessage() + " Exception cause is " + localException.getCause());
      AppMethodBeat.o(139292);
      return;
    }
    k.b(localException);
    label127:
    AppMethodBeat.o(139292);
  }
  
  private void h(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(139298);
    TbsLog.i("TbsInstaller", "proceedTpatchStatus,result=".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      QbSdk.setTBSInstallingStatus(false);
      AppMethodBeat.o(139298);
      return;
      if (TbsDownloader.a(paramContext))
      {
        i(paramContext, 6);
      }
      else
      {
        g(paramContext, true);
        paramInt = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version", 0);
        aj.a(paramContext).b(paramInt, 1);
      }
    }
  }
  
  private void i(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(139309);
    File localFile1 = a().f(paramContext, paramInt);
    a().g(paramContext, true);
    File localFile2 = p(paramContext);
    k.a(localFile2, true);
    localFile1.renameTo(localFile2);
    TbsShareManager.b(paramContext);
    AppMethodBeat.o(139309);
  }
  
  private boolean j(Context paramContext, int paramInt)
  {
    int i3 = 0;
    AppMethodBeat.i(139310);
    TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt start - dirMode: ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    try
    {
      TbsLog.e("TbsInstaller", "doDexoptOrDexoat mode error: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(139310);
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
      AppMethodBeat.o(139310);
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
        AppMethodBeat.o(139310);
        return true;
        TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
        bool = b(paramContext, localFile);
        AppMethodBeat.o(139310);
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
      AppMethodBeat.o(139310);
      return true;
      localFile = f(paramContext, 1);
      continue;
      localFile = q(paramContext);
    }
  }
  
  static File s(Context paramContext)
  {
    AppMethodBeat.i(139341);
    paramContext = new File(paramContext.getDir("tbs", 0), "core_private");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(139341);
      return null;
    }
    AppMethodBeat.o(139341);
    return paramContext;
  }
  
  private int u(Context paramContext)
  {
    int i1 = 1;
    AppMethodBeat.i(139287);
    if (aj.a(paramContext).d() == 1) {}
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
      AppMethodBeat.o(139287);
      return 234;
      i1 = 0;
    }
    AppMethodBeat.o(139287);
    return 221;
    label57:
    if (bool)
    {
      AppMethodBeat.o(139287);
      return 233;
    }
    AppMethodBeat.o(139287);
    return 200;
  }
  
  private static boolean v(Context paramContext)
  {
    AppMethodBeat.i(139291);
    if (paramContext == null)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #1");
      AppMethodBeat.o(139291);
      return true;
    }
    try
    {
      if (new File(paramContext.getDir("tbs", 0), "tmp_folder_core_to_read.conf").exists())
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #2");
        AppMethodBeat.o(139291);
        return true;
      }
      TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #3");
      AppMethodBeat.o(139291);
      return false;
    }
    catch (Exception paramContext)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #4");
      AppMethodBeat.o(139291);
    }
    return true;
  }
  
  private boolean w(Context paramContext)
  {
    AppMethodBeat.i(139316);
    TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
    try
    {
      bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
      TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #2  enabled is ".concat(String.valueOf(bool)));
      if (!bool)
      {
        l = bz.a().a(paramContext);
        if (l != null) {
          break label88;
        }
        TbsLog.i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
        AppMethodBeat.o(139316);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        boolean bool = true;
        continue;
        l = k.f(paramContext);
      }
      label88:
      TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
      AppMethodBeat.o(139316);
    }
    return true;
  }
  
  private void x(Context paramContext)
  {
    AppMethodBeat.i(139317);
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
    if (!w(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      AppMethodBeat.o(139317);
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
        aj.a(paramContext).a(0);
        aj.a(paramContext).b(0);
        aj.a(paramContext).d(0);
        aj.a(paramContext).a("incrupdate_retry_num", 0);
        aj.a(paramContext).c(0, 3);
        aj.a(paramContext).a("");
        aj.a(paramContext).a("tpatch_num", 0);
        aj.a(paramContext).c(-1);
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
      AppMethodBeat.o(139317);
      return;
      TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
    }
  }
  
  private void y(Context paramContext)
  {
    AppMethodBeat.i(139318);
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
    if (!w(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      AppMethodBeat.o(139318);
      return;
    }
    try
    {
      A(paramContext);
      D(paramContext);
      TbsShareManager.a(paramContext);
      aj.a(paramContext).b(0, -1);
      aj.a(paramContext).a("tpatch_num", 0);
      a.set(Integer.valueOf(0));
      g(paramContext);
      AppMethodBeat.o(139318);
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
    AppMethodBeat.i(139319);
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
    if (!w(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      AppMethodBeat.o(139319);
      return;
    }
    for (;;)
    {
      try
      {
        A(paramContext);
        C(paramContext);
        TbsShareManager.a(paramContext);
        aj.a(paramContext).a(0, 3);
        aj.a(paramContext).a("tpatch_num", 0);
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
      AppMethodBeat.o(139319);
      return;
      TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is " + i1 + " getTbsCoreShareDecoupleCoreVersion is " + a().h(paramContext) + " getTbsCoreInstalledVerInNolock is " + a().i(paramContext));
    }
  }
  
  /* Error */
  int a(File paramFile)
  {
    // Byte code:
    //   0: ldc_w 1331
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: ldc 137
    //   11: ldc_w 1333
    //   14: aload_1
    //   15: invokestatic 750	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   21: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: new 182	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: ldc_w 300
    //   32: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 546	java/io/File:exists	()Z
    //   40: istore_3
    //   41: iload_3
    //   42: ifne +11 -> 53
    //   45: ldc_w 1331
    //   48: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iconst_0
    //   52: ireturn
    //   53: new 302	java/util/Properties
    //   56: dup
    //   57: invokespecial 303	java/util/Properties:<init>	()V
    //   60: astore 5
    //   62: new 305	java/io/BufferedInputStream
    //   65: dup
    //   66: new 307	java/io/FileInputStream
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   74: invokespecial 313	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   77: astore_1
    //   78: aload 5
    //   80: aload_1
    //   81: invokevirtual 316	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   84: aload_1
    //   85: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   88: aload 5
    //   90: ldc_w 1335
    //   93: invokevirtual 1336	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 4
    //   98: aload 4
    //   100: ifnonnull +15 -> 115
    //   103: aload_1
    //   104: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   107: ldc_w 1331
    //   110: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: iconst_0
    //   114: ireturn
    //   115: aload 4
    //   117: invokestatic 1339	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   120: istore_2
    //   121: aload_1
    //   122: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   125: ldc_w 1331
    //   128: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: iload_2
    //   132: ireturn
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_1
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   144: ldc_w 1331
    //   147: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: iconst_0
    //   151: ireturn
    //   152: astore_1
    //   153: aload 4
    //   155: ifnull +8 -> 163
    //   158: aload 4
    //   160: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   163: ldc_w 1331
    //   166: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	204	0	this	ao
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
    //   0: ldc_w 1340
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 1340
    //   13: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_0
    //   17: ireturn
    //   18: aconst_null
    //   19: astore 4
    //   21: new 182	java/io/File
    //   24: dup
    //   25: new 182	java/io/File
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: ldc_w 300
    //   36: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 546	java/io/File:exists	()Z
    //   44: istore_3
    //   45: iload_3
    //   46: ifne +11 -> 57
    //   49: ldc_w 1340
    //   52: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_0
    //   56: ireturn
    //   57: new 302	java/util/Properties
    //   60: dup
    //   61: invokespecial 303	java/util/Properties:<init>	()V
    //   64: astore 5
    //   66: new 305	java/io/BufferedInputStream
    //   69: dup
    //   70: new 307	java/io/FileInputStream
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   78: invokespecial 313	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: astore_1
    //   82: aload 5
    //   84: aload_1
    //   85: invokevirtual 316	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   88: aload_1
    //   89: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   92: aload 5
    //   94: ldc_w 1335
    //   97: invokevirtual 1336	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 4
    //   102: aload 4
    //   104: ifnonnull +15 -> 119
    //   107: aload_1
    //   108: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   111: ldc_w 1340
    //   114: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: iconst_0
    //   118: ireturn
    //   119: aload 4
    //   121: invokestatic 1339	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   124: istore_2
    //   125: aload_1
    //   126: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   129: ldc_w 1340
    //   132: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: iload_2
    //   136: ireturn
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   148: ldc_w 1340
    //   151: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: iconst_0
    //   155: ireturn
    //   156: astore_1
    //   157: aload 4
    //   159: ifnull +8 -> 167
    //   162: aload 4
    //   164: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   167: ldc_w 1340
    //   170: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	208	0	this	ao
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
    AppMethodBeat.i(139277);
    if ((paramBoolean) || (((Integer)a.get()).intValue() <= 0)) {
      a.set(Integer.valueOf(i(paramContext)));
    }
    int i1 = ((Integer)a.get()).intValue();
    AppMethodBeat.o(139277);
    return i1;
  }
  
  File a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(139343);
    File localFile = paramContext.getDir("tbs", 0);
    paramContext = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      TbsLog.i("TbsInstaller", "type=" + paramInt + "needMakeDir=" + paramBoolean + "folder=" + paramContext);
      paramContext = new File(localFile, paramContext);
      if (paramContext.isDirectory()) {
        break label216;
      }
      if (!paramBoolean) {
        break;
      }
      if (paramContext.mkdir()) {
        break label216;
      }
      TbsLog.i("TbsInstaller", "getCoreDir,mkdir false");
      AppMethodBeat.o(139343);
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
    AppMethodBeat.o(139343);
    return null;
    label216:
    AppMethodBeat.o(139343);
    return paramContext;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(139289);
    g(paramContext, true);
    aj.a(paramContext).c(paramInt, 2);
    AppMethodBeat.o(139289);
  }
  
  void a(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(139296);
    if ((paramBundle == null) || (paramContext == null))
    {
      AppMethodBeat.o(139296);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = new Object[] { paramContext, paramBundle };
    m.sendMessage(localMessage);
    AppMethodBeat.o(139296);
  }
  
  void a(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(139285);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=".concat(String.valueOf(paramString)));
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=".concat(String.valueOf(paramInt)));
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramContext, paramString, Integer.valueOf(paramInt) };
    m.sendMessage(localMessage);
    AppMethodBeat.o(139285);
  }
  
  void a(Context paramContext, boolean paramBoolean)
  {
    int i5 = 0;
    AppMethodBeat.i(139281);
    if (paramBoolean) {
      this.k = true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
    if (!t(paramContext))
    {
      AppMethodBeat.o(139281);
      return;
    }
    String str = null;
    if (i.tryLock()) {}
    for (;;)
    {
      try
      {
        i4 = aj.a(paramContext).c();
        i3 = aj.a(paramContext).b();
        str = aj.a(paramContext).d("install_apk_path");
        i1 = aj.a(paramContext).c("copy_core_ver");
        i2 = aj.a(paramContext).b("copy_status");
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
          AppMethodBeat.o(139281);
          return;
        }
      }
      finally
      {
        i.unlock();
        AppMethodBeat.o(139281);
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
      AppMethodBeat.o(139281);
      return;
      int i1 = 0;
      int i2 = -1;
      int i3 = 0;
      int i4 = -1;
    }
  }
  
  /* Error */
  public boolean a(Context paramContext1, Context paramContext2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1426
    //   5: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 137
    //   10: ldc_w 1428
    //   13: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: getstatic 107	com/tencent/smtt/sdk/ao:p	Z
    //   19: iconst_1
    //   20: if_icmpne +13 -> 33
    //   23: ldc_w 1426
    //   26: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iconst_1
    //   32: ireturn
    //   33: iconst_1
    //   34: putstatic 107	com/tencent/smtt/sdk/ao:p	Z
    //   37: new 1430	com/tencent/smtt/sdk/as
    //   40: dup
    //   41: aload_0
    //   42: aload_2
    //   43: aload_1
    //   44: invokespecial 1433	com/tencent/smtt/sdk/as:<init>	(Lcom/tencent/smtt/sdk/ao;Landroid/content/Context;Landroid/content/Context;)V
    //   47: invokevirtual 1436	com/tencent/smtt/sdk/as:start	()V
    //   50: ldc_w 1426
    //   53: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -27 -> 29
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	ao
    //   0	64	1	paramContext1	Context
    //   0	64	2	paramContext2	Context
    // Exception table:
    //   from	to	target	type
    //   2	29	59	finally
    //   33	56	59	finally
  }
  
  public boolean a(Context paramContext, File paramFile, int paramInt)
  {
    AppMethodBeat.i(139304);
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
    boolean bool = a(paramContext, paramFile, false);
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is ".concat(String.valueOf(bool)));
    if (bool) {
      a().a(paramContext, paramInt);
    }
    AppMethodBeat.o(139304);
    return bool;
  }
  
  Context b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(139303);
    try
    {
      if (paramContext.getPackageName() != paramString)
      {
        boolean bool = TbsPVConfig.getInstance(paramContext).isEnableNoCoreGray();
        if (bool)
        {
          AppMethodBeat.o(139303);
          return null;
        }
      }
      paramContext = paramContext.createPackageContext(paramString, 2);
      AppMethodBeat.o(139303);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(139303);
    }
    return null;
  }
  
  File b(Context paramContext1, Context paramContext2)
  {
    AppMethodBeat.i(139337);
    paramContext2 = new File(paramContext2.getDir("tbs", 0), "core_share");
    if ((!paramContext2.isDirectory()) && ((paramContext1 == null) || (!TbsShareManager.isThirdPartyApp(paramContext1))) && (!paramContext2.mkdir()))
    {
      TbsLog.i("TbsInstaller", "getTbsCoreShareDir,mkdir false");
      AppMethodBeat.o(139337);
      return null;
    }
    AppMethodBeat.o(139337);
    return paramContext2;
  }
  
  void b()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(139346);
        if (this.e <= 0)
        {
          TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock currentTbsFileLockStackCount=" + this.e + "call stack:" + Log.getStackTraceString(new Throwable()));
          AppMethodBeat.o(139346);
          return;
        }
        if (this.e > 1)
        {
          TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
          this.e -= 1;
          AppMethodBeat.o(139346);
          continue;
        }
        if (this.e != 1) {
          break label140;
        }
      }
      finally {}
      TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
      k.a(this.f, this.g);
      this.e = 0;
      label140:
      AppMethodBeat.o(139346);
    }
  }
  
  public void b(Context paramContext)
  {
    AppMethodBeat.i(139288);
    g(paramContext, true);
    aj.a(paramContext).c(h(paramContext), 2);
    AppMethodBeat.o(139288);
  }
  
  /* Error */
  void b(Context paramContext, Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 1483
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 137
    //   8: new 162	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 1485
    //   15: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: invokestatic 772	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   21: invokevirtual 773	java/lang/Thread:getName	()Ljava/lang/String;
    //   24: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: new 269	java/lang/Throwable
    //   30: dup
    //   31: invokespecial 1470	java/lang/Throwable:<init>	()V
    //   34: invokestatic 642	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   37: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 394	com/tencent/smtt/sdk/ao:c	(Landroid/content/Context;)Z
    //   51: ifeq +20 -> 71
    //   54: aload_1
    //   55: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   58: sipush -539
    //   61: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   64: ldc_w 1483
    //   67: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: return
    //   71: ldc 137
    //   73: ldc_w 1487
    //   76: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_2
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: ifnonnull +10 -> 94
    //   87: ldc_w 1483
    //   90: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: return
    //   94: aload_1
    //   95: invokestatic 477	com/tencent/smtt/utils/k:b	(Landroid/content/Context;)Z
    //   98: ifne +73 -> 171
    //   101: invokestatic 482	com/tencent/smtt/utils/y:a	()J
    //   104: lstore 7
    //   106: aload_1
    //   107: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   110: invokevirtual 485	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   113: lstore 9
    //   115: aload_1
    //   116: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   119: sipush 210
    //   122: new 162	java/lang/StringBuilder
    //   125: dup
    //   126: ldc_w 1489
    //   129: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: lload 7
    //   134: invokevirtual 490	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: ldc_w 492
    //   140: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: lload 9
    //   145: invokevirtual 490	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   148: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   154: aload_1
    //   155: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   158: sipush -540
    //   161: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   164: ldc_w 1483
    //   167: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: aload_0
    //   172: aload_1
    //   173: invokevirtual 428	com/tencent/smtt/sdk/ao:t	(Landroid/content/Context;)Z
    //   176: ifne +20 -> 196
    //   179: aload_1
    //   180: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   183: sipush -541
    //   186: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   189: ldc_w 1483
    //   192: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: return
    //   196: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   199: invokeinterface 433 1 0
    //   204: istore 11
    //   206: ldc 137
    //   208: ldc_w 1491
    //   211: iload 11
    //   213: invokestatic 193	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   216: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   219: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: iload 11
    //   224: ifeq +1713 -> 1937
    //   227: aload_1
    //   228: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   231: getfield 873	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   234: ldc_w 875
    //   237: iconst_0
    //   238: invokeinterface 418 3 0
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
    //   269: invokestatic 1176	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   272: iload 5
    //   274: iconst_5
    //   275: if_icmpne +283 -> 558
    //   278: aload 15
    //   280: astore 13
    //   282: aload 12
    //   284: astore 14
    //   286: aload_0
    //   287: aload_1
    //   288: aload_2
    //   289: invokespecial 1493	com/tencent/smtt/sdk/ao:c	(Landroid/content/Context;Landroid/os/Bundle;)I
    //   292: istore 4
    //   294: iload 4
    //   296: iconst_1
    //   297: if_icmpne +43 -> 340
    //   300: aload 18
    //   302: astore 13
    //   304: iload 4
    //   306: istore_3
    //   307: aload_1
    //   308: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   311: ldc_w 1277
    //   314: invokevirtual 443	com/tencent/smtt/sdk/aj:c	(Ljava/lang/String;)I
    //   317: istore 6
    //   319: aload 18
    //   321: astore 13
    //   323: iload 4
    //   325: istore_3
    //   326: aload_1
    //   327: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   330: ldc_w 1277
    //   333: iload 6
    //   335: iconst_1
    //   336: iadd
    //   337: invokevirtual 512	com/tencent/smtt/sdk/aj:a	(Ljava/lang/String;I)V
    //   340: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   343: invokeinterface 459 1 0
    //   348: aload_0
    //   349: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   352: iload 5
    //   354: iconst_5
    //   355: if_icmpne +17 -> 372
    //   358: aload_0
    //   359: aload_1
    //   360: iload 4
    //   362: invokespecial 1495	com/tencent/smtt/sdk/ao:h	(Landroid/content/Context;I)V
    //   365: ldc_w 1483
    //   368: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   371: return
    //   372: iload 4
    //   374: ifne +68 -> 442
    //   377: ldc 137
    //   379: ldc_w 1497
    //   382: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: aload_1
    //   386: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   389: ldc_w 1273
    //   392: iconst_0
    //   393: invokevirtual 512	com/tencent/smtt/sdk/aj:a	(Ljava/lang/String;I)V
    //   396: aload_1
    //   397: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   400: sipush -544
    //   403: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   406: aload_1
    //   407: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   410: iconst_0
    //   411: iconst_m1
    //   412: invokevirtual 254	com/tencent/smtt/sdk/aj:c	(II)V
    //   415: aload_1
    //   416: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   419: iconst_1
    //   420: invokevirtual 256	com/tencent/smtt/sdk/aj:c	(I)V
    //   423: new 1499	java/lang/NullPointerException
    //   426: dup
    //   427: invokespecial 1500	java/lang/NullPointerException:<init>	()V
    //   430: athrow
    //   431: iconst_0
    //   432: invokestatic 1176	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   435: ldc_w 1483
    //   438: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   441: return
    //   442: iload 4
    //   444: iconst_2
    //   445: if_icmpne +14 -> 459
    //   448: ldc 137
    //   450: ldc_w 1502
    //   453: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: goto -25 -> 431
    //   459: aload_1
    //   460: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   463: sipush -546
    //   466: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   469: ldc 137
    //   471: ldc_w 1504
    //   474: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: aload_1
    //   478: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   481: getfield 844	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   484: ldc_w 846
    //   487: getstatic 852	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   490: invokeinterface 858 3 0
    //   495: pop
    //   496: aload_1
    //   497: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   500: invokevirtual 862	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   503: aload_1
    //   504: invokestatic 501	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   507: ifeq +27 -> 534
    //   510: aload_1
    //   511: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   514: sipush 235
    //   517: ldc_w 1506
    //   520: iload 4
    //   522: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   525: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   528: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   531: goto -100 -> 431
    //   534: aload_1
    //   535: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   538: sipush 217
    //   541: ldc_w 1508
    //   544: iload 4
    //   546: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   549: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   552: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   555: goto -124 -> 431
    //   558: aload 15
    //   560: astore 13
    //   562: aload 12
    //   564: astore 14
    //   566: aload_0
    //   567: aload_1
    //   568: invokevirtual 464	com/tencent/smtt/sdk/ao:i	(Landroid/content/Context;)I
    //   571: ifle +22 -> 593
    //   574: aload 15
    //   576: astore 13
    //   578: aload 12
    //   580: astore 14
    //   582: aload_1
    //   583: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   586: invokevirtual 1222	com/tencent/smtt/sdk/aj:d	()I
    //   589: iconst_1
    //   590: if_icmpne +65 -> 655
    //   593: aload 15
    //   595: astore 13
    //   597: aload 12
    //   599: astore 14
    //   601: iconst_0
    //   602: invokestatic 1176	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   605: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   608: invokeinterface 459 1 0
    //   613: aload_0
    //   614: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   617: iload 5
    //   619: iconst_5
    //   620: if_icmpne +16 -> 636
    //   623: aload_0
    //   624: aload_1
    //   625: iconst_2
    //   626: invokespecial 1495	com/tencent/smtt/sdk/ao:h	(Landroid/content/Context;I)V
    //   629: ldc_w 1483
    //   632: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   635: return
    //   636: ldc 137
    //   638: ldc_w 1502
    //   641: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: iconst_0
    //   645: invokestatic 1176	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   648: ldc_w 1483
    //   651: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   684: aload 15
    //   686: astore 13
    //   688: aload 12
    //   690: astore 14
    //   692: aload_1
    //   693: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   696: ldc_w 1273
    //   699: invokevirtual 443	com/tencent/smtt/sdk/aj:c	(Ljava/lang/String;)I
    //   702: istore_3
    //   703: iload_3
    //   704: iconst_5
    //   705: if_icmple +293 -> 998
    //   708: aload 15
    //   710: astore 13
    //   712: aload 12
    //   714: astore 14
    //   716: ldc 137
    //   718: ldc_w 1510
    //   721: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   724: aload 15
    //   726: astore 13
    //   728: aload 12
    //   730: astore 14
    //   732: aload_2
    //   733: ldc_w 1512
    //   736: invokevirtual 984	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   739: astore 17
    //   741: aload 15
    //   743: astore 13
    //   745: aload 12
    //   747: astore 14
    //   749: aload_2
    //   750: ldc_w 981
    //   753: invokevirtual 984	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   756: astore 16
    //   758: aload 15
    //   760: astore 13
    //   762: aload 12
    //   764: astore 14
    //   766: aload_2
    //   767: ldc_w 1514
    //   770: invokevirtual 984	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   773: astore_2
    //   774: aload 15
    //   776: astore 13
    //   778: aload 12
    //   780: astore 14
    //   782: aload 17
    //   784: invokestatic 1022	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   787: ifne +23 -> 810
    //   790: aload 15
    //   792: astore 13
    //   794: aload 12
    //   796: astore 14
    //   798: new 182	java/io/File
    //   801: dup
    //   802: aload 17
    //   804: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   807: invokestatic 687	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   810: aload 15
    //   812: astore 13
    //   814: aload 12
    //   816: astore 14
    //   818: aload 16
    //   820: invokestatic 1022	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   823: ifne +23 -> 846
    //   826: aload 15
    //   828: astore 13
    //   830: aload 12
    //   832: astore 14
    //   834: new 182	java/io/File
    //   837: dup
    //   838: aload 16
    //   840: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   843: invokestatic 687	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   846: aload 15
    //   848: astore 13
    //   850: aload 12
    //   852: astore 14
    //   854: aload_2
    //   855: invokestatic 1022	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   858: ifne +22 -> 880
    //   861: aload 15
    //   863: astore 13
    //   865: aload 12
    //   867: astore 14
    //   869: new 182	java/io/File
    //   872: dup
    //   873: aload_2
    //   874: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   877: invokestatic 687	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   880: aload 15
    //   882: astore 13
    //   884: aload 12
    //   886: astore 14
    //   888: aload_1
    //   889: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   892: getfield 844	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   895: ldc_w 846
    //   898: getstatic 852	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   901: invokeinterface 858 3 0
    //   906: pop
    //   907: aload 15
    //   909: astore 13
    //   911: aload 12
    //   913: astore 14
    //   915: aload_1
    //   916: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   919: invokevirtual 862	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   922: aload 15
    //   924: astore 13
    //   926: aload 12
    //   928: astore 14
    //   930: aload_1
    //   931: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   934: sipush 224
    //   937: ldc_w 1516
    //   940: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   943: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   946: invokeinterface 459 1 0
    //   951: aload_0
    //   952: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   955: iload 5
    //   957: iconst_5
    //   958: if_icmpne +21 -> 979
    //   961: aload_0
    //   962: aload_1
    //   963: iconst_2
    //   964: invokespecial 1495	com/tencent/smtt/sdk/ao:h	(Landroid/content/Context;I)V
    //   967: ldc_w 1483
    //   970: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   973: return
    //   974: iconst_0
    //   975: istore_3
    //   976: goto -301 -> 675
    //   979: ldc 137
    //   981: ldc_w 1502
    //   984: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   987: iconst_0
    //   988: invokestatic 1176	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   991: ldc_w 1483
    //   994: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   997: return
    //   998: aload 15
    //   1000: astore 13
    //   1002: aload 12
    //   1004: astore 14
    //   1006: aload_1
    //   1007: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1010: ldc_w 1273
    //   1013: iload_3
    //   1014: iconst_1
    //   1015: iadd
    //   1016: invokevirtual 512	com/tencent/smtt/sdk/aj:a	(Ljava/lang/String;I)V
    //   1019: aload 15
    //   1021: astore 13
    //   1023: aload 12
    //   1025: astore 14
    //   1027: aload_1
    //   1028: invokestatic 706	com/tencent/smtt/sdk/ao:s	(Landroid/content/Context;)Ljava/io/File;
    //   1031: astore 16
    //   1033: aload 16
    //   1035: ifnull +972 -> 2007
    //   1038: aload 15
    //   1040: astore 13
    //   1042: aload 12
    //   1044: astore 14
    //   1046: new 182	java/io/File
    //   1049: dup
    //   1050: aload 16
    //   1052: ldc_w 708
    //   1055: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1058: invokevirtual 546	java/io/File:exists	()Z
    //   1061: ifeq +946 -> 2007
    //   1064: aload 15
    //   1066: astore 13
    //   1068: aload 12
    //   1070: astore 14
    //   1072: aload_1
    //   1073: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1076: sipush -550
    //   1079: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1082: aload 15
    //   1084: astore 13
    //   1086: aload 12
    //   1088: astore 14
    //   1090: aload_1
    //   1091: aload_2
    //   1092: invokestatic 973	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   1095: astore 12
    //   1097: aload 12
    //   1099: ifnonnull +79 -> 1178
    //   1102: aload 12
    //   1104: astore 13
    //   1106: aload_1
    //   1107: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1110: sipush 228
    //   1113: new 162	java/lang/StringBuilder
    //   1116: dup
    //   1117: ldc_w 1518
    //   1120: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1123: aload_2
    //   1124: ldc_w 986
    //   1127: invokevirtual 979	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1130: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1133: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1136: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1139: iconst_1
    //   1140: istore 4
    //   1142: aload 12
    //   1144: astore 13
    //   1146: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   1149: invokeinterface 459 1 0
    //   1154: aload_0
    //   1155: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1158: iload 5
    //   1160: iconst_5
    //   1161: if_icmpne +191 -> 1352
    //   1164: aload_0
    //   1165: aload_1
    //   1166: iload 4
    //   1168: invokespecial 1495	com/tencent/smtt/sdk/ao:h	(Landroid/content/Context;I)V
    //   1171: ldc_w 1483
    //   1174: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1177: return
    //   1178: aload 12
    //   1180: astore 13
    //   1182: aload 12
    //   1184: astore 14
    //   1186: aload 12
    //   1188: ldc_w 977
    //   1191: invokevirtual 979	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1194: istore_3
    //   1195: iload_3
    //   1196: istore 4
    //   1198: aload 12
    //   1200: astore 13
    //   1202: iload_3
    //   1203: ifeq -57 -> 1146
    //   1206: aload_1
    //   1207: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1210: sipush 228
    //   1213: new 162	java/lang/StringBuilder
    //   1216: dup
    //   1217: ldc_w 1520
    //   1220: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1223: iload_3
    //   1224: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1227: ldc_w 1522
    //   1230: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: aload_2
    //   1234: ldc_w 986
    //   1237: invokevirtual 979	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1240: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1243: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1246: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1249: iload_3
    //   1250: istore 4
    //   1252: aload 12
    //   1254: astore 13
    //   1256: goto -110 -> 1146
    //   1259: astore_2
    //   1260: aload 12
    //   1262: astore 13
    //   1264: ldc 137
    //   1266: new 162	java/lang/StringBuilder
    //   1269: dup
    //   1270: ldc_w 1524
    //   1273: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1276: aload_2
    //   1277: invokestatic 642	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1280: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1286: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1289: aload 12
    //   1291: astore 13
    //   1293: aload_1
    //   1294: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1297: sipush -543
    //   1300: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1303: aload 12
    //   1305: astore 13
    //   1307: aload_1
    //   1308: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1311: sipush 218
    //   1314: aload_2
    //   1315: invokevirtual 580	java/lang/Exception:toString	()Ljava/lang/String;
    //   1318: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1321: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   1324: invokeinterface 459 1 0
    //   1329: aload_0
    //   1330: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1333: iload 5
    //   1335: iconst_5
    //   1336: if_icmpne +244 -> 1580
    //   1339: aload_0
    //   1340: aload_1
    //   1341: iconst_1
    //   1342: invokespecial 1495	com/tencent/smtt/sdk/ao:h	(Landroid/content/Context;I)V
    //   1345: ldc_w 1483
    //   1348: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1351: return
    //   1352: iload 4
    //   1354: ifne +110 -> 1464
    //   1357: ldc 137
    //   1359: ldc_w 1497
    //   1362: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1365: aload_1
    //   1366: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1369: ldc_w 1273
    //   1372: iconst_0
    //   1373: invokevirtual 512	com/tencent/smtt/sdk/aj:a	(Ljava/lang/String;I)V
    //   1376: aload_1
    //   1377: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1380: sipush -544
    //   1383: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1386: aload_1
    //   1387: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1390: iconst_0
    //   1391: iconst_m1
    //   1392: invokevirtual 254	com/tencent/smtt/sdk/aj:c	(II)V
    //   1395: aload_1
    //   1396: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1399: iconst_1
    //   1400: invokevirtual 256	com/tencent/smtt/sdk/aj:c	(I)V
    //   1403: aload 13
    //   1405: ldc_w 1526
    //   1408: invokevirtual 984	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1411: astore_2
    //   1412: new 182	java/io/File
    //   1415: dup
    //   1416: aload_2
    //   1417: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   1420: aload_1
    //   1421: invokestatic 606	com/tencent/smtt/sdk/ah:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1424: aload_0
    //   1425: aload_1
    //   1426: aload_2
    //   1427: aload 13
    //   1429: ldc_w 1528
    //   1432: invokevirtual 979	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1435: invokespecial 672	com/tencent/smtt/sdk/ao:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1438: aload_1
    //   1439: invokestatic 501	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1442: ifeq +11 -> 1453
    //   1445: aload_1
    //   1446: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1449: iconst_m1
    //   1450: invokevirtual 256	com/tencent/smtt/sdk/aj:c	(I)V
    //   1453: iconst_0
    //   1454: invokestatic 1176	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1457: ldc_w 1483
    //   1460: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1463: return
    //   1464: iload 4
    //   1466: iconst_2
    //   1467: if_icmpne +14 -> 1481
    //   1470: ldc 137
    //   1472: ldc_w 1502
    //   1475: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1478: goto -25 -> 1453
    //   1481: aload_1
    //   1482: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1485: sipush -546
    //   1488: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1491: ldc 137
    //   1493: ldc_w 1504
    //   1496: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1499: aload_1
    //   1500: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1503: getfield 844	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1506: ldc_w 846
    //   1509: getstatic 852	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1512: invokeinterface 858 3 0
    //   1517: pop
    //   1518: aload_1
    //   1519: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1522: invokevirtual 862	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1525: aload_1
    //   1526: invokestatic 501	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1529: ifeq +27 -> 1556
    //   1532: aload_1
    //   1533: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1536: sipush 235
    //   1539: ldc_w 1506
    //   1542: iload 4
    //   1544: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1547: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1550: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1553: goto -100 -> 1453
    //   1556: aload_1
    //   1557: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1560: sipush 217
    //   1563: ldc_w 1508
    //   1566: iload 4
    //   1568: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1571: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1574: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1577: goto -124 -> 1453
    //   1580: aload_1
    //   1581: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1584: sipush -546
    //   1587: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1590: ldc 137
    //   1592: ldc_w 1504
    //   1595: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1598: aload_1
    //   1599: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1602: getfield 844	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1605: ldc_w 846
    //   1608: getstatic 852	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1611: invokeinterface 858 3 0
    //   1616: pop
    //   1617: aload_1
    //   1618: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1621: invokevirtual 862	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1624: aload_1
    //   1625: invokestatic 501	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1628: ifeq +27 -> 1655
    //   1631: aload_1
    //   1632: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1635: sipush 235
    //   1638: ldc_w 1530
    //   1641: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1644: iconst_0
    //   1645: invokestatic 1176	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1648: ldc_w 1483
    //   1651: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1654: return
    //   1655: aload_1
    //   1656: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1659: sipush 217
    //   1662: ldc_w 1532
    //   1665: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1668: goto -24 -> 1644
    //   1671: astore_2
    //   1672: iconst_2
    //   1673: istore_3
    //   1674: aload 13
    //   1676: astore 12
    //   1678: getstatic 51	com/tencent/smtt/sdk/ao:j	Ljava/util/concurrent/locks/Lock;
    //   1681: invokeinterface 459 1 0
    //   1686: aload_0
    //   1687: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1690: iload 5
    //   1692: iconst_5
    //   1693: if_icmpne +16 -> 1709
    //   1696: aload_0
    //   1697: aload_1
    //   1698: iload_3
    //   1699: invokespecial 1495	com/tencent/smtt/sdk/ao:h	(Landroid/content/Context;I)V
    //   1702: ldc_w 1483
    //   1705: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1708: return
    //   1709: iload_3
    //   1710: ifne +114 -> 1824
    //   1713: ldc 137
    //   1715: ldc_w 1497
    //   1718: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1721: aload_1
    //   1722: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1725: ldc_w 1273
    //   1728: iconst_0
    //   1729: invokevirtual 512	com/tencent/smtt/sdk/aj:a	(Ljava/lang/String;I)V
    //   1732: aload_1
    //   1733: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1736: sipush -544
    //   1739: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1742: aload_1
    //   1743: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1746: iconst_0
    //   1747: iconst_m1
    //   1748: invokevirtual 254	com/tencent/smtt/sdk/aj:c	(II)V
    //   1751: aload_1
    //   1752: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1755: iconst_1
    //   1756: invokevirtual 256	com/tencent/smtt/sdk/aj:c	(I)V
    //   1759: aload 12
    //   1761: ldc_w 1526
    //   1764: invokevirtual 984	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1767: astore 13
    //   1769: new 182	java/io/File
    //   1772: dup
    //   1773: aload 13
    //   1775: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   1778: aload_1
    //   1779: invokestatic 606	com/tencent/smtt/sdk/ah:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1782: aload_0
    //   1783: aload_1
    //   1784: aload 13
    //   1786: aload 12
    //   1788: ldc_w 1528
    //   1791: invokevirtual 979	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1794: invokespecial 672	com/tencent/smtt/sdk/ao:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1797: aload_1
    //   1798: invokestatic 501	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1801: ifeq +11 -> 1812
    //   1804: aload_1
    //   1805: invokestatic 251	com/tencent/smtt/sdk/aj:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/aj;
    //   1808: iconst_m1
    //   1809: invokevirtual 256	com/tencent/smtt/sdk/aj:c	(I)V
    //   1812: iconst_0
    //   1813: invokestatic 1176	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1816: ldc_w 1483
    //   1819: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1822: aload_2
    //   1823: athrow
    //   1824: iload_3
    //   1825: iconst_2
    //   1826: if_icmpne +14 -> 1840
    //   1829: ldc 137
    //   1831: ldc_w 1502
    //   1834: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1837: goto -25 -> 1812
    //   1840: aload_1
    //   1841: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1844: sipush -546
    //   1847: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1850: ldc 137
    //   1852: ldc_w 1504
    //   1855: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1858: aload_1
    //   1859: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1862: getfield 844	com/tencent/smtt/sdk/TbsDownloadConfig:a	Ljava/util/Map;
    //   1865: ldc_w 846
    //   1868: getstatic 852	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1871: invokeinterface 858 3 0
    //   1876: pop
    //   1877: aload_1
    //   1878: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1881: invokevirtual 862	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1884: aload_1
    //   1885: invokestatic 501	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1888: ifeq +26 -> 1914
    //   1891: aload_1
    //   1892: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1895: sipush 235
    //   1898: ldc_w 1506
    //   1901: iload_3
    //   1902: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1905: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1908: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1911: goto -99 -> 1812
    //   1914: aload_1
    //   1915: invokestatic 225	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1918: sipush 217
    //   1921: ldc_w 1508
    //   1924: iload_3
    //   1925: invokestatic 399	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1928: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1931: invokevirtual 231	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1934: goto -122 -> 1812
    //   1937: aload_1
    //   1938: invokestatic 389	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1941: sipush -547
    //   1944: invokevirtual 392	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1947: aload_0
    //   1948: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   1951: ldc_w 1483
    //   1954: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	2017	0	this	ao
    //   0	2017	1	paramContext	Context
    //   0	2017	2	paramBundle	Bundle
    //   306	1698	3	i1	int
    //   292	1717	4	i2	int
    //   243	1451	5	i3	int
    //   317	20	6	i4	int
    //   104	29	7	l1	long
    //   113	31	9	l2	long
    //   204	19	11	bool	boolean
    //   255	1739	12	localObject1	Object
    //   262	1751	13	localObject2	Object
    //   266	1718	14	localObject3	Object
    //   249	834	15	localObject4	Object
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
    AppMethodBeat.i(139283);
    if (QbSdk.b)
    {
      AppMethodBeat.o(139283);
      return;
    }
    if (Build.VERSION.SDK_INT < 8)
    {
      TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
      AppMethodBeat.o(139283);
      return;
    }
    TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #1 ");
    if (v(paramContext))
    {
      TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #2 ");
      if ((a(paramContext, "core_unzip_tmp")) && (e(paramContext, paramBoolean)))
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!", true);
        AppMethodBeat.o(139283);
        return;
      }
      if ((a(paramContext, "core_share_backup_tmp")) && (f(paramContext, paramBoolean)))
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!", true);
        AppMethodBeat.o(139283);
        return;
      }
      if ((a(paramContext, "core_copy_tmp")) && (d(paramContext, paramBoolean)))
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!", true);
        AppMethodBeat.o(139283);
        return;
      }
      if ((a(paramContext, "tpatch_tmp")) && (c(paramContext, paramBoolean)))
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch!!", true);
        AppMethodBeat.o(139283);
        return;
      }
      TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
      AppMethodBeat.o(139283);
      return;
    }
    AppMethodBeat.o(139283);
  }
  
  boolean b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(139295);
    if (TbsDownloader.getOverSea(paramContext))
    {
      AppMethodBeat.o(139295);
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
      AppMethodBeat.o(139295);
      return true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
    AppMethodBeat.o(139295);
    return false;
  }
  
  int c(Context paramContext, String paramString)
  {
    AppMethodBeat.i(139314);
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramContext != null)
    {
      int i1 = paramContext.versionCode;
      AppMethodBeat.o(139314);
      return i1;
    }
    AppMethodBeat.o(139314);
    return 0;
  }
  
  void c(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(139300);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
    if (paramInt <= 0)
    {
      AppMethodBeat.o(139300);
      return;
    }
    int i1 = i(paramContext);
    if (i1 == paramInt)
    {
      AppMethodBeat.o(139300);
      return;
    }
    Context localContext = TbsShareManager.e(paramContext);
    if ((localContext != null) || (TbsShareManager.getHostCorePathAppDefined() != null))
    {
      TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
      a(paramContext, localContext);
      AppMethodBeat.o(139300);
      return;
    }
    if (i1 <= 0)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
      QbSdk.a(paramContext, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
    }
    AppMethodBeat.o(139300);
  }
  
  /* Error */
  boolean c(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 1597
    //   5: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 182	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 148	com/tencent/smtt/sdk/ao:q	(Landroid/content/Context;)Ljava/io/File;
    //   17: ldc_w 300
    //   20: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore 5
    //   25: aload 5
    //   27: invokevirtual 546	java/io/File:exists	()Z
    //   30: ifne +11 -> 41
    //   33: ldc_w 1597
    //   36: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: iconst_0
    //   40: ireturn
    //   41: new 302	java/util/Properties
    //   44: dup
    //   45: invokespecial 303	java/util/Properties:<init>	()V
    //   48: astore 6
    //   50: new 305	java/io/BufferedInputStream
    //   53: dup
    //   54: new 307	java/io/FileInputStream
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 313	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore_1
    //   67: aload 6
    //   69: aload_1
    //   70: invokevirtual 316	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload 6
    //   75: ldc_w 326
    //   78: ldc_w 1599
    //   81: invokevirtual 575	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   84: invokestatic 1602	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   87: invokevirtual 883	java/lang/Boolean:booleanValue	()Z
    //   90: istore 4
    //   92: iload 4
    //   94: ifeq +165 -> 259
    //   97: invokestatic 526	java/lang/System:currentTimeMillis	()J
    //   100: aload 5
    //   102: invokevirtual 1605	java/io/File:lastModified	()J
    //   105: lsub
    //   106: ldc2_w 1606
    //   109: lcmp
    //   110: ifle +61 -> 171
    //   113: iconst_1
    //   114: istore_3
    //   115: ldc 137
    //   117: new 162	java/lang/StringBuilder
    //   120: dup
    //   121: ldc_w 1609
    //   124: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: iload 4
    //   129: invokevirtual 713	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   132: ldc_w 1611
    //   135: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iload_3
    //   139: invokevirtual 713	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   142: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: iload_3
    //   149: ifne +27 -> 176
    //   152: iload 4
    //   154: iload_2
    //   155: iand
    //   156: istore 4
    //   158: aload_1
    //   159: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   162: ldc_w 1597
    //   165: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   194: invokevirtual 342	java/io/BufferedInputStream:close	()V
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
    //   219: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   222: ldc_w 1597
    //   225: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	264	0	this	ao
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
    AppMethodBeat.i(139313);
    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=".concat(String.valueOf(paramInt)));
    if (paramInt <= 0)
    {
      AppMethodBeat.o(139313);
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
      AppMethodBeat.o(139313);
      return localContext;
    }
    AppMethodBeat.o(139313);
    return null;
  }
  
  /* Error */
  public String d(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 1632
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 1022	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 1632
    //   16: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: new 182	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 148	com/tencent/smtt/sdk/ao:q	(Landroid/content/Context;)Ljava/io/File;
    //   30: ldc_w 300
    //   33: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   36: astore_1
    //   37: aload_1
    //   38: invokevirtual 546	java/io/File:exists	()Z
    //   41: istore_3
    //   42: iload_3
    //   43: ifne +11 -> 54
    //   46: ldc_w 1632
    //   49: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aconst_null
    //   53: areturn
    //   54: new 302	java/util/Properties
    //   57: dup
    //   58: invokespecial 303	java/util/Properties:<init>	()V
    //   61: astore 4
    //   63: new 305	java/io/BufferedInputStream
    //   66: dup
    //   67: new 307	java/io/FileInputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   75: invokespecial 313	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   78: astore_1
    //   79: aload 4
    //   81: aload_1
    //   82: invokevirtual 316	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   85: aload_1
    //   86: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   89: aload 4
    //   91: aload_2
    //   92: invokevirtual 1336	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore_2
    //   96: aload_1
    //   97: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   100: ldc_w 1632
    //   103: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_2
    //   107: areturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +7 -> 119
    //   115: aload_1
    //   116: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   119: ldc_w 1632
    //   122: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   138: ldc_w 1632
    //   141: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	174	0	this	ao
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
    //   0: ldc_w 1633
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 182	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 148	com/tencent/smtt/sdk/ao:q	(Landroid/content/Context;)Ljava/io/File;
    //   15: ldc_w 300
    //   18: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore_1
    //   22: new 302	java/util/Properties
    //   25: dup
    //   26: invokespecial 303	java/util/Properties:<init>	()V
    //   29: astore_3
    //   30: new 305	java/io/BufferedInputStream
    //   33: dup
    //   34: new 307	java/io/FileInputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 313	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_2
    //   46: aload_3
    //   47: aload_2
    //   48: invokevirtual 316	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   51: new 318	java/io/BufferedOutputStream
    //   54: dup
    //   55: new 320	java/io/FileOutputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 321	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 324	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   66: astore_1
    //   67: aload_3
    //   68: ldc_w 326
    //   71: ldc_w 1599
    //   74: invokevirtual 332	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   77: pop
    //   78: aload_3
    //   79: aload_1
    //   80: aconst_null
    //   81: invokevirtual 336	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   84: aload_1
    //   85: invokevirtual 341	java/io/BufferedOutputStream:close	()V
    //   88: aload_2
    //   89: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   92: ldc_w 1633
    //   95: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: return
    //   99: astore_1
    //   100: ldc_w 1633
    //   103: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: return
    //   107: astore_1
    //   108: ldc_w 1633
    //   111: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_2
    //   120: aload_1
    //   121: ifnull +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 341	java/io/BufferedOutputStream:close	()V
    //   128: aload_2
    //   129: ifnull +51 -> 180
    //   132: aload_2
    //   133: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   136: ldc_w 1633
    //   139: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: return
    //   143: astore_1
    //   144: ldc_w 1633
    //   147: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: astore_1
    //   152: aconst_null
    //   153: astore_2
    //   154: aconst_null
    //   155: astore_3
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 341	java/io/BufferedOutputStream:close	()V
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   172: ldc_w 1633
    //   175: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aload_1
    //   179: athrow
    //   180: ldc_w 1633
    //   183: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	241	0	this	ao
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
    AppMethodBeat.i(139321);
    paramInt = a(f(paramContext, paramInt));
    AppMethodBeat.o(139321);
    return paramInt;
  }
  
  public boolean e(Context paramContext)
  {
    AppMethodBeat.i(139308);
    for (;;)
    {
      int i1;
      try
      {
        Object localObject = new File(k.a(paramContext, 4), "x5.tbs.decouple");
        File localFile1 = a().f(paramContext, 2);
        k.a(localFile1);
        k.a(localFile1, true);
        k.a((File)localObject, localFile1);
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
          AppMethodBeat.o(139308);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(139308);
        return false;
      }
      i1 += 1;
    }
  }
  
  File f(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(139342);
    paramContext = a(paramContext, paramInt, true);
    AppMethodBeat.o(139342);
    return paramContext;
  }
  
  boolean f(Context paramContext)
  {
    AppMethodBeat.i(139312);
    if (TbsShareManager.getHostCorePathAppDefined() != null)
    {
      AppMethodBeat.o(139312);
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
          AppMethodBeat.o(139312);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.mm"))
      {
        bool = localSignature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499");
        if (!bool)
        {
          AppMethodBeat.o(139312);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.mobileqq"))
      {
        bool = localSignature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049");
        if (!bool)
        {
          AppMethodBeat.o(139312);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.tbs"))
      {
        bool = localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a");
        if (!bool)
        {
          AppMethodBeat.o(139312);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.qzone"))
      {
        bool = localSignature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677");
        if (!bool)
        {
          AppMethodBeat.o(139312);
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.qqpimsecure"))
      {
        bool = localSignature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
        if (!bool)
        {
          AppMethodBeat.o(139312);
          return false;
        }
      }
    }
    catch (Exception paramContext)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
      AppMethodBeat.o(139312);
      return false;
    }
    AppMethodBeat.o(139312);
    return true;
  }
  
  public void g(Context paramContext)
  {
    AppMethodBeat.i(139315);
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
    if ((i1 != 0) && (l != null)) {
      k.a(paramContext, l);
    }
    AppMethodBeat.o(139315);
  }
  
  boolean g(Context paramContext, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(139344);
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
            break label328;
          }
          AppMethodBeat.o(139344);
          return true;
        }
        TbsLog.e("TbsInstaller", "321");
        AppMethodBeat.o(139344);
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
          break label331;
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
      AppMethodBeat.o(139344);
      return bool1;
      if (!bool3) {
        k.b(paramContext.getDir("tbs", 0));
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
    //   0: ldc_w 1714
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: new 182	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 514	com/tencent/smtt/sdk/ao:p	(Landroid/content/Context;)Ljava/io/File;
    //   18: ldc_w 300
    //   21: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 546	java/io/File:exists	()Z
    //   29: istore_3
    //   30: iload_3
    //   31: ifne +11 -> 42
    //   34: ldc_w 1714
    //   37: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_0
    //   41: ireturn
    //   42: new 302	java/util/Properties
    //   45: dup
    //   46: invokespecial 303	java/util/Properties:<init>	()V
    //   49: astore 5
    //   51: new 305	java/io/BufferedInputStream
    //   54: dup
    //   55: new 307	java/io/FileInputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 313	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore_1
    //   67: aload 5
    //   69: aload_1
    //   70: invokevirtual 316	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload_1
    //   74: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   77: aload 5
    //   79: ldc_w 1335
    //   82: invokevirtual 1336	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 4
    //   87: aload 4
    //   89: ifnonnull +15 -> 104
    //   92: aload_1
    //   93: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   96: ldc_w 1714
    //   99: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: iconst_0
    //   103: ireturn
    //   104: aload 4
    //   106: invokestatic 1339	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   109: istore_2
    //   110: aload_1
    //   111: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   114: ldc_w 1714
    //   117: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: iload_2
    //   121: ireturn
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_1
    //   125: aload_1
    //   126: ifnull +7 -> 133
    //   129: aload_1
    //   130: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   133: ldc_w 1714
    //   136: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_1
    //   142: aload 4
    //   144: ifnull +8 -> 152
    //   147: aload 4
    //   149: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   152: ldc_w 1714
    //   155: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	193	0	this	ao
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
    //   0: ldc_w 1715
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 182	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 148	com/tencent/smtt/sdk/ao:q	(Landroid/content/Context;)Ljava/io/File;
    //   15: ldc_w 300
    //   18: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 546	java/io/File:exists	()Z
    //   26: istore_3
    //   27: iload_3
    //   28: ifne +11 -> 39
    //   31: ldc_w 1715
    //   34: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: iconst_0
    //   38: ireturn
    //   39: new 302	java/util/Properties
    //   42: dup
    //   43: invokespecial 303	java/util/Properties:<init>	()V
    //   46: astore 5
    //   48: new 305	java/io/BufferedInputStream
    //   51: dup
    //   52: new 307	java/io/FileInputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 313	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore 4
    //   65: aload 4
    //   67: astore_1
    //   68: aload 5
    //   70: aload 4
    //   72: invokevirtual 316	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   75: aload 4
    //   77: astore_1
    //   78: aload 4
    //   80: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   83: aload 4
    //   85: astore_1
    //   86: aload 5
    //   88: ldc_w 1335
    //   91: invokevirtual 1336	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 5
    //   96: aload 5
    //   98: ifnonnull +45 -> 143
    //   101: aload 4
    //   103: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   106: ldc_w 1715
    //   109: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: ldc 137
    //   117: new 162	java/lang/StringBuilder
    //   120: dup
    //   121: ldc_w 1717
    //   124: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: aload_1
    //   128: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   131: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: goto -34 -> 106
    //   143: aload 4
    //   145: astore_1
    //   146: aload 5
    //   148: invokestatic 1339	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   151: istore_2
    //   152: aload 4
    //   154: astore_1
    //   155: getstatic 105	com/tencent/smtt/sdk/ao:o	I
    //   158: ifne +10 -> 168
    //   161: aload 4
    //   163: astore_1
    //   164: iload_2
    //   165: putstatic 105	com/tencent/smtt/sdk/ao:o	I
    //   168: aload 4
    //   170: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   173: ldc_w 1715
    //   176: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: iload_2
    //   180: ireturn
    //   181: astore_1
    //   182: ldc 137
    //   184: new 162	java/lang/StringBuilder
    //   187: dup
    //   188: ldc_w 1717
    //   191: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   194: aload_1
    //   195: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   198: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: goto -34 -> 173
    //   210: astore 5
    //   212: aconst_null
    //   213: astore 4
    //   215: aload 4
    //   217: astore_1
    //   218: ldc 137
    //   220: new 162	java/lang/StringBuilder
    //   223: dup
    //   224: ldc_w 1720
    //   227: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   230: aload 5
    //   232: invokevirtual 580	java/lang/Exception:toString	()Ljava/lang/String;
    //   235: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 4
    //   246: ifnull +8 -> 254
    //   249: aload 4
    //   251: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   254: ldc_w 1715
    //   257: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: iconst_0
    //   261: ireturn
    //   262: astore_1
    //   263: ldc 137
    //   265: new 162	java/lang/StringBuilder
    //   268: dup
    //   269: ldc_w 1717
    //   272: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: aload_1
    //   276: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   279: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: goto -34 -> 254
    //   291: astore 4
    //   293: aconst_null
    //   294: astore_1
    //   295: aload_1
    //   296: ifnull +7 -> 303
    //   299: aload_1
    //   300: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   303: ldc_w 1715
    //   306: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: aload 4
    //   311: athrow
    //   312: astore_1
    //   313: ldc 137
    //   315: new 162	java/lang/StringBuilder
    //   318: dup
    //   319: ldc_w 1717
    //   322: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   325: aload_1
    //   326: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   329: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: goto -35 -> 303
    //   341: astore 4
    //   343: goto -48 -> 295
    //   346: astore 5
    //   348: goto -133 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	ao
    //   0	351	1	paramContext	Context
    //   151	29	2	i1	int
    //   26	2	3	bool	boolean
    //   63	187	4	localBufferedInputStream	java.io.BufferedInputStream
    //   291	19	4	localObject1	Object
    //   341	1	4	localObject2	Object
    //   46	101	5	localObject3	Object
    //   210	21	5	localException1	Exception
    //   346	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   101	106	114	java/io/IOException
    //   168	173	181	java/io/IOException
    //   6	27	210	java/lang/Exception
    //   39	65	210	java/lang/Exception
    //   249	254	262	java/io/IOException
    //   6	27	291	finally
    //   39	65	291	finally
    //   299	303	312	java/io/IOException
    //   68	75	341	finally
    //   78	83	341	finally
    //   86	96	341	finally
    //   146	152	341	finally
    //   155	161	341	finally
    //   164	168	341	finally
    //   218	244	341	finally
    //   68	75	346	java/lang/Exception
    //   78	83	346	java/lang/Exception
    //   86	96	346	java/lang/Exception
    //   146	152	346	java/lang/Exception
    //   155	161	346	java/lang/Exception
    //   164	168	346	java/lang/Exception
  }
  
  int j(Context paramContext)
  {
    AppMethodBeat.i(139326);
    if (o != 0)
    {
      i1 = o;
      AppMethodBeat.o(139326);
      return i1;
    }
    int i1 = i(paramContext);
    AppMethodBeat.o(139326);
    return i1;
  }
  
  void k(Context paramContext)
  {
    AppMethodBeat.i(139327);
    if (o != 0)
    {
      AppMethodBeat.o(139327);
      return;
    }
    o = i(paramContext);
    AppMethodBeat.o(139327);
  }
  
  boolean l(Context paramContext)
  {
    AppMethodBeat.i(139328);
    if (!new File(q(paramContext), "tbs.conf").exists())
    {
      AppMethodBeat.o(139328);
      return false;
    }
    AppMethodBeat.o(139328);
    return true;
  }
  
  /* Error */
  int m(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 1724
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 428	com/tencent/smtt/sdk/ao:t	(Landroid/content/Context;)Z
    //   11: ifne +11 -> 22
    //   14: ldc_w 1724
    //   17: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_m1
    //   21: ireturn
    //   22: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   25: invokevirtual 1082	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   28: istore_3
    //   29: ldc 137
    //   31: ldc_w 1726
    //   34: iload_3
    //   35: invokestatic 193	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   38: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: iload_3
    //   45: ifeq +536 -> 581
    //   48: new 182	java/io/File
    //   51: dup
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 148	com/tencent/smtt/sdk/ao:q	(Landroid/content/Context;)Ljava/io/File;
    //   57: ldc_w 300
    //   60: invokespecial 295	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual 546	java/io/File:exists	()Z
    //   68: istore_3
    //   69: iload_3
    //   70: ifne +49 -> 119
    //   73: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   76: invokevirtual 1729	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   79: ifeq +9 -> 88
    //   82: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   85: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   88: aload_0
    //   89: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   92: ldc_w 1724
    //   95: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: iconst_0
    //   99: ireturn
    //   100: astore_1
    //   101: ldc 137
    //   103: ldc_w 1731
    //   106: aload_1
    //   107: invokestatic 750	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   110: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   113: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: goto -28 -> 88
    //   119: new 302	java/util/Properties
    //   122: dup
    //   123: invokespecial 303	java/util/Properties:<init>	()V
    //   126: astore 5
    //   128: new 305	java/io/BufferedInputStream
    //   131: dup
    //   132: new 307	java/io/FileInputStream
    //   135: dup
    //   136: aload_1
    //   137: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   140: invokespecial 313	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   143: astore 4
    //   145: aload 4
    //   147: astore_1
    //   148: aload 5
    //   150: aload 4
    //   152: invokevirtual 316	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   155: aload 4
    //   157: astore_1
    //   158: aload 4
    //   160: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   163: aload 4
    //   165: astore_1
    //   166: aload 5
    //   168: ldc_w 1335
    //   171: invokevirtual 1336	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   174: astore 5
    //   176: aload 5
    //   178: ifnonnull +83 -> 261
    //   181: aload 4
    //   183: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   186: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   189: invokevirtual 1729	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   192: ifeq +9 -> 201
    //   195: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   198: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   201: aload_0
    //   202: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   205: ldc_w 1724
    //   208: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: iconst_0
    //   212: ireturn
    //   213: astore_1
    //   214: ldc 137
    //   216: new 162	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 1733
    //   223: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload_1
    //   227: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   230: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: goto -53 -> 186
    //   242: astore_1
    //   243: ldc 137
    //   245: ldc_w 1731
    //   248: aload_1
    //   249: invokestatic 750	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   252: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   255: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: goto -57 -> 201
    //   261: aload 4
    //   263: astore_1
    //   264: getstatic 58	com/tencent/smtt/sdk/ao:a	Ljava/lang/ThreadLocal;
    //   267: aload 5
    //   269: invokestatic 1339	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   272: invokestatic 1292	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   275: invokevirtual 1298	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   278: aload 4
    //   280: astore_1
    //   281: getstatic 58	com/tencent/smtt/sdk/ao:a	Ljava/lang/ThreadLocal;
    //   284: invokevirtual 1345	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   287: checkcast 1289	java/lang/Integer
    //   290: invokevirtual 1348	java/lang/Integer:intValue	()I
    //   293: istore_2
    //   294: aload 4
    //   296: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   299: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   302: invokevirtual 1729	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   305: ifeq +9 -> 314
    //   308: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   311: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   314: aload_0
    //   315: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   318: ldc_w 1724
    //   321: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: iload_2
    //   325: ireturn
    //   326: astore_1
    //   327: ldc 137
    //   329: new 162	java/lang/StringBuilder
    //   332: dup
    //   333: ldc_w 1733
    //   336: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   339: aload_1
    //   340: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   343: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: goto -53 -> 299
    //   355: astore_1
    //   356: ldc 137
    //   358: ldc_w 1731
    //   361: aload_1
    //   362: invokestatic 750	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   365: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   368: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: goto -57 -> 314
    //   374: astore 5
    //   376: aconst_null
    //   377: astore 4
    //   379: aload 4
    //   381: astore_1
    //   382: ldc 137
    //   384: new 162	java/lang/StringBuilder
    //   387: dup
    //   388: ldc_w 1735
    //   391: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: aload 5
    //   396: invokevirtual 580	java/lang/Exception:toString	()Ljava/lang/String;
    //   399: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: aload 4
    //   410: ifnull +8 -> 418
    //   413: aload 4
    //   415: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   418: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   421: invokevirtual 1729	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   424: ifeq +9 -> 433
    //   427: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   430: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   433: aload_0
    //   434: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   437: ldc_w 1724
    //   440: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   443: iconst_0
    //   444: ireturn
    //   445: astore_1
    //   446: ldc 137
    //   448: new 162	java/lang/StringBuilder
    //   451: dup
    //   452: ldc_w 1733
    //   455: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   458: aload_1
    //   459: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   462: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: goto -53 -> 418
    //   474: astore_1
    //   475: ldc 137
    //   477: ldc_w 1731
    //   480: aload_1
    //   481: invokestatic 750	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   484: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   487: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   490: goto -57 -> 433
    //   493: astore 4
    //   495: aconst_null
    //   496: astore_1
    //   497: aload_1
    //   498: ifnull +7 -> 505
    //   501: aload_1
    //   502: invokevirtual 342	java/io/BufferedInputStream:close	()V
    //   505: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   508: invokevirtual 1729	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   511: ifeq +9 -> 520
    //   514: getstatic 49	com/tencent/smtt/sdk/ao:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   517: invokevirtual 458	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   520: aload_0
    //   521: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   524: ldc_w 1724
    //   527: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   530: aload 4
    //   532: athrow
    //   533: astore_1
    //   534: ldc 137
    //   536: new 162	java/lang/StringBuilder
    //   539: dup
    //   540: ldc_w 1733
    //   543: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   546: aload_1
    //   547: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   550: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: goto -54 -> 505
    //   562: astore_1
    //   563: ldc 137
    //   565: ldc_w 1731
    //   568: aload_1
    //   569: invokestatic 750	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   572: invokevirtual 197	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   575: invokestatic 365	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: goto -58 -> 520
    //   581: aload_0
    //   582: invokevirtual 461	com/tencent/smtt/sdk/ao:b	()V
    //   585: ldc_w 1724
    //   588: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   591: iconst_0
    //   592: ireturn
    //   593: astore 4
    //   595: goto -98 -> 497
    //   598: astore 5
    //   600: goto -221 -> 379
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	this	ao
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
    AppMethodBeat.i(139332);
    TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
    File localFile1 = q(paramContext);
    File localFile2 = p(paramContext);
    try
    {
      k.a(localFile2, true);
      k.a(localFile1, localFile2, new av(this));
      TbsShareManager.b(paramContext);
      TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
      AppMethodBeat.o(139332);
      return true;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(139332);
    }
    return false;
  }
  
  void o(Context paramContext)
  {
    AppMethodBeat.i(139336);
    TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
    aj.a(paramContext).a(0);
    aj.a(paramContext).b(0);
    aj.a(paramContext).d(0);
    aj.a(paramContext).a("incrupdate_retry_num", 0);
    if (!TbsDownloader.a(paramContext))
    {
      aj.a(paramContext).c(0, -1);
      aj.a(paramContext).a("");
      aj.a(paramContext).a("copy_retry_num", 0);
      aj.a(paramContext).c(-1);
      aj.a(paramContext).a(0, -1);
      k.a(f(paramContext, 0), true);
      k.a(f(paramContext, 1), true);
    }
    AppMethodBeat.o(139336);
  }
  
  File p(Context paramContext)
  {
    AppMethodBeat.i(139338);
    paramContext = new File(paramContext.getDir("tbs", 0), "core_share_decouple");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(139338);
      return null;
    }
    AppMethodBeat.o(139338);
    return paramContext;
  }
  
  File q(Context paramContext)
  {
    AppMethodBeat.i(139339);
    paramContext = b(null, paramContext);
    AppMethodBeat.o(139339);
    return paramContext;
  }
  
  File r(Context paramContext)
  {
    AppMethodBeat.i(139340);
    paramContext = new File(paramContext.getDir("tbs", 0), "share");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir()))
    {
      AppMethodBeat.o(139340);
      return null;
    }
    AppMethodBeat.o(139340);
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
    //   4: ldc_w 1755
    //   7: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 114	com/tencent/smtt/sdk/ao:e	I
    //   14: ifle +31 -> 45
    //   17: ldc 137
    //   19: ldc_w 1757
    //   22: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 114	com/tencent/smtt/sdk/ao:e	I
    //   30: iconst_1
    //   31: iadd
    //   32: putfield 114	com/tencent/smtt/sdk/ao:e	I
    //   35: ldc_w 1755
    //   38: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_2
    //   44: ireturn
    //   45: aload_0
    //   46: aload_1
    //   47: iconst_1
    //   48: ldc_w 1759
    //   51: invokestatic 1762	com/tencent/smtt/utils/k:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   54: putfield 1478	com/tencent/smtt/sdk/ao:g	Ljava/io/FileOutputStream;
    //   57: aload_0
    //   58: getfield 1478	com/tencent/smtt/sdk/ao:g	Ljava/io/FileOutputStream;
    //   61: ifnull +41 -> 102
    //   64: aload_0
    //   65: aload_1
    //   66: aload_0
    //   67: getfield 1478	com/tencent/smtt/sdk/ao:g	Ljava/io/FileOutputStream;
    //   70: invokestatic 1765	com/tencent/smtt/utils/k:a	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   73: putfield 1476	com/tencent/smtt/sdk/ao:f	Ljava/nio/channels/FileLock;
    //   76: aload_0
    //   77: getfield 1476	com/tencent/smtt/sdk/ao:f	Ljava/nio/channels/FileLock;
    //   80: ifnonnull +41 -> 121
    //   83: ldc 137
    //   85: ldc_w 1767
    //   88: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: ldc_w 1755
    //   94: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: iconst_0
    //   98: istore_2
    //   99: goto -58 -> 41
    //   102: ldc 137
    //   104: ldc_w 1769
    //   107: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: ldc_w 1755
    //   113: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: iconst_0
    //   117: istore_2
    //   118: goto -77 -> 41
    //   121: ldc 137
    //   123: ldc_w 1771
    //   126: invokestatic 144	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 114	com/tencent/smtt/sdk/ao:e	I
    //   134: iconst_1
    //   135: iadd
    //   136: putfield 114	com/tencent/smtt/sdk/ao:e	I
    //   139: ldc_w 1755
    //   142: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: goto -104 -> 41
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	ao
    //   0	153	1	paramContext	Context
    //   1	117	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	41	148	finally
    //   45	97	148	finally
    //   102	116	148	finally
    //   121	145	148	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.ao
 * JD-Core Version:    0.7.0.1
 */