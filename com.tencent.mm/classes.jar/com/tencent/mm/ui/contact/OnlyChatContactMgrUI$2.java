package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;

final class OnlyChatContactMgrUI$2
  implements q.f
{
  OnlyChatContactMgrUI$2(OnlyChatContactMgrUI paramOnlyChatContactMgrUI) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(271196);
    paramo.b(0, this.XuL.getString(R.l.enf), R.g.default_icon);
    paramo.b(1, this.XuL.getString(R.l.ene), R.g.default_icon);
    paramo.b(2, this.XuL.getString(R.l.enc), R.g.default_icon);
    paramo.b(3, this.XuL.getString(R.l.enb), R.g.default_icon);
    AppMethodBeat.o(271196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OnlyChatContactMgrUI.2
 * JD-Core Version:    0.7.0.1
 */