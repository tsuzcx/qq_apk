package io.clipworks.androidplus.media;

import android.media.AudioPresentation;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PersistableBundle;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public class WrappedMediaCodec
{
  private static final String TAG = "WrappedMediaCodec";
  private static final AtomicInteger kHandlerThreadIndexCounter;
  private final MediaCodec _backingMediaCodec;
  private HandlerThread _handlerThread;
  
  static
  {
    AppMethodBeat.i(189515);
    kHandlerThreadIndexCounter = new AtomicInteger();
    AppMethodBeat.o(189515);
  }
  
  private WrappedMediaCodec(MediaCodec paramMediaCodec)
  {
    this._backingMediaCodec = paramMediaCodec;
  }
  
  public static WrappedMediaCodec createByCodecName(String paramString)
  {
    AppMethodBeat.i(189475);
    if (paramString == null)
    {
      AppMethodBeat.o(189475);
      return null;
    }
    try
    {
      paramString = new WrappedMediaCodec(MediaCodec.createByCodecName(paramString));
      AppMethodBeat.o(189475);
      return paramString;
    }
    catch (IllegalStateException paramString)
    {
      AppMethodBeat.o(189475);
      return null;
    }
    catch (IOException paramString)
    {
      label36:
      break label36;
    }
  }
  
  public static WrappedMediaCodec createDecoderByType(String paramString)
  {
    AppMethodBeat.i(189481);
    if (paramString == null)
    {
      AppMethodBeat.o(189481);
      return null;
    }
    try
    {
      paramString = new WrappedMediaCodec(MediaCodec.createDecoderByType(paramString));
      AppMethodBeat.o(189481);
      return paramString;
    }
    catch (IllegalStateException paramString)
    {
      AppMethodBeat.o(189481);
      return null;
    }
    catch (IOException paramString)
    {
      label36:
      break label36;
    }
  }
  
  public static WrappedMediaCodec createEncoderByType(String paramString)
  {
    AppMethodBeat.i(189490);
    if (paramString == null)
    {
      AppMethodBeat.o(189490);
      return null;
    }
    try
    {
      paramString = new WrappedMediaCodec(MediaCodec.createEncoderByType(paramString));
      AppMethodBeat.o(189490);
      return paramString;
    }
    catch (IllegalStateException paramString)
    {
      AppMethodBeat.o(189490);
      return null;
    }
    catch (IOException paramString)
    {
      label36:
      break label36;
    }
  }
  
  public static Surface createPersistentInputSurface()
  {
    AppMethodBeat.i(189509);
    Surface localSurface = MediaCodec.createPersistentInputSurface();
    AppMethodBeat.o(189509);
    return localSurface;
  }
  
  public void configure(MediaFormat paramMediaFormat, Surface paramSurface, int paramInt, MediaDescrambler paramMediaDescrambler)
  {
    AppMethodBeat.i(189553);
    this._backingMediaCodec.configure(paramMediaFormat, paramSurface, paramInt, paramMediaDescrambler);
    AppMethodBeat.o(189553);
  }
  
  public void configure(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, int paramInt)
  {
    AppMethodBeat.i(189544);
    this._backingMediaCodec.configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
    AppMethodBeat.o(189544);
  }
  
  public Surface createInputSurface()
  {
    AppMethodBeat.i(189572);
    Surface localSurface = this._backingMediaCodec.createInputSurface();
    AppMethodBeat.o(189572);
    return localSurface;
  }
  
  public int dequeueInputBuffer(long paramLong)
  {
    AppMethodBeat.i(189612);
    int i = this._backingMediaCodec.dequeueInputBuffer(paramLong);
    AppMethodBeat.o(189612);
    return i;
  }
  
  public int dequeueOutputBuffer(MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    AppMethodBeat.i(189621);
    int i = this._backingMediaCodec.dequeueOutputBuffer(paramBufferInfo, paramLong);
    AppMethodBeat.o(189621);
    return i;
  }
  
  public void flush()
  {
    AppMethodBeat.i(189591);
    this._backingMediaCodec.flush();
    AppMethodBeat.o(189591);
  }
  
  public String getCanonicalName()
  {
    AppMethodBeat.i(189735);
    String str = this._backingMediaCodec.getCanonicalName();
    AppMethodBeat.o(189735);
    return str;
  }
  
  public MediaCodecInfo getCodecInfo()
  {
    AppMethodBeat.i(189794);
    MediaCodecInfo localMediaCodecInfo = this._backingMediaCodec.getCodecInfo();
    AppMethodBeat.o(189794);
    return localMediaCodecInfo;
  }
  
  public ByteBuffer getInputBuffer(int paramInt)
  {
    AppMethodBeat.i(189681);
    try
    {
      ByteBuffer localByteBuffer = this._backingMediaCodec.getInputBuffer(paramInt);
      AppMethodBeat.o(189681);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(189681);
    }
    return null;
  }
  
  public MediaFormat getInputFormat()
  {
    AppMethodBeat.i(189659);
    MediaFormat localMediaFormat = this._backingMediaCodec.getInputFormat();
    AppMethodBeat.o(189659);
    return localMediaFormat;
  }
  
  public Image getInputImage(int paramInt)
  {
    AppMethodBeat.i(189690);
    Image localImage = this._backingMediaCodec.getInputImage(paramInt);
    AppMethodBeat.o(189690);
    return localImage;
  }
  
  public PersistableBundle getMetrics()
  {
    AppMethodBeat.i(189744);
    PersistableBundle localPersistableBundle = this._backingMediaCodec.getMetrics();
    AppMethodBeat.o(189744);
    return localPersistableBundle;
  }
  
  public String getName()
  {
    AppMethodBeat.i(189725);
    String str = this._backingMediaCodec.getName();
    AppMethodBeat.o(189725);
    return str;
  }
  
  public ByteBuffer getOutputBuffer(int paramInt)
  {
    AppMethodBeat.i(189697);
    ByteBuffer localByteBuffer = this._backingMediaCodec.getOutputBuffer(paramInt);
    AppMethodBeat.o(189697);
    return localByteBuffer;
  }
  
  public MediaFormat getOutputFormat()
  {
    AppMethodBeat.i(189648);
    MediaFormat localMediaFormat = this._backingMediaCodec.getOutputFormat();
    AppMethodBeat.o(189648);
    return localMediaFormat;
  }
  
  public MediaFormat getOutputFormat(int paramInt)
  {
    AppMethodBeat.i(189668);
    MediaFormat localMediaFormat = this._backingMediaCodec.getOutputFormat(paramInt);
    AppMethodBeat.o(189668);
    return localMediaFormat;
  }
  
  public Image getOutputImage(int paramInt)
  {
    AppMethodBeat.i(189703);
    Image localImage = this._backingMediaCodec.getOutputImage(paramInt);
    AppMethodBeat.o(189703);
    return localImage;
  }
  
  public void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(189597);
    try
    {
      this._backingMediaCodec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      AppMethodBeat.o(189597);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(189597);
      throw localException;
    }
  }
  
  public void queueSecureInputBuffer(int paramInt1, int paramInt2, MediaCodec.CryptoInfo paramCryptoInfo, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(189604);
    this._backingMediaCodec.queueSecureInputBuffer(paramInt1, paramInt2, paramCryptoInfo, paramLong, paramInt3);
    AppMethodBeat.o(189604);
  }
  
  public void release()
  {
    AppMethodBeat.i(189537);
    this._handlerThread.quitSafely();
    this._handlerThread = null;
    this._backingMediaCodec.release();
    AppMethodBeat.o(189537);
  }
  
  public void releaseOutputBuffer(int paramInt, long paramLong)
  {
    AppMethodBeat.i(189631);
    this._backingMediaCodec.releaseOutputBuffer(paramInt, paramLong);
    AppMethodBeat.o(189631);
  }
  
  public void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(189624);
    this._backingMediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
    AppMethodBeat.o(189624);
  }
  
  public void reset()
  {
    AppMethodBeat.i(189526);
    this._backingMediaCodec.reset();
    AppMethodBeat.o(189526);
  }
  
  public void setAudioPresentation(AudioPresentation paramAudioPresentation)
  {
    AppMethodBeat.i(189719);
    this._backingMediaCodec.setAudioPresentation(paramAudioPresentation);
    AppMethodBeat.o(189719);
  }
  
  public void setCallback(MediaCodec.Callback paramCallback)
  {
    AppMethodBeat.i(189770);
    try
    {
      this._backingMediaCodec.setCallback(paramCallback);
      AppMethodBeat.o(189770);
      return;
    }
    catch (Exception paramCallback)
    {
      AppMethodBeat.o(189770);
      throw paramCallback;
    }
  }
  
  public void setCallback(MediaCodec.Callback paramCallback, Handler paramHandler)
  {
    AppMethodBeat.i(189760);
    this._backingMediaCodec.setCallback(paramCallback, paramHandler);
    AppMethodBeat.o(189760);
  }
  
  public void setCallbackOnHandlerThread(MediaCodec.Callback paramCallback)
  {
    AppMethodBeat.i(189781);
    if (this._handlerThread == null)
    {
      this._handlerThread = new HandlerThread("AMC_HTCB_".concat(String.valueOf(kHandlerThreadIndexCounter.getAndAdd(1))));
      this._handlerThread.start();
    }
    Handler localHandler = new Handler(this._handlerThread.getLooper());
    this._backingMediaCodec.setCallback(paramCallback, localHandler);
    AppMethodBeat.o(189781);
  }
  
  public void setInputSurface(Surface paramSurface)
  {
    AppMethodBeat.i(189566);
    this._backingMediaCodec.setInputSurface(paramSurface);
    AppMethodBeat.o(189566);
  }
  
  public void setOnFrameRenderedListener(MediaCodec.OnFrameRenderedListener paramOnFrameRenderedListener, Handler paramHandler)
  {
    AppMethodBeat.i(189788);
    this._backingMediaCodec.setOnFrameRenderedListener(paramOnFrameRenderedListener, paramHandler);
    AppMethodBeat.o(189788);
  }
  
  public void setOutputSurface(Surface paramSurface)
  {
    AppMethodBeat.i(189560);
    this._backingMediaCodec.setOutputSurface(paramSurface);
    AppMethodBeat.o(189560);
  }
  
  public void setParameters(Bundle paramBundle)
  {
    AppMethodBeat.i(189753);
    this._backingMediaCodec.setParameters(paramBundle);
    AppMethodBeat.o(189753);
  }
  
  public void setVideoScalingMode(int paramInt)
  {
    AppMethodBeat.i(189710);
    this._backingMediaCodec.setVideoScalingMode(paramInt);
    AppMethodBeat.o(189710);
  }
  
  public void signalEndOfInputStream()
  {
    AppMethodBeat.i(189640);
    this._backingMediaCodec.signalEndOfInputStream();
    AppMethodBeat.o(189640);
  }
  
  public void start()
  {
    AppMethodBeat.i(189576);
    try
    {
      this._backingMediaCodec.start();
      AppMethodBeat.o(189576);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(189576);
      throw localException;
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(189583);
    this._backingMediaCodec.stop();
    AppMethodBeat.o(189583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     io.clipworks.androidplus.media.WrappedMediaCodec
 * JD-Core Version:    0.7.0.1
 */