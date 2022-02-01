package com.tencent.mm.plugin.remittance.a;

import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.g.a.zb;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.widget.a.f.c;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
  implements o, az, i.a, com.tencent.mm.plugin.messenger.foundation.a.g
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private k.a hMo;
  private cf.a qkv;
  public com.tencent.mm.plugin.remittance.b.b yhA;
  private com.tencent.mm.plugin.remittance.b.d yhB;
  public CharSequence yhC;
  private com.tencent.mm.sdk.b.c<qa> yhD;
  private com.tencent.mm.sdk.b.c<zb> yhE;
  private com.tencent.mm.sdk.b.c<kn> yhF;
  private ac yhz;
  
  static
  {
    AppMethodBeat.i(67351);
    com.tencent.mm.wallet_core.a.i("RemittanceProcess", a.class);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("DelayTransferRecord".hashCode()), new c.1());
    baseDBFactories.put(Integer.valueOf("RemittanceRecord".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.remittance.b.d.SQL_CREATE;
      }
    });
    AppMethodBeat.o(67351);
  }
  
  public c()
  {
    AppMethodBeat.i(67343);
    this.yhz = null;
    this.yhA = null;
    this.yhB = null;
    this.hMo = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(67338);
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString)))
        {
          paramAnonymousString = com.tencent.mm.model.c.d.aDI().xi("100324");
          if ((!paramAnonymousString.isValid()) || (!"1".equals(paramAnonymousString.fsy().get("open")))) {
            break label172;
          }
        }
        label172:
        for (int i = 1;; i = 0)
        {
          paramAnonymousString = com.tencent.mm.kernel.g.ajR().ajA();
          paramAnonymousString.set(am.a.IWq, Integer.valueOf(i));
          int j = ((Integer)paramAnonymousString.get(am.a.IWr, Integer.valueOf(0))).intValue();
          ae.i("MicroMsg.SubCoreRemittance", "receive abtest open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (j == 0)
          {
            com.tencent.mm.y.c.ahI().b(am.a.IWl, true);
            paramAnonymousString.set(am.a.IWr, Integer.valueOf(1));
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWm, Boolean.FALSE);
          }
          AppMethodBeat.o(67338);
          return;
        }
      }
    };
    this.qkv = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(67339);
        ae.i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
        Object localObject1 = paramAnonymousa.gte;
        if (localObject1 == null)
        {
          ae.e("MicroMsg.SubCoreRemittance", "recieve a null msg");
          AppMethodBeat.o(67339);
          return;
        }
        paramAnonymousa = z.a(((cv)localObject1).FNI);
        if (bu.isNullOrNil(paramAnonymousa))
        {
          ae.e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
          AppMethodBeat.o(67339);
          return;
        }
        paramAnonymousa = bx.M(paramAnonymousa, "sysmsg");
        if (paramAnonymousa == null)
        {
          ae.e("MicroMsg.SubCoreRemittance", "Resolve msg error");
          AppMethodBeat.o(67339);
          return;
        }
        Object localObject3 = (String)paramAnonymousa.get(".sysmsg.paymsg.PayMsgType");
        if ("15".equals(localObject3))
        {
          localObject1 = URLDecoder.decode((String)paramAnonymousa.get(".sysmsg.paymsg.appmsgcontent"));
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            ae.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
            AppMethodBeat.o(67339);
            return;
          }
          localObject3 = bx.M((String)localObject1, "msg");
          if (localObject3 == null)
          {
            ae.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
            AppMethodBeat.o(67339);
            return;
          }
          localObject3 = (String)((Map)localObject3).get(".msg.appmsg.wcpayinfo.transferid");
          if (bu.isNullOrNil((String)localObject3))
          {
            ae.e("MicroMsg.SubCoreRemittance", "paymsgid is null");
            AppMethodBeat.o(67339);
            return;
          }
          if (c.this.dLV().axD((String)localObject3))
          {
            ae.e("MicroMsg.SubCoreRemittance", "it is a duplicate msg");
            AppMethodBeat.o(67339);
            return;
          }
          paramAnonymousa = (String)paramAnonymousa.get(".sysmsg.paymsg.tousername");
          if ((bu.isNullOrNil((String)localObject1)) || (bu.isNullOrNil(paramAnonymousa)))
          {
            ae.e("MicroMsg.SubCoreRemittance", "onRecieveMsg get a illegal msg,which content or toUserName is null");
            AppMethodBeat.o(67339);
            return;
          }
          c.this.dLV().au((String)localObject3, (String)localObject1, paramAnonymousa);
          AppMethodBeat.o(67339);
          return;
        }
        String str2;
        String str1;
        int i;
        Object localObject2;
        if ("22".equals(localObject3))
        {
          localObject1 = (String)paramAnonymousa.get(".sysmsg.paymsg.tousername");
          str2 = (String)paramAnonymousa.get(".sysmsg.paymsg.fromusername");
          try
          {
            str1 = URLDecoder.decode((String)paramAnonymousa.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
            if (bu.isNullOrNil(str1))
            {
              ae.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
              AppMethodBeat.o(67339);
              return;
            }
          }
          catch (UnsupportedEncodingException paramAnonymousa)
          {
            ae.printErrStackTrace("MicroMsg.SubCoreRemittance", paramAnonymousa, "", new Object[0]);
            AppMethodBeat.o(67339);
            return;
          }
          paramAnonymousa = bx.M(str1, "msg");
          if (paramAnonymousa == null)
          {
            ae.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
            AppMethodBeat.o(67339);
            return;
          }
          localObject3 = (String)paramAnonymousa.get(".msg.appmsg.wcpayinfo.transferid");
          i = bu.getInt((String)paramAnonymousa.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
          ae.i("MicroMsg.SubCoreRemittance", "receive delay transfer newxml, fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", new Object[] { str2, localObject1, localObject3, Integer.valueOf(i) });
          paramAnonymousa = null;
          try
          {
            c.dLS();
            localObject1 = c.dLT().axv((String)localObject3);
            paramAnonymousa = (e.a)localObject1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.SubCoreRemittance", localException, "", new Object[0]);
            }
            localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(paramAnonymousa.field_msgId);
            if (((ei)localObject2).field_msgId > 0L) {
              break label599;
            }
            ae.i("MicroMsg.SubCoreRemittance", "has delete msg");
            c.dLS();
            c.dLT().delete(paramAnonymousa, new String[0]);
            AppMethodBeat.o(67339);
            return;
            ae.i("MicroMsg.SubCoreRemittance", "update msg: %s", new Object[] { Long.valueOf(((ei)localObject2).field_msgId) });
            ((bv)localObject2).setContent(str1);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(((ei)localObject2).field_msgId, (bv)localObject2);
            paramAnonymousa = c.dLU().axw((String)localObject3);
            if (paramAnonymousa == null) {
              break label693;
            }
          }
          if (paramAnonymousa == null)
          {
            ae.i("MicroMsg.SubCoreRemittance", "empty record");
            AppMethodBeat.o(67339);
            return;
          }
          label599:
          paramAnonymousa.field_receiveStatus = i;
          c.dLU().a(paramAnonymousa);
          for (;;)
          {
            c.axt(((ei)localObject2).field_talker);
            AppMethodBeat.o(67339);
            return;
            label693:
            if (!((ei)localObject2).field_talker.equals(v.aAC()))
            {
              paramAnonymousa = new com.tencent.mm.plugin.remittance.b.c();
              paramAnonymousa.field_locaMsgId = ((ei)localObject2).field_msgId;
              paramAnonymousa.field_transferId = ((String)localObject3);
              paramAnonymousa.field_receiveStatus = i;
              paramAnonymousa.field_isSend = false;
              paramAnonymousa.field_talker = ((ei)localObject2).field_talker;
              c.dLU().a(paramAnonymousa);
            }
          }
        }
        if ("25".equals(localObject3))
        {
          ae.i("MicroMsg.SubCoreRemittance", "parse transfer outtime msg");
          localObject2 = bu.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.transferid"));
          paramAnonymousa = bu.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.fromusername"));
          localObject2 = c.dLU().axx((String)localObject2);
          if (localObject2 != null)
          {
            ((com.tencent.mm.plugin.remittance.b.c)localObject2).field_receiveStatus = 2;
            c.dLU().a((com.tencent.mm.plugin.remittance.b.c)localObject2);
            if (!paramAnonymousa.equals(v.aAC())) {
              c.axt(paramAnonymousa);
            }
          }
          AppMethodBeat.o(67339);
          return;
        }
        if ("33".equals(localObject3))
        {
          i = bu.getInt((String)paramAnonymousa.get(".sysmsg.paymsg.opentransferbankcard"), 0);
          paramAnonymousa = com.tencent.mm.kernel.g.ajR().ajA();
          paramAnonymousa.set(am.a.IWq, Integer.valueOf(i));
          int j = ((Integer)paramAnonymousa.get(am.a.IWr, Integer.valueOf(0))).intValue();
          ae.i("MicroMsg.SubCoreRemittance", "receive open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (j == 0)
          {
            com.tencent.mm.y.c.ahI().b(am.a.IWl, true);
            paramAnonymousa.set(am.a.IWr, Integer.valueOf(1));
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWm, Boolean.FALSE);
          }
          AppMethodBeat.o(67339);
          return;
        }
        if ("45".equals(localObject3))
        {
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGJ, 1) == 0)
          {
            ae.i("MicroMsg.SubCoreRemittance", "needOpenSwitch is close ");
            AppMethodBeat.o(67339);
            return;
          }
          localObject3 = bu.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.transferid"));
          str1 = bu.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.fromusername"));
          str2 = bu.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.content"));
          paramAnonymousa = bu.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.transfer_msg_type"));
          ae.i("MicroMsg.SubCoreRemittance", "parse transfer remind receive msg：transferid：%s,msgType ：%s", new Object[] { localObject3, paramAnonymousa });
          Object localObject4 = c.dLU().axx((String)localObject3);
          if (localObject4 != null)
          {
            if (((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(((com.tencent.mm.plugin.remittance.b.c)localObject4).field_locaMsgId).field_msgId <= 0L)
            {
              ae.i("MicroMsg.SubCoreRemittance", " msg has delete，dont insert remind msg");
              com.tencent.mm.plugin.report.service.g.yxI.f(20467, new Object[] { "transfer_to_change", "dont show message", "", "", "", "", Integer.valueOf(2), localObject3, paramAnonymousa });
              AppMethodBeat.o(67339);
              return;
            }
            ae.i("MicroMsg.SubCoreRemittance", "insert new remind msg");
            localObject4 = new bv();
            ((bv)localObject4).kt(0);
            ((bv)localObject4).ui(str1);
            ((bv)localObject4).setContent(str2);
            ((bv)localObject4).qN(bl.B(str1, ((cv)localObject2).CreateTime));
            ((bv)localObject4).setType(10000);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ar((bv)localObject4);
            com.tencent.mm.plugin.report.service.g.yxI.f(20467, new Object[] { "transfer_to_change", "show message", "", "", "", "", Integer.valueOf(1), localObject3, paramAnonymousa });
            AppMethodBeat.o(67339);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(20467, new Object[] { "transfer_to_change", "dont show message", "", "", "", "", Integer.valueOf(2), localObject3, paramAnonymousa });
          ae.i("MicroMsg.SubCoreRemittance", "remittanceRecord is null, dont insert remind msg");
        }
        AppMethodBeat.o(67339);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.yhD = new com.tencent.mm.sdk.b.c() {};
    this.yhE = new com.tencent.mm.sdk.b.c() {};
    this.yhF = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(67343);
  }
  
  private static boolean axs(String paramString)
  {
    AppMethodBeat.i(189953);
    paramString = dLU().axy(paramString);
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramString.iterator();
      com.tencent.mm.plugin.remittance.b.c localc;
      bv localbv;
      long l;
      do
      {
        for (;;)
        {
          if (!paramString.hasNext()) {
            break label227;
          }
          localc = (com.tencent.mm.plugin.remittance.b.c)paramString.next();
          localbv = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(localc.field_locaMsgId);
          l = localc.field_invalidtime * 1000L - ch.aDc();
          ae.i("MicroMsg.SubCoreRemittance", "remittance status: %s, %s, %s", new Object[] { Integer.valueOf(localc.field_receiveStatus), Long.valueOf(localbv.field_msgId), localbv.field_talker });
          if ((l >= 0L) || ((localc.field_receiveStatus != 1) && (localc.field_receiveStatus != 7))) {
            break;
          }
          ae.i("MicroMsg.SubCoreRemittance", "timeout, change status");
          localc.field_receiveStatus = 2;
          dLU().a(localc);
        }
      } while ((localbv.field_msgId <= 0L) || (l < 0L) || ((localc.field_receiveStatus != 1) && (localc.field_receiveStatus != 7)));
    }
    label227:
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(189953);
      return bool;
    }
  }
  
  public static void axt(String paramString)
  {
    AppMethodBeat.i(189954);
    boolean bool = axs(paramString);
    au localau = ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVa(paramString);
    if ((localau != null) && (!x.wb(paramString)))
    {
      ae.i("MicroMsg.SubCoreRemittance", "update red flag: %s, %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (bool)
      {
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().a(paramString, 268435456, true, localau.field_attrflag);
        AppMethodBeat.o(189954);
        return;
      }
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().a(paramString, 268435456, false, localau.field_attrflag);
    }
    AppMethodBeat.o(189954);
  }
  
  public static c dLS()
  {
    AppMethodBeat.i(67344);
    c localc = (c)u.ap(c.class);
    AppMethodBeat.o(67344);
    return localc;
  }
  
  public static com.tencent.mm.plugin.remittance.b.b dLT()
  {
    AppMethodBeat.i(67345);
    if (dLS().yhA == null)
    {
      localObject = dLS();
      com.tencent.mm.kernel.g.ajS();
      ((c)localObject).yhA = new com.tencent.mm.plugin.remittance.b.b(com.tencent.mm.kernel.g.ajR().gDX);
    }
    Object localObject = dLS().yhA;
    AppMethodBeat.o(67345);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.remittance.b.d dLU()
  {
    AppMethodBeat.i(67346);
    if (dLS().yhB == null)
    {
      localObject = dLS();
      com.tencent.mm.kernel.g.ajS();
      ((c)localObject).yhB = new com.tencent.mm.plugin.remittance.b.d(com.tencent.mm.kernel.g.ajR().gDX);
    }
    Object localObject = dLS().yhB;
    AppMethodBeat.o(67346);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(189956);
    if (paramc.vWi.equals("delete"))
    {
      ae.i("MicroMsg.SubCoreRemittance", "update red flag when delete msg: %s", new Object[] { paramc.talker });
      axt(paramc.talker);
    }
    AppMethodBeat.o(189956);
  }
  
  public final void a(bv parambv, i.c paramc, boolean[] paramArrayOfBoolean) {}
  
  public final void a(bv parambv, au paramau, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(189955);
    if ((paramBoolean) && (!x.wb(paramau.field_username)))
    {
      paramBoolean = axs(paramau.field_username);
      ae.i("MicroMsg.SubCoreRemittance", "try mark red flag when new conv: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      if (paramBoolean) {
        paramau.lQ(268435456);
      }
    }
    AppMethodBeat.o(189955);
  }
  
  public final void b(bv parambv, au paramau, boolean paramBoolean, i.c paramc) {}
  
  public void clearPluginData(int paramInt) {}
  
  public final ac dLV()
  {
    AppMethodBeat.i(67349);
    if (this.yhz == null) {
      this.yhz = new ac();
    }
    ac localac = this.yhz;
    AppMethodBeat.o(67349);
    return localac;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(67347);
    ac localac;
    if (this.yhz != null) {
      localac = this.yhz;
    }
    synchronized (localac.lock)
    {
      localac.ypy.clear();
      com.tencent.mm.model.c.d.aDI().add(this.hMo);
      ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("paymsg", this.qkv, true);
      com.tencent.mm.sdk.b.a.IvT.b(this.yhD);
      com.tencent.mm.sdk.b.a.IvT.b(this.yhE);
      com.tencent.mm.sdk.b.a.IvT.b(this.yhF);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().a(this);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this, null);
      AppForegroundDelegate.cTA.a(this);
      AppMethodBeat.o(67347);
      return;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(67348);
    com.tencent.mm.model.c.d.aDI().remove(this.hMo);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("paymsg", this.qkv, true);
    com.tencent.mm.sdk.b.a.IvT.d(this.yhD);
    com.tencent.mm.sdk.b.a.IvT.d(this.yhE);
    com.tencent.mm.sdk.b.a.IvT.d(this.yhF);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().b(this);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this);
    AppForegroundDelegate.cTA.b(this);
    AppMethodBeat.o(67348);
  }
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(189957);
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189952);
        c.dLW();
        AppMethodBeat.o(189952);
      }
    });
    AppMethodBeat.o(189957);
  }
  
  public void onAppForeground(String paramString) {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.c
 * JD-Core Version:    0.7.0.1
 */