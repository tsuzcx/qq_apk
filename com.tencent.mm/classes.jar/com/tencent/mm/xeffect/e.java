package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/XEffectLib;", "", "()V", "libLoader", "Lkotlin/Function1;", "", "", "load", "name", "setLoader", "loader", "renderlib_release"})
public final class e
{
  private static b<? super String, x> YZs;
  public static final e YZt;
  
  static
  {
    AppMethodBeat.i(195670);
    YZt = new e();
    YZs = (b)a.YZu;
    AppMethodBeat.o(195670);
  }
  
  public static void ah(b<? super String, x> paramb)
  {
    AppMethodBeat.i(195665);
    p.k(paramb, "loader");
    YZs = paramb;
    AppMethodBeat.o(195665);
  }
  
  public static final void load(String paramString)
  {
    AppMethodBeat.i(195667);
    p.k(paramString, "name");
    YZs.invoke(paramString);
    AppMethodBeat.o(195667);
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements b<String, x>
  {
    public static final a YZu;
    
    static
    {
      AppMethodBeat.i(195663);
      YZu = new a();
      AppMethodBeat.o(195663);
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