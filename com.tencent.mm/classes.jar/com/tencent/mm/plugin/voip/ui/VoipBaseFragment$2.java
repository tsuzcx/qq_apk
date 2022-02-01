package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.d;

final class VoipBaseFragment$2
  implements Runnable
{
  VoipBaseFragment$2(VoipBaseFragment paramVoipBaseFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(236146);
    if ((this.NVB.getActivity() == null) || (this.NVB.getActivity().isFinishing()))
    {
      AppMethodBeat.o(236146);
      return;
    }
    if (this.NVB.qcr.findViewById(b.d.net_tip_layout) != null) {
      this.NVB.qcr.findViewById(b.d.net_tip_layout).setOnClickListener(null);
    }
    this.NVB.FzP = false;
    this.NVB.DZt.setVisibility(8);
    this.NVB.FwW.setVisibility(8);
    AppMethodBeat.o(236146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */