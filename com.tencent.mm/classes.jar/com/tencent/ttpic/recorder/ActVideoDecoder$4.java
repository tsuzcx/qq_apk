package com.tencent.ttpic.recorder;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ActVideoDecoder$4
  implements Runnable
{
  ActVideoDecoder$4(ActVideoDecoder paramActVideoDecoder) {}
  
  public void run()
  {
    AppMethodBeat.i(83680);
    if (ActVideoDecoder.access$000(this.this$0) != null) {
      ActVideoDecoder.access$000(this.this$0).release();
    }
    ActVideoDecoder.access$1400(this.this$0).getLooper().quit();
    ActVideoDecoder.access$1402(this.this$0, null);
    AppMethodBeat.o(83680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.recorder.ActVideoDecoder.4
 * JD-Core Version:    0.7.0.1
 */