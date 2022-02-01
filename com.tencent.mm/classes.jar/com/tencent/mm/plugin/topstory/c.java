package com.tencent.mm.plugin.topstory;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
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
  ao yGZ;
  Map<Long, a> zZa;
  
  public c()
  {
    AppMethodBeat.i(88463);
    this.zZa = new ConcurrentHashMap();
    this.yGZ = new ao("TopStoryReportExposeTask")
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
  
  public static void a(dil paramdil, dio paramdio, b paramb)
  {
    AppMethodBeat.i(88465);
    ac.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay: %s %s", new Object[] { paramdio, paramb });
    if ((paramdio != null) && (paramb != null))
    {
      paramb.zZt = System.currentTimeMillis();
      paramb.zZu = (paramb.zZt - paramb.zZs);
      Object localObject = b(paramdil, paramdio, paramb);
      if (!bs.isNullOrNil((String)localObject))
      {
        cpk localcpk = new cpk();
        localcpk.FCf = ((String)localObject);
        ac.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14436VideoPlayReportString %s", new Object[] { localcpk.FCf });
        localObject = new r(localcpk);
        g.agi().a((n)localObject, 0);
      }
      if (paramb.zZL == null) {
        break label477;
      }
    }
    label477:
    for (int i = paramb.zZL.videoBitrate;; i = 0)
    {
      paramdil = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramdil.scene), paramdio.sVF, Long.valueOf(paramdio.FRV), "mp4", Integer.valueOf(paramdio.yBk), Integer.valueOf(i), Long.valueOf(paramb.zZs), Long.valueOf(paramb.zZt), Long.valueOf(paramb.zZv), Long.valueOf(paramb.zZu), Long.valueOf(paramb.zZx), Long.valueOf(paramb.zZy), Long.valueOf(paramb.zZz), Long.valueOf(paramb.zZA), Long.valueOf(paramb.zZD), Long.valueOf(paramb.zZE), Long.valueOf(paramb.zZw), Long.valueOf(paramb.zZF), Long.valueOf(paramb.zZG), Long.valueOf(paramb.zZI), Long.valueOf(paramb.zZJ), paramb.hkW, Long.valueOf(paramb.position), z.dkv(), Long.valueOf(paramb.zZH), Long.valueOf(paramb.zZK), Long.valueOf(paramb.zZB), Long.valueOf(paramb.zZC), paramdil.qox });
      ac.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay 15414 %s", new Object[] { paramdil });
      e.wTc.kvStat(15414, paramdil);
      com.tencent.mm.plugin.topstory.a.a.a.a(paramb);
      AppMethodBeat.o(88465);
      return;
    }
  }
  
  private static String b(dil paramdil, dio paramdio, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(88467);
    StringBuilder localStringBuilder = new StringBuilder("");
    for (;;)
    {
      try
      {
        localStringBuilder.append("scene=");
        localStringBuilder.append(paramdil.scene);
        localStringBuilder.append("&");
        localStringBuilder.append("businesstype=3");
        localStringBuilder.append("&");
        localStringBuilder.append("mediatype=2");
        localStringBuilder.append("&");
        localStringBuilder.append("docid=");
        localStringBuilder.append(paramdio.sxK);
        localStringBuilder.append("&");
        localStringBuilder.append("typepos=");
        localStringBuilder.append("0");
        localStringBuilder.append("&");
        localStringBuilder.append("docpos=");
        localStringBuilder.append(paramInt1 + 1);
        localStringBuilder.append("&");
        localStringBuilder.append("searchid=");
        localStringBuilder.append(paramdil.jKB);
        localStringBuilder.append("&");
        localStringBuilder.append("ishomepage=");
        localStringBuilder.append(0);
        localStringBuilder.append("&rec_category=");
        localStringBuilder.append(paramdio.FRO);
        localStringBuilder.append("&");
        localStringBuilder.append("timestamp=");
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append("&");
        localStringBuilder.append("clicktype=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("&");
        localStringBuilder.append("clickcontent=");
      }
      catch (Exception paramdil)
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
          localStringBuilder.append(p.encode(paramdil.cZL, "utf-8"));
          localStringBuilder.append("&");
          localStringBuilder.append("resulttype=");
          localStringBuilder.append(paramdio.FRU);
          localStringBuilder.append("&");
          localStringBuilder.append("sessionid=");
          localStringBuilder.append(z.Ui(paramdil.scene));
          localStringBuilder.append("&");
          localStringBuilder.append("expand=");
          try
          {
            localStringBuilder.append(p.encode(paramdio.FRQ, "utf-8"));
            localStringBuilder.append("&");
            localStringBuilder.append("title=");
            try
            {
              localStringBuilder.append(p.encode(paramdio.title, "utf-8"));
              localStringBuilder.append("&");
              localStringBuilder.append("nettype=");
              if (ax.isWifi(ai.getContext()))
              {
                localStringBuilder.append("wifi");
                localStringBuilder.append("&");
                localStringBuilder.append("itemtype=");
                localStringBuilder.append(paramdio.FRR);
                paramdil = localStringBuilder.toString();
                AppMethodBeat.o(88467);
                return paramdil;
              }
              if (ax.is4G(ai.getContext()))
              {
                localStringBuilder.append("4g");
                continue;
              }
              localStringBuilder.append("3g");
            }
            catch (Exception paramdil) {}
          }
          catch (Exception paramdil) {}
        }
        catch (Exception paramString) {}
      }
      catch (Exception paramString) {}
    }
  }
  
  private static String b(dil paramdil, dio paramdio, b paramb)
  {
    AppMethodBeat.i(88468);
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("ismediaplay=1");
    localStringBuilder.append("&searchid=");
    localStringBuilder.append(paramdil.jKB);
    localStringBuilder.append("&scene=");
    localStringBuilder.append(paramdil.scene);
    localStringBuilder.append("&businesstype=3");
    localStringBuilder.append("&mediatype=2");
    localStringBuilder.append("&rec_category=");
    localStringBuilder.append(paramdil.FRz);
    localStringBuilder.append("&docid=");
    localStringBuilder.append(paramdio.sxK);
    localStringBuilder.append("&cdnsourcetype=");
    localStringBuilder.append(paramdio.FSb);
    try
    {
      localStringBuilder.append("&expand1=").append(p.encode(paramdio.FRQ, "utf-8"));
      label146:
      localStringBuilder.append("&query=");
      try
      {
        localStringBuilder.append(p.encode(paramdil.cZL, "utf-8"));
        label169:
        localStringBuilder.append("&title=");
        try
        {
          localStringBuilder.append(p.encode(paramdio.title, "utf-8"));
          label192:
          localStringBuilder.append("&duration=");
          localStringBuilder.append(paramdio.yBk * 1000);
          localStringBuilder.append("&mediaid=");
          localStringBuilder.append(paramdio.sVF);
          if (paramb != null)
          {
            localStringBuilder.append("&startplaytime=");
            localStringBuilder.append(paramb.zZs);
            localStringBuilder.append("&endplaytime=");
            localStringBuilder.append(paramb.zZt);
            localStringBuilder.append("&playtime=");
            localStringBuilder.append(paramb.zZu);
            localStringBuilder.append("&lastplayms=");
            localStringBuilder.append(paramb.zZv);
            localStringBuilder.append("&autoplay=");
            localStringBuilder.append(paramb.zZz);
            localStringBuilder.append("&hasplayended=");
            localStringBuilder.append(paramb.zZw);
            localStringBuilder.append("&hasquickplay=");
            localStringBuilder.append(paramb.zZx);
            localStringBuilder.append("&hasfullscreen=");
            localStringBuilder.append(paramb.zZy);
            localStringBuilder.append("&hitpreload=");
            localStringBuilder.append(paramb.zZA);
            localStringBuilder.append("&firstloadtime=");
            localStringBuilder.append(paramb.zZD);
            localStringBuilder.append("&downloadfinishtime=");
            localStringBuilder.append(paramb.zZE);
            localStringBuilder.append("&firstmoovreadytime=");
            localStringBuilder.append(paramb.zZF);
            localStringBuilder.append("&firstdataavailabletime=");
            localStringBuilder.append(paramb.zZI);
            localStringBuilder.append("&filesize=");
            localStringBuilder.append(paramb.zZM);
            if (paramb.zZL != null)
            {
              localStringBuilder.append("&bitrate=");
              localStringBuilder.append(paramb.zZL.videoBitrate);
              localStringBuilder.append("&audiobitrate=");
              localStringBuilder.append(paramb.zZL.audioBitrate);
            }
          }
          paramdil = localStringBuilder.toString();
          AppMethodBeat.o(88468);
          return paramdil;
        }
        catch (Exception paramdil)
        {
          break label192;
        }
      }
      catch (Exception paramdil)
      {
        break label169;
      }
    }
    catch (Exception localException)
    {
      break label146;
    }
  }
  
  public final void a(dil paramdil, dio paramdio, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(88466);
    paramdil = b(paramdil, paramdio, paramInt1, paramInt2, paramString);
    if (!bs.isNullOrNil(paramdil))
    {
      paramdio = new cpk();
      paramdio.FCf = paramdil;
      ac.i("MicroMsg.TopStory.TopStoryReporterImpl", "do12721ClickVideoReport %s", new Object[] { paramdio.FCf });
      paramdil = new r(paramdio);
      g.agi().a(paramdil, 0);
    }
    AppMethodBeat.o(88466);
  }
  
  public final void a(dil paramdil, HashSet<com.tencent.mm.plugin.topstory.a.b.c> paramHashSet)
  {
    AppMethodBeat.i(88464);
    if (paramHashSet.size() == 0)
    {
      AppMethodBeat.o(88464);
      return;
    }
    a locala = (a)this.zZa.get(Long.valueOf(paramdil.FRz));
    if ((locala != null) && (this.yGZ.hasMessages(0)))
    {
      ac.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo hit cached task %d add %d", new Object[] { Integer.valueOf(locala.zZc.size()), Integer.valueOf(paramHashSet.size()) });
      paramdil = paramHashSet.iterator();
      while (paramdil.hasNext())
      {
        paramHashSet = (com.tencent.mm.plugin.topstory.a.b.c)paramdil.next();
        locala.zZc.add(paramHashSet);
      }
      AppMethodBeat.o(88464);
      return;
    }
    if (locala != null) {
      ac.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo not report task: %s size: %d", new Object[] { locala, Integer.valueOf(locala.zZc.size()) });
    }
    locala = new a((byte)0);
    ac.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo new task %d %s", new Object[] { Integer.valueOf(paramHashSet.size()), locala });
    locala.createTime = System.currentTimeMillis();
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      com.tencent.mm.plugin.topstory.a.b.c localc = (com.tencent.mm.plugin.topstory.a.b.c)paramHashSet.next();
      locala.zZc.add(localc);
    }
    locala.zZd = paramdil;
    if (locala.zZc.size() > 0)
    {
      this.yGZ.removeMessages(0);
      this.yGZ.sendMessageDelayed(this.yGZ.obtainMessage(0, locala), 5000L);
      this.zZa.put(Long.valueOf(paramdil.FRz), locala);
    }
    AppMethodBeat.o(88464);
  }
  
  final class a
    implements Runnable
  {
    long createTime;
    HashSet<com.tencent.mm.plugin.topstory.a.b.c> zZc;
    dil zZd;
    
    private a()
    {
      AppMethodBeat.i(88460);
      this.zZc = new HashSet();
      AppMethodBeat.o(88460);
    }
    
    private static String a(List<com.tencent.mm.plugin.topstory.a.b.c> paramList, dil paramdil)
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
          dio localdio = ((com.tencent.mm.plugin.topstory.a.b.c)localObject3).zZN;
          ((StringBuilder)localObject1).append(localdio.cZM);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localdio.sxK);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.topstory.a.b.c)localObject3).sFw);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localdio.FRQ);
          ((StringBuilder)localObject1).append(";");
        }
        try
        {
          localStringBuilder1.append(p.encode(((StringBuilder)localObject1).toString(), "utf-8"));
          localStringBuilder1.append("&resulttype=");
          localObject1 = paramList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject1).next()).zZN;
            localStringBuilder1.append(((dio)localObject2).cZM);
            localStringBuilder1.append(":");
            localStringBuilder1.append(((dio)localObject2).FRU);
            localStringBuilder1.append(";");
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", localException, "", new Object[0]);
          }
          localStringBuilder1.append("&expand=");
          localStringBuilder2 = new StringBuilder("");
          localObject2 = paramList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject2).next()).zZN;
            localStringBuilder2.append(((dio)localObject3).cZM);
            localStringBuilder2.append(":");
            localStringBuilder2.append(((dio)localObject3).FRS);
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
              localStringBuilder2.append(((com.tencent.mm.plugin.topstory.a.b.c)paramList.next()).zZN.FRR);
              localStringBuilder2.append(";");
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", localUnsupportedEncodingException, "", new Object[0]);
            }
            localStringBuilder1.append(localUnsupportedEncodingException);
            if (paramdil == null) {
              break label636;
            }
          }
          localStringBuilder1.append("&");
          localStringBuilder1.append("searchid=");
          localStringBuilder1.append(paramdil.jKB);
          localStringBuilder1.append("&");
          localStringBuilder1.append("query=");
        }
      }
      catch (Exception paramList)
      {
        ac.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", paramList, "build14057VideoInfoExposeString error: %s", new Object[] { paramList.getMessage() });
        AppMethodBeat.o(88462);
        return null;
      }
      try
      {
        StringBuilder localStringBuilder2;
        localStringBuilder1.append(p.encode(paramdil.cZL, "utf-8"));
        localStringBuilder1.append("&");
        localStringBuilder1.append("ishomepage=0");
        localStringBuilder1.append("&");
        localStringBuilder1.append("sessionid=");
        localStringBuilder1.append(z.Ui(paramdil.scene));
        localStringBuilder1.append("&");
        localStringBuilder1.append("scene=");
        localStringBuilder1.append(paramdil.scene);
        localStringBuilder1.append("&rec_category=");
        localStringBuilder1.append(paramdil.FRz);
        label636:
        paramList = localStringBuilder1.toString();
        AppMethodBeat.o(88462);
        return paramList;
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", paramList, "", new Object[0]);
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(88461);
      ac.i("MicroMsg.TopStory.TopStoryReporterImpl", "Star to run ReportExposeTask");
      c.this.zZa.remove(Long.valueOf(this.zZd.FRz));
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.zZc);
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 20;
        if (j >= localArrayList.size()) {}
        for (List localList = localArrayList.subList(i, localArrayList.size());; localList = localArrayList.subList(i, j))
        {
          String str = a(localList, this.zZd);
          if (!bs.isNullOrNil(str))
          {
            final cpk localcpk = new cpk();
            localcpk.FCf = str;
            ac.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14057VideoInfoExposeString %d report string: %s", new Object[] { Integer.valueOf(localList.size()), localcpk.FCf });
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(88459);
                r localr = new r(localcpk);
                g.agi().a(localr, 0);
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