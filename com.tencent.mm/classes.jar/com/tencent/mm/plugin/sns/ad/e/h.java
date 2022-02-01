package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;

public final class h
{
  public static void a(b paramb)
  {
    AppMethodBeat.i(197709);
    if (paramb == null)
    {
      AppMethodBeat.o(197709);
      return;
    }
    i.b(paramb.dSj(), paramb.dSk(), 0, 0, paramb.dSi());
    AppMethodBeat.o(197709);
  }
  
  public static abstract class a
    implements h.b
  {
    public final String dSi()
    {
      return "";
    }
  }
  
  public static abstract interface b
  {
    public abstract String dSi();
    
    public abstract String dSj();
    
    public abstract String dSk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.h
 * JD-Core Version:    0.7.0.1
 */