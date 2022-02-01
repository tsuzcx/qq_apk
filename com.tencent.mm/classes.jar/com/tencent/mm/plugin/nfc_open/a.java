package com.tencent.mm.plugin.nfc_open;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements az
{
  private com.tencent.mm.plugin.nfc_open.b.a wJa;
  
  private static a dxQ()
  {
    AppMethodBeat.i(26681);
    bc.aCa();
    a locala2 = (a)cc.Ca("plugin.nfc_open");
    a locala1 = locala2;
    if (locala2 == null)
    {
      ae.w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
      locala1 = new a();
      bc.aCa().a("plugin.nfc_open", locala1);
    }
    AppMethodBeat.o(26681);
    return locala1;
  }
  
  private static void po(boolean paramBoolean)
  {
    AppMethodBeat.i(26683);
    if (paramBoolean)
    {
      ak.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ak.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
      AppMethodBeat.o(26683);
      return;
    }
    ak.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ak.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
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
    ae.i("MicroMsg.SubCoreCpuCard", "alvinluo process: %s", new Object[] { bu.getProcessNameByPid(ak.getContext(), Process.myPid()) });
    g.ajP().aiU();
    if (dxQ().wJa == null) {
      dxQ().wJa = new com.tencent.mm.plugin.nfc_open.b.a();
    }
    com.tencent.mm.plugin.nfc_open.b.a locala = dxQ().wJa;
    if (locala.dfz())
    {
      ae.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
      bc.ajj().a(1561, locala);
      bc.ajj().a(new com.tencent.mm.plugin.nfc_open.a.b(locala.wJc.version), 0);
    }
    bc.aCg();
    int i = ((Integer)c.ajA().get(am.a.IMN, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      bc.aCg();
      if (((Integer)c.ajA().get(am.a.IMO, Integer.valueOf(0))).intValue() == 1) {
        po(true);
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
      com.tencent.mm.sdk.g.b.c(new a.1(this), getClass().getName());
      AppMethodBeat.o(26682);
      return;
      po(false);
      continue;
      if (i == 1) {
        po(true);
      } else {
        po(false);
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