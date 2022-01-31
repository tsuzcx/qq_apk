package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;

final class c$2
  implements n.d
{
  c$2(c paramc) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(23458);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23458);
      return;
      paramMenuItem = this.pzT;
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Talker_Name", paramMenuItem.contact.field_username);
      localIntent.putExtra("Select_block_List", paramMenuItem.contact.field_username);
      localIntent.putExtra("Select_Send_Card", true);
      localIntent.putExtra("Select_Conv_Type", 3);
      localIntent.putExtra("mutil_select_is_ret", true);
      com.tencent.mm.plugin.profile.b.gmO.a(localIntent, paramMenuItem.cmc);
      AppMethodBeat.o(23458);
      return;
      this.pzT.cmc.getString(2131300036, new Object[] { this.pzT.contact.Of() });
      com.tencent.mm.ui.base.h.d(this.pzT.cmc, this.pzT.cmc.getString(2131298539), "", this.pzT.cmc.getString(2131298538), this.pzT.cmc.getString(2131296888), new c.2.1(this), null);
      AppMethodBeat.o(23458);
      return;
      this.pzT.cch();
      AppMethodBeat.o(23458);
      return;
      paramMenuItem = this.pzT;
      ((com.tencent.mm.pluginsdk.h)g.E(com.tencent.mm.pluginsdk.h.class)).a(paramMenuItem.pyd, paramMenuItem.cmc, paramMenuItem.contact, true, new c.3(paramMenuItem));
      AppMethodBeat.o(23458);
      return;
      paramMenuItem = this.pzT;
      ab.d("MicroMsg.ContactWidgetBizInfo", "dealAddShortcut, username = " + paramMenuItem.contact.field_username);
      com.tencent.mm.plugin.base.model.b.Z(paramMenuItem.cmc, paramMenuItem.contact.field_username);
      al.p(new c.8(paramMenuItem), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.2
 * JD-Core Version:    0.7.0.1
 */