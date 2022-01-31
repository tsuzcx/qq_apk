package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;

final class VoiceSearchEditText$2
  implements TextWatcher
{
  VoiceSearchEditText$2(VoiceSearchEditText paramVoiceSearchEditText) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    VoiceSearchEditText.a(this.vbN, true);
    VoiceSearchEditText.e(this.vbN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.VoiceSearchEditText.2
 * JD-Core Version:    0.7.0.1
 */