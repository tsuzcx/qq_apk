package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.g.a.pt.a;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.pu.a;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.g.a.ud;
import com.tencent.mm.g.a.ue;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.g.a.yq.a;
import com.tencent.mm.g.a.yr;
import com.tencent.mm.g.a.yr.a;
import com.tencent.mm.g.b.a.fm;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.j.j;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.protocal.protobuf.cbh;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.dai;
import com.tencent.mm.protocal.protobuf.daw;
import com.tencent.mm.protocal.protobuf.dax;
import com.tencent.mm.protocal.protobuf.day;
import com.tencent.mm.protocal.protobuf.dbb;
import com.tencent.mm.protocal.protobuf.dcs;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.protocal.protobuf.dkl;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.qv;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  extends com.tencent.mm.ak.n
  implements k
{
  public com.tencent.mm.ak.g callback;
  int dwR;
  boolean fxO;
  int gdl;
  private com.tencent.mm.sdk.b.c gdo;
  private com.tencent.mm.sdk.b.c gdp;
  private com.tencent.mm.ak.b rr;
  long xLI;
  private TimeLineObject xRF;
  private TimeLineObject xRG;
  private int xRH;
  private yq xRI;
  private yr xRJ;
  int xRK;
  private HashMap<Integer, Integer> xRL;
  String xRM;
  HashMap<String, btz> xRN;
  HashMap<String, Integer> xRO;
  String xRP;
  
  public r(String paramString1, int paramInt1, int paramInt2, List<String> paramList, TimeLineObject paramTimeLineObject, int paramInt3, String paramString2, int paramInt4, LinkedList<Long> paramLinkedList, int paramInt5, bua parambua, boolean paramBoolean, LinkedList<crm> paramLinkedList1, daw paramdaw, com.tencent.mm.bw.b paramb, String paramString3, int paramInt6, String paramString4)
  {
    AppMethodBeat.i(95612);
    this.xLI = 0L;
    this.fxO = false;
    this.xRH = 0;
    this.xRL = new HashMap();
    this.gdl = 0;
    this.xRM = "";
    this.xRN = new HashMap();
    this.xRO = new HashMap();
    this.xRP = "";
    this.gdo = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(pu paramAnonymouspu)
      {
        AppMethodBeat.i(95608);
        if (!r.this.xRO.containsKey(paramAnonymouspu.dsM.filePath))
        {
          AppMethodBeat.o(95608);
          return false;
        }
        int i = ((Integer)r.this.xRO.remove(paramAnonymouspu.dsM.filePath)).intValue();
        try
        {
          str1 = URLEncoder.encode(paramAnonymouspu.dsM.result, "UTF-8");
          if (r.this.gdl != 0)
          {
            btz localbtz = (btz)r.this.xRN.get(paramAnonymouspu.dsM.filePath);
            r.this.xRM += String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s&codeType=%d|", new Object[] { Integer.valueOf(i), str1, localbtz.Fjv, localbtz.Url, Integer.valueOf(paramAnonymouspu.dsM.dbX) });
          }
          if (r.this.xRK == 12)
          {
            str1 = "2,3,,".concat(String.valueOf(str1));
            paramAnonymouspu = str1;
            if (i != 0) {}
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          try
          {
            String str1;
            paramAnonymouspu = str1 + "," + URLEncoder.encode(r.this.xRP, "UTF-8");
            ac.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(i), paramAnonymouspu });
            com.tencent.mm.plugin.report.service.h.wUl.kvStat(13717, paramAnonymouspu);
            r.a(r.this);
            AppMethodBeat.o(95608);
            return false;
            localUnsupportedEncodingException = localUnsupportedEncodingException;
            ac.printErrStackTrace("MicroMsg.NetSceneSnsPost", localUnsupportedEncodingException, "", new Object[0]);
            str2 = "";
          }
          catch (UnsupportedEncodingException paramAnonymouspu)
          {
            for (;;)
            {
              String str2;
              ac.e("MicroMsg.NetSceneSnsPost", "", new Object[] { paramAnonymouspu.getMessage() });
              paramAnonymouspu = str2;
            }
          }
        }
      }
    };
    this.gdp = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(pt paramAnonymouspt)
      {
        AppMethodBeat.i(95610);
        if (!r.this.xRO.containsKey(paramAnonymouspt.dsL.filePath))
        {
          AppMethodBeat.o(95610);
          return false;
        }
        paramAnonymouspt = (Integer)r.this.xRO.remove(paramAnonymouspt.dsL.filePath);
        if (paramAnonymouspt == null)
        {
          AppMethodBeat.o(95610);
          return false;
        }
        int i = paramAnonymouspt.intValue();
        String str;
        if (r.this.xRK == 12)
        {
          str = "2,3,,";
          paramAnonymouspt = str;
          if (i != 0) {}
        }
        try
        {
          paramAnonymouspt = "2,3,," + "," + URLEncoder.encode(r.this.xRP, "UTF-8");
          ac.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(i), paramAnonymouspt });
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(13717, paramAnonymouspt);
          r.a(r.this);
          AppMethodBeat.o(95610);
          return false;
        }
        catch (UnsupportedEncodingException paramAnonymouspt)
        {
          for (;;)
          {
            ac.e("MicroMsg.NetSceneSnsPost", "", new Object[] { paramAnonymouspt.getMessage() });
            paramAnonymouspt = str;
          }
        }
      }
    };
    this.xRF = paramTimeLineObject;
    this.dwR = paramInt3;
    this.xRK = paramInt5;
    localObject1 = new b.a();
    ((b.a)localObject1).hvt = new dax();
    ((b.a)localObject1).hvu = new day();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnspost";
    ((b.a)localObject1).funcId = 209;
    ((b.a)localObject1).reqCmdId = 97;
    ((b.a)localObject1).respCmdId = 1000000097;
    this.rr = ((b.a)localObject1).aAz();
    dax localdax = (dax)this.rr.hvr.hvw;
    if (!TextUtils.isEmpty(paramTimeLineObject.xXR.DNt.DNo))
    {
      localObject1 = new qv();
      ((qv)localObject1).EhU = paramTimeLineObject.xXR.DNt.DNo;
      localdax.FKb = ((qv)localObject1);
    }
    localObject1 = y.ayq().xI(parambua.sessionId);
    Object localObject2;
    if (localObject1 != null)
    {
      this.xRI = new yq();
      this.xRI.dCh.dCi = ((y.b)localObject1).getString("prePublishId", "");
      this.xRI.dCh.url = ((y.b)localObject1).getString("url", "");
      this.xRI.dCh.dCk = ((y.b)localObject1).getString("preUsername", "");
      this.xRI.dCh.dCl = ((y.b)localObject1).getString("preChatName", "");
      this.xRI.dCh.dCm = ((y.b)localObject1).getInt("preMsgIndex", 0);
      this.xRI.dCh.dCq = ((y.b)localObject1).getInt("sendAppMsgScene", 0);
      this.xRI.dCh.dCr = ((y.b)localObject1).getInt("getA8KeyScene", 0);
      this.xRI.dCh.dCs = ((y.b)localObject1).getString("referUrl", null);
      this.xRI.dCh.dCt = ((y.b)localObject1).getString("adExtStr", null);
      this.xRI.dCh.dCu = paramString3;
      if (((y.b)localObject1).containsKey("_tmpl_webview_transfer_scene"))
      {
        this.xRJ = new yr();
        this.xRJ.dCx.dCy = ((y.b)localObject1).getInt("_tmpl_webview_transfer_scene", -1);
      }
      localObject1 = "";
      paramString3 = (String)localObject1;
      if (paramTimeLineObject.yAj != null)
      {
        localObject2 = new dcu();
        paramString3 = Base64.decode(paramTimeLineObject.yAj, 0);
      }
    }
    try
    {
      ((dcu)localObject2).parseFrom(paramString3);
      paramString3 = (String)localObject1;
      if (((dcu)localObject2).FMu != null) {
        paramString3 = ((dcu)localObject2).FMu.tdD;
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
    if (bs.isNullOrNil(paramString3))
    {
      localObject1 = paramString3;
      if (paramTimeLineObject.FQn != null) {
        localObject1 = paramTimeLineObject.FQn.Id;
      }
    }
    localdax.FKa = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.xRI.dCh.dCi, this.xRI.dCh.dCk, this.xRI.dCh.dCl, Integer.valueOf(com.tencent.mm.model.x.aE(this.xRI.dCh.dCk, this.xRI.dCh.dCl)), Integer.valueOf(this.xRI.dCh.dCr), localObject1 });
    paramString3 = new SKBuiltinBuffer_t();
    paramString3.setBuffer(paramString1.getBytes());
    i = paramString1.length();
    j = paramString3.getILen();
    if (paramb == null) {}
    for (paramInt3 = 0;; paramInt3 = paramb.xy.length)
    {
      ac.i("MicroMsg.NetSceneSnsPost", "len:%d   skb:%d ctx.len:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt3) });
      localdax.ObjectDesc = paramString3;
      localdax.FJV = paramInt1;
      localdax.FjF = paramInt2;
      localdax.hkN = paramString2;
      this.xRH = paramInt1;
      if (ab.ivi)
      {
        localdax.ObjectDesc = new SKBuiltinBuffer_t();
        ac.e("MicroMsg.NetSceneSnsPost", "post error setObjectDesc is null!");
      }
      paramString3 = new LinkedList();
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label982;
      }
      paramList = paramList.iterator();
      for (paramString1 = ""; paramList.hasNext(); paramString1 = paramString1 + "; + " + (String)localObject1)
      {
        localObject1 = (String)paramList.next();
        localObject2 = new crm();
        ((crm)localObject2).aJV((String)localObject1);
        paramString3.add(localObject2);
      }
    }
    ac.d("MicroMsg.NetSceneSnsPost", "post with list : ".concat(String.valueOf(paramString1)));
    label982:
    localdax.WithUserList = paramString3;
    localdax.WithUserListCount = paramString3.size();
    localdax.FJW = paramInt4;
    paramString1 = localdax.FKa;
    if (parambua.FjW != null)
    {
      paramInt1 = parambua.FjW.FJl;
      ac.i("MicroMsg.NetSceneSnsPost", "setObjectSource: %d, clientid:%s fromScene:%s, score:%d, sdkTokenValid:%s, sdkPkgName:%s", new Object[] { Integer.valueOf(paramInt5), paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt6), paramString4 });
      if ((paramLinkedList1 != null) && (paramLinkedList1.size() > 0))
      {
        if (!paramBoolean) {
          break label1269;
        }
        localdax.BlackList = paramLinkedList1;
        localdax.BlackListCount = paramLinkedList1.size();
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.NetSceneSnsPost", "setObjectSource ".concat(String.valueOf(paramInt5)));
      localdax.FJX = paramInt5;
      paramString1 = new dkl();
      if (!bs.isNullOrNil(parambua.token))
      {
        paramString1.FTx = parambua.token;
        paramString1.FTy = parambua.FjO;
        localdax.Fus = paramString1;
      }
      if ((paramLinkedList == null) || (paramLinkedList.isEmpty())) {
        break label1333;
      }
      localdax.GroupCount = paramLinkedList.size();
      paramString1 = paramLinkedList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (Long)paramString1.next();
        paramString2 = new dai();
        paramString2.FJD = paramList.longValue();
        localdax.FjL.add(paramString2);
      }
      paramInt1 = 0;
      break;
      label1269:
      localdax.GroupUser = paramLinkedList1;
      localdax.GroupUserCount = paramLinkedList1.size();
    }
    ac.d("MicroMsg.NetSceneSnsPost", "tagid " + paramLinkedList.size() + " " + localdax.FjL.toString());
    label1333:
    localdax.FjQ = paramdaw;
    if (!bs.isNullOrNil(parambua.FjS)) {
      localdax.SnsRedEnvelops = new dbb();
    }
    if (paramdaw != null) {
      ac.d("MicroMsg.NetSceneSnsPost", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { paramdaw.DRe, paramdaw.DRf, paramdaw.DRg });
    }
    if (paramb != null) {
      localdax.FJZ = new SKBuiltinBuffer_t().setBuffer(paramb);
    }
    localdax.FKe = parambua.FjW;
    paramString1 = af.dHR().Ph(this.dwR);
    if ((paramString1 != null) && ((paramString1.field_type == 1) || (paramString1.field_type == 15)) && (paramTimeLineObject.FQo != null) && (paramTimeLineObject.FQo.Etz != null) && (paramTimeLineObject.FQo.Etz.size() > 0) && (parambua.FjG != null) && (parambua.FjG.size() == paramTimeLineObject.FQo.Etz.size()))
    {
      paramString1 = af.getAccSnsPath();
      paramList = paramTimeLineObject.FQo.Etz.iterator();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramList.hasNext())
      {
        paramLinkedList = (btz)paramList.next();
        if ((paramLinkedList.ndI == 2) || (paramLinkedList.ndI == 6))
        {
          paramTimeLineObject = new btx();
          if (paramLinkedList.ndI != 2) {
            break label1859;
          }
          paramInt2 = 2;
          label1612:
          paramTimeLineObject.sVK = paramInt2;
          if (paramLinkedList.ndI == 6)
          {
            paramString2 = an.jc(paramString1, paramLinkedList.Id);
            paramLinkedList = com.tencent.mm.plugin.sns.data.q.o(paramLinkedList);
            paramString2 = com.tencent.mm.plugin.sight.base.e.asx(paramString2 + paramLinkedList);
            if (paramString2 != null) {
              paramTimeLineObject.Fje = ((int)Math.round(paramString2.videoDuration / 1000.0D));
            }
          }
          paramString2 = (bqx)parambua.FjG.get(paramInt1);
          paramString2 = af.dHG().xL(paramString2.Fgc);
        }
      }
      try
      {
        paramLinkedList = (buc)new buc().parseFrom(paramString2.ywe);
        paramTimeLineObject.sVo = paramLinkedList.Fki;
        this.xRL.put(Integer.valueOf(paramString2.yvp), Integer.valueOf(paramLinkedList.Fki));
        label1777:
        paramTimeLineObject.DSu = parambua.sessionId;
        ac.i("MicroMsg.NetSceneSnsPost", "post add mediaInfo, Source: %s, videoPlayLength: %s, MediaType: %s, SessionId: %s", new Object[] { Integer.valueOf(paramTimeLineObject.sVo), Integer.valueOf(paramTimeLineObject.Fje), Integer.valueOf(paramTimeLineObject.sVK), paramTimeLineObject.DSu });
        localdax.FKd.add(paramTimeLineObject);
        paramInt1 += 1;
        continue;
        label1859:
        paramInt2 = 1;
        break label1612;
        localdax.FKc = localdax.FKd.size();
        ac.i("MicroMsg.NetSceneSnsPost", "post mediaCount: %s", new Object[] { Integer.valueOf(localdax.FKc) });
        if (com.tencent.mm.plugin.normsg.a.b.vor.aos("ie_sns_upload")) {
          com.tencent.mm.plugin.normsg.a.b.vor.aor("ie_sns_upload");
        }
        for (;;)
        {
          try
          {
            paramString1 = new dun();
            paramString1.Gcm = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.aot("ie_sns_upload"));
            if (paramString1.Gcm == null) {
              continue;
            }
            paramInt1 = paramString1.Gcm.getILen();
            ac.d("MicroMsg.NetSceneSnsPost", "[debug] wcstf set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            paramString1.Gcn = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.aow("ce_sns_upload"));
            if (paramString1.Gcn == null) {
              continue;
            }
            paramInt1 = paramString1.Gcn.getILen();
            ac.d("MicroMsg.NetSceneSnsPost", "[debug] wcste set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            paramString1.Gco = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.dkC());
            if (paramString1.Gco == null) {
              continue;
            }
            paramInt1 = paramString1.Gco.getILen();
            ac.d("MicroMsg.NetSceneSnsPost", "[debug] ccData set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            localdax.DUr = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
          }
          catch (Throwable paramString1)
          {
            continue;
          }
          paramString1 = new cbh();
          paramString1.DRh = paramInt6;
          paramString1.thr = paramString4;
          localdax.FKf = paramString1;
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
    if ((paramTimeLineObject1 == null) || (paramTimeLineObject2 == null) || (paramTimeLineObject1.FQo == null) || (paramTimeLineObject2.FQo == null))
    {
      AppMethodBeat.o(95616);
      return false;
    }
    String str1 = af.getAccSnsPath();
    int i = 0;
    while ((i < paramTimeLineObject1.FQo.Etz.size()) && (i < paramTimeLineObject2.FQo.Etz.size()))
    {
      Object localObject2 = (btz)paramTimeLineObject1.FQo.Etz.get(i);
      Object localObject1 = (btz)paramTimeLineObject2.FQo.Etz.get(i);
      String str2 = com.tencent.mm.plugin.sns.data.q.l((btz)localObject2);
      String str3 = com.tencent.mm.plugin.sns.data.q.m((btz)localObject2);
      String str4 = com.tencent.mm.plugin.sns.data.q.n((btz)localObject2);
      String str5 = com.tencent.mm.plugin.sns.data.q.o((btz)localObject2);
      String str6 = com.tencent.mm.plugin.sns.data.q.k((btz)localObject1);
      String str7 = com.tencent.mm.plugin.sns.data.q.d((btz)localObject1);
      String str8 = com.tencent.mm.plugin.sns.data.q.e((btz)localObject1);
      String str9 = com.tencent.mm.plugin.sns.data.q.i((btz)localObject1);
      ac.d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + str2 + "  - " + str6);
      localObject2 = an.jc(str1, ((btz)localObject2).Id);
      localObject1 = an.jc(str1, ((btz)localObject1).Id);
      com.tencent.mm.vfs.i.aSh((String)localObject1);
      com.tencent.mm.vfs.i.ma((String)localObject2 + str2, (String)localObject1 + str6);
      com.tencent.mm.vfs.i.ma((String)localObject2 + str3, (String)localObject1 + str7);
      com.tencent.mm.vfs.i.ma((String)localObject2 + str4, (String)localObject1 + str8);
      if (com.tencent.mm.vfs.i.eA((String)localObject2 + str5))
      {
        ac.i("MicroMsg.NetSceneSnsPost", "post done copy file %s", new Object[] { (String)localObject1 + str9 });
        com.tencent.mm.vfs.i.ma((String)localObject2 + str5, (String)localObject1 + str9);
      }
      i += 1;
    }
    AppMethodBeat.o(95616);
    return true;
  }
  
  private void atK(String paramString)
  {
    AppMethodBeat.i(95615);
    this.xRP = paramString;
    paramString = com.tencent.mm.model.c.d.aAp().tJ("100132");
    if (paramString.isValid()) {
      this.gdl = bs.getInt((String)paramString.eYV().get("needUploadData"), 1);
    }
    if ((this.xRK != 12) && (this.gdl == 0))
    {
      AppMethodBeat.o(95615);
      return;
    }
    if ((this.xRG != null) && (this.xRG.FQo != null) && (this.xRG.FQo.Etz != null) && (this.xRG.FQo.Etz.size() > 0))
    {
      paramString = this.xRG.FQo.Etz;
      com.tencent.mm.sdk.b.a.GpY.c(this.gdo);
      com.tencent.mm.sdk.b.a.GpY.c(this.gdp);
      paramString = paramString.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        Object localObject = (btz)paramString.next();
        if (((btz)localObject).ndI == 2)
        {
          String str = f.C((btz)localObject);
          if (!bs.isNullOrNil(str))
          {
            this.xRO.put(str, Integer.valueOf(i));
            this.xRN.put(str, localObject);
            localObject = new ps();
            ((ps)localObject).dsJ.dao = System.currentTimeMillis();
            ((ps)localObject).dsJ.filePath = str;
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
            i += 1;
          }
        }
      }
    }
    AppMethodBeat.o(95615);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
    ac.i("MicroMsg.NetSceneSnsPost", "post netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    day localday = (day)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if (paramInt2 == 4) {
      paramq = af.dHR().Ph(this.dwR);
    }
    try
    {
      paramArrayOfByte = (bua)new bua().parseFrom(paramq.field_postBuf);
      paramArrayOfByte.FjN = paramInt3;
      paramArrayOfByte.FjU = localday.FjU;
      paramArrayOfByte.FjV = false;
      paramq.field_postBuf = paramArrayOfByte.toByteArray();
      label145:
      if (paramq != null)
      {
        paramq.dMy();
        af.dHR().b(this.dwR, paramq);
        af.dHQ().Ok(this.dwR);
        ac.d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + paramq.dMu());
        paramq = new uc();
        paramq.dwN.dwO = this.dwR;
        com.tencent.mm.sdk.b.a.GpY.l(paramq);
      }
      if ((this.xRF != null) && (this.xRF.FQo != null) && (this.xRF.FQo.Ety == 21))
      {
        com.tencent.mm.plugin.sns.lucky.a.b.lA(8);
        switch (paramInt3)
        {
        default: 
          com.tencent.mm.plugin.sns.lucky.a.b.lA(20);
        }
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
        com.tencent.mm.plugin.sns.lucky.a.b.lA(17);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.lA(19);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.lA(18);
      }
      if (paramInt3 != 0)
      {
        af.dHQ().Ok(this.dwR);
        if ((this.xRF != null) && (this.xRF.FQo != null) && (this.xRF.FQo.Ety == 21))
        {
          com.tencent.mm.plugin.sns.lucky.a.b.lA(8);
          com.tencent.mm.plugin.sns.lucky.a.b.lA(16);
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
      }
      if ((localday.FIN == null) || (localday.FIN.ObjectDesc == null) || (localday.FIN.ObjectDesc.getBuffer() == null))
      {
        ac.e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
        af.dHQ().Ok(this.dwR);
        paramq = af.dHR().Ph(this.dwR);
        if (paramq != null)
        {
          paramq.dMx();
          af.dHR().b(this.dwR, paramq);
          paramq = new ue();
          paramq.dwT.dwO = this.dwR;
          com.tencent.mm.sdk.b.a.GpY.l(paramq);
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
      }
      Object localObject1 = new String(localday.FIN.ObjectDesc.getBuffer().toByteArray());
      if (this.xRH == 0) {
        ac.d("MicroMsg.NetSceneSnsPost", "resp " + (String)localObject1 + "  ");
      }
      this.xRG = com.tencent.mm.modelsns.g.Ds((String)localObject1);
      Object localObject2;
      Object localObject3;
      if (this.xRG.FQt != null)
      {
        paramq = this.xRG.Id;
        paramArrayOfByte = this.xRG.FQt.hkc;
        localObject2 = this.xRG.FQt.hkb;
        localObject3 = new com.tencent.mm.modelsns.f();
        ((com.tencent.mm.modelsns.f)localObject3).n("20CurrPublishId", paramq + ",");
        ((com.tencent.mm.modelsns.f)localObject3).n("20SourcePublishId", paramArrayOfByte + ",");
        ((com.tencent.mm.modelsns.f)localObject3).n("20SourceAdUxInfo", (String)localObject2 + ",");
        ac.i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + ((com.tencent.mm.modelsns.f)localObject3).PS());
        com.tencent.mm.plugin.report.service.h.wUl.f(13004, new Object[] { localObject3 });
      }
      paramArrayOfByte = af.dHR().Ph(this.dwR);
      paramq = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        ac.e("MicroMsg.NetSceneSnsPost", "the item has delete");
        paramq = new p();
      }
      paramq.setCreateTime(localday.FIN.CreateTime);
      paramq.auR((String)localObject1);
      paramq.field_localFlag &= 0xFFFFFFEF;
      paramq.xG(localday.FIN.Id);
      paramq.xI(localday.FIN.Id);
      if ((localday.FIN.ExtFlag & 0x1) > 0) {
        paramq.dMr();
      }
      this.xLI = localday.FIN.Id;
      if (this.xRI != null)
      {
        this.xRI.dCh.dCj = ("sns_" + com.tencent.mm.plugin.sns.data.q.wW(this.xLI));
        com.tencent.mm.sdk.b.a.GpY.l(this.xRI);
      }
      if ((this.xRJ != null) && (this.xRJ.dCx.dCy != -1)) {
        com.tencent.mm.sdk.b.a.GpY.l(this.xRJ);
      }
      localObject1 = localday.FIN;
      ((SnsObject)localObject1).ObjectDesc.setBuffer(new byte[0]);
      try
      {
        if ((((SnsObject)localObject1).CommentUserListCount == 0) && (((SnsObject)localObject1).LikeUserListCount == 0) && (((SnsObject)localObject1).WithUserListCount == 0) && (((SnsObject)localObject1).GroupCount == 0)) {
          ac.d("MicroMsg.NetSceneSnsPost", "no use! this buf");
        }
        for (;;)
        {
          paramq.dMx();
          af.dHR().delete(this.xLI);
          af.dHR().b(this.dwR, paramq);
          af.dHQ().Ok(this.dwR);
          if (((this.xRF.FQo.Ety == 1) && (this.xRF.exP == 0) && (this.xRG.exP == 1)) || ((this.xRF.FQo.Ety == 15) && (this.xRF.FQv == 0) && (this.xRG.FQv == 1) && (com.tencent.mm.plugin.sns.storage.i.xD(com.tencent.mm.plugin.sns.storage.x.asL(paramq.getSnsId()))))) {
            new ao(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95607);
                t.dHn();
                AppMethodBeat.o(95607);
              }
            });
          }
          paramArrayOfByte = com.tencent.mm.plugin.sns.j.h.yes.dE(Integer.valueOf(this.dwR));
          if ((paramArrayOfByte != null) && (this.xRG != null))
          {
            paramArrayOfByte.aHW();
            paramArrayOfByte.aHX();
            paramArrayOfByte.Dp(this.xRG.Id);
            paramArrayOfByte.pv(this.xRG.FQo.Ety);
            paramArrayOfByte.aHZ();
          }
          paramArrayOfByte = com.tencent.mm.plugin.sns.j.i.yes.dE(Integer.valueOf(this.dwR));
          if ((paramArrayOfByte != null) && (this.xRG != null))
          {
            paramArrayOfByte.aHW();
            paramArrayOfByte.aHX();
            paramArrayOfByte.Dp(this.xRG.Id);
            paramArrayOfByte.pv(this.xRG.FQo.Ety);
            paramArrayOfByte.aHZ();
          }
          paramArrayOfByte = new ue();
          paramArrayOfByte.dwT.dwO = this.dwR;
          com.tencent.mm.sdk.b.a.GpY.l(paramArrayOfByte);
          if (paramq.field_type == 21)
          {
            com.tencent.mm.plugin.sns.lucky.a.b.lA(7);
            System.currentTimeMillis();
          }
          a(this.xRF, this.xRG);
          if (this.xRG != null) {
            break;
          }
          paramArrayOfByte = "";
          atK(paramArrayOfByte);
          if (af.dHN() != null) {
            af.dHN().dGr();
          }
          try
          {
            if (paramq.field_type == 15)
            {
              paramInt1 = ((bqx)((bua)new bua().parseFrom(paramq.field_postBuf)).FjG.getFirst()).Fgc;
              if (paramInt1 > 0)
              {
                localObject2 = (btz)this.xRG.FQo.Etz.get(0);
                if (localObject2 != null)
                {
                  paramq = an.jc(af.getAccSnsPath(), ((btz)localObject2).Id) + com.tencent.mm.plugin.sns.data.q.i((btz)localObject2);
                  paramArrayOfByte = com.tencent.mm.modelvideo.n.aJw();
                  localObject2 = ((btz)localObject2).Url;
                  l = ((SnsObject)localObject1).Id;
                  if (!bs.isNullOrNil((String)localObject2))
                  {
                    boolean bool = bs.isNullOrNil(paramq);
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
          paramq = new ud();
          paramq.dwP.dwQ = l;
          paramq.dwP.dwR = this.dwR;
          paramq.dwP.dwS = this.xRL;
          com.tencent.mm.sdk.b.a.GpY.l(paramq);
          l = ((SnsObject)localObject1).Id;
          paramq = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GWn, "");
          if (!bs.isNullOrNil(paramq))
          {
            ((com.tencent.mm.plugin.expt.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.c.class)).T("snspublicid", com.tencent.mm.plugin.sns.data.q.wW(l), paramq);
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWn, "");
          }
          paramq = com.tencent.mm.plugin.sns.j.f.ydE.ydM;
          paramq.dXY = paramq.t("Published", com.tencent.mm.plugin.sns.data.q.wW(localday.FIN.Id), true);
          com.tencent.mm.plugin.sns.j.f.ydE.dJu();
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95614);
          return;
          paramq.bB(((SnsObject)localObject1).toByteArray());
        }
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.NetSceneSnsPost", paramArrayOfByte, "", new Object[0]);
          continue;
          paramArrayOfByte = this.xRG.FQl;
          continue;
          label1864:
          localObject3 = String.valueOf(paramInt1);
          ac.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", new Object[] { localObject3, localObject2, Long.valueOf(l), paramq });
          locala = (n.a)paramArrayOfByte.hZT.get(localObject3);
          if (locala != null)
          {
            locala.iai = String.valueOf(l);
            locala.iah = paramq;
            locala.dnk = ((String)localObject2);
            paramArrayOfByte.a(locala.hZx, (String)localObject3);
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