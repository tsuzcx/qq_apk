package com.tencent.mm.plugin.sns.ad.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.sns.storage.b.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  public static void a(Context paramContext, b.a parama, String paramString)
  {
    AppMethodBeat.i(199936);
    if (parama == null)
    {
      ac.e("ScanJumpHelper", "jumpScanUI, jumpInfo==null");
      AppMethodBeat.o(199936);
      return;
    }
    ac.i("ScanJumpHelper", "jumpScanUI, desc=" + parama.desc + ", gestureId=" + parama.ygF + ", uxinfo=" + paramString);
    com.tencent.mm.plugin.sns.ad.timeline.a.a.a(parama, "");
    ScanGoodsRequest localScanGoodsRequest = ScanGoodsRequest.dzc();
    localScanGoodsRequest.wWg = parama.desc;
    localScanGoodsRequest.wWd = com.tencent.mm.plugin.sns.ad.timeline.a.a.aCn(parama.ygD);
    localScanGoodsRequest.wWf = com.tencent.mm.plugin.sns.ad.timeline.a.a.aCn(parama.nUY);
    localScanGoodsRequest.wWe = com.tencent.mm.plugin.sns.ad.timeline.a.a.aCn(parama.ygE);
    localScanGoodsRequest.iM("key_sns_ad_ux_info", paramString);
    localScanGoodsRequest.iM("key_gesture_id", String.valueOf(parama.ygF));
    ((com.tencent.mm.plugin.scanner.api.a)g.ab(com.tencent.mm.plugin.scanner.api.a.class)).a(paramContext, localScanGoodsRequest);
    AppMethodBeat.o(199936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.a.a
 * JD-Core Version:    0.7.0.1
 */