package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;

final class ag$6
  implements n.d
{
  ag$6(ag paramag) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(38482);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(38482);
      return;
    case 0: 
      paramMenuItem = this.rKd;
      paramInt = 9 - paramMenuItem.rJW.rKh.size();
      if (paramInt <= 0)
      {
        ab.e("MicroMsg.PicWidget", "has select the max image count");
        AppMethodBeat.o(38482);
        return;
      }
      Object localObject1 = new SightParams(2, 0);
      o.alD();
      Object localObject2 = d.TU(o.getAccVideoPath());
      localObject1 = RecordConfigProvider.a((String)localObject2, d.TW((String)localObject2), ((SightParams)localObject1).fcu, ((SightParams)localObject1).fcu.duration * 1000, 2);
      if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVS, false)) {
        ((RecordConfigProvider)localObject1).qbm = 2;
      }
      localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).mhr = 2;
      ((RecordConfigProvider)localObject1).qbE = ((VideoCaptureReportInfo)localObject2);
      localObject2 = new ag.8(paramMenuItem);
      l = cb.abq();
      if (paramInt < 9)
      {
        h.qsU.e(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), i.ls(l), Long.valueOf(l) });
        ((RecordConfigProvider)localObject1).qbu = Boolean.FALSE;
        CaptureDataManager.qbh.qbg = ((CaptureDataManager.b)localObject2);
        if (!((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVQ, true)) {
          break label344;
        }
        localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.qbG;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(paramMenuItem.cmc, 11, (RecordConfigProvider)localObject1);
      }
      for (;;)
      {
        paramMenuItem.EG(1);
        AppMethodBeat.o(38482);
        return;
        h.qsU.e(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), i.ls(l), Long.valueOf(l) });
        break;
        label344:
        if (paramInt < 9)
        {
          localObject1 = new Intent();
          n.a(paramMenuItem.cmc, 11, (Intent)localObject1, 2, 2);
        }
        else
        {
          localObject1 = new Intent();
          n.a(paramMenuItem.cmc, 11, (Intent)localObject1, 2, 0);
        }
      }
    }
    paramInt = 9 - this.rKd.rJW.rKh.size();
    if (paramInt <= 0)
    {
      ab.e("MicroMsg.PicWidget", "has select the max image count");
      AppMethodBeat.o(38482);
      return;
    }
    paramMenuItem = this.rKd.cmc.getSharedPreferences(ah.dsP(), 0).getString("gallery", "1");
    long l = cb.abq();
    h.qsU.e(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2), i.ls(l), Long.valueOf(l) });
    if (paramMenuItem.equalsIgnoreCase("0")) {
      n.ar(this.rKd.cmc);
    }
    for (;;)
    {
      this.rKd.EG(2);
      break;
      if (paramInt < 9) {
        n.a(this.rKd.cmc, 9, paramInt, 4, 1, null);
      } else {
        n.a(this.rKd.cmc, 9, paramInt, 4, 3, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag.6
 * JD-Core Version:    0.7.0.1
 */