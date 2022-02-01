package com.tencent.mm.plugin.remittance.a;

import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.n;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.c.az;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.remittance.b.b;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storagebase.h.b;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
  implements n, aw, h.a, f
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private k.a hrd;
  private cc.a pAl;
  private com.tencent.mm.plugin.remittance.model.ac wDZ;
  public b wEa;
  private com.tencent.mm.plugin.remittance.b.d wEb;
  public CharSequence wEc;
  private com.tencent.mm.sdk.b.c<pp> wEd;
  private com.tencent.mm.sdk.b.c<yb> wEe;
  private com.tencent.mm.sdk.b.c<ke> wEf;
  
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
    this.wDZ = null;
    this.wEa = null;
    this.wEb = null;
    this.hrd = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(67338);
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString)))
        {
          paramAnonymousString = com.tencent.mm.model.c.d.aAp().tJ("100324");
          if ((!paramAnonymousString.isValid()) || (!"1".equals(paramAnonymousString.eYV().get("open")))) {
            break label172;
          }
        }
        label172:
        for (int i = 1;; i = 0)
        {
          paramAnonymousString = g.agR().agA();
          paramAnonymousString.set(ah.a.GPw, Integer.valueOf(i));
          int j = ((Integer)paramAnonymousString.get(ah.a.GPx, Integer.valueOf(0))).intValue();
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SubCoreRemittance", "receive abtest open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (j == 0)
          {
            com.tencent.mm.y.c.aeH().b(ah.a.GPr, true);
            paramAnonymousString.set(ah.a.GPx, Integer.valueOf(1));
            g.agR().agA().set(ah.a.GPs, Boolean.FALSE);
          }
          AppMethodBeat.o(67338);
          return;
        }
      }
    };
    this.pAl = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(67339);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
        paramAnonymousa = paramAnonymousa.fXi;
        if (paramAnonymousa == null)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SubCoreRemittance", "recieve a null msg");
          AppMethodBeat.o(67339);
          return;
        }
        paramAnonymousa = z.a(paramAnonymousa.DPV);
        if (bs.isNullOrNil(paramAnonymousa))
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
          AppMethodBeat.o(67339);
          return;
        }
        paramAnonymousa = bv.L(paramAnonymousa, "sysmsg");
        if (paramAnonymousa == null)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SubCoreRemittance", "Resolve msg error");
          AppMethodBeat.o(67339);
          return;
        }
        Object localObject1 = (String)paramAnonymousa.get(".sysmsg.paymsg.PayMsgType");
        Object localObject3;
        if ("15".equals(localObject1))
        {
          localObject1 = URLDecoder.decode((String)paramAnonymousa.get(".sysmsg.paymsg.appmsgcontent"));
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
            AppMethodBeat.o(67339);
            return;
          }
          localObject3 = bv.L((String)localObject1, "msg");
          if (localObject3 == null)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
            AppMethodBeat.o(67339);
            return;
          }
          localObject3 = (String)((Map)localObject3).get(".msg.appmsg.wcpayinfo.transferid");
          if (bs.isNullOrNil((String)localObject3))
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SubCoreRemittance", "paymsgid is null");
            AppMethodBeat.o(67339);
            return;
          }
          if (c.this.dxm().aro((String)localObject3))
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SubCoreRemittance", "it is a duplicate msg");
            AppMethodBeat.o(67339);
            return;
          }
          paramAnonymousa = (String)paramAnonymousa.get(".sysmsg.paymsg.tousername");
          if ((bs.isNullOrNil((String)localObject1)) || (bs.isNullOrNil(paramAnonymousa)))
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SubCoreRemittance", "onRecieveMsg get a illegal msg,which content or toUserName is null");
            AppMethodBeat.o(67339);
            return;
          }
          c.this.dxm().am((String)localObject3, (String)localObject1, paramAnonymousa);
          AppMethodBeat.o(67339);
          return;
        }
        int i;
        Object localObject2;
        if ("22".equals(localObject1))
        {
          localObject1 = (String)paramAnonymousa.get(".sysmsg.paymsg.tousername");
          String str2 = (String)paramAnonymousa.get(".sysmsg.paymsg.fromusername");
          String str1;
          try
          {
            str1 = URLDecoder.decode((String)paramAnonymousa.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
            if (bs.isNullOrNil(str1))
            {
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
              AppMethodBeat.o(67339);
              return;
            }
          }
          catch (UnsupportedEncodingException paramAnonymousa)
          {
            com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.SubCoreRemittance", paramAnonymousa, "", new Object[0]);
            AppMethodBeat.o(67339);
            return;
          }
          paramAnonymousa = bv.L(str1, "msg");
          if (paramAnonymousa == null)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
            AppMethodBeat.o(67339);
            return;
          }
          localObject3 = (String)paramAnonymousa.get(".msg.appmsg.wcpayinfo.transferid");
          i = bs.getInt((String)paramAnonymousa.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SubCoreRemittance", "receive delay transfer newxml, fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", new Object[] { str2, localObject1, localObject3, Integer.valueOf(i) });
          paramAnonymousa = null;
          try
          {
            c.dxj();
            localObject1 = c.dxk().arg((String)localObject3);
            paramAnonymousa = (f.a)localObject1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.SubCoreRemittance", localException, "", new Object[0]);
            }
            localObject2 = ((k)g.ab(k.class)).dcr().vP(paramAnonymousa.field_msgId);
            if (((dy)localObject2).field_msgId > 0L) {
              break label596;
            }
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SubCoreRemittance", "has delete msg");
            c.dxj();
            c.dxk().delete(paramAnonymousa, new String[0]);
            AppMethodBeat.o(67339);
            return;
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SubCoreRemittance", "update msg: %s", new Object[] { Long.valueOf(((dy)localObject2).field_msgId) });
            ((bo)localObject2).setContent(str1);
            ((k)g.ab(k.class)).dcr().a(((dy)localObject2).field_msgId, (bo)localObject2);
            paramAnonymousa = c.dxl().arh((String)localObject3);
            if (paramAnonymousa == null) {
              break label690;
            }
          }
          if (paramAnonymousa == null)
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SubCoreRemittance", "empty record");
            AppMethodBeat.o(67339);
            return;
          }
          label596:
          paramAnonymousa.field_receiveStatus = i;
          c.dxl().a(paramAnonymousa);
          for (;;)
          {
            c.are(((dy)localObject2).field_talker);
            AppMethodBeat.o(67339);
            return;
            label690:
            if (!((dy)localObject2).field_talker.equals(u.axw()))
            {
              paramAnonymousa = new com.tencent.mm.plugin.remittance.b.c();
              paramAnonymousa.field_locaMsgId = ((dy)localObject2).field_msgId;
              paramAnonymousa.field_transferId = ((String)localObject3);
              paramAnonymousa.field_receiveStatus = i;
              paramAnonymousa.field_isSend = false;
              paramAnonymousa.field_talker = ((dy)localObject2).field_talker;
              c.dxl().a(paramAnonymousa);
            }
          }
        }
        if ("25".equals(localObject2))
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SubCoreRemittance", "parse transfer outtime msg");
          localObject2 = bs.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.transferid"));
          paramAnonymousa = bs.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.fromusername"));
          localObject2 = c.dxl().ari((String)localObject2);
          if (localObject2 != null)
          {
            ((com.tencent.mm.plugin.remittance.b.c)localObject2).field_receiveStatus = 2;
            c.dxl().a((com.tencent.mm.plugin.remittance.b.c)localObject2);
            if (!paramAnonymousa.equals(u.axw())) {
              c.are(paramAnonymousa);
            }
          }
          AppMethodBeat.o(67339);
          return;
        }
        if ("33".equals(localObject2))
        {
          i = bs.getInt((String)paramAnonymousa.get(".sysmsg.paymsg.opentransferbankcard"), 0);
          paramAnonymousa = g.agR().agA();
          paramAnonymousa.set(ah.a.GPw, Integer.valueOf(i));
          int j = ((Integer)paramAnonymousa.get(ah.a.GPx, Integer.valueOf(0))).intValue();
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SubCoreRemittance", "receive open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (j == 0)
          {
            com.tencent.mm.y.c.aeH().b(ah.a.GPr, true);
            paramAnonymousa.set(ah.a.GPx, Integer.valueOf(1));
            g.agR().agA().set(ah.a.GPs, Boolean.FALSE);
          }
        }
        AppMethodBeat.o(67339);
      }
      
      public final void a(com.tencent.mm.ak.f.c paramAnonymousc) {}
    };
    this.wEd = new com.tencent.mm.sdk.b.c() {};
    this.wEe = new com.tencent.mm.sdk.b.c() {};
    this.wEf = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(67343);
  }
  
  private static boolean ard(String paramString)
  {
    AppMethodBeat.i(207124);
    paramString = dxl().arj(paramString);
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramString.iterator();
      com.tencent.mm.plugin.remittance.b.c localc;
      bo localbo;
      long l;
      do
      {
        for (;;)
        {
          if (!paramString.hasNext()) {
            break label226;
          }
          localc = (com.tencent.mm.plugin.remittance.b.c)paramString.next();
          localbo = ((k)g.ab(k.class)).dcr().vP(localc.field_locaMsgId);
          l = localc.field_invalidtime * 1000L - ce.azJ();
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.SubCoreRemittance", "remittance status: %s, %s, %s", new Object[] { Integer.valueOf(localc.field_receiveStatus), Long.valueOf(localbo.field_msgId), Long.valueOf(l) });
          if ((l >= 0L) || ((localc.field_receiveStatus != 1) && (localc.field_receiveStatus != 7))) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SubCoreRemittance", "timeout, change status");
          localc.field_receiveStatus = 2;
          dxl().a(localc);
        }
      } while ((localbo.field_msgId <= 0L) || (l < 0L) || ((localc.field_receiveStatus != 1) && (localc.field_receiveStatus != 7)));
    }
    label226:
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(207124);
      return bool;
    }
  }
  
  public static void are(String paramString)
  {
    AppMethodBeat.i(207125);
    boolean bool = ard(paramString);
    ap localap = ((k)g.ab(k.class)).awG().aNI(paramString);
    if (localap != null)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SubCoreRemittance", "update red flag: %s, %s", new Object[] { paramString, Boolean.valueOf(bool) });
      if (bool)
      {
        ((k)g.ab(k.class)).awG().a(paramString, 268435456, true, localap.field_attrflag);
        AppMethodBeat.o(207125);
        return;
      }
      ((k)g.ab(k.class)).awG().a(paramString, 268435456, false, localap.field_attrflag);
    }
    AppMethodBeat.o(207125);
  }
  
  public static c dxj()
  {
    AppMethodBeat.i(67344);
    c localc = (c)t.ap(c.class);
    AppMethodBeat.o(67344);
    return localc;
  }
  
  public static b dxk()
  {
    AppMethodBeat.i(67345);
    if (dxj().wEa == null)
    {
      localObject = dxj();
      g.agS();
      ((c)localObject).wEa = new b(g.agR().ghG);
    }
    Object localObject = dxj().wEa;
    AppMethodBeat.o(67345);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.remittance.b.d dxl()
  {
    AppMethodBeat.i(67346);
    if (dxj().wEb == null)
    {
      localObject = dxj();
      g.agS();
      ((c)localObject).wEb = new com.tencent.mm.plugin.remittance.b.d(g.agR().ghG);
    }
    Object localObject = dxj().wEb;
    AppMethodBeat.o(67346);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h paramh, h.c paramc)
  {
    AppMethodBeat.i(207127);
    if (paramc.uHb.equals("delete"))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SubCoreRemittance", "update red flag when delete msg: %s", new Object[] { paramc.talker });
      are(paramc.talker);
    }
    AppMethodBeat.o(207127);
  }
  
  public final void a(bo parambo, ap paramap, boolean paramBoolean, h.c paramc)
  {
    AppMethodBeat.i(207126);
    if (paramBoolean)
    {
      paramBoolean = ard(paramap.field_username);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SubCoreRemittance", "try mark red flag when new conv: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      if (paramBoolean) {
        paramap.lp(268435456);
      }
    }
    AppMethodBeat.o(207126);
  }
  
  public final void b(bo parambo, ap paramap, boolean paramBoolean, h.c paramc) {}
  
  public void clearPluginData(int paramInt) {}
  
  public final com.tencent.mm.plugin.remittance.model.ac dxm()
  {
    AppMethodBeat.i(67349);
    if (this.wDZ == null) {
      this.wDZ = new com.tencent.mm.plugin.remittance.model.ac();
    }
    com.tencent.mm.plugin.remittance.model.ac localac = this.wDZ;
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
    com.tencent.mm.plugin.remittance.model.ac localac;
    if (this.wDZ != null) {
      localac = this.wDZ;
    }
    synchronized (localac.lock)
    {
      localac.wLZ.clear();
      com.tencent.mm.model.c.d.aAp().add(this.hrd);
      ((q)g.ad(q.class)).getSysCmdMsgExtension().a("paymsg", this.pAl, true);
      com.tencent.mm.sdk.b.a.GpY.b(this.wEd);
      com.tencent.mm.sdk.b.a.GpY.b(this.wEe);
      com.tencent.mm.sdk.b.a.GpY.b(this.wEf);
      ((k)g.ab(k.class)).awG().a(this);
      ((k)g.ab(k.class)).dcr().a(this, null);
      AppForegroundDelegate.cHM.a(this);
      AppMethodBeat.o(67347);
      return;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(67348);
    com.tencent.mm.model.c.d.aAp().remove(this.hrd);
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("paymsg", this.pAl, true);
    com.tencent.mm.sdk.b.a.GpY.d(this.wEd);
    com.tencent.mm.sdk.b.a.GpY.d(this.wEe);
    com.tencent.mm.sdk.b.a.GpY.d(this.wEf);
    ((k)g.ab(k.class)).awG().b(this);
    ((k)g.ab(k.class)).dcr().a(this);
    AppForegroundDelegate.cHM.b(this);
    AppMethodBeat.o(67348);
  }
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(207128);
    com.tencent.e.h.JZN.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207123);
        c.dxn();
        AppMethodBeat.o(207123);
      }
    });
    AppMethodBeat.o(207128);
  }
  
  public void onAppForeground(String paramString) {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.c
 * JD-Core Version:    0.7.0.1
 */