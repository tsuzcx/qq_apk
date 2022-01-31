package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;

final class ac$2
  implements View.OnClickListener
{
  ac$2(ac paramac) {}
  
  public final void onClick(View paramView)
  {
    if (this.oRe.oQQ)
    {
      g.DQ();
      if (!g.DP().isSDCardAvailable())
      {
        s.gM(this.oRe.bER);
        return;
      }
      try
      {
        paramView = new az(this.oRe.bER);
        paramView.phH = new ac.2.1(this);
        paramView.phI = new ac.2.2(this);
        paramView.bJQ();
        return;
      }
      catch (Exception paramView)
      {
        return;
      }
    }
    if (!com.tencent.mm.vfs.e.bK(this.oRe.videoPath))
    {
      y.i("MicroMsg.SightWidget", "click videopath is not exist " + this.oRe.videoPath);
      return;
    }
    int[] arrayOfInt = new int[2];
    int j;
    int i;
    if (paramView != null)
    {
      paramView.getLocationInWindow(arrayOfInt);
      j = paramView.getWidth();
      i = paramView.getHeight();
    }
    for (;;)
    {
      paramView = new Intent(this.oRe.bER, SnsOnlineVideoActivity.class);
      paramView.putExtra("intent_videopath", this.oRe.videoPath);
      paramView.putExtra("intent_thumbpath", this.oRe.thumbPath);
      paramView.putExtra("intent_isad", false);
      paramView.putExtra("intent_ispreview", true);
      paramView.putExtra("KBlockAdd", this.oRe.oQY);
      paramView.putExtra("img_gallery_left", arrayOfInt[0]);
      paramView.putExtra("img_gallery_top", arrayOfInt[1]);
      paramView.putExtra("img_gallery_width", j);
      paramView.putExtra("img_gallery_height", i);
      this.oRe.bER.startActivityForResult(paramView, 12);
      this.oRe.bER.overridePendingTransition(0, 0);
      return;
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac.2
 * JD-Core Version:    0.7.0.1
 */