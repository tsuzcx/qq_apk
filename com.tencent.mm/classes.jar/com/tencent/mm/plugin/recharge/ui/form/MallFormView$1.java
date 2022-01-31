package com.tencent.mm.plugin.recharge.ui.form;

import android.text.Editable;
import android.text.TextWatcher;

final class MallFormView$1
  implements TextWatcher
{
  private boolean nsA = false;
  
  MallFormView$1(MallFormView paramMallFormView) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.nsB.YL() != this.nsA)
    {
      if (MallFormView.c(this.nsB) != null) {
        MallFormView.c(this.nsB).gG(this.nsB.YL());
      }
      this.nsA = this.nsB.YL();
    }
    this.nsB.bvp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.MallFormView.1
 * JD-Core Version:    0.7.0.1
 */