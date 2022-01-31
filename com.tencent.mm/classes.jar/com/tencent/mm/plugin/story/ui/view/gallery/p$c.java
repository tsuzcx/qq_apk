package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.protocal.protobuf.chl;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "", "positionV", "", "positionH", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "quota", "connectionCount", "(IILcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;II)V", "cdnMediaId", "", "getCdnMediaId", "()Ljava/lang/String;", "setCdnMediaId", "(Ljava/lang/String;)V", "getConnectionCount", "()I", "setConnectionCount", "(I)V", "getItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getPositionH", "getPositionV", "getQuota", "setQuota", "info", "plugin-story_release"})
public final class p$c
{
  private int connectionCount;
  int eeI;
  String fVf;
  private final int sUP;
  private final int sUQ;
  final i sUW;
  
  public p$c(int paramInt1, int paramInt2, i parami, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(110876);
    this.sUP = paramInt1;
    this.sUQ = paramInt2;
    this.sUW = parami;
    this.eeI = paramInt3;
    this.connectionCount = paramInt4;
    parami = s.swk;
    String str = s.be(this.sUW.fDT, this.sUW.syB.Url);
    parami = str;
    if (str == null) {
      parami = "";
    }
    this.fVf = parami;
    AppMethodBeat.o(110876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.p.c
 * JD-Core Version:    0.7.0.1
 */