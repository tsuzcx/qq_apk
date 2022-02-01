package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
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
import com.tencent.mm.plugin.recordvideo.jumper.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;

final class ak$6
  implements n.d
{
  ak$6(ak paramak) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(98161);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(98161);
      return;
    case 0: 
      paramMenuItem = this.xqH;
      paramInt = 9 - paramMenuItem.xqA.xqL.size();
      if (paramInt <= 0)
      {
        ad.e("MicroMsg.PicWidget", "has select the max image count");
        AppMethodBeat.o(98161);
        return;
      }
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
      localObject2 = new ak.8(paramMenuItem);
      l = ce.asR();
      if (paramInt < 9)
      {
        h.vKh.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), com.tencent.mm.plugin.sns.data.q.dsd(), Long.valueOf(l) });
        ((RecordConfigProvider)localObject1).vhN = Boolean.FALSE;
        CaptureDataManager.vhw.vhv = ((CaptureDataManager.b)localObject2);
        if (!((b)g.ab(b.class)).a(b.a.pqd, true)) {
          break label350;
        }
        localObject2 = a.vih;
        a.a(paramMenuItem.imP, 11, 2130772137, 2130772138, (RecordConfigProvider)localObject1);
      }
      for (;;)
      {
        paramMenuItem.Nk(1);
        AppMethodBeat.o(98161);
        return;
        h.vKh.f(13822, new Object[] { Integer.valueOf(1), Integer.valueOf(2), com.tencent.mm.plugin.sns.data.q.dsd(), Long.valueOf(l) });
        break;
        label350:
        if (paramInt < 9)
        {
          localObject1 = new Intent();
          com.tencent.mm.pluginsdk.ui.tools.q.a(paramMenuItem.imP, 11, (Intent)localObject1, 2, 2);
        }
        else
        {
          localObject1 = new Intent();
          com.tencent.mm.pluginsdk.ui.tools.q.a(paramMenuItem.imP, 11, (Intent)localObject1, 2, 0);
        }
      }
    }
    int i = 9 - this.xqH.xqA.xqL.size();
    if (i <= 0)
    {
      ad.e("MicroMsg.PicWidget", "has select the max image count");
      AppMethodBeat.o(98161);
      return;
    }
    paramMenuItem = this.xqH.imP.getSharedPreferences(aj.eFD(), 0).getString("gallery", "1");
    long l = ce.asR();
    h.vKh.f(13822, new Object[] { Integer.valueOf(2), Integer.valueOf(2), com.tencent.mm.plugin.sns.data.q.dsd(), Long.valueOf(l) });
    if (paramMenuItem.equalsIgnoreCase("0")) {
      com.tencent.mm.pluginsdk.ui.tools.q.aN(this.xqH.imP);
    }
    for (;;)
    {
      this.xqH.Nk(2);
      break;
      if (i >= 9) {
        break label584;
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_can_select_video_and_pic", true);
      com.tencent.mm.pluginsdk.ui.tools.q.a(this.xqH.imP, 9, i, 4, 1, paramMenuItem);
    }
    label584:
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("key_edit_video_max_time_length", com.tencent.mm.modelcontrol.d.awT().awW().duration);
    boolean bool = ((b)g.ab(b.class)).a(b.a.pqO, false);
    if ((g.afB().afk().getInt(ae.a.FsS, 0) == 1) || (bool))
    {
      paramInt = 1;
      label652:
      if (paramInt != 0) {
        break label692;
      }
    }
    label692:
    for (bool = true;; bool = false)
    {
      paramMenuItem.putExtra("key_can_select_video_and_pic", bool);
      com.tencent.mm.pluginsdk.ui.tools.q.a(this.xqH.imP, 9, i, 4, 3, paramMenuItem);
      break;
      paramInt = 0;
      break label652;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak.6
 * JD-Core Version:    0.7.0.1
 */