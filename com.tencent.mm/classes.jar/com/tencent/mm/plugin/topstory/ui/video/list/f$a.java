package com.tencent.mm.plugin.topstory.ui.video.list;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class f$a
  implements c
{
  private float pGY;
  
  f$a(f paramf)
  {
    this.pGY = com.tencent.mm.cb.a.fk(paramf.getContext());
  }
  
  public final int aG(float paramFloat)
  {
    paramFloat /= this.pGY;
    int j = this.pHJ.getListVideoUIComponent().bNx().getVideoDurationSec();
    int i = getCurrentPosition();
    int k = (int)(paramFloat * j) + i;
    if (k < 0) {
      i = 0;
    }
    for (;;)
    {
      String str = com.tencent.mm.plugin.websearch.ui.b.ce(j * 1000L);
      f.J(this.pHJ).setText(com.tencent.mm.plugin.websearch.ui.b.ce(i * 1000L) + "/" + str);
      return i;
      i = k;
      if (k > j) {
        i = j;
      }
    }
  }
  
  public final void akl()
  {
    y.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onSingleTap");
    int i;
    if (f.H(this.pHJ))
    {
      if (f.f(this.pHJ).getVisibility() != 0) {
        break label49;
      }
      i = 1;
      if (i == 0) {
        break label54;
      }
      f.f(this.pHJ).setVisibility(8);
    }
    label49:
    label54:
    do
    {
      return;
      i = 0;
      break;
      g localg = f.f(this.pHJ);
      localg.setVisibility(0);
      localg.bOz();
      if (localg.pHm == null) {
        localg.pHm = new am(new g.1(localg), false);
      }
      localg.pHm.stopTimer();
      localg.pHm.S(2000L, 2000L);
    } while (this.pHJ.getListItemUIComponent() == null);
    this.pHJ.getListItemUIComponent().bNq();
    this.pHJ.getListItemUIComponent().bNp();
  }
  
  public final void akm()
  {
    y.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onDoubleTap");
  }
  
  public final void akn()
  {
    f.I(this.pHJ).setVisibility(0);
    f.f(this.pHJ).ofr.setVisibility(8);
  }
  
  public final boolean bNK()
  {
    return !f.L(this.pHJ);
  }
  
  public final int getCurrentPosition()
  {
    return this.pHJ.getListVideoUIComponent().bNx().getCurrPosSec();
  }
  
  public final void zz(int paramInt)
  {
    f.f(this.pHJ).bOz();
    f.K(this.pHJ).setVisibility(8);
    this.pHJ.seekTo(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f.a
 * JD-Core Version:    0.7.0.1
 */