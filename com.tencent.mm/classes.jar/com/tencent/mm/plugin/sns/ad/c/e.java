package com.tencent.mm.plugin.sns.ad.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.api.b;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
{
  public static void a(Context paramContext, b.b paramb, String paramString)
  {
    AppMethodBeat.i(219012);
    if (paramb == null)
    {
      ae.e("ScanJumpHelper", "jumpScanUI, jumpInfo==null");
      AppMethodBeat.o(219012);
      return;
    }
    ae.i("ScanJumpHelper", "jumpScanUI, desc=" + paramb.desc + ", gestureId=" + paramb.zOi + ", uxinfo=" + paramString);
    d.a(paramb, "");
    ScanGoodsRequest localScanGoodsRequest = ScanGoodsRequest.dNS();
    localScanGoodsRequest.yzK = paramb.desc;
    localScanGoodsRequest.yzH = d.ayX(paramb.zOg);
    localScanGoodsRequest.yzJ = d.ayX(paramb.oEV);
    localScanGoodsRequest.yzI = d.ayX(paramb.zOh);
    localScanGoodsRequest.putExtra("key_sns_ad_ux_info", paramString);
    localScanGoodsRequest.putExtra("key_gesture_id", String.valueOf(paramb.zOi));
    ((b)g.ab(b.class)).a(paramContext, localScanGoodsRequest);
    AppMethodBeat.o(219012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c.e
 * JD-Core Version:    0.7.0.1
 */