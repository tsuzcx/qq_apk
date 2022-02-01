package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/XEffectLib;", "", "()V", "libLoader", "Lkotlin/Function1;", "", "", "load", "name", "setLoader", "loader", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class f
{
  private static b<? super String, ah> agXE;
  public static final f agXF;
  
  static
  {
    AppMethodBeat.i(234529);
    agXF = new f();
    agXE = (b)a.agXG;
    AppMethodBeat.o(234529);
  }
  
  public static void aZ(b<? super String, ah> paramb)
  {
    AppMethodBeat.i(234507);
    s.t(paramb, "loader");
    agXE = paramb;
    AppMethodBeat.o(234507);
  }
  
  public static final void load(String paramString)
  {
    AppMethodBeat.i(234517);
    s.t(paramString, "name");
    agXE.invoke(paramString);
    AppMethodBeat.o(234517);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class a
    extends u
    implements b<String, ah>
  {
    public static final a agXG;
    
    static
    {
      AppMethodBeat.i(234495);
      agXG = new a();
      AppMethodBeat.o(234495);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.xeffect.f
 * JD-Core Version:    0.7.0.1
 */