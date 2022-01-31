package com.tencent.ttpic.recorder;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

class ActVideoDecoder$1
  implements Runnable
{
  ActVideoDecoder$1(ActVideoDecoder paramActVideoDecoder) {}
  
  public void run()
  {
    ActVideoDecoder.access$002(this.this$0, new SurfaceTexture(ActVideoDecoder.access$100(this.this$0)));
    ActVideoDecoder.access$000(this.this$0).setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener()
    {
      public void onFrameAvailable(SurfaceTexture arg1)
      {
        synchronized (ActVideoDecoder.access$200(ActVideoDecoder.1.this.this$0))
        {
          if (ActVideoDecoder.access$300(ActVideoDecoder.1.this.this$0)) {
            throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
          }
        }
        ActVideoDecoder.access$302(ActVideoDecoder.1.this.this$0, true);
        ActVideoDecoder.access$200(ActVideoDecoder.1.this.this$0).notifyAll();
      }
    });
    synchronized (ActVideoDecoder.access$400(this.this$0))
    {
      ActVideoDecoder.access$400(this.this$0).notifyAll();
      ActVideoDecoder.access$502(this.this$0, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.recorder.ActVideoDecoder.1
 * JD-Core Version:    0.7.0.1
 */