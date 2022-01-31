package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;
import com.tencent.mm.plugin.topstory.ui.video.d;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class TopStoryListVideoUI$12
  implements View.OnClickListener
{
  TopStoryListVideoUI$12(TopStoryListVideoUI paramTopStoryListVideoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(2111);
    g.RL().Ru().set(ac.a.yKG, Integer.valueOf(1));
    this.tlQ.tiL.ctY();
    TopStoryListVideoUI.h(this.tlQ).setVisibility(8);
    TopStoryListVideoUI.i(this.tlQ).b(this.tlQ);
    AppMethodBeat.o(2111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.12
 * JD-Core Version:    0.7.0.1
 */