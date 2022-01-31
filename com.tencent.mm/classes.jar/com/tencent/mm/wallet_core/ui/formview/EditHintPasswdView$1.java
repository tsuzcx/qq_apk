package com.tencent.mm.wallet_core.ui.formview;

import android.text.Editable;
import android.text.TextWatcher;

final class EditHintPasswdView$1
  implements TextWatcher
{
  EditHintPasswdView$1(EditHintPasswdView paramEditHintPasswdView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (EditHintPasswdView.b(this.wCO) != null) {
      EditHintPasswdView.b(this.wCO).gG(EditHintPasswdView.c(this.wCO));
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.1
 * JD-Core Version:    0.7.0.1
 */