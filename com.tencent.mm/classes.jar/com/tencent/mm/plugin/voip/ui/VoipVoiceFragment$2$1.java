package com.tencent.mm.plugin.voip.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class VoipVoiceFragment$2$1
  implements Runnable
{
  VoipVoiceFragment$2$1(VoipVoiceFragment.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(4939);
    String str = VoipVoiceFragment.ha(bo.gz(this.tEX.tEW.tCd));
    VoipVoiceFragment.g(this.tEX.tEW).setText(str);
    AppMethodBeat.o(4939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.2.1
 * JD-Core Version:    0.7.0.1
 */