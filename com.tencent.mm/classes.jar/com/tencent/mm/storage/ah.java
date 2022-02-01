package com.tencent.mm.storage;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.p.h;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.plugin.webcanvas.j;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.edo;
import com.tencent.mm.protocal.protobuf.enc;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enp;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.protocal.protobuf.flg;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.nk;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"BIZTIMELINFO_CARDTYPE_AD", "", "BIZTIMELINFO_CARDTYPE_BIZ", "BIZTIMELINFO_CARDTYPE_RECCARD_CANVAS", "BIZTIMELINFO_CARDTYPE_RECFEED", "BIZTIMELINFO_CARDTYPE_RECFEED_TAG", "BIZTIMELINFO_CARDTYPE_RECOMMEND", "BIZTIMELINFO_CARDTYPE_STYL103", "BIZTIMELINFO_CARDTYPE_UNFOLLOW", "TAG", "", "fillBizMsgItem", "Ljava/util/LinkedList;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "getExtraFromXML", "", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "values", "", "getFromCanvasXml", "getRecCardAppMsgs", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "insertCanvasCardImmediately", "maxWeight", "isInTimeLine", "", "isCanvasCard", "isContact", "userName", "isStyleNeedCheckContact", "style", "isSupportRecFeedStyle", "isTLRecCardWrapperLegal", "isTLRecFeedLegal", "recFeed", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "onBizRecommendExpt", "content", "postInsertCanvasCard", "recCanvasSupport", "report21461", "redDotFlag", "insertRet", "testInsertCard", "duplicateCardId", "getCardType", "getMidAndIdx", "", "(Ljava/lang/String;)[Ljava/lang/String;", "isCanvas", "isPkgVersionValid", "log", "isShowBigPic", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "isShowContentBigPic", "isShowContentSmallPic", "isShowThreePic", "isUnderLineMsg", "parseExtraFromXML", "parseFromXML", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "setCardId", "plugin-biz_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ah
{
  private static boolean IR(String paramString)
  {
    AppMethodBeat.i(248562);
    kotlin.g.b.s.u(paramString, "userName");
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString);
    if ((localau != null) && (d.rs(localau.field_type)))
    {
      AppMethodBeat.o(248562);
      return true;
    }
    if ((localau == null) || ((int)localau.maN <= 0)) {
      az.a.okP.a(paramString, "", null);
    }
    AppMethodBeat.o(248562);
    return false;
  }
  
  public static final LinkedList<qn> J(ab paramab)
  {
    AppMethodBeat.i(248558);
    kotlin.g.b.s.u(paramab, "info");
    LinkedList localLinkedList = new LinkedList();
    if ((!paramab.iYf()) || (paramab.iYp() == null))
    {
      AppMethodBeat.o(248558);
      return localLinkedList;
    }
    Object localObject = paramab.iYp();
    if ((((flj)localObject).style == 3) || (((flj)localObject).style == 5) || (((flj)localObject).style == 0))
    {
      paramab = paramab.iYo();
      if (paramab != null)
      {
        paramab = paramab.YVI;
        if (paramab != null) {
          paramab = ((Iterable)paramab).iterator();
        }
      }
    }
    else
    {
      while (paramab.hasNext())
      {
        localObject = (flf)paramab.next();
        qn localqn = new qn();
        localqn.YQK = ((flf)localObject).YQK;
        localqn.hAP = ((flf)localObject).hAP;
        localLinkedList.add(localqn);
        continue;
        if ((((flj)localObject).style == 101) || (((flj)localObject).style == 102) || (((flj)localObject).style == 103))
        {
          paramab = paramab.iYp();
          if (paramab != null)
          {
            paramab = paramab.abLM;
            if (paramab != null)
            {
              paramab = paramab.YSB;
              if (paramab != null)
              {
                paramab = ((Iterable)paramab).iterator();
                while (paramab.hasNext())
                {
                  localObject = (qo)paramab.next();
                  if (localObject != null)
                  {
                    localObject = ((qo)localObject).YVI;
                    if (localObject != null)
                    {
                      localObject = ((Iterable)localObject).iterator();
                      while (((Iterator)localObject).hasNext()) {
                        localLinkedList.add((qn)((Iterator)localObject).next());
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
    AppMethodBeat.o(248558);
    return localLinkedList;
  }
  
  public static final int K(ab paramab)
  {
    int i = 1;
    int j = 1;
    AppMethodBeat.i(248636);
    kotlin.g.b.s.u(paramab, "<this>");
    if (paramab.iYe()) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(248636);
      return i;
      if (paramab.iYf())
      {
        paramab = paramab.iYp();
        i = j;
        if (paramab != null)
        {
          i = j;
          switch (paramab.style)
          {
          case 0: 
          case 3: 
          case 5: 
          default: 
            i = j;
            break;
          case 101: 
          case 102: 
            i = 3;
            break;
          case 1001: 
            i = 5;
            break;
          case 103: 
            i = 7;
            break;
          }
        }
      }
      else if (paramab.iYg())
      {
        i = 4;
      }
      else if (paramab.iYd())
      {
        paramab = paramab.acFJ;
        if ((paramab != null) && (paramab.bcb == 2002)) {}
        for (;;)
        {
          if (i == 0) {
            break label194;
          }
          i = 10;
          break;
          i = 0;
        }
        label194:
        i = 9;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public static final ab a(flj paramflj, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(248662);
    kotlin.g.b.s.u(paramflj, "wrapper");
    if (!c(paramflj, null))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately illegal");
      AppMethodBeat.o(248662);
      return null;
    }
    if (!cA(paramflj.abLO.ablO, true))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately pkg version invalid");
      AppMethodBeat.o(248662);
      return null;
    }
    if (e(paramflj))
    {
      AppMethodBeat.o(248662);
      return null;
    }
    Object localObject1 = com.tencent.mm.an.af.bHl().iYx();
    long l1;
    ab localab;
    long l2;
    label215:
    long l3;
    label258:
    int i;
    label279:
    int j;
    if (paramflj.abLN == 1) {
      if (Math.abs(paramflj.abry * 1000L - br.bCJ()) <= 86400000L)
      {
        l1 = paramflj.abry * 1000L;
        localab = new ab();
        localab.field_msgId = com.tencent.mm.an.af.bHl().iYH();
        localab.field_msgSvrId = 0L;
        localab.field_type = 620757041;
        localab.field_talker = "";
        localab.field_talkerId = 0;
        localab.field_createTime = l1;
        localab.po(1);
        localab.field_status = 3;
        a(localab, paramflj);
        localab.b(paramflj);
        if (!paramBoolean) {
          break label672;
        }
        l2 = com.tencent.mm.an.af.bHl().iYD();
        l3 = 0L;
        l1 = l3;
        if (localObject1 != null)
        {
          if (paramflj.abLO.weight < 0) {
            break label683;
          }
          l1 = Math.min(paramflj.abLO.weight, ad.yU(((ab)localObject1).field_orderFlag));
        }
        l3 = l1;
        if (paramBoolean)
        {
          if (paramInt < 0) {
            break label761;
          }
          if (paramInt > 255) {
            break label756;
          }
          i = 1;
          l3 = l1;
          if (i != 0) {
            l3 = kotlin.k.k.bS(l1, paramInt);
          }
        }
        long l4 = ad.bH(l2, localab.field_createTime / 1000L);
        l1 = l4;
        if (l4 >= 4294967296L)
        {
          Log.w("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately serialNumber is too big %d", new Object[] { Long.valueOf(l4) });
          l2 = com.tencent.mm.an.af.bHl().iYE();
          l1 = ad.bH(l2, localab.field_createTime / 1000L);
        }
        localab.field_orderFlag = (l1 | l2 << 32 | 0xFF000000 & l3 << 24);
        ad.H(localab);
        boolean bool = com.tencent.mm.an.af.bHl().E(localab);
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately result = " + bool + ", title = " + paramflj.abLO.title + " pos = " + paramflj.abLO.pos + " weight=" + paramflj.abLO.weight + ',' + localab.iYb() + " msgId=" + localab.field_msgId + " isInTimeLine=" + paramBoolean);
        if (bool)
        {
          localObject1 = r.acDM;
          if (r.iXt()) {
            com.tencent.mm.plugin.webcanvas.k.WkZ.ioR();
          }
          r.acDM.B(localab);
          localObject1 = af.acGt;
          af.ayG(0);
        }
        localObject1 = j.WkY;
        j.xC(82L);
        localObject1 = s.acEH;
        paramInt = paramflj.pos;
        i = paramflj.abLN;
        j = paramflj.style;
        l1 = paramflj.abry;
        localObject1 = paramflj.abLO;
        if (localObject1 != null) {
          break label766;
        }
        localObject1 = null;
        label607:
        localObject2 = paramflj.abLM;
        if (localObject2 != null) {
          break label776;
        }
      }
    }
    label776:
    for (Object localObject2 = null;; localObject2 = ((apx)localObject2).YSJ)
    {
      s.a(localab, 1, paramInt, i, j, l1, (String)localObject1, (String)localObject2, paramflj.hRR);
      AppMethodBeat.o(248662);
      return localab;
      l1 = br.bCJ();
      break;
      l1 = com.tencent.mm.an.af.bHl().iYz() + 1000L;
      break;
      label672:
      l2 = com.tencent.mm.an.af.bHl().iYa();
      break label215;
      label683:
      if (paramflj.abLO.pos == 0)
      {
        l1 = ad.yU(((ab)localObject1).field_orderFlag);
        break label258;
      }
      localObject1 = com.tencent.mm.an.af.bHl().ayB(paramflj.abLO.pos - 1);
      if (localObject1 == null)
      {
        Log.w("MicroMsg.BizTimeLineStorageLogicExKt", "insertCanvasCardImmediately lastTimeLineInfo is null");
        l1 = l3;
        break label258;
      }
      l1 = ad.yU(((ab)localObject1).field_orderFlag);
      break label258;
      label756:
      i = 0;
      break label279;
      label761:
      i = 0;
      break label279;
      label766:
      localObject1 = ((enc)localObject1).cardId;
      break label607;
    }
  }
  
  public static final LinkedList<String> a(ab paramab, pz parampz)
  {
    AppMethodBeat.i(248549);
    kotlin.g.b.s.u(paramab, "info");
    kotlin.g.b.s.u(parampz, "item");
    LinkedList localLinkedList = new LinkedList();
    if ((!paramab.iYf()) || (paramab.iYp() == null))
    {
      AppMethodBeat.o(248549);
      return localLinkedList;
    }
    paramab = ((Iterable)J(paramab)).iterator();
    label143:
    while (paramab.hasNext())
    {
      qn localqn = (qn)paramab.next();
      parampz.hrh.add(localqn.YQK);
      CharSequence localCharSequence = (CharSequence)localqn.YVF;
      if ((localCharSequence == null) || (kotlin.n.n.bp(localCharSequence))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label143;
        }
        parampz.YUr.add(localqn.YVF);
        break;
      }
    }
    AppMethodBeat.o(248549);
    return localLinkedList;
  }
  
  public static final void a(flj paramflj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248688);
    kotlin.g.b.s.u(paramflj, "wrapper");
    switch (paramflj.style)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(248688);
      return;
      Object localObject1 = paramflj.abLM;
      if (localObject1 != null)
      {
        localObject1 = ((apx)localObject1).YSB;
        if (localObject1 != null)
        {
          Object localObject2 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList();
          localObject2 = ((Iterable)localObject2).iterator();
          Object localObject3;
          label154:
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (((qo)localObject3).YFu == 0) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label154;
              }
              ((Collection)localObject1).add(localObject3);
              break;
            }
          }
          localObject1 = ((Iterable)localObject1).iterator();
          int i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              p.kkW();
            }
            localObject2 = (qo)localObject2;
            localObject3 = (qn)((qo)localObject2).YVI.get(0);
            if ((localObject3 != null) && ((((qn)localObject3).YFu & 0x1) == 0))
            {
              Object localObject4 = ((qn)localObject3).YQK;
              kotlin.g.b.s.s(localObject4, "it.ContentUrl");
              localObject4 = bvH((String)localObject4);
              com.tencent.mm.plugin.report.service.h.OAn.b(21461, new Object[] { ((qo)localObject2).UserName, localObject4[0], localObject4[1], Integer.valueOf(((qn)localObject3).nUA), paramflj.abLM.YSJ, paramflj.abLM.YSF, Integer.valueOf(i), Long.valueOf(paramflj.abry), paramflj.abLM.Zxp, Integer.valueOf(paramflj.style), ((qn)localObject3).YVF, Integer.valueOf(paramflj.weight), Integer.valueOf(paramInt1), Integer.valueOf(paramflj.abLN), Integer.valueOf(paramflj.pos), Integer.valueOf(paramInt2) });
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public static final void a(flj paramflj, Map<String, String> paramMap)
  {
    AppMethodBeat.i(248524);
    kotlin.g.b.s.u(paramflj, "wrapper");
    kotlin.g.b.s.u(paramMap, "values");
    b(paramflj, paramMap);
    AppMethodBeat.o(248524);
  }
  
  public static final void a(ab paramab, flj paramflj)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(248679);
    kotlin.g.b.s.u(paramab, "<this>");
    kotlin.g.b.s.u(paramflj, "wrapper");
    paramab.field_recommendCardId = "";
    switch (paramflj.style)
    {
    default: 
      AppMethodBeat.o(248679);
      return;
    case 101: 
    case 102: 
    case 103: 
      paramflj = paramflj.abLM;
      if (paramflj == null) {}
      for (paramflj = localObject1;; paramflj = paramflj.YSF)
      {
        paramab.field_recommendCardId = paramflj;
        AppMethodBeat.o(248679);
        return;
      }
    }
    paramflj = paramflj.abLO;
    if (paramflj == null) {}
    for (paramflj = localObject2;; paramflj = paramflj.cardId)
    {
      paramab.field_recommendCardId = paramflj;
      break;
    }
  }
  
  public static final void a(LinkedList<qo> paramLinkedList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(248542);
    kotlin.g.b.s.u(paramLinkedList, "<this>");
    kotlin.g.b.s.u(paramMap, "values");
    int i = 0;
    int j = i + 1;
    Object localObject1;
    String str;
    qo localqo;
    if (i == 0)
    {
      localObject1 = "";
      str = kotlin.g.b.s.X(".sysmsg.BizAccountRecommend.BizAccount", localObject1);
      if (!Util.isNullOrNil((String)paramMap.get(kotlin.g.b.s.X(str, ".UserName"))))
      {
        localqo = new qo();
        localqo.UserName = ((String)paramMap.get(kotlin.g.b.s.X(str, ".UserName")));
        localqo.vhX = ((String)paramMap.get(kotlin.g.b.s.X(str, ".NickName")));
        localqo.IJA = ((String)paramMap.get(kotlin.g.b.s.X(str, ".RecommendReason")));
        localqo.pSi = ((String)paramMap.get(kotlin.g.b.s.X(str, ".Signature")));
        localqo.YPo = ((String)paramMap.get(kotlin.g.b.s.X(str, ".BrandIconUrl")));
        localqo.YVH = ((String)paramMap.get(kotlin.g.b.s.X(str, ".AppMsgRecReason")));
        localqo.YVA = new LinkedList();
      }
    }
    int k;
    for (i = 0;; i = k)
    {
      k = i + 1;
      Object localObject2 = new StringBuilder().append(str).append(".NegativeFeedbackReason");
      label254:
      qn localqn;
      if (i == 0)
      {
        localObject1 = "";
        localObject1 = (String)paramMap.get(localObject1);
        if (!Util.isNullOrNil((String)localObject1))
        {
          localqo.YVA.add(localObject1);
          if (k <= 20) {
            continue;
          }
        }
        localqo.YVB = Util.getInt((String)paramMap.get(kotlin.g.b.s.X(str, ".ShowNegativeFeedbackReason")), 1);
        localqo.YVI = new LinkedList();
        paramLinkedList.add(localqo);
        i = 0;
        label348:
        k = i + 1;
        localObject2 = new StringBuilder().append(str).append(".AppMsg");
        if (i != 0) {
          break label1004;
        }
        localObject1 = "";
        label381:
        localObject2 = localObject1;
        if (!Util.isNullOrNil((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".Title"))))
        {
          localqn = new qn();
          localqn.hAP = ((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".Title")));
          localqn.YQI = ((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".Digest")));
          localqn.YQK = ((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".ContentUrl")));
          localqn.IJA = ((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".RecommendReason")));
          localqn.YQM = ((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".CoverImgUrl")));
          localqn.YQN = ((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".CoverImgUrl_1_1")));
          localqn.YQO = ((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".CoverImgUrl_235_1")));
          localqn.nUA = Util.getInt((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".ItemShowType")), -1);
          localqn.YQV = ((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".VideoId")));
          localqn.YQW = Util.getInt((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".VideoWidth")), -1);
          localqn.YQX = Util.getInt((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".VideoHeight")), -1);
          localqn.YQY = Util.getInt((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".VideoDuration")), -1);
          localqn.CreateTime = Util.getInt((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".CreateTime")), -1);
          localqn.YVC = ((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".VoicePlayUrl")));
          localqn.YVD = Util.getInt((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".VoiceDuration")), -1);
          localqn.YVA = new LinkedList();
        }
      }
      int m;
      label1027:
      label1033:
      for (i = 0;; i = m)
      {
        m = i + 1;
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject2).append(".NegativeFeedbackReason");
        if (i == 0) {}
        for (localObject1 = "";; localObject1 = Integer.valueOf(i))
        {
          localObject1 = (String)paramMap.get(localObject1);
          if (!Util.isNullOrNil((String)localObject1))
          {
            localqn.YVA.add(localObject1);
            if (m <= 20) {
              break label1033;
            }
          }
          localqn.YVB = Util.getInt((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".ShowNegativeFeedbackReason")), 1);
          localqn.YVE = Util.getInt((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".RecRk")), 0);
          localqn.YVF = ((String)paramMap.get(kotlin.g.b.s.X((String)localObject2, ".RecInfo")));
          localqn.YVG = SemiXml.encode(paramMap);
          localqo.YVI.add(localqn);
          if (k <= 1) {
            break label1027;
          }
          if (j <= 9) {
            break label1022;
          }
          AppMethodBeat.o(248542);
          return;
          localObject1 = Integer.valueOf(i);
          break;
          localObject1 = Integer.valueOf(i);
          break label254;
          label1004:
          localObject1 = Integer.valueOf(i);
          break label381;
        }
        label1022:
        i = j;
        break;
        i = k;
        break label348;
      }
    }
  }
  
  public static final boolean a(ene paramene)
  {
    AppMethodBeat.i(248572);
    kotlin.g.b.s.u(paramene, "<this>");
    Object localObject = paramene.abrC.get(0);
    kotlin.g.b.s.s(localObject, "this.RecommendItem[0]");
    if (!d((enp)localObject))
    {
      paramene = paramene.abrC.get(0);
      kotlin.g.b.s.s(paramene, "this.RecommendItem[0]");
      if (!e((enp)paramene)) {}
    }
    else
    {
      AppMethodBeat.o(248572);
      return true;
    }
    AppMethodBeat.o(248572);
    return false;
  }
  
  public static final boolean ayM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static final boolean ayN(int paramInt)
  {
    return (paramInt != 103) && (paramInt != 102) && (paramInt != 1001);
  }
  
  public static final void ayO(int paramInt)
  {
    AppMethodBeat.i(248718);
    Object localObject2 = kotlin.g.b.s.X("card_id_", Long.valueOf(System.currentTimeMillis()));
    if (paramInt == 1001)
    {
      localObject1 = kotlin.g.b.s.X("中国国家地理", Long.valueOf(System.currentTimeMillis() % 10000L));
      localObject1 = "<sysmsg type=\"BizRecommendExpt\">\n<BizRecommendExpt>\n<Title><![CDATA[猜你喜欢]]></Title>\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>1591189349</RecID>\n<RedDotFlag>1</RedDotFlag>\n<BusinessId>0</BusinessId>\n<PackageVersion>327166666</PackageVersion>\n<CardID><![CDATA[" + (String)localObject2 + "]]></CardID>\n<Data><![CDATA[{\"Title\":\"猜你喜欢\",\"BizAccount\":[{\"Flag\":0,\"UserName\":\"gh_f05ff0331d78\",\"NickName\":\"" + (String)localObject1 + "\",\"RecommendReason\":\"\",\"Signature\":\"《深度参考》是中国高端精英读物，是您了解最新、最有深度、最有价值的时事财经资讯窗口，欢迎关注！\",\"BrandIconUrl\":\"http://mmbiz.qpic.cn/mmbiz/3lXPl12icGVZjPnbiaWdLbMQoNpTK6ZicaTFUk5jLfciaRVoukmISPd5DC6YHy5No4a4uy6k3PnIMIH00XJOVw0ibRw/0?wx_fmt=png\",\"AppMsgRecReason\":\"近期更新\",\"AppMsg\":[{\"Flag\":0,\"Title\":\"气温超过50°的极热之地，你敢去吗？\",\"Digest\":\"我是摘要测试测试\",\"ContentUrl\":\"https://mp.weixin.qq.com/s/oKmmWfX9G3Yfbmp5aDeyTQ\",\"CoverImgUrl\":\"http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg\",\"CoverImgUrl_1_1\":\"https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg\",\"CoverImgUrl_235_1\":\"\",\"ItemShowType\":0,\"VideoId\":\"\",\"VideoWidth\":0,\"VideoHeight\":0,\"VideoDuration\":180,\"CreateTime\":1593296809,\"NegativeFeedbackReason\":[\"内容质量低\",\"不看此公众号\"],\"ShowNegativeFeedbackReason\":0,\"RecommendReason\":\"\",\"VoicePlayUrl\":\"\",\"VoiceDuration\":0,\"RecRk\":1,\"RecInfo\":\"something\",\"AppMsgId\":2698324179,\"ItemIdx\":1,\"AuthorAppUin\":1014597342,\"CanReward\":0,\"CanPaid\":0},{\"Flag\":0,\"Title\":\"深度雄文，西部高原屏障对中华民族战略安全的重大意义！\",\"Digest\":\"深度参考长按右边的二维码关注2013年4月在中国的阿克塞欣的斗拉特别里奥地地区中印两国爆发“帐蓬对峙”，20\",\"ContentUrl\":\"http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324092&idx=4&sn=015c49c8d05b56267366a2cce351c2ec&chksm=be5bbb08892c321e990026bce74c09ad13da8ec56896875358f4db0271222b09b146b95739b1#rd\",\"CoverImgUrl\":\"http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg\",\"CoverImgUrl_1_1\":\"https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg\",\"CoverImgUrl_235_1\":\"\",\"ItemShowType\":0,\"VideoId\":\"\",\"VideoWidth\":0,\"VideoHeight\":0,\"VideoDuration\":180,\"CreateTime\":1593211927,\"NegativeFeedbackReason\":[\"内容质量低\",\"不看此公众号\"],\"ShowNegativeFeedbackReason\":0,\"RecommendReason\":\"\",\"VoicePlayUrl\":\"\",\"VoiceDuration\":180,\"RecRk\":2,\"RecInfo\":\"great\",\"AppMsgId\":2698324092,\"ItemIdx\":4,\"AuthorAppUin\":1654122144,\"CanReward\":0,\"CanPaid\":0}],\"NegativeFeedbackReason\":[\"不看此公众号\",\"内容低质\",\"内容重复\",\"内容过时\",\"希望减少推荐\"],\"ShowNegativeFeedbackReason\":1,\"BizUin\":3007693851}],\"Pos\":1,\"Weight\":200,\"RecID\":10086,\"Style\":1001,\"Event\":\"hengqing\",\"RedDotFlag\":1,\"RecSummary\":\"深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！\",\"CardId\":\"cdd97abeab063a0e00cea86f805bb17c\",\"ExpType\":\"tools\"}]]></Data>\n<RecSummary><![CDATA[气温超过50°的极热之地，你敢去吗？]]></RecSummary>\n<AppId><![CDATA[wxf337cbaa27790d8e]]></AppId>\n<ExtraData><![CDATA[{\"type\":1,\"real_data\":\"{\\\"biz_info\\\":[{\\\"username\\\":\\\"gh_49f4cd2ce99b\\\",\\\"nickname\\\":\\\"皮皮浪老师\\\",\\\"appmsg_info\\\":[{\\\"url\\\":\\\"http:\\\\\\/\\\\\\/mp.weixin.qq.com\\\\\\/s?__biz=MzA4OTE5NzQ5MQ==&mid=2247483877&idx=1&sn=e693e539daef056fa051e66374e41b48&chksm=901fdf39a768562fe6aaaeed3dfc9909d781ea8c45862cc335ed527eafcdb51f4aca774f67c3#rd\\\",\\\"title\\\":\\\"皮皮浪的复盘讲解（二十二）——围空不要拆二\\\",\\\"rec_rk\\\":1,\\\"rec_info\\\":\\\"something\\\",\\\"item_show_type\\\":5}]}],\\\"style\\\":1001,\\\"event\\\":\\\"hengqing\\\",\\\"card_id\\\":\\\"33a95e9794780cc0f584220dbb9fcfe2\\\",\\\"exp_type\\\":\\\"tools\\\"}\"}]]></ExtraData>\n<TemplatePath><![CDATA[re.js]]></TemplatePath>\n<TemplatePathType><![CDATA[re]]></TemplatePathType>\n</BizRecommendExpt>\n</sysmsg>";
      paramInt = kotlin.n.n.a((CharSequence)localObject1, "<sysmsg", 0, false, 6);
      if (paramInt != -1)
      {
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(248718);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((String)localObject1).substring(paramInt);
        kotlin.g.b.s.s(localObject2, "(this as java.lang.String).substring(startIndex)");
        localObject2 = XmlParser.parseXml((String)localObject2, "sysmsg", null);
        if (localObject2 == null)
        {
          Log.e("MicroMsg.BizTimeLineStorageLogicExKt", "XmlParser values is null, msgContent %s", new Object[] { localObject1 });
          AppMethodBeat.o(248718);
        }
      }
      else
      {
        AppMethodBeat.o(248718);
        return;
      }
      localObject1 = cA((Map)localObject2);
      kotlin.g.b.s.checkNotNull(localObject1);
      d((flj)localObject1);
      AppMethodBeat.o(248718);
      return;
    }
    Object localObject1 = "";
    if (paramInt == 2001)
    {
      long l = System.currentTimeMillis() / 1000L;
      localObject1 = "<sysmsg type=\"BizRecommendExpt\"><BizRecommendExpt>\n<Title><![CDATA[旅行自媒体创业4年，我们从零开始的故事....#人人都是创作者 #我的旅行生活 @微信时刻 @微信创作者 ]]></Title>\n<Pos>2</Pos>\n<Weight>-1</Weight>\n<RecID>1639469558</RecID>\n<RedDotFlag>1</RedDotFlag>\n<BusinessId>2</BusinessId>\n<CardID><![CDATA[finder_rec_card_" + System.currentTimeMillis() + "_export/UzFfAgtgekIEAQAAAAAAXLMERz4qPwAAAAstQy6ubaLX4KHWvLEZgBPEyZMECBI_BIj9zNPgMItDO2sB6ukmHhSn80LkaIt7]]></CardID>\n<Data><![CDATA[{\"style\":1008,\"show_type\":2,\"rec_datas\":[{\"bizuin\":0,\"headimg_url\":\"http://wx.qlogo.cn/finderhead/ajNVdqHZLLD16d5F7KSWDhu0mLZ990XT3hBmptKFibq0tG3xugTAUPA/64\",\"nick_name\":\"牛肉夫妻出逃记\",\"username\":\"\",\"finder_uin\":\"\",\"finder_encrypt_user_name\":\"v2_060000231003b20faec8c6e6811fc3d6ca02ee30b07755b80bf2671109baf9515bc9214e9dc1@finder\",\"title\":\"旅行自媒体创业4年，我们从零开始的故事....#人人都是创作者 #我的旅行生活 @微信时刻 @微信创作者 \",\"cover_img_url\":\"http://wxapp.tc.qq.com/251/20304/stodownload?filekey=30250201010411300f020200fb0402535a040002030175ce040d00000004627466730000000132&storeid=261b7509600059835efe2c51b000000fb00004f50535a051618809625aa966&adaptivelytrans=0&bizid=1023&dotrans=0&hy=SZ&m=&scene=0&picformat=200\",\"finder_object_id\":\"13752720681011580957\",\"finder_export_id\":\"export/UzFfAgtgekIEAQAAAAAAXLMERz4qPwAAAAstQy6ubaLX4KHWvLEZgBPEyZMECBI_BIj9zNPgMItDO2sB6ukmHhSn80LkaIt7\",\"finder_object_nonce_id\":\"13202483152707429542\",\"finder_media_type\":4,\"finder_export_username\":\"export/UzFfAgtgekIEAQAAAAAAJcEnahSLRQAAAAstQy6ubaLX4KHWvLEZgBPElJg-DxE0eXJTzNvhHHrGUchzA9h5H3nVEoAE6A\",\"finder_duration\":86,\"finder_height\":1080,\"finder_width\":1920,\"finder_cover_height\":1080,\"finder_cover_width\":1920,\"finder_like_count\":16,\"finder_comment_count\":1,\"finder_create_time\":" + l + ",\"show_finder\":1,\"alignment\":2,\"recommend_reason\":\"\",\"recommend_send_time\":" + l + ",\"exp_type\":\"recommend_card_vedio_insert_vediofinder_strategy\"},{\"bizuin\":0,\"headimg_url\":\"http://wx.qlogo.cn/finderhead/PiajxSqBRaELialibQmJSwn26dBDbLpMmMBeFs20wrEU2qiaFszERYsbWw/64\",\"nick_name\":\"-肥猪猪的日常\",\"username\":\"\",\"finder_uin\":\"\",\"finder_encrypt_user_name\":\"v2_060000231003b20faec8cae38c10c0d3cc02e430b0774db52853161520a85769411f0b44d41b@finder\",\"title\":\"一次解锁两个口味提拉米苏，喜欢吃甜点的一定要做起来，简直是神仙美味！#提拉米苏@微信时刻\",\"cover_img_url\":\"http://wxapp.tc.qq.com/251/20304/stodownload?m=948baf0a10df722b305fcb8663b94e2b&filekey=30350201010421301f020200fb040253480410948baf0a10df722b305fcb8663b94e2b020303ccc3040d00000004627466730000000132&hy=SH&storeid=161b7602b000ab75d129ecef5000000fb00004f50534802e35b00b72c43ce5&dotrans=0&bizid=1023&adaptivelytrans=0&picformat=200\",\"finder_object_id\":\"13752622588133513262\",\"finder_export_id\":\"export/UzFfAgtgekIEAQAAAAAAFKo2pKMsugAAAAstQy6ubaLX4KHWvLEZgBPE-oMoQwFAEoj9zNPgMIukJe20L-aoYPEg-3KA3H3-\",\"finder_object_nonce_id\":\"17451324971833681560\",\"finder_media_type\":4,\"finder_export_username\":\"export/UzFfAgtgekIEAQAAAAAABe8JRvUlggAAAAstQy6ubaLX4KHWvLEZgBPEqIkZFx40eXJTzNvh4Pbe3n2BrRvS_cRW8y6j3A\",\"finder_duration\":56,\"finder_height\":1920,\"finder_width\":1080,\"finder_cover_height\":1920,\"finder_cover_width\":1080,\"finder_like_count\":2531,\"finder_comment_count\":48,\"finder_create_time\":" + l + ",\"show_finder\":1,\"alignment\":2,\"recommend_reason\":\"\",\"recommend_send_time\":" + l + ",\"exp_type\":\"recommend_card_vedio_insert_vediofinder_strategy\"}]}]]></Data>\n<RecSummary><![CDATA[牛肉夫妻出逃记:旅行自媒体创业4年，我们从零开始的故事....#人人都是创作者 #我的旅行生活 @微信时刻 @微信创作者 ]]></RecSummary>\n<TemplatePath><![CDATA[]]></TemplatePath>\n<AppId><![CDATA[wxf337cbaa27790d8e]]></AppId>\n<UseServerTime>1</UseServerTime>\n<ExtraData><![CDATA[{}]]></ExtraData>\n<TemplatePathType><![CDATA[re]]></TemplatePathType>\n<PackageVersion>127325850</PackageVersion>\n</BizRecommendExpt>";
      paramInt = kotlin.n.n.a((CharSequence)localObject1, "<sysmsg", 0, false, 6);
      if (paramInt != -1)
      {
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(248718);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((String)localObject1).substring(paramInt);
        kotlin.g.b.s.s(localObject2, "(this as java.lang.String).substring(startIndex)");
        localObject2 = XmlParser.parseXml((String)localObject2, "sysmsg", null);
        if (localObject2 == null)
        {
          Log.e("MicroMsg.BizTimeLineStorageLogicExKt", "XmlParser values is null, msgContent %s", new Object[] { localObject1 });
          AppMethodBeat.o(248718);
        }
      }
      else
      {
        AppMethodBeat.o(248718);
        return;
      }
      localObject1 = cA((Map)localObject2);
      kotlin.g.b.s.checkNotNull(localObject1);
      d((flj)localObject1);
      AppMethodBeat.o(248718);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      ad.aj((String)localObject1, null);
      AppMethodBeat.o(248718);
      return;
      localObject1 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_f05ff0331d78]]></UserName>\n<NickName><![CDATA[深度参考]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[《深度参考》是中国高端精英读物，是您了解最新、最有深度、最有价值的时事财经资讯窗口，欢迎关注！]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/3lXPl12icGVZjPnbiaWdLbMQoNpTK6ZicaTFUk5jLfciaRVoukmISPd5DC6YHy5No4a4uy6k3PnIMIH00XJOVw0ibRw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324179&idx=1&sn=02fb8d7cbd9a4187266280edccc1c303&chksm=be5bbba7892c32b19e13202074ffb143c96ff4d1024939ce4c917cf740905e67444b11604b13#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1593296809</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecommendReason><![CDATA[粤知一二]]></RecommendReason>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n<AppMsg>\n<Title><![CDATA[深度雄文，西部高原屏障对中华民族战略安全的重大意义！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324092&idx=4&sn=015c49c8d05b56267366a2cce351c2ec&chksm=be5bbb08892c321e990026bce74c09ad13da8ec56896875358f4db0271222b09b146b95739b1#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1593211927</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>2</RecRk>\n<RecommendReason><![CDATA[粤知一二]]></RecommendReason>\n<RecInfo><![CDATA[great]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>102</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></RecSummary>\n<CardId><![CDATA[" + (String)localObject2 + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
      continue;
      localObject1 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_028c33dfd807]]></UserName>\n<NickName><![CDATA[粤知一二]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[由广东综艺90后门面担当郭嘉峰主持，是一档有个性有深度，看了会上瘾的粤语脱口秀节目。每晚18：00准时更新。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/Y7rtYuVxk9TNiaA7iciav0aI5ZNxxxVybPXOoxocjzdu2REcv0bck59HFZ9jJTmHB6spYXlqibCfUia8E9997dLaoHw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDU3Njk4MA==&mid=2247506230&idx=2&sn=80d0ead06f7d4446e42a89d57ee81699&chksm=ebb4cf8ddcc3469b4d62d4324bcec575812c28fea3d68af6e838f0a9a5bb79a8db7320fc7e70#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[https://vpic.video.qq.com/36675860/i0787zrbitj.png]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>5</ItemShowType>\n<VideoId><![CDATA[i0787zrbitj]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>245</VideoDuration>\n<CreateTime>1592751453</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecommendReason><![CDATA[粤知一二]]></RecommendReason>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n<AppMsg>\n<Title><![CDATA[教你一套坐公交车自救秘籍，你想要吗？]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDU3Njk4MA==&mid=2247494577&idx=1&sn=b0e489f3f5517b7942526aab7710052c&chksm=ebb4fd0adcc3741cc503f47ca2e1193af82db286d2baa438bb8d6209de9e192d8aaac5281d2a#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/Y7rtYuVxk9QHKGicgHASZibRp09iaGwSnnAN4cHzBvfupOIsibv78UfUGAJtcH1wT7wmAOicHib1k8a2FErDx7DFMNpg/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>5</ItemShowType>\n<VideoId><![CDATA[wxv_543960396546260993]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<RecommendReason><![CDATA[粤知一二]]></RecommendReason>\n<VideoDuration>314</VideoDuration>\n<CreateTime>1542015514</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>2</RecRk>\n<RecInfo><![CDATA[great]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>102</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></RecSummary>\n<CardId><![CDATA[" + (String)localObject2 + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
      continue;
      localObject1 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_028c33dfd807]]></UserName>\n<NickName><![CDATA[粤知一二]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[由广东综艺90后门面担当郭嘉峰主持，是一档有个性有深度，看了会上瘾的粤语脱口秀节目。每晚18：00准时更新。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/Y7rtYuVxk9TNiaA7iciav0aI5ZNxxxVybPXOoxocjzdu2REcv0bck59HFZ9jJTmHB6spYXlqibCfUia8E9997dLaoHw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDU3Njk4MA==&mid=2247506230&idx=2&sn=80d0ead06f7d4446e42a89d57ee81699&chksm=ebb4cf8ddcc3469b4d62d4324bcec575812c28fea3d68af6e838f0a9a5bb79a8db7320fc7e70#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[https://vpic.video.qq.com/36675860/i0787zrbitj.png]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>5</ItemShowType>\n<VideoId><![CDATA[i0787zrbitj]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>245</VideoDuration>\n<CreateTime>1592751453</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecommendReason><![CDATA[粤知一二]]></RecommendReason>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>102</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></RecSummary>\n<CardId><![CDATA[" + (String)localObject2 + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
      continue;
      localObject1 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_f05ff0331d78]]></UserName>\n<NickName><![CDATA[深度参考]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[《深度参考》是中国高端精英读物，是您了解最新、最有深度、最有价值的时事财经资讯窗口，欢迎关注！]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/3lXPl12icGVZjPnbiaWdLbMQoNpTK6ZicaTFUk5jLfciaRVoukmISPd5DC6YHy5No4a4uy6k3PnIMIH00XJOVw0ibRw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324179&idx=1&sn=02fb8d7cbd9a4187266280edccc1c303&chksm=be5bbba7892c32b19e13202074ffb143c96ff4d1024939ce4c917cf740905e67444b11604b13#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1593296809</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>101</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></RecSummary>\n<CardId><![CDATA[" + (String)localObject2 + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
      continue;
      localObject1 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[推荐公众号]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_240fbf8b33e4]]></UserName>\n<NickName><![CDATA[36氪]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[36氪是中国领先的新商业媒体，提供新锐深度的商业报道。我们强调趋势与价值，我们的slogan是：让一部分人先看到未来。]]></RecommendReason>\n<Signature><![CDATA[36氪是中国领先的新商业媒体，提供新锐深度的商业报道。我们强调趋势与价值，我们的slogan是：让一部分人先看到未来。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/QicyPhNHD5vYf0JyXiavcUmicQ7icOk55ygRlyOhCa9r132trMAiaYtqL0QzacfMLPolhsiaXGibWC0JskibLic02W6Mw1g/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[8点1氪：微信回应或遭苹果下架；格力口罩昨日开售：KN95每只5.5元；美股史上第二次触发熔断]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI2NDk5NzA0Mw==&mid=2247569208&idx=1&sn=27b7704f80c8271dcad2e52ee63cdf01&chksm=eaa79ee4ddd017f21d63e7a780c1941812f847bf968b40b2d81329b4e9f5a4f70f4e6e814c79#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/QicyPhNHD5vbhqC2kPdlU3tQrCiakmhHStEcNCOLwrocic2Vvr0J3qPNiaKYEn2vYIsQbGFBYM5PSAF9NecOalcnFw/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/QicyPhNHD5vbhqC2kPdlU3tQrCiakmhHStkWNVPziaEt1aEVBPnYyrzlpAbEXicqQ8zRmNgDBfupiccdibuBpeCHpKeQ/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1583799540</CreateTime>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[对A1不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对A2不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对此公众号不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<BizAccount>\n<UserName><![CDATA[gh_363b924965e9]]></UserName>\n<NickName><![CDATA[人民日报]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[参与、沟通、记录时代。]]></RecommendReason>\n<Signature><![CDATA[参与、沟通、记录时代。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/xrFYciaHL08CtD0lEHt59N8SQicW1gI0WjYKCEpzgRCPFBlJGI1rIfRl4bFSTLoFnI4iaylWmJVqd8semEK1OGylg/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[发请柬啦！我们邀请所有人，共同见证一场盛大的婚礼！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&mid=2666316160&idx=1&sn=54684fd350167a7f3bed5bde5ce9dc64&chksm=bdb4a8c38ac321d5852e261a2e31f038fd0e98ec66bee2920d88ee4cdf11979bdede1e0c908e#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/xrFYciaHL08AD1ynAav39zdY1WvI5bbsyACCQygrAQqFY1EZiaRwHJYMD7v2x2LLBp0YsHwku3In19N5D3aYZx9A/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/xrFYciaHL08AD1ynAav39zdY1WvI5bbsy1kWLuqdNxNVFWIUWBC0DTgnyAkt5cAicI2DyfkVZ14Bx5oemgWmiaphg/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1589804841</CreateTime>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[对D不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对此公众号不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>1589808970</RecID>\n<Style>103</Style>\n<Event></Event>\n<RecSummary><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></RecSummary>\n<CardId><![CDATA[" + (String)localObject2 + "]]></CardId>\n<AggregationUrl><![CDATA[http://wwww.baidu.com]]></AggregationUrl>\n<AggregationTitle><![CDATA[大家都在看的大事件 >]]></AggregationTitle>\n<NegativeFeedbackReason><![CDATA[对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对A2不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对此公众号不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
    }
  }
  
  private static void b(flj paramflj, Map<String, String> paramMap)
  {
    AppMethodBeat.i(248532);
    kotlin.g.b.s.u(paramflj, "<this>");
    kotlin.g.b.s.u(paramMap, "values");
    Object localObject = (a)new ah.a(paramflj, paramMap);
    switch (paramflj.style)
    {
    default: 
      AppMethodBeat.o(248532);
      return;
    case 101: 
      ((a)localObject).invoke();
      AppMethodBeat.o(248532);
      return;
    }
    ((a)localObject).invoke();
    apx localapx = paramflj.abLM;
    int j;
    label244:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (i == 0) {}
      for (paramflj = "";; paramflj = Integer.valueOf(i))
      {
        paramflj = (String)paramMap.get(kotlin.g.b.s.X(".sysmsg.BizAccountRecommend.NegativeFeedbackReason", paramflj));
        if (!Util.isNullOrNil(paramflj))
        {
          localapx.YVA.add(paramflj);
          if (j <= 20) {
            break label244;
          }
        }
        localapx.YVB = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.ShowNegativeFeedbackReason"), 0);
        localObject = (String)paramMap.get(".sysmsg.BizAccountRecommend.AggregationUrl");
        paramflj = (flj)localObject;
        if (localObject == null) {
          paramflj = "";
        }
        localapx.Zxq = paramflj;
        paramMap = (String)paramMap.get(".sysmsg.BizAccountRecommend.AggregationTitle");
        paramflj = paramMap;
        if (paramMap == null) {
          paramflj = "";
        }
        localapx.Zxr = paramflj;
        break;
      }
    }
  }
  
  public static final boolean b(ene paramene)
  {
    AppMethodBeat.i(248566);
    kotlin.g.b.s.u(paramene, "<this>");
    if (paramene.bcb == 2003)
    {
      AppMethodBeat.o(248566);
      return true;
    }
    AppMethodBeat.o(248566);
    return false;
  }
  
  public static final boolean b(enp paramenp)
  {
    AppMethodBeat.i(248582);
    kotlin.g.b.s.u(paramenp, "<this>");
    if (paramenp.abrD == p.h.ojE.value)
    {
      AppMethodBeat.o(248582);
      return true;
    }
    AppMethodBeat.o(248582);
    return false;
  }
  
  public static final String[] bvH(String paramString)
  {
    AppMethodBeat.i(248690);
    kotlin.g.b.s.u(paramString, "<this>");
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (!Util.isNullOrNil(paramString)) {}
    try
    {
      Uri localUri = Uri.parse(paramString);
      String str = localUri.getQueryParameter("mid");
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      arrayOfString[0] = paramString;
      str = localUri.getQueryParameter("idx");
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      arrayOfString[1] = paramString;
    }
    catch (Exception paramString)
    {
      label81:
      break label81;
    }
    AppMethodBeat.o(248690);
    return arrayOfString;
  }
  
  public static final boolean c(ene paramene)
  {
    AppMethodBeat.i(248606);
    kotlin.g.b.s.u(paramene, "recFeed");
    if (!ayM(paramene.bcb))
    {
      Log.w("MicroMsg.BizTimeLineStorageLogicExKt", kotlin.g.b.s.X("[TRACE_BIZRECFEED] not support style ", Integer.valueOf(paramene.bcb)));
      AppMethodBeat.o(248606);
      return false;
    }
    if (paramene.bcb == 2003)
    {
      if (!cA(paramene.abrJ, true))
      {
        Log.w("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] canvas card pkg version invalid");
        AppMethodBeat.o(248606);
        return false;
      }
      Log.d("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] canvas just return true");
      AppMethodBeat.o(248606);
      return true;
    }
    Object localObject = (Collection)paramene.abrC;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] RecommendItem is illegal");
      AppMethodBeat.o(248606);
      return false;
    }
    if (paramene.bcb == 2002)
    {
      localObject = (CharSequence)paramene.Zxr;
      if ((localObject == null) || (kotlin.n.n.bp((CharSequence)localObject))) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] AggregationTitle is illegal");
        AppMethodBeat.o(248606);
        return false;
      }
      localObject = (CharSequence)paramene.Zxq;
      if ((localObject == null) || (kotlin.n.n.bp((CharSequence)localObject))) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] AggregationUrl is illegal");
        AppMethodBeat.o(248606);
        return false;
      }
      localObject = (CharSequence)paramene.abrE;
      if ((localObject == null) || (kotlin.n.n.bp((CharSequence)localObject))) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] RecommendWording is illegal");
        AppMethodBeat.o(248606);
        return false;
      }
    }
    paramene = paramene.abrC;
    kotlin.g.b.s.s(paramene, "recFeed.RecommendItem");
    localObject = ((Iterable)paramene).iterator();
    label898:
    while (((Iterator)localObject).hasNext())
    {
      enp localenp = (enp)((Iterator)localObject).next();
      paramene = localenp.abse;
      if (paramene == null)
      {
        paramene = null;
        paramene = (CharSequence)paramene;
        if ((paramene != null) && (!kotlin.n.n.bp(paramene))) {
          break label396;
        }
      }
      label396:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label401;
        }
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] Title is illegal");
        AppMethodBeat.o(248606);
        return false;
        paramene = paramene.hAP;
        break;
      }
      label401:
      paramene = localenp.abse;
      if (paramene == null)
      {
        paramene = null;
        paramene = (CharSequence)paramene;
        if ((paramene != null) && (!kotlin.n.n.bp(paramene))) {
          break label458;
        }
      }
      label458:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label463;
        }
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] ContentUrl is illegal");
        AppMethodBeat.o(248606);
        return false;
        paramene = paramene.YQK;
        break;
      }
      label463:
      paramene = localenp.abse;
      if (paramene == null) {}
      for (i = -1; (i != 5) && (i != 8) && (i != 10) && (i != 0); i = paramene.nUA)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] ItemShowType is illegal, itemShowType=" + i + '.');
        AppMethodBeat.o(248606);
        return false;
      }
      kotlin.g.b.s.s(localenp, "recommendItem");
      if (b(localenp))
      {
        paramene = localenp.abse;
        if (paramene == null) {
          paramene = null;
        }
        while ((paramene == null) || (localenp.abse.aaIF.abiJ.size() < 3))
        {
          Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] showThreePic PictureInfo is illegal, itemShowType=" + i + '.');
          AppMethodBeat.o(248606);
          return false;
          paramene = paramene.aaIF;
          if (paramene == null) {
            paramene = null;
          } else {
            paramene = paramene.abiJ;
          }
        }
      }
      paramene = localenp.absd;
      if (paramene == null)
      {
        paramene = null;
        paramene = (CharSequence)paramene;
        if ((paramene != null) && (!kotlin.n.n.bp(paramene))) {
          break label698;
        }
      }
      label698:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label703;
        }
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] NickName is illegal");
        AppMethodBeat.o(248606);
        return false;
        paramene = paramene.vhX;
        break;
      }
      label703:
      paramene = localenp.absd;
      if (paramene == null)
      {
        paramene = null;
        paramene = (CharSequence)paramene;
        if ((paramene != null) && (!kotlin.n.n.bp(paramene))) {
          break label760;
        }
      }
      label760:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label765;
        }
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] NickName is illegal");
        AppMethodBeat.o(248606);
        return false;
        paramene = paramene.UserName;
        break;
      }
      label765:
      paramene = localenp.abse;
      if ((paramene != null) && (5 == paramene.nUA))
      {
        i = 1;
        if (i == 0) {
          break label832;
        }
        paramene = localenp.abse;
        if (paramene != null) {
          break label824;
        }
      }
      label824:
      for (paramene = null;; paramene = paramene.aaID)
      {
        if (paramene != null) {
          break label832;
        }
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] VideoInfo is illegal");
        AppMethodBeat.o(248606);
        return false;
        i = 0;
        break;
      }
      label832:
      paramene = localenp.abse;
      if ((paramene != null) && (7 == paramene.nUA))
      {
        i = 1;
        label852:
        if (i == 0) {
          break label890;
        }
        paramene = localenp.abse;
        if (paramene != null) {
          break label892;
        }
      }
      label890:
      label892:
      for (paramene = null;; paramene = paramene.aaIE)
      {
        if (paramene != null) {
          break label898;
        }
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] VoiceInfo is illegal");
        AppMethodBeat.o(248606);
        return false;
        i = 0;
        break label852;
        break;
      }
    }
    AppMethodBeat.o(248606);
    return true;
  }
  
  public static final boolean c(flj paramflj, ab paramab)
  {
    AppMethodBeat.i(248631);
    kotlin.g.b.s.u(paramflj, "wrapper");
    int k = paramflj.style;
    if (k == 1001)
    {
      if (paramflj.abLO == null)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal exptInfo = null");
        AppMethodBeat.o(248631);
        return false;
      }
      if (Util.isNullOrNil(paramflj.abLO.data))
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal exptInfo.data = null");
        AppMethodBeat.o(248631);
        return false;
      }
      if ((Util.isNullOrNil(paramflj.abLO.appId)) || (Util.isNullOrNil(paramflj.abLO.abrA)))
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal appid or path error, appId = " + paramflj.abLO.appId + ", path = " + paramflj.abLO.abrA);
        AppMethodBeat.o(248631);
        return false;
      }
      AppMethodBeat.o(248631);
      return true;
    }
    Object localObject = paramflj.abLK;
    if (localObject == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal recCard null");
      AppMethodBeat.o(248631);
      return false;
    }
    if (((fle)localObject).Zxn == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal CardTitle null");
      AppMethodBeat.o(248631);
      return false;
    }
    if (((fle)localObject).YVH == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal AppMsgRecReason null");
      AppMethodBeat.o(248631);
      return false;
    }
    flg localflg = ((fle)localObject).abLF;
    if (localflg == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo null");
      AppMethodBeat.o(248631);
      return false;
    }
    if (localflg.UserName == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo UserName null");
      AppMethodBeat.o(248631);
      return false;
    }
    if (localflg.vhX == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo NickName null");
      AppMethodBeat.o(248631);
      return false;
    }
    if (localflg.abLH == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo RecReason null");
      AppMethodBeat.o(248631);
      return false;
    }
    if (Util.isNullOrNil((List)((fle)localObject).YVI))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] AppMsg null");
      AppMethodBeat.o(248631);
      return false;
    }
    if ((k == 5) && (((fle)localObject).YVI.size() < 2))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] AppMsg video size < 2");
      AppMethodBeat.o(248631);
      return false;
    }
    switch (k)
    {
    default: 
      AppMethodBeat.o(248631);
      return true;
    }
    if ((paramflj.abLM == null) || (Util.isNullOrNil((List)paramflj.abLM.YSB)) || (paramflj.abLM.YSB.size() >= 3))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + k + " BizInfo size >= 3");
      AppMethodBeat.o(248631);
      return false;
    }
    if (paramflj.abLM.YFu == 1)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + k + " extraInfo flag = 1");
      if (paramab != null) {
        com.tencent.mm.an.af.bHl().yQ(paramab.field_msgId);
      }
      AppMethodBeat.o(248631);
      return false;
    }
    int m = paramflj.abLM.YSB.size() - 1;
    if (m >= 0) {}
    int j;
    label1137:
    label1138:
    label1140:
    label1145:
    label1150:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (((qo)paramflj.abLM.YSB.get(i)).YFu != 1) {}
      for (i = 1; i == 0; i = 0)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + k + " bizLegal illegal");
        if (paramab != null) {
          com.tencent.mm.an.af.bHl().yQ(paramab.field_msgId);
        }
        AppMethodBeat.o(248631);
        return false;
        if (j <= m) {
          break label1150;
        }
      }
      if (ayN(k))
      {
        m = paramflj.abLM.YSB.size() - 1;
        if (m < 0) {}
      }
      for (i = 0;; i = j)
      {
        j = i + 1;
        localObject = ((qo)paramflj.abLM.YSB.get(i)).UserName;
        kotlin.g.b.s.s(localObject, "wrapper.extraInfo.BizInfo[i].UserName");
        if (!IR((String)localObject)) {}
        for (i = 0; i != 0; i = 1)
        {
          Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + k + " bizLegal contact");
          if (paramab != null) {
            com.tencent.mm.an.af.bHl().yQ(paramab.field_msgId);
          }
          AppMethodBeat.o(248631);
          return false;
          if (j <= m) {
            break label1145;
          }
        }
        m = paramflj.abLM.YSB.size() - 1;
        if (m >= 0) {}
        for (i = 0;; i = j)
        {
          j = i + 1;
          if (Util.isNullOrNil((List)((qo)paramflj.abLM.YSB.get(i)).YVI))
          {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + k + " AppMsg null");
            AppMethodBeat.o(248631);
            return false;
          }
          if (((qn)((qo)paramflj.abLM.YSB.get(i)).YVI.get(0)).YFu == 1) {}
          for (i = 0; i == 0; i = 1)
          {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + k + " AppMsg illegal");
            AppMethodBeat.o(248631);
            return false;
            if (j <= m) {
              break label1140;
            }
          }
          paramflj = ((qo)paramflj.abLM.YSB.get(0)).YVI;
          kotlin.g.b.s.s(paramflj, "wrapper.extraInfo.BizInfo[0].AppMsg");
          paramflj = ((Iterable)paramflj).iterator();
          i = 1;
          if (paramflj.hasNext())
          {
            paramab = (qn)paramflj.next();
            if ((paramab.nUA != 8) && (paramab.nUA != 7) && (paramab.nUA != 6) && (paramab.nUA != 10)) {
              break label1137;
            }
            i = 0;
          }
          for (;;)
          {
            break;
            if (i != 0) {
              break label1138;
            }
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + k + " showTypeLegal illegal");
            AppMethodBeat.o(248631);
            return false;
          }
          break;
        }
      }
    }
  }
  
  public static final flj cA(Map<String, String> paramMap)
  {
    AppMethodBeat.i(248650);
    kotlin.g.b.s.u(paramMap, "values");
    Object localObject = (String)paramMap.get(".sysmsg.BizRecommendExpt.Title");
    int i = Util.getInt((String)paramMap.get(".sysmsg.BizRecommendExpt.Pos"), -1);
    int j = Util.getInt((String)paramMap.get(".sysmsg.BizRecommendExpt.Weight"), -1);
    long l = Util.getLong((String)paramMap.get(".sysmsg.BizRecommendExpt.RecID"), 0L);
    int k = Util.getInt((String)paramMap.get(".sysmsg.BizRecommendExpt.RedDotFlag"), -1);
    String str2 = (String)paramMap.get(".sysmsg.BizRecommendExpt.BusinessId");
    String str3 = (String)paramMap.get(".sysmsg.BizRecommendExpt.CardID");
    String str4 = (String)paramMap.get(".sysmsg.BizRecommendExpt.Data");
    String str5 = (String)paramMap.get(".sysmsg.BizRecommendExpt.RecSummary");
    String str6 = (String)paramMap.get(".sysmsg.BizRecommendExpt.AppId");
    String str7 = (String)paramMap.get(".sysmsg.BizRecommendExpt.TemplatePathType");
    int m = Util.getInt((String)paramMap.get(".sysmsg.BizRecommendExpt.UseServerTime"), 0);
    String str1 = (String)paramMap.get(".sysmsg.BizRecommendExpt.ExtraData");
    int n = Util.getInt((String)paramMap.get(".sysmsg.BizRecommendExpt.PackageVersion"), 0);
    if ((i < 0) && (j < 0))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] getFromCanvasXml pos = " + i + ", weight = " + j);
      AppMethodBeat.o(248650);
      return null;
    }
    paramMap = new flj();
    paramMap.pos = i;
    paramMap.weight = j;
    paramMap.abry = l;
    enc localenc = new enc();
    localenc.title = ((String)localObject);
    localenc.pos = i;
    localenc.weight = j;
    localenc.abry = l;
    localenc.ablO = n;
    localenc.businessId = str2;
    localenc.cardId = str3;
    localenc.data = str4;
    localenc.Zxp = str5;
    localenc.appId = str6;
    localenc.abrA = str7;
    localObject = kotlin.ah.aiuX;
    paramMap.abLO = localenc;
    paramMap.style = 1001;
    paramMap.abLN = m;
    paramMap.hRR = str1;
    paramMap.abrz = k;
    AppMethodBeat.o(248650);
    return paramMap;
  }
  
  public static final boolean cA(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(248619);
    int i = ((c)com.tencent.mm.kernel.h.ax(c.class)).dbG();
    if (i >= paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      if ((paramBoolean) || (!bool)) {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isPkgVersionValid bizPkgVersion=" + i + ", packageVersion=" + paramInt + " valid=" + bool);
      }
      AppMethodBeat.o(248619);
      return bool;
    }
  }
  
  public static final void cB(Map<String, String> paramMap)
  {
    AppMethodBeat.i(248675);
    kotlin.g.b.s.u(paramMap, "values");
    Object localObject = com.tencent.mm.an.af.bHl().iYx();
    if (localObject == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard lastTimeLineInfo is null");
      AppMethodBeat.o(248675);
      return;
    }
    flj localflj = cA(paramMap);
    if (localflj == null)
    {
      AppMethodBeat.o(248675);
      return;
    }
    MultiProcessMMKV.getSingleMMKV("brandService");
    if (localflj.abrz != 2)
    {
      if (((ab)localObject).field_status == 4)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard lastTimeLineInfo is exposed");
        AppMethodBeat.o(248675);
        return;
      }
      ad.bvD("");
    }
    if (!c(localflj, null))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard illegal");
      AppMethodBeat.o(248675);
      return;
    }
    if (!cA(localflj.abLO.ablO, true))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard pkg version invalid");
      AppMethodBeat.o(248675);
      return;
    }
    if (e(localflj))
    {
      AppMethodBeat.o(248675);
      return;
    }
    long l3 = com.tencent.mm.an.af.bHl().iYD();
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1149L, 1L, 1L, false);
    long l2 = com.tencent.mm.an.af.bHl().iYz();
    ab localab = new ab();
    localab.field_msgId = com.tencent.mm.an.af.bHl().iYH();
    localab.field_msgSvrId = 0L;
    localab.field_type = 620757041;
    localab.field_talker = "";
    localab.field_talkerId = 0;
    localab.field_createTime = (l2 - 1000L);
    localab.po(1);
    localab.field_status = 3;
    a(localab, localflj);
    localab.b(localflj);
    long l1 = 0L;
    if (localflj.abLO.weight >= 0) {
      l1 = kotlin.k.k.bS(localflj.abLO.weight, 255L);
    }
    boolean bool;
    label519:
    int i;
    int j;
    int k;
    for (;;)
    {
      if (localflj.abrz == 2) {
        if (l3 <= 10L)
        {
          AppMethodBeat.o(248675);
          return;
          if (localflj.abLO.pos == 0)
          {
            l1 = ad.yU(((ab)localObject).field_orderFlag);
            localab.field_createTime = (l2 + 1000L);
          }
          else
          {
            paramMap = com.tencent.mm.an.af.bHl().ayB(localflj.abLO.pos - 1);
            if (paramMap == null)
            {
              Log.w("MicroMsg.BizTimeLineStorageLogicExKt", "postInsertCanvasCard lastTimeLineInfo is null");
            }
            else
            {
              l1 = ad.yU(paramMap.field_orderFlag);
              paramMap.field_createTime -= 1000L;
            }
          }
        }
        else
        {
          l2 = ad.bI(l3, localab.field_createTime / 1000L);
          l3 = -1L + l3;
          localab.field_hasShow = 1;
          localab.field_status = 4;
          localab.nH(2);
          localab.field_orderFlag = (l2 | l3 << 32 | l1 << 24 & 0xFF000000);
          ad.H(localab);
          paramMap = com.tencent.mm.an.af.bHl();
          if (localflj.abrz == 2) {
            break label782;
          }
          bool = true;
          bool = paramMap.c(localab, bool);
          Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard result = " + bool + ", redDotFlag = " + localflj.abrz + ", orderFlag = " + localab.field_orderFlag + " pos = " + localflj.abLO.pos + " weight=" + localflj.abLO.weight + ',' + localab.iYb() + " msgId=" + localab.field_msgId);
          if (bool)
          {
            paramMap = r.acDM;
            if (r.iXt()) {
              com.tencent.mm.plugin.webcanvas.k.WkZ.ioR();
            }
            r.acDM.B(localab);
            paramMap = j.WkY;
            j.xC(82L);
            paramMap = s.acEH;
            i = localflj.pos;
            j = localflj.abLN;
            k = localflj.style;
            l1 = localflj.abry;
            paramMap = localflj.abLO;
            if (paramMap != null) {
              break label788;
            }
            paramMap = null;
            label722:
            localObject = localflj.abLM;
            if (localObject != null) {
              break label796;
            }
          }
        }
      }
    }
    label782:
    label788:
    label796:
    for (localObject = null;; localObject = ((apx)localObject).YSJ)
    {
      s.a(localab, 2, i, j, k, l1, paramMap, (String)localObject, localflj.hRR);
      AppMethodBeat.o(248675);
      return;
      l2 = ad.bH(l3, localab.field_createTime / 1000L);
      break;
      bool = false;
      break label519;
      paramMap = paramMap.cardId;
      break label722;
    }
  }
  
  public static final boolean cz(Map<String, String> paramMap)
  {
    AppMethodBeat.i(248646);
    kotlin.g.b.s.u(paramMap, "values");
    if (!Util.isNullOrNil((String)paramMap.get(".sysmsg.BizRecommendExpt.Data")))
    {
      AppMethodBeat.o(248646);
      return true;
    }
    AppMethodBeat.o(248646);
    return false;
  }
  
  public static final boolean d(enp paramenp)
  {
    AppMethodBeat.i(248579);
    kotlin.g.b.s.u(paramenp, "<this>");
    if (paramenp.abrD == p.h.ojC.value)
    {
      AppMethodBeat.o(248579);
      return true;
    }
    AppMethodBeat.o(248579);
    return false;
  }
  
  public static final boolean e(enp paramenp)
  {
    AppMethodBeat.i(248586);
    kotlin.g.b.s.u(paramenp, "<this>");
    if (paramenp.abrD == p.h.ojF.value)
    {
      AppMethodBeat.o(248586);
      return true;
    }
    AppMethodBeat.o(248586);
    return false;
  }
  
  public static final boolean e(flj paramflj)
  {
    ac localac2 = null;
    ac localac1 = null;
    AppMethodBeat.i(248683);
    kotlin.g.b.s.u(paramflj, "<this>");
    switch (paramflj.style)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(248683);
      return false;
      localac2 = com.tencent.mm.an.af.bHl();
      paramflj = paramflj.abLM;
      if (paramflj == null) {}
      for (paramflj = localac1; localac2.bvB(paramflj) != null; paramflj = paramflj.YSF)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] duplicateCardId");
        AppMethodBeat.o(248683);
        return true;
      }
      localac1 = com.tencent.mm.an.af.bHl();
      paramflj = paramflj.abLO;
      if (paramflj == null) {}
      for (paramflj = localac2; localac1.bvB(paramflj) != null; paramflj = paramflj.cardId)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] canvas duplicateCardId");
        AppMethodBeat.o(248683);
        return true;
      }
    }
  }
  
  public static final boolean f(enp paramenp)
  {
    AppMethodBeat.i(248590);
    kotlin.g.b.s.u(paramenp, "<this>");
    if (paramenp.abrD == p.h.ojG.value)
    {
      AppMethodBeat.o(248590);
      return true;
    }
    AppMethodBeat.o(248590);
    return false;
  }
  
  public static final boolean iZd()
  {
    AppMethodBeat.i(248642);
    r localr = r.acDM;
    if (!r.iXo())
    {
      AppMethodBeat.o(248642);
      return false;
    }
    if ((!com.tencent.mm.kernel.h.baz()) || (!((c)com.tencent.mm.kernel.h.ax(c.class)).GY(1001)))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] onBizRecommendExpt style = %s not support", new Object[] { Integer.valueOf(1001) });
      AppMethodBeat.o(248642);
      return false;
    }
    AppMethodBeat.o(248642);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.storage.ah
 * JD-Core Version:    0.7.0.1
 */