package com.tencent.mm.storage;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.p.g;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.cmo;
import com.tencent.mm.protocal.protobuf.dle;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.protocal.protobuf.dug;
import com.tencent.mm.protocal.protobuf.dur;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqc;
import com.tencent.mm.protocal.protobuf.eqd;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"BIZTIMELINFO_CARDTYPE_AD", "", "BIZTIMELINFO_CARDTYPE_BIZ", "BIZTIMELINFO_CARDTYPE_RECCARD_CANVAS", "BIZTIMELINFO_CARDTYPE_RECFEED", "BIZTIMELINFO_CARDTYPE_RECFEED_TAG", "BIZTIMELINFO_CARDTYPE_RECOMMEND", "BIZTIMELINFO_CARDTYPE_STYL103", "BIZTIMELINFO_CARDTYPE_UNFOLLOW", "TAG", "", "fillBizMsgItem", "Ljava/util/LinkedList;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "getExtraFromXML", "", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "values", "", "getFromCanvasXml", "getRecCardAppMsgs", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "insertCanvasCardImmediately", "isCanvasCard", "", "isContact", "userName", "isStyleNeedCheckContact", "style", "isTLRecCardWrapperLegal", "isTLRecFeedLegal", "recFeed", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "onBizRecommendExpt", "content", "postInsertCanvasCard", "recCanvasSupport", "report21461", "redDotFlag", "insertRet", "testInsertCard", "duplicateCardId", "getCardType", "getMidAndIdx", "", "(Ljava/lang/String;)[Ljava/lang/String;", "isCanvas", "isShowBigPic", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "isShowContentBigPic", "isShowContentSmallPic", "isShowThreePic", "isUnderLineMsg", "parseExtraFromXML", "parseFromXML", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "setCardId", "plugin-biz_release"})
public final class af
{
  public static final LinkedList<pe> K(z paramz)
  {
    AppMethodBeat.i(206647);
    p.k(paramz, "info");
    LinkedList localLinkedList = new LinkedList();
    if ((!paramz.hwB()) || (paramz.hwL() == null))
    {
      AppMethodBeat.o(206647);
      return localLinkedList;
    }
    Object localObject = paramz.hwL();
    if ((((eqg)localObject).style == 3) || (((eqg)localObject).style == 5) || (((eqg)localObject).style == 0))
    {
      paramz = paramz.hwK();
      if (paramz != null)
      {
        paramz = paramz.RXM;
        if (paramz != null) {
          paramz = ((Iterable)paramz).iterator();
        }
      }
    }
    else
    {
      while (paramz.hasNext())
      {
        localObject = (eqc)paramz.next();
        pe localpe = new pe();
        localpe.RTk = ((eqc)localObject).RTk;
        localpe.fwr = ((eqc)localObject).fwr;
        localLinkedList.add(localpe);
        continue;
        if ((((eqg)localObject).style == 101) || (((eqg)localObject).style == 102) || (((eqg)localObject).style == 103))
        {
          paramz = paramz.hwL();
          if (paramz != null)
          {
            paramz = paramz.UsF;
            if (paramz != null)
            {
              paramz = paramz.RVd;
              if (paramz != null)
              {
                paramz = ((Iterable)paramz).iterator();
                while (paramz.hasNext())
                {
                  localObject = (pf)paramz.next();
                  if (localObject != null)
                  {
                    localObject = ((pf)localObject).RXM;
                    if (localObject != null)
                    {
                      localObject = ((Iterable)localObject).iterator();
                      while (((Iterator)localObject).hasNext()) {
                        localLinkedList.add((pe)((Iterator)localObject).next());
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
    AppMethodBeat.o(206647);
    return localLinkedList;
  }
  
  public static final int L(z paramz)
  {
    int j = 1;
    AppMethodBeat.i(206661);
    p.k(paramz, "$this$getCardType");
    int i;
    if (paramz.hwA()) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(206661);
      return i;
      if (paramz.hwB())
      {
        paramz = paramz.hwL();
        i = j;
        if (paramz != null)
        {
          i = j;
          switch (paramz.style)
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
      else if (paramz.hwC())
      {
        i = 4;
      }
      else if (paramz.hwz())
      {
        paramz = paramz.Ven;
        if ((paramz != null) && (paramz.RVf == 2002)) {
          i = 10;
        } else {
          i = 9;
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private static boolean Ql(String paramString)
  {
    AppMethodBeat.i(206648);
    p.k(paramString, "userName");
    Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject).bbL().RG(paramString);
    if ((localObject != null) && (((as)localObject).axZ()))
    {
      AppMethodBeat.o(206648);
      return true;
    }
    if ((localObject == null) || (((as)localObject).ayq() <= 0)) {
      az.a.ber().a(paramString, "", null);
    }
    AppMethodBeat.o(206648);
    return false;
  }
  
  public static final LinkedList<String> a(z paramz, oq paramoq)
  {
    AppMethodBeat.i(206645);
    p.k(paramz, "info");
    p.k(paramoq, "item");
    LinkedList localLinkedList = new LinkedList();
    if ((!paramz.hwB()) || (paramz.hwL() == null))
    {
      AppMethodBeat.o(206645);
      return localLinkedList;
    }
    paramz = ((Iterable)K(paramz)).iterator();
    label140:
    while (paramz.hasNext())
    {
      pe localpe = (pe)paramz.next();
      paramoq.fmW.add(localpe.RTk);
      CharSequence localCharSequence = (CharSequence)localpe.RXK;
      if ((localCharSequence == null) || (kotlin.n.n.ba(localCharSequence))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label140;
        }
        paramoq.RWL.add(localpe.RXK);
        break;
      }
    }
    AppMethodBeat.o(206645);
    return localLinkedList;
  }
  
  public static final void a(eqg parameqg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206671);
    p.k(parameqg, "wrapper");
    switch (parameqg.style)
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(206671);
        return;
        localObject1 = parameqg.UsF;
      } while (localObject1 == null);
      localObject1 = ((amf)localObject1).RVd;
    } while (localObject1 == null);
    Object localObject2 = (Iterable)localObject1;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label154:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((pf)localObject3).RIs == 0) {}
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
      int j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      localObject2 = (pf)localObject2;
      localObject3 = (pe)((pf)localObject2).RXM.get(0);
      if (localObject3 != null)
      {
        if ((((pe)localObject3).RIs & 0x1) == 0)
        {
          Object localObject4 = ((pe)localObject3).RTk;
          p.j(localObject4, "it.ContentUrl");
          localObject4 = bvx((String)localObject4);
          com.tencent.mm.plugin.report.service.h.IzE.a(21461, new Object[] { ((pf)localObject2).UserName, localObject4[0], localObject4[1], Integer.valueOf(((pe)localObject3).lpx), parameqg.UsF.RVm, parameqg.UsF.RVi, Integer.valueOf(i), Long.valueOf(parameqg.Uaw), parameqg.UsF.SwG, Integer.valueOf(parameqg.style), ((pe)localObject3).RXK, Integer.valueOf(parameqg.weight), Integer.valueOf(paramInt1), Integer.valueOf(parameqg.UsG), Integer.valueOf(parameqg.pos), Integer.valueOf(paramInt2) });
        }
        i = j;
      }
      else
      {
        i = j;
      }
    }
    AppMethodBeat.o(206671);
  }
  
  public static final void a(eqg parameqg, Map<String, String> paramMap)
  {
    AppMethodBeat.i(206634);
    p.k(parameqg, "wrapper");
    p.k(paramMap, "values");
    b(parameqg, paramMap);
    AppMethodBeat.o(206634);
  }
  
  public static final void a(z paramz, eqg parameqg)
  {
    amf localamf = null;
    due localdue = null;
    AppMethodBeat.i(206668);
    p.k(paramz, "$this$setCardId");
    p.k(parameqg, "wrapper");
    paramz.field_recommendCardId = "";
    switch (parameqg.style)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(206668);
      return;
      localamf = parameqg.UsF;
      parameqg = localdue;
      if (localamf != null) {
        parameqg = localamf.RVi;
      }
      paramz.field_recommendCardId = parameqg;
      AppMethodBeat.o(206668);
      return;
      localdue = parameqg.UsH;
      parameqg = localamf;
      if (localdue != null) {
        parameqg = localdue.cardId;
      }
      paramz.field_recommendCardId = parameqg;
    }
  }
  
  public static final void a(LinkedList<pf> paramLinkedList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(206643);
    p.k(paramLinkedList, "$this$parseFromXML");
    p.k(paramMap, "values");
    int i = 0;
    while (i <= 9)
    {
      Object localObject2 = new StringBuilder(".sysmsg.BizAccountRecommend.BizAccount");
      pf localpf;
      label329:
      Object localObject3;
      if (i == 0)
      {
        localObject1 = "";
        localObject2 = localObject1;
        if (Util.isNullOrNil((String)paramMap.get((String)localObject2 + ".UserName"))) {
          break;
        }
        localpf = new pf();
        localpf.UserName = ((String)paramMap.get((String)localObject2 + ".UserName"));
        localpf.rWI = ((String)paramMap.get((String)localObject2 + ".NickName"));
        localpf.CPq = ((String)paramMap.get((String)localObject2 + ".RecommendReason"));
        localpf.mVB = ((String)paramMap.get((String)localObject2 + ".Signature"));
        localpf.RRW = ((String)paramMap.get((String)localObject2 + ".BrandIconUrl"));
        localpf.RXL = ((String)paramMap.get((String)localObject2 + ".AppMsgRecReason"));
        localpf.RXF = new LinkedList();
        j = 0;
        if (j > 20) {
          break label428;
        }
        localObject3 = new StringBuilder().append((String)localObject2).append(".NegativeFeedbackReason");
        if (j != 0) {
          break label419;
        }
      }
      label419:
      for (Object localObject1 = "";; localObject1 = Integer.valueOf(j))
      {
        localObject1 = (String)paramMap.get(localObject1);
        if (Util.isNullOrNil((String)localObject1)) {
          break label428;
        }
        localpf.RXF.add(localObject1);
        j += 1;
        break label329;
        localObject1 = Integer.valueOf(i);
        break;
      }
      label428:
      localpf.RXG = Util.getInt((String)paramMap.get((String)localObject2 + ".ShowNegativeFeedbackReason"), 1);
      localpf.RXM = new LinkedList();
      paramLinkedList.add(localpf);
      int j = 0;
      while (j <= 1)
      {
        localObject3 = new StringBuilder().append((String)localObject2).append(".AppMsg");
        pe localpe;
        int k;
        label1107:
        StringBuilder localStringBuilder;
        if (j == 0)
        {
          localObject1 = "";
          localObject3 = localObject1;
          if (Util.isNullOrNil((String)paramMap.get((String)localObject3 + ".Title"))) {
            break;
          }
          localpe = new pe();
          localpe.fwr = ((String)paramMap.get((String)localObject3 + ".Title"));
          localpe.RTi = ((String)paramMap.get((String)localObject3 + ".Digest"));
          localpe.RTk = ((String)paramMap.get((String)localObject3 + ".ContentUrl"));
          localpe.RTm = ((String)paramMap.get((String)localObject3 + ".CoverImgUrl"));
          localpe.RTn = ((String)paramMap.get((String)localObject3 + ".CoverImgUrl_1_1"));
          localpe.RTo = ((String)paramMap.get((String)localObject3 + ".CoverImgUrl_235_1"));
          localpe.lpx = Util.getInt((String)paramMap.get((String)localObject3 + ".ItemShowType"), -1);
          localpe.RTv = ((String)paramMap.get((String)localObject3 + ".VideoId"));
          localpe.RTw = Util.getInt((String)paramMap.get((String)localObject3 + ".VideoWidth"), -1);
          localpe.RTx = Util.getInt((String)paramMap.get((String)localObject3 + ".VideoHeight"), -1);
          localpe.RTy = Util.getInt((String)paramMap.get((String)localObject3 + ".VideoDuration"), -1);
          localpe.CreateTime = Util.getInt((String)paramMap.get((String)localObject3 + ".CreateTime"), -1);
          localpe.RXH = ((String)paramMap.get((String)localObject3 + ".VoicePlayUrl"));
          localpe.RXI = Util.getInt((String)paramMap.get((String)localObject3 + ".VoiceDuration"), -1);
          localpe.RXF = new LinkedList();
          k = 0;
          if (k > 20) {
            break label1211;
          }
          localStringBuilder = new StringBuilder().append((String)localObject3).append(".NegativeFeedbackReason");
          if (k != 0) {
            break label1201;
          }
        }
        label1201:
        for (localObject1 = "";; localObject1 = Integer.valueOf(k))
        {
          localObject1 = (String)paramMap.get(localObject1);
          if (Util.isNullOrNil((String)localObject1)) {
            break label1211;
          }
          localpe.RXF.add(localObject1);
          k += 1;
          break label1107;
          localObject1 = Integer.valueOf(j);
          break;
        }
        label1211:
        localpe.RXG = Util.getInt((String)paramMap.get((String)localObject3 + ".ShowNegativeFeedbackReason"), 1);
        localpe.RXJ = Util.getInt((String)paramMap.get((String)localObject3 + ".RecRk"), 0);
        localpe.RXK = ((String)paramMap.get((String)localObject3 + ".RecInfo"));
        localpf.RXM.add(localpe);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(206643);
  }
  
  public static final boolean a(dug paramdug)
  {
    AppMethodBeat.i(206651);
    p.k(paramdug, "$this$isShowBigPic");
    Object localObject = paramdug.UaA.get(0);
    p.j(localObject, "this.RecommendItem[0]");
    if (!d((dur)localObject))
    {
      paramdug = paramdug.UaA.get(0);
      p.j(paramdug, "this.RecommendItem[0]");
      if (!e((dur)paramdug)) {}
    }
    else
    {
      AppMethodBeat.o(206651);
      return true;
    }
    AppMethodBeat.o(206651);
    return false;
  }
  
  public static final boolean asy(int paramInt)
  {
    return (paramInt != 103) && (paramInt != 102) && (paramInt != 1001);
  }
  
  public static final void asz(int paramInt)
  {
    AppMethodBeat.i(206677);
    Object localObject2 = "card_id_" + System.currentTimeMillis();
    if (paramInt == 1001)
    {
      localObject1 = "中国国家地理" + System.currentTimeMillis() % 10000L;
      localObject1 = "<sysmsg type=\"BizRecommendExpt\">\n<BizRecommendExpt>\n<Title><![CDATA[猜你喜欢]]></Title>\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>1591189349</RecID>\n<RedDotFlag>1</RedDotFlag>\n<BusinessId>0</BusinessId>\n<CardID><![CDATA[" + (String)localObject2 + "]]></CardID>\n<Data><![CDATA[{\"Title\":\"猜你喜欢\",\"BizAccount\":[{\"Flag\":0,\"UserName\":\"gh_f05ff0331d78\",\"NickName\":\"" + (String)localObject1 + "\",\"RecommendReason\":\"\",\"Signature\":\"《深度参考》是中国高端精英读物，是您了解最新、最有深度、最有价值的时事财经资讯窗口，欢迎关注！\",\"BrandIconUrl\":\"http://mmbiz.qpic.cn/mmbiz/3lXPl12icGVZjPnbiaWdLbMQoNpTK6ZicaTFUk5jLfciaRVoukmISPd5DC6YHy5No4a4uy6k3PnIMIH00XJOVw0ibRw/0?wx_fmt=png\",\"AppMsgRecReason\":\"近期更新\",\"AppMsg\":[{\"Flag\":0,\"Title\":\"气温超过50°的极热之地，你敢去吗？\",\"Digest\":\"我是摘要测试测试\",\"ContentUrl\":\"https://mp.weixin.qq.com/s/oKmmWfX9G3Yfbmp5aDeyTQ\",\"CoverImgUrl\":\"http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg\",\"CoverImgUrl_1_1\":\"https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg\",\"CoverImgUrl_235_1\":\"\",\"ItemShowType\":0,\"VideoId\":\"\",\"VideoWidth\":0,\"VideoHeight\":0,\"VideoDuration\":180,\"CreateTime\":1593296809,\"NegativeFeedbackReason\":[\"内容质量低\",\"不看此公众号\"],\"ShowNegativeFeedbackReason\":0,\"RecommendReason\":\"\",\"VoicePlayUrl\":\"\",\"VoiceDuration\":0,\"RecRk\":1,\"RecInfo\":\"something\",\"AppMsgId\":2698324179,\"ItemIdx\":1,\"AuthorAppUin\":1014597342,\"CanReward\":0,\"CanPaid\":0},{\"Flag\":0,\"Title\":\"深度雄文，西部高原屏障对中华民族战略安全的重大意义！\",\"Digest\":\"深度参考长按右边的二维码关注2013年4月在中国的阿克塞欣的斗拉特别里奥地地区中印两国爆发“帐蓬对峙”，20\",\"ContentUrl\":\"http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324092&idx=4&sn=015c49c8d05b56267366a2cce351c2ec&chksm=be5bbb08892c321e990026bce74c09ad13da8ec56896875358f4db0271222b09b146b95739b1#rd\",\"CoverImgUrl\":\"http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg\",\"CoverImgUrl_1_1\":\"https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg\",\"CoverImgUrl_235_1\":\"\",\"ItemShowType\":0,\"VideoId\":\"\",\"VideoWidth\":0,\"VideoHeight\":0,\"VideoDuration\":180,\"CreateTime\":1593211927,\"NegativeFeedbackReason\":[\"内容质量低\",\"不看此公众号\"],\"ShowNegativeFeedbackReason\":0,\"RecommendReason\":\"\",\"VoicePlayUrl\":\"\",\"VoiceDuration\":180,\"RecRk\":2,\"RecInfo\":\"great\",\"AppMsgId\":2698324092,\"ItemIdx\":4,\"AuthorAppUin\":1654122144,\"CanReward\":0,\"CanPaid\":0}],\"NegativeFeedbackReason\":[\"不看此公众号\",\"内容低质\",\"内容重复\",\"内容过时\",\"希望减少推荐\"],\"ShowNegativeFeedbackReason\":1,\"BizUin\":3007693851}],\"Pos\":1,\"Weight\":200,\"RecID\":10086,\"Style\":1001,\"Event\":\"hengqing\",\"RedDotFlag\":1,\"RecSummary\":\"深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！\",\"CardId\":\"cdd97abeab063a0e00cea86f805bb17c\",\"ExpType\":\"tools\"}]]></Data>\n<RecSummary><![CDATA[气温超过50°的极热之地，你敢去吗？]]></RecSummary>\n<AppId><![CDATA[wxf337cbaa27790d8e]]></AppId>\n<ExtraData><![CDATA[{\"type\":1,\"real_data\":\"{\\\"biz_info\\\":[{\\\"username\\\":\\\"gh_49f4cd2ce99b\\\",\\\"nickname\\\":\\\"皮皮浪老师\\\",\\\"appmsg_info\\\":[{\\\"url\\\":\\\"http:\\\\\\/\\\\\\/mp.weixin.qq.com\\\\\\/s?__biz=MzA4OTE5NzQ5MQ==&mid=2247483877&idx=1&sn=e693e539daef056fa051e66374e41b48&chksm=901fdf39a768562fe6aaaeed3dfc9909d781ea8c45862cc335ed527eafcdb51f4aca774f67c3#rd\\\",\\\"title\\\":\\\"皮皮浪的复盘讲解（二十二）——围空不要拆二\\\",\\\"rec_rk\\\":1,\\\"rec_info\\\":\\\"something\\\",\\\"item_show_type\\\":5}]}],\\\"style\\\":1001,\\\"event\\\":\\\"hengqing\\\",\\\"card_id\\\":\\\"33a95e9794780cc0f584220dbb9fcfe2\\\",\\\"exp_type\\\":\\\"tools\\\"}\"}]]></ExtraData>\n<TemplatePath><![CDATA[re.js]]></TemplatePath>\n<TemplatePathType><![CDATA[re]]></TemplatePathType>\n</BizRecommendExpt>\n</sysmsg>";
      paramInt = kotlin.n.n.a((CharSequence)localObject1, "<sysmsg", 0, false, 6);
      if (paramInt != -1)
      {
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(206677);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((String)localObject1).substring(paramInt);
        p.j(localObject2, "(this as java.lang.String).substring(startIndex)");
        localObject2 = XmlParser.parseXml((String)localObject2, "sysmsg", null);
        if (localObject2 == null)
        {
          Log.e("MicroMsg.BizTimeLineStorageLogicExKt", "XmlParser values is null, msgContent %s", new Object[] { localObject1 });
          AppMethodBeat.o(206677);
        }
      }
      else
      {
        AppMethodBeat.o(206677);
        return;
      }
      localObject1 = cc((Map)localObject2);
      if (localObject1 == null) {
        p.iCn();
      }
      f((eqg)localObject1);
      AppMethodBeat.o(206677);
      return;
    }
    Object localObject1 = "";
    if (paramInt == 1) {
      localObject1 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_f05ff0331d78]]></UserName>\n<NickName><![CDATA[深度参考]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[《深度参考》是中国高端精英读物，是您了解最新、最有深度、最有价值的时事财经资讯窗口，欢迎关注！]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/3lXPl12icGVZjPnbiaWdLbMQoNpTK6ZicaTFUk5jLfciaRVoukmISPd5DC6YHy5No4a4uy6k3PnIMIH00XJOVw0ibRw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324179&idx=1&sn=02fb8d7cbd9a4187266280edccc1c303&chksm=be5bbba7892c32b19e13202074ffb143c96ff4d1024939ce4c917cf740905e67444b11604b13#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1593296809</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n<AppMsg>\n<Title><![CDATA[深度雄文，西部高原屏障对中华民族战略安全的重大意义！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324092&idx=4&sn=015c49c8d05b56267366a2cce351c2ec&chksm=be5bbb08892c321e990026bce74c09ad13da8ec56896875358f4db0271222b09b146b95739b1#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1593211927</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>2</RecRk>\n<RecInfo><![CDATA[great]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>102</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></RecSummary>\n<CardId><![CDATA[" + (String)localObject2 + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n" + "<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
    }
    for (;;)
    {
      ab.aa((String)localObject1, null);
      AppMethodBeat.o(206677);
      return;
      if (paramInt == 2) {
        localObject1 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_028c33dfd807]]></UserName>\n<NickName><![CDATA[粤知一二]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[由广东综艺90后门面担当郭嘉峰主持，是一档有个性有深度，看了会上瘾的粤语脱口秀节目。每晚18：00准时更新。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/Y7rtYuVxk9TNiaA7iciav0aI5ZNxxxVybPXOoxocjzdu2REcv0bck59HFZ9jJTmHB6spYXlqibCfUia8E9997dLaoHw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDU3Njk4MA==&mid=2247506230&idx=2&sn=80d0ead06f7d4446e42a89d57ee81699&chksm=ebb4cf8ddcc3469b4d62d4324bcec575812c28fea3d68af6e838f0a9a5bb79a8db7320fc7e70#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[https://vpic.video.qq.com/36675860/i0787zrbitj.png]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>5</ItemShowType>\n<VideoId><![CDATA[i0787zrbitj]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>245</VideoDuration>\n<CreateTime>1592751453</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n<AppMsg>\n<Title><![CDATA[教你一套坐公交车自救秘籍，你想要吗？]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDU3Njk4MA==&mid=2247494577&idx=1&sn=b0e489f3f5517b7942526aab7710052c&chksm=ebb4fd0adcc3741cc503f47ca2e1193af82db286d2baa438bb8d6209de9e192d8aaac5281d2a#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/Y7rtYuVxk9QHKGicgHASZibRp09iaGwSnnAN4cHzBvfupOIsibv78UfUGAJtcH1wT7wmAOicHib1k8a2FErDx7DFMNpg/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>5</ItemShowType>\n<VideoId><![CDATA[wxv_543960396546260993]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>314</VideoDuration>\n<CreateTime>1542015514</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>2</RecRk>\n<RecInfo><![CDATA[great]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>102</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></RecSummary>\n<CardId><![CDATA[" + (String)localObject2 + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n" + "<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
      } else if (paramInt == 3) {
        localObject1 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_028c33dfd807]]></UserName>\n<NickName><![CDATA[粤知一二]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[由广东综艺90后门面担当郭嘉峰主持，是一档有个性有深度，看了会上瘾的粤语脱口秀节目。每晚18：00准时更新。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/Y7rtYuVxk9TNiaA7iciav0aI5ZNxxxVybPXOoxocjzdu2REcv0bck59HFZ9jJTmHB6spYXlqibCfUia8E9997dLaoHw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDU3Njk4MA==&mid=2247506230&idx=2&sn=80d0ead06f7d4446e42a89d57ee81699&chksm=ebb4cf8ddcc3469b4d62d4324bcec575812c28fea3d68af6e838f0a9a5bb79a8db7320fc7e70#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[https://vpic.video.qq.com/36675860/i0787zrbitj.png]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>5</ItemShowType>\n<VideoId><![CDATA[i0787zrbitj]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>245</VideoDuration>\n<CreateTime>1592751453</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>102</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></RecSummary>\n<CardId><![CDATA[" + (String)localObject2 + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n" + "<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
      } else if (paramInt == 4) {
        localObject1 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_f05ff0331d78]]></UserName>\n<NickName><![CDATA[深度参考]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[《深度参考》是中国高端精英读物，是您了解最新、最有深度、最有价值的时事财经资讯窗口，欢迎关注！]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/3lXPl12icGVZjPnbiaWdLbMQoNpTK6ZicaTFUk5jLfciaRVoukmISPd5DC6YHy5No4a4uy6k3PnIMIH00XJOVw0ibRw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324179&idx=1&sn=02fb8d7cbd9a4187266280edccc1c303&chksm=be5bbba7892c32b19e13202074ffb143c96ff4d1024939ce4c917cf740905e67444b11604b13#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1593296809</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>101</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></RecSummary>\n<CardId><![CDATA[" + (String)localObject2 + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n" + "<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
      } else if (paramInt == 5) {
        localObject1 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[推荐公众号]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_240fbf8b33e4]]></UserName>\n<NickName><![CDATA[36氪]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[36氪是中国领先的新商业媒体，提供新锐深度的商业报道。我们强调趋势与价值，我们的slogan是：让一部分人先看到未来。]]></RecommendReason>\n<Signature><![CDATA[36氪是中国领先的新商业媒体，提供新锐深度的商业报道。我们强调趋势与价值，我们的slogan是：让一部分人先看到未来。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/QicyPhNHD5vYf0JyXiavcUmicQ7icOk55ygRlyOhCa9r132trMAiaYtqL0QzacfMLPolhsiaXGibWC0JskibLic02W6Mw1g/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[8点1氪：微信回应或遭苹果下架；格力口罩昨日开售：KN95每只5.5元；美股史上第二次触发熔断]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI2NDk5NzA0Mw==&mid=2247569208&idx=1&sn=27b7704f80c8271dcad2e52ee63cdf01&chksm=eaa79ee4ddd017f21d63e7a780c1941812f847bf968b40b2d81329b4e9f5a4f70f4e6e814c79#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/QicyPhNHD5vbhqC2kPdlU3tQrCiakmhHStEcNCOLwrocic2Vvr0J3qPNiaKYEn2vYIsQbGFBYM5PSAF9NecOalcnFw/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/QicyPhNHD5vbhqC2kPdlU3tQrCiakmhHStkWNVPziaEt1aEVBPnYyrzlpAbEXicqQ8zRmNgDBfupiccdibuBpeCHpKeQ/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1583799540</CreateTime>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[对A1不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对A2不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对此公众号不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<BizAccount>\n<UserName><![CDATA[gh_363b924965e9]]></UserName>\n<NickName><![CDATA[人民日报]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[参与、沟通、记录时代。]]></RecommendReason>\n<Signature><![CDATA[参与、沟通、记录时代。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/xrFYciaHL08CtD0lEHt59N8SQicW1gI0WjYKCEpzgRCPFBlJGI1rIfRl4bFSTLoFnI4iaylWmJVqd8semEK1OGylg/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[发请柬啦！我们邀请所有人，共同见证一场盛大的婚礼！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&mid=2666316160&idx=1&sn=54684fd350167a7f3bed5bde5ce9dc64&chksm=bdb4a8c38ac321d5852e261a2e31f038fd0e98ec66bee2920d88ee4cdf11979bdede1e0c908e#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/xrFYciaHL08AD1ynAav39zdY1WvI5bbsyACCQygrAQqFY1EZiaRwHJYMD7v2x2LLBp0YsHwku3In19N5D3aYZx9A/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/xrFYciaHL08AD1ynAav39zdY1WvI5bbsy1kWLuqdNxNVFWIUWBC0DTgnyAkt5cAicI2DyfkVZ14Bx5oemgWmiaphg/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1589804841</CreateTime>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[对D不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对此公众号不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>1589808970</RecID>\n<Style>103</Style>\n<Event></Event>\n<RecSummary><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></RecSummary>\n<CardId><![CDATA[" + (String)localObject2 + "]]></CardId>\n<AggregationUrl><![CDATA[http://wwww.baidu.com]]></AggregationUrl>\n<AggregationTitle><![CDATA[大家都在看的大事件 >]]></AggregationTitle>\n<NegativeFeedbackReason><![CDATA[对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对A2不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n" + "\n<NegativeFeedbackReason><![CDATA[对此公众号不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
      }
    }
  }
  
  private static void b(eqg parameqg, Map<String, String> paramMap)
  {
    AppMethodBeat.i(206638);
    p.k(parameqg, "$this$parseExtraFromXML");
    p.k(paramMap, "values");
    Object localObject = (a)new af.a(parameqg, paramMap);
    switch (parameqg.style)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(206638);
      return;
      ((a)localObject).invoke();
      AppMethodBeat.o(206638);
      return;
      ((a)localObject).invoke();
      amf localamf = parameqg.UsF;
      int i = 0;
      if (i <= 20)
      {
        localObject = new StringBuilder(".sysmsg.BizAccountRecommend.NegativeFeedbackReason");
        if (i == 0) {}
        for (parameqg = "";; parameqg = Integer.valueOf(i))
        {
          parameqg = (String)paramMap.get(parameqg);
          if (Util.isNullOrNil(parameqg)) {
            break label174;
          }
          localamf.RXF.add(parameqg);
          i += 1;
          break;
        }
      }
      label174:
      localamf.RXG = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.ShowNegativeFeedbackReason"), 0);
      localObject = (String)paramMap.get(".sysmsg.BizAccountRecommend.AggregationUrl");
      parameqg = (eqg)localObject;
      if (localObject == null) {
        parameqg = "";
      }
      localamf.SwH = parameqg;
      paramMap = (String)paramMap.get(".sysmsg.BizAccountRecommend.AggregationTitle");
      parameqg = paramMap;
      if (paramMap == null) {
        parameqg = "";
      }
      localamf.SwI = parameqg;
    }
  }
  
  public static final boolean b(dug paramdug)
  {
    AppMethodBeat.i(206650);
    p.k(paramdug, "$this$isCanvas");
    if (paramdug.RVf == 2003)
    {
      AppMethodBeat.o(206650);
      return true;
    }
    AppMethodBeat.o(206650);
    return false;
  }
  
  public static final boolean b(dur paramdur)
  {
    AppMethodBeat.i(206654);
    p.k(paramdur, "$this$isShowThreePic");
    if (paramdur.UaB == p.g.lsd.value)
    {
      AppMethodBeat.o(206654);
      return true;
    }
    AppMethodBeat.o(206654);
    return false;
  }
  
  public static final boolean b(eqg parameqg, z paramz)
  {
    AppMethodBeat.i(206659);
    p.k(parameqg, "wrapper");
    int j = parameqg.style;
    if (j == 1001)
    {
      if (parameqg.UsH == null)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal exptInfo = null");
        AppMethodBeat.o(206659);
        return false;
      }
      if (Util.isNullOrNil(parameqg.UsH.data))
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal exptInfo.data = null");
        AppMethodBeat.o(206659);
        return false;
      }
      if ((Util.isNullOrNil(parameqg.UsH.appId)) || (Util.isNullOrNil(parameqg.UsH.Uay)))
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal appid or path error, appId = " + parameqg.UsH.appId + ", path = " + parameqg.UsH.Uay);
        AppMethodBeat.o(206659);
        return false;
      }
      AppMethodBeat.o(206659);
      return true;
    }
    Object localObject = parameqg.UsD;
    if (localObject == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal recCard null");
      AppMethodBeat.o(206659);
      return false;
    }
    if (((eqb)localObject).SwE == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal CardTitle null");
      AppMethodBeat.o(206659);
      return false;
    }
    if (((eqb)localObject).RXL == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal AppMsgRecReason null");
      AppMethodBeat.o(206659);
      return false;
    }
    eqd localeqd = ((eqb)localObject).Usy;
    if (localeqd == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo null");
      AppMethodBeat.o(206659);
      return false;
    }
    if (localeqd.UserName == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo UserName null");
      AppMethodBeat.o(206659);
      return false;
    }
    if (localeqd.rWI == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo NickName null");
      AppMethodBeat.o(206659);
      return false;
    }
    if (localeqd.UsA == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo RecReason null");
      AppMethodBeat.o(206659);
      return false;
    }
    if (Util.isNullOrNil((List)((eqb)localObject).RXM))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] AppMsg null");
      AppMethodBeat.o(206659);
      return false;
    }
    if ((j == 5) && (((eqb)localObject).RXM.size() < 2))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] AppMsg video size < 2");
      AppMethodBeat.o(206659);
      return false;
    }
    int k;
    if ((j == 101) || (j == 102) || (j == 103))
    {
      if ((parameqg.UsF == null) || (Util.isNullOrNil((List)parameqg.UsF.RVd)) || (parameqg.UsF.RVd.size() >= 3))
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " BizInfo size >= 3");
        AppMethodBeat.o(206659);
        return false;
      }
      if (parameqg.UsF.RIs == 1)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " extraInfo flag = 1");
        if (paramz != null) {
          com.tencent.mm.ao.af.bjB().UI(paramz.field_msgId);
        }
        AppMethodBeat.o(206659);
        return false;
      }
      localObject = parameqg.UsF.RVd;
      p.j(localObject, "wrapper.extraInfo.BizInfo");
      k = ((Collection)localObject).size();
      i = 0;
      if (i >= k) {
        break label1169;
      }
      if (((pf)parameqg.UsF.RVd.get(i)).RIs == 1) {}
    }
    label1156:
    label1164:
    label1169:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " bizLegal illegal");
        if (paramz != null) {
          com.tencent.mm.ao.af.bjB().UI(paramz.field_msgId);
        }
        AppMethodBeat.o(206659);
        return false;
        i += 1;
        break;
      }
      if (asy(j))
      {
        localObject = parameqg.UsF.RVd;
        p.j(localObject, "wrapper.extraInfo.BizInfo");
        k = ((Collection)localObject).size();
        i = 0;
        if (i >= k) {
          break label1164;
        }
        localObject = ((pf)parameqg.UsF.RVd.get(i)).UserName;
        p.j(localObject, "wrapper.extraInfo.BizInfo[i].UserName");
        if (Ql((String)localObject)) {}
      }
      for (i = 0;; i = 1)
      {
        if (i != 0)
        {
          Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " bizLegal contact");
          if (paramz != null) {
            com.tencent.mm.ao.af.bjB().UI(paramz.field_msgId);
          }
          AppMethodBeat.o(206659);
          return false;
          i += 1;
          break;
        }
        paramz = parameqg.UsF.RVd;
        p.j(paramz, "wrapper.extraInfo.BizInfo");
        k = ((Collection)paramz).size();
        i = 0;
        if (i < k)
        {
          if (Util.isNullOrNil((List)((pf)parameqg.UsF.RVd.get(i)).RXM))
          {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " AppMsg null");
            AppMethodBeat.o(206659);
            return false;
          }
          if (((pe)((pf)parameqg.UsF.RVd.get(i)).RXM.get(0)).RIs != 1) {}
        }
        for (i = 0;; i = 1)
        {
          if (i == 0)
          {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " AppMsg illegal");
            AppMethodBeat.o(206659);
            return false;
            i += 1;
            break;
          }
          parameqg = ((pf)parameqg.UsF.RVd.get(0)).RXM;
          p.j(parameqg, "wrapper.extraInfo.BizInfo[0].AppMsg");
          parameqg = ((Iterable)parameqg).iterator();
          i = 1;
          if (parameqg.hasNext())
          {
            paramz = (pe)parameqg.next();
            if ((paramz.lpx != 8) && (paramz.lpx != 7) && (paramz.lpx != 6) && (paramz.lpx != 10)) {
              break label1156;
            }
            i = 0;
          }
          for (;;)
          {
            break;
            if (i == 0)
            {
              Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " showTypeLegal illegal");
              AppMethodBeat.o(206659);
              return false;
            }
            AppMethodBeat.o(206659);
            return true;
          }
        }
      }
    }
  }
  
  public static final String[] bvx(String paramString)
  {
    AppMethodBeat.i(206672);
    p.k(paramString, "$this$getMidAndIdx");
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
      label82:
      break label82;
    }
    AppMethodBeat.o(206672);
    return arrayOfString;
  }
  
  public static final boolean c(dug paramdug)
  {
    AppMethodBeat.i(206657);
    p.k(paramdug, "recFeed");
    Object localObject = (Collection)paramdug.UaA;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] RecommendItem is illegal");
      AppMethodBeat.o(206657);
      return false;
    }
    if (paramdug.RVf == 2002)
    {
      localObject = (CharSequence)paramdug.SwI;
      if ((localObject == null) || (kotlin.n.n.ba((CharSequence)localObject))) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] AggregationTitle is illegal");
        AppMethodBeat.o(206657);
        return false;
      }
      localObject = (CharSequence)paramdug.SwH;
      if ((localObject == null) || (kotlin.n.n.ba((CharSequence)localObject))) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] AggregationUrl is illegal");
        AppMethodBeat.o(206657);
        return false;
      }
      localObject = (CharSequence)paramdug.UaC;
      if ((localObject == null) || (kotlin.n.n.ba((CharSequence)localObject))) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] RecommendWording is illegal");
        AppMethodBeat.o(206657);
        return false;
      }
    }
    paramdug = paramdug.UaA;
    p.j(paramdug, "recFeed.RecommendItem");
    localObject = ((Iterable)paramdug).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dur localdur = (dur)((Iterator)localObject).next();
      paramdug = localdur.UaX;
      if (paramdug != null)
      {
        paramdug = paramdug.fwr;
        paramdug = (CharSequence)paramdug;
        if ((paramdug != null) && (!kotlin.n.n.ba(paramdug))) {
          break label312;
        }
      }
      label312:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label317;
        }
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] Title is illegal");
        AppMethodBeat.o(206657);
        return false;
        paramdug = null;
        break;
      }
      label317:
      paramdug = localdur.UaX;
      if (paramdug != null)
      {
        paramdug = paramdug.RTk;
        paramdug = (CharSequence)paramdug;
        if ((paramdug != null) && (!kotlin.n.n.ba(paramdug))) {
          break label375;
        }
      }
      label375:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label380;
        }
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] ContentUrl is illegal");
        AppMethodBeat.o(206657);
        return false;
        paramdug = null;
        break;
      }
      label380:
      paramdug = localdur.UaX;
      if (paramdug != null) {}
      for (i = paramdug.lpx; (i != 5) && (i != 8) && (i != 10) && (i != 0); i = -1)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] ItemShowType is illegal, itemShowType=" + i + '.');
        AppMethodBeat.o(206657);
        return false;
      }
      p.j(localdur, "recommendItem");
      if (b(localdur))
      {
        paramdug = localdur.UaX;
        if (paramdug != null)
        {
          paramdug = paramdug.Tuc;
          if (paramdug == null) {}
        }
        for (paramdug = paramdug.TSl; (paramdug == null) || (localdur.UaX.Tuc.TSl.size() < 3); paramdug = null)
        {
          Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] showThreePic PictureInfo is illegal, itemShowType=" + i + '.');
          AppMethodBeat.o(206657);
          return false;
        }
      }
      paramdug = localdur.UaW;
      if (paramdug != null)
      {
        paramdug = paramdug.rWI;
        paramdug = (CharSequence)paramdug;
        if ((paramdug != null) && (!kotlin.n.n.ba(paramdug))) {
          break label613;
        }
      }
      label613:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label618;
        }
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] NickName is illegal");
        AppMethodBeat.o(206657);
        return false;
        paramdug = null;
        break;
      }
      label618:
      paramdug = localdur.UaW;
      if (paramdug != null)
      {
        paramdug = paramdug.UserName;
        paramdug = (CharSequence)paramdug;
        if ((paramdug != null) && (!kotlin.n.n.ba(paramdug))) {
          break label676;
        }
      }
      label676:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label681;
        }
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] NickName is illegal");
        AppMethodBeat.o(206657);
        return false;
        paramdug = null;
        break;
      }
      label681:
      paramdug = localdur.UaX;
      if ((paramdug != null) && (5 == paramdug.lpx))
      {
        paramdug = localdur.UaX;
        if (paramdug != null) {}
        for (paramdug = paramdug.Tua; paramdug == null; paramdug = null)
        {
          Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] VideoInfo is illegal");
          AppMethodBeat.o(206657);
          return false;
        }
      }
      paramdug = localdur.UaX;
      if ((paramdug != null) && (7 == paramdug.lpx))
      {
        paramdug = localdur.UaX;
        if (paramdug != null) {}
        for (paramdug = paramdug.Tub; paramdug == null; paramdug = null)
        {
          Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] VoiceInfo is illegal");
          AppMethodBeat.o(206657);
          return false;
        }
      }
    }
    AppMethodBeat.o(206657);
    return true;
  }
  
  public static final boolean cb(Map<String, String> paramMap)
  {
    AppMethodBeat.i(206663);
    p.k(paramMap, "values");
    if (!Util.isNullOrNil((String)paramMap.get(".sysmsg.BizRecommendExpt.Data")))
    {
      AppMethodBeat.o(206663);
      return true;
    }
    AppMethodBeat.o(206663);
    return false;
  }
  
  public static final eqg cc(Map<String, String> paramMap)
  {
    AppMethodBeat.i(206664);
    p.k(paramMap, "values");
    String str1 = (String)paramMap.get(".sysmsg.BizRecommendExpt.Title");
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
    paramMap = (String)paramMap.get(".sysmsg.BizRecommendExpt.ExtraData");
    if ((i < 0) && (j < 0))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] getFromCanvasXml pos = " + i + ", weight = " + j);
      AppMethodBeat.o(206664);
      return null;
    }
    eqg localeqg = new eqg();
    localeqg.pos = i;
    localeqg.weight = j;
    localeqg.Uaw = l;
    due localdue = new due();
    localdue.title = str1;
    localdue.pos = i;
    localdue.weight = j;
    localdue.Uaw = l;
    localdue.businessId = str2;
    localdue.cardId = str3;
    localdue.data = str4;
    localdue.SwG = str5;
    localdue.appId = str6;
    localdue.Uay = str7;
    localeqg.UsH = localdue;
    localeqg.style = 1001;
    localeqg.UsG = m;
    localeqg.fMh = paramMap;
    localeqg.Uax = k;
    AppMethodBeat.o(206664);
    return localeqg;
  }
  
  public static final void cd(Map<String, String> paramMap)
  {
    AppMethodBeat.i(206667);
    p.k(paramMap, "values");
    Object localObject1 = com.tencent.mm.ao.af.bjB();
    p.j(localObject1, "SubCoreBiz.getBizTimeLineInfoStorage()");
    localObject1 = ((aa)localObject1).hwU();
    if (localObject1 == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard lastTimeLineInfo is null");
      AppMethodBeat.o(206667);
      return;
    }
    eqg localeqg = cc(paramMap);
    if (localeqg == null)
    {
      AppMethodBeat.o(206667);
      return;
    }
    paramMap = MultiProcessMMKV.getSingleMMKV("brandService");
    if (localeqg.Uax != 2)
    {
      if (((z)localObject1).field_status == 4)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard lastTimeLineInfo is exposed");
        AppMethodBeat.o(206667);
        return;
      }
      localObject2 = new StringBuilder("BizLatestRecommendCardInfo");
      p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
      paramMap.encode(b.aGq(), "");
    }
    if (!e(localeqg))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard illegal");
      AppMethodBeat.o(206667);
      return;
    }
    if (g(localeqg))
    {
      AppMethodBeat.o(206667);
      return;
    }
    paramMap = com.tencent.mm.ao.af.bjB();
    p.j(paramMap, "SubCoreBiz.getBizTimeLineInfoStorage()");
    long l3 = paramMap.hxb();
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1149L, 1L, 1L, false);
    paramMap = com.tencent.mm.ao.af.bjB();
    p.j(paramMap, "SubCoreBiz.getBizTimeLineInfoStorage()");
    long l2 = paramMap.hwW();
    Object localObject2 = new z();
    ((z)localObject2).field_msgId = com.tencent.mm.ao.af.bjB().hxf();
    ((z)localObject2).field_msgSvrId = 0L;
    ((z)localObject2).field_type = 620757041;
    ((z)localObject2).field_talker = "";
    ((z)localObject2).field_talkerId = 0;
    ((z)localObject2).field_createTime = (l2 - 1000L);
    ((z)localObject2).pp(1);
    ((z)localObject2).field_status = 3;
    a((z)localObject2, localeqg);
    ((z)localObject2).c(localeqg);
    long l1 = 0L;
    if (localeqg.UsH.weight >= 0) {
      l1 = i.bf(localeqg.UsH.weight, 255L);
    }
    boolean bool;
    label556:
    int i;
    int j;
    int k;
    for (;;)
    {
      if (localeqg.Uax == 2) {
        if (l3 <= 10L)
        {
          AppMethodBeat.o(206667);
          return;
          if (localeqg.UsH.pos == 0)
          {
            l1 = ab.UL(((z)localObject1).field_orderFlag);
            ((z)localObject2).field_createTime = (l2 + 1000L);
          }
          else
          {
            paramMap = com.tencent.mm.ao.af.bjB().asp(localeqg.UsH.pos - 1);
            if (paramMap == null)
            {
              Log.w("MicroMsg.BizTimeLineStorageLogicExKt", "postInsertCanvasCard lastTimeLineInfo is null");
            }
            else
            {
              l1 = ab.UL(paramMap.field_orderFlag);
              ((z)localObject2).field_createTime = (paramMap.field_createTime - 1000L);
            }
          }
        }
        else
        {
          l2 = ab.aX(l3, ((z)localObject2).field_createTime / 1000L);
          l3 = -1L + l3;
          ((z)localObject2).field_hasShow = 1;
          ((z)localObject2).field_status = 4;
          ((z)localObject2).jR(2);
          ((z)localObject2).field_orderFlag = (l2 | l3 << 32 | l1 << 24 & 0xFF000000);
          ab.I((z)localObject2);
          paramMap = com.tencent.mm.ao.af.bjB();
          if (localeqg.Uax == 2) {
            break label766;
          }
          bool = true;
          bool = paramMap.c((z)localObject2, bool);
          Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard result = " + bool + ", redDotFlag = " + localeqg.Uax + ", orderFlag = " + ((z)localObject2).field_orderFlag);
          if (bool)
          {
            paramMap = r.VcW;
            if (r.hvT()) {
              m.PuL.gPA();
            }
            r.VcW.B((z)localObject2);
            paramMap = com.tencent.mm.plugin.webcanvas.l.PuB;
            com.tencent.mm.plugin.webcanvas.l.Tt(82L);
            paramMap = s.Vdo;
            i = localeqg.pos;
            j = localeqg.UsG;
            k = localeqg.style;
            l1 = localeqg.Uaw;
            paramMap = localeqg.UsH;
            if (paramMap == null) {
              break label772;
            }
            paramMap = paramMap.cardId;
            label702:
            localObject1 = localeqg.UsF;
            if (localObject1 == null) {
              break label777;
            }
          }
        }
      }
    }
    label772:
    label777:
    for (localObject1 = ((amf)localObject1).RVm;; localObject1 = null)
    {
      s.a((z)localObject2, 2, i, j, k, l1, paramMap, (String)localObject1, localeqg.fMh);
      AppMethodBeat.o(206667);
      return;
      l2 = ab.aW(l3, ((z)localObject2).field_createTime / 1000L);
      break;
      label766:
      bool = false;
      break label556;
      paramMap = null;
      break label702;
    }
  }
  
  public static final boolean d(dur paramdur)
  {
    AppMethodBeat.i(206652);
    p.k(paramdur, "$this$isShowBigPic");
    if (paramdur.UaB == p.g.lsb.value)
    {
      AppMethodBeat.o(206652);
      return true;
    }
    AppMethodBeat.o(206652);
    return false;
  }
  
  public static final boolean e(dur paramdur)
  {
    AppMethodBeat.i(206655);
    p.k(paramdur, "$this$isShowContentBigPic");
    if (paramdur.UaB == p.g.lse.value)
    {
      AppMethodBeat.o(206655);
      return true;
    }
    AppMethodBeat.o(206655);
    return false;
  }
  
  public static final z f(eqg parameqg)
  {
    AppMethodBeat.i(206665);
    p.k(parameqg, "wrapper");
    if (!b(parameqg, null))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately illegal");
      AppMethodBeat.o(206665);
      return null;
    }
    if (g(parameqg))
    {
      AppMethodBeat.o(206665);
      return null;
    }
    Object localObject1 = com.tencent.mm.ao.af.bjB();
    p.j(localObject1, "SubCoreBiz.getBizTimeLineInfoStorage()");
    localObject1 = ((aa)localObject1).hwU();
    long l1;
    z localz;
    long l2;
    label254:
    int i;
    int j;
    int k;
    if (parameqg.UsG == 1) {
      if (Math.abs(parameqg.Uaw * 1000L - bq.beS()) <= 86400000L)
      {
        l1 = parameqg.Uaw * 1000L;
        localz = new z();
        localz.field_msgId = com.tencent.mm.ao.af.bjB().hxf();
        localz.field_msgSvrId = 0L;
        localz.field_type = 620757041;
        localz.field_talker = "";
        localz.field_talkerId = 0;
        localz.field_createTime = l1;
        localz.pp(1);
        localz.field_status = 3;
        a(localz, parameqg);
        localz.c(parameqg);
        localObject2 = com.tencent.mm.ao.af.bjB();
        p.j(localObject2, "SubCoreBiz.getBizTimeLineInfoStorage()");
        long l3 = ((aa)localObject2).hwv();
        l2 = 0L;
        l1 = l2;
        if (localObject1 != null)
        {
          if (parameqg.UsH.weight < 0) {
            break label595;
          }
          l1 = Math.min(parameqg.UsH.weight, ab.UL(((z)localObject1).field_orderFlag));
        }
        long l4 = ab.aW(l3, localz.field_createTime / 1000L);
        l2 = l4;
        if (l4 >= 4294967296L)
        {
          Log.w("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately serialNumber is too big %d", new Object[] { Long.valueOf(l4) });
          l3 = com.tencent.mm.ao.af.bjB().hxc();
          l2 = ab.aW(l3, localz.field_createTime / 1000L);
        }
        localz.field_orderFlag = (l2 | l3 << 32 | 0xFF000000 & l1 << 24);
        ab.I(localz);
        boolean bool = com.tencent.mm.ao.af.bjB().F(localz);
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately result = " + bool + ", title = " + parameqg.UsH.title);
        if (bool)
        {
          localObject1 = r.VcW;
          if (r.hvT()) {
            m.PuL.gPA();
          }
          r.VcW.B(localz);
          localObject1 = ad.Vfe;
          if (ad.hxv())
          {
            localObject1 = ad.Vfe;
            ad.a(0, null, 0L);
          }
        }
        localObject1 = com.tencent.mm.plugin.webcanvas.l.PuB;
        com.tencent.mm.plugin.webcanvas.l.Tt(82L);
        localObject1 = s.Vdo;
        i = parameqg.pos;
        j = parameqg.UsG;
        k = parameqg.style;
        l1 = parameqg.Uaw;
        localObject1 = parameqg.UsH;
        if (localObject1 == null) {
          break label669;
        }
        localObject1 = ((due)localObject1).cardId;
        label514:
        localObject2 = parameqg.UsF;
        if (localObject2 == null) {
          break label675;
        }
      }
    }
    label669:
    label675:
    for (Object localObject2 = ((amf)localObject2).RVm;; localObject2 = null)
    {
      s.a(localz, 1, i, j, k, l1, (String)localObject1, (String)localObject2, parameqg.fMh);
      AppMethodBeat.o(206665);
      return localz;
      l1 = bq.beS();
      break;
      localObject2 = com.tencent.mm.ao.af.bjB();
      p.j(localObject2, "SubCoreBiz.getBizTimeLineInfoStorage()");
      l1 = ((aa)localObject2).hwW() + 1000L;
      break;
      label595:
      if (parameqg.UsH.pos == 0)
      {
        l1 = ab.UL(((z)localObject1).field_orderFlag);
        break label254;
      }
      localObject1 = com.tencent.mm.ao.af.bjB().asp(parameqg.UsH.pos - 1);
      if (localObject1 == null)
      {
        Log.w("MicroMsg.BizTimeLineStorageLogicExKt", "insertCanvasCardImmediately lastTimeLineInfo is null");
        l1 = l2;
        break label254;
      }
      l1 = ab.UL(((z)localObject1).field_orderFlag);
      break label254;
      localObject1 = null;
      break label514;
    }
  }
  
  public static final boolean f(dur paramdur)
  {
    AppMethodBeat.i(206656);
    p.k(paramdur, "$this$isShowContentSmallPic");
    if (paramdur.UaB == p.g.lsg.value)
    {
      AppMethodBeat.o(206656);
      return true;
    }
    AppMethodBeat.o(206656);
    return false;
  }
  
  public static final boolean g(eqg parameqg)
  {
    aa localaa2 = null;
    aa localaa1 = null;
    AppMethodBeat.i(206669);
    p.k(parameqg, "$this$duplicateCardId");
    switch (parameqg.style)
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(206669);
        return false;
        localaa2 = com.tencent.mm.ao.af.bjB();
        localObject = parameqg.UsF;
        parameqg = localaa1;
        if (localObject != null) {
          parameqg = ((amf)localObject).RVi;
        }
      } while (localaa2.bvt(parameqg) == null);
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] duplicateCardId");
      AppMethodBeat.o(206669);
      return true;
      localaa1 = com.tencent.mm.ao.af.bjB();
      Object localObject = parameqg.UsH;
      parameqg = localaa2;
      if (localObject != null) {
        parameqg = ((due)localObject).cardId;
      }
    } while (localaa1.bvt(parameqg) == null);
    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] canvas duplicateCardId");
    AppMethodBeat.o(206669);
    return true;
  }
  
  public static final boolean hxA()
  {
    AppMethodBeat.i(206662);
    r localr = r.VcW;
    if (!r.hvP())
    {
      AppMethodBeat.o(206662);
      return false;
    }
    if ((!com.tencent.mm.kernel.h.aHB()) || (!((c)com.tencent.mm.kernel.h.ae(c.class)).Gz(1001)))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] onBizRecommendExpt style = %s not support", new Object[] { Integer.valueOf(1001) });
      AppMethodBeat.o(206662);
      return false;
    }
    AppMethodBeat.o(206662);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.af
 * JD-Core Version:    0.7.0.1
 */