package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.x;
import com.tencent.mm.sdk.platformtools.y;

final class TopStoryBaseVideoUI$a
  extends x
{
  private TopStoryBaseVideoUI$a(TopStoryBaseVideoUI paramTopStoryBaseVideoUI) {}
  
  public final void z(RecyclerView.v paramv)
  {
    super.z(paramv);
    this.pFv.bOf();
    this.pFv.pFc.b(this.pFv);
    y.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "onRemoveFinished %d", new Object[] { Integer.valueOf(paramv.id()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.a
 * JD-Core Version:    0.7.0.1
 */