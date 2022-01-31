package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.b.p.a;

final class ComposeUI$17
  extends p.a
{
  ComposeUI$17(ComposeUI paramComposeUI) {}
  
  public final void onComplete()
  {
    MailAddrsViewControl.b localb = new MailAddrsViewControl.b(this.ngJ, ComposeUI.d(this.ngJ).Li(null));
    this.ngJ.nfP.setAddrsAdapter(localb);
    ComposeUI.e(this.ngJ).setAddrsAdapter(localb);
    ComposeUI.f(this.ngJ).setAddrsAdapter(localb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.17
 * JD-Core Version:    0.7.0.1
 */