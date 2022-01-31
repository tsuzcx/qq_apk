package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

final class ContactInfoUI$b
  implements Runnable
{
  private WeakReference<ContactInfoUI> bJz;
  private bv pyJ;
  
  ContactInfoUI$b(ContactInfoUI paramContactInfoUI, bv parambv)
  {
    AppMethodBeat.i(153561);
    this.bJz = new WeakReference(paramContactInfoUI);
    this.pyJ = parambv;
    AppMethodBeat.o(153561);
  }
  
  public final void run()
  {
    AppMethodBeat.i(153562);
    ContactInfoUI localContactInfoUI = (ContactInfoUI)this.bJz.get();
    if ((localContactInfoUI == null) || (localContactInfoUI.isFinishing()) || (localContactInfoUI.isDestroyed()))
    {
      AppMethodBeat.o(153562);
      return;
    }
    if ((ContactInfoUI.g(localContactInfoUI) != null) && (this.pyJ != null) && (!bo.isNullOrNil(ContactInfoUI.g(localContactInfoUI).field_username)) && (ContactInfoUI.g(localContactInfoUI).field_username.equals(this.pyJ.field_encryptUsername)) && (!t.oE(ContactInfoUI.g(localContactInfoUI).field_username)))
    {
      ContactInfoUI.g(localContactInfoUI).jn(this.pyJ.field_conRemark);
      localContactInfoUI.getIntent().putExtra("Contact_User", ContactInfoUI.g(localContactInfoUI).field_username);
      if (ContactInfoUI.i(localContactInfoUI) != null)
      {
        ContactInfoUI.i(localContactInfoUI).bkb();
        ContactInfoUI.j(localContactInfoUI).removeAll();
      }
      localContactInfoUI.initView();
    }
    AppMethodBeat.o(153562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.b
 * JD-Core Version:    0.7.0.1
 */