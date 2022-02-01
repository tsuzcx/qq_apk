package com.tencent.mm.plugin.remittance.a;

import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.n;
import com.tencent.mm.g.a.km;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.widget.a.f.c;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
  implements n, ax, i.a, com.tencent.mm.plugin.messenger.foundation.a.g
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private k.a hJv;
  private cd.a qdQ;
  private ac xRG;
  public com.tencent.mm.plugin.remittance.b.b xRH;
  private com.tencent.mm.plugin.remittance.b.d xRI;
  public CharSequence xRJ;
  private com.tencent.mm.sdk.b.c<pz> xRK;
  private com.tencent.mm.sdk.b.c<yv> xRL;
  private com.tencent.mm.sdk.b.c<km> xRM;
  
  static
  {
    AppMethodBeat.i(67351);
    com.tencent.mm.wallet_core.a.i("RemittanceProcess", a.class);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("DelayTransferRecord".hashCode()), new c.1());
    baseDBFactories.put(Integer.valueOf("RemittanceRecord".hashCode()), new c.3());
    AppMethodBeat.o(67351);
  }
  
  public c()
  {
    AppMethodBeat.i(67343);
    this.xRG = null;
    this.xRH = null;
    this.xRI = null;
    this.hJv = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(67338);
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString)))
        {
          paramAnonymousString = com.tencent.mm.model.c.d.aDs().wz("100324");
          if ((!paramAnonymousString.isValid()) || (!"1".equals(paramAnonymousString.foF().get("open")))) {
            break label172;
          }
        }
        label172:
        for (int i = 1;; i = 0)
        {
          paramAnonymousString = com.tencent.mm.kernel.g.ajC().ajl();
          paramAnonymousString.set(al.a.IBR, Integer.valueOf(i));
          int j = ((Integer)paramAnonymousString.get(al.a.IBS, Integer.valueOf(0))).intValue();
          ad.i("MicroMsg.SubCoreRemittance", "receive abtest open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (j == 0)
          {
            com.tencent.mm.z.c.aht().b(al.a.IBM, true);
            paramAnonymousString.set(al.a.IBS, Integer.valueOf(1));
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBN, Boolean.FALSE);
          }
          AppMethodBeat.o(67338);
          return;
        }
      }
    };
    this.qdQ = new cd.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(67339);
        ad.i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
        Object localObject1 = paramAnonymousa.gqE;
        if (localObject1 == null)
        {
          ad.e("MicroMsg.SubCoreRemittance", "recieve a null msg");
          AppMethodBeat.o(67339);
          return;
        }
        paramAnonymousa = z.a(((cv)localObject1).Fvk);
        if (bt.isNullOrNil(paramAnonymousa))
        {
          ad.e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
          AppMethodBeat.o(67339);
          return;
        }
        paramAnonymousa = bw.M(paramAnonymousa, "sysmsg");
        if (paramAnonymousa == null)
        {
          ad.e("MicroMsg.SubCoreRemittance", "Resolve msg error");
          AppMethodBeat.o(67339);
          return;
        }
        Object localObject3 = (String)paramAnonymousa.get(".sysmsg.paymsg.PayMsgType");
        if ("15".equals(localObject3))
        {
          localObject1 = URLDecoder.decode((String)paramAnonymousa.get(".sysmsg.paymsg.appmsgcontent"));
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            ad.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
            AppMethodBeat.o(67339);
            return;
          }
          localObject3 = bw.M((String)localObject1, "msg");
          if (localObject3 == null)
          {
            ad.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
            AppMethodBeat.o(67339);
            return;
          }
          localObject3 = (String)((Map)localObject3).get(".msg.appmsg.wcpayinfo.transferid");
          if (bt.isNullOrNil((String)localObject3))
          {
            ad.e("MicroMsg.SubCoreRemittance", "paymsgid is null");
            AppMethodBeat.o(67339);
            return;
          }
          if (c.this.dIE().awo((String)localObject3))
          {
            ad.e("MicroMsg.SubCoreRemittance", "it is a duplicate msg");
            AppMethodBeat.o(67339);
            return;
          }
          paramAnonymousa = (String)paramAnonymousa.get(".sysmsg.paymsg.tousername");
          if ((bt.isNullOrNil((String)localObject1)) || (bt.isNullOrNil(paramAnonymousa)))
          {
            ad.e("MicroMsg.SubCoreRemittance", "onRecieveMsg get a illegal msg,which content or toUserName is null");
            AppMethodBeat.o(67339);
            return;
          }
          c.this.dIE().au((String)localObject3, (String)localObject1, paramAnonymousa);
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
            if (bt.isNullOrNil(str1))
            {
              ad.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
              AppMethodBeat.o(67339);
              return;
            }
          }
          catch (UnsupportedEncodingException paramAnonymousa)
          {
            ad.printErrStackTrace("MicroMsg.SubCoreRemittance", paramAnonymousa, "", new Object[0]);
            AppMethodBeat.o(67339);
            return;
          }
          paramAnonymousa = bw.M(str1, "msg");
          if (paramAnonymousa == null)
          {
            ad.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
            AppMethodBeat.o(67339);
            return;
          }
          localObject3 = (String)paramAnonymousa.get(".msg.appmsg.wcpayinfo.transferid");
          i = bt.getInt((String)paramAnonymousa.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
          ad.i("MicroMsg.SubCoreRemittance", "receive delay transfer newxml, fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", new Object[] { str2, localObject1, localObject3, Integer.valueOf(i) });
          paramAnonymousa = null;
          try
          {
            c.dIB();
            localObject1 = c.dIC().awg((String)localObject3);
            paramAnonymousa = (e.a)localObject1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.SubCoreRemittance", localException, "", new Object[0]);
            }
            localObject2 = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(paramAnonymousa.field_msgId);
            if (((ei)localObject2).field_msgId > 0L) {
              break label599;
            }
            ad.i("MicroMsg.SubCoreRemittance", "has delete msg");
            c.dIB();
            c.dIC().delete(paramAnonymousa, new String[0]);
            AppMethodBeat.o(67339);
            return;
            ad.i("MicroMsg.SubCoreRemittance", "update msg: %s", new Object[] { Long.valueOf(((ei)localObject2).field_msgId) });
            ((bu)localObject2).setContent(str1);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(((ei)localObject2).field_msgId, (bu)localObject2);
            paramAnonymousa = c.dID().awh((String)localObject3);
            if (paramAnonymousa == null) {
              break label693;
            }
          }
          if (paramAnonymousa == null)
          {
            ad.i("MicroMsg.SubCoreRemittance", "empty record");
            AppMethodBeat.o(67339);
            return;
          }
          label599:
          paramAnonymousa.field_receiveStatus = i;
          c.dID().a(paramAnonymousa);
          for (;;)
          {
            c.awe(((ei)localObject2).field_talker);
            AppMethodBeat.o(67339);
            return;
            label693:
            if (!((ei)localObject2).field_talker.equals(u.aAm()))
            {
              paramAnonymousa = new com.tencent.mm.plugin.remittance.b.c();
              paramAnonymousa.field_locaMsgId = ((ei)localObject2).field_msgId;
              paramAnonymousa.field_transferId = ((String)localObject3);
              paramAnonymousa.field_receiveStatus = i;
              paramAnonymousa.field_isSend = false;
              paramAnonymousa.field_talker = ((ei)localObject2).field_talker;
              c.dID().a(paramAnonymousa);
            }
          }
        }
        if ("25".equals(localObject3))
        {
          ad.i("MicroMsg.SubCoreRemittance", "parse transfer outtime msg");
          localObject2 = bt.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.transferid"));
          paramAnonymousa = bt.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.fromusername"));
          localObject2 = c.dID().awi((String)localObject2);
          if (localObject2 != null)
          {
            ((com.tencent.mm.plugin.remittance.b.c)localObject2).field_receiveStatus = 2;
            c.dID().a((com.tencent.mm.plugin.remittance.b.c)localObject2);
            if (!paramAnonymousa.equals(u.aAm())) {
              c.awe(paramAnonymousa);
            }
          }
          AppMethodBeat.o(67339);
          return;
        }
        if ("33".equals(localObject3))
        {
          i = bt.getInt((String)paramAnonymousa.get(".sysmsg.paymsg.opentransferbankcard"), 0);
          paramAnonymousa = com.tencent.mm.kernel.g.ajC().ajl();
          paramAnonymousa.set(al.a.IBR, Integer.valueOf(i));
          int j = ((Integer)paramAnonymousa.get(al.a.IBS, Integer.valueOf(0))).intValue();
          ad.i("MicroMsg.SubCoreRemittance", "receive open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (j == 0)
          {
            com.tencent.mm.z.c.aht().b(al.a.IBM, true);
            paramAnonymousa.set(al.a.IBS, Integer.valueOf(1));
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBN, Boolean.FALSE);
          }
          AppMethodBeat.o(67339);
          return;
        }
        if ("45".equals(localObject3))
        {
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzC, 1) == 0)
          {
            ad.i("MicroMsg.SubCoreRemittance", "needOpenSwitch is close ");
            AppMethodBeat.o(67339);
            return;
          }
          localObject3 = bt.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.transferid"));
          str1 = bt.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.fromusername"));
          str2 = bt.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.content"));
          paramAnonymousa = bt.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.transfer_msg_type"));
          ad.i("MicroMsg.SubCoreRemittance", "parse transfer remind receive msg：transferid：%s,msgType ：%s", new Object[] { localObject3, paramAnonymousa });
          Object localObject4 = c.dID().awi((String)localObject3);
          if (localObject4 != null)
          {
            if (((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(((com.tencent.mm.plugin.remittance.b.c)localObject4).field_locaMsgId).field_msgId <= 0L)
            {
              ad.i("MicroMsg.SubCoreRemittance", " msg has delete，dont insert remind msg");
              com.tencent.mm.plugin.report.service.g.yhR.f(20467, new Object[] { "transfer_to_change", "dont show message", "", "", "", "", Integer.valueOf(2), localObject3, paramAnonymousa });
              AppMethodBeat.o(67339);
              return;
            }
            ad.i("MicroMsg.SubCoreRemittance", "insert new remind msg");
            localObject4 = new bu();
            ((bu)localObject4).kr(0);
            ((bu)localObject4).tN(str1);
            ((bu)localObject4).setContent(str2);
            ((bu)localObject4).qA(bj.B(str1, ((cv)localObject2).CreateTime));
            ((bu)localObject4).setType(10000);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().as((bu)localObject4);
            com.tencent.mm.plugin.report.service.g.yhR.f(20467, new Object[] { "transfer_to_change", "show message", "", "", "", "", Integer.valueOf(1), localObject3, paramAnonymousa });
            AppMethodBeat.o(67339);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(20467, new Object[] { "transfer_to_change", "dont show message", "", "", "", "", Integer.valueOf(2), localObject3, paramAnonymousa });
          ad.i("MicroMsg.SubCoreRemittance", "remittanceRecord is null, dont insert remind msg");
        }
        AppMethodBeat.o(67339);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.xRK = new com.tencent.mm.sdk.b.c() {};
    this.xRL = new com.tencent.mm.sdk.b.c() {};
    this.xRM = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(67343);
  }
  
  private static boolean awd(String paramString)
  {
    AppMethodBeat.i(199118);
    paramString = dID().awj(paramString);
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramString.iterator();
      com.tencent.mm.plugin.remittance.b.c localc;
      bu localbu;
      long l;
      do
      {
        for (;;)
        {
          if (!paramString.hasNext()) {
            break label227;
          }
          localc = (com.tencent.mm.plugin.remittance.b.c)paramString.next();
          localbu = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(localc.field_locaMsgId);
          l = localc.field_invalidtime * 1000L - cf.aCM();
          ad.i("MicroMsg.SubCoreRemittance", "remittance status: %s, %s, %s", new Object[] { Integer.valueOf(localc.field_receiveStatus), Long.valueOf(localbu.field_msgId), localbu.field_talker });
          if ((l >= 0L) || ((localc.field_receiveStatus != 1) && (localc.field_receiveStatus != 7))) {
            break;
          }
          ad.i("MicroMsg.SubCoreRemittance", "timeout, change status");
          localc.field_receiveStatus = 2;
          dID().a(localc);
        }
      } while ((localbu.field_msgId <= 0L) || (l < 0L) || ((localc.field_receiveStatus != 1) && (localc.field_receiveStatus != 7)));
    }
    label227:
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(199118);
      return bool;
    }
  }
  
  public static void awe(String paramString)
  {
    AppMethodBeat.i(199119);
    boolean bool = awd(paramString);
    at localat = ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTz(paramString);
    if ((localat != null) && (!w.vF(paramString)))
    {
      ad.i("MicroMsg.SubCoreRemittance", "update red flag: %s, %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (bool)
      {
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().a(paramString, 268435456, true, localat.field_attrflag);
        AppMethodBeat.o(199119);
        return;
      }
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().a(paramString, 268435456, false, localat.field_attrflag);
    }
    AppMethodBeat.o(199119);
  }
  
  public static c dIB()
  {
    AppMethodBeat.i(67344);
    c localc = (c)t.ap(c.class);
    AppMethodBeat.o(67344);
    return localc;
  }
  
  public static com.tencent.mm.plugin.remittance.b.b dIC()
  {
    AppMethodBeat.i(67345);
    if (dIB().xRH == null)
    {
      localObject = dIB();
      com.tencent.mm.kernel.g.ajD();
      ((c)localObject).xRH = new com.tencent.mm.plugin.remittance.b.b(com.tencent.mm.kernel.g.ajC().gBq);
    }
    Object localObject = dIB().xRH;
    AppMethodBeat.o(67345);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.remittance.b.d dID()
  {
    AppMethodBeat.i(67346);
    if (dIB().xRI == null)
    {
      localObject = dIB();
      com.tencent.mm.kernel.g.ajD();
      ((c)localObject).xRI = new com.tencent.mm.plugin.remittance.b.d(com.tencent.mm.kernel.g.ajC().gBq);
    }
    Object localObject = dIB().xRI;
    AppMethodBeat.o(67346);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(199121);
    if (paramc.vKe.equals("delete"))
    {
      ad.i("MicroMsg.SubCoreRemittance", "update red flag when delete msg: %s", new Object[] { paramc.talker });
      awe(paramc.talker);
    }
    AppMethodBeat.o(199121);
  }
  
  public final void a(bu parambu, i.c paramc, boolean[] paramArrayOfBoolean) {}
  
  public final void a(bu parambu, at paramat, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(199120);
    if ((paramBoolean) && (!w.vF(paramat.field_username)))
    {
      paramBoolean = awd(paramat.field_username);
      ad.i("MicroMsg.SubCoreRemittance", "try mark red flag when new conv: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      if (paramBoolean) {
        paramat.lO(268435456);
      }
    }
    AppMethodBeat.o(199120);
  }
  
  public final void b(bu parambu, at paramat, boolean paramBoolean, i.c paramc) {}
  
  public void clearPluginData(int paramInt) {}
  
  public final ac dIE()
  {
    AppMethodBeat.i(67349);
    if (this.xRG == null) {
      this.xRG = new ac();
    }
    ac localac = this.xRG;
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
    if (this.xRG != null) {
      localac = this.xRG;
    }
    synchronized (localac.lock)
    {
      localac.xZG.clear();
      com.tencent.mm.model.c.d.aDs().add(this.hJv);
      ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("paymsg", this.qdQ, true);
      com.tencent.mm.sdk.b.a.IbL.b(this.xRK);
      com.tencent.mm.sdk.b.a.IbL.b(this.xRL);
      com.tencent.mm.sdk.b.a.IbL.b(this.xRM);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().a(this);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this, null);
      AppForegroundDelegate.cSQ.a(this);
      AppMethodBeat.o(67347);
      return;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(67348);
    com.tencent.mm.model.c.d.aDs().remove(this.hJv);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("paymsg", this.qdQ, true);
    com.tencent.mm.sdk.b.a.IbL.d(this.xRK);
    com.tencent.mm.sdk.b.a.IbL.d(this.xRL);
    com.tencent.mm.sdk.b.a.IbL.d(this.xRM);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().b(this);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this);
    AppForegroundDelegate.cSQ.b(this);
    AppMethodBeat.o(67348);
  }
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(199122);
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199117);
        c.dIF();
        AppMethodBeat.o(199117);
      }
    });
    AppMethodBeat.o(199122);
  }
  
  public void onAppForeground(String paramString) {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.c
 * JD-Core Version:    0.7.0.1
 */