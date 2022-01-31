package com.tencent.mm.plugin.topstory;

import android.os.HandlerThread;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.b.a;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
  implements f
{
  ah pCV = new c.1(this, new ai("TopStoryReportExposeTask").mnU.getLooper());
  Map<Long, a> pCW = new ConcurrentHashMap();
  
  public static String a(byf parambyf, byg parambyg, a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("ismediaplay=1");
    localStringBuilder.append("&searchid=");
    localStringBuilder.append(parambyf.fTF);
    localStringBuilder.append("&scene=");
    localStringBuilder.append(parambyf.scene);
    localStringBuilder.append("&businesstype=3");
    localStringBuilder.append("&mediatype=2");
    localStringBuilder.append("&rec_category=");
    localStringBuilder.append(parambyf.tOo);
    localStringBuilder.append("&docid=");
    localStringBuilder.append(parambyg.qVw);
    localStringBuilder.append("&query=");
    try
    {
      localStringBuilder.append(q.encode(parambyf.bGm, "utf-8"));
      label116:
      localStringBuilder.append("&title=");
      try
      {
        localStringBuilder.append(q.encode(parambyg.title, "utf-8"));
        label137:
        localStringBuilder.append("&duration=");
        localStringBuilder.append(parambyg.tOw * 1000);
        localStringBuilder.append("&mediaid=");
        localStringBuilder.append(parambyg.tOx);
        if (parama != null)
        {
          localStringBuilder.append("&startplaytime=");
          localStringBuilder.append(parama.pDe);
          localStringBuilder.append("&endplaytime=");
          localStringBuilder.append(parama.pDf);
          localStringBuilder.append("&playtime=");
          localStringBuilder.append(parama.pDg);
          localStringBuilder.append("&lastplayms=");
          localStringBuilder.append(parama.pDh);
          localStringBuilder.append("&autoplay=");
          localStringBuilder.append(parama.pDl);
          localStringBuilder.append("&hasplayended=");
          localStringBuilder.append(parama.pDi);
          localStringBuilder.append("&hasquickplay=");
          localStringBuilder.append(parama.pDj);
          localStringBuilder.append("&hasfullscreen=");
          localStringBuilder.append(parama.pDk);
          localStringBuilder.append("&hitpreload=");
          localStringBuilder.append(parama.pDm);
          localStringBuilder.append("&firstloadtime=");
          localStringBuilder.append(parama.pDp);
          localStringBuilder.append("&downloadfinishtime=");
          localStringBuilder.append(parama.pDq);
          localStringBuilder.append("&firstmoovreadytime=");
          localStringBuilder.append(parama.pDr);
          localStringBuilder.append("&firstdataavailabletime=");
          localStringBuilder.append(parama.pDu);
        }
        return localStringBuilder.toString();
      }
      catch (Exception parambyf)
      {
        break label137;
      }
    }
    catch (Exception parambyf)
    {
      break label116;
    }
  }
  
  private static String b(byf parambyf, byg parambyg, int paramInt1, int paramInt2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    for (;;)
    {
      try
      {
        localStringBuilder.append("scene=");
        localStringBuilder.append(parambyf.scene);
        localStringBuilder.append("&");
        localStringBuilder.append("businesstype=3");
        localStringBuilder.append("&");
        localStringBuilder.append("mediatype=2");
        localStringBuilder.append("&");
        localStringBuilder.append("docid=");
        localStringBuilder.append(parambyg.qVw);
        localStringBuilder.append("&");
        localStringBuilder.append("typepos=");
        localStringBuilder.append("0");
        localStringBuilder.append("&");
        localStringBuilder.append("docpos=");
        localStringBuilder.append(paramInt1 + 1);
        localStringBuilder.append("&");
        localStringBuilder.append("searchid=");
        localStringBuilder.append(parambyf.fTF);
        localStringBuilder.append("&");
        localStringBuilder.append("ishomepage=");
        localStringBuilder.append(0);
        localStringBuilder.append("&rec_category=");
        localStringBuilder.append(parambyg.tOy);
        localStringBuilder.append("&");
        localStringBuilder.append("timestamp=");
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append("&");
        localStringBuilder.append("clicktype=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("&");
        localStringBuilder.append("clickcontent=");
      }
      catch (Exception parambyf)
      {
        continue;
      }
      try
      {
        localStringBuilder.append(q.encode(paramString, "utf-8"));
        localStringBuilder.append("&");
        localStringBuilder.append("clicksource=");
        localStringBuilder.append("4");
        localStringBuilder.append("&");
        localStringBuilder.append("sceneactiontype=");
        localStringBuilder.append(1);
        localStringBuilder.append("&");
        localStringBuilder.append("query=");
        try
        {
          localStringBuilder.append(q.encode(parambyf.bGm, "utf-8"));
          localStringBuilder.append("&");
          localStringBuilder.append("resulttype=");
          localStringBuilder.append(parambyg.tOE);
          localStringBuilder.append("&");
          localStringBuilder.append("sessionid=");
          localStringBuilder.append(aa.Bm(parambyf.scene));
          localStringBuilder.append("&");
          localStringBuilder.append("expand=");
          try
          {
            localStringBuilder.append(q.encode(parambyg.tOA, "utf-8"));
            localStringBuilder.append("&");
            localStringBuilder.append("title=");
            try
            {
              localStringBuilder.append(q.encode(parambyg.title, "utf-8"));
              localStringBuilder.append("&");
              localStringBuilder.append("nettype=");
              if (aq.isWifi(ae.getContext()))
              {
                localStringBuilder.append("wifi");
                localStringBuilder.append("&");
                localStringBuilder.append("itemtype=");
                localStringBuilder.append(parambyg.tOB);
                return localStringBuilder.toString();
              }
              if (aq.is4G(ae.getContext()))
              {
                localStringBuilder.append("4g");
                continue;
              }
              localStringBuilder.append("3g");
            }
            catch (Exception parambyf) {}
          }
          catch (Exception parambyf) {}
        }
        catch (Exception paramString) {}
      }
      catch (Exception paramString) {}
    }
  }
  
  public final void a(byf parambyf, byg parambyg, int paramInt1, int paramInt2, String paramString)
  {
    parambyf = b(parambyf, parambyg, paramInt1, paramInt2, paramString);
    if (!bk.bl(parambyf))
    {
      parambyg = new blf();
      parambyg.tEQ = parambyf;
      y.i("MicroMsg.TopStory.TopStoryReporterImpl", "do12721ClickVideoReport %s", new Object[] { parambyg.tEQ });
      parambyf = new w(parambyg);
      g.Dk().a(parambyf, 0);
    }
  }
  
  public final void a(byf parambyf, HashSet<b> paramHashSet)
  {
    if (paramHashSet.size() == 0) {}
    a locala;
    do
    {
      for (;;)
      {
        return;
        locala = (a)this.pCW.get(Long.valueOf(parambyf.tOo));
        if ((locala == null) || (!this.pCV.hasMessages(0))) {
          break;
        }
        y.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo hit cached task %d add %d", new Object[] { Integer.valueOf(locala.pCY.size()), Integer.valueOf(paramHashSet.size()) });
        parambyf = paramHashSet.iterator();
        while (parambyf.hasNext())
        {
          paramHashSet = (b)parambyf.next();
          locala.pCY.add(paramHashSet);
        }
      }
      if (locala != null) {
        y.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo not report task: %s size: %d", new Object[] { locala, Integer.valueOf(locala.pCY.size()) });
      }
      locala = new a((byte)0);
      y.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo new task %d %s", new Object[] { Integer.valueOf(paramHashSet.size()), locala });
      locala.createTime = System.currentTimeMillis();
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext())
      {
        b localb = (b)paramHashSet.next();
        locala.pCY.add(localb);
      }
      locala.pCZ = parambyf;
    } while (locala.pCY.size() <= 0);
    this.pCV.removeMessages(0);
    this.pCV.sendMessageDelayed(this.pCV.obtainMessage(0, locala), 5000L);
    this.pCW.put(Long.valueOf(parambyf.tOo), locala);
  }
  
  private final class a
    implements Runnable
  {
    long createTime;
    HashSet<b> pCY = new HashSet();
    byf pCZ;
    
    private a() {}
    
    private static String a(List<b> paramList, byf parambyf)
    {
      StringBuilder localStringBuilder1;
      try
      {
        if (paramList.size() == 0) {
          return null;
        }
        localStringBuilder1 = new StringBuilder("");
        localStringBuilder1.append("isexpose=1&content=");
        Object localObject1 = new StringBuilder("");
        Object localObject2 = paramList.iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (b)((Iterator)localObject2).next();
          byg localbyg = ((b)localObject3).pDy;
          ((StringBuilder)localObject1).append(localbyg.bGn);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localbyg.qVw);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(((b)localObject3).kDV);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localbyg.tOA);
          ((StringBuilder)localObject1).append(";");
        }
        try
        {
          localStringBuilder1.append(q.encode(((StringBuilder)localObject1).toString(), "utf-8"));
          localStringBuilder1.append("&resulttype=");
          localObject1 = paramList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((b)((Iterator)localObject1).next()).pDy;
            localStringBuilder1.append(((byg)localObject2).bGn);
            localStringBuilder1.append(":");
            localStringBuilder1.append(((byg)localObject2).tOE);
            localStringBuilder1.append(";");
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", localException, "", new Object[0]);
          }
          localStringBuilder1.append("&expand=");
          localStringBuilder2 = new StringBuilder("");
          localObject2 = paramList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((b)((Iterator)localObject2).next()).pDy;
            localStringBuilder2.append(((byg)localObject3).bGn);
            localStringBuilder2.append(":");
            localStringBuilder2.append(((byg)localObject3).tOC);
            localStringBuilder2.append(";");
          }
          try
          {
            localStringBuilder1.append(q.encode(localStringBuilder2.toString(), "utf-8"));
            localStringBuilder1.append("&itemtype=");
            localStringBuilder2 = new StringBuilder("");
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              localStringBuilder2.append(((b)paramList.next()).pDy.tOB);
              localStringBuilder2.append(";");
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              y.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", localUnsupportedEncodingException, "", new Object[0]);
            }
            localStringBuilder1.append(localUnsupportedEncodingException);
            if (parambyf == null) {
              break label592;
            }
          }
          localStringBuilder1.append("&");
          localStringBuilder1.append("searchid=");
          localStringBuilder1.append(parambyf.fTF);
          localStringBuilder1.append("&");
          localStringBuilder1.append("query=");
        }
      }
      catch (Exception paramList)
      {
        y.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", paramList, "build14057VideoInfoExposeString error: %s", new Object[] { paramList.getMessage() });
        return null;
      }
      try
      {
        StringBuilder localStringBuilder2;
        localStringBuilder1.append(q.encode(parambyf.bGm, "utf-8"));
        localStringBuilder1.append("&");
        localStringBuilder1.append("ishomepage=0");
        localStringBuilder1.append("&");
        localStringBuilder1.append("sessionid=");
        localStringBuilder1.append(aa.Bm(parambyf.scene));
        localStringBuilder1.append("&");
        localStringBuilder1.append("scene=");
        localStringBuilder1.append(parambyf.scene);
        localStringBuilder1.append("&rec_category=");
        localStringBuilder1.append(parambyf.tOo);
        label592:
        return localStringBuilder1.toString();
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", paramList, "", new Object[0]);
        }
      }
    }
    
    public final void run()
    {
      y.i("MicroMsg.TopStory.TopStoryReporterImpl", "Star to run ReportExposeTask");
      c.this.pCW.remove(Long.valueOf(this.pCZ.tOo));
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.pCY);
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 20;
        if (j >= localArrayList.size()) {}
        for (List localList = localArrayList.subList(i, localArrayList.size());; localList = localArrayList.subList(i, j))
        {
          String str = a(localList, this.pCZ);
          if (!bk.bl(str))
          {
            blf localblf = new blf();
            localblf.tEQ = str;
            y.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14057VideoInfoExposeString %d report string: %s", new Object[] { Integer.valueOf(localList.size()), localblf.tEQ });
            ai.d(new c.a.1(this, localblf));
          }
          if (j < localArrayList.size()) {
            break;
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.c
 * JD-Core Version:    0.7.0.1
 */