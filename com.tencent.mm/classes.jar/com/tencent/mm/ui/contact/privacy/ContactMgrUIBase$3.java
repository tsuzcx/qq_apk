package com.tencent.mm.ui.contact.privacy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;

final class ContactMgrUIBase$3
  implements q.f
{
  ContactMgrUIBase$3(ContactMgrUIBase paramContactMgrUIBase) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(290578);
    paramo.b(0, this.XyB.getString(R.l.enc), R.g.default_icon);
    paramo.b(1, this.XyB.getString(R.l.ePc), R.g.default_icon);
    paramo.b(2, this.XyB.getString(R.l.enb), R.g.default_icon);
    AppMethodBeat.o(290578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.ContactMgrUIBase.3
 * JD-Core Version:    0.7.0.1
 */