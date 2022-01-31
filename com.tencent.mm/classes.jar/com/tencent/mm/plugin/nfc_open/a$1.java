package com.tencent.mm.plugin.nfc_open;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    Object localObject = MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "system_config_prefs", 4);
    int k;
    int i;
    if (bk.cp(((SharedPreferences)localObject).getLong("NFC_REPORT_TIME", 0L)) > 86400000L)
    {
      k = com.tencent.mm.plugin.nfc.b.a.a.boy().dV(ae.getContext());
      if (k != 0) {
        break label165;
      }
      i = 0;
      if (!d.ajL()) {
        break label170;
      }
    }
    label165:
    label170:
    for (int j = 1;; j = 0)
    {
      y.i("MicroMsg.SubCoreCpuCard", "alvinluo NFC report isSupportNFC: %d, isSupportHCE: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      h.nFQ.f(12779, new Object[] { q.zf(), Integer.valueOf(i), Integer.valueOf(j) });
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("NFC_REPORT_TIME", bk.UZ());
      ((SharedPreferences.Editor)localObject).commit();
      y.i("MicroMsg.SubCoreCpuCard", "doNFCReport status = " + k);
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