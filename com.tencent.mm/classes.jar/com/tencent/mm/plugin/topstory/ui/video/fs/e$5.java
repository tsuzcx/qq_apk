package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.b.a;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class e$5
  implements f.a
{
  e$5(e parame) {}
  
  public final void a(ckx paramckx, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141935);
    if (paramInt2 > 0) {}
    for (int i = e.F(this.tkq).getWidth() * paramInt1 / paramInt2;; i = 0)
    {
      Object localObject = this.tkq.getFSVideoUIComponent().cJd().tjL;
      if ((localObject != null) && (((a)localObject).teW < this.tkq.getFSVideoUIComponent().cJh().getCurrPosMs())) {
        ((a)localObject).teW = this.tkq.getFSVideoUIComponent().cJh().getCurrPosMs();
      }
      if (e.G(this.tkq).cJh().cKj())
      {
        int j = e.H(this.tkq).cJh().getCurrPosMs() / 1000;
        if (((PluginTopStoryUI)g.G(PluginTopStoryUI.class)).getVideoPlayProgressMap().containsKey(paramckx.xVa))
        {
          ab.i("MicroMsg.TopStory.TopStoryFSVideoContainer", "fs update video progress %s %d", new Object[] { paramckx.xVa, Integer.valueOf(j) });
          ((PluginTopStoryUI)g.G(PluginTopStoryUI.class)).getVideoPlayProgressMap().put(paramckx.xVa, Integer.valueOf(j));
        }
      }
      localObject = (FrameLayout.LayoutParams)e.I(this.tkq).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = i;
      e.J(this.tkq).setLayoutParams((ViewGroup.LayoutParams)localObject);
      e.K(this.tkq).requestLayout();
      if (!this.tkq.tkg.Pk()) {
        this.tkq.tkg.setVisibility(8);
      }
      if ((paramckx.xVn <= 0) && ((paramckx.xVl & 0x100) <= 0) && (e.L(this.tkq).gh(paramInt1, paramInt2))) {
        paramckx.xVn = 1;
      }
      AppMethodBeat.o(141935);
      return;
    }
  }
  
  public final void cKm()
  {
    AppMethodBeat.i(1888);
    e.M(this.tkq).setVisibility(8);
    AppMethodBeat.o(1888);
  }
  
  public final void cKn()
  {
    AppMethodBeat.i(1889);
    if ((this.tkq.getFSVideoUIComponent().cJh().tjS) && ((this.tkq.getFSVideoUIComponent().cJh().cKj()) || (this.tkq.getFSVideoUIComponent().cJh().tjT)))
    {
      e.N(this.tkq).setVisibility(0);
      AppMethodBeat.o(1889);
      return;
    }
    e.O(this.tkq).setVisibility(8);
    AppMethodBeat.o(1889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.5
 * JD-Core Version:    0.7.0.1
 */