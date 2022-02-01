package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
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
    if (((x.AD(ContactInfoUI.e(this.xgj).field_username)) && (!v.aBa())) || ((x.Av(ContactInfoUI.e(this.xgj).field_username)) && (!v.aAW())) || ((x.Ax(ContactInfoUI.e(this.xgj).field_username)) && (!v.aBg())) || ((x.Ar(ContactInfoUI.e(this.xgj).field_username)) && (!v.aBk())))
    {
      paramMenuItem = new Intent();
      paramMenuItem.addFlags(67108864);
      b.iUz.p(paramMenuItem, this.xgj);
    }
    this.xgj.finish();
    c.b(ContactInfoUI.e(this.xgj).field_username, 1501, ContactInfoUI.h(this.xgj), ContactInfoUI.i(this.xgj));
    AppMethodBeat.o(26973);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.6
 * JD-Core Version:    0.7.0.1
 */