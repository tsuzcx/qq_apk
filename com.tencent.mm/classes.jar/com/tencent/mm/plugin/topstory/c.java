package com.tencent.mm.plugin.topstory;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.topstory.a.a.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c
  implements com.tencent.mm.plugin.topstory.a.f
{
  MMHandler KMg;
  private Map<Long, a> MVF;
  
  public c()
  {
    AppMethodBeat.i(88463);
    this.MVF = new ConcurrentHashMap();
    this.KMg = new MMHandler("TopStoryReportExposeTask")
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
  
  public static void a(esv paramesv, esy paramesy, com.tencent.mm.plugin.topstory.a.b.b paramb)
  {
    AppMethodBeat.i(88465);
    Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay: %s %s", new Object[] { paramesy, paramb });
    if ((paramesy != null) && (paramb != null))
    {
      paramb.MVY = System.currentTimeMillis();
      paramb.MVZ = (paramb.MVY - paramb.MVX);
      Object localObject = b(paramesv, paramesy, paramb);
      if (!Util.isNullOrNil((String)localObject))
      {
        dxu localdxu = new dxu();
        localdxu.Udk = ((String)localObject);
        Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14436VideoPlayReportString %s", new Object[] { localdxu.Udk });
        localObject = new y(localdxu);
        h.aGY().a((com.tencent.mm.an.q)localObject, 0);
      }
      if (paramb.MWq == null) {
        break label477;
      }
    }
    label477:
    for (int i = paramb.MWq.videoBitrate;; i = 0)
    {
      paramesv = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramesv.scene), paramesy.Crh, Long.valueOf(paramesy.Uvb), "mp4", Integer.valueOf(paramesy.KFK), Integer.valueOf(i), Long.valueOf(paramb.MVX), Long.valueOf(paramb.MVY), Long.valueOf(paramb.MWa), Long.valueOf(paramb.MVZ), Long.valueOf(paramb.MWc), Long.valueOf(paramb.MWd), Long.valueOf(paramb.MWe), Long.valueOf(paramb.MWf), Long.valueOf(paramb.MWi), Long.valueOf(paramb.MWj), Long.valueOf(paramb.MWb), Long.valueOf(paramb.MWk), Long.valueOf(paramb.MWl), Long.valueOf(paramb.MWn), Long.valueOf(paramb.MWo), paramb.lpD, Long.valueOf(paramb.position), ai.anV(), Long.valueOf(paramb.MWm), Long.valueOf(paramb.MWp), Long.valueOf(paramb.MWg), Long.valueOf(paramb.MWh), paramesv.wmL });
      Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay 15414 %s", new Object[] { paramesv });
      com.tencent.mm.plugin.report.f.Iyx.kvStat(15414, paramesv);
      a.a(paramb);
      AppMethodBeat.o(88465);
      return;
    }
  }
  
  private static String b(esv paramesv, esy paramesy, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(88467);
    StringBuilder localStringBuilder = new StringBuilder("");
    for (;;)
    {
      try
      {
        localStringBuilder.append("scene=");
        localStringBuilder.append(paramesv.scene);
        localStringBuilder.append("&");
        localStringBuilder.append("businesstype=3");
        localStringBuilder.append("&");
        localStringBuilder.append("mediatype=2");
        localStringBuilder.append("&");
        localStringBuilder.append("docid=");
        localStringBuilder.append(paramesy.BHW);
        localStringBuilder.append("&");
        localStringBuilder.append("typepos=");
        localStringBuilder.append("0");
        localStringBuilder.append("&");
        localStringBuilder.append("docpos=");
        localStringBuilder.append(paramInt1 + 1);
        localStringBuilder.append("&");
        localStringBuilder.append("searchid=");
        localStringBuilder.append(paramesv.jQi);
        localStringBuilder.append("&");
        localStringBuilder.append("ishomepage=");
        localStringBuilder.append(0);
        localStringBuilder.append("&rec_category=");
        localStringBuilder.append(paramesy.UuV);
        localStringBuilder.append("&");
        localStringBuilder.append("timestamp=");
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append("&");
        localStringBuilder.append("clicktype=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("&");
        localStringBuilder.append("clickcontent=");
      }
      catch (Exception paramesv)
      {
        continue;
      }
      try
      {
        localStringBuilder.append(com.tencent.mm.compatible.util.q.an(paramString, "utf-8"));
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
          localStringBuilder.append(com.tencent.mm.compatible.util.q.an(paramesv.fwe, "utf-8"));
          localStringBuilder.append("&");
          localStringBuilder.append("resulttype=");
          localStringBuilder.append(paramesy.Uva);
          localStringBuilder.append("&");
          localStringBuilder.append("sessionid=");
          localStringBuilder.append(ai.ane(paramesv.scene));
          localStringBuilder.append("&");
          localStringBuilder.append("expand=");
          try
          {
            localStringBuilder.append(com.tencent.mm.compatible.util.q.an(paramesy.UuX, "utf-8"));
            localStringBuilder.append("&");
            localStringBuilder.append("title=");
            try
            {
              localStringBuilder.append(com.tencent.mm.compatible.util.q.an(paramesy.title, "utf-8"));
              localStringBuilder.append("&");
              localStringBuilder.append("nettype=");
              if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
              {
                localStringBuilder.append("wifi");
                localStringBuilder.append("&");
                localStringBuilder.append("itemtype=");
                localStringBuilder.append(paramesy.UuY);
                paramesv = localStringBuilder.toString();
                AppMethodBeat.o(88467);
                return paramesv;
              }
              if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
              {
                localStringBuilder.append("4g");
                continue;
              }
              localStringBuilder.append("3g");
            }
            catch (Exception paramesv) {}
          }
          catch (Exception paramesv) {}
        }
        catch (Exception paramString) {}
      }
      catch (Exception paramString) {}
    }
  }
  
  private static String b(esv paramesv, esy paramesy, com.tencent.mm.plugin.topstory.a.b.b paramb)
  {
    AppMethodBeat.i(88468);
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("ismediaplay=1");
    localStringBuilder.append("&searchid=");
    localStringBuilder.append(paramesv.jQi);
    localStringBuilder.append("&scene=");
    localStringBuilder.append(paramesv.scene);
    localStringBuilder.append("&businesstype=3");
    localStringBuilder.append("&mediatype=2");
    localStringBuilder.append("&rec_category=");
    localStringBuilder.append(paramesv.UuH);
    localStringBuilder.append("&docid=");
    localStringBuilder.append(paramesy.BHW);
    localStringBuilder.append("&cdnsourcetype=");
    localStringBuilder.append(paramesy.Uvh);
    try
    {
      localStringBuilder.append("&expand1=").append(com.tencent.mm.compatible.util.q.an(paramesy.UuX, "utf-8"));
      label146:
      localStringBuilder.append("&query=");
      try
      {
        localStringBuilder.append(com.tencent.mm.compatible.util.q.an(paramesv.fwe, "utf-8"));
        label169:
        localStringBuilder.append("&title=");
        try
        {
          localStringBuilder.append(com.tencent.mm.compatible.util.q.an(paramesy.title, "utf-8"));
          label192:
          localStringBuilder.append("&duration=");
          localStringBuilder.append(paramesy.KFK * 1000);
          localStringBuilder.append("&mediaid=");
          localStringBuilder.append(paramesy.Crh);
          if (paramb != null)
          {
            localStringBuilder.append("&startplaytime=");
            localStringBuilder.append(paramb.MVX);
            localStringBuilder.append("&endplaytime=");
            localStringBuilder.append(paramb.MVY);
            localStringBuilder.append("&playtime=");
            localStringBuilder.append(paramb.MVZ);
            localStringBuilder.append("&lastplayms=");
            localStringBuilder.append(paramb.MWa);
            localStringBuilder.append("&autoplay=");
            localStringBuilder.append(paramb.MWe);
            localStringBuilder.append("&hasplayended=");
            localStringBuilder.append(paramb.MWb);
            localStringBuilder.append("&hasquickplay=");
            localStringBuilder.append(paramb.MWc);
            localStringBuilder.append("&hasfullscreen=");
            localStringBuilder.append(paramb.MWd);
            localStringBuilder.append("&hitpreload=");
            localStringBuilder.append(paramb.MWf);
            localStringBuilder.append("&firstloadtime=");
            localStringBuilder.append(paramb.MWi);
            localStringBuilder.append("&downloadfinishtime=");
            localStringBuilder.append(paramb.MWj);
            localStringBuilder.append("&firstmoovreadytime=");
            localStringBuilder.append(paramb.MWk);
            localStringBuilder.append("&firstdataavailabletime=");
            localStringBuilder.append(paramb.MWn);
            localStringBuilder.append("&filesize=");
            localStringBuilder.append(paramb.MWr);
            if (paramb.MWq != null)
            {
              localStringBuilder.append("&bitrate=");
              localStringBuilder.append(paramb.MWq.videoBitrate);
              localStringBuilder.append("&audiobitrate=");
              localStringBuilder.append(paramb.MWq.audioBitrate);
            }
          }
          paramesv = localStringBuilder.toString();
          AppMethodBeat.o(88468);
          return paramesv;
        }
        catch (Exception paramesv)
        {
          break label192;
        }
      }
      catch (Exception paramesv)
      {
        break label169;
      }
    }
    catch (Exception localException)
    {
      break label146;
    }
  }
  
  public final void a(esv paramesv, esy paramesy, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(88466);
    paramesv = b(paramesv, paramesy, paramInt1, paramInt2, paramString);
    if (!Util.isNullOrNil(paramesv))
    {
      paramesy = new dxu();
      paramesy.Udk = paramesv;
      Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "do12721ClickVideoReport %s", new Object[] { paramesy.Udk });
      paramesv = new y(paramesy);
      h.aGY().a(paramesv, 0);
    }
    AppMethodBeat.o(88466);
  }
  
  public final void a(esv paramesv, HashSet<com.tencent.mm.plugin.topstory.a.b.c> paramHashSet)
  {
    AppMethodBeat.i(88464);
    if (paramHashSet.size() == 0)
    {
      AppMethodBeat.o(88464);
      return;
    }
    a locala = (a)this.MVF.get(Long.valueOf(paramesv.UuH));
    if ((locala != null) && (this.KMg.hasMessages(0)))
    {
      Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo hit cached task %d add %d", new Object[] { Integer.valueOf(locala.MVH.size()), Integer.valueOf(paramHashSet.size()) });
      paramesv = paramHashSet.iterator();
      while (paramesv.hasNext())
      {
        paramHashSet = (com.tencent.mm.plugin.topstory.a.b.c)paramesv.next();
        locala.MVH.add(paramHashSet);
      }
      AppMethodBeat.o(88464);
      return;
    }
    if (locala != null) {
      Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo not report task: %s size: %d", new Object[] { locala, Integer.valueOf(locala.MVH.size()) });
    }
    locala = new a((byte)0);
    Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo new task %d %s", new Object[] { Integer.valueOf(paramHashSet.size()), locala });
    locala.createTime = System.currentTimeMillis();
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      com.tencent.mm.plugin.topstory.a.b.c localc = (com.tencent.mm.plugin.topstory.a.b.c)paramHashSet.next();
      locala.MVH.add(localc);
    }
    locala.MVI = paramesv;
    if (locala.MVH.size() > 0)
    {
      this.KMg.removeMessages(0);
      this.KMg.sendMessageDelayed(this.KMg.obtainMessage(0, locala), 5000L);
      this.MVF.put(Long.valueOf(paramesv.UuH), locala);
    }
    AppMethodBeat.o(88464);
  }
  
  final class a
    implements Runnable
  {
    HashSet<com.tencent.mm.plugin.topstory.a.b.c> MVH;
    esv MVI;
    long createTime;
    
    private a()
    {
      AppMethodBeat.i(88460);
      this.MVH = new HashSet();
      AppMethodBeat.o(88460);
    }
    
    private static String a(List<com.tencent.mm.plugin.topstory.a.b.c> paramList, esv paramesv)
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
          esy localesy = ((com.tencent.mm.plugin.topstory.a.b.c)localObject3).MWs;
          ((StringBuilder)localObject1).append(localesy.fwf);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localesy.BHW);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.topstory.a.b.c)localObject3).BQq);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localesy.UuX);
          ((StringBuilder)localObject1).append(";");
        }
        try
        {
          localStringBuilder1.append(com.tencent.mm.compatible.util.q.an(((StringBuilder)localObject1).toString(), "utf-8"));
          localStringBuilder1.append("&resulttype=");
          localObject1 = paramList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject1).next()).MWs;
            localStringBuilder1.append(((esy)localObject2).fwf);
            localStringBuilder1.append(":");
            localStringBuilder1.append(((esy)localObject2).Uva);
            localStringBuilder1.append(";");
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", localException, "", new Object[0]);
          }
          localStringBuilder1.append("&expand=");
          localStringBuilder2 = new StringBuilder("");
          localObject2 = paramList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject2).next()).MWs;
            localStringBuilder2.append(((esy)localObject3).fwf);
            localStringBuilder2.append(":");
            localStringBuilder2.append(((esy)localObject3).UuZ);
            localStringBuilder2.append(";");
          }
          try
          {
            localStringBuilder1.append(com.tencent.mm.compatible.util.q.an(localStringBuilder2.toString(), "utf-8"));
            localStringBuilder1.append("&itemtype=");
            localStringBuilder2 = new StringBuilder("");
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              localStringBuilder2.append(((com.tencent.mm.plugin.topstory.a.b.c)paramList.next()).MWs.UuY);
              localStringBuilder2.append(";");
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", localUnsupportedEncodingException, "", new Object[0]);
            }
            localStringBuilder1.append(localUnsupportedEncodingException);
            if (paramesv == null) {
              break label636;
            }
          }
          localStringBuilder1.append("&");
          localStringBuilder1.append("searchid=");
          localStringBuilder1.append(paramesv.jQi);
          localStringBuilder1.append("&");
          localStringBuilder1.append("query=");
        }
      }
      catch (Exception paramList)
      {
        Log.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", paramList, "build14057VideoInfoExposeString error: %s", new Object[] { paramList.getMessage() });
        AppMethodBeat.o(88462);
        return null;
      }
      try
      {
        StringBuilder localStringBuilder2;
        localStringBuilder1.append(com.tencent.mm.compatible.util.q.an(paramesv.fwe, "utf-8"));
        localStringBuilder1.append("&");
        localStringBuilder1.append("ishomepage=0");
        localStringBuilder1.append("&");
        localStringBuilder1.append("sessionid=");
        localStringBuilder1.append(ai.ane(paramesv.scene));
        localStringBuilder1.append("&");
        localStringBuilder1.append("scene=");
        localStringBuilder1.append(paramesv.scene);
        localStringBuilder1.append("&rec_category=");
        localStringBuilder1.append(paramesv.UuH);
        label636:
        paramList = localStringBuilder1.toString();
        AppMethodBeat.o(88462);
        return paramList;
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", paramList, "", new Object[0]);
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(88461);
      Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "Star to run ReportExposeTask");
      c.a(c.this).remove(Long.valueOf(this.MVI.UuH));
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.MVH);
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 20;
        if (j >= localArrayList.size()) {}
        for (List localList = localArrayList.subList(i, localArrayList.size());; localList = localArrayList.subList(i, j))
        {
          String str = a(localList, this.MVI);
          if (!Util.isNullOrNil(str))
          {
            dxu localdxu = new dxu();
            localdxu.Udk = str;
            Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14057VideoInfoExposeString %d report string: %s", new Object[] { Integer.valueOf(localList.size()), localdxu.Udk });
            MMHandlerThread.postToMainThread(new c.a.1(this, localdxu));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.c
 * JD-Core Version:    0.7.0.1
 */