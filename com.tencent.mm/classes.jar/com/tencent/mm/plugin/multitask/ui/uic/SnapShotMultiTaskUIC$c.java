package com.tencent.mm.plugin.multitask.ui.uic;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class SnapShotMultiTaskUIC$c
  implements View.OnClickListener
{
  public static final c AgB;
  
  static
  {
    AppMethodBeat.i(236698);
    AgB = new c();
    AppMethodBeat.o(236698);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(236697);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$onMultiTaskInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.d("MicroMsg.SnapShotMultiTaskUIC", "snapshotview onClick!");
    a.a(this, "com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$onMultiTaskInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.uic.SnapShotMultiTaskUIC.c
 * JD-Core Version:    0.7.0.1
 */