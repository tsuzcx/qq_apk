package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.cg;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

final class ContactInfoUI$c
  implements Runnable
{
  private WeakReference<ContactInfoUI> cyH;
  private cg xgl;
  
  ContactInfoUI$c(ContactInfoUI paramContactInfoUI, cg paramcg)
  {
    AppMethodBeat.i(26980);
    this.cyH = new WeakReference(paramContactInfoUI);
    this.xgl = paramcg;
    AppMethodBeat.o(26980);
  }
  
  public final void run()
  {
    AppMethodBeat.i(26981);
    ContactInfoUI localContactInfoUI = (ContactInfoUI)this.cyH.get();
    ae.i("MicroMsg.ContactInfoUI", "onNotifyChange stranger %s", new Object[] { this.xgl });
    if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
    {
      AppMethodBeat.o(26981);
      return;
    }
    ae.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(ContactInfoUI.j(localContactInfoUI)), ContactInfoUI.e(localContactInfoUI).field_username, this.xgl });
    if ((ContactInfoUI.e(localContactInfoUI) != null) && (this.xgl != null) && (!bu.isNullOrNil(ContactInfoUI.e(localContactInfoUI).field_username)) && (ContactInfoUI.e(localContactInfoUI).field_username.equals(this.xgl.field_encryptUsername)) && (!x.Ba(ContactInfoUI.e(localContactInfoUI).field_username)))
    {
      ContactInfoUI.e(localContactInfoUI).tm(this.xgl.field_conRemark);
      localContactInfoUI.getIntent().putExtra("Contact_User", ContactInfoUI.e(localContactInfoUI).field_username);
      if (ContactInfoUI.k(localContactInfoUI) != null)
      {
        ContactInfoUI.k(localContactInfoUI).ceC();
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