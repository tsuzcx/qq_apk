package io.clipworks.androidplus.graphics;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.facebook.jni.HybridData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NativeOnFrameAvailableListener
  implements SurfaceTexture.OnFrameAvailableListener
{
  private final HybridData mHybridData;
  
  private NativeOnFrameAvailableListener(HybridData paramHybridData)
  {
    this.mHybridData = paramHybridData;
  }
  
  public native void nativeOnFrameAvailable();
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(189494);
    nativeOnFrameAvailable();
    AppMethodBeat.o(189494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.clipworks.androidplus.graphics.NativeOnFrameAvailableListener
 * JD-Core Version:    0.7.0.1
 */