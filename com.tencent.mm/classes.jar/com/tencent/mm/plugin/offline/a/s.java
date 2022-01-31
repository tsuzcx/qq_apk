package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.h.a.tm;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class s
{
  private List<WeakReference<s.a>> fKm = new ArrayList();
  public ArrayList<Long> mIG = new ArrayList();
  public s.b mLy = null;
  private HashSet<String> mLz = new HashSet();
  
  public s()
  {
    Object localObject = com.tencent.mm.plugin.offline.c.a.bqQ();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bn.s((String)localObject, "sysmsg");
      if (localObject != null)
      {
        int i = bk.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
        if ((i >= 0) && (i == 4))
        {
          y.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
          b(E((Map)localObject));
        }
      }
    }
    this.mIG.clear();
  }
  
  private s.b E(Map<String, String> paramMap)
  {
    if (this.mLy == null) {
      this.mLy = new s.b(this);
    }
    this.mLy.mLF = bk.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    this.mLy.mLC = ((String)paramMap.get(".sysmsg.paymsg.isfreeze"));
    this.mLy.mLD = ((String)paramMap.get(".sysmsg.paymsg.freezetype"));
    this.mLy.mLE = ((String)paramMap.get(".sysmsg.paymsg.freezemsg"));
    return this.mLy;
  }
  
  private void b(s.c paramc)
  {
    if (this.fKm == null) {}
    label68:
    for (;;)
    {
      return;
      int i = 0;
      for (;;)
      {
        if (i >= this.fKm.size()) {
          break label68;
        }
        Object localObject = (WeakReference)this.fKm.get(i);
        if (localObject != null)
        {
          localObject = (s.a)((WeakReference)localObject).get();
          if ((localObject != null) && (((s.a)localObject).a(paramc))) {
            break;
          }
        }
        i += 1;
      }
    }
  }
  
  public final void Kk(String paramString)
  {
    com.tencent.mm.plugin.offline.c.a.Kx("");
    com.tencent.mm.plugin.offline.c.a.Kz("");
    com.tencent.mm.plugin.offline.c.a.Ky("");
    ??? = bn.s(paramString, "sysmsg");
    if (??? == null) {
      return;
    }
    int j = bk.getInt((String)((Map)???).get(".sysmsg.paymsg.PayMsgType"), -1);
    int i = bk.getInt((String)((Map)???).get(".sysmsg.paymsg.pay_cmd"), -1);
    String str = (String)((Map)???).get(".sysmsg.paymsg.req_key");
    com.tencent.mm.plugin.offline.c.a.Kx((String)((Map)???).get(".sysmsg.paymsg.ack_key"));
    com.tencent.mm.plugin.offline.c.a.vH(j);
    com.tencent.mm.plugin.offline.c.a.Ky(str);
    j = bk.getInt((String)((Map)???).get(".sysmsg.paymsg.PayMsgType"), -1);
    y.i("MicroMsg.WalletOfflineMsgManager", "msg type is " + j);
    y.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", new Object[] { Integer.valueOf(j), paramString });
    if ((j >= 0) && (j == 4))
    {
      b(E((Map)???));
      com.tencent.mm.plugin.offline.c.a.Ko(paramString);
      return;
    }
    if ((j >= 0) && (j == 5))
    {
      if (i != 1) {
        break label1019;
      }
      y.i("MicroMsg.WalletOfflineMsgManager", "payCmd is PAY_CMD_OFFLINE_PAY_REFRESH_TOKEN (value is 1), refresh offline token");
      k.bpX();
      k.bqa().dx(4, 4);
    }
    label1019:
    for (boolean bool = false;; bool = true)
    {
      paramString = new s.e(this);
      paramString.mLF = bk.getInt((String)((Map)???).get(".sysmsg.paymsg.PayMsgType"), -1);
      paramString.mLG = ((String)((Map)???).get(".sysmsg.paymsg.cftretcode"));
      paramString.mLH = ((String)((Map)???).get(".sysmsg.paymsg.cftretmsg"));
      paramString.mLI = ((String)((Map)???).get(".sysmsg.paymsg.wxretcode"));
      paramString.mLJ = ((String)((Map)???).get(".sysmsg.paymsg.wxretmsg"));
      paramString.mLK = ((String)((Map)???).get(".sysmsg.paymsg.error_detail_url"));
      paramString.mLL = true;
      paramString.mLL = bool;
      b(paramString);
      return;
      if ((j >= 0) && (j == 6))
      {
        str = (String)((Map)???).get(".sysmsg.paymsg.transid");
        y.i("helios", "MSG_TYPE_ORDER trasid=" + str);
        if (!bk.bl(str))
        {
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.utD, Boolean.valueOf(true));
        }
        y.i("MicroMsg.WalletOfflineMsgManager", "orders xml: %s", new Object[] { paramString });
        paramString = new s.f(this);
        paramString.mLF = bk.getInt((String)((Map)???).get(".sysmsg.paymsg.PayMsgType"), -1);
        paramString.mLM = ((String)((Map)???).get(".sysmsg.paymsg.transid"));
        paramString.mLN = com.tencent.mm.plugin.offline.c.a.F((Map)???);
        if (paramString.mLN.qwN.size() > 0) {
          com.tencent.mm.plugin.offline.c.a.Kz(((Orders.Commodity)paramString.mLN.qwN.get(0)).bMY);
        }
        if (((Map)???).containsKey(".sysmsg.paymsg.real_name_info")) {
          paramString.cdK = new s.h(this, (Map)???);
        }
        b(paramString);
        return;
      }
      if ((j >= 0) && (j == 7))
      {
        o.bVs().xO();
        return;
      }
      if ((j >= 0) && (j == 8))
      {
        paramString = new s.g(this);
        paramString.mLF = bk.getInt((String)((Map)???).get(".sysmsg.paymsg.PayMsgType"), -1);
        paramString.mLO = ((String)((Map)???).get(".sysmsg.paymsg.good_name"));
        paramString.mLP = ((String)((Map)???).get(".sysmsg.paymsg.total_fee"));
        paramString.bOT = ((String)((Map)???).get(".sysmsg.paymsg.req_key"));
        paramString.id = ((String)((Map)???).get(".sysmsg.paymsg.id"));
        ??? = (String)((Map)???).get(".sysmsg.paymsg.confirm_type");
        y.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + paramString.mLQ);
        if ((!TextUtils.isEmpty((CharSequence)???)) && (((String)???).equals("1"))) {}
        for (paramString.mLQ = 1;; paramString.mLQ = 0)
        {
          b(paramString);
          return;
        }
      }
      if ((j >= 0) && (j == 10))
      {
        k.bpX();
        k.bqa().dx(4, 4);
        return;
      }
      if ((j >= 0) && (j == 20))
      {
        paramString = new tm();
        paramString.cdJ.cdK = new s.h(this, (Map)???);
        com.tencent.mm.sdk.b.a.udP.m(paramString);
        return;
      }
      if ((j >= 0) && (j == 23))
      {
        paramString = new s.d(this);
        paramString.mLF = bk.getInt((String)((Map)???).get(".sysmsg.paymsg.PayMsgType"), -1);
        paramString.bOT = ((String)((Map)???).get(".sysmsg.paymsg.req_key"));
        synchronized (this.mLz)
        {
          if (this.mLz.contains(paramString.bOT))
          {
            y.i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", new Object[] { paramString.bOT });
            return;
          }
        }
        this.mLz.add(paramString.bOT);
        b(paramString);
        return;
      }
      if ((j < 0) || (j != 24)) {
        break;
      }
      paramString = new s.d(this);
      paramString.mLF = bk.getInt((String)((Map)???).get(".sysmsg.paymsg.PayMsgType"), -1);
      paramString.bOT = ((String)((Map)???).get(".sysmsg.paymsg.req_key"));
      b(paramString);
      return;
    }
  }
  
  public final void Kl(String paramString)
  {
    int i = bk.getInt((String)bn.s(paramString, "sysmsg").get(".sysmsg.paymsg.PayMsgType"), -1);
    paramString = new HashSet();
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.mJT));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.mJS));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.mJU));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.mJR));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.mJO));
    if (paramString.contains(Integer.valueOf(i))) {
      com.tencent.mm.kernel.g.DS().O(new s.1(this));
    }
  }
  
  public final void a(s.a parama)
  {
    if (this.fKm == null) {
      this.fKm = new ArrayList();
    }
    if (parama != null) {
      this.fKm.add(new WeakReference(parama));
    }
  }
  
  public final void b(s.a parama)
  {
    if ((this.fKm == null) || (parama == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.fKm.size())
      {
        WeakReference localWeakReference = (WeakReference)this.fKm.get(i);
        if (localWeakReference != null)
        {
          s.a locala = (s.a)localWeakReference.get();
          if ((locala != null) && (locala.equals(parama)))
          {
            this.fKm.remove(localWeakReference);
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  public final boolean fr(long paramLong)
  {
    if ((this.mIG == null) || (this.mIG.size() == 0)) {
      y.e("MicroMsg.WalletOfflineMsgManager", "mMsgIdList is null or size == 0");
    }
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.mIG.size())
      {
        if (((Long)this.mIG.get(i)).longValue() == paramLong) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.s
 * JD-Core Version:    0.7.0.1
 */