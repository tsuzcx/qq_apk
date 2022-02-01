package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class p
  implements com.tencent.mm.plugin.sns.b.p
{
  private static volatile p DqX = null;
  
  public static p eWt()
  {
    AppMethodBeat.i(94916);
    if (DqX == null) {}
    try
    {
      if (DqX == null) {
        DqX = new p();
      }
      p localp = DqX;
      AppMethodBeat.o(94916);
      return localp;
    }
    finally
    {
      AppMethodBeat.o(94916);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.p
 * JD-Core Version:    0.7.0.1
 */