package com.tencent.mm.plugin.nfc_open;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(26680);
    Object localObject = MultiProcessSharedPreferences.getSharedPreferences(ak.getContext(), "system_config_prefs", 4);
    int k;
    int i;
    if (bu.aO(((SharedPreferences)localObject).getLong("NFC_REPORT_TIME", 0L)) > 86400000L)
    {
      k = com.tencent.mm.plugin.nfc.b.a.a.dxO().gb(ak.getContext());
      if (k != 0) {
        break label171;
      }
      i = 0;
      if (!d.bmx()) {
        break label176;
      }
    }
    label171:
    label176:
    for (int j = 1;; j = 0)
    {
      ae.i("MicroMsg.SubCoreCpuCard", "alvinluo NFC report isSupportNFC: %d, isSupportHCE: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      g.yxI.f(12779, new Object[] { q.cH(true), Integer.valueOf(i), Integer.valueOf(j) });
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("NFC_REPORT_TIME", bu.HQ());
      ((SharedPreferences.Editor)localObject).commit();
      ae.i("MicroMsg.SubCoreCpuCard", "doNFCReport status = ".concat(String.valueOf(k)));
      AppMethodBeat.o(26680);
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a.1
 * JD-Core Version:    0.7.0.1
 */