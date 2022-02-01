package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qd.a;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qe.a;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.zk;
import com.tencent.mm.g.a.zk.a;
import com.tencent.mm.g.a.zl;
import com.tencent.mm.g.a.zl.a;
import com.tencent.mm.g.b.a.gl;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.byl;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dfj;
import com.tencent.mm.protocal.protobuf.dfv;
import com.tencent.mm.protocal.protobuf.dgj;
import com.tencent.mm.protocal.protobuf.dgk;
import com.tencent.mm.protocal.protobuf.dgl;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dqc;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.sm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class r
  extends com.tencent.mm.al.n
  implements k
{
  public com.tencent.mm.al.f callback;
  int dJd;
  boolean fRb;
  int gwV;
  private com.tencent.mm.sdk.b.c gwY;
  private com.tencent.mm.sdk.b.c gwZ;
  private com.tencent.mm.al.b rr;
  long zaX;
  private TimeLineObject zhA;
  private int zhB;
  private zk zhC;
  private zl zhD;
  int zhE;
  private HashMap<Integer, Integer> zhF;
  String zhG;
  HashMap<String, byn> zhH;
  HashMap<String, Integer> zhI;
  String zhJ;
  private TimeLineObject zhz;
  
  public r(String paramString1, int paramInt1, int paramInt2, List<String> paramList, TimeLineObject paramTimeLineObject, int paramInt3, String paramString2, int paramInt4, LinkedList<Long> paramLinkedList, int paramInt5, byo parambyo, boolean paramBoolean, LinkedList<cwt> paramLinkedList1, dgj paramdgj, com.tencent.mm.bx.b paramb, String paramString3, int paramInt6, String paramString4)
  {
    AppMethodBeat.i(95612);
    this.zaX = 0L;
    this.fRb = false;
    this.zhB = 0;
    this.zhF = new HashMap();
    this.gwV = 0;
    this.zhG = "";
    this.zhH = new HashMap();
    this.zhI = new HashMap();
    this.zhJ = "";
    this.gwY = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(qe paramAnonymousqe)
      {
        AppMethodBeat.i(95608);
        if (!r.this.zhI.containsKey(paramAnonymousqe.dEH.filePath))
        {
          AppMethodBeat.o(95608);
          return false;
        }
        int i = ((Integer)r.this.zhI.remove(paramAnonymousqe.dEH.filePath)).intValue();
        try
        {
          str1 = URLEncoder.encode(paramAnonymousqe.dEH.result, "UTF-8");
          if (r.this.gwV != 0)
          {
            byn localbyn = (byn)r.this.zhH.get(paramAnonymousqe.dEH.filePath);
            r.this.zhG += String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s&codeType=%d|", new Object[] { Integer.valueOf(i), str1, localbyn.GSW, localbyn.Url, Integer.valueOf(paramAnonymousqe.dEH.dnt) });
          }
          if (r.this.zhE == 12)
          {
            str1 = "2,3,,".concat(String.valueOf(str1));
            paramAnonymousqe = str1;
            if (i != 0) {}
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          try
          {
            String str1;
            paramAnonymousqe = str1 + "," + URLEncoder.encode(r.this.zhJ, "UTF-8");
            ad.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(i), paramAnonymousqe });
            com.tencent.mm.plugin.report.service.g.yhR.kvStat(13717, paramAnonymousqe);
            r.a(r.this);
            AppMethodBeat.o(95608);
            return false;
            localUnsupportedEncodingException = localUnsupportedEncodingException;
            ad.printErrStackTrace("MicroMsg.NetSceneSnsPost", localUnsupportedEncodingException, "", new Object[0]);
            str2 = "";
          }
          catch (UnsupportedEncodingException paramAnonymousqe)
          {
            for (;;)
            {
              String str2;
              ad.e("MicroMsg.NetSceneSnsPost", "", new Object[] { paramAnonymousqe.getMessage() });
              paramAnonymousqe = str2;
            }
          }
        }
      }
    };
    this.gwZ = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(qd paramAnonymousqd)
      {
        AppMethodBeat.i(95610);
        if (!r.this.zhI.containsKey(paramAnonymousqd.dEG.filePath))
        {
          AppMethodBeat.o(95610);
          return false;
        }
        paramAnonymousqd = (Integer)r.this.zhI.remove(paramAnonymousqd.dEG.filePath);
        if (paramAnonymousqd == null)
        {
          AppMethodBeat.o(95610);
          return false;
        }
        int i = paramAnonymousqd.intValue();
        String str;
        if (r.this.zhE == 12)
        {
          str = "2,3,,";
          paramAnonymousqd = str;
          if (i != 0) {}
        }
        try
        {
          paramAnonymousqd = "2,3,," + "," + URLEncoder.encode(r.this.zhJ, "UTF-8");
          ad.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(i), paramAnonymousqd });
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(13717, paramAnonymousqd);
          r.a(r.this);
          AppMethodBeat.o(95610);
          return false;
        }
        catch (UnsupportedEncodingException paramAnonymousqd)
        {
          for (;;)
          {
            ad.e("MicroMsg.NetSceneSnsPost", "", new Object[] { paramAnonymousqd.getMessage() });
            paramAnonymousqd = str;
          }
        }
      }
    };
    this.zhz = paramTimeLineObject;
    this.dJd = paramInt3;
    this.zhE = paramInt5;
    localObject1 = new b.a();
    ((b.a)localObject1).hNM = new dgk();
    ((b.a)localObject1).hNN = new dgl();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnspost";
    ((b.a)localObject1).funcId = 209;
    ((b.a)localObject1).hNO = 97;
    ((b.a)localObject1).respCmdId = 1000000097;
    this.rr = ((b.a)localObject1).aDC();
    dgk localdgk = (dgk)this.rr.hNK.hNQ;
    if (!TextUtils.isEmpty(paramTimeLineObject.znQ.Fsy.Fst))
    {
      localObject1 = new sm();
      ((sm)localObject1).FPb = paramTimeLineObject.znQ.Fsy.Fst;
      localdgk.HuJ = ((sm)localObject1);
    }
    localObject1 = y.aBq().AG(parambyo.sessionId);
    Object localObject2;
    if (localObject1 != null)
    {
      this.zhC = new zk();
      this.zhC.dOu.dOv = ((y.b)localObject1).getString("prePublishId", "");
      this.zhC.dOu.url = ((y.b)localObject1).getString("url", "");
      this.zhC.dOu.dOx = ((y.b)localObject1).getString("preUsername", "");
      this.zhC.dOu.dOy = ((y.b)localObject1).getString("preChatName", "");
      this.zhC.dOu.dOz = ((y.b)localObject1).getInt("preMsgIndex", 0);
      this.zhC.dOu.dOD = ((y.b)localObject1).getInt("sendAppMsgScene", 0);
      this.zhC.dOu.dOE = ((y.b)localObject1).getInt("getA8KeyScene", 0);
      this.zhC.dOu.dOF = ((y.b)localObject1).getString("referUrl", null);
      this.zhC.dOu.dOG = ((y.b)localObject1).getString("adExtStr", null);
      this.zhC.dOu.dOH = paramString3;
      if (((y.b)localObject1).containsKey("_tmpl_webview_transfer_scene"))
      {
        this.zhD = new zl();
        this.zhD.dOK.dOL = ((y.b)localObject1).getInt("_tmpl_webview_transfer_scene", -1);
      }
      localObject1 = "";
      paramString3 = (String)localObject1;
      if (paramTimeLineObject.zRz != null)
      {
        localObject2 = new dih();
        paramString3 = Base64.decode(paramTimeLineObject.zRz, 0);
      }
    }
    try
    {
      ((dih)localObject2).parseFrom(paramString3);
      paramString3 = (String)localObject1;
      if (((dih)localObject2).Hxc != null) {
        paramString3 = ((dih)localObject2).Hxc.ubt;
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
    if (bt.isNullOrNil(paramString3))
    {
      localObject1 = paramString3;
      if (paramTimeLineObject.HAS != null) {
        localObject1 = paramTimeLineObject.HAS.Id;
      }
    }
    localdgk.HuI = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.zhC.dOu.dOv, this.zhC.dOu.dOx, this.zhC.dOu.dOy, Integer.valueOf(com.tencent.mm.model.x.aG(this.zhC.dOu.dOx, this.zhC.dOu.dOy)), Integer.valueOf(this.zhC.dOu.dOE), localObject1 });
    paramString3 = new SKBuiltinBuffer_t();
    paramString3.setBuffer(paramString1.getBytes());
    i = paramString1.length();
    j = paramString3.getILen();
    if (paramb == null) {}
    for (paramInt3 = 0;; paramInt3 = paramb.zr.length)
    {
      ad.i("MicroMsg.NetSceneSnsPost", "len:%d   skb:%d ctx.len:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt3) });
      localdgk.ObjectDesc = paramString3;
      localdgk.HuD = paramInt1;
      localdgk.GTg = paramInt2;
      localdgk.hCW = paramString2;
      this.zhB = paramInt1;
      if (ac.iOp)
      {
        localdgk.ObjectDesc = new SKBuiltinBuffer_t();
        ad.e("MicroMsg.NetSceneSnsPost", "post error setObjectDesc is null!");
      }
      paramString3 = new LinkedList();
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label982;
      }
      paramList = paramList.iterator();
      for (paramString1 = ""; paramList.hasNext(); paramString1 = paramString1 + "; + " + (String)localObject1)
      {
        localObject1 = (String)paramList.next();
        localObject2 = new cwt();
        ((cwt)localObject2).aPy((String)localObject1);
        paramString3.add(localObject2);
      }
    }
    ad.d("MicroMsg.NetSceneSnsPost", "post with list : ".concat(String.valueOf(paramString1)));
    label982:
    localdgk.WithUserList = paramString3;
    localdgk.WithUserListCount = paramString3.size();
    localdgk.HuE = paramInt4;
    paramString1 = localdgk.HuI;
    if (parambyo.GTx != null)
    {
      paramInt1 = parambyo.GTx.HtT;
      ad.i("MicroMsg.NetSceneSnsPost", "setObjectSource: %d, clientid:%s fromScene:%s, score:%d, sdkTokenValid:%s, sdkPkgName:%s", new Object[] { Integer.valueOf(paramInt5), paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt6), paramString4 });
      if ((paramLinkedList1 != null) && (paramLinkedList1.size() > 0))
      {
        if (!paramBoolean) {
          break label1269;
        }
        localdgk.BlackList = paramLinkedList1;
        localdgk.BlackListCount = paramLinkedList1.size();
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneSnsPost", "setObjectSource ".concat(String.valueOf(paramInt5)));
      localdgk.HuF = paramInt5;
      paramString1 = new dqc();
      if (!bt.isNullOrNil(parambyo.token))
      {
        paramString1.HEl = parambyo.token;
        paramString1.HEm = parambyo.GTp;
        localdgk.Hex = paramString1;
      }
      if ((paramLinkedList == null) || (paramLinkedList.isEmpty())) {
        break label1333;
      }
      localdgk.GroupCount = paramLinkedList.size();
      paramString1 = paramLinkedList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (Long)paramString1.next();
        paramString2 = new dfv();
        paramString2.Hul = paramList.longValue();
        localdgk.GTm.add(paramString2);
      }
      paramInt1 = 0;
      break;
      label1269:
      localdgk.GroupUser = paramLinkedList1;
      localdgk.GroupUserCount = paramLinkedList1.size();
    }
    ad.d("MicroMsg.NetSceneSnsPost", "tagid " + paramLinkedList.size() + " " + localdgk.GTm.toString());
    label1333:
    localdgk.GTr = paramdgj;
    if (!bt.isNullOrNil(parambyo.GTt)) {
      localdgk.SnsRedEnvelops = new dgo();
    }
    if (paramdgj != null) {
      ad.d("MicroMsg.NetSceneSnsPost", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { paramdgj.Fww, paramdgj.Fwx, paramdgj.Fwy });
    }
    if (paramb != null) {
      localdgk.HuH = new SKBuiltinBuffer_t().setBuffer(paramb);
    }
    localdgk.HuM = parambyo.GTx;
    paramString1 = ag.dUe().QP(this.dJd);
    if ((paramString1 != null) && ((paramString1.field_type == 1) || (paramString1.field_type == 15)) && (paramTimeLineObject.HAT != null) && (paramTimeLineObject.HAT.GaQ != null) && (paramTimeLineObject.HAT.GaQ.size() > 0) && (parambyo.GTh != null) && (parambyo.GTh.size() == paramTimeLineObject.HAT.GaQ.size()))
    {
      paramString1 = ag.getAccSnsPath();
      paramList = paramTimeLineObject.HAT.GaQ.iterator();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramList.hasNext())
      {
        paramLinkedList = (byn)paramList.next();
        if ((paramLinkedList.nEf == 2) || (paramLinkedList.nEf == 6))
        {
          paramTimeLineObject = new byl();
          if (paramLinkedList.nEf != 2) {
            break label1859;
          }
          paramInt2 = 2;
          label1612:
          paramTimeLineObject.tSp = paramInt2;
          if (paramLinkedList.nEf == 6)
          {
            paramString2 = ao.jo(paramString1, paramLinkedList.Id);
            paramLinkedList = com.tencent.mm.plugin.sns.data.q.o(paramLinkedList);
            paramString2 = com.tencent.mm.plugin.sight.base.e.axx(paramString2 + paramLinkedList);
            if (paramString2 != null) {
              paramTimeLineObject.GSF = ((int)Math.round(paramString2.videoDuration / 1000.0D));
            }
          }
          paramString2 = (bvk)parambyo.GTh.get(paramInt1);
          paramString2 = ag.dTT().Aj(paramString2.GPE);
        }
      }
      try
      {
        paramLinkedList = (byq)new byq().parseFrom(paramString2.zNr);
        paramTimeLineObject.tRT = paramLinkedList.GTJ;
        this.zhF.put(Integer.valueOf(paramString2.zMC), Integer.valueOf(paramLinkedList.GTJ));
        label1777:
        paramTimeLineObject.FxN = parambyo.sessionId;
        ad.i("MicroMsg.NetSceneSnsPost", "post add mediaInfo, Source: %s, videoPlayLength: %s, MediaType: %s, SessionId: %s", new Object[] { Integer.valueOf(paramTimeLineObject.tRT), Integer.valueOf(paramTimeLineObject.GSF), Integer.valueOf(paramTimeLineObject.tSp), paramTimeLineObject.FxN });
        localdgk.HuL.add(paramTimeLineObject);
        paramInt1 += 1;
        continue;
        label1859:
        paramInt2 = 1;
        break label1612;
        localdgk.HuK = localdgk.HuL.size();
        ad.i("MicroMsg.NetSceneSnsPost", "post mediaCount: %s", new Object[] { Integer.valueOf(localdgk.HuK) });
        if (com.tencent.mm.plugin.normsg.a.b.wtJ.ats("ie_sns_upload")) {
          com.tencent.mm.plugin.normsg.a.b.wtJ.atr("ie_sns_upload");
        }
        for (;;)
        {
          try
          {
            paramString1 = new eah();
            paramString1.HNj = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.att("ie_sns_upload"));
            if (paramString1.HNj == null) {
              continue;
            }
            paramInt1 = paramString1.HNj.getILen();
            ad.d("MicroMsg.NetSceneSnsPost", "[debug] wcstf set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            paramString1.HNk = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.atw("ce_sns_upload"));
            if (paramString1.HNk == null) {
              continue;
            }
            paramInt1 = paramString1.HNk.getILen();
            ad.d("MicroMsg.NetSceneSnsPost", "[debug] wcste set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            paramString1.HNl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.duO());
            if (paramString1.HNl == null) {
              continue;
            }
            paramInt1 = paramString1.HNl.getILen();
            ad.d("MicroMsg.NetSceneSnsPost", "[debug] ccData set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            localdgk.FzL = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
          }
          catch (Throwable paramString1)
          {
            continue;
          }
          paramString1 = new cfy();
          paramString1.Fwz = paramInt6;
          paramString1.ufi = paramString4;
          localdgk.HuN = paramString1;
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
    if ((paramTimeLineObject1 == null) || (paramTimeLineObject2 == null) || (paramTimeLineObject1.HAT == null) || (paramTimeLineObject2.HAT == null))
    {
      AppMethodBeat.o(95616);
      return false;
    }
    String str1 = ag.getAccSnsPath();
    int i = 0;
    while ((i < paramTimeLineObject1.HAT.GaQ.size()) && (i < paramTimeLineObject2.HAT.GaQ.size()))
    {
      Object localObject2 = (byn)paramTimeLineObject1.HAT.GaQ.get(i);
      Object localObject1 = (byn)paramTimeLineObject2.HAT.GaQ.get(i);
      String str2 = com.tencent.mm.plugin.sns.data.q.l((byn)localObject2);
      String str3 = com.tencent.mm.plugin.sns.data.q.m((byn)localObject2);
      String str4 = com.tencent.mm.plugin.sns.data.q.n((byn)localObject2);
      String str5 = com.tencent.mm.plugin.sns.data.q.o((byn)localObject2);
      String str6 = com.tencent.mm.plugin.sns.data.q.k((byn)localObject1);
      String str7 = com.tencent.mm.plugin.sns.data.q.d((byn)localObject1);
      String str8 = com.tencent.mm.plugin.sns.data.q.e((byn)localObject1);
      String str9 = com.tencent.mm.plugin.sns.data.q.i((byn)localObject1);
      ad.d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + str2 + "  - " + str6);
      localObject2 = ao.jo(str1, ((byn)localObject2).Id);
      localObject1 = ao.jo(str1, ((byn)localObject1).Id);
      com.tencent.mm.vfs.i.aYg((String)localObject1);
      com.tencent.mm.vfs.i.mA((String)localObject2 + str2, (String)localObject1 + str6);
      com.tencent.mm.vfs.i.mA((String)localObject2 + str3, (String)localObject1 + str7);
      com.tencent.mm.vfs.i.mA((String)localObject2 + str4, (String)localObject1 + str8);
      if (com.tencent.mm.vfs.i.fv((String)localObject2 + str5))
      {
        ad.i("MicroMsg.NetSceneSnsPost", "post done copy file %s", new Object[] { (String)localObject1 + str9 });
        com.tencent.mm.vfs.i.mA((String)localObject2 + str5, (String)localObject1 + str9);
      }
      i += 1;
    }
    AppMethodBeat.o(95616);
    return true;
  }
  
  private void ayP(String paramString)
  {
    AppMethodBeat.i(95615);
    this.zhJ = paramString;
    paramString = com.tencent.mm.model.c.d.aDs().wz("100132");
    if (paramString.isValid()) {
      this.gwV = bt.getInt((String)paramString.foF().get("needUploadData"), 1);
    }
    if ((this.zhE != 12) && (this.gwV == 0))
    {
      AppMethodBeat.o(95615);
      return;
    }
    if ((this.zhA != null) && (this.zhA.HAT != null) && (this.zhA.HAT.GaQ != null) && (this.zhA.HAT.GaQ.size() > 0))
    {
      paramString = this.zhA.HAT.GaQ;
      com.tencent.mm.sdk.b.a.IbL.c(this.gwY);
      com.tencent.mm.sdk.b.a.IbL.c(this.gwZ);
      paramString = paramString.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        Object localObject = (byn)paramString.next();
        if (((byn)localObject).nEf == 2)
        {
          String str = f.C((byn)localObject);
          if (!bt.isNullOrNil(str))
          {
            this.zhI.put(str, Integer.valueOf(i));
            this.zhH.put(str, localObject);
            localObject = new qc();
            ((qc)localObject).dEC.dlI = System.currentTimeMillis();
            ((qc)localObject).dEC.filePath = str;
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
            i += 1;
          }
        }
      }
    }
    AppMethodBeat.o(95615);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
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
    ad.i("MicroMsg.NetSceneSnsPost", "post netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    dgl localdgl = (dgl)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if (paramInt2 == 4) {
      paramq = ag.dUe().QP(this.dJd);
    }
    try
    {
      paramArrayOfByte = (byo)new byo().parseFrom(paramq.field_postBuf);
      paramArrayOfByte.GTo = paramInt3;
      paramArrayOfByte.GTv = localdgl.GTv;
      paramArrayOfByte.GTw = false;
      paramq.field_postBuf = paramArrayOfByte.toByteArray();
      label145:
      if (paramq != null)
      {
        paramq.dYO();
        ag.dUe().b(this.dJd, paramq);
        ag.dUd().PR(this.dJd);
        ad.d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + paramq.dYK());
        paramq = new uv();
        paramq.dIZ.dJa = this.dJd;
        com.tencent.mm.sdk.b.a.IbL.l(paramq);
      }
      if ((this.zhz != null) && (this.zhz.HAT != null) && (this.zhz.HAT.GaP == 21))
      {
        com.tencent.mm.plugin.sns.lucky.a.b.ma(8);
        switch (paramInt3)
        {
        default: 
          com.tencent.mm.plugin.sns.lucky.a.b.ma(20);
        }
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
        com.tencent.mm.plugin.sns.lucky.a.b.ma(17);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.ma(19);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.ma(18);
      }
      if (paramInt3 != 0)
      {
        ag.dUd().PR(this.dJd);
        if ((this.zhz != null) && (this.zhz.HAT != null) && (this.zhz.HAT.GaP == 21))
        {
          com.tencent.mm.plugin.sns.lucky.a.b.ma(8);
          com.tencent.mm.plugin.sns.lucky.a.b.ma(16);
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
      }
      if ((localdgl.Htv == null) || (localdgl.Htv.ObjectDesc == null) || (localdgl.Htv.ObjectDesc.getBuffer() == null))
      {
        ad.e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
        ag.dUd().PR(this.dJd);
        paramq = ag.dUe().QP(this.dJd);
        if (paramq != null)
        {
          paramq.dYN();
          ag.dUe().b(this.dJd, paramq);
          paramq = new ux();
          paramq.dJf.dJa = this.dJd;
          com.tencent.mm.sdk.b.a.IbL.l(paramq);
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
      }
      Object localObject1 = new String(localdgl.Htv.ObjectDesc.getBuffer().toByteArray());
      if (this.zhB == 0) {
        ad.d("MicroMsg.NetSceneSnsPost", "resp " + (String)localObject1 + "  ");
      }
      this.zhA = com.tencent.mm.modelsns.h.Gx((String)localObject1);
      Object localObject2;
      Object localObject3;
      if (this.zhA.HAY != null)
      {
        paramq = this.zhA.Id;
        paramArrayOfByte = this.zhA.HAY.hCl;
        localObject2 = this.zhA.HAY.hCk;
        localObject3 = new com.tencent.mm.modelsns.g();
        ((com.tencent.mm.modelsns.g)localObject3).m("20CurrPublishId", paramq + ",");
        ((com.tencent.mm.modelsns.g)localObject3).m("20SourcePublishId", paramArrayOfByte + ",");
        ((com.tencent.mm.modelsns.g)localObject3).m("20SourceAdUxInfo", (String)localObject2 + ",");
        ad.i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + ((com.tencent.mm.modelsns.g)localObject3).RE());
        com.tencent.mm.plugin.report.service.g.yhR.f(13004, new Object[] { localObject3 });
      }
      paramArrayOfByte = ag.dUe().QP(this.dJd);
      paramq = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        ad.e("MicroMsg.NetSceneSnsPost", "the item has delete");
        paramq = new p();
      }
      paramq.setCreateTime(localdgl.Htv.CreateTime);
      paramq.azY((String)localObject1);
      paramq.field_localFlag &= 0xFFFFFFEF;
      paramq.Ae(localdgl.Htv.Id);
      paramq.Ag(localdgl.Htv.Id);
      if ((localdgl.Htv.ExtFlag & 0x1) > 0) {
        paramq.dYH();
      }
      this.zaX = localdgl.Htv.Id;
      if (this.zhC != null)
      {
        this.zhC.dOu.dOw = ("sns_" + com.tencent.mm.plugin.sns.data.q.zw(this.zaX));
        com.tencent.mm.sdk.b.a.IbL.l(this.zhC);
      }
      if ((this.zhD != null) && (this.zhD.dOK.dOL != -1)) {
        com.tencent.mm.sdk.b.a.IbL.l(this.zhD);
      }
      localObject1 = localdgl.Htv;
      ((SnsObject)localObject1).ObjectDesc.setBuffer(new byte[0]);
      try
      {
        if ((((SnsObject)localObject1).CommentUserListCount == 0) && (((SnsObject)localObject1).LikeUserListCount == 0) && (((SnsObject)localObject1).WithUserListCount == 0) && (((SnsObject)localObject1).GroupCount == 0)) {
          ad.d("MicroMsg.NetSceneSnsPost", "no use! this buf");
        }
        for (;;)
        {
          paramq.dYN();
          ag.dUe().delete(this.zaX);
          ag.dUe().b(this.dJd, paramq);
          ag.dUd().PR(this.dJd);
          if (((this.zhz.HAT.GaP == 1) && (this.zhz.ePo == 0) && (this.zhA.ePo == 1)) || ((this.zhz.HAT.GaP == 15) && (this.zhz.HBa == 0) && (this.zhA.HBa == 1) && (com.tencent.mm.plugin.sns.storage.i.Ab(com.tencent.mm.plugin.sns.storage.x.axN(paramq.getSnsId()))))) {
            new ap(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95607);
                t.dTz();
                AppMethodBeat.o(95607);
              }
            });
          }
          paramArrayOfByte = com.tencent.mm.plugin.sns.j.g.zus.dH(Integer.valueOf(this.dJd));
          if ((paramArrayOfByte != null) && (this.zhA != null))
          {
            paramArrayOfByte.aLh();
            paramArrayOfByte.aLi();
            paramArrayOfByte.Gu(this.zhA.Id);
            paramArrayOfByte.pY(this.zhA.HAT.GaP);
            paramArrayOfByte.aLk();
          }
          paramArrayOfByte = com.tencent.mm.plugin.sns.j.h.zus.dH(Integer.valueOf(this.dJd));
          if ((paramArrayOfByte != null) && (this.zhA != null))
          {
            paramArrayOfByte.aLh();
            paramArrayOfByte.aLi();
            paramArrayOfByte.Gu(this.zhA.Id);
            paramArrayOfByte.pY(this.zhA.HAT.GaP);
            paramArrayOfByte.aLk();
          }
          paramArrayOfByte = new ux();
          paramArrayOfByte.dJf.dJa = this.dJd;
          com.tencent.mm.sdk.b.a.IbL.l(paramArrayOfByte);
          if (paramq.field_type == 21)
          {
            com.tencent.mm.plugin.sns.lucky.a.b.ma(7);
            System.currentTimeMillis();
          }
          a(this.zhz, this.zhA);
          if (this.zhA != null) {
            break;
          }
          paramArrayOfByte = "";
          ayP(paramArrayOfByte);
          if (ag.dUa() != null) {
            ag.dUa().dSE();
          }
          try
          {
            if (paramq.field_type == 15)
            {
              paramInt1 = ((bvk)((byo)new byo().parseFrom(paramq.field_postBuf)).GTh.getFirst()).GPE;
              if (paramInt1 > 0)
              {
                localObject2 = (byn)this.zhA.HAT.GaQ.get(0);
                if (localObject2 != null)
                {
                  paramq = ao.jo(ag.getAccSnsPath(), ((byn)localObject2).Id) + com.tencent.mm.plugin.sns.data.q.i((byn)localObject2);
                  paramArrayOfByte = com.tencent.mm.modelvideo.n.aMH();
                  localObject2 = ((byn)localObject2).Url;
                  l = ((SnsObject)localObject1).Id;
                  if (!bt.isNullOrNil((String)localObject2))
                  {
                    boolean bool = bt.isNullOrNil(paramq);
                    if (!bool) {
                      break label1962;
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
          paramq = new uw();
          paramq.dJb.dJc = l;
          paramq.dJb.dJd = this.dJd;
          paramq.dJb.dJe = this.zhF;
          com.tencent.mm.sdk.b.a.IbL.l(paramq);
          l = ((SnsObject)localObject1).Id;
          paramq = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IJl, "");
          if (!bt.isNullOrNil(paramq))
          {
            ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.c.class)).U("snspublicid", com.tencent.mm.plugin.sns.data.q.zw(l), paramq);
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJl, "");
          }
          paramq = com.tencent.mm.plugin.sns.j.e.ztz.ztH;
          paramq.eop = paramq.t("Published", com.tencent.mm.plugin.sns.data.q.zw(localdgl.Htv.Id), true);
          com.tencent.mm.plugin.sns.j.e.ztz.dVH();
          if (com.tencent.mm.plugin.sns.j.e.ztz.zuh.eoR == 1L)
          {
            paramq = com.tencent.mm.plugin.sns.j.e.ztz.zuh;
            paramq.eoT = paramq.t("NextPublishId", com.tencent.mm.plugin.sns.data.q.zx(((SnsObject)localObject1).Id), true);
            com.tencent.mm.plugin.sns.j.e.ztz.dVP();
          }
          if (com.tencent.mm.plugin.sns.j.e.ztz.zuj == this.dJd)
          {
            paramq = com.tencent.mm.plugin.sns.j.e.ztz;
            com.tencent.mm.plugin.sns.j.e.a(9, "", 0, 0, cf.aCL(), ((SnsObject)localObject1).Id, com.tencent.mm.plugin.sns.j.e.ztz.zuk);
            com.tencent.mm.plugin.sns.j.e.ztz.zuj = 0;
          }
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95614);
          return;
          paramq.bI(((SnsObject)localObject1).toByteArray());
        }
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.NetSceneSnsPost", paramArrayOfByte, "", new Object[0]);
          continue;
          paramArrayOfByte = this.zhA.HAQ;
          continue;
          label1962:
          localObject3 = String.valueOf(paramInt1);
          ad.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", new Object[] { localObject3, localObject2, Long.valueOf(l), paramq });
          locala = (n.a)paramArrayOfByte.ito.get(localObject3);
          if (locala != null)
          {
            locala.itD = String.valueOf(l);
            locala.itC = paramq;
            locala.dyY = ((String)localObject2);
            paramArrayOfByte.a(locala.icO, (String)localObject3);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.model.r
 * JD-Core Version:    0.7.0.1
 */