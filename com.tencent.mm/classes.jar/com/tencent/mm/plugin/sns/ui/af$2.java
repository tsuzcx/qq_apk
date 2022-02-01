package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;

final class af$2
  implements View.OnClickListener
{
  af$2(af paramaf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(97990);
    if (this.xpq.xoQ)
    {
      g.afC();
      if (!g.afB().isSDCardAvailable())
      {
        t.g(this.xpq.imP, null);
        AppMethodBeat.o(97990);
        return;
      }
      try
      {
        paramView = new com.tencent.mm.ui.widget.a.e(this.xpq.imP, 1, false);
        paramView.HrX = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(97988);
            if (!com.tencent.mm.platformtools.ab.hWB) {
              paramAnonymousl.c(0, af.2.this.xpq.imP.getString(2131755747));
            }
            paramAnonymousl.c(1, af.2.this.xpq.imP.getString(2131755754));
            AppMethodBeat.o(97988);
          }
        };
        paramView.HrY = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            boolean bool1 = true;
            AppMethodBeat.i(97989);
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(97989);
              return;
              paramAnonymousMenuItem = af.2.this.xpq;
              paramAnonymousMenuItem.Nk(1);
              long l = ce.asR();
              h.vKh.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), com.tencent.mm.plugin.sns.data.q.dsd(), Long.valueOf(l) });
              Object localObject1 = new SightParams(2, 0);
              o.aCH();
              Object localObject2 = com.tencent.mm.plugin.mmsight.d.agZ(o.getAccVideoPath());
              localObject1 = RecordConfigProvider.a((String)localObject2, com.tencent.mm.plugin.mmsight.d.ahb((String)localObject2), ((SightParams)localObject1).gCB, ((SightParams)localObject1).gCB.duration * 1000, 2);
              if (((b)g.ab(b.class)).a(b.a.pqf, false)) {
                ((RecordConfigProvider)localObject1).vhB = 2;
              }
              localObject2 = new VideoCaptureReportInfo();
              ((VideoCaptureReportInfo)localObject2).pOf = 7;
              ((RecordConfigProvider)localObject1).vhY = ((VideoCaptureReportInfo)localObject2);
              localObject2 = new af.9(paramAnonymousMenuItem);
              CaptureDataManager.vhw.vhv = ((CaptureDataManager.b)localObject2);
              if (((b)g.ab(b.class)).a(b.a.pqd, true))
              {
                localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
                com.tencent.mm.plugin.recordvideo.jumper.a.a(paramAnonymousMenuItem.imP, 11, 2130772137, 2130772138, (RecordConfigProvider)localObject1);
                AppMethodBeat.o(97989);
                return;
              }
              localObject1 = new Intent();
              com.tencent.mm.pluginsdk.ui.tools.q.a(paramAnonymousMenuItem.imP, 11, (Intent)localObject1, 2, 0);
              AppMethodBeat.o(97989);
              return;
              paramAnonymousMenuItem = af.2.this.xpq.imP.getSharedPreferences(aj.eFD(), 0).getString("gallery", "1");
              l = ce.asR();
              h.vKh.f(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2), com.tencent.mm.plugin.sns.data.q.dsd(), Long.valueOf(l) });
              if (!paramAnonymousMenuItem.equalsIgnoreCase("0")) {
                break;
              }
              com.tencent.mm.pluginsdk.ui.tools.q.aN(af.2.this.xpq.imP);
              af.2.this.xpq.Nk(2);
            }
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.d.awT().awW().duration);
            boolean bool2 = ((b)g.ab(b.class)).a(b.a.pqO, false);
            if ((g.afB().afk().getInt(ae.a.FsS, 0) == 1) || (bool2))
            {
              paramAnonymousInt = 1;
              label474:
              if (paramAnonymousInt != 0) {
                break label515;
              }
            }
            for (;;)
            {
              paramAnonymousMenuItem.putExtra("key_can_select_video_and_pic", bool1);
              com.tencent.mm.pluginsdk.ui.tools.q.a(af.2.this.xpq.imP, 9, 9, 4, 3, paramAnonymousMenuItem);
              break;
              paramAnonymousInt = 0;
              break label474;
              label515:
              bool1 = false;
            }
          }
        };
        paramView.csG();
        AppMethodBeat.o(97990);
        return;
      }
      catch (Exception paramView)
      {
        AppMethodBeat.o(97990);
        return;
      }
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
      if (this.xpq.xpa.J(arrayOfInt[0], arrayOfInt[1], j, i))
      {
        AppMethodBeat.o(97990);
        return;
      }
      if (!i.eK(this.xpq.videoPath))
      {
        ad.i("MicroMsg.SightWidget", "click videopath is not exist " + this.xpq.videoPath);
        AppMethodBeat.o(97990);
        return;
      }
      paramView = new Intent(this.xpq.imP, SnsOnlineVideoActivity.class);
      paramView.putExtra("intent_videopath", this.xpq.videoPath);
      paramView.putExtra("intent_thumbpath", this.xpq.thumbPath);
      paramView.putExtra("intent_isad", false);
      paramView.putExtra("intent_ispreview", true);
      paramView.putExtra("KBlockAdd", this.xpq.xoY);
      paramView.putExtra("sns_video_scene", 6);
      paramView.putExtra("img_gallery_left", arrayOfInt[0]);
      paramView.putExtra("img_gallery_top", arrayOfInt[1]);
      paramView.putExtra("img_gallery_width", j);
      paramView.putExtra("img_gallery_height", i);
      this.xpq.imP.startActivityForResult(paramView, 12);
      this.xpq.imP.overridePendingTransition(0, 0);
      AppMethodBeat.o(97990);
      return;
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.af.2
 * JD-Core Version:    0.7.0.1
 */