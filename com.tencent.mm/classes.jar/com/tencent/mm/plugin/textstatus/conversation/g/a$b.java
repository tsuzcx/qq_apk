package com.tencent.mm.plugin.textstatus.conversation.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.textstatus.a.r.b;
import com.tencent.mm.plugin.textstatus.conversation.b.a;
import com.tencent.mm.plugin.textstatus.proto.g;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/conversation/service/TextStatusContactService$fetchContact$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "_scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
  implements com.tencent.mm.am.h
{
  a$b(a parama, r.b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(291084);
    com.tencent.mm.kernel.h.aZW().c(this.Tjr.getType(), (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(this.Tjr.getType(), (com.tencent.mm.am.h)this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.Tjr.TiE;
      if (paramString != null)
      {
        paramp = this.Tjs;
        if (paramp != null) {
          paramp.onDone(true, (List)paramString.ToF);
        }
        AppMethodBeat.o(291084);
      }
    }
    else
    {
      paramString = this.Tjs;
      if (paramString != null) {
        paramString.onDone(false, null);
      }
    }
    AppMethodBeat.o(291084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.g.a.b
 * JD-Core Version:    0.7.0.1
 */