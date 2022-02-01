package com.tencent.mm.plugin.textstatus.ui;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.zx;
import com.tencent.mm.autogen.a.zx.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$configUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StatusIconConfigUpdateEvent;", "callback", "", "event", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusEditActivity$configUpdateListener$1
  extends IListener<zx>
{
  TextStatusEditActivity$configUpdateListener$1(TextStatusEditActivity paramTextStatusEditActivity, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(291780);
    AppMethodBeat.o(291780);
  }
  
  private static final void a(zx paramzx, TextStatusEditActivity paramTextStatusEditActivity)
  {
    AppMethodBeat.i(291789);
    s.u(paramzx, "$it");
    s.u(paramTextStatusEditActivity, "this$0");
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "config update old" + paramzx.idv.idw + " new:" + paramzx.idv.idy);
    TextStatusEditActivity.l(paramTextStatusEditActivity);
    TextStatusEditActivity.m(paramTextStatusEditActivity);
    AppMethodBeat.o(291789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.configUpdateListener.1
 * JD-Core Version:    0.7.0.1
 */