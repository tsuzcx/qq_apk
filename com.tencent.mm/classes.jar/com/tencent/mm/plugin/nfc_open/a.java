package com.tencent.mm.plugin.nfc_open;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.mm.ah.p;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.protocal.c.azh;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashMap;

public final class a
  implements ar
{
  private com.tencent.mm.plugin.nfc_open.b.a mGq;
  
  private static a boA()
  {
    au.Hq();
    a locala2 = (a)bu.iR("plugin.nfc_open");
    a locala1 = locala2;
    if (locala2 == null)
    {
      y.w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
      locala1 = new a();
      au.Hq().a("plugin.nfc_open", locala1);
    }
    return locala1;
  }
  
  private static void hW(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ae.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ae.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
      return;
    }
    ae.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ae.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
  }
  
  public final void bh(boolean paramBoolean)
  {
    y.i("MicroMsg.SubCoreCpuCard", "alvinluo process: %s", new Object[] { bk.am(ae.getContext(), Process.myPid()) });
    g.DN().CX();
    if (boA().mGq == null) {
      boA().mGq = new com.tencent.mm.plugin.nfc_open.b.a();
    }
    com.tencent.mm.plugin.nfc_open.b.a locala = boA().mGq;
    if (locala.bbn())
    {
      y.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
      au.Dk().a(1561, locala);
      au.Dk().a(new b(locala.mGs.version), 0);
    }
    au.Hx();
    int i = ((Integer)c.Dz().get(ac.a.upP, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      au.Hx();
      if (((Integer)c.Dz().get(ac.a.upQ, Integer.valueOf(0))).intValue() == 1) {
        hW(true);
      }
    }
    for (;;)
    {
      y.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
      e.post(new a.1(this), getClass().getName());
      return;
      hW(false);
      continue;
      if (i == 1) {
        hW(true);
      } else {
        hW(false);
      }
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease() {}
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.a
 * JD-Core Version:    0.7.0.1
 */