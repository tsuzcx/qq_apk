package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ContactInfoUI$9
  implements View.OnClickListener
{
  ContactInfoUI$9(ContactInfoUI paramContactInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153558);
    ab.i("MicroMsg.ContactInfoUI", "onClick: actionBarClick action_bar_root");
    ContactInfoUI.k(this.pyI);
    AppMethodBeat.o(153558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.9
 * JD-Core Version:    0.7.0.1
 */