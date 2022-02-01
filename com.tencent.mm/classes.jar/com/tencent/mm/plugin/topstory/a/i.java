package com.tencent.mm.plugin.topstory.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.protocal.protobuf.dcx;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class i
{
  public static void Pd(int paramInt)
  {
    AppMethodBeat.i(90994);
    switch (paramInt)
    {
    default: 
      b.lI(b.qHt);
    }
    for (;;)
    {
      a.lI(7);
      AppMethodBeat.o(90994);
      return;
      b.lI(b.qHg);
      continue;
      b.lI(b.qHh);
      continue;
      b.lI(b.qHi);
      continue;
      b.lI(b.qHj);
      continue;
      b.lI(b.qHk);
      continue;
      b.lI(b.qHl);
      continue;
      b.lI(b.qHm);
      continue;
      b.lI(b.qHn);
      continue;
      b.lI(b.qHo);
      continue;
      b.lI(b.qHp);
      continue;
      b.lI(b.qHq);
      continue;
      b.lI(b.qHr);
      continue;
      b.lI(b.qHs);
    }
  }
  
  public static void a(dcn paramdcn, String paramString, long paramLong)
  {
    AppMethodBeat.i(90992);
    if ((paramdcn.EtT.size() > 0) && ("clickTopStory".equals(((dcx)paramdcn.EtT.get(0)).name))) {}
    for (long l = paramLong - ((dcx)paramdcn.EtT.get(0)).timestamp;; l = 0L)
    {
      int i = aa.Sb(1);
      paramdcn = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramdcn.scene), paramdcn.qwV, paramdcn.sessionId, Integer.valueOf(i), paramString, Long.valueOf(paramLong), Integer.valueOf(paramdcn.yMc), Integer.valueOf(paramdcn.EtU), paramdcn.qGK, Long.valueOf(l), paramdcn.EtW });
      ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomeUIAction 15466 %s", new Object[] { paramdcn });
      h.vKh.kvStat(15466, paramdcn);
      AppMethodBeat.o(90992);
      return;
    }
  }
  
  public static final void a(dcy paramdcy, long paramLong, ddb paramddb)
  {
    AppMethodBeat.i(90997);
    int i;
    long l;
    if (paramLong > 0L)
    {
      i = paramdcy.scene;
      paramLong /= 1000L;
      l = paramdcy.Euy;
      if (paramddb == null) {
        break label156;
      }
    }
    label156:
    for (paramddb = paramddb.EuP;; paramddb = paramdcy.Euv)
    {
      paramdcy = String.format("videoflowbrowsereport=1&scene=%s&staytime=%s&channelid=%s&pageid=%s&nettype=%s&source=%s&expand=%s&searchid=%s", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Integer.valueOf(3), "", Integer.valueOf(2), paramddb, paramdcy.jko });
      ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoPageBrowseTime 15018 %s", new Object[] { paramdcy });
      paramddb = new ckd();
      paramddb.Eff = paramdcy;
      paramdcy = new com.tencent.mm.plugin.websearch.api.w(paramddb);
      g.aeS().a(paramdcy, 0);
      AppMethodBeat.o(90997);
      return;
    }
  }
  
  public static final void a(dcy paramdcy, ddb paramddb, int paramInt)
  {
    AppMethodBeat.i(177107);
    ckd localckd = new ckd();
    localckd.Eff = String.format("logname=videopoint&scene=%s&docid=%s&searchid=%s&vid=%s&actiontype=%s&itemtype=%s", new Object[] { Integer.valueOf(paramdcy.scene), paramddb.roQ, paramdcy.jko, paramddb.rNP, Integer.valueOf(paramInt), Integer.valueOf(paramddb.EuQ) });
    ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportVideoPointAction %s", new Object[] { localckd.Eff });
    paramdcy = new s(localckd);
    g.aeS().a(paramdcy, 0);
    AppMethodBeat.o(177107);
  }
  
  public static void a(dcy paramdcy, ddb paramddb, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(90991);
    paramdcy = String.format("videosharereport=1&scene=%s&searchid=%s&docid=%s&cdnsourcetype=%s&videoid=%s&optype=%s&fromuser=%s&touser=%s&channelid=%s&optypes=%s&expand=%s", new Object[] { Integer.valueOf(paramdcy.scene), paramdcy.jko, paramddb.roQ, Integer.valueOf(paramddb.Eva), paramddb.rNP, Integer.valueOf(0), paramString2, paramString3, Long.valueOf(paramdcy.Euy), paramString1, paramddb.EuP });
    ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare 15035 %s", new Object[] { paramdcy });
    paramddb = new ckd();
    paramddb.Eff = paramdcy;
    ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare:".concat(String.valueOf(paramdcy)));
    paramdcy = new com.tencent.mm.plugin.websearch.api.w(paramddb);
    g.aeS().a(paramdcy, 0);
    AppMethodBeat.o(90991);
  }
  
  public static void a(dcy paramdcy, ddb paramddb, Set<ahk> paramSet, int paramInt)
  {
    AppMethodBeat.i(90996);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("isfeedback=1");
    localStringBuffer.append("&feedtype=0");
    localStringBuffer.append("&businesstype=2");
    localStringBuffer.append("&itemtype=");
    localStringBuffer.append(paramddb.EuQ);
    localStringBuffer.append("&scene=");
    localStringBuffer.append(paramdcy.scene);
    localStringBuffer.append("&searchid=");
    localStringBuffer.append(paramdcy.jko);
    localStringBuffer.append("&clicktime=");
    localStringBuffer.append(System.currentTimeMillis());
    localStringBuffer.append("&docid=");
    localStringBuffer.append(paramddb.roQ);
    localStringBuffer.append("&docpos=");
    localStringBuffer.append(paramInt);
    localStringBuffer.append("&reasonid=");
    Object localObject = paramSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuffer.append(((ahk)((Iterator)localObject).next()).id);
      localStringBuffer.append("#");
    }
    localStringBuffer.append("&reasonwording=");
    localObject = new StringBuffer();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ((StringBuffer)localObject).append(((ahk)paramSet.next()).doh);
      ((StringBuffer)localObject).append("#");
    }
    try
    {
      localStringBuffer.append(p.encode(((StringBuffer)localObject).toString(), "utf8"));
      label291:
      localStringBuffer.append("&offset=");
      localStringBuffer.append(paramInt);
      localStringBuffer.append("&sessionid=");
      localStringBuffer.append(aa.RY(paramdcy.scene));
      localStringBuffer.append("&reserveexpand=");
      localStringBuffer.append(paramddb.EuR);
      ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportFeedBackClick %s", new Object[] { localStringBuffer.toString() });
      paramdcy = new ckd();
      paramdcy.Eff = localStringBuffer.toString();
      paramdcy = new com.tencent.mm.plugin.websearch.api.w(paramdcy);
      g.aeS().a(paramdcy, 0);
      AppMethodBeat.o(90996);
      return;
    }
    catch (UnsupportedEncodingException paramSet)
    {
      break label291;
    }
  }
  
  public static void a(ddb paramddb, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(90995);
    int i;
    if (ay.isWifi(aj.getContext()))
    {
      i = 2;
      if (paramddb == null) {
        break label122;
      }
    }
    label122:
    for (paramddb = paramddb.roQ;; paramddb = "")
    {
      paramddb = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt1), paramString, paramddb, Integer.valueOf(i), Integer.valueOf(paramInt2) });
      ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryVideoPlayError %s", new Object[] { paramddb });
      e.vIY.kvStat(15248, paramddb);
      AppMethodBeat.o(90995);
      return;
      if (!ay.isConnected(aj.getContext()))
      {
        i = 1;
        break;
      }
      i = 3;
      break;
    }
  }
  
  public static void a(dsx paramdsx, bl parambl)
  {
    AppMethodBeat.i(90993);
    Object localObject1;
    Object localObject2;
    int i;
    if (com.tencent.mm.model.w.pF(parambl.field_talker)) {
      if (parambl.field_isSend == 1)
      {
        localObject1 = u.aqG();
        localObject2 = parambl.field_talker;
        i = 2;
        parambl = (bl)localObject1;
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append("isShareClick=1");
        ((StringBuffer)localObject1).append("&relevant_vid=");
        ((StringBuffer)localObject1).append(paramdsx.AGs);
        ((StringBuffer)localObject1).append("&relevant_pre_searchid=");
        ((StringBuffer)localObject1).append(paramdsx.AGu);
        ((StringBuffer)localObject1).append("&relevant_shared_openid=");
        ((StringBuffer)localObject1).append(paramdsx.AGv);
        ((StringBuffer)localObject1).append("&rec_category=");
        if (paramdsx.AGE <= 0L) {
          break label320;
        }
        ((StringBuffer)localObject1).append(paramdsx.AGE);
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject1).append("&source=");
      ((StringBuffer)localObject1).append(paramdsx.source);
      ((StringBuffer)localObject1).append("&fromUser=");
      ((StringBuffer)localObject1).append(parambl);
      ((StringBuffer)localObject1).append("&fromScene=");
      ((StringBuffer)localObject1).append(i);
      ((StringBuffer)localObject1).append("&targetInfo=");
      ((StringBuffer)localObject1).append((String)localObject2);
      ((StringBuffer)localObject1).append("&expand=");
      ((StringBuffer)localObject1).append(paramdsx.AGt);
      ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject1).toString() });
      paramdsx = new ckd();
      paramdsx.Eff = ((StringBuffer)localObject1).toString();
      paramdsx = new com.tencent.mm.plugin.websearch.api.w(paramdsx);
      g.aeS().a(paramdsx, 0);
      AppMethodBeat.o(90993);
      return;
      localObject1 = bi.uf(parambl.field_content);
      break;
      if (parambl.field_isSend == 1)
      {
        localObject2 = u.aqG();
        localObject1 = parambl.field_talker;
        parambl = (bl)localObject2;
      }
      for (;;)
      {
        i = 1;
        localObject2 = localObject1;
        break;
        parambl = parambl.field_talker;
        localObject1 = u.aqG();
      }
      label320:
      ((StringBuffer)localObject1).append(paramdsx.AGw);
    }
  }
  
  public static final void asz(String paramString)
  {
    AppMethodBeat.i(190939);
    ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryWebViewVisitTime %s", new Object[] { paramString });
    ckd localckd = new ckd();
    localckd.Eff = paramString;
    paramString = new com.tencent.mm.plugin.websearch.api.w(localckd);
    g.aeS().a(paramString, 0);
    AppMethodBeat.o(190939);
  }
  
  public static final void c(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(90999);
    if ((!bt.isNullOrNil(paramString1)) && (paramString1.startsWith("wrd"))) {
      try
      {
        paramString1 = String.format("%s,%s,%s,%s", new Object[] { p.encode(paramString2, "utf8"), Integer.valueOf(paramInt), paramString1, Long.valueOf(paramLong) });
        ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "kvReportTopStoryOpenWebViewError 15728 %s", new Object[] { paramString1 });
        h.vKh.kvStat(15728, paramString1);
        AppMethodBeat.o(90999);
        return;
      }
      catch (UnsupportedEncodingException paramString1) {}
    }
    AppMethodBeat.o(90999);
  }
  
  public static final void eI(String paramString, int paramInt)
  {
    AppMethodBeat.i(90998);
    if ((!bt.isNullOrNil(paramString)) && (paramString.startsWith("wrd"))) {
      h.vKh.idkeyStat(900L, paramInt, 1L, false);
    }
    AppMethodBeat.o(90998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.i
 * JD-Core Version:    0.7.0.1
 */