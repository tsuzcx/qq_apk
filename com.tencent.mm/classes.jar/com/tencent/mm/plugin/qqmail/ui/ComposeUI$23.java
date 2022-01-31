package com.tencent.mm.plugin.qqmail.ui;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

final class ComposeUI$23
  implements View.OnFocusChangeListener
{
  ComposeUI$23(ComposeUI paramComposeUI) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      ComposeUI.j(this.ngJ).setSelection(ComposeUI.j(this.ngJ).getText().length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.23
 * JD-Core Version:    0.7.0.1
 */