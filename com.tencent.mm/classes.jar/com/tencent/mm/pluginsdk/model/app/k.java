package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.k.b.a;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.ar.a;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.g.a.pm;
import com.tencent.mm.g.a.pm.a;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.g.a.ye;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class k
  implements com.tencent.mm.ak.f
{
  private static void F(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(31012);
    com.tencent.mm.storage.ap localap;
    if (!bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.AppMessageExtension", "updateC2CAAMsgMark, mark: %s, talker: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
      az.ayM();
      localap = com.tencent.mm.model.c.awG().aNI(paramString);
      if (localap != null)
      {
        if (!paramBoolean) {
          break label85;
        }
        localap.lp(16777216);
      }
    }
    for (;;)
    {
      az.ayM();
      com.tencent.mm.model.c.awG().a(localap, paramString);
      AppMethodBeat.o(31012);
      return;
      label85:
      localap.lq(16777216);
    }
  }
  
  private f.b a(f.a parama, String paramString, k.b paramb)
  {
    AppMethodBeat.i(31011);
    localcu = parama.fXi;
    az.ayM();
    localh = com.tencent.mm.model.c.awD();
    az.ayM();
    Object localObject1 = com.tencent.mm.model.c.awJ();
    localObject2 = u.axw();
    String str1 = z.a(localcu.DPT);
    String str2 = z.a(localcu.DPU);
    int j;
    bi.b localb;
    label117:
    int i;
    label358:
    boolean bool;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.a.k)localObject1).has(str1)) || (((String)localObject2).equals(str1)))
    {
      j = 1;
      localb = bi.yr(localcu.DPY);
      localObject1 = null;
      if (localb != null) {
        localObject1 = localb.hou;
      }
      if (!w.xm((String)localObject1)) {
        break label1790;
      }
      localObject1 = "notifymessage";
      localObject3 = localh.aF((String)localObject1, localcu.vTQ);
      ac.i("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", new Object[] { Long.valueOf(localcu.vTQ), Long.valueOf(((dy)localObject3).field_msgId) });
      if ((((dy)localObject3).field_msgId != 0L) && (((dy)localObject3).field_createTime + 604800000L < bi.z((String)localObject1, localcu.CreateTime)))
      {
        ac.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localcu.vTQ), Long.valueOf(((dy)localObject3).field_msgId) });
        bi.pK(((dy)localObject3).field_msgId);
        ((bo)localObject3).setMsgId(0L);
      }
      localObject2 = localObject3;
      if (((dy)localObject3).field_msgId == 0L)
      {
        localObject2 = new bo();
        ((bo)localObject2).oz(localcu.vTQ);
        ((bo)localObject2).oA(bi.z((String)localObject1, localcu.CreateTime));
      }
      if (paramb.hhC != null)
      {
        ((bo)localObject2).rl(paramb.hhC.eSk);
        ac.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", new Object[] { ((dy)localObject2).eSk });
      }
      ((bo)localObject2).setType(m.f(paramb));
      if (!((bo)localObject2).eZj()) {
        break label1809;
      }
      localObject3 = paramb.content;
      ((bo)localObject2).setContent((String)localObject3);
      if (((bo)localObject2).eZj()) {
        ((bo)localObject2).rj(paramb.eSb);
      }
      if ((localcu.DPW != 2) || (((dy)localObject2).field_msgId != 0L)) {
        break label2112;
      }
      switch (((bo)localObject2).getType())
      {
      default: 
        i = 0;
        label435:
        if (i == 0) {
          if (paramb.type == 2)
          {
            bool = true;
            label451:
            localObject3 = z.a(localcu.DPX);
            if (ab.ivM)
            {
              ac.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
              localObject3 = null;
            }
            if (bs.cv((byte[])localObject3)) {
              break label1844;
            }
            if ((paramb.type != 33) && (paramb.type != 36) && (paramb.type != 46) && (paramb.type != 44) && (paramb.type != 48)) {
              break label1827;
            }
            localObject3 = com.tencent.mm.av.o.aFx().a((byte[])localObject3, Bitmap.CompressFormat.PNG);
            if (bs.isNullOrNil((String)localObject3)) {
              ac.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", new Object[] { ((dy)localObject2).field_content });
            }
            if (!bs.isNullOrNil((String)localObject3))
            {
              ((bo)localObject2).rf((String)localObject3);
              ac.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path".concat(String.valueOf(localObject3)));
            }
            label603:
            if (j == 0) {
              break label2384;
            }
            ((bo)localObject2).jT(1);
            ((bo)localObject2).re((String)localObject1);
            i = localcu.ndj;
            label628:
            ((bo)localObject2).setStatus(i);
            if (paramb.type == 2001) {
              if (paramb.cZX == 1)
              {
                if ((TextUtils.isEmpty(paramb.hjr)) || (TextUtils.isEmpty(paramb.hjs)) || (paramb.hjt <= 0)) {
                  break label2422;
                }
                ac.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
                localObject1 = new ar();
                ((ar)localObject1).dah = new ar.a();
                ((ar)localObject1).dah.daj = paramb.hjs;
                ((ar)localObject1).dah.dai = paramb.hjr;
                ((ar)localObject1).dah.dak = paramb.hjt;
                com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
              }
            }
          }
        }
        label544:
        break;
      }
    }
    for (;;)
    {
      try
      {
        if (bs.gY(paramb.hjD)) {
          continue;
        }
        localObject1 = paramb.hjD.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = ((String)((Iterator)localObject1).next()).split(",");
          if ((localObject3 == null) || (localObject3.length <= 0)) {
            continue;
          }
          localObject3 = localObject3[0];
          if ((bs.isNullOrNil((String)localObject3)) || (!((String)localObject3).equals(u.axw()))) {
            continue;
          }
          ((bo)localObject2).setFlag(((dy)localObject2).field_flag | 0x8);
          ac.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
          F(true, ((dy)localObject2).field_talker);
        }
      }
      catch (Exception localException)
      {
        long l1;
        long l2;
        label1790:
        Object localObject4;
        label1809:
        label1827:
        label1844:
        Object localObject5;
        String str3;
        c.a locala;
        label2112:
        label2384:
        label2422:
        ac.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", new Object[] { localException.getMessage() });
        continue;
        ((bjn)localObject3).EYT = localException.hgR;
        ((bjn)localObject3).EYV = localException.hgS;
        continue;
        localh.b(localcu.vTQ, (bo)localObject2);
        parama = new f.b((bo)localObject2, false);
        continue;
        localException.dbG.dbO = true;
        continue;
      }
      ac.i("MicroMsg.AppMessageExtension", "paymsgid: %s", new Object[] { paramb.hjq });
      ((bo)localObject2).qf(localcu.DPY);
      if (localb != null)
      {
        ((bo)localObject2).rk(localb.hoy);
        ((bo)localObject2).kk(localb.hoz);
        ((bo)localObject2).ri(localb.hox);
      }
      if (((bo)localObject2).cru()) {
        ((bo)localObject2).rf(com.tencent.mm.modelvideo.t.DU(str1));
      }
      bi.a((bo)localObject2, parama);
      if (((dy)localObject2).field_msgId != 0L) {
        continue;
      }
      ((bo)localObject2).setMsgId(bi.u((bo)localObject2));
      parama = new com.tencent.mm.g.a.t();
      parama.cZb.cZc = ((bo)localObject2);
      parama.cZb.cZd = paramb;
      com.tencent.mm.sdk.b.a.GpY.l(parama);
      parama = new f.b((bo)localObject2, true);
      if ((((bo)localObject2).getType() == 301989937) && (w.xk(((dy)localObject2).field_talker))) {
        ((bo)localObject2).setMsgId(0L);
      }
      if ((((bo)localObject2).fbz()) && ("notifymessage".equals(((dy)localObject2).field_talker)))
      {
        localObject1 = bv.L(((dy)localObject2).field_content, "msg");
        if (localObject1 != null)
        {
          localObject1 = bs.nullAsNil((String)((Map)localObject1).get(".msg.fromusername"));
          if (com.tencent.mm.storage.ai.vC((String)localObject1))
          {
            ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).b((String)localObject1, null);
            ac.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", new Object[] { localObject1 });
          }
        }
      }
      if (((bo)localObject2).getType() == 536870961)
      {
        localObject1 = (com.tencent.mm.ah.b)paramb.ao(com.tencent.mm.ah.b.class);
        localObject3 = new pm();
        ((pm)localObject3).dsv.dsr = ((dy)localObject2).field_msgId;
        ((pm)localObject3).dsv.dsw = ((com.tencent.mm.ah.b)localObject1).dsu;
        ((pm)localObject3).dsv.drV = paramString;
        if (((dy)localObject2).field_isSend == 1)
        {
          ac.d("MicroMsg.AppMessageExtension", "fromuser: %s, touser: %s", new Object[] { str1, str2 });
          ((pm)localObject3).dsv.username = ((dy)localObject2).field_talker;
        }
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
        if (((pm)localObject3).dsv.drV != null)
        {
          ((bo)localObject2).setContent(((pm)localObject3).dsv.drV);
          localh.a(((dy)localObject2).field_msgId, (bo)localObject2);
        }
      }
      if ((!bs.isNullOrNil(paramb.hjw)) && (((bo)localObject2).getType() == 436207665))
      {
        localObject1 = new pk();
        ((pk)localObject1).dsq.dsr = ((dy)localObject2).field_msgId;
        ((pk)localObject1).dsq.drV = paramString;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      if ((paramb.type == 2000) && (!bs.isNullOrNil(paramb.hiO)))
      {
        paramString = new pp();
        paramString.dsA.dlI = paramb.hiO;
        paramString.dsA.msgId = ((dy)localObject2).field_msgId;
        paramString.dsA.dsB = paramb;
        com.tencent.mm.sdk.b.a.GpY.l(paramString);
        F(false, ((dy)localObject2).field_talker);
      }
      paramString = paramb.hkv;
      paramb = bs.bG((String)paramString.get(".msg.appmsg.ext_pay_info.pay_type"), "");
      if (((paramb.equals("wx_f2f")) || (paramb.equals("wx_md"))) && (parama.hvL))
      {
        l1 = ((dy)localObject2).field_createTime;
        l2 = ce.azI();
        ac.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", new Object[] { paramb, Long.valueOf(l1), Long.valueOf(l2) });
        localObject1 = new cd();
        i = bs.getInt((String)paramString.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
        localObject2 = bs.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.pay_feetype"));
        localObject3 = bs.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
        str1 = bs.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.voice_content"));
        str2 = bs.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.expire_voice_timestamp"));
        j = bs.getInt((String)paramString.get(".msg.appmsg.ext_pay_info.need_failover"), 1);
        if ((i > 0) && (!bs.isNullOrNil((String)localObject2)) && (!bs.isNullOrNil((String)localObject3)))
        {
          ((cd)localObject1).dbG.dbH = i;
          ((cd)localObject1).dbG.dbI = ((String)localObject2);
          ((cd)localObject1).dbG.dbJ = ((String)localObject3);
          ((cd)localObject1).dbG.dbK = paramb;
          ((cd)localObject1).dbG.fe = (l2 - l1);
          ((cd)localObject1).dbG.dbL = 0;
          ((cd)localObject1).dbG.dbM = str1;
          ((cd)localObject1).dbG.dbN = str2;
          if (j != 0) {
            continue;
          }
          ((cd)localObject1).dbG.dbO = false;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        }
      }
      AppMethodBeat.o(31011);
      return parama;
      j = 0;
      break;
      if (j != 0)
      {
        localObject1 = str2;
        break label117;
      }
      localObject1 = str1;
      break label117;
      localObject3 = paramString;
      break label358;
      i = 1;
      break label435;
      bool = false;
      break label451;
      localObject3 = a((byte[])localObject3, bool, ((bo)localObject2).fbD());
      break label544;
      if ((!bs.isNullOrNil(paramb.hhV)) && (!bs.isNullOrNil(paramb.hhZ)))
      {
        a(((dy)localObject2).field_msgSvrId, (bo)localObject2, (String)localObject1, paramb.hhZ, paramb.hhV, paramb.hhW, bool, paramb, "", false);
        break label603;
      }
      if (!bs.isNullOrNil(paramb.thumburl))
      {
        ac.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
        localObject4 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
        localObject3 = com.tencent.mm.av.o.aFx().getFullPath((String)localObject4);
        com.tencent.mm.av.o.aFx();
        localObject4 = com.tencent.mm.av.g.tl((String)localObject4);
        localObject5 = com.tencent.mm.av.o.aFB();
        str3 = paramb.thumburl;
        locala = new c.a();
        locala.gKe = ((String)localObject3);
        locala.hKx = true;
        ((com.tencent.mm.av.a.a)localObject5).a(str3, null, locala.aFT());
        ((bo)localObject2).rf((String)localObject4);
        ac.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(localObject3)));
        break label603;
      }
      if (bs.isNullOrNil(paramb.hhM)) {
        break label603;
      }
      a(((dy)localObject2).field_msgSvrId, (bo)localObject2, (String)localObject1, paramb.hhS, paramb.hhM, paramb.hhN, bool, paramb, paramb.hhR, true);
      ac.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.hhM);
      break label603;
      if (!bs.isNullOrNil(paramb.thumburl))
      {
        ac.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
        localObject3 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
        if (paramb.type == 2001) {
          localObject3 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
        }
        if (((bo)localObject2).eZj()) {
          break label603;
        }
        localObject4 = com.tencent.mm.av.o.aFx().getFullPath((String)localObject3);
        com.tencent.mm.av.o.aFx();
        localObject3 = com.tencent.mm.av.g.tl((String)localObject3);
        localObject5 = com.tencent.mm.av.o.aFB();
        str3 = paramb.thumburl;
        locala = new c.a();
        locala.gKe = ((String)localObject4);
        locala.hKx = true;
        ((com.tencent.mm.av.a.a)localObject5).a(str3, null, locala.aFT());
        ((bo)localObject2).rf((String)localObject3);
        ac.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(localObject4)));
        break label603;
      }
      if (bs.isNullOrNil(paramb.hhM)) {
        break label603;
      }
      if (paramb.type == 2)
      {
        bool = true;
        a(((dy)localObject2).field_msgSvrId, (bo)localObject2, (String)localObject1, paramb.hhS, paramb.hhM, paramb.hhN, bool, paramb, paramb.hhR, true);
        ac.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.hhM);
        break label603;
      }
      bool = false;
      continue;
      ((bo)localObject2).jT(0);
      ((bo)localObject2).re((String)localObject1);
      if (localcu.ndj > 3)
      {
        i = localcu.ndj;
        break label628;
      }
      i = 3;
      break label628;
      ac.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
      continue;
      if (!"1001".equals(paramb.hjn))
      {
        localObject1 = new ye();
        ((ye)localObject1).dBH.drV = paramString;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        F(false, ((dy)localObject2).field_talker);
        if ("1002".equals(paramb.hjn))
        {
          localObject1 = (com.tencent.mm.ah.c)paramb.ao(com.tencent.mm.ah.c.class);
          localObject3 = new bjn();
          ((bjn)localObject3).EYU = ((com.tencent.mm.ah.c)localObject1).hgV;
          ((bjn)localObject3).EYX = ((com.tencent.mm.ah.c)localObject1).hgW;
          ((bjn)localObject3).gSO = ((com.tencent.mm.ah.c)localObject1).hgT;
          ((bjn)localObject3).EYW = ((com.tencent.mm.ah.c)localObject1).hgU;
          if (j == 0) {
            continue;
          }
          ((bjn)localObject3).EYT = ((com.tencent.mm.ah.c)localObject1).hgP;
          ((bjn)localObject3).EYV = ((com.tencent.mm.ah.c)localObject1).hgQ;
          localObject4 = (com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class);
          localObject5 = new bjm();
          ((bjm)localObject5).EYD = ((bjn)localObject3);
          ((com.tencent.mm.plugin.luckymoney.a.a)localObject4).a((bjm)localObject5);
          ((com.tencent.mm.plugin.luckymoney.a.a)localObject4).a(((com.tencent.mm.ah.c)localObject1).hgX);
        }
      }
    }
  }
  
  static String a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31010);
    paramArrayOfByte = com.tencent.mm.av.o.aFx().a(paramArrayOfByte, paramBoolean1, Bitmap.CompressFormat.PNG, paramBoolean2);
    AppMethodBeat.o(31010);
    return paramArrayOfByte;
  }
  
  private boolean a(final long paramLong, bo parambo, String paramString1, String paramString2, String paramString3, final int paramInt, final boolean paramBoolean1, final k.b paramb, String paramString4, boolean paramBoolean2)
  {
    AppMethodBeat.i(31014);
    ac.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", new Object[] { Long.valueOf(parambo.field_msgSvrId), paramString2, Integer.valueOf(paramInt), paramString3, paramString1, Boolean.valueOf(paramBoolean1) });
    final long l = bs.eWj();
    final int i;
    com.tencent.mm.i.g localg;
    if (paramb != null)
    {
      i = paramb.type;
      paramb = com.tencent.mm.av.o.aFx().p(bs.eWj(), "", "");
      localg = new com.tencent.mm.i.g();
      localg.field_mediaId = com.tencent.mm.an.c.a("downappthumb", parambo.field_createTime, paramString1, String.valueOf(paramLong));
      localg.field_fullpath = paramb;
      if (!paramBoolean2) {
        break label290;
      }
      localg.field_fileType = 19;
      localg.fre = paramString3;
      label163:
      localg.field_totalLen = paramInt;
      localg.field_aesKey = paramString2;
      localg.field_priority = com.tencent.mm.i.a.fqq;
      localg.field_authKey = paramString4;
      if (!w.sQ(paramString1)) {
        break label308;
      }
    }
    label290:
    label308:
    for (int j = 1;; j = 0)
    {
      localg.field_chattype = j;
      ac.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString1 });
      localg.frb = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(31005);
          if (paramAnonymousInt != 0)
          {
            ac.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousInt), l });
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(paramInt), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramb), "" })).aHZ();
            AppMethodBeat.o(31005);
            return paramAnonymousInt;
          }
          if (paramAnonymousd == null)
          {
            AppMethodBeat.o(31005);
            return 0;
          }
          label210:
          long l1;
          long l2;
          int i;
          int j;
          int k;
          if (paramAnonymousd.field_retCode != 0)
          {
            ac.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousd.field_retCode), l });
            if (paramAnonymousd != null) {
              break label904;
            }
            paramAnonymousInt = -1;
            l1 = paramInt;
            l2 = bs.eWj();
            i = com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext());
            j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
            k = paramb;
            if (paramAnonymousd != null) {
              break label913;
            }
            paramAnonymousString = "";
            label248:
            if (paramAnonymousd != null) {
              break label922;
            }
            paramAnonymousc = "";
            label256:
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aHZ();
            if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode != 0))
            {
              if (paramAnonymousd != null) {
                break label931;
              }
              paramAnonymousInt = -1;
              label402:
              l1 = paramInt;
              l2 = bs.eWj();
              i = com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext());
              j = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
              k = paramb;
              if (paramAnonymousd != null) {
                break label940;
              }
              paramAnonymousString = "";
              label440:
              if (paramAnonymousd != null) {
                break label949;
              }
            }
          }
          label896:
          label904:
          label913:
          label922:
          label931:
          label940:
          label949:
          for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.fqM)
          {
            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aHZ();
            com.tencent.mm.av.o.aFx().doNotify();
            AppMethodBeat.o(31005);
            return 0;
            az.ayM();
            paramAnonymousc = com.tencent.mm.model.c.awD().aF(i, paramLong);
            if (paramAnonymousc.field_msgSvrId != paramLong)
            {
              ac.e("MicroMsg.AppMessageExtension", "hy: appmsg %d has been deleted", new Object[] { Long.valueOf(paramLong) });
              AppMethodBeat.o(31005);
              return 0;
            }
            ac.i("MicroMsg.AppMessageExtension", "hy: %d current msg type is %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousc.getType()) });
            paramAnonymousString = com.tencent.mm.vfs.i.aU(paramBoolean1, 0, -1);
            if ((this.Dih == 33) || (this.Dih == 36) || (this.Dih == 46) || (this.Dih == 44) || (this.Dih == 48))
            {
              paramAnonymousString = com.tencent.mm.av.o.aFx().a(paramAnonymousString, Bitmap.CompressFormat.JPEG);
              label747:
              if (!bs.isNullOrNil(paramAnonymousString))
              {
                paramAnonymousc.rf(paramAnonymousString);
                az.ayM();
                com.tencent.mm.model.c.awD().b(paramAnonymousc.field_msgSvrId, paramAnonymousc);
              }
              ac.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", new Object[] { Long.valueOf(paramLong), i, l, paramAnonymousString });
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 16L, paramb, false);
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(198L, 17L, 1L, false);
              paramAnonymousString = com.tencent.mm.plugin.report.service.h.wUl;
              if (!w.sQ(i)) {
                break label896;
              }
            }
            for (l1 = 19L;; l1 = 18L)
            {
              paramAnonymousString.idkeyStat(198L, l1, 1L, false);
              break;
              paramAnonymousString = k.a(paramAnonymousString, this.Dii, paramAnonymousc.fbD());
              break label747;
            }
            paramAnonymousInt = paramAnonymousd.field_retCode;
            break label210;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break label248;
            paramAnonymousc = paramAnonymousd.fqM;
            break label256;
            paramAnonymousInt = paramAnonymousd.field_retCode;
            break label402;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break label440;
          }
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return null;
        }
      };
      com.tencent.mm.an.f.aDD().b(localg, -1);
      AppMethodBeat.o(31014);
      return true;
      i = 0;
      break;
      localg.field_fileId = paramString3;
      localg.field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
      break label163;
    }
  }
  
  public static String kV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31008);
    if (bs.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(31008);
      return null;
    }
    String str = paramString2;
    if (w.sQ(paramString1))
    {
      int i = bi.yi(paramString2);
      str = paramString2;
      if (i != -1) {
        str = (paramString2 + " ").substring(i + 2).trim();
      }
    }
    paramString1 = bs.aLx(str);
    AppMethodBeat.o(31008);
    return paramString1;
  }
  
  public final boolean a(final a parama, String paramString1, long paramLong, String paramString2, final String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(31015);
    String str = com.tencent.mm.av.o.aFx().p("Note_".concat(String.valueOf(paramString1)), "", "");
    if (com.tencent.mm.vfs.i.eA(str))
    {
      AppMethodBeat.o(31015);
      return false;
    }
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.field_mediaId = com.tencent.mm.an.c.a("downappthumb", paramLong, paramString4, String.valueOf(paramString1));
    localg.field_fullpath = str;
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
    localg.field_totalLen = paramInt;
    localg.field_aesKey = paramString2;
    localg.field_fileId = paramString3;
    localg.field_priority = com.tencent.mm.i.a.fqq;
    if (w.sQ(paramString4)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localg.field_chattype = paramInt;
      ac.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString4 });
      localg.frb = new g.a()
      {
        WeakReference<k.a> Dik;
        
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(31007);
          ac.i("MicroMsg.AppMessageExtension", "getThumbByCdn start callback: field_mediaId:%s thumbUrl:%s", new Object[] { paramAnonymousString, paramString3 });
          if (paramAnonymousInt != 0)
          {
            ac.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: startRet:%d thumbUrl:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramString3 });
            AppMethodBeat.o(31007);
            return paramAnonymousInt;
          }
          if (paramAnonymousd == null)
          {
            AppMethodBeat.o(31007);
            return 0;
          }
          if (paramAnonymousd.field_retCode != 0)
          {
            ac.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: sceneResult.field_retCode:%d thumbUrl:%s", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramString3 });
            paramAnonymousInt = paramAnonymousd.field_retCode;
            AppMethodBeat.o(31007);
            return paramAnonymousInt;
          }
          ac.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished thumbUrl:%s", new Object[] { paramString3 });
          com.tencent.mm.av.o.aFx().doNotify();
          paramAnonymousString = (k.a)this.Dik.get();
          if (paramAnonymousString != null) {
            paramAnonymousString.eLf();
          }
          AppMethodBeat.o(31007);
          return 0;
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return null;
        }
      };
      com.tencent.mm.an.f.aDD().b(localg, -1);
      AppMethodBeat.o(31015);
      return true;
    }
  }
  
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(31009);
    ac.d("MicroMsg.AppMessageExtension", "process add app message");
    Object localObject5 = parama.fXi;
    Object localObject1 = z.a(((cu)localObject5).DPT);
    String str = z.a(((cu)localObject5).DPU);
    if ((bs.isNullOrNil((String)localObject1)) || (bs.isNullOrNil(str))) {
      ac.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
    }
    k.b localb;
    for (str = null;; str = kV((String)localObject1, z.a(((cu)localObject5).DPV)))
    {
      localb = k.b.vA(str);
      if (localb != null) {
        break;
      }
      ac.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
      AppMethodBeat.o(31009);
      return null;
    }
    if (localb.hju)
    {
      az.ayM();
      com.tencent.mm.model.c.agA().set(352273, str);
      az.ayM();
      com.tencent.mm.model.c.agA().set(352274, Long.valueOf(System.currentTimeMillis()));
      new b(str).eKV();
      AppMethodBeat.o(31009);
      return null;
    }
    Object localObject2 = ap.dny().aGk(localb.appId);
    Object localObject3 = localb.appId;
    int i = localb.aBM;
    if (localObject2 == null) {}
    f.b localb1;
    for (localObject1 = "null";; localObject1 = Integer.valueOf(((g)localObject2).field_appVersion))
    {
      ac.i("MicroMsg.AppMessageExtension", "check version appid:%s, msgVer:%d, appVer:%s", new Object[] { localObject3, Integer.valueOf(i), localObject1 });
      if ((localObject2 == null) || (((g)localObject2).field_appVersion < localb.aBM)) {
        ap.dnx().aGj(localb.appId);
      }
      localb1 = a(parama, z.a(((cu)localObject5).DPV), localb);
      if (localb1.cZc != null) {
        break;
      }
      AppMethodBeat.o(31009);
      return null;
    }
    bo localbo = localb1.cZc;
    if (localbo.eZj())
    {
      AppMethodBeat.o(31009);
      return localb1;
    }
    if (localbo.getType() == 301989937)
    {
      AppMethodBeat.o(31009);
      return localb1;
    }
    if (localbo.getType() == -1879048190)
    {
      localObject1 = new xd();
      ((xd)localObject1).dzU.dqf = str;
      ((xd)localObject1).dzU.description = localb.description;
      ((xd)localObject1).dzU.cZc = localbo;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    if ((localbo.getType() == 49) && (!bs.isNullOrNil(localb.canvasPageXml)))
    {
      localObject1 = new com.tencent.mm.g.a.f();
      ((com.tencent.mm.g.a.f)localObject1).cYo.cYp = localb.canvasPageXml;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    if (localbo.cru())
    {
      localObject3 = (String)com.tencent.mm.kernel.g.agR().agA().get(2, "");
      localObject1 = z.a(((cu)localObject5).DPU);
      localObject2 = z.a(((cu)localObject5).DPT);
      if ((!((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ().has((String)localObject2)) && (!((String)localObject3).equals(localObject2))) {
        break label1060;
      }
      i = 1;
      localObject3 = new s();
      if (i == 0) {
        break label1065;
      }
      label568:
      ((s)localObject3).drG = ((String)localObject1);
      ((s)localObject3).iaC = ((String)localObject2);
      ((s)localObject3).createTime = ((cu)localObject5).CreateTime;
      ((s)localObject3).dpl = ((cu)localObject5).vTQ;
      ((s)localObject3).iaO = ((cu)localObject5).DPV.FEm;
      ((s)localObject3).iaJ = ((int)localbo.field_msgId);
      if (!localbo.fbt()) {
        break label1072;
      }
    }
    Object localObject6;
    for (localObject1 = new com.tencent.mm.ah.y().a(localbo.GYQ);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ((s)localObject3).fileName = localbo.field_imgPath;
        ((s)localObject3).a(((com.tencent.mm.ah.y)localObject1).videoUrl, ((com.tencent.mm.ah.y)localObject1).videoDuration, ((com.tencent.mm.ah.y)localObject1).title, ((com.tencent.mm.ah.y)localObject1).DWF, "", "", "");
        ((s)localObject3).status = 111;
      }
      com.tencent.mm.modelvideo.o.aJy().b((s)localObject3);
      if (localb.type != 53) {
        break label1371;
      }
      ac.i("MicroMsg.AppMessageExtension", "process MM_APP_SOLITAIRE_TEXT");
      localObject3 = ((cu)localObject5).DPZ;
      localObject6 = localb.title;
      if (!bs.isNullOrNil((String)localObject3)) {
        break label1142;
      }
      localObject1 = "";
      label762:
      ((cu)localObject5).DPZ = ((String)localObject1);
      localObject1 = bi.yl(localbo.field_content);
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break label1717;
      }
      label792:
      if (!parama.hvF) {
        break label1314;
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).b(z.a(((cu)localObject5).DPT), (String)localObject1, localb.title, (String)localb.hko.second, localbo.field_msgId, localbo.field_createTime / 1000L);
      label853:
      if ((w.wp(localbo.field_talker)) && (com.tencent.mm.chatroom.d.y.VM())) {
        ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupTodoByReceiverAppMsg(localbo);
      }
      if ((w.wp(localbo.field_talker)) && (aa.VQ())) {
        ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(localbo);
      }
      parama = new com.tencent.mm.ah.k();
      localb.a(parama);
      parama.field_msgId = localbo.field_msgId;
      if ((ap.eLl().zN(localbo.field_msgId) != null) || (!ap.eLl().insert(parama))) {
        break label1709;
      }
      if (localb.type == 40)
      {
        parama = ap.bEO().zM(localbo.field_msgId);
        localObject1 = com.tencent.mm.ah.t.vF(str);
        if (parama == null) {
          m.a(null, localbo.field_msgId, 0, null, null, ((com.tencent.mm.ah.t)localObject1).hkZ, localb.type, 0);
        }
        parama = new com.tencent.mm.plugin.record.b.e(localbo.field_msgId, localbo.field_msgSvrId, null);
        az.agi().a(parama, 0);
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
      localObject1 = k.b.az(localbo.field_content, localbo.field_reserved);
      if (localObject1 != null) {
        break label1106;
      }
      ac.w("MicroMsg.AppMessageExtension", "getVideoInfo content is null");
    }
    label1106:
    localObject1 = (com.tencent.mm.ah.e)((k.b)localObject1).ao(com.tencent.mm.ah.e.class);
    if ((localObject1 != null) && (((com.tencent.mm.ah.e)localObject1).hhf != null)) {}
    for (localObject1 = ((com.tencent.mm.ah.e)localObject1).hhf;; localObject1 = null)
    {
      break;
      label1142:
      localObject2 = bs.aLx((String)localObject3);
      if (bs.isNullOrNil((String)localObject2))
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
        localObject2 = bv.L((String)localObject2, "pushcontent");
        if (localObject2 == null)
        {
          ac.e("MicroMsg.AppMessageExtension", "inval xml");
          localObject1 = localObject3;
          break;
        }
        localObject2 = (String)((Map)localObject2).get(".pushcontent.$nickname");
        ((StringBuilder)localObject1).append("<pushcontent content=\"").append((String)localObject2).append(" : ").append((String)localObject6).append("\"nickname=\"").append((String)localObject2).append("\" />\n");
        localObject1 = ((StringBuilder)localObject1).toString();
        break;
        label1314:
        ((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).a(z.a(((cu)localObject5).DPT), (String)localObject1, localb.title, (String)localb.hko.second, localbo.field_msgId, localbo.field_createTime / 1000L);
        break label853;
        label1371:
        if (localb.type == 57)
        {
          ac.i("MicroMsg.AppMessageExtension", "process MM_APP_MSG_QUOTE");
          ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).handleReceivedQuoteMsg(localbo.field_msgId, localbo.field_msgSvrId, localbo.field_talker, localb.hkp.uVU);
          break label853;
        }
        if (localb.type != 60) {
          break label853;
        }
        parama = (String)com.tencent.mm.kernel.g.agR().agA().get(2, "");
        localObject1 = z.a(((cu)localObject5).DPT);
        boolean bool;
        if ((((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ().has((String)localObject1)) || (parama.equals(localObject1)))
        {
          bool = true;
          label1501:
          if (!bool) {
            break label1700;
          }
        }
        for (;;)
        {
          ac.i("MicroMsg.AppMessageExtension", "process MM_APP_MMLIVE_SHARE, isSender%b, anchor:%s", new Object[] { Boolean.valueOf(bool), parama });
          if (bool) {
            break;
          }
          localObject3 = (com.tencent.mm.live.b.l)localb.ao(com.tencent.mm.live.b.l.class);
          long l1 = Long.parseLong(((com.tencent.mm.live.b.l)localObject3).gvC);
          localObject2 = ((com.tencent.mm.live.b.l)localObject3).gmR;
          localObject3 = ((com.tencent.mm.live.b.l)localObject3).thumbUrl;
          localObject4 = ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage();
          localObject6 = Boolean.FALSE;
          long l2 = ((cu)localObject5).CreateTime;
          ac.i("MicroMsg.LiveTipsBarStorage", "addLiveToTipsBar, hostRoomId:%s, liveId:%d", new Object[] { localObject1, Long.valueOf(l1) });
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
          break label1501;
          label1700:
          parama = localb.dng;
        }
        label1709:
        AppMethodBeat.o(31009);
        return null;
        label1717:
        localObject1 = "";
        break label792;
      }
    }
  }
  
  public final void b(f.c paramc)
  {
    String str = null;
    AppMethodBeat.i(31013);
    Object localObject = paramc.dpq;
    if (localObject == null)
    {
      ac.e("MicroMsg.AppMessageExtension", "[onPreDelMessage] msg == null");
      AppMethodBeat.o(31013);
      return;
    }
    ac.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + ((dy)localObject).field_imgPath);
    paramc = new xc();
    paramc.dzT.path = ((dy)localObject).field_imgPath;
    com.tencent.mm.sdk.b.a.GpY.l(paramc);
    paramc = ((dy)localObject).field_content;
    if (paramc != null)
    {
      k.b localb = k.b.vA(paramc);
      if ((localb != null) && (localb.type == 6))
      {
        paramc = com.tencent.mm.loader.j.b.apj() + localb.title;
        com.tencent.mm.vfs.i.deleteFile(paramc);
        com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.loader.j.b.apj() + localb.title + "_tmp");
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.s.a.bEO().zM(((dy)localObject).field_msgId);
      if (localObject != null)
      {
        str = ((c)localObject).field_fileFullPath;
        com.tencent.mm.vfs.i.deleteFile(str);
        com.tencent.mm.plugin.s.a.bEO().delete((com.tencent.mm.sdk.e.c)localObject, new String[] { "msgInfoId" });
      }
      ac.w("MicroMsg.AppMessageExtension", "onPreDelMessage, clean file, %s, %s", new Object[] { paramc, str });
      AppMethodBeat.o(31013);
      return;
      paramc = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void eLf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.k
 * JD-Core Version:    0.7.0.1
 */