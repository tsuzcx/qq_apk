package com.tenpay.android.wechat;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class TenpaySecureEditText$2
  implements View.OnFocusChangeListener
{
  TenpaySecureEditText$2(TenpaySecureEditText paramTenpaySecureEditText) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.this$0.setCompoundDrawables(this.this$0.getCompoundDrawables()[0], this.this$0.getCompoundDrawables()[1], null, this.this$0.getCompoundDrawables()[3]);
    }
    while ((this.this$0.getText().toString().equals("")) || (TenpaySecureEditText.EditState.PASSWORD == this.this$0.mEditState) || (TenpaySecureEditText.EditState.CVV_PAYMENT == this.this$0.mEditState) || (TenpaySecureEditText.EditState.CVV_4_PAYMENT == this.this$0.mEditState)) {
      return;
    }
    this.this$0.setCompoundDrawables(this.this$0.getCompoundDrawables()[0], this.this$0.getCompoundDrawables()[1], TenpaySecureEditText.access$000(this.this$0), this.this$0.getCompoundDrawables()[3]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tenpay.android.wechat.TenpaySecureEditText.2
 * JD-Core Version:    0.7.0.1
 */