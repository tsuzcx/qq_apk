package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.c;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public final class o
{
  private byg pDy;
  private b pEp;
  private int pFU;
  Map<String, com.tencent.mm.plugin.topstory.a.b.b> pGo = new HashMap();
  public int pGp = 2;
  public com.tencent.mm.plugin.topstory.a.b.a pGq;
  
  public final void a(byg parambyg, int paramInt, String paramString)
  {
    this.pDy = parambyg;
    this.pGq = new com.tencent.mm.plugin.topstory.a.b.a();
    this.pGq.pDe = System.currentTimeMillis();
    this.pGq.pDm = 2L;
    this.pGq.pDl = this.pGp;
    this.pGq.position = (paramInt + 1);
    byf localbyf = this.pEp.bNv();
    this.pGq.pDx = (localbyf.scene + "_" + localbyf.fTF + "_" + localbyf.tOo);
    if (this.pEp.isFullscreenMode()) {
      this.pGq.pDk = 1L;
    }
    this.pGp = 2;
    y.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "startVideoPlay %s %s %s reportInfo: %d %d", new Object[] { paramString, parambyg.tOx, parambyg.title, Long.valueOf(this.pGq.pDl), Long.valueOf(this.pGq.pDm) });
  }
  
  public final void akT()
  {
    this.pFU -= 1;
    y.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.pFU) });
    if (this.pFU <= 0)
    {
      bOp();
      this.pEp = null;
    }
  }
  
  public final void b(byf parambyf)
  {
    ((PluginTopStory)g.t(PluginTopStory.class)).getReporter();
    byg localbyg = this.pDy;
    com.tencent.mm.plugin.topstory.a.b.a locala = this.pGq;
    y.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay: %s %s", new Object[] { localbyg, locala });
    if ((localbyg != null) && (locala != null))
    {
      locala.pDf = System.currentTimeMillis();
      locala.pDg = (locala.pDf - locala.pDe);
      Object localObject = c.a(parambyf, localbyg, locala);
      if (!bk.bl((String)localObject))
      {
        blf localblf = new blf();
        localblf.tEQ = ((String)localObject);
        y.i("MicroMsg.TopStory.TopStoryReporterImpl", "build14436VideoPlayReportString %s", new Object[] { localblf.tEQ });
        localObject = new w(localblf);
        g.Dk().a((m)localObject, 0);
      }
      parambyf = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(parambyf.scene), localbyg.tOx, Long.valueOf(localbyg.tOF), "mp4", Integer.valueOf(localbyg.tOw), Integer.valueOf(0), Long.valueOf(locala.pDe), Long.valueOf(locala.pDf), Long.valueOf(locala.pDh), Long.valueOf(locala.pDg), Long.valueOf(locala.pDj), Long.valueOf(locala.pDk), Long.valueOf(locala.pDl), Long.valueOf(locala.pDm), Long.valueOf(locala.pDp), Long.valueOf(locala.pDq), Long.valueOf(locala.pDi), Long.valueOf(locala.pDr), Long.valueOf(locala.pDs), Long.valueOf(locala.pDu), Long.valueOf(locala.pDv), locala.pDx, Long.valueOf(locala.position), aa.boM(), Long.valueOf(locala.pDt), Long.valueOf(locala.pDw), Long.valueOf(locala.pDn), Long.valueOf(locala.pDo), parambyf.tNY });
      y.i("MicroMsg.TopStory.TopStoryReporterImpl", "stopVideoPlay 15414 %s", new Object[] { parambyf });
      com.tencent.mm.plugin.report.f.nEG.aC(15414, parambyf);
      com.tencent.mm.plugin.topstory.a.a.a.a(locala);
    }
    this.pDy = null;
    this.pGq = null;
  }
  
  public final void b(byg parambyg)
  {
    if (parambyg == null) {
      y.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose null");
    }
    com.tencent.mm.plugin.topstory.a.b.b localb = new com.tencent.mm.plugin.topstory.a.b.b(parambyg);
    if (!this.pGo.containsKey(localb.pDy.tOx))
    {
      this.pGo.put(localb.pDy.tOx, localb);
      y.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose %s", new Object[] { parambyg });
      return;
    }
    ((com.tencent.mm.plugin.topstory.a.b.b)this.pGo.get(localb.pDy.tOx)).pDy = parambyg;
  }
  
  public final void bOp()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.pGo.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.topstory.a.b.b localb = (com.tencent.mm.plugin.topstory.a.b.b)localIterator.next();
      if (!localb.nHq)
      {
        localHashSet.add(localb);
        localb.nHq = true;
      }
    }
    if (this.pEp != null) {
      ((com.tencent.mm.plugin.topstory.a.b)g.t(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.pEp.bNv(), localHashSet);
    }
  }
  
  public final void c(byg parambyg)
  {
    b(parambyg);
    ((com.tencent.mm.plugin.topstory.a.b.b)this.pGo.get(parambyg.tOx)).pDz = true;
  }
  
  public final void d(b paramb)
  {
    this.pFU += 1;
    this.pEp = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.o
 * JD-Core Version:    0.7.0.1
 */