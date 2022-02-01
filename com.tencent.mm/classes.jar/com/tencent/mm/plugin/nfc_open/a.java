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
import com.tencent.mm.protocal.protobuf.byc;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements aw
{
  private com.tencent.mm.plugin.nfc_open.b.a vnY;
  
  private static a dko()
  {
    AppMethodBeat.i(26681);
    az.ayG();
    a locala2 = (a)bz.yz("plugin.nfc_open");
    a locala1 = locala2;
    if (locala2 == null)
    {
      ac.w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
      locala1 = new a();
      az.ayG().a("plugin.nfc_open", locala1);
    }
    AppMethodBeat.o(26681);
    return locala1;
  }
  
  private static void oH(boolean paramBoolean)
  {
    AppMethodBeat.i(26683);
    if (paramBoolean)
    {
      ai.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ai.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
      AppMethodBeat.o(26683);
      return;
    }
    ai.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ai.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
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
    ac.i("MicroMsg.SubCoreCpuCard", "alvinluo process: %s", new Object[] { bs.getProcessNameByPid(ai.getContext(), Process.myPid()) });
    g.agP().afT();
    if (dko().vnY == null) {
      dko().vnY = new com.tencent.mm.plugin.nfc_open.b.a();
    }
    com.tencent.mm.plugin.nfc_open.b.a locala = dko().vnY;
    if (locala.cTx())
    {
      ac.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
      az.agi().a(1561, locala);
      az.agi().a(new com.tencent.mm.plugin.nfc_open.a.b(locala.voa.version), 0);
    }
    az.ayM();
    int i = ((Integer)c.agA().get(ah.a.GFZ, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      az.ayM();
      if (((Integer)c.agA().get(ah.a.GGa, Integer.valueOf(0))).intValue() == 1) {
        oH(true);
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(26680);
          Object localObject = MultiProcessSharedPreferences.getSharedPreferences(ai.getContext(), "system_config_prefs", 4);
          int k;
          int i;
          if (bs.aO(((SharedPreferences)localObject).getLong("NFC_REPORT_TIME", 0L)) > 86400000L)
          {
            k = com.tencent.mm.plugin.nfc.b.a.a.dkm().fQ(ai.getContext());
            if (k != 0) {
              break label171;
            }
            i = 0;
            if (!d.bie()) {
              break label176;
            }
          }
          label171:
          label176:
          for (int j = 1;; j = 0)
          {
            ac.i("MicroMsg.SubCoreCpuCard", "alvinluo NFC report isSupportNFC: %d, isSupportHCE: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            h.wUl.f(12779, new Object[] { com.tencent.mm.compatible.deviceinfo.q.cF(true), Integer.valueOf(i), Integer.valueOf(j) });
            localObject = ((SharedPreferences)localObject).edit();
            ((SharedPreferences.Editor)localObject).putLong("NFC_REPORT_TIME", bs.Gn());
            ((SharedPreferences.Editor)localObject).commit();
            ac.i("MicroMsg.SubCoreCpuCard", "doNFCReport status = ".concat(String.valueOf(k)));
            AppMethodBeat.o(26680);
            return;
            i = 1;
            break;
          }
        }
      }, getClass().getName());
      AppMethodBeat.o(26682);
      return;
      oH(false);
      continue;
      if (i == 1) {
        oH(true);
      } else {
        oH(false);
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