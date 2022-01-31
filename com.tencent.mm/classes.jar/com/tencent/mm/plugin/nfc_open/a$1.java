package com.tencent.mm.plugin.nfc_open;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(23053);
    Object localObject = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "system_config_prefs", 4);
    int k;
    int i;
    if (bo.av(((SharedPreferences)localObject).getLong("NFC_REPORT_TIME", 0L)) > 86400000L)
    {
      k = com.tencent.mm.plugin.nfc.b.a.a.bWY().eJ(ah.getContext());
      if (k != 0) {
        break label171;
      }
      i = 0;
      if (!d.aEk()) {
        break label176;
      }
    }
    label171:
    label176:
    for (int j = 1;; j = 0)
    {
      ab.i("MicroMsg.SubCoreCpuCard", "alvinluo NFC report isSupportNFC: %d, isSupportHCE: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      h.qsU.e(12779, new Object[] { q.bP(true), Integer.valueOf(i), Integer.valueOf(j) });
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("NFC_REPORT_TIME", bo.yB());
      ((SharedPreferences.Editor)localObject).commit();
      ab.i("MicroMsg.SubCoreCpuCard", "doNFCReport status = ".concat(String.valueOf(k)));
      AppMethodBeat.o(23053);
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a.1
 * JD-Core Version:    0.7.0.1
 */