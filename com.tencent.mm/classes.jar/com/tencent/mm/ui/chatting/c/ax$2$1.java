package com.tencent.mm.ui.chatting.c;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;

final class ax$2$1
  implements Runnable
{
  ax$2$1(ax.2 param2, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(35728);
    if (this.oRg == 0)
    {
      ax.b(this.HZf.HZd);
      this.HZf.HZd.a(bs.aLz(this.val$id), ChattingItemTranslate.b.IpG);
      ax.a(this.HZf.HZd, bs.aLz(this.val$id));
      AppMethodBeat.o(35728);
      return;
    }
    if (this.oRg == 3) {
      h.cg(this.HZf.HZd.cLy.HZF.getContext(), this.HZf.HZd.cLy.HZF.getMMResources().getString(2131757330));
    }
    for (;;)
    {
      this.HZf.HZd.a(bs.aLz(this.val$id), ChattingItemTranslate.b.IpD);
      this.HZf.HZd.cLy.bJU();
      AppMethodBeat.o(35728);
      return;
      if (this.oRg != 5) {
        h.cg(this.HZf.HZd.cLy.HZF.getContext(), this.HZf.HZd.cLy.HZF.getMMResources().getString(2131757325));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ax.2.1
 * JD-Core Version:    0.7.0.1
 */