package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zx;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class s
{
  public ArrayList<Long> AHb;
  public b AKa;
  private HashSet<String> AKb;
  private List<WeakReference<a>> pQG;
  
  public s()
  {
    AppMethodBeat.i(66322);
    this.pQG = new ArrayList();
    this.AKa = null;
    this.AHb = new ArrayList();
    this.AKb = new HashSet();
    Object localObject = a.eAu();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = XmlParser.parseXml((String)localObject, "sysmsg", null);
      if (localObject != null)
      {
        int i = Util.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
        if ((i >= 0) && (i == 4))
        {
          Log.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
          b(au((Map)localObject));
        }
      }
    }
    this.AHb.clear();
    AppMethodBeat.o(66322);
  }
  
  private d at(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66327);
    d locald = new d();
    locald.AKh = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locald.dNQ = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(66327);
    return locald;
  }
  
  private b au(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66328);
    if (this.AKa == null) {
      this.AKa = new b();
    }
    this.AKa.AKh = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    this.AKa.AKe = ((String)paramMap.get(".sysmsg.paymsg.isfreeze"));
    this.AKa.AKf = ((String)paramMap.get(".sysmsg.paymsg.freezetype"));
    this.AKa.AKg = ((String)paramMap.get(".sysmsg.paymsg.freezemsg"));
    paramMap = this.AKa;
    AppMethodBeat.o(66328);
    return paramMap;
  }
  
  private e av(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66329);
    e locale = new e();
    locale.AKh = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locale.AKi = ((String)paramMap.get(".sysmsg.paymsg.cftretcode"));
    locale.AKj = ((String)paramMap.get(".sysmsg.paymsg.cftretmsg"));
    locale.AKk = ((String)paramMap.get(".sysmsg.paymsg.wxretcode"));
    locale.AKl = ((String)paramMap.get(".sysmsg.paymsg.wxretmsg"));
    locale.AKm = ((String)paramMap.get(".sysmsg.paymsg.error_detail_url"));
    locale.AKn = true;
    AppMethodBeat.o(66329);
    return locale;
  }
  
  private f aw(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66330);
    f localf = new f();
    localf.AKh = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localf.AKo = ((String)paramMap.get(".sysmsg.paymsg.transid"));
    localf.AKp = a.az(paramMap);
    if (localf.AKp.HZd.size() > 0) {
      a.aJu(((Orders.Commodity)localf.AKp.HZd.get(0)).dDM);
    }
    if (paramMap.containsKey(".sysmsg.paymsg.real_name_info")) {
      localf.egD = new h(paramMap);
    }
    AppMethodBeat.o(66330);
    return localf;
  }
  
  private d ax(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66331);
    d locald = new d();
    locald.AKh = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locald.dNQ = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(66331);
    return locald;
  }
  
  private g ay(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66332);
    g localg = new g();
    localg.AKh = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localg.AKq = ((String)paramMap.get(".sysmsg.paymsg.good_name"));
    localg.AKr = ((String)paramMap.get(".sysmsg.paymsg.total_fee"));
    localg.dNQ = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    localg.id = ((String)paramMap.get(".sysmsg.paymsg.id"));
    paramMap = (String)paramMap.get(".sysmsg.paymsg.confirm_type");
    Log.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + localg.qGa);
    if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals("1"))) {}
    for (localg.qGa = 1;; localg.qGa = 0)
    {
      AppMethodBeat.o(66332);
      return localg;
    }
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(66323);
    if (this.pQG == null)
    {
      AppMethodBeat.o(66323);
      return;
    }
    int i = 0;
    while (i < this.pQG.size())
    {
      Object localObject = (WeakReference)this.pQG.get(i);
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
    if (this.pQG == null) {
      this.pQG = new ArrayList();
    }
    this.pQG.add(new WeakReference(parama));
    AppMethodBeat.o(66324);
  }
  
  public final void aJc(String arg1)
  {
    AppMethodBeat.i(66326);
    a.aJs("");
    a.aJu("");
    a.aJt("");
    Object localObject = XmlParser.parseXml(???, "sysmsg", null);
    if (localObject == null)
    {
      AppMethodBeat.o(66326);
      return;
    }
    int j = Util.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    int i = Util.getInt((String)((Map)localObject).get(".sysmsg.paymsg.pay_cmd"), -1);
    String str = (String)((Map)localObject).get(".sysmsg.paymsg.req_key");
    a.aJs((String)((Map)localObject).get(".sysmsg.paymsg.ack_key"));
    a.Ug(j);
    a.aJt(str);
    j = Util.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    Log.i("MicroMsg.WalletOfflineMsgManager", "msg type is ".concat(String.valueOf(j)));
    Log.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", new Object[] { Integer.valueOf(j), ??? });
    if ((j >= 0) && (j == 4))
    {
      b(au((Map)localObject));
      a.aJj(???);
      AppMethodBeat.o(66326);
      return;
    }
    if ((j >= 0) && (j == 5))
    {
      if (i != 1) {
        break label640;
      }
      Log.i("MicroMsg.WalletOfflineMsgManager", "payCmd is PAY_CMD_OFFLINE_PAY_REFRESH_TOKEN (value is 1), refresh offline token");
      k.ezn();
      k.ezq().hE(4, 4);
    }
    label640:
    for (boolean bool = false;; bool = true)
    {
      ??? = av((Map)localObject);
      ???.AKn = bool;
      b(???);
      AppMethodBeat.o(66326);
      return;
      if ((j >= 0) && (j == 6))
      {
        str = (String)((Map)localObject).get(".sysmsg.paymsg.transid");
        Log.i("helios", "MSG_TYPE_ORDER trasid=".concat(String.valueOf(str)));
        if (!Util.isNullOrNil(str))
        {
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NYK, Boolean.TRUE);
        }
        Log.i("MicroMsg.WalletOfflineMsgManager", "orders xml: %s", new Object[] { ??? });
        b(aw((Map)localObject));
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 7))
      {
        com.tencent.mm.plugin.wallet_core.model.t.fQI().and();
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
        k.ezn();
        k.ezq().hE(4, 4);
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 20))
      {
        ??? = new zx();
        ???.egC.egD = new h((Map)localObject);
        EventCenter.instance.publish(???);
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 23))
      {
        localObject = ax((Map)localObject);
        synchronized (this.AKb)
        {
          if (this.AKb.contains(((d)localObject).dNQ))
          {
            Log.i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", new Object[] { ((d)localObject).dNQ });
            AppMethodBeat.o(66326);
            return;
          }
          this.AKb.add(((d)localObject).dNQ);
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
  
  public final void aJd(String paramString)
  {
    AppMethodBeat.i(66333);
    int i = Util.getInt((String)XmlParser.parseXml(paramString, "sysmsg", null).get(".sysmsg.paymsg.PayMsgType"), -1);
    paramString = new HashSet();
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.AIr));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.AIq));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.AIs));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.AIp));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.AIm));
    if (paramString.contains(Integer.valueOf(i))) {
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66320);
          Log.v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a(new b(this.AKc), 0);
          AppMethodBeat.o(66320);
        }
      });
    }
    AppMethodBeat.o(66333);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(66325);
    if (this.pQG == null)
    {
      AppMethodBeat.o(66325);
      return;
    }
    int i = 0;
    while (i < this.pQG.size())
    {
      WeakReference localWeakReference = (WeakReference)this.pQG.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.pQG.remove(localWeakReference);
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
    public String AKe;
    public String AKf;
    public String AKg;
    
    public b()
    {
      super();
    }
  }
  
  public class c
  {
    public int AKh;
    
    public c() {}
  }
  
  public final class d
    extends s.c
  {
    public String dNQ;
    
    public d()
    {
      super();
    }
  }
  
  public final class e
    extends s.c
  {
    public String AKi;
    public String AKj;
    public String AKk;
    public String AKl;
    public String AKm;
    public boolean AKn = true;
    
    public e()
    {
      super();
    }
  }
  
  public final class f
    extends s.c
  {
    public String AKo;
    public Orders AKp;
    public s.h egD;
    
    public f()
    {
      super();
    }
  }
  
  public final class g
    extends s.c
  {
    public String AKq;
    public String AKr;
    public String dNQ;
    public String id;
    public int qGa;
    
    public g()
    {
      super();
    }
  }
  
  public final class h
  {
    public boolean AKs;
    public String egd;
    public String ege;
    public String egf;
    public String egg;
    public String egh;
    
    public h()
    {
      AppMethodBeat.i(66321);
      Object localObject;
      this.egd = ((String)localObject.get(".sysmsg.paymsg.guide_flag"));
      this.ege = ((String)localObject.get(".sysmsg.paymsg.guide_wording"));
      this.egf = ((String)localObject.get(".sysmsg.paymsg.left_button_wording"));
      this.egg = ((String)localObject.get(".sysmsg.paymsg.right_button_wording"));
      this.egh = ((String)localObject.get(".sysmsg.paymsg.upload_credit_url"));
      if ("1".equals(localObject.get(".sysmsg.paymsg.guide_block"))) {}
      for (boolean bool = true;; bool = false)
      {
        this.AKs = bool;
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