package com.tencent.mm.plugin.topstory;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dod;
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
  Map<Long, a> BqM;
  ap zYs;
  
  public c()
  {
    AppMethodBeat.i(88463);
    this.BqM = new ConcurrentHashMap();
    this.zYs = new ap("TopStoryReportExposeTask")
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
  
  public static void a(doa paramdoa, dod paramdod, b paramb)
  {
    AppMethodBeat.i(88465);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay: %s %s", new Object[] { paramdod, paramb });
    if ((paramdod != null) && (paramb != null))
    {
      paramb.Brf = System.currentTimeMillis();
      paramb.Brg = (paramb.Brf - paramb.Bre);
      Object localObject = b(paramdoa, paramdod, paramb);
      if (!bt.isNullOrNil((String)localObject))
      {
        cup localcup = new cup();
        localcup.Hmu = ((String)localObject);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14436VideoPlayReportString %s", new Object[] { localcup.Hmu });
        localObject = new u(localcup);
        g.aiU().a((n)localObject, 0);
      }
      if (paramb.Brx == null) {
        break label477;
      }
    }
    label477:
    for (int i = paramb.Brx.videoBitrate;; i = 0)
    {
      paramdoa = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramdoa.scene), paramdod.tSk, Long.valueOf(paramdod.HCB), "mp4", Integer.valueOf(paramdod.zSz), Integer.valueOf(i), Long.valueOf(paramb.Bre), Long.valueOf(paramb.Brf), Long.valueOf(paramb.Brh), Long.valueOf(paramb.Brg), Long.valueOf(paramb.Brj), Long.valueOf(paramb.Brk), Long.valueOf(paramb.Brl), Long.valueOf(paramb.Brm), Long.valueOf(paramb.Brp), Long.valueOf(paramb.Brq), Long.valueOf(paramb.Bri), Long.valueOf(paramb.Brr), Long.valueOf(paramb.Brs), Long.valueOf(paramb.Bru), Long.valueOf(paramb.Brv), paramb.hDf, Long.valueOf(paramb.position), com.tencent.mm.plugin.websearch.api.ad.Ux(), Long.valueOf(paramb.Brt), Long.valueOf(paramb.Brw), Long.valueOf(paramb.Brn), Long.valueOf(paramb.Bro), paramdoa.qXu });
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay 15414 %s", new Object[] { paramdoa });
      e.ygI.kvStat(15414, paramdoa);
      com.tencent.mm.plugin.topstory.a.a.a.a(paramb);
      AppMethodBeat.o(88465);
      return;
    }
  }
  
  private static String b(doa paramdoa, dod paramdod, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(88467);
    StringBuilder localStringBuilder = new StringBuilder("");
    for (;;)
    {
      try
      {
        localStringBuilder.append("scene=");
        localStringBuilder.append(paramdoa.scene);
        localStringBuilder.append("&");
        localStringBuilder.append("businesstype=3");
        localStringBuilder.append("&");
        localStringBuilder.append("mediatype=2");
        localStringBuilder.append("&");
        localStringBuilder.append("docid=");
        localStringBuilder.append(paramdod.tul);
        localStringBuilder.append("&");
        localStringBuilder.append("typepos=");
        localStringBuilder.append("0");
        localStringBuilder.append("&");
        localStringBuilder.append("docpos=");
        localStringBuilder.append(paramInt1 + 1);
        localStringBuilder.append("&");
        localStringBuilder.append("searchid=");
        localStringBuilder.append(paramdoa.keN);
        localStringBuilder.append("&");
        localStringBuilder.append("ishomepage=");
        localStringBuilder.append(0);
        localStringBuilder.append("&rec_category=");
        localStringBuilder.append(paramdod.HCu);
        localStringBuilder.append("&");
        localStringBuilder.append("timestamp=");
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append("&");
        localStringBuilder.append("clicktype=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("&");
        localStringBuilder.append("clickcontent=");
      }
      catch (Exception paramdoa)
      {
        continue;
      }
      try
      {
        localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(paramString, "utf-8"));
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
          localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(paramdoa.dld, "utf-8"));
          localStringBuilder.append("&");
          localStringBuilder.append("resulttype=");
          localStringBuilder.append(paramdod.HCA);
          localStringBuilder.append("&");
          localStringBuilder.append("sessionid=");
          localStringBuilder.append(com.tencent.mm.plugin.websearch.api.ad.Wb(paramdoa.scene));
          localStringBuilder.append("&");
          localStringBuilder.append("expand=");
          try
          {
            localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(paramdod.HCw, "utf-8"));
            localStringBuilder.append("&");
            localStringBuilder.append("title=");
            try
            {
              localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(paramdod.title, "utf-8"));
              localStringBuilder.append("&");
              localStringBuilder.append("nettype=");
              if (ay.isWifi(aj.getContext()))
              {
                localStringBuilder.append("wifi");
                localStringBuilder.append("&");
                localStringBuilder.append("itemtype=");
                localStringBuilder.append(paramdod.HCx);
                paramdoa = localStringBuilder.toString();
                AppMethodBeat.o(88467);
                return paramdoa;
              }
              if (ay.is4G(aj.getContext()))
              {
                localStringBuilder.append("4g");
                continue;
              }
              localStringBuilder.append("3g");
            }
            catch (Exception paramdoa) {}
          }
          catch (Exception paramdoa) {}
        }
        catch (Exception paramString) {}
      }
      catch (Exception paramString) {}
    }
  }
  
  private static String b(doa paramdoa, dod paramdod, b paramb)
  {
    AppMethodBeat.i(88468);
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("ismediaplay=1");
    localStringBuilder.append("&searchid=");
    localStringBuilder.append(paramdoa.keN);
    localStringBuilder.append("&scene=");
    localStringBuilder.append(paramdoa.scene);
    localStringBuilder.append("&businesstype=3");
    localStringBuilder.append("&mediatype=2");
    localStringBuilder.append("&rec_category=");
    localStringBuilder.append(paramdoa.HCf);
    localStringBuilder.append("&docid=");
    localStringBuilder.append(paramdod.tul);
    localStringBuilder.append("&cdnsourcetype=");
    localStringBuilder.append(paramdod.HCH);
    try
    {
      localStringBuilder.append("&expand1=").append(com.tencent.mm.compatible.util.q.encode(paramdod.HCw, "utf-8"));
      label146:
      localStringBuilder.append("&query=");
      try
      {
        localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(paramdoa.dld, "utf-8"));
        label169:
        localStringBuilder.append("&title=");
        try
        {
          localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(paramdod.title, "utf-8"));
          label192:
          localStringBuilder.append("&duration=");
          localStringBuilder.append(paramdod.zSz * 1000);
          localStringBuilder.append("&mediaid=");
          localStringBuilder.append(paramdod.tSk);
          if (paramb != null)
          {
            localStringBuilder.append("&startplaytime=");
            localStringBuilder.append(paramb.Bre);
            localStringBuilder.append("&endplaytime=");
            localStringBuilder.append(paramb.Brf);
            localStringBuilder.append("&playtime=");
            localStringBuilder.append(paramb.Brg);
            localStringBuilder.append("&lastplayms=");
            localStringBuilder.append(paramb.Brh);
            localStringBuilder.append("&autoplay=");
            localStringBuilder.append(paramb.Brl);
            localStringBuilder.append("&hasplayended=");
            localStringBuilder.append(paramb.Bri);
            localStringBuilder.append("&hasquickplay=");
            localStringBuilder.append(paramb.Brj);
            localStringBuilder.append("&hasfullscreen=");
            localStringBuilder.append(paramb.Brk);
            localStringBuilder.append("&hitpreload=");
            localStringBuilder.append(paramb.Brm);
            localStringBuilder.append("&firstloadtime=");
            localStringBuilder.append(paramb.Brp);
            localStringBuilder.append("&downloadfinishtime=");
            localStringBuilder.append(paramb.Brq);
            localStringBuilder.append("&firstmoovreadytime=");
            localStringBuilder.append(paramb.Brr);
            localStringBuilder.append("&firstdataavailabletime=");
            localStringBuilder.append(paramb.Bru);
            localStringBuilder.append("&filesize=");
            localStringBuilder.append(paramb.Bry);
            if (paramb.Brx != null)
            {
              localStringBuilder.append("&bitrate=");
              localStringBuilder.append(paramb.Brx.videoBitrate);
              localStringBuilder.append("&audiobitrate=");
              localStringBuilder.append(paramb.Brx.audioBitrate);
            }
          }
          paramdoa = localStringBuilder.toString();
          AppMethodBeat.o(88468);
          return paramdoa;
        }
        catch (Exception paramdoa)
        {
          break label192;
        }
      }
      catch (Exception paramdoa)
      {
        break label169;
      }
    }
    catch (Exception localException)
    {
      break label146;
    }
  }
  
  public final void a(doa paramdoa, dod paramdod, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(88466);
    paramdoa = b(paramdoa, paramdod, paramInt1, paramInt2, paramString);
    if (!bt.isNullOrNil(paramdoa))
    {
      paramdod = new cup();
      paramdod.Hmu = paramdoa;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "do12721ClickVideoReport %s", new Object[] { paramdod.Hmu });
      paramdoa = new u(paramdod);
      g.aiU().a(paramdoa, 0);
    }
    AppMethodBeat.o(88466);
  }
  
  public final void a(doa paramdoa, HashSet<com.tencent.mm.plugin.topstory.a.b.c> paramHashSet)
  {
    AppMethodBeat.i(88464);
    if (paramHashSet.size() == 0)
    {
      AppMethodBeat.o(88464);
      return;
    }
    a locala = (a)this.BqM.get(Long.valueOf(paramdoa.HCf));
    if ((locala != null) && (this.zYs.hasMessages(0)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo hit cached task %d add %d", new Object[] { Integer.valueOf(locala.BqO.size()), Integer.valueOf(paramHashSet.size()) });
      paramdoa = paramHashSet.iterator();
      while (paramdoa.hasNext())
      {
        paramHashSet = (com.tencent.mm.plugin.topstory.a.b.c)paramdoa.next();
        locala.BqO.add(paramHashSet);
      }
      AppMethodBeat.o(88464);
      return;
    }
    if (locala != null) {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo not report task: %s size: %d", new Object[] { locala, Integer.valueOf(locala.BqO.size()) });
    }
    locala = new a((byte)0);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo new task %d %s", new Object[] { Integer.valueOf(paramHashSet.size()), locala });
    locala.createTime = System.currentTimeMillis();
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      com.tencent.mm.plugin.topstory.a.b.c localc = (com.tencent.mm.plugin.topstory.a.b.c)paramHashSet.next();
      locala.BqO.add(localc);
    }
    locala.BqP = paramdoa;
    if (locala.BqO.size() > 0)
    {
      this.zYs.removeMessages(0);
      this.zYs.sendMessageDelayed(this.zYs.obtainMessage(0, locala), 5000L);
      this.BqM.put(Long.valueOf(paramdoa.HCf), locala);
    }
    AppMethodBeat.o(88464);
  }
  
  final class a
    implements Runnable
  {
    HashSet<com.tencent.mm.plugin.topstory.a.b.c> BqO;
    doa BqP;
    long createTime;
    
    private a()
    {
      AppMethodBeat.i(88460);
      this.BqO = new HashSet();
      AppMethodBeat.o(88460);
    }
    
    private static String a(List<com.tencent.mm.plugin.topstory.a.b.c> paramList, doa paramdoa)
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
          dod localdod = ((com.tencent.mm.plugin.topstory.a.b.c)localObject3).Brz;
          ((StringBuilder)localObject1).append(localdod.dle);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localdod.tul);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.topstory.a.b.c)localObject3).tCq);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localdod.HCw);
          ((StringBuilder)localObject1).append(";");
        }
        try
        {
          localStringBuilder1.append(com.tencent.mm.compatible.util.q.encode(((StringBuilder)localObject1).toString(), "utf-8"));
          localStringBuilder1.append("&resulttype=");
          localObject1 = paramList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject1).next()).Brz;
            localStringBuilder1.append(((dod)localObject2).dle);
            localStringBuilder1.append(":");
            localStringBuilder1.append(((dod)localObject2).HCA);
            localStringBuilder1.append(";");
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", localException, "", new Object[0]);
          }
          localStringBuilder1.append("&expand=");
          localStringBuilder2 = new StringBuilder("");
          localObject2 = paramList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject2).next()).Brz;
            localStringBuilder2.append(((dod)localObject3).dle);
            localStringBuilder2.append(":");
            localStringBuilder2.append(((dod)localObject3).HCy);
            localStringBuilder2.append(";");
          }
          try
          {
            localStringBuilder1.append(com.tencent.mm.compatible.util.q.encode(localStringBuilder2.toString(), "utf-8"));
            localStringBuilder1.append("&itemtype=");
            localStringBuilder2 = new StringBuilder("");
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              localStringBuilder2.append(((com.tencent.mm.plugin.topstory.a.b.c)paramList.next()).Brz.HCx);
              localStringBuilder2.append(";");
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", localUnsupportedEncodingException, "", new Object[0]);
            }
            localStringBuilder1.append(localUnsupportedEncodingException);
            if (paramdoa == null) {
              break label636;
            }
          }
          localStringBuilder1.append("&");
          localStringBuilder1.append("searchid=");
          localStringBuilder1.append(paramdoa.keN);
          localStringBuilder1.append("&");
          localStringBuilder1.append("query=");
        }
      }
      catch (Exception paramList)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", paramList, "build14057VideoInfoExposeString error: %s", new Object[] { paramList.getMessage() });
        AppMethodBeat.o(88462);
        return null;
      }
      try
      {
        StringBuilder localStringBuilder2;
        localStringBuilder1.append(com.tencent.mm.compatible.util.q.encode(paramdoa.dld, "utf-8"));
        localStringBuilder1.append("&");
        localStringBuilder1.append("ishomepage=0");
        localStringBuilder1.append("&");
        localStringBuilder1.append("sessionid=");
        localStringBuilder1.append(com.tencent.mm.plugin.websearch.api.ad.Wb(paramdoa.scene));
        localStringBuilder1.append("&");
        localStringBuilder1.append("scene=");
        localStringBuilder1.append(paramdoa.scene);
        localStringBuilder1.append("&rec_category=");
        localStringBuilder1.append(paramdoa.HCf);
        label636:
        paramList = localStringBuilder1.toString();
        AppMethodBeat.o(88462);
        return paramList;
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", paramList, "", new Object[0]);
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(88461);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "Star to run ReportExposeTask");
      c.this.BqM.remove(Long.valueOf(this.BqP.HCf));
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.BqO);
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 20;
        if (j >= localArrayList.size()) {}
        for (List localList = localArrayList.subList(i, localArrayList.size());; localList = localArrayList.subList(i, j))
        {
          String str = a(localList, this.BqP);
          if (!bt.isNullOrNil(str))
          {
            final cup localcup = new cup();
            localcup.Hmu = str;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14057VideoInfoExposeString %d report string: %s", new Object[] { Integer.valueOf(localList.size()), localcup.Hmu });
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(88459);
                u localu = new u(localcup);
                g.aiU().a(localu, 0);
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