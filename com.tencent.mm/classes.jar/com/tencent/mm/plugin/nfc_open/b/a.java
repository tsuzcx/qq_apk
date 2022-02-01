package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.protocal.protobuf.abs;
import com.tencent.mm.protocal.protobuf.aef;
import com.tencent.mm.protocal.protobuf.aeg;
import com.tencent.mm.protocal.protobuf.dcs;
import com.tencent.mm.protocal.protobuf.tz;
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
  public dcs Gxr;
  
  public a()
  {
    AppMethodBeat.i(26689);
    init();
    AppMethodBeat.o(26689);
  }
  
  private void a(dcs paramdcs)
  {
    AppMethodBeat.i(26691);
    if (!bh.aHB())
    {
      Log.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
      AppMethodBeat.o(26691);
      return;
    }
    if (paramdcs != null)
    {
      Log.i("MicroMsg.CpuCardConfigManager", "setConfig config");
      this.Gxr = paramdcs;
      try
      {
        paramdcs = new String(this.Gxr.toByteArray(), "ISO-8859-1");
        bh.beI();
        c.aHp().set(ar.a.ViK, paramdcs);
        AppMethodBeat.o(26691);
        return;
      }
      catch (UnsupportedEncodingException paramdcs)
      {
        Log.w("MicroMsg.CpuCardConfigManager", "save config exp, " + paramdcs.getLocalizedMessage());
        AppMethodBeat.o(26691);
        return;
      }
      catch (IOException paramdcs)
      {
        Log.w("MicroMsg.CpuCardConfigManager", "save config exp, " + paramdcs.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(26691);
  }
  
  private dcs fjd()
  {
    AppMethodBeat.i(26692);
    if (this.Gxr == null) {
      init();
    }
    dcs localdcs = this.Gxr;
    AppMethodBeat.o(26692);
    return localdcs;
  }
  
  private void init()
  {
    AppMethodBeat.i(26690);
    this.Gxr = new dcs();
    bh.beI();
    String str = String.valueOf(c.aHp().get(ar.a.ViK, null));
    if (Util.isNullOrNil(str))
    {
      this.Gxr.SqO = new LinkedList();
      this.Gxr.lastUpdateTime = 0L;
      this.Gxr.SqP = 86400;
      this.Gxr.version = 0;
      AppMethodBeat.o(26690);
      return;
    }
    try
    {
      this.Gxr.parseFrom(str.getBytes("ISO-8859-1"));
      Log.i("MicroMsg.CpuCardConfigManager", "alvinluo nfcConfig version: %d", new Object[] { Integer.valueOf(this.Gxr.version) });
      AppMethodBeat.o(26690);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
      this.Gxr.SqO = new LinkedList();
      this.Gxr.lastUpdateTime = 0L;
      this.Gxr.SqP = 86400;
      this.Gxr.version = 0;
      AppMethodBeat.o(26690);
    }
  }
  
  public final boolean eIq()
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
    if (this.Gxr != null)
    {
      j = this.Gxr.SqP;
      if (j >= 1800) {}
    }
    for (;;)
    {
      Log.i("MicroMsg.CpuCardConfigManager", "now=" + Util.nowSecond() + ", lastUpdateTime=" + this.Gxr.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + this.Gxr.SqP);
      if (Util.nowSecond() - this.Gxr.lastUpdateTime > i)
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
    bh.aGY().b(1561, this);
    if ((paramq instanceof b))
    {
      paramString = fjd();
      paramString.lastUpdateTime = Util.nowSecond();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (aef)d.c.b(((b)paramq).rr.lBS);
        if (paramq != null)
        {
          paramString.SqP = paramq.SqP;
          paramString.SqQ = paramq.SqQ;
          bh.beI();
          if (((Integer)c.aHp().get(ar.a.ViP, Integer.valueOf(0))).intValue() == 0)
          {
            if (paramq.SqQ != 1) {
              break label234;
            }
            MMApplicationContext.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
          }
          for (;;)
          {
            bh.beI();
            c.aHp().set(ar.a.ViQ, Integer.valueOf(paramq.SqQ));
            bh.beI();
            c.aHp().set(ar.a.ViT, paramq.OIC);
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
          if ((paramq.SqO != null) && (!paramq.SqO.isEmpty())) {
            if (paramString.SqO == null)
            {
              paramString.SqO = new LinkedList();
              paramInt1 = 0;
            }
          }
          for (;;)
          {
            if (paramInt1 < paramq.SqO.size())
            {
              tz localtz = new tz();
              localtz.RDy = ((tz)paramq.SqO.get(paramInt1)).RDy;
              localtz.Sdv = ((tz)paramq.SqO.get(paramInt1)).Sdv;
              Log.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + Util.nullAsNil(Integer.valueOf(localtz.Sdv)) + ", url=" + Util.nullAsNil(localtz.RDy));
              if (localtz.Sdu == null)
              {
                localtz.Sdu = new LinkedList();
                label462:
                paramInt2 = 0;
              }
              for (;;)
              {
                if (paramInt2 >= ((tz)paramq.SqO.get(paramInt1)).Sdu.size()) {
                  break label758;
                }
                aeg localaeg = new aeg();
                if (localaeg.SqR == null) {
                  localaeg.SqR = new LinkedList();
                }
                for (;;)
                {
                  int i = 0;
                  while (i < ((aeg)((tz)paramq.SqO.get(paramInt1)).Sdu.get(paramInt2)).SqR.size())
                  {
                    abs localabs = new abs();
                    localabs.SnD = ((abs)((aeg)((tz)paramq.SqO.get(paramInt1)).Sdu.get(paramInt2)).SqR.get(i)).SnD;
                    localabs.EAI = ((abs)((aeg)((tz)paramq.SqO.get(paramInt1)).Sdu.get(paramInt2)).SqR.get(i)).EAI;
                    Log.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + Util.nullAsNil(localabs.SnD) + ", answer=" + Util.nullAsNil(localabs.EAI));
                    localaeg.SqR.add(localabs);
                    i += 1;
                  }
                  paramString.SqO.clear();
                  break;
                  localtz.Sdu.clear();
                  break label462;
                  localaeg.SqR.clear();
                }
                localtz.Sdu.add(localaeg);
                paramInt2 += 1;
              }
              label758:
              paramString.SqO.add(localtz);
              paramInt1 += 1;
              continue;
              paramString.SqO.clear();
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