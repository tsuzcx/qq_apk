package com.tencent.mm.plugin.textstatus.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.x;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/logic/StatusLoadLogicFactory;", "", "()V", "get", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "getDetailLogic", "getProfileLogic", "Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f Tmq;
  
  static
  {
    AppMethodBeat.i(289741);
    Tmq = new f();
    AppMethodBeat.o(289741);
  }
  
  public static e a(x paramx)
  {
    AppMethodBeat.i(289727);
    s.u(paramx, "showParam");
    paramx = (e)new c(paramx);
    AppMethodBeat.o(289727);
    return paramx;
  }
  
  public static d b(x paramx)
  {
    AppMethodBeat.i(289732);
    s.u(paramx, "showParam");
    paramx = (d)new b(paramx);
    AppMethodBeat.o(289732);
    return paramx;
  }
  
  public static e c(x paramx)
  {
    AppMethodBeat.i(289736);
    s.u(paramx, "showParam");
    paramx = (e)new a(paramx);
    AppMethodBeat.o(289736);
    return paramx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.f
 * JD-Core Version:    0.7.0.1
 */