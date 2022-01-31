package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.a.f;

final class ContactSearchUI$5
  implements DialogInterface.OnCancelListener
{
  ContactSearchUI$5(ContactSearchUI paramContactSearchUI, f paramf) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(25529);
    aw.Rc().a(this.mWB);
    AppMethodBeat.o(25529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI.5
 * JD-Core Version:    0.7.0.1
 */