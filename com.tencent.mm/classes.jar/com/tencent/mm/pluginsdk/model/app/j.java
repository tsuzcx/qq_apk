package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.j.b.a;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.am.a;
import com.tencent.mm.g.a.by;
import com.tencent.mm.g.a.no;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.nq.a;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.a.us;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.b;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class j
  implements com.tencent.mm.ai.e
{
  private e.b a(e.a parama, String paramString, j.b paramb)
  {
    AppMethodBeat.i(27318);
    localcm = parama.eyJ;
    aw.aaz();
    localh = com.tencent.mm.model.c.YC();
    aw.aaz();
    Object localObject1 = com.tencent.mm.model.c.YI();
    localObject2 = com.tencent.mm.model.r.Zn();
    String str1 = aa.a(localcm.woP);
    String str2 = aa.a(localcm.woQ);
    int j;
    bf.b localb;
    label117:
    int i;
    label358:
    boolean bool;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.a.k)localObject1).has(str1)) || (((String)localObject2).equals(str1)))
    {
      j = 1;
      localb = bf.pA(localcm.woU);
      localObject1 = null;
      if (localb != null) {
        localObject1 = localb.fmD;
      }
      if (!t.oz((String)localObject1)) {
        break label1727;
      }
      localObject1 = "notifymessage";
      localObject3 = localh.ag((String)localObject1, localcm.pIG);
      ab.i("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", new Object[] { Long.valueOf(localcm.pIG), Long.valueOf(((dd)localObject3).field_msgId) });
      if ((((dd)localObject3).field_msgId != 0L) && (((dd)localObject3).field_createTime + 604800000L < bf.x((String)localObject1, localcm.CreateTime)))
      {
        ab.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localcm.pIG), Long.valueOf(((dd)localObject3).field_msgId) });
        bf.gw(((dd)localObject3).field_msgId);
        ((bi)localObject3).setMsgId(0L);
      }
      localObject2 = localObject3;
      if (((dd)localObject3).field_msgId == 0L)
      {
        localObject2 = new bi();
        ((bi)localObject2).fP(localcm.pIG);
        ((bi)localObject2).fQ(bf.x((String)localObject1, localcm.CreateTime));
      }
      if (paramb.fgt != null)
      {
        ((bi)localObject2).kq(paramb.fgt.dHa);
        ab.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", new Object[] { ((dd)localObject2).dHa });
      }
      ((bi)localObject2).setType(l.c(paramb));
      if (!((bi)localObject2).dvV()) {
        break label1746;
      }
      localObject3 = paramb.content;
      ((bi)localObject2).setContent((String)localObject3);
      if (((bi)localObject2).dvV()) {
        ((bi)localObject2).ko(paramb.dGR);
      }
      if ((localcm.woS != 2) || (((dd)localObject2).field_msgId != 0L)) {
        break label2061;
      }
      switch (((bi)localObject2).getType())
      {
      default: 
        i = 0;
        label435:
        if (i == 0) {
          if (paramb.type == 2)
          {
            bool = true;
            label451:
            localObject3 = aa.a(localcm.woT);
            if (ae.gkQ)
            {
              ab.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
              localObject3 = null;
            }
            if (bo.ce((byte[])localObject3)) {
              break label1781;
            }
            if ((paramb.type != 33) && (paramb.type != 36) && (paramb.type != 46) && (paramb.type != 44) && (paramb.type != 48)) {
              break label1764;
            }
            localObject3 = com.tencent.mm.at.o.ahC().a((byte[])localObject3, Bitmap.CompressFormat.PNG);
            if (bo.isNullOrNil((String)localObject3)) {
              ab.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", new Object[] { ((dd)localObject2).field_content });
            }
            if (!bo.isNullOrNil((String)localObject3))
            {
              ((bi)localObject2).kk((String)localObject3);
              ab.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path".concat(String.valueOf(localObject3)));
            }
            label602:
            if (j == 0) {
              break label2337;
            }
            ((bi)localObject2).hL(1);
            ((bi)localObject2).kj((String)localObject1);
            i = localcm.jJS;
            label627:
            ((bi)localObject2).setStatus(i);
            if (paramb.type == 2001) {
              if (paramb.showType == 1)
              {
                if ((TextUtils.isEmpty(paramb.fik)) || (TextUtils.isEmpty(paramb.fil)) || (paramb.fim <= 0)) {
                  break label2375;
                }
                ab.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
                localObject1 = new am();
                ((am)localObject1).cnM = new am.a();
                ((am)localObject1).cnM.cnO = paramb.fil;
                ((am)localObject1).cnM.cnN = paramb.fik;
                ((am)localObject1).cnM.cnP = paramb.fim;
                com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
              }
            }
          }
        }
        label543:
        break;
      }
    }
    for (;;)
    {
      try
      {
        if (bo.es(paramb.fiw)) {
          continue;
        }
        localObject1 = paramb.fiw.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = ((String)((Iterator)localObject1).next()).split(",");
          if ((localObject3 == null) || (localObject3.length <= 0)) {
            continue;
          }
          localObject3 = localObject3[0];
          if ((bo.isNullOrNil((String)localObject3)) || (!((String)localObject3).equals(com.tencent.mm.model.r.Zn()))) {
            continue;
          }
          ((bi)localObject2).hV(((dd)localObject2).field_flag | 0x8);
          ab.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
          z(true, ((dd)localObject2).field_talker);
        }
      }
      catch (Exception localException)
      {
        long l1;
        long l2;
        label1727:
        label1746:
        label1764:
        label1781:
        String str3;
        com.tencent.mm.at.a.a locala;
        String str4;
        c.a locala1;
        label2061:
        label2337:
        label2375:
        ab.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", new Object[] { localException.getMessage() });
        continue;
        ((aut)localObject3).xjV = localException.fgb;
        ((aut)localObject3).xjY = localException.fgc;
        continue;
        localh.b(localcm.pIG, (bi)localObject2);
        parama = new e.b((bi)localObject2, false);
        continue;
      }
      ab.i("MicroMsg.AppMessageExtension", "paymsgid: %s", new Object[] { paramb.fij });
      ((bi)localObject2).jl(localcm.woU);
      if (localb != null)
      {
        ((bi)localObject2).kp(localb.fmI);
        ((bi)localObject2).kn(localb.fmH);
      }
      bf.a((bi)localObject2, parama);
      if (((dd)localObject2).field_msgId != 0L) {
        continue;
      }
      ((bi)localObject2).setMsgId(bf.l((bi)localObject2));
      parama = new com.tencent.mm.g.a.r();
      parama.cmP.cmQ = ((bi)localObject2);
      parama.cmP.cmR = paramb;
      com.tencent.mm.sdk.b.a.ymk.l(parama);
      parama = new e.b((bi)localObject2, true);
      if ((((bi)localObject2).getType() == 301989937) && (t.ox(((dd)localObject2).field_talker))) {
        ((bi)localObject2).setMsgId(0L);
      }
      if ((((bi)localObject2).dxP()) && ("notifymessage".equals(((dd)localObject2).field_talker)))
      {
        localObject1 = br.F(((dd)localObject2).field_content, "msg");
        if (localObject1 != null)
        {
          localObject1 = bo.nullAsNil((String)((Map)localObject1).get(".msg.fromusername"));
          if (ad.na((String)localObject1))
          {
            ((com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.i.class)).b((String)localObject1, null);
            ab.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", new Object[] { localObject1 });
          }
        }
      }
      if (((bi)localObject2).getType() == 536870961)
      {
        localObject1 = (com.tencent.mm.af.b)paramb.R(com.tencent.mm.af.b.class);
        localObject3 = new nq();
        ((nq)localObject3).cEh.cEe = ((dd)localObject2).field_msgId;
        ((nq)localObject3).cEh.cEi = ((com.tencent.mm.af.b)localObject1).cEg;
        ((nq)localObject3).cEh.cDI = paramString;
        if (((dd)localObject2).field_isSend == 1)
        {
          ab.d("MicroMsg.AppMessageExtension", "fromuser: %s, touser: %s", new Object[] { str1, str2 });
          ((nq)localObject3).cEh.username = ((dd)localObject2).field_talker;
        }
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
        if (((nq)localObject3).cEh.cDI != null)
        {
          ((bi)localObject2).setContent(((nq)localObject3).cEh.cDI);
          localh.a(((dd)localObject2).field_msgId, (bi)localObject2);
        }
      }
      if ((!bo.isNullOrNil(paramb.fip)) && (((bi)localObject2).getType() == 436207665))
      {
        localObject1 = new no();
        ((no)localObject1).cEd.cEe = ((dd)localObject2).field_msgId;
        ((no)localObject1).cEd.cDI = paramString;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      if ((paramb.type == 2000) && (!bo.isNullOrNil(paramb.fhG)))
      {
        paramString = new nt();
        paramString.cEm.cyr = paramb.fhG;
        paramString.cEm.cpO = ((dd)localObject2).field_msgId;
        paramString.cEm.cEn = paramb;
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
        z(false, ((dd)localObject2).field_talker);
      }
      paramb = paramb.fjm;
      paramString = bo.bf((String)paramb.get(".msg.appmsg.ext_pay_info.pay_type"), "");
      if (((paramString.equals("wx_f2f")) || (paramString.equals("wx_md"))) && (parama.ftj))
      {
        l1 = ((dd)localObject2).field_createTime;
        l2 = cb.abq();
        ab.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2) });
        localObject1 = new by();
        i = bo.getInt((String)paramb.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
        localObject2 = bo.nullAsNil((String)paramb.get(".msg.appmsg.ext_pay_info.pay_feetype"));
        localObject3 = bo.nullAsNil((String)paramb.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
        str1 = bo.nullAsNil((String)paramb.get(".msg.appmsg.ext_pay_info.voice_content"));
        paramb = bo.nullAsNil((String)paramb.get(".msg.appmsg.ext_pay_info.expire_voice_timestamp"));
        if ((i > 0) && (!bo.isNullOrNil((String)localObject2)) && (!bo.isNullOrNil((String)localObject3)))
        {
          ((by)localObject1).cpn.cpo = i;
          ((by)localObject1).cpn.cpp = ((String)localObject2);
          ((by)localObject1).cpn.cpq = ((String)localObject3);
          ((by)localObject1).cpn.cpr = paramString;
          ((by)localObject1).cpn.cps = (l2 - l1);
          ((by)localObject1).cpn.cpt = 0;
          ((by)localObject1).cpn.cpu = str1;
          ((by)localObject1).cpn.cpv = paramb;
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        }
      }
      AppMethodBeat.o(27318);
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
      localObject3 = a((byte[])localObject3, bool, ((bi)localObject2).dxT());
      break label543;
      if ((!bo.isNullOrNil(paramb.fgM)) && (!bo.isNullOrNil(paramb.fgS)))
      {
        a(((dd)localObject2).field_msgSvrId, (bi)localObject2, (String)localObject1, paramb.fgS, paramb.fgM, paramb.fgN, bool, paramb, "", false);
        break label602;
      }
      if (!bo.isNullOrNil(paramb.thumburl))
      {
        ab.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
        str3 = com.tencent.mm.a.g.w(bo.aoy().getBytes());
        localObject3 = com.tencent.mm.at.o.ahC().getFullPath(str3);
        com.tencent.mm.at.o.ahC();
        str3 = com.tencent.mm.at.g.td(str3);
        locala = com.tencent.mm.at.o.ahG();
        str4 = paramb.thumburl;
        locala1 = new c.a();
        locala1.eNO = ((String)localObject3);
        locala1.eNM = true;
        locala.a(str4, null, locala1.ahY());
        ((bi)localObject2).kk(str3);
        ab.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(localObject3)));
        break label602;
      }
      if (bo.isNullOrNil(paramb.fgD)) {
        break label602;
      }
      a(((dd)localObject2).field_msgSvrId, (bi)localObject2, (String)localObject1, paramb.fgJ, paramb.fgD, paramb.fgE, bool, paramb, paramb.fgI, true);
      ab.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.fgD);
      break label602;
      if (!bo.isNullOrNil(paramb.thumburl))
      {
        ab.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.thumburl);
        localObject3 = com.tencent.mm.a.g.w(bo.aoy().getBytes());
        if (paramb.type == 2001) {
          localObject3 = com.tencent.mm.a.g.w(paramb.thumburl.getBytes());
        }
        str3 = com.tencent.mm.at.o.ahC().getFullPath((String)localObject3);
        com.tencent.mm.at.o.ahC();
        localObject3 = com.tencent.mm.at.g.td((String)localObject3);
        locala = com.tencent.mm.at.o.ahG();
        str4 = paramb.thumburl;
        locala1 = new c.a();
        locala1.eNO = str3;
        locala1.eNM = true;
        locala.a(str4, null, locala1.ahY());
        ((bi)localObject2).kk((String)localObject3);
        ab.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path ".concat(String.valueOf(str3)));
        break label602;
      }
      if (bo.isNullOrNil(paramb.fgD)) {
        break label602;
      }
      if (paramb.type == 2)
      {
        bool = true;
        a(((dd)localObject2).field_msgSvrId, (bi)localObject2, (String)localObject1, paramb.fgJ, paramb.fgD, paramb.fgE, bool, paramb, paramb.fgI, true);
        ab.d("MicroMsg.AppMessageExtension", "get cdn image " + paramb.fgD);
        break label602;
      }
      bool = false;
      continue;
      ((bi)localObject2).hL(0);
      ((bi)localObject2).kj((String)localObject1);
      if (localcm.jJS > 3)
      {
        i = localcm.jJS;
        break label627;
      }
      i = 3;
      break label627;
      ab.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
      continue;
      if (!"1001".equals(paramb.fig))
      {
        localObject1 = new vt();
        ((vt)localObject1).cMX.cDI = paramString;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        z(false, ((dd)localObject2).field_talker);
        if ("1002".equals(paramb.fig))
        {
          localObject1 = (com.tencent.mm.af.c)paramb.R(com.tencent.mm.af.c.class);
          localObject3 = new aut();
          ((aut)localObject3).xjX = ((com.tencent.mm.af.c)localObject1).fgf;
          ((aut)localObject3).xka = ((com.tencent.mm.af.c)localObject1).fgg;
          ((aut)localObject3).xjW = ((com.tencent.mm.af.c)localObject1).fgd;
          ((aut)localObject3).xjZ = ((com.tencent.mm.af.c)localObject1).fge;
          if (j == 0) {
            continue;
          }
          ((aut)localObject3).xjV = ((com.tencent.mm.af.c)localObject1).ffZ;
          ((aut)localObject3).xjY = ((com.tencent.mm.af.c)localObject1).fga;
          ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.luckymoney.a.a.class)).a((aut)localObject3);
        }
      }
    }
  }
  
  static String a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(27317);
    paramArrayOfByte = com.tencent.mm.at.o.ahC().a(paramArrayOfByte, paramBoolean1, Bitmap.CompressFormat.PNG, paramBoolean2);
    AppMethodBeat.o(27317);
    return paramArrayOfByte;
  }
  
  private boolean a(long paramLong, bi parambi, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean1, j.b paramb, String paramString4, boolean paramBoolean2)
  {
    AppMethodBeat.i(27321);
    ab.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", new Object[] { Long.valueOf(parambi.field_msgSvrId), paramString2, Integer.valueOf(paramInt), paramString3, paramString1, Boolean.valueOf(paramBoolean1) });
    long l = bo.aoy();
    int i;
    com.tencent.mm.i.g localg;
    if (paramb != null)
    {
      i = paramb.type;
      paramb = com.tencent.mm.at.o.ahC().q(bo.aoy(), "", "");
      localg = new com.tencent.mm.i.g();
      localg.field_mediaId = com.tencent.mm.al.c.a("downappthumb", parambi.field_createTime, paramString1, String.valueOf(paramLong));
      localg.field_fullpath = paramb;
      if (!paramBoolean2) {
        break label290;
      }
      localg.field_fileType = 19;
      localg.eds = paramString3;
      label163:
      localg.field_totalLen = paramInt;
      localg.field_aesKey = paramString2;
      localg.field_priority = com.tencent.mm.i.a.ecG;
      localg.field_authKey = paramString4;
      if (!t.lA(paramString1)) {
        break label308;
      }
    }
    label290:
    label308:
    for (int j = 1;; j = 0)
    {
      localg.field_chattype = j;
      ab.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString1 });
      localg.edp = new j.1(this, paramLong, paramString3, l, paramInt, paramString1, paramb, i, paramBoolean1);
      com.tencent.mm.al.f.afO().b(localg, -1);
      AppMethodBeat.o(27321);
      return true;
      i = 0;
      break;
      localg.field_fileId = paramString3;
      localg.field_fileType = com.tencent.mm.i.a.MediaType_THUMBIMAGE;
      break label163;
    }
  }
  
  public static String hS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27315);
    if (bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(27315);
      return null;
    }
    String str = paramString2;
    if (t.lA(paramString1))
    {
      int i = bf.pt(paramString2);
      str = paramString2;
      if (i != -1) {
        str = (paramString2 + " ").substring(i + 2).trim();
      }
    }
    paramString1 = bo.apU(str);
    AppMethodBeat.o(27315);
    return paramString1;
  }
  
  private static void z(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(27319);
    ak localak;
    if (!bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.AppMessageExtension", "updateC2CAAMsgMark, mark: %s, talker: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
      aw.aaz();
      localak = com.tencent.mm.model.c.YF().arH(paramString);
      if (localak != null)
      {
        if (!paramBoolean) {
          break label87;
        }
        localak.jg(16777216);
      }
    }
    for (;;)
    {
      aw.aaz();
      com.tencent.mm.model.c.YF().a(localak, paramString);
      AppMethodBeat.o(27319);
      return;
      label87:
      localak.jh(16777216);
    }
  }
  
  public final void a(e.c paramc)
  {
    AppMethodBeat.i(27320);
    paramc = paramc.cEE;
    if (paramc == null)
    {
      ab.e("MicroMsg.AppMessageExtension", "[onPreDelMessage] msg == null");
      AppMethodBeat.o(27320);
      return;
    }
    ab.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + paramc.field_imgPath);
    us localus = new us();
    localus.cLi.path = paramc.field_imgPath;
    com.tencent.mm.sdk.b.a.ymk.l(localus);
    paramc = paramc.field_content;
    if (paramc != null)
    {
      paramc = j.b.mY(paramc);
      if ((paramc != null) && (paramc.type == 6))
      {
        com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.compatible.util.e.esq + paramc.title);
        com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.compatible.util.e.esq + paramc.title + "_tmp");
      }
    }
    AppMethodBeat.o(27320);
  }
  
  public final boolean a(j.a parama, String paramString1, long paramLong, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(27322);
    String str = com.tencent.mm.at.o.ahC().q("Note_".concat(String.valueOf(paramString1)), "", "");
    if (com.tencent.mm.vfs.e.cN(str))
    {
      AppMethodBeat.o(27322);
      return false;
    }
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.field_mediaId = com.tencent.mm.al.c.a("downappthumb", paramLong, paramString4, String.valueOf(paramString1));
    localg.field_fullpath = str;
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
    localg.field_totalLen = paramInt;
    localg.field_aesKey = paramString2;
    localg.field_fileId = paramString3;
    localg.field_priority = com.tencent.mm.i.a.ecG;
    if (t.lA(paramString4)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localg.field_chattype = paramInt;
      ab.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(localg.field_chattype), paramString4 });
      localg.edp = new j.2(this, parama, paramString3);
      com.tencent.mm.al.f.afO().b(localg, -1);
      AppMethodBeat.o(27322);
      return true;
    }
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(27316);
    ab.d("MicroMsg.AppMessageExtension", "process add app message");
    Object localObject3 = parama.eyJ;
    Object localObject1 = aa.a(((cm)localObject3).woP);
    Object localObject2 = aa.a(((cm)localObject3).woQ);
    if ((bo.isNullOrNil((String)localObject1)) || (bo.isNullOrNil((String)localObject2))) {
      ab.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
    }
    j.b localb;
    for (localObject1 = null;; localObject1 = hS((String)localObject1, aa.a(((cm)localObject3).woR)))
    {
      localb = j.b.mY((String)localObject1);
      if (localb != null) {
        break;
      }
      ab.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
      AppMethodBeat.o(27316);
      return null;
    }
    if (localb.fin)
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(352273, localObject1);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(352274, Long.valueOf(System.currentTimeMillis()));
      new a((String)localObject1).dlu();
      AppMethodBeat.o(27316);
      return null;
    }
    f localf = al.cac().als(localb.appId);
    String str = localb.appId;
    int i = localb.bDc;
    if (localf == null) {}
    for (localObject2 = "null";; localObject2 = Integer.valueOf(localf.field_appVersion))
    {
      ab.i("MicroMsg.AppMessageExtension", "check version appid:%s, msgVer:%d, appVer:%s", new Object[] { str, Integer.valueOf(i), localObject2 });
      if ((localf == null) || (localf.field_appVersion < localb.bDc)) {
        al.cab().alr(localb.appId);
      }
      parama = a(parama, aa.a(((cm)localObject3).woR), localb);
      if (parama.cmQ != null) {
        break;
      }
      AppMethodBeat.o(27316);
      return null;
    }
    localObject2 = parama.cmQ;
    if (((bi)localObject2).dvV())
    {
      AppMethodBeat.o(27316);
      return parama;
    }
    if (((bi)localObject2).getType() == 301989937)
    {
      AppMethodBeat.o(27316);
      return parama;
    }
    if (((bi)localObject2).getType() == -1879048190)
    {
      localObject3 = new ut();
      ((ut)localObject3).cLj.cBW = ((String)localObject1);
      ((ut)localObject3).cLj.description = localb.description;
      ((ut)localObject3).cLj.cmQ = ((bi)localObject2);
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
    }
    if ((((bi)localObject2).getType() == 49) && (!bo.isNullOrNil(localb.canvasPageXml)))
    {
      localObject3 = new com.tencent.mm.g.a.f();
      ((com.tencent.mm.g.a.f)localObject3).cmg.cmh = localb.canvasPageXml;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
    }
    localObject3 = new com.tencent.mm.af.j();
    localb.a((com.tencent.mm.af.j)localObject3);
    ((com.tencent.mm.af.j)localObject3).field_msgId = ((dd)localObject2).field_msgId;
    if ((al.dlL().nx(((dd)localObject2).field_msgId) == null) && (al.dlL().insert((com.tencent.mm.sdk.e.c)localObject3)))
    {
      if (localb.type == 40)
      {
        localObject3 = al.aUJ().nw(((dd)localObject2).field_msgId);
        localObject1 = com.tencent.mm.af.o.nd((String)localObject1);
        if (localObject3 == null) {
          l.a(null, ((dd)localObject2).field_msgId, 0, null, null, ((com.tencent.mm.af.o)localObject1).fjF, localb.type, 0);
        }
        localObject1 = new com.tencent.mm.plugin.record.b.e(((dd)localObject2).field_msgId, ((dd)localObject2).field_msgSvrId, null);
        aw.Rc().a((m)localObject1, 0);
      }
      AppMethodBeat.o(27316);
      return parama;
    }
    AppMethodBeat.o(27316);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.j
 * JD-Core Version:    0.7.0.1
 */