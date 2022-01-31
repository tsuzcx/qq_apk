package com.tenpay.android.wechat;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TenpaySecureEditText$2
  implements View.OnFocusChangeListener
{
  TenpaySecureEditText$2(TenpaySecureEditText paramTenpaySecureEditText) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(49461);
    if (!paramBoolean)
    {
      this.this$0.setCompoundDrawables(this.this$0.getCompoundDrawables()[0], this.this$0.getCompoundDrawables()[1], null, this.this$0.getCompoundDrawables()[3]);
      AppMethodBeat.o(49461);
      return;
    }
    if ((!this.this$0.getText().toString().equals("")) && (TenpaySecureEditText.EditState.PASSWORD != this.this$0.mEditState) && (TenpaySecureEditText.EditState.CVV_PAYMENT != this.this$0.mEditState) && (TenpaySecureEditText.EditState.CVV_4_PAYMENT != this.this$0.mEditState)) {
      this.this$0.setCompoundDrawables(this.this$0.getCompoundDrawables()[0], this.this$0.getCompoundDrawables()[1], TenpaySecureEditText.access$000(this.this$0), this.this$0.getCompoundDrawables()[3]);
    }
    AppMethodBeat.o(49461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tenpay.android.wechat.TenpaySecureEditText.2
 * JD-Core Version:    0.7.0.1
 */