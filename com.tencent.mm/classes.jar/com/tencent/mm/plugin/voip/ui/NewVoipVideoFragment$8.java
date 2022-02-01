package com.tencent.mm.plugin.voip.ui;

import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NewVoipVideoFragment$8
  implements Runnable
{
  NewVoipVideoFragment$8(NewVoipVideoFragment paramNewVoipVideoFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(216451);
    if ((this.CiJ.getActivity() == null) || (this.CiJ.getActivity().isFinishing()))
    {
      AppMethodBeat.o(216451);
      return;
    }
    NewVoipVideoFragment.g(this.CiJ).setVisibility(8);
    AppMethodBeat.o(216451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.8
 * JD-Core Version:    0.7.0.1
 */