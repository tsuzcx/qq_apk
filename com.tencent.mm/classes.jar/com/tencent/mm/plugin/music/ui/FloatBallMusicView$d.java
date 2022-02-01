package com.tencent.mm.plugin.music.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class FloatBallMusicView$d
  implements View.OnClickListener
{
  FloatBallMusicView$d(FloatBallMusicView paramFloatBallMusicView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(220000);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/music/ui/FloatBallMusicView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    localObject = FloatBallMusicView.a(this.AmL);
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
    a.a(this, "com/tencent/mm/plugin/music/ui/FloatBallMusicView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(220000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.FloatBallMusicView.d
 * JD-Core Version:    0.7.0.1
 */