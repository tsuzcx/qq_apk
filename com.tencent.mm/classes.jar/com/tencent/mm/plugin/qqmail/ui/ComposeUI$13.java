package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.ui.base.h;

final class ComposeUI$13
  implements View.OnClickListener
{
  ComposeUI$13(ComposeUI paramComposeUI) {}
  
  public final void onClick(View paramView)
  {
    if (!ComposeUI.E(this.ngJ).bud())
    {
      ComposeUI.a(this.ngJ, h.b(this.ngJ, this.ngJ.getString(b.j.plugin_qqmail_attach_uploading), true, new ComposeUI.13.1(this)));
      ComposeUI.E(this.ngJ).nhG = new ComposeUI.13.2(this);
      return;
    }
    s.c(ComposeUI.s(this.ngJ), ComposeUI.n(this.ngJ), ComposeUI.x(this.ngJ));
    ComposeUI.I(this.ngJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.13
 * JD-Core Version:    0.7.0.1
 */