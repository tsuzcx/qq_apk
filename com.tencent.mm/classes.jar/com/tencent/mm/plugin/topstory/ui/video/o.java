package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class o
{
  private int ASI;
  private dpa BIY;
  private b BLm;
  Map<String, com.tencent.mm.plugin.topstory.a.b.c> BNk;
  public int BNl;
  public com.tencent.mm.plugin.topstory.a.b.b BNm;
  public List<String> BNn;
  
  public o()
  {
    AppMethodBeat.i(126164);
    this.BNl = 2;
    this.BNn = new ArrayList();
    this.BNk = new HashMap();
    AppMethodBeat.o(126164);
  }
  
  public final void a(dpa paramdpa, int paramInt, String paramString)
  {
    AppMethodBeat.i(126169);
    this.BIY = paramdpa;
    this.BNm = new com.tencent.mm.plugin.topstory.a.b.b();
    this.BNm.BID = System.currentTimeMillis();
    this.BNm.BIL = 2L;
    this.BNm.BIK = this.BNl;
    this.BNm.position = (paramInt + 1);
    dox localdox = this.BLm.etg();
    this.BNm.hFX = (localdox.scene + "_" + localdox.kid + "_" + localdox.HVS);
    if (this.BLm.isFullscreenMode()) {
      this.BNm.BIJ = 1L;
    }
    this.BNl = 2;
    ae.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "startVideoPlay %s %s %s reportInfo: %d %d", new Object[] { paramString, paramdpa.udb, paramdpa.title, Long.valueOf(this.BNm.BIK), Long.valueOf(this.BNm.BIL) });
    AppMethodBeat.o(126169);
  }
  
  public final void b(dox paramdox)
  {
    AppMethodBeat.i(126170);
    eug();
    ((PluginTopStory)g.ad(PluginTopStory.class)).getReporter();
    com.tencent.mm.plugin.topstory.c.a(paramdox, this.BIY, this.BNm);
    this.BIY = null;
    this.BNm = null;
    AppMethodBeat.o(126170);
  }
  
  public final void d(b paramb)
  {
    this.ASI += 1;
    this.BLm = paramb;
  }
  
  public final void euf()
  {
    AppMethodBeat.i(126168);
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.BNk.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.topstory.a.b.c localc = (com.tencent.mm.plugin.topstory.a.b.c)localIterator.next();
      if (!localc.sDg)
      {
        localHashSet.add(localc);
        localc.sDg = true;
      }
    }
    if (this.BLm != null) {
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.BLm.etg(), localHashSet);
    }
    AppMethodBeat.o(126168);
  }
  
  public final void eug()
  {
    AppMethodBeat.i(126171);
    if ((this.BNm != null) && (this.BIY != null)) {
      this.BNn.add(this.BIY.udb + "#" + this.BNm.BIG / 1000L);
    }
    AppMethodBeat.o(126171);
  }
  
  public final void i(dpa paramdpa)
  {
    AppMethodBeat.i(126165);
    if (paramdpa == null) {
      ae.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose null");
    }
    com.tencent.mm.plugin.topstory.a.b.c localc = new com.tencent.mm.plugin.topstory.a.b.c(paramdpa);
    if (!this.BNk.containsKey(localc.BIY.udb))
    {
      this.BNk.put(localc.BIY.udb, localc);
      ae.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose %s", new Object[] { paramdpa });
      AppMethodBeat.o(126165);
      return;
    }
    ((com.tencent.mm.plugin.topstory.a.b.c)this.BNk.get(localc.BIY.udb)).BIY = paramdpa;
    AppMethodBeat.o(126165);
  }
  
  public final void j(dpa paramdpa)
  {
    AppMethodBeat.i(126167);
    i(paramdpa);
    ((com.tencent.mm.plugin.topstory.a.b.c)this.BNk.get(paramdpa.udb)).BIZ = true;
    AppMethodBeat.o(126167);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126166);
    this.ASI -= 1;
    ae.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.ASI) });
    if (this.ASI <= 0)
    {
      euf();
      this.BLm = null;
    }
    AppMethodBeat.o(126166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.o
 * JD-Core Version:    0.7.0.1
 */