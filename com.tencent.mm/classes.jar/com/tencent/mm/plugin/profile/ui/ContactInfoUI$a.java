package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

final class ContactInfoUI$a
  implements Runnable
{
  private WeakReference<ContactInfoUI> cyH;
  private String fIQ;
  
  ContactInfoUI$a(ContactInfoUI paramContactInfoUI, String paramString)
  {
    AppMethodBeat.i(26978);
    this.cyH = new WeakReference(paramContactInfoUI);
    this.fIQ = paramString;
    AppMethodBeat.o(26978);
  }
  
  public final void run()
  {
    AppMethodBeat.i(26979);
    ContactInfoUI localContactInfoUI = (ContactInfoUI)this.cyH.get();
    ae.i("MicroMsg.ContactInfoUI", "onNotifyChange contact %s", new Object[] { this.fIQ });
    if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
    {
      AppMethodBeat.o(26979);
      return;
    }
    ae.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(ContactInfoUI.j(localContactInfoUI)), ContactInfoUI.e(localContactInfoUI).field_username, this.fIQ });
    if ((ContactInfoUI.e(localContactInfoUI) != null) && (!bu.isNullOrNil(ContactInfoUI.e(localContactInfoUI).field_username)) && ((ContactInfoUI.e(localContactInfoUI).field_username.equals(this.fIQ)) || (ContactInfoUI.e(localContactInfoUI).field_username.equals(an.aUA(this.fIQ)))))
    {
      ContactInfoUI.a(localContactInfoUI, ((l)g.ab(l.class)).azF().BH(this.fIQ));
      if (ContactInfoUI.k(localContactInfoUI) != null)
      {
        ContactInfoUI.k(localContactInfoUI).ceC();
        ContactInfoUI.l(localContactInfoUI).removeAll();
      }
      localContactInfoUI.initView();
    }
    AppMethodBeat.o(26979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.a
 * JD-Core Version:    0.7.0.1
 */