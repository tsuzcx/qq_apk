package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoiceTransTextUI$7
  implements Runnable
{
  VoiceTransTextUI$7(VoiceTransTextUI paramVoiceTransTextUI, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(25600);
    if (VoiceTransTextUI.r(this.taB).getMeasuredHeight() >= VoiceTransTextUI.s(this.taB).getMeasuredHeight())
    {
      VoiceTransTextUI.r(this.taB).fullScroll(130);
      int i = VoiceTransTextUI.r(this.taB).getScrollY();
      VoiceTransTextUI.c(this.taB, VoiceTransTextUI.r(this.taB).getPaddingTop());
      VoiceTransTextUI.c(this.taB, VoiceTransTextUI.t(this.taB) - i);
      if (!this.taE)
      {
        if (VoiceTransTextUI.t(this.taB) > 0)
        {
          VoiceTransTextUI.r(this.taB).setPadding(0, VoiceTransTextUI.t(this.taB), 0, 0);
          AppMethodBeat.o(25600);
        }
      }
      else
      {
        VoiceTransTextUI.r(this.taB).setPadding(0, 0, 0, 0);
        VoiceTransTextUI.u(this.taB).setVisibility(8);
        VoiceTransTextUI.u(this.taB).setHeight(0);
      }
    }
    AppMethodBeat.o(25600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.7
 * JD-Core Version:    0.7.0.1
 */