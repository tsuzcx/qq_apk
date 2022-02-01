package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.l;

final class ContactInfoUI$6
  implements MenuItem.OnMenuItemClickListener
{
  ContactInfoUI$6(ContactInfoUI paramContactInfoUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26973);
    if (((w.sT(ContactInfoUI.e(this.uAr).field_username)) && (!u.arc())) || ((w.sL(ContactInfoUI.e(this.uAr).field_username)) && (!u.aqY())) || ((w.sN(ContactInfoUI.e(this.uAr).field_username)) && (!u.arh())) || ((w.sH(ContactInfoUI.e(this.uAr).field_username)) && (!u.ark())))
    {
      paramMenuItem = new Intent();
      paramMenuItem.addFlags(67108864);
      b.hYt.p(paramMenuItem, this.uAr);
    }
    this.uAr.finish();
    AppMethodBeat.o(26973);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.6
 * JD-Core Version:    0.7.0.1
 */