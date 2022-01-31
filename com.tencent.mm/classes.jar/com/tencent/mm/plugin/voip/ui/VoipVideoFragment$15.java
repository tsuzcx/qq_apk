package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.base.h;

final class VoipVideoFragment$15
  implements View.OnClickListener
{
  VoipVideoFragment$15(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(4892);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
    if ((at.isWifi(this.tEo.getActivity())) || ((r.cNv()) && (!at.is2G(this.tEo.getActivity()))))
    {
      VoipVideoFragment.e(this.tEo);
      AppMethodBeat.o(4892);
      return;
    }
    h.a(this.tEo.getActivity(), 2131304716, 2131304717, new VoipVideoFragment.15.1(this), new VoipVideoFragment.15.2(this));
    AppMethodBeat.o(4892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.15
 * JD-Core Version:    0.7.0.1
 */