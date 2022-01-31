package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;

class StreamDecodeDataComponent$2
  implements Runnable
{
  StreamDecodeDataComponent$2(StreamDecodeDataComponent paramStreamDecodeDataComponent) {}
  
  public void run()
  {
    AppMethodBeat.i(104688);
    this.this$0.mCallback.playerPaused(this.this$0.mCorePlayer);
    AppMethodBeat.o(104688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.StreamDecodeDataComponent.2
 * JD-Core Version:    0.7.0.1
 */