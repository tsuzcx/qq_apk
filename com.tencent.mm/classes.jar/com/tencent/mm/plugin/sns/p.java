package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.q;

public class p
  implements q
{
  private static volatile p JwC = null;
  
  public static p fJw()
  {
    AppMethodBeat.i(94916);
    if (JwC == null) {}
    try
    {
      if (JwC == null) {
        JwC = new p();
      }
      p localp = JwC;
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