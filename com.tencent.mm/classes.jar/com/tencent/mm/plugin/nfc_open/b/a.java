package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.protobuf.byc;
import com.tencent.mm.protocal.protobuf.qx;
import com.tencent.mm.protocal.protobuf.xt;
import com.tencent.mm.protocal.protobuf.zn;
import com.tencent.mm.protocal.protobuf.zo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public final class a
  implements g
{
  public byc voa;
  
  public a()
  {
    AppMethodBeat.i(26689);
    init();
    AppMethodBeat.o(26689);
  }
  
  private void a(byc parambyc)
  {
    AppMethodBeat.i(26691);
    if (!az.agM())
    {
      ac.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
      AppMethodBeat.o(26691);
      return;
    }
    if (parambyc != null)
    {
      ac.i("MicroMsg.CpuCardConfigManager", "setConfig config");
      this.voa = parambyc;
      try
      {
        parambyc = new String(this.voa.toByteArray(), "ISO-8859-1");
        az.ayM();
        c.agA().set(ah.a.GFU, parambyc);
        AppMethodBeat.o(26691);
        return;
      }
      catch (UnsupportedEncodingException parambyc)
      {
        ac.w("MicroMsg.CpuCardConfigManager", "save config exp, " + parambyc.getLocalizedMessage());
        AppMethodBeat.o(26691);
        return;
      }
      catch (IOException parambyc)
      {
        ac.w("MicroMsg.CpuCardConfigManager", "save config exp, " + parambyc.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(26691);
  }
  
  private byc dkp()
  {
    AppMethodBeat.i(26692);
    if (this.voa == null) {
      init();
    }
    byc localbyc = this.voa;
    AppMethodBeat.o(26692);
    return localbyc;
  }
  
  private void init()
  {
    AppMethodBeat.i(26690);
    this.voa = new byc();
    az.ayM();
    String str = String.valueOf(c.agA().get(ah.a.GFU, null));
    if (bs.isNullOrNil(str))
    {
      this.voa.EtR = new LinkedList();
      this.voa.lastUpdateTime = 0L;
      this.voa.EtS = 86400;
      this.voa.version = 0;
      AppMethodBeat.o(26690);
      return;
    }
    try
    {
      this.voa.parseFrom(str.getBytes("ISO-8859-1"));
      ac.i("MicroMsg.CpuCardConfigManager", "alvinluo nfcConfig version: %d", new Object[] { Integer.valueOf(this.voa.version) });
      AppMethodBeat.o(26690);
      return;
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
      this.voa.EtR = new LinkedList();
      this.voa.lastUpdateTime = 0L;
      this.voa.EtS = 86400;
      this.voa.version = 0;
      AppMethodBeat.o(26690);
    }
  }
  
  public final boolean cTx()
  {
    int i = 1800;
    AppMethodBeat.i(26693);
    try
    {
      if (NfcAdapter.getDefaultAdapter(ai.getContext()) == null)
      {
        ac.i("MicroMsg.CpuCardConfigManager", "Nfc not support no need update");
        AppMethodBeat.o(26693);
        return false;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.CpuCardConfigManager", localException, "", new Object[0]);
      AppMethodBeat.o(26693);
      return false;
    }
    int j;
    if (this.voa != null)
    {
      j = this.voa.EtS;
      if (j >= 1800) {}
    }
    for (;;)
    {
      ac.i("MicroMsg.CpuCardConfigManager", "now=" + bs.aNx() + ", lastUpdateTime=" + this.voa.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + this.voa.EtS);
      if (bs.aNx() - this.voa.lastUpdateTime > i)
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
    az.agi().b(1561, this);
    if ((paramn instanceof com.tencent.mm.plugin.nfc_open.a.b))
    {
      paramString = dkp();
      paramString.lastUpdateTime = bs.aNx();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (zn)((com.tencent.mm.plugin.nfc_open.a.b)paramn).rr.hvs.hvw;
        if (paramn != null)
        {
          paramString.EtS = paramn.EtS;
          paramString.EtT = paramn.EtT;
          az.ayM();
          if (((Integer)c.agA().get(ah.a.GFZ, Integer.valueOf(0))).intValue() == 0)
          {
            if (paramn.EtT != 1) {
              break label234;
            }
            ai.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ai.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
          }
          for (;;)
          {
            az.ayM();
            c.agA().set(ah.a.GGa, Integer.valueOf(paramn.EtT));
            az.ayM();
            c.agA().set(ah.a.GGd, paramn.Bpi);
            if (paramString.version != paramn.version) {
              break;
            }
            ac.i("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd no config change return version = " + paramn.version);
            a(paramString);
            AppMethodBeat.o(26694);
            return;
            label234:
            ai.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ai.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
          }
          paramString.version = paramn.version;
          ac.i("MicroMsg.CpuCardConfigManager", "alvinluo nfc-onSceneEnd config new version: %d", new Object[] { Integer.valueOf(paramn.version) });
          if ((paramn.EtR != null) && (!paramn.EtR.isEmpty())) {
            if (paramString.EtR == null)
            {
              paramString.EtR = new LinkedList();
              paramInt1 = 0;
            }
          }
          for (;;)
          {
            if (paramInt1 < paramn.EtR.size())
            {
              qx localqx = new qx();
              localqx.DKP = ((qx)paramn.EtR.get(paramInt1)).DKP;
              localqx.EhW = ((qx)paramn.EtR.get(paramInt1)).EhW;
              ac.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + bs.m(Integer.valueOf(localqx.EhW)) + ", url=" + bs.nullAsNil(localqx.DKP));
              if (localqx.EhV == null)
              {
                localqx.EhV = new LinkedList();
                label462:
                paramInt2 = 0;
              }
              for (;;)
              {
                if (paramInt2 >= ((qx)paramn.EtR.get(paramInt1)).EhV.size()) {
                  break label758;
                }
                zo localzo = new zo();
                if (localzo.EtU == null) {
                  localzo.EtU = new LinkedList();
                }
                for (;;)
                {
                  int i = 0;
                  while (i < ((zo)((qx)paramn.EtR.get(paramInt1)).EhV.get(paramInt2)).EtU.size())
                  {
                    xt localxt = new xt();
                    localxt.ErI = ((xt)((zo)((qx)paramn.EtR.get(paramInt1)).EhV.get(paramInt2)).EtU.get(i)).ErI;
                    localxt.umW = ((xt)((zo)((qx)paramn.EtR.get(paramInt1)).EhV.get(paramInt2)).EtU.get(i)).umW;
                    ac.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + bs.nullAsNil(localxt.ErI) + ", answer=" + bs.nullAsNil(localxt.umW));
                    localzo.EtU.add(localxt);
                    i += 1;
                  }
                  paramString.EtR.clear();
                  break;
                  localqx.EhV.clear();
                  break label462;
                  localzo.EtU.clear();
                }
                localqx.EhV.add(localzo);
                paramInt2 += 1;
              }
              label758:
              paramString.EtR.add(localqx);
              paramInt1 += 1;
              continue;
              paramString.EtR.clear();
            }
          }
        }
      }
      a(paramString);
    }
    AppMethodBeat.o(26694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.b.a
 * JD-Core Version:    0.7.0.1
 */