package com.tencent.mm.plugin.textstatus.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.n;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/logic/StatusLoadLogicFactory;", "", "()V", "get", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "getProfileLogic", "Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "plugin-textstatus_release"})
public final class e
{
  public static final e FYH;
  
  static
  {
    AppMethodBeat.i(216156);
    FYH = new e();
    AppMethodBeat.o(216156);
  }
  
  public static d a(n paramn)
  {
    AppMethodBeat.i(216154);
    p.h(paramn, "showParam");
    paramn = (d)new b(paramn);
    AppMethodBeat.o(216154);
    return paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.d.e
 * JD-Core Version:    0.7.0.1
 */