package com.tencent.mm.plugin.topstory;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
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

public final class c
  implements f
{
  MMHandler Eyp;
  Map<Long, a> GiU;
  
  public c()
  {
    AppMethodBeat.i(88463);
    this.GiU = new ConcurrentHashMap();
    this.Eyp = new MMHandler("TopStoryReportExposeTask")
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
  
  public static void a(eit parameit, eiw parameiw, b paramb)
  {
    AppMethodBeat.i(88465);
    Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay: %s %s", new Object[] { parameiw, paramb });
    if ((parameiw != null) && (paramb != null))
    {
      paramb.Gjn = System.currentTimeMillis();
      paramb.Gjo = (paramb.Gjn - paramb.Gjm);
      Object localObject = b(parameit, parameiw, paramb);
      if (!Util.isNullOrNil((String)localObject))
      {
        doc localdoc = new doc();
        localdoc.MRe = ((String)localObject);
        Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14436VideoPlayReportString %s", new Object[] { localdoc.MRe });
        localObject = new y(localdoc);
        g.azz().a((com.tencent.mm.ak.q)localObject, 0);
      }
      if (paramb.GjF == null) {
        break label477;
      }
    }
    label477:
    for (int i = paramb.GjF.videoBitrate;; i = 0)
    {
      parameit = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(parameit.scene), parameiw.psI, Long.valueOf(parameiw.Niv), "mp4", Integer.valueOf(parameiw.Eso), Integer.valueOf(i), Long.valueOf(paramb.Gjm), Long.valueOf(paramb.Gjn), Long.valueOf(paramb.Gjp), Long.valueOf(paramb.Gjo), Long.valueOf(paramb.Gjr), Long.valueOf(paramb.Gjs), Long.valueOf(paramb.Gjt), Long.valueOf(paramb.Gju), Long.valueOf(paramb.Gjx), Long.valueOf(paramb.Gjy), Long.valueOf(paramb.Gjq), Long.valueOf(paramb.Gjz), Long.valueOf(paramb.GjA), Long.valueOf(paramb.GjC), Long.valueOf(paramb.GjD), paramb.iAh, Long.valueOf(paramb.position), ai.ait(), Long.valueOf(paramb.GjB), Long.valueOf(paramb.GjE), Long.valueOf(paramb.Gjv), Long.valueOf(paramb.Gjw), parameit.sGQ });
      Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay 15414 %s", new Object[] { parameit });
      e.Cxv.kvStat(15414, parameit);
      com.tencent.mm.plugin.topstory.a.a.a.a(paramb);
      AppMethodBeat.o(88465);
      return;
    }
  }
  
  private static String b(eit parameit, eiw parameiw, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(88467);
    StringBuilder localStringBuilder = new StringBuilder("");
    for (;;)
    {
      try
      {
        localStringBuilder.append("scene=");
        localStringBuilder.append(parameit.scene);
        localStringBuilder.append("&");
        localStringBuilder.append("businesstype=3");
        localStringBuilder.append("&");
        localStringBuilder.append("mediatype=2");
        localStringBuilder.append("&");
        localStringBuilder.append("docid=");
        localStringBuilder.append(parameiw.wWb);
        localStringBuilder.append("&");
        localStringBuilder.append("typepos=");
        localStringBuilder.append("0");
        localStringBuilder.append("&");
        localStringBuilder.append("docpos=");
        localStringBuilder.append(paramInt1 + 1);
        localStringBuilder.append("&");
        localStringBuilder.append("searchid=");
        localStringBuilder.append(parameit.hes);
        localStringBuilder.append("&");
        localStringBuilder.append("ishomepage=");
        localStringBuilder.append(0);
        localStringBuilder.append("&rec_category=");
        localStringBuilder.append(parameiw.Nip);
        localStringBuilder.append("&");
        localStringBuilder.append("timestamp=");
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append("&");
        localStringBuilder.append("clicktype=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("&");
        localStringBuilder.append("clickcontent=");
      }
      catch (Exception parameit)
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
          localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(parameit.dDv, "utf-8"));
          localStringBuilder.append("&");
          localStringBuilder.append("resulttype=");
          localStringBuilder.append(parameiw.Niu);
          localStringBuilder.append("&");
          localStringBuilder.append("sessionid=");
          localStringBuilder.append(ai.afq(parameit.scene));
          localStringBuilder.append("&");
          localStringBuilder.append("expand=");
          try
          {
            localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(parameiw.Nir, "utf-8"));
            localStringBuilder.append("&");
            localStringBuilder.append("title=");
            try
            {
              localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(parameiw.title, "utf-8"));
              localStringBuilder.append("&");
              localStringBuilder.append("nettype=");
              if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
              {
                localStringBuilder.append("wifi");
                localStringBuilder.append("&");
                localStringBuilder.append("itemtype=");
                localStringBuilder.append(parameiw.Nis);
                parameit = localStringBuilder.toString();
                AppMethodBeat.o(88467);
                return parameit;
              }
              if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
              {
                localStringBuilder.append("4g");
                continue;
              }
              localStringBuilder.append("3g");
            }
            catch (Exception parameit) {}
          }
          catch (Exception parameit) {}
        }
        catch (Exception paramString) {}
      }
      catch (Exception paramString) {}
    }
  }
  
  private static String b(eit parameit, eiw parameiw, b paramb)
  {
    AppMethodBeat.i(88468);
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("ismediaplay=1");
    localStringBuilder.append("&searchid=");
    localStringBuilder.append(parameit.hes);
    localStringBuilder.append("&scene=");
    localStringBuilder.append(parameit.scene);
    localStringBuilder.append("&businesstype=3");
    localStringBuilder.append("&mediatype=2");
    localStringBuilder.append("&rec_category=");
    localStringBuilder.append(parameit.Nib);
    localStringBuilder.append("&docid=");
    localStringBuilder.append(parameiw.wWb);
    localStringBuilder.append("&cdnsourcetype=");
    localStringBuilder.append(parameiw.NiB);
    try
    {
      localStringBuilder.append("&expand1=").append(com.tencent.mm.compatible.util.q.encode(parameiw.Nir, "utf-8"));
      label146:
      localStringBuilder.append("&query=");
      try
      {
        localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(parameit.dDv, "utf-8"));
        label169:
        localStringBuilder.append("&title=");
        try
        {
          localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(parameiw.title, "utf-8"));
          label192:
          localStringBuilder.append("&duration=");
          localStringBuilder.append(parameiw.Eso * 1000);
          localStringBuilder.append("&mediaid=");
          localStringBuilder.append(parameiw.psI);
          if (paramb != null)
          {
            localStringBuilder.append("&startplaytime=");
            localStringBuilder.append(paramb.Gjm);
            localStringBuilder.append("&endplaytime=");
            localStringBuilder.append(paramb.Gjn);
            localStringBuilder.append("&playtime=");
            localStringBuilder.append(paramb.Gjo);
            localStringBuilder.append("&lastplayms=");
            localStringBuilder.append(paramb.Gjp);
            localStringBuilder.append("&autoplay=");
            localStringBuilder.append(paramb.Gjt);
            localStringBuilder.append("&hasplayended=");
            localStringBuilder.append(paramb.Gjq);
            localStringBuilder.append("&hasquickplay=");
            localStringBuilder.append(paramb.Gjr);
            localStringBuilder.append("&hasfullscreen=");
            localStringBuilder.append(paramb.Gjs);
            localStringBuilder.append("&hitpreload=");
            localStringBuilder.append(paramb.Gju);
            localStringBuilder.append("&firstloadtime=");
            localStringBuilder.append(paramb.Gjx);
            localStringBuilder.append("&downloadfinishtime=");
            localStringBuilder.append(paramb.Gjy);
            localStringBuilder.append("&firstmoovreadytime=");
            localStringBuilder.append(paramb.Gjz);
            localStringBuilder.append("&firstdataavailabletime=");
            localStringBuilder.append(paramb.GjC);
            localStringBuilder.append("&filesize=");
            localStringBuilder.append(paramb.GjG);
            if (paramb.GjF != null)
            {
              localStringBuilder.append("&bitrate=");
              localStringBuilder.append(paramb.GjF.videoBitrate);
              localStringBuilder.append("&audiobitrate=");
              localStringBuilder.append(paramb.GjF.audioBitrate);
            }
          }
          parameit = localStringBuilder.toString();
          AppMethodBeat.o(88468);
          return parameit;
        }
        catch (Exception parameit)
        {
          break label192;
        }
      }
      catch (Exception parameit)
      {
        break label169;
      }
    }
    catch (Exception localException)
    {
      break label146;
    }
  }
  
  public final void a(eit parameit, eiw parameiw, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(88466);
    parameit = b(parameit, parameiw, paramInt1, paramInt2, paramString);
    if (!Util.isNullOrNil(parameit))
    {
      parameiw = new doc();
      parameiw.MRe = parameit;
      Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "do12721ClickVideoReport %s", new Object[] { parameiw.MRe });
      parameit = new y(parameiw);
      g.azz().a(parameit, 0);
    }
    AppMethodBeat.o(88466);
  }
  
  public final void a(eit parameit, HashSet<com.tencent.mm.plugin.topstory.a.b.c> paramHashSet)
  {
    AppMethodBeat.i(88464);
    if (paramHashSet.size() == 0)
    {
      AppMethodBeat.o(88464);
      return;
    }
    a locala = (a)this.GiU.get(Long.valueOf(parameit.Nib));
    if ((locala != null) && (this.Eyp.hasMessages(0)))
    {
      Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo hit cached task %d add %d", new Object[] { Integer.valueOf(locala.GiW.size()), Integer.valueOf(paramHashSet.size()) });
      parameit = paramHashSet.iterator();
      while (parameit.hasNext())
      {
        paramHashSet = (com.tencent.mm.plugin.topstory.a.b.c)parameit.next();
        locala.GiW.add(paramHashSet);
      }
      AppMethodBeat.o(88464);
      return;
    }
    if (locala != null) {
      Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo not report task: %s size: %d", new Object[] { locala, Integer.valueOf(locala.GiW.size()) });
    }
    locala = new a((byte)0);
    Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo new task %d %s", new Object[] { Integer.valueOf(paramHashSet.size()), locala });
    locala.createTime = System.currentTimeMillis();
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      com.tencent.mm.plugin.topstory.a.b.c localc = (com.tencent.mm.plugin.topstory.a.b.c)paramHashSet.next();
      locala.GiW.add(localc);
    }
    locala.GiX = parameit;
    if (locala.GiW.size() > 0)
    {
      this.Eyp.removeMessages(0);
      this.Eyp.sendMessageDelayed(this.Eyp.obtainMessage(0, locala), 5000L);
      this.GiU.put(Long.valueOf(parameit.Nib), locala);
    }
    AppMethodBeat.o(88464);
  }
  
  final class a
    implements Runnable
  {
    HashSet<com.tencent.mm.plugin.topstory.a.b.c> GiW;
    eit GiX;
    long createTime;
    
    private a()
    {
      AppMethodBeat.i(88460);
      this.GiW = new HashSet();
      AppMethodBeat.o(88460);
    }
    
    private static String a(List<com.tencent.mm.plugin.topstory.a.b.c> paramList, eit parameit)
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
          eiw localeiw = ((com.tencent.mm.plugin.topstory.a.b.c)localObject3).GjH;
          ((StringBuilder)localObject1).append(localeiw.dDw);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localeiw.wWb);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.topstory.a.b.c)localObject3).xeh);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localeiw.Nir);
          ((StringBuilder)localObject1).append(";");
        }
        try
        {
          localStringBuilder1.append(com.tencent.mm.compatible.util.q.encode(((StringBuilder)localObject1).toString(), "utf-8"));
          localStringBuilder1.append("&resulttype=");
          localObject1 = paramList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject1).next()).GjH;
            localStringBuilder1.append(((eiw)localObject2).dDw);
            localStringBuilder1.append(":");
            localStringBuilder1.append(((eiw)localObject2).Niu);
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
            localObject3 = ((com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject2).next()).GjH;
            localStringBuilder2.append(((eiw)localObject3).dDw);
            localStringBuilder2.append(":");
            localStringBuilder2.append(((eiw)localObject3).Nit);
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
              localStringBuilder2.append(((com.tencent.mm.plugin.topstory.a.b.c)paramList.next()).GjH.Nis);
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
            if (parameit == null) {
              break label636;
            }
          }
          localStringBuilder1.append("&");
          localStringBuilder1.append("searchid=");
          localStringBuilder1.append(parameit.hes);
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
        localStringBuilder1.append(com.tencent.mm.compatible.util.q.encode(parameit.dDv, "utf-8"));
        localStringBuilder1.append("&");
        localStringBuilder1.append("ishomepage=0");
        localStringBuilder1.append("&");
        localStringBuilder1.append("sessionid=");
        localStringBuilder1.append(ai.afq(parameit.scene));
        localStringBuilder1.append("&");
        localStringBuilder1.append("scene=");
        localStringBuilder1.append(parameit.scene);
        localStringBuilder1.append("&rec_category=");
        localStringBuilder1.append(parameit.Nib);
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
      c.this.GiU.remove(Long.valueOf(this.GiX.Nib));
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.GiW);
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 20;
        if (j >= localArrayList.size()) {}
        for (List localList = localArrayList.subList(i, localArrayList.size());; localList = localArrayList.subList(i, j))
        {
          String str = a(localList, this.GiX);
          if (!Util.isNullOrNil(str))
          {
            final doc localdoc = new doc();
            localdoc.MRe = str;
            Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14057VideoInfoExposeString %d report string: %s", new Object[] { Integer.valueOf(localList.size()), localdoc.MRe });
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(88459);
                y localy = new y(localdoc);
                g.azz().a(localy, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.c
 * JD-Core Version:    0.7.0.1
 */