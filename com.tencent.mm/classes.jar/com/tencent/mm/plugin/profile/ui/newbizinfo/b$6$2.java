package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.i;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class b$6$2
  implements n.d
{
  b$6$2(b.6 param6) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(153583);
    switch (paramMenuItem.getItemId())
    {
    default: 
      ab.w("MicroMsg.ContactWidgetNewBizInfo", "default onMMMenuItemSelected err");
    }
    do
    {
      do
      {
        AppMethodBeat.o(153583);
        return;
        paramMenuItem = this.pDp.pDl;
        Intent localIntent = new Intent();
        localIntent.setClass(paramMenuItem.pDe, NewBizInfoMoreInofUI.class);
        localIntent.putExtra("Contact_User", paramMenuItem.contact.field_username);
        if (paramMenuItem.pDe.getIntent() != null) {
          localIntent.putExtras(paramMenuItem.pDe.getIntent());
        }
        paramMenuItem.pDe.startActivity(localIntent);
        c.cZ(paramMenuItem.contact.field_username, 700);
        AppMethodBeat.o(153583);
        return;
        paramMenuItem = this.pDp.pDl;
        localIntent = new Intent();
        localIntent.putExtra("Select_Talker_Name", paramMenuItem.contact.field_username);
        localIntent.putExtra("Select_block_List", paramMenuItem.contact.field_username);
        localIntent.putExtra("Select_Send_Card", true);
        localIntent.putExtra("Select_Conv_Type", 3);
        localIntent.putExtra("mutil_select_is_ret", true);
        com.tencent.mm.plugin.profile.b.gmO.a(localIntent, paramMenuItem.pDe);
        c.cZ(paramMenuItem.contact.field_username, 800);
        AppMethodBeat.o(153583);
        return;
        paramMenuItem = this.pDp.pDl;
        localIntent = new Intent();
        localIntent.setClass(paramMenuItem.pDe, NewBizInfoSettingUI.class);
        localIntent.putExtra("Contact_User", paramMenuItem.contact.field_username);
        localIntent.putExtra("key_start_biz_profile_setting_from_scene", 2);
        if (paramMenuItem.pDe.getIntent() != null) {
          localIntent.putExtras(paramMenuItem.pDe.getIntent());
        }
        paramMenuItem.pDe.startActivity(localIntent);
        AppMethodBeat.o(153583);
        return;
        c.cZ(this.pDp.pDl.contact.field_username, 903);
        i.nh(this.pDp.pDl.contact.field_username);
        b.a(this.pDp.pDl);
      } while ((s.aWl()) && (!f.rT(this.pDp.pDl.contact.field_username)));
      h.bO(this.pDp.pDl.pDe, this.pDp.pDl.pDe.getString(2131301407));
      AppMethodBeat.o(153583);
      return;
      t.y(this.pDp.pDl.contact.field_username, true);
      c.cZ(this.pDp.pDl.contact.field_username, 904);
      b.a(this.pDp.pDl);
    } while ((s.aWl()) && (!f.rT(this.pDp.pDl.contact.field_username)));
    h.bO(this.pDp.pDl.pDe, this.pDp.pDl.pDe.getString(2131297726));
    AppMethodBeat.o(153583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.6.2
 * JD-Core Version:    0.7.0.1
 */