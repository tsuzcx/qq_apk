package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.statusbar.c.a;

final class ContactInfoUI$2
  implements c.a
{
  ContactInfoUI$2(ContactInfoUI paramContactInfoUI) {}
  
  public final void pB(int paramInt)
  {
    AppMethodBeat.i(23350);
    if (ContactInfoUI.e(this.pyI)) {
      ContactInfoUI.f(this.pyI).setPadding(0, paramInt, 0, 0);
    }
    AppMethodBeat.o(23350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactInfoUI.2
 * JD-Core Version:    0.7.0.1
 */