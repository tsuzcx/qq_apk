package com.tencent.mm.plugin.topstory.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.protocal.protobuf.esk;
import com.tencent.mm.protocal.protobuf.esu;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class i
{
  public static void a(esk paramesk, String paramString, long paramLong)
  {
    AppMethodBeat.i(90992);
    if ((paramesk.Uue.size() > 0) && ("clickTopStory".equals(((esu)paramesk.Uue.get(0)).name))) {}
    for (long l = paramLong - ((esu)paramesk.Uue.get(0)).timestamp;; l = 0L)
    {
      int i = ai.anh(1);
      paramesk = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramesk.scene), paramesk.wmL, paramesk.sessionId, Integer.valueOf(i), paramString, Long.valueOf(paramLong), Integer.valueOf(paramesk.MWz), Integer.valueOf(paramesk.Uuf), paramesk.ARR, Long.valueOf(l), paramesk.Uug });
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomeUIAction 15466 %s", new Object[] { paramesk });
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(15466, paramesk);
      AppMethodBeat.o(90992);
      return;
    }
  }
  
  public static final void a(esv paramesv, long paramLong, esy paramesy)
  {
    AppMethodBeat.i(90997);
    int i;
    long l;
    if (paramLong > 0L)
    {
      i = paramesv.scene;
      paramLong /= 1000L;
      l = paramesv.UuH;
      if (paramesy == null) {
        break label156;
      }
    }
    label156:
    for (paramesy = paramesy.UuX;; paramesy = paramesv.UuE)
    {
      paramesv = String.format("videoflowbrowsereport=1&scene=%s&staytime=%s&channelid=%s&pageid=%s&nettype=%s&source=%s&expand=%s&searchid=%s", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Integer.valueOf(3), "", Integer.valueOf(2), paramesy, paramesv.jQi });
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoPageBrowseTime 15018 %s", new Object[] { paramesv });
      paramesy = new dxu();
      paramesy.Udk = paramesv;
      paramesv = new ad(paramesy);
      com.tencent.mm.kernel.h.aGY().a(paramesv, 0);
      AppMethodBeat.o(90997);
      return;
    }
  }
  
  public static final void a(esv paramesv, esy paramesy, int paramInt)
  {
    AppMethodBeat.i(177107);
    dxu localdxu = new dxu();
    localdxu.Udk = String.format("logname=videopoint&scene=%s&docid=%s&searchid=%s&vid=%s&actiontype=%s&itemtype=%s", new Object[] { Integer.valueOf(paramesv.scene), paramesy.BHW, paramesv.jQi, paramesy.Crh, Integer.valueOf(paramInt), Integer.valueOf(paramesy.UuY) });
    Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportVideoPointAction %s", new Object[] { localdxu.Udk });
    paramesv = new y(localdxu);
    com.tencent.mm.kernel.h.aGY().a(paramesv, 0);
    AppMethodBeat.o(177107);
  }
  
  public static void a(esv paramesv, esy paramesy, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(90991);
    paramesv = String.format("videosharereport=1&scene=%s&searchid=%s&docid=%s&cdnsourcetype=%s&videoid=%s&optype=%s&fromuser=%s&touser=%s&channelid=%s&optypes=%s&expand=%s", new Object[] { Integer.valueOf(paramesv.scene), paramesv.jQi, paramesy.BHW, Integer.valueOf(paramesy.Uvh), paramesy.Crh, Integer.valueOf(0), paramString2, paramString3, Long.valueOf(paramesv.UuH), paramString1, paramesy.UuX });
    Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare 15035 %s", new Object[] { paramesv });
    paramesy = new dxu();
    paramesy.Udk = paramesv;
    Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare:".concat(String.valueOf(paramesv)));
    paramesv = new ad(paramesy);
    com.tencent.mm.kernel.h.aGY().a(paramesv, 0);
    AppMethodBeat.o(90991);
  }
  
  public static void a(esv paramesv, esy paramesy, Set<aoz> paramSet, int paramInt)
  {
    AppMethodBeat.i(90996);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("isfeedback=1");
    localStringBuffer.append("&feedtype=0");
    localStringBuffer.append("&businesstype=2");
    localStringBuffer.append("&itemtype=");
    localStringBuffer.append(paramesy.UuY);
    localStringBuffer.append("&scene=");
    localStringBuffer.append(paramesv.scene);
    localStringBuffer.append("&searchid=");
    localStringBuffer.append(paramesv.jQi);
    localStringBuffer.append("&clicktime=");
    localStringBuffer.append(System.currentTimeMillis());
    localStringBuffer.append("&docid=");
    localStringBuffer.append(paramesy.BHW);
    localStringBuffer.append("&docpos=");
    localStringBuffer.append(paramInt);
    localStringBuffer.append("&reasonid=");
    Object localObject = paramSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuffer.append(((aoz)((Iterator)localObject).next()).id);
      localStringBuffer.append("#");
    }
    localStringBuffer.append("&reasonwording=");
    localObject = new StringBuffer();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ((StringBuffer)localObject).append(((aoz)paramSet.next()).wording);
      ((StringBuffer)localObject).append("#");
    }
    try
    {
      localStringBuffer.append(q.an(((StringBuffer)localObject).toString(), "utf8"));
      label280:
      localStringBuffer.append("&offset=");
      localStringBuffer.append(paramInt);
      localStringBuffer.append("&sessionid=");
      localStringBuffer.append(ai.ane(paramesv.scene));
      localStringBuffer.append("&reserveexpand=");
      localStringBuffer.append(paramesy.UuZ);
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportFeedBackClick %s", new Object[] { localStringBuffer.toString() });
      paramesv = new dxu();
      paramesv.Udk = localStringBuffer.toString();
      paramesv = new ad(paramesv);
      com.tencent.mm.kernel.h.aGY().a(paramesv, 0);
      AppMethodBeat.o(90996);
      return;
    }
    catch (UnsupportedEncodingException paramSet)
    {
      break label280;
    }
  }
  
  public static void a(esy paramesy, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(90995);
    int i;
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      i = 2;
      if (paramesy == null) {
        break label122;
      }
    }
    label122:
    for (paramesy = paramesy.BHW;; paramesy = "")
    {
      paramesy = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt1), paramString, paramesy, Integer.valueOf(i), Integer.valueOf(paramInt2) });
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryVideoPlayError %s", new Object[] { paramesy });
      f.Iyx.kvStat(15248, paramesy);
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
  
  public static void a(flm paramflm, ca paramca)
  {
    AppMethodBeat.i(90993);
    Object localObject1;
    Object localObject2;
    int i;
    if (ab.Lj(paramca.field_talker)) {
      if (paramca.field_isSend == 1)
      {
        localObject1 = z.bcZ();
        localObject2 = paramca.field_talker;
        i = 2;
        paramca = (ca)localObject1;
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append("isShareClick=1");
        ((StringBuffer)localObject1).append("&relevant_vid=");
        ((StringBuffer)localObject1).append(paramflm.PyQ);
        ((StringBuffer)localObject1).append("&relevant_pre_searchid=");
        ((StringBuffer)localObject1).append(paramflm.PyS);
        ((StringBuffer)localObject1).append("&relevant_shared_openid=");
        ((StringBuffer)localObject1).append(paramflm.PyT);
        ((StringBuffer)localObject1).append("&rec_category=");
        if (paramflm.Pzc <= 0L) {
          break label320;
        }
        ((StringBuffer)localObject1).append(paramflm.Pzc);
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject1).append("&source=");
      ((StringBuffer)localObject1).append(paramflm.source);
      ((StringBuffer)localObject1).append("&fromUser=");
      ((StringBuffer)localObject1).append(paramca);
      ((StringBuffer)localObject1).append("&fromScene=");
      ((StringBuffer)localObject1).append(i);
      ((StringBuffer)localObject1).append("&targetInfo=");
      ((StringBuffer)localObject1).append((String)localObject2);
      ((StringBuffer)localObject1).append("&expand=");
      ((StringBuffer)localObject1).append(paramflm.PyR);
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject1).toString() });
      paramflm = new dxu();
      paramflm.Udk = ((StringBuffer)localObject1).toString();
      paramflm = new ad(paramflm);
      com.tencent.mm.kernel.h.aGY().a(paramflm, 0);
      AppMethodBeat.o(90993);
      return;
      localObject1 = bq.RL(paramca.field_content);
      break;
      if (paramca.field_isSend == 1)
      {
        localObject2 = z.bcZ();
        localObject1 = paramca.field_talker;
        paramca = (ca)localObject2;
      }
      for (;;)
      {
        i = 1;
        localObject2 = localObject1;
        break;
        paramca = paramca.field_talker;
        localObject1 = z.bcZ();
      }
      label320:
      ((StringBuffer)localObject1).append(paramflm.PyU);
    }
  }
  
  public static void ajv(int paramInt)
  {
    AppMethodBeat.i(90994);
    switch (paramInt)
    {
    default: 
      b.rE(b.zZm);
    }
    for (;;)
    {
      a.rE(7);
      AppMethodBeat.o(90994);
      return;
      b.rE(b.zYZ);
      continue;
      b.rE(b.zZa);
      continue;
      b.rE(b.zZb);
      continue;
      b.rE(b.zZc);
      continue;
      b.rE(b.zZd);
      continue;
      b.rE(b.zZe);
      continue;
      b.rE(b.zZf);
      continue;
      b.rE(b.zZg);
      continue;
      b.rE(b.zZh);
      continue;
      b.rE(b.zZi);
      continue;
      b.rE(b.zZj);
      continue;
      b.rE(b.zZk);
      continue;
      b.rE(b.zZl);
    }
  }
  
  public static final void beU(String paramString)
  {
    AppMethodBeat.i(190952);
    Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryWebViewVisitTime %s", new Object[] { paramString });
    dxu localdxu = new dxu();
    localdxu.Udk = paramString;
    paramString = new ad(localdxu);
    com.tencent.mm.kernel.h.aGY().a(paramString, 0);
    AppMethodBeat.o(190952);
  }
  
  public static final void g(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(90999);
    if ((!Util.isNullOrNil(paramString1)) && (paramString1.startsWith("wrd"))) {
      try
      {
        paramString1 = String.format("%s,%s,%s,%s", new Object[] { q.an(paramString2, "utf8"), Integer.valueOf(paramInt), paramString1, Long.valueOf(paramLong) });
        Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "kvReportTopStoryOpenWebViewError 15728 %s", new Object[] { paramString1 });
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(15728, paramString1);
        AppMethodBeat.o(90999);
        return;
      }
      catch (UnsupportedEncodingException paramString1) {}
    }
    AppMethodBeat.o(90999);
  }
  
  public static final void gz(String paramString, int paramInt)
  {
    AppMethodBeat.i(90998);
    if ((!Util.isNullOrNil(paramString)) && (paramString.startsWith("wrd"))) {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(900L, paramInt, 1L, false);
    }
    AppMethodBeat.o(90998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.i
 * JD-Core Version:    0.7.0.1
 */