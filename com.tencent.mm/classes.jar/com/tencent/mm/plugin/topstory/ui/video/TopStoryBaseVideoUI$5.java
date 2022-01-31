package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.widget.b.a;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;
import java.util.Set;

final class TopStoryBaseVideoUI$5
  implements b.a
{
  TopStoryBaseVideoUI$5(TopStoryBaseVideoUI paramTopStoryBaseVideoUI, ckx paramckx, int paramInt) {}
  
  public final void i(Set<adl> paramSet)
  {
    AppMethodBeat.i(1722);
    ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow commit");
    t.makeText(this.tiT.getContext(), 2131304335, 0).show();
    h.a(this.tiT.cJf(), this.tiU, paramSet, this.tiT.tiM.cKc());
    this.tiT.tiL.stopPlay();
    this.tiT.tiM.GH(this.lU);
    if (this.tiT.tiR)
    {
      this.tiT.tiB.bT(this.lU + this.tiT.tiB.getHeadersCount());
      this.tiT.tix.ajb.notifyChanged();
      this.tiT.tiz.a(0, 3, null);
      AppMethodBeat.o(1722);
      return;
    }
    this.tiT.tix.bT(this.lU + this.tiT.tix.getHeadersCount());
    this.tiT.tiB.ajb.notifyChanged();
    AppMethodBeat.o(1722);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(1723);
    ab.i("MicroMsg.TopStory.TopStoryBaseVideoUI", "popupWindow dismiss");
    if (TopStoryBaseVideoUI.a(this.tiT))
    {
      this.tiT.tiL.ctY();
      TopStoryBaseVideoUI.b(this.tiT);
      if (this.tiT.tiR) {
        try
        {
          ((com.tencent.mm.plugin.topstory.ui.video.fs.f)this.tiT.tiL.tjQ.getControlBar()).aFn();
          AppMethodBeat.o(1723);
          return;
        }
        catch (Exception localException) {}
      }
    }
    AppMethodBeat.o(1723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.TopStoryBaseVideoUI.5
 * JD-Core Version:    0.7.0.1
 */