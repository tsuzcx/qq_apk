package com.tencent.mm.plugin.topstory.ui.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class TopStoryBaseVideoUI$1
  implements View.OnClickListener
{
  TopStoryBaseVideoUI$1(TopStoryBaseVideoUI paramTopStoryBaseVideoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(126076);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.Gnd.fzm();
    a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(126076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.1
 * JD-Core Version:    0.7.0.1
 */