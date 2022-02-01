package com.tencent.mm.plugin.topstory.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class i
{
  public static void TA(int paramInt)
  {
    AppMethodBeat.i(90994);
    switch (paramInt)
    {
    default: 
      b.md(b.sCj);
    }
    for (;;)
    {
      a.md(7);
      AppMethodBeat.o(90994);
      return;
      b.md(b.sBW);
      continue;
      b.md(b.sBX);
      continue;
      b.md(b.sBY);
      continue;
      b.md(b.sBZ);
      continue;
      b.md(b.sCa);
      continue;
      b.md(b.sCb);
      continue;
      b.md(b.sCc);
      continue;
      b.md(b.sCd);
      continue;
      b.md(b.sCe);
      continue;
      b.md(b.sCf);
      continue;
      b.md(b.sCg);
      continue;
      b.md(b.sCh);
      continue;
      b.md(b.sCi);
    }
  }
  
  public static void a(dom paramdom, String paramString, long paramLong)
  {
    AppMethodBeat.i(90992);
    if ((paramdom.HVo.size() > 0) && ("clickTopStory".equals(((dow)paramdom.HVo.get(0)).name))) {}
    for (long l = paramLong - ((dow)paramdom.HVo.get(0)).timestamp;; l = 0L)
    {
      int i = ad.WL(1);
      paramdom = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramdom.scene), paramdom.rfA, paramdom.sessionId, Integer.valueOf(i), paramString, Long.valueOf(paramLong), Integer.valueOf(paramdom.BJf), Integer.valueOf(paramdom.HVp), paramdom.sBn, Long.valueOf(l), paramdom.HVq });
      ae.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomeUIAction 15466 %s", new Object[] { paramdom });
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(15466, paramdom);
      AppMethodBeat.o(90992);
      return;
    }
  }
  
  public static final void a(dox paramdox, long paramLong, dpa paramdpa)
  {
    AppMethodBeat.i(90997);
    int i;
    long l;
    if (paramLong > 0L)
    {
      i = paramdox.scene;
      paramLong /= 1000L;
      l = paramdox.HVS;
      if (paramdpa == null) {
        break label156;
      }
    }
    label156:
    for (paramdpa = paramdpa.HWj;; paramdpa = paramdox.HVP)
    {
      paramdox = String.format("videoflowbrowsereport=1&scene=%s&staytime=%s&channelid=%s&pageid=%s&nettype=%s&source=%s&expand=%s&searchid=%s", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Integer.valueOf(3), "", Integer.valueOf(2), paramdpa, paramdox.kid });
      ae.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoPageBrowseTime 15018 %s", new Object[] { paramdox });
      paramdpa = new cvj();
      paramdpa.HFU = paramdox;
      paramdox = new z(paramdpa);
      com.tencent.mm.kernel.g.ajj().a(paramdox, 0);
      AppMethodBeat.o(90997);
      return;
    }
  }
  
  public static final void a(dox paramdox, dpa paramdpa, int paramInt)
  {
    AppMethodBeat.i(177107);
    cvj localcvj = new cvj();
    localcvj.HFU = String.format("logname=videopoint&scene=%s&docid=%s&searchid=%s&vid=%s&actiontype=%s&itemtype=%s", new Object[] { Integer.valueOf(paramdox.scene), paramdpa.tFc, paramdox.kid, paramdpa.udb, Integer.valueOf(paramInt), Integer.valueOf(paramdpa.HWk) });
    ae.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportVideoPointAction %s", new Object[] { localcvj.HFU });
    paramdox = new u(localcvj);
    com.tencent.mm.kernel.g.ajj().a(paramdox, 0);
    AppMethodBeat.o(177107);
  }
  
  public static void a(dox paramdox, dpa paramdpa, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(90991);
    paramdox = String.format("videosharereport=1&scene=%s&searchid=%s&docid=%s&cdnsourcetype=%s&videoid=%s&optype=%s&fromuser=%s&touser=%s&channelid=%s&optypes=%s&expand=%s", new Object[] { Integer.valueOf(paramdox.scene), paramdox.kid, paramdpa.tFc, Integer.valueOf(paramdpa.HWu), paramdpa.udb, Integer.valueOf(0), paramString2, paramString3, Long.valueOf(paramdox.HVS), paramString1, paramdpa.HWj });
    ae.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare 15035 %s", new Object[] { paramdox });
    paramdpa = new cvj();
    paramdpa.HFU = paramdox;
    ae.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare:".concat(String.valueOf(paramdox)));
    paramdox = new z(paramdpa);
    com.tencent.mm.kernel.g.ajj().a(paramdox, 0);
    AppMethodBeat.o(90991);
  }
  
  public static void a(dox paramdox, dpa paramdpa, Set<alj> paramSet, int paramInt)
  {
    AppMethodBeat.i(90996);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("isfeedback=1");
    localStringBuffer.append("&feedtype=0");
    localStringBuffer.append("&businesstype=2");
    localStringBuffer.append("&itemtype=");
    localStringBuffer.append(paramdpa.HWk);
    localStringBuffer.append("&scene=");
    localStringBuffer.append(paramdox.scene);
    localStringBuffer.append("&searchid=");
    localStringBuffer.append(paramdox.kid);
    localStringBuffer.append("&clicktime=");
    localStringBuffer.append(System.currentTimeMillis());
    localStringBuffer.append("&docid=");
    localStringBuffer.append(paramdpa.tFc);
    localStringBuffer.append("&docpos=");
    localStringBuffer.append(paramInt);
    localStringBuffer.append("&reasonid=");
    Object localObject = paramSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuffer.append(((alj)((Iterator)localObject).next()).id);
      localStringBuffer.append("#");
    }
    localStringBuffer.append("&reasonwording=");
    localObject = new StringBuffer();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ((StringBuffer)localObject).append(((alj)paramSet.next()).dyI);
      ((StringBuffer)localObject).append("#");
    }
    try
    {
      localStringBuffer.append(com.tencent.mm.compatible.util.q.encode(((StringBuffer)localObject).toString(), "utf8"));
      label291:
      localStringBuffer.append("&offset=");
      localStringBuffer.append(paramInt);
      localStringBuffer.append("&sessionid=");
      localStringBuffer.append(ad.WI(paramdox.scene));
      localStringBuffer.append("&reserveexpand=");
      localStringBuffer.append(paramdpa.HWl);
      ae.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportFeedBackClick %s", new Object[] { localStringBuffer.toString() });
      paramdox = new cvj();
      paramdox.HFU = localStringBuffer.toString();
      paramdox = new z(paramdox);
      com.tencent.mm.kernel.g.ajj().a(paramdox, 0);
      AppMethodBeat.o(90996);
      return;
    }
    catch (UnsupportedEncodingException paramSet)
    {
      break label291;
    }
  }
  
  public static void a(dpa paramdpa, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(90995);
    int i;
    if (az.isWifi(ak.getContext()))
    {
      i = 2;
      if (paramdpa == null) {
        break label122;
      }
    }
    label122:
    for (paramdpa = paramdpa.tFc;; paramdpa = "")
    {
      paramdpa = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt1), paramString, paramdpa, Integer.valueOf(i), Integer.valueOf(paramInt2) });
      ae.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryVideoPlayError %s", new Object[] { paramdpa });
      e.ywz.kvStat(15248, paramdpa);
      AppMethodBeat.o(90995);
      return;
      if (!az.isConnected(ak.getContext()))
      {
        i = 1;
        break;
      }
      i = 3;
      break;
    }
  }
  
  public static void a(egh paramegh, bv parambv)
  {
    AppMethodBeat.i(90993);
    Object localObject1;
    Object localObject2;
    int i;
    if (x.wb(parambv.field_talker)) {
      if (parambv.field_isSend == 1)
      {
        localObject1 = v.aAC();
        localObject2 = parambv.field_talker;
        i = 2;
        parambv = (bv)localObject1;
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append("isShareClick=1");
        ((StringBuffer)localObject1).append("&relevant_vid=");
        ((StringBuffer)localObject1).append(paramegh.DTD);
        ((StringBuffer)localObject1).append("&relevant_pre_searchid=");
        ((StringBuffer)localObject1).append(paramegh.DTF);
        ((StringBuffer)localObject1).append("&relevant_shared_openid=");
        ((StringBuffer)localObject1).append(paramegh.DTG);
        ((StringBuffer)localObject1).append("&rec_category=");
        if (paramegh.DTP <= 0L) {
          break label320;
        }
        ((StringBuffer)localObject1).append(paramegh.DTP);
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject1).append("&source=");
      ((StringBuffer)localObject1).append(paramegh.source);
      ((StringBuffer)localObject1).append("&fromUser=");
      ((StringBuffer)localObject1).append(parambv);
      ((StringBuffer)localObject1).append("&fromScene=");
      ((StringBuffer)localObject1).append(i);
      ((StringBuffer)localObject1).append("&targetInfo=");
      ((StringBuffer)localObject1).append((String)localObject2);
      ((StringBuffer)localObject1).append("&expand=");
      ((StringBuffer)localObject1).append(paramegh.DTE);
      ae.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject1).toString() });
      paramegh = new cvj();
      paramegh.HFU = ((StringBuffer)localObject1).toString();
      paramegh = new z(paramegh);
      com.tencent.mm.kernel.g.ajj().a(paramegh, 0);
      AppMethodBeat.o(90993);
      return;
      localObject1 = bl.BM(parambv.field_content);
      break;
      if (parambv.field_isSend == 1)
      {
        localObject2 = v.aAC();
        localObject1 = parambv.field_talker;
        parambv = (bv)localObject2;
      }
      for (;;)
      {
        i = 1;
        localObject2 = localObject1;
        break;
        parambv = parambv.field_talker;
        localObject1 = v.aAC();
      }
      label320:
      ((StringBuffer)localObject1).append(paramegh.DTH);
    }
  }
  
  public static final void aEg(String paramString)
  {
    AppMethodBeat.i(207662);
    ae.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryWebViewVisitTime %s", new Object[] { paramString });
    cvj localcvj = new cvj();
    localcvj.HFU = paramString;
    paramString = new z(localcvj);
    com.tencent.mm.kernel.g.ajj().a(paramString, 0);
    AppMethodBeat.o(207662);
  }
  
  public static final void fr(String paramString, int paramInt)
  {
    AppMethodBeat.i(90998);
    if ((!bu.isNullOrNil(paramString)) && (paramString.startsWith("wrd"))) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(900L, paramInt, 1L, false);
    }
    AppMethodBeat.o(90998);
  }
  
  public static final void g(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(90999);
    if ((!bu.isNullOrNil(paramString1)) && (paramString1.startsWith("wrd"))) {
      try
      {
        paramString1 = String.format("%s,%s,%s,%s", new Object[] { com.tencent.mm.compatible.util.q.encode(paramString2, "utf8"), Integer.valueOf(paramInt), paramString1, Long.valueOf(paramLong) });
        ae.i("MicroMsg.TopStory.TopStoryReportApiLogic", "kvReportTopStoryOpenWebViewError 15728 %s", new Object[] { paramString1 });
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(15728, paramString1);
        AppMethodBeat.o(90999);
        return;
      }
      catch (UnsupportedEncodingException paramString1) {}
    }
    AppMethodBeat.o(90999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.i
 * JD-Core Version:    0.7.0.1
 */