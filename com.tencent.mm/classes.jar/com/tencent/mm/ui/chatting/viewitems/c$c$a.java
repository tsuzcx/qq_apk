package com.tencent.mm.ui.chatting.viewitems;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.widget.textview.a.f;

final class c$c$a
  implements n.d
{
  public bi cmQ;
  
  c$c$a(c.c paramc) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(32794);
    if (this.cmQ == null)
    {
      ab.e("MicroMsg.ChattingItem", "context item select failed, null msg");
      AppMethodBeat.o(32794);
      return;
    }
    this.zRJ.zRy.a(paramMenuItem, c.c.b(this.zRJ), this.cmQ);
    ((v)c.c.b(this.zRJ).ay(v.class)).a(paramMenuItem, this.zRJ.zRy);
    if (c.c.c(this.zRJ) != null) {
      c.c.c(this.zRJ).dismiss();
    }
    AppMethodBeat.o(32794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c.c.a
 * JD-Core Version:    0.7.0.1
 */