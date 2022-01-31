package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.azh;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.c.qu;
import com.tencent.mm.protocal.c.rt;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public final class a
  implements f
{
  public azh mGs;
  
  public a()
  {
    init();
  }
  
  private void a(azh paramazh)
  {
    if (!au.DK()) {
      y.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
    }
    while (paramazh == null) {
      return;
    }
    y.i("MicroMsg.CpuCardConfigManager", "setConfig config");
    this.mGs = paramazh;
    try
    {
      paramazh = new String(this.mGs.toByteArray(), "ISO-8859-1");
      au.Hx();
      c.Dz().c(ac.a.upK, paramazh);
      return;
    }
    catch (UnsupportedEncodingException paramazh)
    {
      y.w("MicroMsg.CpuCardConfigManager", "save config exp, " + paramazh.getLocalizedMessage());
      return;
    }
    catch (IOException paramazh)
    {
      y.w("MicroMsg.CpuCardConfigManager", "save config exp, " + paramazh.getLocalizedMessage());
    }
  }
  
  private azh boB()
  {
    if (this.mGs == null) {
      init();
    }
    return this.mGs;
  }
  
  private void init()
  {
    this.mGs = new azh();
    au.Hx();
    String str = String.valueOf(c.Dz().get(ac.a.upK, null));
    if (bk.bl(str))
    {
      this.mGs.sPS = new LinkedList();
      this.mGs.lastUpdateTime = 0L;
      this.mGs.sPT = 86400;
      this.mGs.version = 0;
      return;
    }
    try
    {
      this.mGs.aH(str.getBytes("ISO-8859-1"));
      return;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
      this.mGs.sPS = new LinkedList();
      this.mGs.lastUpdateTime = 0L;
      this.mGs.sPT = 86400;
      this.mGs.version = 0;
    }
  }
  
  public final boolean bbn()
  {
    int i = 1800;
    try
    {
      if (NfcAdapter.getDefaultAdapter(ae.getContext()) == null)
      {
        y.i("MicroMsg.CpuCardConfigManager", "Nfc not support no need update");
        return false;
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.CpuCardConfigManager", localException, "", new Object[0]);
      return false;
    }
    int j;
    if (this.mGs != null)
    {
      j = this.mGs.sPT;
      if (j >= 1800) {}
    }
    for (;;)
    {
      y.i("MicroMsg.CpuCardConfigManager", "now=" + bk.UX() + ", lastUpdateTime=" + this.mGs.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + this.mGs.sPT);
      if (bk.UX() - this.mGs.lastUpdateTime > i)
      {
        return true;
        if (j > 604800) {
          i = 604800;
        }
      }
      else
      {
        return false;
      }
      i = j;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(1561, this);
    if ((paramm instanceof com.tencent.mm.plugin.nfc_open.a.b))
    {
      paramString = boB();
      paramString.lastUpdateTime = bk.UX();
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label745;
      }
      paramm = (rt)((com.tencent.mm.plugin.nfc_open.a.b)paramm).dmK.ecF.ecN;
      if (paramm == null) {
        break label745;
      }
      paramString.sPT = paramm.sPT;
      paramString.sPU = paramm.sPU;
      au.Hx();
      if (((Integer)c.Dz().get(ac.a.upP, Integer.valueOf(0))).intValue() == 0)
      {
        if (paramm.sPU != 1) {
          break label221;
        }
        ae.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ae.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
      }
    }
    for (;;)
    {
      au.Hx();
      c.Dz().c(ac.a.upQ, Integer.valueOf(paramm.sPU));
      au.Hx();
      c.Dz().c(ac.a.upT, paramm.qri);
      if (paramString.version != paramm.version) {
        break;
      }
      y.i("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd no config change return version = " + paramm.version);
      a(paramString);
      return;
      label221:
      ae.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ae.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
    }
    paramString.version = paramm.version;
    if ((paramm.sPS != null) && (!paramm.sPS.isEmpty())) {
      if (paramString.sPS == null)
      {
        paramString.sPS = new LinkedList();
        paramInt1 = 0;
      }
    }
    for (;;)
    {
      if (paramInt1 < paramm.sPS.size())
      {
        lu locallu = new lu();
        locallu.srC = ((lu)paramm.sPS.get(paramInt1)).srC;
        locallu.sHo = ((lu)paramm.sPS.get(paramInt1)).sHo;
        y.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + bk.g(Integer.valueOf(locallu.sHo)) + ", url=" + bk.pm(locallu.srC));
        if (locallu.sHn == null)
        {
          locallu.sHn = new LinkedList();
          label425:
          paramInt2 = 0;
        }
        for (;;)
        {
          if (paramInt2 >= ((lu)paramm.sPS.get(paramInt1)).sHn.size()) {
            break label721;
          }
          ru localru = new ru();
          if (localru.sPV == null) {
            localru.sPV = new LinkedList();
          }
          for (;;)
          {
            int i = 0;
            while (i < ((ru)((lu)paramm.sPS.get(paramInt1)).sHn.get(paramInt2)).sPV.size())
            {
              qu localqu = new qu();
              localqu.sOz = ((qu)((ru)((lu)paramm.sPS.get(paramInt1)).sHn.get(paramInt2)).sPV.get(i)).sOz;
              localqu.lQN = ((qu)((ru)((lu)paramm.sPS.get(paramInt1)).sHn.get(paramInt2)).sPV.get(i)).lQN;
              y.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + bk.pm(localqu.sOz) + ", answer=" + bk.pm(localqu.lQN));
              localru.sPV.add(localqu);
              i += 1;
            }
            paramString.sPS.clear();
            break;
            locallu.sHn.clear();
            break label425;
            localru.sPV.clear();
          }
          locallu.sHn.add(localru);
          paramInt2 += 1;
        }
        label721:
        paramString.sPS.add(locallu);
        paramInt1 += 1;
        continue;
        paramString.sPS.clear();
      }
    }
    label745:
    a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.b.a
 * JD-Core Version:    0.7.0.1
 */