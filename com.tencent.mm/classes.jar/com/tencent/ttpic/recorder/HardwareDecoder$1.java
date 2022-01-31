package com.tencent.ttpic.recorder;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.filter.o;

class HardwareDecoder$1
  implements SurfaceTexture.OnFrameAvailableListener
{
  HardwareDecoder$1(HardwareDecoder paramHardwareDecoder) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    HardwareDecoder.access$002(this.this$0, true);
    HardwareDecoder.access$100(this.this$0).updateTexImage();
    HardwareDecoder.access$100(this.this$0).getTransformMatrix(HardwareDecoder.access$200(this.this$0));
    HardwareDecoder.access$300(this.this$0).nativeUpdateMatrix(HardwareDecoder.access$200(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.recorder.HardwareDecoder.1
 * JD-Core Version:    0.7.0.1
 */