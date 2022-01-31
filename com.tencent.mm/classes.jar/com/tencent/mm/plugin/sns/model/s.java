package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.mz;
import com.tencent.mm.h.a.qp;
import com.tencent.mm.h.a.qq;
import com.tencent.mm.h.a.um;
import com.tencent.mm.h.a.um.a;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.auf;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.awb;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.awg;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bsz;
import com.tencent.mm.protocal.c.btj;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bty;
import com.tencent.mm.protocal.c.btz;
import com.tencent.mm.protocal.c.bua;
import com.tencent.mm.protocal.c.bud;
import com.tencent.mm.protocal.c.bvm;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.protocal.c.bvz;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.bzd;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.ls;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class s
  extends m
  implements k
{
  int dFZ = 0;
  private com.tencent.mm.sdk.b.c dGc = new s.2(this);
  private com.tencent.mm.sdk.b.c dGd = new s.3(this);
  private com.tencent.mm.ah.b dmK;
  public com.tencent.mm.ah.f dmL;
  boolean dpW = false;
  int onc;
  private bxk oqf;
  private bxk oqg;
  long oqh = 0L;
  private int oqi = 0;
  private um oqj;
  int oqk;
  String oql = "";
  HashMap<String, awd> oqm = new HashMap();
  HashMap<String, Integer> oqn = new HashMap();
  String oqo = "";
  
  public s(String paramString1, int paramInt1, int paramInt2, List<String> paramList, bxk parambxk, int paramInt3, String paramString2, int paramInt4, LinkedList<Long> paramLinkedList, int paramInt5, awe paramawe, boolean paramBoolean, LinkedList<bml> paramLinkedList1, bty parambty, com.tencent.mm.bv.b paramb, String paramString3)
  {
    this.oqf = parambxk;
    this.onc = paramInt3;
    this.oqk = paramInt5;
    localObject1 = new b.a();
    ((b.a)localObject1).ecH = new btz();
    ((b.a)localObject1).ecI = new bua();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnspost";
    ((b.a)localObject1).ecG = 209;
    ((b.a)localObject1).ecJ = 97;
    ((b.a)localObject1).ecK = 1000000097;
    this.dmK = ((b.a)localObject1).Kt();
    btz localbtz = (btz)this.dmK.ecE.ecN;
    if (!TextUtils.isEmpty(parambxk.ouC.sug.sub))
    {
      localObject1 = new ls();
      ((ls)localObject1).sHm = parambxk.ouC.sug.sub;
      localbtz.tKI = ((ls)localObject1);
    }
    localObject1 = u.Hc().ii(paramawe.bIB);
    Object localObject2;
    if (localObject1 != null)
    {
      this.oqj = new um();
      this.oqj.ceR.ceS = ((u.b)localObject1).getString("prePublishId", "");
      this.oqj.ceR.url = ((u.b)localObject1).getString("url", "");
      this.oqj.ceR.ceU = ((u.b)localObject1).getString("preUsername", "");
      this.oqj.ceR.ceV = ((u.b)localObject1).getString("preChatName", "");
      this.oqj.ceR.ceW = ((u.b)localObject1).getInt("preMsgIndex", 0);
      this.oqj.ceR.cfa = ((u.b)localObject1).getInt("sendAppMsgScene", 0);
      this.oqj.ceR.cfb = ((u.b)localObject1).getInt("getA8KeyScene", 0);
      this.oqj.ceR.cfc = ((u.b)localObject1).getString("referUrl", null);
      this.oqj.ceR.cfd = ((u.b)localObject1).getString("adExtStr", null);
      this.oqj.ceR.cfe = paramString3;
      localObject1 = "";
      paramString3 = (String)localObject1;
      if (parambxk.oPO != null)
      {
        localObject2 = new bvo();
        paramString3 = Base64.decode(parambxk.oPO, 0);
      }
    }
    try
    {
      ((bvo)localObject2).aH(paramString3);
      paramString3 = (String)localObject1;
      if (((bvo)localObject2).tMo != null) {
        paramString3 = ((bvo)localObject2).tMo.kOK;
      }
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        int i;
        int j;
        paramString3 = (String)localObject1;
      }
    }
    localObject1 = paramString3;
    if (bk.bl(paramString3))
    {
      localObject1 = paramString3;
      if (parambxk.tNq != null) {
        localObject1 = parambxk.tNq.lsK;
      }
    }
    localbtz.tKH = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.oqj.ceR.ceS, this.oqj.ceR.ceU, this.oqj.ceR.ceV, Integer.valueOf(t.R(this.oqj.ceR.ceU, this.oqj.ceR.ceV)), Integer.valueOf(this.oqj.ceR.cfb), localObject1 });
    paramString3 = new bmk();
    paramString3.bs(paramString1.getBytes());
    i = paramString1.length();
    j = paramString3.tFK;
    if (paramb == null) {}
    for (paramInt3 = 0;; paramInt3 = paramb.oY.length)
    {
      y.i("MicroMsg.NetSceneSnsPost", "len:%d   skb:%d ctx.len:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt3) });
      localbtz.tJU = paramString3;
      localbtz.tKC = paramInt1;
      localbtz.tsm = paramInt2;
      localbtz.nde = paramString2;
      this.oqi = paramInt1;
      if (ae.eSr)
      {
        localbtz.tJU = new bmk();
        y.e("MicroMsg.NetSceneSnsPost", "post error setObjectDesc is null!");
      }
      paramString3 = new LinkedList();
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label931;
      }
      paramList = paramList.iterator();
      for (paramString1 = ""; paramList.hasNext(); paramString1 = paramString1 + "; + " + (String)localObject1)
      {
        localObject1 = (String)paramList.next();
        localObject2 = new bml();
        ((bml)localObject2).YI((String)localObject1);
        paramString3.add(localObject2);
      }
    }
    y.d("MicroMsg.NetSceneSnsPost", "post with list : " + paramString1);
    label931:
    localbtz.tKe = paramString3;
    localbtz.tKd = paramString3.size();
    localbtz.tKD = paramInt4;
    paramString1 = localbtz.tKH;
    if (paramawe.tsE != null)
    {
      paramInt1 = paramawe.tsE.tJG;
      y.i("MicroMsg.NetSceneSnsPost", "setObjectSource: %d, clientid:%s fromScene:%s, score:%d", new Object[] { Integer.valueOf(paramInt5), paramString2, paramString1, Integer.valueOf(paramInt1) });
      if ((paramLinkedList1 != null) && (paramLinkedList1.size() > 0))
      {
        if (!paramBoolean) {
          break label1211;
        }
        localbtz.tKj = paramLinkedList1;
        localbtz.tKi = paramLinkedList1.size();
      }
    }
    for (;;)
    {
      y.d("MicroMsg.NetSceneSnsPost", "setObjectSource " + paramInt5);
      localbtz.tKE = paramInt5;
      paramString1 = new bzd();
      if (!bk.bl(paramawe.token))
      {
        paramString1.tPj = paramawe.token;
        paramString1.tPk = paramawe.tsv;
        localbtz.tzP = paramString1;
      }
      if ((paramLinkedList == null) || (paramLinkedList.isEmpty())) {
        break label1275;
      }
      localbtz.tuG = paramLinkedList.size();
      paramString1 = paramLinkedList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (Long)paramString1.next();
        paramString2 = new btj();
        paramString2.tJS = paramList.longValue();
        localbtz.tss.add(paramString2);
      }
      paramInt1 = 0;
      break;
      label1211:
      localbtz.tsx = paramLinkedList1;
      localbtz.tKk = paramLinkedList1.size();
    }
    y.d("MicroMsg.NetSceneSnsPost", "tagid " + paramLinkedList.size() + " " + localbtz.tss.toString());
    label1275:
    localbtz.tsy = parambty;
    if (!bk.bl(paramawe.tsA)) {
      localbtz.tKm = new bud();
    }
    if (parambty != null) {
      y.d("MicroMsg.NetSceneSnsPost", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { parambty.swU, parambty.swV, parambty.swW });
    }
    if (paramb != null) {
      localbtz.tKG = new bmk().b(paramb);
    }
    localbtz.tKL = paramawe.tsE;
    paramString1 = af.bDF().yt(this.onc);
    if ((paramString1 != null) && ((paramString1.field_type == 1) || (paramString1.field_type == 15)) && (parambxk.tNr != null) && (parambxk.tNr.sPJ != null) && (parambxk.tNr.sPJ.size() > 0) && (paramawe.tsn != null) && (paramawe.tsn.size() == parambxk.tNr.sPJ.size()))
    {
      paramString1 = af.getAccSnsPath();
      paramList = parambxk.tNr.sPJ.iterator();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramList.hasNext())
      {
        paramLinkedList = (awd)paramList.next();
        if ((paramLinkedList.hQR == 2) || (paramLinkedList.hQR == 6))
        {
          parambxk = new awb();
          if (paramLinkedList.hQR != 2) {
            break label1755;
          }
          paramInt2 = 2;
          label1554:
          parambxk.kVG = paramInt2;
          if (paramLinkedList.hQR == 6)
          {
            paramString2 = an.eJ(paramString1, paramLinkedList.lsK);
            paramLinkedList = com.tencent.mm.plugin.sns.data.i.p(paramLinkedList);
            paramString2 = com.tencent.mm.plugin.sight.base.d.MH(paramString2 + paramLinkedList);
            if (paramString2 != null) {
              parambxk.trL = ((int)Math.round(paramString2.jlu / 1000.0D));
            }
          }
          paramString2 = (auf)paramawe.tsn.get(paramInt1);
          paramString2 = af.bDu().gu(paramString2.tpH);
        }
      }
      try
      {
        parambxk.swS = ((awg)new awg().aH(paramString2.oLV)).tsQ;
        label1691:
        y.i("MicroMsg.NetSceneSnsPost", "post add mediaInfo, Source: %s, videoPlayLength: %s, MediaType: %s", new Object[] { Integer.valueOf(parambxk.swS), Integer.valueOf(parambxk.trL), Integer.valueOf(parambxk.kVG) });
        localbtz.tKK.add(parambxk);
        paramInt1 += 1;
        continue;
        label1755:
        paramInt2 = 1;
        break label1554;
        localbtz.tKJ = localbtz.tKK.size();
        y.i("MicroMsg.NetSceneSnsPost", "post mediaCount: %s", new Object[] { Integer.valueOf(localbtz.tKJ) });
        localbtz.tpt = new bmk().bs(com.tencent.mm.plugin.normsg.a.b.mGK.boP());
        return;
      }
      catch (Exception paramString2)
      {
        break label1691;
      }
    }
  }
  
  private void Nw(String paramString)
  {
    this.oqo = paramString;
    paramString = com.tencent.mm.model.c.c.IX().fJ("100132");
    if (paramString.isValid()) {
      this.dFZ = bk.getInt((String)paramString.ctr().get("needUploadData"), 1);
    }
    if ((this.oqk != 12) && (this.dFZ == 0)) {}
    for (;;)
    {
      return;
      if ((this.oqg != null) && (this.oqg.tNr != null) && (this.oqg.tNr.sPJ != null) && (this.oqg.tNr.sPJ.size() > 0))
      {
        paramString = this.oqg.tNr.sPJ;
        com.tencent.mm.sdk.b.a.udP.c(this.dGc);
        com.tencent.mm.sdk.b.a.udP.c(this.dGd);
        paramString = paramString.iterator();
        int i = 0;
        while (paramString.hasNext())
        {
          Object localObject = (awd)paramString.next();
          if (((awd)localObject).hQR == 2)
          {
            String str = g.C((awd)localObject);
            if (!bk.bl(str))
            {
              this.oqn.put(str, Integer.valueOf(i));
              this.oqm.put(str, localObject);
              localObject = new mz();
              ((mz)localObject).bWF.filePath = str;
              com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
              i += 1;
            }
          }
        }
      }
    }
  }
  
  private static boolean a(bxk parambxk1, bxk parambxk2)
  {
    if ((parambxk1 == null) || (parambxk2 == null) || (parambxk1.tNr == null) || (parambxk2.tNr == null)) {
      return false;
    }
    String str1 = af.getAccSnsPath();
    int i = 0;
    while ((i < parambxk1.tNr.sPJ.size()) && (i < parambxk2.tNr.sPJ.size()))
    {
      Object localObject2 = (awd)parambxk1.tNr.sPJ.get(i);
      Object localObject1 = (awd)parambxk2.tNr.sPJ.get(i);
      String str2 = com.tencent.mm.plugin.sns.data.i.m((awd)localObject2);
      String str3 = com.tencent.mm.plugin.sns.data.i.n((awd)localObject2);
      String str4 = com.tencent.mm.plugin.sns.data.i.o((awd)localObject2);
      String str5 = com.tencent.mm.plugin.sns.data.i.p((awd)localObject2);
      String str6 = com.tencent.mm.plugin.sns.data.i.l((awd)localObject1);
      String str7 = com.tencent.mm.plugin.sns.data.i.e((awd)localObject1);
      String str8 = com.tencent.mm.plugin.sns.data.i.f((awd)localObject1);
      String str9 = com.tencent.mm.plugin.sns.data.i.j((awd)localObject1);
      y.d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + str2 + "  - " + str6);
      localObject2 = an.eJ(str1, ((awd)localObject2).lsK);
      localObject1 = an.eJ(str1, ((awd)localObject1).lsK);
      com.tencent.mm.vfs.e.nb((String)localObject1);
      com.tencent.mm.vfs.e.aA((String)localObject2 + str2, (String)localObject1 + str6);
      com.tencent.mm.vfs.e.aA((String)localObject2 + str3, (String)localObject1 + str7);
      com.tencent.mm.vfs.e.aA((String)localObject2 + str4, (String)localObject1 + str8);
      if (com.tencent.mm.vfs.e.bK((String)localObject2 + str5))
      {
        y.i("MicroMsg.NetSceneSnsPost", "post done copy file %s", new Object[] { (String)localObject1 + str9 });
        com.tencent.mm.vfs.e.aA((String)localObject2 + str5, (String)localObject1 + str9);
      }
      i += 1;
    }
    return true;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneSnsPost", "post netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    Object localObject1 = (bua)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    if (paramInt2 == 4) {
      paramq = af.bDF().yt(this.onc);
    }
    try
    {
      paramArrayOfByte = (awe)new awe().aH(paramq.field_postBuf);
      paramArrayOfByte.tsu = paramInt3;
      paramArrayOfByte.tsC = ((bua)localObject1).tsC;
      paramArrayOfByte.tsD = false;
      paramq.field_postBuf = paramArrayOfByte.toByteArray();
      label139:
      if (paramq != null)
      {
        paramq.bGI();
        af.bDF().b(this.onc, paramq);
        af.bDE().xI(this.onc);
        y.d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + paramq.bGE());
        paramq = new qp();
        paramq.bZS.bZT = this.onc;
        com.tencent.mm.sdk.b.a.udP.m(paramq);
      }
      if ((this.oqf != null) && (this.oqf.tNr != null) && (this.oqf.tNr.sPI == 21))
      {
        com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(8);
        switch (paramInt3)
        {
        default: 
          com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(20);
        }
      }
      for (;;)
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(17);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(19);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(18);
      }
      if (paramInt3 != 0)
      {
        af.bDE().xI(this.onc);
        if ((this.oqf != null) && (this.oqf.tNr != null) && (this.oqf.tNr.sPI == 21))
        {
          com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(8);
          com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(16);
        }
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      if ((((bua)localObject1).tJi == null) || (((bua)localObject1).tJi.tJU == null) || (((bua)localObject1).tJi.tJU.tFM == null))
      {
        y.e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
        af.bDE().xI(this.onc);
        paramq = af.bDF().yt(this.onc);
        paramq.bGH();
        af.bDF().b(this.onc, paramq);
        paramq = new qq();
        paramq.bZU.bZT = this.onc;
        com.tencent.mm.sdk.b.a.udP.m(paramq);
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      Object localObject2 = new String(((bua)localObject1).tJi.tJU.tFM.toByteArray());
      if (this.oqi == 0) {
        y.d("MicroMsg.NetSceneSnsPost", "resp " + (String)localObject2 + "  ");
      }
      this.oqg = com.tencent.mm.modelsns.e.nn((String)localObject2);
      if (this.oqg.tNw != null)
      {
        paramq = this.oqg.lsK;
        paramArrayOfByte = this.oqg.tNw.dSW;
        String str = this.oqg.tNw.dSV;
        com.tencent.mm.modelsns.d locald = new com.tencent.mm.modelsns.d();
        locald.j("20CurrPublishId", paramq + ",");
        locald.j("20SourcePublishId", paramArrayOfByte + ",");
        locald.j("20SourceAdUxInfo", str + ",");
        y.i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + locald.uJ());
        com.tencent.mm.plugin.report.service.h.nFQ.f(13004, new Object[] { locald });
      }
      paramArrayOfByte = af.bDF().yt(this.onc);
      paramq = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        y.e("MicroMsg.NetSceneSnsPost", "the item has delete");
        paramq = new com.tencent.mm.plugin.sns.storage.n();
      }
      paramq.iB(((bua)localObject1).tJi.mPL);
      paramq.Oz((String)localObject2);
      paramq.field_localFlag &= 0xFFFFFFEF;
      paramq.gp(((bua)localObject1).tJi.sGd);
      paramq.gr(((bua)localObject1).tJi.sGd);
      if ((((bua)localObject1).tJi.ttI & 0x1) > 0) {
        paramq.bGB();
      }
      this.oqh = ((bua)localObject1).tJi.sGd;
      if (this.oqj != null)
      {
        this.oqj.ceR.ceT = ("sns_" + com.tencent.mm.plugin.sns.data.i.fN(this.oqh));
        com.tencent.mm.sdk.b.a.udP.m(this.oqj);
      }
      localObject2 = ((bua)localObject1).tJi;
      ((bto)localObject2).tJU.bs(new byte[0]);
      try
      {
        if ((((bto)localObject2).tKa == 0) && (((bto)localObject2).tJX == 0) && (((bto)localObject2).tKd == 0) && (((bto)localObject2).tuG == 0)) {
          y.d("MicroMsg.NetSceneSnsPost", "no use! this buf");
        }
        for (;;)
        {
          paramq.bGH();
          af.bDF().b(this.onc, paramq);
          af.bDE().xI(this.onc);
          if (((this.oqf.tNr.sPI == 1) && (this.oqf.cCu == 0) && (this.oqg.cCu == 1)) || ((this.oqf.tNr.sPI == 15) && (this.oqf.tNy == 0) && (this.oqg.tNy == 1) && (com.tencent.mm.plugin.sns.storage.i.gm(v.OU(paramq.bGk()))))) {
            new ah(Looper.getMainLooper()).post(new s.1(this));
          }
          paramArrayOfByte = com.tencent.mm.plugin.sns.h.f.ozP.bD(Integer.valueOf(this.onc));
          if ((paramArrayOfByte != null) && (this.oqg != null))
          {
            paramArrayOfByte.QU();
            paramArrayOfByte.QV();
            paramArrayOfByte.nk(this.oqg.lsK);
            paramArrayOfByte.jg(this.oqg.tNr.sPI);
            paramArrayOfByte.QX();
          }
          paramArrayOfByte = com.tencent.mm.plugin.sns.h.g.ozP.bD(Integer.valueOf(this.onc));
          if ((paramArrayOfByte != null) && (this.oqg != null))
          {
            paramArrayOfByte.QU();
            paramArrayOfByte.QV();
            paramArrayOfByte.nk(this.oqg.lsK);
            paramArrayOfByte.jg(this.oqg.tNr.sPI);
            paramArrayOfByte.QX();
          }
          paramArrayOfByte = new qq();
          paramArrayOfByte.bZU.bZT = this.onc;
          com.tencent.mm.sdk.b.a.udP.m(paramArrayOfByte);
          if (paramq.field_type == 21)
          {
            if (paramq.field_pravited != 1) {
              paramInt1 = ((bua)localObject1).tJi.ttI;
            }
            com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(7);
            paramArrayOfByte = this.oqg.lsK;
            System.currentTimeMillis();
          }
          a(this.oqf, this.oqg);
          if (this.oqg != null) {
            break;
          }
          paramArrayOfByte = "";
          Nw(paramArrayOfByte);
          if (af.bDB() != null) {
            af.bDB().bCp();
          }
          try
          {
            if (paramq.field_type == 15)
            {
              localObject1 = (awd)this.oqg.tNr.sPJ.get(0);
              if (localObject1 != null)
              {
                paramq = an.eJ(af.getAccSnsPath(), ((awd)localObject1).lsK) + com.tencent.mm.plugin.sns.data.i.j((awd)localObject1);
                paramArrayOfByte = com.tencent.mm.modelvideo.n.Sp();
                localObject1 = ((awd)localObject1).kSC;
                l = ((bto)localObject2).sGd;
                if (!bk.bl((String)localObject1))
                {
                  boolean bool = bk.bl(paramq);
                  if (!bool) {
                    break label1610;
                  }
                }
              }
            }
          }
          catch (Exception paramq)
          {
            long l;
            label1551:
            break label1551;
          }
          this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
          return;
          paramq.aL(((bto)localObject2).toByteArray());
        }
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.NetSceneSnsPost", paramArrayOfByte, "", new Object[0]);
          continue;
          paramArrayOfByte = this.oqg.tNo;
          continue;
          label1610:
          localObject2 = ((String)localObject1).hashCode();
          y.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", new Object[] { localObject2, localObject1, Long.valueOf(l), paramq });
          localObject1 = (n.a)paramArrayOfByte.eGQ.get(localObject2);
          if (localObject1 != null)
          {
            ((n.a)localObject1).eHf = String.valueOf(l);
            ((n.a)localObject1).eHe = paramq;
            paramArrayOfByte.a(((n.a)localObject1).eGu, (String)localObject2);
          }
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      break label139;
    }
  }
  
  public final int getType()
  {
    return 209;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.s
 * JD-Core Version:    0.7.0.1
 */