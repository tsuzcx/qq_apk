package com.tencent.mm.plugin.nfc_open;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ca;
import com.tencent.mm.protocal.protobuf.cct;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements ax
{
  private com.tencent.mm.plugin.nfc_open.b.a wtq;
  
  private static a duA()
  {
    AppMethodBeat.i(26681);
    ba.aBK();
    a locala2 = (a)ca.By("plugin.nfc_open");
    a locala1 = locala2;
    if (locala2 == null)
    {
      ad.w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
      locala1 = new a();
      ba.aBK().a("plugin.nfc_open", locala1);
    }
    AppMethodBeat.o(26681);
    return locala1;
  }
  
  private static void pg(boolean paramBoolean)
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
    g.ajA().aiF();
    if (duA().wtq == null) {
      duA().wtq = new com.tencent.mm.plugin.nfc_open.b.a();
    }
    com.tencent.mm.plugin.nfc_open.b.a locala = duA().wtq;
    if (locala.dcH())
    {
      ad.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
      ba.aiU().a(1561, locala);
      ba.aiU().a(new com.tencent.mm.plugin.nfc_open.a.b(locala.wts.version), 0);
    }
    ba.aBQ();
    int i = ((Integer)c.ajl().get(al.a.Isr, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      ba.aBQ();
      if (((Integer)c.ajl().get(al.a.Iss, Integer.valueOf(0))).intValue() == 1) {
        pg(true);
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
      com.tencent.mm.sdk.g.b.c(new a.1(this), getClass().getName());
      AppMethodBeat.o(26682);
      return;
      pg(false);
      continue;
      if (i == 1) {
        pg(true);
      } else {
        pg(false);
      }
    }
  }
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a
 * JD-Core Version:    0.7.0.1
 */