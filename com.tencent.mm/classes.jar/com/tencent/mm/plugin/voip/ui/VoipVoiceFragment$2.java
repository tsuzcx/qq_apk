package com.tencent.mm.plugin.voip.ui;

import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipVoiceFragment$2
  implements Runnable
{
  VoipVoiceFragment$2(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(115465);
    if ((this.CkP.getActivity() == null) || (this.CkP.getActivity().isFinishing()))
    {
      AppMethodBeat.o(115465);
      return;
    }
    VoipVoiceFragment.k(this.CkP).setVisibility(8);
    AppMethodBeat.o(115465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.2
 * JD-Core Version:    0.7.0.1
 */