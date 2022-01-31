package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.sdk.platformtools.y;

final class VoiceSearchEditText$3
  implements View.OnFocusChangeListener
{
  VoiceSearchEditText$3(VoiceSearchEditText paramVoiceSearchEditText) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    y.d("MicroMsg.VoiceSearchEditText", "onFocusChange hasFocus = [%s], currentFocusState = [%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(VoiceSearchEditText.f(this.vbN)) });
    if ((!paramBoolean) && (VoiceSearchEditText.f(this.vbN)))
    {
      VoiceSearchEditText.e(this.vbN);
      VoiceSearchEditText.a(this.vbN, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.VoiceSearchEditText.3
 * JD-Core Version:    0.7.0.1
 */