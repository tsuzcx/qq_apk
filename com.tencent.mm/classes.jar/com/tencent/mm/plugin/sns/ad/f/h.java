package com.tencent.mm.plugin.sns.ad.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.j;

public final class h
{
  public static void a(b paramb)
  {
    AppMethodBeat.i(219181);
    if (paramb == null)
    {
      AppMethodBeat.o(219181);
      return;
    }
    j.b(paramb.dVH(), paramb.dVI(), 0, 0, paramb.dVG());
    AppMethodBeat.o(219181);
  }
  
  public static abstract class a
    implements h.b
  {
    public final String dVG()
    {
      return "";
    }
  }
  
  public static abstract interface b
  {
    public abstract String dVG();
    
    public abstract String dVH();
    
    public abstract String dVI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.h
 * JD-Core Version:    0.7.0.1
 */