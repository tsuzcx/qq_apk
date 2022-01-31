package com.tencent.mm.wallet_core.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.y;
import com.tenpay.android.wechat.TenpaySecureEditText;

final class EditHintView$1
  implements TextWatcher
{
  EditHintView$1(EditHintView paramEditHintView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    boolean bool = this.wBY.YL();
    if ((bool != EditHintView.c(this.wBY)) && (EditHintView.d(this.wBY) != null))
    {
      y.d("MicroMsg.EditHintView", "View:" + EditHintView.e(this.wBY) + ", editType:" + EditHintView.f(this.wBY) + " inputValid change to " + bool);
      EditHintView.a(this.wBY, bool);
    }
    EditHintView.g(this.wBY);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((EditHintView.a(this.wBY) == 4) && (this.wBY.YL()))
    {
      EditHintView.b(this.wBY);
      this.wBY.wBN.ClearInput();
    }
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView.1
 * JD-Core Version:    0.7.0.1
 */