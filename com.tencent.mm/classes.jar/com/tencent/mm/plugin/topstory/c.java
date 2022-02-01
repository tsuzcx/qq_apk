package com.tencent.mm.plugin.topstory;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
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
  aq ApE;
  Map<Long, a> BIl;
  
  public c()
  {
    AppMethodBeat.i(88463);
    this.BIl = new ConcurrentHashMap();
    this.ApE = new aq("TopStoryReportExposeTask")
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
  
  public static void a(dox paramdox, dpa paramdpa, b paramb)
  {
    AppMethodBeat.i(88465);
    ae.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay: %s %s", new Object[] { paramdpa, paramb });
    if ((paramdpa != null) && (paramb != null))
    {
      paramb.BIE = System.currentTimeMillis();
      paramb.BIF = (paramb.BIE - paramb.BID);
      Object localObject = b(paramdox, paramdpa, paramb);
      if (!bu.isNullOrNil((String)localObject))
      {
        cvj localcvj = new cvj();
        localcvj.HFU = ((String)localObject);
        ae.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14436VideoPlayReportString %s", new Object[] { localcvj.HFU });
        localObject = new u(localcvj);
        g.ajj().a((n)localObject, 0);
      }
      if (paramb.BIW == null) {
        break label477;
      }
    }
    label477:
    for (int i = paramb.BIW.videoBitrate;; i = 0)
    {
      paramdox = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramdox.scene), paramdpa.udb, Long.valueOf(paramdpa.HWo), "mp4", Integer.valueOf(paramdpa.AjG), Integer.valueOf(i), Long.valueOf(paramb.BID), Long.valueOf(paramb.BIE), Long.valueOf(paramb.BIG), Long.valueOf(paramb.BIF), Long.valueOf(paramb.BII), Long.valueOf(paramb.BIJ), Long.valueOf(paramb.BIK), Long.valueOf(paramb.BIL), Long.valueOf(paramb.BIO), Long.valueOf(paramb.BIP), Long.valueOf(paramb.BIH), Long.valueOf(paramb.BIQ), Long.valueOf(paramb.BIR), Long.valueOf(paramb.BIT), Long.valueOf(paramb.BIU), paramb.hFX, Long.valueOf(paramb.position), ad.UD(), Long.valueOf(paramb.BIS), Long.valueOf(paramb.BIV), Long.valueOf(paramb.BIM), Long.valueOf(paramb.BIN), paramdox.rfA });
      ae.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay 15414 %s", new Object[] { paramdox });
      e.ywz.kvStat(15414, paramdox);
      com.tencent.mm.plugin.topstory.a.a.a.a(paramb);
      AppMethodBeat.o(88465);
      return;
    }
  }
  
  private static String b(dox paramdox, dpa paramdpa, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(88467);
    StringBuilder localStringBuilder = new StringBuilder("");
    for (;;)
    {
      try
      {
        localStringBuilder.append("scene=");
        localStringBuilder.append(paramdox.scene);
        localStringBuilder.append("&");
        localStringBuilder.append("businesstype=3");
        localStringBuilder.append("&");
        localStringBuilder.append("mediatype=2");
        localStringBuilder.append("&");
        localStringBuilder.append("docid=");
        localStringBuilder.append(paramdpa.tFc);
        localStringBuilder.append("&");
        localStringBuilder.append("typepos=");
        localStringBuilder.append("0");
        localStringBuilder.append("&");
        localStringBuilder.append("docpos=");
        localStringBuilder.append(paramInt1 + 1);
        localStringBuilder.append("&");
        localStringBuilder.append("searchid=");
        localStringBuilder.append(paramdox.kid);
        localStringBuilder.append("&");
        localStringBuilder.append("ishomepage=");
        localStringBuilder.append(0);
        localStringBuilder.append("&rec_category=");
        localStringBuilder.append(paramdpa.HWh);
        localStringBuilder.append("&");
        localStringBuilder.append("timestamp=");
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append("&");
        localStringBuilder.append("clicktype=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("&");
        localStringBuilder.append("clickcontent=");
      }
      catch (Exception paramdox)
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
          localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(paramdox.dmf, "utf-8"));
          localStringBuilder.append("&");
          localStringBuilder.append("resulttype=");
          localStringBuilder.append(paramdpa.HWn);
          localStringBuilder.append("&");
          localStringBuilder.append("sessionid=");
          localStringBuilder.append(ad.WI(paramdox.scene));
          localStringBuilder.append("&");
          localStringBuilder.append("expand=");
          try
          {
            localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(paramdpa.HWj, "utf-8"));
            localStringBuilder.append("&");
            localStringBuilder.append("title=");
            try
            {
              localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(paramdpa.title, "utf-8"));
              localStringBuilder.append("&");
              localStringBuilder.append("nettype=");
              if (az.isWifi(ak.getContext()))
              {
                localStringBuilder.append("wifi");
                localStringBuilder.append("&");
                localStringBuilder.append("itemtype=");
                localStringBuilder.append(paramdpa.HWk);
                paramdox = localStringBuilder.toString();
                AppMethodBeat.o(88467);
                return paramdox;
              }
              if (az.is4G(ak.getContext()))
              {
                localStringBuilder.append("4g");
                continue;
              }
              localStringBuilder.append("3g");
            }
            catch (Exception paramdox) {}
          }
          catch (Exception paramdox) {}
        }
        catch (Exception paramString) {}
      }
      catch (Exception paramString) {}
    }
  }
  
  private static String b(dox paramdox, dpa paramdpa, b paramb)
  {
    AppMethodBeat.i(88468);
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("ismediaplay=1");
    localStringBuilder.append("&searchid=");
    localStringBuilder.append(paramdox.kid);
    localStringBuilder.append("&scene=");
    localStringBuilder.append(paramdox.scene);
    localStringBuilder.append("&businesstype=3");
    localStringBuilder.append("&mediatype=2");
    localStringBuilder.append("&rec_category=");
    localStringBuilder.append(paramdox.HVS);
    localStringBuilder.append("&docid=");
    localStringBuilder.append(paramdpa.tFc);
    localStringBuilder.append("&cdnsourcetype=");
    localStringBuilder.append(paramdpa.HWu);
    try
    {
      localStringBuilder.append("&expand1=").append(com.tencent.mm.compatible.util.q.encode(paramdpa.HWj, "utf-8"));
      label146:
      localStringBuilder.append("&query=");
      try
      {
        localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(paramdox.dmf, "utf-8"));
        label169:
        localStringBuilder.append("&title=");
        try
        {
          localStringBuilder.append(com.tencent.mm.compatible.util.q.encode(paramdpa.title, "utf-8"));
          label192:
          localStringBuilder.append("&duration=");
          localStringBuilder.append(paramdpa.AjG * 1000);
          localStringBuilder.append("&mediaid=");
          localStringBuilder.append(paramdpa.udb);
          if (paramb != null)
          {
            localStringBuilder.append("&startplaytime=");
            localStringBuilder.append(paramb.BID);
            localStringBuilder.append("&endplaytime=");
            localStringBuilder.append(paramb.BIE);
            localStringBuilder.append("&playtime=");
            localStringBuilder.append(paramb.BIF);
            localStringBuilder.append("&lastplayms=");
            localStringBuilder.append(paramb.BIG);
            localStringBuilder.append("&autoplay=");
            localStringBuilder.append(paramb.BIK);
            localStringBuilder.append("&hasplayended=");
            localStringBuilder.append(paramb.BIH);
            localStringBuilder.append("&hasquickplay=");
            localStringBuilder.append(paramb.BII);
            localStringBuilder.append("&hasfullscreen=");
            localStringBuilder.append(paramb.BIJ);
            localStringBuilder.append("&hitpreload=");
            localStringBuilder.append(paramb.BIL);
            localStringBuilder.append("&firstloadtime=");
            localStringBuilder.append(paramb.BIO);
            localStringBuilder.append("&downloadfinishtime=");
            localStringBuilder.append(paramb.BIP);
            localStringBuilder.append("&firstmoovreadytime=");
            localStringBuilder.append(paramb.BIQ);
            localStringBuilder.append("&firstdataavailabletime=");
            localStringBuilder.append(paramb.BIT);
            localStringBuilder.append("&filesize=");
            localStringBuilder.append(paramb.BIX);
            if (paramb.BIW != null)
            {
              localStringBuilder.append("&bitrate=");
              localStringBuilder.append(paramb.BIW.videoBitrate);
              localStringBuilder.append("&audiobitrate=");
              localStringBuilder.append(paramb.BIW.audioBitrate);
            }
          }
          paramdox = localStringBuilder.toString();
          AppMethodBeat.o(88468);
          return paramdox;
        }
        catch (Exception paramdox)
        {
          break label192;
        }
      }
      catch (Exception paramdox)
      {
        break label169;
      }
    }
    catch (Exception localException)
    {
      break label146;
    }
  }
  
  public final void a(dox paramdox, dpa paramdpa, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(88466);
    paramdox = b(paramdox, paramdpa, paramInt1, paramInt2, paramString);
    if (!bu.isNullOrNil(paramdox))
    {
      paramdpa = new cvj();
      paramdpa.HFU = paramdox;
      ae.i("MicroMsg.TopStory.TopStoryReporterImpl", "do12721ClickVideoReport %s", new Object[] { paramdpa.HFU });
      paramdox = new u(paramdpa);
      g.ajj().a(paramdox, 0);
    }
    AppMethodBeat.o(88466);
  }
  
  public final void a(dox paramdox, HashSet<com.tencent.mm.plugin.topstory.a.b.c> paramHashSet)
  {
    AppMethodBeat.i(88464);
    if (paramHashSet.size() == 0)
    {
      AppMethodBeat.o(88464);
      return;
    }
    a locala = (a)this.BIl.get(Long.valueOf(paramdox.HVS));
    if ((locala != null) && (this.ApE.hasMessages(0)))
    {
      ae.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo hit cached task %d add %d", new Object[] { Integer.valueOf(locala.BIn.size()), Integer.valueOf(paramHashSet.size()) });
      paramdox = paramHashSet.iterator();
      while (paramdox.hasNext())
      {
        paramHashSet = (com.tencent.mm.plugin.topstory.a.b.c)paramdox.next();
        locala.BIn.add(paramHashSet);
      }
      AppMethodBeat.o(88464);
      return;
    }
    if (locala != null) {
      ae.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo not report task: %s size: %d", new Object[] { locala, Integer.valueOf(locala.BIn.size()) });
    }
    locala = new a((byte)0);
    ae.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo new task %d %s", new Object[] { Integer.valueOf(paramHashSet.size()), locala });
    locala.createTime = System.currentTimeMillis();
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      com.tencent.mm.plugin.topstory.a.b.c localc = (com.tencent.mm.plugin.topstory.a.b.c)paramHashSet.next();
      locala.BIn.add(localc);
    }
    locala.BIo = paramdox;
    if (locala.BIn.size() > 0)
    {
      this.ApE.removeMessages(0);
      this.ApE.sendMessageDelayed(this.ApE.obtainMessage(0, locala), 5000L);
      this.BIl.put(Long.valueOf(paramdox.HVS), locala);
    }
    AppMethodBeat.o(88464);
  }
  
  final class a
    implements Runnable
  {
    HashSet<com.tencent.mm.plugin.topstory.a.b.c> BIn;
    dox BIo;
    long createTime;
    
    private a()
    {
      AppMethodBeat.i(88460);
      this.BIn = new HashSet();
      AppMethodBeat.o(88460);
    }
    
    private static String a(List<com.tencent.mm.plugin.topstory.a.b.c> paramList, dox paramdox)
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
          dpa localdpa = ((com.tencent.mm.plugin.topstory.a.b.c)localObject3).BIY;
          ((StringBuilder)localObject1).append(localdpa.dmg);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localdpa.tFc);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.topstory.a.b.c)localObject3).tNh);
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(localdpa.HWj);
          ((StringBuilder)localObject1).append(";");
        }
        try
        {
          localStringBuilder1.append(com.tencent.mm.compatible.util.q.encode(((StringBuilder)localObject1).toString(), "utf-8"));
          localStringBuilder1.append("&resulttype=");
          localObject1 = paramList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject1).next()).BIY;
            localStringBuilder1.append(((dpa)localObject2).dmg);
            localStringBuilder1.append(":");
            localStringBuilder1.append(((dpa)localObject2).HWn);
            localStringBuilder1.append(";");
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", localException, "", new Object[0]);
          }
          localStringBuilder1.append("&expand=");
          localStringBuilder2 = new StringBuilder("");
          localObject2 = paramList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((com.tencent.mm.plugin.topstory.a.b.c)((Iterator)localObject2).next()).BIY;
            localStringBuilder2.append(((dpa)localObject3).dmg);
            localStringBuilder2.append(":");
            localStringBuilder2.append(((dpa)localObject3).HWl);
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
              localStringBuilder2.append(((com.tencent.mm.plugin.topstory.a.b.c)paramList.next()).BIY.HWk);
              localStringBuilder2.append(";");
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", localUnsupportedEncodingException, "", new Object[0]);
            }
            localStringBuilder1.append(localUnsupportedEncodingException);
            if (paramdox == null) {
              break label636;
            }
          }
          localStringBuilder1.append("&");
          localStringBuilder1.append("searchid=");
          localStringBuilder1.append(paramdox.kid);
          localStringBuilder1.append("&");
          localStringBuilder1.append("query=");
        }
      }
      catch (Exception paramList)
      {
        ae.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", paramList, "build14057VideoInfoExposeString error: %s", new Object[] { paramList.getMessage() });
        AppMethodBeat.o(88462);
        return null;
      }
      try
      {
        StringBuilder localStringBuilder2;
        localStringBuilder1.append(com.tencent.mm.compatible.util.q.encode(paramdox.dmf, "utf-8"));
        localStringBuilder1.append("&");
        localStringBuilder1.append("ishomepage=0");
        localStringBuilder1.append("&");
        localStringBuilder1.append("sessionid=");
        localStringBuilder1.append(ad.WI(paramdox.scene));
        localStringBuilder1.append("&");
        localStringBuilder1.append("scene=");
        localStringBuilder1.append(paramdox.scene);
        localStringBuilder1.append("&rec_category=");
        localStringBuilder1.append(paramdox.HVS);
        label636:
        paramList = localStringBuilder1.toString();
        AppMethodBeat.o(88462);
        return paramList;
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.TopStory.TopStoryReporterImpl", paramList, "", new Object[0]);
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(88461);
      ae.i("MicroMsg.TopStory.TopStoryReporterImpl", "Star to run ReportExposeTask");
      c.this.BIl.remove(Long.valueOf(this.BIo.HVS));
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.BIn);
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 20;
        if (j >= localArrayList.size()) {}
        for (List localList = localArrayList.subList(i, localArrayList.size());; localList = localArrayList.subList(i, j))
        {
          String str = a(localList, this.BIo);
          if (!bu.isNullOrNil(str))
          {
            final cvj localcvj = new cvj();
            localcvj.HFU = str;
            ae.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14057VideoInfoExposeString %d report string: %s", new Object[] { Integer.valueOf(localList.size()), localcvj.HFU });
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(88459);
                u localu = new u(localcvj);
                g.ajj().a(localu, 0);
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
 * Qualified Name:     com.tencent.mm.plugin.topstory.c
 * JD-Core Version:    0.7.0.1
 */