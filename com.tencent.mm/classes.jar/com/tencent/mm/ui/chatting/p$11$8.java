package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.ui.base.n.d;

final class p$11$8
  implements n.d
{
  p$11$8(p.11 param11) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(204950);
    if (paramInt == 0)
    {
      ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().a(p.e(this.Gnx.Gnt).GzJ.getContext(), LiveConfig.db(p.e(this.Gnx.Gnt).getTalkerUserName(), LiveConfig.qsG));
      AppMethodBeat.o(204950);
      return;
    }
    ((com.tencent.mm.live.a)g.ad(com.tencent.mm.live.a.class)).liveEntranceJumper().c(p.e(this.Gnx.Gnt).GzJ.getContext(), LiveConfig.db(p.e(this.Gnx.Gnt).getTalkerUserName(), LiveConfig.qsG));
    AppMethodBeat.o(204950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p.11.8
 * JD-Core Version:    0.7.0.1
 */