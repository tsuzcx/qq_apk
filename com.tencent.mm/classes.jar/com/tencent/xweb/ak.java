package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

public final class ak
{
  static String aabM;
  static boolean aabN = true;
  static boolean aabO;
  
  public static void IM(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(197842);
      XWalkEnvironment.addXWalkInitializeLog("XWebUpdaterSetting", "setIsEmbedDirReady: ".concat(String.valueOf(paramBoolean)));
      aabN = paramBoolean;
      AppMethodBeat.o(197842);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void IN(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(197843);
      XWalkEnvironment.addXWalkInitializeLog("XWebUpdaterSetting", "setForbidDownloadCode: ".concat(String.valueOf(paramBoolean)));
      aabO = paramBoolean;
      AppMethodBeat.o(197843);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void bFr(String paramString)
  {
    try
    {
      AppMethodBeat.i(197840);
      XWalkEnvironment.addXWalkInitializeLog("XWebUpdaterSetting", "setEmbedInstallLibDir: ".concat(String.valueOf(paramString)));
      aabM = paramString;
      AppMethodBeat.o(197840);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static boolean iwQ()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 52	com/tencent/xweb/ak:aabO	Z
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.ak
 * JD-Core Version:    0.7.0.1
 */