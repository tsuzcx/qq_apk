package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

final class f$2
  implements Runnable
{
  f$2(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(137021);
    ac.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayRunnable, run");
    Iterator localIterator = this.vcU.vcx.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.vcU.amS(str) == 0) {
        this.vcU.amU(str);
      }
    }
    AppMethodBeat.o(137021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.f.2
 * JD-Core Version:    0.7.0.1
 */