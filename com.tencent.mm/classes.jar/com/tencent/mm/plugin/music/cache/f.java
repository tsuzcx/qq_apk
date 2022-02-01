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
  private static long fnE = 0L;
  private List<String> fnD;
  
  public f(List<String> paramList)
  {
    AppMethodBeat.i(137172);
    this.fnD = new ArrayList(10);
    if (!paramList.isEmpty()) {
      this.fnD.addAll(paramList);
    }
    AppMethodBeat.o(137172);
  }
  
  private boolean hv(String paramString)
  {
    AppMethodBeat.i(137174);
    Iterator localIterator = this.fnD.iterator();
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
  
  public final void fdP()
  {
    final long l = 0L;
    AppMethodBeat.i(137173);
    if (fnE == 0L)
    {
      if (!e.fdV()) {
        break label71;
      }
      l = ((c)com.tencent.mm.plugin.music.f.c.b.bm(c.class)).fdS();
    }
    for (;;)
    {
      fnE = l;
      l = System.currentTimeMillis();
      if (l - fnE > FPD.longValue()) {
        break;
      }
      Log.e("MicroMsg.Music.PieceCacheCleanController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
      AppMethodBeat.o(137173);
      return;
      label71:
      Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
    fnE = l;
    Log.i("MicroMsg.Music.PieceCacheCleanController", "start clean music file");
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137171);
        long l = l;
        if (e.fdV()) {
          ((c)com.tencent.mm.plugin.music.f.c.b.bm(c.class)).OD(l);
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