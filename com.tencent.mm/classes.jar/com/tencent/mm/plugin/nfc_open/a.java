package com.tencent.mm.plugin.nfc_open;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashMap;

public final class a
  implements at
{
  private com.tencent.mm.plugin.nfc_open.b.a pgw;
  
  private static a bXa()
  {
    AppMethodBeat.i(23054);
    aw.aat();
    a locala2 = (a)bw.pF("plugin.nfc_open");
    a locala1 = locala2;
    if (locala2 == null)
    {
      ab.w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
      locala1 = new a();
      aw.aat().a("plugin.nfc_open", locala1);
    }
    AppMethodBeat.o(23054);
    return locala1;
  }
  
  private static void jS(boolean paramBoolean)
  {
    AppMethodBeat.i(23056);
    if (paramBoolean)
    {
      ah.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
      AppMethodBeat.o(23056);
      return;
    }
    ah.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
    AppMethodBeat.o(23056);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(23055);
    ab.i("MicroMsg.SubCoreCpuCard", "alvinluo process: %s", new Object[] { bo.az(ah.getContext(), Process.myPid()) });
    g.RJ().QQ();
    if (bXa().pgw == null) {
      bXa().pgw = new com.tencent.mm.plugin.nfc_open.b.a();
    }
    com.tencent.mm.plugin.nfc_open.b.a locala = bXa().pgw;
    if (locala.bIs())
    {
      ab.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
      aw.Rc().a(1561, locala);
      aw.Rc().a(new b(locala.pgy.version), 0);
    }
    aw.aaz();
    int i = ((Integer)c.Ru().get(ac.a.yzP, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      aw.aaz();
      if (((Integer)c.Ru().get(ac.a.yzQ, Integer.valueOf(0))).intValue() == 1) {
        jS(true);
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
      d.post(new a.1(this), getClass().getName());
      AppMethodBeat.o(23055);
      return;
      jS(false);
      continue;
      if (i == 1) {
        jS(true);
      } else {
        jS(false);
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