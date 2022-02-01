package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/XEffectLib;", "", "()V", "libLoader", "Lkotlin/Function1;", "", "", "load", "name", "setLoader", "loader", "renderlib_release"})
public final class d
{
  private static b<? super String, x> RxM;
  public static final d RxN;
  
  static
  {
    AppMethodBeat.i(237047);
    RxN = new d();
    RxM = (b)a.RxO;
    AppMethodBeat.o(237047);
  }
  
  public static void R(b<? super String, x> paramb)
  {
    AppMethodBeat.i(237045);
    p.h(paramb, "loader");
    RxM = paramb;
    AppMethodBeat.o(237045);
  }
  
  public static final void load(String paramString)
  {
    AppMethodBeat.i(237046);
    p.h(paramString, "name");
    RxM.invoke(paramString);
    AppMethodBeat.o(237046);
  }
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements b<String, x>
  {
    public static final a RxO;
    
    static
    {
      AppMethodBeat.i(237044);
      RxO = new a();
      AppMethodBeat.o(237044);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.xeffect.d
 * JD-Core Version:    0.7.0.1
 */