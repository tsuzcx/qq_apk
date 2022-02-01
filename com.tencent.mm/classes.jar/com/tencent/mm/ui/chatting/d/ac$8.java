package com.tencent.mm.ui.chatting.d;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class ac$8
  implements o.g
{
  ac$8(ac paramac) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(233116);
    if (paramInt == 0)
    {
      ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().a(this.Prh.dom.Pwc.getContext(), LiveConfig.V(this.Prh.dom.getTalkerUserName(), LiveConfig.hvS));
      AppMethodBeat.o(233116);
      return;
    }
    ((com.tencent.mm.live.a)g.ah(com.tencent.mm.live.a.class)).liveEntranceJumper().c(this.Prh.dom.Pwc.getContext(), LiveConfig.V(this.Prh.dom.getTalkerUserName(), LiveConfig.hvS));
    AppMethodBeat.o(233116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ac.8
 * JD-Core Version:    0.7.0.1
 */