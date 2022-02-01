package com.tencent.mm.plugin.topstory.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.fnt;
import com.tencent.mm.protocal.protobuf.fod;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.protocal.protobuf.gib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class h
{
  public static void a(fnt paramfnt, String paramString, long paramLong)
  {
    AppMethodBeat.i(90992);
    if ((paramfnt.abNF.size() > 0) && ("clickTopStory".equals(((fod)paramfnt.abNF.get(0)).name))) {}
    for (long l = paramLong - ((fod)paramfnt.abNF.get(0)).timestamp;; l = 0L)
    {
      int i = aj.asY(1);
      paramfnt = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramfnt.scene), paramfnt.zIO, paramfnt.sessionId, Integer.valueOf(i), paramString, Long.valueOf(paramLong), Integer.valueOf(paramfnt.TJd), Integer.valueOf(paramfnt.tBy), paramfnt.GtP, Long.valueOf(l), paramfnt.abNG });
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomeUIAction 15466 %s", new Object[] { paramfnt });
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(15466, paramfnt);
      AppMethodBeat.o(90992);
      return;
    }
  }
  
  public static final void a(foe paramfoe, long paramLong, foh paramfoh)
  {
    AppMethodBeat.i(90997);
    int i;
    long l;
    if (paramLong > 0L)
    {
      i = paramfoe.scene;
      paramLong /= 1000L;
      l = paramfoe.abOj;
      if (paramfoh == null) {
        break label156;
      }
    }
    label156:
    for (paramfoh = paramfoh.abOy;; paramfoh = paramfoe.abOg)
    {
      paramfoe = String.format("videoflowbrowsereport=1&scene=%s&staytime=%s&channelid=%s&pageid=%s&nettype=%s&source=%s&expand=%s&searchid=%s", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Integer.valueOf(3), "", Integer.valueOf(2), paramfoh, paramfoe.mpa });
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoPageBrowseTime 15018 %s", new Object[] { paramfoe });
      paramfoh = new eqy();
      paramfoh.abuE = paramfoe;
      paramfoe = new ae(paramfoh);
      com.tencent.mm.kernel.h.aZW().a(paramfoe, 0);
      AppMethodBeat.o(90997);
      return;
    }
  }
  
  public static final void a(foe paramfoe, foh paramfoh, int paramInt)
  {
    AppMethodBeat.i(177107);
    eqy localeqy = new eqy();
    localeqy.abuE = String.format("logname=videopoint&scene=%s&docid=%s&searchid=%s&vid=%s&actiontype=%s&itemtype=%s", new Object[] { Integer.valueOf(paramfoe.scene), paramfoh.HsD, paramfoe.mpa, paramfoh.Ido, Integer.valueOf(paramInt), Integer.valueOf(paramfoh.abOz) });
    Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportVideoPointAction %s", new Object[] { localeqy.abuE });
    paramfoe = new com.tencent.mm.plugin.websearch.api.z(localeqy);
    com.tencent.mm.kernel.h.aZW().a(paramfoe, 0);
    AppMethodBeat.o(177107);
  }
  
  public static void a(foe paramfoe, foh paramfoh, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(90991);
    paramfoe = String.format("videosharereport=1&scene=%s&searchid=%s&docid=%s&cdnsourcetype=%s&videoid=%s&optype=%s&fromuser=%s&touser=%s&channelid=%s&optypes=%s&expand=%s", new Object[] { Integer.valueOf(paramfoe.scene), paramfoe.mpa, paramfoh.HsD, Integer.valueOf(paramfoh.abOI), paramfoh.Ido, Integer.valueOf(0), paramString2, paramString3, Long.valueOf(paramfoe.abOj), paramString1, paramfoh.abOy });
    Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare 15035 %s", new Object[] { paramfoe });
    paramfoh = new eqy();
    paramfoh.abuE = paramfoe;
    Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare:".concat(String.valueOf(paramfoe)));
    paramfoe = new ae(paramfoh);
    com.tencent.mm.kernel.h.aZW().a(paramfoe, 0);
    AppMethodBeat.o(90991);
  }
  
  public static void a(foe paramfoe, foh paramfoh, Set<ass> paramSet, int paramInt)
  {
    AppMethodBeat.i(90996);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("isfeedback=1");
    localStringBuffer.append("&feedtype=0");
    localStringBuffer.append("&businesstype=2");
    localStringBuffer.append("&itemtype=");
    localStringBuffer.append(paramfoh.abOz);
    localStringBuffer.append("&scene=");
    localStringBuffer.append(paramfoe.scene);
    localStringBuffer.append("&searchid=");
    localStringBuffer.append(paramfoe.mpa);
    localStringBuffer.append("&clicktime=");
    localStringBuffer.append(System.currentTimeMillis());
    localStringBuffer.append("&docid=");
    localStringBuffer.append(paramfoh.HsD);
    localStringBuffer.append("&docpos=");
    localStringBuffer.append(paramInt);
    localStringBuffer.append("&reasonid=");
    Object localObject = paramSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuffer.append(((ass)((Iterator)localObject).next()).id);
      localStringBuffer.append("#");
    }
    localStringBuffer.append("&reasonwording=");
    localObject = new StringBuffer();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ((StringBuffer)localObject).append(((ass)paramSet.next()).wording);
      ((StringBuffer)localObject).append("#");
    }
    try
    {
      localStringBuffer.append(r.as(((StringBuffer)localObject).toString(), "utf8"));
      label280:
      localStringBuffer.append("&offset=");
      localStringBuffer.append(paramInt);
      localStringBuffer.append("&sessionid=");
      localStringBuffer.append(aj.asV(paramfoe.scene));
      localStringBuffer.append("&reserveexpand=");
      localStringBuffer.append(paramfoh.abOA);
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportFeedBackClick %s", new Object[] { localStringBuffer.toString() });
      paramfoe = new eqy();
      paramfoe.abuE = localStringBuffer.toString();
      paramfoe = new ae(paramfoe);
      com.tencent.mm.kernel.h.aZW().a(paramfoe, 0);
      AppMethodBeat.o(90996);
      return;
    }
    catch (UnsupportedEncodingException paramSet)
    {
      break label280;
    }
  }
  
  public static void a(foh paramfoh, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(90995);
    int i;
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      i = 2;
      if (paramfoh == null) {
        break label122;
      }
    }
    label122:
    for (paramfoh = paramfoh.HsD;; paramfoh = "")
    {
      paramfoh = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt1), paramString, paramfoh, Integer.valueOf(i), Integer.valueOf(paramInt2) });
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryVideoPlayError %s", new Object[] { paramfoh });
      f.Ozc.kvStat(15248, paramfoh);
      AppMethodBeat.o(90995);
      return;
      if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
      {
        i = 1;
        break;
      }
      i = 3;
      break;
    }
  }
  
  public static void a(gib paramgib, cc paramcc)
  {
    AppMethodBeat.i(90993);
    Object localObject1;
    Object localObject2;
    int i;
    if (au.bwE(paramcc.field_talker)) {
      if (paramcc.field_isSend == 1)
      {
        localObject1 = com.tencent.mm.model.z.bAM();
        localObject2 = paramcc.field_talker;
        i = 2;
        paramcc = (cc)localObject1;
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append("isShareClick=1");
        ((StringBuffer)localObject1).append("&relevant_vid=");
        ((StringBuffer)localObject1).append(paramgib.WoZ);
        ((StringBuffer)localObject1).append("&relevant_pre_searchid=");
        ((StringBuffer)localObject1).append(paramgib.Wpb);
        ((StringBuffer)localObject1).append("&relevant_shared_openid=");
        ((StringBuffer)localObject1).append(paramgib.Wpc);
        ((StringBuffer)localObject1).append("&rec_category=");
        if (paramgib.Wpl <= 0L) {
          break label320;
        }
        ((StringBuffer)localObject1).append(paramgib.Wpl);
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject1).append("&source=");
      ((StringBuffer)localObject1).append(paramgib.source);
      ((StringBuffer)localObject1).append("&fromUser=");
      ((StringBuffer)localObject1).append(paramcc);
      ((StringBuffer)localObject1).append("&fromScene=");
      ((StringBuffer)localObject1).append(i);
      ((StringBuffer)localObject1).append("&targetInfo=");
      ((StringBuffer)localObject1).append((String)localObject2);
      ((StringBuffer)localObject1).append("&expand=");
      ((StringBuffer)localObject1).append(paramgib.Wpa);
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject1).toString() });
      paramgib = new eqy();
      paramgib.abuE = ((StringBuffer)localObject1).toString();
      paramgib = new ae(paramgib);
      com.tencent.mm.kernel.h.aZW().a(paramgib, 0);
      AppMethodBeat.o(90993);
      return;
      localObject1 = br.JJ(paramcc.field_content);
      break;
      if (paramcc.field_isSend == 1)
      {
        localObject2 = com.tencent.mm.model.z.bAM();
        localObject1 = paramcc.field_talker;
        paramcc = (cc)localObject2;
      }
      for (;;)
      {
        i = 1;
        localObject2 = localObject1;
        break;
        paramcc = paramcc.field_talker;
        localObject1 = com.tencent.mm.model.z.bAM();
      }
      label320:
      ((StringBuffer)localObject1).append(paramgib.Wpd);
    }
  }
  
  public static void aoM(int paramInt)
  {
    AppMethodBeat.i(90994);
    switch (paramInt)
    {
    default: 
      b.rG(b.Fug);
    }
    for (;;)
    {
      a.rG(7);
      AppMethodBeat.o(90994);
      return;
      b.rG(b.FtT);
      continue;
      b.rG(b.FtU);
      continue;
      b.rG(b.FtV);
      continue;
      b.rG(b.FtW);
      continue;
      b.rG(b.FtX);
      continue;
      b.rG(b.FtY);
      continue;
      b.rG(b.FtZ);
      continue;
      b.rG(b.Fua);
      continue;
      b.rG(b.Fub);
      continue;
      b.rG(b.Fuc);
      continue;
      b.rG(b.Fud);
      continue;
      b.rG(b.Fue);
      continue;
      b.rG(b.Fuf);
    }
  }
  
  public static final void ber(String paramString)
  {
    AppMethodBeat.i(271666);
    Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryWebViewVisitTime %s", new Object[] { paramString });
    eqy localeqy = new eqy();
    localeqy.abuE = paramString;
    paramString = new ae(localeqy);
    com.tencent.mm.kernel.h.aZW().a(paramString, 0);
    AppMethodBeat.o(271666);
  }
  
  public static final void g(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(90999);
    if ((!Util.isNullOrNil(paramString1)) && (paramString1.startsWith("wrd"))) {
      try
      {
        paramString1 = String.format("%s,%s,%s,%s", new Object[] { r.as(paramString2, "utf8"), Integer.valueOf(paramInt), paramString1, Long.valueOf(paramLong) });
        Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "kvReportTopStoryOpenWebViewError 15728 %s", new Object[] { paramString1 });
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(15728, paramString1);
        AppMethodBeat.o(90999);
        return;
      }
      catch (UnsupportedEncodingException paramString1) {}
    }
    AppMethodBeat.o(90999);
  }
  
  public static final void hw(String paramString, int paramInt)
  {
    AppMethodBeat.i(90998);
    if ((!Util.isNullOrNil(paramString)) && (paramString.startsWith("wrd"))) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(900L, paramInt, 1L, false);
    }
    AppMethodBeat.o(90998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.h
 * JD-Core Version:    0.7.0.1
 */