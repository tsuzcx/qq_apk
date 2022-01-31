package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;

final class SnsUploadUI$8
  implements TextWatcher
{
  SnsUploadUI$8(SnsUploadUI paramSnsUploadUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SnsUploadUI.f(this.pjp).getText().toString().trim().length() > 0)
    {
      this.pjp.enableOptionMenu(true);
      return;
    }
    this.pjp.enableOptionMenu(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.8
 * JD-Core Version:    0.7.0.1
 */