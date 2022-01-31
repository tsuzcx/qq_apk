package com.tencent.mm.plugin.music.cache;

import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  implements b
{
  private static long gNF = 0L;
  private List<String> gNG = new ArrayList(10);
  
  public f(List<String> paramList)
  {
    if (!paramList.isEmpty()) {
      this.gNG.addAll(paramList);
    }
  }
  
  private boolean vf(String paramString)
  {
    Iterator localIterator = this.gNG.iterator();
    while (localIterator.hasNext()) {
      if (paramString.contains((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public final void bmH()
  {
    long l = 0L;
    if (gNF == 0L)
    {
      if (!e.bmM()) {
        break label61;
      }
      l = ((c)com.tencent.mm.plugin.music.f.c.b.Q(c.class)).bmK();
    }
    for (;;)
    {
      gNF = l;
      l = System.currentTimeMillis();
      if (l - gNF > mya.longValue()) {
        break;
      }
      y.e("MicroMsg.Music.PieceCacheCleanController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
      return;
      label61:
      y.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
    }
    gNF = l;
    y.i("MicroMsg.Music.PieceCacheCleanController", "start clean music file");
    com.tencent.mm.sdk.f.e.post(new f.1(this, l), "PieceCacheCleanController");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.f
 * JD-Core Version:    0.7.0.1
 */