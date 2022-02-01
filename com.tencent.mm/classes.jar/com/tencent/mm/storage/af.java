package com.tencent.mm.storage;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webcanvas.m;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkp;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
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
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"BIZTIMELINFO_CARDTYPE_AD", "", "BIZTIMELINFO_CARDTYPE_BIZ", "BIZTIMELINFO_CARDTYPE_RECCARD_CANVAS", "BIZTIMELINFO_CARDTYPE_RECFEED", "BIZTIMELINFO_CARDTYPE_RECFEED_TAG", "BIZTIMELINFO_CARDTYPE_RECOMMEND", "BIZTIMELINFO_CARDTYPE_STYL103", "BIZTIMELINFO_CARDTYPE_UNFOLLOW", "TAG", "", "fillBizMsgItem", "Ljava/util/LinkedList;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "getExtraFromXML", "", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "values", "", "getFromCanvasXml", "getRecCardAppMsgs", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "insertCanvasCardImmediately", "isCanvasCard", "", "isContact", "userName", "isTLRecCardWrapperLegal", "isTLRecFeedLegal", "recFeed", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "onBizRecommendExpt", "content", "postInsertCanvasCard", "recCanvasSupport", "report21461", "redDotFlag", "insertRet", "testInsertCard", "style", "duplicateCardId", "getCardType", "getMidAndIdx", "", "(Ljava/lang/String;)[Ljava/lang/String;", "isShowBigPic", "isUnderLineMsg", "parseExtraFromXML", "parseFromXML", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "setCardId", "plugin-biz_release"})
public final class af
{
  public static final LinkedList<pi> F(z paramz)
  {
    AppMethodBeat.i(212640);
    p.h(paramz, "info");
    LinkedList localLinkedList = new LinkedList();
    if ((!paramz.gAu()) || (paramz.gAD() == null))
    {
      AppMethodBeat.o(212640);
      return localLinkedList;
    }
    Object localObject = paramz.gAD();
    if ((((ege)localObject).style == 3) || (((ege)localObject).style == 5) || (((ege)localObject).style == 0))
    {
      paramz = paramz.gAC();
      if (paramz != null)
      {
        paramz = paramz.KWy;
        if (paramz != null) {
          paramz = ((Iterable)paramz).iterator();
        }
      }
    }
    else
    {
      while (paramz.hasNext())
      {
        localObject = (ega)paramz.next();
        pi localpi = new pi();
        localpi.KSj = ((ega)localObject).KSj;
        localpi.Title = ((ega)localObject).Title;
        localLinkedList.add(localpi);
        continue;
        if ((((ege)localObject).style == 101) || (((ege)localObject).style == 102) || (((ege)localObject).style == 103))
        {
          paramz = paramz.gAD();
          if (paramz != null)
          {
            paramz = paramz.Nga;
            if (paramz != null)
            {
              paramz = paramz.KUf;
              if (paramz != null)
              {
                paramz = ((Iterable)paramz).iterator();
                while (paramz.hasNext())
                {
                  localObject = (pj)paramz.next();
                  if (localObject != null)
                  {
                    localObject = ((pj)localObject).KWy;
                    if (localObject != null)
                    {
                      localObject = ((Iterable)localObject).iterator();
                      while (((Iterator)localObject).hasNext()) {
                        localLinkedList.add((pi)((Iterator)localObject).next());
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
    AppMethodBeat.o(212640);
    return localLinkedList;
  }
  
  public static final int G(z paramz)
  {
    int j = 1;
    AppMethodBeat.i(212646);
    p.h(paramz, "$this$getCardType");
    int i;
    if (paramz.gAt()) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(212646);
      return i;
      if (paramz.gAu())
      {
        paramz = paramz.gAD();
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
      else if (paramz.gAv())
      {
        i = 4;
      }
      else if (paramz.gAs())
      {
        paramz = paramz.NQr;
        if ((paramz != null) && (paramz.KUh == 2002)) {
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
  
  private static boolean IS(String paramString)
  {
    AppMethodBeat.i(212641);
    p.h(paramString, "userName");
    Object localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().Kn(paramString);
    if ((localObject != null) && (((as)localObject).arv()))
    {
      AppMethodBeat.o(212641);
      return true;
    }
    if ((localObject == null) || (((as)localObject).arH() <= 0)) {
      ay.a.aVo().a(paramString, "", null);
    }
    AppMethodBeat.o(212641);
    return false;
  }
  
  public static final LinkedList<String> a(z paramz, ow paramow)
  {
    AppMethodBeat.i(212639);
    p.h(paramz, "info");
    p.h(paramow, "item");
    LinkedList localLinkedList = new LinkedList();
    if ((!paramz.gAu()) || (paramz.gAD() == null))
    {
      AppMethodBeat.o(212639);
      return localLinkedList;
    }
    paramz = ((Iterable)F(paramz)).iterator();
    label140:
    while (paramz.hasNext())
    {
      pi localpi = (pi)paramz.next();
      paramow.duo.add(localpi.KSj);
      CharSequence localCharSequence = (CharSequence)localpi.KWw;
      if ((localCharSequence == null) || (n.aL(localCharSequence))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label140;
        }
        paramow.KVF.add(localpi.KWw);
        break;
      }
    }
    AppMethodBeat.o(212639);
    return localLinkedList;
  }
  
  public static final void a(ege paramege, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212654);
    p.h(paramege, "wrapper");
    switch (paramege.style)
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(212654);
        return;
        localObject1 = paramege.Nga;
      } while (localObject1 == null);
      localObject1 = ((ale)localObject1).KUf;
    } while (localObject1 == null);
    Object localObject2 = (Iterable)localObject1;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label154:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((pj)localObject3).KHa == 0) {}
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
        kotlin.a.j.hxH();
      }
      localObject2 = (pj)localObject2;
      localObject3 = (pi)((pj)localObject2).KWy.get(0);
      if (localObject3 != null)
      {
        if ((((pi)localObject3).KHa & 0x1) == 0)
        {
          Object localObject4 = ((pi)localObject3).KSj;
          p.g(localObject4, "it.ContentUrl");
          localObject4 = bjc((String)localObject4);
          h.CyF.a(21461, new Object[] { ((pj)localObject2).UserName, localObject4[0], localObject4[1], Integer.valueOf(((pi)localObject3).iAb), paramege.Nga.KUo, paramege.Nga.KUk, Integer.valueOf(i), Long.valueOf(paramege.MOC), paramege.Nga.Lui, Integer.valueOf(paramege.style), ((pi)localObject3).KWw, Integer.valueOf(paramege.weight), Integer.valueOf(paramInt1), Integer.valueOf(paramege.Ngb), Integer.valueOf(paramege.pos), Integer.valueOf(paramInt2) });
        }
        i = j;
      }
      else
      {
        i = j;
      }
    }
    AppMethodBeat.o(212654);
  }
  
  public static final void a(ege paramege, Map<String, String> paramMap)
  {
    AppMethodBeat.i(212636);
    p.h(paramege, "wrapper");
    p.h(paramMap, "values");
    b(paramege, paramMap);
    AppMethodBeat.o(212636);
  }
  
  public static final void a(z paramz, ege paramege)
  {
    ale localale = null;
    dkp localdkp = null;
    AppMethodBeat.i(212652);
    p.h(paramz, "$this$setCardId");
    p.h(paramege, "wrapper");
    paramz.field_recommendCardId = "";
    switch (paramege.style)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212652);
      return;
      localale = paramege.Nga;
      paramege = localdkp;
      if (localale != null) {
        paramege = localale.KUk;
      }
      paramz.field_recommendCardId = paramege;
      AppMethodBeat.o(212652);
      return;
      localdkp = paramege.Ngc;
      paramege = localale;
      if (localdkp != null) {
        paramege = localdkp.cardId;
      }
      paramz.field_recommendCardId = paramege;
    }
  }
  
  public static final void a(LinkedList<pj> paramLinkedList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(212638);
    p.h(paramLinkedList, "$this$parseFromXML");
    p.h(paramMap, "values");
    int i = 0;
    while (i <= 9)
    {
      Object localObject2 = new StringBuilder(".sysmsg.BizAccountRecommend.BizAccount");
      pj localpj;
      label329:
      Object localObject3;
      if (i == 0)
      {
        localObject1 = "";
        localObject2 = localObject1;
        if (Util.isNullOrNil((String)paramMap.get((String)localObject2 + ".UserName"))) {
          break;
        }
        localpj = new pj();
        localpj.UserName = ((String)paramMap.get((String)localObject2 + ".UserName"));
        localpj.oUJ = ((String)paramMap.get((String)localObject2 + ".NickName"));
        localpj.xLi = ((String)paramMap.get((String)localObject2 + ".RecommendReason"));
        localpj.keb = ((String)paramMap.get((String)localObject2 + ".Signature"));
        localpj.KQY = ((String)paramMap.get((String)localObject2 + ".BrandIconUrl"));
        localpj.KWx = ((String)paramMap.get((String)localObject2 + ".AppMsgRecReason"));
        localpj.KWr = new LinkedList();
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
        localpj.KWr.add(localObject1);
        j += 1;
        break label329;
        localObject1 = Integer.valueOf(i);
        break;
      }
      label428:
      localpj.KWs = Util.getInt((String)paramMap.get((String)localObject2 + ".ShowNegativeFeedbackReason"), 1);
      localpj.KWy = new LinkedList();
      paramLinkedList.add(localpj);
      int j = 0;
      while (j <= 1)
      {
        localObject3 = new StringBuilder().append((String)localObject2).append(".AppMsg");
        pi localpi;
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
          localpi = new pi();
          localpi.Title = ((String)paramMap.get((String)localObject3 + ".Title"));
          localpi.KSh = ((String)paramMap.get((String)localObject3 + ".Digest"));
          localpi.KSj = ((String)paramMap.get((String)localObject3 + ".ContentUrl"));
          localpi.KSl = ((String)paramMap.get((String)localObject3 + ".CoverImgUrl"));
          localpi.KSm = ((String)paramMap.get((String)localObject3 + ".CoverImgUrl_1_1"));
          localpi.KSn = ((String)paramMap.get((String)localObject3 + ".CoverImgUrl_235_1"));
          localpi.iAb = Util.getInt((String)paramMap.get((String)localObject3 + ".ItemShowType"), -1);
          localpi.KSu = ((String)paramMap.get((String)localObject3 + ".VideoId"));
          localpi.KSv = Util.getInt((String)paramMap.get((String)localObject3 + ".VideoWidth"), -1);
          localpi.KSw = Util.getInt((String)paramMap.get((String)localObject3 + ".VideoHeight"), -1);
          localpi.KSx = Util.getInt((String)paramMap.get((String)localObject3 + ".VideoDuration"), -1);
          localpi.CreateTime = Util.getInt((String)paramMap.get((String)localObject3 + ".CreateTime"), -1);
          localpi.KWt = ((String)paramMap.get((String)localObject3 + ".VoicePlayUrl"));
          localpi.KWu = Util.getInt((String)paramMap.get((String)localObject3 + ".VoiceDuration"), -1);
          localpi.KWr = new LinkedList();
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
          localpi.KWr.add(localObject1);
          k += 1;
          break label1107;
          localObject1 = Integer.valueOf(j);
          break;
        }
        label1211:
        localpi.KWs = Util.getInt((String)paramMap.get((String)localObject3 + ".ShowNegativeFeedbackReason"), 1);
        localpi.KWv = Util.getInt((String)paramMap.get((String)localObject3 + ".RecRk"), 0);
        localpi.KWw = ((String)paramMap.get((String)localObject3 + ".RecInfo"));
        localpj.KWy.add(localpi);
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(212638);
  }
  
  public static final boolean a(dkr paramdkr)
  {
    AppMethodBeat.i(212642);
    p.h(paramdkr, "$this$isShowBigPic");
    if (paramdkr.MOH == 0)
    {
      AppMethodBeat.o(212642);
      return true;
    }
    AppMethodBeat.o(212642);
    return false;
  }
  
  public static final void akc(int paramInt)
  {
    AppMethodBeat.i(212656);
    Object localObject2 = "card_id_" + System.currentTimeMillis();
    if (paramInt == 1001)
    {
      localObject1 = "中国国家地理" + System.currentTimeMillis() % 10000L;
      localObject1 = "<sysmsg type=\"BizRecommendExpt\">\n<BizRecommendExpt>\n<Title><![CDATA[猜你喜欢]]></Title>\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>1591189349</RecID>\n<RedDotFlag>1</RedDotFlag>\n<BusinessId>0</BusinessId>\n<CardID><![CDATA[" + (String)localObject2 + "]]></CardID>\n<Data><![CDATA[{\"Title\":\"猜你喜欢\",\"BizAccount\":[{\"Flag\":0,\"UserName\":\"gh_f05ff0331d78\",\"NickName\":\"" + (String)localObject1 + "\",\"RecommendReason\":\"\",\"Signature\":\"《深度参考》是中国高端精英读物，是您了解最新、最有深度、最有价值的时事财经资讯窗口，欢迎关注！\",\"BrandIconUrl\":\"http://mmbiz.qpic.cn/mmbiz/3lXPl12icGVZjPnbiaWdLbMQoNpTK6ZicaTFUk5jLfciaRVoukmISPd5DC6YHy5No4a4uy6k3PnIMIH00XJOVw0ibRw/0?wx_fmt=png\",\"AppMsgRecReason\":\"近期更新\",\"AppMsg\":[{\"Flag\":0,\"Title\":\"气温超过50°的极热之地，你敢去吗？\",\"Digest\":\"我是摘要测试测试\",\"ContentUrl\":\"https://mp.weixin.qq.com/s/oKmmWfX9G3Yfbmp5aDeyTQ\",\"CoverImgUrl\":\"http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg\",\"CoverImgUrl_1_1\":\"https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg\",\"CoverImgUrl_235_1\":\"\",\"ItemShowType\":0,\"VideoId\":\"\",\"VideoWidth\":0,\"VideoHeight\":0,\"VideoDuration\":180,\"CreateTime\":1593296809,\"NegativeFeedbackReason\":[\"内容质量低\",\"不看此公众号\"],\"ShowNegativeFeedbackReason\":0,\"RecommendReason\":\"\",\"VoicePlayUrl\":\"\",\"VoiceDuration\":0,\"RecRk\":1,\"RecInfo\":\"something\",\"AppMsgId\":2698324179,\"ItemIdx\":1,\"AuthorAppUin\":1014597342,\"CanReward\":0,\"CanPaid\":0},{\"Flag\":0,\"Title\":\"深度雄文，西部高原屏障对中华民族战略安全的重大意义！\",\"Digest\":\"深度参考长按右边的二维码关注2013年4月在中国的阿克塞欣的斗拉特别里奥地地区中印两国爆发“帐蓬对峙”，20\",\"ContentUrl\":\"http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324092&idx=4&sn=015c49c8d05b56267366a2cce351c2ec&chksm=be5bbb08892c321e990026bce74c09ad13da8ec56896875358f4db0271222b09b146b95739b1#rd\",\"CoverImgUrl\":\"http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg\",\"CoverImgUrl_1_1\":\"https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg\",\"CoverImgUrl_235_1\":\"\",\"ItemShowType\":0,\"VideoId\":\"\",\"VideoWidth\":0,\"VideoHeight\":0,\"VideoDuration\":180,\"CreateTime\":1593211927,\"NegativeFeedbackReason\":[\"内容质量低\",\"不看此公众号\"],\"ShowNegativeFeedbackReason\":0,\"RecommendReason\":\"\",\"VoicePlayUrl\":\"\",\"VoiceDuration\":180,\"RecRk\":2,\"RecInfo\":\"great\",\"AppMsgId\":2698324092,\"ItemIdx\":4,\"AuthorAppUin\":1654122144,\"CanReward\":0,\"CanPaid\":0}],\"NegativeFeedbackReason\":[\"不看此公众号\",\"内容低质\",\"内容重复\",\"内容过时\",\"希望减少推荐\"],\"ShowNegativeFeedbackReason\":1,\"BizUin\":3007693851}],\"Pos\":1,\"Weight\":200,\"RecID\":10086,\"Style\":1001,\"Event\":\"hengqing\",\"RedDotFlag\":1,\"RecSummary\":\"深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！\",\"CardId\":\"cdd97abeab063a0e00cea86f805bb17c\",\"ExpType\":\"tools\"}]]></Data>\n<RecSummary><![CDATA[气温超过50°的极热之地，你敢去吗？]]></RecSummary>\n<AppId><![CDATA[wxf337cbaa27790d8e]]></AppId>\n<ExtraData><![CDATA[{\"type\":1,\"real_data\":\"{\\\"biz_info\\\":[{\\\"username\\\":\\\"gh_49f4cd2ce99b\\\",\\\"nickname\\\":\\\"皮皮浪老师\\\",\\\"appmsg_info\\\":[{\\\"url\\\":\\\"http:\\\\\\/\\\\\\/mp.weixin.qq.com\\\\\\/s?__biz=MzA4OTE5NzQ5MQ==&mid=2247483877&idx=1&sn=e693e539daef056fa051e66374e41b48&chksm=901fdf39a768562fe6aaaeed3dfc9909d781ea8c45862cc335ed527eafcdb51f4aca774f67c3#rd\\\",\\\"title\\\":\\\"皮皮浪的复盘讲解（二十二）——围空不要拆二\\\",\\\"rec_rk\\\":1,\\\"rec_info\\\":\\\"something\\\",\\\"item_show_type\\\":5}]}],\\\"style\\\":1001,\\\"event\\\":\\\"hengqing\\\",\\\"card_id\\\":\\\"33a95e9794780cc0f584220dbb9fcfe2\\\",\\\"exp_type\\\":\\\"tools\\\"}\"}]]></ExtraData>\n<TemplatePath><![CDATA[re.js]]></TemplatePath>\n<TemplatePathType><![CDATA[re]]></TemplatePathType>\n</BizRecommendExpt>\n</sysmsg>";
      paramInt = n.a((CharSequence)localObject1, "<sysmsg", 0, false, 6);
      if (paramInt != -1)
      {
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(212656);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((String)localObject1).substring(paramInt);
        p.g(localObject2, "(this as java.lang.String).substring(startIndex)");
        localObject2 = XmlParser.parseXml((String)localObject2, "sysmsg", null);
        if (localObject2 == null)
        {
          Log.e("MicroMsg.BizTimeLineStorageLogicExKt", "XmlParser values is null, msgContent %s", new Object[] { localObject1 });
          AppMethodBeat.o(212656);
        }
      }
      else
      {
        AppMethodBeat.o(212656);
        return;
      }
      localObject1 = bV((Map)localObject2);
      if (localObject1 == null) {
        p.hyc();
      }
      f((ege)localObject1);
      AppMethodBeat.o(212656);
      return;
    }
    Object localObject1 = "";
    if (paramInt == 1) {
      localObject1 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_f05ff0331d78]]></UserName>\n<NickName><![CDATA[深度参考]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[《深度参考》是中国高端精英读物，是您了解最新、最有深度、最有价值的时事财经资讯窗口，欢迎关注！]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/3lXPl12icGVZjPnbiaWdLbMQoNpTK6ZicaTFUk5jLfciaRVoukmISPd5DC6YHy5No4a4uy6k3PnIMIH00XJOVw0ibRw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324179&idx=1&sn=02fb8d7cbd9a4187266280edccc1c303&chksm=be5bbba7892c32b19e13202074ffb143c96ff4d1024939ce4c917cf740905e67444b11604b13#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1593296809</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n<AppMsg>\n<Title><![CDATA[深度雄文，西部高原屏障对中华民族战略安全的重大意义！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324092&idx=4&sn=015c49c8d05b56267366a2cce351c2ec&chksm=be5bbb08892c321e990026bce74c09ad13da8ec56896875358f4db0271222b09b146b95739b1#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVY34GKxTibsNvqZEtEeIFYTRKFt0yr47GZY0AicB2iaU9Iuf7r374aNic2ZD8M2iaZibGkhXEicDwpViaSbiaA/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1593211927</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>2</RecRk>\n<RecInfo><![CDATA[great]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>102</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></RecSummary>\n<CardId><![CDATA[" + (String)localObject2 + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n" + "<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
    }
    for (;;)
    {
      ab.X((String)localObject1, null);
      AppMethodBeat.o(212656);
      return;
      if (paramInt == 2) {
        localObject1 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_028c33dfd807]]></UserName>\n<NickName><![CDATA[粤知一二]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[由广东综艺90后门面担当郭嘉峰主持，是一档有个性有深度，看了会上瘾的粤语脱口秀节目。每晚18：00准时更新。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/Y7rtYuVxk9TNiaA7iciav0aI5ZNxxxVybPXOoxocjzdu2REcv0bck59HFZ9jJTmHB6spYXlqibCfUia8E9997dLaoHw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDU3Njk4MA==&mid=2247506230&idx=2&sn=80d0ead06f7d4446e42a89d57ee81699&chksm=ebb4cf8ddcc3469b4d62d4324bcec575812c28fea3d68af6e838f0a9a5bb79a8db7320fc7e70#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[https://vpic.video.qq.com/36675860/i0787zrbitj.png]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>5</ItemShowType>\n<VideoId><![CDATA[i0787zrbitj]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>245</VideoDuration>\n<CreateTime>1592751453</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n<AppMsg>\n<Title><![CDATA[教你一套坐公交车自救秘籍，你想要吗？]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDU3Njk4MA==&mid=2247494577&idx=1&sn=b0e489f3f5517b7942526aab7710052c&chksm=ebb4fd0adcc3741cc503f47ca2e1193af82db286d2baa438bb8d6209de9e192d8aaac5281d2a#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/Y7rtYuVxk9QHKGicgHASZibRp09iaGwSnnAN4cHzBvfupOIsibv78UfUGAJtcH1wT7wmAOicHib1k8a2FErDx7DFMNpg/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>5</ItemShowType>\n<VideoId><![CDATA[wxv_543960396546260993]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>314</VideoDuration>\n<CreateTime>1542015514</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>2</RecRk>\n<RecInfo><![CDATA[great]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>102</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></RecSummary>\n<CardId><![CDATA[" + (String)localObject2 + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n" + "<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
      } else if (paramInt == 3) {
        localObject1 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_028c33dfd807]]></UserName>\n<NickName><![CDATA[粤知一二]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[由广东综艺90后门面担当郭嘉峰主持，是一档有个性有深度，看了会上瘾的粤语脱口秀节目。每晚18：00准时更新。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/Y7rtYuVxk9TNiaA7iciav0aI5ZNxxxVybPXOoxocjzdu2REcv0bck59HFZ9jJTmHB6spYXlqibCfUia8E9997dLaoHw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI4MDU3Njk4MA==&mid=2247506230&idx=2&sn=80d0ead06f7d4446e42a89d57ee81699&chksm=ebb4cf8ddcc3469b4d62d4324bcec575812c28fea3d68af6e838f0a9a5bb79a8db7320fc7e70#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[https://vpic.video.qq.com/36675860/i0787zrbitj.png]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>5</ItemShowType>\n<VideoId><![CDATA[i0787zrbitj]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>245</VideoDuration>\n<CreateTime>1592751453</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>102</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[经常吃港式茶餐厅的你，点餐时一定都听过这些暗号！]]></RecSummary>\n<CardId><![CDATA[" + (String)localObject2 + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n" + "<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
      } else if (paramInt == 4) {
        localObject1 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[猜你喜欢]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_f05ff0331d78]]></UserName>\n<NickName><![CDATA[深度参考]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[]]></RecommendReason>\n<Signature><![CDATA[《深度参考》是中国高端精英读物，是您了解最新、最有深度、最有价值的时事财经资讯窗口，欢迎关注！]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/3lXPl12icGVZjPnbiaWdLbMQoNpTK6ZicaTFUk5jLfciaRVoukmISPd5DC6YHy5No4a4uy6k3PnIMIH00XJOVw0ibRw/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzAwNzY5Mzg1MQ==&mid=2698324179&idx=1&sn=02fb8d7cbd9a4187266280edccc1c303&chksm=be5bbba7892c32b19e13202074ffb143c96ff4d1024939ce4c917cf740905e67444b11604b13#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/3lXPl12icGVZIyj3SMeiaotBJ8r5qwgAicflnXdjFKicPd2jbfd0ibRpsUFo7m0oAenT7ReBddeeqmoicDBPcOVCaMNw/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1593296809</CreateTime>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n<VoicePlayUrl><![CDATA[]]></VoicePlayUrl>\n<VoiceDuration>0</VoiceDuration>\n<RecRk>1</RecRk>\n<RecInfo><![CDATA[something]]></RecInfo>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>10086</RecID>\n<Style>101</Style>\n<Event>hengqing</Event>\n<RedDotFlag>1</RedDotFlag>\n<RecSummary><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></RecSummary>\n<CardId><![CDATA[" + (String)localObject2 + "]]></CardId>\n<ExpType><![CDATA[tools]]></ExpType>\n<NegativeFeedbackReason><![CDATA[不看此公众号]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容低质]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容重复]]></NegativeFeedbackReason>\n\n" + "<NegativeFeedbackReason><![CDATA[内容过时]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
      } else if (paramInt == 5) {
        localObject1 = "<sysmsg type=\"BizRecommendNotify\">\n<BizAccountRecommend>\n<Title><![CDATA[推荐公众号]]></Title>\n\n<BizAccount>\n<UserName><![CDATA[gh_240fbf8b33e4]]></UserName>\n<NickName><![CDATA[36氪]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[36氪是中国领先的新商业媒体，提供新锐深度的商业报道。我们强调趋势与价值，我们的slogan是：让一部分人先看到未来。]]></RecommendReason>\n<Signature><![CDATA[36氪是中国领先的新商业媒体，提供新锐深度的商业报道。我们强调趋势与价值，我们的slogan是：让一部分人先看到未来。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/QicyPhNHD5vYf0JyXiavcUmicQ7icOk55ygRlyOhCa9r132trMAiaYtqL0QzacfMLPolhsiaXGibWC0JskibLic02W6Mw1g/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[8点1氪：微信回应或遭苹果下架；格力口罩昨日开售：KN95每只5.5元；美股史上第二次触发熔断]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MzI2NDk5NzA0Mw==&mid=2247569208&idx=1&sn=27b7704f80c8271dcad2e52ee63cdf01&chksm=eaa79ee4ddd017f21d63e7a780c1941812f847bf968b40b2d81329b4e9f5a4f70f4e6e814c79#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/QicyPhNHD5vbhqC2kPdlU3tQrCiakmhHStEcNCOLwrocic2Vvr0J3qPNiaKYEn2vYIsQbGFBYM5PSAF9NecOalcnFw/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/QicyPhNHD5vbhqC2kPdlU3tQrCiakmhHStkWNVPziaEt1aEVBPnYyrzlpAbEXicqQ8zRmNgDBfupiccdibuBpeCHpKeQ/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1583799540</CreateTime>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[对A1不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对A2不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对此公众号不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<BizAccount>\n<UserName><![CDATA[gh_363b924965e9]]></UserName>\n<NickName><![CDATA[人民日报]]></NickName>\n<HeadImgUrl><![CDATA[]]></HeadImgUrl>\n<RecommendReason><![CDATA[参与、沟通、记录时代。]]></RecommendReason>\n<Signature><![CDATA[参与、沟通、记录时代。]]></Signature>\n<BrandIconUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_png/xrFYciaHL08CtD0lEHt59N8SQicW1gI0WjYKCEpzgRCPFBlJGI1rIfRl4bFSTLoFnI4iaylWmJVqd8semEK1OGylg/0?wx_fmt=png]]></BrandIconUrl>\n<AppMsgRecReason><![CDATA[]]></AppMsgRecReason>\n\n<AppMsg>\n<Title><![CDATA[发请柬啦！我们邀请所有人，共同见证一场盛大的婚礼！]]></Title>\n<Digest><![CDATA[]]></Digest>\n<ContentUrl><![CDATA[http://mp.weixin.qq.com/s?__biz=MjM5MjAxNDM4MA==&mid=2666316160&idx=1&sn=54684fd350167a7f3bed5bde5ce9dc64&chksm=bdb4a8c38ac321d5852e261a2e31f038fd0e98ec66bee2920d88ee4cdf11979bdede1e0c908e#rd]]></ContentUrl>\n<CoverImgUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/xrFYciaHL08AD1ynAav39zdY1WvI5bbsyACCQygrAQqFY1EZiaRwHJYMD7v2x2LLBp0YsHwku3In19N5D3aYZx9A/0?wx_fmt=jpeg]]></CoverImgUrl>\n<CoverImgUrl_1_1><![CDATA[https://mmbiz.qlogo.cn/mmbiz_jpg/xrFYciaHL08AD1ynAav39zdY1WvI5bbsy1kWLuqdNxNVFWIUWBC0DTgnyAkt5cAicI2DyfkVZ14Bx5oemgWmiaphg/0?wx_fmt=jpeg]]></CoverImgUrl_1_1>\n<CoverImgUrl_235_1><![CDATA[]]></CoverImgUrl_235_1>\n<ItemShowType>0</ItemShowType>\n<VideoId><![CDATA[]]></VideoId>\n<VideoWidth>0</VideoWidth>\n<VideoHeight>0</VideoHeight>\n<VideoDuration>0</VideoDuration>\n<CreateTime>1589804841</CreateTime>\n\n<ShowNegativeFeedbackReason>0</ShowNegativeFeedbackReason>\n</AppMsg>\n\n\n<NegativeFeedbackReason><![CDATA[对D不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对此公众号不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccount>\n\n<Pos>1</Pos>\n<Weight>200</Weight>\n<RecID>1589808970</RecID>\n<Style>103</Style>\n<Event></Event>\n<RecSummary><![CDATA[深度长文：美“印太战略”注定失败，中国有能力应付美国极端选择！]]></RecSummary>\n<CardId><![CDATA[" + (String)localObject2 + "]]></CardId>\n<AggregationUrl><![CDATA[http://wwww.baidu.com]]></AggregationUrl>\n<AggregationTitle><![CDATA[大家都在看的大事件 >]]></AggregationTitle>\n<NegativeFeedbackReason><![CDATA[对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣对A1不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[对A2不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[内容质量低]]></NegativeFeedbackReason>\n" + "\n<NegativeFeedbackReason><![CDATA[对此公众号不感兴趣]]></NegativeFeedbackReason>\n\n<NegativeFeedbackReason><![CDATA[希望减少推荐]]></NegativeFeedbackReason>\n\n<ShowNegativeFeedbackReason>1</ShowNegativeFeedbackReason>\n</BizAccountRecommend>\n</sysmsg>";
      }
    }
  }
  
  private static void b(ege paramege, Map<String, String> paramMap)
  {
    AppMethodBeat.i(212637);
    p.h(paramege, "$this$parseExtraFromXML");
    p.h(paramMap, "values");
    Object localObject = (kotlin.g.a.a)new af.a(paramege, paramMap);
    switch (paramege.style)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212637);
      return;
      ((kotlin.g.a.a)localObject).invoke();
      AppMethodBeat.o(212637);
      return;
      ((kotlin.g.a.a)localObject).invoke();
      ale localale = paramege.Nga;
      int i = 0;
      if (i <= 20)
      {
        localObject = new StringBuilder(".sysmsg.BizAccountRecommend.NegativeFeedbackReason");
        if (i == 0) {}
        for (paramege = "";; paramege = Integer.valueOf(i))
        {
          paramege = (String)paramMap.get(paramege);
          if (Util.isNullOrNil(paramege)) {
            break label174;
          }
          localale.KWr.add(paramege);
          i += 1;
          break;
        }
      }
      label174:
      localale.KWs = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.ShowNegativeFeedbackReason"), 0);
      localObject = (String)paramMap.get(".sysmsg.BizAccountRecommend.AggregationUrl");
      paramege = (ege)localObject;
      if (localObject == null) {
        paramege = "";
      }
      localale.Luj = paramege;
      paramMap = (String)paramMap.get(".sysmsg.BizAccountRecommend.AggregationTitle");
      paramege = paramMap;
      if (paramMap == null) {
        paramege = "";
      }
      localale.Luk = paramege;
    }
  }
  
  public static final boolean b(dkr paramdkr)
  {
    AppMethodBeat.i(212643);
    p.h(paramdkr, "recFeed");
    Object localObject = (Collection)paramdkr.MOG;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] RecommendItem is illegal");
      AppMethodBeat.o(212643);
      return false;
    }
    if (paramdkr.KUh == 2002)
    {
      localObject = (CharSequence)paramdkr.Luk;
      if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] AggregationTitle is illegal");
        AppMethodBeat.o(212643);
        return false;
      }
      localObject = (CharSequence)paramdkr.Luj;
      if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] AggregationUrl is illegal");
        AppMethodBeat.o(212643);
        return false;
      }
      localObject = (CharSequence)paramdkr.MOI;
      if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] RecommendWording is illegal");
        AppMethodBeat.o(212643);
        return false;
      }
    }
    paramdkr = paramdkr.MOG;
    p.g(paramdkr, "recFeed.RecommendItem");
    localObject = ((Iterable)paramdkr).iterator();
    while (((Iterator)localObject).hasNext())
    {
      dlb localdlb = (dlb)((Iterator)localObject).next();
      paramdkr = localdlb.MOY;
      if (paramdkr != null)
      {
        paramdkr = paramdkr.Title;
        paramdkr = (CharSequence)paramdkr;
        if ((paramdkr != null) && (!n.aL(paramdkr))) {
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
        AppMethodBeat.o(212643);
        return false;
        paramdkr = null;
        break;
      }
      label317:
      paramdkr = localdlb.MOY;
      if (paramdkr != null)
      {
        paramdkr = paramdkr.KSj;
        paramdkr = (CharSequence)paramdkr;
        if ((paramdkr != null) && (!n.aL(paramdkr))) {
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
        AppMethodBeat.o(212643);
        return false;
        paramdkr = null;
        break;
      }
      label380:
      paramdkr = localdlb.MOY;
      if (paramdkr != null) {}
      for (i = paramdkr.iAb; (i != 5) && (i != 8) && (i != 10) && (i != 0); i = -1)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] ItemShowType is illegal, itemShowType=" + i + '.');
        AppMethodBeat.o(212643);
        return false;
      }
      paramdkr = localdlb.MOX;
      if (paramdkr != null)
      {
        paramdkr = paramdkr.oUJ;
        paramdkr = (CharSequence)paramdkr;
        if ((paramdkr != null) && (!n.aL(paramdkr))) {
          break label514;
        }
      }
      label514:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label519;
        }
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] NickName is illegal");
        AppMethodBeat.o(212643);
        return false;
        paramdkr = null;
        break;
      }
      label519:
      paramdkr = localdlb.MOX;
      if (paramdkr != null)
      {
        paramdkr = paramdkr.UserName;
        paramdkr = (CharSequence)paramdkr;
        if ((paramdkr != null) && (!n.aL(paramdkr))) {
          break label577;
        }
      }
      label577:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label582;
        }
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] NickName is illegal");
        AppMethodBeat.o(212643);
        return false;
        paramdkr = null;
        break;
      }
      label582:
      paramdkr = localdlb.MOY;
      if ((paramdkr != null) && (5 == paramdkr.iAb))
      {
        paramdkr = localdlb.MOY;
        if (paramdkr != null) {}
        for (paramdkr = paramdkr.Mjm; paramdkr == null; paramdkr = null)
        {
          Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] VideoInfo is illegal");
          AppMethodBeat.o(212643);
          return false;
        }
      }
      paramdkr = localdlb.MOY;
      if ((paramdkr != null) && (7 == paramdkr.iAb))
      {
        paramdkr = localdlb.MOY;
        if (paramdkr != null) {}
        for (paramdkr = paramdkr.Mjn; paramdkr == null; paramdkr = null)
        {
          Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECFEED] VoiceInfo is illegal");
          AppMethodBeat.o(212643);
          return false;
        }
      }
    }
    AppMethodBeat.o(212643);
    return true;
  }
  
  public static final boolean b(ege paramege, z paramz)
  {
    AppMethodBeat.i(212644);
    p.h(paramege, "wrapper");
    int j = paramege.style;
    if (j == 1001)
    {
      if (paramege.Ngc == null)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal exptInfo = null");
        AppMethodBeat.o(212644);
        return false;
      }
      if (Util.isNullOrNil(paramege.Ngc.data))
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal exptInfo.data = null");
        AppMethodBeat.o(212644);
        return false;
      }
      if ((Util.isNullOrNil(paramege.Ngc.appId)) || (Util.isNullOrNil(paramege.Ngc.MOE)))
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal appid or path error, appId = " + paramege.Ngc.appId + ", path = " + paramege.Ngc.MOE);
        AppMethodBeat.o(212644);
        return false;
      }
      AppMethodBeat.o(212644);
      return true;
    }
    Object localObject = paramege.NfY;
    if (localObject == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal recCard null");
      AppMethodBeat.o(212644);
      return false;
    }
    if (((efz)localObject).Lug == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal CardTitle null");
      AppMethodBeat.o(212644);
      return false;
    }
    if (((efz)localObject).KWx == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] isTLRecCardWrapperLegal AppMsgRecReason null");
      AppMethodBeat.o(212644);
      return false;
    }
    egb localegb = ((efz)localObject).NfT;
    if (localegb == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo null");
      AppMethodBeat.o(212644);
      return false;
    }
    if (localegb.UserName == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo UserName null");
      AppMethodBeat.o(212644);
      return false;
    }
    if (localegb.oUJ == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo NickName null");
      AppMethodBeat.o(212644);
      return false;
    }
    if (localegb.NfV == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] checkBizInfo RecReason null");
      AppMethodBeat.o(212644);
      return false;
    }
    if (Util.isNullOrNil((List)((efz)localObject).KWy))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] AppMsg null");
      AppMethodBeat.o(212644);
      return false;
    }
    if ((j == 5) && (((efz)localObject).KWy.size() < 2))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] AppMsg video size < 2");
      AppMethodBeat.o(212644);
      return false;
    }
    int k;
    if ((j == 101) || (j == 102) || (j == 103))
    {
      if ((paramege.Nga == null) || (Util.isNullOrNil((List)paramege.Nga.KUf)) || (paramege.Nga.KUf.size() >= 3))
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " BizInfo size >= 3");
        AppMethodBeat.o(212644);
        return false;
      }
      if (paramege.Nga.KHa == 1)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " extraInfo flag = 1");
        if (paramz != null) {
          ag.ban().MX(paramz.field_msgId);
        }
        AppMethodBeat.o(212644);
        return false;
      }
      localObject = paramege.Nga.KUf;
      p.g(localObject, "wrapper.extraInfo.BizInfo");
      k = ((Collection)localObject).size();
      i = 0;
      if (i >= k) {
        break label1168;
      }
      if (((pj)paramege.Nga.KUf.get(i)).KHa == 1) {}
    }
    label1155:
    label1163:
    label1168:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " bizLegal illegal");
        if (paramz != null) {
          ag.ban().MX(paramz.field_msgId);
        }
        AppMethodBeat.o(212644);
        return false;
        i += 1;
        break;
      }
      if (j != 103)
      {
        localObject = paramege.Nga.KUf;
        p.g(localObject, "wrapper.extraInfo.BizInfo");
        k = ((Collection)localObject).size();
        i = 0;
        if (i >= k) {
          break label1163;
        }
        localObject = ((pj)paramege.Nga.KUf.get(i)).UserName;
        p.g(localObject, "wrapper.extraInfo.BizInfo[i].UserName");
        if (IS((String)localObject)) {}
      }
      for (i = 0;; i = 1)
      {
        if (i != 0)
        {
          Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " bizLegal contact");
          if (paramz != null) {
            ag.ban().MX(paramz.field_msgId);
          }
          AppMethodBeat.o(212644);
          return false;
          i += 1;
          break;
        }
        paramz = paramege.Nga.KUf;
        p.g(paramz, "wrapper.extraInfo.BizInfo");
        k = ((Collection)paramz).size();
        i = 0;
        if (i < k)
        {
          if (Util.isNullOrNil((List)((pj)paramege.Nga.KUf.get(i)).KWy))
          {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " AppMsg null");
            AppMethodBeat.o(212644);
            return false;
          }
          if (((pi)((pj)paramege.Nga.KUf.get(i)).KWy.get(0)).KHa != 1) {}
        }
        for (i = 0;; i = 1)
        {
          if (i == 0)
          {
            Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " AppMsg illegal");
            AppMethodBeat.o(212644);
            return false;
            i += 1;
            break;
          }
          paramege = ((pj)paramege.Nga.KUf.get(0)).KWy;
          p.g(paramege, "wrapper.extraInfo.BizInfo[0].AppMsg");
          paramege = ((Iterable)paramege).iterator();
          i = 1;
          if (paramege.hasNext())
          {
            paramz = (pi)paramege.next();
            if ((paramz.iAb != 8) && (paramz.iAb != 7) && (paramz.iAb != 6) && (paramz.iAb != 10)) {
              break label1155;
            }
            i = 0;
          }
          for (;;)
          {
            break;
            if (i == 0)
            {
              Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] style = " + j + " showTypeLegal illegal");
              AppMethodBeat.o(212644);
              return false;
            }
            AppMethodBeat.o(212644);
            return true;
          }
        }
      }
    }
  }
  
  public static final boolean bU(Map<String, String> paramMap)
  {
    AppMethodBeat.i(212648);
    p.h(paramMap, "values");
    if (!Util.isNullOrNil((String)paramMap.get(".sysmsg.BizRecommendExpt.Data")))
    {
      AppMethodBeat.o(212648);
      return true;
    }
    AppMethodBeat.o(212648);
    return false;
  }
  
  public static final ege bV(Map<String, String> paramMap)
  {
    AppMethodBeat.i(212649);
    p.h(paramMap, "values");
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
      AppMethodBeat.o(212649);
      return null;
    }
    ege localege = new ege();
    localege.pos = i;
    localege.weight = j;
    localege.MOC = l;
    dkp localdkp = new dkp();
    localdkp.title = str1;
    localdkp.pos = i;
    localdkp.weight = j;
    localdkp.MOC = l;
    localdkp.businessId = str2;
    localdkp.cardId = str3;
    localdkp.data = str4;
    localdkp.Lui = str5;
    localdkp.appId = str6;
    localdkp.MOE = str7;
    localege.Ngc = localdkp;
    localege.style = 1001;
    localege.Ngb = m;
    localege.dSJ = paramMap;
    localege.MOD = k;
    AppMethodBeat.o(212649);
    return localege;
  }
  
  public static final void bW(Map<String, String> paramMap)
  {
    AppMethodBeat.i(212651);
    p.h(paramMap, "values");
    Object localObject1 = ag.ban();
    p.g(localObject1, "SubCoreBiz.getBizTimeLineInfoStorage()");
    localObject1 = ((aa)localObject1).gAM();
    if (localObject1 == null)
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard lastTimeLineInfo is null");
      AppMethodBeat.o(212651);
      return;
    }
    ege localege = bV(paramMap);
    if (localege == null)
    {
      AppMethodBeat.o(212651);
      return;
    }
    paramMap = MultiProcessMMKV.getSingleMMKV("brandService");
    if (localege.MOD != 2)
    {
      if (((z)localObject1).field_status == 4)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard lastTimeLineInfo is exposed");
        AppMethodBeat.o(212651);
        return;
      }
      localObject2 = new StringBuilder("BizLatestRecommendCardInfo");
      p.g(g.aAf(), "MMKernel.account()");
      paramMap.encode(com.tencent.mm.kernel.a.ayV(), "");
    }
    if (!e(localege))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard illegal");
      AppMethodBeat.o(212651);
      return;
    }
    if (g(localege))
    {
      AppMethodBeat.o(212651);
      return;
    }
    paramMap = ag.ban();
    p.g(paramMap, "SubCoreBiz.getBizTimeLineInfoStorage()");
    long l3 = paramMap.gAS();
    h.CyF.idkeyStat(1149L, 1L, 1L, false);
    paramMap = ag.ban();
    p.g(paramMap, "SubCoreBiz.getBizTimeLineInfoStorage()");
    long l2 = paramMap.gAO();
    Object localObject2 = new z();
    ((z)localObject2).field_msgId = ag.ban().gAW();
    ((z)localObject2).field_msgSvrId = 0L;
    ((z)localObject2).field_type = 620757041;
    ((z)localObject2).field_talker = "";
    ((z)localObject2).field_talkerId = 0;
    ((z)localObject2).field_createTime = (l2 - 1000L);
    ((z)localObject2).nc(1);
    ((z)localObject2).field_status = 3;
    a((z)localObject2, localege);
    ((z)localObject2).c(localege);
    long l1 = 0L;
    if (localege.Ngc.weight >= 0) {
      l1 = kotlin.k.j.aN(localege.Ngc.weight, 255L);
    }
    boolean bool;
    label556:
    int i;
    int j;
    int k;
    for (;;)
    {
      if (localege.MOD == 2) {
        if (l3 <= 10L)
        {
          AppMethodBeat.o(212651);
          return;
          if (localege.Ngc.pos == 0)
          {
            l1 = ab.Na(((z)localObject1).field_orderFlag);
            ((z)localObject2).field_createTime = (l2 + 1000L);
          }
          else
          {
            paramMap = ag.ban().ajV(localege.Ngc.pos - 1);
            if (paramMap == null)
            {
              Log.w("MicroMsg.BizTimeLineStorageLogicExKt", "postInsertCanvasCard lastTimeLineInfo is null");
            }
            else
            {
              l1 = ab.Na(paramMap.field_orderFlag);
              ((z)localObject2).field_createTime = (paramMap.field_createTime - 1000L);
            }
          }
        }
        else
        {
          l2 = ab.aF(l3, ((z)localObject2).field_createTime / 1000L);
          l3 = -1L + l3;
          ((z)localObject2).field_hasShow = 1;
          ((z)localObject2).field_status = 4;
          ((z)localObject2).iF(2);
          ((z)localObject2).field_orderFlag = (l2 | l3 << 32 | l1 << 24 & 0xFF000000);
          ab.E((z)localObject2);
          paramMap = ag.ban();
          if (localege.MOD == 2) {
            break label766;
          }
          bool = true;
          bool = paramMap.b((z)localObject2, bool);
          Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] postInsertCanvasCard result = " + bool + ", redDotFlag = " + localege.MOD + ", orderFlag = " + ((z)localObject2).field_orderFlag);
          if (bool)
          {
            paramMap = r.NPl;
            if (r.gzP()) {
              m.IAG.fWS();
            }
            r.NPl.z((z)localObject2);
            paramMap = com.tencent.mm.plugin.webcanvas.l.IAx;
            com.tencent.mm.plugin.webcanvas.l.LV(82L);
            paramMap = s.NPC;
            i = localege.pos;
            j = localege.Ngb;
            k = localege.style;
            l1 = localege.MOC;
            paramMap = localege.Ngc;
            if (paramMap == null) {
              break label772;
            }
            paramMap = paramMap.cardId;
            label702:
            localObject1 = localege.Nga;
            if (localObject1 == null) {
              break label777;
            }
          }
        }
      }
    }
    label772:
    label777:
    for (localObject1 = ((ale)localObject1).KUo;; localObject1 = null)
    {
      s.a((z)localObject2, 2, i, j, k, l1, paramMap, (String)localObject1, localege.dSJ);
      AppMethodBeat.o(212651);
      return;
      l2 = ab.aE(l3, ((z)localObject2).field_createTime / 1000L);
      break;
      label766:
      bool = false;
      break label556;
      paramMap = null;
      break label702;
    }
  }
  
  public static final String[] bjc(String paramString)
  {
    AppMethodBeat.i(212655);
    p.h(paramString, "$this$getMidAndIdx");
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
    AppMethodBeat.o(212655);
    return arrayOfString;
  }
  
  public static final z f(ege paramege)
  {
    AppMethodBeat.i(212650);
    p.h(paramege, "wrapper");
    if (!b(paramege, null))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately illegal");
      AppMethodBeat.o(212650);
      return null;
    }
    if (g(paramege))
    {
      AppMethodBeat.o(212650);
      return null;
    }
    Object localObject1 = ag.ban();
    p.g(localObject1, "SubCoreBiz.getBizTimeLineInfoStorage()");
    localObject1 = ((aa)localObject1).gAM();
    long l1;
    z localz;
    long l2;
    label254:
    int i;
    int j;
    int k;
    if (paramege.Ngb == 1) {
      if (Math.abs(paramege.MOC * 1000L - bp.aVP()) <= 86400000L)
      {
        l1 = paramege.MOC * 1000L;
        localz = new z();
        localz.field_msgId = ag.ban().gAW();
        localz.field_msgSvrId = 0L;
        localz.field_type = 620757041;
        localz.field_talker = "";
        localz.field_talkerId = 0;
        localz.field_createTime = l1;
        localz.nc(1);
        localz.field_status = 3;
        a(localz, paramege);
        localz.c(paramege);
        localObject2 = ag.ban();
        p.g(localObject2, "SubCoreBiz.getBizTimeLineInfoStorage()");
        long l3 = ((aa)localObject2).gAo();
        l2 = 0L;
        l1 = l2;
        if (localObject1 != null)
        {
          if (paramege.Ngc.weight < 0) {
            break label595;
          }
          l1 = Math.min(paramege.Ngc.weight, ab.Na(((z)localObject1).field_orderFlag));
        }
        long l4 = ab.aE(l3, localz.field_createTime / 1000L);
        l2 = l4;
        if (l4 >= 4294967296L)
        {
          Log.w("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately serialNumber is too big %d", new Object[] { Long.valueOf(l4) });
          l3 = ag.ban().gAT();
          l2 = ab.aE(l3, localz.field_createTime / 1000L);
        }
        localz.field_orderFlag = (l2 | l3 << 32 | 0xFF000000 & l1 << 24);
        ab.E(localz);
        boolean bool = ag.ban().B(localz);
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] insertCanvasCardImmediately result = " + bool + ", title = " + paramege.Ngc.title);
        if (bool)
        {
          localObject1 = r.NPl;
          if (r.gzP()) {
            m.IAG.fWS();
          }
          r.NPl.z(localz);
          localObject1 = ad.NRn;
          if (ad.gBk())
          {
            localObject1 = ad.NRn;
            ad.aka(ab.NQN);
          }
        }
        localObject1 = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.LV(82L);
        localObject1 = s.NPC;
        i = paramege.pos;
        j = paramege.Ngb;
        k = paramege.style;
        l1 = paramege.MOC;
        localObject1 = paramege.Ngc;
        if (localObject1 == null) {
          break label669;
        }
        localObject1 = ((dkp)localObject1).cardId;
        label514:
        localObject2 = paramege.Nga;
        if (localObject2 == null) {
          break label675;
        }
      }
    }
    label669:
    label675:
    for (Object localObject2 = ((ale)localObject2).KUo;; localObject2 = null)
    {
      s.a(localz, 1, i, j, k, l1, (String)localObject1, (String)localObject2, paramege.dSJ);
      AppMethodBeat.o(212650);
      return localz;
      l1 = bp.aVP();
      break;
      localObject2 = ag.ban();
      p.g(localObject2, "SubCoreBiz.getBizTimeLineInfoStorage()");
      l1 = ((aa)localObject2).gAO() + 1000L;
      break;
      label595:
      if (paramege.Ngc.pos == 0)
      {
        l1 = ab.Na(((z)localObject1).field_orderFlag);
        break label254;
      }
      localObject1 = ag.ban().ajV(paramege.Ngc.pos - 1);
      if (localObject1 == null)
      {
        Log.w("MicroMsg.BizTimeLineStorageLogicExKt", "insertCanvasCardImmediately lastTimeLineInfo is null");
        l1 = l2;
        break label254;
      }
      l1 = ab.Na(((z)localObject1).field_orderFlag);
      break label254;
      localObject1 = null;
      break label514;
    }
  }
  
  public static final boolean g(ege paramege)
  {
    aa localaa2 = null;
    aa localaa1 = null;
    AppMethodBeat.i(212653);
    p.h(paramege, "$this$duplicateCardId");
    switch (paramege.style)
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(212653);
        return false;
        localaa2 = ag.ban();
        localObject = paramege.Nga;
        paramege = localaa1;
        if (localObject != null) {
          paramege = ((ale)localObject).KUk;
        }
      } while (localaa2.biY(paramege) == null);
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] duplicateCardId");
      AppMethodBeat.o(212653);
      return true;
      localaa1 = ag.ban();
      Object localObject = paramege.Ngc;
      paramege = localaa2;
      if (localObject != null) {
        paramege = ((dkp)localObject).cardId;
      }
    } while (localaa1.biY(paramege) == null);
    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] canvas duplicateCardId");
    AppMethodBeat.o(212653);
    return true;
  }
  
  public static final boolean gBp()
  {
    AppMethodBeat.i(212647);
    r localr = r.NPl;
    if (!r.gzM())
    {
      AppMethodBeat.o(212647);
      return false;
    }
    if ((!g.aAc()) || (!((b)g.af(b.class)).CT(1001)))
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] onBizRecommendExpt style = %s not support", new Object[] { Integer.valueOf(1001) });
      AppMethodBeat.o(212647);
      return false;
    }
    AppMethodBeat.o(212647);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.af
 * JD-Core Version:    0.7.0.1
 */