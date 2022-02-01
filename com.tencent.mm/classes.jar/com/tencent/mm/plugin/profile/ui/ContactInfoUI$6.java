package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
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
    if (((w.wW(ContactInfoUI.e(this.vJk).field_username)) && (!u.axS())) || ((w.wO(ContactInfoUI.e(this.vJk).field_username)) && (!u.axO())) || ((w.wQ(ContactInfoUI.e(this.vJk).field_username)) && (!u.axX())) || ((w.wK(ContactInfoUI.e(this.vJk).field_username)) && (!u.aya())))
    {
      paramMenuItem = new Intent();
      paramMenuItem.addFlags(67108864);
      b.iyx.p(paramMenuItem, this.vJk);
    }
    this.vJk.finish();
    AppMethodBeat.o(26973);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.6
 * JD-Core Version:    0.7.0.1
 */