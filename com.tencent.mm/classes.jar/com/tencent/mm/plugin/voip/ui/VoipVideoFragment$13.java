package com.tencent.mm.plugin.voip.ui;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class VoipVideoFragment$13
  implements View.OnClickListener
{
  long UIX = 0L;
  
  VoipVideoFragment$13(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115414);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/voip/ui/VoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.Voip.VoipVideoFragment", "steve: mGlSmallVideoView clicked!");
    if ((VoipVideoFragment.e(this.UKQ).UNN) || (VoipVideoFragment.e(this.UKQ).getVisibility() != 0))
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "current view is not show ");
      a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(115414);
      return;
    }
    if (Util.ticksToNow(this.UIX) < 400L)
    {
      Log.i("MicroMsg.Voip.VoipVideoFragment", "click mGlSmallVideoView too fast and not allow to response it,times%s", new Object[] { Long.valueOf(Util.ticksToNow(this.UIX)) });
      a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(115414);
      return;
    }
    this.UIX = Util.currentTicks();
    paramView = this.UKQ;
    if (!VoipVideoFragment.f(this.UKQ))
    {
      bool = true;
      VoipVideoFragment.b(paramView, bool);
      this.UKQ.iaP();
      paramView = this.UKQ;
      if (VoipVideoFragment.f(this.UKQ)) {
        break label269;
      }
    }
    label269:
    for (boolean bool = true;; bool = false)
    {
      paramView = VoipVideoFragment.c(paramView, bool);
      VoipVideoFragment.e(this.UKQ).mI(paramView.x, paramView.y);
      h.OAn.b(11079, new Object[] { Integer.valueOf(3) });
      a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVideoFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(115414);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.13
 * JD-Core Version:    0.7.0.1
 */