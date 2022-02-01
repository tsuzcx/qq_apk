package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.g.a.aax;
import com.tencent.mm.g.a.aax.a;
import com.tencent.mm.g.a.aay;
import com.tencent.mm.g.a.aay.a;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qy.a;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.qz.a;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.g.a.vz;
import com.tencent.mm.g.a.wa;
import com.tencent.mm.g.b.a.dz;
import com.tencent.mm.g.b.a.ht;
import com.tencent.mm.g.b.a.kb;
import com.tencent.mm.g.b.a.ke;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.protocal.protobuf.cmz;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.cwz;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dzk;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.eam;
import com.tencent.mm.protocal.protobuf.ean;
import com.tencent.mm.protocal.protobuf.eao;
import com.tencent.mm.protocal.protobuf.ear;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.ecm;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.protocal.protobuf.ekv;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.tt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class t
  extends com.tencent.mm.ak.q
  implements com.tencent.mm.network.m
{
  private aax DIA;
  private aay DIB;
  int DIC;
  private HashMap<Integer, Integer> DID;
  String DIE;
  HashMap<String, cnb> DIF;
  HashMap<String, Integer> DIG;
  private HashMap<Integer, Integer> DIH;
  String DII;
  private TimeLineObject DIx;
  private TimeLineObject DIy;
  private int DIz;
  long Dyz;
  public com.tencent.mm.ak.i callback;
  int ecf;
  boolean gyp;
  int hmp;
  private IListener hms;
  private IListener hmt;
  private com.tencent.mm.ak.d rr;
  
  public t(String paramString1, int paramInt1, int paramInt2, List<String> paramList, TimeLineObject paramTimeLineObject, int paramInt3, String paramString2, int paramInt4, LinkedList<Long> paramLinkedList, int paramInt5, cnc paramcnc, boolean paramBoolean, LinkedList<dqi> paramLinkedList1, eam parameam, com.tencent.mm.bw.b paramb, String paramString3, int paramInt6, String paramString4)
  {
    AppMethodBeat.i(95612);
    this.Dyz = 0L;
    this.gyp = false;
    this.DIz = 0;
    this.DID = new HashMap();
    this.hmp = 0;
    this.DIE = "";
    this.DIF = new HashMap();
    this.DIG = new HashMap();
    this.DIH = new HashMap();
    this.DII = "";
    this.hms = new IListener()
    {
      private boolean a(qz paramAnonymousqz)
      {
        AppMethodBeat.i(95608);
        if (!t.this.DIG.containsKey(paramAnonymousqz.dXz.filePath))
        {
          Log.e("MicroMsg.NetSceneSnsPost", "recog succ, but not found %s", new Object[] { paramAnonymousqz.dXz.filePath });
          AppMethodBeat.o(95608);
          return false;
        }
        int i = ((Integer)t.this.DIG.remove(paramAnonymousqz.dXz.filePath)).intValue();
        try
        {
          localObject1 = URLEncoder.encode(paramAnonymousqz.dXz.result, "UTF-8");
          localcnb = null;
          if (t.this.hmp != 0)
          {
            localcnb = (cnb)t.this.DIF.get(paramAnonymousqz.dXz.filePath);
            t.this.DIE += String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s&codeType=%d|", new Object[] { Integer.valueOf(i), localObject1, localcnb.MsM, localcnb.Url, Integer.valueOf(paramAnonymousqz.dXz.dFL) });
          }
          if (t.this.DIC == 12)
          {
            str1 = "2,3,,".concat(String.valueOf(localObject1));
            localObject1 = str1;
            if (i != 0) {}
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          try
          {
            cnb localcnb;
            Object localObject1 = str1 + "," + URLEncoder.encode(t.this.DII, "UTF-8");
            Log.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(i), localObject1 });
            com.tencent.mm.plugin.report.service.h.CyF.kvStat(13717, (String)localObject1);
            t.a(t.this);
            localObject1 = t.this;
            str1 = paramAnonymousqz.dXz.filePath;
            String str2 = paramAnonymousqz.dXz.result;
            if (localcnb != null)
            {
              paramAnonymousqz = localcnb.MsG;
              if (t.a(t.this, i) != 1) {
                break label431;
              }
              i = 3;
              t.a((t)localObject1, str1, str2, paramAnonymousqz, i);
              AppMethodBeat.o(95608);
              return false;
              localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
              Log.printErrStackTrace("MicroMsg.NetSceneSnsPost", localUnsupportedEncodingException1, "", new Object[0]);
              localObject1 = "";
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException2)
          {
            for (;;)
            {
              String str1;
              Log.e("MicroMsg.NetSceneSnsPost", "", new Object[] { localUnsupportedEncodingException2.getMessage() });
              Object localObject2 = str1;
              continue;
              paramAnonymousqz = "";
              continue;
              label431:
              i = 2;
            }
          }
        }
      }
    };
    this.hmt = new IListener()
    {
      private boolean a(qy paramAnonymousqy)
      {
        int i = 2;
        AppMethodBeat.i(95610);
        if (!t.this.DIG.containsKey(paramAnonymousqy.dXy.filePath))
        {
          Log.e("MicroMsg.NetSceneSnsPost", "recog succ, but not found %s", new Object[] { paramAnonymousqy.dXy.filePath });
          AppMethodBeat.o(95610);
          return false;
        }
        Object localObject1 = (Integer)t.this.DIG.remove(paramAnonymousqy.dXy.filePath);
        if (localObject1 == null)
        {
          AppMethodBeat.o(95610);
          return false;
        }
        int j = ((Integer)localObject1).intValue();
        Object localObject3;
        if (t.this.DIC == 12)
        {
          localObject3 = "2,3,,";
          localObject1 = localObject3;
          if (j != 0) {}
        }
        try
        {
          localObject1 = "2,3,," + "," + URLEncoder.encode(t.this.DII, "UTF-8");
          Log.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(j), localObject1 });
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(13717, (String)localObject1);
          t.a(t.this);
          if (t.this.hmp != 0)
          {
            localObject1 = (cnb)t.this.DIF.get(paramAnonymousqy.dXy.filePath);
            localObject3 = t.this;
            String str = paramAnonymousqy.dXy.filePath;
            if (localObject1 != null)
            {
              paramAnonymousqy = ((cnb)localObject1).MsG;
              if (t.a(t.this, j) == 1) {
                i = 3;
              }
              t.a((t)localObject3, str, null, paramAnonymousqy, i);
              AppMethodBeat.o(95610);
              return false;
            }
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            Log.e("MicroMsg.NetSceneSnsPost", "", new Object[] { localUnsupportedEncodingException.getMessage() });
            Object localObject2 = localObject3;
            continue;
            paramAnonymousqy = "";
            continue;
            localObject2 = null;
          }
        }
      }
    };
    this.DIx = paramTimeLineObject;
    this.ecf = paramInt3;
    this.DIC = paramInt5;
    localObject1 = new d.a();
    ((d.a)localObject1).iLN = new ean();
    ((d.a)localObject1).iLO = new eao();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnspost";
    ((d.a)localObject1).funcId = 209;
    ((d.a)localObject1).iLP = 97;
    ((d.a)localObject1).respCmdId = 1000000097;
    this.rr = ((d.a)localObject1).aXF();
    ean localean = (ean)this.rr.iLK.iLR;
    if (!TextUtils.isEmpty(paramTimeLineObject.actionInfo.KEw.KEr))
    {
      localObject1 = new tt();
      ((tt)localObject1).Lcd = paramTimeLineObject.actionInfo.KEw.KEr;
      localean.MZX = ((tt)localObject1);
    }
    localObject1 = ad.aVe().JW(paramcnc.sessionId);
    Object localObject2;
    if (localObject1 != null)
    {
      this.DIA = new aax();
      this.DIA.ehN.ehO = ((ad.b)localObject1).getString("prePublishId", "");
      this.DIA.ehN.url = ((ad.b)localObject1).getString("url", "");
      this.DIA.ehN.ehQ = ((ad.b)localObject1).getString("preUsername", "");
      this.DIA.ehN.ehR = ((ad.b)localObject1).getString("preChatName", "");
      this.DIA.ehN.ehS = ((ad.b)localObject1).getInt("preMsgIndex", 0);
      this.DIA.ehN.ehW = ((ad.b)localObject1).getInt("sendAppMsgScene", 0);
      this.DIA.ehN.ehX = ((ad.b)localObject1).getInt("getA8KeyScene", 0);
      this.DIA.ehN.ehY = ((ad.b)localObject1).getString("referUrl", null);
      this.DIA.ehN.ehZ = ((ad.b)localObject1).getString("adExtStr", null);
      this.DIA.ehN.eia = paramString3;
      if (((ad.b)localObject1).containsKey("_tmpl_webview_transfer_scene"))
      {
        this.DIB = new aay();
        this.DIB.eid.eie = ((ad.b)localObject1).getInt("_tmpl_webview_transfer_scene", -1);
      }
      localObject1 = "";
      paramString3 = (String)localObject1;
      if (paramTimeLineObject.statExtStr != null)
      {
        localObject2 = new eco();
        paramString3 = Base64.decode(paramTimeLineObject.statExtStr, 0);
      }
    }
    try
    {
      ((eco)localObject2).parseFrom(paramString3);
      paramString3 = (String)localObject1;
      if (((eco)localObject2).NcJ != null) {
        paramString3 = ((eco)localObject2).NcJ.xEN;
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
    if (Util.isNullOrNil(paramString3))
    {
      localObject1 = paramString3;
      if (paramTimeLineObject.AppInfo != null) {
        localObject1 = paramTimeLineObject.AppInfo.Id;
      }
    }
    localean.MZW = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.DIA.ehN.ehO, this.DIA.ehN.ehQ, this.DIA.ehN.ehR, Integer.valueOf(com.tencent.mm.model.ac.aJ(this.DIA.ehN.ehQ, this.DIA.ehN.ehR)), Integer.valueOf(this.DIA.ehN.ehX), localObject1 });
    paramString3 = new SKBuiltinBuffer_t();
    paramString3.setBuffer(paramString1.getBytes());
    i = paramString1.length();
    j = paramString3.getILen();
    if (paramb == null) {}
    for (paramInt3 = 0;; paramInt3 = paramb.zy.length)
    {
      Log.i("MicroMsg.NetSceneSnsPost", "len:%d   skb:%d ctx.len:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt3) });
      localean.ObjectDesc = paramString3;
      localean.MZR = paramInt1;
      localean.MsV = paramInt2;
      localean.izX = paramString2;
      this.DIz = paramInt1;
      if (com.tencent.mm.platformtools.ac.jOd)
      {
        localean.ObjectDesc = new SKBuiltinBuffer_t();
        Log.e("MicroMsg.NetSceneSnsPost", "post error setObjectDesc is null!");
      }
      paramString3 = new LinkedList();
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label993;
      }
      paramList = paramList.iterator();
      for (paramString1 = ""; paramList.hasNext(); paramString1 = paramString1 + "; + " + (String)localObject1)
      {
        localObject1 = (String)paramList.next();
        localObject2 = new dqi();
        ((dqi)localObject2).bhy((String)localObject1);
        paramString3.add(localObject2);
      }
    }
    Log.d("MicroMsg.NetSceneSnsPost", "post with list : ".concat(String.valueOf(paramString1)));
    label993:
    localean.WithUserList = paramString3;
    localean.WithUserListCount = paramString3.size();
    localean.MZS = paramInt4;
    paramString1 = localean.MZW;
    if (paramcnc.Mtm != null)
    {
      paramInt1 = paramcnc.Mtm.MZf;
      Log.i("MicroMsg.NetSceneSnsPost", "setObjectSource: %d, clientid:%s fromScene:%s, score:%d, sdkTokenValid:%s, sdkPkgName:%s", new Object[] { Integer.valueOf(paramInt5), paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt6), paramString4 });
      if ((paramLinkedList1 != null) && (paramLinkedList1.size() > 0))
      {
        if (!paramBoolean) {
          break label1280;
        }
        localean.BlackList = paramLinkedList1;
        localean.BlackListCount = paramLinkedList1.size();
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneSnsPost", "setObjectSource ".concat(String.valueOf(paramInt5)));
      localean.MZT = paramInt5;
      paramString1 = new ekv();
      if (!Util.isNullOrNil(paramcnc.token))
      {
        paramString1.Nke = paramcnc.token;
        paramString1.Nkf = paramcnc.Mte;
        localean.MID = paramString1;
      }
      if ((paramLinkedList == null) || (paramLinkedList.isEmpty())) {
        break label1344;
      }
      localean.GroupCount = paramLinkedList.size();
      paramString1 = paramLinkedList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (Long)paramString1.next();
        paramString2 = new dzw();
        paramString2.MZv = paramList.longValue();
        localean.Mtb.add(paramString2);
      }
      paramInt1 = 0;
      break;
      label1280:
      localean.GroupUser = paramLinkedList1;
      localean.GroupUserCount = paramLinkedList1.size();
    }
    Log.d("MicroMsg.NetSceneSnsPost", "tagid " + paramLinkedList.size() + " " + localean.Mtb.toString());
    label1344:
    localean.Mtg = parameam;
    if (!Util.isNullOrNil(paramcnc.Mti)) {
      localean.SnsRedEnvelops = new ear();
    }
    if (parameam != null) {
      Log.d("MicroMsg.NetSceneSnsPost", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { parameam.KIC, parameam.KID, parameam.KIE });
    }
    if (paramb != null) {
      localean.MZV = new SKBuiltinBuffer_t().setBuffer(paramb);
    }
    localean.Naa = paramcnc.Mtm;
    paramString1 = aj.faO().Zr(this.ecf);
    if ((paramString1 != null) && ((paramString1.getTypeFlag() == 1) || (paramString1.getTypeFlag() == 15)) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.LoV != null) && (paramTimeLineObject.ContentObj.LoV.size() > 0) && (paramcnc.MsW != null) && (paramcnc.MsW.size() == paramTimeLineObject.ContentObj.LoV.size()))
    {
      paramString1 = aj.getAccSnsPath();
      paramList = paramTimeLineObject.ContentObj.LoV.iterator();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramList.hasNext())
      {
        paramLinkedList = (cnb)paramList.next();
        if ((paramLinkedList.oUv == 2) || (paramLinkedList.oUv == 6))
        {
          paramTimeLineObject = new cmz();
          if (paramLinkedList.oUv != 2) {
            break label1870;
          }
          paramInt2 = 2;
          label1623:
          paramTimeLineObject.xuT = paramInt2;
          if (paramLinkedList.oUv == 6)
          {
            paramString2 = ar.ki(paramString1, paramLinkedList.Id);
            paramLinkedList = com.tencent.mm.plugin.sns.data.r.p(paramLinkedList);
            paramString2 = com.tencent.mm.plugin.sight.base.e.aNx(paramString2 + paramLinkedList);
            if (paramString2 != null) {
              paramTimeLineObject.Msw = ((int)Math.round(paramString2.videoDuration / 1000.0D));
            }
          }
          paramString2 = (cjs)paramcnc.MsW.get(paramInt1);
          paramString2 = aj.faD().JK(paramString2.Mpj);
        }
      }
      try
      {
        paramLinkedList = (cne)new cne().parseFrom(paramString2.EmR);
        paramTimeLineObject.xub = paramLinkedList.Mty;
        this.DID.put(Integer.valueOf(paramString2.localid), Integer.valueOf(paramLinkedList.Mty));
        label1788:
        paramTimeLineObject.SessionId = paramcnc.sessionId;
        Log.i("MicroMsg.NetSceneSnsPost", "post add mediaInfo, Source: %s, videoPlayLength: %s, MediaType: %s, SessionId: %s", new Object[] { Integer.valueOf(paramTimeLineObject.xub), Integer.valueOf(paramTimeLineObject.Msw), Integer.valueOf(paramTimeLineObject.xuT), paramTimeLineObject.SessionId });
        localean.MZZ.add(paramTimeLineObject);
        paramInt1 += 1;
        continue;
        label1870:
        paramInt2 = 1;
        break label1623;
        localean.MZY = localean.MZZ.size();
        Log.i("MicroMsg.NetSceneSnsPost", "post mediaCount: %s", new Object[] { Integer.valueOf(localean.MZY) });
        if (com.tencent.mm.plugin.normsg.a.d.AEF.aIO("ie_sns_upload")) {
          com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_sns_upload");
        }
        for (;;)
        {
          try
          {
            paramString1 = new ewf();
            paramString1.NtO = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.aIP("ie_sns_upload"));
            if (paramString1.NtO == null) {
              continue;
            }
            paramInt1 = paramString1.NtO.getILen();
            Log.d("MicroMsg.NetSceneSnsPost", "[debug] wcstf set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            paramString1.NtP = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.aIS("ce_sns_upload"));
            if (paramString1.NtP == null) {
              continue;
            }
            paramInt1 = paramString1.NtP.getILen();
            Log.d("MicroMsg.NetSceneSnsPost", "[debug] wcste set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            paramString1.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.exJ());
            if (paramString1.NtQ == null) {
              continue;
            }
            paramInt1 = paramString1.NtQ.getILen();
            Log.d("MicroMsg.NetSceneSnsPost", "[debug] ccData set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            localean.KLQ = new SKBuiltinBuffer_t().setBuffer(paramString1.toByteArray());
          }
          catch (Throwable paramString1)
          {
            continue;
          }
          if ((paramcnc == null) || (paramcnc.Mth == null)) {
            continue;
          }
          paramString1 = paramcnc.Mth.iterator();
          paramInt1 = 0;
          if (!paramString1.hasNext()) {
            continue;
          }
          paramList = (eas)paramString1.next();
          this.DIH.put(Integer.valueOf(paramInt1), Integer.valueOf(paramList.Nam));
          paramInt1 += 1;
          continue;
          paramInt1 = -1;
          continue;
          paramInt1 = -1;
          continue;
          paramInt1 = -1;
        }
        paramString1 = new cwz();
        paramString1.KIF = paramInt6;
        paramString1.xuk = paramString4;
        localean.Nab = paramString1;
        AppMethodBeat.o(95612);
        return;
      }
      catch (Exception paramString2)
      {
        break label1788;
      }
    }
  }
  
  private static boolean a(TimeLineObject paramTimeLineObject1, TimeLineObject paramTimeLineObject2)
  {
    AppMethodBeat.i(95616);
    if ((paramTimeLineObject1 == null) || (paramTimeLineObject2 == null) || (paramTimeLineObject1.ContentObj == null) || (paramTimeLineObject2.ContentObj == null))
    {
      AppMethodBeat.o(95616);
      return false;
    }
    String str1 = aj.getAccSnsPath();
    int i = 0;
    while ((i < paramTimeLineObject1.ContentObj.LoV.size()) && (i < paramTimeLineObject2.ContentObj.LoV.size()))
    {
      Object localObject2 = (cnb)paramTimeLineObject1.ContentObj.LoV.get(i);
      Object localObject1 = (cnb)paramTimeLineObject2.ContentObj.LoV.get(i);
      String str2 = com.tencent.mm.plugin.sns.data.r.m((cnb)localObject2);
      String str3 = com.tencent.mm.plugin.sns.data.r.n((cnb)localObject2);
      String str4 = com.tencent.mm.plugin.sns.data.r.o((cnb)localObject2);
      String str5 = com.tencent.mm.plugin.sns.data.r.p((cnb)localObject2);
      String str6 = com.tencent.mm.plugin.sns.data.r.l((cnb)localObject1);
      String str7 = com.tencent.mm.plugin.sns.data.r.e((cnb)localObject1);
      String str8 = com.tencent.mm.plugin.sns.data.r.f((cnb)localObject1);
      String str9 = com.tencent.mm.plugin.sns.data.r.j((cnb)localObject1);
      Log.d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + str2 + "  - " + str6);
      localObject2 = ar.ki(str1, ((cnb)localObject2).Id);
      localObject1 = ar.ki(str1, ((cnb)localObject1).Id);
      com.tencent.mm.vfs.s.boN((String)localObject1);
      com.tencent.mm.vfs.s.nx((String)localObject2 + str2, (String)localObject1 + str6);
      com.tencent.mm.vfs.s.nx((String)localObject2 + str3, (String)localObject1 + str7);
      com.tencent.mm.vfs.s.nx((String)localObject2 + str4, (String)localObject1 + str8);
      if (com.tencent.mm.vfs.s.YS((String)localObject2 + str5))
      {
        Log.i("MicroMsg.NetSceneSnsPost", "post done copy file %s", new Object[] { (String)localObject1 + str9 });
        com.tencent.mm.vfs.s.nx((String)localObject2 + str5, (String)localObject1 + str9);
      }
      i += 1;
    }
    AppMethodBeat.o(95616);
    return true;
  }
  
  private void aPc(String paramString)
  {
    AppMethodBeat.i(95615);
    this.DII = paramString;
    paramString = com.tencent.mm.model.c.d.aXu().Fu("100132");
    if (paramString.isValid()) {
      this.hmp = Util.getInt((String)paramString.gzz().get("needUploadData"), 1);
    }
    if ((this.DIC != 12) && (this.hmp == 0))
    {
      AppMethodBeat.o(95615);
      return;
    }
    if ((this.DIy != null) && (this.DIy.ContentObj != null) && (this.DIy.ContentObj.LoV != null) && (this.DIy.ContentObj.LoV.size() > 0))
    {
      paramString = this.DIy.ContentObj.LoV;
      EventCenter.instance.addListener(this.hms);
      EventCenter.instance.addListener(this.hmt);
      paramString = paramString.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        Object localObject = (cnb)paramString.next();
        if (((cnb)localObject).oUv == 2)
        {
          String str = g.D((cnb)localObject);
          if (!Util.isNullOrNil(str))
          {
            this.DIG.put(str, Integer.valueOf(i));
            this.DIF.put(str, localObject);
            localObject = new qx();
            ((qx)localObject).dXu.dDZ = System.nanoTime();
            ((qx)localObject).dXu.filePath = str;
            EventCenter.instance.publish((IEvent)localObject);
            i += 1;
          }
        }
      }
    }
    AppMethodBeat.o(95615);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(95613);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95613);
    return i;
  }
  
  public final int getType()
  {
    return 209;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95614);
    Log.i("MicroMsg.NetSceneSnsPost", "post netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    eao localeao = (eao)((com.tencent.mm.ak.d)params).iLL.iLR;
    if (paramInt2 == 4) {
      params = aj.faO().Zr(this.ecf);
    }
    try
    {
      paramArrayOfByte = (cnc)new cnc().parseFrom(params.field_postBuf);
      paramArrayOfByte.Mtd = paramInt3;
      paramArrayOfByte.Mtk = localeao.Mtk;
      paramArrayOfByte.Mtl = false;
      params.setPostBuf(paramArrayOfByte.toByteArray());
      if (params != null)
      {
        params.setItemDie();
        aj.faO().d(this.ecf, params);
        aj.faN().Yv(this.ecf);
        Log.d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + params.getLocalid());
        params = new vy();
        params.ecb.ecc = this.ecf;
        EventCenter.instance.publish(params);
      }
      if ((this.DIx != null) && (this.DIx.ContentObj != null) && (this.DIx.ContentObj.LoU == 21))
      {
        com.tencent.mm.plugin.sns.lucky.a.b.pl(8);
        switch (paramInt3)
        {
        default: 
          com.tencent.mm.plugin.sns.lucky.a.b.pl(20);
        }
      }
      for (;;)
      {
        if (com.tencent.mm.plugin.sns.k.e.DUQ.DVD == this.ecf)
        {
          com.tencent.mm.plugin.sns.k.e.DUQ.DVE.esJ = 1L;
          com.tencent.mm.plugin.sns.k.e.DUQ.fcF();
          com.tencent.mm.plugin.sns.k.e.DUQ.DVD = 0;
        }
        if (com.tencent.mm.plugin.sns.k.e.DUQ.DVF == this.ecf)
        {
          com.tencent.mm.plugin.sns.k.e.DUQ.DVG.esJ = 1L;
          com.tencent.mm.plugin.sns.k.e.DUQ.fcG();
          com.tencent.mm.plugin.sns.k.e.DUQ.DVF = 0;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
        com.tencent.mm.plugin.sns.lucky.a.b.pl(17);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.pl(19);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.pl(18);
      }
      if (paramInt3 != 0)
      {
        aj.faN().Yv(this.ecf);
        if ((this.DIx != null) && (this.DIx.ContentObj != null) && (this.DIx.ContentObj.LoU == 21))
        {
          com.tencent.mm.plugin.sns.lucky.a.b.pl(8);
          com.tencent.mm.plugin.sns.lucky.a.b.pl(16);
        }
        if (com.tencent.mm.plugin.sns.k.e.DUQ.DVD == this.ecf)
        {
          com.tencent.mm.plugin.sns.k.e.DUQ.DVE.esJ = 1L;
          com.tencent.mm.plugin.sns.k.e.DUQ.fcF();
          com.tencent.mm.plugin.sns.k.e.DUQ.DVD = 0;
        }
        if (com.tencent.mm.plugin.sns.k.e.DUQ.DVF == this.ecf)
        {
          com.tencent.mm.plugin.sns.k.e.DUQ.DVG.esJ = 1L;
          com.tencent.mm.plugin.sns.k.e.DUQ.fcG();
          com.tencent.mm.plugin.sns.k.e.DUQ.DVF = 0;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
      }
      if ((localeao.MYH == null) || (localeao.MYH.ObjectDesc == null) || (localeao.MYH.ObjectDesc.getBuffer() == null))
      {
        Log.e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
        aj.faN().Yv(this.ecf);
        params = aj.faO().Zr(this.ecf);
        if (params != null)
        {
          params.clearItemDie();
          aj.faO().d(this.ecf, params);
          params = new wa();
          params.ech.ecc = this.ecf;
          EventCenter.instance.publish(params);
        }
        if (com.tencent.mm.plugin.sns.k.e.DUQ.DVD == this.ecf)
        {
          com.tencent.mm.plugin.sns.k.e.DUQ.DVE.esJ = 1L;
          com.tencent.mm.plugin.sns.k.e.DUQ.fcF();
          com.tencent.mm.plugin.sns.k.e.DUQ.DVD = 0;
        }
        if (com.tencent.mm.plugin.sns.k.e.DUQ.DVF == this.ecf)
        {
          com.tencent.mm.plugin.sns.k.e.DUQ.DVG.esJ = 1L;
          com.tencent.mm.plugin.sns.k.e.DUQ.fcG();
          com.tencent.mm.plugin.sns.k.e.DUQ.DVF = 0;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
      }
      paramArrayOfByte = new String(localeao.MYH.ObjectDesc.getBuffer().toByteArray());
      if (this.DIz == 0) {
        Log.d("MicroMsg.NetSceneSnsPost", "resp " + paramArrayOfByte + "  ");
      }
      this.DIy = com.tencent.mm.modelsns.n.PM(paramArrayOfByte);
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (this.DIy.streamvideo != null)
      {
        params = this.DIy.Id;
        localObject1 = this.DIy.streamvideo.izg;
        localObject2 = this.DIy.streamvideo.izf;
        localObject3 = new com.tencent.mm.modelsns.m();
        ((com.tencent.mm.modelsns.m)localObject3).n("20CurrPublishId", params + ",");
        ((com.tencent.mm.modelsns.m)localObject3).n("20SourcePublishId", (String)localObject1 + ",");
        ((com.tencent.mm.modelsns.m)localObject3).n("20SourceAdUxInfo", (String)localObject2 + ",");
        Log.i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + ((com.tencent.mm.modelsns.m)localObject3).abW());
        com.tencent.mm.plugin.report.service.h.CyF.a(13004, new Object[] { localObject3 });
      }
      params = aj.faO().Zr(this.ecf);
      if (params == null)
      {
        Log.e("MicroMsg.NetSceneSnsPost", "the item has delete");
        params = new SnsInfo();
        params.setCreateTime(localeao.MYH.CreateTime);
        params.setContent(paramArrayOfByte);
        params.setPostFinish();
        params.setSnsId(localeao.MYH.Id);
        params.setStringSeq(localeao.MYH.Id);
        if ((localeao.MYH.ExtFlag & 0x1) > 0) {
          params.setExtFlag();
        }
        this.Dyz = localeao.MYH.Id;
        if (this.DIA != null)
        {
          this.DIA.ehN.ehP = ("sns_" + com.tencent.mm.plugin.sns.data.r.Jb(this.Dyz));
          EventCenter.instance.publish(this.DIA);
        }
        if ((this.DIB != null) && (this.DIB.eid.eie != -1)) {
          EventCenter.instance.publish(this.DIB);
        }
        localObject1 = localeao.MYH;
        ((SnsObject)localObject1).ObjectDesc.setBuffer(new byte[0]);
        try
        {
          if ((((SnsObject)localObject1).CommentUserListCount == 0) && (((SnsObject)localObject1).LikeUserListCount == 0) && (((SnsObject)localObject1).WithUserListCount == 0) && (((SnsObject)localObject1).GroupCount == 0)) {
            Log.d("MicroMsg.NetSceneSnsPost", "no use! this buf");
          }
          for (;;)
          {
            params.clearItemDie();
            aj.faO().delete(this.Dyz);
            aj.faO().d(this.ecf, params);
            aj.faN().Yv(this.ecf);
            if (((this.DIx.ContentObj.LoU == 1) && (this.DIx.showFlag == 0) && (this.DIy.showFlag == 1)) || ((this.DIx.ContentObj.LoU == 15) && (this.DIx.sightFolded == 0) && (this.DIy.sightFolded == 1) && (com.tencent.mm.plugin.sns.storage.g.JG(y.aOa(params.getSnsId()))))) {
              new MMHandler(Looper.getMainLooper()).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(95607);
                  v.fai();
                  AppMethodBeat.o(95607);
                }
              });
            }
            paramArrayOfByte = com.tencent.mm.plugin.sns.k.g.DVR.dR(Integer.valueOf(this.ecf));
            if ((paramArrayOfByte != null) && (this.DIy != null))
            {
              paramArrayOfByte.bfH();
              paramArrayOfByte.bfI();
              paramArrayOfByte.PJ(this.DIy.Id);
              paramArrayOfByte.tR(this.DIy.ContentObj.LoU);
              paramArrayOfByte.bfK();
            }
            paramArrayOfByte = com.tencent.mm.plugin.sns.k.h.DVR.dR(Integer.valueOf(this.ecf));
            if ((paramArrayOfByte != null) && (this.DIy != null))
            {
              paramArrayOfByte.bfH();
              paramArrayOfByte.bfI();
              paramArrayOfByte.PJ(this.DIy.Id);
              paramArrayOfByte.tR(this.DIy.ContentObj.LoU);
              paramArrayOfByte.bfK();
            }
            paramArrayOfByte = new wa();
            paramArrayOfByte.ech.ecc = this.ecf;
            EventCenter.instance.publish(paramArrayOfByte);
            if (params.getTypeFlag() == 21)
            {
              params.getPravited();
              com.tencent.mm.plugin.sns.lucky.a.b.pl(7);
              System.currentTimeMillis();
            }
            a(this.DIx, this.DIy);
            if (this.DIy != null) {
              break;
            }
            paramArrayOfByte = "";
            aPc(paramArrayOfByte);
            if (aj.faK() != null) {
              aj.faK().eZn();
            }
            try
            {
              if (params.getTypeFlag() == 15)
              {
                paramInt1 = ((cjs)((cnc)new cnc().parseFrom(params.getPostBuf())).MsW.getFirst()).Mpj;
                if (paramInt1 > 0)
                {
                  localObject3 = (cnb)this.DIy.ContentObj.LoV.get(0);
                  if (localObject3 != null)
                  {
                    paramArrayOfByte = ar.ki(aj.getAccSnsPath(), ((cnb)localObject3).Id) + com.tencent.mm.plugin.sns.data.r.j((cnb)localObject3);
                    localObject2 = com.tencent.mm.modelvideo.n.bhh();
                    localObject3 = ((cnb)localObject3).Url;
                    l = ((SnsObject)localObject1).Id;
                    if (!Util.isNullOrNil((String)localObject3))
                    {
                      boolean bool = Util.isNullOrNil(paramArrayOfByte);
                      if (!bool) {
                        break label2309;
                      }
                    }
                  }
                }
              }
            }
            catch (Exception paramArrayOfByte)
            {
              long l;
              label1839:
              String str;
              n.a locala;
              break label1839;
            }
            l = ((SnsObject)localObject1).Id;
            paramArrayOfByte = new vz();
            paramArrayOfByte.ecd.ece = l;
            paramArrayOfByte.ecd.ecf = this.ecf;
            paramArrayOfByte.ecd.ecg = this.DID;
            EventCenter.instance.publish(paramArrayOfByte);
            l = ((SnsObject)localObject1).Id;
            paramArrayOfByte = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Onx, "");
            if (!Util.isNullOrNil(paramArrayOfByte))
            {
              ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).aa("snspublicid", com.tencent.mm.plugin.sns.data.r.Jb(l), paramArrayOfByte);
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Onx, "");
            }
            paramArrayOfByte = com.tencent.mm.plugin.sns.k.e.DUQ.DVa;
            paramArrayOfByte.eTz = paramArrayOfByte.x("Published", com.tencent.mm.plugin.sns.data.r.Jb(localeao.MYH.Id), true);
            com.tencent.mm.plugin.sns.k.e.DUQ.fcw();
            if (com.tencent.mm.plugin.sns.k.e.DUQ.DVA.eUb == 1L)
            {
              paramArrayOfByte = com.tencent.mm.plugin.sns.k.e.DUQ.DVA;
              paramArrayOfByte.eUd = paramArrayOfByte.x("NextPublishId", com.tencent.mm.plugin.sns.data.r.Jc(((SnsObject)localObject1).Id), true);
              com.tencent.mm.plugin.sns.k.e.DUQ.fcE();
            }
            if (com.tencent.mm.plugin.sns.k.e.DUQ.DVC == this.ecf)
            {
              paramArrayOfByte = com.tencent.mm.plugin.sns.k.e.DUQ;
              com.tencent.mm.plugin.sns.k.e.a(9, "", 0, 0, cl.aWz(), ((SnsObject)localObject1).Id, com.tencent.mm.plugin.sns.k.e.DUQ.Aqq, 0);
              com.tencent.mm.plugin.sns.k.e.DUQ.DVC = 0;
            }
            if (com.tencent.mm.plugin.sns.k.e.DUQ.DVD == this.ecf)
            {
              com.tencent.mm.plugin.sns.k.e.DUQ.DVE.esJ = 2L;
              paramArrayOfByte = com.tencent.mm.plugin.sns.k.e.DUQ.DVE;
              paramArrayOfByte.epf = paramArrayOfByte.x("Publishid", com.tencent.mm.plugin.sns.data.r.Jc(params.field_snsId), true);
              com.tencent.mm.plugin.sns.k.e.DUQ.fcF();
              com.tencent.mm.plugin.sns.k.e.DUQ.DVD = 0;
            }
            if (com.tencent.mm.plugin.sns.k.e.DUQ.DVF == this.ecf)
            {
              com.tencent.mm.plugin.sns.k.e.DUQ.DVG.esJ = 2L;
              paramArrayOfByte = com.tencent.mm.plugin.sns.k.e.DUQ.DVG;
              paramArrayOfByte.epf = paramArrayOfByte.x("Publishid", com.tencent.mm.plugin.sns.data.r.Jc(params.field_snsId), true);
              com.tencent.mm.plugin.sns.k.e.DUQ.fcG();
              com.tencent.mm.plugin.sns.k.e.DUQ.DVF = 0;
            }
            this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
            AppMethodBeat.o(95614);
            return;
            params.setAttrBuf(((SnsObject)localObject1).toByteArray());
          }
        }
        catch (IOException paramArrayOfByte)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.NetSceneSnsPost", paramArrayOfByte, "", new Object[0]);
            continue;
            paramArrayOfByte = this.DIy.ContentDesc;
            continue;
            label2309:
            str = String.valueOf(paramInt1);
            Log.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", new Object[] { str, localObject3, Long.valueOf(l), paramArrayOfByte });
            locala = (n.a)((com.tencent.mm.modelvideo.n)localObject2).jrv.get(str);
            if (locala != null)
            {
              locala.jrM = String.valueOf(l);
              locala.jrL = paramArrayOfByte;
              locala.dRP = ((String)localObject3);
              ((com.tencent.mm.modelvideo.n)localObject2).a(locala.jaC, str, "", l);
            }
          }
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.t
 * JD-Core Version:    0.7.0.1
 */