package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.k.b.a;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.g.a.aq.a;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.g.a.pb;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.g.a.pd.a;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.g.a.wr;
import com.tencent.mm.g.a.ws;
import com.tencent.mm.g.a.xt;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.b;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.as;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class k
  implements com.tencent.mm.al.f
{
  private static void E(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(31012);
    am localam;
    if (!bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.AppMessageExtension", "updateC2CAAMsgMark, mark: %s, talker: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
      az.arV();
      localam = com.tencent.mm.model.c.apR().aIn(paramString);
      if (localam != null)
      {
        if (!paramBoolean) {
          break label85;
        }
        localam.lu(16777216);
      }
    }
    for (;;)
    {
      az.arV();
      com.tencent.mm.model.c.apR().a(localam, paramString);
      AppMethodBeat.o(31012);
      return;
      label85:
      localam.lv(16777216);
    }
  }
  
  private f.b a(f.a parama, String paramString, k.b paramb)
  {
    AppMethodBeat.i(31011);
    localcs = parama.fTo;
    az.arV();
    localh = com.tencent.mm.model.c.apO();
    az.arV();
    Object localObject1 = com.tencent.mm.model.c.apU();
    localObject2 = u.aqG();
    String str1 = z.a(localcs.Cxx);
    String str2 = z.a(localcs.Cxy);
    int j;
    bi.b localb;
    label117:
    int i;
    label358:
    boolean bool;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.a.k)localObject1).has(str1)) || (((String)localObject2).equals(str1)))
    {
      j = 1;
      localb = bi.ul(localcs.CxC);
      localObject1 = null;
      if (localb != null) {
        localObject1 = localb.gNU;
      }
      if (!w.tj((String)localObject1)) {
        break label1790;
      }
      localObject1 = "notifymessage";
      localObject3 = localh.aD((String)localObject1, localcs.uKZ);
      ad.i("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", new Object[] { Long.valueOf(localcs.uKZ), Long.valueOf(((du)localObject3).field_msgId) });
      if ((((du)localObject3).field_msgId != 0L) && (((du)localObject3).field_createTime + 604800000L < bi.y((String)localObject1, localcs.CreateTime)))
      {
        ad.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localcs.uKZ), Long.valueOf(((du)localObject3).field_msgId) });
        bi.lW(((du)localObject3).field_msgId);
        ((bl)localObject3).setMsgId(0L);
      }
      localObject2 = localObject3;
      if (((du)localObject3).field_msgId == 0L)
      {
        localObject2 = new bl();
        ((bl)localObject2).kX(localcs.uKZ);
        ((bl)localObject2).kY(bi.y((String)localObject1, localcs.CreateTime));
      }
      if (paramb.gHb != null)
      {
        ((bl)localObject2).of(paramb.gHb.ePc);
        ad.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", new Object[] { ((du)localObject2).ePc });
      }
      ((bl)localObject2).setType(m.f(paramb));
      if (!((bl)localObject2).eJL()) {
        break label1809;
      }
      localObject3 = paramb.content;
      ((bl)localObject2).setContent((String)localObject3);
      if (((bl)localObject2).eJL()) {
        ((bl)localObject2).od(paramb.eOT);
      }
      if ((localcs.CxA != 2) || (((du)localObject2).field_msgId != 0L)) {
        break label2112;
      }
      switch (((bl)localObject2).getType())
      {
      default: 
        i = 0;
        label435:
        if (i == 0) {
          if (paramb.type == 2)
          {
            bool = true;
            label451:
            localObject3 = z.a(localcs.CxB);
            if (com.tencent.mm.platformtools.ab.hVI)
            {
              ad.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
              localObject3 = null;
            }
            if (bt.cw((byte[])localObject3)) {
              break label1844;
            }
            if ((paramb.type != 33) && (paramb.type != 36) && (paramb.type != 46) && (paramb.type != 44) && (paramb.type != 48)) {
              break label1827;
            }
            localObject3 = com.tencent.mm.aw.o.ayF().a((byte[])localObject3, Bitmap.CompressFormat.PNG);
            if (bt.isNullOrNil((String)localObject3)) {
              ad.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", new Object[] { ((du)localObject2).field_content });
            }
            if (!bt.isNullOrNil((String)localObject3))
            {
              ((bl)localObject2).nZ((String)localObject3);
              ad.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path".concat(String.valueOf(localObject3)));
            }
            label603:
            if (j == 0) {
              break label2384;
            }
            ((bl)localObject2).jV(1);
            ((bl)localObject2).nY((String)localObject1);
            i = localcs.mBi;
            label628:
            ((bl)localObject2).setStatus(i);
            if (paramb.type == 2001) {
              if (paramb.dcz == 1)
              {
                if ((TextUtils.isEmpty(paramb.gIR)) || (TextUtils.isEmpty(paramb.gIS)) || (paramb.gIT <= 0)) {
                  break label2422;
                }
                ad.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
                localObject1 = new aq();
                ((aq)localObject1).dcJ = new aq.a();
                ((aq)localObject1).dcJ.dcL = paramb.gIS;
                ((aq)localObject1).dcJ.dcK = paramb.gIR;
                ((aq)localObject1).dcJ.dcM = paramb.gIT;
                com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
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
        if (bt.gL(paramb.gJd)) {
          continue;
        }
        localObject1 = paramb.gJd.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = ((String)((Iterator)localObject1).next()).split(",");
          if ((localObject3 == null) || (localObject3.length <= 0)) {
            continue;
          }
          localObject3 = localObject3[0];
          if ((bt.isNullOrNil((String)localObject3)) || (!((String)localObject3).equals(u.aqG()))) {
            continue;
          }
          ((bl)localObject2).setFlag(((du)localObject2).field_flag | 0x8);
          ad.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
          E(true, ((du)localObject2).field_talker);
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
        ad.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", new Object[] { localException.getMessage() });
        continue;
        ((bfv)localObject3).DDx = localException.gGq;
        ((bfv)localObject3).DDz = localException.gGr;
        continue;
        localh.b(localcs.uKZ, (bl)localObject2);
        parama = new f.b((bl)localObject2, false);
        continue;
        localException.dek.des = true;
        continue;
      }
      ad.i("MicroMsg.AppMessageExtension", "paymsgid: %s", new Object[] { paramb.gIQ });
      ((bl)localObject2).mZ(localcs.CxC);
      if (localb != null)
      {
        ((bl)localObject2).oe(localb.gNY);
        ((bl)localObject2).kn(localb.gNZ);
        ((bl)localObject2).oc(localb.gNX);
      }
      if (((bl)localObject2).cjN()) {
        ((bl)localObject2).nZ(com.tencent.mm.modelvideo.t.zP(str1));
      }
      bi.a((bl)localObject2, parama);
      if (((du)localObject2).field_msgId != 0L) {
        continue;
      }
      ((bl)localObject2).setMsgId(bi.u((bl)localObject2));
      parama = new com.tencent.mm.g.a.s();
      parama.dbC.dbD = ((bl)localObject2);
      parama.dbC.dbE = paramb;
      com.tencent.mm.sdk.b.a.ESL.l(parama);
      parama = new f.b((bl)localObject2, true);
      if ((((bl)localObject2).getType() == 301989937) && (w.th(((du)localObject2).field_talker))) {
        ((bl)localObject2).setMsgId(0L);
      }
      if ((((bl)localObject2).eLV()) && ("notifymessage".equals(((du)localObject2).field_talker)))
      {
        localObject1 = bw.K(((du)localObject2).field_content, "msg");
        if (localObject1 != null)
        {
          localObject1 = bt.nullAsNil((String)((Map)localObject1).get(".msg.fromusername"));
          if (af.rz((String)localObject1))
          {
            ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).b((String)localObject1, null);
            ad.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", new Object[] { localObject1 });
          }
        }
      }
      if (((bl)localObject2).getType() == 536870961)
      {
        localObject1 = (com.tencent.mm.ai.b)paramb.ao(com.tencent.mm.ai.b.class);
        localObject3 = new pd();
        ((pd)localObject3).duJ.duG = ((du)localObject2).field_msgId;
        ((pd)localObject3).duJ.duK = ((com.tencent.mm.ai.b)localObject1).duI;
        ((pd)localObject3).duJ.duk = paramString;
        if (((du)localObject2).field_isSend == 1)
        {
          ad.d("MicroMsg.AppMessageExtension", "fromuser: %s, touser: %s", new Object[] { str1, str2 });
          ((pd)localObject3).duJ.username = ((du)localObject2).field_talker;
        }
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
        if (((pd)localObject3).duJ.duk != null)
        {
          ((bl)localObject2).setContent(((pd)localObject3).duJ.duk);
          localh.a(((du)localObject2).field_msgId, (bl)localObject2);
        }
      }
      if ((!bt.isNullOrNil(paramb.gIW)) && (((bl)localObject2).getType() == 436207665))
      {
        localObject1 = new pb();
        ((pb)localObject1).duF.duG = ((du)localObject2).field_msgId;
        ((pb)localObject1).duF.duk = paramString;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      if ((paramb.type == 2000) && (!bt.isNullOrNil(paramb.gIn)))
      {
        paramString = new pg();
        paramString.duO.dnZ = paramb.gIn;
        paramString.duO.msgId = ((du)localObject2).field_msgId;
        paramString.duO.duP = paramb;
        com.tencent.mm.sdk.b.a.ESL.l(paramString);
        E(false, ((du)localObject2).field_talker);
      }
      paramString = paramb.gJV;
      paramb = bt.by((String)paramString.get(".msg.appmsg.ext_pay_info.pay_type"), "");
      if (((paramb.equals("wx_f2f")) || (paramb.equals("wx_md"))) && (parama.gVm))
      {
        l1 = ((du)localObject2).field_createTime;
        l2 = ce.asR();
        ad.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", new Object[] { paramb, Long.valueOf(l1), Long.valueOf(l2) });
        localObject1 = new cd();
        i = bt.getInt((String)paramString.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
        localObject2 = bt.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.pay_feetype"));
        localObject3 = bt.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
        str1 = bt.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.voice_content"));
        str2 = bt.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.expire_voice_timestamp"));
        j = bt.getInt((String)paramString.get(".msg.appmsg.ext_pay_info.need_failover"), 1);
        if ((i > 0) && (!bt.isNullOrNil((String)localObject2)) && (!bt.isNullOrNil((String)localObject3)))
        {
          ((cd)localObject1).dek.del = i;
          ((cd)localObject1).dek.dem = ((String)localObject2);
          ((cd)localObject1).dek.den = ((String)localObject3);
          ((cd)localObject1).dek.deo = paramb;
          ((cd)localObject1).dek.ed = (l2 - l1);
          ((cd)localObject1).dek.dep = 0;
          ((cd)localObject1).dek.deq = str1;
          ((cd)localObject1).dek.der = str2;
          if (j != 0) {
            continue;
          }
          ((cd)localObject1).dek.des = false;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
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
      localObject3 = a((byte[])localObject3, bool, ((bl)localObject2).eLZ());
      break label544;
      if ((!bt.isNullOrNil(paramb.gHu)) && (!bt.isNullOrNil(paramb.gHy)))
      {
        a(((du)localObject2).field_msgSvrId, (bl)localObject2, (String)localObject1, paramb.gHy, paramb.gHu, paramb.gHv, bool, paramb, "", false);
        break label603;
      }
      if (!bt.isNullOrNil(paramb.thumburl))
      {
        ad.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
        localObject4 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
        localObject3 = com.tencent.mm.aw.o.ayF().getFullPath((String)localObject4);
        com.tencent.mm.aw.o.ayF();
        localObject4 = com.tencent.mm.aw.g.pY((String)localObject4);
        localObject5 = com.tencent.mm.aw.o.ayJ();
        str3 = paramb.thumburl;
        locala = new c.a();
        locala.gjt = ((String)localObject3);
        locala.hjU = true;
        ((com.tencent.mm.aw.a.a)localObject5).a(str3, null, locala.azc());
        ((bl)localObject2).nZ((String)localObject4);
        ad.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(localObject3)));
        break label603;
      }
      if (bt.isNullOrNil(paramb.gHl)) {
        break label603;
      }
      a(((du)localObject2).field_msgSvrId, (bl)localObject2, (String)localObject1, paramb.gHr, paramb.gHl, paramb.gHm, bool, paramb, paramb.gHq, true);
      ad.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.gHl);
      break label603;
      if (!bt.isNullOrNil(paramb.thumburl))
      {
        ad.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
        localObject3 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
        if (paramb.type == 2001) {
          localObject3 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
        }
        if (((bl)localObject2).eJL()) {
          break label603;
        }
        localObject4 = com.tencent.mm.aw.o.ayF().getFullPath((String)localObject3);
        com.tencent.mm.aw.o.ayF();
        localObject3 = com.tencent.mm.aw.g.pY((String)localObject3);
        localObject5 = com.tencent.mm.aw.o.ayJ();
        str3 = paramb.thumburl;
        locala = new c.a();
        locala.gjt = ((String)localObject4);
        locala.hjU = true;
        ((com.tencent.mm.aw.a.a)localObject5).a(str3, null, locala.azc());
        ((bl)localObject2).nZ((String)localObject3);
        ad.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(localObject4)));
        break label603;
      }
      if (bt.isNullOrNil(paramb.gHl)) {
        break label603;
      }
      if (paramb.type == 2)
      {
        bool = true;
        a(((du)localObject2).field_msgSvrId, (bl)localObject2, (String)localObject1, paramb.gHr, paramb.gHl, paramb.gHm, bool, paramb, paramb.gHq, true);
        ad.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.gHl);
        break label603;
      }
      bool = false;
      continue;
      ((bl)localObject2).jV(0);
      ((bl)localObject2).nY((String)localObject1);
      if (localcs.mBi > 3)
      {
        i = localcs.mBi;
        break label628;
      }
      i = 3;
      break label628;
      ad.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
      continue;
      if (!"1001".equals(paramb.gIN))
      {
        localObject1 = new xt();
        ((xt)localObject1).dDV.duk = paramString;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        E(false, ((du)localObject2).field_talker);
        if ("1002".equals(paramb.gIN))
        {
          localObject1 = (com.tencent.mm.ai.c)paramb.ao(com.tencent.mm.ai.c.class);
          localObject3 = new bfv();
          ((bfv)localObject3).DDy = ((com.tencent.mm.ai.c)localObject1).gGu;
          ((bfv)localObject3).DDB = ((com.tencent.mm.ai.c)localObject1).gGv;
          ((bfv)localObject3).gsg = ((com.tencent.mm.ai.c)localObject1).gGs;
          ((bfv)localObject3).DDA = ((com.tencent.mm.ai.c)localObject1).gGt;
          if (j == 0) {
            continue;
          }
          ((bfv)localObject3).DDx = ((com.tencent.mm.ai.c)localObject1).gGo;
          ((bfv)localObject3).DDz = ((com.tencent.mm.ai.c)localObject1).gGp;
          localObject4 = (com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class);
          localObject5 = new bfu();
          ((bfu)localObject5).DDh = ((bfv)localObject3);
          ((com.tencent.mm.plugin.luckymoney.a.a)localObject4).a((bfu)localObject5);
          ((com.tencent.mm.plugin.luckymoney.a.a)localObject4).a(((com.tencent.mm.ai.c)localObject1).gGw);
        }
      }
    }
  }
  
  static String a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31010);
    paramArrayOfByte = com.tencent.mm.aw.o.ayF().a(paramArrayOfByte, paramBoolean1, Bitmap.CompressFormat.PNG, paramBoolean2);
    AppMethodBeat.o(31010);
    return paramArrayOfByte;
  }
  
  private boolean a(final long paramLong, bl parambl, String paramString1, String paramString2, String paramString3, final int paramInt, final boolean paramBoolean1, final k.b paramb, String paramString4, boolean paramBoolean2)
  {
    AppMethodBeat.i(31014);
    ad.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", new Object[] { Long.valueOf(parambl.field_msgSvrId), paramString2, Integer.valueOf(paramInt), paramString3, paramString1, Boolean.valueOf(paramBoolean1) });
    final long l = bt.eGO();
    final int i;
    com.tencent.mm.i.g localg;
    if (paramb != null)
    {
      i = paramb.type;
      paramb = com.tencent.mm.aw.o.ayF().p(bt.eGO(), "", "");
      localg = new com.tencent.mm.i.g();
      localg.field_mediaId = com.tencent.mm.ao.c.a("downappthumb", parambl.field_createTime, paramString1, String.valueOf(paramLong));
      localg.field_fullpath = paramb;
      if (!paramBoolean2) {
        break label290;
      }
      localg.field_fileType = 19;
      localg.fnK = paramString3;
      label163:
      localg.field_totalLen = paramInt;
      localg.field_aesKey = paramString2;
      localg.field_priority = com.tencent.mm.i.a.fmW;
      localg.field_authKey = paramString4;
      if (!w.pF(paramString1)) {
        break label308;
      }
    }
    label290:
    label308:
    for (int j = 1;; j = 0)
    {
      localg.field_chattype = j;
      ad.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString1 });
      localg.fnH = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(31005);
          if (paramAnonymousInt != 0)
          {
            ad.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousInt), l });
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(paramInt), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramb), "" })).aBj();
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
            ad.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousd.field_retCode), l });
            if (paramAnonymousd != null) {
              break label904;
            }
            paramAnonymousInt = -1;
            l1 = paramInt;
            l2 = bt.eGO();
            i = com.tencent.mm.ao.c.cu(aj.getContext());
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
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aBj();
            if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode != 0))
            {
              if (paramAnonymousd != null) {
                break label931;
              }
              paramAnonymousInt = -1;
              label402:
              l1 = paramInt;
              l2 = bt.eGO();
              i = com.tencent.mm.ao.c.cu(aj.getContext());
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
          for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.fns)
          {
            new com.tencent.mm.g.b.a.f(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aBj();
            com.tencent.mm.aw.o.ayF().doNotify();
            AppMethodBeat.o(31005);
            return 0;
            az.arV();
            paramAnonymousc = com.tencent.mm.model.c.apO().aD(i, paramLong);
            if (paramAnonymousc.field_msgSvrId != paramLong)
            {
              ad.e("MicroMsg.AppMessageExtension", "hy: appmsg %d has been deleted", new Object[] { Long.valueOf(paramLong) });
              AppMethodBeat.o(31005);
              return 0;
            }
            ad.i("MicroMsg.AppMessageExtension", "hy: %d current msg type is %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousc.getType()) });
            paramAnonymousString = com.tencent.mm.vfs.i.aR(paramBoolean1, 0, -1);
            if ((this.BPT == 33) || (this.BPT == 36) || (this.BPT == 46) || (this.BPT == 44) || (this.BPT == 48))
            {
              paramAnonymousString = com.tencent.mm.aw.o.ayF().a(paramAnonymousString, Bitmap.CompressFormat.JPEG);
              label747:
              if (!bt.isNullOrNil(paramAnonymousString))
              {
                paramAnonymousc.nZ(paramAnonymousString);
                az.arV();
                com.tencent.mm.model.c.apO().b(paramAnonymousc.field_msgSvrId, paramAnonymousc);
              }
              ad.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", new Object[] { Long.valueOf(paramLong), i, l, paramAnonymousString });
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 16L, paramb, false);
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(198L, 17L, 1L, false);
              paramAnonymousString = com.tencent.mm.plugin.report.service.h.vKh;
              if (!w.pF(i)) {
                break label896;
              }
            }
            for (l1 = 19L;; l1 = 18L)
            {
              paramAnonymousString.idkeyStat(198L, l1, 1L, false);
              break;
              paramAnonymousString = k.a(paramAnonymousString, this.BPU, paramAnonymousc.eLZ());
              break label747;
            }
            paramAnonymousInt = paramAnonymousd.field_retCode;
            break label210;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break label248;
            paramAnonymousc = paramAnonymousd.fns;
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
      com.tencent.mm.ao.f.awL().b(localg, -1);
      AppMethodBeat.o(31014);
      return true;
      i = 0;
      break;
      localg.field_fileId = paramString3;
      localg.field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
      break label163;
    }
  }
  
  public static String ky(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31008);
    if (bt.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(31008);
      return null;
    }
    String str = paramString2;
    if (w.pF(paramString1))
    {
      int i = bi.uc(paramString2);
      str = paramString2;
      if (i != -1) {
        str = (paramString2 + " ").substring(i + 2).trim();
      }
    }
    paramString1 = bt.aGg(str);
    AppMethodBeat.o(31008);
    return paramString1;
  }
  
  public final boolean a(final a parama, String paramString1, long paramLong, String paramString2, final String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(31015);
    String str = com.tencent.mm.aw.o.ayF().p("Note_".concat(String.valueOf(paramString1)), "", "");
    if (com.tencent.mm.vfs.i.eK(str))
    {
      AppMethodBeat.o(31015);
      return false;
    }
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.field_mediaId = com.tencent.mm.ao.c.a("downappthumb", paramLong, paramString4, String.valueOf(paramString1));
    localg.field_fullpath = str;
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
    localg.field_totalLen = paramInt;
    localg.field_aesKey = paramString2;
    localg.field_fileId = paramString3;
    localg.field_priority = com.tencent.mm.i.a.fmW;
    if (w.pF(paramString4)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localg.field_chattype = paramInt;
      ad.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString4 });
      localg.fnH = new g.a()
      {
        WeakReference<k.a> BPW;
        
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(31007);
          ad.i("MicroMsg.AppMessageExtension", "getThumbByCdn start callback: field_mediaId:%s thumbUrl:%s", new Object[] { paramAnonymousString, paramString3 });
          if (paramAnonymousInt != 0)
          {
            ad.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: startRet:%d thumbUrl:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramString3 });
            AppMethodBeat.o(31007);
            return paramAnonymousInt;
          }
          if (paramAnonymousd == null)
          {
            AppMethodBeat.o(31007);
            return 0;
          }
          if (paramAnonymousd.field_retCode != 0) {
            ad.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: sceneResult.field_retCode:%d thumbUrl:%s", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramString3 });
          }
          for (;;)
          {
            com.tencent.mm.aw.o.ayF().doNotify();
            paramAnonymousString = (k.a)this.BPW.get();
            if (paramAnonymousString != null) {
              paramAnonymousString.evL();
            }
            AppMethodBeat.o(31007);
            return 0;
            ad.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished thumbUrl:%s", new Object[] { paramString3 });
          }
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return null;
        }
      };
      com.tencent.mm.ao.f.awL().b(localg, -1);
      AppMethodBeat.o(31015);
      return true;
    }
  }
  
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(31009);
    ad.d("MicroMsg.AppMessageExtension", "process add app message");
    cs localcs = parama.fTo;
    Object localObject1 = z.a(localcs.Cxx);
    String str1 = z.a(localcs.Cxy);
    if ((bt.isNullOrNil((String)localObject1)) || (bt.isNullOrNil(str1))) {
      ad.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
    }
    k.b localb;
    for (str1 = null;; str1 = ky((String)localObject1, z.a(localcs.Cxz)))
    {
      localb = k.b.rx(str1);
      if (localb != null) {
        break;
      }
      ad.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
      AppMethodBeat.o(31009);
      return null;
    }
    if (localb.gIU)
    {
      az.arV();
      com.tencent.mm.model.c.afk().set(352273, str1);
      az.arV();
      com.tencent.mm.model.c.afk().set(352274, Long.valueOf(System.currentTimeMillis()));
      new b(str1).evB();
      AppMethodBeat.o(31009);
      return null;
    }
    Object localObject2 = ap.cZQ().aAS(localb.appId);
    Object localObject3 = localb.appId;
    int i = localb.aAS;
    if (localObject2 == null) {}
    f.b localb1;
    for (localObject1 = "null";; localObject1 = Integer.valueOf(((g)localObject2).field_appVersion))
    {
      ad.i("MicroMsg.AppMessageExtension", "check version appid:%s, msgVer:%d, appVer:%s", new Object[] { localObject3, Integer.valueOf(i), localObject1 });
      if ((localObject2 == null) || (((g)localObject2).field_appVersion < localb.aAS)) {
        ap.cZP().aAR(localb.appId);
      }
      localb1 = a(parama, z.a(localcs.Cxz), localb);
      if (localb1.dbD != null) {
        break;
      }
      AppMethodBeat.o(31009);
      return null;
    }
    bl localbl = localb1.dbD;
    if (localbl.eJL())
    {
      AppMethodBeat.o(31009);
      return localb1;
    }
    if (localbl.getType() == 301989937)
    {
      AppMethodBeat.o(31009);
      return localb1;
    }
    if (localbl.getType() == -1879048190)
    {
      localObject1 = new ws();
      ((ws)localObject1).dCg.dsv = str1;
      ((ws)localObject1).dCg.description = localb.description;
      ((ws)localObject1).dCg.dbD = localbl;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    if ((localbl.getType() == 49) && (!bt.isNullOrNil(localb.canvasPageXml)))
    {
      localObject1 = new com.tencent.mm.g.a.f();
      ((com.tencent.mm.g.a.f)localObject1).daS.daT = localb.canvasPageXml;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    if (localbl.cjN())
    {
      localObject3 = (String)com.tencent.mm.kernel.g.afB().afk().get(2, "");
      localObject1 = z.a(localcs.Cxy);
      localObject2 = z.a(localcs.Cxx);
      if ((!((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU().has((String)localObject2)) && (!((String)localObject3).equals(localObject2))) {
        break label1060;
      }
      i = 1;
      localObject3 = new com.tencent.mm.modelvideo.s();
      if (i == 0) {
        break label1065;
      }
      label568:
      ((com.tencent.mm.modelvideo.s)localObject3).dtV = ((String)localObject1);
      ((com.tencent.mm.modelvideo.s)localObject3).hAb = ((String)localObject2);
      ((com.tencent.mm.modelvideo.s)localObject3).createTime = localcs.CreateTime;
      ((com.tencent.mm.modelvideo.s)localObject3).drA = localcs.uKZ;
      ((com.tencent.mm.modelvideo.s)localObject3).hAn = localcs.Cxz.Ehn;
      ((com.tencent.mm.modelvideo.s)localObject3).hAi = ((int)localbl.field_msgId);
      if (!localbl.eLP()) {
        break label1072;
      }
    }
    String str2;
    for (localObject1 = new com.tencent.mm.ai.y().a(localbl.FzO);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ((com.tencent.mm.modelvideo.s)localObject3).fileName = localbl.field_imgPath;
        ((com.tencent.mm.modelvideo.s)localObject3).a(((com.tencent.mm.ai.y)localObject1).videoUrl, ((com.tencent.mm.ai.y)localObject1).videoDuration, ((com.tencent.mm.ai.y)localObject1).title, ((com.tencent.mm.ai.y)localObject1).CEf, "", "", "");
        ((com.tencent.mm.modelvideo.s)localObject3).status = 111;
      }
      com.tencent.mm.modelvideo.o.aCI().b((com.tencent.mm.modelvideo.s)localObject3);
      if (localb.type != 53) {
        break label1371;
      }
      ad.i("MicroMsg.AppMessageExtension", "process MM_APP_SOLITAIRE_TEXT");
      localObject3 = localcs.CxD;
      str2 = localb.title;
      if (!bt.isNullOrNil((String)localObject3)) {
        break label1142;
      }
      localObject1 = "";
      label762:
      localcs.CxD = ((String)localObject1);
      localObject1 = bi.uf(localbl.field_content);
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break label1603;
      }
      label792:
      if (!parama.gVg) {
        break label1314;
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).b(z.a(localcs.Cxx), (String)localObject1, localb.title, (String)localb.gJO.second, localbl.field_msgId, localbl.field_createTime / 1000L);
      label853:
      if ((w.sm(localbl.field_talker)) && (com.tencent.mm.chatroom.d.y.UQ())) {
        ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupTodoByReceiverAppMsg(localbl);
      }
      if ((w.sm(localbl.field_talker)) && (aa.UU())) {
        ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(localbl);
      }
      parama = new com.tencent.mm.ai.k();
      localb.a(parama);
      parama.field_msgId = localbl.field_msgId;
      if ((ap.evR().vk(localbl.field_msgId) != null) || (!ap.evR().insert(parama))) {
        break label1595;
      }
      if (localb.type == 40)
      {
        parama = ap.bxS().vj(localbl.field_msgId);
        localObject1 = com.tencent.mm.ai.t.rC(str1);
        if (parama == null) {
          m.a(null, localbl.field_msgId, 0, null, null, ((com.tencent.mm.ai.t)localObject1).gKz, localb.type, 0);
        }
        parama = new com.tencent.mm.plugin.record.b.e(localbl.field_msgId, localbl.field_msgSvrId, null);
        az.aeS().a(parama, 0);
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
      localObject1 = k.b.ar(localbl.field_content, localbl.field_reserved);
      if (localObject1 != null) {
        break label1106;
      }
      ad.w("MicroMsg.AppMessageExtension", "getVideoInfo content is null");
    }
    label1106:
    localObject1 = (com.tencent.mm.ai.e)((k.b)localObject1).ao(com.tencent.mm.ai.e.class);
    if ((localObject1 != null) && (((com.tencent.mm.ai.e)localObject1).gGE != null)) {}
    for (localObject1 = ((com.tencent.mm.ai.e)localObject1).gGE;; localObject1 = null)
    {
      break;
      label1142:
      localObject2 = bt.aGg((String)localObject3);
      if (bt.isNullOrNil((String)localObject2))
      {
        localObject1 = "";
        break label762;
      }
      i = ((String)localObject2).indexOf("<pushcontent");
      StringBuilder localStringBuilder = new StringBuilder();
      if (i > 0)
      {
        localObject1 = ((String)localObject2).substring(i);
        localStringBuilder = localStringBuilder.append(((String)localObject2).substring(0, i));
        localObject2 = localObject1;
      }
      for (localObject1 = localStringBuilder;; localObject1 = localStringBuilder)
      {
        localObject2 = bw.K((String)localObject2, "pushcontent");
        if (localObject2 == null)
        {
          ad.e("MicroMsg.AppMessageExtension", "inval xml");
          localObject1 = localObject3;
          break;
        }
        localObject2 = (String)((Map)localObject2).get(".pushcontent.$nickname");
        ((StringBuilder)localObject1).append("<pushcontent content=\"").append((String)localObject2).append(" : ").append(str2).append("\"nickname=\"").append((String)localObject2).append("\" />\n");
        localObject1 = ((StringBuilder)localObject1).toString();
        break;
        label1314:
        ((com.tencent.mm.plugin.messenger.foundation.a.i)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.i.class)).a(z.a(localcs.Cxx), (String)localObject1, localb.title, (String)localb.gJO.second, localbl.field_msgId, localbl.field_createTime / 1000L);
        break label853;
        label1371:
        if (localb.type == 57)
        {
          ad.i("MicroMsg.AppMessageExtension", "process MM_APP_MSG_QUOTE");
          ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).handleReceivedQuoteMsg(localbl.field_msgId, localbl.field_msgSvrId, localbl.field_talker, localb.gJP.tNr);
          break label853;
        }
        if (localb.type != 60) {
          break label853;
        }
        parama = (String)com.tencent.mm.kernel.g.afB().afk().get(2, "");
        localObject1 = z.a(localcs.Cxx);
        boolean bool;
        if ((((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU().has((String)localObject1)) || (parama.equals(localObject1)))
        {
          bool = true;
          label1501:
          if (!bool) {
            break label1586;
          }
        }
        for (;;)
        {
          ad.i("MicroMsg.AppMessageExtension", "process MM_APP_MMLIVE_SHARE, isSender%b, anchor:%s", new Object[] { Boolean.valueOf(bool), parama });
          if (bool) {
            break;
          }
          localObject2 = (com.tencent.mm.live.b.k)localb.ao(com.tencent.mm.live.b.k.class);
          as.a((String)localObject1, Long.parseLong(((com.tencent.mm.live.b.k)localObject2).zaR), ((com.tencent.mm.live.b.k)localObject2).qud, ((com.tencent.mm.live.b.k)localObject2).thumbUrl, parama, Boolean.FALSE, localcs.CreateTime);
          break;
          bool = false;
          break label1501;
          label1586:
          parama = localb.dpv;
        }
        label1595:
        AppMethodBeat.o(31009);
        return null;
        label1603:
        localObject1 = "";
        break label792;
      }
    }
  }
  
  public final void b(f.c paramc)
  {
    String str = null;
    AppMethodBeat.i(31013);
    Object localObject = paramc.drF;
    if (localObject == null)
    {
      ad.e("MicroMsg.AppMessageExtension", "[onPreDelMessage] msg == null");
      AppMethodBeat.o(31013);
      return;
    }
    ad.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + ((du)localObject).field_imgPath);
    paramc = new wr();
    paramc.dCf.path = ((du)localObject).field_imgPath;
    com.tencent.mm.sdk.b.a.ESL.l(paramc);
    paramc = ((du)localObject).field_content;
    if (paramc != null)
    {
      k.b localb = k.b.rx(paramc);
      if ((localb != null) && (localb.type == 6))
      {
        paramc = com.tencent.mm.loader.j.b.aij() + localb.title;
        com.tencent.mm.vfs.i.deleteFile(paramc);
        com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.loader.j.b.aij() + localb.title + "_tmp");
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.s.a.bxS().vj(((du)localObject).field_msgId);
      if (localObject != null)
      {
        str = ((c)localObject).field_fileFullPath;
        com.tencent.mm.vfs.i.deleteFile(str);
        com.tencent.mm.plugin.s.a.bxS().delete((com.tencent.mm.sdk.e.c)localObject, new String[] { "msgInfoId" });
      }
      ad.w("MicroMsg.AppMessageExtension", "onPreDelMessage, clean file, %s, %s", new Object[] { paramc, str });
      AppMethodBeat.o(31013);
      return;
      paramc = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void evL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.k
 * JD-Core Version:    0.7.0.1
 */