package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.c.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends a<b>
{
  public String pjW;
  private i.a pjX;
  
  public e()
  {
    AppMethodBeat.i(43305);
    this.pjW = "";
    this.pjX = new e.1(this);
    k.bYF();
    if (k.bYI() != null)
    {
      k.bYF();
      k.bYI().pkA = this.pjX;
    }
    AppMethodBeat.o(43305);
  }
  
  private static void bYv()
  {
    AppMethodBeat.i(43306);
    k.bYF();
    k.bYI().eY(1, 1);
    AppMethodBeat.o(43306);
  }
  
  private static void bYw()
  {
    AppMethodBeat.i(43307);
    k.bYF();
    k.bYI().AW(2);
    AppMethodBeat.o(43307);
  }
  
  public static int bYx()
  {
    AppMethodBeat.i(43311);
    k.bYF();
    k.bYI();
    int i = i.bYE();
    AppMethodBeat.o(43311);
    return i;
  }
  
  private static void c(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(43308);
    paramString = new o(paramInt1, paramInt2, paramInt3, paramString);
    g.RM();
    g.RK().eHt.a(paramString, 0);
    AppMethodBeat.o(43308);
  }
  
  public final void onChange()
  {
    AppMethodBeat.i(43304);
    if (this.pjT == null)
    {
      AppMethodBeat.o(43304);
      return;
    }
    int i = 0;
    while (i < this.pjT.size())
    {
      Object localObject = (WeakReference)this.pjT.get(i);
      if (localObject != null)
      {
        localObject = (b)((WeakReference)localObject).get();
        if (localObject != null) {
          ((b)localObject).bbx();
        }
      }
      i += 1;
    }
    AppMethodBeat.o(43304);
  }
  
  public final String t(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(43309);
    ab.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bo.dtY().toString() });
    paramString = u(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(43309);
    return paramString;
  }
  
  public final String u(int paramInt1, int paramInt2, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(43310);
    int j = bYx();
    Object localObject;
    if (j > 0)
    {
      if (j < k.pkP)
      {
        ab.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount < %s", new Object[] { Integer.valueOf(k.pkP) });
        bYw();
      }
      k.bYF();
      localObject = k.AY(196617);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        ab.e("MicroMsg.OfflineCodesMgr", "generateKey_V3 cn is null, the csr is not exist! cn:".concat(String.valueOf(localObject)));
        AppMethodBeat.o(43310);
        return "";
      }
      com.tencent.mm.wallet_core.c.b.dSi();
      localObject = com.tencent.mm.wallet_core.c.b.getToken((String)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        bYv();
        ab.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null");
        AppMethodBeat.o(43310);
        return "";
      }
    }
    else
    {
      paramString = h.qsU;
      if (com.tencent.mm.plugin.offline.c.a.eD(ah.getContext()))
      {
        paramInt1 = 0;
        paramInt2 = i;
        if (at.isNetworkConnected(ah.getContext())) {
          paramInt2 = 1;
        }
        paramString.e(14163, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        h.qsU.idkeyStat(135L, 29L, 1L, true);
        if (!at.isNetworkConnected(ah.getContext())) {
          break label249;
        }
        h.qsU.idkeyStat(135L, 31L, 1L, true);
      }
      for (;;)
      {
        bYv();
        ab.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount is 0");
        AppMethodBeat.o(43310);
        return "";
        paramInt1 = 1;
        break;
        label249:
        h.qsU.idkeyStat(135L, 30L, 1L, true);
      }
    }
    if (localObject != null) {
      ab.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code length : %s ext_business_attach %s %s", new Object[] { Integer.valueOf(((String)localObject).length()), paramString, localObject });
    }
    c(j - 1, paramInt1, paramInt2, paramString);
    ab.i("MicroMsg.OfflineCodesMgr", "doNetSceneShowCode count " + (j - 1));
    paramString = com.tencent.mm.plugin.offline.c.a.Wt(com.tencent.mm.plugin.offline.c.a.bZL());
    if ((paramString == null) || (paramString.size() == 0))
    {
      ab.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 cardList is null");
      bYv();
      AppMethodBeat.o(43310);
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
        break label481;
      }
      localObject = (a.a)paramString.get(paramInt1);
      if ((localObject == null) || (((a.a)localObject).por == null) || (!((a.a)localObject).por.equals(this.pjW))) {
        break label645;
      }
      l1 = ((a.a)localObject).pop;
    }
    label645:
    for (;;)
    {
      paramInt1 += 1;
      break;
      ab.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null or is not isNumeric");
      AppMethodBeat.o(43310);
      return "";
      label481:
      localObject = String.valueOf(l1 << 48 | l2);
      if (((String)localObject).length() == 15)
      {
        paramString = "0".concat(String.valueOf(localObject));
        if (TextUtils.isEmpty(com.tencent.mm.plugin.offline.c.a.bZN())) {
          break label631;
        }
      }
      label631:
      for (paramString = com.tencent.mm.plugin.offline.c.a.bZN() + paramString;; paramString = "12".concat(String.valueOf(paramString)))
      {
        AppMethodBeat.o(43310);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.e
 * JD-Core Version:    0.7.0.1
 */