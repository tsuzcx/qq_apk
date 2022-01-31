package com.tencent.mm.plugin.topstory;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.topstory.a.b.b;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
  implements f
{
  ak teK;
  Map<Long, c.a> teL;
  
  public c()
  {
    AppMethodBeat.i(65497);
    this.teL = new ConcurrentHashMap();
    this.teK = new c.1(this, new al("TopStoryReportExposeTask").oNc.getLooper());
    AppMethodBeat.o(65497);
  }
  
  public static void a(ckw paramckw, ckx paramckx, com.tencent.mm.plugin.topstory.a.b.a parama)
  {
    AppMethodBeat.i(65499);
    ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay: %s %s", new Object[] { paramckx, parama });
    if ((paramckx != null) && (parama != null))
    {
      parama.teU = System.currentTimeMillis();
      parama.teV = (parama.teU - parama.teT);
      Object localObject = b(paramckw, paramckx, parama);
      if (!bo.isNullOrNil((String)localObject))
      {
        buo localbuo = new buo();
        localbuo.xHP = ((String)localObject);
        ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14436VideoPlayReportString %s", new Object[] { localbuo.xHP });
        localObject = new w(localbuo);
        g.Rc().a((m)localObject, 0);
      }
      paramckw = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(paramckw.scene), paramckx.xVa, Long.valueOf(paramckx.xVi), "mp4", Integer.valueOf(paramckx.xUZ), Integer.valueOf(0), Long.valueOf(parama.teT), Long.valueOf(parama.teU), Long.valueOf(parama.teW), Long.valueOf(parama.teV), Long.valueOf(parama.teY), Long.valueOf(parama.teZ), Long.valueOf(parama.tfa), Long.valueOf(parama.tfb), Long.valueOf(parama.tfe), Long.valueOf(parama.tff), Long.valueOf(parama.teX), Long.valueOf(parama.tfg), Long.valueOf(parama.tfh), Long.valueOf(parama.tfj), Long.valueOf(parama.tfk), parama.fjC, Long.valueOf(parama.position), aa.bXn(), Long.valueOf(parama.tfi), Long.valueOf(parama.tfl), Long.valueOf(parama.tfc), Long.valueOf(parama.tfd), paramckw.xUt });
      ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay 15414 %s", new Object[] { paramckw });
      e.qrI.kvStat(15414, paramckw);
      com.tencent.mm.plugin.topstory.a.a.a.a(parama);
    }
    AppMethodBeat.o(65499);
  }
  
  private static String b(ckw paramckw, ckx paramckx, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(65501);
    StringBuilder localStringBuilder = new StringBuilder("");
    for (;;)
    {
      try
      {
        localStringBuilder.append("scene=");
        localStringBuilder.append(paramckw.scene);
        localStringBuilder.append("&");
        localStringBuilder.append("businesstype=3");
        localStringBuilder.append("&");
        localStringBuilder.append("mediatype=2");
        localStringBuilder.append("&");
        localStringBuilder.append("docid=");
        localStringBuilder.append(paramckx.uKI);
        localStringBuilder.append("&");
        localStringBuilder.append("typepos=");
        localStringBuilder.append("0");
        localStringBuilder.append("&");
        localStringBuilder.append("docpos=");
        localStringBuilder.append(paramInt1 + 1);
        localStringBuilder.append("&");
        localStringBuilder.append("searchid=");
        localStringBuilder.append(paramckw.hng);
        localStringBuilder.append("&");
        localStringBuilder.append("ishomepage=");
        localStringBuilder.append(0);
        localStringBuilder.append("&rec_category=");
        localStringBuilder.append(paramckx.xVb);
        localStringBuilder.append("&");
        localStringBuilder.append("timestamp=");
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append("&");
        localStringBuilder.append("clicktype=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("&");
        localStringBuilder.append("clickcontent=");
      }
      catch (Exception paramckw)
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
          localStringBuilder.append(q.encode(paramckw.cnv, "utf-8"));
          localStringBuilder.append("&");
          localStringBuilder.append("resulttype=");
          localStringBuilder.append(paramckx.xVh);
          localStringBuilder.append("&");
          localStringBuilder.append("sessionid=");
          localStringBuilder.append(aa.IZ(paramckw.scene));
          localStringBuilder.append("&");
          localStringBuilder.append("expand=");
          try
          {
            localStringBuilder.append(q.encode(paramckx.xVd, "utf-8"));
            localStringBuilder.append("&");
            localStringBuilder.append("title=");
            try
            {
              localStringBuilder.append(q.encode(paramckx.title, "utf-8"));
              localStringBuilder.append("&");
              localStringBuilder.append("nettype=");
              if (at.isWifi(ah.getContext()))
              {
                localStringBuilder.append("wifi");
                localStringBuilder.append("&");
                localStringBuilder.append("itemtype=");
                localStringBuilder.append(paramckx.xVe);
                paramckw = localStringBuilder.toString();
                AppMethodBeat.o(65501);
                return paramckw;
              }
              if (at.is4G(ah.getContext()))
              {
                localStringBuilder.append("4g");
                continue;
              }
              localStringBuilder.append("3g");
            }
            catch (Exception paramckw) {}
          }
          catch (Exception paramckw) {}
        }
        catch (Exception paramString) {}
      }
      catch (Exception paramString) {}
    }
  }
  
  private static String b(ckw paramckw, ckx paramckx, com.tencent.mm.plugin.topstory.a.b.a parama)
  {
    AppMethodBeat.i(65502);
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("ismediaplay=1");
    localStringBuilder.append("&searchid=");
    localStringBuilder.append(paramckw.hng);
    localStringBuilder.append("&scene=");
    localStringBuilder.append(paramckw.scene);
    localStringBuilder.append("&businesstype=3");
    localStringBuilder.append("&mediatype=2");
    localStringBuilder.append("&rec_category=");
    localStringBuilder.append(paramckw.xUO);
    localStringBuilder.append("&docid=");
    localStringBuilder.append(paramckx.uKI);
    localStringBuilder.append("&cdnsourcetype=");
    localStringBuilder.append(paramckx.xVr);
    try
    {
      localStringBuilder.append("&expand1=").append(q.encode(paramckx.xVd, "utf-8"));
      label146:
      localStringBuilder.append("&query=");
      try
      {
        localStringBuilder.append(q.encode(paramckw.cnv, "utf-8"));
        label169:
        localStringBuilder.append("&title=");
        try
        {
          localStringBuilder.append(q.encode(paramckx.title, "utf-8"));
          label192:
          localStringBuilder.append("&duration=");
          localStringBuilder.append(paramckx.xUZ * 1000);
          localStringBuilder.append("&mediaid=");
          localStringBuilder.append(paramckx.xVa);
          if (parama != null)
          {
            localStringBuilder.append("&startplaytime=");
            localStringBuilder.append(parama.teT);
            localStringBuilder.append("&endplaytime=");
            localStringBuilder.append(parama.teU);
            localStringBuilder.append("&playtime=");
            localStringBuilder.append(parama.teV);
            localStringBuilder.append("&lastplayms=");
            localStringBuilder.append(parama.teW);
            localStringBuilder.append("&autoplay=");
            localStringBuilder.append(parama.tfa);
            localStringBuilder.append("&hasplayended=");
            localStringBuilder.append(parama.teX);
            localStringBuilder.append("&hasquickplay=");
            localStringBuilder.append(parama.teY);
            localStringBuilder.append("&hasfullscreen=");
            localStringBuilder.append(parama.teZ);
            localStringBuilder.append("&hitpreload=");
            localStringBuilder.append(parama.tfb);
            localStringBuilder.append("&firstloadtime=");
            localStringBuilder.append(parama.tfe);
            localStringBuilder.append("&downloadfinishtime=");
            localStringBuilder.append(parama.tff);
            localStringBuilder.append("&firstmoovreadytime=");
            localStringBuilder.append(parama.tfg);
            localStringBuilder.append("&firstdataavailabletime=");
            localStringBuilder.append(parama.tfj);
          }
          paramckw = localStringBuilder.toString();
          AppMethodBeat.o(65502);
          return paramckw;
        }
        catch (Exception paramckw)
        {
          break label192;
        }
      }
      catch (Exception paramckw)
      {
        break label169;
      }
    }
    catch (Exception localException)
    {
      break label146;
    }
  }
  
  public final void a(ckw paramckw, ckx paramckx, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(65500);
    paramckw = b(paramckw, paramckx, paramInt1, paramInt2, paramString);
    if (!bo.isNullOrNil(paramckw))
    {
      paramckx = new buo();
      paramckx.xHP = paramckw;
      ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "do12721ClickVideoReport %s", new Object[] { paramckx.xHP });
      paramckw = new w(paramckx);
      g.Rc().a(paramckw, 0);
    }
    AppMethodBeat.o(65500);
  }
  
  public final void a(ckw paramckw, HashSet<b> paramHashSet)
  {
    AppMethodBeat.i(65498);
    if (paramHashSet.size() == 0)
    {
      AppMethodBeat.o(65498);
      return;
    }
    c.a locala = (c.a)this.teL.get(Long.valueOf(paramckw.xUO));
    if ((locala != null) && (this.teK.hasMessages(0)))
    {
      ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo hit cached task %d add %d", new Object[] { Integer.valueOf(locala.teN.size()), Integer.valueOf(paramHashSet.size()) });
      paramckw = paramHashSet.iterator();
      while (paramckw.hasNext())
      {
        paramHashSet = (b)paramckw.next();
        locala.teN.add(paramHashSet);
      }
      AppMethodBeat.o(65498);
      return;
    }
    if (locala != null) {
      ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo not report task: %s size: %d", new Object[] { locala, Integer.valueOf(locala.teN.size()) });
    }
    locala = new c.a(this, (byte)0);
    ab.i("MicroMsg.TopStory.TopStoryReporterImpl", "reportExposeVideoInfo new task %d %s", new Object[] { Integer.valueOf(paramHashSet.size()), locala });
    locala.createTime = System.currentTimeMillis();
    paramHashSet = paramHashSet.iterator();
    while (paramHashSet.hasNext())
    {
      b localb = (b)paramHashSet.next();
      locala.teN.add(localb);
    }
    locala.teO = paramckw;
    if (locala.teN.size() > 0)
    {
      this.teK.removeMessages(0);
      this.teK.sendMessageDelayed(this.teK.obtainMessage(0, locala), 5000L);
      this.teL.put(Long.valueOf(paramckw.xUO), locala);
    }
    AppMethodBeat.o(65498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.c
 * JD-Core Version:    0.7.0.1
 */