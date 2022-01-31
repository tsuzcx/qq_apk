package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.f.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

final class f$3
  implements Runnable
{
  f$3(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(137272);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayRunnable, run");
    Iterator localIterator = this.oXg.oWJ.iterator();
    int i = 0;
    f localf;
    Object localObject5;
    if (localIterator.hasNext())
    {
      ??? = (String)localIterator.next();
      if (this.oXg.UN((String)???) != 0) {
        break label450;
      }
      localf = this.oXg;
      ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersAndSaveState, appId:%s", new Object[] { ??? });
      localObject5 = (LinkedList)localf.oWL.get(???);
      if ((localObject5 == null) || (((LinkedList)localObject5).size() == 0))
      {
        ab.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
        label112:
        i = 1;
      }
    }
    label450:
    for (;;)
    {
      break;
      Object localObject6;
      Object localObject7;
      for (;;)
      {
        h localh;
        synchronized (localf.lDc)
        {
          localObject6 = ((LinkedList)localObject5).iterator();
          if (!((Iterator)localObject6).hasNext()) {
            break;
          }
          localObject7 = (String)((Iterator)localObject6).next();
          if (localf.oWZ.en((String)localObject7)) {
            localf.oWZ.er((String)localObject7);
          }
          localh = (h)localf.oWF.remove(localObject7);
          localf.oWG.remove(localObject7);
          if (localh == null) {
            continue;
          }
          localf.b((String)localObject7, localh);
          ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
          if (localh.frl) {
            f.d((String)localObject7, localh);
          }
        }
        f.c((String)localObject7, localh);
      }
      localObject5 = ((LinkedList)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (String)((Iterator)localObject5).next();
        if (localf.oWZ.en((String)localObject6)) {
          localf.oWZ.er((String)localObject6);
        }
        localObject7 = (h)localf.oWH.remove(localObject6);
        localf.oWI.remove(localObject6);
        if (localObject7 != null)
        {
          localf.b((String)localObject6, (h)localObject7);
          ab.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
          if (((h)localObject7).frl) {
            f.d((String)localObject6, (h)localObject7);
          } else {
            f.c((String)localObject6, (h)localObject7);
          }
        }
      }
      break label112;
      if (i == 0) {}
      synchronized (this.oXg.lDc)
      {
        this.oXg.oWR = true;
        this.oXg.oWT = System.currentTimeMillis();
        al.p(this.oXg.oXd, 1800000L);
        AppMethodBeat.o(137272);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.f.3
 * JD-Core Version:    0.7.0.1
 */