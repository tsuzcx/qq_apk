package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vh;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
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
  private List<WeakReference<s.a>> kkV;
  public ArrayList<Long> piV;
  public s.b plP;
  private HashSet<String> plQ;
  
  public s()
  {
    AppMethodBeat.i(43423);
    this.kkV = new ArrayList();
    this.plP = null;
    this.piV = new ArrayList();
    this.plQ = new HashSet();
    Object localObject = com.tencent.mm.plugin.offline.c.a.bZG();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = br.F((String)localObject, "sysmsg");
      if (localObject != null)
      {
        int i = bo.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
        if ((i >= 0) && (i == 4))
        {
          ab.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
          b(O((Map)localObject));
        }
      }
    }
    this.piV.clear();
    AppMethodBeat.o(43423);
  }
  
  private s.d N(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43428);
    s.d locald = new s.d(this);
    locald.plW = bo.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locald.cwk = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(43428);
    return locald;
  }
  
  private s.b O(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43429);
    if (this.plP == null) {
      this.plP = new s.b(this);
    }
    this.plP.plW = bo.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    this.plP.plT = ((String)paramMap.get(".sysmsg.paymsg.isfreeze"));
    this.plP.plU = ((String)paramMap.get(".sysmsg.paymsg.freezetype"));
    this.plP.plV = ((String)paramMap.get(".sysmsg.paymsg.freezemsg"));
    paramMap = this.plP;
    AppMethodBeat.o(43429);
    return paramMap;
  }
  
  private s.e P(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43430);
    s.e locale = new s.e(this);
    locale.plW = bo.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locale.plX = ((String)paramMap.get(".sysmsg.paymsg.cftretcode"));
    locale.plY = ((String)paramMap.get(".sysmsg.paymsg.cftretmsg"));
    locale.plZ = ((String)paramMap.get(".sysmsg.paymsg.wxretcode"));
    locale.pma = ((String)paramMap.get(".sysmsg.paymsg.wxretmsg"));
    locale.pmb = ((String)paramMap.get(".sysmsg.paymsg.error_detail_url"));
    locale.pmc = true;
    AppMethodBeat.o(43430);
    return locale;
  }
  
  private s.f Q(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43431);
    s.f localf = new s.f(this);
    localf.plW = bo.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localf.pmd = ((String)paramMap.get(".sysmsg.paymsg.transid"));
    localf.pme = com.tencent.mm.plugin.offline.c.a.T(paramMap);
    if (localf.pme.ujl.size() > 0) {
      com.tencent.mm.plugin.offline.c.a.WB(((Orders.Commodity)localf.pme.ujl.get(0)).cnJ);
    }
    if (paramMap.containsKey(".sysmsg.paymsg.real_name_info")) {
      localf.cMu = new h(paramMap);
    }
    AppMethodBeat.o(43431);
    return localf;
  }
  
  private s.d R(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43432);
    s.d locald = new s.d(this);
    locald.plW = bo.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locald.cwk = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(43432);
    return locald;
  }
  
  private s.g S(Map<String, String> paramMap)
  {
    AppMethodBeat.i(43433);
    s.g localg = new s.g(this);
    localg.plW = bo.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localg.pmf = ((String)paramMap.get(".sysmsg.paymsg.good_name"));
    localg.pmg = ((String)paramMap.get(".sysmsg.paymsg.total_fee"));
    localg.cwk = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    localg.id = ((String)paramMap.get(".sysmsg.paymsg.id"));
    paramMap = (String)paramMap.get(".sysmsg.paymsg.confirm_type");
    ab.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + localg.kWb);
    if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals("1"))) {}
    for (localg.kWb = 1;; localg.kWb = 0)
    {
      AppMethodBeat.o(43433);
      return localg;
    }
  }
  
  private void b(s.c paramc)
  {
    AppMethodBeat.i(43424);
    if (this.kkV == null)
    {
      AppMethodBeat.o(43424);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      Object localObject = (WeakReference)this.kkV.get(i);
      if (localObject != null)
      {
        localObject = (s.a)((WeakReference)localObject).get();
        if ((localObject != null) && (((s.a)localObject).a(paramc))) {
          break;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(43424);
  }
  
  public final void Wj(String arg1)
  {
    AppMethodBeat.i(43427);
    com.tencent.mm.plugin.offline.c.a.Wz("");
    com.tencent.mm.plugin.offline.c.a.WB("");
    com.tencent.mm.plugin.offline.c.a.WA("");
    Object localObject = br.F(???, "sysmsg");
    if (localObject == null)
    {
      AppMethodBeat.o(43427);
      return;
    }
    int j = bo.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    int i = bo.getInt((String)((Map)localObject).get(".sysmsg.paymsg.pay_cmd"), -1);
    String str = (String)((Map)localObject).get(".sysmsg.paymsg.req_key");
    com.tencent.mm.plugin.offline.c.a.Wz((String)((Map)localObject).get(".sysmsg.paymsg.ack_key"));
    com.tencent.mm.plugin.offline.c.a.Bf(j);
    com.tencent.mm.plugin.offline.c.a.WA(str);
    j = bo.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    ab.i("MicroMsg.WalletOfflineMsgManager", "msg type is ".concat(String.valueOf(j)));
    ab.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", new Object[] { Integer.valueOf(j), ??? });
    if ((j >= 0) && (j == 4))
    {
      b(O((Map)localObject));
      com.tencent.mm.plugin.offline.c.a.Wq(???);
      AppMethodBeat.o(43427);
      return;
    }
    if ((j >= 0) && (j == 5))
    {
      if (i != 1) {
        break label639;
      }
      ab.i("MicroMsg.WalletOfflineMsgManager", "payCmd is PAY_CMD_OFFLINE_PAY_REFRESH_TOKEN (value is 1), refresh offline token");
      k.bYF();
      k.bYI().eX(4, 4);
    }
    label639:
    for (boolean bool = false;; bool = true)
    {
      ??? = P((Map)localObject);
      ???.pmc = bool;
      b(???);
      AppMethodBeat.o(43427);
      return;
      if ((j >= 0) && (j == 6))
      {
        str = (String)((Map)localObject).get(".sysmsg.paymsg.transid");
        ab.i("helios", "MSG_TYPE_ORDER trasid=".concat(String.valueOf(str)));
        if (!bo.isNullOrNil(str))
        {
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yDG, Boolean.TRUE);
        }
        ab.i("MicroMsg.WalletOfflineMsgManager", "orders xml: %s", new Object[] { ??? });
        b(Q((Map)localObject));
        AppMethodBeat.o(43427);
        return;
      }
      if ((j >= 0) && (j == 7))
      {
        t.cTN().Kg();
        AppMethodBeat.o(43427);
        return;
      }
      if ((j >= 0) && (j == 8))
      {
        b(S((Map)localObject));
        AppMethodBeat.o(43427);
        return;
      }
      if ((j >= 0) && (j == 10))
      {
        k.bYF();
        k.bYI().eX(4, 4);
        AppMethodBeat.o(43427);
        return;
      }
      if ((j >= 0) && (j == 20))
      {
        ??? = new vh();
        ???.cMt.cMu = new h((Map)localObject);
        com.tencent.mm.sdk.b.a.ymk.l(???);
        AppMethodBeat.o(43427);
        return;
      }
      if ((j >= 0) && (j == 23))
      {
        localObject = R((Map)localObject);
        synchronized (this.plQ)
        {
          if (this.plQ.contains(((s.d)localObject).cwk))
          {
            ab.i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", new Object[] { ((s.d)localObject).cwk });
            AppMethodBeat.o(43427);
            return;
          }
          this.plQ.add(((s.d)localObject).cwk);
          b((s.c)localObject);
          AppMethodBeat.o(43427);
          return;
        }
      }
      if ((j >= 0) && (j == 24))
      {
        b(N(localMap));
        AppMethodBeat.o(43427);
        return;
      }
      AppMethodBeat.o(43427);
      return;
    }
  }
  
  public final void Wk(String paramString)
  {
    AppMethodBeat.i(43434);
    int i = bo.getInt((String)br.F(paramString, "sysmsg").get(".sysmsg.paymsg.PayMsgType"), -1);
    paramString = new HashSet();
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.pki));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.pkh));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.pkj));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.pkg));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.pkd));
    if (paramString.contains(Integer.valueOf(i))) {
      com.tencent.mm.kernel.g.RO().ac(new s.1(this));
    }
    AppMethodBeat.o(43434);
  }
  
  public final void a(s.a parama)
  {
    AppMethodBeat.i(43425);
    if (this.kkV == null) {
      this.kkV = new ArrayList();
    }
    this.kkV.add(new WeakReference(parama));
    AppMethodBeat.o(43425);
  }
  
  public final void b(s.a parama)
  {
    AppMethodBeat.i(43426);
    if (this.kkV == null)
    {
      AppMethodBeat.o(43426);
      return;
    }
    int i = 0;
    while (i < this.kkV.size())
    {
      WeakReference localWeakReference = (WeakReference)this.kkV.get(i);
      if (localWeakReference != null)
      {
        s.a locala = (s.a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.kkV.remove(localWeakReference);
          AppMethodBeat.o(43426);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(43426);
  }
  
  public final class h
  {
    public String cLV;
    public String cLW;
    public String cLX;
    public String cLY;
    public String cLZ;
    public boolean pmh;
    
    public h()
    {
      AppMethodBeat.i(43422);
      Object localObject;
      this.cLV = ((String)localObject.get(".sysmsg.paymsg.guide_flag"));
      this.cLW = ((String)localObject.get(".sysmsg.paymsg.guide_wording"));
      this.cLX = ((String)localObject.get(".sysmsg.paymsg.left_button_wording"));
      this.cLY = ((String)localObject.get(".sysmsg.paymsg.right_button_wording"));
      this.cLZ = ((String)localObject.get(".sysmsg.paymsg.upload_credit_url"));
      if ("1".equals(localObject.get(".sysmsg.paymsg.guide_block"))) {}
      for (boolean bool = true;; bool = false)
      {
        this.pmh = bool;
        AppMethodBeat.o(43422);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.s
 * JD-Core Version:    0.7.0.1
 */