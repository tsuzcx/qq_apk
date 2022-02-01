package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

final class ContactInfoUI$b
  implements Runnable
{
  private WeakReference<ContactInfoUI> cqo;
  private bw uAs;
  
  ContactInfoUI$b(ContactInfoUI paramContactInfoUI, bw parambw)
  {
    AppMethodBeat.i(26980);
    this.cqo = new WeakReference(paramContactInfoUI);
    this.uAs = parambw;
    AppMethodBeat.o(26980);
  }
  
  public final void run()
  {
    AppMethodBeat.i(26981);
    ContactInfoUI localContactInfoUI = (ContactInfoUI)this.cqo.get();
    ad.i("MicroMsg.ContactInfoUI", "onNotifyChange stranger %s", new Object[] { this.uAs });
    if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
    {
      AppMethodBeat.o(26981);
      return;
    }
    ad.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(ContactInfoUI.h(localContactInfoUI)), ContactInfoUI.e(localContactInfoUI).field_username, this.uAs });
    if ((ContactInfoUI.e(localContactInfoUI) != null) && (this.uAs != null) && (!bt.isNullOrNil(ContactInfoUI.e(localContactInfoUI).field_username)) && (ContactInfoUI.e(localContactInfoUI).field_username.equals(this.uAs.field_encryptUsername)) && (!w.tp(ContactInfoUI.e(localContactInfoUI).field_username)))
    {
      ContactInfoUI.e(localContactInfoUI).nb(this.uAs.field_conRemark);
      localContactInfoUI.getIntent().putExtra("Contact_User", ContactInfoUI.e(localContactInfoUI).field_username);
      if (ContactInfoUI.i(localContactInfoUI) != null)
      {
        ContactInfoUI.i(localContactInfoUI).bRu();
        ContactInfoUI.j(localContactInfoUI).removeAll();
      }
      localContactInfoUI.initView();
    }
    AppMethodBeat.o(26981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.b
 * JD-Core Version:    0.7.0.1
 */