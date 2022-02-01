package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.adb;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class u
{
  public ArrayList<Long> Mwu;
  public b Mzt;
  private HashSet<String> Mzu;
  private List<WeakReference<a>> eNV;
  
  public u()
  {
    AppMethodBeat.i(66322);
    this.eNV = new ArrayList();
    this.Mzt = null;
    this.Mwu = new ArrayList();
    this.Mzu = new HashSet();
    Object localObject = com.tencent.mm.plugin.offline.c.d.gwK();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = XmlParser.parseXml((String)localObject, "sysmsg", null);
      if (localObject != null)
      {
        int i = Util.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
        if ((i >= 0) && (i == 4))
        {
          Log.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
          a(aE((Map)localObject));
        }
      }
    }
    this.Mwu.clear();
    AppMethodBeat.o(66322);
  }
  
  private void a(d paramd)
  {
    AppMethodBeat.i(66323);
    if (this.eNV == null)
    {
      AppMethodBeat.o(66323);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      Object localObject = (WeakReference)this.eNV.get(i);
      if (localObject != null)
      {
        localObject = (a)((WeakReference)localObject).get();
        if ((localObject != null) && (((a)localObject).onNotify(paramd))) {
          break;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(66323);
  }
  
  private e aD(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66327);
    e locale = new e();
    locale.MzB = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locale.hMy = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(66327);
    return locale;
  }
  
  private b aE(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66328);
    if (this.Mzt == null) {
      this.Mzt = new b();
    }
    this.Mzt.MzB = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    this.Mzt.Mzx = ((String)paramMap.get(".sysmsg.paymsg.isfreeze"));
    this.Mzt.Mzy = ((String)paramMap.get(".sysmsg.paymsg.freezetype"));
    this.Mzt.Mzz = ((String)paramMap.get(".sysmsg.paymsg.freezemsg"));
    paramMap = this.Mzt;
    AppMethodBeat.o(66328);
    return paramMap;
  }
  
  private f aF(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66329);
    f localf = new f();
    localf.MzB = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localf.MzD = ((String)paramMap.get(".sysmsg.paymsg.cftretcode"));
    localf.MzE = ((String)paramMap.get(".sysmsg.paymsg.cftretmsg"));
    localf.MzF = ((String)paramMap.get(".sysmsg.paymsg.wxretcode"));
    localf.MzG = ((String)paramMap.get(".sysmsg.paymsg.wxretmsg"));
    localf.MzH = ((String)paramMap.get(".sysmsg.paymsg.error_detail_url"));
    localf.MzI = Util.getInt((String)paramMap.get(".sysmsg.paymsg.pay_cmd"), -1);
    localf.MzJ = true;
    AppMethodBeat.o(66329);
    return localf;
  }
  
  private g aG(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66330);
    g localg = new g();
    localg.MzB = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localg.MzK = ((String)paramMap.get(".sysmsg.paymsg.transid"));
    localg.MzL = com.tencent.mm.plugin.offline.c.d.aJ(paramMap);
    if (localg.MzL.VGX.size() > 0) {
      com.tencent.mm.plugin.offline.c.d.aQV(((Orders.Commodity)localg.MzL.VGX.get(0)).hAU);
    }
    if (paramMap.containsKey(".sysmsg.paymsg.real_name_info")) {
      localg.ihd = new i(paramMap);
    }
    AppMethodBeat.o(66330);
    return localg;
  }
  
  private e aH(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66331);
    e locale = new e();
    locale.MzB = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    locale.hMy = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    AppMethodBeat.o(66331);
    return locale;
  }
  
  private h aI(Map<String, String> paramMap)
  {
    AppMethodBeat.i(66332);
    h localh = new h();
    localh.MzB = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    localh.MzM = ((String)paramMap.get(".sysmsg.paymsg.good_name"));
    localh.MzN = ((String)paramMap.get(".sysmsg.paymsg.total_fee"));
    localh.hMy = ((String)paramMap.get(".sysmsg.paymsg.req_key"));
    localh.id = ((String)paramMap.get(".sysmsg.paymsg.id"));
    paramMap = (String)paramMap.get(".sysmsg.paymsg.confirm_type");
    Log.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + localh.xld);
    if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals("1"))) {}
    for (localh.xld = 1;; localh.xld = 0)
    {
      AppMethodBeat.o(66332);
      return localh;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(66324);
    if (this.eNV == null) {
      this.eNV = new ArrayList();
    }
    this.eNV.add(new WeakReference(parama));
    AppMethodBeat.o(66324);
  }
  
  public final void aQA(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(269128);
    Map localMap = XmlParser.parseXml(paramString, "sysmsg", null);
    if (localMap == null)
    {
      AppMethodBeat.o(269128);
      return;
    }
    int i = Util.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    if (i == 20) {
      paramString = new j(localMap);
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramString.MzB = i;
        paramString.hAT = ((String)localMap.get(".sysmsg.paymsg.req_key"));
        paramString.MzC = ((String)localMap.get(".sysmsg.paymsg.ack_key"));
        a(paramString);
      }
      AppMethodBeat.o(269128);
      return;
      if (i == 5)
      {
        paramString = aF(localMap);
      }
      else if (i == 6)
      {
        paramString = aG(localMap);
      }
      else if (i == 8)
      {
        paramString = aI(localMap);
      }
      else if (i == 4)
      {
        paramString = aE(localMap);
      }
      else if (i == 23)
      {
        paramString = aH(localMap);
      }
      else if (i == 24)
      {
        paramString = aD(localMap);
      }
      else
      {
        paramString = localObject;
        if (i == 42) {
          paramString = new c(localMap);
        }
      }
    }
  }
  
  public final void aQB(String arg1)
  {
    AppMethodBeat.i(66326);
    com.tencent.mm.plugin.offline.c.d.aQT("");
    com.tencent.mm.plugin.offline.c.d.aQV("");
    com.tencent.mm.plugin.offline.c.d.aQU("");
    Object localObject = XmlParser.parseXml(???, "sysmsg", null);
    if (localObject == null)
    {
      AppMethodBeat.o(66326);
      return;
    }
    int j = Util.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    int i = Util.getInt((String)((Map)localObject).get(".sysmsg.paymsg.pay_cmd"), -1);
    String str = (String)((Map)localObject).get(".sysmsg.paymsg.req_key");
    com.tencent.mm.plugin.offline.c.d.aQT((String)((Map)localObject).get(".sysmsg.paymsg.ack_key"));
    com.tencent.mm.plugin.offline.c.d.afj(j);
    com.tencent.mm.plugin.offline.c.d.aQU(str);
    j = Util.getInt((String)((Map)localObject).get(".sysmsg.paymsg.PayMsgType"), -1);
    Log.i("MicroMsg.WalletOfflineMsgManager", "msg type is ".concat(String.valueOf(j)));
    Log.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", new Object[] { Integer.valueOf(j), ??? });
    if ((j >= 0) && (j == 4))
    {
      a(aE((Map)localObject));
      com.tencent.mm.plugin.offline.c.d.aQK(???);
      AppMethodBeat.o(66326);
      return;
    }
    if ((j >= 0) && (j == 5))
    {
      if (i != 1) {
        break label636;
      }
      Log.i("MicroMsg.WalletOfflineMsgManager", "payCmd is PAY_CMD_OFFLINE_PAY_REFRESH_TOKEN (value is 1), refresh offline token");
      k.gvj();
      k.gvm().kp(4, 4);
    }
    label636:
    for (boolean bool = false;; bool = true)
    {
      ??? = aF((Map)localObject);
      ???.MzJ = bool;
      a(???);
      AppMethodBeat.o(66326);
      return;
      if ((j >= 0) && (j == 6))
      {
        str = (String)((Map)localObject).get(".sysmsg.paymsg.transid");
        Log.i("helios", "MSG_TYPE_ORDER trasid=".concat(String.valueOf(str)));
        if (!Util.isNullOrNil(str))
        {
          h.baF();
          h.baE().ban().set(at.a.acOf, Boolean.TRUE);
        }
        Log.i("MicroMsg.WalletOfflineMsgManager", "orders xml: %s", new Object[] { ??? });
        a(aG((Map)localObject));
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 7))
      {
        com.tencent.mm.plugin.wallet_core.model.u.iiC().aNm();
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 8))
      {
        a(aI((Map)localObject));
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 10))
      {
        k.gvj();
        k.gvm().kp(4, 4);
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 20))
      {
        ??? = new adb();
        ???.ihc.ihd = new i((Map)localObject);
        ???.publish();
        AppMethodBeat.o(66326);
        return;
      }
      if ((j >= 0) && (j == 23))
      {
        localObject = aH((Map)localObject);
        synchronized (this.Mzu)
        {
          if (this.Mzu.contains(((e)localObject).hMy))
          {
            Log.i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", new Object[] { ((e)localObject).hMy });
            AppMethodBeat.o(66326);
            return;
          }
          this.Mzu.add(((e)localObject).hMy);
          a((d)localObject);
          AppMethodBeat.o(66326);
          return;
        }
      }
      if ((j >= 0) && (j == 24))
      {
        a(aD(localMap));
        AppMethodBeat.o(66326);
        return;
      }
      AppMethodBeat.o(66326);
      return;
    }
  }
  
  public final void aQC(String paramString)
  {
    AppMethodBeat.i(66333);
    int i = Util.getInt((String)XmlParser.parseXml(paramString, "sysmsg", null).get(".sysmsg.paymsg.PayMsgType"), -1);
    paramString = new HashSet();
    paramString.add(Integer.valueOf(g.MxJ));
    paramString.add(Integer.valueOf(g.MxI));
    paramString.add(Integer.valueOf(g.MxK));
    paramString.add(Integer.valueOf(g.MxH));
    paramString.add(Integer.valueOf(g.MxE));
    if (paramString.contains(Integer.valueOf(i))) {
      h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66320);
          Log.v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
          h.baF();
          h.baD().mCm.a(new d(this.Mzv), 0);
          AppMethodBeat.o(66320);
        }
      });
    }
    AppMethodBeat.o(66333);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(66325);
    if ((this.eNV == null) || (parama == null))
    {
      AppMethodBeat.o(66325);
      return;
    }
    int i = 0;
    while (i < this.eNV.size())
    {
      WeakReference localWeakReference = (WeakReference)this.eNV.get(i);
      if (localWeakReference != null)
      {
        a locala = (a)localWeakReference.get();
        if ((locala != null) && (locala.equals(parama)))
        {
          this.eNV.remove(localWeakReference);
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
    public abstract boolean onNotify(u.d paramd);
  }
  
  public final class b
    extends u.d
  {
    public String Mzx;
    public String Mzy;
    public String Mzz;
    
    public b()
    {
      super();
    }
  }
  
  public final class c
    extends u.d
  {
    public String MzA;
    
    public c()
    {
      super();
      AppMethodBeat.i(269116);
      Object localObject;
      this.MzA = ((String)localObject.get(".sysmsg.paymsg.PayMsgInfo"));
      AppMethodBeat.o(269116);
    }
  }
  
  public class d
  {
    public int MzB;
    public String MzC;
    public String hAT;
    
    public d() {}
  }
  
  public final class e
    extends u.d
  {
    public String hMy;
    
    public e()
    {
      super();
    }
  }
  
  public final class f
    extends u.d
  {
    public String MzD;
    public String MzE;
    public String MzF;
    public String MzG;
    public String MzH;
    public int MzI;
    public boolean MzJ = true;
    
    public f()
    {
      super();
    }
  }
  
  public final class g
    extends u.d
  {
    public String MzK;
    public Orders MzL;
    public u.i ihd;
    
    public g()
    {
      super();
    }
  }
  
  public final class h
    extends u.d
  {
    public String MzM;
    public String MzN;
    public String hMy;
    public String id;
    public int xld;
    
    public h()
    {
      super();
    }
  }
  
  public final class i
  {
    public boolean MzO;
    public String igC;
    public String igD;
    public String igE;
    public String igF;
    public String igG;
    
    public i()
    {
      AppMethodBeat.i(66321);
      Object localObject;
      this.igC = ((String)localObject.get(".sysmsg.paymsg.guide_flag"));
      this.igD = ((String)localObject.get(".sysmsg.paymsg.guide_wording"));
      this.igE = ((String)localObject.get(".sysmsg.paymsg.left_button_wording"));
      this.igF = ((String)localObject.get(".sysmsg.paymsg.right_button_wording"));
      this.igG = ((String)localObject.get(".sysmsg.paymsg.upload_credit_url"));
      if ("1".equals(localObject.get(".sysmsg.paymsg.guide_block"))) {}
      for (boolean bool = true;; bool = false)
      {
        this.MzO = bool;
        AppMethodBeat.o(66321);
        return;
      }
    }
  }
  
  public final class j
    extends u.d
  {
    public u.i ihd;
    
    public j()
    {
      super();
      AppMethodBeat.i(269117);
      Map localMap;
      this.ihd = new u.i(u.this, localMap);
      AppMethodBeat.o(269117);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.u
 * JD-Core Version:    0.7.0.1
 */