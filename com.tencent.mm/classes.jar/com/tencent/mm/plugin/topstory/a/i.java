package com.tencent.mm.plugin.topstory.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.aij;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.dik;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class i
{
  public static void Rj(int paramInt)
  {
    AppMethodBeat.i(90994);
    switch (paramInt)
    {
    default: 
      b.lA(b.rAo);
    }
    for (;;)
    {
      a.lA(7);
      AppMethodBeat.o(90994);
      return;
      b.lA(b.rAb);
      continue;
      b.lA(b.rAc);
      continue;
      b.lA(b.rAd);
      continue;
      b.lA(b.rAe);
      continue;
      b.lA(b.rAf);
      continue;
      b.lA(b.rAg);
      continue;
      b.lA(b.rAh);
      continue;
      b.lA(b.rAi);
      continue;
      b.lA(b.rAj);
      continue;
      b.lA(b.rAk);
      continue;
      b.lA(b.rAl);
      continue;
      b.lA(b.rAm);
      continue;
      b.lA(b.rAn);
    }
  }
  
  public static void a(dia paramdia, String paramString, long paramLong)
  {
    AppMethodBeat.i(90992);
    if ((paramdia.FQV.size() > 0) && ("clickTopStory".equals(((dik)paramdia.FQV.get(0)).name))) {}
    for (long l = paramLong - ((dik)paramdia.FQV.get(0)).timestamp;; l = 0L)
    {
      int i = z.Ul(1);
      paramdia = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramdia.scene), paramdia.qox, paramdia.sessionId, Integer.valueOf(i), paramString, Long.valueOf(paramLong), Integer.valueOf(paramdia.zZU), Integer.valueOf(paramdia.FQW), paramdia.rzt, Long.valueOf(l), paramdia.FQX });
      ac.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomeUIAction 15466 %s", new Object[] { paramdia });
      h.wUl.kvStat(15466, paramdia);
      AppMethodBeat.o(90992);
      return;
    }
  }
  
  public static final void a(dil paramdil, long paramLong, dio paramdio)
  {
    AppMethodBeat.i(90997);
    int i;
    long l;
    if (paramLong > 0L)
    {
      i = paramdil.scene;
      paramLong /= 1000L;
      l = paramdil.FRz;
      if (paramdio == null) {
        break label156;
      }
    }
    label156:
    for (paramdio = paramdio.FRQ;; paramdio = paramdil.FRw)
    {
      paramdil = String.format("videoflowbrowsereport=1&scene=%s&staytime=%s&channelid=%s&pageid=%s&nettype=%s&source=%s&expand=%s&searchid=%s", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Integer.valueOf(3), "", Integer.valueOf(2), paramdio, paramdil.jKB });
      ac.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoPageBrowseTime 15018 %s", new Object[] { paramdil });
      paramdio = new cpk();
      paramdio.FCf = paramdil;
      paramdil = new v(paramdio);
      g.agi().a(paramdil, 0);
      AppMethodBeat.o(90997);
      return;
    }
  }
  
  public static final void a(dil paramdil, dio paramdio, int paramInt)
  {
    AppMethodBeat.i(177107);
    cpk localcpk = new cpk();
    localcpk.FCf = String.format("logname=videopoint&scene=%s&docid=%s&searchid=%s&vid=%s&actiontype=%s&itemtype=%s", new Object[] { Integer.valueOf(paramdil.scene), paramdio.sxK, paramdil.jKB, paramdio.sVF, Integer.valueOf(paramInt), Integer.valueOf(paramdio.FRR) });
    ac.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportVideoPointAction %s", new Object[] { localcpk.FCf });
    paramdil = new r(localcpk);
    g.agi().a(paramdil, 0);
    AppMethodBeat.o(177107);
  }
  
  public static void a(dil paramdil, dio paramdio, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(90991);
    paramdil = String.format("videosharereport=1&scene=%s&searchid=%s&docid=%s&cdnsourcetype=%s&videoid=%s&optype=%s&fromuser=%s&touser=%s&channelid=%s&optypes=%s&expand=%s", new Object[] { Integer.valueOf(paramdil.scene), paramdil.jKB, paramdio.sxK, Integer.valueOf(paramdio.FSb), paramdio.sVF, Integer.valueOf(0), paramString2, paramString3, Long.valueOf(paramdil.FRz), paramString1, paramdio.FRQ });
    ac.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare 15035 %s", new Object[] { paramdil });
    paramdio = new cpk();
    paramdio.FCf = paramdil;
    ac.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare:".concat(String.valueOf(paramdil)));
    paramdil = new v(paramdio);
    g.agi().a(paramdil, 0);
    AppMethodBeat.o(90991);
  }
  
  public static void a(dil paramdil, dio paramdio, Set<aij> paramSet, int paramInt)
  {
    AppMethodBeat.i(90996);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("isfeedback=1");
    localStringBuffer.append("&feedtype=0");
    localStringBuffer.append("&businesstype=2");
    localStringBuffer.append("&itemtype=");
    localStringBuffer.append(paramdio.FRR);
    localStringBuffer.append("&scene=");
    localStringBuffer.append(paramdil.scene);
    localStringBuffer.append("&searchid=");
    localStringBuffer.append(paramdil.jKB);
    localStringBuffer.append("&clicktime=");
    localStringBuffer.append(System.currentTimeMillis());
    localStringBuffer.append("&docid=");
    localStringBuffer.append(paramdio.sxK);
    localStringBuffer.append("&docpos=");
    localStringBuffer.append(paramInt);
    localStringBuffer.append("&reasonid=");
    Object localObject = paramSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuffer.append(((aij)((Iterator)localObject).next()).id);
      localStringBuffer.append("#");
    }
    localStringBuffer.append("&reasonwording=");
    localObject = new StringBuffer();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ((StringBuffer)localObject).append(((aij)paramSet.next()).dlQ);
      ((StringBuffer)localObject).append("#");
    }
    try
    {
      localStringBuffer.append(p.encode(((StringBuffer)localObject).toString(), "utf8"));
      label291:
      localStringBuffer.append("&offset=");
      localStringBuffer.append(paramInt);
      localStringBuffer.append("&sessionid=");
      localStringBuffer.append(z.Ui(paramdil.scene));
      localStringBuffer.append("&reserveexpand=");
      localStringBuffer.append(paramdio.FRS);
      ac.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportFeedBackClick %s", new Object[] { localStringBuffer.toString() });
      paramdil = new cpk();
      paramdil.FCf = localStringBuffer.toString();
      paramdil = new v(paramdil);
      g.agi().a(paramdil, 0);
      AppMethodBeat.o(90996);
      return;
    }
    catch (UnsupportedEncodingException paramSet)
    {
      break label291;
    }
  }
  
  public static void a(dio paramdio, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(90995);
    int i;
    if (ax.isWifi(ai.getContext()))
    {
      i = 2;
      if (paramdio == null) {
        break label122;
      }
    }
    label122:
    for (paramdio = paramdio.sxK;; paramdio = "")
    {
      paramdio = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt1), paramString, paramdio, Integer.valueOf(i), Integer.valueOf(paramInt2) });
      ac.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryVideoPlayError %s", new Object[] { paramdio });
      e.wTc.kvStat(15248, paramdio);
      AppMethodBeat.o(90995);
      return;
      if (!ax.isConnected(ai.getContext()))
      {
        i = 1;
        break;
      }
      i = 3;
      break;
    }
  }
  
  public static void a(dyo paramdyo, bo parambo)
  {
    AppMethodBeat.i(90993);
    Object localObject1;
    Object localObject2;
    int i;
    if (w.sQ(parambo.field_talker)) {
      if (parambo.field_isSend == 1)
      {
        localObject1 = u.axw();
        localObject2 = parambo.field_talker;
        i = 2;
        parambo = (bo)localObject1;
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append("isShareClick=1");
        ((StringBuffer)localObject1).append("&relevant_vid=");
        ((StringBuffer)localObject1).append(paramdyo.BYK);
        ((StringBuffer)localObject1).append("&relevant_pre_searchid=");
        ((StringBuffer)localObject1).append(paramdyo.BYM);
        ((StringBuffer)localObject1).append("&relevant_shared_openid=");
        ((StringBuffer)localObject1).append(paramdyo.BYN);
        ((StringBuffer)localObject1).append("&rec_category=");
        if (paramdyo.BYW <= 0L) {
          break label320;
        }
        ((StringBuffer)localObject1).append(paramdyo.BYW);
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject1).append("&source=");
      ((StringBuffer)localObject1).append(paramdyo.source);
      ((StringBuffer)localObject1).append("&fromUser=");
      ((StringBuffer)localObject1).append(parambo);
      ((StringBuffer)localObject1).append("&fromScene=");
      ((StringBuffer)localObject1).append(i);
      ((StringBuffer)localObject1).append("&targetInfo=");
      ((StringBuffer)localObject1).append((String)localObject2);
      ((StringBuffer)localObject1).append("&expand=");
      ((StringBuffer)localObject1).append(paramdyo.BYL);
      ac.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject1).toString() });
      paramdyo = new cpk();
      paramdyo.FCf = ((StringBuffer)localObject1).toString();
      paramdyo = new v(paramdyo);
      g.agi().a(paramdyo, 0);
      AppMethodBeat.o(90993);
      return;
      localObject1 = bi.yl(parambo.field_content);
      break;
      if (parambo.field_isSend == 1)
      {
        localObject2 = u.axw();
        localObject1 = parambo.field_talker;
        parambo = (bo)localObject2;
      }
      for (;;)
      {
        i = 1;
        localObject2 = localObject1;
        break;
        parambo = parambo.field_talker;
        localObject1 = u.axw();
      }
      label320:
      ((StringBuffer)localObject1).append(paramdyo.BYO);
    }
  }
  
  public static final void axI(String paramString)
  {
    AppMethodBeat.i(206851);
    ac.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryWebViewVisitTime %s", new Object[] { paramString });
    cpk localcpk = new cpk();
    localcpk.FCf = paramString;
    paramString = new v(localcpk);
    g.agi().a(paramString, 0);
    AppMethodBeat.o(206851);
  }
  
  public static final void c(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(90999);
    if ((!bs.isNullOrNil(paramString1)) && (paramString1.startsWith("wrd"))) {
      try
      {
        paramString1 = String.format("%s,%s,%s,%s", new Object[] { p.encode(paramString2, "utf8"), Integer.valueOf(paramInt), paramString1, Long.valueOf(paramLong) });
        ac.i("MicroMsg.TopStory.TopStoryReportApiLogic", "kvReportTopStoryOpenWebViewError 15728 %s", new Object[] { paramString1 });
        h.wUl.kvStat(15728, paramString1);
        AppMethodBeat.o(90999);
        return;
      }
      catch (UnsupportedEncodingException paramString1) {}
    }
    AppMethodBeat.o(90999);
  }
  
  public static final void eQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(90998);
    if ((!bs.isNullOrNil(paramString)) && (paramString.startsWith("wrd"))) {
      h.wUl.idkeyStat(900L, paramInt, 1L, false);
    }
    AppMethodBeat.o(90998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.i
 * JD-Core Version:    0.7.0.1
 */