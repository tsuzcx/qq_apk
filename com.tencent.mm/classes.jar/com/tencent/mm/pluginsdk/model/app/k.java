package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.k.b.a;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.at.a;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.pw.a;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.a.xw;
import com.tencent.mm.g.a.xx;
import com.tencent.mm.g.a.yy;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.b;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.bnv;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class k
  implements com.tencent.mm.al.e
{
  private static void K(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(31012);
    com.tencent.mm.storage.at localat;
    if (!bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.AppMessageExtension", "updateC2CAAMsgMark, mark: %s, talker: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
      ba.aBQ();
      localat = com.tencent.mm.model.c.azv().aTz(paramString);
      if (localat != null)
      {
        if (!paramBoolean) {
          break label85;
        }
        localat.lO(16777216);
      }
    }
    for (;;)
    {
      ba.aBQ();
      com.tencent.mm.model.c.azv().a(localat, paramString);
      AppMethodBeat.o(31012);
      return;
      label85:
      localat.lP(16777216);
    }
  }
  
  private e.b a(e.a parama, String paramString, k.b paramb)
  {
    AppMethodBeat.i(31011);
    localcv = parama.gqE;
    ba.aBQ();
    locali = com.tencent.mm.model.c.azs();
    ba.aBQ();
    Object localObject1 = com.tencent.mm.model.c.azy();
    localObject2 = u.aAm();
    String str1 = z.a(localcv.Fvi);
    String str2 = z.a(localcv.Fvj);
    int j;
    bj.b localb;
    label117:
    int i;
    label358:
    boolean bool;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.a.l)localObject1).has(str1)) || (((String)localObject2).equals(str1)))
    {
      j = 1;
      localb = bj.Bq(localcv.Fvn);
      localObject1 = null;
      if (localb != null) {
        localObject1 = localb.hGM;
      }
      if (!w.Aj((String)localObject1)) {
        break label1790;
      }
      localObject1 = "notifymessage";
      localObject3 = locali.aI((String)localObject1, localcv.xbt);
      ad.i("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", new Object[] { Long.valueOf(localcv.xbt), Long.valueOf(((ei)localObject3).field_msgId) });
      if ((((ei)localObject3).field_msgId != 0L) && (((ei)localObject3).field_createTime + 604800000L < bj.B((String)localObject1, localcv.CreateTime)))
      {
        ad.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localcv.xbt), Long.valueOf(((ei)localObject3).field_msgId) });
        bj.rJ(((ei)localObject3).field_msgId);
        ((bu)localObject3).setMsgId(0L);
      }
      localObject2 = localObject3;
      if (((ei)localObject3).field_msgId == 0L)
      {
        localObject2 = new bu();
        ((bu)localObject2).qz(localcv.xbt);
        ((bu)localObject2).qA(bj.B((String)localObject1, localcv.CreateTime));
      }
      if (paramb.hzL != null)
      {
        ((bu)localObject2).tX(paramb.hzL.fkz);
        ad.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", new Object[] { ((ei)localObject2).fkz });
      }
      ((bu)localObject2).setType(m.g(paramb));
      if (!((bu)localObject2).fpd()) {
        break label1809;
      }
      localObject3 = paramb.content;
      ((bu)localObject2).setContent((String)localObject3);
      if (((bu)localObject2).fpd()) {
        ((bu)localObject2).tV(paramb.fkq);
      }
      if ((localcv.Fvl != 2) || (((ei)localObject2).field_msgId != 0L)) {
        break label2112;
      }
      switch (((bu)localObject2).getType())
      {
      default: 
        i = 0;
        label435:
        if (i == 0) {
          if (paramb.type == 2)
          {
            bool = true;
            label451:
            localObject3 = z.a(localcv.Fvm);
            if (ac.iOT)
            {
              ad.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
              localObject3 = null;
            }
            if (bt.cC((byte[])localObject3)) {
              break label1844;
            }
            if ((paramb.type != 33) && (paramb.type != 36) && (paramb.type != 46) && (paramb.type != 44) && (paramb.type != 48)) {
              break label1827;
            }
            localObject3 = com.tencent.mm.aw.q.aIF().a((byte[])localObject3, Bitmap.CompressFormat.PNG);
            if (bt.isNullOrNil((String)localObject3)) {
              ad.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", new Object[] { ((ei)localObject2).field_content });
            }
            if (!bt.isNullOrNil((String)localObject3))
            {
              ((bu)localObject2).tO((String)localObject3);
              ad.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path".concat(String.valueOf(localObject3)));
            }
            label603:
            if (j == 0) {
              break label2384;
            }
            ((bu)localObject2).kr(1);
            ((bu)localObject2).tN((String)localObject1);
            i = localcv.nDG;
            label628:
            ((bu)localObject2).setStatus(i);
            if (paramb.type == 2001) {
              if (paramb.dlp == 1)
              {
                if ((TextUtils.isEmpty(paramb.hBA)) || (TextUtils.isEmpty(paramb.hBB)) || (paramb.hBC <= 0)) {
                  break label2422;
                }
                ad.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
                localObject1 = new com.tencent.mm.g.a.at();
                ((com.tencent.mm.g.a.at)localObject1).dlB = new at.a();
                ((com.tencent.mm.g.a.at)localObject1).dlB.dlD = paramb.hBB;
                ((com.tencent.mm.g.a.at)localObject1).dlB.dlC = paramb.hBA;
                ((com.tencent.mm.g.a.at)localObject1).dlB.dlE = paramb.hBC;
                com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
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
        if (bt.hj(paramb.hBM)) {
          continue;
        }
        localObject1 = paramb.hBM.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = ((String)((Iterator)localObject1).next()).split(",");
          if ((localObject3 == null) || (localObject3.length <= 0)) {
            continue;
          }
          localObject3 = localObject3[0];
          if ((bt.isNullOrNil((String)localObject3)) || (!((String)localObject3).equals(u.aAm()))) {
            continue;
          }
          ((bu)localObject2).setFlag(((ei)localObject2).field_flag | 0x8);
          ad.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
          K(true, ((ei)localObject2).field_talker);
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
        ((bnv)localObject3).GIp = localException.hza;
        ((bnv)localObject3).GIr = localException.hzb;
        continue;
        locali.b(localcv.xbt, (bu)localObject2);
        parama = new e.b((bu)localObject2, false);
        continue;
        localException.dnc.dnk = true;
        continue;
      }
      ad.i("MicroMsg.AppMessageExtension", "paymsgid: %s", new Object[] { paramb.hBz });
      ((bu)localObject2).sP(localcv.Fvn);
      if (localb != null)
      {
        ((bu)localObject2).tW(localb.hGQ);
        ((bu)localObject2).kH(localb.hGR);
        ((bu)localObject2).tR(localb.hGP);
      }
      if (((bu)localObject2).cxg()) {
        ((bu)localObject2).tO(com.tencent.mm.modelvideo.t.Hg(str2));
      }
      bj.a((bu)localObject2, parama);
      if (((ei)localObject2).field_msgId != 0L) {
        continue;
      }
      ((bu)localObject2).setMsgId(bj.v((bu)localObject2));
      parama = new com.tencent.mm.g.a.t();
      parama.dkt.dku = ((bu)localObject2);
      parama.dkt.dkv = paramb;
      com.tencent.mm.sdk.b.a.IbL.l(parama);
      parama = new e.b((bu)localObject2, true);
      if ((((bu)localObject2).getType() == 301989937) && (w.Ah(((ei)localObject2).field_talker))) {
        ((bu)localObject2).setMsgId(0L);
      }
      if ((((bu)localObject2).frC()) && ("notifymessage".equals(((ei)localObject2).field_talker)))
      {
        localObject1 = bw.M(((ei)localObject2).field_content, "msg");
        if (localObject1 != null)
        {
          localObject1 = bt.nullAsNil((String)((Map)localObject1).get(".msg.fromusername"));
          if (am.yt((String)localObject1))
          {
            ((n)com.tencent.mm.kernel.g.ab(n.class)).b((String)localObject1, null);
            ad.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", new Object[] { localObject1 });
          }
        }
      }
      if (((bu)localObject2).getType() == 536870961)
      {
        localObject1 = (com.tencent.mm.ai.b)paramb.ao(com.tencent.mm.ai.b.class);
        localObject3 = new pw();
        ((pw)localObject3).dEo.dEl = ((ei)localObject2).field_msgId;
        ((pw)localObject3).dEo.dEp = ((com.tencent.mm.ai.b)localObject1).dEn;
        ((pw)localObject3).dEo.dDP = paramString;
        if (((ei)localObject2).field_isSend == 1)
        {
          ad.d("MicroMsg.AppMessageExtension", "fromuser: %s, touser: %s", new Object[] { str1, str2 });
          ((pw)localObject3).dEo.username = ((ei)localObject2).field_talker;
        }
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
        if (((pw)localObject3).dEo.dDP != null)
        {
          ((bu)localObject2).setContent(((pw)localObject3).dEo.dDP);
          locali.a(((ei)localObject2).field_msgId, (bu)localObject2);
        }
      }
      if ((!bt.isNullOrNil(paramb.hBF)) && (((bu)localObject2).getType() == 436207665))
      {
        localObject1 = new pu();
        ((pu)localObject1).dEk.dEl = ((ei)localObject2).field_msgId;
        ((pu)localObject1).dEk.dDP = paramString;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      if ((paramb.type == 2000) && (!bt.isNullOrNil(paramb.hAX)))
      {
        paramString = new pz();
        paramString.dEt.dxv = paramb.hAX;
        paramString.dEt.msgId = ((ei)localObject2).field_msgId;
        paramString.dEt.dEu = paramb;
        com.tencent.mm.sdk.b.a.IbL.l(paramString);
        K(false, ((ei)localObject2).field_talker);
      }
      paramString = paramb.hCE;
      paramb = bt.bI((String)paramString.get(".msg.appmsg.ext_pay_info.pay_type"), "");
      if (((paramb.equals("wx_f2f")) || (paramb.equals("wx_md"))) && (parama.hOa))
      {
        l1 = ((ei)localObject2).field_createTime;
        l2 = cf.aCL();
        ad.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", new Object[] { paramb, Long.valueOf(l1), Long.valueOf(l2) });
        localObject1 = new cg();
        i = bt.getInt((String)paramString.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
        localObject2 = bt.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.pay_feetype"));
        localObject3 = bt.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
        str1 = bt.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.voice_content"));
        str2 = bt.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.expire_voice_timestamp"));
        j = bt.getInt((String)paramString.get(".msg.appmsg.ext_pay_info.need_failover"), 1);
        if ((i > 0) && (!bt.isNullOrNil((String)localObject2)) && (!bt.isNullOrNil((String)localObject3)))
        {
          ((cg)localObject1).dnc.dnd = i;
          ((cg)localObject1).dnc.dne = ((String)localObject2);
          ((cg)localObject1).dnc.dnf = ((String)localObject3);
          ((cg)localObject1).dnc.dng = paramb;
          ((cg)localObject1).dnc.gW = (l2 - l1);
          ((cg)localObject1).dnc.dnh = 0;
          ((cg)localObject1).dnc.dni = str1;
          ((cg)localObject1).dnc.dnj = str2;
          if (j != 0) {
            continue;
          }
          ((cg)localObject1).dnc.dnk = false;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
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
      localObject3 = a((byte[])localObject3, bool, ((bu)localObject2).frH());
      break label544;
      if ((!bt.isNullOrNil(paramb.hAe)) && (!bt.isNullOrNil(paramb.hAi)))
      {
        a(((ei)localObject2).field_msgSvrId, (bu)localObject2, (String)localObject1, paramb.hAi, paramb.hAe, paramb.hAf, bool, paramb, "", false);
        break label603;
      }
      if (!bt.isNullOrNil(paramb.thumburl))
      {
        ad.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
        localObject4 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
        localObject3 = com.tencent.mm.aw.q.aIF().getFullPath((String)localObject4);
        com.tencent.mm.aw.q.aIF();
        localObject4 = com.tencent.mm.aw.i.wb((String)localObject4);
        localObject5 = com.tencent.mm.aw.q.aIJ();
        str3 = paramb.thumburl;
        locala = new c.a();
        locala.hdP = ((String)localObject3);
        locala.idr = true;
        ((com.tencent.mm.aw.a.a)localObject5).a(str3, null, locala.aJc());
        ((bu)localObject2).tO((String)localObject4);
        ad.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(localObject3)));
        break label603;
      }
      if (bt.isNullOrNil(paramb.hzV)) {
        break label603;
      }
      a(((ei)localObject2).field_msgSvrId, (bu)localObject2, (String)localObject1, paramb.hAb, paramb.hzV, paramb.hzW, bool, paramb, paramb.hAa, true);
      ad.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.hzV);
      break label603;
      if (!bt.isNullOrNil(paramb.thumburl))
      {
        ad.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
        localObject3 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
        if (paramb.type == 2001) {
          localObject3 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
        }
        if (((bu)localObject2).fpd()) {
          break label603;
        }
        localObject4 = com.tencent.mm.aw.q.aIF().getFullPath((String)localObject3);
        com.tencent.mm.aw.q.aIF();
        localObject3 = com.tencent.mm.aw.i.wb((String)localObject3);
        localObject5 = com.tencent.mm.aw.q.aIJ();
        str3 = paramb.thumburl;
        locala = new c.a();
        locala.hdP = ((String)localObject4);
        locala.idr = true;
        ((com.tencent.mm.aw.a.a)localObject5).a(str3, null, locala.aJc());
        ((bu)localObject2).tO((String)localObject3);
        ad.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(localObject4)));
        break label603;
      }
      if (bt.isNullOrNil(paramb.hzV)) {
        break label603;
      }
      if (paramb.type == 2)
      {
        bool = true;
        a(((ei)localObject2).field_msgSvrId, (bu)localObject2, (String)localObject1, paramb.hAb, paramb.hzV, paramb.hzW, bool, paramb, paramb.hAa, true);
        ad.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.hzV);
        break label603;
      }
      bool = false;
      continue;
      ((bu)localObject2).kr(0);
      ((bu)localObject2).tN((String)localObject1);
      if (localcv.nDG > 3)
      {
        i = localcv.nDG;
        break label628;
      }
      i = 3;
      break label628;
      ad.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
      continue;
      if (!"1001".equals(paramb.hBw))
      {
        localObject1 = new yy();
        ((yy)localObject1).dNU.dDP = paramString;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
        K(false, ((ei)localObject2).field_talker);
        if ("1002".equals(paramb.hBw))
        {
          localObject1 = (com.tencent.mm.ai.c)paramb.ao(com.tencent.mm.ai.c.class);
          localObject3 = new bnv();
          ((bnv)localObject3).GIq = ((com.tencent.mm.ai.c)localObject1).hze;
          ((bnv)localObject3).GIt = ((com.tencent.mm.ai.c)localObject1).hzf;
          ((bnv)localObject3).hkP = ((com.tencent.mm.ai.c)localObject1).hzc;
          ((bnv)localObject3).GIs = ((com.tencent.mm.ai.c)localObject1).hzd;
          if (j == 0) {
            continue;
          }
          ((bnv)localObject3).GIp = ((com.tencent.mm.ai.c)localObject1).hyY;
          ((bnv)localObject3).GIr = ((com.tencent.mm.ai.c)localObject1).hyZ;
          localObject4 = (com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class);
          localObject5 = new bnu();
          ((bnu)localObject5).GHZ = ((bnv)localObject3);
          ((com.tencent.mm.plugin.luckymoney.a.a)localObject4).a((bnu)localObject5);
          ((com.tencent.mm.plugin.luckymoney.a.a)localObject4).a(((com.tencent.mm.ai.c)localObject1).hzg);
        }
      }
    }
  }
  
  static String a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31010);
    paramArrayOfByte = com.tencent.mm.aw.q.aIF().a(paramArrayOfByte, paramBoolean1, Bitmap.CompressFormat.PNG, paramBoolean2);
    AppMethodBeat.o(31010);
    return paramArrayOfByte;
  }
  
  private boolean a(final long paramLong, bu parambu, String paramString1, String paramString2, String paramString3, final int paramInt, final boolean paramBoolean1, final k.b paramb, String paramString4, boolean paramBoolean2)
  {
    AppMethodBeat.i(31014);
    ad.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", new Object[] { Long.valueOf(parambu.field_msgSvrId), paramString2, Integer.valueOf(paramInt), paramString3, paramString1, Boolean.valueOf(paramBoolean1) });
    final long l = bt.flT();
    final int i;
    com.tencent.mm.i.g localg;
    if (paramb != null)
    {
      i = paramb.type;
      paramb = com.tencent.mm.aw.q.aIF().o(bt.flT(), "", "");
      localg = new com.tencent.mm.i.g();
      localg.fJi = "task_AppMessageExtension_1";
      localg.field_mediaId = com.tencent.mm.ao.c.a("downappthumb", parambu.field_createTime, paramString1, String.valueOf(paramLong));
      localg.field_fullpath = paramb;
      if (!paramBoolean2) {
        break label298;
      }
      localg.field_fileType = 19;
      localg.fJm = paramString3;
      label171:
      localg.field_totalLen = paramInt;
      localg.field_aesKey = paramString2;
      localg.field_priority = com.tencent.mm.i.a.fIx;
      localg.field_authKey = paramString4;
      if (!w.vF(paramString1)) {
        break label316;
      }
    }
    label298:
    label316:
    for (int j = 1;; j = 0)
    {
      localg.field_chattype = j;
      ad.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString1 });
      localg.fJj = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(31005);
          if (paramAnonymousInt != 0)
          {
            ad.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousInt), l });
            new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(paramInt), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramb), "" })).aLk();
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
            l2 = bt.flT();
            i = com.tencent.mm.ao.c.cA(aj.getContext());
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
            new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aLk();
            if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode != 0))
            {
              if (paramAnonymousd != null) {
                break label931;
              }
              paramAnonymousInt = -1;
              label402:
              l1 = paramInt;
              l2 = bt.flT();
              i = com.tencent.mm.ao.c.cA(aj.getContext());
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
          for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.fIT)
          {
            new h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aLk();
            com.tencent.mm.aw.q.aIF().doNotify();
            AppMethodBeat.o(31005);
            return 0;
            ba.aBQ();
            paramAnonymousc = com.tencent.mm.model.c.azs().aI(i, paramLong);
            if (paramAnonymousc.field_msgSvrId != paramLong)
            {
              ad.e("MicroMsg.AppMessageExtension", "hy: appmsg %d has been deleted", new Object[] { Long.valueOf(paramLong) });
              AppMethodBeat.o(31005);
              return 0;
            }
            ad.i("MicroMsg.AppMessageExtension", "hy: %d current msg type is %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousc.getType()) });
            paramAnonymousString = com.tencent.mm.vfs.i.aY(paramBoolean1, 0, -1);
            if ((this.EMS == 33) || (this.EMS == 36) || (this.EMS == 46) || (this.EMS == 44) || (this.EMS == 48))
            {
              paramAnonymousString = com.tencent.mm.aw.q.aIF().a(paramAnonymousString, Bitmap.CompressFormat.JPEG);
              label747:
              if (!bt.isNullOrNil(paramAnonymousString))
              {
                paramAnonymousc.tO(paramAnonymousString);
                ba.aBQ();
                com.tencent.mm.model.c.azs().b(paramAnonymousc.field_msgSvrId, paramAnonymousc);
              }
              ad.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", new Object[] { Long.valueOf(paramLong), i, l, paramAnonymousString });
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 16L, paramb, false);
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(198L, 17L, 1L, false);
              paramAnonymousString = com.tencent.mm.plugin.report.service.g.yhR;
              if (!w.vF(i)) {
                break label896;
              }
            }
            for (l1 = 19L;; l1 = 18L)
            {
              paramAnonymousString.idkeyStat(198L, l1, 1L, false);
              break;
              paramAnonymousString = k.a(paramAnonymousString, this.EMT, paramAnonymousc.frH());
              break label747;
            }
            paramAnonymousInt = paramAnonymousd.field_retCode;
            break label210;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break label248;
            paramAnonymousc = paramAnonymousd.fIT;
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
      com.tencent.mm.ao.f.aGI().b(localg, -1);
      AppMethodBeat.o(31014);
      return true;
      i = 0;
      break;
      localg.field_fileId = paramString3;
      localg.field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
      break label171;
    }
  }
  
  public static String ls(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31008);
    if (bt.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(31008);
      return null;
    }
    String str = paramString2;
    if (w.vF(paramString1))
    {
      int i = bj.Bh(paramString2);
      str = paramString2;
      if (i != -1) {
        str = (paramString2 + " ").substring(i + 2).trim();
      }
    }
    paramString1 = bt.aRd(str);
    AppMethodBeat.o(31008);
    return paramString1;
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(31009);
    ad.d("MicroMsg.AppMessageExtension", "process add app message");
    Object localObject5 = parama.gqE;
    Object localObject1 = z.a(((cv)localObject5).Fvi);
    String str = z.a(((cv)localObject5).Fvj);
    if ((bt.isNullOrNil((String)localObject1)) || (bt.isNullOrNil(str))) {
      ad.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
    }
    k.b localb;
    for (str = null;; str = ls((String)localObject1, z.a(((cv)localObject5).Fvk)))
    {
      localb = k.b.yr(str);
      if (localb != null) {
        break;
      }
      ad.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
      AppMethodBeat.o(31009);
      return null;
    }
    if (localb.hBD)
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(352273, str);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(352274, Long.valueOf(System.currentTimeMillis()));
      new b(str).eZP();
      AppMethodBeat.o(31009);
      return null;
    }
    Object localObject2 = ao.dxQ().aLK(localb.appId);
    Object localObject3 = localb.appId;
    int i = localb.aDD;
    if (localObject2 == null) {}
    e.b localb1;
    for (localObject1 = "null";; localObject1 = Integer.valueOf(((g)localObject2).field_appVersion))
    {
      ad.i("MicroMsg.AppMessageExtension", "check version appid:%s, msgVer:%d, appVer:%s", new Object[] { localObject3, Integer.valueOf(i), localObject1 });
      if ((localObject2 == null) || (((g)localObject2).field_appVersion < localb.aDD)) {
        ao.dxP().aLJ(localb.appId);
      }
      localb1 = a(parama, z.a(((cv)localObject5).Fvk), localb);
      if (localb1.dku != null) {
        break;
      }
      AppMethodBeat.o(31009);
      return null;
    }
    bu localbu = localb1.dku;
    if (localbu.fpd())
    {
      AppMethodBeat.o(31009);
      return localb1;
    }
    if (localbu.getType() == 301989937)
    {
      AppMethodBeat.o(31009);
      return localb1;
    }
    if (localbu.getType() == -1879048190)
    {
      localObject1 = new xx();
      ((xx)localObject1).dMh.dBS = str;
      ((xx)localObject1).dMh.description = localb.description;
      ((xx)localObject1).dMh.dku = localbu;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    if ((localbu.getType() == 49) && (!bt.isNullOrNil(localb.canvasPageXml)))
    {
      localObject1 = new com.tencent.mm.g.a.f();
      ((com.tencent.mm.g.a.f)localObject1).djG.djH = localb.canvasPageXml;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    if (localbu.cxg())
    {
      localObject3 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(2, "");
      localObject1 = z.a(((cv)localObject5).Fvj);
      localObject2 = z.a(((cv)localObject5).Fvi);
      if ((!((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azy().has((String)localObject2)) && (!((String)localObject3).equals(localObject2))) {
        break label1060;
      }
      i = 1;
      localObject3 = new s();
      if (i == 0) {
        break label1065;
      }
      label568:
      ((s)localObject3).dDy = ((String)localObject1);
      ((s)localObject3).itY = ((String)localObject2);
      ((s)localObject3).createTime = ((cv)localObject5).CreateTime;
      ((s)localObject3).dAY = ((cv)localObject5).xbt;
      ((s)localObject3).iuk = ((cv)localObject5).Fvk.HoB;
      ((s)localObject3).iuf = ((int)localbu.field_msgId);
      if (!localbu.frw()) {
        break label1072;
      }
    }
    Object localObject6;
    for (localObject1 = new com.tencent.mm.ai.y().a(localbu.IMf);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ((s)localObject3).fileName = localbu.field_imgPath;
        ((s)localObject3).a(((com.tencent.mm.ai.y)localObject1).videoUrl, ((com.tencent.mm.ai.y)localObject1).videoDuration, ((com.tencent.mm.ai.y)localObject1).title, ((com.tencent.mm.ai.y)localObject1).FCb, "", "", "");
        ((s)localObject3).status = 111;
      }
      o.aMJ().b((s)localObject3);
      if (localb.type != 53) {
        break label1371;
      }
      ad.i("MicroMsg.AppMessageExtension", "process MM_APP_SOLITAIRE_TEXT");
      localObject3 = ((cv)localObject5).Fvo;
      localObject6 = localb.title;
      if (!bt.isNullOrNil((String)localObject3)) {
        break label1142;
      }
      localObject1 = "";
      label762:
      ((cv)localObject5).Fvo = ((String)localObject1);
      localObject1 = bj.Bk(localbu.field_content);
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break label1717;
      }
      label792:
      if (!parama.hNU) {
        break label1314;
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).b(z.a(((cv)localObject5).Fvi), (String)localObject1, localb.title, (String)localb.hCx.second, localbu.field_msgId, localbu.field_createTime / 1000L);
      label853:
      if ((w.zk(localbu.field_talker)) && (com.tencent.mm.chatroom.d.y.Yd())) {
        ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupTodoByReceiverAppMsg(localbu);
      }
      if ((w.zk(localbu.field_talker)) && (aa.Yh())) {
        ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(localbu);
      }
      parama = new com.tencent.mm.ai.k();
      localb.a(parama);
      parama.field_msgId = localbu.field_msgId;
      if ((ao.fag().xH(localbu.field_msgId) != null) || (!ao.fag().insert(parama))) {
        break label1709;
      }
      if (localb.type == 40)
      {
        parama = ao.bIX().CB(localbu.field_msgId);
        localObject1 = com.tencent.mm.ai.t.yw(str);
        if (parama == null) {
          m.a(null, localbu.field_msgId, 0, null, null, ((com.tencent.mm.ai.t)localObject1).hDi, localb.type, 0);
        }
        parama = new com.tencent.mm.plugin.record.b.f(localbu.field_msgId, localbu.field_msgSvrId, null);
        ba.aiU().a(parama, 0);
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
      localObject1 = k.b.aA(localbu.field_content, localbu.field_reserved);
      if (localObject1 != null) {
        break label1106;
      }
      ad.w("MicroMsg.AppMessageExtension", "getVideoInfo content is null");
    }
    label1106:
    localObject1 = (com.tencent.mm.ai.e)((k.b)localObject1).ao(com.tencent.mm.ai.e.class);
    if ((localObject1 != null) && (((com.tencent.mm.ai.e)localObject1).hzo != null)) {}
    for (localObject1 = ((com.tencent.mm.ai.e)localObject1).hzo;; localObject1 = null)
    {
      break;
      label1142:
      localObject2 = bt.aRd((String)localObject3);
      if (bt.isNullOrNil((String)localObject2))
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
        localObject2 = bw.M((String)localObject2, "pushcontent");
        if (localObject2 == null)
        {
          ad.e("MicroMsg.AppMessageExtension", "inval xml");
          localObject1 = localObject3;
          break;
        }
        localObject2 = (String)((Map)localObject2).get(".pushcontent.$nickname");
        ((StringBuilder)localObject1).append("<pushcontent content=\"").append((String)localObject2).append(" : ").append((String)localObject6).append("\"nickname=\"").append((String)localObject2).append("\" />\n");
        localObject1 = ((StringBuilder)localObject1).toString();
        break;
        label1314:
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).a(z.a(((cv)localObject5).Fvi), (String)localObject1, localb.title, (String)localb.hCx.second, localbu.field_msgId, localbu.field_createTime / 1000L);
        break label853;
        label1371:
        if (localb.type == 57)
        {
          ad.i("MicroMsg.AppMessageExtension", "process MM_APP_MSG_QUOTE");
          ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).handleReceivedQuoteMsg(localbu.field_msgId, localbu.field_msgSvrId, localbu.field_talker, localb.hCy.vZc);
          break label853;
        }
        if (localb.type != 60) {
          break label853;
        }
        parama = (String)com.tencent.mm.kernel.g.ajC().ajl().get(2, "");
        localObject1 = z.a(((cv)localObject5).Fvi);
        boolean bool;
        if ((((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azy().has((String)localObject1)) || (parama.equals(localObject1)))
        {
          bool = true;
          label1501:
          if (!bool) {
            break label1700;
          }
        }
        for (;;)
        {
          ad.i("MicroMsg.AppMessageExtension", "process MM_APP_MMLIVE_SHARE, isSender%b, anchor:%s", new Object[] { Boolean.valueOf(bool), parama });
          if (bool) {
            break;
          }
          localObject3 = (com.tencent.mm.live.b.l)localb.ao(com.tencent.mm.live.b.l.class);
          long l1 = Long.parseLong(((com.tencent.mm.live.b.l)localObject3).gPn);
          localObject2 = ((com.tencent.mm.live.b.l)localObject3).gGA;
          localObject3 = ((com.tencent.mm.live.b.l)localObject3).thumbUrl;
          localObject4 = ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage();
          localObject6 = Boolean.FALSE;
          long l2 = ((cv)localObject5).CreateTime;
          ad.i("MicroMsg.LiveTipsBarStorage", "addLiveToTipsBar, hostRoomId:%s, liveId:%d", new Object[] { localObject1, Long.valueOf(l1) });
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
          parama = localb.dyU;
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
  
  public final void b(e.c paramc)
  {
    String str = null;
    AppMethodBeat.i(31013);
    Object localObject = paramc.dBd;
    if (localObject == null)
    {
      ad.e("MicroMsg.AppMessageExtension", "[onPreDelMessage] msg == null");
      AppMethodBeat.o(31013);
      return;
    }
    ad.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + ((ei)localObject).field_imgPath);
    paramc = new xw();
    paramc.dMg.path = ((ei)localObject).field_imgPath;
    com.tencent.mm.sdk.b.a.IbL.l(paramc);
    paramc = ((ei)localObject).field_content;
    if (paramc != null)
    {
      k.b localb = k.b.yr(paramc);
      if ((localb != null) && (localb.type == 6))
      {
        paramc = com.tencent.mm.loader.j.b.arX() + localb.title;
        com.tencent.mm.vfs.i.deleteFile(paramc);
        com.tencent.mm.vfs.i.deleteFile(com.tencent.mm.loader.j.b.arX() + localb.title + "_tmp");
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.s.a.bIX().CB(((ei)localObject).field_msgId);
      if (localObject != null)
      {
        str = ((c)localObject).field_fileFullPath;
        com.tencent.mm.vfs.i.deleteFile(str);
        com.tencent.mm.plugin.s.a.bIX().delete((com.tencent.mm.sdk.e.c)localObject, new String[] { "msgInfoId" });
      }
      ad.w("MicroMsg.AppMessageExtension", "onPreDelMessage, clean file, %s, %s", new Object[] { paramc, str });
      AppMethodBeat.o(31013);
      return;
      paramc = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void eZZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.k
 * JD-Core Version:    0.7.0.1
 */