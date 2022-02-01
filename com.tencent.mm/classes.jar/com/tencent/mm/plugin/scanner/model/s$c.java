package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsh;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager$updateScanConfig$1", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"})
public final class s$c
  implements r.a
{
  public final void a(bsh parambsh)
  {
    AppMethodBeat.i(52200);
    if (parambsh == null)
    {
      AppMethodBeat.o(52200);
      return;
    }
    ac.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig onSuccess type: %d, version: %s, config: %s", new Object[] { Integer.valueOf(parambsh.type), parambsh.version, parambsh.Fhk });
    parambsh = parambsh.Fhk;
    k.g(parambsh, "resp.conf_str");
    s.setConfig(parambsh);
    AppMethodBeat.o(52200);
  }
  
  public final void p(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(52201);
    ac.e("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig onFailed errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(52201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.s.c
 * JD-Core Version:    0.7.0.1
 */