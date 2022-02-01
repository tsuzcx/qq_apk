package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/OfflineScanReporter;", "", "()V", "ACTION_TYPE_CLICK_BY_NOTIFY_MESSAGE", "", "ACTION_TYPE_NORMAL", "NETWORK_TYPE_BAD_WITHOUT_DIALOG", "NETWORK_TYPE_BAD_WITH_DIALOG", "NETWORK_TYPE_CONNECTED", "NETWORK_TYPE_UNAVAILABLE", "OFFLINE_SCAN_SCENE_SCAN", "OFFLINE_SCAN_SCENE_SELECT_FROM_ALBUM", "TAG", "", "report", "", "result", "resultType", "scene", "networkType", "actionType", "plugin-scan_release"})
public final class o
{
  public static final o yCW;
  
  static
  {
    AppMethodBeat.i(52181);
    yCW = new o();
    AppMethodBeat.o(52181);
  }
  
  public static void d(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(189568);
    p.h(paramString2, "resultType");
    ae.i("MicroMsg.OfflineScanReporter", "alvinluo OfflineScan report resultType: %s, scene: %d, networkType: %d, actionType: %d, result: %s", new Object[] { paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString1 });
    g localg = g.yxI;
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localg.f(17386, new Object[] { paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), str });
    AppMethodBeat.o(189568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.o
 * JD-Core Version:    0.7.0.1
 */