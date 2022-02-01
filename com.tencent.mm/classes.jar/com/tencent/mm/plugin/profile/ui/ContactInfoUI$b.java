package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

final class ContactInfoUI$b
  implements Runnable
{
  private WeakReference<ContactInfoUI> cya;
  private bk wQt;
  
  ContactInfoUI$b(ContactInfoUI paramContactInfoUI, bk parambk)
  {
    AppMethodBeat.i(193250);
    this.cya = new WeakReference(paramContactInfoUI);
    this.wQt = parambk;
    AppMethodBeat.o(193250);
  }
  
  public final void run()
  {
    AppMethodBeat.i(193251);
    ContactInfoUI localContactInfoUI = (ContactInfoUI)this.cya.get();
    ad.i("MicroMsg.ContactInfoUI", "onNotifyStrangerChange friendUser %s", new Object[] { this.wQt });
    if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
    {
      AppMethodBeat.o(193251);
      return;
    }
    boolean bool = ContactInfoUI.j(localContactInfoUI);
    String str2 = ContactInfoUI.e(localContactInfoUI).field_username;
    if (this.wQt != null) {}
    for (String str1 = this.wQt.field_encryptUsername;; str1 = "")
    {
      ad.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(bool), str2, str1 });
      if ((ContactInfoUI.e(localContactInfoUI) != null) && (this.wQt != null) && (!bt.isNullOrNil(ContactInfoUI.e(localContactInfoUI).field_username)) && (ContactInfoUI.e(localContactInfoUI).field_username.equals(this.wQt.field_encryptUsername)) && (!w.Aq(ContactInfoUI.e(localContactInfoUI).field_username)))
      {
        str1 = this.wQt.field_username;
        if ((!bt.isNullOrNil(str1)) && (!str1.equals(ContactInfoUI.e(localContactInfoUI).field_username))) {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1430, 4);
        }
        if (!bt.isNullOrNil(str1)) {
          ContactInfoUI.a(localContactInfoUI, ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(str1));
        }
        localContactInfoUI.getIntent().putExtra("Contact_User", ContactInfoUI.e(localContactInfoUI).field_username);
        if (ContactInfoUI.k(localContactInfoUI) != null)
        {
          ContactInfoUI.k(localContactInfoUI).cdn();
          ContactInfoUI.l(localContactInfoUI).removeAll();
        }
        localContactInfoUI.initView();
      }
      AppMethodBeat.o(193251);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.b
 * JD-Core Version:    0.7.0.1
 */