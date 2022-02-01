package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class s
{
  private List<WeakReference<a>> oCX;
  public ArrayList<Long> wLz;
  public b wOu;
  private HashSet<String> wOv;
  
  public s()
  {
    AppMethodBeat.i(66322);
    this.oCX = new ArrayList();
    this.wOu = null;
    this.wLz = new ArrayList();
    this.wOv = new HashSet();
    Object localObject = com.tencent.mm.plugin.offline.c.a.dAI();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bx.M((String)localObject, "sysmsg");
      if (localObject != null)
      {
        int i = bu.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
        if ((i >= 0) && (i == 4))
        {
          ae.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
          b(au((Map)localObject));
        }
      }
    }
    this.wLz.clear();
    AppMethodBeat.o(66322);
  }
  
  private d at(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66327);
    d locald = new d();
    locald.wOB = bu.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locald.dwj = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(66327);
    return locald;
  }
  
  private b au(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66328);
    if (this.wOu == null) {
      this.wOu = new b();
    }
    this.wOu.wOB = bu.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    this.wOu.wOy = ((String)paramMap.get(".sysmsg.paymsg.isfreeze"));
    this.wOu.wOz = ((String)paramMap.get(".sysmsg.paymsg.freezetype"));
    this.wOu.wOA = ((String)paramMap.get(".sysmsg.paymsg.freezemsg"));
    paramMap = this.wOu;
    AppMethodBeat.o(66328);
    return paramMap;
  }
  
  private e av(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66329);
    e locale = new e();
    locale.wOB = bu.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locale.wOC = ((String)paramMap.get(".sysmsg.paymsg.cftretcode"));
    locale.wOD = ((String)paramMap.get(".sysmsg.paymsg.cftretmsg"));
    locale.wOE = ((String)paramMap.get(".sysmsg.paymsg.wxretcode"));
    locale.wOF = ((String)paramMap.get(".sysmsg.paymsg.wxretmsg"));
    locale.wOG = ((String)paramMap.get(".sysmsg.paymsg.error_detail_url"));
    locale.wOH = true;
    AppMethodBeat.o(66329);
    return locale;
  }
  
  private f aw(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66330);
    f localf = new f();
    localf.wOB = bu.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localf.wOI = ((String)paramMap.get(".sysmsg.paymsg.transid"));
    localf.wOJ = com.tencent.mm.plugin.offline.c.a.az(paramMap);
    if (localf.wOJ.DpP.size() > 0) {
      com.tencent.mm.plugin.offline.c.a.avi(((Orders.Commodity)localf.wOJ.DpP.get(0)).dmx);
    }
    if (paramMap.containsKey(".sysmsg.paymsg.real_name_info")) {
      localf.dOH = new h(paramMap);
    }
    AppMethodBeat.o(66330);
    return localf;
  }
  
  private d ax(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66331);
    d locald = new d();
    locald.wOB = bu.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locald.dwj = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(66331);
    return locald;
  }
  
  private g ay(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66332);
    g localg = new g();
    localg.wOB = bu.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localg.wOK = ((String)paramMap.get(".sysmsg.paymsg.good_name"));
    localg.wOL = ((String)paramMap.get(".sysmsg.paymsg.total_fee"));
    localg.dwj = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    localg.id = ((String)paramMap.get(".sysmsg.paymsg.id"));
    paramMap = (String)paramMap.get(".sysmsg.paymsg.confirm_type");
    ae.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + localg.pqv);
    if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals("1"))) {}
    for (localg.pqv = 1;; localg.pqv = 0)
    {
      AppMethodBeat.o(66332);
      return localg;
    }
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(66323);
    if (this.oCX == null)
    {
      AppMethodBeat.o(66323);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      Object localObject = (WeakReference)this.oCX.get(i);
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
    if (this.oCX == null) {
      this.oCX = new ArrayList();
    }
    this.oCX.add(new WeakReference(parama));
    AppMethodBeat.o(66324);
  }
  
  public final void auQ(String arg1)
  {
    AppMethodBeat.i(66326);
    com.tencent.mm.plugin.offline.c.a.avg("");
    com.tencent.mm.plugin.offline.c.a.avi("");
    com.tencent.mm.plugin.offline.c.a.avh("");
    Object localObject = bx.M(???, "sysmsg");
    if (localObject == null)
    {
      AppMethodBeat.o(66326);
      return;
    }
    int j = bu.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    int i = bu.getInt((String)((Map)localObject).get(".sysmsg.paymsg.pay_cmd"), -1);
    String str = (String)((Map)localObject).get(".sysmsg.paymsg.req_key");
    com.tencent.mm.plugin.offline.c.a.avg((String)((Map)localObject).get(".sysmsg.paymsg.ack_key"));
    com.tencent.mm.plugin.offline.c.a.MW(j);
    com.tencent.mm.plugin.offline.c.a.avh(str);
    j = bu.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    ae.i("MicroMsg.WalletOfflineMsgManager", "msg type is ".concat(String.valueOf(j)));
    ae.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", new Object[] { Integer.valueOf(j), ??? });
    if ((j >= 0) && (j == 4))
    {
      b(au((Map)localObject));
      com.tencent.mm.plugin.offline.c.a.auX(???);
      AppMethodBeat.o(66326);
      return;
    }
    if ((j >= 0) && (j == 5))
    {
      if (i != 1) {
        break label639;
      }
      ae.i("MicroMsg.WalletOfflineMsgManager", "payCmd is PAY_CMD_OFFLINE_PAY_REFRESH_TOKEN (value is 1), refresh offline token");
      k.dzG();
      k.dzJ().gT(4, 4);
    }
    label639:
    for (boolean bool = false;; bool = true)
    {
      ??? = av((Map)localObject);
      ???.wOH = bool;
      b(???);
      AppMethodBeat.o(66326);
      return;
      if ((j >= 0) && (j == 6))
      {
        str = (String)((Map)localObject).get(".sysmsg.paymsg.transid");
        ae.i("helios", "MSG_TYPE_ORDER trasid=".concat(String.valueOf(str)));
        if (!bu.isNullOrNil(str))
        {
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IQJ, Boolean.TRUE);
        }
        ae.i("MicroMsg.WalletOfflineMsgManager", "orders xml: %s", new Object[] { ??? });
        b(aw((Map)localObject));
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 7))
      {
        t.eJf().Zq();
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 8))
      {
        b(ay((Map)localObject));
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 10))
      {
        k.dzG();
        k.dzJ().gT(4, 4);
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 20))
      {
        ??? = new ys();
        ???.dOG.dOH = new h((Map)localObject);
        com.tencent.mm.sdk.b.a.IvT.l(???);
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 23))
      {
        localObject = ax((Map)localObject);
        synchronized (this.wOv)
        {
          if (this.wOv.contains(((d)localObject).dwj))
          {
            ae.i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", new Object[] { ((d)localObject).dwj });
            AppMethodBeat.o(66326);
            return;
          }
          this.wOv.add(((d)localObject).dwj);
          b((c)localObject);
          AppMethodBeat.o(66326);
          return;
        }
      }
      if ((j >= 0) && (j == 24))
      {
        b(at(localMap));
        AppMethodBeat.o(66326);
        return;
      }
      AppMethodBeat.o(66326);
      return;
    }
  }
  
  public final void auR(String paramString)
  {
    AppMethodBeat.i(66333);
    int i = bu.getInt((String)bx.M(paramString, "sysmsg").get(".sysmsg.paymsg.PayMsgType"), -1);
    paramString = new HashSet();
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.wML));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.wMK));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.wMM));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.wMJ));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.wMG));
    if (paramString.contains(Integer.valueOf(i))) {
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66320);
          ae.v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.a(new b(this.wOw), 0);
          AppMethodBeat.o(66320);
        }
      });
    }
    AppMethodBeat.o(66333);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(66325);
    if (this.oCX == null)
    {
      AppMethodBeat.o(66325);
      return;
    }
    int i = 0;
    while (i < this.oCX.size())
    {
      WeakReference localWeakReference = (WeakReference)this.oCX.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.oCX.remove(localWeakReference);
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
    public String wOA;
    public String wOy;
    public String wOz;
    
    public b()
    {
      super();
    }
  }
  
  public class c
  {
    public int wOB;
    
    public c() {}
  }
  
  public final class d
    extends s.c
  {
    public String dwj;
    
    public d()
    {
      super();
    }
  }
  
  public final class e
    extends s.c
  {
    public String wOC;
    public String wOD;
    public String wOE;
    public String wOF;
    public String wOG;
    public boolean wOH = true;
    
    public e()
    {
      super();
    }
  }
  
  public final class f
    extends s.c
  {
    public s.h dOH;
    public String wOI;
    public Orders wOJ;
    
    public f()
    {
      super();
    }
  }
  
  public final class g
    extends s.c
  {
    public String dwj;
    public String id;
    public int pqv;
    public String wOK;
    public String wOL;
    
    public g()
    {
      super();
    }
  }
  
  public final class h
  {
    public String dOi;
    public String dOj;
    public String dOk;
    public String dOl;
    public String dOm;
    public boolean wOM;
    
    public h()
    {
      AppMethodBeat.i(66321);
      Object localObject;
      this.dOi = ((String)localObject.get(".sysmsg.paymsg.guide_flag"));
      this.dOj = ((String)localObject.get(".sysmsg.paymsg.guide_wording"));
      this.dOk = ((String)localObject.get(".sysmsg.paymsg.left_button_wording"));
      this.dOl = ((String)localObject.get(".sysmsg.paymsg.right_button_wording"));
      this.dOm = ((String)localObject.get(".sysmsg.paymsg.upload_credit_url"));
      if ("1".equals(localObject.get(".sysmsg.paymsg.guide_block"))) {}
      for (boolean bool = true;; bool = false)
      {
        this.wOM = bool;
        AppMethodBeat.o(66321);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.s
 * JD-Core Version:    0.7.0.1
 */