package com.tencent.mm.plugin.textstatus.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.x;
import com.tencent.mm.plugin.textstatus.h.f.b;
import com.tencent.mm.plugin.textstatus.proto.t;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/logic/BaseDetailLoadLogic;", "Lcom/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "(Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;)V", "update", "", "username", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "extraParam", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCardShowExtraParam;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c
{
  public a(x paramx)
  {
    super(paramx);
    AppMethodBeat.i(289733);
    AppMethodBeat.o(289733);
  }
  
  public final boolean b(String paramString, b paramb, t paramt)
  {
    AppMethodBeat.i(289738);
    s.u(paramString, "username");
    boolean bool = super.b(paramString, paramb, paramt);
    AppMethodBeat.o(289738);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.a
 * JD-Core Version:    0.7.0.1
 */