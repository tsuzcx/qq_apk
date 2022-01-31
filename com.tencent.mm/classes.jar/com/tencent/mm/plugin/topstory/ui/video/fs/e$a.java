package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.topstory.ui.video.c;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.sdk.platformtools.y;

final class e$a
  implements c
{
  private float pGY;
  
  e$a(e parame)
  {
    this.pGY = com.tencent.mm.cb.a.fk(parame.getContext());
  }
  
  public final int aG(float paramFloat)
  {
    paramFloat /= this.pGY;
    int j = this.pGX.getFSVideoUIComponent().bNx().getVideoDurationSec();
    int i = getCurrentPosition();
    int k = (int)(paramFloat * j) + i;
    if (k < 0) {
      i = 0;
    }
    for (;;)
    {
      String str = com.tencent.mm.plugin.websearch.ui.b.ce(j * 1000L);
      e.N(this.pGX).setText(com.tencent.mm.plugin.websearch.ui.b.ce(i * 1000L) + "/" + str);
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
    if (e.L(this.pGX))
    {
      if (e.l(this.pGX).getVisibility() != 0) {
        break label49;
      }
      i = 1;
      if (i == 0) {
        break label54;
      }
      e.l(this.pGX).setVisibility(8);
    }
    label49:
    label54:
    do
    {
      return;
      i = 0;
      break;
      e.l(this.pGX).show();
    } while (this.pGX.getFSItemUIComponent() == null);
    this.pGX.getFSItemUIComponent().bNq();
    this.pGX.getFSItemUIComponent().bNp();
  }
  
  public final void akm()
  {
    y.d("MicroMsg.TopStory.TopStoryListVideoContainer", "onDoubleTap");
  }
  
  public final void akn()
  {
    e.M(this.pGX).setVisibility(0);
    e.l(this.pGX).ofr.setVisibility(8);
  }
  
  public final boolean bNK()
  {
    return !e.P(this.pGX);
  }
  
  public final int getCurrentPosition()
  {
    return this.pGX.getFSVideoUIComponent().bNx().getCurrPosSec();
  }
  
  public final void zz(int paramInt)
  {
    e.l(this.pGX).bOz();
    e.O(this.pGX).setVisibility(8);
    this.pGX.seekTo(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.a
 * JD-Core Version:    0.7.0.1
 */