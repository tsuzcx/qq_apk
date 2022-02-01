package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends a<b>
{
  public String GBp;
  private i.a GBq;
  
  public e()
  {
    AppMethodBeat.i(66207);
    this.GBp = "";
    this.GBq = new i.a()
    {
      public final void fkL()
      {
        AppMethodBeat.i(66205);
        e.this.onChange();
        AppMethodBeat.o(66205);
      }
    };
    k.fkT();
    if (k.fkW() != null)
    {
      k.fkT();
      k.fkW().GBS = this.GBq;
    }
    AppMethodBeat.o(66207);
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(66210);
    paramString = new o(paramInt1, paramInt2, paramInt3, paramString);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
    AppMethodBeat.o(66210);
  }
  
  private static void fkI()
  {
    AppMethodBeat.i(66208);
    k.fkT();
    k.fkW().iK(1, 1);
    AppMethodBeat.o(66208);
  }
  
  private static void fkJ()
  {
    AppMethodBeat.i(66209);
    k.fkT();
    k.fkW().aaI(2);
    AppMethodBeat.o(66209);
  }
  
  public static int fkK()
  {
    AppMethodBeat.i(66213);
    k.fkT();
    k.fkW();
    int i = i.fkS();
    AppMethodBeat.o(66213);
    return i;
  }
  
  public final String C(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(66211);
    Log.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Util.getStack().toString() });
    paramString = D(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(66211);
    return paramString;
  }
  
  public final String D(int paramInt1, int paramInt2, String paramString)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(66212);
    int k = fkK();
    if (k > 0)
    {
      if (k < k.GCh)
      {
        Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount < %s", new Object[] { Integer.valueOf(k.GCh) });
        fkJ();
      }
      k.fkT();
      localObject = k.aaK(196617);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        Log.e("MicroMsg.OfflineCodesMgr", "generateKey_V3 cn is null, the csr is not exist! cn:".concat(String.valueOf(localObject)));
        AppMethodBeat.o(66212);
        return "";
      }
      com.tencent.mm.wallet_core.c.b.iiL();
      localObject = com.tencent.mm.wallet_core.c.b.getToken((String)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        fkI();
        Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null");
        AppMethodBeat.o(66212);
        return "";
      }
    }
    else
    {
      paramString = com.tencent.mm.plugin.report.service.h.IzE;
      if (com.tencent.mm.plugin.offline.c.a.isAppOnForeground(MMApplicationContext.getContext()))
      {
        paramInt1 = 0;
        paramInt2 = i;
        if (NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
          paramInt2 = 1;
        }
        paramString.a(14163, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 29L, 1L, true);
        if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
          break label252;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 31L, 1L, true);
      }
      for (;;)
      {
        fkI();
        Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount is 0");
        AppMethodBeat.o(66212);
        return "";
        paramInt1 = 1;
        break;
        label252:
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(135L, 30L, 1L, true);
      }
    }
    if (localObject != null) {
      Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code length : %s ext_business_attach %s %s", new Object[] { Integer.valueOf(((String)localObject).length()), paramString, localObject });
    }
    a(k - 1, paramInt1, paramInt2, paramString);
    Log.i("MicroMsg.OfflineCodesMgr", "doNetSceneShowCode count " + (k - 1));
    paramString = com.tencent.mm.plugin.offline.c.a.aTI(com.tencent.mm.plugin.offline.c.a.fme());
    if ((paramString == null) || (paramString.size() == 0))
    {
      Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 cardList is null");
      fkI();
      AppMethodBeat.o(66212);
      return "";
    }
    long l3;
    long l1;
    if ((localObject != null) && (com.tencent.mm.plugin.offline.c.a.isNumeric((String)localObject)))
    {
      l3 = Long.valueOf((String)localObject, 10).longValue();
      l1 = 0L;
      paramInt1 = j;
    }
    while (paramInt1 < paramString.size())
    {
      localObject = (a.a)paramString.get(paramInt1);
      long l2 = l1;
      if (localObject != null)
      {
        l2 = l1;
        if (((a.a)localObject).GGC != null)
        {
          l2 = l1;
          if (((a.a)localObject).GGC.equals(this.GBp)) {
            l2 = ((a.a)localObject).GGB;
          }
        }
      }
      paramInt1 += 1;
      l1 = l2;
      continue;
      Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null or is not isNumeric");
      AppMethodBeat.o(66212);
      return "";
    }
    Object localObject = String.valueOf(l1 << 48 | l3);
    if (((String)localObject).length() == 15)
    {
      paramString = "0".concat(String.valueOf(localObject));
      if (TextUtils.isEmpty(com.tencent.mm.plugin.offline.c.a.getTokenPin())) {
        break label649;
      }
    }
    label649:
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
  
  public final void onChange()
  {
    AppMethodBeat.i(66206);
    if (this.GBm == null)
    {
      AppMethodBeat.o(66206);
      return;
    }
    int i = 0;
    while (i < this.GBm.size())
    {
      Object localObject = (WeakReference)this.GBm.get(i);
      if (localObject != null)
      {
        localObject = (b)((WeakReference)localObject).get();
        if (localObject != null) {
          ((b)localObject).cGM();
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