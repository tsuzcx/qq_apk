package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.g.a.a;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.ak.a;
import com.tencent.mm.h.a.bv;
import com.tencent.mm.h.a.ms;
import com.tencent.mm.h.a.mu;
import com.tencent.mm.h.a.mu.a;
import com.tencent.mm.h.a.mw;
import com.tencent.mm.h.a.r;
import com.tencent.mm.h.a.sz;
import com.tencent.mm.h.a.ta;
import com.tencent.mm.h.a.tx;
import com.tencent.mm.h.a.ug;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class j
  implements com.tencent.mm.ah.e
{
  j.a rUn = null;
  
  private e.b a(e.a parama, String paramString, g.a parama1)
  {
    localcd = parama.dBs;
    au.Hx();
    localg = com.tencent.mm.model.c.Fy();
    au.Hx();
    Object localObject1 = com.tencent.mm.model.c.FE();
    localObject2 = q.Gj();
    String str1 = aa.a(localcd.svF);
    String str2 = aa.a(localcd.svG);
    int i;
    bd.b localb;
    label111:
    Object localObject3;
    label352:
    int j;
    label431:
    boolean bool;
    if ((((com.tencent.mm.plugin.messenger.foundation.a.a.j)localObject1).has(str1)) || (((String)localObject2).equals(str1)))
    {
      i = 1;
      localb = bd.iM(localcd.svK);
      localObject1 = null;
      if (localb != null) {
        localObject1 = localb.dWv;
      }
      if (!s.hQ((String)localObject1)) {
        break label1652;
      }
      localObject1 = "notifymessage";
      localObject3 = localg.O((String)localObject1, localcd.ndp);
      y.i("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", new Object[] { Long.valueOf(localcd.ndp), Long.valueOf(((cs)localObject3).field_msgId) });
      if ((((cs)localObject3).field_msgId != 0L) && (((cs)localObject3).field_createTime + 604800000L < bd.o((String)localObject1, localcd.mPL)))
      {
        y.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", new Object[] { Long.valueOf(localcd.ndp), Long.valueOf(((cs)localObject3).field_msgId) });
        bd.bC(((cs)localObject3).field_msgId);
        ((bi)localObject3).setMsgId(0L);
      }
      localObject2 = localObject3;
      if (((cs)localObject3).field_msgId == 0L)
      {
        localObject2 = new bi();
        ((bi)localObject2).bf(localcd.ndp);
        ((bi)localObject2).bg(bd.o((String)localObject1, localcd.mPL));
      }
      if (parama1.dQs != null)
      {
        ((bi)localObject2).ej(parama1.dQs.cQO);
        y.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", new Object[] { ((cs)localObject2).cQO });
      }
      ((bi)localObject2).setType(l.d(parama1));
      if (!((bi)localObject2).ctz()) {
        break label1671;
      }
      localObject3 = parama1.content;
      ((bi)localObject2).setContent((String)localObject3);
      if (((bi)localObject2).ctz()) {
        ((bi)localObject2).eh(parama1.cQF);
      }
      if ((localcd.svI != 2) || (((cs)localObject2).field_msgId != 0L)) {
        break label1993;
      }
      switch (((bi)localObject2).getType())
      {
      default: 
        j = 0;
        if (j == 0) {
          if (parama1.type == 2)
          {
            bool = true;
            label447:
            localObject3 = aa.a(localcd.svJ);
            if (ae.eSV)
            {
              y.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
              localObject3 = null;
            }
            if (bk.bE((byte[])localObject3)) {
              break label1706;
            }
            if ((parama1.type != 33) && (parama1.type != 36)) {
              break label1689;
            }
            localObject3 = o.OJ().a((byte[])localObject3, Bitmap.CompressFormat.PNG);
            label512:
            if (bk.bl((String)localObject3)) {
              y.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", new Object[] { ((cs)localObject2).field_content });
            }
            if (!bk.bl((String)localObject3))
            {
              ((bi)localObject2).ed((String)localObject3);
              y.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path" + (String)localObject3);
            }
            label578:
            if (i == 0) {
              break label2276;
            }
            ((bi)localObject2).fA(1);
            ((bi)localObject2).ec((String)localObject1);
            i = localcd.hQq;
            label603:
            ((bi)localObject2).setStatus(i);
            if ((parama1.type == 2001) && (parama1.showType == 1))
            {
              if ((TextUtils.isEmpty(parama1.dSl)) || (TextUtils.isEmpty(parama1.dSm)) || (parama1.dSn <= 0)) {
                break label2314;
              }
              y.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
              localObject1 = new com.tencent.mm.h.a.ak();
              ((com.tencent.mm.h.a.ak)localObject1).bGz = new ak.a();
              ((com.tencent.mm.h.a.ak)localObject1).bGz.bGB = parama1.dSm;
              ((com.tencent.mm.h.a.ak)localObject1).bGz.bGA = parama1.dSl;
              ((com.tencent.mm.h.a.ak)localObject1).bGz.bGC = parama1.dSn;
              com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
            }
            label729:
            if (parama1.type != 2001) {
              break;
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
        if (bk.dk(parama1.dSx)) {
          continue;
        }
        localObject1 = parama1.dSx.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = ((String)((Iterator)localObject1).next()).split(",");
          if ((localObject3 == null) || (localObject3.length <= 0)) {
            continue;
          }
          localObject3 = localObject3[0];
          if ((bk.bl((String)localObject3)) || (!((String)localObject3).equals(q.Gj()))) {
            continue;
          }
          ((bi)localObject2).fJ(((cs)localObject2).field_flag | 0x8);
          y.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
          r(true, ((cs)localObject2).field_talker);
        }
      }
      catch (Exception localException)
      {
        long l1;
        long l2;
        label1652:
        String str3;
        label1671:
        label1689:
        label1706:
        com.tencent.mm.as.a.a locala;
        String str4;
        c.a locala1;
        label1993:
        label2276:
        y.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", new Object[] { localException.getMessage() });
        label2314:
        continue;
        localg.b(localcd.ndp, (bi)localObject2);
        parama = new e.b((bi)localObject2, false);
        continue;
      }
      y.i("MicroMsg.AppMessageExtension", "paymsgid: %s", new Object[] { parama1.dSk });
      ((bi)localObject2).cY(localcd.svK);
      if (localb != null)
      {
        ((bi)localObject2).ei(localb.dWA);
        ((bi)localObject2).eg(localb.dWz);
      }
      bd.a((bi)localObject2, parama);
      if (((cs)localObject2).field_msgId != 0L) {
        continue;
      }
      ((bi)localObject2).setMsgId(bd.h((bi)localObject2));
      parama = new r();
      parama.bFG.bFH = ((bi)localObject2);
      parama.bFG.bFI = parama1;
      com.tencent.mm.sdk.b.a.udP.m(parama);
      parama = new e.b((bi)localObject2, true);
      if ((((bi)localObject2).getType() == 301989937) && (s.hO(((cs)localObject2).field_talker))) {
        ((bi)localObject2).setMsgId(0L);
      }
      if ((((bi)localObject2).cvl()) && ("notifymessage".equals(((cs)localObject2).field_talker)))
      {
        localObject1 = bn.s(((cs)localObject2).field_content, "msg");
        if (localObject1 != null)
        {
          localObject1 = bk.pm((String)((Map)localObject1).get(".msg.fromusername"));
          if (ad.gr((String)localObject1))
          {
            ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).b((String)localObject1, null);
            y.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", new Object[] { localObject1 });
          }
        }
      }
      if (((bi)localObject2).getType() == 536870961)
      {
        localObject1 = (com.tencent.mm.ae.b)parama1.A(com.tencent.mm.ae.b.class);
        localObject3 = new mu();
        ((mu)localObject3).bWu.bWr = ((cs)localObject2).field_msgId;
        ((mu)localObject3).bWu.bWv = ((com.tencent.mm.ae.b)localObject1).bWt;
        ((mu)localObject3).bWu.bVV = paramString;
        if (((cs)localObject2).field_isSend == 1)
        {
          y.d("MicroMsg.AppMessageExtension", "fromuser: %s, touser: %s", new Object[] { str1, str2 });
          ((mu)localObject3).bWu.username = ((cs)localObject2).field_talker;
        }
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
        if (((mu)localObject3).bWu.bVV != null)
        {
          ((bi)localObject2).setContent(((mu)localObject3).bWu.bVV);
          localg.a(((cs)localObject2).field_msgId, (bi)localObject2);
        }
      }
      if ((!bk.bl(parama1.dSq)) && (((bi)localObject2).getType() == 436207665))
      {
        localObject1 = new ms();
        ((ms)localObject1).bWq.bWr = ((cs)localObject2).field_msgId;
        ((ms)localObject1).bWq.bVV = paramString;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      }
      if ((parama1.type == 2000) && (!bk.bl(parama1.dRH)))
      {
        paramString = new mw();
        paramString.bWx.bQR = parama1.dRH;
        paramString.bWx.bIt = ((cs)localObject2).field_msgId;
        paramString.bWx.bWy = parama1;
        com.tencent.mm.sdk.b.a.udP.m(paramString);
        r(false, ((cs)localObject2).field_talker);
      }
      parama1 = parama1.dTl;
      paramString = bk.aM((String)parama1.get(".msg.appmsg.ext_pay_info.pay_type"), "");
      if (((paramString.equals("wx_f2f")) || (paramString.equals("wx_md"))) && (parama.ecX))
      {
        l1 = ((cs)localObject2).field_createTime;
        l2 = bz.Is();
        y.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2) });
        localObject1 = new bv();
        i = bk.getInt((String)parama1.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
        localObject2 = bk.pm((String)parama1.get(".msg.appmsg.ext_pay_info.pay_feetype"));
        parama1 = bk.pm((String)parama1.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
        if ((i > 0) && (!bk.bl((String)localObject2)) && (!bk.bl(parama1)))
        {
          ((bv)localObject1).bHX.fee = i;
          ((bv)localObject1).bHX.bHY = ((String)localObject2);
          ((bv)localObject1).bHX.bHZ = parama1;
          ((bv)localObject1).bHX.bIa = paramString;
          ((bv)localObject1).bHX.brn = (l2 - l1);
          ((bv)localObject1).bHX.source = 0;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        }
      }
      return parama;
      i = 0;
      break;
      if (i != 0)
      {
        localObject1 = str2;
        break label111;
      }
      localObject1 = str1;
      break label111;
      localObject3 = paramString;
      break label352;
      j = 1;
      break label431;
      bool = false;
      break label447;
      localObject3 = a((byte[])localObject3, bool, ((bi)localObject2).cvp());
      break label512;
      if ((!bk.bl(parama1.dQL)) && (!bk.bl(parama1.dQS)))
      {
        a(((cs)localObject2).field_msgSvrId, (bi)localObject2, (String)localObject1, parama1.dQS, parama1.dQL, parama1.dQM, bool, parama1, "", false);
        break label578;
      }
      if (!bk.bl(parama1.thumburl))
      {
        y.d("MicroMsg.AppMessageExtension", "get cdn image " + parama1.thumburl);
        str3 = com.tencent.mm.a.g.o(bk.UY().getBytes());
        localObject3 = o.OJ().getFullPath(str3);
        o.OJ();
        str3 = com.tencent.mm.as.g.md(str3);
        locala = o.ON();
        str4 = parama1.thumburl;
        locala1 = new c.a();
        locala1.erh = ((String)localObject3);
        locala1.erf = true;
        locala.a(str4, null, locala1.OV());
        ((bi)localObject2).ed(str3);
        y.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path " + (String)localObject3);
        break label578;
      }
      if (bk.bl(parama1.dQC)) {
        break label578;
      }
      a(((cs)localObject2).field_msgSvrId, (bi)localObject2, (String)localObject1, parama1.dQI, parama1.dQC, parama1.dQD, bool, parama1, parama1.dQH, true);
      y.d("MicroMsg.AppMessageExtension", "get cdn image " + parama1.dQC);
      break label578;
      if (!bk.bl(parama1.thumburl))
      {
        y.d("MicroMsg.AppMessageExtension", "get cdn image " + parama1.thumburl);
        localObject3 = com.tencent.mm.a.g.o(bk.UY().getBytes());
        if (parama1.type == 2001) {
          localObject3 = com.tencent.mm.a.g.o(parama1.thumburl.getBytes());
        }
        str3 = o.OJ().getFullPath((String)localObject3);
        o.OJ();
        localObject3 = com.tencent.mm.as.g.md((String)localObject3);
        locala = o.ON();
        str4 = parama1.thumburl;
        locala1 = new c.a();
        locala1.erh = str3;
        locala1.erf = true;
        locala.a(str4, null, locala1.OV());
        ((bi)localObject2).ed((String)localObject3);
        y.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path " + str3);
        break label578;
      }
      if (bk.bl(parama1.dQC)) {
        break label578;
      }
      if (parama1.type == 2)
      {
        bool = true;
        a(((cs)localObject2).field_msgSvrId, (bi)localObject2, (String)localObject1, parama1.dQI, parama1.dQC, parama1.dQD, bool, parama1, parama1.dQH, true);
        y.d("MicroMsg.AppMessageExtension", "get cdn image " + parama1.dQC);
        break label578;
      }
      bool = false;
      continue;
      ((bi)localObject2).fA(0);
      ((bi)localObject2).ec((String)localObject1);
      if (localcd.hQq > 3)
      {
        i = localcd.hQq;
        break label603;
      }
      i = 3;
      break label603;
      y.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
      break label729;
      if (!"1001".equals(parama1.dSh))
      {
        localObject1 = new tx();
        ((tx)localObject1).cej.bVV = paramString;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        r(false, ((cs)localObject2).field_talker);
      }
    }
  }
  
  static String a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    return o.OJ().a(9, paramArrayOfByte, paramBoolean1, Bitmap.CompressFormat.PNG, paramBoolean2);
  }
  
  private boolean a(long paramLong, bi parambi, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean1, g.a parama, String paramString4, boolean paramBoolean2)
  {
    y.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", new Object[] { Long.valueOf(parambi.field_msgSvrId), paramString2, Integer.valueOf(paramInt), paramString3, paramString1, Boolean.valueOf(paramBoolean1) });
    long l = bk.UY();
    int i;
    com.tencent.mm.j.f localf;
    if (parama != null)
    {
      i = parama.type;
      parama = o.OJ().o(bk.UY(), "", "");
      localf = new com.tencent.mm.j.f();
      localf.field_mediaId = com.tencent.mm.ak.c.a("downappthumb", parambi.field_createTime, paramString1, String.valueOf(paramLong));
      localf.field_fullpath = parama;
      if (!paramBoolean2) {
        break label278;
      }
      localf.field_fileType = 19;
      localf.dlQ = paramString3;
      label157:
      localf.field_totalLen = paramInt;
      localf.field_aesKey = paramString2;
      localf.field_priority = com.tencent.mm.j.a.dll;
      localf.field_authKey = paramString4;
      if (!s.fn(paramString1)) {
        break label296;
      }
    }
    label278:
    label296:
    for (int j = 1;; j = 0)
    {
      localf.field_chattype = j;
      y.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", new Object[] { Integer.valueOf(localf.field_chattype), paramString1 });
      localf.dlP = new j.1(this, paramLong, paramString3, l, paramInt, paramString1, parama, i, paramBoolean1);
      com.tencent.mm.ak.f.Nd().b(localf, -1);
      return true;
      i = 0;
      break;
      localf.field_fileId = paramString3;
      localf.field_fileType = com.tencent.mm.j.a.MediaType_THUMBIMAGE;
      break label157;
    }
  }
  
  public static String fS(String paramString1, String paramString2)
  {
    if (bk.bl(paramString2)) {
      return null;
    }
    String str = paramString2;
    if (s.fn(paramString1))
    {
      int i = bd.iH(paramString2);
      str = paramString2;
      if (i != -1) {
        str = (paramString2 + " ").substring(i + 2).trim();
      }
    }
    return bk.ZQ(str);
  }
  
  private static void r(boolean paramBoolean, String paramString)
  {
    com.tencent.mm.storage.ak localak;
    if (!bk.bl(paramString))
    {
      y.i("MicroMsg.AppMessageExtension", "updateC2CAAMsgMark, mark: %s, talker: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
      au.Hx();
      localak = com.tencent.mm.model.c.FB().abv(paramString);
      if (localak != null)
      {
        if (!paramBoolean) {
          break label75;
        }
        localak.gT(16777216);
      }
    }
    for (;;)
    {
      au.Hx();
      com.tencent.mm.model.c.FB().a(localak, paramString);
      return;
      label75:
      localak.gU(16777216);
    }
  }
  
  public final void a(e.c paramc)
  {
    paramc = paramc.bWO;
    if (paramc == null) {
      y.e("MicroMsg.AppMessageExtension", "[onPreDelMessage] msg == null");
    }
    do
    {
      do
      {
        return;
        y.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + paramc.field_imgPath);
        sz localsz = new sz();
        localsz.ccA.path = paramc.field_imgPath;
        com.tencent.mm.sdk.b.a.udP.m(localsz);
        paramc = paramc.field_content;
      } while (paramc == null);
      paramc = g.a.gp(paramc);
    } while ((paramc == null) || (paramc.type != 6));
    com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.compatible.util.e.dzB + paramc.title);
    com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.compatible.util.e.dzB + paramc.title + "_tmp");
  }
  
  public final boolean a(j.a parama, String paramString1, long paramLong, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    String str = o.OJ().o("Note_" + paramString1, "", "");
    if (com.tencent.mm.vfs.e.bK(str)) {
      return false;
    }
    this.rUn = parama;
    com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
    localf.field_mediaId = com.tencent.mm.ak.c.a("downappthumb", paramLong, paramString4, paramString1);
    localf.field_fullpath = str;
    localf.field_fileType = com.tencent.mm.j.a.MediaType_FULLSIZEIMAGE;
    localf.field_totalLen = paramInt;
    localf.field_aesKey = paramString2;
    localf.field_fileId = paramString3;
    localf.field_priority = com.tencent.mm.j.a.dll;
    if (s.fn(paramString4)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localf.field_chattype = paramInt;
      y.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", new Object[] { Integer.valueOf(localf.field_chattype), paramString4 });
      localf.dlP = new j.2(this, paramString3, parama);
      com.tencent.mm.ak.f.Nd().b(localf, -1);
      return true;
    }
  }
  
  public final e.b b(e.a parama)
  {
    y.d("MicroMsg.AppMessageExtension", "process add app message");
    Object localObject3 = parama.dBs;
    Object localObject1 = aa.a(((cd)localObject3).svF);
    Object localObject2 = aa.a(((cd)localObject3).svG);
    g.a locala;
    if ((bk.bl((String)localObject1)) || (bk.bl((String)localObject2)))
    {
      y.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
      localObject1 = null;
      locala = g.a.gp((String)localObject1);
      if (locala != null) {
        break label95;
      }
      y.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
    }
    label95:
    do
    {
      return null;
      localObject1 = fS((String)localObject1, aa.a(((cd)localObject3).svH));
      break;
      if (locala.dSo)
      {
        au.Hx();
        com.tencent.mm.model.c.Dz().o(352273, localObject1);
        au.Hx();
        com.tencent.mm.model.c.Dz().o(352274, Long.valueOf(System.currentTimeMillis()));
        new a((String)localObject1).ckM();
        return null;
      }
      f localf = ap.brn().VU(locala.appId);
      String str = locala.appId;
      int i = locala.cau;
      if (localf == null) {}
      for (localObject2 = "null";; localObject2 = Integer.valueOf(localf.field_appVersion))
      {
        y.i("MicroMsg.AppMessageExtension", "check version appid:%s, msgVer:%d, appVer:%s", new Object[] { str, Integer.valueOf(i), localObject2 });
        if ((localf == null) || (localf.field_appVersion < locala.cau)) {
          ap.brm().VS(locala.appId);
        }
        parama = a(parama, aa.a(((cd)localObject3).svH), locala);
        if (parama.bFH == null) {
          break;
        }
        localObject2 = parama.bFH;
        if (!((bi)localObject2).ctz()) {
          break label334;
        }
        if (!bk.bl(locala.dTi))
        {
          localObject1 = new ug();
          ((ug)localObject1).ceK.bUr = locala.dTi;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        }
        return parama;
      }
      if (((bi)localObject2).getType() == 301989937) {
        return parama;
      }
      if (((bi)localObject2).getType() == -1879048190)
      {
        localObject3 = new ta();
        ((ta)localObject3).ccB.bUr = ((String)localObject1);
        ((ta)localObject3).ccB.description = locala.description;
        ((ta)localObject3).ccB.bFH = ((bi)localObject2);
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
      }
      if ((((bi)localObject2).getType() == 49) && (!bk.bl(locala.canvasPageXml)))
      {
        localObject3 = new com.tencent.mm.h.a.f();
        ((com.tencent.mm.h.a.f)localObject3).bEV.bEW = locala.canvasPageXml;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
      }
      localObject3 = new com.tencent.mm.ae.g();
      locala.a((com.tencent.mm.ae.g)localObject3);
      ((com.tencent.mm.ae.g)localObject3).field_msgId = ((cs)localObject2).field_msgId;
    } while ((ap.clc().gZ(((cs)localObject2).field_msgId) != null) || (!ap.clc().b((com.tencent.mm.sdk.e.c)localObject3)));
    label334:
    if (locala.type == 40)
    {
      localObject3 = ap.avh().gY(((cs)localObject2).field_msgId);
      localObject1 = com.tencent.mm.ae.k.gv((String)localObject1);
      if (localObject3 == null) {
        l.a(null, ((cs)localObject2).field_msgId, 0, null, null, ((com.tencent.mm.ae.k)localObject1).dTz, locala.type, 0);
      }
      localObject1 = new ac(((cs)localObject2).field_msgId, ((cs)localObject2).field_msgSvrId, null);
      au.Dk().a((m)localObject1, 0);
    }
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.j
 * JD-Core Version:    0.7.0.1
 */