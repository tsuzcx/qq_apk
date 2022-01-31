package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;

class StaticDecodeDataComponent$1
  implements Runnable
{
  StaticDecodeDataComponent$1(StaticDecodeDataComponent paramStaticDecodeDataComponent) {}
  
  public void run()
  {
    AppMethodBeat.i(104687);
    if (this.this$0.getPlayerState() == 8)
    {
      Logger.w("StaticDecodeDataComponent", "[run] state changed to END during postRunnable!");
      AppMethodBeat.o(104687);
      return;
    }
    this.this$0.mCallback.playerPrepared(this.this$0.mCorePlayer);
    AppMethodBeat.o(104687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent.1
 * JD-Core Version:    0.7.0.1
 */