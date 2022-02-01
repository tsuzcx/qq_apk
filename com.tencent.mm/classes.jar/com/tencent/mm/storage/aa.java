package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.plugin.webcanvas.h;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.a;
import d.n.n;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"BIZTIMELINFO_CARDTYPE_AD", "", "BIZTIMELINFO_CARDTYPE_BIZ", "BIZTIMELINFO_CARDTYPE_RECCARD_CANVAS", "BIZTIMELINFO_CARDTYPE_RECOMMEND", "BIZTIMELINFO_CARDTYPE_UNFOLLOW", "TAG", "", "fillBizMsgItem", "Ljava/util/LinkedList;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "filterDuplicateMsg", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "getExtraFromXML", "", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "values", "", "getFromCanvasXml", "getRecCardAppMsgs", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "insertCanvasCardImmediately", "isCanvasCard", "isContact", "userName", "isTLRecCardWrapperLegal", "onBizRecommendExpt", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "postInsertCanvasCard", "testInsertCard", "style", "duplicateCardId", "getCardType", "parseExtraFromXML", "parseFromXML", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "setCardId", "plugin-biz_release"})
public final class aa
{
  private static boolean An(String paramString)
  {
    AppMethodBeat.i(188844);
    d.g.b.p.h(paramString, "userName");
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azF().BH(paramString);
    if ((localObject != null) && (((an)localObject).ads()))
    {
      AppMethodBeat.o(188844);
      return true;
    }
    if ((localObject == null) || (((an)localObject).adE() <= 0)) {
      au.a.aBQ().a(paramString, "", null);
    }
    AppMethodBeat.o(188844);
    return false;
  }
  
