package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.protocal.protobuf.yt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public final class a
  implements g
{
  public btl ufb;
  
  public a()
  {
    AppMethodBeat.i(26689);
    init();
    AppMethodBeat.o(26689);
  }
  
  private void a(btl parambtl)
  {
    AppMethodBeat.i(26691);
    if (!az.afw())
    {
      ad.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
      AppMethodBeat.o(26691);
      return;
    }
    if (parambtl != null)
    {
      ad.i("MicroMsg.CpuCardConfigManager", "setConfig config");
      this.ufb = parambtl;
      try
      {
        parambtl = new String(this.ufb.toByteArray(), "ISO-8859-1");
        az.arV();
        c.afk().set(ae.a.Fif, parambtl);
        AppMethodBeat.o(26691);
        return;
      }
      catch (UnsupportedEncodingException parambtl)
      {
        ad.w("MicroMsg.CpuCardConfigManager", "save config exp, " + parambtl.getLocalizedMessage());
        AppMethodBeat.o(26691);
        return;
      }
      catch (IOException parambtl)
      {
        ad.w("MicroMsg.CpuCardConfigManager", "save config exp, " + parambtl.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(26691);
  }
  
  private btl cWH()
  {
    AppMethodBeat.i(26692);
    if (this.ufb == null) {
      init();
    }
    btl localbtl = this.ufb;
    AppMethodBeat.o(26692);
    return localbtl;
  }
  
  private void init()
  {
    AppMethodBeat.i(26690);
    this.ufb = new btl();
    az.arV();
    String str = String.valueOf(c.afk().get(ae.a.Fif, null));
    if (bt.isNullOrNil(str))
    {
      this.ufb.DaU = new LinkedList();
      this.ufb.lastUpdateTime = 0L;
      this.ufb.DaV = 86400;
      this.ufb.version = 0;
      AppMethodBeat.o(26690);
      return;
    }
    try
    {
      this.ufb.parseFrom(str.getBytes("ISO-8859-1"));
      ad.i("MicroMsg.CpuCardConfigManager", "alvinluo nfcConfig version: %d", new Object[] { Integer.valueOf(this.ufb.version) });
      AppMethodBeat.o(26690);
      return;
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
      this.ufb.DaU = new LinkedList();
      this.ufb.lastUpdateTime = 0L;
      this.ufb.DaV = 86400;
      this.ufb.version = 0;
      AppMethodBeat.o(26690);
    }
  }
  
  public final boolean cGn()
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
    if (this.ufb != null)
    {
      j = this.ufb.DaV;
      if (j >= 1800) {}
    }
    for (;;)
    {
      ad.i("MicroMsg.CpuCardConfigManager", "now=" + bt.aGK() + ", lastUpdateTime=" + this.ufb.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + this.ufb.DaV);
      if (bt.aGK() - this.ufb.lastUpdateTime > i)
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
    az.aeS().b(1561, this);
    if ((paramn instanceof com.tencent.mm.plugin.nfc_open.a.b))
    {
      paramString = cWH();
      paramString.lastUpdateTime = bt.aGK();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (ys)((com.tencent.mm.plugin.nfc_open.a.b)paramn).rr.gUT.gUX;
        if (paramn != null)
        {
          paramString.DaV = paramn.DaV;
          paramString.DaW = paramn.DaW;
          az.arV();
          if (((Integer)c.afk().get(ae.a.Fik, Integer.valueOf(0))).intValue() == 0)
          {
            if (paramn.DaW != 1) {
              break label234;
            }
            aj.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(aj.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
          }
          for (;;)
          {
            az.arV();
            c.afk().set(ae.a.Fil, Integer.valueOf(paramn.DaW));
            az.arV();
            c.afk().set(ae.a.Fio, paramn.zWO);
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
          if ((paramn.DaU != null) && (!paramn.DaU.isEmpty())) {
            if (paramString.DaU == null)
            {
              paramString.DaU = new LinkedList();
              paramInt1 = 0;
            }
          }
          for (;;)
          {
            if (paramInt1 < paramn.DaU.size())
            {
              qn localqn = new qn();
              localqn.Csy = ((qn)paramn.DaU.get(paramInt1)).Csy;
              localqn.CPl = ((qn)paramn.DaU.get(paramInt1)).CPl;
              ad.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + bt.l(Integer.valueOf(localqn.CPl)) + ", url=" + bt.nullAsNil(localqn.Csy));
              if (localqn.CPk == null)
              {
                localqn.CPk = new LinkedList();
                label462:
                paramInt2 = 0;
              }
              for (;;)
              {
                if (paramInt2 >= ((qn)paramn.DaU.get(paramInt1)).CPk.size()) {
                  break label758;
                }
                yt localyt = new yt();
                if (localyt.DaX == null) {
                  localyt.DaX = new LinkedList();
                }
                for (;;)
                {
                  int i = 0;
                  while (i < ((yt)((qn)paramn.DaU.get(paramInt1)).CPk.get(paramInt2)).DaX.size())
                  {
                    xb localxb = new xb();
                    localxb.CYV = ((xb)((yt)((qn)paramn.DaU.get(paramInt1)).CPk.get(paramInt2)).DaX.get(i)).CYV;
                    localxb.teH = ((xb)((yt)((qn)paramn.DaU.get(paramInt1)).CPk.get(paramInt2)).DaX.get(i)).teH;
                    ad.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + bt.nullAsNil(localxb.CYV) + ", answer=" + bt.nullAsNil(localxb.teH));
                    localyt.DaX.add(localxb);
                    i += 1;
                  }
                  paramString.DaU.clear();
                  break;
                  localqn.CPk.clear();
                  break label462;
                  localyt.DaX.clear();
                }
                localqn.CPk.add(localyt);
                paramInt2 += 1;
              }
              label758:
              paramString.DaU.add(localqn);
              paramInt1 += 1;
              continue;
              paramString.DaU.clear();
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