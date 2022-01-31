package com.tencent.mm.plugin.music.b;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

final class e$3
  implements Runnable
{
  e$3(e parame) {}
  
  public final void run()
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayRunnable, run");
    Iterator localIterator = this.mxk.mwS.iterator();
    int i = 0;
    e locale;
    Object localObject5;
    if (localIterator.hasNext())
    {
      ??? = (String)localIterator.next();
      if (this.mxk.IU((String)???) != 0) {
        break label388;
      }
      locale = this.mxk;
      y.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersAndSaveState, appId:%s", new Object[] { ??? });
      localObject5 = (LinkedList)locale.mwU.get(???);
      if ((localObject5 == null) || (((LinkedList)localObject5).size() == 0))
      {
        y.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
        label107:
        i = 1;
      }
    }
    label388:
    for (;;)
    {
      break;
      Object localObject6;
      Object localObject7;
      for (;;)
      {
        g localg;
        synchronized (locale.jtD)
        {
          localObject6 = ((LinkedList)localObject5).iterator();
          if (!((Iterator)localObject6).hasNext()) {
            break;
          }
          localObject7 = (String)((Iterator)localObject6).next();
          localg = (g)locale.mwO.remove(localObject7);
          locale.mwP.remove(localObject7);
          if (localg == null) {
            continue;
          }
          locale.b((String)localObject7, localg);
          y.i("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
          if (localg.eaW) {
            e.d((String)localObject7, localg);
          }
        }
        e.c((String)localObject7, localg);
      }
      localObject5 = ((LinkedList)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (String)((Iterator)localObject5).next();
        localObject7 = (g)locale.mwQ.remove(localObject6);
        locale.mwR.remove(localObject6);
        if (localObject7 != null)
        {
          locale.b((String)localObject6, (g)localObject7);
          y.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
          if (((g)localObject7).eaW) {
            e.d((String)localObject6, (g)localObject7);
          } else {
            e.c((String)localObject6, (g)localObject7);
          }
        }
      }
      break label107;
      if (i == 0) {}
      synchronized (this.mxk.jtD)
      {
        this.mxk.mxa = true;
        this.mxk.mxc = System.currentTimeMillis();
        ai.l(this.mxk.mxj, 1800000L);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.e.3
 * JD-Core Version:    0.7.0.1
 */