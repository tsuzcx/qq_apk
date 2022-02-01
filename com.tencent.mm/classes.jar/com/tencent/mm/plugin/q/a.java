package com.tencent.mm.plugin.q;

import java.util.List;

public final class a
{
  private static List<a.a> Klt;
  private static String Klu;
  
  public static void D(String paramString, List<a.a> paramList)
  {
    try
    {
      Klu = paramString;
      Klt = paramList;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static List<a.a> aKr(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 23
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ifnull +27 -> 36
    //   12: aload_0
    //   13: getstatic 15	com/tencent/mm/plugin/q/a:Klu	Ljava/lang/String;
    //   16: invokevirtual 35	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: ifeq +17 -> 36
    //   22: getstatic 17	com/tencent/mm/plugin/q/a:Klt	Ljava/util/List;
    //   25: astore_0
    //   26: ldc 23
    //   28: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: aconst_null
    //   37: astore_0
    //   38: ldc 23
    //   40: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -12 -> 31
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	8	46	finally
    //   12	31	46	finally
    //   38	43	46	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.q.a
 * JD-Core Version:    0.7.0.1
 */