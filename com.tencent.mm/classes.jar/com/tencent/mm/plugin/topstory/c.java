package com.tencent.mm.plugin.topstory;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
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
  ap xuj;
  Map<Long, a> yLh;
  
  public c()
  {
    AppMethodBeat.i(88463);
    this.yLh = new ConcurrentHashMap();
    this.xuj = new ap("TopStoryReportExposeTask")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(88458);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(88458);
          return;
          ((c.a)paramAnonymousMessage.obj).run();
        }
      }
    };
    AppMethodBeat.o(88463);
  }
  
  public static void a(dcy paramdcy, ddb paramddb, b paramb)
  {
    AppMethodBeat.i(88465);
    ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay: %s %s", new Object[] { paramddb, paramb });
    if ((paramddb != null) && (paramb != null))
    {
      paramb.yLA = System.currentTimeMillis();
      paramb.yLB = (paramb.yLA - paramb.yLz);
      Object localObject = b(paramdcy, paramddb, paramb);
      if (!bt.isNullOrNil((String)localObject))
      {
        ckd localckd = new ckd();
        localckd.Eff = ((String)localObject);
        ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14436VideoPlayReportString %s", new Object[] { localckd.Eff });
        localObject = new s(localckd);
        g.aeS().a((n)localObject, 0);
      }
      if (paramb.yLS == null) {
        break label477;
      }
    }
    label477:
    for (int i = paramb.yLS.videoBitrate;; i = 0)
    {
      paramdcy = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramdcy.scene), paramddb.rNP, Long.valueOf(paramddb.EuU), "mp4", Integer.valueOf(paramddb.xot), Integer.valueOf(i), Long.valueOf(paramb.yLz), Long.valueOf(paramb.yLA), Long.valueOf(paramb.yLC), Long.valueOf(paramb.yLB), Long.valueOf(paramb.yLE), Long.valueOf(paramb.yLF), Long.valueOf(paramb.yLG), Long.valueOf(paramb.yLH), Long.valueOf(paramb.yLK), Long.valueOf(paramb.yLL), Long.valueOf(paramb.yLD), Long.valueOf(paramb.yLM), Long.valueOf(paramb.yLN), Long.valueOf(paramb.yLP), Long.valueOf(paramb.yLQ), paramb.gKw, Long.valueOf(paramb.position), aa.cWN(), Long.valueOf(paramb.yLO), Long.valueOf(paramb.yLR), Long.valueOf(paramb.yLI), Long.valueOf(paramb.yLJ), paramdcy.qwV });
      ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay 15414 %s", new Object[] { paramdcy });
      e.vIY.kvStat(15414, paramdcy);
      com.tencent.mm.plugin.topstory.a.a.a.a(paramb);
      AppMethodBeat.o(88465);
      return;
    }
  }
  
  private static String b(dcy paramdcy, ddb paramddb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(88467);
    StringBuilder localStringBuilder = new StringBuilder("");
    for (;;)
    {
      try
      {
        localStringBuilder.append("scene=");
        localStringBuilder.append(paramdcy.scene);
        localStringBuilder.append("&");
        localStringBuilder.append("businesstype=3");
        localStringBuilder.append("&");
        localStringBuilder.append("mediatype=2");
        localStringBuilder.append("&");
        localStringBuilder.append("docid=");
        localStringBuilder.append(paramddb.roQ);
        localStringBuilder.append("&");
        localStringBuilder.append("typepos=");
        localStringBuilder.append("0");
        localStringBuilder.append("&");
        localStringBuilder.append("docpos=");
        localStringBuilder.append(paramInt1 + 1);
        localStringBuilder.append("&");
        localStringBuilder.append("searchid=");
        localStringBuilder.append(paramdcy.jko);
        localStringBuilder.append("&");
        localStringBuilder.append("ishomepage=");
        localStringBuilder.append(0);
        localStringBuilder.append("&rec_category=");
        localStringBuilder.append(paramddb.EuN);
        localStringBuilder.append("&");
        localStringBuilder.append("timestamp=");
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append("&");
        localStringBuilder.append("clicktype=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("&");
        localStringBuilder.append("clickcontent=");
      }
      catch (Exception paramdcy)
      {
        continue;
      }
      try
      {
        localStringBuilder.append(p.encode(paramString, "utf-8"));
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
          localStringBuilder.append(p.encode(paramdcy.dcm, "utf-8"));
          localStringBuilder.append("&");
          localStringBuilder.append("resulttype=");
          localStringBuilder.append(paramddb.EuT);
          localStringBuilder.append("&");
          localStringBuilder.append("sessionid=");
          localStringBuilder.append(aa.RY(paramdcy.scene));
          localStringBuilder.append("&");
          localStringBuilder.append("expand=");
          try
          {
            localStringBuilder.append(p.encode(paramddb.EuP, "utf-8"));
            localStringBuilder.append("&");
            localStringBuilder.append("title=");
            try
            {
              localStringBuilder.append(p.encode(paramddb.title, "utf-8"));
              localStringBuilder.append("&");
              localStringBuilder.append("nettype=");
              if (ay.isWifi(aj.getContext()))
              {
                localStringBuilder.append("wifi");
                localStringBuilder.append("&");
                localStringBuilder.append("itemtype=");
                localStringBuilder.append(paramddb.EuQ);
                paramdcy = localStringBuilder.toString();
                AppMethodBeat.o(88467);
                return paramdcy;
              }
              if (ay.is4G(aj.getContext()))
              {
                localStringBuilder.append("4g");
                continue;
              }
              localStringBuilder.append("3g");
            }
            catch (Exception paramdcy) {}
          }
          catch (Exception paramdcy) {}
        }
        catch (Exception paramString) {}
      }
      catch (Exception paramString) {}
    }
  }
  
  private static String b(dcy paramdcy, ddb paramddb, b paramb)
  {
    AppMethodBeat.i(88468);
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("ismediaplay=1");
    localStringBuilder.append("&searchid=");
    localStringBuilder.append(paramdcy.jko);
    localStringBuilder.append("&scene=");
    localStringBuilder.append(paramdcy.scene);
    localStringBuilder.append("&businesstype=3");
    localStringBuilder.append("&mediatype=2");
    localStringBuilder.append("&rec_category=");
    localStringBuilder.append(paramdcy.Euy);
    localStringBuilder.append("&docid=");
    localStringBuilder.append(paramddb.roQ);
    localStringBuilder.append("&cdnsourcetype=");
    localStringBuilder.append(paramddb.Eva);
    try
    {
      localStringBuilder.append("&expand1=").append(p.encode(paramddb.EuP, "utf-8"));
      label146:
      localStringBuilder.append("&query=");
      try
      {
        localStringBuilder.append(p.encode(paramdcy.dcm, "utf-8"));
        label169:
        localStringBuilder.append("&title=");
        try
        {
          localStringBuilder.append(p.encode(paramddb.title, "utf-8"));
          label192:
          localStringBuilder.append("&duration=");
          localStringBuilder.append(paramddb.xot * 1000);
          localStringBuilder.append("&mediaid=");
          localStringBuilder.append(paramddb.rNP);
          if (paramb != null)
          {
            localStringBuilder.append("&startplaytime=");
            localStringBuilder.append(paramb.yLz);
            localStringBuilder.append("&endplaytime=");
            localStringBuilder.append(paramb.yLA);
            localStringBuilder.append("&playtime=");
            localStringBuilder.append(paramb.yLB);
            localStringBuilder.append("&lastplayms=");
            localStringBuilder.append(paramb.yLC);
            localStringBuilder.append("&autoplay=");
            localStringBuilder.append(paramb.yLG);
            localStringBuilder.append("&hasplayended=");
            localStringBuilder.append(paramb.yLD);
            localStringBuilder.append("&hasquickplay=");
            localStringBuilder.append(paramb.yLE);
            localStringBuilder.append("&hasfullscreen=");
            localStringBuilder.append(paramb.yLF);
            localStringBuilder.append("&hitpreload=");
            localStringBuilder.append(paramb.yLH);
            localStringBuilder.append("&firstloadtime=");
            localStringBuilder.append(paramb.yLK);
            localStringBuilder.append("&downloadfinishtime=");
            localStringBuilder.append(paramb.yLL);
            localStringBuilder.append("&firstmoovreadytime=");
            localStringBuilder.append(paramb.yLM);
            localStringBuilder.append("&firstdataavailabletime=");
            localStringBuilder.append(paramb.yLP);
            localStringBuilder.append("&filesize=");
            localStringBuilder.append(paramb.yLT);
            if (paramb.yLS != null)
            {
              localStringBuilder.append("&bitrate=");
              localStringBuilder.append(paramb.yLS.videoBitrate);
              localStringBuilder.append("&audiobitrate=");
              localStringBuilder.append(paramb.yLS.audioBitrate);
            }
          }
          paramdcy = localStringBuilder.toString();
          AppMethodBeat.o(88468);
          return paramdcy;
        }
        catch (Exception paramdcy)
        {
          break label192;
        }
      }
      catch (Exception paramdcy)
      {
        break label169;
      }
    }
    catch (Exception localException)
    {
      break label146;
    }
  }
  
  public final void a(dcy paramdcy, ddb paramddb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(88466);
    paramdcy = b(paramdcy, paramddb, paramInt1, paramInt2, paramString);
    if (!bt.isNullOrNil(paramdcy))
    {
      paramddb = new ckd();
      paramddb.Eff = paramdcy;
      ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "do12721ClickVideoReport %s", new Object[] { paramddb.Eff });
      paramdcy = new s(paramddb);
      g.aeS().a(paramdcy, 0);
    }
    AppMethodBeat.o(88466);
  }
  
  public final void a(dcy paramdcy, HashSet<com.tencent.mm.plugin.topstory.a.b.c> paramHashSet)
  {
    AppMethodBeat.i(88464);
    if (paramHashSet.size() == 0)
    {
      AppMethodBeat.o(88464);
      return;
    }
    a locala = (a)this.yLh.get(Long.valueOf(paramdcy.Euy));
    if ((locala != null) && (this.xuj.hasMessages(0)))
    {
      ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo hit cached task %d add %d", new Object[] { Integer.valueOf(locala.yLj.size()), Integer.valueOf(paramHashSet.size()) });
      paramdcy = paramHashSet.iterator();
      while (paramdcy.hasNext())
      {
        paramHashSet = (com.tencent.mm.plugin.topstory.a.b.c)paramdcy.next();
        locala.yLj.add(paramHashSet);
      }
      AppMethodBeat.o(88464);
      return;
    }
    if (locala != null) {
      ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo not report task: %s size: %d", new Object[] { locala, Integer.valueOf(locala.yLj.size()) });
    }
    locala = new a((byte)0);
    ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo new task %d %s", new Object[] { Integer.valueOf(paramHashSet.size()), locala });
    locala.createTime = System.currentTimeMillis();
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      com.tencent.mm.plugin.topstory.a.b.c localc = (com.tencent.mm.plugin.topstory.a.b.c)paramHashSet.next();
      locala.yLj.add(localc);
    }
    locala.yLk = paramdcy;
    if (locala.yLj.size() > 0)
    {
      this.xuj.removeMessages(0);
      this.xuj.sendMessageDelayed(this.xuj.obtainMessage(0, locala), 5000L);
      this.yLh.put(Long.valueOf(paramdcy.Euy), locala);
    }
    AppMethodBeat.o(88464);
  }
  
  final class a
    implements Runnable
  {
    long createTime;
    HashSet<com.tencent.mm.plugin.topstory.a.b.c> yLj;
    dcy yLk;
    
    private a()
    {
      AppMethodBeat.i(88460);
      this.yLj = new HashSet();
      AppMethodBeat.o(88460);
    }
    
    private static String a(List<com.tencent.mm.plugin.topstory.a.b.c> paramList, dcy paramdcy)
    {
      AppMethodBeat.i(88462);
      StringBuilder localStringBuilder1;
      try
      {
        int i = paramList.size();
        if (i == 0)
        {
          AppMethodBeat.o(88462);
          return null;
        }
        localStringBuilder1 = new StringBuilder("");
        localStringBuilder1.append("isexpose=1&content=");
        Object localObject1 = new StringBuilder("");
        Object localObject2 = paramList.iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject2).next();
          ddb localddb = ((com.tencent.mm.plugin.topstory.a.b.c)localObject3).yLU;
          ((StringBuilder)localObject1).append(localddb.dcn);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localddb.roQ);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.topstory.a.b.c)localObject3).rwE);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localddb.EuP);
          ((StringBuilder)localObject1).append(";");
        }
        try
        {
          localStringBuilder1.append(p.encode(((StringBuilder)localObject1).toString(), "utf-8"));
          localStringBuilder1.append("&resulttype=");
          localObject1 = paramList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject1).next()).yLU;
            localStringBuilder1.append(((ddb)localObject2).dcn);
            localStringBuilder1.append(":");
            localStringBuilder1.append(((ddb)localObject2).EuT);
            localStringBuilder1.append(";");
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", localException, "", new Object[0]);
          }
          localStringBuilder1.append("&expand=");
          localStringBuilder2 = new StringBuilder("");
          localObject2 = paramList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject2).next()).yLU;
            localStringBuilder2.append(((ddb)localObject3).dcn);
            localStringBuilder2.append(":");
            localStringBuilder2.append(((ddb)localObject3).EuR);
            localStringBuilder2.append(";");
          }
          try
          {
            localStringBuilder1.append(p.encode(localStringBuilder2.toString(), "utf-8"));
            localStringBuilder1.append("&itemtype=");
            localStringBuilder2 = new StringBuilder("");
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              localStringBuilder2.append(((com.tencent.mm.plugin.topstory.a.b.c)paramList.next()).yLU.EuQ);
              localStringBuilder2.append(";");
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", localUnsupportedEncodingException, "", new Object[0]);
            }
            localStringBuilder1.append(localUnsupportedEncodingException);
            if (paramdcy == null) {
              break label636;
            }
          }
          localStringBuilder1.append("&");
          localStringBuilder1.append("searchid=");
          localStringBuilder1.append(paramdcy.jko);
          localStringBuilder1.append("&");
          localStringBuilder1.append("query=");
        }
      }
      catch (Exception paramList)
      {
        ad.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", paramList, "build14057VideoInfoExposeString error: %s", new Object[] { paramList.getMessage() });
        AppMethodBeat.o(88462);
        return null;
      }
      try
      {
        StringBuilder localStringBuilder2;
        localStringBuilder1.append(p.encode(paramdcy.dcm, "utf-8"));
        localStringBuilder1.append("&");
        localStringBuilder1.append("ishomepage=0");
        localStringBuilder1.append("&");
        localStringBuilder1.append("sessionid=");
        localStringBuilder1.append(aa.RY(paramdcy.scene));
        localStringBuilder1.append("&");
        localStringBuilder1.append("scene=");
        localStringBuilder1.append(paramdcy.scene);
        localStringBuilder1.append("&rec_category=");
        localStringBuilder1.append(paramdcy.Euy);
        label636:
        paramList = localStringBuilder1.toString();
        AppMethodBeat.o(88462);
        return paramList;
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", paramList, "", new Object[0]);
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(88461);
      ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "Star to run ReportExposeTask");
      c.this.yLh.remove(Long.valueOf(this.yLk.Euy));
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.yLj);
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 20;
        if (j >= localArrayList.size()) {}
        for (List localList = localArrayList.subList(i, localArrayList.size());; localList = localArrayList.subList(i, j))
        {
          String str = a(localList, this.yLk);
          if (!bt.isNullOrNil(str))
          {
            final ckd localckd = new ckd();
            localckd.Eff = str;
            ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14057VideoInfoExposeString %d report string: %s", new Object[] { Integer.valueOf(localList.size()), localckd.Eff });
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(88459);
                s locals = new s(localckd);
                g.aeS().a(locals, 0);
                AppMethodBeat.o(88459);
              }
            });
          }
          if (j < localArrayList.size()) {
            break;
          }
          AppMethodBeat.o(88461);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.c
 * JD-Core Version:    0.7.0.1
 */