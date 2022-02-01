package com.tencent.mm.plugin.music.model;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ig;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.findersdk.a.al;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class d$d
  implements View.OnClickListener
{
  d$d(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(260302);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$initMusicFloatBallView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = new ig();
    paramView.sJ(2L);
    paramView.sK(4L);
    al.a(paramView);
    b.feA();
    this.FRp.cvE();
    a.a(this, "com/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$initMusicFloatBallView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(260302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.d
 * JD-Core Version:    0.7.0.1
 */