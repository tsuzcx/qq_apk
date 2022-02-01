package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dod;
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
  private int ABn;
  private dod Brz;
  private b BtO;
  Map<String, com.tencent.mm.plugin.topstory.a.b.c> BvM;
  public int BvN;
  public com.tencent.mm.plugin.topstory.a.b.b BvO;
  public List<String> BvP;
  
  public o()
  {
    AppMethodBeat.i(126164);
    this.BvN = 2;
    this.BvP = new ArrayList();
    this.BvM = new HashMap();
    AppMethodBeat.o(126164);
  }
  
  public final void a(dod paramdod, int paramInt, String paramString)
  {
    AppMethodBeat.i(126169);
    this.Brz = paramdod;
    this.BvO = new com.tencent.mm.plugin.topstory.a.b.b();
    this.BvO.Bre = System.currentTimeMillis();
    this.BvO.Brm = 2L;
    this.BvO.Brl = this.BvN;
    this.BvO.position = (paramInt + 1);
    doa localdoa = this.BtO.epz();
    this.BvO.hDf = (localdoa.scene + "_" + localdoa.keN + "_" + localdoa.HCf);
    if (this.BtO.isFullscreenMode()) {
      this.BvO.Brk = 1L;
    }
    this.BvN = 2;
    ad.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "startVideoPlay %s %s %s reportInfo: %d %d", new Object[] { paramString, paramdod.tSk, paramdod.title, Long.valueOf(this.BvO.Brl), Long.valueOf(this.BvO.Brm) });
    AppMethodBeat.o(126169);
  }
  
  public final void b(doa paramdoa)
  {
    AppMethodBeat.i(126170);
    eqz();
    ((PluginTopStory)g.ad(PluginTopStory.class)).getReporter();
    com.tencent.mm.plugin.topstory.c.a(paramdoa, this.Brz, this.BvO);
    this.Brz = null;
    this.BvO = null;
    AppMethodBeat.o(126170);
  }
  
  public final void d(b paramb)
  {
    this.ABn += 1;
    this.BtO = paramb;
  }
  
  public final void eqy()
  {
    AppMethodBeat.i(126168);
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.BvM.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.topstory.a.b.c localc = (com.tencent.mm.plugin.topstory.a.b.c)localIterator.next();
      if (!localc.ssW)
      {
        localHashSet.add(localc);
        localc.ssW = true;
      }
    }
    if (this.BtO != null) {
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.BtO.epz(), localHashSet);
    }
    AppMethodBeat.o(126168);
  }
  
  public final void eqz()
  {
    AppMethodBeat.i(126171);
    if ((this.BvO != null) && (this.Brz != null)) {
      this.BvP.add(this.Brz.tSk + "#" + this.BvO.Brh / 1000L);
    }
    AppMethodBeat.o(126171);
  }
  
  public final void i(dod paramdod)
  {
    AppMethodBeat.i(126165);
    if (paramdod == null) {
      ad.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose null");
    }
    com.tencent.mm.plugin.topstory.a.b.c localc = new com.tencent.mm.plugin.topstory.a.b.c(paramdod);
    if (!this.BvM.containsKey(localc.Brz.tSk))
    {
      this.BvM.put(localc.Brz.tSk, localc);
      ad.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose %s", new Object[] { paramdod });
      AppMethodBeat.o(126165);
      return;
    }
    ((com.tencent.mm.plugin.topstory.a.b.c)this.BvM.get(localc.Brz.tSk)).Brz = paramdod;
    AppMethodBeat.o(126165);
  }
  
  public final void j(dod paramdod)
  {
    AppMethodBeat.i(126167);
    i(paramdod);
    ((com.tencent.mm.plugin.topstory.a.b.c)this.BvM.get(paramdod.tSk)).BrA = true;
    AppMethodBeat.o(126167);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126166);
    this.ABn -= 1;
    ad.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.ABn) });
    if (this.ABn <= 0)
    {
      eqy();
      this.BtO = null;
    }
    AppMethodBeat.o(126166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.o
 * JD-Core Version:    0.7.0.1
 */