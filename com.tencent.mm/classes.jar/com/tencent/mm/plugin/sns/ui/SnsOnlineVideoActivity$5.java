package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.br.d;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class SnsOnlineVideoActivity$5
  implements n.c
{
  SnsOnlineVideoActivity$5(SnsOnlineVideoActivity paramSnsOnlineVideoActivity) {}
  
  public final void a(l paraml)
  {
    int i = 1;
    if (bk.ZR(g.AA().getValue("SIGHTCannotTransmitForFav")) == 0)
    {
      boolean bool1 = com.tencent.mm.vfs.e.bK(SnsOnlineVideoActivity.r(this.pbr));
      boolean bool2 = com.tencent.mm.vfs.e.bK(SnsOnlineVideoActivity.s(this.pbr));
      y.i("MicroMsg.SnsOnlineVideoActivity", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      paraml.add(0, 3, 0, this.pbr.getString(i.j.sns_ad_video_right_menu_send_friend));
      if ((!bool1) || (!bool2)) {}
    }
    for (;;)
    {
      if (d.SP("favorite")) {
        paraml.add(0, 2, 0, this.pbr.getString(i.j.plugin_favorite_opt));
      }
      paraml.add(0, 5, 0, this.pbr.getString(i.j.save_video_to_local));
      if (i != 0)
      {
        do localdo = new do();
        localdo.bJZ.bJQ = SnsOnlineVideoActivity.t(this.pbr);
        a.udP.m(localdo);
        if (localdo.bKa.bJy) {
          paraml.add(0, 4, 0, this.pbr.getString(i.j.app_open));
        }
      }
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.5
 * JD-Core Version:    0.7.0.1
 */