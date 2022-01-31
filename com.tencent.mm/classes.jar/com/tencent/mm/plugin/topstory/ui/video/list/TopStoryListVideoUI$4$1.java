package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a;

final class TopStoryListVideoUI$4$1
  implements TopStoryCommentFloatDialog.a
{
  TopStoryListVideoUI$4$1(TopStoryListVideoUI.4 param4) {}
  
  public final void cKs()
  {
    AppMethodBeat.i(2103);
    this.tlS.tlQ.tlM.setVisibility(8);
    this.tlS.tlQ.tkT.setVisibility(8);
    AppMethodBeat.o(2103);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(2102);
    this.tlS.tlQ.tiL.ctY();
    AppMethodBeat.o(2102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.4.1
 * JD-Core Version:    0.7.0.1
 */