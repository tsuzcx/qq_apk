package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback;

final class MoreTabUI$10
  implements PullDownListView.IPullDownCallback
{
  MoreTabUI$10(MoreTabUI paramMoreTabUI) {}
  
  public final void Bv(int paramInt)
  {
    AppMethodBeat.i(29710);
    if (MoreTabUI.i(this.zdu) != null) {
      MoreTabUI.i(this.zdu).Fy(paramInt);
    }
    AppMethodBeat.o(29710);
  }
  
  public final void Bw(int paramInt)
  {
    AppMethodBeat.i(29711);
    if (MoreTabUI.i(this.zdu) != null) {
      MoreTabUI.i(this.zdu).Fz(paramInt);
    }
    AppMethodBeat.o(29711);
  }
  
  public final void Bx(int paramInt)
  {
    AppMethodBeat.i(29712);
    if (MoreTabUI.i(this.zdu) != null) {
      MoreTabUI.i(this.zdu).Bx(paramInt);
    }
    AppMethodBeat.o(29712);
  }
  
  public final void cbY()
  {
    AppMethodBeat.i(29706);
    if (MoreTabUI.i(this.zdu) != null) {
      MoreTabUI.i(this.zdu).czg();
    }
    if ((MoreTabUI.t(this.zdu)) && (!MoreTabUI.m(this.zdu)))
    {
      i locali = i.sFa;
      i.cDJ().cWD = System.currentTimeMillis();
      locali = i.sFa;
      i.cDK();
    }
    AppMethodBeat.o(29706);
  }
  
  public final void cbZ()
  {
    AppMethodBeat.i(29707);
    if (MoreTabUI.i(this.zdu) != null) {
      MoreTabUI.i(this.zdu).czh();
    }
    AppMethodBeat.o(29707);
  }
  
  public final void cca()
  {
    AppMethodBeat.i(29708);
    ab.i("MicroMsg.MoreTabUI", "story_cat onMuteIn");
    MoreTabUI.u(this.zdu).czi();
    AppMethodBeat.o(29708);
  }
  
  public final void ccb()
  {
    AppMethodBeat.i(29709);
    MoreTabUI.u(this.zdu).czj();
    AppMethodBeat.o(29709);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(29705);
    if (MoreTabUI.i(this.zdu) == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.MoreTabUI", "story_cat onPostClose, storyGallery is null?:%s", new Object[] { Boolean.valueOf(bool) });
      if (MoreTabUI.i(this.zdu) != null)
      {
        MoreTabUI.i(this.zdu).lN(true);
        MoreTabUI.i(this.zdu).post(new MoreTabUI.10.1(this));
      }
      MoreTabUI.a(this.zdu, false);
      MoreTabUI.r(this.zdu);
      MoreTabUI.s(this.zdu).cbX();
      if ((MoreTabUI.t(this.zdu)) && (!MoreTabUI.m(this.zdu)))
      {
        long l = System.currentTimeMillis();
        i locali = i.sFa;
        i.mO(l);
        locali = i.sFa;
        i.cDJ().cVu = l;
      }
      AppMethodBeat.o(29705);
      return;
    }
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(29704);
    if (MoreTabUI.i(this.zdu) == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.MoreTabUI", "story_cat onPostOpen, storyGallery is null?:%s", new Object[] { Boolean.valueOf(bool) });
      if (MoreTabUI.i(this.zdu) != null)
      {
        i locali = i.sFa;
        i.cDo().cVa = 1L;
        locali = i.sFa;
        i.cDo().cWy = 1L;
        MoreTabUI.i(this.zdu).K(paramBoolean, true);
        MoreTabUI.a(this.zdu, 8);
        MoreTabUI.j(this.zdu);
        MoreTabUI.k(this.zdu);
      }
      MoreTabUI.a(this.zdu, true);
      MoreTabUI.l(this.zdu);
      if ((!MoreTabUI.m(this.zdu)) && (!MoreTabUI.n(this.zdu)))
      {
        int i = g.RL().Ru().getInt(ac.a.yLI, 0);
        g.RL().Ru().set(ac.a.yLI, Integer.valueOf(i + 1));
        MoreTabUI.o(this.zdu);
      }
      AppMethodBeat.o(29704);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI.10
 * JD-Core Version:    0.7.0.1
 */