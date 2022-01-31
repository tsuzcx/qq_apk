package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.cky;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class m
{
  private int smh;
  b thM;
  String tjp;
  Map<String, cky> tjq;
  Set<String> tjr;
  
  public m()
  {
    AppMethodBeat.i(1751);
    this.smh = 0;
    this.tjq = Collections.synchronizedMap(new HashMap());
    this.tjr = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(1751);
  }
  
  static long ac(long paramLong1, long paramLong2)
  {
    long l = 0L;
    if (paramLong2 != 0L) {
      l = 100L * paramLong1 / paramLong2;
    }
    return l;
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(1753);
    this.smh -= 1;
    ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.smh) });
    if (this.smh <= 0)
    {
      cKa();
      this.tjr.clear();
      d.post(new m.b(this, this.tjp), "TopStory.DeleteVideoFolderTask");
      this.thM = null;
    }
    AppMethodBeat.o(1753);
  }
  
  public final void cKa()
  {
    AppMethodBeat.i(1754);
    Iterator localIterator = this.tjr.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      f.afO().sJ(str);
    }
    AppMethodBeat.o(1754);
  }
  
  public final void d(b paramb)
  {
    AppMethodBeat.i(1752);
    this.smh += 1;
    ab.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUICreate %d", new Object[] { Integer.valueOf(this.smh) });
    this.thM = paramb;
    this.tjp = g.aef(paramb.cJf().xUt);
    AppMethodBeat.o(1752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m
 * JD-Core Version:    0.7.0.1
 */