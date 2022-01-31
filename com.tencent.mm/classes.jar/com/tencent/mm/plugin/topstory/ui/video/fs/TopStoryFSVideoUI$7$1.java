package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a;

final class TopStoryFSVideoUI$7$1
  implements TopStoryCommentFloatDialog.a
{
  TopStoryFSVideoUI$7$1(TopStoryFSVideoUI.7 param7) {}
  
  public final void cKs()
  {
    AppMethodBeat.i(1960);
    this.tlb.tkZ.tkT.setVisibility(8);
    AppMethodBeat.o(1960);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(1959);
    this.tlb.tkZ.tiL.ctY();
    TopStoryFSVideoUI.b(this.tlb.tkZ);
    AppMethodBeat.o(1959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.7.1
 * JD-Core Version:    0.7.0.1
 */