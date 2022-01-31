package com.tencent.mm.plugin.topstory.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.protocal.protobuf.ckv;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h
{
  public static void Gw(int paramInt)
  {
    AppMethodBeat.i(96372);
    switch (paramInt)
    {
    default: 
      b.kS(b.uLi);
    }
    for (;;)
    {
      a.kS(7);
      AppMethodBeat.o(96372);
      return;
      b.kS(b.uKU);
      continue;
      b.kS(b.uKV);
      continue;
      b.kS(b.uKW);
      continue;
      b.kS(b.uKX);
      continue;
      b.kS(b.uKY);
      continue;
      b.kS(b.uKZ);
      continue;
      b.kS(b.uLa);
      continue;
      b.kS(b.uLb);
      continue;
      b.kS(b.uLc);
      continue;
      b.kS(b.uLd);
      continue;
      b.kS(b.uLe);
      continue;
      b.kS(b.uLf);
      continue;
      b.kS(b.uLg);
    }
  }
  
  public static void a(cko paramcko, String paramString, long paramLong)
  {
    AppMethodBeat.i(96370);
    if ((paramcko.xUu.size() > 0) && ("clickTopStory".equals(((ckv)paramcko.xUu.get(0)).name))) {}
    for (long l = paramLong - ((ckv)paramcko.xUu.get(0)).timestamp;; l = 0L)
    {
      int i = aa.Jf(1);
      paramcko = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramcko.scene), paramcko.xUt, paramcko.cpW, Integer.valueOf(i), paramString, Long.valueOf(paramLong), Integer.valueOf(paramcko.tft), Integer.valueOf(paramcko.xUv), paramcko.xUx, Long.valueOf(l), paramcko.xUy });
      ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomeUIAction 15466 %s", new Object[] { paramcko });
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(15466, paramcko);
      AppMethodBeat.o(96370);
      return;
    }
  }
  
  public static final void a(ckw paramckw, long paramLong, ckx paramckx)
  {
    AppMethodBeat.i(96375);
    int i;
    long l;
    if (paramLong > 0L)
    {
      i = paramckw.scene;
      paramLong /= 1000L;
      l = paramckw.xUO;
      if (paramckx == null) {
        break label156;
      }
    }
    label156:
    for (paramckx = paramckx.xVd;; paramckx = paramckw.xUL)
    {
      paramckw = String.format("videoflowbrowsereport=1&scene=%s&staytime=%s&channelid=%s&pageid=%s&nettype=%s&source=%s&expand=%s&searchid=%s", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Integer.valueOf(3), "", Integer.valueOf(2), paramckx, paramckw.hng });
      ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoPageBrowseTime 15018 %s", new Object[] { paramckw });
      paramckx = new buo();
      paramckx.xHP = paramckw;
      paramckw = new w(paramckx);
      g.Rc().a(paramckw, 0);
      AppMethodBeat.o(96375);
      return;
    }
  }
  
  public static void a(ckw paramckw, ckx paramckx, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96369);
    paramckw = String.format("videosharereport=1&scene=%s&searchid=%s&docid=%s&cdnsourcetype=%s&videoid=%s&optype=%s&fromuser=%s&touser=%s&channelid=%s&optypes=%s&expand=%s", new Object[] { Integer.valueOf(paramckw.scene), paramckw.hng, paramckx.uKI, Integer.valueOf(paramckx.xVr), paramckx.xVa, Integer.valueOf(0), paramString2, paramString3, Long.valueOf(paramckw.xUO), paramString1, paramckx.xVd });
    ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare 15035 %s", new Object[] { paramckw });
    paramckx = new buo();
    paramckx.xHP = paramckw;
    ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare:".concat(String.valueOf(paramckw)));
    paramckw = new w(paramckx);
    g.Rc().a(paramckw, 0);
    AppMethodBeat.o(96369);
  }
  
  public static void a(ckw paramckw, ckx paramckx, Set<adl> paramSet, int paramInt)
  {
    AppMethodBeat.i(96374);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("isfeedback=1");
    localStringBuffer.append("&feedtype=0");
    localStringBuffer.append("&businesstype=2");
    localStringBuffer.append("&itemtype=");
    localStringBuffer.append(paramckx.xVe);
    localStringBuffer.append("&scene=");
    localStringBuffer.append(paramckw.scene);
    localStringBuffer.append("&searchid=");
    localStringBuffer.append(paramckw.hng);
    localStringBuffer.append("&clicktime=");
    localStringBuffer.append(System.currentTimeMillis());
    localStringBuffer.append("&docid=");
    localStringBuffer.append(paramckx.uKI);
    localStringBuffer.append("&docpos=");
    localStringBuffer.append(paramInt);
    localStringBuffer.append("&reasonid=");
    Object localObject = paramSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuffer.append(((adl)((Iterator)localObject).next()).id);
      localStringBuffer.append("#");
    }
    localStringBuffer.append("&reasonwording=");
    localObject = new StringBuffer();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ((StringBuffer)localObject).append(((adl)paramSet.next()).cyA);
      ((StringBuffer)localObject).append("#");
    }
    try
    {
      localStringBuffer.append(q.encode(((StringBuffer)localObject).toString(), "utf8"));
      label289:
      localStringBuffer.append("&offset=");
      localStringBuffer.append(paramInt);
      localStringBuffer.append("&sessionid=");
      localStringBuffer.append(aa.IZ(paramckw.scene));
      localStringBuffer.append("&reserveexpand=");
      localStringBuffer.append(paramckx.xVf);
      ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportFeedBackClick %s", new Object[] { localStringBuffer.toString() });
      paramckw = new buo();
      paramckw.xHP = localStringBuffer.toString();
      paramckw = new w(paramckw);
      g.Rc().a(paramckw, 0);
      AppMethodBeat.o(96374);
      return;
    }
    catch (UnsupportedEncodingException paramSet)
    {
      break label289;
    }
  }
  
  public static void a(ckx paramckx, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(96373);
    int i;
    if (at.isWifi(ah.getContext()))
    {
      i = 2;
      if (paramckx == null) {
        break label122;
      }
    }
    label122:
    for (paramckx = paramckx.uKI;; paramckx = "")
    {
      paramckx = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt1), paramString, paramckx, Integer.valueOf(i), Integer.valueOf(paramInt2) });
      ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryVideoPlayError %s", new Object[] { paramckx });
      e.qrI.kvStat(15248, paramckx);
      AppMethodBeat.o(96373);
      return;
      if (!at.isConnected(ah.getContext()))
      {
        i = 1;
        break;
      }
      i = 3;
      break;
    }
  }
  
  public static void a(cyl paramcyl, bi parambi)
  {
    AppMethodBeat.i(96371);
    Object localObject1;
    Object localObject2;
    int i;
    if (t.lA(parambi.field_talker)) {
      if (parambi.field_isSend == 1)
      {
        localObject1 = r.Zn();
        localObject2 = parambi.field_talker;
        i = 2;
        parambi = (bi)localObject1;
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append("isShareClick=1");
        ((StringBuffer)localObject1).append("&relevant_vid=");
        ((StringBuffer)localObject1).append(paramcyl.uJi);
        ((StringBuffer)localObject1).append("&relevant_pre_searchid=");
        ((StringBuffer)localObject1).append(paramcyl.uJk);
        ((StringBuffer)localObject1).append("&relevant_shared_openid=");
        ((StringBuffer)localObject1).append(paramcyl.uJl);
        ((StringBuffer)localObject1).append("&rec_category=");
        if (paramcyl.uJu <= 0L) {
          break label320;
        }
        ((StringBuffer)localObject1).append(paramcyl.uJu);
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject1).append("&source=");
      ((StringBuffer)localObject1).append(paramcyl.source);
      ((StringBuffer)localObject1).append("&fromUser=");
      ((StringBuffer)localObject1).append(parambi);
      ((StringBuffer)localObject1).append("&fromScene=");
      ((StringBuffer)localObject1).append(i);
      ((StringBuffer)localObject1).append("&targetInfo=");
      ((StringBuffer)localObject1).append((String)localObject2);
      ((StringBuffer)localObject1).append("&expand=");
      ((StringBuffer)localObject1).append(paramcyl.uJj);
      ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject1).toString() });
      paramcyl = new buo();
      paramcyl.xHP = ((StringBuffer)localObject1).toString();
      paramcyl = new w(paramcyl);
      g.Rc().a(paramcyl, 0);
      AppMethodBeat.o(96371);
      return;
      localObject1 = bf.pu(parambi.field_content);
      break;
      if (parambi.field_isSend == 1)
      {
        localObject2 = r.Zn();
        localObject1 = parambi.field_talker;
        parambi = (bi)localObject2;
      }
      for (;;)
      {
        i = 1;
        localObject2 = localObject1;
        break;
        parambi = parambi.field_talker;
        localObject1 = r.Zn();
      }
      label320:
      ((StringBuffer)localObject1).append(paramcyl.uJm);
    }
  }
  
  public static final void c(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(96377);
    if ((!bo.isNullOrNil(paramString1)) && (paramString1.startsWith("wrd"))) {
      try
      {
        paramString1 = String.format("%s,%s,%s,%s", new Object[] { q.encode(paramString2, "utf8"), Integer.valueOf(paramInt), paramString1, Long.valueOf(paramLong) });
        ab.i("MicroMsg.TopStory.TopStoryReportApiLogic", "kvReportTopStoryOpenWebViewError 15728 %s", new Object[] { paramString1 });
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(15728, paramString1);
        AppMethodBeat.o(96377);
        return;
      }
      catch (UnsupportedEncodingException paramString1) {}
    }
    AppMethodBeat.o(96377);
  }
  
  public static final void dA(String paramString, int paramInt)
  {
    AppMethodBeat.i(96376);
    if ((!bo.isNullOrNil(paramString)) && (paramString.startsWith("wrd"))) {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(900L, paramInt, 1L, false);
    }
    AppMethodBeat.o(96376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.h
 * JD-Core Version:    0.7.0.1
 */