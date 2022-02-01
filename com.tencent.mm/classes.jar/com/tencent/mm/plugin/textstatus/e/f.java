package com.tencent.mm.plugin.textstatus.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.r;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/logic/StatusLoadLogicFactory;", "", "()V", "get", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "getDetailLogic", "getProfileLogic", "Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "plugin-textstatus_release"})
public final class f
{
  public static final f MCG;
  
  static
  {
    AppMethodBeat.i(238788);
    MCG = new f();
    AppMethodBeat.o(238788);
  }
  
  public static e a(r paramr)
  {
    AppMethodBeat.i(238775);
    p.k(paramr, "showParam");
    paramr = (e)new c(paramr);
    AppMethodBeat.o(238775);
    return paramr;
  }
  
  public static d b(r paramr)
  {
    AppMethodBeat.i(238779);
    p.k(paramr, "showParam");
    paramr = (d)new b(paramr);
    AppMethodBeat.o(238779);
    return paramr;
  }
  
  public static e c(r paramr)
  {
    AppMethodBeat.i(238782);
    p.k(paramr, "showParam");
    paramr = (e)new a(paramr);
    AppMethodBeat.o(238782);
    return paramr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.e.f
 * JD-Core Version:    0.7.0.1
 */