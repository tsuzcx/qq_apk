package com.tencent.mm.plugin.voip.ui;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class VoipVideoFragment$6
  implements View.OnClickListener
{
  long CiK = 0L;
  
  VoipVideoFragment$6(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115399);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
    if ((VoipVideoFragment.k(this.Ckc).Cok) || (VoipVideoFragment.k(this.Ckc).getVisibility() != 0))
    {
      ad.i("MicroMsg.Voip.VoipVideoFragment", "current view is not show ");
      a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(115399);
      return;
    }
    if (bt.aO(this.CiK) < 400L)
    {
      ad.i("MicroMsg.Voip.VoipVideoFragment", "click mGlSmallVideoView too fast and not allow to response it,times%s", new Object[] { Long.valueOf(bt.aO(this.CiK)) });
      a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(115399);
      return;
    }
    this.CiK = bt.HI();
    paramView = this.Ckc;
    if (!VoipVideoFragment.l(this.Ckc))
    {
      bool = true;
      VoipVideoFragment.b(paramView, bool);
      this.Ckc.eza();
      paramView = this.Ckc;
      if (VoipVideoFragment.l(this.Ckc)) {
        break label269;
      }
    }
    label269:
    for (boolean bool = true;; bool = false)
    {
      paramView = VoipVideoFragment.c(paramView, bool);
      VoipVideoFragment.k(this.Ckc).iy(paramView.x, paramView.y);
      g.yhR.f(11079, new Object[] { Integer.valueOf(3) });
      a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(115399);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.6
 * JD-Core Version:    0.7.0.1
 */