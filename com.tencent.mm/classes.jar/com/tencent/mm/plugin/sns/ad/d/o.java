package com.tencent.mm.plugin.sns.ad.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.api.c;
import com.tencent.mm.plugin.sns.ad.timeline.b.f;
import com.tencent.mm.plugin.sns.storage.ADXml.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
{
  public static void a(Context paramContext, ADXml.b paramb, String paramString)
  {
    AppMethodBeat.i(193991);
    if (paramb == null)
    {
      Log.e("ScanJumpHelper", "jumpScanUI, jumpInfo==null");
      AppMethodBeat.o(193991);
      return;
    }
    Log.i("ScanJumpHelper", "jumpScanUI, desc=" + paramb.desc + ", gestureId=" + paramb.Kjw + ", uxinfo=" + paramString);
    f.a(paramb, "");
    ScanGoodsRequest localScanGoodsRequest = ScanGoodsRequest.fBW();
    localScanGoodsRequest.IGv = paramb.desc;
    localScanGoodsRequest.IGs = f.aYH(paramb.JyG);
    localScanGoodsRequest.IGu = f.aYH(paramb.toE);
    localScanGoodsRequest.IGt = f.aYH(paramb.Kjv);
    localScanGoodsRequest.putExtra("key_sns_ad_ux_info", paramString);
    localScanGoodsRequest.putExtra("key_gesture_id", String.valueOf(paramb.Kjw));
    ((c)h.ae(c.class)).a(paramContext, localScanGoodsRequest);
    AppMethodBeat.o(193991);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.o
 * JD-Core Version:    0.7.0.1
 */