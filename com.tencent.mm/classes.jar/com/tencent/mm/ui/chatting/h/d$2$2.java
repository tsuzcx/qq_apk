package com.tencent.mm.ui.chatting.h;

import android.view.MenuItem;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.a.c.b;

final class d$2$2
  implements n.d
{
  d$2$2(d.2 param2, c.b paramb) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    au.Hx();
    bi localbi = c.Fy().fd(this.vyC.bIt);
    this.vyQ.vyO.d(paramMenuItem.getItemId(), localbi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.d.2.2
 * JD-Core Version:    0.7.0.1
 */