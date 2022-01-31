package com.tencent.mm.pluginsdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;

final class VoiceInputUI$5
  implements TextWatcher
{
  VoiceInputUI$5(VoiceInputUI paramVoiceInputUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    y.d("VoiceInputUI", "afterTextChanged firstTextChange:%s,textChange:%s", new Object[] { Boolean.valueOf(VoiceInputUI.f(this.sbE)), Boolean.valueOf(VoiceInputUI.g(this.sbE)) });
    if (VoiceInputUI.f(this.sbE))
    {
      VoiceInputUI.h(this.sbE);
      return;
    }
    VoiceInputUI.d(this.sbE);
    VoiceInputUI.c(this.sbE).requestLayout();
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI.5
 * JD-Core Version:    0.7.0.1
 */