package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

final class ContactInfoUI$a
  implements Runnable
{
  private WeakReference<ContactInfoUI> cqo;
  private String flk;
  
  ContactInfoUI$a(ContactInfoUI paramContactInfoUI, String paramString)
  {
    AppMethodBeat.i(26978);
    this.cqo = new WeakReference(paramContactInfoUI);
    this.flk = paramString;
    AppMethodBeat.o(26978);
  }
  
  public final void run()
  {
    AppMethodBeat.i(26979);
    ContactInfoUI localContactInfoUI = (ContactInfoUI)this.cqo.get();
    ad.i("MicroMsg.ContactInfoUI", "onNotifyChange contact %s", new Object[] { this.flk });
    if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
    {
      AppMethodBeat.o(26979);
      return;
    }
    ad.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(ContactInfoUI.h(localContactInfoUI)), ContactInfoUI.e(localContactInfoUI).field_username, this.flk });
    if ((ContactInfoUI.e(localContactInfoUI) != null) && (!bt.isNullOrNil(ContactInfoUI.e(localContactInfoUI).field_username)) && ((ContactInfoUI.e(localContactInfoUI).field_username.equals(this.flk)) || (ContactInfoUI.e(localContactInfoUI).field_username.equals(af.aHM(this.flk)))))
    {
      ContactInfoUI.a(localContactInfoUI, ((k)g.ab(k.class)).apM().aHY(this.flk));
      if (ContactInfoUI.i(localContactInfoUI) != null)
      {
        ContactInfoUI.i(localContactInfoUI).bRu();
        ContactInfoUI.j(localContactInfoUI).removeAll();
      }
      localContactInfoUI.initView();
    }
    AppMethodBeat.o(26979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.a
 * JD-Core Version:    0.7.0.1
 */