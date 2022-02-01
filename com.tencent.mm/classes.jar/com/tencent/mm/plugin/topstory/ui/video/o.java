package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class o
{
  private int xWr;
  private ddb yLU;
  private b yOm;
  Map<String, com.tencent.mm.plugin.topstory.a.b.c> yQk;
  public int yQl;
  public com.tencent.mm.plugin.topstory.a.b.b yQm;
  public List<String> yQn;
  
  public o()
  {
    AppMethodBeat.i(126164);
    this.yQl = 2;
    this.yQn = new ArrayList();
    this.yQk = new HashMap();
    AppMethodBeat.o(126164);
  }
  
  public final void a(ddb paramddb, int paramInt, String paramString)
  {
    AppMethodBeat.i(126169);
    this.yLU = paramddb;
    this.yQm = new com.tencent.mm.plugin.topstory.a.b.b();
    this.yQm.yLz = System.currentTimeMillis();
    this.yQm.yLH = 2L;
    this.yQm.yLG = this.yQl;
    this.yQm.position = (paramInt + 1);
    dcy localdcy = this.yOm.dOH();
    this.yQm.gKw = (localdcy.scene + "_" + localdcy.jko + "_" + localdcy.Euy);
    if (this.yOm.isFullscreenMode()) {
      this.yQm.yLF = 1L;
    }
    this.yQl = 2;
    ad.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "startVideoPlay %s %s %s reportInfo: %d %d", new Object[] { paramString, paramddb.rNP, paramddb.title, Long.valueOf(this.yQm.yLG), Long.valueOf(this.yQm.yLH) });
    AppMethodBeat.o(126169);
  }
  
  public final void b(dcy paramdcy)
  {
    AppMethodBeat.i(126170);
    dPJ();
    ((PluginTopStory)g.ad(PluginTopStory.class)).getReporter();
    com.tencent.mm.plugin.topstory.c.a(paramdcy, this.yLU, this.yQm);
    this.yLU = null;
    this.yQm = null;
    AppMethodBeat.o(126170);
  }
  
  public final void d(b paramb)
  {
    this.xWr += 1;
    this.yOm = paramb;
  }
  
  public final void dPI()
  {
    AppMethodBeat.i(126168);
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.yQk.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.topstory.a.b.c localc = (com.tencent.mm.plugin.topstory.a.b.c)localIterator.next();
      if (!localc.qHI)
      {
        localHashSet.add(localc);
        localc.qHI = true;
      }
    }
    if (this.yOm != null) {
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.yOm.dOH(), localHashSet);
    }
    AppMethodBeat.o(126168);
  }
  
  public final void dPJ()
  {
    AppMethodBeat.i(126171);
    if ((this.yQm != null) && (this.yLU != null)) {
      this.yQn.add(this.yLU.rNP + "#" + this.yQm.yLC / 1000L);
    }
    AppMethodBeat.o(126171);
  }
  
  public final void i(ddb paramddb)
  {
    AppMethodBeat.i(126165);
    if (paramddb == null) {
      ad.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose null");
    }
    com.tencent.mm.plugin.topstory.a.b.c localc = new com.tencent.mm.plugin.topstory.a.b.c(paramddb);
    if (!this.yQk.containsKey(localc.yLU.rNP))
    {
      this.yQk.put(localc.yLU.rNP, localc);
      ad.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose %s", new Object[] { paramddb });
      AppMethodBeat.o(126165);
      return;
    }
    ((com.tencent.mm.plugin.topstory.a.b.c)this.yQk.get(localc.yLU.rNP)).yLU = paramddb;
    AppMethodBeat.o(126165);
  }
  
  public final void j(ddb paramddb)
  {
    AppMethodBeat.i(126167);
    i(paramddb);
    ((com.tencent.mm.plugin.topstory.a.b.c)this.yQk.get(paramddb.rNP)).yLV = true;
    AppMethodBeat.o(126167);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126166);
    this.xWr -= 1;
    ad.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.xWr) });
    if (this.xWr <= 0)
    {
      dPI();
      this.yOm = null;
    }
    AppMethodBeat.o(126166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.o
 * JD-Core Version:    0.7.0.1
 */