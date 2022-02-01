package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class ag
{
  static String IOa;
  static boolean IOb = true;
  static boolean IOc;
  
  public static void aPj(String paramString)
  {
    try
    {
      AppMethodBeat.i(195168);
      XWalkEnvironment.addXWalkInitializeLog("XWebUpdaterSetting", "setEmbedInstallLibDir: ".concat(String.valueOf(paramString)));
      IOa = paramString;
      AppMethodBeat.o(195168);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static String frs()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 51
    //   5: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 45	com/tencent/xweb/ag:IOa	Ljava/lang/String;
    //   11: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +17 -> 31
    //   17: getstatic 45	com/tencent/xweb/ag:IOa	Ljava/lang/String;
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
  
  public static boolean frt()
  {
    try
    {
      boolean bool = IOc;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void xD(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(195170);
      XWalkEnvironment.addXWalkInitializeLog("XWebUpdaterSetting", "setIsEmbedDirReady: ".concat(String.valueOf(paramBoolean)));
      IOb = paramBoolean;
      AppMethodBeat.o(195170);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void xE(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(195171);
      XWalkEnvironment.addXWalkInitializeLog("XWebUpdaterSetting", "setForbidDownloadCode: ".concat(String.valueOf(paramBoolean)));
      IOc = paramBoolean;
      AppMethodBeat.o(195171);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.ag
 * JD-Core Version:    0.7.0.1
 */