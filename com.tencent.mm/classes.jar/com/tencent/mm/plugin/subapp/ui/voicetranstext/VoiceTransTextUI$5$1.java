package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class VoiceTransTextUI$5$1
  implements Runnable
{
  VoiceTransTextUI$5$1(VoiceTransTextUI.5 param5) {}
  
  public final void run()
  {
    y.i("MicroMsg.VoiceTransTextUI", "notify has new trans, so pull");
    if (VoiceTransTextUI.q(this.pyQ.pyO) != null) {
      VoiceTransTextUI.q(this.pyQ.pyO).stopTimer();
    }
    VoiceTransTextUI.a(this.pyQ.pyO, VoiceTransTextUI.a.pyX);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.5.1
 * JD-Core Version:    0.7.0.1
 */