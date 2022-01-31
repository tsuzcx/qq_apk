package com.tencent.mm.plugin.q;

import java.util.List;

public final class a
{
  private static List<a.a> lKI;
  private static String lKJ;
  
  /* Error */
  public static List<a.a> GK(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +22 -> 26
    //   7: aload_0
    //   8: getstatic 15	com/tencent/mm/plugin/q/a:lKJ	Ljava/lang/String;
    //   11: invokevirtual 21	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +12 -> 26
    //   17: getstatic 23	com/tencent/mm/plugin/q/a:lKI	Ljava/util/List;
    //   20: astore_0
    //   21: ldc 2
    //   23: monitorexit
    //   24: aload_0
    //   25: areturn
    //   26: aconst_null
    //   27: astore_0
    //   28: goto -7 -> 21
    //   31: astore_0
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   7	21	31	finally
  }
  
  public static void o(String paramString, List<a.a> paramList)
  {
    try
    {
      lKJ = paramString;
      lKI = paramList;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.q.a
 * JD-Core Version:    0.7.0.1
 */