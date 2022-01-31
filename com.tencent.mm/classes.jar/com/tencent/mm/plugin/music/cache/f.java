package com.tencent.mm.plugin.music.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  implements b
{
  private static long cfo = 0L;
  private List<String> cfn;
  
  public f(List<String> paramList)
  {
    AppMethodBeat.i(137422);
    this.cfn = new ArrayList(10);
    if (!paramList.isEmpty()) {
      this.cfn.addAll(paramList);
    }
    AppMethodBeat.o(137422);
  }
  
  private boolean dW(String paramString)
  {
    AppMethodBeat.i(137424);
    Iterator localIterator = this.cfn.iterator();
    while (localIterator.hasNext()) {
      if (paramString.contains((String)localIterator.next()))
      {
        AppMethodBeat.o(137424);
        return true;
      }
    }
    AppMethodBeat.o(137424);
    return false;
  }
  
  public final void bVa()
  {
    long l = 0L;
    AppMethodBeat.i(137423);
    if (cfo == 0L)
    {
      if (!e.bVi()) {
        break label71;
      }
      l = ((c)com.tencent.mm.plugin.music.f.c.b.am(c.class)).bVd();
    }
    for (;;)
    {
      cfo = l;
      l = System.currentTimeMillis();
      if (l - cfo > oYi.longValue()) {
        break;
      }
      ab.e("MicroMsg.Music.PieceCacheCleanController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
      AppMethodBeat.o(137423);
      return;
      label71:
      ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
    cfo = l;
    ab.i("MicroMsg.Music.PieceCacheCleanController", "start clean music file");
    d.post(new f.1(this, l), "PieceCacheCleanController");
    AppMethodBeat.o(137423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.f
 * JD-Core Version:    0.7.0.1
 */