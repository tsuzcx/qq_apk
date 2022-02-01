package io.clipworks.androidplus.media;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import com.facebook.jni.HybridData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NativeMediaCodecCallback
  extends MediaCodec.Callback
{
  private final HybridData mHybridData;
  
  private NativeMediaCodecCallback(HybridData paramHybridData)
  {
    this.mHybridData = paramHybridData;
  }
  
  private native void nativeOnError(MediaCodec.CodecException paramCodecException);
  
  private native void nativeOnInputBufferAvailable(int paramInt);
  
  private native void nativeOnOutputBufferAvailable(int paramInt, MediaCodec.BufferInfo paramBufferInfo);
  
  private native void nativeOnOutputFormatChanged(MediaFormat paramMediaFormat);
  
  public void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
  {
    AppMethodBeat.i(189539);
    nativeOnError(paramCodecException);
    AppMethodBeat.o(189539);
  }
  
  public void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(189518);
    nativeOnInputBufferAvailable(paramInt);
    AppMethodBeat.o(189518);
  }
  
  public void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(189528);
    nativeOnOutputBufferAvailable(paramInt, paramBufferInfo);
    AppMethodBeat.o(189528);
  }
  
  public void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(189546);
    nativeOnOutputFormatChanged(paramMediaFormat);
    AppMethodBeat.o(189546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     io.clipworks.androidplus.media.NativeMediaCodecCallback
 * JD-Core Version:    0.7.0.1
 */