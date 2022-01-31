package com.tencent.mm.plugin.remittance.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;

final class RemittanceBusiUI$23
  implements TextWatcher
{
  RemittanceBusiUI$23(RemittanceBusiUI paramRemittanceBusiUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(44917);
    RemittanceBusiUI.g(this.qoF);
    if (RemittanceBusiUI.h(this.qoF) == 32)
    {
      paramEditable = this.qoF;
      if (RemittanceBusiUI.i(this.qoF) != null) {
        break label55;
      }
    }
    label55:
    for (int i = 400;; i = RemittanceBusiUI.i(this.qoF).qiW)
    {
      RemittanceBusiUI.a(paramEditable, null, i);
      AppMethodBeat.o(44917);
      return;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.23
 * JD-Core Version:    0.7.0.1
 */