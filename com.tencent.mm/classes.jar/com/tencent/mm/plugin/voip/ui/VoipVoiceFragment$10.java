package com.tencent.mm.plugin.voip.ui;

import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipVoiceFragment$10
  implements Runnable
{
  VoipVoiceFragment$10(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(4948);
    if ((this.tEW.getActivity() == null) || (this.tEW.getActivity().isFinishing()))
    {
      AppMethodBeat.o(4948);
      return;
    }
    VoipVoiceFragment.k(this.tEW).setVisibility(8);
    AppMethodBeat.o(4948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.10
 * JD-Core Version:    0.7.0.1
 */