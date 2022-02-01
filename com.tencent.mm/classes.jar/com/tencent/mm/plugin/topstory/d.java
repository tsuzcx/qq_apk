package com.tencent.mm.plugin.topstory;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.topstory.a.a.a;
import com.tencent.mm.plugin.topstory.a.b.c;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.foh;
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

public class d
  implements e
{
  MMHandler RlS;
  private Map<Long, a> TIi;
  
  public d()
  {
    AppMethodBeat.i(88463);
    this.TIi = new ConcurrentHashMap();
    this.RlS = new MMHandler("TopStoryReportExposeTask")
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
          ((d.a)paramAnonymousMessage.obj).run();
        }
      }
    };
    AppMethodBeat.o(88463);
  }
  
  public static void a(foe paramfoe, foh paramfoh, com.tencent.mm.plugin.topstory.a.b.b paramb)
  {
    AppMethodBeat.i(88465);
    Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay: %s %s", new Object[] { paramfoh, paramb });
    if ((paramfoh != null) && (paramb != null))
    {
      paramb.TIC = System.currentTimeMillis();
      paramb.TID = (paramb.TIC - paramb.TIB);
      Object localObject = b(paramfoe, paramfoh, paramb);
      if (!Util.isNullOrNil((String)localObject))
      {
        eqy localeqy = new eqy();
        localeqy.abuE = ((String)localObject);
        Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14436VideoPlayReportString %s", new Object[] { localeqy.abuE });
        localObject = new z(localeqy);
        h.aZW().a((p)localObject, 0);
      }
      if (paramb.ObD == null) {
        break label477;
      }
    }
    label477:
    for (int i = paramb.ObD.videoBitrate;; i = 0)
    {
      paramfoe = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramfoe.scene), paramfoh.Ido, Long.valueOf(paramfoh.abOC), "mp4", Integer.valueOf(paramfoh.Rfk), Integer.valueOf(i), Long.valueOf(paramb.TIB), Long.valueOf(paramb.TIC), Long.valueOf(paramb.TIE), Long.valueOf(paramb.TID), Long.valueOf(paramb.TIG), Long.valueOf(paramb.TIH), Long.valueOf(paramb.TII), Long.valueOf(paramb.TIJ), Long.valueOf(paramb.TIM), Long.valueOf(paramb.TIN), Long.valueOf(paramb.TIF), Long.valueOf(paramb.TIO), Long.valueOf(paramb.TIQ), Long.valueOf(paramb.TIS), Long.valueOf(paramb.TIT), paramb.mso, Long.valueOf(paramb.position), aj.gtA(), Long.valueOf(paramb.TIR), Long.valueOf(paramb.TIU), Long.valueOf(paramb.TIK), Long.valueOf(paramb.TIL), paramfoe.zIO });
      Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay 15414 %s", new Object[] { paramfoe });
      f.Ozc.kvStat(15414, paramfoe);
      a.a(paramb);
      AppMethodBeat.o(88465);
      return;
    }
  }
  
  private static String b(foe paramfoe, foh paramfoh, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(88467);
    StringBuilder localStringBuilder = new StringBuilder("");
    for (;;)
    {
      try
      {
        localStringBuilder.append("scene=");
        localStringBuilder.append(paramfoe.scene);
        localStringBuilder.append("&");
        localStringBuilder.append("businesstype=3");
        localStringBuilder.append("&");
        localStringBuilder.append("mediatype=2");
        localStringBuilder.append("&");
        localStringBuilder.append("docid=");
        localStringBuilder.append(paramfoh.HsD);
        localStringBuilder.append("&");
        localStringBuilder.append("typepos=");
        localStringBuilder.append("0");
        localStringBuilder.append("&");
        localStringBuilder.append("docpos=");
        localStringBuilder.append(paramInt1 + 1);
        localStringBuilder.append("&");
        localStringBuilder.append("searchid=");
        localStringBuilder.append(paramfoe.mpa);
        localStringBuilder.append("&");
        localStringBuilder.append("ishomepage=");
        localStringBuilder.append(0);
        localStringBuilder.append("&rec_category=");
        localStringBuilder.append(paramfoh.abOw);
        localStringBuilder.append("&");
        localStringBuilder.append("timestamp=");
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append("&");
        localStringBuilder.append("clicktype=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("&");
        localStringBuilder.append("clickcontent=");
      }
      catch (Exception paramfoe)
      {
        continue;
      }
      try
      {
        localStringBuilder.append(r.as(paramString, "utf-8"));
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
          localStringBuilder.append(r.as(paramfoe.hAB, "utf-8"));
          localStringBuilder.append("&");
          localStringBuilder.append("resulttype=");
          localStringBuilder.append(paramfoh.abOB);
          localStringBuilder.append("&");
          localStringBuilder.append("sessionid=");
          localStringBuilder.append(aj.asV(paramfoe.scene));
          localStringBuilder.append("&");
          localStringBuilder.append("expand=");
          try
          {
            localStringBuilder.append(r.as(paramfoh.abOy, "utf-8"));
            localStringBuilder.append("&");
            localStringBuilder.append("title=");
            try
            {
              localStringBuilder.append(r.as(paramfoh.title, "utf-8"));
              localStringBuilder.append("&");
              localStringBuilder.append("nettype=");
              if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
              {
                localStringBuilder.append("wifi");
                localStringBuilder.append("&");
                localStringBuilder.append("itemtype=");
                localStringBuilder.append(paramfoh.abOz);
                paramfoe = localStringBuilder.toString();
                AppMethodBeat.o(88467);
                return paramfoe;
              }
              if (NetStatusUtil.is4G(MMApplicationContext.getContext()))
              {
                localStringBuilder.append("4g");
                continue;
              }
              localStringBuilder.append("3g");
            }
            catch (Exception paramfoe) {}
          }
          catch (Exception paramfoe) {}
        }
        catch (Exception paramString) {}
      }
      catch (Exception paramString) {}
    }
  }
  
  private static String b(foe paramfoe, foh paramfoh, com.tencent.mm.plugin.topstory.a.b.b paramb)
  {
    AppMethodBeat.i(88468);
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("ismediaplay=1");
    localStringBuilder.append("&searchid=");
    localStringBuilder.append(paramfoe.mpa);
    localStringBuilder.append("&scene=");
    localStringBuilder.append(paramfoe.scene);
    localStringBuilder.append("&businesstype=3");
    localStringBuilder.append("&mediatype=2");
    localStringBuilder.append("&rec_category=");
    localStringBuilder.append(paramfoe.abOj);
    localStringBuilder.append("&docid=");
    localStringBuilder.append(paramfoh.HsD);
    localStringBuilder.append("&cdnsourcetype=");
    localStringBuilder.append(paramfoh.abOI);
    try
    {
      localStringBuilder.append("&expand1=").append(r.as(paramfoh.abOy, "utf-8"));
      label146:
      localStringBuilder.append("&query=");
      try
      {
        localStringBuilder.append(r.as(paramfoe.hAB, "utf-8"));
        label169:
        localStringBuilder.append("&title=");
        try
        {
          localStringBuilder.append(r.as(paramfoh.title, "utf-8"));
          label192:
          localStringBuilder.append("&duration=");
          localStringBuilder.append(paramfoh.Rfk * 1000);
          localStringBuilder.append("&mediaid=");
          localStringBuilder.append(paramfoh.Ido);
          if (paramb != null)
          {
            localStringBuilder.append("&startplaytime=");
            localStringBuilder.append(paramb.TIB);
            localStringBuilder.append("&endplaytime=");
            localStringBuilder.append(paramb.TIC);
            localStringBuilder.append("&playtime=");
            localStringBuilder.append(paramb.TID);
            localStringBuilder.append("&lastplayms=");
            localStringBuilder.append(paramb.TIE);
            localStringBuilder.append("&autoplay=");
            localStringBuilder.append(paramb.TII);
            localStringBuilder.append("&hasplayended=");
            localStringBuilder.append(paramb.TIF);
            localStringBuilder.append("&hasquickplay=");
            localStringBuilder.append(paramb.TIG);
            localStringBuilder.append("&hasfullscreen=");
            localStringBuilder.append(paramb.TIH);
            localStringBuilder.append("&hitpreload=");
            localStringBuilder.append(paramb.TIJ);
            localStringBuilder.append("&firstloadtime=");
            localStringBuilder.append(paramb.TIM);
            localStringBuilder.append("&downloadfinishtime=");
            localStringBuilder.append(paramb.TIN);
            localStringBuilder.append("&firstmoovreadytime=");
            localStringBuilder.append(paramb.TIO);
            localStringBuilder.append("&firstdataavailabletime=");
            localStringBuilder.append(paramb.TIS);
            localStringBuilder.append("&filesize=");
            localStringBuilder.append(paramb.TIV);
            if (paramb.ObD != null)
            {
              localStringBuilder.append("&bitrate=");
              localStringBuilder.append(paramb.ObD.videoBitrate);
              localStringBuilder.append("&audiobitrate=");
              localStringBuilder.append(paramb.ObD.audioBitrate);
            }
          }
          paramfoe = localStringBuilder.toString();
          AppMethodBeat.o(88468);
          return paramfoe;
        }
        catch (Exception paramfoe)
        {
          break label192;
        }
      }
      catch (Exception paramfoe)
      {
        break label169;
      }
    }
    catch (Exception localException)
    {
      break label146;
    }
  }
  
  public final void a(foe paramfoe, foh paramfoh, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(88466);
    paramfoe = b(paramfoe, paramfoh, paramInt1, paramInt2, paramString);
    if (!Util.isNullOrNil(paramfoe))
    {
      paramfoh = new eqy();
      paramfoh.abuE = paramfoe;
      Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "do12721ClickVideoReport %s", new Object[] { paramfoh.abuE });
      paramfoe = new z(paramfoh);
      h.aZW().a(paramfoe, 0);
    }
    AppMethodBeat.o(88466);
  }
  
  public final void a(foe paramfoe, HashSet<c> paramHashSet)
  {
    AppMethodBeat.i(88464);
    if (paramHashSet.size() == 0)
    {
      AppMethodBeat.o(88464);
      return;
    }
    a locala = (a)this.TIi.get(Long.valueOf(paramfoe.abOj));
    if ((locala != null) && (this.RlS.hasMessages(0)))
    {
      Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo hit cached task %d add %d", new Object[] { Integer.valueOf(locala.TIk.size()), Integer.valueOf(paramHashSet.size()) });
      paramfoe = paramHashSet.iterator();
      while (paramfoe.hasNext())
      {
        paramHashSet = (c)paramfoe.next();
        locala.TIk.add(paramHashSet);
      }
      AppMethodBeat.o(88464);
      return;
    }
    if (locala != null) {
      Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo not report task: %s size: %d", new Object[] { locala, Integer.valueOf(locala.TIk.size()) });
    }
    locala = new a((byte)0);
    Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo new task %d %s", new Object[] { Integer.valueOf(paramHashSet.size()), locala });
    locala.createTime = System.currentTimeMillis();
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      c localc = (c)paramHashSet.next();
      locala.TIk.add(localc);
    }
    locala.TIl = paramfoe;
    if (locala.TIk.size() > 0)
    {
      this.RlS.removeMessages(0);
      this.RlS.sendMessageDelayed(this.RlS.obtainMessage(0, locala), 5000L);
      this.TIi.put(Long.valueOf(paramfoe.abOj), locala);
    }
    AppMethodBeat.o(88464);
  }
  
  final class a
    implements Runnable
  {
    HashSet<c> TIk;
    foe TIl;
    long createTime;
    
    private a()
    {
      AppMethodBeat.i(88460);
      this.TIk = new HashSet();
      AppMethodBeat.o(88460);
    }
    
    private static String a(List<c> paramList, foe paramfoe)
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
          localObject3 = (c)((Iterator)localObject2).next();
          foh localfoh = ((c)localObject3).TIW;
          ((StringBuilder)localObject1).append(localfoh.beV);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localfoh.HsD);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(((c)localObject3).HBX);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localfoh.abOy);
          ((StringBuilder)localObject1).append(";");
        }
        try
        {
          localStringBuilder1.append(r.as(((StringBuilder)localObject1).toString(), "utf-8"));
          localStringBuilder1.append("&resulttype=");
          localObject1 = paramList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((c)((Iterator)localObject1).next()).TIW;
            localStringBuilder1.append(((foh)localObject2).beV);
            localStringBuilder1.append(":");
            localStringBuilder1.append(((foh)localObject2).abOB);
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
            localObject3 = ((c)((Iterator)localObject2).next()).TIW;
            localStringBuilder2.append(((foh)localObject3).beV);
            localStringBuilder2.append(":");
            localStringBuilder2.append(((foh)localObject3).abOA);
            localStringBuilder2.append(";");
          }
          try
          {
            localStringBuilder1.append(r.as(localStringBuilder2.toString(), "utf-8"));
            localStringBuilder1.append("&itemtype=");
            localStringBuilder2 = new StringBuilder("");
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              localStringBuilder2.append(((c)paramList.next()).TIW.abOz);
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
            if (paramfoe == null) {
              break label636;
            }
          }
          localStringBuilder1.append("&");
          localStringBuilder1.append("searchid=");
          localStringBuilder1.append(paramfoe.mpa);
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
        localStringBuilder1.append(r.as(paramfoe.hAB, "utf-8"));
        localStringBuilder1.append("&");
        localStringBuilder1.append("ishomepage=0");
        localStringBuilder1.append("&");
        localStringBuilder1.append("sessionid=");
        localStringBuilder1.append(aj.asV(paramfoe.scene));
        localStringBuilder1.append("&");
        localStringBuilder1.append("scene=");
        localStringBuilder1.append(paramfoe.scene);
        localStringBuilder1.append("&rec_category=");
        localStringBuilder1.append(paramfoe.abOj);
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
      d.a(d.this).remove(Long.valueOf(this.TIl.abOj));
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.TIk);
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 20;
        if (j >= localArrayList.size()) {}
        for (List localList = localArrayList.subList(i, localArrayList.size());; localList = localArrayList.subList(i, j))
        {
          String str = a(localList, this.TIl);
          if (!Util.isNullOrNil(str))
          {
            final eqy localeqy = new eqy();
            localeqy.abuE = str;
            Log.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14057VideoInfoExposeString %d report string: %s", new Object[] { Integer.valueOf(localList.size()), localeqy.abuE });
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(88459);
                z localz = new z(localeqy);
                h.aZW().a(localz, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.d
 * JD-Core Version:    0.7.0.1
 */