package com.tencent.mm.plugin.voip.ui;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.ab;

final class VoipVideoFragment$4
  implements View.OnClickListener
{
  VoipVideoFragment$4(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(4873);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
    paramView = this.tEo;
    if (!VoipVideoFragment.k(this.tEo))
    {
      bool = true;
      VoipVideoFragment.b(paramView, bool);
      this.tEo.cPb();
      paramView = this.tEo;
      if (VoipVideoFragment.k(this.tEo)) {
        break label116;
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      paramView = VoipVideoFragment.c(paramView, bool);
      VoipVideoFragment.l(this.tEo).gp(paramView.x, paramView.y);
      h.qsU.e(11079, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(4873);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.4
 * JD-Core Version:    0.7.0.1
 */