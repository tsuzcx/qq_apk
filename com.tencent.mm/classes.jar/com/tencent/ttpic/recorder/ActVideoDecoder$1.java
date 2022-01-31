package com.tencent.ttpic.recorder;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ActVideoDecoder$1
  implements Runnable
{
  ActVideoDecoder$1(ActVideoDecoder paramActVideoDecoder) {}
  
  public void run()
  {
    AppMethodBeat.i(83677);
    ActVideoDecoder.access$002(this.this$0, new SurfaceTexture(ActVideoDecoder.access$100(this.this$0)));
    ActVideoDecoder.access$000(this.this$0).setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener()
    {
      public void onFrameAvailable(SurfaceTexture arg1)
      {
        AppMethodBeat.i(83676);
        synchronized (ActVideoDecoder.access$200(ActVideoDecoder.1.this.this$0))
        {
          if (ActVideoDecoder.access$300(ActVideoDecoder.1.this.this$0))
          {
            RuntimeException localRuntimeException = new RuntimeException("mFrameAvailable already set, frame could be dropped");
            AppMethodBeat.o(83676);
            throw localRuntimeException;
          }
        }
        ActVideoDecoder.access$302(ActVideoDecoder.1.this.this$0, true);
        ActVideoDecoder.access$200(ActVideoDecoder.1.this.this$0).notifyAll();
        AppMethodBeat.o(83676);
      }
    });
    synchronized (ActVideoDecoder.access$400(this.this$0))
    {
      ActVideoDecoder.access$400(this.this$0).notifyAll();
      ActVideoDecoder.access$502(this.this$0, true);
      AppMethodBeat.o(83677);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.recorder.ActVideoDecoder.1
 * JD-Core Version:    0.7.0.1
 */