package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/OfflineScanReporter;", "", "()V", "ACTION_TYPE_CLICK_BY_NOTIFY_MESSAGE", "", "ACTION_TYPE_NORMAL", "NETWORK_TYPE_BAD_WITHOUT_DIALOG", "NETWORK_TYPE_BAD_WITH_DIALOG", "NETWORK_TYPE_CONNECTED", "NETWORK_TYPE_UNAVAILABLE", "OFFLINE_SCAN_SCENE_SCAN", "OFFLINE_SCAN_SCENE_SELECT_FROM_ALBUM", "TAG", "", "ifScanTabMerge", "", "getIfScanTabMerge", "()Z", "setIfScanTabMerge", "(Z)V", "report", "", "result", "resultType", "scene", "networkType", "actionType", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
{
  public static final w ORS;
  private static boolean ORT;
  
  static
  {
    AppMethodBeat.i(52181);
    ORS = new w();
    AppMethodBeat.o(52181);
  }
  
  public static void BX(boolean paramBoolean)
  {
    ORT = paramBoolean;
  }
  
  public static void b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    AppMethodBeat.i(314424);
    s.u(paramString2, "resultType");
    Log.i("MicroMsg.OfflineScanReporter", "alvinluo OfflineScan report resultType: %s, scene: %d, networkType: %d, actionType: %d, result: %s", new Object[] { paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString1 });
    h localh = h.OAn;
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    if (ORT) {}
    for (;;)
    {
      localh.b(17386, new Object[] { paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), str, Integer.valueOf(i) });
      AppMethodBeat.o(314424);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.w
 * JD-Core Version:    0.7.0.1
 */