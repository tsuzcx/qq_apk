package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

final class ComposeUI$7
  implements View.OnClickListener
{
  ComposeUI$7(ComposeUI paramComposeUI) {}
  
  public final void onClick(View paramView)
  {
    ComposeUI.z(this.ngJ).setVisibility(8);
    ComposeUI.A(this.ngJ).setVisibility(0);
    ComposeUI.B(this.ngJ).setVisibility(0);
    ComposeUI.z(this.ngJ).post(new ComposeUI.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.7
 * JD-Core Version:    0.7.0.1
 */