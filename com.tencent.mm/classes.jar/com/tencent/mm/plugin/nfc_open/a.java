package com.tencent.mm.plugin.nfc_open;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements bd
{
  private com.tencent.mm.plugin.nfc_open.b.a AEl;
  
  private static a exy()
  {
    AppMethodBeat.i(26681);
    bg.aVz();
    a locala2 = (a)cg.KG("plugin.nfc_open");
    a locala1 = locala2;
    if (locala2 == null)
    {
      Log.w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
      locala1 = new a();
      bg.aVz().a("plugin.nfc_open", locala1);
    }
    AppMethodBeat.o(26681);
    return locala1;
  }
  
  private static void st(boolean paramBoolean)
  {
    AppMethodBeat.i(26683);
    if (paramBoolean)
    {
      MMApplicationContext.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
      AppMethodBeat.o(26683);
      return;
    }
    MMApplicationContext.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
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
    Log.i("MicroMsg.SubCoreCpuCard", "alvinluo process: %s", new Object[] { Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid()) });
    g.aAf().azk();
    if (exy().AEl == null) {
      exy().AEl = new com.tencent.mm.plugin.nfc_open.b.a();
    }
    com.tencent.mm.plugin.nfc_open.b.a locala = exy().AEl;
    if (locala.dZt())
    {
      Log.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
      bg.azz().a(1561, locala);
      bg.azz().a(new b(locala.AEn.version), 0);
    }
    bg.aVF();
    int i = ((Integer)c.azQ().get(ar.a.NUQ, Integer.valueOf(0))).intValue();
    if (i == 0)
    {
      bg.aVF();
      if (((Integer)c.azQ().get(ar.a.NUR, Integer.valueOf(0))).intValue() == 1) {
        st(true);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
      ThreadPool.post(new a.1(this), getClass().getName());
      AppMethodBeat.o(26682);
      return;
      st(false);
      continue;
      if (i == 1) {
        st(true);
      } else {
        st(false);
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