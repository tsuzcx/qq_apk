package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.b.p.a;

final class ComposeUI$17
  extends p.a
{
  ComposeUI$17(ComposeUI paramComposeUI) {}
  
  public final void onComplete()
  {
    AppMethodBeat.i(68195);
    MailAddrsViewControl.b localb = new MailAddrsViewControl.b(this.pLX, ComposeUI.d(this.pLX).Xs(null));
    this.pLX.pLe.setAddrsAdapter(localb);
    ComposeUI.e(this.pLX).setAddrsAdapter(localb);
    ComposeUI.f(this.pLX).setAddrsAdapter(localb);
    AppMethodBeat.o(68195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.17
 * JD-Core Version:    0.7.0.1
 */