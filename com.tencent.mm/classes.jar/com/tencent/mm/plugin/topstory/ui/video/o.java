package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class o
{
  private int LrP;
  private esy MWs;
  private b MYE;
  Map<String, com.tencent.mm.plugin.topstory.a.b.c> NaE;
  public int NaF;
  public com.tencent.mm.plugin.topstory.a.b.b NaG;
  public List<String> NaH;
  
  public o()
  {
    AppMethodBeat.i(126164);
    this.NaF = 2;
    this.NaH = new ArrayList();
    this.NaE = new HashMap();
    AppMethodBeat.o(126164);
  }
  
  public final void a(esy paramesy, int paramInt, String paramString)
  {
    AppMethodBeat.i(126169);
    this.MWs = paramesy;
    this.NaG = new com.tencent.mm.plugin.topstory.a.b.b();
    this.NaG.MVX = System.currentTimeMillis();
    this.NaG.MWf = 2L;
    this.NaG.MWe = this.NaF;
    this.NaG.position = (paramInt + 1);
    esv localesv = this.MYE.gqA();
    this.NaG.lpD = (localesv.scene + "_" + localesv.jQi + "_" + localesv.UuH);
    if (this.MYE.cne()) {
      this.NaG.MWd = 1L;
    }
    this.NaF = 2;
    Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "startVideoPlay %s %s %s reportInfo: %d %d", new Object[] { paramString, paramesy.Crh, paramesy.title, Long.valueOf(this.NaG.MWe), Long.valueOf(this.NaG.MWf) });
    AppMethodBeat.o(126169);
  }
  
  public final void b(esv paramesv)
  {
    AppMethodBeat.i(126170);
    grD();
    ((PluginTopStory)h.ag(PluginTopStory.class)).getReporter();
    com.tencent.mm.plugin.topstory.c.a(paramesv, this.MWs, this.NaG);
    this.MWs = null;
    this.NaG = null;
    AppMethodBeat.o(126170);
  }
  
  public final void d(b paramb)
  {
    this.LrP += 1;
    this.MYE = paramb;
  }
  
  public final void grC()
  {
    AppMethodBeat.i(126168);
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.NaE.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.topstory.a.b.c localc = (com.tencent.mm.plugin.topstory.a.b.c)localIterator.next();
      if (!localc.Aaj)
      {
        localHashSet.add(localc);
        localc.Aaj = true;
      }
    }
    if (this.MYE != null) {
      ((com.tencent.mm.plugin.topstory.a.b)h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.MYE.gqA(), localHashSet);
    }
    AppMethodBeat.o(126168);
  }
  
  public final void grD()
  {
    AppMethodBeat.i(126171);
    if ((this.NaG != null) && (this.MWs != null)) {
      this.NaH.add(this.MWs.Crh + "#" + this.NaG.MWa / 1000L);
    }
    AppMethodBeat.o(126171);
  }
  
  public final void j(esy paramesy)
  {
    AppMethodBeat.i(126165);
    if (paramesy == null) {
      Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose null");
    }
    com.tencent.mm.plugin.topstory.a.b.c localc = new com.tencent.mm.plugin.topstory.a.b.c(paramesy);
    if (!this.NaE.containsKey(localc.MWs.Crh))
    {
      this.NaE.put(localc.MWs.Crh, localc);
      Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose %s", new Object[] { paramesy });
      AppMethodBeat.o(126165);
      return;
    }
    ((com.tencent.mm.plugin.topstory.a.b.c)this.NaE.get(localc.MWs.Crh)).MWs = paramesy;
    AppMethodBeat.o(126165);
  }
  
  public final void k(esy paramesy)
  {
    AppMethodBeat.i(126167);
    j(paramesy);
    ((com.tencent.mm.plugin.topstory.a.b.c)this.NaE.get(paramesy.Crh)).MWt = true;
    AppMethodBeat.o(126167);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126166);
    this.LrP -= 1;
    Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.LrP) });
    if (this.LrP <= 0)
    {
      grC();
      this.MYE = null;
    }
    AppMethodBeat.o(126166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.o
 * JD-Core Version:    0.7.0.1
 */