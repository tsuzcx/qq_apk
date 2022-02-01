package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/xeffect/XEffectLib;", "", "()V", "libLoader", "Lkotlin/Function1;", "", "", "load", "name", "setLoader", "loader", "renderlib_release"})
public final class e
{
  private static b<? super String, z> OfK;
  public static final e OfL;
  
  static
  {
    AppMethodBeat.i(221433);
    OfL = new e();
    OfK = (b)e.c.OfM;
    AppMethodBeat.o(221433);
  }
  
  public static void N(b<? super String, z> paramb)
  {
    AppMethodBeat.i(221431);
    p.h(paramb, "loader");
    OfK = paramb;
    AppMethodBeat.o(221431);
  }
  
  public static final void load(String paramString)
  {
    AppMethodBeat.i(221432);
    p.h(paramString, "name");
    OfK.invoke(paramString);
    AppMethodBeat.o(221432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.xeffect.e
 * JD-Core Version:    0.7.0.1
 */