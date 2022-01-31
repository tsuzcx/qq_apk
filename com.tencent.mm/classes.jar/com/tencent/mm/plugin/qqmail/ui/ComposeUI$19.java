package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;

final class ComposeUI$19
  implements MailAddrsViewControl.a
{
  ComposeUI$19(ComposeUI paramComposeUI) {}
  
  public final void b(MailAddrsViewControl paramMailAddrsViewControl)
  {
    AppMethodBeat.i(68201);
    h.a(this.pLX.getContext(), this.pLX.getString(2131302141), "", new ComposeUI.19.1(this, paramMailAddrsViewControl), new ComposeUI.19.2(this, paramMailAddrsViewControl));
    AppMethodBeat.o(68201);
  }
  
  public final void cei()
  {
    AppMethodBeat.i(68202);
    t.a(this.pLX, this.pLX.getString(2131302141), 1500L);
    AppMethodBeat.o(68202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.19
 * JD-Core Version:    0.7.0.1
 */