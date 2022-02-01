package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class s
{
  private List<WeakReference<a>> owv;
  public ArrayList<Long> wvO;
  public b wyJ;
  private HashSet<String> wyK;
  
  public s()
  {
    AppMethodBeat.i(66322);
    this.owv = new ArrayList();
    this.wyJ = null;
    this.wvO = new ArrayList();
    this.wyK = new HashSet();
    Object localObject = com.tencent.mm.plugin.offline.c.a.dxs();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bw.M((String)localObject, "sysmsg");
      if (localObject != null)
      {
        int i = bt.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
        if ((i >= 0) && (i == 4))
        {
          ad.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
          b(ao((Map)localObject));
        }
      }
    }
    this.wvO.clear();
    AppMethodBeat.o(66322);
  }
  
  private d an(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66327);
    d locald = new d();
    locald.wyQ = bt.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locald.dve = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(66327);
    return locald;
  }
  
  private b ao(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66328);
    if (this.wyJ == null) {
      this.wyJ = new b();
    }
    this.wyJ.wyQ = bt.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    this.wyJ.wyN = ((String)paramMap.get(".sysmsg.paymsg.isfreeze"));
    this.wyJ.wyO = ((String)paramMap.get(".sysmsg.paymsg.freezetype"));
    this.wyJ.wyP = ((String)paramMap.get(".sysmsg.paymsg.freezemsg"));
    paramMap = this.wyJ;
    AppMethodBeat.o(66328);
    return paramMap;
  }
  
  private e ap(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66329);
    e locale = new e();
    locale.wyQ = bt.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locale.wyR = ((String)paramMap.get(".sysmsg.paymsg.cftretcode"));
    locale.wyS = ((String)paramMap.get(".sysmsg.paymsg.cftretmsg"));
    locale.wyT = ((String)paramMap.get(".sysmsg.paymsg.wxretcode"));
    locale.wyU = ((String)paramMap.get(".sysmsg.paymsg.wxretmsg"));
    locale.wyV = ((String)paramMap.get(".sysmsg.paymsg.error_detail_url"));
    locale.wyW = true;
    AppMethodBeat.o(66329);
    return locale;
  }
  
  private f aq(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66330);
    f localf = new f();
    localf.wyQ = bt.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localf.wyX = ((String)paramMap.get(".sysmsg.paymsg.transid"));
    localf.wyY = com.tencent.mm.plugin.offline.c.a.at(paramMap);
    if (localf.wyY.CYk.size() > 0) {
      com.tencent.mm.plugin.offline.c.a.atT(((Orders.Commodity)localf.wyY.CYk.get(0)).dlv);
    }
    if (paramMap.containsKey(".sysmsg.paymsg.real_name_info")) {
      localf.dNr = new h(paramMap);
    }
    AppMethodBeat.o(66330);
    return localf;
  }
  
  private d ar(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66331);
    d locald = new d();
    locald.wyQ = bt.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locald.dve = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(66331);
    return locald;
  }
  
  private g as(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66332);
    g localg = new g();
    localg.wyQ = bt.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localg.wyZ = ((String)paramMap.get(".sysmsg.paymsg.good_name"));
    localg.wza = ((String)paramMap.get(".sysmsg.paymsg.total_fee"));
    localg.dve = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    localg.id = ((String)paramMap.get(".sysmsg.paymsg.id"));
    paramMap = (String)paramMap.get(".sysmsg.paymsg.confirm_type");
    ad.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + localg.pjQ);
    if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals("1"))) {}
    for (localg.pjQ = 1;; localg.pjQ = 0)
    {
      AppMethodBeat.o(66332);
      return localg;
    }
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(66323);
    if (this.owv == null)
    {
      AppMethodBeat.o(66323);
      return;
    }
    int i = 0;
    while (i < this.owv.size())
    {
      Object localObject = (WeakReference)this.owv.get(i);
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
    if (this.owv == null) {
      this.owv = new ArrayList();
    }
    this.owv.add(new WeakReference(parama));
    AppMethodBeat.o(66324);
  }
  
  public final void atB(String arg1)
  {
    AppMethodBeat.i(66326);
    com.tencent.mm.plugin.offline.c.a.atR("");
    com.tencent.mm.plugin.offline.c.a.atT("");
    com.tencent.mm.plugin.offline.c.a.atS("");
    Object localObject = bw.M(???, "sysmsg");
    if (localObject == null)
    {
      AppMethodBeat.o(66326);
      return;
    }
    int j = bt.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    int i = bt.getInt((String)((Map)localObject).get(".sysmsg.paymsg.pay_cmd"), -1);
    String str = (String)((Map)localObject).get(".sysmsg.paymsg.req_key");
    com.tencent.mm.plugin.offline.c.a.atR((String)((Map)localObject).get(".sysmsg.paymsg.ack_key"));
    com.tencent.mm.plugin.offline.c.a.Mr(j);
    com.tencent.mm.plugin.offline.c.a.atS(str);
    j = bt.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    ad.i("MicroMsg.WalletOfflineMsgManager", "msg type is ".concat(String.valueOf(j)));
    ad.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", new Object[] { Integer.valueOf(j), ??? });
    if ((j >= 0) && (j == 4))
    {
      b(ao((Map)localObject));
      com.tencent.mm.plugin.offline.c.a.atI(???);
      AppMethodBeat.o(66326);
      return;
    }
    if ((j >= 0) && (j == 5))
    {
      if (i != 1) {
        break label639;
      }
      ad.i("MicroMsg.WalletOfflineMsgManager", "payCmd is PAY_CMD_OFFLINE_PAY_REFRESH_TOKEN (value is 1), refresh offline token");
      k.dwq();
      k.dwt().gS(4, 4);
    }
    label639:
    for (boolean bool = false;; bool = true)
    {
      ??? = ap((Map)localObject);
      ???.wyW = bool;
      b(???);
      AppMethodBeat.o(66326);
      return;
      if ((j >= 0) && (j == 6))
      {
        str = (String)((Map)localObject).get(".sysmsg.paymsg.transid");
        ad.i("helios", "MSG_TYPE_ORDER trasid=".concat(String.valueOf(str)));
        if (!bt.isNullOrNil(str))
        {
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iwl, Boolean.TRUE);
        }
        ad.i("MicroMsg.WalletOfflineMsgManager", "orders xml: %s", new Object[] { ??? });
        b(aq((Map)localObject));
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 7))
      {
        t.eFy().Zh();
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 8))
      {
        b(as((Map)localObject));
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 10))
      {
        k.dwq();
        k.dwt().gS(4, 4);
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 20))
      {
        ??? = new ym();
        ???.dNq.dNr = new h((Map)localObject);
        com.tencent.mm.sdk.b.a.IbL.l(???);
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 23))
      {
        localObject = ar((Map)localObject);
        synchronized (this.wyK)
        {
          if (this.wyK.contains(((d)localObject).dve))
          {
            ad.i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", new Object[] { ((d)localObject).dve });
            AppMethodBeat.o(66326);
            return;
          }
          this.wyK.add(((d)localObject).dve);
          b((c)localObject);
          AppMethodBeat.o(66326);
          return;
        }
      }
      if ((j >= 0) && (j == 24))
      {
        b(an(localMap));
        AppMethodBeat.o(66326);
        return;
      }
      AppMethodBeat.o(66326);
      return;
    }
  }
  
  public final void atC(String paramString)
  {
    AppMethodBeat.i(66333);
    int i = bt.getInt((String)bw.M(paramString, "sysmsg").get(".sysmsg.paymsg.PayMsgType"), -1);
    paramString = new HashSet();
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.wxa));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.wwZ));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.wxb));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.wwY));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.wwV));
    if (paramString.contains(Integer.valueOf(i))) {
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66320);
          ad.v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(new b(this.wyL), 0);
          AppMethodBeat.o(66320);
        }
      });
    }
    AppMethodBeat.o(66333);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(66325);
    if (this.owv == null)
    {
      AppMethodBeat.o(66325);
      return;
    }
    int i = 0;
    while (i < this.owv.size())
    {
      WeakReference localWeakReference = (WeakReference)this.owv.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.owv.remove(localWeakReference);
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
    public String wyN;
    public String wyO;
    public String wyP;
    
    public b()
    {
      super();
    }
  }
  
  public class c
  {
    public int wyQ;
    
    public c() {}
  }
  
  public final class d
    extends s.c
  {
    public String dve;
    
    public d()
    {
      super();
    }
  }
  
  public final class e
    extends s.c
  {
    public String wyR;
    public String wyS;
    public String wyT;
    public String wyU;
    public String wyV;
    public boolean wyW = true;
    
    public e()
    {
      super();
    }
  }
  
  public final class f
    extends s.c
  {
    public s.h dNr;
    public String wyX;
    public Orders wyY;
    
    public f()
    {
      super();
    }
  }
  
  public final class g
    extends s.c
  {
    public String dve;
    public String id;
    public int pjQ;
    public String wyZ;
    public String wza;
    
    public g()
    {
      super();
    }
  }
  
  public final class h
  {
    public String dMS;
    public String dMT;
    public String dMU;
    public String dMV;
    public String dMW;
    public boolean wzb;
    
    public h()
    {
      AppMethodBeat.i(66321);
      Object localObject;
      this.dMS = ((String)localObject.get(".sysmsg.paymsg.guide_flag"));
      this.dMT = ((String)localObject.get(".sysmsg.paymsg.guide_wording"));
      this.dMU = ((String)localObject.get(".sysmsg.paymsg.left_button_wording"));
      this.dMV = ((String)localObject.get(".sysmsg.paymsg.right_button_wording"));
      this.dMW = ((String)localObject.get(".sysmsg.paymsg.upload_credit_url"));
      if ("1".equals(localObject.get(".sysmsg.paymsg.guide_block"))) {}
      for (boolean bool = true;; bool = false)
      {
        this.wzb = bool;
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