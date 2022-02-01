package com.tencent.mm.plugin.voip.ui;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipVoiceFragment$3
  implements Runnable
{
  VoipVoiceFragment$3(VoipVoiceFragment paramVoipVoiceFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(216529);
    if ((this.CkP.getActivity() == null) || (this.CkP.getActivity().isFinishing()))
    {
      AppMethodBeat.o(216529);
      return;
    }
    if (this.CkP.lPT.findViewById(2131308162) != null) {
      this.CkP.lPT.findViewById(2131308162).setOnClickListener(null);
    }
    VoipVoiceFragment.l(this.CkP);
    VoipVoiceFragment.m(this.CkP).setVisibility(8);
    VoipVoiceFragment.n(this.CkP).setVisibility(8);
    AppMethodBeat.o(216529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment.3
 * JD-Core Version:    0.7.0.1
 */