package com.tencent.mm.plugin.vlog.decoder;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mediaplus.AudioSoftDecoderJni;
import com.tencent.mm.mediaplus.AudioSoftDecoderJni.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.codec.IMediaCodec;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/decoder/AudioSoftDecoder;", "Lcom/tencent/tav/codec/IMediaCodec;", "()V", "TAG", "", "decodePts", "", "inputBuffer", "Ljava/nio/ByteBuffer;", "outputBuffer", "ptr", "bindSurfaceTexture", "", "p0", "Landroid/graphics/SurfaceTexture;", "configure", "format", "Landroid/media/MediaFormat;", "surface", "Landroid/view/Surface;", "crypto", "Landroid/media/MediaCrypto;", "flags", "", "createInputSurface", "dequeueInputBuffer", "timeoutUs", "dequeueOutputBuffer", "info", "Landroid/media/MediaCodec$BufferInfo;", "flush", "getInputBuffer", "index", "getOutputBuffer", "getOutputFormat", "queueInputBuffer", "offset", "size", "presentationTimeUs", "release", "releaseOutputBuffer", "render", "", "reset", "setDataSource", "path", "signalEndOfInputStream", "start", "stop", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements IMediaCodec
{
  private final String TAG = "AudioSoftDecoder";
  private ByteBuffer cJn;
  private long nyU;
  private ByteBuffer outputBuffer;
  private long ptr;
  
  public final void bindSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(281360);
    s.u(paramSurfaceTexture, "p0");
    AppMethodBeat.o(281360);
  }
  
  public final void configure(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, int paramInt) {}
  
  public final Surface createInputSurface()
  {
    return null;
  }
  
  public final int dequeueInputBuffer(long paramLong)
  {
    return 0;
  }
  
  public final int dequeueOutputBuffer(MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    AppMethodBeat.i(281375);
    s.u(paramBufferInfo, "info");
    Object localObject = AudioSoftDecoderJni.nNf;
    localObject = AudioSoftDecoderJni.nGetOutputBuffer(this.ptr);
    if (localObject != null) {
      if (localObject.length != 0) {
        break label51;
      }
    }
    label51:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(281375);
      return -1;
    }
    int j = localObject.length;
    ByteBuffer localByteBuffer = this.outputBuffer;
    if (localByteBuffer == null) {}
    for (i = 0;; i = localByteBuffer.capacity())
    {
      i = Math.min(j, i);
      if (i < localObject.length) {
        Log.w(this.TAG, "output size not enough " + i + ", " + localObject.length);
      }
      paramBufferInfo.presentationTimeUs = this.nyU;
      paramBufferInfo.size = i;
      paramBufferInfo = this.outputBuffer;
      if (paramBufferInfo != null)
      {
        paramBufferInfo.position(0);
        if (paramBufferInfo.limit() != i) {
          Log.i(this.TAG, "output buffer size changed " + paramBufferInfo.limit() + " -> " + i);
        }
        paramBufferInfo.limit(i);
        paramBufferInfo.put((byte[])localObject, 0, i);
      }
      AppMethodBeat.o(281375);
      return 0;
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(281384);
    AudioSoftDecoderJni.a locala = AudioSoftDecoderJni.nNf;
    AudioSoftDecoderJni.nFlush(this.ptr);
    AppMethodBeat.o(281384);
  }
  
  public final ByteBuffer getInputBuffer(int paramInt)
  {
    AppMethodBeat.i(281368);
    ByteBuffer localByteBuffer = this.cJn;
    if (localByteBuffer != null) {
      localByteBuffer.position(0);
    }
    localByteBuffer = this.cJn;
    AppMethodBeat.o(281368);
    return localByteBuffer;
  }
  
  public final ByteBuffer getOutputBuffer(int paramInt)
  {
    return this.outputBuffer;
  }
  
  public final MediaFormat getOutputFormat()
  {
    return null;
  }
  
  public final void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(281371);
    this.nyU = paramLong;
    ByteBuffer localByteBuffer = this.cJn;
    if (localByteBuffer != null)
    {
      AudioSoftDecoderJni.a locala = AudioSoftDecoderJni.nNf;
      AudioSoftDecoderJni.nDecodeSample(this.ptr, localByteBuffer, paramInt3);
    }
    AppMethodBeat.o(281371);
  }
  
  public final void release()
  {
    AppMethodBeat.i(281399);
    AudioSoftDecoderJni.a locala = AudioSoftDecoderJni.nNf;
    AudioSoftDecoderJni.nDestroy(this.ptr);
    this.ptr = 0L;
    AppMethodBeat.o(281399);
  }
  
  public final void releaseOutputBuffer(int paramInt, boolean paramBoolean) {}
  
  public final void reset() {}
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(281354);
    s.u(paramString, "path");
    AudioSoftDecoderJni.a locala = AudioSoftDecoderJni.nNf;
    this.ptr = AudioSoftDecoderJni.nInit(paramString);
    paramString = AudioSoftDecoderJni.nNf;
    int i = AudioSoftDecoderJni.nGetOutputBufferSize(this.ptr);
    paramString = AudioSoftDecoderJni.nNf;
    int j = AudioSoftDecoderJni.nGetErrCode(this.ptr);
    Log.i(this.TAG, "configure " + this.ptr + ' ' + i + ' ' + j);
    paramString = AudioSoftDecoderJni.nNf;
    if (j != AudioSoftDecoderJni.bvC())
    {
      paramString = new ExportRuntimeException(new ExportErrorStatus(-202, null, ""));
      AppMethodBeat.o(281354);
      throw paramString;
    }
    this.cJn = ByteBuffer.allocateDirect(8192).order(ByteOrder.nativeOrder());
    this.outputBuffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
    AppMethodBeat.o(281354);
  }
  
  public final void signalEndOfInputStream() {}
  
  public final void start() {}
  
  public final void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.decoder.a
 * JD-Core Version:    0.7.0.1
 */