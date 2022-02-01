package com.tencent.mm.plugin.textstatus;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.textstatus.a.f.a;
import com.tencent.mm.plugin.textstatus.h.c;
import com.tencent.mm.plugin.textstatus.proto.d;
import com.tencent.mm.ui.base.w;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/PluginTextStatus$getVerifyInfoForWeRun$1$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "_scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginTextStatus$c
  implements com.tencent.mm.am.h
{
  PluginTextStatus$c(c paramc, f.a parama, w paramw) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(289634);
    com.tencent.mm.kernel.h.aZW().c(this.Tbx.getType(), (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(this.Tbx.getType(), (com.tencent.mm.am.h)this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.Tbx.TmF;
      if (paramString != null) {
        this.Tby.aB(true, paramString.ToE);
      }
    }
    for (;;)
    {
      this.yjx.dismiss();
      AppMethodBeat.o(289634);
      return;
      this.Tby.aB(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.PluginTextStatus.c
 * JD-Core Version:    0.7.0.1
 */