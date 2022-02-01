package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.offline.a.q;
import com.tencent.mm.plugin.offline.c.d;
import com.tencent.mm.plugin.offline.c.d.a;
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
  public String Mxy;
  private i.a Mxz;
  
  public e()
  {
    AppMethodBeat.i(66207);
    this.Mxy = "";
    this.Mxz = new i.a()
    {
      public final void gvc()
      {
        AppMethodBeat.i(66205);
        e.this.onChange();
        AppMethodBeat.o(66205);
      }
    };
    k.gvj();
    if (k.gvm() != null)
    {
      k.gvj();
      k.gvm().Mya = this.Mxz;
    }
    AppMethodBeat.o(66207);
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(269113);
    paramString1 = new q(paramInt1, paramInt2, paramInt3, paramString1, paramString2);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString1, 0);
    AppMethodBeat.o(269113);
  }
  
  private static void guZ()
  {
    AppMethodBeat.i(66208);
    k.gvj();
    k.gvm().kq(1, 1);
    AppMethodBeat.o(66208);
  }
  
  private static void gva()
  {
    AppMethodBeat.i(66209);
    k.gvj();
    k.gvm().afb(2);
    AppMethodBeat.o(66209);
  }
  
  public static int gvb()
  {
    AppMethodBeat.i(66213);
    k.gvj();
    k.gvm();
    int i = i.gvi();
    AppMethodBeat.o(66213);
    return i;
  }
  
  public final String G(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(66211);
    Log.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Util.getStack().toString() });
    paramString = H(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(66211);
    return paramString;
  }
  
  public final String H(int paramInt1, int paramInt2, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(66212);
    int j = gvb();
    String str;
    if (j > 0)
    {
      if (j < k.Myp)
      {
        Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount < %s", new Object[] { Integer.valueOf(k.Myp) });
        gva();
      }
      k.gvj();
      localObject = k.afd(196617);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        Log.e("MicroMsg.OfflineCodesMgr", "generateKey_V3 cn is null, the csr is not exist! cn:".concat(String.valueOf(localObject)));
        AppMethodBeat.o(66212);
        return "";
      }
      com.tencent.mm.wallet_core.model.b.jOG();
      str = com.tencent.mm.wallet_core.model.b.getToken((String)localObject);
      if (TextUtils.isEmpty(str))
      {
        guZ();
        Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null");
        AppMethodBeat.o(66212);
        return "";
      }
    }
    else
    {
      paramString = com.tencent.mm.plugin.report.service.h.OAn;
      MMApplicationContext.getContext();
      if (d.gwX())
      {
        paramInt1 = 0;
        paramInt2 = i;
        if (NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
          paramInt2 = 1;
        }
        paramString.b(14163, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 29L, 1L, true);
        if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext())) {
          break label250;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 31L, 1L, true);
      }
      for (;;)
      {
        guZ();
        Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount is 0");
        AppMethodBeat.o(66212);
        return "";
        paramInt1 = 1;
        break;
        label250:
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(135L, 30L, 1L, true);
      }
    }
    boolean bool = d.aQX(str);
    if (bool) {}
    for (i = 2;; i = 1)
    {
      d.setTokenType(i);
      if ((d.gxe() != 0) || (!bool)) {
        break;
      }
      com.tencent.mm.wallet_core.model.b.jOG();
      com.tencent.mm.wallet_core.model.b.clearToken((String)localObject);
      guZ();
      Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 online code is close, need get token again");
      AppMethodBeat.o(66212);
      return "";
    }
    if (str != null) {
      Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code length : %s ext_business_attach %s %s", new Object[] { Integer.valueOf(str.length()), paramString, str });
    }
    if (bool) {}
    long l2;
    for (Object localObject = "1";; localObject = "0")
    {
      a(j - 1, paramInt1, paramInt2, paramString, (String)localObject);
      Log.i("MicroMsg.OfflineCodesMgr", "doNetSceneShowCode count " + (j - 1));
      if (!d.isNumeric(str)) {
        break;
      }
      l2 = Long.valueOf(str, 10).longValue();
      if (bool) {
        break label640;
      }
      paramString = d.aQN(d.gwQ());
      if ((paramString != null) && (paramString.size() != 0)) {
        break label498;
      }
      Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 cardList is null");
      guZ();
      AppMethodBeat.o(66212);
      return "";
    }
    Log.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null or is not isNumeric");
    AppMethodBeat.o(66212);
    return "";
    label498:
    long l1 = 0L;
    paramInt1 = 0;
    if (paramInt1 < paramString.size())
    {
      localObject = (d.a)paramString.get(paramInt1);
      if ((localObject == null) || (((d.a)localObject).MDt == null) || (!((d.a)localObject).MDt.equals(this.Mxy))) {
        break label747;
      }
      l1 = ((d.a)localObject).MDs;
    }
    label603:
    label733:
    label747:
    for (;;)
    {
      paramInt1 += 1;
      break;
      l1 = l1 << 48 | l2;
      localObject = String.valueOf(l1);
      if (((String)localObject).length() == 15)
      {
        paramString = "0".concat(String.valueOf(localObject));
        if (TextUtils.isEmpty(d.getTokenPin())) {
          break label733;
        }
      }
      for (paramString = d.getTokenPin() + paramString;; paramString = "12".concat(String.valueOf(paramString)))
      {
        AppMethodBeat.o(66212);
        return paramString;
        Log.i("MicroMsg.OfflineCodesMgr", "is online code");
        l1 = l2;
        break;
        if (((String)localObject).length() == 14)
        {
          paramString = "00".concat(String.valueOf(localObject));
          break label603;
        }
        if (((String)localObject).length() == 13)
        {
          paramString = "000".concat(String.valueOf(localObject));
          break label603;
        }
        paramString = (String)localObject;
        if (((String)localObject).length() != 12) {
          break label603;
        }
        paramString = "0000".concat(String.valueOf(localObject));
        break label603;
      }
    }
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(66206);
    if (this.Mxv == null)
    {
      AppMethodBeat.o(66206);
      return;
    }
    int i = 0;
    while (i < this.Mxv.size())
    {
      Object localObject = (WeakReference)this.Mxv.get(i);
      if (localObject != null)
      {
        localObject = (b)((WeakReference)localObject).get();
        if (localObject != null) {
          ((b)localObject).dkd();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(66206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.e
 * JD-Core Version:    0.7.0.1
 */