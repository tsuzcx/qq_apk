package com.tencent.mm.plugin.topstory.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eis;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.fat;
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
  public static void a(eii parameii, String paramString, long paramLong)
  {
    AppMethodBeat.i(90992);
    if ((parameii.Nhy.size() > 0) && ("clickTopStory".equals(((eis)parameii.Nhy.get(0)).name))) {}
    for (long l = paramLong - ((eis)parameii.Nhy.get(0)).timestamp;; l = 0L)
    {
      int i = ai.aft(1);
      parameii = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(parameii.scene), parameii.sGQ, parameii.sessionId, Integer.valueOf(i), paramString, Long.valueOf(paramLong), Integer.valueOf(parameii.GjO), Integer.valueOf(parameii.Nhz), parameii.wib, Long.valueOf(l), parameii.NhA });
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomeUIAction 15466 %s", new Object[] { parameii });
      h.CyF.kvStat(15466, parameii);
      AppMethodBeat.o(90992);
      return;
    }
  }
  
  public static final void a(eit parameit, long paramLong, eiw parameiw)
  {
    AppMethodBeat.i(90997);
    int i;
    long l;
    if (paramLong > 0L)
    {
      i = parameit.scene;
      paramLong /= 1000L;
      l = parameit.Nib;
      if (parameiw == null) {
        break label156;
      }
    }
    label156:
    for (parameiw = parameiw.Nir;; parameiw = parameit.NhY)
    {
      parameit = String.format("videoflowbrowsereport=1&scene=%s&staytime=%s&channelid=%s&pageid=%s&nettype=%s&source=%s&expand=%s&searchid=%s", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Long.valueOf(l), Integer.valueOf(3), "", Integer.valueOf(2), parameiw, parameit.hes });
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoPageBrowseTime 15018 %s", new Object[] { parameit });
      parameiw = new doc();
      parameiw.MRe = parameit;
      parameit = new ad(parameiw);
      g.azz().a(parameit, 0);
      AppMethodBeat.o(90997);
      return;
    }
  }
  
  public static final void a(eit parameit, eiw parameiw, int paramInt)
  {
    AppMethodBeat.i(177107);
    doc localdoc = new doc();
    localdoc.MRe = String.format("logname=videopoint&scene=%s&docid=%s&searchid=%s&vid=%s&actiontype=%s&itemtype=%s", new Object[] { Integer.valueOf(parameit.scene), parameiw.wWb, parameit.hes, parameiw.psI, Integer.valueOf(paramInt), Integer.valueOf(parameiw.Nis) });
    Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportVideoPointAction %s", new Object[] { localdoc.MRe });
    parameit = new y(localdoc);
    g.azz().a(parameit, 0);
    AppMethodBeat.o(177107);
  }
  
  public static void a(eit parameit, eiw parameiw, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(90991);
    parameit = String.format("videosharereport=1&scene=%s&searchid=%s&docid=%s&cdnsourcetype=%s&videoid=%s&optype=%s&fromuser=%s&touser=%s&channelid=%s&optypes=%s&expand=%s", new Object[] { Integer.valueOf(parameit.scene), parameit.hes, parameiw.wWb, Integer.valueOf(parameiw.NiB), parameiw.psI, Integer.valueOf(0), paramString2, paramString3, Long.valueOf(parameit.Nib), paramString1, parameiw.Nir });
    Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare 15035 %s", new Object[] { parameit });
    parameiw = new doc();
    parameiw.MRe = parameit;
    Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoShare:".concat(String.valueOf(parameit)));
    parameit = new ad(parameiw);
    g.azz().a(parameit, 0);
    AppMethodBeat.o(90991);
  }
  
  public static void a(eit parameit, eiw parameiw, Set<any> paramSet, int paramInt)
  {
    AppMethodBeat.i(90996);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("isfeedback=1");
    localStringBuffer.append("&feedtype=0");
    localStringBuffer.append("&businesstype=2");
    localStringBuffer.append("&itemtype=");
    localStringBuffer.append(parameiw.Nis);
    localStringBuffer.append("&scene=");
    localStringBuffer.append(parameit.scene);
    localStringBuffer.append("&searchid=");
    localStringBuffer.append(parameit.hes);
    localStringBuffer.append("&clicktime=");
    localStringBuffer.append(System.currentTimeMillis());
    localStringBuffer.append("&docid=");
    localStringBuffer.append(parameiw.wWb);
    localStringBuffer.append("&docpos=");
    localStringBuffer.append(paramInt);
    localStringBuffer.append("&reasonid=");
    Object localObject = paramSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuffer.append(((any)((Iterator)localObject).next()).id);
      localStringBuffer.append("#");
    }
    localStringBuffer.append("&reasonwording=");
    localObject = new StringBuffer();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      ((StringBuffer)localObject).append(((any)paramSet.next()).dQx);
      ((StringBuffer)localObject).append("#");
    }
    try
    {
      localStringBuffer.append(q.encode(((StringBuffer)localObject).toString(), "utf8"));
      label280:
      localStringBuffer.append("&offset=");
      localStringBuffer.append(paramInt);
      localStringBuffer.append("&sessionid=");
      localStringBuffer.append(ai.afq(parameit.scene));
      localStringBuffer.append("&reserveexpand=");
      localStringBuffer.append(parameiw.Nit);
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportFeedBackClick %s", new Object[] { localStringBuffer.toString() });
      parameit = new doc();
      parameit.MRe = localStringBuffer.toString();
      parameit = new ad(parameit);
      g.azz().a(parameit, 0);
      AppMethodBeat.o(90996);
      return;
    }
    catch (UnsupportedEncodingException paramSet)
    {
      break label280;
    }
  }
  
  public static void a(eiw parameiw, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(90995);
    int i;
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      i = 2;
      if (parameiw == null) {
        break label122;
      }
    }
    label122:
    for (parameiw = parameiw.wWb;; parameiw = "")
    {
      parameiw = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt1), paramString, parameiw, Integer.valueOf(i), Integer.valueOf(paramInt2) });
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryVideoPlayError %s", new Object[] { parameiw });
      e.Cxv.kvStat(15248, parameiw);
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
  
  public static void a(fat paramfat, ca paramca)
  {
    AppMethodBeat.i(90993);
    Object localObject1;
    Object localObject2;
    int i;
    if (ab.Eq(paramca.field_talker)) {
      if (paramca.field_isSend == 1)
      {
        localObject1 = z.aTY();
        localObject2 = paramca.field_talker;
        i = 2;
        paramca = (ca)localObject1;
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append("isShareClick=1");
        ((StringBuffer)localObject1).append("&relevant_vid=");
        ((StringBuffer)localObject1).append(paramfat.IEy);
        ((StringBuffer)localObject1).append("&relevant_pre_searchid=");
        ((StringBuffer)localObject1).append(paramfat.IEA);
        ((StringBuffer)localObject1).append("&relevant_shared_openid=");
        ((StringBuffer)localObject1).append(paramfat.IEB);
        ((StringBuffer)localObject1).append("&rec_category=");
        if (paramfat.IEK <= 0L) {
          break label320;
        }
        ((StringBuffer)localObject1).append(paramfat.IEK);
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject1).append("&source=");
      ((StringBuffer)localObject1).append(paramfat.source);
      ((StringBuffer)localObject1).append("&fromUser=");
      ((StringBuffer)localObject1).append(paramca);
      ((StringBuffer)localObject1).append("&fromScene=");
      ((StringBuffer)localObject1).append(i);
      ((StringBuffer)localObject1).append("&targetInfo=");
      ((StringBuffer)localObject1).append((String)localObject2);
      ((StringBuffer)localObject1).append("&expand=");
      ((StringBuffer)localObject1).append(paramfat.IEz);
      Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject1).toString() });
      paramfat = new doc();
      paramfat.MRe = ((StringBuffer)localObject1).toString();
      paramfat = new ad(paramfat);
      g.azz().a(paramfat, 0);
      AppMethodBeat.o(90993);
      return;
      localObject1 = bp.Ks(paramca.field_content);
      break;
      if (paramca.field_isSend == 1)
      {
        localObject2 = z.aTY();
        localObject1 = paramca.field_talker;
        paramca = (ca)localObject2;
      }
      for (;;)
      {
        i = 1;
        localObject2 = localObject1;
        break;
        paramca = paramca.field_talker;
        localObject1 = z.aTY();
      }
      label320:
      ((StringBuffer)localObject1).append(paramfat.IEC);
    }
  }
  
  public static final void aTw(String paramString)
  {
    AppMethodBeat.i(206894);
    Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryWebViewVisitTime %s", new Object[] { paramString });
    doc localdoc = new doc();
    localdoc.MRe = paramString;
    paramString = new ad(localdoc);
    g.azz().a(paramString, 0);
    AppMethodBeat.o(206894);
  }
  
  public static void abQ(int paramInt)
  {
    AppMethodBeat.i(90994);
    switch (paramInt)
    {
    default: 
      b.pl(b.vif);
    }
    for (;;)
    {
      a.pl(7);
      AppMethodBeat.o(90994);
      return;
      b.pl(b.vhQ);
      continue;
      b.pl(b.vhR);
      continue;
      b.pl(b.vhS);
      continue;
      b.pl(b.vhT);
      continue;
      b.pl(b.vhU);
      continue;
      b.pl(b.vhV);
      continue;
      b.pl(b.vhW);
      continue;
      b.pl(b.vhX);
      continue;
      b.pl(b.vhY);
      continue;
      b.pl(b.vhZ);
      continue;
      b.pl(b.vib);
      continue;
      b.pl(b.vic);
      continue;
      b.pl(b.vie);
    }
  }
  
  public static final void fQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(90998);
    if ((!Util.isNullOrNil(paramString)) && (paramString.startsWith("wrd"))) {
      h.CyF.idkeyStat(900L, paramInt, 1L, false);
    }
    AppMethodBeat.o(90998);
  }
  
  public static final void g(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(90999);
    if ((!Util.isNullOrNil(paramString1)) && (paramString1.startsWith("wrd"))) {
      try
      {
        paramString1 = String.format("%s,%s,%s,%s", new Object[] { q.encode(paramString2, "utf8"), Integer.valueOf(paramInt), paramString1, Long.valueOf(paramLong) });
        Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "kvReportTopStoryOpenWebViewError 15728 %s", new Object[] { paramString1 });
        h.CyF.kvStat(15728, paramString1);
        AppMethodBeat.o(90999);
        return;
      }
      catch (UnsupportedEncodingException paramString1) {}
    }
    AppMethodBeat.o(90999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.i
 * JD-Core Version:    0.7.0.1
 */