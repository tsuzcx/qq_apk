package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class ai
{
  static String KAw;
  static boolean KAx = true;
  static boolean KAy;
  
  public static void aVc(String paramString)
  {
    try
    {
      AppMethodBeat.i(205078);
      XWalkEnvironment.addXWalkInitializeLog("XWebUpdaterSetting", "setEmbedInstallLibDir: ".concat(String.valueOf(paramString)));
      KAw = paramString;
      AppMethodBeat.o(205078);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static String fJU()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 51
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 45	com/tencent/xweb/ai:KAw	Ljava/lang/String;
    //   11: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +17 -> 31
    //   17: getstatic 45	com/tencent/xweb/ai:KAw	Ljava/lang/String;
    //   20: astore_0
    //   21: ldc 51
    //   23: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: ldc 2
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: invokestatic 61	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   34: invokevirtual 67	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   37: getfield 72	android/content/pm/ApplicationInfo:nativeLibraryDir	Ljava/lang/String;
    //   40: astore_0
    //   41: ldc 51
    //   43: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: goto -20 -> 26
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	21	0	str	String
    //   49	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	26	49	finally
    //   31	46	49	finally
  }
  
  /* Error */
  public static boolean fJV()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 76	com/tencent/xweb/ai:KAy	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	14	0	bool	boolean
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  public static void yU(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(205080);
      XWalkEnvironment.addXWalkInitializeLog("XWebUpdaterSetting", "setIsEmbedDirReady: ".concat(String.valueOf(paramBoolean)));
      KAx = paramBoolean;
      AppMethodBeat.o(205080);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void yV(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(205081);
      XWalkEnvironment.addXWalkInitializeLog("XWebUpdaterSetting", "setForbidDownloadCode: ".concat(String.valueOf(paramBoolean)));
      KAy = paramBoolean;
      AppMethodBeat.o(205081);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.ai
 * JD-Core Version:    0.7.0.1
 */