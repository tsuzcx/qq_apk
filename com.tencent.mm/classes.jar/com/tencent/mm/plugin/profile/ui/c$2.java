package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.profile.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class c$2
  implements n.d
{
  c$2(c paramc) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      paramMenuItem = this.mWY;
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Talker_Name", paramMenuItem.dnp.field_username);
      localIntent.putExtra("Select_block_List", paramMenuItem.dnp.field_username);
      localIntent.putExtra("Select_Send_Card", true);
      localIntent.putExtra("Select_Conv_Type", 3);
      localIntent.putExtra("mutil_select_is_ret", true);
      a.eUR.a(localIntent, paramMenuItem.bER);
      return;
    case 2: 
      this.mWY.bER.getString(R.l.fmt_delcontactmsg_confirm, new Object[] { this.mWY.dnp.Bq() });
      h.a(this.mWY.bER, this.mWY.bER.getString(R.l.contact_info_biz_clear_msg_tips), "", this.mWY.bER.getString(R.l.contact_info_biz_clear_msg), this.mWY.bER.getString(R.l.app_cancel), new c.2.1(this), null);
      return;
    case 3: 
      this.mWY.bsB();
      return;
    case 4: 
      paramMenuItem = this.mWY;
      ((com.tencent.mm.pluginsdk.g)com.tencent.mm.kernel.g.r(com.tencent.mm.pluginsdk.g.class)).a(paramMenuItem.mVy, paramMenuItem.bER, paramMenuItem.dnp, true, new c.3(paramMenuItem));
      return;
    }
    paramMenuItem = this.mWY;
    y.d("MicroMsg.ContactWidgetBizInfo", "dealAddShortcut, username = " + paramMenuItem.dnp.field_username);
    b.U(paramMenuItem.bER, paramMenuItem.dnp.field_username);
    ai.l(new c.8(paramMenuItem), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.2
 * JD-Core Version:    0.7.0.1
 */