package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.ui.base.p;

final class ComposeUI$11$2
  implements b.b
{
  ComposeUI$11$2(ComposeUI.11 param11) {}
  
  public final void btV()
  {
    ComposeUI.G(this.ngO.ngJ).setMessage(this.ngO.ngJ.getString(b.j.plugin_qqmail_attach_uploading));
  }
  
  public final void onComplete()
  {
    ComposeUI.a(this.ngO.ngJ, ComposeUI.H(this.ngO.ngJ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.11.2
 * JD-Core Version:    0.7.0.1
 */