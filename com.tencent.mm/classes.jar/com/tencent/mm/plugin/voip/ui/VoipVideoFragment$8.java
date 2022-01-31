package com.tencent.mm.plugin.voip.ui;

import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipVideoFragment$8
  implements Runnable
{
  VoipVideoFragment$8(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(4877);
    if ((this.tEo.getActivity() == null) || (this.tEo.getActivity().isFinishing()))
    {
      AppMethodBeat.o(4877);
      return;
    }
    VoipVideoFragment.g(this.tEo).setVisibility(8);
    AppMethodBeat.o(4877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.8
 * JD-Core Version:    0.7.0.1
 */