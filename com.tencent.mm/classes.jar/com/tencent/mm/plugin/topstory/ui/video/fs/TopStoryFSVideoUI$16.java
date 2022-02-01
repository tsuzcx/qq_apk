package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class TopStoryFSVideoUI$16
  implements View.OnClickListener
{
  TopStoryFSVideoUI$16(TopStoryFSVideoUI paramTopStoryFSVideoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(126351);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    TopStoryFSVideoUI.c(this.Bxi);
    a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(126351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.16
 * JD-Core Version:    0.7.0.1
 */