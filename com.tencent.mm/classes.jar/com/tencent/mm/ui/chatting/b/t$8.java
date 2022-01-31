package com.tencent.mm.ui.chatting.b;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.h.a.td;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.ui.chatting.e;

final class t$8
  implements MenuItem.OnMenuItemClickListener
{
  t$8(t paramt) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    td localtd = new td();
    localtd.ccJ.bNb = 5;
    localtd.ccJ.talker = this.vqY.byx.pSb.field_username;
    localtd.ccJ.context = this.vqY.byx.vtz.getContext();
    if (paramMenuItem.getItemId() == 1) {
      localtd.ccJ.ccE = 4;
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.udP.m(localtd);
      return true;
      if (paramMenuItem.getItemId() == 2) {
        localtd.ccJ.ccE = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.t.8
 * JD-Core Version:    0.7.0.1
 */