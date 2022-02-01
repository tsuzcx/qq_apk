package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bxo;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager$updateScanConfig$1", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"})
public final class v$c
  implements u.a
{
  v$c(int paramInt) {}
  
  public final void a(bxo parambxo)
  {
    AppMethodBeat.i(52200);
    if (parambxo == null)
    {
      AppMethodBeat.o(52200);
      return;
    }
    ae.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig onSuccess type: %d, version: %s, config: %s", new Object[] { Integer.valueOf(parambxo.type), parambxo.version, parambxo.Hkn });
    v localv = v.yDr;
    v.a(this.cAn, parambxo);
    AppMethodBeat.o(52200);
  }
  
  public final void p(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(52201);
    ae.e("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig onFailed errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(52201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.v.c
 * JD-Core Version:    0.7.0.1
 */