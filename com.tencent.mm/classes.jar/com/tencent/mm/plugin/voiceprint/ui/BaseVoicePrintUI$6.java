package com.tencent.mm.plugin.voiceprint.ui;

import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseVoicePrintUI$6
  implements Runnable
{
  BaseVoicePrintUI$6(BaseVoicePrintUI paramBaseVoicePrintUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(26136);
    BaseVoicePrintUI.c(this.trX).setErr(2131304578);
    BaseVoicePrintUI.c(this.trX).cLz();
    BaseVoicePrintUI.f(this.trX).setPressed(false);
    BaseVoicePrintUI.f(this.trX).setEnabled(false);
    BaseVoicePrintUI.g(this.trX).stop();
    AppMethodBeat.o(26136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.6
 * JD-Core Version:    0.7.0.1
 */