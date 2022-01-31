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
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;

final class ac$2$2
  implements n.d
{
  ac$2$2(ac.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(38338);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(38338);
      return;
    case 0: 
      paramMenuItem = this.rIR.rIQ;
      paramMenuItem.EG(1);
      l = cb.abq();
      h.qsU.e(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), i.ls(l), Long.valueOf(l) });
      Object localObject1 = new SightParams(2, 0);
      o.alD();
      Object localObject2 = com.tencent.mm.plugin.mmsight.d.TU(o.getAccVideoPath());
      localObject1 = RecordConfigProvider.a((String)localObject2, com.tencent.mm.plugin.mmsight.d.TW((String)localObject2), ((SightParams)localObject1).fcu, ((SightParams)localObject1).fcu.duration * 1000, 2);
      if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVS, false)) {
        ((RecordConfigProvider)localObject1).qbm = 2;
      }
      localObject2 = new VideoCaptureReportInfo();
      ((VideoCaptureReportInfo)localObject2).mhr = 1;
      ((RecordConfigProvider)localObject1).qbE = ((VideoCaptureReportInfo)localObject2);
      localObject2 = new ac.9(paramMenuItem);
      CaptureDataManager.qbh.qbg = ((CaptureDataManager.b)localObject2);
      if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVQ, true))
      {
        localObject2 = com.tencent.mm.plugin.recordvideo.jumper.a.qbG;
        com.tencent.mm.plugin.recordvideo.jumper.a.a(paramMenuItem.cmc, 11, (RecordConfigProvider)localObject1);
        AppMethodBeat.o(38338);
        return;
      }
      localObject1 = new Intent();
      n.a(paramMenuItem.cmc, 11, (Intent)localObject1, 2, 0);
      AppMethodBeat.o(38338);
      return;
    }
    paramMenuItem = this.rIR.rIQ.cmc.getSharedPreferences(ah.dsP(), 0).getString("gallery", "1");
    long l = cb.abq();
    h.qsU.e(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2), i.ls(l), Long.valueOf(l) });
    if (paramMenuItem.equalsIgnoreCase("0")) {
      n.ar(this.rIR.rIQ.cmc);
    }
    for (;;)
    {
      this.rIR.rIQ.EG(2);
      break;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.d.afW().afZ().duration);
      n.a(this.rIR.rIQ.cmc, 9, 9, 4, 3, paramMenuItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac.2.2
 * JD-Core Version:    0.7.0.1
 */