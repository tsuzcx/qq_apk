package com.tencent.mm.plugin.music.model;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class d$c
  implements View.OnClickListener
{
  d$c(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(219956);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$initMusicFloatBallView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.Akl.cir();
    a.a(this, "com/tencent/mm/plugin/music/model/GlobalMusicPlayerFloatBallHelper$initMusicFloatBallView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(219956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d.c
 * JD-Core Version:    0.7.0.1
 */