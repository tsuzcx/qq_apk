package com.tencent.mm.plugin.textstatus.conversation.g;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.textstatus.a.r.a;
import com.tencent.mm.plugin.textstatus.conversation.b.b;
import com.tencent.mm.plugin.textstatus.conversation.e.a;
import com.tencent.mm.plugin.textstatus.proto.u;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/service/TextStatusOplogService;", "", "()V", "oplogReq", "", "item", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCmdItem;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "callback", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusContactService$OplogCallback;", "items", "Ljava/util/LinkedList;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e Tjy;
  
  static
  {
    AppMethodBeat.i(291082);
    Tjy = new e();
    AppMethodBeat.o(291082);
  }
  
  public static void a(LinkedList<u> paramLinkedList, q paramq, final r.a parama)
  {
    AppMethodBeat.i(291073);
    kotlin.g.b.s.u(paramLinkedList, "items");
    paramLinkedList = new b(paramLinkedList);
    if (paramq == null)
    {
      com.tencent.mm.kernel.h.aZW().a((p)paramLinkedList, 0);
      AppMethodBeat.o(291073);
      return;
    }
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.aZW();
    kotlin.g.b.s.s(locals, "getNetSceneQueue()");
    a.a(locals, (p)paramLinkedList, paramq, (com.tencent.mm.am.h)new a(paramLinkedList, parama));
    AppMethodBeat.o(291073);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/conversation/service/TextStatusOplogService$oplogReq$2", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "_scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.am.h
  {
    a(b paramb, r.a parama) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(291081);
      com.tencent.mm.kernel.h.aZW().c(this.Tjz.getType(), (com.tencent.mm.am.h)this);
      com.tencent.mm.kernel.h.aZW().b(this.Tjz.getType(), (com.tencent.mm.am.h)this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        parama.Fv(true);
        AppMethodBeat.o(291081);
        return;
      }
      parama.Fv(false);
      AppMethodBeat.o(291081);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.g.e
 * JD-Core Version:    0.7.0.1
 */