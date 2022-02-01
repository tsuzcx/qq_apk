package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.c.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends a<b>
{
  private i.a wMA;
  public String wMz;
  
  public e()
  {
    AppMethodBeat.i(66207);
    this.wMz = "";
    this.wMA = new i.a()
    {
      public final void dzz()
      {
        AppMethodBeat.i(66205);
        e.this.onChange();
        AppMethodBeat.o(66205);
      }
    };
    k.dzG();
    if (k.dzJ() != null)
    {
      k.dzG();
      k.dzJ().wNd = this.wMA;
    }
    AppMethodBeat.o(66207);
  }
  
  private static void c(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(66210);
    paramString = new o(paramInt1, paramInt2, paramInt3, paramString);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
    AppMethodBeat.o(66210);
  }
  
  private static void dzw()
  {
    AppMethodBeat.i(66208);
    k.dzG();
    k.dzJ().gU(1, 1);
    AppMethodBeat.o(66208);
  }
  
  private static void dzx()
  {
    AppMethodBeat.i(66209);
    k.dzG();
    k.dzJ().ML(2);
    AppMethodBeat.o(66209);
  }
  
  public static int dzy()
  {
    AppMethodBeat.i(66213);
    k.dzG();
    k.dzJ();
    int i = i.dzF();
    AppMethodBeat.o(66213);
    return i;
  }
  
  public final String B(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(66211);
    ae.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bu.fpN().toString() });
    paramString = C(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(66211);
    return paramString;
  }
  
  public final String C(int paramInt1, int paramInt2, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(66212);
    int j = dzy();
    Object localObject;
    if (j > 0)
    {
      if (j < k.wNs)
      {
        ae.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount < %s", new Object[] { Integer.valueOf(k.wNs) });
        dzx();
      }
      k.dzG();
      localObject = k.MN(196617);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        ae.e("MicroMsg.OfflineCodesMgr", "generateKey_V3 cn is null, the csr is not exist! cn:".concat(String.valueOf(localObject)));
        AppMethodBeat.o(66212);
        return "";
      }
      com.tencent.mm.wallet_core.c.b.fVM();
      localObject = com.tencent.mm.wallet_core.c.b.getToken((String)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        dzw();
        ae.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null");
        AppMethodBeat.o(66212);
        return "";
      }
    }
    else
    {
      paramString = com.tencent.mm.plugin.report.service.g.yxI;
      if (com.tencent.mm.plugin.offline.c.a.cJ(ak.getContext()))
      {
        paramInt1 = 0;
        paramInt2 = i;
        if (az.isNetworkConnected(ak.getContext())) {
          paramInt2 = 1;
        }
        paramString.f(14163, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 29L, 1L, true);
        if (!az.isNetworkConnected(ak.getContext())) {
          break label249;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 31L, 1L, true);
      }
      for (;;)
      {
        dzw();
        ae.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount is 0");
        AppMethodBeat.o(66212);
        return "";
        paramInt1 = 1;
        break;
        label249:
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(135L, 30L, 1L, true);
      }
    }
    if (localObject != null) {
      ae.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code length : %s ext_business_attach %s %s", new Object[] { Integer.valueOf(((String)localObject).length()), paramString, localObject });
    }
    c(j - 1, paramInt1, paramInt2, paramString);
    ae.i("MicroMsg.OfflineCodesMgr", "doNetSceneShowCode count " + (j - 1));
    paramString = com.tencent.mm.plugin.offline.c.a.ava(com.tencent.mm.plugin.offline.c.a.dAO());
    if ((paramString == null) || (paramString.size() == 0))
    {
      ae.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 cardList is null");
      dzw();
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
      if ((localObject == null) || (((a.a)localObject).wRt == null) || (!((a.a)localObject).wRt.equals(this.wMz))) {
        break label644;
      }
      l1 = ((a.a)localObject).wRs;
    }
    label644:
    for (;;)
    {
      paramInt1 += 1;
      break;
      ae.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null or is not isNumeric");
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
    if (this.wMw == null)
    {
      AppMethodBeat.o(66206);
      return;
    }
    int i = 0;
    while (i < this.wMw.size())
    {
      Object localObject = (WeakReference)this.wMw.get(i);
      if (localObject != null)
      {
        localObject = (b)((WeakReference)localObject).get();
        if (localObject != null) {
          ((b)localObject).bVw();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(66206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.e
 * JD-Core Version:    0.7.0.1
 */