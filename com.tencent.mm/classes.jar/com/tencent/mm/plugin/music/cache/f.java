package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  implements b
{
  private static long dea = 0L;
  private List<String> ddZ;
  
  public f(List<String> paramList)
  {
    AppMethodBeat.i(137172);
    this.ddZ = new ArrayList(10);
    if (!paramList.isEmpty()) {
      this.ddZ.addAll(paramList);
    }
    AppMethodBeat.o(137172);
  }
  
  private boolean atA(String paramString)
  {
    AppMethodBeat.i(137174);
    Iterator localIterator = this.ddZ.iterator();
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
  
  public final void dvI()
  {
    final long l = 0L;
    AppMethodBeat.i(137173);
    if (dea == 0L)
    {
      if (!e.dvQ()) {
        break label71;
      }
      l = ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).dvL();
    }
    for (;;)
    {
      dea = l;
      l = System.currentTimeMillis();
      if (l - dea > wyY.longValue()) {
        break;
      }
      ae.e("MicroMsg.Music.PieceCacheCleanController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
      AppMethodBeat.o(137173);
      return;
      label71:
      ae.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
    dea = l;
    ae.i("MicroMsg.Music.PieceCacheCleanController", "start clean music file");
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137171);
        long l = l;
        if (e.dvQ()) {
          ((c)com.tencent.mm.plugin.music.f.c.b.aQ(c.class)).yD(l);
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