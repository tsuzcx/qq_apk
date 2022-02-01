package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends a<b>
{
  public String wwO;
  private i.a wwP;
  
  public e()
  {
    AppMethodBeat.i(66207);
    this.wwO = "";
    this.wwP = new i.a()
    {
      public final void dwj()
      {
        AppMethodBeat.i(66205);
        e.this.onChange();
        AppMethodBeat.o(66205);
      }
    };
    k.dwq();
    if (k.dwt() != null)
    {
      k.dwq();
      k.dwt().wxs = this.wwP;
    }
    AppMethodBeat.o(66207);
  }
  
  private static void c(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(66210);
    paramString = new o(paramInt1, paramInt2, paramInt3, paramString);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
    AppMethodBeat.o(66210);
  }
  
  private static void dwg()
  {
    AppMethodBeat.i(66208);
    k.dwq();
    k.dwt().gT(1, 1);
    AppMethodBeat.o(66208);
  }
  
  private static void dwh()
  {
    AppMethodBeat.i(66209);
    k.dwq();
    k.dwt().Mg(2);
    AppMethodBeat.o(66209);
  }
  
  public static int dwi()
  {
    AppMethodBeat.i(66213);
    k.dwq();
    k.dwt();
    int i = i.dwp();
    AppMethodBeat.o(66213);
    return i;
  }
  
  public final String B(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(66211);
    ad.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bt.flS().toString() });
    paramString = C(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(66211);
    return paramString;
  }
  
  public final String C(int paramInt1, int paramInt2, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(66212);
    int j = dwi();
    Object localObject;
    if (j > 0)
    {
      if (j < k.wxH)
      {
        ad.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount < %s", new Object[] { Integer.valueOf(k.wxH) });
        dwh();
      }
      k.dwq();
      localObject = k.Mi(196617);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        ad.e("MicroMsg.OfflineCodesMgr", "generateKey_V3 cn is null, the csr is not exist! cn:".concat(String.valueOf(localObject)));
        AppMethodBeat.o(66212);
        return "";
      }
      com.tencent.mm.wallet_core.c.b.fRq();
      localObject = com.tencent.mm.wallet_core.c.b.getToken((String)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        dwg();
        ad.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null");
        AppMethodBeat.o(66212);
        return "";
      }
    }
    else
    {
      paramString = com.tencent.mm.plugin.report.service.g.yhR;
      if (com.tencent.mm.plugin.offline.c.a.cH(aj.getContext()))
      {
        paramInt1 = 0;
        paramInt2 = i;
        if (ay.isNetworkConnected(aj.getContext())) {
          paramInt2 = 1;
        }
        paramString.f(14163, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 29L, 1L, true);
        if (!ay.isNetworkConnected(aj.getContext())) {
          break label249;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 31L, 1L, true);
      }
      for (;;)
      {
        dwg();
        ad.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount is 0");
        AppMethodBeat.o(66212);
        return "";
        paramInt1 = 1;
        break;
        label249:
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(135L, 30L, 1L, true);
      }
    }
    if (localObject != null) {
      ad.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code length : %s ext_business_attach %s %s", new Object[] { Integer.valueOf(((String)localObject).length()), paramString, localObject });
    }
    c(j - 1, paramInt1, paramInt2, paramString);
    ad.i("MicroMsg.OfflineCodesMgr", "doNetSceneShowCode count " + (j - 1));
    paramString = com.tencent.mm.plugin.offline.c.a.atL(com.tencent.mm.plugin.offline.c.a.dxy());
    if ((paramString == null) || (paramString.size() == 0))
    {
      ad.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 cardList is null");
      dwg();
      AppMethodBeat.o(66212);
      return "";
    }
    long l2;
    long l1;
    if ((localObject != null) && (com.tencent.mm.plugin.offline.c.a.isNumeric((String)localObject)))
    {
      l2 = Long.valueOf((String)localObject, 10).longValue();
      l1 = 0L;
      paramInt1 = 0;
      if (paramInt1 >= paramString.size()) {
        break label480;
      }
      localObject = (a.a)paramString.get(paramInt1);
      if ((localObject == null) || (((a.a)localObject).wBI == null) || (!((a.a)localObject).wBI.equals(this.wwO))) {
        break label644;
      }
      l1 = ((a.a)localObject).wBH;
    }
    label644:
    for (;;)
    {
      paramInt1 += 1;
      break;
      ad.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null or is not isNumeric");
      AppMethodBeat.o(66212);
      return "";
      label480:
      localObject = String.valueOf(l1 << 48 | l2);
      if (((String)localObject).length() == 15)
      {
        paramString = "0".concat(String.valueOf(localObject));
        if (TextUtils.isEmpty(com.tencent.mm.plugin.offline.c.a.getTokenPin())) {
          break label630;
        }
      }
      label630:
      for (paramString = com.tencent.mm.plugin.offline.c.a.getTokenPin() + paramString;; paramString = "12".concat(String.valueOf(paramString)))
      {
        AppMethodBeat.o(66212);
        return paramString;
        if (((String)localObject).length() == 14)
        {
          paramString = "00".concat(String.valueOf(localObject));
          break;
        }
        if (((String)localObject).length() == 13)
        {
          paramString = "000".concat(String.valueOf(localObject));
          break;
        }
        paramString = (String)localObject;
        if (((String)localObject).length() != 12) {
          break;
        }
        paramString = "0000".concat(String.valueOf(localObject));
        break;
      }
    }
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(66206);
    if (this.wwL == null)
    {
      AppMethodBeat.o(66206);
      return;
    }
    int i = 0;
    while (i < this.wwL.size())
    {
      Object localObject = (WeakReference)this.wwL.get(i);
      if (localObject != null)
      {
        localObject = (b)((WeakReference)localObject).get();
        if (localObject != null) {
          ((b)localObject).bUh();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(66206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.e
 * JD-Core Version:    0.7.0.1
 */