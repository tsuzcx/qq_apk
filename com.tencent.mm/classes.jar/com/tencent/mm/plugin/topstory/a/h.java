package com.tencent.mm.plugin.topstory.a;

import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.byb;
import com.tencent.mm.protocal.c.bye;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.protocal.c.ckw;
import com.tencent.mm.protocal.c.zc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  public static void a(byb parambyb, String paramString, long paramLong)
  {
    if ((parambyb.tNZ.size() > 0) && ("clickTopStory".equals(((bye)parambyb.tNZ.get(0)).name))) {}
    for (long l = paramLong - ((bye)parambyb.tNZ.get(0)).timestamp;; l = 0L)
    {
      int i = aa.Bs(1);
      parambyb = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(parambyb.scene), parambyb.tNY, parambyb.bIB, Integer.valueOf(i), paramString, Long.valueOf(paramLong), Integer.valueOf(parambyb.pDC), Integer.valueOf(parambyb.tOa), parambyb.tOc, Long.valueOf(l), parambyb.tOd });
      y.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomeUIAction 15466 %s", new Object[] { parambyb });
      com.tencent.mm.plugin.report.service.h.nFQ.aC(15466, parambyb);
      return;
    }
  }
  
  public static final void a(byf parambyf, long paramLong)
  {
    if (paramLong > 0L)
    {
      parambyf = String.format("%s,%s,%s,%s", new Object[] { Integer.valueOf(parambyf.scene), Long.valueOf(paramLong), Long.valueOf(parambyf.tOo), Integer.valueOf(3) });
      y.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoPageBrowseTime 15018 %s", new Object[] { parambyf });
      com.tencent.mm.plugin.report.service.h.nFQ.aC(15018, parambyf);
    }
  }
  
  public static void a(byf parambyf, byg parambyg, String paramString1, String paramString2, String paramString3)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(15035, new Object[] { Integer.valueOf(parambyf.scene), parambyf.fTF, parambyg.qVw, parambyg.tOx, Integer.valueOf(0), paramString2, paramString3, Long.valueOf(parambyf.tOo), paramString1 });
  }
  
  public static void a(byf parambyf, byg parambyg, List<Integer> paramList, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("isfeedback=1");
    localStringBuffer.append("&feedtype=0");
    localStringBuffer.append("&businesstype=2");
    localStringBuffer.append("&itemtype=");
    localStringBuffer.append(parambyg.tOB);
    localStringBuffer.append("&scene=");
    localStringBuffer.append(parambyf.scene);
    localStringBuffer.append("&searchid=");
    localStringBuffer.append(parambyf.fTF);
    localStringBuffer.append("&clicktime=");
    localStringBuffer.append(System.currentTimeMillis());
    localStringBuffer.append("&docid=");
    localStringBuffer.append(parambyg.qVw);
    localStringBuffer.append("&docpos=");
    localStringBuffer.append(1);
    localStringBuffer.append("&reasonid=");
    Object localObject = paramList.iterator();
    int i;
    while (((Iterator)localObject).hasNext())
    {
      i = ((Integer)((Iterator)localObject).next()).intValue();
      localStringBuffer.append(((zc)parambyg.tOH.get(i)).id);
      localStringBuffer.append("#");
    }
    localStringBuffer.append("&reasonwording=");
    localObject = new StringBuffer();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      i = ((Integer)paramList.next()).intValue();
      ((StringBuffer)localObject).append(((zc)parambyg.tOH.get(i)).bQZ);
      ((StringBuffer)localObject).append("#");
    }
    try
    {
      localStringBuffer.append(com.tencent.mm.compatible.util.q.encode(((StringBuffer)localObject).toString(), "utf8"));
      label305:
      localStringBuffer.append("&offset=");
      localStringBuffer.append(paramInt);
      localStringBuffer.append("&sessionid=");
      localStringBuffer.append(aa.Bm(parambyf.scene));
      localStringBuffer.append("&reserveexpand=");
      localStringBuffer.append(parambyg.tOC);
      y.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportFeedBackClick %s", new Object[] { localStringBuffer.toString() });
      parambyf = new blf();
      parambyf.tEQ = localStringBuffer.toString();
      parambyf = new w(parambyf);
      g.Dk().a(parambyf, 0);
      return;
    }
    catch (UnsupportedEncodingException paramList)
    {
      break label305;
    }
  }
  
  public static void a(byg parambyg, int paramInt1, String paramString, int paramInt2)
  {
    int i;
    if (aq.isWifi(ae.getContext()))
    {
      i = 2;
      if (parambyg == null) {
        break label110;
      }
    }
    label110:
    for (parambyg = parambyg.qVw;; parambyg = "")
    {
      parambyg = String.format("%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramInt1), paramString, parambyg, Integer.valueOf(i), Integer.valueOf(paramInt2) });
      y.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportKvTopStoryVideoPlayError %s", new Object[] { parambyg });
      f.nEG.aC(15248, parambyg);
      return;
      if (!aq.isConnected(ae.getContext()))
      {
        i = 1;
        break;
      }
      i = 3;
      break;
    }
  }
  
  public static void a(ckw paramckw, bi parambi)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if (s.fn(parambi.field_talker)) {
      if (parambi.field_isSend == 1)
      {
        localObject1 = com.tencent.mm.model.q.Gj();
        localObject2 = parambi.field_talker;
        i = 2;
        parambi = (bi)localObject1;
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append("isShareClick=1");
        ((StringBuffer)localObject1).append("&relevant_vid=");
        ((StringBuffer)localObject1).append(paramckw.qTY);
        ((StringBuffer)localObject1).append("&relevant_pre_searchid=");
        ((StringBuffer)localObject1).append(paramckw.qUa);
        ((StringBuffer)localObject1).append("&relevant_shared_openid=");
        ((StringBuffer)localObject1).append(paramckw.qUb);
        ((StringBuffer)localObject1).append("&rec_category=");
        if (paramckw.qUk <= 0L) {
          break label291;
        }
        ((StringBuffer)localObject1).append(paramckw.qUk);
      }
    }
    for (;;)
    {
      ((StringBuffer)localObject1).append("&source=");
      ((StringBuffer)localObject1).append(paramckw.aWf);
      ((StringBuffer)localObject1).append("&fromUser=");
      ((StringBuffer)localObject1).append(parambi);
      ((StringBuffer)localObject1).append("&fromScene=");
      ((StringBuffer)localObject1).append(i);
      ((StringBuffer)localObject1).append("&targetInfo=");
      ((StringBuffer)localObject1).append((String)localObject2);
      y.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", new Object[] { ((StringBuffer)localObject1).toString() });
      paramckw = new blf();
      paramckw.tEQ = ((StringBuffer)localObject1).toString();
      paramckw = new w(paramckw);
      g.Dk().a(paramckw, 0);
      return;
      localObject1 = bd.iI(parambi.field_content);
      break;
      if (parambi.field_isSend == 1)
      {
        localObject2 = com.tencent.mm.model.q.Gj();
        localObject1 = parambi.field_talker;
        parambi = (bi)localObject2;
      }
      for (;;)
      {
        i = 1;
        localObject2 = localObject1;
        break;
        parambi = parambi.field_talker;
        localObject1 = com.tencent.mm.model.q.Gj();
      }
      label291:
      ((StringBuffer)localObject1).append(paramckw.qUc);
    }
  }
  
  public static final void b(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if ((!bk.bl(paramString1)) && (paramString1.startsWith("wrd"))) {}
    try
    {
      paramString1 = String.format("%s,%s,%s,%s", new Object[] { com.tencent.mm.compatible.util.q.encode(paramString2, "utf8"), Integer.valueOf(paramInt), paramString1, Long.valueOf(paramLong) });
      y.i("MicroMsg.TopStory.TopStoryReportApiLogic", "kvReportTopStoryOpenWebViewError 15728 %s", new Object[] { paramString1 });
      com.tencent.mm.plugin.report.service.h.nFQ.aC(15728, paramString1);
      return;
    }
    catch (UnsupportedEncodingException paramString1) {}
  }
  
  public static final void cB(String paramString, int paramInt)
  {
    if ((!bk.bl(paramString)) && (paramString.startsWith("wrd"))) {
      com.tencent.mm.plugin.report.service.h.nFQ.a(900L, paramInt, 1L, false);
    }
  }
  
  public static void zu(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      b.jdMethod_if(b.qVW);
    }
    for (;;)
    {
      a.jdMethod_if(7);
      return;
      b.jdMethod_if(b.qVJ);
      continue;
      b.jdMethod_if(b.qVK);
      continue;
      b.jdMethod_if(b.qVL);
      continue;
      b.jdMethod_if(b.qVM);
      continue;
      b.jdMethod_if(b.qVN);
      continue;
      b.jdMethod_if(b.qVO);
      continue;
      b.jdMethod_if(b.qVP);
      continue;
      b.jdMethod_if(b.qVQ);
      continue;
      b.jdMethod_if(b.qVR);
      continue;
      b.jdMethod_if(b.qVS);
      continue;
      b.jdMethod_if(b.qVT);
      continue;
      b.jdMethod_if(b.qVU);
      continue;
      b.jdMethod_if(b.qVV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.h
 * JD-Core Version:    0.7.0.1
 */