package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

final class ContactInfoUI$a
  implements Runnable
{
  private WeakReference<ContactInfoUI> bJz;
  private String eaX;
  
  ContactInfoUI$a(ContactInfoUI paramContactInfoUI, String paramString)
  {
    AppMethodBeat.i(153559);
    this.bJz = new WeakReference(paramContactInfoUI);
    this.eaX = paramString;
    AppMethodBeat.o(153559);
  }
  
  public final void run()
  {
    AppMethodBeat.i(153560);
    ContactInfoUI localContactInfoUI = (ContactInfoUI)this.bJz.get();
    if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
    {
      AppMethodBeat.o(153560);
      return;
    }
    ab.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(ContactInfoUI.h(localContactInfoUI)), ContactInfoUI.g(localContactInfoUI).field_username, this.eaX });
    if ((ContactInfoUI.g(localContactInfoUI) != null) && (!bo.isNullOrNil(ContactInfoUI.g(localContactInfoUI).field_username)) && ((ContactInfoUI.g(localContactInfoUI).field_username.equals(this.eaX)) || (ContactInfoUI.g(localContactInfoUI).field_username.equals(ad.ark(this.eaX)))))
    {
      if (ContactInfoUI.i(localContactInfoUI) != null)
      {
        ContactInfoUI.i(localContactInfoUI).bkb();
        ContactInfoUI.j(localContactInfoUI).removeAll();
      }
      localContactInfoUI.initView();
    }
    AppMethodBeat.o(153560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.a
 * JD-Core Version:    0.7.0.1
 */