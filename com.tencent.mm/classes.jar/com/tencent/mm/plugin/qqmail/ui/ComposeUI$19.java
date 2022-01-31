package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

final class ComposeUI$19
  implements MailAddrsViewControl.a
{
  ComposeUI$19(ComposeUI paramComposeUI) {}
  
  public final void b(MailAddrsViewControl paramMailAddrsViewControl)
  {
    h.a(this.ngJ.mController.uMN, this.ngJ.getString(b.j.plugin_qqmail_mail_addr_format_invalid), "", new ComposeUI.19.1(this, paramMailAddrsViewControl), new ComposeUI.19.2(this, paramMailAddrsViewControl));
  }
  
  public final void btW()
  {
    com.tencent.mm.ui.base.s.a(this.ngJ, this.ngJ.getString(b.j.plugin_qqmail_mail_addr_format_invalid), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.19
 * JD-Core Version:    0.7.0.1
 */