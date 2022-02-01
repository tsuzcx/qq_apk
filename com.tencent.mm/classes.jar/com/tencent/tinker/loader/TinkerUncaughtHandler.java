package com.tencent.tinker.loader;

import android.content.Context;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public class TinkerUncaughtHandler
  implements Thread.UncaughtExceptionHandler
{
  private static final String TAG = "Tinker.UncaughtHandler";
  private final Context context;
  private final File crashFile;
  private final Thread.UncaughtExceptionHandler ueh;
  
  public TinkerUncaughtHandler(Context paramContext)
  {
    this.context = paramContext;
    this.ueh = Thread.getDefaultUncaughtExceptionHandler();
    this.crashFile = SharePatchFileUtil.getPatchLastCrashFile(paramContext);
  }
  
  /* Error */
  public void uncaughtException(Thread paramThread, java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc 10
    //   2: new 46	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 48
    //   8: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_2
    //   12: invokestatic 57	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   15: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: iconst_0
    //   22: anewarray 4	java/lang/Object
    //   25: invokestatic 71	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: aload_0
    //   29: getfield 31	com/tencent/tinker/loader/TinkerUncaughtHandler:ueh	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   32: aload_1
    //   33: aload_2
    //   34: invokeinterface 73 3 0
    //   39: aload_0
    //   40: getfield 39	com/tencent/tinker/loader/TinkerUncaughtHandler:crashFile	Ljava/io/File;
    //   43: ifnull +45 -> 88
    //   46: invokestatic 29	java/lang/Thread:getDefaultUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   49: instanceof 2
    //   52: ifeq +36 -> 88
    //   55: aload_0
    //   56: getfield 39	com/tencent/tinker/loader/TinkerUncaughtHandler:crashFile	Ljava/io/File;
    //   59: invokevirtual 79	java/io/File:getParentFile	()Ljava/io/File;
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 83	java/io/File:exists	()Z
    //   67: ifne +22 -> 89
    //   70: aload_1
    //   71: invokevirtual 86	java/io/File:mkdirs	()Z
    //   74: ifne +15 -> 89
    //   77: ldc 10
    //   79: ldc 88
    //   81: iconst_0
    //   82: anewarray 4	java/lang/Object
    //   85: invokestatic 71	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: return
    //   89: new 90	java/io/PrintWriter
    //   92: dup
    //   93: new 92	java/io/FileWriter
    //   96: dup
    //   97: aload_0
    //   98: getfield 39	com/tencent/tinker/loader/TinkerUncaughtHandler:crashFile	Ljava/io/File;
    //   101: iconst_0
    //   102: invokespecial 95	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   105: invokespecial 98	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   108: astore_3
    //   109: aload_3
    //   110: astore_1
    //   111: aload_3
    //   112: new 46	java/lang/StringBuilder
    //   115: dup
    //   116: ldc 100
    //   118: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   121: aload_0
    //   122: getfield 23	com/tencent/tinker/loader/TinkerUncaughtHandler:context	Landroid/content/Context;
    //   125: invokestatic 106	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getProcessName	(Landroid/content/Context;)Ljava/lang/String;
    //   128: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokevirtual 109	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   137: aload_3
    //   138: astore_1
    //   139: aload_3
    //   140: aload_2
    //   141: invokestatic 112	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getExceptionCauseString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   144: invokevirtual 109	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   147: aload_3
    //   148: invokestatic 116	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   151: invokestatic 122	android/os/Process:myPid	()I
    //   154: invokestatic 126	android/os/Process:killProcess	(I)V
    //   157: return
    //   158: astore 4
    //   160: aconst_null
    //   161: astore_2
    //   162: aload_2
    //   163: astore_1
    //   164: ldc 10
    //   166: new 46	java/lang/StringBuilder
    //   169: dup
    //   170: ldc 128
    //   172: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   175: aload 4
    //   177: invokestatic 57	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   180: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: iconst_0
    //   187: anewarray 4	java/lang/Object
    //   190: invokestatic 71	com/tencent/tinker/loader/shareutil/ShareTinkerLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: aload_2
    //   194: invokestatic 116	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   197: goto -46 -> 151
    //   200: astore_2
    //   201: aconst_null
    //   202: astore_1
    //   203: aload_1
    //   204: invokestatic 116	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   207: aload_2
    //   208: athrow
    //   209: astore_2
    //   210: goto -7 -> 203
    //   213: astore 4
    //   215: aload_3
    //   216: astore_2
    //   217: goto -55 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	TinkerUncaughtHandler
    //   0	220	1	paramThread	Thread
    //   0	220	2	paramThrowable	java.lang.Throwable
    //   108	108	3	localPrintWriter	java.io.PrintWriter
    //   158	18	4	localIOException1	java.io.IOException
    //   213	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   89	109	158	java/io/IOException
    //   89	109	200	finally
    //   111	137	209	finally
    //   139	147	209	finally
    //   164	193	209	finally
    //   111	137	213	java/io/IOException
    //   139	147	213	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerUncaughtHandler
 * JD-Core Version:    0.7.0.1
 */