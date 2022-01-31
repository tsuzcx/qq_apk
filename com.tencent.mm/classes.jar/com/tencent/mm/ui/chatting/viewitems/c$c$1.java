package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R.l;
import com.tencent.mm.as.f;
import com.tencent.mm.as.g;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.z;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

final class c$c$1
  implements View.OnCreateContextMenuListener
{
  c$c$1(c.c paramc, c paramc1) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenuInfo = (aw)paramView.getTag();
    if (paramContextMenuInfo == null) {}
    int i;
    do
    {
      return;
      i = paramContextMenuInfo.position;
      paramContextMenuInfo = paramContextMenuInfo.bWO;
      if (paramContextMenuInfo == null)
      {
        y.e("MicroMsg.ChattingItem", "msg is null!");
        return;
      }
      boolean bool = this.vBh.vAX.a(paramContextMenu, paramView, paramContextMenuInfo);
      if ((ad.aaT(c.c.a(this.vBh).getTalkerUserName())) || (ad.aaR(c.c.a(this.vBh).getTalkerUserName())))
      {
        y.i("MicroMsg.ChattingItem", "on create context menu, match qcontact or tcontact, remove favorite menu item");
        paramContextMenu.removeItem(116);
      }
      if (!bool) {
        break;
      }
      if (c.c.a(this.vBh).cFF()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
      }
      if (((!bf.k(paramContextMenuInfo)) && (this.vBh.vAX.cHd()) && (c.c.a(this.vBh).cFF())) || (c.c.a(this.vBh).pSb.cua())) {
        paramContextMenu.add(i, 122, 0, c.c.a(this.vBh).vtz.getMMResources().getString(R.l.chatting_long_click_menu_more));
      }
      if (paramContextMenu.findItem(123) != null) {
        paramContextMenu.removeItem(100);
      }
    } while (bf.k(paramContextMenuInfo));
    c.c.a(this.vBh, paramContextMenu, paramContextMenuInfo, i);
    return;
    if (paramContextMenuInfo.ctB())
    {
      au.Hx();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        ((z)c.c.a(this.vBh).ac(z.class)).a(paramContextMenu, i, paramContextMenuInfo);
      }
    }
    for (;;)
    {
      if (paramContextMenuInfo.field_status == 5)
      {
        paramContextMenu.add(i, 103, 0, c.c.a(this.vBh).vtz.getMMResources().getString(R.l.chatting_long_click_menu_resend_msg_img));
        f.c(o.OJ().q(paramContextMenuInfo));
      }
      if (paramContextMenu.findItem(123) != null) {
        paramContextMenu.removeItem(100);
      }
      if (bf.k(paramContextMenuInfo)) {
        break;
      }
      c.c.a(this.vBh, paramContextMenu, paramContextMenuInfo, i);
      return;
      if (paramContextMenuInfo.cvj()) {
        paramContextMenu.add(i, 100, 0, c.c.a(this.vBh).vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c.c.1
 * JD-Core Version:    0.7.0.1
 */