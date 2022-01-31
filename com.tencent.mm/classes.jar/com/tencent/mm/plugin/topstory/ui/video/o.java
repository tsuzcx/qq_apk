package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.a.b.a;
import com.tencent.mm.plugin.topstory.a.f;
import com.tencent.mm.plugin.topstory.c;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public final class o
{
  private int smh;
  private ckx tfm;
  private b thM;
  Map<String, com.tencent.mm.plugin.topstory.a.b.b> tjJ;
  public int tjK;
  public a tjL;
  
  public o()
  {
    AppMethodBeat.i(1792);
    this.tjK = 2;
    this.tjJ = new HashMap();
    AppMethodBeat.o(1792);
  }
  
  public final void a(ckx paramckx, int paramInt, String paramString)
  {
    AppMethodBeat.i(1797);
    this.tfm = paramckx;
    this.tjL = new a();
    this.tjL.teT = System.currentTimeMillis();
    this.tjL.tfb = 2L;
    this.tjL.tfa = this.tjK;
    this.tjL.position = (paramInt + 1);
    ckw localckw = this.thM.cJf();
    this.tjL.fjC = (localckw.scene + "_" + localckw.hng + "_" + localckw.xUO);
    if (this.thM.isFullscreenMode()) {
      this.tjL.teZ = 1L;
    }
    this.tjK = 2;
    ab.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "startVideoPlay %s %s %s reportInfo: %d %d", new Object[] { paramString, paramckx.xVa, paramckx.title, Long.valueOf(this.tjL.tfa), Long.valueOf(this.tjL.tfb) });
    AppMethodBeat.o(1797);
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(1794);
    this.smh -= 1;
    ab.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.smh) });
    if (this.smh <= 0)
    {
      cKd();
      this.thM = null;
    }
    AppMethodBeat.o(1794);
  }
  
  public final void b(ckw paramckw)
  {
    AppMethodBeat.i(1798);
    ((PluginTopStory)g.G(PluginTopStory.class)).getReporter();
    c.a(paramckw, this.tfm, this.tjL);
    this.tfm = null;
    this.tjL = null;
    AppMethodBeat.o(1798);
  }
  
  public final void cKd()
  {
    AppMethodBeat.i(1796);
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.tjJ.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.topstory.a.b.b localb = (com.tencent.mm.plugin.topstory.a.b.b)localIterator.next();
      if (!localb.quM)
      {
        localHashSet.add(localb);
        localb.quM = true;
      }
    }
    if (this.thM != null) {
      ((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.thM.cJf(), localHashSet);
    }
    AppMethodBeat.o(1796);
  }
  
  public final void d(b paramb)
  {
    this.smh += 1;
    this.thM = paramb;
  }
  
  public final void f(ckx paramckx)
  {
    AppMethodBeat.i(1793);
    if (paramckx == null) {
      ab.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose null");
    }
    com.tencent.mm.plugin.topstory.a.b.b localb = new com.tencent.mm.plugin.topstory.a.b.b(paramckx);
    if (!this.tjJ.containsKey(localb.tfm.xVa))
    {
      this.tjJ.put(localb.tfm.xVa, localb);
      ab.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose %s", new Object[] { paramckx });
      AppMethodBeat.o(1793);
      return;
    }
    ((com.tencent.mm.plugin.topstory.a.b.b)this.tjJ.get(localb.tfm.xVa)).tfm = paramckx;
    AppMethodBeat.o(1793);
  }
  
  public final void g(ckx paramckx)
  {
    AppMethodBeat.i(1795);
    f(paramckx);
    ((com.tencent.mm.plugin.topstory.a.b.b)this.tjJ.get(paramckx.xVa)).tfn = true;
    AppMethodBeat.o(1795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.o
 * JD-Core Version:    0.7.0.1
 */