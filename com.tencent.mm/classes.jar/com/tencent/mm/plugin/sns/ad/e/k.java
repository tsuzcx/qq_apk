package com.tencent.mm.plugin.sns.ad.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.api.c;
import com.tencent.mm.plugin.sns.ad.timeline.b.e;
import com.tencent.mm.plugin.sns.storage.ADXml.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
{
  public static void a(Context paramContext, ADXml.b paramb, String paramString)
  {
    AppMethodBeat.i(201940);
    if (paramb == null)
    {
      Log.e("ScanJumpHelper", "jumpScanUI, jumpInfo==null");
      AppMethodBeat.o(201940);
      return;
    }
    Log.i("ScanJumpHelper", "jumpScanUI, desc=" + paramb.desc + ", gestureId=" + paramb.DWl + ", uxinfo=" + paramString);
    e.a(paramb, "");
    ScanGoodsRequest localScanGoodsRequest = ScanGoodsRequest.eOU();
    localScanGoodsRequest.CAQ = paramb.desc;
    localScanGoodsRequest.CAN = e.aNR(paramb.DWj);
    localScanGoodsRequest.CAP = e.aNR(paramb.pSE);
    localScanGoodsRequest.CAO = e.aNR(paramb.DWk);
    localScanGoodsRequest.putExtra("key_sns_ad_ux_info", paramString);
    localScanGoodsRequest.putExtra("key_gesture_id", String.valueOf(paramb.DWl));
    ((c)g.af(c.class)).a(paramContext, localScanGoodsRequest);
    AppMethodBeat.o(201940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.k
 * JD-Core Version:    0.7.0.1
 */