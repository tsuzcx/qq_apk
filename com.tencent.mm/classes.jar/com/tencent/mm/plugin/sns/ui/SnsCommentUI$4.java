package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;

final class SnsCommentUI$4
  implements TextWatcher
{
  SnsCommentUI$4(SnsCommentUI paramSnsCommentUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SnsCommentUI.b(this.oXZ).getText().toString().trim().length() > 0)
    {
      this.oXZ.enableOptionMenu(true);
      return;
    }
    this.oXZ.enableOptionMenu(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentUI.4
 * JD-Core Version:    0.7.0.1
 */