package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.f;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class m
{
  private int LrP;
  b MYE;
  String Nam;
  Map<String, esz> Nan;
  Set<String> Nao;
  
  public m()
  {
    AppMethodBeat.i(126116);
    this.LrP = 0;
    this.Nan = Collections.synchronizedMap(new HashMap());
    this.Nao = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(126116);
  }
  
  static long aJ(long paramLong1, long paramLong2)
  {
    long l = 0L;
    if (paramLong2 != 0L) {
      l = 100L * paramLong1 / paramLong2;
    }
    return l;
  }
  
  public final void d(b paramb)
  {
    AppMethodBeat.i(126117);
    this.LrP += 1;
    Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUICreate %d", new Object[] { Integer.valueOf(this.LrP) });
    this.MYE = paramb;
    this.Nam = h.beT(paramb.gqA().wmL);
    AppMethodBeat.o(126117);
  }
  
  public final void gry()
  {
    AppMethodBeat.i(126119);
    Iterator localIterator = this.Nao.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      f.bkg().Vz(str);
    }
    AppMethodBeat.o(126119);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(126118);
    this.LrP -= 1;
    Log.i("MicroMsg.TopStory.TopStoryPreloadMgr", "onUIDestroy %d", new Object[] { Integer.valueOf(this.LrP) });
    if (this.LrP <= 0)
    {
      gry();
      this.Nao.clear();
      ThreadPool.post(new m.b(this, this.Nam), "TopStory.DeleteVideoFolderTask");
      this.MYE = null;
    }
    AppMethodBeat.o(126118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.m
 * JD-Core Version:    0.7.0.1
 */