package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bz;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

final class ContactInfoUI$b
  implements Runnable
{
  private WeakReference<ContactInfoUI> cnv;
  private bz vJl;
  
  ContactInfoUI$b(ContactInfoUI paramContactInfoUI, bz parambz)
  {
    AppMethodBeat.i(26980);
    this.cnv = new WeakReference(paramContactInfoUI);
    this.vJl = parambz;
    AppMethodBeat.o(26980);
  }
  
  public final void run()
  {
    AppMethodBeat.i(26981);
    ContactInfoUI localContactInfoUI = (ContactInfoUI)this.cnv.get();
    ac.i("MicroMsg.ContactInfoUI", "onNotifyChange stranger %s", new Object[] { this.vJl });
    if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
    {
      AppMethodBeat.o(26981);
      return;
    }
    ac.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(ContactInfoUI.h(localContactInfoUI)), ContactInfoUI.e(localContactInfoUI).field_username, this.vJl });
    if ((ContactInfoUI.e(localContactInfoUI) != null) && (this.vJl != null) && (!bs.isNullOrNil(ContactInfoUI.e(localContactInfoUI).field_username)) && (ContactInfoUI.e(localContactInfoUI).field_username.equals(this.vJl.field_encryptUsername)) && (!w.xs(ContactInfoUI.e(localContactInfoUI).field_username)))
    {
      ContactInfoUI.e(localContactInfoUI).qh(this.vJl.field_conRemark);
      localContactInfoUI.getIntent().putExtra("Contact_User", ContactInfoUI.e(localContactInfoUI).field_username);
      if (ContactInfoUI.i(localContactInfoUI) != null)
      {
        ContactInfoUI.i(localContactInfoUI).bYJ();
        ContactInfoUI.j(localContactInfoUI).removeAll();
      }
      localContactInfoUI.initView();
    }
    AppMethodBeat.o(26981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.b
 * JD-Core Version:    0.7.0.1
 */