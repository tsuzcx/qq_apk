package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.i;
import com.tencent.mm.plugin.profile.a;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class b$2$2
  implements n.d
{
  b$2$2(b.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      y.w("MicroMsg.ContactWidgetNewBizInfo", "default onMMMenuItemSelected err");
    }
    do
    {
      do
      {
        return;
        paramMenuItem = this.mZB.mZA;
        Intent localIntent = new Intent();
        localIntent.setClass(paramMenuItem.mZy, NewBizInfoMoreInofUI.class);
        localIntent.putExtra("Contact_User", paramMenuItem.dnp.field_username);
        if (paramMenuItem.mZy.getIntent() != null) {
          localIntent.putExtras(paramMenuItem.mZy.getIntent());
        }
        paramMenuItem.mZy.startActivity(localIntent);
        c.cg(paramMenuItem.dnp.field_username, 700);
        return;
        paramMenuItem = this.mZB.mZA;
        localIntent = new Intent();
        localIntent.putExtra("Select_Talker_Name", paramMenuItem.dnp.field_username);
        localIntent.putExtra("Select_block_List", paramMenuItem.dnp.field_username);
        localIntent.putExtra("Select_Send_Card", true);
        localIntent.putExtra("Select_Conv_Type", 3);
        localIntent.putExtra("mutil_select_is_ret", true);
        a.eUR.a(localIntent, paramMenuItem.mZy);
        c.cg(paramMenuItem.dnp.field_username, 800);
        return;
        paramMenuItem = this.mZB.mZA;
        localIntent = new Intent();
        localIntent.setClass(paramMenuItem.mZy, NewBizInfoSettingUI.class);
        localIntent.putExtra("Contact_User", paramMenuItem.dnp.field_username);
        if (paramMenuItem.mZy.getIntent() != null) {
          localIntent.putExtras(paramMenuItem.mZy.getIntent());
        }
        paramMenuItem.mZy.startActivity(localIntent);
        return;
        c.cg(this.mZB.mZA.dnp.field_username, 903);
        i.gz(this.mZB.mZA.dnp.field_username);
        b.a(this.mZB.mZA);
      } while ((com.tencent.mm.storage.s.ctL()) && (!f.kY(this.mZB.mZA.dnp.field_username)));
      h.bC(this.mZB.mZA.mZy, this.mZB.mZA.mZy.getString(R.l.main_conversation_placedtop_tips));
      return;
      com.tencent.mm.model.s.u(this.mZB.mZA.dnp.field_username, true);
      c.cg(this.mZB.mZA.dnp.field_username, 904);
      b.a(this.mZB.mZA);
    } while ((com.tencent.mm.storage.s.ctL()) && (!f.kY(this.mZB.mZA.dnp.field_username)));
    h.bC(this.mZB.mZA.mZy, this.mZB.mZA.mZy.getString(R.l.biz_time_line_unplacedtop_tips));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.2.2
 * JD-Core Version:    0.7.0.1
 */