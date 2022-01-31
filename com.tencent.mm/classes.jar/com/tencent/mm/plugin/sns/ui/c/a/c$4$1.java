package com.tencent.mm.plugin.sns.ui.c.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.storage.b.c.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.aj;
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
    AppMethodBeat.i(40097);
    com.tencent.mm.plugin.sns.data.i.la(false);
    this.sgh.sge.sgb.setBackgroundColor(this.sgh.sge.context.getResources().getColor(2131690476));
    AppMethodBeat.o(40097);
  }
  
  public final void dr(List<PointF> paramList)
  {
    int i = 2;
    AppMethodBeat.i(40098);
    com.tencent.mm.plugin.sns.data.i.la(true);
    List localList = com.tencent.mm.plugin.sns.data.i.ZP(this.sgh.sgg.rra);
    this.sgh.sge.sgb.setBackgroundColor(0);
    if ((localList.size() > 0) && (paramList.size() > 0)) {}
    for (;;)
    {
      try
      {
        float f1 = com.tencent.mm.ui.tools.a.a.v(localList, paramList);
        Collections.reverse(localList);
        float f2 = com.tencent.mm.ui.tools.a.a.v(localList, paramList);
        float f3 = (float)Math.acos(Math.max(f1, f2));
        ab.i("MicroMsg.FullCardAdDetailItem", "similarity: %f,%f, distance:%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3) });
        if (f3 > this.sgh.sgg.rqZ) {
          break label678;
        }
        this.sgh.sge.rOV.a(this.sgh.sge);
        com.tencent.mm.plugin.sns.data.i.e(new long[] { 20L, 100L });
        Object localObject = new int[2];
        this.sgh.sge.contentView.getLocationInWindow((int[])localObject);
        Intent localIntent = new Intent();
        localIntent.putExtra("img_gallery_left", localObject[0]);
        localIntent.putExtra("img_gallery_top", localObject[1]);
        localIntent.putExtra("img_gallery_width", this.sgh.sge.contentView.getWidth());
        localIntent.putExtra("img_gallery_height", this.sgh.sge.contentView.getHeight());
        localIntent.putExtra("sns_landing_pages_share_sns_id", this.sgh.rFG.getSnsId());
        localIntent.putExtra("sns_landing_pages_rawSnsId", this.sgh.rFG.csh().Id);
        localIntent.putExtra("sns_landing_pages_ux_info", this.sgh.rFG.csP());
        localObject = this.sgh.rFG.csb().cqw();
        if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.gD(this.sgh.rFG.csb().cBW, "adFullCardGestureCanvasInfo")) {
          ((String)localObject).replaceAll("(?s)<adFullCardGestureCanvasInfo[^>]*>.*?</adFullCardGestureCanvasInfo>", "");
        }
        localIntent.putExtra("sns_landing_pages_xml", (String)localObject);
        localIntent.setClass(this.sgh.sge.context, SnsAdNativeLandingPagesUI.class);
        localIntent.putExtra("sns_landig_pages_from_source", 2);
        localIntent.putExtra("sns_landing_pages_xml_prefix", "adxml");
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
        localIntent.putExtra("sns_landing_is_native_sight_ad", true);
        this.sgh.sge.context.startActivity(localIntent);
        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(1, 2, com.tencent.mm.plugin.sns.data.i.ZN(this.sgh.rFG.csh().Id), 25, 21));
        h.qsU.e(16552, new Object[] { this.sgh.rFG.csh().Id, com.tencent.mm.plugin.sns.data.i.cZ(localList), com.tencent.mm.plugin.sns.data.i.cZ(com.tencent.mm.ui.tools.a.a.u(paramList, 20)), Integer.valueOf((int)(100.0F * f3)), Integer.valueOf(i), Long.valueOf(bo.apW(this.sgh.rFG.csM())), this.sgh.rFG.csd().cFe });
        return;
      }
      catch (Exception paramList)
      {
        ab.printErrStackTrace("MicroMsg.FullCardAdDetailItem", paramList, "recog gesture error!", new Object[0]);
        return;
      }
      finally
      {
        this.sgh.sge.sgb.cxM();
        AppMethodBeat.o(40098);
      }
      AppMethodBeat.o(40098);
      return;
      label678:
      i = 1;
    }
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(40099);
    com.tencent.mm.plugin.sns.data.i.la(true);
    this.sgh.sge.sgb.setBackgroundColor(0);
    this.sgh.sge.sfG.rLD.performClick();
    AppMethodBeat.o(40099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.c.4.1
 * JD-Core Version:    0.7.0.1
 */