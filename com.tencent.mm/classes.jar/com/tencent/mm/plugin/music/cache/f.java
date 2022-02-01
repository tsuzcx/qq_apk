package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  implements b
{
  private static long hrP = 0L;
  private List<String> hrO;
  
  public f(List<String> paramList)
  {
    AppMethodBeat.i(137172);
    this.hrO = new ArrayList(10);
    if (!paramList.isEmpty()) {
      this.hrO.addAll(paramList);
    }
    AppMethodBeat.o(137172);
  }
  
  private boolean iW(String paramString)
  {
    AppMethodBeat.i(137174);
    Iterator localIterator = this.hrO.iterator();
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
  
  public final void gmQ()
  {
    final long l = 0L;
    AppMethodBeat.i(137173);
    if (hrP == 0L)
    {
      if (!e.gmX()) {
        break label71;
      }
      l = ((c)com.tencent.mm.plugin.music.e.c.b.bU(c.class)).gmT();
    }
    for (;;)
    {
      hrP = l;
      l = System.currentTimeMillis();
      if (l - hrP > LKz.longValue()) {
        break;
      }
      Log.e("MicroMsg.Music.PieceCacheCleanController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
      AppMethodBeat.o(137173);
      return;
      label71:
      Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
    hrP = l;
    Log.i("MicroMsg.Music.PieceCacheCleanController", "start clean music file");
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137171);
        long l = l;
        if (e.gmX()) {
          ((c)com.tencent.mm.plugin.music.e.c.b.bU(c.class)).sA(l);
        }
        f.a(f.this);
        AppMethodBeat.o(137171);
      }
    }, "PieceCacheCleanController");
    AppMethodBeat.o(137173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.f
 * JD-Core Version:    0.7.0.1
 */