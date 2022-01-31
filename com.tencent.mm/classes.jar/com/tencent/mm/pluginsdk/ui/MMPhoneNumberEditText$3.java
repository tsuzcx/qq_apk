package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMPhoneNumberEditText$3
  implements View.OnFocusChangeListener
{
  MMPhoneNumberEditText$3(MMPhoneNumberEditText paramMMPhoneNumberEditText) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(27494);
    if (MMPhoneNumberEditText.e(this.vQZ) != null) {
      MMPhoneNumberEditText.e(this.vQZ).onFocusChange(paramView, paramBoolean);
    }
    MMPhoneNumberEditText.c(this.vQZ);
    AppMethodBeat.o(27494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText.3
 * JD-Core Version:    0.7.0.1
 */