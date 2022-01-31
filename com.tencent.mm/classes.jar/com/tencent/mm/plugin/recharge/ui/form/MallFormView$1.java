package com.tencent.mm.plugin.recharge.ui.form;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallFormView$1
  implements TextWatcher
{
  private boolean pXO = false;
  
  MallFormView$1(MallFormView paramMallFormView) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(44375);
    if (this.pXP.asv() != this.pXO)
    {
      if (MallFormView.c(this.pXP) != null) {
        MallFormView.c(this.pXP).onInputValidChange(this.pXP.asv());
      }
      this.pXO = this.pXP.asv();
    }
    this.pXP.cfI();
    AppMethodBeat.o(44375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.MallFormView.1
 * JD-Core Version:    0.7.0.1
 */