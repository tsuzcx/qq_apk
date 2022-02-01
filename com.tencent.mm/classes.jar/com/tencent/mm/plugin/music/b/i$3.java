package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

final class i$3
  implements Runnable
{
  i$3(i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(137022);
    Log.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayRunnable, run");
    Iterator localIterator = this.LJu.LIM.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.LJu.aOg(str) == 0) {
        this.LJu.aOi(str);
      }
    }
    AppMethodBeat.o(137022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.i.3
 * JD-Core Version:    0.7.0.1
 */