package com.tencent.mm.ui.chatting.viewitems;

import android.view.MenuItem;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.b.b.u;
import com.tencent.mm.ui.chatting.c.a;

final class c$c$a
  implements n.d
{
  public bi bFH;
  
  c$c$a(c.c paramc) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (this.bFH == null)
    {
      y.e("MicroMsg.ChattingItem", "context item select failed, null msg");
      return;
    }
    this.vBh.vAX.a(paramMenuItem, c.c.a(this.vBh), this.bFH);
    ((u)c.c.a(this.vBh).ac(u.class)).a(paramMenuItem, this.vBh.vAX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c.c.a
 * JD-Core Version:    0.7.0.1
 */