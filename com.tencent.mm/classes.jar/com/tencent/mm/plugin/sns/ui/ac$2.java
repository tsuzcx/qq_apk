package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;

final class ac$2
  implements View.OnClickListener
{
  ac$2(ac paramac) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38339);
    if (this.rIQ.rIC)
    {
      g.RM();
      if (!g.RL().isSDCardAvailable())
      {
        t.ii(this.rIQ.cmc);
        AppMethodBeat.o(38339);
        return;
      }
      try
      {
        paramView = new ay(this.rIQ.cmc);
        paramView.sao = new ac.2.1(this);
        paramView.sap = new ac.2.2(this);
        paramView.cwt();
        AppMethodBeat.o(38339);
        return;
      }
      catch (Exception paramView)
      {
        AppMethodBeat.o(38339);
        return;
      }
    }
    if (!com.tencent.mm.vfs.e.cN(this.rIQ.videoPath))
    {
      ab.i("MicroMsg.SightWidget", "click videopath is not exist " + this.rIQ.videoPath);
      AppMethodBeat.o(38339);
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
      paramView = new Intent(this.rIQ.cmc, SnsOnlineVideoActivity.class);
      paramView.putExtra("intent_videopath", this.rIQ.videoPath);
      paramView.putExtra("intent_thumbpath", this.rIQ.thumbPath);
      paramView.putExtra("intent_isad", false);
      paramView.putExtra("intent_ispreview", true);
      paramView.putExtra("KBlockAdd", this.rIQ.rIK);
      paramView.putExtra("sns_video_scene", 6);
      paramView.putExtra("img_gallery_left", arrayOfInt[0]);
      paramView.putExtra("img_gallery_top", arrayOfInt[1]);
      paramView.putExtra("img_gallery_width", j);
      paramView.putExtra("img_gallery_height", i);
      this.rIQ.cmc.startActivityForResult(paramView, 12);
      this.rIQ.cmc.overridePendingTransition(0, 0);
      AppMethodBeat.o(38339);
      return;
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac.2
 * JD-Core Version:    0.7.0.1
 */