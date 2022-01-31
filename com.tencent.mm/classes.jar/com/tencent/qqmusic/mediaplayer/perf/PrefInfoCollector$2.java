package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.util.Logger;

class PrefInfoCollector$2
  implements Runnable
{
  PrefInfoCollector$2(PrefInfoCollector paramPrefInfoCollector, AudioInformation paramAudioInformation) {}
  
  public void run()
  {
    AppMethodBeat.i(128431);
    try
    {
      PrefInfoCollector.access$000(this.this$0);
      PrefInfoCollector.access$100(this.this$0, this.val$audioInformation);
      PrefInfoCollector.access$200(this.this$0);
      AppMethodBeat.o(128431);
      return;
    }
    catch (Exception localException)
    {
      Logger.e(PrefInfoCollector.access$300(), localException);
      AppMethodBeat.o(128431);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.PrefInfoCollector.2
 * JD-Core Version:    0.7.0.1
 */