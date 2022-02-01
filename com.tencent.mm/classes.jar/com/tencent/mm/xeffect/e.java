package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/xeffect/XEffectLib;", "", "()V", "libLoader", "Lkotlin/Function1;", "", "", "load", "name", "setLoader", "loader", "renderlib_release"})
public final class e
{
  private static b<? super String, z> LYE;
  public static final e LYF;
  
  static
  {
    AppMethodBeat.i(217082);
    LYF = new e();
    LYE = (b)a.LYG;
    AppMethodBeat.o(217082);
  }
  
  public static void I(b<? super String, z> paramb)
  {
    AppMethodBeat.i(217080);
    p.h(paramb, "loader");
    LYE = paramb;
    AppMethodBeat.o(217080);
  }
  
  public static final void load(String paramString)
  {
    AppMethodBeat.i(217081);
    p.h(paramString, "name");
    LYE.invoke(paramString);
    AppMethodBeat.o(217081);
  }
  
  @l(gjZ={1, 1, 15}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements b<String, z>
  {
    public static final a LYG;
    
    static
    {
      AppMethodBeat.i(217079);
      LYG = new a();
      AppMethodBeat.o(217079);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.xeffect.e
 * JD-Core Version:    0.7.0.1
 */