package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.c.a.a;
import com.tencent.mm.plugin.report.service.h;
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
  public String AIf;
  private i.a AIg;
  
  public e()
  {
    AppMethodBeat.i(66207);
    this.AIf = "";
    this.AIg = new i.a()
    {
      public final void ezg()
      {
        AppMethodBeat.i(66205);
        e.this.onChange();
        AppMethodBeat.o(66205);
      }
    };
    k.ezn();
    if (k.ezq() != null)
    {
      k.ezn();
      k.ezq().AIJ = this.AIg;
    }
    AppMethodBeat.o(66207);
  }
  
  private static void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(66210);
    paramString = new o(paramInt1, paramInt2, paramInt3, paramString);
    g.aAi();
    g.aAg().hqi.a(paramString, 0);
    AppMethodBeat.o(66210);
  }
  
  private static void ezd()
  {
    AppMethodBeat.i(66208);
    k.ezn();
    k.ezq().hF(1, 1);
    AppMethodBeat.o(66208);
  }
  
  private static void eze()
  {
    AppMethodBeat.i(66209);
    k.ezn();
    k.ezq().TV(2);
    AppMethodBeat.o(66209);
  }
  
  public static int ezf()
  {
    AppMethodBeat.i(66213);
    k.ezn();
    k.ezq();
    int i = i.ezm();
    AppMethodBeat.o(66213);
    return i;
  }
  
  public final String A(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(66211);
    Log.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Util.getStack().toString() });
    paramString = B(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(66211);
    return paramString;
  }
  
  public final String B(int paramInt1, int paramInt2, String paramString)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(66212);
    int k = ezf();
    if (k > 0)
    {
      if (k < k.AIY)
      {
        Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount < %s", new Object[] { Integer.valueOf(k.AIY) });
        eze();
      }
      k.ezn();
      localObject = k.TX(196617);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        Log.e("MicroMsg.OfflineCodesMgr", "generateKey_V3 cn is null, the csr is not exist! cn:".concat(String.valueOf(localObject)));
        AppMethodBeat.o(66212);
        return "";
      }
      com.tencent.mm.wallet_core.c.b.hhj();
      localObject = com.tencent.mm.wallet_core.c.b.getToken((String)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        ezd();
        Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null");
        AppMethodBeat.o(66212);
        return "";
      }
    }
    else
    {
      paramString = h.CyF;
      if (com.tencent.mm.plugin.offline.c.a.isAppOnForeground(MMApplicationContext.getContext()))
      {
        paramInt1 = 0;
        paramInt2 = i;
        if (NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
          paramInt2 = 1;
        }
        paramString.a(14163, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        h.CyF.idkeyStat(135L, 29L, 1L, true);
        if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
          break label252;
        }
        h.CyF.idkeyStat(135L, 31L, 1L, true);
      }
      for (;;)
      {
        ezd();
        Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount is 0");
        AppMethodBeat.o(66212);
        return "";
        paramInt1 = 1;
        break;
        label252:
        h.CyF.idkeyStat(135L, 30L, 1L, true);
      }
    }
    if (localObject != null) {
      Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code length : %s ext_business_attach %s %s", new Object[] { Integer.valueOf(((String)localObject).length()), paramString, localObject });
    }
    b(k - 1, paramInt1, paramInt2, paramString);
    Log.i("MicroMsg.OfflineCodesMgr", "doNetSceneShowCode count " + (k - 1));
    paramString = com.tencent.mm.plugin.offline.c.a.aJm(com.tencent.mm.plugin.offline.c.a.eAA());
    if ((paramString == null) || (paramString.size() == 0))
    {
      Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 cardList is null");
      ezd();
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
        if (((a.a)localObject).ANo != null)
        {
          l2 = l1;
          if (((a.a)localObject).ANo.equals(this.AIf)) {
            l2 = ((a.a)localObject).ANn;
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
        break label650;
      }
    }
    label650:
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
    if (this.AIc == null)
    {
      AppMethodBeat.o(66206);
      return;
    }
    int i = 0;
    while (i < this.AIc.size())
    {
      Object localObject = (WeakReference)this.AIc.get(i);
      if (localObject != null)
      {
        localObject = (b)((WeakReference)localObject).get();
        if (localObject != null) {
          ((b)localObject).ctk();
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