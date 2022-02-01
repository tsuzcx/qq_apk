package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

final class ContactInfoUI$a
  implements Runnable
{
  private WeakReference<ContactInfoUI> cnv;
  private String foE;
  
  ContactInfoUI$a(ContactInfoUI paramContactInfoUI, String paramString)
  {
    AppMethodBeat.i(26978);
    this.cnv = new WeakReference(paramContactInfoUI);
    this.foE = paramString;
    AppMethodBeat.o(26978);
  }
  
  public final void run()
  {
    AppMethodBeat.i(26979);
    ContactInfoUI localContactInfoUI = (ContactInfoUI)this.cnv.get();
    ac.i("MicroMsg.ContactInfoUI", "onNotifyChange contact %s", new Object[] { this.foE });
    if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
    {
      AppMethodBeat.o(26979);
      return;
    }
    ac.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(ContactInfoUI.h(localContactInfoUI)), ContactInfoUI.e(localContactInfoUI).field_username, this.foE });
    if ((ContactInfoUI.e(localContactInfoUI) != null) && (!bs.isNullOrNil(ContactInfoUI.e(localContactInfoUI).field_username)) && ((ContactInfoUI.e(localContactInfoUI).field_username.equals(this.foE)) || (ContactInfoUI.e(localContactInfoUI).field_username.equals(ai.aNh(this.foE)))))
    {
      ContactInfoUI.a(localContactInfoUI, ((k)g.ab(k.class)).awB().aNt(this.foE));
      if (ContactInfoUI.i(localContactInfoUI) != null)
      {
        ContactInfoUI.i(localContactInfoUI).bYJ();
        ContactInfoUI.j(localContactInfoUI).removeAll();
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