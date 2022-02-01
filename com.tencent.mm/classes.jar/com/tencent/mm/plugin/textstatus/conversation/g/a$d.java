package com.tencent.mm.plugin.textstatus.conversation.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.textstatus.conversation.b.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/conversation/service/TextStatusContactService$replyGreeting$1$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$d
  implements com.tencent.mm.am.h
{
  a$d(c paramc, b<? super Boolean, ah> paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(291106);
    com.tencent.mm.kernel.h.aZW().c(this.Tju.getType(), (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(this.Tju.getType(), (com.tencent.mm.am.h)this);
    paramString = this.$callback;
    if (paramString != null) {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      paramString.invoke(Boolean.valueOf(bool));
      AppMethodBeat.o(291106);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.g.a.d
 * JD-Core Version:    0.7.0.1
 */