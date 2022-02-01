package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

final class ContactInfoUI$c
  implements Runnable
{
  private WeakReference<ContactInfoUI> cya;
  private cf wQu;
  
  ContactInfoUI$c(ContactInfoUI paramContactInfoUI, cf paramcf)
  {
    AppMethodBeat.i(26980);
    this.cya = new WeakReference(paramContactInfoUI);
    this.wQu = paramcf;
    AppMethodBeat.o(26980);
  }
  
  public final void run()
  {
    AppMethodBeat.i(26981);
    ContactInfoUI localContactInfoUI = (ContactInfoUI)this.cya.get();
    ad.i("MicroMsg.ContactInfoUI", "onNotifyChange stranger %s", new Object[] { this.wQu });
    if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
    {
      AppMethodBeat.o(26981);
      return;
    }
    ad.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(ContactInfoUI.j(localContactInfoUI)), ContactInfoUI.e(localContactInfoUI).field_username, this.wQu });
    if ((ContactInfoUI.e(localContactInfoUI) != null) && (this.wQu != null) && (!bt.isNullOrNil(ContactInfoUI.e(localContactInfoUI).field_username)) && (ContactInfoUI.e(localContactInfoUI).field_username.equals(this.wQu.field_encryptUsername)) && (!w.Aq(ContactInfoUI.e(localContactInfoUI).field_username)))
    {
      ContactInfoUI.e(localContactInfoUI).sR(this.wQu.field_conRemark);
      localContactInfoUI.getIntent().putExtra("Contact_User", ContactInfoUI.e(localContactInfoUI).field_username);
      if (ContactInfoUI.k(localContactInfoUI) != null)
      {
        ContactInfoUI.k(localContactInfoUI).cdn();
        ContactInfoUI.l(localContactInfoUI).removeAll();
      }
      localContactInfoUI.initView();
    }
    AppMethodBeat.o(26981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.c
 * JD-Core Version:    0.7.0.1
 */