  public static final LinkedList<String> a(w paramw, oc paramoc)
  {
    AppMethodBeat.i(188842);
    d.g.b.p.h(paramw, "info");
    d.g.b.p.h(paramoc, "item");
    LinkedList localLinkedList = new LinkedList();
    if ((!paramw.ftb()) || (paramw.ftk() == null))
    {
      AppMethodBeat.o(188842);
      return localLinkedList;
    }
    paramw = ((Iterable)s(paramw)).iterator();
    label140:
    while (paramw.hasNext())
    {
      ol localol = (ol)paramw.next();
      paramoc.ddt.add(localol.FYs);
      CharSequence localCharSequence = (CharSequence)localol.Gcr;
      if ((localCharSequence == null) || (n.aD(localCharSequence))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label140;
        }
        paramoc.GbH.add(localol.Gcr);
        break;
      }
    }
    AppMethodBeat.o(188842);
    return localLinkedList;
  }
  
  public static final void a(dmq paramdmq, Map<String, String> paramMap)
  {
    AppMethodBeat.i(188839);
    d.g.b.p.h(paramdmq, "wrapper");
    d.g.b.p.h(paramMap, "values");
    b(paramdmq, paramMap);
    AppMethodBeat.o(188839);
  }
  
  public static final void a(w paramw, dmq paramdmq)
  {
    aiq localaiq = null;
    csm localcsm = null;
    AppMethodBeat.i(188849);
    d.g.b.p.h(paramw, "$this$setCardId");
    d.g.b.p.h(paramdmq, "wrapper");
    paramw.field_recommendCardId = "";
    switch (paramdmq.style)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(188849);
      return;
      localaiq = paramdmq.HTS;
      paramdmq = localcsm;
      if (localaiq != null) {
        paramdmq = localaiq.Gaq;
      }
      paramw.field_recommendCardId = paramdmq;
      AppMethodBeat.o(188849);
      return;
      localcsm = paramdmq.HTU;
      paramdmq = localaiq;
      if (localcsm != null) {
        paramdmq = localcsm.cardId;
      }
      paramw.field_recommendCardId = paramdmq;
    }
  }
  
  public static final void a(LinkedList<om> paramLinkedList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(188841);
    d.g.b.p.h(paramLinkedList, "$this$parseFromXML");
    d.g.b.p.h(paramMap, "values");
    int i = 0;
    while (i <= 9)
    {
      Object localObject2 = new StringBuilder(".sysmsg.BizAccountRecommend.BizAccount");
      om localom;
      label323:
      Object localObject3;
      if (i == 0)
      {
        localObject1 = "";
        localObject2 = localObject1;
        if (bu.isNullOrNil((String)paramMap.get((String)localObject2 + ".UserName"))) {
          break;
        }
        localom = new om();
        localom.nIJ = ((String)paramMap.get((String)localObject2 + ".UserName"));
        localom.nJO = ((String)paramMap.get((String)localObject2 + ".NickName"));
        localom.usP = ((String)paramMap.get((String)localObject2 + ".RecommendReason"));
        localom.jfY = ((String)paramMap.get((String)localObject2 + ".Signature"));
        localom.Gcs = ((String)paramMap.get((String)localObject2 + ".BrandIconUrl"));
        localom.Gct = ((String)paramMap.get((String)localObject2 + ".AppMsgRecReason"));
        localom.Gcm = new LinkedList();
        j = 0;
        if (j > 20) {
          break label422;
        }
        localObject3 = new StringBuilder().append((String)localObject2).append(".NegativeFeedbackReason");
        if (j != 0) {
          break label413;
        }
      }
      label413:
      for (Object localObject1 = "";; localObject1 = Integer.valueOf(j))
      {
        localObject1 = (String)paramMap.get(localObject1);
        if (bu.isNullOrNil((String)localObject1)) {
          break label422;
        }
        localom.Gcm.add(localObject1);
        j += 1;
        break label323;
        localObject1 = Integer.valueOf(i);
        break;
      }
      label422:
      localom.Gcn = bu.getInt((String)paramMap.get((String)localObject2 + ".ShowNegativeFeedbackReason"), 1);
      localom.Gcu = new LinkedList();
      paramLinkedList.add(localom);
      int j = 0;
      while (j <= 1)
      {
        localObject3 = new StringBuilder().append((String)localObject2).append(".AppMsg");
        ol localol;
        int k;
        label1101:
        StringBuilder localStringBuilder;
        if (j == 0)
        {
          localObject1 = "";
          localObject3 = localObject1;
          if (bu.isNullOrNil((String)paramMap.get((String)localObject3 + ".Title"))) {
            break;
          }
          localol = new ol();
          localol.Title = ((String)paramMap.get((String)localObject3 + ".Title"));
          localol.FYq = ((String)paramMap.get((String)localObject3 + ".Digest"));
          localol.FYs = ((String)paramMap.get((String)localObject3 + ".ContentUrl"));
          localol.FYu = ((String)paramMap.get((String)localObject3 + ".CoverImgUrl"));
          localol.FYv = ((String)paramMap.get((String)localObject3 + ".CoverImgUrl_1_1"));
          localol.FYw = ((String)paramMap.get((String)localObject3 + ".CoverImgUrl_235_1"));
          localol.hFR = bu.getInt((String)paramMap.get((String)localObject3 + ".ItemShowType"), -1);
          localol.FYD = ((String)paramMap.get((String)localObject3 + ".VideoId"));
          localol.FYE = bu.getInt((String)paramMap.get((String)localObject3 + ".VideoWidth"), -1);
          localol.FYF = bu.getInt((String)paramMap.get((String)localObject3 + ".VideoHeight"), -1);
          localol.FYG = bu.getInt((String)paramMap.get((String)localObject3 + ".VideoDuration"), -1);
          localol.CreateTime = bu.getInt((String)paramMap.get((String)localObject3 + ".CreateTime"), -1);
          localol.Gco = ((String)paramMap.get((String)localObject3 + ".VoicePlayUrl"));
          localol.Gcp = bu.getInt((String)paramMap.get((String)localObject3 + ".VoiceDuration"), -1);
          localol.Gcm = new LinkedList();
          k = 0;
          if (k > 20) {
            break label1205;
          }
          localStringBuilder = new StringBuilder().append((String)localObject3).append(".NegativeFeedbackReason");
          if (k != 0) {
            break label1195;
          }
        }
        label1195:
        for (localObject1 = "";; localObject1 = Integer.valueOf(k))
        {
          localObject1 = (String)paramMap.get(localObject1);
          if (bu.isNullOrNil((String)localObject1)) {
            break label1205;
          }
          localol.Gcm.add(localObject1);
          k += 1;
          break label1101;
          localObject1 = Integer.valueOf(j);
          break;
        }
        label1205:
        localol.Gcn = bu.getInt((String)paramMap.get((String)localObject3 + ".ShowNegativeFeedbackReason"), 1);
        localol.Gcq = bu.getInt((String)paramMap.get((String)localObject3 + ".RecRk"), 0);
        localol.Gcr = ((String)paramMap.get((String)localObject3 + ".RecInfo"));
        localom.Gcu.add(localol);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(188841);
  }
  
  private static void b(dmq paramdmq, Map<String, String> paramMap)
  {
    AppMethodBeat.i(188840);
    d.g.b.p.h(paramdmq, "$this$parseExtraFromXML");
    d.g.b.p.h(paramMap, "values");
    Object localObject = (a)new aa.a(paramdmq, paramMap);
    switch (paramdmq.style)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(188840);
      return;
      ((a)localObject).invoke();
      AppMethodBeat.o(188840);
      return;
      ((a)localObject).invoke();
      aiq localaiq = paramdmq.HTS;
      int i = 0;
      if (i <= 20)
      {
        localObject = new StringBuilder(".sysmsg.BizAccountRecommend.NegativeFeedbackReason");
        if (i == 0) {}
        for (paramdmq = "";; paramdmq = Integer.valueOf(i))
        {
          paramdmq = (String)paramMap.get(paramdmq);
          if (bu.isNullOrNil(paramdmq)) {
            break label174;
          }
          localaiq.Gcm.add(paramdmq);
          i += 1;
          break;
        }
      }
      label174:
      localaiq.Gcn = bu.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.ShowNegativeFeedbackReason"), 0);
      localObject = (String)paramMap.get(".sysmsg.BizAccountRecommend.AggregationUrl");
      paramdmq = (dmq)localObject;
      if (localObject == null) {
        paramdmq = "";
      }
      localaiq.Gyv = paramdmq;
      paramMap = (String)paramMap.get(".sysmsg.BizAccountRecommend.AggregationTitle");
      paramdmq = paramMap;
      if (paramMap == null) {
        paramdmq = "";
      }
      localaiq.Gyw = paramdmq;
    }
  }
  
  public static final boolean b(dmq paramdmq, w paramw)
  {
    AppMethodBeat.i(188845);
    d.g.b.p.h(paramdmq, "wrapper");
    int j = paramdmq.style;
    if (j == 1001)
    {
      if (paramdmq.HTU == null)
      {
        ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal exptInfo = null");
        AppMethodBeat.o(188845);
        return false;
      }
      if (bu.isNullOrNil(paramdmq.HTU.data))
      {
        ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal exptInfo.data = null");
        AppMethodBeat.o(188845);
        return false;
      }
      if ((bu.isNullOrNil(paramdmq.HTU.appId)) || (bu.isNullOrNil(paramdmq.HTU.HDK)))
      {
        ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal appid or path error, appId = " + paramdmq.HTU.appId + ", path = " + paramdmq.HTU.HDK);
        AppMethodBeat.o(188845);
        return false;
      }
      AppMethodBeat.o(188845);
      return true;
    }
    Object localObject = paramdmq.HTQ;
    if (localObject == null)
    {
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal recCard null");
      AppMethodBeat.o(188845);
      return false;
    }
    if (((dml)localObject).Gys == null)
    {
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal CardTitle null");
      AppMethodBeat.o(188845);
      return false;
    }
    if (((dml)localObject).Gct == null)
    {
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal AppMsgRecReason null");
      AppMethodBeat.o(188845);
      return false;
    }
    dmn localdmn = ((dml)localObject).HTL;
    if (localdmn == null)
    {
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo null");
      AppMethodBeat.o(188845);
      return false;
    }
    if (localdmn.nIJ == null)
    {
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo UserName null");
      AppMethodBeat.o(188845);
      return false;
    }
    if (localdmn.nJO == null)
    {
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo NickName null");
      AppMethodBeat.o(188845);
      return false;
    }
    if (localdmn.HTN == null)
    {
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo RecReason null");
      AppMethodBeat.o(188845);
      return false;
    }
    if (bu.ht((List)((dml)localObject).Gcu))
    {
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] AppMsg null");
      AppMethodBeat.o(188845);
      return false;
    }
    if ((j == 5) && (((dml)localObject).Gcu.size() < 2))
    {
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] AppMsg video size < 2");
      AppMethodBeat.o(188845);
      return false;
    }
    int k;
    if ((j == 101) || (j == 102) || (j == 103))
    {
      if ((paramdmq.HTS == null) || (bu.ht((List)paramdmq.HTS.Gal)) || (paramdmq.HTS.Gal.size() >= 3))
      {
        ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " BizInfo size >= 3");
        AppMethodBeat.o(188845);
        return false;
      }
      if (paramdmq.HTS.FNv == 1)
      {
        ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " extraInfo flag = 1");
        if (paramw != null) {
          ag.aGv().DU(paramw.field_msgId);
        }
        AppMethodBeat.o(188845);
        return false;
      }
      localObject = paramdmq.HTS.Gal;
      d.g.b.p.g(localObject, "wrapper.extraInfo.BizInfo");
      k = ((Collection)localObject).size();
      i = 0;
      if (i >= k) {
        break label1167;
      }
      if (((om)paramdmq.HTS.Gal.get(i)).FNv == 1) {}
    }
    label1154:
    label1162:
    label1167:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " bizLegal illegal");
        if (paramw != null) {
          ag.aGv().DU(paramw.field_msgId);
        }
        AppMethodBeat.o(188845);
        return false;
        i += 1;
        break;
      }
      if (j != 103)
      {
        localObject = paramdmq.HTS.Gal;
        d.g.b.p.g(localObject, "wrapper.extraInfo.BizInfo");
        k = ((Collection)localObject).size();
        i = 0;
        if (i >= k) {
          break label1162;
        }
        localObject = ((om)paramdmq.HTS.Gal.get(i)).nIJ;
        d.g.b.p.g(localObject, "wrapper.extraInfo.BizInfo[i].UserName");
        if (An((String)localObject)) {}
      }
      for (i = 0;; i = 1)
      {
        if (i != 0)
        {
          ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " bizLegal contact");
          if (paramw != null) {
            ag.aGv().DU(paramw.field_msgId);
          }
          AppMethodBeat.o(188845);
          return false;
          i += 1;
          break;
        }
        paramw = paramdmq.HTS.Gal;
        d.g.b.p.g(paramw, "wrapper.extraInfo.BizInfo");
        k = ((Collection)paramw).size();
        i = 0;
        if (i < k)
        {
          if (bu.ht((List)((om)paramdmq.HTS.Gal.get(i)).Gcu))
          {
            ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " AppMsg null");
            AppMethodBeat.o(188845);
            return false;
          }
          if (((ol)((om)paramdmq.HTS.Gal.get(i)).Gcu.get(0)).FNv != 1) {}
        }
        for (i = 0;; i = 1)
        {
          if (i == 0)
          {
            ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " AppMsg illegal");
            AppMethodBeat.o(188845);
            return false;
            i += 1;
            break;
          }
          paramdmq = ((om)paramdmq.HTS.Gal.get(0)).Gcu;
          d.g.b.p.g(paramdmq, "wrapper.extraInfo.BizInfo[0].AppMsg");
          paramdmq = ((Iterable)paramdmq).iterator();
          i = 1;
          if (paramdmq.hasNext())
          {
            paramw = (ol)paramdmq.next();
            if ((paramw.hFR != 8) && (paramw.hFR != 7) && (paramw.hFR != 6) && (paramw.hFR != 10)) {
              break label1154;
            }
            i = 0;
          }
          for (;;)
          {
            break;
            if (i == 0)
            {
              ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " showTypeLegal illegal");
              AppMethodBeat.o(188845);
              return false;
            }
            AppMethodBeat.o(188845);
            return true;
          }
        }
      }
    }
  }
  
  public static final dmq bQ(Map<String, String> paramMap)
  {
    AppMethodBeat.i(188847);
    d.g.b.p.h(paramMap, "values");
    String str1 = (String)paramMap.get(".sysmsg.BizRecommendExpt.Title");
    int i = bu.getInt((String)paramMap.get(".sysmsg.BizRecommendExpt.Pos"), -1);
    int j = bu.getInt((String)paramMap.get(".sysmsg.BizRecommendExpt.Weight"), -1);
    long l = bu.getLong((String)paramMap.get(".sysmsg.BizRecommendExpt.RecID"), 0L);
    int k = bu.getInt((String)paramMap.get(".sysmsg.BizRecommendExpt.RedDotFlag"), -1);
    String str2 = (String)paramMap.get(".sysmsg.BizRecommendExpt.BusinessId");
    String str3 = (String)paramMap.get(".sysmsg.BizRecommendExpt.CardID");
    String str4 = (String)paramMap.get(".sysmsg.BizRecommendExpt.Data");
    String str5 = (String)paramMap.get(".sysmsg.BizRecommendExpt.RecSummary");
    String str6 = (String)paramMap.get(".sysmsg.BizRecommendExpt.AppId");
    String str7 = (String)paramMap.get(".sysmsg.BizRecommendExpt.TemplatePathType");
    int m = bu.getInt((String)paramMap.get(".sysmsg.BizRecommendExpt.UseServerTime"), 0);
    paramMap = (String)paramMap.get(".sysmsg.BizRecommendExpt.ExtraData");
    if ((i < 0) && (j < 0))
    {
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] getFromCanvasXml pos = " + i + ", weight = " + j);
      AppMethodBeat.o(188847);
      return null;
    }
    dmq localdmq = new dmq();
    localdmq.pos = i;
    localdmq.weight = j;
    localdmq.HDI = l;
    csm localcsm = new csm();
    localcsm.title = str1;
    localcsm.pos = i;
    localcsm.weight = j;
    localcsm.HDI = l;
    localcsm.HDJ = k;
    localcsm.kNn = str2;
    localcsm.cardId = str3;
    localcsm.data = str4;
    localcsm.Gyu = str5;
    localcsm.appId = str6;
    localcsm.HDK = str7;
    localcsm.dAU = paramMap;
    localdmq.HTU = localcsm;
    localdmq.style = 1001;
    localdmq.HTT = m;
    AppMethodBeat.o(188847);
    return localdmq;
  }
  
  public static final void d(dmq paramdmq)
  {
    Object localObject3 = null;
    AppMethodBeat.i(188848);
    d.g.b.p.h(paramdmq, "wrapper");
    if (!b(paramdmq, null))
    {
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately illegal");
      AppMethodBeat.o(188848);
      return;
    }
    if (e(paramdmq))
    {
      AppMethodBeat.o(188848);
      return;
    }
    Object localObject1 = ag.aGv();
    d.g.b.p.g(localObject1, "SubCoreBiz.getBizTimeLineInfoStorage()");
    localObject1 = ((x)localObject1).ftp();
    System.currentTimeMillis();
    long l1;
    w localw;
    long l2;
    label258:
    int i;
    int j;
    int k;
    if (paramdmq.HTT == 1) {
      if (Math.abs(paramdmq.HDI * 1000L - System.currentTimeMillis()) <= 86400000L)
      {
        l1 = paramdmq.HDI * 1000L;
        localw = new w();
        localw.field_msgId = ag.aGv().ftx();
        localw.field_msgSvrId = 0L;
        localw.field_type = 620757041;
        localw.field_talker = "";
        localw.field_talkerId = 0;
        localw.field_createTime = l1;
        localw.ka(1);
        localw.field_status = 3;
        a(localw, paramdmq);
        localw.b(paramdmq);
        localObject2 = ag.aGv();
        d.g.b.p.g(localObject2, "SubCoreBiz.getBizTimeLineInfoStorage()");
        long l3 = ((x)localObject2).fsY();
        l2 = 0L;
        l1 = l2;
        if (localObject1 != null)
        {
          if (paramdmq.HTU.weight < 0) {
            break label607;
          }
          l1 = Math.min(paramdmq.HTU.weight, y.DX(((w)localObject1).field_orderFlag));
        }
        long l4 = y.aA(l3, localw.field_createTime / 1000L);
        l2 = l4;
        if (l4 >= 4294967296L)
        {
          ae.w("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately serialNumber is too big %d", new Object[] { Long.valueOf(l4) });
          l3 = ag.aGv().ftt();
          l2 = y.aA(l3, localw.field_createTime / 1000L);
        }
        localw.field_orderFlag = (l2 | l3 << 32 | 0xFF000000 & l1 << 24);
        y.r(localw);
        boolean bool = ag.aGv().p(localw);
        ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately result = " + bool + ", title = " + paramdmq.HTU.title);
        if (bool)
        {
          localObject1 = p.IIi;
          if (p.fsJ())
          {
            localObject1 = h.DQL;
            h.eUa();
          }
          p.IIi.o(localw);
          if (y.ftH()) {
            y.abs(y.IJf);
          }
        }
        localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.CH(82L);
        localObject1 = q.IIu;
        i = paramdmq.pos;
        j = paramdmq.HTT;
        k = paramdmq.style;
        l1 = paramdmq.HDI;
        localObject1 = paramdmq.HTU;
        if (localObject1 == null) {
          break label681;
        }
        localObject1 = ((csm)localObject1).cardId;
        label510:
        localObject2 = paramdmq.HTS;
        if (localObject2 == null) {
          break label687;
        }
      }
    }
    label681:
    label687:
    for (Object localObject2 = ((aiq)localObject2).Gau;; localObject2 = null)
    {
      csm localcsm = paramdmq.HTU;
      paramdmq = localObject3;
      if (localcsm != null) {
        paramdmq = localcsm.dAU;
      }
      q.a(localw, 1, i, j, 5, k, l1, (String)localObject1, (String)localObject2, paramdmq);
      AppMethodBeat.o(188848);
      return;
      l1 = System.currentTimeMillis();
      break;
      if (localObject1 != null)
      {
        l1 = ((w)localObject1).field_createTime + 1000L;
        break;
      }
      l1 = System.currentTimeMillis();
      break;
      label607:
      if (paramdmq.HTU.pos == 0)
      {
        l1 = y.DX(((w)localObject1).field_orderFlag);
        break label258;
      }
      localObject1 = ag.aGv().abp(paramdmq.HTU.pos - 1);
      if (localObject1 == null)
      {
        ae.w("MicroMsg.BizTimeLineStorageLogicExKt", "insertCanvasCardImmediately lastTimeLineInfo is null");
        l1 = l2;
        break label258;
      }
      l1 = y.DX(((w)localObject1).field_orderFlag);
      break label258;
      localObject1 = null;
      break label510;
    }
  }
  
  public static final boolean e(dmq paramdmq)
  {
    x localx2 = null;
    x localx1 = null;
    AppMethodBeat.i(188850);
    d.g.b.p.h(paramdmq, "$this$duplicateCardId");
    switch (paramdmq.style)
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(188850);
        return false;
        localx2 = ag.aGv();
        localObject = paramdmq.HTS;
        paramdmq = localx1;
        if (localObject != null) {
          paramdmq = ((aiq)localObject).Gaq;
        }
      } while (localx2.aUb(paramdmq) == null);
      ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] duplicateCardId");
      AppMethodBeat.o(188850);
      return true;
      localx1 = ag.aGv();
      Object localObject = paramdmq.HTU;
      paramdmq = localx2;
      if (localObject != null) {
        paramdmq = ((csm)localObject).cardId;
      }
    } while (localx1.aUb(paramdmq) == null);
    ae.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] canvas duplicateCardId");
    AppMethodBeat.o(188850);
    return true;
  }
  
  public static final LinkedList<ol> s(w paramw)
  {
    AppMethodBeat.i(188843);
    d.g.b.p.h(paramw, "info");
    LinkedList localLinkedList = new LinkedList();
    if ((!paramw.ftb()) || (paramw.ftk() == null))
    {
      AppMethodBeat.o(188843);
      return localLinkedList;
    }
    Object localObject = paramw.ftk();
    if ((((dmq)localObject).style == 3) || (((dmq)localObject).style == 5) || (((dmq)localObject).style == 0))
    {
      paramw = paramw.ftj();
      if (paramw != null)
      {
        paramw = paramw.Gcu;
        if (paramw != null) {
          paramw = ((Iterable)paramw).iterator();
        }
      }
    }
    else
    {
      while (paramw.hasNext())
      {
        localObject = (dmm)paramw.next();
        ol localol = new ol();
        localol.FYs = ((dmm)localObject).FYs;
        localol.Title = ((dmm)localObject).Title;
        localLinkedList.add(localol);
        continue;
        if ((((dmq)localObject).style == 101) || (((dmq)localObject).style == 102) || (((dmq)localObject).style == 103))
        {
          paramw = paramw.ftk();
          if (paramw != null)
          {
            paramw = paramw.HTS;
            if (paramw != null)
            {
              paramw = paramw.Gal;
              if (paramw != null)
              {
                paramw = ((Iterable)paramw).iterator();
                while (paramw.hasNext())
                {
                  localObject = (om)paramw.next();
                  if (localObject != null)
                  {
                    localObject = ((om)localObject).Gcu;
                    if (localObject != null)
                    {
                      localObject = ((Iterable)localObject).iterator();
                      while (((Iterator)localObject).hasNext()) {
                        localLinkedList.add((ol)((Iterator)localObject).next());
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(188843);
    return localLinkedList;
  }
  
  public static final int t(w paramw)
  {
    int j = 1;
    AppMethodBeat.i(188846);
    d.g.b.p.h(paramw, "$this$getCardType");
    int i;
    if (paramw.fta()) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(188846);
      return i;
      if (paramw.ftb())
      {
        paramw = paramw.ftk();
        i = j;
        if (paramw != null)
        {
          i = j;
          switch (paramw.style)
          {
          case 0: 
          case 3: 
          case 5: 
          default: 
            i = j;
            break;
          case 101: 
            i = 3;
            break;
          case 1001: 
            i = 5;
            break;
          }
        }
      }
      else if (paramw.ftc())
      {
        i = 4;
      }
      else
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.aa
 * JD-Core Version:    0.7.0.1
 */