package com.tencent.ttpic.recorder;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ActVideoDecoder$3
  implements Runnable
{
  ActVideoDecoder$3(ActVideoDecoder paramActVideoDecoder) {}
  
  public void run()
  {
    AppMethodBeat.i(83679);
    if (ActVideoDecoder.access$900(this.this$0) != null) {
      ActVideoDecoder.access$900(this.this$0).seekTo(0L, 0);
    }
    if (ActVideoDecoder.access$1000(this.this$0) != null) {
      ActVideoDecoder.access$1000(this.this$0).flush();
    }
    ActVideoDecoder.access$1102(this.this$0, false);
    ActVideoDecoder.access$1202(this.this$0, -1L);
    ActVideoDecoder.access$1302(this.this$0, -1L);
    AppMethodBeat.o(83679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.recorder.ActVideoDecoder.3
 * JD-Core Version:    0.7.0.1
 */