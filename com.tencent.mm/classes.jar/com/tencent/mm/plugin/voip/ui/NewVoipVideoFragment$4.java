package com.tencent.mm.plugin.voip.ui;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.b.i;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

final class NewVoipVideoFragment$4
  implements View.OnClickListener
{
  long CiK = 0L;
  
  NewVoipVideoFragment$4(NewVoipVideoFragment paramNewVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216447);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
    this.CiK = bt.HI();
    paramView = this.CiJ;
    if (!NewVoipVideoFragment.k(this.CiJ))
    {
      bool = true;
      NewVoipVideoFragment.b(paramView, bool);
      ((c)this.CiJ.CiR.get()).evk();
      i.tB(true);
      paramView = this.CiJ;
      if (NewVoipVideoFragment.k(this.CiJ)) {
        break label187;
      }
    }
    label187:
    for (boolean bool = true;; bool = false)
    {
      paramView = NewVoipVideoFragment.c(paramView, bool);
      if (NewVoipVideoFragment.l(this.CiJ) != null) {
        NewVoipVideoFragment.l(this.CiJ).iy(paramView.x, paramView.y);
      }
      g.yhR.f(11079, new Object[] { Integer.valueOf(3) });
      a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216447);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.4
 * JD-Core Version:    0.7.0.1
 */