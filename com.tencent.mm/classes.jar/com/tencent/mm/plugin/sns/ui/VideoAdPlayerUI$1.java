package com.tencent.mm.plugin.sns.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.d;
import com.tencent.mm.modelstat.i;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.a;
import com.tencent.mm.plugin.sns.a.b.a.a;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class VideoAdPlayerUI$1
  implements VideoPlayView.a
{
  VideoAdPlayerUI$1(VideoAdPlayerUI paramVideoAdPlayerUI) {}
  
  public final void bBr()
  {
    VideoAdPlayerUI.d(this.pkW).bH(false);
    a locala = VideoAdPlayerUI.a(this.pkW).olx;
    locala.omv += (int)bk.cp(VideoAdPlayerUI.a(this.pkW).olx.omz);
    VideoAdPlayerUI.a(this.pkW, false);
  }
  
  public final void bBs()
  {
    y.i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
    Object localObject = VideoAdPlayerUI.a(this.pkW).olx;
    ((a)localObject).omu += 1;
    VideoAdPlayerUI.a(this.pkW, false);
    if (VideoAdPlayerUI.e(this.pkW) != 0)
    {
      localObject = new i(13227, "1,2," + VideoAdPlayerUI.i(this.pkW) + "," + VideoAdPlayerUI.f(this.pkW) + "," + VideoAdPlayerUI.g(this.pkW) + "," + bk.UX() + "," + VideoAdPlayerUI.h(this.pkW) + "," + VideoAdPlayerUI.i(this.pkW), (int)bk.UX());
      g.DQ();
      g.DO().dJT.a((m)localObject, 0);
    }
  }
  
  public final void bBt()
  {
    y.i("MicroMsg.VideoPlayerUI", "onPlayDownloadedPartComplete");
    VideoAdPlayerUI.a(this.pkW, false);
    VideoAdPlayerUI.c(this.pkW).bBo();
  }
  
  public final void iQ(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = VideoAdPlayerUI.a(this.pkW).olx;
      if (this.pkW.getResources().getConfiguration().orientation != 2) {
        break label291;
      }
    }
    label291:
    for (int i = 2;; i = 1)
    {
      ((a)localObject).omy = i;
      VideoAdPlayerUI.a(this.pkW).olx.omz = bk.UZ();
      VideoAdPlayerUI.a(this.pkW).olx.omx = 2;
      VideoAdPlayerUI.a(this.pkW).olx.omv = 0;
      if ((!VideoAdPlayerUI.b(this.pkW)) && ((int)VideoAdPlayerUI.c(this.pkW).getLastProgresstime() == 0))
      {
        localObject = VideoAdPlayerUI.a(this.pkW).olx;
        ((a)localObject).omt += 1;
      }
      VideoAdPlayerUI.a(this.pkW).olx.omz = bk.UZ();
      VideoAdPlayerUI.d(this.pkW).a(VideoAdPlayerUI.c(this.pkW));
      if (VideoAdPlayerUI.e(this.pkW) != 0)
      {
        localObject = new i(13227, "1,1,0," + VideoAdPlayerUI.f(this.pkW) + "," + VideoAdPlayerUI.g(this.pkW) + "," + bk.UX() + "," + VideoAdPlayerUI.h(this.pkW) + "," + VideoAdPlayerUI.i(this.pkW), (int)bk.UX());
        g.DQ();
        g.DO().dJT.a((m)localObject, 0);
      }
      VideoAdPlayerUI.a(this.pkW, true);
      return;
    }
  }
  
  public final void xv(int paramInt)
  {
    if (VideoAdPlayerUI.i(this.pkW) == 0)
    {
      VideoAdPlayerUI.a(this.pkW, paramInt);
      VideoAdPlayerUI.j(this.pkW).pkD = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI.1
 * JD-Core Version:    0.7.0.1
 */