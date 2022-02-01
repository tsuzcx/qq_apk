package com.tencent.mm.plugin.topstory.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class h$1
  implements View.OnClickListener
{
  h$1(h paramh) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(126072);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.Gmt.fV(paramView);
    a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(126072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.h.1
 * JD-Core Version:    0.7.0.1
 */