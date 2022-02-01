package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.ady;
import com.tencent.mm.protocal.protobuf.adz;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.protocal.protobuf.tx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public final class a
  implements i
{
  public ctt AEn;
  
  public a()
  {
    AppMethodBeat.i(26689);
    init();
    AppMethodBeat.o(26689);
  }
  
  private void a(ctt paramctt)
  {
    AppMethodBeat.i(26691);
    if (!bg.aAc())
    {
      Log.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
      AppMethodBeat.o(26691);
      return;
    }
    if (paramctt != null)
    {
      Log.i("MicroMsg.CpuCardConfigManager", "setConfig config");
      this.AEn = paramctt;
      try
      {
        paramctt = new String(this.AEn.toByteArray(), "ISO-8859-1");
        bg.aVF();
        c.azQ().set(ar.a.NUK, paramctt);
        AppMethodBeat.o(26691);
        return;
      }
      catch (UnsupportedEncodingException paramctt)
      {
        Log.w("MicroMsg.CpuCardConfigManager", "save config exp, " + paramctt.getLocalizedMessage());
        AppMethodBeat.o(26691);
        return;
      }
      catch (IOException paramctt)
      {
        Log.w("MicroMsg.CpuCardConfigManager", "save config exp, " + paramctt.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(26691);
  }
  
  private ctt exz()
  {
    AppMethodBeat.i(26692);
    if (this.AEn == null) {
      init();
    }
    ctt localctt = this.AEn;
    AppMethodBeat.o(26692);
    return localctt;
  }
  
  private void init()
  {
    AppMethodBeat.i(26690);
    this.AEn = new ctt();
    bg.aVF();
    String str = String.valueOf(c.azQ().get(ar.a.NUK, null));
    if (Util.isNullOrNil(str))
    {
      this.AEn.Lps = new LinkedList();
      this.AEn.lastUpdateTime = 0L;
      this.AEn.Lpt = 86400;
      this.AEn.version = 0;
      AppMethodBeat.o(26690);
      return;
    }
    try
    {
      this.AEn.parseFrom(str.getBytes("ISO-8859-1"));
      Log.i("MicroMsg.CpuCardConfigManager", "alvinluo nfcConfig version: %d", new Object[] { Integer.valueOf(this.AEn.version) });
      AppMethodBeat.o(26690);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
      this.AEn.Lps = new LinkedList();
      this.AEn.lastUpdateTime = 0L;
      this.AEn.Lpt = 86400;
      this.AEn.version = 0;
      AppMethodBeat.o(26690);
    }
  }
  
  public final boolean dZt()
  {
    int i = 1800;
    AppMethodBeat.i(26693);
    try
    {
      if (NfcAdapter.getDefaultAdapter(MMApplicationContext.getContext()) == null)
      {
        Log.i("MicroMsg.CpuCardConfigManager", "Nfc not support no need update");
        AppMethodBeat.o(26693);
        return false;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.CpuCardConfigManager", localException, "", new Object[0]);
      AppMethodBeat.o(26693);
      return false;
    }
    int j;
    if (this.AEn != null)
    {
      j = this.AEn.Lpt;
      if (j >= 1800) {}
    }
    for (;;)
    {
      Log.i("MicroMsg.CpuCardConfigManager", "now=" + Util.nowSecond() + ", lastUpdateTime=" + this.AEn.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + this.AEn.Lpt);
      if (Util.nowSecond() - this.AEn.lastUpdateTime > i)
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(26694);
    bg.azz().b(1561, this);
    if ((paramq instanceof b))
    {
      paramString = exz();
      paramString.lastUpdateTime = Util.nowSecond();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (ady)((b)paramq).rr.iLL.iLR;
        if (paramq != null)
        {
          paramString.Lpt = paramq.Lpt;
          paramString.Lpu = paramq.Lpu;
          bg.aVF();
          if (((Integer)c.azQ().get(ar.a.NUQ, Integer.valueOf(0))).intValue() == 0)
          {
            if (paramq.Lpu != 1) {
              break label234;
            }
            MMApplicationContext.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
          }
          for (;;)
          {
            bg.aVF();
            c.azQ().set(ar.a.NUR, Integer.valueOf(paramq.Lpu));
            bg.aVF();
            c.azQ().set(ar.a.NUU, paramq.HQv);
            if (paramString.version != paramq.version) {
              break;
            }
            Log.i("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd no config change return version = " + paramq.version);
            a(paramString);
            AppMethodBeat.o(26694);
            return;
            label234:
            MMApplicationContext.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
          }
          paramString.version = paramq.version;
          Log.i("MicroMsg.CpuCardConfigManager", "alvinluo nfc-onSceneEnd config new version: %d", new Object[] { Integer.valueOf(paramq.version) });
          if ((paramq.Lps != null) && (!paramq.Lps.isEmpty())) {
            if (paramString.Lps == null)
            {
              paramString.Lps = new LinkedList();
              paramInt1 = 0;
            }
          }
          for (;;)
          {
            if (paramInt1 < paramq.Lps.size())
            {
              tx localtx = new tx();
              localtx.KBH = ((tx)paramq.Lps.get(paramInt1)).KBH;
              localtx.Lci = ((tx)paramq.Lps.get(paramInt1)).Lci;
              Log.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + Util.nullAsNil(Integer.valueOf(localtx.Lci)) + ", url=" + Util.nullAsNil(localtx.KBH));
              if (localtx.Lch == null)
              {
                localtx.Lch = new LinkedList();
                label462:
                paramInt2 = 0;
              }
              for (;;)
              {
                if (paramInt2 >= ((tx)paramq.Lps.get(paramInt1)).Lch.size()) {
                  break label758;
                }
                adz localadz = new adz();
                if (localadz.Lpv == null) {
                  localadz.Lpv = new LinkedList();
                }
                for (;;)
                {
                  int i = 0;
                  while (i < ((adz)((tx)paramq.Lps.get(paramInt1)).Lch.get(paramInt2)).Lpv.size())
                  {
                    abl localabl = new abl();
                    localabl.Lmp = ((abl)((adz)((tx)paramq.Lps.get(paramInt1)).Lch.get(paramInt2)).Lpv.get(i)).Lmp;
                    localabl.yWF = ((abl)((adz)((tx)paramq.Lps.get(paramInt1)).Lch.get(paramInt2)).Lpv.get(i)).yWF;
                    Log.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + Util.nullAsNil(localabl.Lmp) + ", answer=" + Util.nullAsNil(localabl.yWF));
                    localadz.Lpv.add(localabl);
                    i += 1;
                  }
                  paramString.Lps.clear();
                  break;
                  localtx.Lch.clear();
                  break label462;
                  localadz.Lpv.clear();
                }
                localtx.Lch.add(localadz);
                paramInt2 += 1;
              }
              label758:
              paramString.Lps.add(localtx);
              paramInt1 += 1;
              continue;
              paramString.Lps.clear();
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