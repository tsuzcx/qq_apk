package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.xs;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class s
{
  private List<WeakReference<a>> nTa;
  public ArrayList<Long> vqw;
  public b vtr;
  private HashSet<String> vts;
  
  public s()
  {
    AppMethodBeat.i(66322);
    this.nTa = new ArrayList();
    this.vtr = null;
    this.vqw = new ArrayList();
    this.vts = new HashSet();
    Object localObject = com.tencent.mm.plugin.offline.c.a.dna();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bv.L((String)localObject, "sysmsg");
      if (localObject != null)
      {
        int i = bs.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
        if ((i >= 0) && (i == 4))
        {
          ac.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
          b(aj((Map)localObject));
        }
      }
    }
    this.vqw.clear();
    AppMethodBeat.o(66322);
  }
  
  private d ai(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66327);
    d locald = new d();
    locald.vty = bs.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locald.djr = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(66327);
    return locald;
  }
  
  private b aj(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66328);
    if (this.vtr == null) {
      this.vtr = new b();
    }
    this.vtr.vty = bs.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    this.vtr.vtv = ((String)paramMap.get(".sysmsg.paymsg.isfreeze"));
    this.vtr.vtw = ((String)paramMap.get(".sysmsg.paymsg.freezetype"));
    this.vtr.vtx = ((String)paramMap.get(".sysmsg.paymsg.freezemsg"));
    paramMap = this.vtr;
    AppMethodBeat.o(66328);
    return paramMap;
  }
  
  private e ak(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66329);
    e locale = new e();
    locale.vty = bs.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locale.vtz = ((String)paramMap.get(".sysmsg.paymsg.cftretcode"));
    locale.vtA = ((String)paramMap.get(".sysmsg.paymsg.cftretmsg"));
    locale.vtB = ((String)paramMap.get(".sysmsg.paymsg.wxretcode"));
    locale.vtC = ((String)paramMap.get(".sysmsg.paymsg.wxretmsg"));
    locale.vtD = ((String)paramMap.get(".sysmsg.paymsg.error_detail_url"));
    locale.vtE = true;
    AppMethodBeat.o(66329);
    return locale;
  }
  
  private f al(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66330);
    f localf = new f();
    localf.vty = bs.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localf.vtF = ((String)paramMap.get(".sysmsg.paymsg.transid"));
    localf.vtG = com.tencent.mm.plugin.offline.c.a.ao(paramMap);
    if (localf.vtG.BxR.size() > 0) {
      com.tencent.mm.plugin.offline.c.a.aoT(((Orders.Commodity)localf.vtG.BxR.get(0)).dad);
    }
    if (paramMap.containsKey(".sysmsg.paymsg.real_name_info")) {
      localf.dBe = new h(paramMap);
    }
    AppMethodBeat.o(66330);
    return localf;
  }
  
  private d am(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66331);
    d locald = new d();
    locald.vty = bs.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locald.djr = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(66331);
    return locald;
  }
  
  private g an(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66332);
    g localg = new g();
    localg.vty = bs.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localg.vtH = ((String)paramMap.get(".sysmsg.paymsg.good_name"));
    localg.vtI = ((String)paramMap.get(".sysmsg.paymsg.total_fee"));
    localg.djr = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    localg.id = ((String)paramMap.get(".sysmsg.paymsg.id"));
    paramMap = (String)paramMap.get(".sysmsg.paymsg.confirm_type");
    ac.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + localg.oGm);
    if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals("1"))) {}
    for (localg.oGm = 1;; localg.oGm = 0)
    {
      AppMethodBeat.o(66332);
      return localg;
    }
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(66323);
    if (this.nTa == null)
    {
      AppMethodBeat.o(66323);
      return;
    }
    int i = 0;
    while (i < this.nTa.size())
    {
      Object localObject = (WeakReference)this.nTa.get(i);
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
    if (this.nTa == null) {
      this.nTa = new ArrayList();
    }
    this.nTa.add(new WeakReference(parama));
    AppMethodBeat.o(66324);
  }
  
  public final void aoB(String arg1)
  {
    AppMethodBeat.i(66326);
    com.tencent.mm.plugin.offline.c.a.aoR("");
    com.tencent.mm.plugin.offline.c.a.aoT("");
    com.tencent.mm.plugin.offline.c.a.aoS("");
    Object localObject = bv.L(???, "sysmsg");
    if (localObject == null)
    {
      AppMethodBeat.o(66326);
      return;
    }
    int j = bs.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    int i = bs.getInt((String)((Map)localObject).get(".sysmsg.paymsg.pay_cmd"), -1);
    String str = (String)((Map)localObject).get(".sysmsg.paymsg.req_key");
    com.tencent.mm.plugin.offline.c.a.aoR((String)((Map)localObject).get(".sysmsg.paymsg.ack_key"));
    com.tencent.mm.plugin.offline.c.a.KP(j);
    com.tencent.mm.plugin.offline.c.a.aoS(str);
    j = bs.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    ac.i("MicroMsg.WalletOfflineMsgManager", "msg type is ".concat(String.valueOf(j)));
    ac.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", new Object[] { Integer.valueOf(j), ??? });
    if ((j >= 0) && (j == 4))
    {
      b(aj((Map)localObject));
      com.tencent.mm.plugin.offline.c.a.aoI(???);
      AppMethodBeat.o(66326);
      return;
    }
    if ((j >= 0) && (j == 5))
    {
      if (i != 1) {
        break label639;
      }
      ac.i("MicroMsg.WalletOfflineMsgManager", "payCmd is PAY_CMD_OFFLINE_PAY_REFRESH_TOKEN (value is 1), refresh offline token");
      k.dlZ();
      k.dmc().gA(4, 4);
    }
    label639:
    for (boolean bool = false;; bool = true)
    {
      ??? = ak((Map)localObject);
      ???.vtE = bool;
      b(???);
      AppMethodBeat.o(66326);
      return;
      if ((j >= 0) && (j == 6))
      {
        str = (String)((Map)localObject).get(".sysmsg.paymsg.transid");
        ac.i("helios", "MSG_TYPE_ORDER trasid=".concat(String.valueOf(str)));
        if (!bs.isNullOrNil(str))
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GJT, Boolean.TRUE);
        }
        ac.i("MicroMsg.WalletOfflineMsgManager", "orders xml: %s", new Object[] { ??? });
        b(al((Map)localObject));
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 7))
      {
        com.tencent.mm.plugin.wallet_core.model.s.ery().WN();
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 8))
      {
        b(an((Map)localObject));
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 10))
      {
        k.dlZ();
        k.dmc().gA(4, 4);
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 20))
      {
        ??? = new xs();
        ???.dBd.dBe = new h((Map)localObject);
        com.tencent.mm.sdk.b.a.GpY.l(???);
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 23))
      {
        localObject = am((Map)localObject);
        synchronized (this.vts)
        {
          if (this.vts.contains(((d)localObject).djr))
          {
            ac.i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", new Object[] { ((d)localObject).djr });
            AppMethodBeat.o(66326);
            return;
          }
          this.vts.add(((d)localObject).djr);
          b((c)localObject);
          AppMethodBeat.o(66326);
          return;
        }
      }
      if ((j >= 0) && (j == 24))
      {
        b(ai(localMap));
        AppMethodBeat.o(66326);
        return;
      }
      AppMethodBeat.o(66326);
      return;
    }
  }
  
  public final void aoC(String paramString)
  {
    AppMethodBeat.i(66333);
    int i = bs.getInt((String)bv.L(paramString, "sysmsg").get(".sysmsg.paymsg.PayMsgType"), -1);
    paramString = new HashSet();
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.vrI));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.vrH));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.vrJ));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.vrG));
    paramString.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.vrD));
    if (paramString.contains(Integer.valueOf(i))) {
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66320);
          ac.v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(new b(this.vtt), 0);
          AppMethodBeat.o(66320);
        }
      });
    }
    AppMethodBeat.o(66333);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(66325);
    if (this.nTa == null)
    {
      AppMethodBeat.o(66325);
      return;
    }
    int i = 0;
    while (i < this.nTa.size())
    {
      WeakReference localWeakReference = (WeakReference)this.nTa.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.nTa.remove(localWeakReference);
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
    public String vtv;
    public String vtw;
    public String vtx;
    
    public b()
    {
      super();
    }
  }
  
  public class c
  {
    public int vty;
    
    public c() {}
  }
  
  public final class d
    extends s.c
  {
    public String djr;
    
    public d()
    {
      super();
    }
  }
  
  public final class e
    extends s.c
  {
    public String vtA;
    public String vtB;
    public String vtC;
    public String vtD;
    public boolean vtE = true;
    public String vtz;
    
    public e()
    {
      super();
    }
  }
  
  public final class f
    extends s.c
  {
    public s.h dBe;
    public String vtF;
    public Orders vtG;
    
    public f()
    {
      super();
    }
  }
  
  public final class g
    extends s.c
  {
    public String djr;
    public String id;
    public int oGm;
    public String vtH;
    public String vtI;
    
    public g()
    {
      super();
    }
  }
  
  public final class h
  {
    public String dAF;
    public String dAG;
    public String dAH;
    public String dAI;
    public String dAJ;
    public boolean vtJ;
    
    public h()
    {
      AppMethodBeat.i(66321);
      Object localObject;
      this.dAF = ((String)localObject.get(".sysmsg.paymsg.guide_flag"));
      this.dAG = ((String)localObject.get(".sysmsg.paymsg.guide_wording"));
      this.dAH = ((String)localObject.get(".sysmsg.paymsg.left_button_wording"));
      this.dAI = ((String)localObject.get(".sysmsg.paymsg.right_button_wording"));
      this.dAJ = ((String)localObject.get(".sysmsg.paymsg.upload_credit_url"));
      if ("1".equals(localObject.get(".sysmsg.paymsg.guide_block"))) {}
      for (boolean bool = true;; bool = false)
      {
        this.vtJ = bool;
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