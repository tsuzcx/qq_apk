package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  implements b
{
  private static long dcY = 0L;
  private List<String> dcX;
  
  public f(List<String> paramList)
  {
    AppMethodBeat.i(137172);
    this.dcX = new ArrayList(10);
    if (!paramList.isEmpty()) {
      this.dcX.addAll(paramList);
    }
    AppMethodBeat.o(137172);
  }
  
  private boolean asm(String paramString)
  {
    AppMethodBeat.i(137174);
    Iterator localIterator = this.dcX.iterator();
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
  
  public final void dst()
  {
    final long l = 0L;
    AppMethodBeat.i(137173);
    if (dcY == 0L)
    {
      if (!e.dsB()) {
        break label71;
      }
      l = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).dsw();
    }
    for (;;)
    {
      dcY = l;
      l = System.currentTimeMillis();
      if (l - dcY > wjt.longValue()) {
        break;
      }
      ad.e("MicroMsg.Music.PieceCacheCleanController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
      AppMethodBeat.o(137173);
      return;
      label71:
      ad.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
    dcY = l;
    ad.i("MicroMsg.Music.PieceCacheCleanController", "start clean music file");
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137171);
        long l = l;
        if (e.dsB()) {
          ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).yj(l);
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