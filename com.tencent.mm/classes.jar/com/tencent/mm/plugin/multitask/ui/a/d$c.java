package com.tencent.mm.plugin.multitask.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class d$c
  implements View.OnClickListener
{
  public static final c FNp;
  
  static
  {
    AppMethodBeat.i(196905);
    FNp = new c();
    AppMethodBeat.o(196905);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(196904);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$onMultiTaskInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.d("MicroMsg.SnapShotMultiTaskUIC", "snapshotview onClick!");
    a.a(this, "com/tencent/mm/plugin/multitask/ui/uic/SnapShotMultiTaskUIC$onMultiTaskInit$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(196904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.a.d.c
 * JD-Core Version:    0.7.0.1
 */