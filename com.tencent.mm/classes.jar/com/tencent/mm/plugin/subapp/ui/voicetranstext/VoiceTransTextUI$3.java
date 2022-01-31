package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.ah;

final class VoiceTransTextUI$3
  implements View.OnTouchListener
{
  VoiceTransTextUI$3(VoiceTransTextUI paramVoiceTransTextUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
    case 0: 
      do
      {
        return false;
        VoiceTransTextUI.c(this.pyO);
        VoiceTransTextUI.a(this.pyO, paramView.getScrollY());
        VoiceTransTextUI.b(this.pyO, VoiceTransTextUI.d(this.pyO));
        VoiceTransTextUI.e(this.pyO).removeMessages(0);
      } while (!VoiceTransTextUI.f(this.pyO));
      VoiceTransTextUI.g(this.pyO);
      VoiceTransTextUI.a(this.pyO, true);
      return false;
    }
    if (Math.abs(VoiceTransTextUI.h(this.pyO) - paramView.getScrollY()) > VoiceTransTextUI.i(this.pyO)) {
      VoiceTransTextUI.e(this.pyO).sendMessage(VoiceTransTextUI.e(this.pyO).obtainMessage(0, paramView));
    }
    if ((VoiceTransTextUI.j(this.pyO) < 800L) && (Math.abs(VoiceTransTextUI.h(this.pyO) - paramView.getScrollY()) <= VoiceTransTextUI.i(this.pyO)) && (!VoiceTransTextUI.k(this.pyO)))
    {
      VoiceTransTextUI.e(this.pyO).removeMessages(0);
      VoiceTransTextUI.l(this.pyO);
      this.pyO.finish();
    }
    VoiceTransTextUI.a(this.pyO, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.3
 * JD-Core Version:    0.7.0.1
 */