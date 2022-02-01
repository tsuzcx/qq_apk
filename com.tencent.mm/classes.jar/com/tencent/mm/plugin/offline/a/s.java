package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.abe;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class s
{
  public ArrayList<Long> GAk;
  public b GDh;
  private HashSet<String> GDi;
  private List<WeakReference<a>> cSF;
  
  public s()
  {
    AppMethodBeat.i(66322);
    this.cSF = new ArrayList();
    this.GDh = null;
    this.GAk = new ArrayList();
    this.GDi = new HashSet();
    Object localObject = a.flY();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = XmlParser.parseXml((String)localObject, "sysmsg", null);
      if (localObject != null)
      {
        int i = Util.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
        if ((i >= 0) && (i == 4))
        {
          Log.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
          b(ao((Map)localObject));
        }
      }
    }
    this.GAk.clear();
    AppMethodBeat.o(66322);
  }
  
  private d an(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66327);
    d locald = new d();
    locald.GDo = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locald.fHb = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(66327);
    return locald;
  }
  
  private b ao(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66328);
    if (this.GDh == null) {
      this.GDh = new b();
    }
    this.GDh.GDo = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    this.GDh.GDl = ((String)paramMap.get(".sysmsg.paymsg.isfreeze"));
    this.GDh.GDm = ((String)paramMap.get(".sysmsg.paymsg.freezetype"));
    this.GDh.GDn = ((String)paramMap.get(".sysmsg.paymsg.freezemsg"));
    paramMap = this.GDh;
    AppMethodBeat.o(66328);
    return paramMap;
  }
  
  private e ap(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66329);
    e locale = new e();
    locale.GDo = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locale.GDp = ((String)paramMap.get(".sysmsg.paymsg.cftretcode"));
    locale.GDq = ((String)paramMap.get(".sysmsg.paymsg.cftretmsg"));
    locale.GDr = ((String)paramMap.get(".sysmsg.paymsg.wxretcode"));
    locale.GDs = ((String)paramMap.get(".sysmsg.paymsg.wxretmsg"));
    locale.GDt = ((String)paramMap.get(".sysmsg.paymsg.error_detail_url"));
    locale.GDu = true;
    AppMethodBeat.o(66329);
    return locale;
  }
  
  private f aq(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66330);
    f localf = new f();
    localf.GDo = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localf.GDv = ((String)paramMap.get(".sysmsg.paymsg.transid"));
    localf.GDw = a.at(paramMap);
    if (localf.GDw.ORd.size() > 0) {
      a.aTQ(((Orders.Commodity)localf.GDw.ORd.get(0)).fww);
    }
    if (paramMap.containsKey(".sysmsg.paymsg.real_name_info")) {
      localf.gaT = new h(paramMap);
    }
    AppMethodBeat.o(66330);
    return localf;
  }
  
  private d ar(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66331);
    d locald = new d();
    locald.GDo = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locald.fHb = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(66331);
    return locald;
  }
  
  private g as(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66332);
    g localg = new g();
    localg.GDo = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localg.GDx = ((String)paramMap.get(".sysmsg.paymsg.good_name"));
    localg.GDy = ((String)paramMap.get(".sysmsg.paymsg.total_fee"));
    localg.fHb = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    localg.id = ((String)paramMap.get(".sysmsg.paymsg.id"));
    paramMap = (String)paramMap.get(".sysmsg.paymsg.confirm_type");
    Log.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + localg.ufc);
    if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals("1"))) {}
    for (localg.ufc = 1;; localg.ufc = 0)
    {
      AppMethodBeat.o(66332);
      return localg;
    }
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(66323);
    if (this.cSF == null)
    {
      AppMethodBeat.o(66323);
      return;
    }
    int i = 0;
    while (i < this.cSF.size())
    {
      Object localObject = (WeakReference)this.cSF.get(i);
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
    if (this.cSF == null) {
      this.cSF = new ArrayList();
    }
    this.cSF.add(new WeakReference(parama));
    AppMethodBeat.o(66324);
  }
  
  public final void aTy(String arg1)
  {
    AppMethodBeat.i(66326);
    a.aTO("");
    a.aTQ("");
    a.aTP("");
    Object localObject = XmlParser.parseXml(???, "sysmsg", null);
    if (localObject == null)
    {
      AppMethodBeat.o(66326);
      return;
    }
    int j = Util.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    int i = Util.getInt((String)((Map)localObject).get(".sysmsg.paymsg.pay_cmd"), -1);
    String str = (String)((Map)localObject).get(".sysmsg.paymsg.req_key");
    a.aTO((String)((Map)localObject).get(".sysmsg.paymsg.ack_key"));
    a.aaR(j);
    a.aTP(str);
    j = Util.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    Log.i("MicroMsg.WalletOfflineMsgManager", "msg type is ".concat(String.valueOf(j)));
    Log.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", new Object[] { Integer.valueOf(j), ??? });
    if ((j >= 0) && (j == 4))
    {
      b(ao((Map)localObject));
      a.aTF(???);
      AppMethodBeat.o(66326);
      return;
    }
    if ((j >= 0) && (j == 5))
    {
      if (i != 1) {
        break label640;
      }
      Log.i("MicroMsg.WalletOfflineMsgManager", "payCmd is PAY_CMD_OFFLINE_PAY_REFRESH_TOKEN (value is 1), refresh offline token");
      k.fkT();
      k.fkW().iJ(4, 4);
    }
    label640:
    for (boolean bool = false;; bool = true)
    {
      ??? = ap((Map)localObject);
      ???.GDu = bool;
      b(???);
      AppMethodBeat.o(66326);
      return;
      if ((j >= 0) && (j == 6))
      {
        str = (String)((Map)localObject).get(".sysmsg.paymsg.transid");
        Log.i("helios", "MSG_TYPE_ORDER trasid=".concat(String.valueOf(str)));
        if (!Util.isNullOrNil(str))
        {
          h.aHH();
          h.aHG().aHp().set(ar.a.VmK, Boolean.TRUE);
        }
        Log.i("MicroMsg.WalletOfflineMsgManager", "orders xml: %s", new Object[] { ??? });
        b(aq((Map)localObject));
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 7))
      {
        u.gJo().ate();
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
        k.fkT();
        k.fkW().iJ(4, 4);
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 20))
      {
        ??? = new abe();
        ???.gaS.gaT = new h((Map)localObject);
        EventCenter.instance.publish(???);
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 23))
      {
        localObject = ar((Map)localObject);
        synchronized (this.GDi)
        {
          if (this.GDi.contains(((d)localObject).fHb))
          {
            Log.i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", new Object[] { ((d)localObject).fHb });
            AppMethodBeat.o(66326);
            return;
          }
          this.GDi.add(((d)localObject).fHb);
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
  
  public final void aTz(String paramString)
  {
    AppMethodBeat.i(66333);
    int i = Util.getInt((String)XmlParser.parseXml(paramString, "sysmsg", null).get(".sysmsg.paymsg.PayMsgType"), -1);
    paramString = new HashSet();
    paramString.add(Integer.valueOf(g.GBA));
    paramString.add(Integer.valueOf(g.GBz));
    paramString.add(Integer.valueOf(g.GBB));
    paramString.add(Integer.valueOf(g.GBy));
    paramString.add(Integer.valueOf(g.GBv));
    if (paramString.contains(Integer.valueOf(i))) {
      h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66320);
          Log.v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
          h.aHH();
          h.aHF().kcd.a(new b(this.GDj), 0);
          AppMethodBeat.o(66320);
        }
      });
    }
    AppMethodBeat.o(66333);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(66325);
    if (this.cSF == null)
    {
      AppMethodBeat.o(66325);
      return;
    }
    int i = 0;
    while (i < this.cSF.size())
    {
      WeakReference localWeakReference = (WeakReference)this.cSF.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.cSF.remove(localWeakReference);
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
    public String GDl;
    public String GDm;
    public String GDn;
    
    public b()
    {
      super();
    }
  }
  
  public class c
  {
    public int GDo;
    
    public c() {}
  }
  
  public final class d
    extends s.c
  {
    public String fHb;
    
    public d()
    {
      super();
    }
  }
  
  public final class e
    extends s.c
  {
    public String GDp;
    public String GDq;
    public String GDr;
    public String GDs;
    public String GDt;
    public boolean GDu = true;
    
    public e()
    {
      super();
    }
  }
  
  public final class f
    extends s.c
  {
    public String GDv;
    public Orders GDw;
    public s.h gaT;
    
    public f()
    {
      super();
    }
  }
  
  public final class g
    extends s.c
  {
    public String GDx;
    public String GDy;
    public String fHb;
    public String id;
    public int ufc;
    
    public g()
    {
      super();
    }
  }
  
  public final class h
  {
    public boolean GDz;
    public String gat;
    public String gau;
    public String gav;
    public String gaw;
    public String gax;
    
    public h()
    {
      AppMethodBeat.i(66321);
      Object localObject;
      this.gat = ((String)localObject.get(".sysmsg.paymsg.guide_flag"));
      this.gau = ((String)localObject.get(".sysmsg.paymsg.guide_wording"));
      this.gav = ((String)localObject.get(".sysmsg.paymsg.left_button_wording"));
      this.gaw = ((String)localObject.get(".sysmsg.paymsg.right_button_wording"));
      this.gax = ((String)localObject.get(".sysmsg.paymsg.upload_credit_url"));
      if ("1".equals(localObject.get(".sysmsg.paymsg.guide_block"))) {}
      for (boolean bool = true;; bool = false)
      {
        this.GDz = bool;
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