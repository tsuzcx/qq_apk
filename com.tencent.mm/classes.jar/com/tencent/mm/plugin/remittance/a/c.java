package com.tencent.mm.plugin.remittance.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.f.a.abn;
import com.tencent.mm.f.a.lu;
import com.tencent.mm.f.a.ru;
import com.tencent.mm.f.a.tx;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.remittance.model.ak;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.widget.a.f.c;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c
  implements o, be, i.a, com.tencent.mm.plugin.messenger.foundation.a.i
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ak Ifs;
  public com.tencent.mm.plugin.remittance.b.b Ift;
  private com.tencent.mm.plugin.remittance.b.d Ifu;
  public CharSequence Ifv;
  private IListener<ru> Ifw;
  private IListener<abn> Ifx;
  private IListener<lu> Ify;
  private IListener<tx> Ifz;
  private MStorage.IOnStorageChange lxt;
  private ck.a vgX;
  
  static
  {
    AppMethodBeat.i(67351);
    com.tencent.mm.wallet_core.a.j("RemittanceProcess", a.class);
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
    this.Ifs = null;
    this.Ift = null;
    this.Ifu = null;
    this.lxt = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(193741);
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString)))
        {
          paramAnonymousString = com.tencent.mm.model.c.d.bgB().Mu("100324");
          if ((!paramAnonymousString.isValid()) || (!"1".equals(paramAnonymousString.hvz().get("open")))) {
            break label172;
          }
        }
        label172:
        for (int i = 1;; i = 0)
        {
          paramAnonymousString = com.tencent.mm.kernel.h.aHG().aHp();
          paramAnonymousString.set(ar.a.VsT, Integer.valueOf(i));
          int j = ((Integer)paramAnonymousString.get(ar.a.VsU, Integer.valueOf(0))).intValue();
          Log.i("MicroMsg.SubCoreRemittance", "receive abtest open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (j == 0)
          {
            com.tencent.mm.aa.c.aFn().b(ar.a.VsO, true);
            paramAnonymousString.set(ar.a.VsU, Integer.valueOf(1));
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VsP, Boolean.FALSE);
          }
          AppMethodBeat.o(193741);
          return;
        }
      }
    };
    this.vgX = new ck.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(200995);
        Log.i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
        Object localObject1 = paramAnonymousa.jQG;
        if (localObject1 == null)
        {
          Log.e("MicroMsg.SubCoreRemittance", "recieve a null msg");
          AppMethodBeat.o(200995);
          return;
        }
        paramAnonymousa = com.tencent.mm.platformtools.z.a(((db)localObject1).RIF);
        if (Util.isNullOrNil(paramAnonymousa))
        {
          Log.e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
          AppMethodBeat.o(200995);
          return;
        }
        paramAnonymousa = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
        if (paramAnonymousa == null)
        {
          Log.e("MicroMsg.SubCoreRemittance", "Resolve msg error");
          AppMethodBeat.o(200995);
          return;
        }
        Object localObject3 = (String)paramAnonymousa.get(".sysmsg.paymsg.PayMsgType");
        Object localObject4;
        if ("15".equals(localObject3))
        {
          localObject1 = URLDecoder.decode((String)paramAnonymousa.get(".sysmsg.paymsg.appmsgcontent"));
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            Log.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
            AppMethodBeat.o(200995);
            return;
          }
          localObject3 = XmlParser.parseXml((String)localObject1, "msg", null);
          if (localObject3 == null)
          {
            Log.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
            AppMethodBeat.o(200995);
            return;
          }
          localObject3 = (String)((Map)localObject3).get(".msg.appmsg.wcpayinfo.transferid");
          if (Util.isNullOrNil((String)localObject3))
          {
            Log.e("MicroMsg.SubCoreRemittance", "paymsgid is null");
            AppMethodBeat.o(200995);
            return;
          }
          if (c.this.fzM().aWH((String)localObject3))
          {
            Log.e("MicroMsg.SubCoreRemittance", "it is a duplicate msg");
            AppMethodBeat.o(200995);
            return;
          }
          localObject4 = (String)paramAnonymousa.get(".sysmsg.paymsg.tousername");
          if ((Util.isNullOrNil((String)localObject1)) || (Util.isNullOrNil((String)localObject4)))
          {
            Log.e("MicroMsg.SubCoreRemittance", "onRecieveMsg get a illegal msg,which content or toUserName is null");
            AppMethodBeat.o(200995);
            return;
          }
          paramAnonymousa = (String)paramAnonymousa.get("msg.appmsg.wcpayinfo.receiver_username");
          c.this.fzM().F((String)localObject3, (String)localObject1, (String)localObject4, paramAnonymousa);
          AppMethodBeat.o(200995);
          return;
        }
        Object localObject5;
        String str;
        int i;
        Object localObject2;
        if ("22".equals(localObject3))
        {
          localObject1 = (String)paramAnonymousa.get(".sysmsg.paymsg.tousername");
          localObject5 = (String)paramAnonymousa.get(".sysmsg.paymsg.fromusername");
          try
          {
            str = URLDecoder.decode((String)paramAnonymousa.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
            if (Util.isNullOrNil(str))
            {
              Log.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
              AppMethodBeat.o(200995);
              return;
            }
          }
          catch (UnsupportedEncodingException paramAnonymousa)
          {
            Log.printErrStackTrace("MicroMsg.SubCoreRemittance", paramAnonymousa, "", new Object[0]);
            AppMethodBeat.o(200995);
            return;
          }
          paramAnonymousa = XmlParser.parseXml(str, "msg", null);
          if (paramAnonymousa == null)
          {
            Log.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
            AppMethodBeat.o(200995);
            return;
          }
          localObject3 = (String)paramAnonymousa.get(".msg.appmsg.wcpayinfo.transferid");
          i = Util.getInt((String)paramAnonymousa.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
          localObject4 = (String)paramAnonymousa.get(".msg.appmsg.wcpayinfo.receiver_name");
          Log.i("MicroMsg.SubCoreRemittance", "receive delay transfer newxml, fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", new Object[] { localObject5, localObject1, localObject3, Integer.valueOf(i) });
          paramAnonymousa = null;
          try
          {
            c.fzJ();
            localObject1 = c.fzK().aWz((String)localObject3);
            paramAnonymousa = (h.a)localObject1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.SubCoreRemittance", localException, "", new Object[0]);
            }
            localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramAnonymousa.field_msgId);
            if (((et)localObject2).field_msgId > 0L) {
              break label633;
            }
            Log.i("MicroMsg.SubCoreRemittance", "has delete msg");
            c.fzJ();
            c.fzK().delete(paramAnonymousa, new String[0]);
            AppMethodBeat.o(200995);
            return;
            Log.i("MicroMsg.SubCoreRemittance", "update msg: %s", new Object[] { Long.valueOf(((et)localObject2).field_msgId) });
            ((ca)localObject2).setContent(str);
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(((et)localObject2).field_msgId, (ca)localObject2);
            paramAnonymousa = c.fzL().aWA((String)localObject3);
            if (paramAnonymousa == null) {
              break label732;
            }
          }
          if (paramAnonymousa == null)
          {
            Log.i("MicroMsg.SubCoreRemittance", "empty record");
            AppMethodBeat.o(200995);
            return;
          }
          label633:
          paramAnonymousa.field_receiveStatus = i;
          c.fzL().a(paramAnonymousa);
          for (;;)
          {
            c.this.aWx(((et)localObject2).field_talker);
            AppMethodBeat.o(200995);
            return;
            label732:
            if (!((et)localObject2).field_talker.equals(com.tencent.mm.model.z.bcZ()))
            {
              paramAnonymousa = new com.tencent.mm.plugin.remittance.b.c();
              paramAnonymousa.field_locaMsgId = ((et)localObject2).field_msgId;
              paramAnonymousa.field_transferId = ((String)localObject3);
              paramAnonymousa.field_receiveStatus = i;
              paramAnonymousa.field_isSend = false;
              paramAnonymousa.field_talker = ((et)localObject2).field_talker;
              paramAnonymousa.field_receiverName = ((String)localObject4);
              c.fzL().a(paramAnonymousa);
            }
          }
        }
        if ("25".equals(localObject3))
        {
          Log.i("MicroMsg.SubCoreRemittance", "parse transfer outtime msg");
          localObject4 = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.transferid"));
          localObject3 = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.fromusername"));
          localObject4 = c.fzL().aWB((String)localObject4);
          if ((localObject4 != null) && ((((com.tencent.mm.plugin.remittance.b.c)localObject4).field_receiveStatus == -1) || (((com.tencent.mm.plugin.remittance.b.c)localObject4).field_receiveStatus == 1) || (((com.tencent.mm.plugin.remittance.b.c)localObject4).field_receiveStatus == 7) || (((com.tencent.mm.plugin.remittance.b.c)localObject4).field_receiveStatus == 0)))
          {
            ((com.tencent.mm.plugin.remittance.b.c)localObject4).field_receiveStatus = 2;
            c.fzL().a((com.tencent.mm.plugin.remittance.b.c)localObject4);
            c.this.aWx((String)localObject3);
            localObject4 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(((com.tencent.mm.plugin.remittance.b.c)localObject4).field_locaMsgId);
            if ((((et)localObject4).field_msgId <= 0L) || ((((et)localObject4).hxx & 0x4) == 4) || (((ca)localObject4).getType() == 10000) || (((ca)localObject4).getType() == 268445456))
            {
              Log.i("MicroMsg.SubCoreRemittance", " msg is delete or revoked");
              AppMethodBeat.o(200995);
              return;
            }
            paramAnonymousa = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.content"));
            if (Util.isNullOrNil(paramAnonymousa))
            {
              AppMethodBeat.o(200995);
              return;
            }
            localObject4 = new ca();
            ((ca)localObject4).pJ(0);
            ((ca)localObject4).Jm((String)localObject3);
            ((ca)localObject4).setContent(paramAnonymousa);
            ((ca)localObject4).setCreateTime(bq.z((String)localObject3, ((db)localObject2).CreateTime));
            ((ca)localObject4).setType(10000);
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM((ca)localObject4);
          }
          AppMethodBeat.o(200995);
          return;
        }
        if ("33".equals(localObject3))
        {
          i = Util.getInt((String)paramAnonymousa.get(".sysmsg.paymsg.opentransferbankcard"), 0);
          paramAnonymousa = com.tencent.mm.kernel.h.aHG().aHp();
          paramAnonymousa.set(ar.a.VsT, Integer.valueOf(i));
          int j = ((Integer)paramAnonymousa.get(ar.a.VsU, Integer.valueOf(0))).intValue();
          Log.i("MicroMsg.SubCoreRemittance", "receive open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (j == 0)
          {
            com.tencent.mm.aa.c.aFn().b(ar.a.VsO, true);
            paramAnonymousa.set(ar.a.VsU, Integer.valueOf(1));
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VsP, Boolean.FALSE);
          }
          AppMethodBeat.o(200995);
          return;
        }
        if ("45".equals(localObject3))
        {
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHe, 1) == 0)
          {
            Log.i("MicroMsg.SubCoreRemittance", "needOpenSwitch is close ");
            AppMethodBeat.o(200995);
            return;
          }
          localObject3 = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.transferid"));
          localObject4 = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.fromusername"));
          str = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.content"));
          paramAnonymousa = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.transfer_msg_type"));
          Log.i("MicroMsg.SubCoreRemittance", "parse transfer remind receive msg：transferid：%s,msgType ：%s", new Object[] { localObject3, paramAnonymousa });
          localObject5 = c.fzL().aWB((String)localObject3);
          if (localObject5 != null)
          {
            localObject5 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(((com.tencent.mm.plugin.remittance.b.c)localObject5).field_locaMsgId);
            if ((((et)localObject5).field_msgId <= 0L) || ((((et)localObject5).hxx & 0x4) == 4) || (((ca)localObject5).getType() == 10000) || (((ca)localObject5).getType() == 268445456))
            {
              Log.i("MicroMsg.SubCoreRemittance", " msg has delete，dont insert remind msg");
              com.tencent.mm.plugin.report.service.h.IzE.a(20467, new Object[] { "transfer_to_change", "dont show message", "", "", "", "", Integer.valueOf(2), localObject3, paramAnonymousa });
              AppMethodBeat.o(200995);
              return;
            }
            Log.i("MicroMsg.SubCoreRemittance", "insert new remind msg");
            localObject5 = new ca();
            ((ca)localObject5).pJ(0);
            ((ca)localObject5).Jm((String)localObject4);
            ((ca)localObject5).setContent(str);
            ((ca)localObject5).setCreateTime(bq.z((String)localObject4, ((db)localObject2).CreateTime));
            ((ca)localObject5).setType(10000);
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM((ca)localObject5);
            com.tencent.mm.plugin.report.service.h.IzE.a(20467, new Object[] { "transfer_to_change", "show message", "", "", "", "", Integer.valueOf(1), localObject3, paramAnonymousa });
            AppMethodBeat.o(200995);
            return;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(20467, new Object[] { "transfer_to_change", "dont show message", "", "", "", "", Integer.valueOf(2), localObject3, paramAnonymousa });
          Log.i("MicroMsg.SubCoreRemittance", "remittanceRecord is null, dont insert remind msg");
          AppMethodBeat.o(200995);
          return;
        }
        if ("46".equals(localObject3))
        {
          localObject2 = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.pos_id"));
          localObject3 = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.version"));
          localObject4 = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.url"));
          str = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.md5"));
          Log.i("MicroMsg.SubCoreRemittance", "parse voice update msg，pos_id：%s,version ：%s, resourceUrl:%s, md5:%s", new Object[] { localObject2, localObject3, localObject4, str });
          if ((Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil((String)localObject3)))
          {
            Log.i("MicroMsg.SubCoreRemittance", "pos_id is null || version is null");
            AppMethodBeat.o(200995);
            return;
          }
          if (Util.isEqual((String)localObject2, "0")) {
            com.tencent.mm.plugin.collect.model.voice.a.cOg();
          }
          for (paramAnonymousa = com.tencent.mm.plugin.collect.model.voice.a.aiq("0-1"); Util.isNullOrNil(paramAnonymousa); paramAnonymousa = com.tencent.mm.plugin.collect.model.voice.a.aiq((String)localObject2))
          {
            Log.i("MicroMsg.SubCoreRemittance", "need insert new config");
            com.tencent.mm.plugin.collect.model.voice.a.cOg();
            com.tencent.mm.plugin.collect.model.voice.a.p((String)localObject2, (String)localObject4, (String)localObject3, str);
            AppMethodBeat.o(200995);
            return;
            com.tencent.mm.plugin.collect.model.voice.a.cOg();
          }
          double d1 = Double.parseDouble((String)localObject3);
          double d2 = Double.parseDouble(paramAnonymousa);
          Log.i("MicroMsg.SubCoreRemittance", "voice resource file - version： %s ，versionLocal:%s", new Object[] { localObject3, paramAnonymousa });
          if (d1 > d2)
          {
            if (Util.isNullOrNil((String)localObject4))
            {
              Log.i("MicroMsg.SubCoreRemittance", "resourceUrl is null");
              AppMethodBeat.o(200995);
              return;
            }
            Log.i("MicroMsg.SubCoreRemittance", "need update voice resource config");
            com.tencent.mm.plugin.collect.model.voice.a.cOg();
            com.tencent.mm.plugin.collect.model.voice.a.p((String)localObject2, (String)localObject4, (String)localObject3, str);
            AppMethodBeat.o(200995);
            return;
          }
          Log.i("MicroMsg.SubCoreRemittance", "version < versionLocal,do not update voice resource");
        }
        AppMethodBeat.o(200995);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.Ifw = new IListener() {};
    this.Ifx = new IListener() {};
    this.Ify = new c.11(this);
    this.Ifz = new c.4(this);
    AppMethodBeat.o(67343);
  }
  
  public static c fzJ()
  {
    AppMethodBeat.i(67344);
    c localc = (c)y.as(c.class);
    AppMethodBeat.o(67344);
    return localc;
  }
  
  public static com.tencent.mm.plugin.remittance.b.b fzK()
  {
    AppMethodBeat.i(67345);
    if (fzJ().Ift == null)
    {
      localObject = fzJ();
      com.tencent.mm.kernel.h.aHH();
      ((c)localObject).Ift = new com.tencent.mm.plugin.remittance.b.b(com.tencent.mm.kernel.h.aHG().kcF);
    }
    Object localObject = fzJ().Ift;
    AppMethodBeat.o(67345);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.remittance.b.d fzL()
  {
    AppMethodBeat.i(67346);
    if (fzJ().Ifu == null)
    {
      localObject = fzJ();
      com.tencent.mm.kernel.h.aHH();
      ((c)localObject).Ifu = new com.tencent.mm.plugin.remittance.b.d(com.tencent.mm.kernel.h.aHG().kcF);
    }
    Object localObject = fzJ().Ifu;
    AppMethodBeat.o(67346);
    return localObject;
  }
  
  public final void a(ca paramca, i.c paramc, boolean[] paramArrayOfBoolean) {}
  
  public final void a(ca paramca, az paramaz, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(263537);
    if (paramBoolean) {
      aWx(paramaz.field_username);
    }
    AppMethodBeat.o(263537);
  }
  
  public final void aWx(final String paramString)
  {
    AppMethodBeat.i(263536);
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220394);
        Object localObject1 = paramString;
        localObject1 = c.fzL().aWC((String)localObject1);
        Object localObject2;
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (com.tencent.mm.plugin.remittance.b.c)((Iterator)localObject1).next();
              if (!com.tencent.mm.model.z.bcZ().equals(((com.tencent.mm.plugin.remittance.b.c)localObject2).field_receiverName))
              {
                Log.i("MicroMsg.SubCoreRemittance", "not receiver");
              }
              else
              {
                long l = ((com.tencent.mm.plugin.remittance.b.c)localObject2).field_invalidtime * 1000L - cm.bfE();
                Log.i("MicroMsg.SubCoreRemittance", "remittance status: %s, %s, %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.remittance.b.c)localObject2).field_receiveStatus), Long.valueOf(((com.tencent.mm.plugin.remittance.b.c)localObject2).field_locaMsgId), ((com.tencent.mm.plugin.remittance.b.c)localObject2).field_talker });
                if ((l < 0L) && ((((com.tencent.mm.plugin.remittance.b.c)localObject2).field_receiveStatus == 1) || (((com.tencent.mm.plugin.remittance.b.c)localObject2).field_receiveStatus == 7)))
                {
                  Log.i("MicroMsg.SubCoreRemittance", "timeout, change status");
                  ((com.tencent.mm.plugin.remittance.b.c)localObject2).field_receiveStatus = 2;
                  c.fzL().a((com.tencent.mm.plugin.remittance.b.c)localObject2);
                }
                else if ((l >= 0L) && ((((com.tencent.mm.plugin.remittance.b.c)localObject2).field_receiveStatus == 1) || (((com.tencent.mm.plugin.remittance.b.c)localObject2).field_receiveStatus == 7)))
                {
                  localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(((com.tencent.mm.plugin.remittance.b.c)localObject2).field_locaMsgId);
                  if ((((et)localObject2).field_msgId <= 0L) || ((((et)localObject2).hxx & 0x4) == 4) || (((ca)localObject2).getType() == 10000) || (((ca)localObject2).getType() == 268445456)) {
                    break;
                  }
                }
              }
            }
          }
        }
        for (boolean bool = true;; bool = false)
        {
          localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx(paramString);
          if (localObject1 != null)
          {
            Log.i("MicroMsg.SubCoreRemittance", "update red flag: %s, %s", new Object[] { paramString, Boolean.valueOf(bool) });
            if (!bool) {
              break label438;
            }
          }
          label438:
          for (int i = 1;; i = 0)
          {
            ((az)localObject1).pS(i);
            Log.i("MicroMsg.SubCoreRemittance", "update ret: %s", new Object[] { Integer.valueOf(((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a((az)localObject1, paramString)) });
            AppMethodBeat.o(220394);
            return;
            if ((((ca)localObject2).getType() != 10000) && ((((et)localObject2).hxx & 0x4) != 4)) {
              break;
            }
            Log.i("MicroMsg.SubCoreRemittance", "is revoke msg");
            break;
          }
        }
      }
    }, "update_remit_red_flag");
    AppMethodBeat.o(263536);
  }
  
  public final void b(ca paramca, az paramaz, boolean paramBoolean, i.c paramc) {}
  
  public void clearPluginData(int paramInt) {}
  
  public final ak fzM()
  {
    AppMethodBeat.i(67349);
    if (this.Ifs == null) {
      this.Ifs = new ak();
    }
    ak localak = this.Ifs;
    AppMethodBeat.o(67349);
    return localak;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(67347);
    ak localak;
    if (this.Ifs != null) {
      localak = this.Ifs;
    }
    synchronized (localak.lock)
    {
      localak.InG.clear();
      com.tencent.mm.model.c.d.bgB().add(this.lxt);
      ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("paymsg", this.vgX, true);
      EventCenter.instance.add(this.Ifw);
      EventCenter.instance.add(this.Ifx);
      EventCenter.instance.add(this.Ify);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a(this);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this, null);
      AppForegroundDelegate.fby.a(this);
      this.Ifz.alive();
      com.tencent.e.h.ZvG.o(new c.6(this), 12000L);
      AppMethodBeat.o(67347);
      return;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(67348);
    com.tencent.mm.model.c.d.bgB().remove(this.lxt);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("paymsg", this.vgX, true);
    EventCenter.instance.removeListener(this.Ifw);
    EventCenter.instance.removeListener(this.Ifx);
    EventCenter.instance.removeListener(this.Ify);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().b(this);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this);
    this.Ifz.dead();
    AppForegroundDelegate.fby.b(this);
    AppMethodBeat.o(67348);
  }
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(263539);
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(272402);
        c.a(c.this);
        AppMethodBeat.o(272402);
      }
    }, "check_remit_red_flag_background");
    AppMethodBeat.o(263539);
  }
  
  public void onAppForeground(String paramString) {}
  
  public void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(263538);
    if (paramc.EVM.equals("delete"))
    {
      Log.i("MicroMsg.SubCoreRemittance", "update red flag when delete msg: %s", new Object[] { paramc.talker });
      aWx(paramc.talker);
    }
    AppMethodBeat.o(263538);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.c
 * JD-Core Version:    0.7.0.1
 */