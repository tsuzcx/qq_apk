package com.tencent.mm.ui.chatting.c;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class y$16
  implements n.d
{
  y$16(y paramy) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(204956);
    if (paramInt == 0)
    {
      ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().a(this.Gwf.cOd.GzJ.getContext(), LiveConfig.db(this.Gwf.cOd.getTalkerUserName(), LiveConfig.qsG));
      AppMethodBeat.o(204956);
      return;
    }
    ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(this.Gwf.cOd.GzJ.getContext(), LiveConfig.db(this.Gwf.cOd.getTalkerUserName(), LiveConfig.qsG));
    AppMethodBeat.o(204956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.y.16
 * JD-Core Version:    0.7.0.1
 */