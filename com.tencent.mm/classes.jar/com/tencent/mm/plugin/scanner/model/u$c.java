package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager$updateScanConfig$1", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"})
public final class u$c
  implements t.a
{
  public final void a(bwu parambwu)
  {
    AppMethodBeat.i(52200);
    if (parambwu == null)
    {
      AppMethodBeat.o(52200);
      return;
    }
    ad.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig onSuccess type: %d, version: %s, config: %s", new Object[] { Integer.valueOf(parambwu.type), parambwu.version, parambwu.GQM });
    parambwu = parambwu.GQM;
    p.g(parambwu, "resp.conf_str");
    u.setConfig(parambwu);
    AppMethodBeat.o(52200);
  }
  
  public final void p(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(52201);
    ad.e("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig onFailed errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(52201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.u.c
 * JD-Core Version:    0.7.0.1
 */