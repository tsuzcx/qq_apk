package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.c.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends a<b>
{
  public String mJH = "";
  private i.a mJI = new e.1(this);
  
  public e()
  {
    k.bpX();
    if (k.bqa() != null)
    {
      k.bpX();
      k.bqa().mKl = this.mJI;
    }
  }
  
  private static void bpP()
  {
    k.bpX();
    k.bqa().dy(1, 1);
  }
  
  public static int bpQ()
  {
    k.bpX();
    k.bqa();
    return i.bpW();
  }
  
  public final void axs()
  {
    if (this.mJE == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mJE.size())
      {
        Object localObject = (WeakReference)this.mJE.get(i);
        if (localObject != null)
        {
          localObject = (b)((WeakReference)localObject).get();
          if (localObject != null) {
            ((b)localObject).azP();
          }
        }
        i += 1;
      }
    }
  }
  
  public final String o(int paramInt1, int paramInt2, String paramString)
  {
    int i = 0;
    int j = bpQ();
    Object localObject;
    if (j > 0)
    {
      if (j < k.mKA)
      {
        y.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount < %s", new Object[] { Integer.valueOf(k.mKA) });
        k.bpX();
        k.bqa().vz(2);
      }
      k.bpX();
      localObject = k.vA(196617);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        y.e("MicroMsg.OfflineCodesMgr", "generateKey_V3 cn is null, the csr is not exist! cn:" + (String)localObject);
        return "";
      }
      com.tencent.mm.wallet_core.c.a.cMr();
      localObject = com.tencent.mm.wallet_core.c.a.getToken((String)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        bpP();
        y.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null");
        return "";
      }
    }
    else
    {
      paramString = h.nFQ;
      if (com.tencent.mm.plugin.offline.c.a.dR(ae.getContext()))
      {
        paramInt1 = 0;
        paramInt2 = i;
        if (aq.isNetworkConnected(ae.getContext())) {
          paramInt2 = 1;
        }
        paramString.f(14163, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        h.nFQ.a(135L, 29L, 1L, true);
        if (!aq.isNetworkConnected(ae.getContext())) {
          break label244;
        }
        h.nFQ.a(135L, 31L, 1L, true);
      }
      for (;;)
      {
        bpP();
        y.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount is 0");
        return "";
        paramInt1 = 1;
        break;
        label244:
        h.nFQ.a(135L, 30L, 1L, true);
      }
    }
    if (localObject != null) {
      y.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code length : %s ext_business_attach %s %s", new Object[] { Integer.valueOf(((String)localObject).length()), paramString, localObject });
    }
    paramString = new o(j - 1, paramInt1, paramInt2, paramString);
    g.DQ();
    g.DO().dJT.a(paramString, 0);
    y.i("MicroMsg.OfflineCodesMgr", "doNetSceneShowCode count " + (j - 1));
    paramString = com.tencent.mm.plugin.offline.c.a.Kr(com.tencent.mm.plugin.offline.c.a.bqW());
    if ((paramString == null) || (paramString.size() == 0))
    {
      y.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 cardList is null");
      bpP();
      return "";
    }
    long l2;
    long l1;
    if ((localObject != null) && (com.tencent.mm.plugin.offline.c.a.yS((String)localObject)))
    {
      l2 = Long.valueOf((String)localObject, 10).longValue();
      l1 = 0L;
      paramInt1 = 0;
      if (paramInt1 >= paramString.size()) {
        break label485;
      }
      localObject = (a.a)paramString.get(paramInt1);
      if ((localObject == null) || (((a.a)localObject).mOc == null) || (!((a.a)localObject).mOc.equals(this.mJH))) {
        break label674;
      }
      l1 = ((a.a)localObject).mOa;
    }
    label674:
    for (;;)
    {
      paramInt1 += 1;
      break;
      y.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null or is not isNumeric");
      return "";
      label485:
      localObject = String.valueOf(l1 << 48 | l2);
      if (((String)localObject).length() == 15) {
        paramString = "0" + (String)localObject;
      }
      while (!TextUtils.isEmpty(com.tencent.mm.plugin.offline.c.a.bqY()))
      {
        return com.tencent.mm.plugin.offline.c.a.bqY() + paramString;
        if (((String)localObject).length() == 14)
        {
          paramString = "00" + (String)localObject;
        }
        else if (((String)localObject).length() == 13)
        {
          paramString = "000" + (String)localObject;
        }
        else
        {
          paramString = (String)localObject;
          if (((String)localObject).length() == 12) {
            paramString = "0000" + (String)localObject;
          }
        }
      }
      return "12" + paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.e
 * JD-Core Version:    0.7.0.1
 */