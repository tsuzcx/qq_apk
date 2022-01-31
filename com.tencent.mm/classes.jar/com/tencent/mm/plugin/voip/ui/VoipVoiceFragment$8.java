package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class VoipVoiceFragment$8
  implements View.OnClickListener
{
  VoipVoiceFragment$8(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(4946);
    ab.i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
    if ((this.tEW.tCc != null) && (this.tEW.tCc.get() != null) && (((c)this.tEW.tCc.get()).cMI())) {
      this.tEW.gm(2131304681, -1);
    }
    AppMethodBeat.o(4946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.8
 * JD-Core Version:    0.7.0.1
 */