package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

final class f$2
  implements Runnable
{
  f$2(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(137271);
    ab.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayRunnable, run");
    Iterator localIterator = this.oXg.oWJ.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.oXg.UN(str) == 0) {
        this.oXg.UP(str);
      }
    }
    AppMethodBeat.o(137271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.f.2
 * JD-Core Version:    0.7.0.1
 */