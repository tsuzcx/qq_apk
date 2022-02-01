package com.tencent.mm.plugin.nfc_open;

import android.content.ComponentName;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ci;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.protocal.protobuf.dul;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements be
{
  private com.tencent.mm.plugin.nfc_open.b.a Mtp;
  
  private static void Ad(boolean paramBoolean)
  {
    AppMethodBeat.i(26683);
    if (paramBoolean)
    {
      Util.setComponentEnabledSetting(MMApplicationContext.getContext(), new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
      AppMethodBeat.o(26683);
      return;
    }
    Util.setComponentEnabledSetting(MMApplicationContext.getContext(), new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
    AppMethodBeat.o(26683);
  }
  
  private static a gts()
  {
    AppMethodBeat.i(26681);
    bh.bCt();
    a locala2 = (a)ci.Ka("plugin.nfc_open");
    a locala1 = locala2;
    if (locala2 == null)
    {
      Log.w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
      locala1 = new a();
      bh.bCt().a("plugin.nfc_open", locala1);
    }
    AppMethodBeat.o(26681);
    return locala1;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(26682);
    Log.i("MicroMsg.SubCoreCpuCard", "alvinluo process: %s", new Object[] { Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid()) });
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gts().Mtp == null) {
      gts().Mtp = new com.tencent.mm.plugin.nfc_open.b.a();
    }
    com.tencent.mm.plugin.nfc_open.b.a locala = gts().Mtp;
    if (locala.fQj())
    {
      Log.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
      bh.aZW().a(1561, locala);
      bh.aZW().a(new com.tencent.mm.plugin.nfc_open.model.a(locala.Mtw.version), 0);
    }
    bh.bCz();
    int i = ((Integer)c.ban().get(at.a.acKj, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      bh.bCz();
      if (((Integer)c.ban().get(at.a.acKk, Integer.valueOf(0))).intValue() == 1) {
        Ad(true);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(26680);
          Object localObject = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "system_config_prefs", 4);
          int k;
          int i;
          if (Util.ticksToNow(((SharedPreferences)localObject).getLong("NFC_REPORT_TIME", 0L)) > 86400000L)
          {
            k = com.tencent.mm.plugin.nfc.b.a.a.gtq().jk(MMApplicationContext.getContext());
            if (k != 0) {
              break label171;
            }
            i = 0;
            if (!d.ctK()) {
              break label176;
            }
          }
          label171:
          label176:
          for (int j = 1;; j = 0)
          {
            Log.i("MicroMsg.SubCoreCpuCard", "alvinluo NFC report isSupportNFC: %d, isSupportHCE: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            com.tencent.mm.plugin.report.service.h.OAn.b(12779, new Object[] { q.eD(true), Integer.valueOf(i), Integer.valueOf(j) });
            localObject = ((SharedPreferences)localObject).edit();
            ((SharedPreferences.Editor)localObject).putLong("NFC_REPORT_TIME", Util.currentTicks());
            ((SharedPreferences.Editor)localObject).commit();
            Log.i("MicroMsg.SubCoreCpuCard", "doNFCReport status = ".concat(String.valueOf(k)));
            AppMethodBeat.o(26680);
            return;
            i = 1;
            break;
          }
        }
      }, getClass().getName());
      AppMethodBeat.o(26682);
      return;
      Ad(false);
      continue;
      if (i == 1) {
        Ad(true);
      } else {
        Ad(false);
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