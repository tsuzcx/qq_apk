package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.m;

final class ContactInfoUI$6
  implements MenuItem.OnMenuItemClickListener
{
  ContactInfoUI$6(ContactInfoUI paramContactInfoUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26973);
    if (((w.zT(ContactInfoUI.e(this.wQs).field_username)) && (!u.aAK())) || ((w.zL(ContactInfoUI.e(this.wQs).field_username)) && (!u.aAG())) || ((w.zN(ContactInfoUI.e(this.wQs).field_username)) && (!u.aAQ())) || ((w.zH(ContactInfoUI.e(this.wQs).field_username)) && (!u.aAU())))
    {
      paramMenuItem = new Intent();
      paramMenuItem.addFlags(67108864);
      b.iRG.p(paramMenuItem, this.wQs);
    }
    this.wQs.finish();
    c.b(ContactInfoUI.e(this.wQs).field_username, 1501, ContactInfoUI.h(this.wQs), ContactInfoUI.i(this.wQs));
    AppMethodBeat.o(26973);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.6
 * JD-Core Version:    0.7.0.1
 */