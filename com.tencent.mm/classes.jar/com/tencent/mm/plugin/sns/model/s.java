package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qe.a;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.qf.a;
import com.tencent.mm.g.a.uz;
import com.tencent.mm.g.a.va;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.g.a.zq;
import com.tencent.mm.g.a.zq.a;
import com.tencent.mm.g.a.zr;
import com.tencent.mm.g.a.zr.a;
import com.tencent.mm.g.b.a.gn;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bwe;
import com.tencent.mm.protocal.protobuf.bzf;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.bzk;
import com.tencent.mm.protocal.protobuf.cgs;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dgd;
import com.tencent.mm.protocal.protobuf.dgp;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.protocal.protobuf.dhe;
import com.tencent.mm.protocal.protobuf.dhf;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.protocal.protobuf.dja;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dqz;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.so;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class s
  extends com.tencent.mm.ak.n
  implements k
{
  public f callback;
  int dKr;
  boolean fTh;
  int gzC;
  private com.tencent.mm.sdk.b.c gzF;
  private com.tencent.mm.sdk.b.c gzG;
  private com.tencent.mm.ak.b rr;
  long zry;
  private TimeLineObject zyo;
  private TimeLineObject zyp;
  private int zyq;
  private zq zyr;
  private zr zys;
  int zyt;
  private HashMap<Integer, Integer> zyu;
  String zyv;
  HashMap<String, bzh> zyw;
  HashMap<String, Integer> zyx;
  String zyy;
  
  public s(String paramString1, int paramInt1, int paramInt2, List<String> paramList, TimeLineObject paramTimeLineObject, int paramInt3, String paramString2, int paramInt4, LinkedList<Long> paramLinkedList, int paramInt5, bzi parambzi, boolean paramBoolean, LinkedList<cxn> paramLinkedList1, dhd paramdhd, com.tencent.mm.bw.b paramb, String paramString3, int paramInt6, String paramString4)
  {
    AppMethodBeat.i(95612);
    this.zry = 0L;
    this.fTh = false;
    this.zyq = 0;
    this.zyu = new HashMap();
    this.gzC = 0;
    this.zyv = "";
    this.zyw = new HashMap();
    this.zyx = new HashMap();
    this.zyy = "";
    this.gzF = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(qf paramAnonymousqf)
      {
        AppMethodBeat.i(95608);
        if (!s.this.zyx.containsKey(paramAnonymousqf.dFM.filePath))
        {
          AppMethodBeat.o(95608);
          return false;
        }
        int i = ((Integer)s.this.zyx.remove(paramAnonymousqf.dFM.filePath)).intValue();
        try
        {
          str1 = URLEncoder.encode(paramAnonymousqf.dFM.result, "UTF-8");
          if (s.this.gzC != 0)
          {
            bzh localbzh = (bzh)s.this.zyw.get(paramAnonymousqf.dFM.filePath);
            s.this.zyv += String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s&codeType=%d|", new Object[] { Integer.valueOf(i), str1, localbzh.Hmx, localbzh.Url, Integer.valueOf(paramAnonymousqf.dFM.dov) });
          }
          if (s.this.zyt == 12)
          {
            str1 = "2,3,,".concat(String.valueOf(str1));
            paramAnonymousqf = str1;
            if (i != 0) {}
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          try
          {
            String str1;
            paramAnonymousqf = str1 + "," + URLEncoder.encode(s.this.zyy, "UTF-8");
            ae.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(i), paramAnonymousqf });
            com.tencent.mm.plugin.report.service.g.yxI.kvStat(13717, paramAnonymousqf);
            s.a(s.this);
            AppMethodBeat.o(95608);
            return false;
            localUnsupportedEncodingException = localUnsupportedEncodingException;
            ae.printErrStackTrace("MicroMsg.NetSceneSnsPost", localUnsupportedEncodingException, "", new Object[0]);
            str2 = "";
          }
          catch (UnsupportedEncodingException paramAnonymousqf)
          {
            for (;;)
            {
              String str2;
              ae.e("MicroMsg.NetSceneSnsPost", "", new Object[] { paramAnonymousqf.getMessage() });
              paramAnonymousqf = str2;
            }
          }
        }
      }
    };
    this.gzG = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(qe paramAnonymousqe)
      {
        AppMethodBeat.i(95610);
        if (!s.this.zyx.containsKey(paramAnonymousqe.dFL.filePath))
        {
          AppMethodBeat.o(95610);
          return false;
        }
        paramAnonymousqe = (Integer)s.this.zyx.remove(paramAnonymousqe.dFL.filePath);
        if (paramAnonymousqe == null)
        {
          AppMethodBeat.o(95610);
          return false;
        }
        int i = paramAnonymousqe.intValue();
        String str;
        if (s.this.zyt == 12)
        {
          str = "2,3,,";
          paramAnonymousqe = str;
          if (i != 0) {}
        }
        try
        {
          paramAnonymousqe = "2,3,," + "," + URLEncoder.encode(s.this.zyy, "UTF-8");
          ae.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(i), paramAnonymousqe });
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(13717, paramAnonymousqe);
          s.a(s.this);
          AppMethodBeat.o(95610);
          return false;
        }
        catch (UnsupportedEncodingException paramAnonymousqe)
        {
          for (;;)
          {
            ae.e("MicroMsg.NetSceneSnsPost", "", new Object[] { paramAnonymousqe.getMessage() });
            paramAnonymousqe = str;
          }
        }
      }
    };
    this.zyo = paramTimeLineObject;
    this.dKr = paramInt3;
    this.zyt = paramInt5;
    localObject1 = new b.a();
    ((b.a)localObject1).hQF = new dhe();
    ((b.a)localObject1).hQG = new dhf();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnspost";
    ((b.a)localObject1).funcId = 209;
    ((b.a)localObject1).hQH = 97;
    ((b.a)localObject1).respCmdId = 1000000097;
    this.rr = ((b.a)localObject1).aDS();
    dhe localdhe = (dhe)this.rr.hQD.hQJ;
    if (!TextUtils.isEmpty(paramTimeLineObject.zFf.FKW.FKR))
    {
      localObject1 = new so();
      ((so)localObject1).GhA = paramTimeLineObject.zFf.FKW.FKR;
      localdhe.HOm = ((so)localObject1);
    }
    localObject1 = z.aBG().Bq(parambzi.sessionId);
    Object localObject2;
    if (localObject1 != null)
    {
      this.zyr = new zq();
      this.zyr.dPK.dPL = ((z.b)localObject1).getString("prePublishId", "");
      this.zyr.dPK.url = ((z.b)localObject1).getString("url", "");
      this.zyr.dPK.dPN = ((z.b)localObject1).getString("preUsername", "");
      this.zyr.dPK.dPO = ((z.b)localObject1).getString("preChatName", "");
      this.zyr.dPK.dPP = ((z.b)localObject1).getInt("preMsgIndex", 0);
      this.zyr.dPK.dPT = ((z.b)localObject1).getInt("sendAppMsgScene", 0);
      this.zyr.dPK.dPU = ((z.b)localObject1).getInt("getA8KeyScene", 0);
      this.zyr.dPK.dPV = ((z.b)localObject1).getString("referUrl", null);
      this.zyr.dPK.dPW = ((z.b)localObject1).getString("adExtStr", null);
      this.zyr.dPK.dPX = paramString3;
      if (((z.b)localObject1).containsKey("_tmpl_webview_transfer_scene"))
      {
        this.zys = new zr();
        this.zys.dQa.dQb = ((z.b)localObject1).getInt("_tmpl_webview_transfer_scene", -1);
      }
      localObject1 = "";
      paramString3 = (String)localObject1;
      if (paramTimeLineObject.AiG != null)
      {
        localObject2 = new djc();
        paramString3 = Base64.decode(paramTimeLineObject.AiG, 0);
      }
    }
    try
    {
      ((djc)localObject2).parseFrom(paramString3);
      paramString3 = (String)localObject1;
      if (((djc)localObject2).HQL != null) {
        paramString3 = ((djc)localObject2).HQL.umv;
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
    if (bu.isNullOrNil(paramString3))
    {
      localObject1 = paramString3;
      if (paramTimeLineObject.HUF != null) {
        localObject1 = paramTimeLineObject.HUF.Id;
      }
    }
    localdhe.HOl = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.zyr.dPK.dPL, this.zyr.dPK.dPN, this.zyr.dPK.dPO, Integer.valueOf(y.aH(this.zyr.dPK.dPN, this.zyr.dPK.dPO)), Integer.valueOf(this.zyr.dPK.dPU), localObject1 });
    paramString3 = new SKBuiltinBuffer_t();
    paramString3.setBuffer(paramString1.getBytes());
    i = paramString1.length();
    j = paramString3.getILen();
    if (paramb == null) {}
    for (paramInt3 = 0;; paramInt3 = paramb.zr.length)
    {
      ae.i("MicroMsg.NetSceneSnsPost", "len:%d   skb:%d ctx.len:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt3) });
      localdhe.ObjectDesc = paramString3;
      localdhe.HOg = paramInt1;
      localdhe.HmH = paramInt2;
      localdhe.hFO = paramString2;
      this.zyq = paramInt1;
      if (ac.iRj)
      {
        localdhe.ObjectDesc = new SKBuiltinBuffer_t();
        ae.e("MicroMsg.NetSceneSnsPost", "post error setObjectDesc is null!");
      }
      paramString3 = new LinkedList();
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label982;
      }
      paramList = paramList.iterator();
      for (paramString1 = ""; paramList.hasNext(); paramString1 = paramString1 + "; + " + (String)localObject1)
      {
        localObject1 = (String)paramList.next();
        localObject2 = new cxn();
        ((cxn)localObject2).aQV((String)localObject1);
        paramString3.add(localObject2);
      }
    }
    ae.d("MicroMsg.NetSceneSnsPost", "post with list : ".concat(String.valueOf(paramString1)));
    label982:
    localdhe.WithUserList = paramString3;
    localdhe.WithUserListCount = paramString3.size();
    localdhe.HOh = paramInt4;
    paramString1 = localdhe.HOl;
    if (parambzi.HmY != null)
    {
      paramInt1 = parambzi.HmY.HNw;
      ae.i("MicroMsg.NetSceneSnsPost", "setObjectSource: %d, clientid:%s fromScene:%s, score:%d, sdkTokenValid:%s, sdkPkgName:%s", new Object[] { Integer.valueOf(paramInt5), paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt6), paramString4 });
      if ((paramLinkedList1 != null) && (paramLinkedList1.size() > 0))
      {
        if (!paramBoolean) {
          break label1269;
        }
        localdhe.BlackList = paramLinkedList1;
        localdhe.BlackListCount = paramLinkedList1.size();
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.NetSceneSnsPost", "setObjectSource ".concat(String.valueOf(paramInt5)));
      localdhe.HOi = paramInt5;
      paramString1 = new dqz();
      if (!bu.isNullOrNil(parambzi.token))
      {
        paramString1.HXY = parambzi.token;
        paramString1.HXZ = parambzi.HmQ;
        localdhe.HxX = paramString1;
      }
      if ((paramLinkedList == null) || (paramLinkedList.isEmpty())) {
        break label1333;
      }
      localdhe.GroupCount = paramLinkedList.size();
      paramString1 = paramLinkedList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (Long)paramString1.next();
        paramString2 = new dgp();
        paramString2.HNO = paramList.longValue();
        localdhe.HmN.add(paramString2);
      }
      paramInt1 = 0;
      break;
      label1269:
      localdhe.GroupUser = paramLinkedList1;
      localdhe.GroupUserCount = paramLinkedList1.size();
    }
    ae.d("MicroMsg.NetSceneSnsPost", "tagid " + paramLinkedList.size() + " " + localdhe.HmN.toString());
    label1333:
    localdhe.HmS = paramdhd;
    if (!bu.isNullOrNil(parambzi.HmU)) {
      localdhe.SnsRedEnvelops = new dhi();
    }
    if (paramdhd != null) {
      ae.d("MicroMsg.NetSceneSnsPost", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { paramdhd.FOU, paramdhd.FOV, paramdhd.FOW });
    }
    if (paramb != null) {
      localdhe.HOk = new SKBuiltinBuffer_t().setBuffer(paramb);
    }
    localdhe.HOp = parambzi.HmY;
    paramString1 = ah.dXE().Rw(this.dKr);
    if ((paramString1 != null) && ((paramString1.field_type == 1) || (paramString1.field_type == 15)) && (paramTimeLineObject.HUG != null) && (paramTimeLineObject.HUG.Gtx != null) && (paramTimeLineObject.HUG.Gtx.size() > 0) && (parambzi.HmI != null) && (parambzi.HmI.size() == paramTimeLineObject.HUG.Gtx.size()))
    {
      paramString1 = ah.getAccSnsPath();
      paramList = paramTimeLineObject.HUG.Gtx.iterator();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramList.hasNext())
      {
        paramLinkedList = (bzh)paramList.next();
        if ((paramLinkedList.nJA == 2) || (paramLinkedList.nJA == 6))
        {
          paramTimeLineObject = new bzf();
          if (paramLinkedList.nJA != 2) {
            break label1859;
          }
          paramInt2 = 2;
          label1612:
          paramTimeLineObject.udg = paramInt2;
          if (paramLinkedList.nJA == 6)
          {
            paramString2 = ap.jv(paramString1, paramLinkedList.Id);
            paramLinkedList = r.o(paramLinkedList);
            paramString2 = com.tencent.mm.plugin.sight.base.e.ayN(paramString2 + paramLinkedList);
            if (paramString2 != null) {
              paramTimeLineObject.Hmg = ((int)Math.round(paramString2.videoDuration / 1000.0D));
            }
          }
          paramString2 = (bwe)parambzi.HmI.get(paramInt1);
          paramString2 = ah.dXt().AH(paramString2.Hjg);
        }
      }
      try
      {
        paramLinkedList = (bzk)new bzk().parseFrom(paramString2.Aey);
        paramTimeLineObject.ucK = paramLinkedList.Hnk;
        this.zyu.put(Integer.valueOf(paramString2.AdJ), Integer.valueOf(paramLinkedList.Hnk));
        label1777:
        paramTimeLineObject.FQl = parambzi.sessionId;
        ae.i("MicroMsg.NetSceneSnsPost", "post add mediaInfo, Source: %s, videoPlayLength: %s, MediaType: %s, SessionId: %s", new Object[] { Integer.valueOf(paramTimeLineObject.ucK), Integer.valueOf(paramTimeLineObject.Hmg), Integer.valueOf(paramTimeLineObject.udg), paramTimeLineObject.FQl });
        localdhe.HOo.add(paramTimeLineObject);
        paramInt1 += 1;
        continue;
        label1859:
        paramInt2 = 1;
        break label1612;
        localdhe.HOn = localdhe.HOo.size();
        ae.i("MicroMsg.NetSceneSnsPost", "post mediaCount: %s", new Object[] { Integer.valueOf(localdhe.HOn) });
        if (com.tencent.mm.plugin.normsg.a.b.wJt.auF("ie_sns_upload")) {
          com.tencent.mm.plugin.normsg.a.b.wJt.auE("ie_sns_upload");
        }
        for (;;)
        {
          try
          {
            paramString1 = new eby();
            paramString1.Ihq = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.auG("ie_sns_upload"));
            if (paramString1.Ihq == null) {
              continue;
            }
            paramInt1 = paramString1.Ihq.getILen();
            ae.d("MicroMsg.NetSceneSnsPost", "[debug] wcstf set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            paramString1.Ihr = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.auJ("ce_sns_upload"));
            if (paramString1.Ihr == null) {
              continue;
            }
            paramInt1 = paramString1.Ihr.getILen();
            ae.d("MicroMsg.NetSceneSnsPost", "[debug] wcste set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            paramString1.Ihs = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.dye());
            if (paramString1.Ihs == null) {
              continue;
            }
            paramInt1 = paramString1.Ihs.getILen();
            ae.d("MicroMsg.NetSceneSnsPost", "[debug] ccData set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            localdhe.FSj = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
          }
          catch (Throwable paramString1)
          {
            continue;
          }
          paramString1 = new cgs();
          paramString1.FOX = paramInt6;
          paramString1.uqs = paramString4;
          localdhe.HOq = paramString1;
          AppMethodBeat.o(95612);
          return;
          paramInt1 = -1;
          continue;
          paramInt1 = -1;
          continue;
          paramInt1 = -1;
        }
      }
      catch (Exception paramString2)
      {
        break label1777;
      }
    }
  }
  
  private static boolean a(TimeLineObject paramTimeLineObject1, TimeLineObject paramTimeLineObject2)
  {
    AppMethodBeat.i(95616);
    if ((paramTimeLineObject1 == null) || (paramTimeLineObject2 == null) || (paramTimeLineObject1.HUG == null) || (paramTimeLineObject2.HUG == null))
    {
      AppMethodBeat.o(95616);
      return false;
    }
    String str1 = ah.getAccSnsPath();
    int i = 0;
    while ((i < paramTimeLineObject1.HUG.Gtx.size()) && (i < paramTimeLineObject2.HUG.Gtx.size()))
    {
      Object localObject2 = (bzh)paramTimeLineObject1.HUG.Gtx.get(i);
      Object localObject1 = (bzh)paramTimeLineObject2.HUG.Gtx.get(i);
      String str2 = r.l((bzh)localObject2);
      String str3 = r.m((bzh)localObject2);
      String str4 = r.n((bzh)localObject2);
      String str5 = r.o((bzh)localObject2);
      String str6 = r.k((bzh)localObject1);
      String str7 = r.d((bzh)localObject1);
      String str8 = r.e((bzh)localObject1);
      String str9 = r.i((bzh)localObject1);
      ae.d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + str2 + "  - " + str6);
      localObject2 = ap.jv(str1, ((bzh)localObject2).Id);
      localObject1 = ap.jv(str1, ((bzh)localObject1).Id);
      o.aZI((String)localObject1);
      o.mG((String)localObject2 + str2, (String)localObject1 + str6);
      o.mG((String)localObject2 + str3, (String)localObject1 + str7);
      o.mG((String)localObject2 + str4, (String)localObject1 + str8);
      if (o.fB((String)localObject2 + str5))
      {
        ae.i("MicroMsg.NetSceneSnsPost", "post done copy file %s", new Object[] { (String)localObject1 + str9 });
        o.mG((String)localObject2 + str5, (String)localObject1 + str9);
      }
      i += 1;
    }
    AppMethodBeat.o(95616);
    return true;
  }
  
  private void aAg(String paramString)
  {
    AppMethodBeat.i(95615);
    this.zyy = paramString;
    paramString = com.tencent.mm.model.c.d.aDI().xi("100132");
    if (paramString.isValid()) {
      this.gzC = bu.getInt((String)paramString.fsy().get("needUploadData"), 1);
    }
    if ((this.zyt != 12) && (this.gzC == 0))
    {
      AppMethodBeat.o(95615);
      return;
    }
    if ((this.zyp != null) && (this.zyp.HUG != null) && (this.zyp.HUG.Gtx != null) && (this.zyp.HUG.Gtx.size() > 0))
    {
      paramString = this.zyp.HUG.Gtx;
      com.tencent.mm.sdk.b.a.IvT.c(this.gzF);
      com.tencent.mm.sdk.b.a.IvT.c(this.gzG);
      paramString = paramString.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        Object localObject = (bzh)paramString.next();
        if (((bzh)localObject).nJA == 2)
        {
          String str = g.C((bzh)localObject);
          if (!bu.isNullOrNil(str))
          {
            this.zyx.put(str, Integer.valueOf(i));
            this.zyw.put(str, localObject);
            localObject = new qd();
            ((qd)localObject).dFH.dmK = System.currentTimeMillis();
            ((qd)localObject).dFH.filePath = str;
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
            i += 1;
          }
        }
      }
    }
    AppMethodBeat.o(95615);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(95613);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95613);
    return i;
  }
  
  public final int getType()
  {
    return 209;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95614);
    ae.i("MicroMsg.NetSceneSnsPost", "post netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    dhf localdhf = (dhf)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if (paramInt2 == 4) {
      paramq = ah.dXE().Rw(this.dKr);
    }
    try
    {
      paramArrayOfByte = (bzi)new bzi().parseFrom(paramq.field_postBuf);
      paramArrayOfByte.HmP = paramInt3;
      paramArrayOfByte.HmW = localdhf.HmW;
      paramArrayOfByte.HmX = false;
      paramq.field_postBuf = paramArrayOfByte.toByteArray();
      label145:
      if (paramq != null)
      {
        paramq.ecs();
        ah.dXE().b(this.dKr, paramq);
        ah.dXD().Qy(this.dKr);
        ae.d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + paramq.eco());
        paramq = new uz();
        paramq.dKn.dKo = this.dKr;
        com.tencent.mm.sdk.b.a.IvT.l(paramq);
      }
      if ((this.zyo != null) && (this.zyo.HUG != null) && (this.zyo.HUG.Gtw == 21))
      {
        com.tencent.mm.plugin.sns.lucky.a.b.md(8);
        switch (paramInt3)
        {
        default: 
          com.tencent.mm.plugin.sns.lucky.a.b.md(20);
        }
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
        com.tencent.mm.plugin.sns.lucky.a.b.md(17);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.md(19);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.md(18);
      }
      if (paramInt3 != 0)
      {
        ah.dXD().Qy(this.dKr);
        if ((this.zyo != null) && (this.zyo.HUG != null) && (this.zyo.HUG.Gtw == 21))
        {
          com.tencent.mm.plugin.sns.lucky.a.b.md(8);
          com.tencent.mm.plugin.sns.lucky.a.b.md(16);
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
      }
      if ((localdhf.HMY == null) || (localdhf.HMY.ObjectDesc == null) || (localdhf.HMY.ObjectDesc.getBuffer() == null))
      {
        ae.e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
        ah.dXD().Qy(this.dKr);
        paramq = ah.dXE().Rw(this.dKr);
        if (paramq != null)
        {
          paramq.ecr();
          ah.dXE().b(this.dKr, paramq);
          paramq = new vb();
          paramq.dKt.dKo = this.dKr;
          com.tencent.mm.sdk.b.a.IvT.l(paramq);
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
      }
      Object localObject1 = new String(localdhf.HMY.ObjectDesc.getBuffer().toByteArray());
      if (this.zyq == 0) {
        ae.d("MicroMsg.NetSceneSnsPost", "resp " + (String)localObject1 + "  ");
      }
      this.zyp = com.tencent.mm.modelsns.h.GZ((String)localObject1);
      Object localObject2;
      Object localObject3;
      if (this.zyp.HUL != null)
      {
        paramq = this.zyp.Id;
        paramArrayOfByte = this.zyp.HUL.hFa;
        localObject2 = this.zyp.HUL.hEZ;
        localObject3 = new com.tencent.mm.modelsns.g();
        ((com.tencent.mm.modelsns.g)localObject3).m("20CurrPublishId", paramq + ",");
        ((com.tencent.mm.modelsns.g)localObject3).m("20SourcePublishId", paramArrayOfByte + ",");
        ((com.tencent.mm.modelsns.g)localObject3).m("20SourceAdUxInfo", (String)localObject2 + ",");
        ae.i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + ((com.tencent.mm.modelsns.g)localObject3).RD());
        com.tencent.mm.plugin.report.service.g.yxI.f(13004, new Object[] { localObject3 });
      }
      paramArrayOfByte = ah.dXE().Rw(this.dKr);
      paramq = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        ae.e("MicroMsg.NetSceneSnsPost", "the item has delete");
        paramq = new p();
      }
      paramq.setCreateTime(localdhf.HMY.CreateTime);
      paramq.aBp((String)localObject1);
      paramq.field_localFlag &= 0xFFFFFFEF;
      paramq.AC(localdhf.HMY.Id);
      paramq.AE(localdhf.HMY.Id);
      if ((localdhf.HMY.ExtFlag & 0x1) > 0) {
        paramq.ecl();
      }
      this.zry = localdhf.HMY.Id;
      if (this.zyr != null)
      {
        this.zyr.dPK.dPM = ("sns_" + r.zV(this.zry));
        com.tencent.mm.sdk.b.a.IvT.l(this.zyr);
      }
      if ((this.zys != null) && (this.zys.dQa.dQb != -1)) {
        com.tencent.mm.sdk.b.a.IvT.l(this.zys);
      }
      localObject1 = localdhf.HMY;
      ((SnsObject)localObject1).ObjectDesc.setBuffer(new byte[0]);
      try
      {
        if ((((SnsObject)localObject1).CommentUserListCount == 0) && (((SnsObject)localObject1).LikeUserListCount == 0) && (((SnsObject)localObject1).WithUserListCount == 0) && (((SnsObject)localObject1).GroupCount == 0)) {
          ae.d("MicroMsg.NetSceneSnsPost", "no use! this buf");
        }
        for (;;)
        {
          paramq.ecr();
          ah.dXE().delete(this.zry);
          ah.dXE().b(this.dKr, paramq);
          ah.dXD().Qy(this.dKr);
          if (((this.zyo.HUG.Gtw == 1) && (this.zyo.eQZ == 0) && (this.zyp.eQZ == 1)) || ((this.zyo.HUG.Gtw == 15) && (this.zyo.HUN == 0) && (this.zyp.HUN == 1) && (com.tencent.mm.plugin.sns.storage.i.Az(x.aze(paramq.getSnsId()))))) {
            new aq(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95607);
                u.dWZ();
                AppMethodBeat.o(95607);
              }
            });
          }
          paramArrayOfByte = com.tencent.mm.plugin.sns.j.g.zLJ.dI(Integer.valueOf(this.dKr));
          if ((paramArrayOfByte != null) && (this.zyp != null))
          {
            paramArrayOfByte.aLE();
            paramArrayOfByte.aLF();
            paramArrayOfByte.GW(this.zyp.Id);
            paramArrayOfByte.qb(this.zyp.HUG.Gtw);
            paramArrayOfByte.aLH();
          }
          paramArrayOfByte = com.tencent.mm.plugin.sns.j.h.zLJ.dI(Integer.valueOf(this.dKr));
          if ((paramArrayOfByte != null) && (this.zyp != null))
          {
            paramArrayOfByte.aLE();
            paramArrayOfByte.aLF();
            paramArrayOfByte.GW(this.zyp.Id);
            paramArrayOfByte.qb(this.zyp.HUG.Gtw);
            paramArrayOfByte.aLH();
          }
          paramArrayOfByte = new vb();
          paramArrayOfByte.dKt.dKo = this.dKr;
          com.tencent.mm.sdk.b.a.IvT.l(paramArrayOfByte);
          if (paramq.field_type == 21)
          {
            com.tencent.mm.plugin.sns.lucky.a.b.md(7);
            System.currentTimeMillis();
          }
          a(this.zyo, this.zyp);
          if (this.zyp != null) {
            break;
          }
          paramArrayOfByte = "";
          aAg(paramArrayOfByte);
          if (ah.dXA() != null) {
            ah.dXA().dWc();
          }
          try
          {
            if (paramq.field_type == 15)
            {
              paramInt1 = ((bwe)((bzi)new bzi().parseFrom(paramq.field_postBuf)).HmI.getFirst()).Hjg;
              if (paramInt1 > 0)
              {
                localObject2 = (bzh)this.zyp.HUG.Gtx.get(0);
                if (localObject2 != null)
                {
                  paramq = ap.jv(ah.getAccSnsPath(), ((bzh)localObject2).Id) + r.i((bzh)localObject2);
                  paramArrayOfByte = com.tencent.mm.modelvideo.n.aNf();
                  localObject2 = ((bzh)localObject2).Url;
                  l = ((SnsObject)localObject1).Id;
                  if (!bu.isNullOrNil((String)localObject2))
                  {
                    boolean bool = bu.isNullOrNil(paramq);
                    if (!bool) {
                      break label1963;
                    }
                  }
                }
              }
            }
          }
          catch (Exception paramq)
          {
            long l;
            label1629:
            n.a locala;
            break label1629;
          }
          l = ((SnsObject)localObject1).Id;
          paramq = new va();
          paramq.dKp.dKq = l;
          paramq.dKp.dKr = this.dKr;
          paramq.dKp.dKs = this.zyu;
          com.tencent.mm.sdk.b.a.IvT.l(paramq);
          l = ((SnsObject)localObject1).Id;
          paramq = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.JdR, "");
          if (!bu.isNullOrNil(paramq))
          {
            ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.c.class)).V("snspublicid", r.zV(l), paramq);
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JdR, "");
          }
          paramq = com.tencent.mm.plugin.sns.j.e.zKO.zKY;
          paramq.epW = paramq.t("Published", r.zV(localdhf.HMY.Id), true);
          com.tencent.mm.plugin.sns.j.e.zKO.dZi();
          if (com.tencent.mm.plugin.sns.j.e.zKO.zLy.eqy == 1L)
          {
            paramq = com.tencent.mm.plugin.sns.j.e.zKO.zLy;
            paramq.eqA = paramq.t("NextPublishId", r.zW(((SnsObject)localObject1).Id), true);
            com.tencent.mm.plugin.sns.j.e.zKO.dZq();
          }
          if (com.tencent.mm.plugin.sns.j.e.zKO.zLA == this.dKr)
          {
            paramq = com.tencent.mm.plugin.sns.j.e.zKO;
            com.tencent.mm.plugin.sns.j.e.a(9, "", 0, 0, ch.aDb(), ((SnsObject)localObject1).Id, com.tencent.mm.plugin.sns.j.e.zKO.zLB, 0);
            com.tencent.mm.plugin.sns.j.e.zKO.zLA = 0;
          }
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95614);
          return;
          paramq.bL(((SnsObject)localObject1).toByteArray());
        }
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.NetSceneSnsPost", paramArrayOfByte, "", new Object[0]);
          continue;
          paramArrayOfByte = this.zyp.HUD;
          continue;
          label1963:
          localObject3 = String.valueOf(paramInt1);
          ae.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", new Object[] { localObject3, localObject2, Long.valueOf(l), paramq });
          locala = (n.a)paramArrayOfByte.iwi.get(localObject3);
          if (locala != null)
          {
            locala.iwx = String.valueOf(l);
            locala.iww = paramq;
            locala.dAd = ((String)localObject2);
            paramArrayOfByte.a(locala.ifH, (String)localObject3);
          }
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      break label145;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.s
 * JD-Core Version:    0.7.0.1
 */