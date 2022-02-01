package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager$updateScanConfig$1", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac$a
  implements ab.a
{
  ac$a(int paramInt) {}
  
  public final void a(dlb paramdlb)
  {
    AppMethodBeat.i(52200);
    if (paramdlb == null)
    {
      AppMethodBeat.o(52200);
      return;
    }
    Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo pdateScanConfig onSuccess type: %d, version: %s, config: %s, guide: %s", new Object[] { Integer.valueOf(paramdlb.type), paramdlb.version, paramdlb.aaQS, paramdlb.aaQT });
    ac localac = ac.OSi;
    ac.a(this.eKn, paramdlb);
    AppMethodBeat.o(52200);
  }
  
  public final void s(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(52201);
    Log.e("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig onFailed errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(52201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ac.a
 * JD-Core Version:    0.7.0.1
 */