package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  implements b
{
  private static long cRI = 0L;
  private List<String> cRH;
  
  public f(List<String> paramList)
  {
    AppMethodBeat.i(137172);
    this.cRH = new ArrayList(10);
    if (!paramList.isEmpty()) {
      this.cRH.addAll(paramList);
    }
    AppMethodBeat.o(137172);
  }
  
  private boolean ann(String paramString)
  {
    AppMethodBeat.i(137174);
    Iterator localIterator = this.cRH.iterator();
    while (localIterator.hasNext()) {
      if (paramString.contains((String)localIterator.next()))
      {
        AppMethodBeat.o(137174);
        return true;
      }
    }
    AppMethodBeat.o(137174);
    return false;
  }
  
  public final void dih()
  {
    final long l = 0L;
    AppMethodBeat.i(137173);
    if (cRI == 0L)
    {
      if (!e.dip()) {
        break label71;
      }
      l = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).dik();
    }
    for (;;)
    {
      cRI = l;
      l = System.currentTimeMillis();
      if (l - cRI > vdX.longValue()) {
        break;
      }
      ac.e("MicroMsg.Music.PieceCacheCleanController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
      AppMethodBeat.o(137173);
      return;
      label71:
      ac.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
    cRI = l;
    ac.i("MicroMsg.Music.PieceCacheCleanController", "start clean music file");
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137171);
        long l = l;
        if (e.dip()) {
          ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).wa(l);
        }
        f.a(f.this);
        AppMethodBeat.o(137171);
      }
    }, "PieceCacheCleanController");
    AppMethodBeat.o(137173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.f
 * JD-Core Version:    0.7.0.1
 */