package com.tencent.mm.plugin.remittance.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.remittance.b.b;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storagebase.h.b;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class c
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private k.a gQD;
  private cc.a oXa;
  private ac vtU;
  public b vtV;
  private com.tencent.mm.plugin.remittance.b.d vtW;
  public CharSequence vtX;
  private com.tencent.mm.sdk.b.c<pg> vtY;
  private com.tencent.mm.sdk.b.c<xq> vtZ;
  private com.tencent.mm.sdk.b.c<jw> vua;
  
  static
  {
    AppMethodBeat.i(67351);
    com.tencent.mm.wallet_core.a.i("RemittanceProcess", a.class);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("DelayTransferRecord".hashCode()), new c.1());
    baseDBFactories.put(Integer.valueOf("RemittanceRecord".hashCode()), new c.2());
    AppMethodBeat.o(67351);
  }
  
  public c()
  {
    AppMethodBeat.i(67343);
    this.vtU = null;
    this.vtV = null;
    this.vtW = null;
    this.gQD = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(67338);
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString)))
        {
          paramAnonymousString = com.tencent.mm.model.c.d.aty().qu("100324");
          if ((!paramAnonymousString.isValid()) || (!"1".equals(paramAnonymousString.eJy().get("open")))) {
            break label172;
          }
        }
        label172:
        for (int i = 1;; i = 0)
        {
          paramAnonymousString = g.afB().afk();
          paramAnonymousString.set(ae.a.FrG, Integer.valueOf(i));
          int j = ((Integer)paramAnonymousString.get(ae.a.FrH, Integer.valueOf(0))).intValue();
          ad.i("MicroMsg.SubCoreRemittance", "receive abtest open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (j == 0)
          {
            com.tencent.mm.z.c.adr().b(ae.a.FrB, true);
            paramAnonymousString.set(ae.a.FrH, Integer.valueOf(1));
            g.afB().afk().set(ae.a.FrC, Boolean.FALSE);
          }
          AppMethodBeat.o(67338);
          return;
        }
      }
    };
    this.oXa = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(67339);
        ad.i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
        paramAnonymousa = paramAnonymousa.fTo;
        if (paramAnonymousa == null)
        {
          ad.e("MicroMsg.SubCoreRemittance", "recieve a null msg");
          AppMethodBeat.o(67339);
          return;
        }
        paramAnonymousa = z.a(paramAnonymousa.Cxz);
        if (bt.isNullOrNil(paramAnonymousa))
        {
          ad.e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
          AppMethodBeat.o(67339);
          return;
        }
        paramAnonymousa = bw.K(paramAnonymousa, "sysmsg");
        if (paramAnonymousa == null)
        {
          ad.e("MicroMsg.SubCoreRemittance", "Resolve msg error");
          AppMethodBeat.o(67339);
          return;
        }
        Object localObject1 = (String)paramAnonymousa.get(".sysmsg.paymsg.PayMsgType");
        Object localObject2;
        if ("15".equals(localObject1))
        {
          localObject1 = URLDecoder.decode((String)paramAnonymousa.get(".sysmsg.paymsg.appmsgcontent"));
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            ad.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
            AppMethodBeat.o(67339);
            return;
          }
          localObject2 = bw.K((String)localObject1, "msg");
          if (localObject2 == null)
          {
            ad.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
            AppMethodBeat.o(67339);
            return;
          }
          localObject2 = (String)((Map)localObject2).get(".msg.appmsg.wcpayinfo.transferid");
          if (bt.isNullOrNil((String)localObject2))
          {
            ad.e("MicroMsg.SubCoreRemittance", "paymsgid is null");
            AppMethodBeat.o(67339);
            return;
          }
          if (c.this.djm().amh((String)localObject2))
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
          c.this.djm().al((String)localObject2, (String)localObject1, paramAnonymousa);
          AppMethodBeat.o(67339);
          return;
        }
        String str1;
        int i;
        if ("22".equals(localObject1))
        {
          localObject1 = (String)paramAnonymousa.get(".sysmsg.paymsg.tousername");
          String str2 = (String)paramAnonymousa.get(".sysmsg.paymsg.fromusername");
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
          paramAnonymousa = bw.K(str1, "msg");
          if (paramAnonymousa == null)
          {
            ad.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
            AppMethodBeat.o(67339);
            return;
          }
          localObject2 = (String)paramAnonymousa.get(".msg.appmsg.wcpayinfo.transferid");
          i = bt.getInt((String)paramAnonymousa.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
          ad.i("MicroMsg.SubCoreRemittance", "receive delay transfer newxml, fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", new Object[] { str2, localObject1, localObject2, Integer.valueOf(i) });
          paramAnonymousa = null;
          try
          {
            c.djj();
            localObject1 = c.djk().amb((String)localObject2);
            paramAnonymousa = (f.a)localObject1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.SubCoreRemittance", localException, "", new Object[0]);
            }
            localbl = ((k)g.ab(k.class)).cOI().rm(paramAnonymousa.field_msgId);
            if (localbl.field_msgId > 0L) {
              break label596;
            }
            ad.i("MicroMsg.SubCoreRemittance", "has delete msg");
            c.djj();
            c.djk().delete(paramAnonymousa, new String[0]);
            AppMethodBeat.o(67339);
            return;
            ad.i("MicroMsg.SubCoreRemittance", "update msg: %s", new Object[] { Long.valueOf(localbl.field_msgId) });
            localbl.setContent(str1);
            ((k)g.ab(k.class)).cOI().a(localbl.field_msgId, localbl);
            paramAnonymousa = c.djl().amc((String)localObject2);
            if (paramAnonymousa == null) {
              break label682;
            }
            paramAnonymousa.field_receiveStatus = i;
            c.djl().a(paramAnonymousa);
            AppMethodBeat.o(67339);
            return;
            if (localbl.field_talker.equals(u.aqG())) {
              break label737;
            }
            paramAnonymousa = new com.tencent.mm.plugin.remittance.b.c();
            paramAnonymousa.field_locaMsgId = localbl.field_msgId;
            paramAnonymousa.field_transferId = ((String)localObject2);
            paramAnonymousa.field_receiveStatus = i;
            paramAnonymousa.field_isSend = false;
            c.djl().a(paramAnonymousa);
            AppMethodBeat.o(67339);
            return;
          }
          if (paramAnonymousa == null)
          {
            ad.i("MicroMsg.SubCoreRemittance", "empty record");
            AppMethodBeat.o(67339);
            return;
          }
        }
        bl localbl;
        label596:
        label737:
        if ("33".equals(localbl))
        {
          i = bt.getInt((String)paramAnonymousa.get(".sysmsg.paymsg.opentransferbankcard"), 0);
          paramAnonymousa = g.afB().afk();
          paramAnonymousa.set(ae.a.FrG, Integer.valueOf(i));
          int j = ((Integer)paramAnonymousa.get(ae.a.FrH, Integer.valueOf(0))).intValue();
          ad.i("MicroMsg.SubCoreRemittance", "receive open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (j == 0)
          {
            com.tencent.mm.z.c.adr().b(ae.a.FrB, true);
            paramAnonymousa.set(ae.a.FrH, Integer.valueOf(1));
            g.afB().afk().set(ae.a.FrC, Boolean.FALSE);
          }
        }
        label682:
        AppMethodBeat.o(67339);
      }
      
      public final void a(com.tencent.mm.al.f.c paramAnonymousc) {}
    };
    this.vtY = new com.tencent.mm.sdk.b.c() {};
    this.vtZ = new com.tencent.mm.sdk.b.c() {};
    this.vua = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(67343);
  }
  
  public static c djj()
  {
    AppMethodBeat.i(67344);
    c localc = (c)t.ap(c.class);
    AppMethodBeat.o(67344);
    return localc;
  }
  
  public static b djk()
  {
    AppMethodBeat.i(67345);
    if (djj().vtV == null)
    {
      localObject = djj();
      g.afC();
      ((c)localObject).vtV = new b(g.afB().gda);
    }
    Object localObject = djj().vtV;
    AppMethodBeat.o(67345);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.remittance.b.d djl()
  {
    AppMethodBeat.i(67346);
    if (djj().vtW == null)
    {
      localObject = djj();
      g.afC();
      ((c)localObject).vtW = new com.tencent.mm.plugin.remittance.b.d(g.afB().gda);
    }
    Object localObject = djj().vtW;
    AppMethodBeat.o(67346);
    return localObject;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public final ac djm()
  {
    AppMethodBeat.i(67349);
    if (this.vtU == null) {
      this.vtU = new ac();
    }
    ac localac = this.vtU;
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
    if (this.vtU != null) {
      localac = this.vtU;
    }
    synchronized (localac.lock)
    {
      localac.vBU.clear();
      com.tencent.mm.model.c.d.aty().add(this.gQD);
      ((q)g.ad(q.class)).getSysCmdMsgExtension().a("paymsg", this.oXa, true);
      com.tencent.mm.sdk.b.a.ESL.b(this.vtY);
      com.tencent.mm.sdk.b.a.ESL.b(this.vtZ);
      com.tencent.mm.sdk.b.a.ESL.b(this.vua);
      AppMethodBeat.o(67347);
      return;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(67348);
    com.tencent.mm.model.c.d.aty().remove(this.gQD);
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("paymsg", this.oXa, true);
    com.tencent.mm.sdk.b.a.ESL.d(this.vtY);
    com.tencent.mm.sdk.b.a.ESL.d(this.vtZ);
    com.tencent.mm.sdk.b.a.ESL.d(this.vua);
    AppMethodBeat.o(67348);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.c
 * JD-Core Version:    0.7.0.1
 */