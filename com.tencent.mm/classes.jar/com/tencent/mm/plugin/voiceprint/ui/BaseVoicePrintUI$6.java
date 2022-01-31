package com.tencent.mm.plugin.voiceprint.ui;

import android.widget.Button;
import com.tencent.mm.R.l;

final class BaseVoicePrintUI$6
  implements Runnable
{
  BaseVoicePrintUI$6(BaseVoicePrintUI paramBaseVoicePrintUI) {}
  
  public final void run()
  {
    BaseVoicePrintUI.c(this.pMb).setErr(R.l.voice_record_permission_denied);
    BaseVoicePrintUI.c(this.pMb).bPu();
    BaseVoicePrintUI.f(this.pMb).setPressed(false);
    BaseVoicePrintUI.f(this.pMb).setEnabled(false);
    BaseVoicePrintUI.g(this.pMb).stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.6
 * JD-Core Version:    0.7.0.1
 */