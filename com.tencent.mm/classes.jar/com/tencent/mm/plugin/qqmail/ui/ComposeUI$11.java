package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

final class ComposeUI$11
  implements View.OnClickListener
{
  ComposeUI$11(ComposeUI paramComposeUI) {}
  
  public final void onClick(View paramView)
  {
    this.ngJ.XM();
    ComposeUI.j(this.ngJ).getText().toString();
    ComposeUI.D(this.ngJ);
    if (!this.ngJ.btU()) {
      return;
    }
    paramView = this.ngJ;
    ComposeUI localComposeUI = this.ngJ;
    this.ngJ.getString(b.j.app_tip);
    ComposeUI.a(paramView, h.b(localComposeUI, this.ngJ.getString(b.j.plugin_qqmail_compose_send_ing), true, new ComposeUI.11.1(this)));
    if (!ComposeUI.E(this.ngJ).bud())
    {
      ComposeUI.G(this.ngJ).setMessage(this.ngJ.getString(b.j.plugin_qqmail_attach_uploading));
      ComposeUI.E(this.ngJ).nhG = new ComposeUI.11.2(this);
      return;
    }
    ComposeUI.a(this.ngJ, ComposeUI.H(this.ngJ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.11
 * JD-Core Version:    0.7.0.1
 */