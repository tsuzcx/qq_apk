package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;
import com.tencent.mm.plugin.topstory.ui.video.d;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class TopStoryListVideoUI$7
  implements View.OnClickListener
{
  TopStoryListVideoUI$7(TopStoryListVideoUI paramTopStoryListVideoUI) {}
  
  public final void onClick(View paramView)
  {
    g.DP().Dz().c(ac.a.uzO, Integer.valueOf(1));
    this.pId.pFp.bMs();
    TopStoryListVideoUI.h(this.pId).setVisibility(8);
    TopStoryListVideoUI.i(this.pId).b(this.pId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.7
 * JD-Core Version:    0.7.0.1
 */