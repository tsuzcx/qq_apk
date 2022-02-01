package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.a.b.c;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.topstory.d;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.protocal.protobuf.foh;
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
  private int RUS;
  private foh TIW;
  private b TLn;
  Map<String, c> TNn;
  public int TNo;
  public com.tencent.mm.plugin.topstory.a.b.b TNp;
  public List<String> TNq;
  
  public o()
  {
    AppMethodBeat.i(126164);
    this.TNo = 2;
    this.TNq = new ArrayList();
    this.TNn = new HashMap();
    AppMethodBeat.o(126164);
  }
  
  public final void a(foh paramfoh, int paramInt, String paramString)
  {
    AppMethodBeat.i(126169);
    this.TIW = paramfoh;
    this.TNp = new com.tencent.mm.plugin.topstory.a.b.b();
    this.TNp.TIB = System.currentTimeMillis();
    this.TNp.TIJ = 2L;
    this.TNp.TII = this.TNo;
    this.TNp.position = (paramInt + 1);
    foe localfoe = this.TLn.hNz();
    this.TNp.mso = (localfoe.scene + "_" + localfoe.mpa + "_" + localfoe.abOj);
    if (this.TLn.cOX()) {
      this.TNp.TIH = 1L;
    }
    this.TNo = 2;
    Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "startVideoPlay %s %s %s reportInfo: %d %d", new Object[] { paramString, paramfoh.Ido, paramfoh.title, Long.valueOf(this.TNp.TII), Long.valueOf(this.TNp.TIJ) });
    AppMethodBeat.o(126169);
  }
  
  public final void b(foe paramfoe)
  {
    AppMethodBeat.i(126170);
    hOD();
    ((PluginTopStory)h.az(PluginTopStory.class)).getReporter();
    d.a(paramfoe, this.TIW, this.TNp);
    this.TIW = null;
    this.TNp = null;
    AppMethodBeat.o(126170);
  }
  
  public final void d(b paramb)
  {
    this.RUS += 1;
    this.TLn = paramb;
  }
  
  public final void hOC()
  {
    AppMethodBeat.i(126168);
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.TNn.values().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (!localc.lAr)
      {
        localHashSet.add(localc);
        localc.lAr = true;
      }
    }
    if (this.TLn != null) {
      ((com.tencent.mm.plugin.topstory.a.b)h.az(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.TLn.hNz(), localHashSet);
    }
    AppMethodBeat.o(126168);
  }
  
  public final void hOD()
  {
    AppMethodBeat.i(126171);
    if ((this.TNp != null) && (this.TIW != null)) {
      this.TNq.add(this.TIW.Ido + "#" + this.TNp.TIE / 1000L);
    }
    AppMethodBeat.o(126171);
  }
  
  public final void j(foh paramfoh)
  {
    AppMethodBeat.i(126165);
    if (paramfoh == null) {
      Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose null");
    }
    c localc = new c(paramfoh);
    if (!this.TNn.containsKey(localc.TIW.Ido))
    {
      this.TNn.put(localc.TIW.Ido, localc);
      Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "setVideoInfoExpose %s", new Object[] { paramfoh });
      AppMethodBeat.o(126165);
      return;
    }
    ((c)this.TNn.get(localc.TIW.Ido)).TIW = paramfoh;
    AppMethodBeat.o(126165);
  }
  
  public final void k(foh paramfoh)
  {
    AppMethodBeat.i(126167);
    j(paramfoh);
    ((c)this.TNn.get(paramfoh.Ido)).TIX = true;
    AppMethodBeat.o(126167);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126166);
    this.RUS -= 1;
    Log.i("MicroMSsg.TopStory.TopStoryVideoReportMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.RUS) });
    if (this.RUS <= 0)
    {
      hOC();
      this.TLn = null;
    }
    AppMethodBeat.o(126166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.o
 * JD-Core Version:    0.7.0.1
 */