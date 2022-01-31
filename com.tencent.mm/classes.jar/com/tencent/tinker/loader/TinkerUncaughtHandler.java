package com.tencent.tinker.loader;

import android.content.Context;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public class TinkerUncaughtHandler
  implements Thread.UncaughtExceptionHandler
{
  private final Context context;
  private final Thread.UncaughtExceptionHandler ufC;
  private final File wXv;
  
  public TinkerUncaughtHandler(Context paramContext)
  {
    this.context = paramContext;
    this.ufC = Thread.getDefaultUncaughtExceptionHandler();
    this.wXv = SharePatchFileUtil.hZ(paramContext);
  }
  
  /* Error */
  public void uncaughtException(Thread paramThread, java.lang.Throwable paramThrowable)
  {
    // Byte code:
    //   0: new 42	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 44
    //   6: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: aload_2
    //   10: invokestatic 53	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   13: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_0
    //   18: getfield 27	com/tencent/tinker/loader/TinkerUncaughtHandler:ufC	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   21: aload_1
    //   22: aload_2
    //   23: invokeinterface 59 3 0
    //   28: aload_0
    //   29: getfield 35	com/tencent/tinker/loader/TinkerUncaughtHandler:wXv	Ljava/io/File;
    //   32: ifnull +34 -> 66
    //   35: invokestatic 25	java/lang/Thread:getDefaultUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   38: instanceof 2
    //   41: ifeq +25 -> 66
    //   44: aload_0
    //   45: getfield 35	com/tencent/tinker/loader/TinkerUncaughtHandler:wXv	Ljava/io/File;
    //   48: invokevirtual 65	java/io/File:getParentFile	()Ljava/io/File;
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 69	java/io/File:exists	()Z
    //   56: ifne +11 -> 67
    //   59: aload_1
    //   60: invokevirtual 72	java/io/File:mkdirs	()Z
    //   63: ifne +4 -> 67
    //   66: return
    //   67: new 74	java/io/PrintWriter
    //   70: dup
    //   71: new 76	java/io/FileWriter
    //   74: dup
    //   75: aload_0
    //   76: getfield 35	com/tencent/tinker/loader/TinkerUncaughtHandler:wXv	Ljava/io/File;
    //   79: iconst_0
    //   80: invokespecial 79	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   83: invokespecial 82	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   86: astore_3
    //   87: aload_3
    //   88: astore_1
    //   89: aload_3
    //   90: new 42	java/lang/StringBuilder
    //   93: dup
    //   94: ldc 84
    //   96: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 19	com/tencent/tinker/loader/TinkerUncaughtHandler:context	Landroid/content/Context;
    //   103: invokestatic 90	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:ak	(Landroid/content/Context;)Ljava/lang/String;
    //   106: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokevirtual 97	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   115: aload_3
    //   116: astore_1
    //   117: aload_3
    //   118: aload_2
    //   119: invokestatic 100	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:k	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   122: invokevirtual 97	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   125: aload_3
    //   126: invokestatic 104	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:S	(Ljava/lang/Object;)V
    //   129: invokestatic 110	android/os/Process:myPid	()I
    //   132: invokestatic 114	android/os/Process:killProcess	(I)V
    //   135: return
    //   136: astore 4
    //   138: aconst_null
    //   139: astore_2
    //   140: aload_2
    //   141: astore_1
    //   142: new 42	java/lang/StringBuilder
    //   145: dup
    //   146: ldc 116
    //   148: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: aload 4
    //   153: invokestatic 53	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   156: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_2
    //   161: invokestatic 104	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:S	(Ljava/lang/Object;)V
    //   164: goto -35 -> 129
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_1
    //   170: aload_1
    //   171: invokestatic 104	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:S	(Ljava/lang/Object;)V
    //   174: aload_2
    //   175: athrow
    //   176: astore_2
    //   177: goto -7 -> 170
    //   180: astore 4
    //   182: aload_3
    //   183: astore_2
    //   184: goto -44 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	TinkerUncaughtHandler
    //   0	187	1	paramThread	Thread
    //   0	187	2	paramThrowable	java.lang.Throwable
    //   86	97	3	localPrintWriter	java.io.PrintWriter
    //   136	16	4	localIOException1	java.io.IOException
    //   180	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   67	87	136	java/io/IOException
    //   67	87	167	finally
    //   89	115	176	finally
    //   117	125	176	finally
    //   142	160	176	finally
    //   89	115	180	java/io/IOException
    //   117	125	180	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerUncaughtHandler
 * JD-Core Version:    0.7.0.1
 */