package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class p
  implements com.tencent.mm.plugin.sns.c.p
{
  private static volatile p wvV = null;
  
  public static p drl()
  {
    AppMethodBeat.i(94916);
    if (wvV == null) {}
    try
    {
      if (wvV == null) {
        wvV = new p();
      }
      p localp = wvV;
      AppMethodBeat.o(94916);
      return localp;
    }
    finally
    {
      AppMethodBeat.o(94916);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.p
 * JD-Core Version:    0.7.0.1
 */