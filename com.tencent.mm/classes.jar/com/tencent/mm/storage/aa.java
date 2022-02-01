package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ag;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.plugin.webcanvas.f;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.protocal.protobuf.dlq;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.oa;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.a;
import d.n.n;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"BIZTIMELINFO_CARDTYPE_AD", "", "BIZTIMELINFO_CARDTYPE_BIZ", "BIZTIMELINFO_CARDTYPE_RECCARD_CANVAS", "BIZTIMELINFO_CARDTYPE_RECOMMEND", "BIZTIMELINFO_CARDTYPE_UNFOLLOW", "TAG", "", "fillBizMsgItem", "Ljava/util/LinkedList;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "filterDuplicateMsg", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "getExtraFromXML", "", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "values", "", "getFromCanvasXml", "getRecCardAppMsgs", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "insertCanvasCardImmediately", "isCanvasCard", "isContact", "userName", "isTLRecCardWrapperLegal", "onBizRecommendExpt", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "postInsertCanvasCard", "testInsertCard", "style", "getCardType", "parseExtraFromXML", "parseFromXML", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "plugin-biz_release"})
public final class aa
{
  public static final LinkedList<String> a(w paramw, oa paramoa)
  {
    AppMethodBeat.i(207370);
    d.g.b.p.h(paramw, "info");
    d.g.b.p.h(paramoa, "item");
    LinkedList localLinkedList = new LinkedList();
    if ((!paramw.fpe()) || (paramw.fpm() == null))
    {
      AppMethodBeat.o(207370);
      return localLinkedList;
    }
    paramw = ((Iterable)s(paramw)).iterator();
    label140:
    while (paramw.hasNext())
    {
      oj localoj = (oj)paramw.next();
      paramoa.dcr.add(localoj.FFW);
      CharSequence localCharSequence = (CharSequence)localoj.FJS;
      if ((localCharSequence == null) || (n.aE(localCharSequence))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label140;
        }
        paramoa.FJi.add(localoj.FJS);
        break;
      }
    }
    AppMethodBeat.o(207370);
    return localLinkedList;
  }
  
  public static final void a(dlt paramdlt, Map<String, String> paramMap)
  {
    AppMethodBeat.i(207367);
    d.g.b.p.h(paramdlt, "wrapper");
    d.g.b.p.h(paramMap, "values");
    b(paramdlt, paramMap);
    AppMethodBeat.o(207367);
  }
  
  public static final void a(LinkedList<ok> paramLinkedList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(207369);
    d.g.b.p.h(paramLinkedList, "$this$parseFromXML");
    d.g.b.p.h(paramMap, "values");
    int i = 0;
    while (i <= 9)
    {
      Object localObject2 = new StringBuilder(".sysmsg.BizAccountRecommend.BizAccount");
      ok localok;
      label318:
      Object localObject3;
      if (i == 0)
      {
        localObject1 = "";
        localObject2 = localObject1;
        if (bt.isNullOrNil((String)paramMap.get((String)localObject2 + ".UserName"))) {
          break;
        }
        localok = new ok();
        localok.nDo = ((String)paramMap.get((String)localObject2 + ".UserName"));
        localok.nEt = ((String)paramMap.get((String)localObject2 + ".NickName"));
        localok.uhr = ((String)paramMap.get((String)localObject2 + ".RecommendReason"));
        localok.jdf = ((String)paramMap.get((String)localObject2 + ".Signature"));
        localok.FJT = ((String)paramMap.get((String)localObject2 + ".BrandIconUrl"));
        localok.FJU = ((String)paramMap.get((String)localObject2 + ".AppMsgRecReason"));
        localok.FJN = new LinkedList();
        j = 0;
        if (j > 20) {
          break label416;
        }
        localObject3 = new StringBuilder().append((String)localObject2).append(".NegativeFeedbackReason");
        if (j != 0) {
          break label407;
        }
      }
      label407:
      for (Object localObject1 = "";; localObject1 = Integer.valueOf(j))
      {
        localObject1 = (String)paramMap.get(localObject1);
        if (bt.isNullOrNil((String)localObject1)) {
          break label416;
        }
        localok.FJN.add(localObject1);
        j += 1;
        break label318;
        localObject1 = Integer.valueOf(i);
        break;
      }
      label416:
      localok.FJO = bt.getInt((String)paramMap.get((String)localObject2 + ".ShowNegativeFeedbackReason"), 1);
      localok.FJV = new LinkedList();
      paramLinkedList.add(localok);
      int j = 0;
      while (j <= 1)
      {
        localObject3 = new StringBuilder().append((String)localObject2).append(".AppMsg");
        oj localoj;
        int k;
        label1089:
        StringBuilder localStringBuilder;
        if (j == 0)
        {
          localObject1 = "";
          localObject3 = localObject1;
          if (bt.isNullOrNil((String)paramMap.get((String)localObject3 + ".Title"))) {
            break;
          }
          localoj = new oj();
          localoj.Title = ((String)paramMap.get((String)localObject3 + ".Title"));
          localoj.FFU = ((String)paramMap.get((String)localObject3 + ".Digest"));
          localoj.FFW = ((String)paramMap.get((String)localObject3 + ".ContentUrl"));
          localoj.FFY = ((String)paramMap.get((String)localObject3 + ".CoverImgUrl"));
          localoj.FFZ = ((String)paramMap.get((String)localObject3 + ".CoverImgUrl_1_1"));
          localoj.FGa = ((String)paramMap.get((String)localObject3 + ".CoverImgUrl_235_1"));
          localoj.hCZ = bt.getInt((String)paramMap.get((String)localObject3 + ".ItemShowType"), -1);
          localoj.FGh = ((String)paramMap.get((String)localObject3 + ".VideoId"));
          localoj.FGi = bt.getInt((String)paramMap.get((String)localObject3 + ".VideoWidth"), -1);
          localoj.FGj = bt.getInt((String)paramMap.get((String)localObject3 + ".VideoHeight"), -1);
          localoj.FGk = bt.getInt((String)paramMap.get((String)localObject3 + ".VideoDuration"), -1);
          localoj.CreateTime = bt.getInt((String)paramMap.get((String)localObject3 + ".CreateTime"), -1);
          localoj.FJP = ((String)paramMap.get((String)localObject3 + ".VoicePlayUrl"));
          localoj.FJQ = bt.getInt((String)paramMap.get((String)localObject3 + ".VoiceDuration"), -1);
          localoj.FJN = new LinkedList();
          k = 0;
          if (k > 20) {
            break label1192;
          }
          localStringBuilder = new StringBuilder().append((String)localObject3).append(".NegativeFeedbackReason");
          if (k != 0) {
            break label1182;
          }
        }
        label1182:
        for (localObject1 = "";; localObject1 = Integer.valueOf(k))
        {
          localObject1 = (String)paramMap.get(localObject1);
          if (bt.isNullOrNil((String)localObject1)) {
            break label1192;
          }
          localoj.FJN.add(localObject1);
          k += 1;
          break label1089;
          localObject1 = Integer.valueOf(j);
          break;
        }
        label1192:
        localoj.FJO = bt.getInt((String)paramMap.get((String)localObject3 + ".ShowNegativeFeedbackReason"), 1);
        localoj.FJR = bt.getInt((String)paramMap.get((String)localObject3 + ".RecRk"), 0);
        localoj.FJS = ((String)paramMap.get((String)localObject3 + ".RecInfo"));
        localok.FJV.add(localoj);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(207369);
  }
  
  private static void b(dlt paramdlt, Map<String, String> paramMap)
  {
    AppMethodBeat.i(207368);
    d.g.b.p.h(paramdlt, "$this$parseExtraFromXML");
    d.g.b.p.h(paramMap, "values");
    Object localObject = (a)new aa.a(paramdlt, paramMap);
    switch (paramdlt.style)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(207368);
      return;
      ((a)localObject).invoke();
      AppMethodBeat.o(207368);
      return;
      ((a)localObject).invoke();
      aig localaig = paramdlt.HAf;
      int i = 0;
      if (i <= 20)
      {
        localObject = new StringBuilder(".sysmsg.BizAccountRecommend.NegativeFeedbackReason");
        if (i == 0) {}
        for (paramdlt = "";; paramdlt = Integer.valueOf(i))
        {
          paramdlt = (String)paramMap.get(paramdlt);
          if (bt.isNullOrNil(paramdlt)) {
            break label170;
          }
          localaig.FJN.add(paramdlt);
          i += 1;
          break;
        }
      }
      label170:
      localaig.FJO = bt.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.ShowNegativeFeedbackReason"), 0);
      localObject = (String)paramMap.get(".sysmsg.BizAccountRecommend.AggregationUrl");
      paramdlt = (dlt)localObject;
      if (localObject == null) {
        paramdlt = "";
      }
      localaig.GfN = paramdlt;
      paramMap = (String)paramMap.get(".sysmsg.BizAccountRecommend.AggregationTitle");
      paramdlt = paramMap;
      if (paramMap == null) {
        paramdlt = "";
      }
      localaig.GfO = paramdlt;
    }
  }
  
  public static final boolean b(dlt paramdlt, w paramw)
  {
    AppMethodBeat.i(207373);
    d.g.b.p.h(paramdlt, "wrapper");
    int j = paramdlt.style;
    if (j == 1001)
    {
      if (paramdlt.HAh == null)
      {
        ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal exptInfo = null");
        AppMethodBeat.o(207373);
        return false;
      }
      if (bt.isNullOrNil(paramdlt.HAh.data))
      {
        ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal exptInfo.data = null");
        AppMethodBeat.o(207373);
        return false;
      }
      if ((bt.isNullOrNil(paramdlt.HAh.appId)) || (bt.isNullOrNil(paramdlt.HAh.Hkk)))
      {
        ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal appid or path error, appId = " + paramdlt.HAh.appId + ", path = " + paramdlt.HAh.Hkk);
        AppMethodBeat.o(207373);
        return false;
      }
      AppMethodBeat.o(207373);
      return true;
    }
    Object localObject = paramdlt.HAd;
    if (localObject == null)
    {
      ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal recCard null");
      AppMethodBeat.o(207373);
      return false;
    }
    if (((dlo)localObject).GfK == null)
    {
      ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal CardTitle null");
      AppMethodBeat.o(207373);
      return false;
    }
    if (((dlo)localObject).FJU == null)
    {
      ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal AppMsgRecReason null");
      AppMethodBeat.o(207373);
      return false;
    }
    dlq localdlq = ((dlo)localObject).HzY;
    if (localdlq == null)
    {
      ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo null");
      AppMethodBeat.o(207373);
      return false;
    }
    if (localdlq.nDo == null)
    {
      ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo UserName null");
      AppMethodBeat.o(207373);
      return false;
    }
    if (localdlq.nEt == null)
    {
      ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo NickName null");
      AppMethodBeat.o(207373);
      return false;
    }
    if (localdlq.HAa == null)
    {
      ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo RecReason null");
      AppMethodBeat.o(207373);
      return false;
    }
    if (bt.hj((List)((dlo)localObject).FJV))
    {
      ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] AppMsg null");
      AppMethodBeat.o(207373);
      return false;
    }
    if ((j == 5) && (((dlo)localObject).FJV.size() < 2))
    {
      ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] AppMsg video size < 2");
      AppMethodBeat.o(207373);
      return false;
    }
    int k;
    if ((j == 101) || (j == 102))
    {
      if ((paramdlt.HAf == null) || (bt.hj((List)paramdlt.HAf.FHP)) || (paramdlt.HAf.FHP.size() >= 3))
      {
        ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " BizInfo size >= 3");
        AppMethodBeat.o(207373);
        return false;
      }
      if (paramdlt.HAf.FuX == 1)
      {
        ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " extraInfo flag = 1");
        if (paramw != null) {
          ag.aGf().Dv(paramw.field_msgId);
        }
        AppMethodBeat.o(207373);
        return false;
      }
      localObject = paramdlt.HAf.FHP;
      d.g.b.p.g(localObject, "wrapper.extraInfo.BizInfo");
      k = ((Collection)localObject).size();
      i = 0;
      if (i >= k) {
        break label1155;
      }
      if (((ok)paramdlt.HAf.FHP.get(i)).FuX == 1) {}
    }
    label1155:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " bizLegal illegal");
        if (paramw != null) {
          ag.aGf().Dv(paramw.field_msgId);
        }
        AppMethodBeat.o(207373);
        return false;
        i += 1;
        break;
      }
      localObject = paramdlt.HAf.FHP;
      d.g.b.p.g(localObject, "wrapper.extraInfo.BizInfo");
      k = ((Collection)localObject).size();
      i = 0;
      if (i < k)
      {
        localObject = ((ok)paramdlt.HAf.FHP.get(i)).nDo;
        d.g.b.p.g(localObject, "wrapper.extraInfo.BizInfo[i].UserName");
        if (zD((String)localObject)) {}
      }
      for (i = 0;; i = 1)
      {
        if (i != 0)
        {
          ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " bizLegal contact");
          if (paramw != null) {
            ag.aGf().Dv(paramw.field_msgId);
          }
          AppMethodBeat.o(207373);
          return false;
          i += 1;
          break;
        }
        paramw = paramdlt.HAf.FHP;
        d.g.b.p.g(paramw, "wrapper.extraInfo.BizInfo");
        k = ((Collection)paramw).size();
        i = 0;
        if (i < k)
        {
          if (bt.hj((List)((ok)paramdlt.HAf.FHP.get(i)).FJV))
          {
            ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " AppMsg null");
            AppMethodBeat.o(207373);
            return false;
          }
          if (((oj)((ok)paramdlt.HAf.FHP.get(i)).FJV.get(0)).FuX == 1) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0)
          {
            ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " AppMsg illegal");
            AppMethodBeat.o(207373);
            return false;
            i += 1;
            break;
          }
          paramdlt = ((ok)paramdlt.HAf.FHP.get(0)).FJV;
          d.g.b.p.g(paramdlt, "wrapper.extraInfo.BizInfo[0].AppMsg");
          paramdlt = ((Iterable)paramdlt).iterator();
          i = 1;
          if (paramdlt.hasNext())
          {
            paramw = (oj)paramdlt.next();
            if ((paramw.hCZ != 8) && (paramw.hCZ != 7) && (paramw.hCZ != 6) && (paramw.hCZ != 10)) {
              break label1142;
            }
            i = 0;
          }
          label1142:
          for (;;)
          {
            break;
            if (i == 0)
            {
              ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " showTypeLegal illegal");
              AppMethodBeat.o(207373);
              return false;
            }
            AppMethodBeat.o(207373);
            return true;
          }
        }
      }
    }
  }
  
  public static final dlt bK(Map<String, String> paramMap)
  {
    AppMethodBeat.i(207375);
    d.g.b.p.h(paramMap, "values");
    String str1 = (String)paramMap.get(".sysmsg.BizRecommendExpt.Title");
    int i = bt.getInt((String)paramMap.get(".sysmsg.BizRecommendExpt.Pos"), -1);
    int j = bt.getInt((String)paramMap.get(".sysmsg.BizRecommendExpt.Weight"), -1);
    long l = bt.getLong((String)paramMap.get(".sysmsg.BizRecommendExpt.RecID"), 0L);
    int k = bt.getInt((String)paramMap.get(".sysmsg.BizRecommendExpt.RedDotFlag"), -1);
    String str2 = (String)paramMap.get(".sysmsg.BizRecommendExpt.BusinessId");
    String str3 = (String)paramMap.get(".sysmsg.BizRecommendExpt.CardID");
    String str4 = (String)paramMap.get(".sysmsg.BizRecommendExpt.Data");
    String str5 = (String)paramMap.get(".sysmsg.BizRecommendExpt.RecSummary");
    String str6 = (String)paramMap.get(".sysmsg.BizRecommendExpt.AppId");
    String str7 = (String)paramMap.get(".sysmsg.BizRecommendExpt.TemplatePathType");
    int m = bt.getInt((String)paramMap.get(".sysmsg.BizRecommendExpt.UseServerTime"), 0);
    paramMap = (String)paramMap.get(".sysmsg.BizRecommendExpt.ExtraData");
    if ((i < 0) && (j < 0))
    {
      ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] getFromCanvasXml pos = " + i + ", weight = " + j);
      AppMethodBeat.o(207375);
      return null;
    }
    dlt localdlt = new dlt();
    localdlt.pos = i;
    localdlt.weight = j;
    localdlt.Hki = l;
    crs localcrs = new crs();
    localcrs.title = str1;
    localcrs.pos = i;
    localcrs.weight = j;
    localcrs.Hki = l;
    localcrs.Hkj = k;
    localcrs.kJY = str2;
    localcrs.cardId = str3;
    localcrs.data = str4;
    localcrs.GfM = str5;
    localcrs.appId = str6;
    localcrs.Hkk = str7;
    localcrs.dzP = paramMap;
    localdlt.HAh = localcrs;
    localdlt.style = 1001;
    localdlt.HAg = m;
    AppMethodBeat.o(207375);
    return localdlt;
  }
  
  public static final void d(dlt paramdlt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(207376);
    d.g.b.p.h(paramdlt, "wrapper");
    if (!b(paramdlt, null))
    {
      ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately illegal");
      AppMethodBeat.o(207376);
      return;
    }
    Object localObject1 = ag.aGf();
    d.g.b.p.g(localObject1, "SubCoreBiz.getBizTimeLineInfoStorage()");
    localObject1 = ((x)localObject1).fpq();
    System.currentTimeMillis();
    long l1;
    w localw;
    long l2;
    label238:
    int i;
    int j;
    int k;
    if (paramdlt.HAg == 1) {
      if (Math.abs(paramdlt.Hki * 1000L - System.currentTimeMillis()) <= 86400000L)
      {
        l1 = paramdlt.Hki * 1000L;
        localw = new w();
        localw.field_msgId = ag.aGf().fpy();
        localw.field_msgSvrId = 0L;
        localw.field_type = 620757041;
        localw.field_talker = "";
        localw.field_talkerId = 0;
        localw.field_createTime = l1;
        localw.jY(1);
        localw.field_status = 3;
        localw.b(paramdlt);
        localObject2 = ag.aGf();
        d.g.b.p.g(localObject2, "SubCoreBiz.getBizTimeLineInfoStorage()");
        long l3 = ((x)localObject2).fpb();
        l2 = 0L;
        l1 = l2;
        if (localObject1 != null)
        {
          if (paramdlt.HAh.weight < 0) {
            break label576;
          }
          l1 = Math.min(paramdlt.HAh.weight, y.Dy(((w)localObject1).field_orderFlag));
        }
        long l4 = y.aB(l3, localw.field_createTime / 1000L);
        l2 = l4;
        if (l4 >= 4294967296L)
        {
          ad.w("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately serialNumber is too big %d", new Object[] { Long.valueOf(l4) });
          l3 = ag.aGf().fpu();
          l2 = y.aB(l3, localw.field_createTime / 1000L);
        }
        localw.field_orderFlag = (l2 | l3 << 32 | 0xFF000000 & l1 << 24);
        y.r(localw);
        boolean bool = ag.aGf().o(localw);
        ad.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately result = " + bool + ", title = " + paramdlt.HAh.title);
        if (bool)
        {
          localObject1 = com.tencent.mm.plugin.webcanvas.g.Dzc;
          com.tencent.mm.plugin.webcanvas.g.eLs();
          p.InU.n(localw);
          if (y.fpH()) {
            y.aaK(y.IoP);
          }
        }
        localObject1 = f.DyX;
        f.Cj(82L);
        localObject1 = q.Ioe;
        i = paramdlt.pos;
        j = paramdlt.HAg;
        k = paramdlt.style;
        l1 = paramdlt.Hki;
        localObject1 = paramdlt.HAh;
        if (localObject1 == null) {
          break label650;
        }
        localObject1 = ((crs)localObject1).cardId;
        label479:
        localObject2 = paramdlt.HAf;
        if (localObject2 == null) {
          break label656;
        }
      }
    }
    label650:
    label656:
    for (Object localObject2 = ((aig)localObject2).FHY;; localObject2 = null)
    {
      crs localcrs = paramdlt.HAh;
      paramdlt = localObject3;
      if (localcrs != null) {
        paramdlt = localcrs.dzP;
      }
      q.a(localw, 1, i, j, 5, k, l1, (String)localObject1, (String)localObject2, paramdlt);
      AppMethodBeat.o(207376);
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
      label576:
      if (paramdlt.HAh.pos == 0)
      {
        l1 = y.Dy(((w)localObject1).field_orderFlag);
        break label238;
      }
      localObject1 = ag.aGf().aaI(paramdlt.HAh.pos - 1);
      if (localObject1 == null)
      {
        ad.w("MicroMsg.BizTimeLineStorageLogicExKt", "insertCanvasCardImmediately lastTimeLineInfo is null");
        l1 = l2;
        break label238;
      }
      l1 = y.Dy(((w)localObject1).field_orderFlag);
      break label238;
      localObject1 = null;
      break label479;
    }
  }
  
  public static final LinkedList<oj> s(w paramw)
  {
    AppMethodBeat.i(207371);
    d.g.b.p.h(paramw, "info");
    LinkedList localLinkedList = new LinkedList();
    if ((!paramw.fpe()) || (paramw.fpm() == null))
    {
      AppMethodBeat.o(207371);
      return localLinkedList;
    }
    Object localObject = paramw.fpm();
    if ((((dlt)localObject).style == 3) || (((dlt)localObject).style == 5) || (((dlt)localObject).style == 0))
    {
      paramw = paramw.fpl();
      if (paramw != null)
      {
        paramw = paramw.FJV;
        if (paramw != null) {
          paramw = ((Iterable)paramw).iterator();
        }
      }
    }
    else
    {
      while (paramw.hasNext())
      {
        localObject = (dlp)paramw.next();
        oj localoj = new oj();
        localoj.FFW = ((dlp)localObject).FFW;
        localoj.Title = ((dlp)localObject).Title;
        localLinkedList.add(localoj);
        continue;
        if ((((dlt)localObject).style == 101) || (((dlt)localObject).style == 102))
        {
          paramw = paramw.fpm();
          if (paramw != null)
          {
            paramw = paramw.HAf;
            if (paramw != null)
            {
              paramw = paramw.FHP;
              if (paramw != null)
              {
                paramw = ((Iterable)paramw).iterator();
                while (paramw.hasNext())
                {
                  localObject = (ok)paramw.next();
                  if (localObject != null)
                  {
                    localObject = ((ok)localObject).FJV;
                    if (localObject != null)
                    {
                      localObject = ((Iterable)localObject).iterator();
                      while (((Iterator)localObject).hasNext()) {
                        localLinkedList.add((oj)((Iterator)localObject).next());
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
    AppMethodBeat.o(207371);
    return localLinkedList;
  }
  
  public static final int t(w paramw)
  {
    int j = 1;
    AppMethodBeat.i(207374);
    d.g.b.p.h(paramw, "$this$getCardType");
    int i;
    if (paramw.fpd()) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(207374);
      return i;
      if (paramw.fpe())
      {
        paramw = paramw.fpm();
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
      else if (paramw.fpf())
      {
        i = 4;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private static boolean zD(String paramString)
  {
    AppMethodBeat.i(207372);
    d.g.b.p.h(paramString, "userName");
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azp().Bf(paramString);
    if ((localObject != null) && (((am)localObject).adh()))
    {
      AppMethodBeat.o(207372);
      return true;
    }
    if ((localObject == null) || (((am)localObject).adt() <= 0)) {
      as.a.aBA().a(paramString, "", null);
    }
    AppMethodBeat.o(207372);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.aa
 * JD-Core Version:    0.7.0.1
 */