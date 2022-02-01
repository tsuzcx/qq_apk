package com.tencent.mm.plugin.vlog.parallel;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.TAVKitMuxer.SightVideoJNIMediaMuxer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/parallel/ParallelSingleSoftWriter;", "Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer$SightVideoJNIMediaMuxer;", "path", "", "format", "", "(Ljava/lang/String;I)V", "TAG", "audioTrackInfo", "Lcom/tencent/mm/plugin/vlog/parallel/ParallelMuxTrackInfo;", "isFinish", "", "getPath", "()Ljava/lang/String;", "addTrack", "mediaFormat", "Landroid/media/MediaFormat;", "audioTrack", "audioTrackIndex", "clearResource", "", "getH264FilePath", "getTotalFrameCount", "getValidAudioFormat", "getValidVideoFormat", "release", "stop", "writeSampleData", "trackId", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends TAVKitMuxer.SightVideoJNIMediaMuxer
{
  private final String TAG;
  a UcM;
  private final int format;
  private volatile boolean ooe;
  final String path;
  
  public c(String paramString, int paramInt)
  {
    super(paramString, paramInt);
    AppMethodBeat.i(281245);
    this.path = paramString;
    this.format = paramInt;
    this.TAG = ("MicroMsg.ParallelSoftWriter[" + hashCode() + ']');
    AppMethodBeat.o(281245);
  }
  
  public final int addTrack(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(281253);
    s.u(paramMediaFormat, "mediaFormat");
    Object localObject;
    if (paramMediaFormat.containsKey("mime"))
    {
      localObject = paramMediaFormat.getString("mime");
      s.checkNotNull(localObject);
      s.s(localObject, "mediaFormat.getString(MediaFormat.KEY_MIME)!!");
      if (!n.a((CharSequence)localObject, (CharSequence)"video", false)) {}
    }
    for (int i = 1; i == 0; i = 0)
    {
      setAudioFormat(paramMediaFormat);
      localObject = a.Ucz;
      this.UcM = a.a.b(paramMediaFormat, String.valueOf(hashCode()));
      i = audioTrackIndex();
      AppMethodBeat.o(281253);
      return i;
    }
    i = super.addTrack(paramMediaFormat);
    AppMethodBeat.o(281253);
    return i;
  }
  
  public final int audioTrackIndex()
  {
    a locala = this.UcM;
    if (locala == null) {
      return -1;
    }
    return locala.trackId;
  }
  
  public final void clearResource()
  {
    AppMethodBeat.i(281296);
    Log.i(this.TAG, "clearResource");
    super.clearResource();
    super.release();
    AppMethodBeat.o(281296);
  }
  
  public final MediaFormat hRU()
  {
    AppMethodBeat.i(281274);
    MediaFormat localMediaFormat = getVideoFormat();
    AppMethodBeat.o(281274);
    return localMediaFormat;
  }
  
  public final MediaFormat hRV()
  {
    AppMethodBeat.i(281279);
    MediaFormat localMediaFormat = getAudioFormat();
    AppMethodBeat.o(281279);
    return localMediaFormat;
  }
  
  public final int hRW()
  {
    AppMethodBeat.i(281284);
    int i = getVideoFrameCount();
    AppMethodBeat.o(281284);
    return i;
  }
  
  public final void release()
  {
    AppMethodBeat.i(281289);
    Log.i(this.TAG, "release");
    AppMethodBeat.o(281289);
  }
  
  public final boolean stop()
  {
    AppMethodBeat.i(281272);
    if (this.ooe)
    {
      AppMethodBeat.o(281272);
      return true;
    }
    this.ooe = true;
    Object localObject = getEncoder();
    if (localObject != null) {
      ((AssetWriterVideoEncoder)localObject).stop();
    }
    localObject = this.UcM;
    if (localObject != null) {
      ((a)localObject).hRR();
    }
    if (getDuration() <= 0)
    {
      Log.e(this.TAG, "error duration is 0");
      setStarted(false);
      AppMethodBeat.o(281272);
      return false;
    }
    setStarted(false);
    AppMethodBeat.o(281272);
    return true;
  }
  
  public final void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(281265);
    s.u(paramByteBuffer, "byteBuffer");
    s.u(paramBufferInfo, "bufferInfo");
    if (paramInt == audioTrackIndex())
    {
      a locala = this.UcM;
      if (locala != null) {
        locala.k(paramByteBuffer, paramBufferInfo);
      }
      AppMethodBeat.o(281265);
      return;
    }
    super.writeSampleData(paramInt, paramByteBuffer, paramBufferInfo);
    AppMethodBeat.o(281265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.parallel.c
 * JD-Core Version:    0.7.0.1
 */