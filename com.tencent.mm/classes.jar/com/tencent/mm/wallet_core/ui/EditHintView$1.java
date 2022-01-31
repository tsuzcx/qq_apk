package com.tencent.mm.wallet_core.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tenpay.android.wechat.TenpaySecureEditText;

final class EditHintView$1
  implements TextWatcher
{
  EditHintView$1(EditHintView paramEditHintView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(49182);
    boolean bool = this.AYr.asv();
    if ((bool != EditHintView.c(this.AYr)) && (EditHintView.d(this.AYr) != null))
    {
      ab.d("MicroMsg.EditHintView", "View:" + EditHintView.e(this.AYr) + ", editType:" + EditHintView.f(this.AYr) + " inputValid change to " + bool);
      EditHintView.a(this.AYr, bool);
      EditHintView.d(this.AYr);
      EditHintView.c(this.AYr);
    }
    EditHintView.g(this.AYr);
    AppMethodBeat.o(49182);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(49181);
    if ((EditHintView.a(this.AYr) == 4) && (this.AYr.asv()))
    {
      EditHintView.b(this.AYr);
      this.AYr.AYg.ClearInput();
    }
    AppMethodBeat.o(49181);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView.1
 * JD-Core Version:    0.7.0.1
 */