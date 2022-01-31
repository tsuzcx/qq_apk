package com.tencent.mm.plugin.music.b;

import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

final class e$2
  implements Runnable
{
  e$2(e parame) {}
  
  public final void run()
  {
    y.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayRunnable, run");
    Iterator localIterator = this.mxk.mwS.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (this.mxk.IU(str) == 0) {
        this.mxk.IW(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.e.2
 * JD-Core Version:    0.7.0.1
 */