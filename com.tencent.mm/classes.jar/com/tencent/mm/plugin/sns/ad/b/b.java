package com.tencent.mm.plugin.sns.ad.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.api.a;
import com.tencent.mm.plugin.sns.storage.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public static void a(Context paramContext, b.a parama, String paramString)
  {
    AppMethodBeat.i(197557);
    if (parama == null)
    {
      ad.e("ScanJumpHelper", "jumpScanUI, jumpInfo==null");
      AppMethodBeat.o(197557);
      return;
    }
    ad.i("ScanJumpHelper", "jumpScanUI, desc=" + parama.desc + ", gestureId=" + parama.zwJ + ", uxinfo=" + paramString);
    com.tencent.mm.plugin.sns.ad.timeline.a.b.a(parama, "");
    ScanGoodsRequest localScanGoodsRequest = ScanGoodsRequest.dKA();
    localScanGoodsRequest.yjO = parama.desc;
    localScanGoodsRequest.yjL = com.tencent.mm.plugin.sns.ad.timeline.a.b.axF(parama.zwH);
    localScanGoodsRequest.yjN = com.tencent.mm.plugin.sns.ad.timeline.a.b.axF(parama.oyt);
    localScanGoodsRequest.yjM = com.tencent.mm.plugin.sns.ad.timeline.a.b.axF(parama.zwI);
    localScanGoodsRequest.putExtra("key_sns_ad_ux_info", paramString);
    localScanGoodsRequest.putExtra("key_gesture_id", String.valueOf(parama.zwJ));
    ((a)g.ab(a.class)).a(paramContext, localScanGoodsRequest);
    AppMethodBeat.o(197557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.b.b
 * JD-Core Version:    0.7.0.1
 */