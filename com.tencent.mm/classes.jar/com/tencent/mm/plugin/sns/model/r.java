package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.g.a.pk.a;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.g.a.pl.a;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.g.a.yf;
import com.tencent.mm.g.a.yf.a;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yg.a;
import com.tencent.mm.g.b.a.dw;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.sns.k.j;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.bwn;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cuk;
import com.tencent.mm.protocal.protobuf.cuw;
import com.tencent.mm.protocal.protobuf.cvk;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
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
  public com.tencent.mm.al.g callback;
  int dzf;
  int fYF;
  private com.tencent.mm.sdk.b.c fYI;
  private com.tencent.mm.sdk.b.c fYJ;
  boolean fuh;
  private com.tencent.mm.al.b rr;
  private TimeLineObject wFk;
  private TimeLineObject wFl;
  long wFm;
  private int wFn;
  private yf wFo;
  private yg wFp;
  int wFq;
  private HashMap<Integer, Integer> wFr;
  String wFs;
  HashMap<String, bpi> wFt;
  HashMap<String, Integer> wFu;
  String wFv;
  
  public r(String paramString1, int paramInt1, int paramInt2, List<String> paramList, TimeLineObject paramTimeLineObject, int paramInt3, String paramString2, int paramInt4, LinkedList<Long> paramLinkedList, int paramInt5, bpj parambpj, boolean paramBoolean, LinkedList<cmf> paramLinkedList1, cvk paramcvk, com.tencent.mm.bx.b paramb, String paramString3, int paramInt6, String paramString4)
  {
    AppMethodBeat.i(95612);
    this.wFm = 0L;
    this.fuh = false;
    this.wFn = 0;
    this.wFr = new HashMap();
    this.fYF = 0;
    this.wFs = "";
    this.wFt = new HashMap();
    this.wFu = new HashMap();
    this.wFv = "";
    this.fYI = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(pl paramAnonymouspl)
      {
        AppMethodBeat.i(95608);
        if (!r.this.wFu.containsKey(paramAnonymouspl.dva.filePath))
        {
          AppMethodBeat.o(95608);
          return false;
        }
        int i = ((Integer)r.this.wFu.remove(paramAnonymouspl.dva.filePath)).intValue();
        try
        {
          str1 = URLEncoder.encode(paramAnonymouspl.dva.result, "UTF-8");
          if (r.this.fYF != 0)
          {
            bpi localbpi = (bpi)r.this.wFt.get(paramAnonymouspl.dva.filePath);
            r.this.wFs += String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s&codeType=%d|", new Object[] { Integer.valueOf(i), str1, localbpi.DNe, localbpi.Url, Integer.valueOf(paramAnonymouspl.dva.deB) });
          }
          if (r.this.wFq == 12)
          {
            str1 = "2,3,,".concat(String.valueOf(str1));
            paramAnonymouspl = str1;
            if (i != 0) {}
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          try
          {
            String str1;
            paramAnonymouspl = str1 + "," + URLEncoder.encode(r.this.wFv, "UTF-8");
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(i), paramAnonymouspl });
            com.tencent.mm.plugin.report.service.h.vKh.kvStat(13717, paramAnonymouspl);
            r.a(r.this);
            AppMethodBeat.o(95608);
            return false;
            localUnsupportedEncodingException = localUnsupportedEncodingException;
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneSnsPost", localUnsupportedEncodingException, "", new Object[0]);
            str2 = "";
          }
          catch (UnsupportedEncodingException paramAnonymouspl)
          {
            for (;;)
            {
              String str2;
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneSnsPost", "", new Object[] { paramAnonymouspl.getMessage() });
              paramAnonymouspl = str2;
            }
          }
        }
      }
    };
    this.fYJ = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(pk paramAnonymouspk)
      {
        AppMethodBeat.i(95610);
        if (!r.this.wFu.containsKey(paramAnonymouspk.duZ.filePath))
        {
          AppMethodBeat.o(95610);
          return false;
        }
        paramAnonymouspk = (Integer)r.this.wFu.remove(paramAnonymouspk.duZ.filePath);
        if (paramAnonymouspk == null)
        {
          AppMethodBeat.o(95610);
          return false;
        }
        int i = paramAnonymouspk.intValue();
        String str;
        if (r.this.wFq == 12)
        {
          str = "2,3,,";
          paramAnonymouspk = str;
          if (i != 0) {}
        }
        try
        {
          paramAnonymouspk = "2,3,," + "," + URLEncoder.encode(r.this.wFv, "UTF-8");
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(i), paramAnonymouspk });
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(13717, paramAnonymouspk);
          r.a(r.this);
          AppMethodBeat.o(95610);
          return false;
        }
        catch (UnsupportedEncodingException paramAnonymouspk)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneSnsPost", "", new Object[] { paramAnonymouspk.getMessage() });
            paramAnonymouspk = str;
          }
        }
      }
    };
    this.wFk = paramTimeLineObject;
    this.dzf = paramInt3;
    this.wFq = paramInt5;
    localObject1 = new b.a();
    ((b.a)localObject1).gUU = new cvl();
    ((b.a)localObject1).gUV = new cvm();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnspost";
    ((b.a)localObject1).funcId = 209;
    ((b.a)localObject1).reqCmdId = 97;
    ((b.a)localObject1).respCmdId = 1000000097;
    this.rr = ((b.a)localObject1).atI();
    cvl localcvl = (cvl)this.rr.gUS.gUX;
    if (!TextUtils.isEmpty(paramTimeLineObject.wLl.CuY.CuT))
    {
      localObject1 = new ql();
      ((ql)localObject1).CPj = paramTimeLineObject.wLl.CuY.CuT;
      localcvl.Enc = ((ql)localObject1);
    }
    localObject1 = y.arz().tC(parambpj.sessionId);
    Object localObject2;
    if (localObject1 != null)
    {
      this.wFo = new yf();
      this.wFo.dEv.dEw = ((y.b)localObject1).getString("prePublishId", "");
      this.wFo.dEv.url = ((y.b)localObject1).getString("url", "");
      this.wFo.dEv.dEy = ((y.b)localObject1).getString("preUsername", "");
      this.wFo.dEv.dEz = ((y.b)localObject1).getString("preChatName", "");
      this.wFo.dEv.dEA = ((y.b)localObject1).getInt("preMsgIndex", 0);
      this.wFo.dEv.dEE = ((y.b)localObject1).getInt("sendAppMsgScene", 0);
      this.wFo.dEv.dEF = ((y.b)localObject1).getInt("getA8KeyScene", 0);
      this.wFo.dEv.dEG = ((y.b)localObject1).getString("referUrl", null);
      this.wFo.dEv.dEH = ((y.b)localObject1).getString("adExtStr", null);
      this.wFo.dEv.dEI = paramString3;
      if (((y.b)localObject1).containsKey("_tmpl_webview_transfer_scene"))
      {
        this.wFp = new yg();
        this.wFp.dEL.dEM = ((y.b)localObject1).getInt("_tmpl_webview_transfer_scene", -1);
      }
      localObject1 = "";
      paramString3 = (String)localObject1;
      if (paramTimeLineObject.xns != null)
      {
        localObject2 = new cxi();
        paramString3 = Base64.decode(paramTimeLineObject.xns, 0);
      }
    }
    try
    {
      ((cxi)localObject2).parseFrom(paramString3);
      paramString3 = (String)localObject1;
      if (((cxi)localObject2).Epv != null) {
        paramString3 = ((cxi)localObject2).Epv.rVL;
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
      if (paramTimeLineObject.Etl != null) {
        localObject1 = paramTimeLineObject.Etl.Id;
      }
    }
    localcvl.Enb = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.wFo.dEv.dEw, this.wFo.dEv.dEy, this.wFo.dEv.dEz, Integer.valueOf(com.tencent.mm.model.x.aw(this.wFo.dEv.dEy, this.wFo.dEv.dEz)), Integer.valueOf(this.wFo.dEv.dEF), localObject1 });
    paramString3 = new SKBuiltinBuffer_t();
    paramString3.setBuffer(paramString1.getBytes());
    i = paramString1.length();
    j = paramString3.getILen();
    if (paramb == null) {}
    for (paramInt3 = 0;; paramInt3 = paramb.wA.length)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsPost", "len:%d   skb:%d ctx.len:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt3) });
      localcvl.ObjectDesc = paramString3;
      localcvl.EmW = paramInt1;
      localcvl.DNo = paramInt2;
      localcvl.gKn = paramString2;
      this.wFn = paramInt1;
      if (com.tencent.mm.platformtools.ab.hVe)
      {
        localcvl.ObjectDesc = new SKBuiltinBuffer_t();
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneSnsPost", "post error setObjectDesc is null!");
      }
      paramString3 = new LinkedList();
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label982;
      }
      paramList = paramList.iterator();
      for (paramString1 = ""; paramList.hasNext(); paramString1 = paramString1 + "; + " + (String)localObject1)
      {
        localObject1 = (String)paramList.next();
        localObject2 = new cmf();
        ((cmf)localObject2).aEE((String)localObject1);
        paramString3.add(localObject2);
      }
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneSnsPost", "post with list : ".concat(String.valueOf(paramString1)));
    label982:
    localcvl.WithUserList = paramString3;
    localcvl.WithUserListCount = paramString3.size();
    localcvl.EmX = paramInt4;
    paramString1 = localcvl.Enb;
    if (parambpj.DNF != null)
    {
      paramInt1 = parambpj.DNF.Emm;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsPost", "setObjectSource: %d, clientid:%s fromScene:%s, score:%d, sdkTokenValid:%s, sdkPkgName:%s", new Object[] { Integer.valueOf(paramInt5), paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt6), paramString4 });
      if ((paramLinkedList1 != null) && (paramLinkedList1.size() > 0))
      {
        if (!paramBoolean) {
          break label1269;
        }
        localcvl.BlackList = paramLinkedList1;
        localcvl.BlackListCount = paramLinkedList1.size();
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneSnsPost", "setObjectSource ".concat(String.valueOf(paramInt5)));
      localcvl.EmY = paramInt5;
      paramString1 = new dew();
      if (!bt.isNullOrNil(parambpj.token))
      {
        paramString1.Ewv = parambpj.token;
        paramString1.Eww = parambpj.DNx;
        localcvl.DXy = paramString1;
      }
      if ((paramLinkedList == null) || (paramLinkedList.isEmpty())) {
        break label1333;
      }
      localcvl.GroupCount = paramLinkedList.size();
      paramString1 = paramLinkedList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (Long)paramString1.next();
        paramString2 = new cuw();
        paramString2.EmE = paramList.longValue();
        localcvl.DNu.add(paramString2);
      }
      paramInt1 = 0;
      break;
      label1269:
      localcvl.GroupUser = paramLinkedList1;
      localcvl.GroupUserCount = paramLinkedList1.size();
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneSnsPost", "tagid " + paramLinkedList.size() + " " + localcvl.DNu.toString());
    label1333:
    localcvl.DNz = paramcvk;
    if (!bt.isNullOrNil(parambpj.DNB)) {
      localcvl.SnsRedEnvelops = new cvp();
    }
    if (paramcvk != null) {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneSnsPost", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { paramcvk.CyI, paramcvk.CyJ, paramcvk.CyK });
    }
    if (paramb != null) {
      localcvl.Ena = new SKBuiltinBuffer_t().setBuffer(paramb);
    }
    localcvl.Enf = parambpj.DNF;
    paramString1 = af.dtu().Ne(this.dzf);
    if ((paramString1 != null) && ((paramString1.field_type == 1) || (paramString1.field_type == 15)) && (paramTimeLineObject.Etm != null) && (paramTimeLineObject.Etm.DaC != null) && (paramTimeLineObject.Etm.DaC.size() > 0) && (parambpj.DNp != null) && (parambpj.DNp.size() == paramTimeLineObject.Etm.DaC.size()))
    {
      paramString1 = af.getAccSnsPath();
      paramList = paramTimeLineObject.Etm.DaC.iterator();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramList.hasNext())
      {
        paramLinkedList = (bpi)paramList.next();
        if ((paramLinkedList.mBH == 2) || (paramLinkedList.mBH == 6))
        {
          paramTimeLineObject = new bpg();
          if (paramLinkedList.mBH != 2) {
            break label1859;
          }
          paramInt2 = 2;
          label1612:
          paramTimeLineObject.rNT = paramInt2;
          if (paramLinkedList.mBH == 6)
          {
            paramString2 = an.iF(paramString1, paramLinkedList.Id);
            paramLinkedList = com.tencent.mm.plugin.sns.data.q.o(paramLinkedList);
            paramString2 = com.tencent.mm.plugin.sight.base.e.ano(paramString2 + paramLinkedList);
            if (paramString2 != null) {
              paramTimeLineObject.DMN = ((int)Math.round(paramString2.videoDuration / 1000.0D));
            }
          }
          paramString2 = (bmh)parambpj.DNp.get(paramInt1);
          paramString2 = af.dtj().ti(paramString2.DJN);
        }
      }
      try
      {
        paramLinkedList = (bpl)new bpl().parseFrom(paramString2.xjn);
        paramTimeLineObject.rNz = paramLinkedList.DNR;
        this.wFr.put(Integer.valueOf(paramString2.xiB), Integer.valueOf(paramLinkedList.DNR));
        label1777:
        paramTimeLineObject.CzY = parambpj.sessionId;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsPost", "post add mediaInfo, Source: %s, videoPlayLength: %s, MediaType: %s, SessionId: %s", new Object[] { Integer.valueOf(paramTimeLineObject.rNz), Integer.valueOf(paramTimeLineObject.DMN), Integer.valueOf(paramTimeLineObject.rNT), paramTimeLineObject.CzY });
        localcvl.Ene.add(paramTimeLineObject);
        paramInt1 += 1;
        continue;
        label1859:
        paramInt2 = 1;
        break label1612;
        localcvl.End = localcvl.Ene.size();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsPost", "post mediaCount: %s", new Object[] { Integer.valueOf(localcvl.End) });
        if (com.tencent.mm.plugin.normsg.a.b.ufs.aju("ie_sns_upload")) {
          com.tencent.mm.plugin.normsg.a.b.ufs.ajt("ie_sns_upload");
        }
        for (;;)
        {
          try
          {
            paramString1 = new dow();
            paramString1.EFa = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.ajv("ie_sns_upload"));
            if (paramString1.EFa == null) {
              continue;
            }
            paramInt1 = paramString1.EFa.getILen();
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneSnsPost", "[debug] wcstf set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            paramString1.EFb = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.ajy("ce_sns_upload"));
            if (paramString1.EFb == null) {
              continue;
            }
            paramInt1 = paramString1.EFb.getILen();
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneSnsPost", "[debug] wcste set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            paramString1.EFc = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.cWU());
            if (paramString1.EFc == null) {
              continue;
            }
            paramInt1 = paramString1.EFc.getILen();
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneSnsPost", "[debug] ccData set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            localcvl.CBU = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
          }
          catch (Throwable paramString1)
          {
            continue;
          }
          paramString1 = new bwn();
          paramString1.CyL = paramInt6;
          paramString1.rZy = paramString4;
          localcvl.Eng = paramString1;
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
    if ((paramTimeLineObject1 == null) || (paramTimeLineObject2 == null) || (paramTimeLineObject1.Etm == null) || (paramTimeLineObject2.Etm == null))
    {
      AppMethodBeat.o(95616);
      return false;
    }
    String str1 = af.getAccSnsPath();
    int i = 0;
    while ((i < paramTimeLineObject1.Etm.DaC.size()) && (i < paramTimeLineObject2.Etm.DaC.size()))
    {
      Object localObject2 = (bpi)paramTimeLineObject1.Etm.DaC.get(i);
      Object localObject1 = (bpi)paramTimeLineObject2.Etm.DaC.get(i);
      String str2 = com.tencent.mm.plugin.sns.data.q.l((bpi)localObject2);
      String str3 = com.tencent.mm.plugin.sns.data.q.m((bpi)localObject2);
      String str4 = com.tencent.mm.plugin.sns.data.q.n((bpi)localObject2);
      String str5 = com.tencent.mm.plugin.sns.data.q.o((bpi)localObject2);
      String str6 = com.tencent.mm.plugin.sns.data.q.k((bpi)localObject1);
      String str7 = com.tencent.mm.plugin.sns.data.q.d((bpi)localObject1);
      String str8 = com.tencent.mm.plugin.sns.data.q.e((bpi)localObject1);
      String str9 = com.tencent.mm.plugin.sns.data.q.i((bpi)localObject1);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + str2 + "  - " + str6);
      localObject2 = an.iF(str1, ((bpi)localObject2).Id);
      localObject1 = an.iF(str1, ((bpi)localObject1).Id);
      com.tencent.mm.vfs.i.aMF((String)localObject1);
      com.tencent.mm.vfs.i.lD((String)localObject2 + str2, (String)localObject1 + str6);
      com.tencent.mm.vfs.i.lD((String)localObject2 + str3, (String)localObject1 + str7);
      com.tencent.mm.vfs.i.lD((String)localObject2 + str4, (String)localObject1 + str8);
      if (com.tencent.mm.vfs.i.eK((String)localObject2 + str5))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsPost", "post done copy file %s", new Object[] { (String)localObject1 + str9 });
        com.tencent.mm.vfs.i.lD((String)localObject2 + str5, (String)localObject1 + str9);
      }
      i += 1;
    }
    AppMethodBeat.o(95616);
    return true;
  }
  
  private void aoy(String paramString)
  {
    AppMethodBeat.i(95615);
    this.wFv = paramString;
    paramString = com.tencent.mm.model.c.d.aty().qu("100132");
    if (paramString.isValid()) {
      this.fYF = bt.getInt((String)paramString.eJy().get("needUploadData"), 1);
    }
    if ((this.wFq != 12) && (this.fYF == 0))
    {
      AppMethodBeat.o(95615);
      return;
    }
    if ((this.wFl != null) && (this.wFl.Etm != null) && (this.wFl.Etm.DaC != null) && (this.wFl.Etm.DaC.size() > 0))
    {
      paramString = this.wFl.Etm.DaC;
      com.tencent.mm.sdk.b.a.ESL.c(this.fYI);
      com.tencent.mm.sdk.b.a.ESL.c(this.fYJ);
      paramString = paramString.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        Object localObject = (bpi)paramString.next();
        if (((bpi)localObject).mBH == 2)
        {
          String str = f.C((bpi)localObject);
          if (!bt.isNullOrNil(str))
          {
            this.wFu.put(str, Integer.valueOf(i));
            this.wFt.put(str, localObject);
            localObject = new pj();
            ((pj)localObject).duX.dcQ = System.currentTimeMillis();
            ((pj)localObject).duX.filePath = str;
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
            i += 1;
          }
        }
      }
    }
    AppMethodBeat.o(95615);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(95613);
    this.callback = paramg;
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsPost", "post netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    cvm localcvm = (cvm)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if (paramInt2 == 4) {
      paramq = af.dtu().Ne(this.dzf);
    }
    try
    {
      paramArrayOfByte = (bpj)new bpj().parseFrom(paramq.field_postBuf);
      paramArrayOfByte.DNw = paramInt3;
      paramArrayOfByte.DND = localcvm.DND;
      paramArrayOfByte.DNE = false;
      paramq.field_postBuf = paramArrayOfByte.toByteArray();
      label145:
      if (paramq != null)
      {
        paramq.dyb();
        af.dtu().b(this.dzf, paramq);
        af.dtt().Mi(this.dzf);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + paramq.dxX());
        paramq = new tt();
        paramq.dzb.dzc = this.dzf;
        com.tencent.mm.sdk.b.a.ESL.l(paramq);
      }
      if ((this.wFk != null) && (this.wFk.Etm != null) && (this.wFk.Etm.DaB == 21))
      {
        com.tencent.mm.plugin.sns.lucky.a.b.lI(8);
        switch (paramInt3)
        {
        default: 
          com.tencent.mm.plugin.sns.lucky.a.b.lI(20);
        }
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
        com.tencent.mm.plugin.sns.lucky.a.b.lI(17);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.lI(19);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.lI(18);
      }
      if (paramInt3 != 0)
      {
        af.dtt().Mi(this.dzf);
        if ((this.wFk != null) && (this.wFk.Etm != null) && (this.wFk.Etm.DaB == 21))
        {
          com.tencent.mm.plugin.sns.lucky.a.b.lI(8);
          com.tencent.mm.plugin.sns.lucky.a.b.lI(16);
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
      }
      if ((localcvm.ElO == null) || (localcvm.ElO.ObjectDesc == null) || (localcvm.ElO.ObjectDesc.getBuffer() == null))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
        af.dtt().Mi(this.dzf);
        paramq = af.dtu().Ne(this.dzf);
        if (paramq != null)
        {
          paramq.dya();
          af.dtu().b(this.dzf, paramq);
          paramq = new tv();
          paramq.dzh.dzc = this.dzf;
          com.tencent.mm.sdk.b.a.ESL.l(paramq);
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
      }
      Object localObject1 = new String(localcvm.ElO.ObjectDesc.getBuffer().toByteArray());
      if (this.wFn == 0) {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneSnsPost", "resp " + (String)localObject1 + "  ");
      }
      this.wFl = com.tencent.mm.modelsns.g.zn((String)localObject1);
      Object localObject2;
      Object localObject3;
      if (this.wFl.Etr != null)
      {
        paramq = this.wFl.Id;
        paramArrayOfByte = this.wFl.Etr.gJC;
        localObject2 = this.wFl.Etr.gJB;
        localObject3 = new com.tencent.mm.modelsns.f();
        ((com.tencent.mm.modelsns.f)localObject3).o("20CurrPublishId", paramq + ",");
        ((com.tencent.mm.modelsns.f)localObject3).o("20SourcePublishId", paramArrayOfByte + ",");
        ((com.tencent.mm.modelsns.f)localObject3).o("20SourceAdUxInfo", (String)localObject2 + ",");
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + ((com.tencent.mm.modelsns.f)localObject3).PW());
        com.tencent.mm.plugin.report.service.h.vKh.f(13004, new Object[] { localObject3 });
      }
      paramArrayOfByte = af.dtu().Ne(this.dzf);
      paramq = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneSnsPost", "the item has delete");
        paramq = new p();
      }
      paramq.setCreateTime(localcvm.ElO.CreateTime);
      paramq.apI((String)localObject1);
      paramq.field_localFlag &= 0xFFFFFFEF;
      paramq.td(localcvm.ElO.Id);
      paramq.tf(localcvm.ElO.Id);
      if ((localcvm.ElO.ExtFlag & 0x1) > 0) {
        paramq.dxU();
      }
      this.wFm = localcvm.ElO.Id;
      if (this.wFo != null)
      {
        this.wFo.dEv.dEx = ("sns_" + com.tencent.mm.plugin.sns.data.q.st(this.wFm));
        com.tencent.mm.sdk.b.a.ESL.l(this.wFo);
      }
      if ((this.wFp != null) && (this.wFp.dEL.dEM != -1)) {
        com.tencent.mm.sdk.b.a.ESL.l(this.wFp);
      }
      localObject1 = localcvm.ElO;
      ((SnsObject)localObject1).ObjectDesc.setBuffer(new byte[0]);
      try
      {
        if ((((SnsObject)localObject1).CommentUserListCount == 0) && (((SnsObject)localObject1).LikeUserListCount == 0) && (((SnsObject)localObject1).WithUserListCount == 0) && (((SnsObject)localObject1).GroupCount == 0)) {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneSnsPost", "no use! this buf");
        }
        for (;;)
        {
          paramq.dya();
          af.dtu().delete(this.wFm);
          af.dtu().b(this.dzf, paramq);
          af.dtt().Mi(this.dzf);
          if (((this.wFk.Etm.DaB == 1) && (this.wFk.evt == 0) && (this.wFl.evt == 1)) || ((this.wFk.Etm.DaB == 15) && (this.wFk.Ett == 0) && (this.wFl.Ett == 1) && (com.tencent.mm.plugin.sns.storage.i.ta(com.tencent.mm.plugin.sns.storage.x.anz(paramq.getSnsId()))))) {
            new ap(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95607);
                t.dsP();
                AppMethodBeat.o(95607);
              }
            });
          }
          paramArrayOfByte = com.tencent.mm.plugin.sns.k.h.wRM.dD(Integer.valueOf(this.dzf));
          if ((paramArrayOfByte != null) && (this.wFl != null))
          {
            paramArrayOfByte.aBg();
            paramArrayOfByte.aBh();
            paramArrayOfByte.zk(this.wFl.Id);
            paramArrayOfByte.oH(this.wFl.Etm.DaB);
            paramArrayOfByte.aBj();
          }
          paramArrayOfByte = com.tencent.mm.plugin.sns.k.i.wRM.dD(Integer.valueOf(this.dzf));
          if ((paramArrayOfByte != null) && (this.wFl != null))
          {
            paramArrayOfByte.aBg();
            paramArrayOfByte.aBh();
            paramArrayOfByte.zk(this.wFl.Id);
            paramArrayOfByte.oH(this.wFl.Etm.DaB);
            paramArrayOfByte.aBj();
          }
          paramArrayOfByte = new tv();
          paramArrayOfByte.dzh.dzc = this.dzf;
          com.tencent.mm.sdk.b.a.ESL.l(paramArrayOfByte);
          if (paramq.field_type == 21)
          {
            com.tencent.mm.plugin.sns.lucky.a.b.lI(7);
            System.currentTimeMillis();
          }
          a(this.wFk, this.wFl);
          if (this.wFl != null) {
            break;
          }
          paramArrayOfByte = "";
          aoy(paramArrayOfByte);
          if (af.dtq() != null) {
            af.dtq().drS();
          }
          try
          {
            if (paramq.field_type == 15)
            {
              paramInt1 = ((bmh)((bpj)new bpj().parseFrom(paramq.field_postBuf)).DNp.getFirst()).DJN;
              if (paramInt1 > 0)
              {
                localObject2 = (bpi)this.wFl.Etm.DaC.get(0);
                if (localObject2 != null)
                {
                  paramq = an.iF(af.getAccSnsPath(), ((bpi)localObject2).Id) + com.tencent.mm.plugin.sns.data.q.i((bpi)localObject2);
                  paramArrayOfByte = com.tencent.mm.modelvideo.n.aCG();
                  localObject2 = ((bpi)localObject2).Url;
                  l = ((SnsObject)localObject1).Id;
                  if (!bt.isNullOrNil((String)localObject2))
                  {
                    boolean bool = bt.isNullOrNil(paramq);
                    if (!bool) {
                      break label1864;
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
          paramq = new tu();
          paramq.dzd.dze = l;
          paramq.dzd.dzf = this.dzf;
          paramq.dzd.dzg = this.wFr;
          com.tencent.mm.sdk.b.a.ESL.l(paramq);
          l = ((SnsObject)localObject1).Id;
          paramq = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fxt, "");
          if (!bt.isNullOrNil(paramq))
          {
            ((com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class)).T("snspublicid", com.tencent.mm.plugin.sns.data.q.st(l), paramq);
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fxt, "");
          }
          paramq = com.tencent.mm.plugin.sns.k.f.wQY.wRg;
          paramq.dWd = paramq.t("Published", com.tencent.mm.plugin.sns.data.q.st(localcvm.ElO.Id), true);
          com.tencent.mm.plugin.sns.k.f.wQY.duV();
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95614);
          return;
          paramq.bC(((SnsObject)localObject1).toByteArray());
        }
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneSnsPost", paramArrayOfByte, "", new Object[0]);
          continue;
          paramArrayOfByte = this.wFl.Etj;
          continue;
          label1864:
          localObject3 = String.valueOf(paramInt1);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", new Object[] { localObject3, localObject2, Long.valueOf(l), paramq });
          locala = (n.a)paramArrayOfByte.hzs.get(localObject3);
          if (locala != null)
          {
            locala.hzH = String.valueOf(l);
            locala.hzG = paramq;
            locala.dpz = ((String)localObject2);
            paramArrayOfByte.a(locala.hyW, (String)localObject3);
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