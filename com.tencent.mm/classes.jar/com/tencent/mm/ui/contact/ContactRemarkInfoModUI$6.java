package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.b.c.a;

final class ContactRemarkInfoModUI$6
  implements c.a
{
  ContactRemarkInfoModUI$6(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void Tw(String paramString) {}
  
  public final void Tx(String paramString) {}
  
  public final void eY(String paramString)
  {
    AppMethodBeat.i(252992);
    k.s(this.afdA, R.l.settings_modify_remark_invalid_more, R.l.settings_modify_name_title);
    this.afdA.afdx = false;
    AppMethodBeat.o(252992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.6
 * JD-Core Version:    0.7.0.1
 */