package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoiceSearchEditText$2
  implements TextWatcher
{
  VoiceSearchEditText$2(VoiceSearchEditText paramVoiceSearchEditText) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107089);
    VoiceSearchEditText.a(this.zqj, true);
    VoiceSearchEditText.f(this.zqj);
    AppMethodBeat.o(107089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.VoiceSearchEditText.2
 * JD-Core Version:    0.7.0.1
 */