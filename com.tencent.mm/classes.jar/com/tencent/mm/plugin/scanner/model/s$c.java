package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager$updateScanConfig$1", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigSyncManager$ScanConfigSyncCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"})
public final class s$c
  implements r.a
{
  public final void a(bnr parambnr)
  {
    AppMethodBeat.i(52200);
    if (parambnr == null)
    {
      AppMethodBeat.o(52200);
      return;
    }
    ad.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig onSuccess type: %d, version: %s, config: %s", new Object[] { Integer.valueOf(parambnr.type), parambnr.version, parambnr.DKV });
    parambnr = parambnr.DKV;
    k.g(parambnr, "resp.conf_str");
    s.setConfig(parambnr);
    AppMethodBeat.o(52200);
  }
  
  public final void p(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(52201);
    ad.e("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig onFailed errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(52201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.s.c
 * JD-Core Version:    0.7.0.1
 */