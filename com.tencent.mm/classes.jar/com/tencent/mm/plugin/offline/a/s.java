package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class s
{
  private List<WeakReference<a>> nqa;
  public ArrayList<Long> uhy;
  public b ukv;
  private HashSet<String> ukw;
  
  public s()
  {
    AppMethodBeat.i(66322);
    this.nqa = new ArrayList();
    this.ukv = null;
    this.uhy = new ArrayList();
    this.ukw = new HashSet();
    Object localObject = com.tencent.mm.plugin.offline.c.a.cZs();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bw.K((String)localObject, "sysmsg");
      if (localObject != null)
      {
        int i = bt.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
        if ((i >= 0) && (i == 4))
        {
          ad.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
          b(ah((Map)localObject));
        }
      }
    }
    this.uhy.clear();
    AppMethodBeat.o(66322);
  }
  
  private d ag(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66327);
    d locald = new d();
    locald.ukC = bt.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locald.dlJ = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(66327);
    return locald;
  }
  
  private b ah(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66328);
    if (this.ukv == null) {
      this.ukv = new b();
    }
    this.ukv.ukC = bt.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    this.ukv.ukz = ((String)paramMap.get(".sysmsg.paymsg.isfreeze"));
    this.ukv.ukA = ((String)paramMap.get(".sysmsg.paymsg.freezetype"));
    this.ukv.ukB = ((String)paramMap.get(".sysmsg.paymsg.freezemsg"));
    paramMap = this.ukv;
    AppMethodBeat.o(66328);
    return paramMap;
  }
  
  private e ai(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66329);
    e locale = new e();
    locale.ukC = bt.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locale.ukD = ((String)paramMap.get(".sysmsg.paymsg.cftretcode"));
    locale.ukE = ((String)paramMap.get(".sysmsg.paymsg.cftretmsg"));
    locale.ukF = ((String)paramMap.get(".sysmsg.paymsg.wxretcode"));
    locale.ukG = ((String)paramMap.get(".sysmsg.paymsg.wxretmsg"));
    locale.ukH = ((String)paramMap.get(".sysmsg.paymsg.error_detail_url"));
    locale.ukI = true;
    AppMethodBeat.o(66329);
    return locale;
  }
  
  private f aj(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66330);
    f localf = new f();
    localf.ukC = bt.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localf.ukJ = ((String)paramMap.get(".sysmsg.paymsg.transid"));
    localf.ukK = com.tencent.mm.plugin.offline.c.a.am(paramMap);
    if (localf.ukK.Afx.size() > 0) {
      com.tencent.mm.plugin.offline.c.a.ajV(((Orders.Commodity)localf.ukK.Afx.get(0)).dcF);
    }
    if (paramMap.containsKey(".sysmsg.paymsg.real_name_info")) {
      localf.dDs = new h(paramMap);
    }
    AppMethodBeat.o(66330);
    return localf;
  }
  
  private d ak(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66331);
    d locald = new d();
    locald.ukC = bt.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locald.dlJ = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(66331);
    return locald;
  }
  
  private g al(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66332);
    g localg = new g();
    localg.ukC = bt.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localg.ukL = ((String)paramMap.get(".sysmsg.paymsg.good_name"));
    localg.ukM = ((String)paramMap.get(".sysmsg.paymsg.total_fee"));
    localg.dlJ = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    localg.id = ((String)paramMap.get(".sysmsg.paymsg.id"));
    paramMap = (String)paramMap.get(".sysmsg.paymsg.confirm_type");
    ad.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + localg.ocN);
    if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals("1"))) {}
    for (localg.ocN = 1;; localg.ocN = 0)
    {
      AppMethodBeat.o(66332);
      return localg;
    }
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(66323);
    if (this.nqa == null)
    {
      AppMethodBeat.o(66323);
      return;
    }
    int i = 0;
    while (i < this.nqa.size())
    {
      Object localObject = (WeakReference)this.nqa.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if ((localObject != null) && (((a)localObject).a(paramc))) {
          break;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(66323);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(66324);
    if (this.nqa == null) {
      this.nqa = new ArrayList();
    }
    this.nqa.add(new WeakReference(parama));
    AppMethodBeat.o(66324);
  }
  
  public final void ajD(String arg1)
  {
    AppMethodBeat.i(66326);
    com.tencent.mm.plugin.offline.c.a.ajT("");
    com.tencent.mm.plugin.offline.c.a.ajV("");
    com.tencent.mm.plugin.offline.c.a.ajU("");
    Object localObject = bw.K(???, "sysmsg");
    if (localObject == null)
    {
      AppMethodBeat.o(66326);
      return;
    }
    int j = bt.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    int i = bt.getInt((String)((Map)localObject).get(".sysmsg.paymsg.pay_cmd"), -1);
    String str = (String)((Map)localObject).get(".sysmsg.paymsg.req_key");
    com.tencent.mm.plugin.offline.c.a.ajT((String)((Map)localObject).get(".sysmsg.paymsg.ack_key"));
    com.tencent.mm.plugin.offline.c.a.IQ(j);
    com.tencent.mm.plugin.offline.c.a.ajU(str);
    j = bt.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    ad.i("MicroMsg.WalletOfflineMsgManager", "msg type is ".concat(String.valueOf(j)));
    ad.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", new Object[] { Integer.valueOf(j), ??? });
    if ((j >= 0) && (j == 4))
    {
      b(ah((Map)localObject));
      com.tencent.mm.plugin.offline.c.a.ajK(???);
      AppMethodBeat.o(66326);
      return;
    }
    if ((j >= 0) && (j == 5))
    {
      if (i != 1) {
        break label639;
      }
      ad.i("MicroMsg.WalletOfflineMsgManager", "payCmd is PAY_CMD_OFFLINE_PAY_REFRESH_TOKEN (value is 1), refresh offline token");
      k.cYr();
      k.cYu().gt(4, 4);
    }
    label639:
    for (boolean bool = false;; bool = true)
    {
      ??? = ai((Map)localObject);
      ???.ukI = bool;
      b(???);
      AppMethodBeat.o(66326);
      return;
      if ((j >= 0) && (j == 6))
      {
        str = (String)((Map)localObject).get(".sysmsg.paymsg.transid");
        ad.i("helios", "MSG_TYPE_ORDER trasid=".concat(String.valueOf(str)));
        if (!bt.isNullOrNil(str))
        {
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fme, Boolean.TRUE);
        }
        ad.i("MicroMsg.WalletOfflineMsgManager", "orders xml: %s", new Object[] { ??? });
        b(aj((Map)localObject));
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 7))
      {
        com.tencent.mm.plugin.wallet_core.model.s.ecc().VP();
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 8))
      {
        b(al((Map)localObject));
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 10))
      {
        k.cYr();
        k.cYu().gt(4, 4);
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 20))
      {
        ??? = new xh();
        ???.dDr.dDs = new h((Map)localObject);
        com.tencent.mm.sdk.b.a.ESL.l(???);
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 23))
      {
        localObject = ak((Map)localObject);
        synchronized (this.ukw)
        {
          if (this.ukw.contains(((d)localObject).dlJ))
          {
            ad.i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", new Object[] { ((d)localObject).dlJ });
            AppMethodBeat.o(66326);
            return;
          }
          this.ukw.add(((d)localObject).dlJ);
          b((c)localObject);
          AppMethodBeat.o(66326);
          return;
        }
      }
      if ((j >= 0) && (j == 24))
      {
        b(ag(localMap));
        AppMethodBeat.o(66326);
        return;
      }
      AppMethodBeat.o(66326);
      return;
    }
  }
  
  public final void ajE(String paramString)
  {
    AppMethodBeat.i(66333);
    int i = bt.getInt((String)bw.K(paramString, "sysmsg").get(".sysmsg.paymsg.PayMsgType"), -1);
    paramString = new HashSet();
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.uiM));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.uiL));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.uiN));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.uiK));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.uiH));
    if (paramString.contains(Integer.valueOf(i))) {
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66320);
          ad.v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(new b(this.ukx), 0);
          AppMethodBeat.o(66320);
        }
      });
    }
    AppMethodBeat.o(66333);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(66325);
    if (this.nqa == null)
    {
      AppMethodBeat.o(66325);
      return;
    }
    int i = 0;
    while (i < this.nqa.size())
    {
      WeakReference localWeakReference = (WeakReference)this.nqa.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.nqa.remove(localWeakReference);
          AppMethodBeat.o(66325);
          return;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(66325);
  }
  
  public static abstract interface a
  {
    public abstract boolean a(s.c paramc);
  }
  
  public final class b
    extends s.c
  {
    public String ukA;
    public String ukB;
    public String ukz;
    
    public b()
    {
      super();
    }
  }
  
  public class c
  {
    public int ukC;
    
    public c() {}
  }
  
  public final class d
    extends s.c
  {
    public String dlJ;
    
    public d()
    {
      super();
    }
  }
  
  public final class e
    extends s.c
  {
    public String ukD;
    public String ukE;
    public String ukF;
    public String ukG;
    public String ukH;
    public boolean ukI = true;
    
    public e()
    {
      super();
    }
  }
  
  public final class f
    extends s.c
  {
    public s.h dDs;
    public String ukJ;
    public Orders ukK;
    
    public f()
    {
      super();
    }
  }
  
  public final class g
    extends s.c
  {
    public String dlJ;
    public String id;
    public int ocN;
    public String ukL;
    public String ukM;
    
    public g()
    {
      super();
    }
  }
  
  public final class h
  {
    public String dCT;
    public String dCU;
    public String dCV;
    public String dCW;
    public String dCX;
    public boolean ukN;
    
    public h()
    {
      AppMethodBeat.i(66321);
      Object localObject;
      this.dCT = ((String)localObject.get(".sysmsg.paymsg.guide_flag"));
      this.dCU = ((String)localObject.get(".sysmsg.paymsg.guide_wording"));
      this.dCV = ((String)localObject.get(".sysmsg.paymsg.left_button_wording"));
      this.dCW = ((String)localObject.get(".sysmsg.paymsg.right_button_wording"));
      this.dCX = ((String)localObject.get(".sysmsg.paymsg.upload_credit_url"));
      if ("1".equals(localObject.get(".sysmsg.paymsg.guide_block"))) {}
      for (boolean bool = true;; bool = false)
      {
        this.ukN = bool;
        AppMethodBeat.o(66321);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.s
 * JD-Core Version:    0.7.0.1
 */