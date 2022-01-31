package com.tencent.mm.plugin.topstory.ui.video.list;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.topstory.ui.widget.c.a;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;

final class TopStoryListVideoUI$2
  implements c.a
{
  TopStoryListVideoUI$2(TopStoryListVideoUI paramTopStoryListVideoUI, ckx paramckx) {}
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(2100);
    this.tlQ.tkW.a(paramf, new TopStoryListVideoUI.2.1(this), (int)TopStoryListVideoUI.j(this.tlQ).xUO, this.tiU.xVe);
    if (this.tlQ.tiL.cKj()) {
      this.tlQ.tiL.crn();
    }
    AppMethodBeat.o(2100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.TopStoryListVideoUI.2
 * JD-Core Version:    0.7.0.1
 */