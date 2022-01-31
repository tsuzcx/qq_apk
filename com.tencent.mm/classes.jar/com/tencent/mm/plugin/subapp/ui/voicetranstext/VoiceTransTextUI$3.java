package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class VoiceTransTextUI$3
  implements View.OnTouchListener
{
  VoiceTransTextUI$3(VoiceTransTextUI paramVoiceTransTextUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(25594);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25594);
      return false;
      VoiceTransTextUI.c(this.taB);
      VoiceTransTextUI.a(this.taB, paramView.getScrollY());
      VoiceTransTextUI.b(this.taB, VoiceTransTextUI.d(this.taB));
      VoiceTransTextUI.e(this.taB).removeMessages(0);
      if (VoiceTransTextUI.f(this.taB))
      {
        VoiceTransTextUI.g(this.taB);
        VoiceTransTextUI.a(this.taB, true);
        continue;
        if (Math.abs(VoiceTransTextUI.h(this.taB) - paramView.getScrollY()) > VoiceTransTextUI.i(this.taB)) {
          VoiceTransTextUI.e(this.taB).sendMessage(VoiceTransTextUI.e(this.taB).obtainMessage(0, paramView));
        }
        if ((VoiceTransTextUI.j(this.taB) < 800L) && (Math.abs(VoiceTransTextUI.h(this.taB) - paramView.getScrollY()) <= VoiceTransTextUI.i(this.taB)) && (!VoiceTransTextUI.k(this.taB)))
        {
          VoiceTransTextUI.e(this.taB).removeMessages(0);
          VoiceTransTextUI.l(this.taB);
          this.taB.finish();
        }
        VoiceTransTextUI.a(this.taB, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.3
 * JD-Core Version:    0.7.0.1
 */