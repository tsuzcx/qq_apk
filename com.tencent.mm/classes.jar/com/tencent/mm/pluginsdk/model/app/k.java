package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.k.b.a;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.at.a;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.g.a.px;
import com.tencent.mm.g.a.px.a;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.g.a.yc;
import com.tencent.mm.g.a.yd;
import com.tencent.mm.g.a.ze;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.b;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class k
  implements com.tencent.mm.ak.e
{
  private static void M(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(31012);
    au localau;
    if (!bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.AppMessageExtension", "updateC2CAAMsgMark, mark: %s, talker: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
      bc.aCg();
      localau = com.tencent.mm.model.c.azL().aVa(paramString);
      if (localau != null)
      {
        if (!paramBoolean) {
          break label85;
        }
        localau.lQ(16777216);
      }
    }
    for (;;)
    {
      bc.aCg();
      com.tencent.mm.model.c.azL().a(localau, paramString);
      AppMethodBeat.o(31012);
      return;
      label85:
      localau.lR(16777216);
    }
  }
  
  private e.b a(e.a parama, String paramString, k.b paramb)
  {
    AppMethodBeat.i(31011);
    cv localcv = parama.gte;
    bc.aCg();
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = com.tencent.mm.model.c.azI();
    bc.aCg();
    Object localObject1 = com.tencent.mm.model.c.azO();
    Object localObject2 = v.aAC();
    String str1 = z.a(localcv.FNG);
    String str2 = z.a(localcv.FNH);
    int j;
    bl.b localb;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.a.l)localObject1).has(str1)) || (((String)localObject2).equals(str1)))
    {
      j = 1;
      localb = bl.BS(localcv.FNL);
      if (localb == null) {
        break label2754;
      }
    }
    label114:
    Object localObject4;
    label431:
    label447:
    label2754:
    for (Object localObject3 = localb.hJE;; localObject3 = null)
    {
      label355:
      int i;
      boolean bool;
      if (x.AT((String)localObject3))
      {
        localObject1 = "notifymessage";
        localObject4 = locali.aJ((String)localObject1, localcv.xrk);
        ae.i("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", new Object[] { Long.valueOf(localcv.xrk), Long.valueOf(((ei)localObject4).field_msgId) });
        if ((((ei)localObject4).field_msgId != 0L) && (((ei)localObject4).field_createTime + 604800000L < bl.B((String)localObject1, localcv.CreateTime)))
        {
          ae.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localcv.xrk), Long.valueOf(((ei)localObject4).field_msgId) });
          bl.rW(((ei)localObject4).field_msgId);
          ((bv)localObject4).setMsgId(0L);
        }
        localObject2 = localObject4;
        if (((ei)localObject4).field_msgId == 0L)
        {
          localObject2 = new bv();
          ((bv)localObject2).qM(localcv.xrk);
          ((bv)localObject2).qN(bl.B((String)localObject1, localcv.CreateTime));
        }
        if (paramb.hCz != null)
        {
          ((bv)localObject2).us(paramb.hCz.fmw);
          ae.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", new Object[] { ((ei)localObject2).fmw });
        }
        ((bv)localObject2).setType(m.g(paramb));
        if (!((bv)localObject2).fta()) {
          break label1811;
        }
        localObject4 = paramb.content;
        ((bv)localObject2).setContent((String)localObject4);
        if (((bv)localObject2).fta()) {
          ((bv)localObject2).uq(paramb.fmn);
        }
        if ((localcv.FNJ != 2) || (((ei)localObject2).field_msgId != 0L)) {
          break label2114;
        }
        switch (((bv)localObject2).getType())
        {
        default: 
          i = 0;
          if (i == 0) {
            if (paramb.type == 2)
            {
              bool = true;
              localObject4 = z.a(localcv.FNK);
              if (ac.iRN)
              {
                ae.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                localObject4 = null;
              }
              if (bu.cF((byte[])localObject4)) {
                break label1846;
              }
              if ((paramb.type != 33) && (paramb.type != 36) && (paramb.type != 46) && (paramb.type != 44) && (paramb.type != 48)) {
                break label1829;
              }
              localObject4 = com.tencent.mm.av.q.aIX().a((byte[])localObject4, Bitmap.CompressFormat.PNG);
              if (bu.isNullOrNil((String)localObject4)) {
                ae.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", new Object[] { ((ei)localObject2).field_content });
              }
              if (!bu.isNullOrNil((String)localObject4))
              {
                ((bv)localObject2).uj((String)localObject4);
                ae.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path".concat(String.valueOf(localObject4)));
              }
              label599:
              if (j == 0) {
                break label2386;
              }
              ((bv)localObject2).kt(1);
              ((bv)localObject2).ui((String)localObject1);
              i = localcv.nJb;
              label624:
              ((bv)localObject2).setStatus(i);
              if (paramb.type == 2001) {
                if (paramb.dmr == 1)
                {
                  if ((TextUtils.isEmpty(paramb.hEo)) || (TextUtils.isEmpty(paramb.hEp)) || (paramb.hEq <= 0)) {
                    break label2424;
                  }
                  ae.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
                  localObject1 = new at();
                  ((at)localObject1).dmD = new at.a();
                  ((at)localObject1).dmD.dmF = paramb.hEp;
                  ((at)localObject1).dmD.dmE = paramb.hEo;
                  ((at)localObject1).dmD.dmG = paramb.hEq;
                  com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
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
          if (bu.ht(paramb.hEA)) {
            continue;
          }
          localObject1 = paramb.hEA.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject4 = ((String)((Iterator)localObject1).next()).split(",");
            if ((localObject4 == null) || (localObject4.length <= 0)) {
              continue;
            }
            localObject4 = localObject4[0];
            if ((bu.isNullOrNil((String)localObject4)) || (!((String)localObject4).equals(v.aAC()))) {
              continue;
            }
            ((bv)localObject2).setFlag(((ei)localObject2).field_flag | 0x8);
            ae.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
            M(true, ((ei)localObject2).field_talker);
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
          label2114:
          label2386:
          label2424:
          ae.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", new Object[] { localException.getMessage() });
          continue;
          ((bon)localObject4).HbR = localException.hBO;
          ((bon)localObject4).HbT = localException.hBP;
          continue;
          ((bv)localObject2).setMsgId(bl.v((bv)localObject2));
          continue;
          if (!ab.d((bv)localObject2, (String)localObject3)) {
            continue;
          }
          com.tencent.mm.storage.y.d((bv)localObject2, true);
          parama = new e.b((bv)localObject2, false);
          continue;
          locali.b(localcv.xrk, (bv)localObject2);
          continue;
          localException.doe.dom = true;
          continue;
        }
        ae.i("MicroMsg.AppMessageExtension", "paymsgid: %s", new Object[] { paramb.hEn });
        ((bv)localObject2).tk(localcv.FNL);
        if (localb != null)
        {
          ((bv)localObject2).ur(localb.hJI);
          ((bv)localObject2).kJ(localb.hJJ);
          ((bv)localObject2).um(localb.hJH);
        }
        if (((bv)localObject2).cyH()) {
          ((bv)localObject2).uj(com.tencent.mm.modelvideo.t.HI(str2));
        }
        bl.a((bv)localObject2, parama);
        if (((ei)localObject2).field_msgId != 0L) {
          continue;
        }
        if (!ab.d((bv)localObject2, (String)localObject3)) {
          continue;
        }
        com.tencent.mm.storage.y.d((bv)localObject2, true);
        parama = new com.tencent.mm.g.a.t();
        parama.dlv.dlw = ((bv)localObject2);
        parama.dlv.dlx = paramb;
        com.tencent.mm.sdk.b.a.IvT.l(parama);
        parama = new e.b((bv)localObject2, true);
        if ((((bv)localObject2).getType() == 301989937) && (x.AR(((ei)localObject2).field_talker))) {
          ((bv)localObject2).setMsgId(0L);
        }
        if ((((bv)localObject2).fvC()) && ("notifymessage".equals(((ei)localObject2).field_talker)))
        {
          localObject1 = bx.M(((ei)localObject2).field_content, "msg");
          if (localObject1 != null)
          {
            localObject1 = bu.nullAsNil((String)((Map)localObject1).get(".msg.fromusername"));
            if (an.zd((String)localObject1))
            {
              ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).b((String)localObject1, null);
              ae.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", new Object[] { localObject1 });
            }
          }
        }
        if (((bv)localObject2).getType() == 536870961)
        {
          localObject1 = (com.tencent.mm.ah.b)paramb.ao(com.tencent.mm.ah.b.class);
          localObject3 = new px();
          ((px)localObject3).dFt.dFq = ((ei)localObject2).field_msgId;
          ((px)localObject3).dFt.dFu = ((com.tencent.mm.ah.b)localObject1).dFs;
          ((px)localObject3).dFt.dEU = paramString;
          if (((ei)localObject2).field_isSend == 1)
          {
            ae.d("MicroMsg.AppMessageExtension", "fromuser: %s, touser: %s", new Object[] { str1, str2 });
            ((px)localObject3).dFt.username = ((ei)localObject2).field_talker;
          }
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
          if (((px)localObject3).dFt.dEU != null)
          {
            ((bv)localObject2).setContent(((px)localObject3).dFt.dEU);
            locali.a(((ei)localObject2).field_msgId, (bv)localObject2);
          }
        }
        if ((!bu.isNullOrNil(paramb.hEt)) && (((bv)localObject2).getType() == 436207665))
        {
          localObject1 = new pv();
          ((pv)localObject1).dFp.dFq = ((ei)localObject2).field_msgId;
          ((pv)localObject1).dFp.dEU = paramString;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
        }
        if ((paramb.type == 2000) && (!bu.isNullOrNil(paramb.hDL)))
        {
          paramString = new qa();
          paramString.dFy.dyA = paramb.hDL;
          paramString.dFy.msgId = ((ei)localObject2).field_msgId;
          paramString.dFy.dFz = paramb;
          com.tencent.mm.sdk.b.a.IvT.l(paramString);
          M(false, ((ei)localObject2).field_talker);
        }
        paramString = paramb.hFw;
        paramb = bu.bI((String)paramString.get(".msg.appmsg.ext_pay_info.pay_type"), "");
        if (((paramb.equals("wx_f2f")) || (paramb.equals("wx_md"))) && (parama.hQT))
        {
          l1 = ((ei)localObject2).field_createTime;
          l2 = ch.aDb();
          ae.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", new Object[] { paramb, Long.valueOf(l1), Long.valueOf(l2) });
          localObject1 = new cg();
          i = bu.getInt((String)paramString.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
          localObject2 = bu.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.pay_feetype"));
          localObject3 = bu.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
          localObject4 = bu.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.voice_content"));
          str1 = bu.nullAsNil((String)paramString.get(".msg.appmsg.ext_pay_info.expire_voice_timestamp"));
          j = bu.getInt((String)paramString.get(".msg.appmsg.ext_pay_info.need_failover"), 1);
          if ((i > 0) && (!bu.isNullOrNil((String)localObject2)) && (!bu.isNullOrNil((String)localObject3)))
          {
            ((cg)localObject1).doe.dof = i;
            ((cg)localObject1).doe.dog = ((String)localObject2);
            ((cg)localObject1).doe.doh = ((String)localObject3);
            ((cg)localObject1).doe.doi = paramb;
            ((cg)localObject1).doe.gW = (l2 - l1);
            ((cg)localObject1).doe.doj = 0;
            ((cg)localObject1).doe.dok = ((String)localObject4);
            ((cg)localObject1).doe.dol = str1;
            if (j != 0) {
              continue;
            }
            ((cg)localObject1).doe.dom = false;
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
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
        localObject4 = a((byte[])localObject4, bool, ((bv)localObject2).fvH());
        break label540;
        if ((!bu.isNullOrNil(paramb.hCS)) && (!bu.isNullOrNil(paramb.hCW)))
        {
          a(((ei)localObject2).field_msgSvrId, (bv)localObject2, (String)localObject1, paramb.hCW, paramb.hCS, paramb.hCT, bool, paramb, "", false);
          break label599;
        }
        if (!bu.isNullOrNil(paramb.thumburl))
        {
          ae.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
          localObject5 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
          localObject4 = com.tencent.mm.av.q.aIX().getFullPath((String)localObject5);
          com.tencent.mm.av.q.aIX();
          localObject5 = com.tencent.mm.av.i.wI((String)localObject5);
          localObject6 = com.tencent.mm.av.q.aJb();
          str3 = paramb.thumburl;
          locala = new c.a();
          locala.hgD = ((String)localObject4);
          locala.igk = true;
          ((com.tencent.mm.av.a.a)localObject6).a(str3, null, locala.aJu());
          ((bv)localObject2).uj((String)localObject5);
          ae.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(localObject4)));
          break label599;
        }
        if (bu.isNullOrNil(paramb.hCJ)) {
          break label599;
        }
        a(((ei)localObject2).field_msgSvrId, (bv)localObject2, (String)localObject1, paramb.hCP, paramb.hCJ, paramb.hCK, bool, paramb, paramb.hCO, true);
        ae.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.hCJ);
        break label599;
        if (!bu.isNullOrNil(paramb.thumburl))
        {
          ae.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
          localObject4 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
          if (paramb.type == 2001) {
            localObject4 = com.tencent.mm.b.g.getMessageDigest(paramb.thumburl.getBytes());
          }
          if (((bv)localObject2).fta()) {
            break label599;
          }
          localObject5 = com.tencent.mm.av.q.aIX().getFullPath((String)localObject4);
          com.tencent.mm.av.q.aIX();
          localObject4 = com.tencent.mm.av.i.wI((String)localObject4);
          localObject6 = com.tencent.mm.av.q.aJb();
          str3 = paramb.thumburl;
          locala = new c.a();
          locala.hgD = ((String)localObject5);
          locala.igk = true;
          ((com.tencent.mm.av.a.a)localObject6).a(str3, null, locala.aJu());
          ((bv)localObject2).uj((String)localObject4);
          ae.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(localObject5)));
          break label599;
        }
        if (bu.isNullOrNil(paramb.hCJ)) {
          break label599;
        }
        if (paramb.type == 2)
        {
          bool = true;
          a(((ei)localObject2).field_msgSvrId, (bv)localObject2, (String)localObject1, paramb.hCP, paramb.hCJ, paramb.hCK, bool, paramb, paramb.hCO, true);
          ae.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.hCJ);
          break label599;
        }
        bool = false;
        continue;
        ((bv)localObject2).kt(0);
        ((bv)localObject2).ui((String)localObject1);
        if (localcv.nJb > 3)
        {
          i = localcv.nJb;
          break label624;
        }
        i = 3;
        break label624;
        ae.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
        continue;
        if (!"1001".equals(paramb.hEk))
        {
          localObject1 = new ze();
          ((ze)localObject1).dPk.dEU = paramString;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
          M(false, ((ei)localObject2).field_talker);
          if ("1002".equals(paramb.hEk))
          {
            localObject1 = (com.tencent.mm.ah.c)paramb.ao(com.tencent.mm.ah.c.class);
            localObject4 = new bon();
            ((bon)localObject4).HbS = ((com.tencent.mm.ah.c)localObject1).hBS;
            ((bon)localObject4).HbV = ((com.tencent.mm.ah.c)localObject1).hBT;
            ((bon)localObject4).hnD = ((com.tencent.mm.ah.c)localObject1).hBQ;
            ((bon)localObject4).HbU = ((com.tencent.mm.ah.c)localObject1).hBR;
            if (j == 0) {
              continue;
            }
            ((bon)localObject4).HbR = ((com.tencent.mm.ah.c)localObject1).hBM;
            ((bon)localObject4).HbT = ((com.tencent.mm.ah.c)localObject1).hBN;
            localObject5 = (com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class);
            localObject6 = new bom();
            ((bom)localObject6).HbB = ((bon)localObject4);
            ((com.tencent.mm.plugin.luckymoney.a.a)localObject5).a((bom)localObject6);
            ((com.tencent.mm.plugin.luckymoney.a.a)localObject5).a(((com.tencent.mm.ah.c)localObject1).hBU);
          }
        }
      }
    }
  }
  
  static String a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(31010);
    paramArrayOfByte = com.tencent.mm.av.q.aIX().a(paramArrayOfByte, paramBoolean1, Bitmap.CompressFormat.PNG, paramBoolean2);
    AppMethodBeat.o(31010);
    return paramArrayOfByte;
  }
  
  private boolean a(final long paramLong, bv parambv, String paramString1, String paramString2, String paramString3, final int paramInt, final boolean paramBoolean1, final k.b paramb, String paramString4, boolean paramBoolean2)
  {
    AppMethodBeat.i(31014);
    ae.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", new Object[] { Long.valueOf(parambv.field_msgSvrId), paramString2, Integer.valueOf(paramInt), paramString3, paramString1, Boolean.valueOf(paramBoolean1) });
    final long l = bu.fpO();
    final int i;
    com.tencent.mm.i.g localg;
    if (paramb != null)
    {
      i = paramb.type;
      paramb = com.tencent.mm.av.q.aIX().o(bu.fpO(), "", "");
      localg = new com.tencent.mm.i.g();
      localg.fLl = "task_AppMessageExtension_1";
      localg.field_mediaId = com.tencent.mm.an.c.a("downappthumb", parambv.field_createTime, paramString1, String.valueOf(paramLong));
      localg.field_fullpath = paramb;
      if (!paramBoolean2) {
        break label298;
      }
      localg.field_fileType = 19;
      localg.fLp = paramString3;
      label171:
      localg.field_totalLen = paramInt;
      localg.field_aesKey = paramString2;
      localg.field_priority = com.tencent.mm.i.a.fKB;
      localg.field_authKey = paramString4;
      if (!x.wb(paramString1)) {
        break label316;
      }
    }
    label298:
    label316:
    for (int j = 1;; j = 0)
    {
      localg.field_chattype = j;
      ae.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString1 });
      localg.fLm = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(31005);
          if (paramAnonymousInt != 0)
          {
            ae.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousInt), l });
            new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(paramInt), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(paramb), "" })).aLH();
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
            ae.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousd.field_retCode), l });
            if (paramAnonymousd != null) {
              break label904;
            }
            paramAnonymousInt = -1;
            l1 = paramInt;
            l2 = bu.fpO();
            i = com.tencent.mm.an.c.cC(ak.getContext());
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
            new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aLH();
            if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode != 0))
            {
              if (paramAnonymousd != null) {
                break label931;
              }
              paramAnonymousInt = -1;
              label402:
              l1 = paramInt;
              l2 = bu.fpO();
              i = com.tencent.mm.an.c.cC(ak.getContext());
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
          for (paramAnonymousc = "";; paramAnonymousc = paramAnonymousd.fKX)
          {
            new h(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(2), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousString, "", "", "", "", "", "", "", paramAnonymousc })).aLH();
            com.tencent.mm.av.q.aIX().doNotify();
            AppMethodBeat.o(31005);
            return 0;
            bc.aCg();
            paramAnonymousc = com.tencent.mm.model.c.azI().aJ(i, paramLong);
            if (paramAnonymousc.field_msgSvrId != paramLong)
            {
              ae.e("MicroMsg.AppMessageExtension", "hy: appmsg %d has been deleted", new Object[] { Long.valueOf(paramLong) });
              AppMethodBeat.o(31005);
              return 0;
            }
            ae.i("MicroMsg.AppMessageExtension", "hy: %d current msg type is %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramAnonymousc.getType()) });
            paramAnonymousString = com.tencent.mm.vfs.o.bb(paramBoolean1, 0, -1);
            if ((this.Ffp == 33) || (this.Ffp == 36) || (this.Ffp == 46) || (this.Ffp == 44) || (this.Ffp == 48))
            {
              paramAnonymousString = com.tencent.mm.av.q.aIX().a(paramAnonymousString, Bitmap.CompressFormat.JPEG);
              label747:
              if (!bu.isNullOrNil(paramAnonymousString))
              {
                paramAnonymousc.uj(paramAnonymousString);
                bc.aCg();
                com.tencent.mm.model.c.azI().b(paramAnonymousc.field_msgSvrId, paramAnonymousc);
              }
              ae.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", new Object[] { Long.valueOf(paramLong), i, l, paramAnonymousString });
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 16L, paramb, false);
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(198L, 17L, 1L, false);
              paramAnonymousString = com.tencent.mm.plugin.report.service.g.yxI;
              if (!x.wb(i)) {
                break label896;
              }
            }
            for (l1 = 19L;; l1 = 18L)
            {
              paramAnonymousString.idkeyStat(198L, l1, 1L, false);
              break;
              paramAnonymousString = k.a(paramAnonymousString, this.Ffq, paramAnonymousc.fvH());
              break label747;
            }
            paramAnonymousInt = paramAnonymousd.field_retCode;
            break label210;
            paramAnonymousString = paramAnonymousd.field_transInfo;
            break label248;
            paramAnonymousc = paramAnonymousd.fKX;
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
      com.tencent.mm.an.f.aGZ().b(localg, -1);
      AppMethodBeat.o(31014);
      return true;
      i = 0;
      break;
      localg.field_fileId = paramString3;
      localg.field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
      break label171;
    }
  }
  
  public static String lz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31008);
    if (bu.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(31008);
      return null;
    }
    String str = paramString2;
    if (x.wb(paramString1))
    {
      int i = bl.BJ(paramString2);
      str = paramString2;
      if (i != -1) {
        str = (paramString2 + " ").substring(i + 2).trim();
      }
    }
    paramString1 = bu.aSA(str);
    AppMethodBeat.o(31008);
    return paramString1;
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(31009);
    ae.d("MicroMsg.AppMessageExtension", "process add app message");
    Object localObject5 = parama.gte;
    Object localObject1 = z.a(((cv)localObject5).FNG);
    String str = z.a(((cv)localObject5).FNH);
    if ((bu.isNullOrNil((String)localObject1)) || (bu.isNullOrNil(str))) {
      ae.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
    }
    k.b localb;
    for (str = null;; str = lz((String)localObject1, z.a(((cv)localObject5).FNI)))
    {
      localb = k.b.zb(str);
      if (localb != null) {
        break;
      }
      ae.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
      AppMethodBeat.o(31009);
      return null;
    }
    if (localb.hEr)
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(352273, str);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(352274, Long.valueOf(System.currentTimeMillis()));
      new b(str).fdD();
      AppMethodBeat.o(31009);
      return null;
    }
    Object localObject2 = ao.dBg().aNg(localb.appId);
    Object localObject3 = localb.appId;
    int i = localb.aDD;
    if (localObject2 == null) {}
    e.b localb1;
    for (localObject1 = "null";; localObject1 = Integer.valueOf(((g)localObject2).field_appVersion))
    {
      ae.i("MicroMsg.AppMessageExtension", "check version appid:%s, msgVer:%d, appVer:%s", new Object[] { localObject3, Integer.valueOf(i), localObject1 });
      if ((localObject2 == null) || (((g)localObject2).field_appVersion < localb.aDD)) {
        ao.dBf().aNf(localb.appId);
      }
      localb1 = a(parama, z.a(((cv)localObject5).FNI), localb);
      if (localb1.dlw != null) {
        break;
      }
      AppMethodBeat.o(31009);
      return null;
    }
    bv localbv = localb1.dlw;
    if (localbv.fta())
    {
      AppMethodBeat.o(31009);
      return localb1;
    }
    if (localbv.getType() == 301989937)
    {
      AppMethodBeat.o(31009);
      return localb1;
    }
    if (localbv.getType() == -1879048190)
    {
      localObject1 = new yd();
      ((yd)localObject1).dNx.dCX = str;
      ((yd)localObject1).dNx.description = localb.description;
      ((yd)localObject1).dNx.dlw = localbv;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    if ((localbv.getType() == 49) && (!bu.isNullOrNil(localb.canvasPageXml)))
    {
      localObject1 = new com.tencent.mm.g.a.f();
      ((com.tencent.mm.g.a.f)localObject1).dkI.dkJ = localb.canvasPageXml;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    }
    if (localbv.cyH())
    {
      localObject3 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(2, "");
      localObject1 = z.a(((cv)localObject5).FNH);
      localObject2 = z.a(((cv)localObject5).FNG);
      if ((!((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().has((String)localObject2)) && (!((String)localObject3).equals(localObject2))) {
        break label1060;
      }
      i = 1;
      localObject3 = new s();
      if (i == 0) {
        break label1065;
      }
      label568:
      ((s)localObject3).dED = ((String)localObject1);
      ((s)localObject3).iwS = ((String)localObject2);
      ((s)localObject3).createTime = ((cv)localObject5).CreateTime;
      ((s)localObject3).dCd = ((cv)localObject5).xrk;
      ((s)localObject3).ixe = ((cv)localObject5).FNI.HId;
      ((s)localObject3).iwZ = ((int)localbv.field_msgId);
      if (!localbv.fvw()) {
        break label1072;
      }
    }
    Object localObject6;
    for (localObject1 = new com.tencent.mm.ah.y().a(localbv.JgM);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ((s)localObject3).fileName = localbv.field_imgPath;
        ((s)localObject3).a(((com.tencent.mm.ah.y)localObject1).videoUrl, ((com.tencent.mm.ah.y)localObject1).videoDuration, ((com.tencent.mm.ah.y)localObject1).title, ((com.tencent.mm.ah.y)localObject1).FUw, "", "", "");
        ((s)localObject3).status = 111;
      }
      com.tencent.mm.modelvideo.o.aNh().b((s)localObject3);
      if (localb.type != 53) {
        break label1371;
      }
      ae.i("MicroMsg.AppMessageExtension", "process MM_APP_SOLITAIRE_TEXT");
      localObject3 = ((cv)localObject5).FNM;
      localObject6 = localb.title;
      if (!bu.isNullOrNil((String)localObject3)) {
        break label1142;
      }
      localObject1 = "";
      label762:
      ((cv)localObject5).FNM = ((String)localObject1);
      localObject1 = bl.BM(localbv.field_content);
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break label1717;
      }
      label792:
      if (!parama.hQN) {
        break label1314;
      }
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).b(z.a(((cv)localObject5).FNG), (String)localObject1, localb.title, (String)localb.hFp.second, localbv.field_msgId, localbv.field_createTime / 1000L);
      label853:
      if ((x.zU(localbv.field_talker)) && (com.tencent.mm.chatroom.d.y.Yn())) {
        ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupTodoByReceiverAppMsg(localbv);
      }
      if ((x.zU(localbv.field_talker)) && (aa.Yr())) {
        ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(localbv);
      }
      parama = new com.tencent.mm.ah.k();
      localb.a(parama);
      parama.field_msgId = localbv.field_msgId;
      if ((ao.fdU().yb(localbv.field_msgId) != null) || (!ao.fdU().insert(parama))) {
        break label1709;
      }
      if (localb.type == 40)
      {
        parama = ao.bJV().CZ(localbv.field_msgId);
        localObject1 = com.tencent.mm.ah.t.zg(str);
        if (parama == null) {
          m.a(null, localbv.field_msgId, 0, null, null, ((com.tencent.mm.ah.t)localObject1).hGa, localb.type, 0);
        }
        parama = new com.tencent.mm.plugin.record.b.f(localbv.field_msgId, localbv.field_msgSvrId, null);
        bc.ajj().a(parama, 0);
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
      localObject1 = k.b.aB(localbv.field_content, localbv.field_reserved);
      if (localObject1 != null) {
        break label1106;
      }
      ae.w("MicroMsg.AppMessageExtension", "getVideoInfo content is null");
    }
    label1106:
    localObject1 = (com.tencent.mm.ah.e)((k.b)localObject1).ao(com.tencent.mm.ah.e.class);
    if ((localObject1 != null) && (((com.tencent.mm.ah.e)localObject1).hCc != null)) {}
    for (localObject1 = ((com.tencent.mm.ah.e)localObject1).hCc;; localObject1 = null)
    {
      break;
      label1142:
      localObject2 = bu.aSA((String)localObject3);
      if (bu.isNullOrNil((String)localObject2))
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
        localObject2 = bx.M((String)localObject2, "pushcontent");
        if (localObject2 == null)
        {
          ae.e("MicroMsg.AppMessageExtension", "inval xml");
          localObject1 = localObject3;
          break;
        }
        localObject2 = (String)((Map)localObject2).get(".pushcontent.$nickname");
        ((StringBuilder)localObject1).append("<pushcontent content=\"").append((String)localObject2).append(" : ").append((String)localObject6).append("\"nickname=\"").append((String)localObject2).append("\" />\n");
        localObject1 = ((StringBuilder)localObject1).toString();
        break;
        label1314:
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).a(z.a(((cv)localObject5).FNG), (String)localObject1, localb.title, (String)localb.hFp.second, localbv.field_msgId, localbv.field_createTime / 1000L);
        break label853;
        label1371:
        if (localb.type == 57)
        {
          ae.i("MicroMsg.AppMessageExtension", "process MM_APP_MSG_QUOTE");
          ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).handleReceivedQuoteMsg(localbv.field_msgId, localbv.field_msgSvrId, localbv.field_talker, localb.hFq.wlg);
          break label853;
        }
        if (localb.type != 60) {
          break label853;
        }
        parama = (String)com.tencent.mm.kernel.g.ajR().ajA().get(2, "");
        localObject1 = z.a(((cv)localObject5).FNG);
        boolean bool;
        if ((((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().has((String)localObject1)) || (parama.equals(localObject1)))
        {
          bool = true;
          label1501:
          if (!bool) {
            break label1700;
          }
        }
        for (;;)
        {
          ae.i("MicroMsg.AppMessageExtension", "process MM_APP_MMLIVE_SHARE, isSender%b, anchor:%s", new Object[] { Boolean.valueOf(bool), parama });
          if (bool) {
            break;
          }
          localObject3 = (com.tencent.mm.live.b.l)localb.ao(com.tencent.mm.live.b.l.class);
          long l1 = Long.parseLong(((com.tencent.mm.live.b.l)localObject3).gRV);
          localObject2 = ((com.tencent.mm.live.b.l)localObject3).gJj;
          localObject3 = ((com.tencent.mm.live.b.l)localObject3).thumbUrl;
          localObject4 = ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).getLiveTipsBarStorage();
          localObject6 = Boolean.FALSE;
          long l2 = ((cv)localObject5).CreateTime;
          ae.i("MicroMsg.LiveTipsBarStorage", "addLiveToTipsBar, hostRoomId:%s, liveId:%d", new Object[] { localObject1, Long.valueOf(l1) });
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
          parama = localb.dzZ;
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
    Object localObject = paramc.dCi;
    if (localObject == null)
    {
      ae.e("MicroMsg.AppMessageExtension", "[onPreDelMessage] msg == null");
      AppMethodBeat.o(31013);
      return;
    }
    ae.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + ((ei)localObject).field_imgPath);
    paramc = new yc();
    paramc.dNw.path = ((ei)localObject).field_imgPath;
    com.tencent.mm.sdk.b.a.IvT.l(paramc);
    paramc = ((ei)localObject).field_content;
    if (paramc != null)
    {
      k.b localb = k.b.zb(paramc);
      if ((localb != null) && (localb.type == 6))
      {
        paramc = com.tencent.mm.loader.j.b.asm() + localb.title;
        com.tencent.mm.vfs.o.deleteFile(paramc);
        com.tencent.mm.vfs.o.deleteFile(com.tencent.mm.loader.j.b.asm() + localb.title + "_tmp");
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.s.a.bJV().CZ(((ei)localObject).field_msgId);
      if (localObject != null)
      {
        str = ((c)localObject).field_fileFullPath;
        com.tencent.mm.vfs.o.deleteFile(str);
        com.tencent.mm.plugin.s.a.bJV().delete((com.tencent.mm.sdk.e.c)localObject, new String[] { "msgInfoId" });
      }
      ae.w("MicroMsg.AppMessageExtension", "onPreDelMessage, clean file, %s, %s", new Object[] { paramc, str });
      AppMethodBeat.o(31013);
      return;
      paramc = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void fdN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.k
 * JD-Core Version:    0.7.0.1
 */