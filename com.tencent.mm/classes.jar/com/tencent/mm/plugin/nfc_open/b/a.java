package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.ss;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public final class a
  implements f
{
  public cdn wJc;
  
  public a()
  {
    AppMethodBeat.i(26689);
    init();
    AppMethodBeat.o(26689);
  }
  
  private void a(cdn paramcdn)
  {
    AppMethodBeat.i(26691);
    if (!bc.ajM())
    {
      ae.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
      AppMethodBeat.o(26691);
      return;
    }
    if (paramcdn != null)
    {
      ae.i("MicroMsg.CpuCardConfigManager", "setConfig config");
      this.wJc = paramcdn;
      try
      {
        paramcdn = new String(this.wJc.toByteArray(), "ISO-8859-1");
        bc.aCg();
        c.ajA().set(am.a.IMI, paramcdn);
        AppMethodBeat.o(26691);
        return;
      }
      catch (UnsupportedEncodingException paramcdn)
      {
        ae.w("MicroMsg.CpuCardConfigManager", "save config exp, " + paramcdn.getLocalizedMessage());
        AppMethodBeat.o(26691);
        return;
      }
      catch (IOException paramcdn)
      {
        ae.w("MicroMsg.CpuCardConfigManager", "save config exp, " + paramcdn.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(26691);
  }
  
  private cdn dxR()
  {
    AppMethodBeat.i(26692);
    if (this.wJc == null) {
      init();
    }
    cdn localcdn = this.wJc;
    AppMethodBeat.o(26692);
    return localcdn;
  }
  
  private void init()
  {
    AppMethodBeat.i(26690);
    this.wJc = new cdn();
    bc.aCg();
    String str = String.valueOf(c.ajA().get(am.a.IMI, null));
    if (bu.isNullOrNil(str))
    {
      this.wJc.GtQ = new LinkedList();
      this.wJc.lastUpdateTime = 0L;
      this.wJc.GtR = 86400;
      this.wJc.version = 0;
      AppMethodBeat.o(26690);
      return;
    }
    try
    {
      this.wJc.parseFrom(str.getBytes("ISO-8859-1"));
      ae.i("MicroMsg.CpuCardConfigManager", "alvinluo nfcConfig version: %d", new Object[] { Integer.valueOf(this.wJc.version) });
      AppMethodBeat.o(26690);
      return;
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
      this.wJc.GtQ = new LinkedList();
      this.wJc.lastUpdateTime = 0L;
      this.wJc.GtR = 86400;
      this.wJc.version = 0;
      AppMethodBeat.o(26690);
    }
  }
  
  public final boolean dfz()
  {
    int i = 1800;
    AppMethodBeat.i(26693);
    try
    {
      if (NfcAdapter.getDefaultAdapter(ak.getContext()) == null)
      {
        ae.i("MicroMsg.CpuCardConfigManager", "Nfc not support no need update");
        AppMethodBeat.o(26693);
        return false;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.CpuCardConfigManager", localException, "", new Object[0]);
      AppMethodBeat.o(26693);
      return false;
    }
    int j;
    if (this.wJc != null)
    {
      j = this.wJc.GtR;
      if (j >= 1800) {}
    }
    for (;;)
    {
      ae.i("MicroMsg.CpuCardConfigManager", "now=" + bu.aRi() + ", lastUpdateTime=" + this.wJc.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + this.wJc.GtR);
      if (bu.aRi() - this.wJc.lastUpdateTime > i)
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
    bc.ajj().b(1561, this);
    if ((paramn instanceof com.tencent.mm.plugin.nfc_open.a.b))
    {
      paramString = dxR();
      paramString.lastUpdateTime = bu.aRi();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (abw)((com.tencent.mm.plugin.nfc_open.a.b)paramn).rr.hQE.hQJ;
        if (paramn != null)
        {
          paramString.GtR = paramn.GtR;
          paramString.GtS = paramn.GtS;
          bc.aCg();
          if (((Integer)c.ajA().get(am.a.IMN, Integer.valueOf(0))).intValue() == 0)
          {
            if (paramn.GtS != 1) {
              break label234;
            }
            ak.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ak.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
          }
          for (;;)
          {
            bc.aCg();
            c.ajA().set(am.a.IMO, Integer.valueOf(paramn.GtS));
            bc.aCg();
            c.ajA().set(am.a.IMR, paramn.Dhc);
            if (paramString.version != paramn.version) {
              break;
            }
            ae.i("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd no config change return version = " + paramn.version);
            a(paramString);
            AppMethodBeat.o(26694);
            return;
            label234:
            ak.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ak.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
          }
          paramString.version = paramn.version;
          ae.i("MicroMsg.CpuCardConfigManager", "alvinluo nfc-onSceneEnd config new version: %d", new Object[] { Integer.valueOf(paramn.version) });
          if ((paramn.GtQ != null) && (!paramn.GtQ.isEmpty())) {
            if (paramString.GtQ == null)
            {
              paramString.GtQ = new LinkedList();
              paramInt1 = 0;
            }
          }
          for (;;)
          {
            if (paramInt1 < paramn.GtQ.size())
            {
              ss localss = new ss();
              localss.FIt = ((ss)paramn.GtQ.get(paramInt1)).FIt;
              localss.GhF = ((ss)paramn.GtQ.get(paramInt1)).GhF;
              ae.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + bu.o(Integer.valueOf(localss.GhF)) + ", url=" + bu.nullAsNil(localss.FIt));
              if (localss.GhE == null)
              {
                localss.GhE = new LinkedList();
                label462:
                paramInt2 = 0;
              }
              for (;;)
              {
                if (paramInt2 >= ((ss)paramn.GtQ.get(paramInt1)).GhE.size()) {
                  break label758;
                }
                abx localabx = new abx();
                if (localabx.GtT == null) {
                  localabx.GtT = new LinkedList();
                }
                for (;;)
                {
                  int i = 0;
                  while (i < ((abx)((ss)paramn.GtQ.get(paramInt1)).GhE.get(paramInt2)).GtT.size())
                  {
                    zv localzv = new zv();
                    localzv.Grr = ((zv)((abx)((ss)paramn.GtQ.get(paramInt1)).GhE.get(paramInt2)).GtT.get(i)).Grr;
                    localzv.vBH = ((zv)((abx)((ss)paramn.GtQ.get(paramInt1)).GhE.get(paramInt2)).GtT.get(i)).vBH;
                    ae.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + bu.nullAsNil(localzv.Grr) + ", answer=" + bu.nullAsNil(localzv.vBH));
                    localabx.GtT.add(localzv);
                    i += 1;
                  }
                  paramString.GtQ.clear();
                  break;
                  localss.GhE.clear();
                  break label462;
                  localabx.GtT.clear();
                }
                localss.GhE.add(localabx);
                paramInt2 += 1;
              }
              label758:
              paramString.GtQ.add(localss);
              paramInt1 += 1;
              continue;
              paramString.GtQ.clear();
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