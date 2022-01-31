package com.tencent.mm.plugin.voip.ui;

import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VoipVideoFragment$7
  implements Runnable
{
  VoipVideoFragment$7(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(140179);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
    VoipVideoFragment.q(this.tEo);
    if ((this.tEo.getActivity() == null) || (this.tEo.getActivity().isFinishing()))
    {
      AppMethodBeat.o(140179);
      return;
    }
    if (VoipVideoFragment.r(this.tEo) > 0)
    {
      AppMethodBeat.o(140179);
      return;
    }
    VoipVideoFragment.o(this.tEo).setVisibility(8);
    VoipVideoFragment.s(this.tEo).setVisibility(8);
    VoipVideoFragment.t(this.tEo).setVisibility(8);
    VoipVideoFragment.a(this.tEo).setVisibility(8);
    VoipVideoFragment.b(this.tEo).setVisibility(8);
    VoipVideoFragment.d(this.tEo, false);
    AppMethodBeat.o(140179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.7
 * JD-Core Version:    0.7.0.1
 */