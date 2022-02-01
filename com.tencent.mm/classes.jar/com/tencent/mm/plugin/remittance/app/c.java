package com.tencent.mm.plugin.remittance.app;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q;
import com.tencent.mm.autogen.a.adk;
import com.tencent.mm.autogen.a.mz;
import com.tencent.mm.autogen.a.tj;
import com.tencent.mm.autogen.a.vm;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.be;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.remittance.a.b;
import com.tencent.mm.plugin.remittance.a.d;
import com.tencent.mm.plugin.remittance.model.am;
import com.tencent.mm.plugin.remittance.model.g;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.protocal.protobuf.drl;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.wallet_core.model.ab;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c
  implements q, be, i.a, com.tencent.mm.plugin.messenger.foundation.a.i
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private am ObM;
  public b ObN;
  private d ObO;
  public CharSequence ObP;
  private IListener<tj> ObQ;
  private IListener<adk> ObR;
  private IListener<mz> ObS;
  private IListener<vm> ObT;
  private MStorage.IOnStorageChange ooR;
  private cl.a ysZ;
  
  static
  {
    AppMethodBeat.i(67351);
    com.tencent.mm.wallet_core.a.n("RemittanceProcess", a.class);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("DelayTransferRecord".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("RemittanceRecord".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return d.SQL_CREATE;
      }
    });
    AppMethodBeat.o(67351);
  }
  
  public c()
  {
    AppMethodBeat.i(67343);
    this.ObM = null;
    this.ObN = null;
    this.ObO = null;
    this.ooR = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData) {}
    };
    this.ysZ = new cl.a()
    {
      public final void a(com.tencent.mm.am.g.a paramAnonymousa)
      {
        AppMethodBeat.i(288699);
        Log.i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
        Object localObject1 = paramAnonymousa.mpN;
        if (localObject1 == null)
        {
          Log.e("MicroMsg.SubCoreRemittance", "recieve a null msg");
          AppMethodBeat.o(288699);
          return;
        }
        paramAnonymousa = w.a(((dl)localObject1).YFG);
        if (Util.isNullOrNil(paramAnonymousa))
        {
          Log.e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
          AppMethodBeat.o(288699);
          return;
        }
        paramAnonymousa = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
        if (paramAnonymousa == null)
        {
          Log.e("MicroMsg.SubCoreRemittance", "Resolve msg error");
          AppMethodBeat.o(288699);
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
            AppMethodBeat.o(288699);
            return;
          }
          localObject3 = XmlParser.parseXml((String)localObject1, "msg", null);
          if (localObject3 == null)
          {
            Log.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
            AppMethodBeat.o(288699);
            return;
          }
          localObject3 = (String)((Map)localObject3).get(".msg.appmsg.wcpayinfo.transferid");
          if (Util.isNullOrNil((String)localObject3))
          {
            Log.e("MicroMsg.SubCoreRemittance", "paymsgid is null");
            AppMethodBeat.o(288699);
            return;
          }
          if (c.this.gLy().aTV((String)localObject3))
          {
            Log.e("MicroMsg.SubCoreRemittance", "it is a duplicate msg");
            AppMethodBeat.o(288699);
            return;
          }
          localObject4 = (String)paramAnonymousa.get(".sysmsg.paymsg.tousername");
          if ((Util.isNullOrNil((String)localObject1)) || (Util.isNullOrNil((String)localObject4)))
          {
            Log.e("MicroMsg.SubCoreRemittance", "onRecieveMsg get a illegal msg,which content or toUserName is null");
            AppMethodBeat.o(288699);
            return;
          }
          paramAnonymousa = (String)paramAnonymousa.get("msg.appmsg.wcpayinfo.receiver_username");
          c.this.gLy().H((String)localObject3, (String)localObject1, (String)localObject4, paramAnonymousa);
          AppMethodBeat.o(288699);
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
              AppMethodBeat.o(288699);
              return;
            }
          }
          catch (UnsupportedEncodingException paramAnonymousa)
          {
            Log.printErrStackTrace("MicroMsg.SubCoreRemittance", paramAnonymousa, "", new Object[0]);
            AppMethodBeat.o(288699);
            return;
          }
          paramAnonymousa = XmlParser.parseXml(str, "msg", null);
          if (paramAnonymousa == null)
          {
            Log.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
            AppMethodBeat.o(288699);
            return;
          }
          localObject3 = (String)paramAnonymousa.get(".msg.appmsg.wcpayinfo.transferid");
          i = Util.getInt((String)paramAnonymousa.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
          localObject4 = (String)paramAnonymousa.get(".msg.appmsg.wcpayinfo.receiver_name");
          Log.i("MicroMsg.SubCoreRemittance", "receive delay transfer newxml, fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", new Object[] { localObject5, localObject1, localObject3, Integer.valueOf(i) });
          paramAnonymousa = null;
          try
          {
            c.gLv();
            localObject1 = c.gLw().aTN((String)localObject3);
            paramAnonymousa = (com.tencent.mm.am.g.a)localObject1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.SubCoreRemittance", localException, "", new Object[0]);
            }
            localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramAnonymousa.field_msgId);
            if ((localObject2 != null) && (((fi)localObject2).field_msgId > 0L)) {
              break label638;
            }
            Log.i("MicroMsg.SubCoreRemittance", "has delete msg");
            c.gLv();
            c.gLw().delete(paramAnonymousa, new String[0]);
            AppMethodBeat.o(288699);
            return;
            Log.i("MicroMsg.SubCoreRemittance", "update msg: %s", new Object[] { Long.valueOf(((fi)localObject2).field_msgId) });
            ((cc)localObject2).setContent(str);
            ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(((fi)localObject2).field_msgId, (cc)localObject2);
            paramAnonymousa = c.gLx().aTO((String)localObject3);
            if (paramAnonymousa == null) {
              break label737;
            }
          }
          if (paramAnonymousa == null)
          {
            Log.i("MicroMsg.SubCoreRemittance", "empty record");
            AppMethodBeat.o(288699);
            return;
          }
          label638:
          paramAnonymousa.field_receiveStatus = i;
          c.gLx().a(paramAnonymousa);
          for (;;)
          {
            c.this.aTL(((fi)localObject2).field_talker);
            AppMethodBeat.o(288699);
            return;
            label737:
            if (!((fi)localObject2).field_talker.equals(z.bAM()))
            {
              paramAnonymousa = new com.tencent.mm.plugin.remittance.a.c();
              paramAnonymousa.field_locaMsgId = ((fi)localObject2).field_msgId;
              paramAnonymousa.field_transferId = ((String)localObject3);
              paramAnonymousa.field_receiveStatus = i;
              paramAnonymousa.field_isSend = false;
              paramAnonymousa.field_talker = ((fi)localObject2).field_talker;
              paramAnonymousa.field_receiverName = ((String)localObject4);
              c.gLx().a(paramAnonymousa);
            }
          }
        }
        if ("25".equals(localObject3))
        {
          Log.i("MicroMsg.SubCoreRemittance", "parse transfer outtime msg");
          localObject4 = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.transferid"));
          localObject3 = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.fromusername"));
          localObject4 = c.gLx().aTP((String)localObject4);
          if ((localObject4 != null) && ((((com.tencent.mm.plugin.remittance.a.c)localObject4).field_receiveStatus == -1) || (((com.tencent.mm.plugin.remittance.a.c)localObject4).field_receiveStatus == 1) || (((com.tencent.mm.plugin.remittance.a.c)localObject4).field_receiveStatus == 7) || (((com.tencent.mm.plugin.remittance.a.c)localObject4).field_receiveStatus == 0)))
          {
            ((com.tencent.mm.plugin.remittance.a.c)localObject4).field_receiveStatus = 2;
            c.gLx().a((com.tencent.mm.plugin.remittance.a.c)localObject4);
            c.this.aTL((String)localObject3);
            localObject4 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((com.tencent.mm.plugin.remittance.a.c)localObject4).field_locaMsgId);
            if ((localObject4 == null) || (((fi)localObject4).field_msgId <= 0L) || ((((fi)localObject4).jUq & 0x4) == 4) || (((cc)localObject4).getType() == 10000) || (((cc)localObject4).getType() == 268445456))
            {
              Log.i("MicroMsg.SubCoreRemittance", " msg is delete or revoked");
              AppMethodBeat.o(288699);
              return;
            }
            paramAnonymousa = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.content"));
            if (Util.isNullOrNil(paramAnonymousa))
            {
              AppMethodBeat.o(288699);
              return;
            }
            localObject4 = new cc();
            ((cc)localObject4).pI(0);
            ((cc)localObject4).BS((String)localObject3);
            ((cc)localObject4).setContent(paramAnonymousa);
            ((cc)localObject4).setCreateTime(br.D((String)localObject3, ((dl)localObject2).CreateTime));
            ((cc)localObject4).setType(10000);
            ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().ba((cc)localObject4);
          }
          AppMethodBeat.o(288699);
          return;
        }
        if ("33".equals(localObject3))
        {
          i = Util.getInt((String)paramAnonymousa.get(".sysmsg.paymsg.opentransferbankcard"), 0);
          paramAnonymousa = com.tencent.mm.kernel.h.baE().ban();
          paramAnonymousa.set(at.a.acUy, Integer.valueOf(i));
          int j = ((Integer)paramAnonymousa.get(at.a.acUz, Integer.valueOf(0))).intValue();
          Log.i("MicroMsg.SubCoreRemittance", "receive open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (j == 0)
          {
            com.tencent.mm.aa.c.aYo().b(at.a.acUt, true);
            paramAnonymousa.set(at.a.acUz, Integer.valueOf(1));
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acUu, Boolean.FALSE);
          }
          AppMethodBeat.o(288699);
          return;
        }
        if ("45".equals(localObject3))
        {
          if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXa, 1) == 0)
          {
            Log.i("MicroMsg.SubCoreRemittance", "needOpenSwitch is close ");
            AppMethodBeat.o(288699);
            return;
          }
          localObject3 = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.transferid"));
          localObject4 = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.fromusername"));
          str = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.content"));
          paramAnonymousa = Util.nullAsNil((String)paramAnonymousa.get(".sysmsg.paymsg.transfer_msg_type"));
          Log.i("MicroMsg.SubCoreRemittance", "parse transfer remind receive msg：transferid：%s,msgType ：%s", new Object[] { localObject3, paramAnonymousa });
          localObject5 = c.gLx().aTP((String)localObject3);
          if (localObject5 != null)
          {
            localObject5 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((com.tencent.mm.plugin.remittance.a.c)localObject5).field_locaMsgId);
            if ((localObject5 == null) || (((fi)localObject5).field_msgId <= 0L) || ((((fi)localObject5).jUq & 0x4) == 4) || (((cc)localObject5).getType() == 10000) || (((cc)localObject5).getType() == 268445456))
            {
              Log.i("MicroMsg.SubCoreRemittance", " msg has delete，dont insert remind msg");
              com.tencent.mm.plugin.report.service.h.OAn.b(20467, new Object[] { "transfer_to_change", "dont show message", "", "", "", "", Integer.valueOf(2), localObject3, paramAnonymousa });
              AppMethodBeat.o(288699);
              return;
            }
            Log.i("MicroMsg.SubCoreRemittance", "insert new remind msg");
            localObject5 = new cc();
            ((cc)localObject5).pI(0);
            ((cc)localObject5).BS((String)localObject4);
            ((cc)localObject5).setContent(str);
            ((cc)localObject5).setCreateTime(br.D((String)localObject4, ((dl)localObject2).CreateTime));
            ((cc)localObject5).setType(10000);
            ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().ba((cc)localObject5);
            com.tencent.mm.plugin.report.service.h.OAn.b(20467, new Object[] { "transfer_to_change", "show message", "", "", "", "", Integer.valueOf(1), localObject3, paramAnonymousa });
            AppMethodBeat.o(288699);
            return;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(20467, new Object[] { "transfer_to_change", "dont show message", "", "", "", "", Integer.valueOf(2), localObject3, paramAnonymousa });
          Log.i("MicroMsg.SubCoreRemittance", "remittanceRecord is null, dont insert remind msg");
          AppMethodBeat.o(288699);
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
            AppMethodBeat.o(288699);
            return;
          }
          if (Util.isEqual((String)localObject2, "0")) {
            com.tencent.mm.plugin.collect.model.voice.a.drL();
          }
          for (paramAnonymousa = com.tencent.mm.plugin.collect.model.voice.a.abo("0-1"); Util.isNullOrNil(paramAnonymousa); paramAnonymousa = com.tencent.mm.plugin.collect.model.voice.a.abo((String)localObject2))
          {
            Log.i("MicroMsg.SubCoreRemittance", "need insert new config");
            com.tencent.mm.plugin.collect.model.voice.a.drL();
            com.tencent.mm.plugin.collect.model.voice.a.q((String)localObject2, (String)localObject4, (String)localObject3, str);
            AppMethodBeat.o(288699);
            return;
            com.tencent.mm.plugin.collect.model.voice.a.drL();
          }
          double d1 = Double.parseDouble((String)localObject3);
          double d2 = Double.parseDouble(paramAnonymousa);
          Log.i("MicroMsg.SubCoreRemittance", "voice resource file - version： %s ，versionLocal:%s", new Object[] { localObject3, paramAnonymousa });
          if (d1 > d2)
          {
            if (Util.isNullOrNil((String)localObject4))
            {
              Log.i("MicroMsg.SubCoreRemittance", "resourceUrl is null");
              AppMethodBeat.o(288699);
              return;
            }
            Log.i("MicroMsg.SubCoreRemittance", "need update voice resource config");
            com.tencent.mm.plugin.collect.model.voice.a.drL();
            com.tencent.mm.plugin.collect.model.voice.a.q((String)localObject2, (String)localObject4, (String)localObject3, str);
            AppMethodBeat.o(288699);
            return;
          }
          Log.i("MicroMsg.SubCoreRemittance", "version < versionLocal,do not update voice resource");
        }
        AppMethodBeat.o(288699);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.ObQ = new SubCoreRemittance.6(this, com.tencent.mm.app.f.hfK);
    this.ObR = new SubCoreRemittance.7(this, com.tencent.mm.app.f.hfK);
    this.ObS = new SubCoreRemittance.8(this, com.tencent.mm.app.f.hfK);
    this.ObT = new SubCoreRemittance.12(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(67343);
  }
  
  public static c gLv()
  {
    AppMethodBeat.i(67344);
    c localc = (c)y.aL(c.class);
    AppMethodBeat.o(67344);
    return localc;
  }
  
  public static b gLw()
  {
    AppMethodBeat.i(67345);
    if (gLv().ObN == null)
    {
      localObject = gLv();
      com.tencent.mm.kernel.h.baF();
      ((c)localObject).ObN = new b(com.tencent.mm.kernel.h.baE().mCN);
    }
    Object localObject = gLv().ObN;
    AppMethodBeat.o(67345);
    return localObject;
  }
  
  public static d gLx()
  {
    AppMethodBeat.i(67346);
    if (gLv().ObO == null)
    {
      localObject = gLv();
      com.tencent.mm.kernel.h.baF();
      ((c)localObject).ObO = new d(com.tencent.mm.kernel.h.baE().mCN);
    }
    Object localObject = gLv().ObO;
    AppMethodBeat.o(67346);
    return localObject;
  }
  
  public final void a(cc paramcc, i.c paramc, boolean[] paramArrayOfBoolean) {}
  
  public final void a(cc paramcc, bb parambb, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(288717);
    if (paramBoolean) {
      aTL(parambb.field_username);
    }
    AppMethodBeat.o(288717);
  }
  
  public final void aTL(final String paramString)
  {
    AppMethodBeat.i(288707);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(288690);
        Object localObject1 = paramString;
        localObject1 = c.gLx().aTQ((String)localObject1);
        Object localObject2;
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (com.tencent.mm.plugin.remittance.a.c)((Iterator)localObject1).next();
              if (!z.bAM().equals(((com.tencent.mm.plugin.remittance.a.c)localObject2).field_receiverName))
              {
                Log.i("MicroMsg.SubCoreRemittance", "not receiver");
              }
              else
              {
                long l = ((com.tencent.mm.plugin.remittance.a.c)localObject2).field_invalidtime * 1000L - cn.bDw();
                Log.i("MicroMsg.SubCoreRemittance", "remittance status: %s, %s, %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.remittance.a.c)localObject2).field_receiveStatus), Long.valueOf(((com.tencent.mm.plugin.remittance.a.c)localObject2).field_locaMsgId), ((com.tencent.mm.plugin.remittance.a.c)localObject2).field_talker });
                if ((l < 0L) && ((((com.tencent.mm.plugin.remittance.a.c)localObject2).field_receiveStatus == 1) || (((com.tencent.mm.plugin.remittance.a.c)localObject2).field_receiveStatus == 7)))
                {
                  Log.i("MicroMsg.SubCoreRemittance", "timeout, change status");
                  ((com.tencent.mm.plugin.remittance.a.c)localObject2).field_receiveStatus = 2;
                  c.gLx().a((com.tencent.mm.plugin.remittance.a.c)localObject2);
                }
                else if ((l >= 0L) && ((((com.tencent.mm.plugin.remittance.a.c)localObject2).field_receiveStatus == 1) || (((com.tencent.mm.plugin.remittance.a.c)localObject2).field_receiveStatus == 7)))
                {
                  localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((com.tencent.mm.plugin.remittance.a.c)localObject2).field_locaMsgId);
                  if ((((fi)localObject2).field_msgId <= 0L) || ((((fi)localObject2).jUq & 0x4) == 4) || (((cc)localObject2).getType() == 10000) || (((cc)localObject2).getType() == 268445456)) {
                    break;
                  }
                }
              }
            }
          }
        }
        for (boolean bool = true;; bool = false)
        {
          localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM(paramString);
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
            ((bb)localObject1).pR(i);
            Log.i("MicroMsg.SubCoreRemittance", "update ret: %s", new Object[] { Integer.valueOf(((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c((bb)localObject1, paramString)) });
            AppMethodBeat.o(288690);
            return;
            if ((((cc)localObject2).getType() != 10000) && ((((fi)localObject2).jUq & 0x4) != 4)) {
              break;
            }
            Log.i("MicroMsg.SubCoreRemittance", "is revoke msg");
            break;
          }
        }
      }
    }, "update_remit_red_flag");
    AppMethodBeat.o(288707);
  }
  
  public final void b(cc paramcc, bb parambb, boolean paramBoolean, i.c paramc) {}
  
  public void clearPluginData(int paramInt) {}
  
  public final am gLy()
  {
    AppMethodBeat.i(67349);
    if (this.ObM == null) {
      this.ObM = new am();
    }
    am localam = this.ObM;
    AppMethodBeat.o(67349);
    return localam;
  }
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(67347);
    am localam;
    if (this.ObM != null) {
      localam = this.ObM;
    }
    synchronized (localam.lock)
    {
      localam.OkW.clear();
      ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("paymsg", this.ysZ, true);
      this.ObQ.alive();
      this.ObR.alive();
      this.ObS.alive();
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().a(this);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this, null);
      AppForegroundDelegate.heY.a(this);
      this.ObT.alive();
      com.tencent.threadpool.h.ahAA.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(288689);
          MMApplicationContext.getContext();
          g localg = g.Oie;
          try
          {
            Object localObject = (String)((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(at.a.adhK, null);
            if (!Util.isNullOrNil((String)localObject)) {
              localg.Oid.parseFrom(Base64.decode((String)localObject, 0));
            }
            localObject = localg.Oid.aaXj.iterator();
            while (((Iterator)localObject).hasNext())
            {
              dri localdri = (dri)((Iterator)localObject).next();
              int j = (int)((localdri.aaXf - br.bCJ()) / 1000L);
              int i = j;
              if (j < 0) {
                i = 0;
              }
              new com.tencent.mm.plugin.remittance.model.g.a(i, localdri).start();
            }
            AppMethodBeat.o(288689);
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.MsgCheckTaskMgr", localException, "", new Object[0]);
            localg.Oid.aaXj.clear();
            AppMethodBeat.o(288689);
            return;
          }
        }
      }, 12000L);
      AppMethodBeat.o(67347);
      return;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(67348);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("paymsg", this.ysZ, true);
    this.ObQ.dead();
    this.ObR.dead();
    this.ObS.dead();
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().b(this);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this);
    this.ObT.dead();
    AppForegroundDelegate.heY.b(this);
    AppMethodBeat.o(67348);
  }
  
  public void onAppBackground(String paramString)
  {
    AppMethodBeat.i(288734);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(288688);
        c.a(c.this);
        AppMethodBeat.o(288688);
      }
    }, "check_remit_red_flag_background");
    AppMethodBeat.o(288734);
  }
  
  public void onAppForeground(String paramString) {}
  
  public void onNotifyChange(com.tencent.mm.plugin.messenger.foundation.a.a.i parami, i.c paramc)
  {
    AppMethodBeat.i(288729);
    if (paramc.KRm.equals("delete"))
    {
      Log.i("MicroMsg.SubCoreRemittance", "update red flag when delete msg: %s", new Object[] { paramc.talker });
      aTL(paramc.talker);
    }
    AppMethodBeat.o(288729);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.app.c
 * JD-Core Version:    0.7.0.1
 */