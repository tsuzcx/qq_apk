package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public final class ak
{
  private static boolean aifX = true;
  private static boolean aifY;
  
  @Deprecated
  public static void OT(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(212437);
      Log.i("XWebEmbedSetting", "setForbidDownloadCode:".concat(String.valueOf(paramBoolean)));
      aifY = paramBoolean;
      AppMethodBeat.o(212437);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static boolean kgd()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 43	com/tencent/xweb/ak:aifY	Z
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.ak
 * JD-Core Version:    0.7.0.1
 */