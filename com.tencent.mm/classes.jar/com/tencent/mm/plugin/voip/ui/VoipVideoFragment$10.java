package com.tencent.mm.plugin.voip.ui;

import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipVideoFragment$10
  implements Runnable
{
  VoipVideoFragment$10(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(216522);
    if ((this.Ckc.getActivity() == null) || (this.Ckc.getActivity().isFinishing()))
    {
      AppMethodBeat.o(216522);
      return;
    }
    VoipVideoFragment.g(this.Ckc).setVisibility(8);
    AppMethodBeat.o(216522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.10
 * JD-Core Version:    0.7.0.1
 */