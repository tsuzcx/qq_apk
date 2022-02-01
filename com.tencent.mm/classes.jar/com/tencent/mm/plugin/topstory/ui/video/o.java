package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class o
{
  private b Acd;
  Map<String, com.tencent.mm.plugin.topstory.a.b.c> Aea;
  public int Aeb;
  public com.tencent.mm.plugin.topstory.a.b.b Aec;
  public List<String> Aed;
  private dio zZN;
  private int zjn;
  
  public o()
  {
    AppMethodBeat.i(126164);
    this.Aeb = 2;
    this.Aed = new ArrayList();
    this.Aea = new HashMap();
    AppMethodBeat.o(126164);
  }
  
  public final void a(dio paramdio, int paramInt, String paramString)
  {
    AppMethodBeat.i(126169);
    this.zZN = paramdio;
    this.Aec = new com.tencent.mm.plugin.topstory.a.b.b();
    this.Aec.zZs = System.currentTimeMillis();
    this.Aec.zZA = 2L;
    this.Aec.zZz = this.Aeb;
    this.Aec.position = (paramInt + 1);
    dil localdil = this.Acd.edh();
    this.Aec.hkW = (localdil.scene + "_" + localdil.jKB + "_" + localdil.FRz);
    if (this.Acd.isFullscreenMode()) {
      this.Aec.zZy = 1L;
    }
    this.Aeb = 2;
    ac.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "startVideoPlay %s %s %s reportInfo: %d %d", new Object[] { paramString, paramdio.sVF, paramdio.title, Long.valueOf(this.Aec.zZz), Long.valueOf(this.Aec.zZA) });
    AppMethodBeat.o(126169);
  }
  
  public final void b(dil paramdil)
  {
    AppMethodBeat.i(126170);
    eei();
    ((PluginTopStory)g.ad(PluginTopStory.class)).getReporter();
    com.tencent.mm.plugin.topstory.c.a(paramdil, this.zZN, this.Aec);
    this.zZN = null;
    this.Aec = null;
    AppMethodBeat.o(126170);
  }
  
  public final void d(b paramb)
  {
    this.zjn += 1;
    this.Acd = paramb;
  }
  
  public final void eeh()
  {
    AppMethodBeat.i(126168);
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.Aea.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.topstory.a.b.c localc = (com.tencent.mm.plugin.topstory.a.b.c)localIterator.next();
      if (!localc.rAJ)
      {
        localHashSet.add(localc);
        localc.rAJ = true;
      }
    }
    if (this.Acd != null) {
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.Acd.edh(), localHashSet);
    }
    AppMethodBeat.o(126168);
  }
  
  public final void eei()
  {
    AppMethodBeat.i(126171);
    if ((this.Aec != null) && (this.zZN != null)) {
      this.Aed.add(this.zZN.sVF + "#" + this.Aec.zZv / 1000L);
    }
    AppMethodBeat.o(126171);
  }
  
  public final void i(dio paramdio)
  {
    AppMethodBeat.i(126165);
    if (paramdio == null) {
      ac.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose null");
    }
    com.tencent.mm.plugin.topstory.a.b.c localc = new com.tencent.mm.plugin.topstory.a.b.c(paramdio);
    if (!this.Aea.containsKey(localc.zZN.sVF))
    {
      this.Aea.put(localc.zZN.sVF, localc);
      ac.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose %s", new Object[] { paramdio });
      AppMethodBeat.o(126165);
      return;
    }
    ((com.tencent.mm.plugin.topstory.a.b.c)this.Aea.get(localc.zZN.sVF)).zZN = paramdio;
    AppMethodBeat.o(126165);
  }
  
  public final void j(dio paramdio)
  {
    AppMethodBeat.i(126167);
    i(paramdio);
    ((com.tencent.mm.plugin.topstory.a.b.c)this.Aea.get(paramdio.sVF)).zZO = true;
    AppMethodBeat.o(126167);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126166);
    this.zjn -= 1;
    ac.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.zjn) });
    if (this.zjn <= 0)
    {
      eeh();
      this.Acd = null;
    }
    AppMethodBeat.o(126166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.o
 * JD-Core Version:    0.7.0.1
 */