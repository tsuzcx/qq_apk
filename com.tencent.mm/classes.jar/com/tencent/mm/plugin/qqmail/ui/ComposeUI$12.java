package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.s;

final class ComposeUI$12
  implements am.a
{
  ComposeUI$12(ComposeUI paramComposeUI) {}
  
  public final boolean tC()
  {
    if ((this.ngJ.ngm) && (ComposeUI.a(this.ngJ, false)) && (ComposeUI.a(this.ngJ) == 5))
    {
      ComposeUI.b(this.ngJ);
      if (ComposeUI.c(this.ngJ) != null) {
        ComposeUI.c(this.ngJ).dismiss();
      }
      ComposeUI.a(this.ngJ, s.a(this.ngJ, this.ngJ.getString(b.j.plugin_qqmail_composeui_auto_save), 2000L));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.12
 * JD-Core Version:    0.7.0.1
 */