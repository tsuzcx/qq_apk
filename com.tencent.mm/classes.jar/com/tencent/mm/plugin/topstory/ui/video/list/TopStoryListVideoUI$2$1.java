package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a;

final class TopStoryListVideoUI$2$1
  implements TopStoryCommentFloatDialog.a
{
  TopStoryListVideoUI$2$1(TopStoryListVideoUI.2 param2) {}
  
  public final void cKs()
  {
    AppMethodBeat.i(2099);
    this.tlR.tlQ.tlM.setVisibility(8);
    this.tlR.tlQ.tkT.setVisibility(8);
    AppMethodBeat.o(2099);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(2098);
    this.tlR.tlQ.tiL.ctY();
    AppMethodBeat.o(2098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.2.1
 * JD-Core Version:    0.7.0.1
 */