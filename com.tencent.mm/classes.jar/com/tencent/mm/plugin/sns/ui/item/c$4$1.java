package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.storage.b.c.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collections;
import java.util.List;

final class c$4$1
  implements SnsDrawGestureView.a
{
  c$4$1(c.4 param4) {}
  
  public final void cwT()
  {
    AppMethodBeat.i(40138);
    com.tencent.mm.plugin.sns.data.i.la(false);
    c.a.b(this.sik.sii).setBackgroundColor(this.sik.sih.mActivity.getResources().getColor(2131690476));
    AppMethodBeat.o(40138);
  }
  
  public final void dr(List<PointF> paramList)
  {
    int i = 1;
    AppMethodBeat.i(40139);
    com.tencent.mm.plugin.sns.data.i.la(true);
    Object localObject1 = com.tencent.mm.plugin.sns.data.i.ZP(this.sik.sgg.rra);
    c.a.b(this.sik.sii).setBackgroundColor(0);
    if ((((List)localObject1).size() > 0) && (paramList.size() > 0)) {
      try
      {
        float f1 = com.tencent.mm.ui.tools.a.a.v((List)localObject1, paramList);
        String str = com.tencent.mm.plugin.sns.data.i.cZ((List)localObject1);
        Collections.reverse((List)localObject1);
        float f2 = com.tencent.mm.ui.tools.a.a.v((List)localObject1, paramList);
        float f3 = (float)Math.acos(Math.max(f1, f2));
        ab.i("MicroMsg.FullCardAdTimeLineItem", "similarity: %f,%f, distance:%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
        if (f3 <= this.sik.sgg.rqZ)
        {
          this.sik.sih.rkX.rWP.rFy.i(this.sik.sii);
          com.tencent.mm.plugin.sns.data.i.e(new long[] { 20L, 100L });
          Object localObject2 = new int[2];
          this.sik.sii.rMB.getLocationInWindow((int[])localObject2);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("img_gallery_left", localObject2[0]);
          ((Intent)localObject1).putExtra("img_gallery_top", localObject2[1]);
          ((Intent)localObject1).putExtra("img_gallery_width", this.sik.sii.rMB.getWidth());
          ((Intent)localObject1).putExtra("img_gallery_height", this.sik.sii.rMB.getHeight());
          ((Intent)localObject1).putExtra("sns_landing_pages_share_sns_id", this.sik.rFG.getSnsId());
          ((Intent)localObject1).putExtra("sns_landing_pages_rawSnsId", this.sik.rFG.csh().Id);
          ((Intent)localObject1).putExtra("sns_landing_pages_ux_info", this.sik.rFG.csP());
          localObject2 = this.sik.rFG.csb().cqw();
          if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.gD(this.sik.rFG.csb().cBW, "adFullCardGestureCanvasInfo")) {
            ((String)localObject2).replaceAll("(?s)<adFullCardGestureCanvasInfo[^>]*>.*?</adFullCardGestureCanvasInfo>", "");
          }
          ((Intent)localObject1).putExtra("sns_landing_pages_xml", (String)localObject2);
          ((Intent)localObject1).setClass(this.sik.sih.mActivity, SnsAdNativeLandingPagesUI.class);
          ((Intent)localObject1).putExtra("sns_landig_pages_from_source", 1);
          ((Intent)localObject1).putExtra("sns_landing_pages_xml_prefix", "adxml");
          ((Intent)localObject1).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
          ((Intent)localObject1).putExtra("sns_landing_is_native_sight_ad", true);
          this.sik.sih.mActivity.startActivity((Intent)localObject1);
          localObject1 = new SnsAdClick(1, 1, com.tencent.mm.plugin.sns.data.i.ZN(this.sik.rFG.csh().Id), 25, 21);
          if ((this.sik.sih.mActivity instanceof SnsTimeLineUI)) {
            ((SnsAdClick)localObject1).fQA = ((SnsTimeLineUI)this.sik.sih.mActivity).cwf().di(this.sik.rFG.csH(), 25);
          }
          com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject1);
          i = 2;
        }
        h.qsU.e(16552, new Object[] { this.sik.rFG.csh().Id, str, com.tencent.mm.plugin.sns.data.i.cZ(com.tencent.mm.ui.tools.a.a.u(paramList, 20)), Integer.valueOf((int)(100.0F * f3)), Integer.valueOf(i), Long.valueOf(bo.apW(this.sik.rFG.csM())), this.sik.rFG.csd().cFe });
        return;
      }
      catch (Exception paramList)
      {
        ab.printErrStackTrace("MicroMsg.FullCardAdTimeLineItem", paramList, "recog gesture error!", new Object[0]);
        return;
      }
      finally
      {
        c.a.b(this.sik.sii).cxM();
        AppMethodBeat.o(40139);
      }
    }
    AppMethodBeat.o(40139);
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(40140);
    com.tencent.mm.plugin.sns.data.i.la(true);
    c.a.b(this.sik.sii).setBackgroundColor(0);
    this.sik.sii.sfG.rLD.performClick();
    AppMethodBeat.o(40140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.c.4.1
 * JD-Core Version:    0.7.0.1
 */