package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import android.nfc.NfcAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.protocal.protobuf.agr;
import com.tencent.mm.protocal.protobuf.ags;
import com.tencent.mm.protocal.protobuf.dul;
import com.tencent.mm.protocal.protobuf.vq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public final class a
  implements h
{
  public dul Mtw;
  
  public a()
  {
    AppMethodBeat.i(26689);
    init();
    AppMethodBeat.o(26689);
  }
  
  private void a(dul paramdul)
  {
    AppMethodBeat.i(26691);
    if (!bh.baz())
    {
      Log.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
      AppMethodBeat.o(26691);
      return;
    }
    if (paramdul != null)
    {
      Log.i("MicroMsg.CpuCardConfigManager", "setConfig config");
      this.Mtw = paramdul;
      try
      {
        paramdul = new String(this.Mtw.toByteArray(), "ISO-8859-1");
        bh.bCz();
        com.tencent.mm.model.c.ban().set(at.a.acKe, paramdul);
        AppMethodBeat.o(26691);
        return;
      }
      catch (UnsupportedEncodingException paramdul)
      {
        Log.w("MicroMsg.CpuCardConfigManager", "save config exp, " + paramdul.getLocalizedMessage());
        AppMethodBeat.o(26691);
        return;
      }
      catch (IOException paramdul)
      {
        Log.w("MicroMsg.CpuCardConfigManager", "save config exp, " + paramdul.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(26691);
  }
  
  private dul gtt()
  {
    AppMethodBeat.i(26692);
    if (this.Mtw == null) {
      init();
    }
    dul localdul = this.Mtw;
    AppMethodBeat.o(26692);
    return localdul;
  }
  
  private void init()
  {
    AppMethodBeat.i(26690);
    this.Mtw = new dul();
    bh.bCz();
    String str = String.valueOf(com.tencent.mm.model.c.ban().get(at.a.acKe, null));
    if (Util.isNullOrNil(str))
    {
      this.Mtw.ZpP = new LinkedList();
      this.Mtw.lastUpdateTime = 0L;
      this.Mtw.ZpQ = 86400;
      this.Mtw.version = 0;
      AppMethodBeat.o(26690);
      return;
    }
    try
    {
      this.Mtw.parseFrom(str.getBytes("ISO-8859-1"));
      Log.i("MicroMsg.CpuCardConfigManager", "alvinluo nfcConfig version: %d", new Object[] { Integer.valueOf(this.Mtw.version) });
      AppMethodBeat.o(26690);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
      this.Mtw.ZpP = new LinkedList();
      this.Mtw.lastUpdateTime = 0L;
      this.Mtw.ZpQ = 86400;
      this.Mtw.version = 0;
      AppMethodBeat.o(26690);
    }
  }
  
  public final boolean fQj()
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
    if (this.Mtw != null)
    {
      j = this.Mtw.ZpQ;
      if (j >= 1800) {}
    }
    for (;;)
    {
      Log.i("MicroMsg.CpuCardConfigManager", "now=" + Util.nowSecond() + ", lastUpdateTime=" + this.Mtw.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + this.Mtw.ZpQ);
      if (Util.nowSecond() - this.Mtw.lastUpdateTime > i)
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(26694);
    bh.aZW().b(1561, this);
    if ((paramp instanceof com.tencent.mm.plugin.nfc_open.model.a))
    {
      paramString = gtt();
      paramString.lastUpdateTime = Util.nowSecond();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramp = (agr)c.c.b(((com.tencent.mm.plugin.nfc_open.model.a)paramp).rr.otC);
        if (paramp != null)
        {
          paramString.ZpQ = paramp.ZpQ;
          paramString.ZpR = paramp.ZpR;
          bh.bCz();
          if (((Integer)com.tencent.mm.model.c.ban().get(at.a.acKj, Integer.valueOf(0))).intValue() == 0)
          {
            if (paramp.ZpR != 1) {
              break label232;
            }
            Util.setComponentEnabledSetting(MMApplicationContext.getContext(), new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
          }
          for (;;)
          {
            bh.bCz();
            com.tencent.mm.model.c.ban().set(at.a.acKk, Integer.valueOf(paramp.ZpR));
            bh.bCz();
            com.tencent.mm.model.c.ban().set(at.a.acKn, paramp.Vyo);
            if (paramString.version != paramp.version) {
              break;
            }
            Log.i("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd no config change return version = " + paramp.version);
            a(paramString);
            AppMethodBeat.o(26694);
            return;
            label232:
            Util.setComponentEnabledSetting(MMApplicationContext.getContext(), new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
          }
          paramString.version = paramp.version;
          Log.i("MicroMsg.CpuCardConfigManager", "alvinluo nfc-onSceneEnd config new version: %d", new Object[] { Integer.valueOf(paramp.version) });
          if ((paramp.ZpP != null) && (!paramp.ZpP.isEmpty())) {
            if (paramString.ZpP == null)
            {
              paramString.ZpP = new LinkedList();
              paramInt1 = 0;
            }
          }
          for (;;)
          {
            if (paramInt1 < paramp.ZpP.size())
            {
              vq localvq = new vq();
              localvq.YAb = ((vq)paramp.ZpP.get(paramInt1)).YAb;
              localvq.Zbp = ((vq)paramp.ZpP.get(paramInt1)).Zbp;
              Log.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + Util.nullAsNil(Integer.valueOf(localvq.Zbp)) + ", url=" + Util.nullAsNil(localvq.YAb));
              if (localvq.Zbo == null)
              {
                localvq.Zbo = new LinkedList();
                label458:
                paramInt2 = 0;
              }
              for (;;)
              {
                if (paramInt2 >= ((vq)paramp.ZpP.get(paramInt1)).Zbo.size()) {
                  break label754;
                }
                ags localags = new ags();
                if (localags.ZpS == null) {
                  localags.ZpS = new LinkedList();
                }
                for (;;)
                {
                  int i = 0;
                  while (i < ((ags)((vq)paramp.ZpP.get(paramInt1)).Zbo.get(paramInt2)).ZpS.size())
                  {
                    adu localadu = new adu();
                    localadu.ZlZ = ((adu)((ags)((vq)paramp.ZpP.get(paramInt1)).Zbo.get(paramInt2)).ZpS.get(i)).ZlZ;
                    localadu.KtE = ((adu)((ags)((vq)paramp.ZpP.get(paramInt1)).Zbo.get(paramInt2)).ZpS.get(i)).KtE;
                    Log.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + Util.nullAsNil(localadu.ZlZ) + ", answer=" + Util.nullAsNil(localadu.KtE));
                    localags.ZpS.add(localadu);
                    i += 1;
                  }
                  paramString.ZpP.clear();
                  break;
                  localvq.Zbo.clear();
                  break label458;
                  localags.ZpS.clear();
                }
                localvq.Zbo.add(localags);
                paramInt2 += 1;
              }
              label754:
              paramString.ZpP.add(localvq);
              paramInt1 += 1;
              continue;
              paramString.ZpP.clear();
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