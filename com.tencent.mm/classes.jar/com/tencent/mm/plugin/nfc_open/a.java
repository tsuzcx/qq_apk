package com.tencent.mm.plugin.nfc_open;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements aw
{
  private com.tencent.mm.plugin.nfc_open.b.a ueZ;
  
  private static a cWG()
  {
    AppMethodBeat.i(26681);
    az.arP();
    a locala2 = (a)bz.ut("plugin.nfc_open");
    a locala1 = locala2;
    if (locala2 == null)
    {
      ad.w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
      locala1 = new a();
      az.arP().a("plugin.nfc_open", locala1);
    }
    AppMethodBeat.o(26681);
    return locala1;
  }
  
  private static void nN(boolean paramBoolean)
  {
    AppMethodBeat.i(26683);
    if (paramBoolean)
    {
      aj.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(aj.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
      AppMethodBeat.o(26683);
      return;
    }
    aj.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(aj.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
    AppMethodBeat.o(26683);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(26682);
    ad.i("MicroMsg.SubCoreCpuCard", "alvinluo process: %s", new Object[] { bt.getProcessNameByPid(aj.getContext(), Process.myPid()) });
    g.afz().aeD();
    if (cWG().ueZ == null) {
      cWG().ueZ = new com.tencent.mm.plugin.nfc_open.b.a();
    }
    com.tencent.mm.plugin.nfc_open.b.a locala = cWG().ueZ;
    if (locala.cGn())
    {
      ad.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
      az.aeS().a(1561, locala);
      az.aeS().a(new com.tencent.mm.plugin.nfc_open.a.b(locala.ufb.version), 0);
    }
    az.arV();
    int i = ((Integer)c.afk().get(ae.a.Fik, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      az.arV();
      if (((Integer)c.afk().get(ae.a.Fil, Integer.valueOf(0))).intValue() == 1) {
        nN(true);
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(26680);
          Object localObject = MultiProcessSharedPreferences.getSharedPreferences(aj.getContext(), "system_config_prefs", 4);
          int k;
          int i;
          if (bt.aS(((SharedPreferences)localObject).getLong("NFC_REPORT_TIME", 0L)) > 86400000L)
          {
            k = com.tencent.mm.plugin.nfc.b.a.a.cWE().fE(aj.getContext());
            if (k != 0) {
              break label171;
            }
            i = 0;
            if (!d.bbm()) {
              break label176;
            }
          }
          label171:
          label176:
          for (int j = 1;; j = 0)
          {
            ad.i("MicroMsg.SubCoreCpuCard", "alvinluo NFC report isSupportNFC: %d, isSupportHCE: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            h.vKh.f(12779, new Object[] { com.tencent.mm.compatible.deviceinfo.q.cG(true), Integer.valueOf(i), Integer.valueOf(j) });
            localObject = ((SharedPreferences)localObject).edit();
            ((SharedPreferences.Editor)localObject).putLong("NFC_REPORT_TIME", bt.GC());
            ((SharedPreferences.Editor)localObject).commit();
            ad.i("MicroMsg.SubCoreCpuCard", "doNFCReport status = ".concat(String.valueOf(k)));
            AppMethodBeat.o(26680);
            return;
            i = 1;
            break;
          }
        }
      }, getClass().getName());
      AppMethodBeat.o(26682);
      return;
      nN(false);
      continue;
      if (i == 1) {
        nN(true);
      } else {
        nN(false);
      }
    }
  }
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a
 * JD-Core Version:    0.7.0.1
 */