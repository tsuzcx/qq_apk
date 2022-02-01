package com.tencent.mm.plugin.sns.ad.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.api.c;
import com.tencent.mm.plugin.sns.storage.ADXml.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.sdk.platformtools.Log;

public final class s
{
  public static void a(Context paramContext, ADXml.b paramb, String paramString, int paramInt)
  {
    AppMethodBeat.i(309965);
    if (paramb == null)
    {
      Log.e("ScanJumpHelper", "jumpScanUI, jumpInfo==null");
      AppMethodBeat.o(309965);
      return;
    }
    Log.i("ScanJumpHelper", "jumpScanUI, desc=" + paramb.desc + ", gestureId=" + paramb.QHt + ", uxinfo=" + paramString);
    com.tencent.mm.plugin.sns.ad.timeline.helper.h.a(paramb, "");
    ScanGoodsRequest localScanGoodsRequest = ScanGoodsRequest.gPC();
    localScanGoodsRequest.OMD = paramb.desc;
    localScanGoodsRequest.OMA = k.aZH(paramb.PNb);
    localScanGoodsRequest.OMC = k.aZH(paramb.wtd);
    localScanGoodsRequest.OMB = k.aZH(paramb.QHs);
    localScanGoodsRequest.putExtra("key_sns_ad_ux_info", paramString);
    localScanGoodsRequest.putExtra("key_gesture_id", String.valueOf(paramb.QHt));
    ((c)com.tencent.mm.kernel.h.ax(c.class)).a(paramContext, localScanGoodsRequest, paramInt);
    AppMethodBeat.o(309965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.s
 * JD-Core Version:    0.7.0.1
 */