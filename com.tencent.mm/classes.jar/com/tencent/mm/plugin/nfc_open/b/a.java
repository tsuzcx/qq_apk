package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.protocal.protobuf.vo;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public final class a
  implements f
{
  public bgk pgy;
  
  public a()
  {
    AppMethodBeat.i(23063);
    init();
    AppMethodBeat.o(23063);
  }
  
  private void a(bgk parambgk)
  {
    AppMethodBeat.i(23065);
    if (!aw.RG())
    {
      ab.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
      AppMethodBeat.o(23065);
      return;
    }
    if (parambgk != null)
    {
      ab.i("MicroMsg.CpuCardConfigManager", "setConfig config");
      this.pgy = parambgk;
      try
      {
        parambgk = new String(this.pgy.toByteArray(), "ISO-8859-1");
        aw.aaz();
        c.Ru().set(ac.a.yzK, parambgk);
        AppMethodBeat.o(23065);
        return;
      }
      catch (UnsupportedEncodingException parambgk)
      {
        ab.w("MicroMsg.CpuCardConfigManager", "save config exp, " + parambgk.getLocalizedMessage());
        AppMethodBeat.o(23065);
        return;
      }
      catch (IOException parambgk)
      {
        ab.w("MicroMsg.CpuCardConfigManager", "save config exp, " + parambgk.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(23065);
  }
  
  private bgk bXb()
  {
    AppMethodBeat.i(23066);
    if (this.pgy == null) {
      init();
    }
    bgk localbgk = this.pgy;
    AppMethodBeat.o(23066);
    return localbgk;
  }
  
  private void init()
  {
    AppMethodBeat.i(23064);
    this.pgy = new bgk();
    aw.aaz();
    String str = String.valueOf(c.Ru().get(ac.a.yzK, null));
    if (bo.isNullOrNil(str))
    {
      this.pgy.wOn = new LinkedList();
      this.pgy.lastUpdateTime = 0L;
      this.pgy.wOo = 86400;
      this.pgy.version = 0;
      AppMethodBeat.o(23064);
      return;
    }
    try
    {
      this.pgy.parseFrom(str.getBytes("ISO-8859-1"));
      AppMethodBeat.o(23064);
      return;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + localException.getLocalizedMessage());
      this.pgy.wOn = new LinkedList();
      this.pgy.lastUpdateTime = 0L;
      this.pgy.wOo = 86400;
      this.pgy.version = 0;
      AppMethodBeat.o(23064);
    }
  }
  
  public final boolean bIs()
  {
    int i = 1800;
    AppMethodBeat.i(23067);
    try
    {
      if (NfcAdapter.getDefaultAdapter(ah.getContext()) == null)
      {
        ab.i("MicroMsg.CpuCardConfigManager", "Nfc not support no need update");
        AppMethodBeat.o(23067);
        return false;
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.CpuCardConfigManager", localException, "", new Object[0]);
      AppMethodBeat.o(23067);
      return false;
    }
    int j;
    if (this.pgy != null)
    {
      j = this.pgy.wOo;
      if (j >= 1800) {}
    }
    for (;;)
    {
      ab.i("MicroMsg.CpuCardConfigManager", "now=" + bo.aox() + ", lastUpdateTime=" + this.pgy.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + this.pgy.wOo);
      if (bo.aox() - this.pgy.lastUpdateTime > i)
      {
        AppMethodBeat.o(23067);
        return true;
        if (j > 604800) {
          i = 604800;
        }
      }
      else
      {
        AppMethodBeat.o(23067);
        return false;
      }
      i = j;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(23068);
    aw.Rc().b(1561, this);
    if ((paramm instanceof com.tencent.mm.plugin.nfc_open.a.b))
    {
      paramString = bXb();
      paramString.lastUpdateTime = bo.aox();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramm = (vo)((com.tencent.mm.plugin.nfc_open.a.b)paramm).rr.fsW.fta;
        if (paramm != null)
        {
          paramString.wOo = paramm.wOo;
          paramString.wOp = paramm.wOp;
          aw.aaz();
          if (((Integer)c.Ru().get(ac.a.yzP, Integer.valueOf(0))).intValue() == 0)
          {
            if (paramm.wOp != 1) {
              break label234;
            }
            ah.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
          }
          for (;;)
          {
            aw.aaz();
            c.Ru().set(ac.a.yzQ, Integer.valueOf(paramm.wOp));
            aw.aaz();
            c.Ru().set(ac.a.yzT, paramm.ucg);
            if (paramString.version != paramm.version) {
              break;
            }
            ab.i("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd no config change return version = " + paramm.version);
            a(paramString);
            AppMethodBeat.o(23068);
            return;
            label234:
            ah.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
          }
          paramString.version = paramm.version;
          if ((paramm.wOn != null) && (!paramm.wOn.isEmpty())) {
            if (paramString.wOn == null)
            {
              paramString.wOn = new LinkedList();
              paramInt1 = 0;
            }
          }
          for (;;)
          {
            if (paramInt1 < paramm.wOn.size())
            {
              oi localoi = new oi();
              localoi.wki = ((oi)paramm.wOn.get(paramInt1)).wki;
              localoi.wDK = ((oi)paramm.wOn.get(paramInt1)).wDK;
              ab.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + bo.g(Integer.valueOf(localoi.wDK)) + ", url=" + bo.nullAsNil(localoi.wki));
              if (localoi.wDJ == null)
              {
                localoi.wDJ = new LinkedList();
                label439:
                paramInt2 = 0;
              }
              for (;;)
              {
                if (paramInt2 >= ((oi)paramm.wOn.get(paramInt1)).wDJ.size()) {
                  break label735;
                }
                vp localvp = new vp();
                if (localvp.wOq == null) {
                  localvp.wOq = new LinkedList();
                }
                for (;;)
                {
                  int i = 0;
                  while (i < ((vp)((oi)paramm.wOn.get(paramInt1)).wDJ.get(paramInt2)).wOq.size())
                  {
                    ub localub = new ub();
                    localub.wMy = ((ub)((vp)((oi)paramm.wOn.get(paramInt1)).wDJ.get(paramInt2)).wOq.get(i)).wMy;
                    localub.ooD = ((ub)((vp)((oi)paramm.wOn.get(paramInt1)).wDJ.get(paramInt2)).wOq.get(i)).ooD;
                    ab.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + bo.nullAsNil(localub.wMy) + ", answer=" + bo.nullAsNil(localub.ooD));
                    localvp.wOq.add(localub);
                    i += 1;
                  }
                  paramString.wOn.clear();
                  break;
                  localoi.wDJ.clear();
                  break label439;
                  localvp.wOq.clear();
                }
                localoi.wDJ.add(localvp);
                paramInt2 += 1;
              }
              label735:
              paramString.wOn.add(localoi);
              paramInt1 += 1;
              continue;
              paramString.wOn.clear();
            }
          }
        }
      }
      a(paramString);
    }
    AppMethodBeat.o(23068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc_open.b.a
 * JD-Core Version:    0.7.0.1
 */