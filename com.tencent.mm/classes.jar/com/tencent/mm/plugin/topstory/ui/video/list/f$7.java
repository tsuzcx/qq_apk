package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.a.b.a;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class f$7
  implements g.a
{
  f$7(f paramf) {}
  
  public final void cKm()
  {
    AppMethodBeat.i(2048);
    f.M(this.tlr).setVisibility(8);
    AppMethodBeat.o(2048);
  }
  
  public final void cKn()
  {
    AppMethodBeat.i(2049);
    if ((this.tlr.getListVideoUIComponent().cJh().tjS) && ((this.tlr.getListVideoUIComponent().cJh().cKj()) || (this.tlr.getListVideoUIComponent().cJh().tjT)))
    {
      f.N(this.tlr).setVisibility(0);
      AppMethodBeat.o(2049);
      return;
    }
    f.O(this.tlr).setVisibility(8);
    AppMethodBeat.o(2049);
  }
  
  public final void update(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2047);
    if (paramInt2 > 0) {}
    for (int i = f.B(this.tlr).getWidth() * paramInt1 / paramInt2;; i = 0)
    {
      Object localObject = this.tlr.getListVideoUIComponent().cJd().tjL;
      if ((localObject != null) && (((a)localObject).teW < this.tlr.getListVideoUIComponent().cJh().getCurrPosMs())) {
        ((a)localObject).teW = this.tlr.getListVideoUIComponent().cJh().getCurrPosMs();
      }
      if (this.tlr.getListVideoUIComponent().cJh().cKj())
      {
        int j = this.tlr.getListVideoUIComponent().cJh().getCurrPosMs() / 1000;
        if (((PluginTopStoryUI)com.tencent.mm.kernel.g.G(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(f.C(this.tlr).xVa))
        {
          ab.i("MicroMsg.TopStory.TopStoryListVideoContainer", "list update video progress %s %d", new Object[] { f.D(this.tlr).xVa, Integer.valueOf(j) });
          ((PluginTopStoryUI)com.tencent.mm.kernel.g.G(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(f.E(this.tlr).xVa, Integer.valueOf(j));
        }
      }
      localObject = (FrameLayout.LayoutParams)f.F(this.tlr).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = i;
      f.G(this.tlr).setLayoutParams((ViewGroup.LayoutParams)localObject);
      f.H(this.tlr).requestLayout();
      if (!f.g(this.tlr).Pk()) {
        f.g(this.tlr).setVisibility(8);
      }
      if ((f.I(this.tlr).xVn <= 0) && ((f.J(this.tlr).xVl & 0x100) <= 0) && (f.K(this.tlr).gh(paramInt1, paramInt2))) {
        f.L(this.tlr).xVn = 1;
      }
      AppMethodBeat.o(2047);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f.7
 * JD-Core Version:    0.7.0.1
 */