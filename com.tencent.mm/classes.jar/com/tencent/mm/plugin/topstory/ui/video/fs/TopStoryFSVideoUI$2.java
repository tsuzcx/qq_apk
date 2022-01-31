package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.b.a;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;
import java.util.Set;

final class TopStoryFSVideoUI$2
  implements b.a
{
  TopStoryFSVideoUI$2(TopStoryFSVideoUI paramTopStoryFSVideoUI, ckx paramckx, int paramInt) {}
  
  public final void i(Set<adl> paramSet)
  {
    AppMethodBeat.i(1952);
    ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow commit");
    t.makeText(this.tkZ.getContext(), 2131304335, 0).show();
    h.a(this.tkZ.cJf(), this.tiU, paramSet, this.tkZ.tiM.cKc());
    this.tkZ.tiL.stopPlay();
    this.tkZ.tiM.GH(this.lU);
    this.tkZ.tkM.bT(this.lU + this.tkZ.tkM.getHeadersCount());
    this.tkZ.tiw.a(0, 3, null);
    AppMethodBeat.o(1952);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(1953);
    ab.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow dismiss");
    if (TopStoryFSVideoUI.c(this.tkZ))
    {
      this.tkZ.tiL.ctY();
      TopStoryFSVideoUI.d(this.tkZ);
      try
      {
        ((f)this.tkZ.tiL.tjQ.getControlBar()).aFn();
        AppMethodBeat.o(1953);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(1953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI.2
 * JD-Core Version:    0.7.0.1
 */