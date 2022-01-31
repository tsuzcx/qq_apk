package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

final class VoiceTransTextUI$7
  implements Runnable
{
  VoiceTransTextUI$7(VoiceTransTextUI paramVoiceTransTextUI, boolean paramBoolean) {}
  
  public final void run()
  {
    if (VoiceTransTextUI.r(this.pyO).getMeasuredHeight() >= VoiceTransTextUI.s(this.pyO).getMeasuredHeight())
    {
      VoiceTransTextUI.r(this.pyO).fullScroll(130);
      int i = VoiceTransTextUI.r(this.pyO).getScrollY();
      VoiceTransTextUI.c(this.pyO, VoiceTransTextUI.r(this.pyO).getPaddingTop());
      VoiceTransTextUI.c(this.pyO, VoiceTransTextUI.t(this.pyO) - i);
      if (this.pyR) {
        break label121;
      }
      if (VoiceTransTextUI.t(this.pyO) > 0) {
        VoiceTransTextUI.r(this.pyO).setPadding(0, VoiceTransTextUI.t(this.pyO), 0, 0);
      }
    }
    return;
    label121:
    VoiceTransTextUI.r(this.pyO).setPadding(0, 0, 0, 0);
    VoiceTransTextUI.u(this.pyO).setVisibility(8);
    VoiceTransTextUI.u(this.pyO).setHeight(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.7
 * JD-Core Version:    0.7.0.1
 */