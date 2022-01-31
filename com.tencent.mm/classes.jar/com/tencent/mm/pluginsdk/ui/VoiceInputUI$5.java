package com.tencent.mm.pluginsdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMEditText;

final class VoiceInputUI$5
  implements TextWatcher
{
  VoiceInputUI$5(VoiceInputUI paramVoiceInputUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(27611);
    ab.d("VoiceInputUI", "afterTextChanged firstTextChange:%s,textChange:%s", new Object[] { Boolean.valueOf(VoiceInputUI.f(this.vSL)), Boolean.valueOf(VoiceInputUI.g(this.vSL)) });
    if (VoiceInputUI.f(this.vSL))
    {
      VoiceInputUI.h(this.vSL);
      AppMethodBeat.o(27611);
      return;
    }
    VoiceInputUI.d(this.vSL);
    VoiceInputUI.c(this.vSL).requestLayout();
    AppMethodBeat.o(27611);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI.5
 * JD-Core Version:    0.7.0.1
 */