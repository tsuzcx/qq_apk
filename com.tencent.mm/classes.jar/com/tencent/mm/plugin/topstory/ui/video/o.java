package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
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
  private int Fdo;
  private eiw GjH;
  private b GlS;
  Map<String, com.tencent.mm.plugin.topstory.a.b.c> GnR;
  public int GnS;
  public com.tencent.mm.plugin.topstory.a.b.b GnT;
  public List<String> GnU;
  
  public o()
  {
    AppMethodBeat.i(126164);
    this.GnS = 2;
    this.GnU = new ArrayList();
    this.GnR = new HashMap();
    AppMethodBeat.o(126164);
  }
  
  public final void a(eiw parameiw, int paramInt, String paramString)
  {
    AppMethodBeat.i(126169);
    this.GjH = parameiw;
    this.GnT = new com.tencent.mm.plugin.topstory.a.b.b();
    this.GnT.Gjm = System.currentTimeMillis();
    this.GnT.Gju = 2L;
    this.GnT.Gjt = this.GnS;
    this.GnT.position = (paramInt + 1);
    eit localeit = this.GlS.fyD();
    this.GnT.iAh = (localeit.scene + "_" + localeit.hes + "_" + localeit.Nib);
    if (this.GlS.isFullscreenMode()) {
      this.GnT.Gjs = 1L;
    }
    this.GnS = 2;
    Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "startVideoPlay %s %s %s reportInfo: %d %d", new Object[] { paramString, parameiw.psI, parameiw.title, Long.valueOf(this.GnT.Gjt), Long.valueOf(this.GnT.Gju) });
    AppMethodBeat.o(126169);
  }
  
  public final void b(eit parameit)
  {
    AppMethodBeat.i(126170);
    fzC();
    ((PluginTopStory)g.ah(PluginTopStory.class)).getReporter();
    com.tencent.mm.plugin.topstory.c.a(parameit, this.GjH, this.GnT);
    this.GjH = null;
    this.GnT = null;
    AppMethodBeat.o(126170);
  }
  
  public final void d(b paramb)
  {
    this.Fdo += 1;
    this.GlS = paramb;
  }
  
  public final void fzB()
  {
    AppMethodBeat.i(126168);
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.GnR.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.topstory.a.b.c localc = (com.tencent.mm.plugin.topstory.a.b.c)localIterator.next();
      if (!localc.vtY)
      {
        localHashSet.add(localc);
        localc.vtY = true;
      }
    }
    if (this.GlS != null) {
      ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.GlS.fyD(), localHashSet);
    }
    AppMethodBeat.o(126168);
  }
  
  public final void fzC()
  {
    AppMethodBeat.i(126171);
    if ((this.GnT != null) && (this.GjH != null)) {
      this.GnU.add(this.GjH.psI + "#" + this.GnT.Gjp / 1000L);
    }
    AppMethodBeat.o(126171);
  }
  
  public final void j(eiw parameiw)
  {
    AppMethodBeat.i(126165);
    if (parameiw == null) {
      Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose null");
    }
    com.tencent.mm.plugin.topstory.a.b.c localc = new com.tencent.mm.plugin.topstory.a.b.c(parameiw);
    if (!this.GnR.containsKey(localc.GjH.psI))
    {
      this.GnR.put(localc.GjH.psI, localc);
      Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose %s", new Object[] { parameiw });
      AppMethodBeat.o(126165);
      return;
    }
    ((com.tencent.mm.plugin.topstory.a.b.c)this.GnR.get(localc.GjH.psI)).GjH = parameiw;
    AppMethodBeat.o(126165);
  }
  
  public final void k(eiw parameiw)
  {
    AppMethodBeat.i(126167);
    j(parameiw);
    ((com.tencent.mm.plugin.topstory.a.b.c)this.GnR.get(parameiw.psI)).GjI = true;
    AppMethodBeat.o(126167);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126166);
    this.Fdo -= 1;
    Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.Fdo) });
    if (this.Fdo <= 0)
    {
      fzB();
      this.GlS = null;
    }
    AppMethodBeat.o(126166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.o
 * JD-Core Version:    0.7.0.1
 */