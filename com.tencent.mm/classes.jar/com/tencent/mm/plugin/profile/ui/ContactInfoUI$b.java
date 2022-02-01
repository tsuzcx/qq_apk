package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

final class ContactInfoUI$b
  implements Runnable
{
  private WeakReference<ContactInfoUI> cyH;
  private bl xgk;
  
  ContactInfoUI$b(ContactInfoUI paramContactInfoUI, bl parambl)
  {
    AppMethodBeat.i(186524);
    this.cyH = new WeakReference(paramContactInfoUI);
    this.xgk = parambl;
    AppMethodBeat.o(186524);
  }
  
  public final void run()
  {
    AppMethodBeat.i(186525);
    ContactInfoUI localContactInfoUI = (ContactInfoUI)this.cyH.get();
    ae.i("MicroMsg.ContactInfoUI", "onNotifyStrangerChange friendUser %s", new Object[] { this.xgk });
    if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
    {
      AppMethodBeat.o(186525);
      return;
    }
    boolean bool = ContactInfoUI.j(localContactInfoUI);
    String str2 = ContactInfoUI.e(localContactInfoUI).field_username;
    if (this.xgk != null) {}
    for (String str1 = this.xgk.field_encryptUsername;; str1 = "")
    {
      ae.i("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[] { Boolean.valueOf(bool), str2, str1 });
      if ((ContactInfoUI.e(localContactInfoUI) != null) && (this.xgk != null) && (!bu.isNullOrNil(ContactInfoUI.e(localContactInfoUI).field_username)) && (ContactInfoUI.e(localContactInfoUI).field_username.equals(this.xgk.field_encryptUsername)) && (!x.Ba(ContactInfoUI.e(localContactInfoUI).field_username)))
      {
        str1 = this.xgk.field_username;
        if ((!bu.isNullOrNil(str1)) && (!str1.equals(ContactInfoUI.e(localContactInfoUI).field_username))) {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1430, 4);
        }
        if (!bu.isNullOrNil(str1)) {
          ContactInfoUI.a(localContactInfoUI, ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(str1));
        }
        localContactInfoUI.getIntent().putExtra("Contact_User", ContactInfoUI.e(localContactInfoUI).field_username);
        if (ContactInfoUI.k(localContactInfoUI) != null)
        {
          ContactInfoUI.k(localContactInfoUI).ceC();
          ContactInfoUI.l(localContactInfoUI).removeAll();
        }
        localContactInfoUI.initView();
      }
      AppMethodBeat.o(186525);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.b
 * JD-Core Version:    0.7.0.1
 */