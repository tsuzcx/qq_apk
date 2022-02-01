package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.k.b.a;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.aaj;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.av.a;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.g.a.qr.a;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.ze;
import com.tencent.mm.g.a.zf;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class k
  implements com.tencent.mm.ak.h
{
  private static void N(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(31012);
    az localaz;
    if (!Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.AppMessageExtension", "updateC2CAAMsgMark, mark: %s, talker: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
      bg.aVF();
      localaz = com.tencent.mm.model.c.aST().bjY(paramString);
      if (localaz != null)
      {
        if (!paramBoolean) {
          break label85;
        }
        localaz.oT(16777216);
      }
    }
    for (;;)
    {
      bg.aVF();
      com.tencent.mm.model.c.aST().a(localaz, paramString);
      AppMethodBeat.o(31012);
      return;
      label85:
      localaz.oU(16777216);
    }
  }
  
  private h.b a(h.a parama, String paramString, k.b paramb)
  {
    AppMethodBeat.i(31011);
    de localde = parama.heO;
    bg.aVF();
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = com.tencent.mm.model.c.aSQ();
    bg.aVF();
    Object localObject1 = com.tencent.mm.model.c.aSW();
    Object localObject2 = com.tencent.mm.model.z.aTY();
    String str1 = com.tencent.mm.platformtools.z.a(localde.KHl);
    String str2 = com.tencent.mm.platformtools.z.a(localde.KHm);
    int j;
    bp.b localb;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.a.l)localObject1).has(str1)) || (((String)localObject2).equals(str1)))
    {
      j = 1;
      localb = bp.Ky(localde.KHq);
      if (localb == null) {
        break label2781;
      }
    }
    label114:
    Object localObject4;
    label431:
    label447:
    label599:
    label2781:
    for (Object localObject3 = localb.iEo;; localObject3 = null)
    {
      label355:
      int i;
      boolean bool;
      if (com.tencent.mm.model.ab.Jy((String)localObject3))
      {
        localObject1 = "notifymessage";
        localObject4 = locali.aJ((String)localObject1, localde.Brn);
        Log.i("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", new Object[] { Long.valueOf(localde.Brn), Long.valueOf(((eo)localObject4).field_msgId) });
        if ((((eo)localObject4).field_msgId != 0L) && (((eo)localObject4).field_createTime + 604800000L < bp.C((String)localObject1, localde.CreateTime)))
        {
          Log.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localde.Brn), Long.valueOf(((eo)localObject4).field_msgId) });
          bp.Ad(((eo)localObject4).field_msgId);
          ((ca)localObject4).setMsgId(0L);
        }
        localObject2 = localObject4;
        if (((eo)localObject4).field_msgId == 0L)
        {
          localObject2 = new ca();
          ((ca)localObject2).yF(localde.Brn);
          ((ca)localObject2).setCreateTime(bp.C((String)localObject1, localde.CreateTime));
        }
        if (paramb.iwF != null)
        {
          ((ca)localObject2).CI(paramb.iwF.fRa);
          Log.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", new Object[] { ((eo)localObject2).fRa });
        }
        ((ca)localObject2).setType(m.g(paramb));
        if (!((ca)localObject2).gAt()) {
          break label1812;
        }
        localObject4 = paramb.content;
        ((ca)localObject2).setContent((String)localObject4);
        if (((ca)localObject2).gAt()) {
          ((ca)localObject2).CG(paramb.fQR);
        }
        if ((localde.KHo != 2) || (((eo)localObject2).field_msgId != 0L)) {
          break label2115;
        }
        switch (((ca)localObject2).getType())
        {
        default: 
          i = 0;
          if (i == 0) {
            if (paramb.type == 2)
            {
              bool = true;
              localObject4 = com.tencent.mm.platformtools.z.a(localde.KHp);
              if (ac.jOI)
              {
                Log.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                localObject4 = null;
              }
              if (Util.isNullOrNil((byte[])localObject4)) {
                break label1847;
              }
              if ((paramb.type != 33) && (paramb.type != 36) && (paramb.type != 46) && (paramb.type != 44) && (paramb.type != 48)) {
                break label1830;
              }
              localObject4 = com.tencent.mm.av.q.bcR().a((byte[])localObject4, Bitmap.CompressFormat.PNG);
              if (Util.isNullOrNil((String)localObject4)) {
                Log.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", new Object[] { ((eo)localObject2).field_content });
              }
              if (!Util.isNullOrNil((String)localObject4))
              {
                ((ca)localObject2).Cz((String)localObject4);
                Log.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path".concat(String.valueOf(localObject4)));
              }
              if (j == 0) {
                break label2387;
              }
              ((ca)localObject2).nv(1);
              ((ca)localObject2).Cy((String)localObject1);
              i = localde.oTW;
              label624:
              ((ca)localObject2).setStatus(i);
              if (paramb.type == 2001) {
                if (paramb.dDG == 1)
                {
                  if ((TextUtils.isEmpty(paramb.iyu)) || (TextUtils.isEmpty(paramb.iyv)) || (paramb.iyw <= 0)) {
                    break label2425;
                  }
                  Log.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
                  localObject1 = new av();
                  ((av)localObject1).dDS = new av.a();
                  ((av)localObject1).dDS.dDU = paramb.iyv;
                  ((av)localObject1).dDS.dDT = paramb.iyu;
                  ((av)localObject1).dDS.dDV = paramb.iyw;
                  EventCenter.instance.publish((IEvent)localObject1);
                }
              }
            }
          }
          break;
        }
      }
      for (;;)
      {
        try
        {
          if (Util.isNullOrNil(paramb.iyG)) {
            continue;
          }
          localObject1 = paramb.iyG.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject4 = ((String)((Iterator)localObject1).next()).split(",");
            if ((localObject4 == null) || (localObject4.length <= 0)) {
              continue;
            }
            localObject4 = localObject4[0];
            if ((Util.isNullOrNil((String)localObject4)) || (!((String)localObject4).equals(com.tencent.mm.model.z.aTY()))) {
              continue;
            }
            ((ca)localObject2).setFlag(((eo)localObject2).field_flag | 0x8);
            Log.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
            N(true, ((eo)localObject2).field_talker);
          }
        }
        catch (Exception localException)
        {
          long l1;
          long l2;
          Object localObject5;
          Object localObject6;
          String str3;
          c.a locala;
          label2425:
          Log.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", new Object[] { localException.getMessage() });
          continue;
          ((cbf)localObject4).MgU = localException.ivU;
          ((cbf)localObject4).MgW = localException.ivV;
          continue;
          ((ca)localObject2).setMsgId(bp.x((ca)localObject2));
          continue;
          if (!ag.d((ca)localObject2, (String)localObject3)) {
            continue;
          }
          com.tencent.mm.storage.ab.e((ca)localObject2, true);
          parama = new h.b((ca)localObject2, false);
          continue;
          locali.b(localde.Brn, (ca)localObject2);
          continue;
          localException.dFt.dFA = true;
          continue;
        }
        Log.i("MicroMsg.AppMessageExtension", "paymsgid: %s", new Object[] { paramb.iyt });
        ((ca)localObject2).BB(localde.KHq);
        if (localb != null)
        {
          ((ca)localObject2).CH(localb.iEs);
          ((ca)localObject2).nM(localb.iEt);
          ((ca)localObject2).CC(localb.iEr);
        }
        if (((ca)localObject2).cWK()) {
          ((ca)localObject2).Cz(com.tencent.mm.modelvideo.t.Qv(str2));
        }
        bp.a((ca)localObject2, parama);
        if (((eo)localObject2).field_msgId != 0L) {
          continue;
        }
        if (!ag.d((ca)localObject2, (String)localObject3)) {
          continue;
        }
        com.tencent.mm.storage.ab.e((ca)localObject2, true);
        parama = new v();
        parama.dCL.dCM = ((ca)localObject2);
        parama.dCL.dCN = paramb;
        EventCenter.instance.publish(parama);
        parama = new h.b((ca)localObject2, true);
        if ((((ca)localObject2).getType() == 301989937) && (com.tencent.mm.model.ab.Jw(((eo)localObject2).field_talker))) {
          ((ca)localObject2).setMsgId(0L);
        }
        if ((((ca)localObject2).gDj()) && ("notifymessage".equals(((eo)localObject2).field_talker)))
        {
          localObject1 = XmlParser.parseXml(((eo)localObject2).field_content, "msg", null);
          if (localObject1 != null)
          {
            localObject1 = Util.nullAsNil((String)((Map)localObject1).get(".msg.fromusername"));
            if (as.HF((String)localObject1))
            {
              ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).c((String)localObject1, null);
              Log.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", new Object[] { localObject1 });
            }
          }
        }
        if (((ca)localObject2).getType() == 536870961)
        {
          localObject1 = (com.tencent.mm.ag.b)paramb.as(com.tencent.mm.ag.b.class);
          localObject3 = new qr();
          ((qr)localObject3).dXg.dXd = ((eo)localObject2).field_msgId;
          ((qr)localObject3).dXg.dXh = ((com.tencent.mm.ag.b)localObject1).dXf;
          ((qr)localObject3).dXg.dWG = paramString;
          if (((eo)localObject2).field_isSend == 1)
          {
            Log.d("MicroMsg.AppMessageExtension", "fromuser: %s, touser: %s", new Object[] { str1, str2 });
            ((qr)localObject3).dXg.username = ((eo)localObject2).field_talker;
          }
          EventCenter.instance.publish((IEvent)localObject3);
          if (((qr)localObject3).dXg.dWG != null)
          {
            ((ca)localObject2).setContent(((qr)localObject3).dXg.dWG);
            locali.a(((eo)localObject2).field_msgId, (ca)localObject2);
          }
        }
        if ((!Util.isNullOrNil(paramb.iyz)) && (((ca)localObject2).getType() == 436207665))
        {
          localObject1 = new qp();
          ((qp)localObject1).dXc.dXd = ((eo)localObject2).field_msgId;
          ((qp)localObject1).dXc.dWG = paramString;
          EventCenter.instance.publish((IEvent)localObject1);
        }
        if ((paramb.type == 2000) && (!Util.isNullOrNil(paramb.ixQ)))
        {
          paramString = new qu();
          paramString.dXl.dQp = paramb.ixQ;
          paramString.dXl.msgId = ((eo)localObject2).field_msgId;
          paramString.dXl.dXm = paramb;
          EventCenter.instance.publish(paramString);
          N(false, ((eo)localObject2).field_talker);
        }
        paramString = paramb.izF;
        paramb = Util.nullAs((String)paramString.get(".msg.appmsg.ext_pay_info.pay_type"), "");
        if (((paramb.equals("wx_f2f")) || (paramb.equals("wx_md"))) && (parama.iMb))
        {
          l1 = ((eo)localObject2).field_createTime;
          l2 = cl.aWz();
          Log.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", new Object[] { paramb, Long.valueOf(l1), Long.valueOf(l2) });
          localObject1 = new ci();
          i = Util.getInt((String)paramString.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
          localObject2 = Util.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.pay_feetype"));
          localObject3 = Util.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
          localObject4 = Util.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.voice_content"));
          str1 = Util.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.expire_voice_timestamp"));
          j = Util.getInt((String)paramString.get(".msg.appmsg.ext_pay_info.need_failover"), 1);
          if ((i > 0) && (!Util.isNullOrNil((String)localObject2)) && (!Util.isNullOrNil((String)localObject3)))
          {
            ((ci)localObject1).dFt.dFu = i;
            ((ci)localObject1).dFt.dFv = ((String)localObject2);
            ((ci)localObject1).dFt.dFw = ((String)localObject3);
            ((ci)localObject1).dFt.dFx = paramb;
            ((ci)localObject1).dFt.gY = (l2 - l1);
            ((ci)localObject1).dFt.source = 0;
            ((ci)localObject1).dFt.dFy = ((String)localObject4);
            ((ci)localObject1).dFt.dFz = str1;
            if (j != 0) {
              continue;
            }
            ((ci)localObject1).dFt.dFA = false;
            EventCenter.instance.publish((IEvent)localObject1);
          }
        }
        AppMethodBeat.o(31011);
        return parama;
        j = 0;
        break;
        if (j != 0)
        {
          localObject1 = str2;
          break label114;
        }
        localObject1 = str1;
        break label114;
        localObject4 = paramString;
        break label355;
        i = 1;
        break label431;
        bool = false;
        break label447;
        localObject4 = a((byte[])localObject4, bool, ((ca)localObject2).gDo());
        break label540;
        if ((!Util.isNullOrNil(paramb.iwX)) && (!Util.isNullOrNil(paramb.ixb)))
        {
          a(((eo)localObject2).field_msgSvrId, (ca)localObject2, (String)localObject1, paramb.ixb, paramb.iwX, paramb.iwY, bool, paramb, "", false);
          break label599;
        }
        if (!Util.isNullOrNil(paramb.thumburl))
        {
          Log.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
          localObject5 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
          localObject4 = com.tencent.mm.av.q.bcR().getFullPath((String)localObject5);
          com.tencent.mm.av.q.bcR();
          localObject5 = com.tencent.mm.av.i.EX((String)localObject5);
          localObject6 = com.tencent.mm.av.q.bcV();
          str3 = paramb.thumburl;
          locala = new c.a();
          locala.fullPath = ((String)localObject4);
          locala.jbf = true;
          ((com.tencent.mm.av.a.a)localObject6).a(str3, null, locala.bdv());
          ((ca)localObject2).Cz((String)localObject5);
          Log.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(localObject4)));
          break label599;
        }
        if (Util.isNullOrNil(paramb.iwO)) {
          break label599;
        }
        a(((eo)localObject2).field_msgSvrId, (ca)localObject2, (String)localObject1, paramb.iwU, paramb.iwO, paramb.iwP, bool, paramb, paramb.iwT, true);
        Log.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.iwO);
        break label599;
        if (!Util.isNullOrNil(paramb.thumburl))
        {
          Log.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
          localObject4 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
          if (paramb.type == 2001) {
            localObject4 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
          }
          if (((ca)localObject2).gAt()) {
            break label599;
          }
          localObject5 = com.tencent.mm.av.q.bcR().getFullPath((String)localObject4);
          com.tencent.mm.av.q.bcR();
          localObject4 = com.tencent.mm.av.i.EX((String)localObject4);
          localObject6 = com.tencent.mm.av.q.bcV();
          str3 = paramb.thumburl;
          locala = new c.a();
          locala.fullPath = ((String)localObject5);
          locala.jbf = true;
          ((com.tencent.mm.av.a.a)localObject6).a(str3, null, locala.bdv());
          ((ca)localObject2).Cz((String)localObject4);
          Log.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(localObject5)));
          break label599;
        }
        if (Util.isNullOrNil(paramb.iwO)) {
          break label599;
        }
        if (paramb.type == 2)
        {
          bool = true;
          a(((eo)localObject2).field_msgSvrId, (ca)localObject2, (String)localObject1, paramb.iwU, paramb.iwO, paramb.iwP, bool, paramb, paramb.iwT, true);
          Log.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.iwO);
          break label599;
        }
        bool = false;
        continue;
        ((ca)localObject2).nv(0);
        ((ca)localObject2).Cy((String)localObject1);
        if (localde.oTW > 3)
        {
          i = localde.oTW;
          break label624;
        }
        i = 3;
        break label624;
        Log.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
        continue;
        if (!"1001".equals(paramb.iyq))
        {
          localObject1 = new aaj();
          ((aaj)localObject1).ehg.dWG = paramString;
          ((aaj)localObject1).ehg.ehh = ((eo)localObject2).field_talker;
          ((aaj)localObject1).ehg.dTS = ((eo)localObject2).field_msgSvrId;
          EventCenter.instance.publish((IEvent)localObject1);
          N(false, ((eo)localObject2).field_talker);
          if ("1002".equals(paramb.iyq))
          {
            localObject1 = (com.tencent.mm.ag.c)paramb.as(com.tencent.mm.ag.c.class);
            localObject4 = new cbf();
            ((cbf)localObject4).MgV = ((com.tencent.mm.ag.c)localObject1).ivY;
            ((cbf)localObject4).MgY = ((com.tencent.mm.ag.c)localObject1).ivZ;
            ((cbf)localObject4).igW = ((com.tencent.mm.ag.c)localObject1).ivW;
            ((cbf)localObject4).MgX = ((com.tencent.mm.ag.c)localObject1).ivX;
            if (j == 0) {
              continue;
            }
            ((cbf)localObject4).MgU = ((com.tencent.mm.ag.c)localObject1).ivS;
            ((cbf)localObject4).MgW = ((com.tencent.mm.ag.c)localObject1).ivT;
            localObject5 = (com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.luckymoney.a.a.class);
            localObject6 = new cbe();
            ((cbe)localObject6).MgC = ((cbf)localObject4);
            ((com.tencent.mm.plugin.luckymoney.a.a)localObject5).a((cbe)localObject6);
            ((com.tencent.mm.plugin.luckymoney.a.a)localObject5).a(((com.tencent.mm.ag.c)localObject1).iwb);
          }
        }
      }
    }
  }
  
  static String a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(232149);
    paramArrayOfByte = com.tencent.mm.av.q.bcR().a(paramArrayOfByte, paramBoolean1, Bitmap.CompressFormat.PNG, paramBoolean2);
    AppMethodBeat.o(232149);
    return paramArrayOfByte;
  }
  
  private boolean a(final long paramLong, ca paramca, final String paramString1, String paramString2, String paramString3, final int paramInt, final boolean paramBoolean1, k.b paramb, String paramString4, boolean paramBoolean2)
  {
    AppMethodBeat.i(31014);
    Log.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", new Object[] { Long.valueOf(paramca.field_msgSvrId), paramString2, Integer.valueOf(paramInt), paramString3, paramString1, Boolean.valueOf(paramBoolean1) });
    final long l = Util.nowMilliSecond();
    final int i;
    com.tencent.mm.i.g localg;
    if (paramb != null)
    {
      i = paramb.type;
      paramb = "wcf://temp/appmsgext-cdnthumb-" + new Random().nextLong();
      localg = new com.tencent.mm.i.g();
      localg.taskName = "task_AppMessageExtension_1";
      localg.field_mediaId = com.tencent.mm.an.c.a("downappthumb", paramca.field_createTime, paramString1, String.valueOf(paramLong));
      localg.field_fullpath = paramb;
      if (!paramBoolean2) {
        break label296;
      }
      localg.field_fileType = 19;
      localg.gqB = paramString3;
      label169:
      localg.field_totalLen = paramInt;
      localg.field_aesKey = paramString2;
      localg.field_priority = com.tencent.mm.i.a.gpN;
      localg.field_authKey = paramString4;
      if (!com.tencent.mm.model.ab.Eq(paramString1)) {
        break label314;
      }
    }
    label296:
    label314:
    for (int j = 1;; j = 0)
    {
      localg.field_chattype = j;
      Log.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString1 });
      localg.gqy = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(31005);
          if (paramAnonymousInt != 0)
          {
            Log.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousInt), l });
            new com.tencent.mm.g.b.a.y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(paramInt), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramString1), "" })).bfK();
            AppMethodBeat.o(31005);
            return paramAnonymousInt;
          }
          if (paramAnonymousd == null)
          {
            AppMethodBeat.o(31005);
            return 0;
          }
          label218:
          long l1;
          long l2;
          int i;
          int j;
          int k;
          if (paramAnonymousd.field_retCode != 0)
          {
            Log.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousd.field_retCode), l });
            com.tencent.mm.vfs.s.deleteFile(i);
            if (paramAnonymousd != null) {
              break label920;
            }
            paramAnonymousInt = -1;
            l1 = paramInt;
            l2 = Util.nowMilliSecond();
            i = com.tencent.mm.an.c.cY(MMApplicationContext.getContext());
            j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
            k = paramString1;
            if (paramAnonymousd != null) {
              break label929;
            }
            paramAnonymousString = "";
            label256:
            if (paramAnonymousd != null) {
              break label938;
            }
            paramAnonymousc = "";
            label264:
            new com.tencent.mm.g.b.a.y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).bfK();
            if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode != 0))
            {
              if (paramAnonymousd != null) {
                break label947;
              }
              paramAnonymousInt = -1;
              label410:
              l1 = paramInt;
              l2 = Util.nowMilliSecond();
              i = com.tencent.mm.an.c.cY(MMApplicationContext.getContext());
              j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
              k = paramString1;
              if (paramAnonymousd != null) {
                break label956;
              }
              paramAnonymousString = "";
              label448:
              if (paramAnonymousd != null) {
                break label965;
              }
            }
          }
          label912:
          label920:
          label929:
          label938:
          label947:
          label956:
          label965:
          for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.gqk)
          {
            new w(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).bfK();
            com.tencent.mm.av.q.bcR().doNotify();
            AppMethodBeat.o(31005);
            return 0;
            bg.aVF();
            paramAnonymousc = com.tencent.mm.model.c.aSQ().aJ(paramBoolean1, paramLong);
            if (paramAnonymousc.field_msgSvrId != paramLong)
            {
              Log.e("MicroMsg.AppMessageExtension", "hy: appmsg %d has been deleted", new Object[] { Long.valueOf(paramLong) });
              AppMethodBeat.o(31005);
              return 0;
            }
            Log.i("MicroMsg.AppMessageExtension", "hy: %d current msg type is %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousc.getType()) });
            paramAnonymousString = com.tencent.mm.vfs.s.aW(i, 0, -1);
            if ((this.JWg == 33) || (this.JWg == 36) || (this.JWg == 46) || (this.JWg == 44) || (this.JWg == 48))
            {
              paramAnonymousString = com.tencent.mm.av.q.bcR().a(paramAnonymousString, Bitmap.CompressFormat.JPEG);
              com.tencent.mm.vfs.s.deleteFile(i);
              label763:
              if (!Util.isNullOrNil(paramAnonymousString))
              {
                paramAnonymousc.Cz(paramAnonymousString);
                bg.aVF();
                com.tencent.mm.model.c.aSQ().b(paramAnonymousc.field_msgSvrId, paramAnonymousc);
              }
              Log.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", new Object[] { Long.valueOf(paramLong), paramBoolean1, l, paramAnonymousString });
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 16L, paramString1, false);
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(198L, 17L, 1L, false);
              paramAnonymousString = com.tencent.mm.plugin.report.service.h.CyF;
              if (!com.tencent.mm.model.ab.Eq(paramBoolean1)) {
                break label912;
              }
            }
            for (l1 = 19L;; l1 = 18L)
            {
              paramAnonymousString.idkeyStat(198L, l1, 1L, false);
              break;
              paramAnonymousString = k.a(paramAnonymousString, this.JWh, paramAnonymousc.gDo());
              break label763;
            }
            paramAnonymousInt = paramAnonymousd.field_retCode;
            break label218;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break label256;
            paramAnonymousc = paramAnonymousd.gqk;
            break label264;
            paramAnonymousInt = paramAnonymousd.field_retCode;
            break label410;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break label448;
          }
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return null;
        }
      };
      com.tencent.mm.an.f.baQ().b(localg, -1);
      AppMethodBeat.o(31014);
      return true;
      i = 0;
      break;
      localg.field_fileId = paramString3;
      localg.field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
      break label169;
    }
  }
  
  public static String mx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31008);
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(31008);
      return null;
    }
    String str = paramString2;
    if (com.tencent.mm.model.ab.Eq(paramString1))
    {
      int i = bp.Kp(paramString2);
      str = paramString2;
      if (i != -1) {
        str = (paramString2 + " ").substring(i + 2).trim();
      }
    }
    paramString1 = Util.processXml(str);
    AppMethodBeat.o(31008);
    return paramString1;
  }
  
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(31009);
    Log.d("MicroMsg.AppMessageExtension", "process add app message");
    Object localObject5 = parama.heO;
    Object localObject1 = com.tencent.mm.platformtools.z.a(((de)localObject5).KHl);
    String str = com.tencent.mm.platformtools.z.a(((de)localObject5).KHm);
    if ((Util.isNullOrNil((String)localObject1)) || (Util.isNullOrNil(str))) {
      Log.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
    }
    k.b localb;
    for (str = null;; str = mx((String)localObject1, com.tencent.mm.platformtools.z.a(((de)localObject5).KHn)))
    {
      localb = k.b.HD(str);
      if (localb != null) {
        break;
      }
      Log.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
      AppMethodBeat.o(31009);
      return null;
    }
    if (localb.iyx)
    {
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(352273, str);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(352274, Long.valueOf(System.currentTimeMillis()));
      new b(str).gmP();
      AppMethodBeat.o(31009);
      return null;
    }
    Object localObject2 = ao.eAS().bdG(localb.appId);
    Object localObject3 = localb.appId;
    int i = localb.appVersion;
    if (localObject2 == null) {}
    h.b localb1;
    for (localObject1 = "null";; localObject1 = Integer.valueOf(((g)localObject2).field_appVersion))
    {
      Log.i("MicroMsg.AppMessageExtension", "check version appid:%s, msgVer:%d, appVer:%s", new Object[] { localObject3, Integer.valueOf(i), localObject1 });
      if ((localObject2 == null) || (((g)localObject2).field_appVersion < localb.appVersion)) {
        ao.eAR().bdF(localb.appId);
      }
      localb1 = a(parama, com.tencent.mm.platformtools.z.a(((de)localObject5).KHn), localb);
      if (localb1.dCM != null) {
        break;
      }
      AppMethodBeat.o(31009);
      return null;
    }
    ca localca = localb1.dCM;
    if (localca.gAt())
    {
      AppMethodBeat.o(31009);
      return localb1;
    }
    if (localca.getType() == 301989937)
    {
      AppMethodBeat.o(31009);
      return localb1;
    }
    if (localca.getType() == -1879048190)
    {
      localObject1 = new zf();
      ((zf)localObject1).efq.xml = str;
      ((zf)localObject1).efq.description = localb.description;
      ((zf)localObject1).efq.dCM = localca;
      EventCenter.instance.publish((IEvent)localObject1);
    }
    if ((localca.getType() == 49) && (!Util.isNullOrNil(localb.canvasPageXml)))
    {
      localObject1 = new com.tencent.mm.g.a.g();
      ((com.tencent.mm.g.a.g)localObject1).dBU.dBV = localb.canvasPageXml;
      EventCenter.instance.publish((IEvent)localObject1);
    }
    if (localca.cWK())
    {
      localObject3 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(2, "");
      localObject1 = com.tencent.mm.platformtools.z.a(((de)localObject5).KHm);
      localObject2 = com.tencent.mm.platformtools.z.a(((de)localObject5).KHl);
      if ((!((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().has((String)localObject2)) && (!((String)localObject3).equals(localObject2))) {
        break label1060;
      }
      i = 1;
      localObject3 = new com.tencent.mm.modelvideo.s();
      if (i == 0) {
        break label1065;
      }
      label568:
      ((com.tencent.mm.modelvideo.s)localObject3).dWq = ((String)localObject1);
      ((com.tencent.mm.modelvideo.s)localObject3).jsh = ((String)localObject2);
      ((com.tencent.mm.modelvideo.s)localObject3).createTime = ((de)localObject5).CreateTime;
      ((com.tencent.mm.modelvideo.s)localObject3).dTS = ((de)localObject5).Brn;
      ((com.tencent.mm.modelvideo.s)localObject3).jst = ((de)localObject5).KHn.MTo;
      ((com.tencent.mm.modelvideo.s)localObject3).jso = ((int)localca.field_msgId);
      if (!localca.gDd()) {
        break label1072;
      }
    }
    Object localObject6;
    for (localObject1 = new com.tencent.mm.ag.y().a(localca.OqD);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ((com.tencent.mm.modelvideo.s)localObject3).fileName = localca.field_imgPath;
        ((com.tencent.mm.modelvideo.s)localObject3).a(((com.tencent.mm.ag.y)localObject1).videoUrl, ((com.tencent.mm.ag.y)localObject1).videoDuration, ((com.tencent.mm.ag.y)localObject1).title, ((com.tencent.mm.ag.y)localObject1).KOe, "", "", "");
        ((com.tencent.mm.modelvideo.s)localObject3).status = 111;
      }
      o.bhj().b((com.tencent.mm.modelvideo.s)localObject3);
      if (localb.type != 53) {
        break label1372;
      }
      Log.i("MicroMsg.AppMessageExtension", "process MM_APP_SOLITAIRE_TEXT");
      localObject3 = ((de)localObject5).KHr;
      localObject6 = localb.title;
      if (!Util.isNullOrNil((String)localObject3)) {
        break label1142;
      }
      localObject1 = "";
      label762:
      ((de)localObject5).KHr = ((String)localObject1);
      localObject1 = bp.Ks(localca.field_content);
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break label1718;
      }
      label792:
      if (!parama.iLV) {
        break label1315;
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.j.class)).b(com.tencent.mm.platformtools.z.a(((de)localObject5).KHl), (String)localObject1, localb.title, (String)localb.izx.second, localca.field_msgId, localca.field_createTime / 1000L);
      label853:
      if ((com.tencent.mm.model.ab.Ix(localca.field_talker)) && (com.tencent.mm.chatroom.d.y.ama())) {
        ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.chatroom.plugin.a.class)).handleGroupTodoByReceiverAppMsg(localca);
      }
      if ((com.tencent.mm.model.ab.Ix(localca.field_talker)) && (aa.ame())) {
        ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(localca);
      }
      parama = new com.tencent.mm.ag.k();
      localb.a(parama);
      parama.field_msgId = localca.field_msgId;
      if ((ao.gnf().GL(localca.field_msgId) != null) || (!ao.gnf().insert(parama))) {
        break label1710;
      }
      if (localb.type == 40)
      {
        parama = ao.cgO().Mp(localca.field_msgId);
        localObject1 = com.tencent.mm.ag.t.HI(str);
        if (parama == null) {
          m.a(null, localca.field_msgId, 0, null, null, ((com.tencent.mm.ag.t)localObject1).iAk, localb.type, 0);
        }
        parama = new com.tencent.mm.plugin.record.b.f(localca.field_msgId, localca.field_msgSvrId, null);
        bg.azz().a(parama, 0);
      }
      AppMethodBeat.o(31009);
      return localb1;
      label1060:
      i = 0;
      break;
      label1065:
      localObject1 = localObject2;
      break label568;
      label1072:
      localObject1 = k.b.aD(localca.field_content, localca.field_reserved);
      if (localObject1 != null) {
        break label1106;
      }
      Log.w("MicroMsg.AppMessageExtension", "getVideoInfo content is null");
    }
    label1106:
    localObject1 = (com.tencent.mm.ag.e)((k.b)localObject1).as(com.tencent.mm.ag.e.class);
    if ((localObject1 != null) && (((com.tencent.mm.ag.e)localObject1).iwi != null)) {}
    for (localObject1 = ((com.tencent.mm.ag.e)localObject1).iwi;; localObject1 = null)
    {
      break;
      label1142:
      localObject2 = Util.processXml((String)localObject3);
      if (Util.isNullOrNil((String)localObject2))
      {
        localObject1 = "";
        break label762;
      }
      i = ((String)localObject2).indexOf("<pushcontent");
      Object localObject4 = new StringBuilder();
      if (i > 0)
      {
        localObject1 = ((String)localObject2).substring(i);
        localObject4 = ((StringBuilder)localObject4).append(((String)localObject2).substring(0, i));
        localObject2 = localObject1;
      }
      for (localObject1 = localObject4;; localObject1 = localObject4)
      {
        localObject2 = XmlParser.parseXml((String)localObject2, "pushcontent", null);
        if (localObject2 == null)
        {
          Log.e("MicroMsg.AppMessageExtension", "inval xml");
          localObject1 = localObject3;
          break;
        }
        localObject2 = (String)((Map)localObject2).get(".pushcontent.$nickname");
        ((StringBuilder)localObject1).append("<pushcontent content=\"").append((String)localObject2).append(" : ").append((String)localObject6).append("\"nickname=\"").append((String)localObject2).append("\" />\n");
        localObject1 = ((StringBuilder)localObject1).toString();
        break;
        label1315:
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.j.class)).a(com.tencent.mm.platformtools.z.a(((de)localObject5).KHl), (String)localObject1, localb.title, (String)localb.izx.second, localca.field_msgId, localca.field_createTime / 1000L);
        break label853;
        label1372:
        if (localb.type == 57)
        {
          Log.i("MicroMsg.AppMessageExtension", "process MM_APP_MSG_QUOTE");
          ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.msgquote.a.class)).handleReceivedQuoteMsg(localca.field_msgId, localca.field_msgSvrId, localca.field_talker, localb.izy.zFI);
          break label853;
        }
        if (localb.type != 60) {
          break label853;
        }
        parama = (String)com.tencent.mm.kernel.g.aAh().azQ().get(2, "");
        localObject1 = com.tencent.mm.platformtools.z.a(((de)localObject5).KHl);
        boolean bool;
        if ((((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().has((String)localObject1)) || (parama.equals(localObject1)))
        {
          bool = true;
          label1502:
          if (!bool) {
            break label1701;
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.AppMessageExtension", "process MM_APP_MMLIVE_SHARE, isSender%b, anchor:%s", new Object[] { Boolean.valueOf(bool), parama });
          if (bool) {
            break;
          }
          localObject3 = (com.tencent.mm.live.b.y)localb.as(com.tencent.mm.live.b.y.class);
          long l1 = Long.parseLong(((com.tencent.mm.live.b.y)localObject3).hJs);
          localObject2 = ((com.tencent.mm.live.b.y)localObject3).hwb;
          localObject3 = ((com.tencent.mm.live.b.y)localObject3).thumbUrl;
          localObject4 = ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.live.a.class)).getLiveTipsBarStorage();
          localObject6 = Boolean.FALSE;
          long l2 = ((de)localObject5).CreateTime;
          Log.i("MicroMsg.LiveTipsBarStorage", "addLiveToTipsBar, hostRoomId:%s, liveId:%d", new Object[] { localObject1, Long.valueOf(l1) });
          localObject5 = new com.tencent.mm.live.b.c.b();
          ((com.tencent.mm.live.b.c.b)localObject5).field_hostRoomId = ((String)localObject1);
          ((com.tencent.mm.live.b.c.b)localObject5).field_liveId = l1;
          ((com.tencent.mm.live.b.c.b)localObject5).field_liveName = ((String)localObject2);
          ((com.tencent.mm.live.b.c.b)localObject5).field_thumbUrl = ((String)localObject3);
          ((com.tencent.mm.live.b.c.b)localObject5).field_anchorUsername = parama;
          ((com.tencent.mm.live.b.c.b)localObject5).field_isSender = ((Boolean)localObject6).booleanValue();
          ((com.tencent.mm.live.b.c.b)localObject5).field_timeStamp = l2;
          ((com.tencent.mm.live.b.c.c)localObject4).a((com.tencent.mm.live.b.c.b)localObject5);
          break;
          bool = false;
          break label1502;
          label1701:
          parama = localb.dRL;
        }
        label1710:
        AppMethodBeat.o(31009);
        return null;
        label1718:
        localObject1 = "";
        break label792;
      }
    }
  }
  
  public final void b(h.c paramc)
  {
    String str = null;
    AppMethodBeat.i(31013);
    Object localObject = paramc.dTX;
    if (localObject == null)
    {
      Log.e("MicroMsg.AppMessageExtension", "[onPreDelMessage] msg == null");
      AppMethodBeat.o(31013);
      return;
    }
    Log.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + ((eo)localObject).field_imgPath);
    paramc = new ze();
    paramc.efp.path = ((eo)localObject).field_imgPath;
    EventCenter.instance.publish(paramc);
    paramc = ((eo)localObject).field_content;
    if (paramc != null)
    {
      k.b localb = k.b.HD(paramc);
      if ((localb != null) && (localb.type == 6))
      {
        paramc = com.tencent.mm.loader.j.b.aKM() + localb.title;
        com.tencent.mm.vfs.s.deleteFile(paramc);
        com.tencent.mm.vfs.s.deleteFile(com.tencent.mm.loader.j.b.aKM() + localb.title + "_tmp");
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.r.a.cgO().Mp(((eo)localObject).field_msgId);
      if (localObject != null)
      {
        str = ((c)localObject).field_fileFullPath;
        com.tencent.mm.vfs.s.deleteFile(str);
        com.tencent.mm.plugin.r.a.cgO().delete((IAutoDBItem)localObject, new String[] { "msgInfoId" });
      }
      Log.w("MicroMsg.AppMessageExtension", "onPreDelMessage, clean file, %s, %s", new Object[] { paramc, str });
      AppMethodBeat.o(31013);
      return;
      paramc = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void gmY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.k
 * JD-Core Version:    0.7.0.1
 */