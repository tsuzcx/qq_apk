package com.tencent.mm.plugin.textstatus.conversation.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/service/TextStatusMsgService;", "", "()V", "hasRecvMsg", "", "markHasRecvMsg", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d Tjx;
  
  static
  {
    AppMethodBeat.i(291072);
    Tjx = new d();
    AppMethodBeat.o(291072);
  }
  
  public static boolean hGA()
  {
    AppMethodBeat.i(291070);
    Object localObject = h.baE().ban().get(at.a.adhk, null);
    if ((localObject instanceof Boolean)) {}
    for (localObject = (Boolean)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(291070);
      return false;
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(291070);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.g.d
 * JD-Core Version:    0.7.0.1
 */