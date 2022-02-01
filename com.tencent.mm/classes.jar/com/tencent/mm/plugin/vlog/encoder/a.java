package com.tencent.mm.plugin.vlog.encoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.AudioSoftEncoder;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.decoder.AssetWriterAudioEncoder;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/encoder/CompositionAudioSoftEncoder;", "Lcom/tencent/tav/decoder/AssetWriterAudioEncoder;", "()V", "TAG", "", "bufferSize", "", "dataBuffer", "Ljava/nio/ByteBuffer;", "encodeOption", "Lcom/tencent/tav/core/ExportConfig;", "encodePts", "", "inputEOS", "", "mediaFormat", "Landroid/media/MediaFormat;", "muxer", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "nPtr", "endWriteAudioSample", "getEncodeFormat", "getEncodePresentationTimeUs", "isEncodeToEndOfStream", "prepare", "outputConfig", "release", "", "setMediaMuxer", "start", "stop", "writeAudioFrame", "endOfStream", "writeAudioSample", "presentationTime", "audioBuffer", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements AssetWriterAudioEncoder
{
  private final String TAG = "MicroMsg.CompositionAudioSoftEncoder";
  private int TXQ;
  private long TXR;
  private ByteBuffer TXS;
  private boolean TXT;
  private int bufferSize;
  private ExportConfig encodeOption;
  private MediaFormat mediaFormat;
  private IMediaMuxer muxer;
  
  public final boolean endWriteAudioSample()
  {
    Object localObject2 = null;
    AppMethodBeat.i(281189);
    Log.i(this.TAG, "endWriteAudioSample: ");
    ByteBuffer localByteBuffer = this.TXS;
    Object localObject1 = localByteBuffer;
    if (localByteBuffer == null)
    {
      s.bIx("dataBuffer");
      localObject1 = null;
    }
    int i = ((ByteBuffer)localObject1).position();
    int j;
    if (i > 0)
    {
      localByteBuffer = this.TXS;
      localObject1 = localByteBuffer;
      if (localByteBuffer == null)
      {
        s.bIx("dataBuffer");
        localObject1 = null;
      }
      ((ByteBuffer)localObject1).position(0);
      j = this.TXQ;
      localObject1 = this.TXS;
      if (localObject1 != null) {
        break label121;
      }
      s.bIx("dataBuffer");
      localObject1 = localObject2;
    }
    label121:
    for (;;)
    {
      AudioSoftEncoder.nWriteAudioSample(j, (ByteBuffer)localObject1, i, this.TXR);
      AudioSoftEncoder.nEndWriteAudioSample(this.TXQ);
      AppMethodBeat.o(281189);
      return true;
    }
  }
  
  public final MediaFormat getEncodeFormat()
  {
    AppMethodBeat.i(281202);
    MediaFormat localMediaFormat = this.mediaFormat;
    s.checkNotNull(localMediaFormat);
    AppMethodBeat.o(281202);
    return localMediaFormat;
  }
  
  public final long getEncodePresentationTimeUs()
  {
    return this.TXR;
  }
  
  public final boolean isEncodeToEndOfStream()
  {
    return this.TXT;
  }
  
  public final boolean prepare(ExportConfig paramExportConfig, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(281181);
    s.u(paramExportConfig, "outputConfig");
    s.u(paramMediaFormat, "mediaFormat");
    this.encodeOption = paramExportConfig;
    this.mediaFormat = paramMediaFormat;
    int i = paramExportConfig.getAudioChannelCount();
    int j = paramMediaFormat.getInteger("bitrate");
    int k = paramExportConfig.getAudioSampleRateHz();
    int m = paramMediaFormat.getInteger("aac-profile");
    this.TXQ = AudioSoftEncoder.nInit(j, k, i, m);
    i = AudioSoftEncoder.nGetErrCode(this.TXQ);
    this.bufferSize = AudioSoftEncoder.nGetBufferSize(this.TXQ);
    paramExportConfig = ByteBuffer.allocateDirect(this.bufferSize).order(ByteOrder.nativeOrder());
    s.s(paramExportConfig, "allocateDirect(bufferSiz…(ByteOrder.nativeOrder())");
    this.TXS = paramExportConfig;
    Log.i(this.TAG, "prepare: " + this.TXQ + ' ' + this.bufferSize + ", " + i);
    if (i != 0)
    {
      paramExportConfig = new ExportRuntimeException(new ExportErrorStatus(-104, null, paramMediaFormat.toString()));
      AppMethodBeat.o(281181);
      throw paramExportConfig;
    }
    AppMethodBeat.o(281181);
    return true;
  }
  
  public final void release()
  {
    AppMethodBeat.i(281209);
    Log.i(this.TAG, s.X("release: ", Integer.valueOf(this.TXQ)));
    AudioSoftEncoder.nDestroy(this.TXQ);
    this.TXQ = 0;
    AppMethodBeat.o(281209);
  }
  
  public final void setMediaMuxer(IMediaMuxer paramIMediaMuxer)
  {
    this.muxer = paramIMediaMuxer;
  }
  
  public final boolean start()
  {
    return true;
  }
  
  public final void stop() {}
  
  public final boolean writeAudioFrame(boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(281194);
    Object localObject1 = this.muxer;
    if (localObject1 == null) {}
    for (int i = -1; i == -1; i = ((IMediaMuxer)localObject1).audioTrackIndex())
    {
      AppMethodBeat.o(281194);
      return true;
    }
    Object localObject2 = AudioSoftEncoder.nGetOutputBuffer(this.TXQ);
    int j;
    if (localObject2 != null) {
      if (localObject2.length == 0)
      {
        j = 1;
        if (j != 0) {
          break label184;
        }
        j = 1;
        label72:
        if (j == 0) {
          break label189;
        }
        localObject1 = new MediaCodec.BufferInfo();
        ((MediaCodec.BufferInfo)localObject1).presentationTimeUs = this.TXR;
        ((MediaCodec.BufferInfo)localObject1).size = localObject2.length;
        ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(localObject2.length).order(ByteOrder.nativeOrder());
        localByteBuffer.put((byte[])localObject2);
        localByteBuffer.position(0);
        localObject2 = this.muxer;
        bool1 = bool2;
        if (localObject2 != null) {
          ((IMediaMuxer)localObject2).writeSampleData(i, localByteBuffer, (MediaCodec.BufferInfo)localObject1);
        }
      }
    }
    label184:
    label189:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      if (paramBoolean) {
        this.TXT = true;
      }
      AppMethodBeat.o(281194);
      return bool1;
      j = 0;
      break;
      j = 0;
      break label72;
    }
  }
  
  public final long writeAudioSample(long paramLong, ByteBuffer paramByteBuffer)
  {
    Object localObject2 = null;
    AppMethodBeat.i(281191);
    s.u(paramByteBuffer, "audioBuffer");
    int i = paramByteBuffer.position();
    int k = paramByteBuffer.limit();
    Object localObject3 = this.TXS;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("dataBuffer");
      localObject1 = null;
    }
    int j = ((ByteBuffer)localObject1).position();
    localObject3 = this.TXS;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("dataBuffer");
      localObject1 = null;
    }
    k = Math.min(((ByteBuffer)localObject1).capacity() - j, k - i);
    paramByteBuffer.limit(i + k);
    localObject3 = this.TXS;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("dataBuffer");
      localObject1 = null;
    }
    ((ByteBuffer)localObject1).put(paramByteBuffer);
    localObject3 = this.TXS;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("dataBuffer");
      localObject1 = null;
    }
    StringBuilder localStringBuilder;
    if (j + k >= ((ByteBuffer)localObject1).capacity())
    {
      localObject3 = this.TXS;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("dataBuffer");
        localObject1 = null;
      }
      ((ByteBuffer)localObject1).position(0);
      j = this.TXQ;
      localObject3 = this.TXS;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("dataBuffer");
        localObject1 = null;
      }
      AudioSoftEncoder.nWriteAudioSample(j, (ByteBuffer)localObject1, this.bufferSize, paramLong);
      this.TXR = paramLong;
      localObject3 = this.TAG;
      localStringBuilder = new StringBuilder("writeAudioSample: write size is ").append(i).append(", ");
      localObject1 = this.TXS;
      if (localObject1 != null) {
        break label429;
      }
      s.bIx("dataBuffer");
      localObject1 = localObject2;
    }
    label429:
    for (;;)
    {
      Log.i((String)localObject3, ((ByteBuffer)localObject1).position() + ", " + k + '}');
      if (k <= 0) {
        break label432;
      }
      paramByteBuffer.position(i + k);
      paramLong = k;
      paramByteBuffer = this.encodeOption;
      s.checkNotNull(paramByteBuffer);
      i = paramByteBuffer.getAudioChannelCount();
      paramByteBuffer = this.encodeOption;
      s.checkNotNull(paramByteBuffer);
      paramLong = DecoderUtils.getAudioDuration(paramLong, i, paramByteBuffer.getAudioSampleRateHz());
      AppMethodBeat.o(281191);
      return paramLong;
      localObject3 = this.TXS;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("dataBuffer");
        localObject1 = null;
      }
      ((ByteBuffer)localObject1).position(k);
      break;
    }
    label432:
    Log.w(this.TAG, "writeAudioSample: error");
    AppMethodBeat.o(281191);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.encoder.a
 * JD-Core Version:    0.7.0.1
 */