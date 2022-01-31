package com.tencent.mm.ui.chatting.h;

import android.view.MenuItem;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.a.c.b;

final class h$2$2
  implements n.d
{
  h$2$2(h.2 param2, c.b paramb, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (this.vyC == null)
    {
      y.e("MicroMsg.UrlHistoryListPresenter", "item is null! position:%s", new Object[] { Integer.valueOf(this.kX) });
      return;
    }
    au.Hx();
    paramMenuItem = c.Fy().fd(this.vyC.bIt);
    this.vzk.vzi.d(paramInt, paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.h.2.2
 * JD-Core Version:    0.7.0.1
 */