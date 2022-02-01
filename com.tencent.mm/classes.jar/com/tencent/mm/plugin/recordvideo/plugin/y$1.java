package com.tencent.mm.plugin.recordvideo.plugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class y$1
  implements View.OnClickListener
{
  y$1(y paramy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(182850);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/RecordFilterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = this.xRG;
    if (!this.xRG.enable) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setEnable(bool);
      a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/RecordFilterPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(182850);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.y.1
 * JD-Core Version:    0.7.0.1
 */