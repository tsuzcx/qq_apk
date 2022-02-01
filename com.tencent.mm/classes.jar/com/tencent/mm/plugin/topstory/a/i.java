package com.tencent.mm.plugin.topstory.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.dnp;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class i
{
  public static void ST(int paramInt)
  {
    AppMethodBeat.i(90994);
    switch (paramInt)
    {
    default: 
      b.ma(b.srZ);
    }
    for (;;)
    {
      a.ma(7);
      AppMethodBeat.o(90994);
      return;
      b.ma(b.srM);
      continue;
      b.ma(b.srN);
      continue;
      b.ma(b.srO);
      continue;
      b.ma(b.srP);
      continue;
      b.ma(b.srQ);
      continue;
      b.ma(b.srR);
      continue;
      b.ma(b.srS);
      continue;
      b.ma(b.srT);
      continue;
      b.ma(b.srU);
      continue;
      b.ma(b.srV);
      continue;
      b.ma(b.srW);
      continue;
      b.ma(b.srX);
      continue;
      b.ma(b.srY);
    }
  }
  
  public static void a(dnp paramdnp, String paramString, long paramLong)
  {
    AppMethodBeat.i(90992);
    if ((paramdnp.HBB.size() > 0) && ("clickTopStory".equals(((dnz)paramdnp.HBB.get(0)).name))) {}
    for (long l = paramLong - ((dnz)paramdnp.HBB.get(0)).timestamp;; l = 0L)
    {
      int i = com.tencent.mm.plugin.websearch.api.ad.We(1);
      paramdnp = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramdnp.scene), paramdnp.qXu, paramdnp.sessionId, Integer.valueOf(i), paramString, Long.valueOf(paramLong), Integer.valueOf(paramdnp.BrG), Integer.valueOf(paramdnp.HBC), paramdnp.srd, Long.valueOf(l), paramdnp.HBD });
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomeUIAction 15466 %s", new Object[] { paramdnp });
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(15466, paramdnp);
      AppMethodBeat.o(90992);
      return;
    }
  }
  
  public static final void a(doa paramdoa, long paramLong, dod paramdod)
  {
    AppMethodBeat.i(90997);
    int i;
    long l;
    if (paramLong > 0L)
    {
      i = paramdoa.scene;
      paramLong /= 1000L;
      l = paramdoa.HCf;
      if (paramdod == null) {
        break label156;
      }
    }
    label156:
    for (paramdod = paramdod.HCw;; paramdod = paramdoa.HCc)
    {
      paramdoa = String.format("videoflowbrowsereport=1&scene=%s&staytime=%s&channelid=%s&pageid=%s&nettype=%s&source=%s&expand=%s&searchid=%s", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Integer.valueOf(3), "", Integer.valueOf(2), paramdod, paramdoa.keN });
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoPageBrowseTime 15018 %s", new Object[] { paramdoa });
      paramdod = new cup();
      paramdod.Hmu = paramdoa;
      paramdoa = new z(paramdod);
      com.tencent.mm.kernel.g.aiU().a(paramdoa, 0);
      AppMethodBeat.o(90997);
      return;
    }
  }
  
  public static final void a(doa paramdoa, dod paramdod, int paramInt)
  {
    AppMethodBeat.i(177107);
    cup localcup = new cup();
    localcup.Hmu = String.format("logname=videopoint&scene=%s&docid=%s&searchid=%s&vid=%s&actiontype=%s&itemtype=%s", new Object[] { Integer.valueOf(paramdoa.scene), paramdod.tul, paramdoa.keN, paramdod.tSk, Integer.valueOf(paramInt), Integer.valueOf(paramdod.HCx) });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportVideoPointAction %s", new Object[] { localcup.Hmu });
    paramdoa = new com.tencent.mm.plugin.websearch.api.u(localcup);
    com.tencent.mm.kernel.g.aiU().a(paramdoa, 0);
    AppMethodBeat.o(177107);
  }
  
  public static void a(doa paramdoa, dod paramdod, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(90991);
    paramdoa = String.format("videosharereport=1&scene=%s&searchid=%s&docid=%s&cdnsourcetype=%s&videoid=%s&optype=%s&fromuser=%s&touser=%s&channelid=%s&optypes=%s&expand=%s", new Object[] { Integer.valueOf(paramdoa.scene), paramdoa.keN, paramdod.tul, Integer.valueOf(paramdod.HCH), paramdod.tSk, Integer.valueOf(0), paramString2, paramString3, Long.valueOf(paramdoa.HCf), paramString1, paramdod.HCw });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare 15035 %s", new Object[] { paramdoa });
    paramdod = new cup();
    paramdod.Hmu = paramdoa;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare:".concat(String.valueOf(paramdoa)));
    paramdoa = new z(paramdod);
    com.tencent.mm.kernel.g.aiU().a(paramdoa, 0);
    AppMethodBeat.o(90991);
  }
  
  public static void a(doa paramdoa, dod paramdod, Set<akz> paramSet, int paramInt)
  {
    AppMethodBeat.i(90996);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("isfeedback=1");
    localStringBuffer.append("&feedtype=0");
    localStringBuffer.append("&businesstype=2");
    localStringBuffer.append("&itemtype=");
    localStringBuffer.append(paramdod.HCx);
    localStringBuffer.append("&scene=");
    localStringBuffer.append(paramdoa.scene);
    localStringBuffer.append("&searchid=");
    localStringBuffer.append(paramdoa.keN);
    localStringBuffer.append("&clicktime=");
    localStringBuffer.append(System.currentTimeMillis());
    localStringBuffer.append("&docid=");
    localStringBuffer.append(paramdod.tul);
    localStringBuffer.append("&docpos=");
    localStringBuffer.append(paramInt);
    localStringBuffer.append("&reasonid=");
    Object localObject = paramSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuffer.append(((akz)((Iterator)localObject).next()).id);
      localStringBuffer.append("#");
    }
    localStringBuffer.append("&reasonwording=");
    localObject = new StringBuffer();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ((StringBuffer)localObject).append(((akz)paramSet.next()).dxD);
      ((StringBuffer)localObject).append("#");
    }
    try
    {
      localStringBuffer.append(com.tencent.mm.compatible.util.q.encode(((StringBuffer)localObject).toString(), "utf8"));
      label291:
      localStringBuffer.append("&offset=");
      localStringBuffer.append(paramInt);
      localStringBuffer.append("&sessionid=");
      localStringBuffer.append(com.tencent.mm.plugin.websearch.api.ad.Wb(paramdoa.scene));
      localStringBuffer.append("&reserveexpand=");
      localStringBuffer.append(paramdod.HCy);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportFeedBackClick %s", new Object[] { localStringBuffer.toString() });
      paramdoa = new cup();
      paramdoa.Hmu = localStringBuffer.toString();
      paramdoa = new z(paramdoa);
      com.tencent.mm.kernel.g.aiU().a(paramdoa, 0);
      AppMethodBeat.o(90996);
      return;
    }
    catch (UnsupportedEncodingException paramSet)
    {
      break label291;
    }
  }
  
  public static void a(dod paramdod, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(90995);
    int i;
    if (ay.isWifi(aj.getContext()))
    {
      i = 2;
      if (paramdod == null) {
        break label122;
      }
    }
    label122:
    for (paramdod = paramdod.tul;; paramdod = "")
    {
      paramdod = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt1), paramString, paramdod, Integer.valueOf(i), Integer.valueOf(paramInt2) });
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryVideoPlayError %s", new Object[] { paramdod });
      e.ygI.kvStat(15248, paramdod);
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
  
  public static void a(eeq parameeq, bu parambu)
  {
    AppMethodBeat.i(90993);
    Object localObject1;
    Object localObject2;
    int i;
    if (w.vF(parambu.field_talker)) {
      if (parambu.field_isSend == 1)
      {
        localObject1 = com.tencent.mm.model.u.aAm();
        localObject2 = parambu.field_talker;
        i = 2;
        parambu = (bu)localObject1;
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append("isShareClick=1");
        ((StringBuffer)localObject1).append("&relevant_vid=");
        ((StringBuffer)localObject1).append(parameeq.DBG);
        ((StringBuffer)localObject1).append("&relevant_pre_searchid=");
        ((StringBuffer)localObject1).append(parameeq.DBI);
        ((StringBuffer)localObject1).append("&relevant_shared_openid=");
        ((StringBuffer)localObject1).append(parameeq.DBJ);
        ((StringBuffer)localObject1).append("&rec_category=");
        if (parameeq.DBS <= 0L) {
          break label320;
        }
        ((StringBuffer)localObject1).append(parameeq.DBS);
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject1).append("&source=");
      ((StringBuffer)localObject1).append(parameeq.source);
      ((StringBuffer)localObject1).append("&fromUser=");
      ((StringBuffer)localObject1).append(parambu);
      ((StringBuffer)localObject1).append("&fromScene=");
      ((StringBuffer)localObject1).append(i);
      ((StringBuffer)localObject1).append("&targetInfo=");
      ((StringBuffer)localObject1).append((String)localObject2);
      ((StringBuffer)localObject1).append("&expand=");
      ((StringBuffer)localObject1).append(parameeq.DBH);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject1).toString() });
      parameeq = new cup();
      parameeq.Hmu = ((StringBuffer)localObject1).toString();
      parameeq = new z(parameeq);
      com.tencent.mm.kernel.g.aiU().a(parameeq, 0);
      AppMethodBeat.o(90993);
      return;
      localObject1 = bj.Bk(parambu.field_content);
      break;
      if (parambu.field_isSend == 1)
      {
        localObject2 = com.tencent.mm.model.u.aAm();
        localObject1 = parambu.field_talker;
        parambu = (bu)localObject2;
      }
      for (;;)
      {
        i = 1;
        localObject2 = localObject1;
        break;
        parambu = parambu.field_talker;
        localObject1 = com.tencent.mm.model.u.aAm();
      }
      label320:
      ((StringBuffer)localObject1).append(parameeq.DBK);
    }
  }
  
  public static final void aCN(String paramString)
  {
    AppMethodBeat.i(219081);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryWebViewVisitTime %s", new Object[] { paramString });
    cup localcup = new cup();
    localcup.Hmu = paramString;
    paramString = new z(localcup);
    com.tencent.mm.kernel.g.aiU().a(paramString, 0);
    AppMethodBeat.o(219081);
  }
  
  public static final void fi(String paramString, int paramInt)
  {
    AppMethodBeat.i(90998);
    if ((!bt.isNullOrNil(paramString)) && (paramString.startsWith("wrd"))) {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(900L, paramInt, 1L, false);
    }
    AppMethodBeat.o(90998);
  }
  
  public static final void g(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(90999);
    if ((!bt.isNullOrNil(paramString1)) && (paramString1.startsWith("wrd"))) {
      try
      {
        paramString1 = String.format("%s,%s,%s,%s", new Object[] { com.tencent.mm.compatible.util.q.encode(paramString2, "utf8"), Integer.valueOf(paramInt), paramString1, Long.valueOf(paramLong) });
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReportApiLogic", "kvReportTopStoryOpenWebViewError 15728 %s", new Object[] { paramString1 });
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(15728, paramString1);
        AppMethodBeat.o(90999);
        return;
      }
      catch (UnsupportedEncodingException paramString1) {}
    }
    AppMethodBeat.o(90999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.i
 * JD-Core Version:    0.7.0.1
 */