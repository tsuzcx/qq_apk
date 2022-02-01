package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.cct;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.protocal.protobuf.zs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public final class a
  implements f
{
  public cct wts;
  
  public a()
  {
    AppMethodBeat.i(26689);
    init();
    AppMethodBeat.o(26689);
  }
  
  private void a(cct paramcct)
  {
    AppMethodBeat.i(26691);
    if (!ba.ajx())
    {
      ad.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
      AppMethodBeat.o(26691);
      return;
    }
    if (paramcct != null)
    {
      ad.i("MicroMsg.CpuCardConfigManager", "setConfig config");
      this.wts = paramcct;
      try
      {
        paramcct = new String(this.wts.toByteArray(), "ISO-8859-1");
        ba.aBQ();
        c.ajl().set(al.a.Ism, paramcct);
        AppMethodBeat.o(26691);
        return;
      }
      catch (UnsupportedEncodingException paramcct)
      {
        ad.w("MicroMsg.CpuCardConfigManager", "save config exp, " + paramcct.getLocalizedMessage());
        AppMethodBeat.o(26691);
        return;
      }
      catch (IOException paramcct)
      {
        ad.w("MicroMsg.CpuCardConfigManager", "save config exp, " + paramcct.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(26691);
  }
  
  private cct duB()
  {
    AppMethodBeat.i(26692);
    if (this.wts == null) {
      init();
    }
    cct localcct = this.wts;
    AppMethodBeat.o(26692);
    return localcct;
  }
  
  private void init()
  {
    AppMethodBeat.i(26690);
    this.wts = new cct();
    ba.aBQ();
    String str = String.valueOf(c.ajl().get(al.a.Ism, null));
    if (bt.isNullOrNil(str))
    {
      this.wts.Gbj = new LinkedList();
      this.wts.lastUpdateTime = 0L;
      this.wts.Gbk = 86400;
      this.wts.version = 0;
      AppMethodBeat.o(26690);
      return;
    }
    try
    {
      this.wts.parseFrom(str.getBytes("ISO-8859-1"));
      ad.i("MicroMsg.CpuCardConfigManager", "alvinluo nfcConfig version: %d", new Object[] { Integer.valueOf(this.wts.version) });
      AppMethodBeat.o(26690);
      return;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
      this.wts.Gbj = new LinkedList();
      this.wts.lastUpdateTime = 0L;
      this.wts.Gbk = 86400;
      this.wts.version = 0;
      AppMethodBeat.o(26690);
    }
  }
  
  public final boolean dcH()
  {
    int i = 1800;
    AppMethodBeat.i(26693);
    try
    {
      if (NfcAdapter.getDefaultAdapter(aj.getContext()) == null)
      {
        ad.i("MicroMsg.CpuCardConfigManager", "Nfc not support no need update");
        AppMethodBeat.o(26693);
        return false;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.CpuCardConfigManager", localException, "", new Object[0]);
      AppMethodBeat.o(26693);
      return false;
    }
    int j;
    if (this.wts != null)
    {
      j = this.wts.Gbk;
      if (j >= 1800) {}
    }
    for (;;)
    {
      ad.i("MicroMsg.CpuCardConfigManager", "now=" + bt.aQJ() + ", lastUpdateTime=" + this.wts.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + this.wts.Gbk);
      if (bt.aQJ() - this.wts.lastUpdateTime > i)
      {
        AppMethodBeat.o(26693);
        return true;
        if (j > 604800) {
          i = 604800;
        }
      }
      else
      {
        AppMethodBeat.o(26693);
        return false;
      }
      i = j;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(26694);
    ba.aiU().b(1561, this);
    if ((paramn instanceof com.tencent.mm.plugin.nfc_open.a.b))
    {
      paramString = duB();
      paramString.lastUpdateTime = bt.aQJ();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (abn)((com.tencent.mm.plugin.nfc_open.a.b)paramn).rr.hNL.hNQ;
        if (paramn != null)
        {
          paramString.Gbk = paramn.Gbk;
          paramString.Gbl = paramn.Gbl;
          ba.aBQ();
          if (((Integer)c.ajl().get(al.a.Isr, Integer.valueOf(0))).intValue() == 0)
          {
            if (paramn.Gbl != 1) {
              break label234;
            }
            aj.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(aj.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
          }
          for (;;)
          {
            ba.aBQ();
            c.ajl().set(al.a.Iss, Integer.valueOf(paramn.Gbl));
            ba.aBQ();
            c.ajl().set(al.a.Isv, paramn.CPy);
            if (paramString.version != paramn.version) {
              break;
            }
            ad.i("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd no config change return version = " + paramn.version);
            a(paramString);
            AppMethodBeat.o(26694);
            return;
            label234:
            aj.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(aj.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
          }
          paramString.version = paramn.version;
          ad.i("MicroMsg.CpuCardConfigManager", "alvinluo nfc-onSceneEnd config new version: %d", new Object[] { Integer.valueOf(paramn.version) });
          if ((paramn.Gbj != null) && (!paramn.Gbj.isEmpty())) {
            if (paramString.Gbj == null)
            {
              paramString.Gbj = new LinkedList();
              paramInt1 = 0;
            }
          }
          for (;;)
          {
            if (paramInt1 < paramn.Gbj.size())
            {
              sq localsq = new sq();
              localsq.FpV = ((sq)paramn.Gbj.get(paramInt1)).FpV;
              localsq.FPg = ((sq)paramn.Gbj.get(paramInt1)).FPg;
              ad.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + bt.n(Integer.valueOf(localsq.FPg)) + ", url=" + bt.nullAsNil(localsq.FpV));
              if (localsq.FPf == null)
              {
                localsq.FPf = new LinkedList();
                label462:
                paramInt2 = 0;
              }
              for (;;)
              {
                if (paramInt2 >= ((sq)paramn.Gbj.get(paramInt1)).FPf.size()) {
                  break label758;
                }
                abo localabo = new abo();
                if (localabo.Gbm == null) {
                  localabo.Gbm = new LinkedList();
                }
                for (;;)
                {
                  int i = 0;
                  while (i < ((abo)((sq)paramn.Gbj.get(paramInt1)).FPf.get(paramInt2)).Gbm.size())
                  {
                    zs localzs = new zs();
                    localzs.FYR = ((zs)((abo)((sq)paramn.Gbj.get(paramInt1)).FPf.get(paramInt2)).Gbm.get(i)).FYR;
                    localzs.vpC = ((zs)((abo)((sq)paramn.Gbj.get(paramInt1)).FPf.get(paramInt2)).Gbm.get(i)).vpC;
                    ad.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + bt.nullAsNil(localzs.FYR) + ", answer=" + bt.nullAsNil(localzs.vpC));
                    localabo.Gbm.add(localzs);
                    i += 1;
                  }
                  paramString.Gbj.clear();
                  break;
                  localsq.FPf.clear();
                  break label462;
                  localabo.Gbm.clear();
                }
                localsq.FPf.add(localabo);
                paramInt2 += 1;
              }
              label758:
              paramString.Gbj.add(localsq);
              paramInt1 += 1;
              continue;
              paramString.Gbj.clear();
            }
          }
        }
      }
      a(paramString);
    }
    AppMethodBeat.o(26694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.b.a
 * JD-Core Version:    0.7.0.1
 */