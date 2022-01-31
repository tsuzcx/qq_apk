package com.tencent.mm.plugin.qqmail.ui;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class ComposeUI$3
  implements View.OnClickListener
{
  ComposeUI$3(ComposeUI paramComposeUI) {}
  
  public final void onClick(View paramView)
  {
    ComposeUI.j(this.ngJ).getText().clear();
    ComposeUI.j(this.ngJ).requestFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.3
 * JD-Core Version:    0.7.0.1
 */