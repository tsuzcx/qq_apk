package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/OfflineScanReporter;", "", "()V", "ACTION_TYPE_CLICK_BY_NOTIFY_MESSAGE", "", "ACTION_TYPE_NORMAL", "NETWORK_TYPE_BAD_WITHOUT_DIALOG", "NETWORK_TYPE_BAD_WITH_DIALOG", "NETWORK_TYPE_CONNECTED", "NETWORK_TYPE_UNAVAILABLE", "OFFLINE_SCAN_SCENE_SCAN", "OFFLINE_SCAN_SCENE_SELECT_FROM_ALBUM", "TAG", "", "report", "", "resultType", "scene", "networkType", "actionType", "plugin-scan_release"})
public final class l
{
  public static final l wZe;
  
  static
  {
    AppMethodBeat.i(52181);
    wZe = new l();
    AppMethodBeat.o(52181);
  }
  
  public static void n(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(52180);
    k.h(paramString, "resultType");
    ac.i("MicroMsg.OfflineScanReporter", "alvinluo OfflineScan report resultType: %s, scene: %d, networkType: %d, actionType: %d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    h.wUl.f(17386, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(52180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.l
 * JD-Core Version:    0.7.0.1
 */