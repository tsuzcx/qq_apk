package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;

final class MMPhoneNumberEditText$3
  implements View.OnFocusChangeListener
{
  MMPhoneNumberEditText$3(MMPhoneNumberEditText paramMMPhoneNumberEditText) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (MMPhoneNumberEditText.e(this.saj) != null) {
      MMPhoneNumberEditText.e(this.saj).onFocusChange(paramView, paramBoolean);
    }
    MMPhoneNumberEditText.c(this.saj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.3
 * JD-Core Version:    0.7.0.1
 */