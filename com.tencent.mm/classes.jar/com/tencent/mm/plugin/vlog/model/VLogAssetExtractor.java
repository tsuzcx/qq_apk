package com.tencent.mm.plugin.vlog.model;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.extractor.IExtractorDelegate;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/VLogAssetExtractor;", "Lcom/tencent/tav/extractor/IExtractorDelegate;", "()V", "TAG", "", "alignDtsToZero", "", "audioFormat", "Landroid/media/MediaFormat;", "audioRetTrackIndex", "", "audioTrackIndex", "nPtr", "", "videoFormat", "videoRetTrackIndex", "videoTrackIndex", "advance", "getSampleTime", "getSampleTrackIndex", "getTrackCount", "getTrackFormat", "index", "initTrackData", "", "nAudioTrackIndex", "nContainAudio", "nContainVideo", "nCreate", "path", "nCurrentSelectTrackIndex", "nDestroy", "nGetAudioBitrate", "nGetAudioChannelCount", "nGetAudioCsdData", "", "nGetAudioDuration", "", "nGetAudioMime", "nGetAudioSampleRate", "nGetFps", "nGetHeight", "nGetHevcHead", "nGetSampleData", "byteBuffer", "Ljava/nio/ByteBuffer;", "nGetSampleDataByteArray", "nGetSampleDataDtsUs", "nGetSampleDataPtsUs", "nGetTrackCount", "nGetVideoBitrate", "nGetVideoDuration", "nGetVideoExtraData", "nGetVideoMime", "nGetVideoPPS", "nGetVideoPixelFormat", "nGetVideoRotate", "nGetVideoSPS", "nGetWidth", "nReadNextSample", "nSeekTo", "timeUs", "nSelectTrack", "trackIndex", "nUnSelectTrack", "nVideoTrackIndex", "needMirror", "readSampleData", "byteBuf", "offset", "release", "seekTo", "mode", "selectTrack", "setDataSource", "unselectTrack", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VLogAssetExtractor
  implements IExtractorDelegate
{
  private String TAG;
  private boolean Uar;
  private int Uas;
  private int Uat;
  private MediaFormat audioFormat;
  private int audioTrackIndex;
  private long nNg;
  private MediaFormat videoFormat;
  private int videoTrackIndex;
  
  public VLogAssetExtractor()
  {
    AppMethodBeat.i(283265);
    this.TAG = s.X("MicroMsg.VLogAssetExtractor@", Long.valueOf(this.nNg));
    this.videoFormat = new MediaFormat();
    this.audioFormat = new MediaFormat();
    this.videoTrackIndex = -1;
    this.audioTrackIndex = -1;
    this.Uat = 1;
    Log.i(this.TAG, "create VLogAssetExtractor");
    SightVideoJNI.registerALL();
    AppMethodBeat.o(283265);
  }
  
  private final native int nAudioTrackIndex(long paramLong);
  
  private final native boolean nContainAudio(long paramLong);
  
  private final native boolean nContainVideo(long paramLong);
  
  private final native long nCreate(String paramString, boolean paramBoolean);
  
  private final native int nCurrentSelectTrackIndex(long paramLong);
  
  private final native boolean nDestroy(long paramLong);
  
  private final native int nGetAudioBitrate(long paramLong);
  
  private final native int nGetAudioChannelCount(long paramLong);
  
  private final native byte[] nGetAudioCsdData(long paramLong);
  
  private final native double nGetAudioDuration(long paramLong);
  
  private final native String nGetAudioMime(long paramLong);
  
  private final native int nGetAudioSampleRate(long paramLong);
  
  private final native double nGetFps(long paramLong);
  
  private final native int nGetHeight(long paramLong);
  
  private final native byte[] nGetHevcHead(long paramLong);
  
  private final native int nGetSampleData(long paramLong, ByteBuffer paramByteBuffer);
  
  private final native byte[] nGetSampleDataByteArray(long paramLong);
  
  private final native long nGetSampleDataDtsUs(long paramLong);
  
  private final native long nGetSampleDataPtsUs(long paramLong);
  
  private final native int nGetTrackCount(long paramLong);
  
  private final native int nGetVideoBitrate(long paramLong);
  
  private final native double nGetVideoDuration(long paramLong);
  
  private final native byte[] nGetVideoExtraData(long paramLong);
  
  private final native String nGetVideoMime(long paramLong);
  
  private final native byte[] nGetVideoPPS(long paramLong);
  
  private final native int nGetVideoPixelFormat(long paramLong);
  
  private final native int nGetVideoRotate(long paramLong);
  
  private final native byte[] nGetVideoSPS(long paramLong);
  
  private final native int nGetWidth(long paramLong);
  
  private final native boolean nReadNextSample(long paramLong);
  
  private final native boolean nSeekTo(long paramLong1, long paramLong2);
  
  private final native boolean nSelectTrack(long paramLong, int paramInt);
  
  private final native boolean nUnSelectTrack(long paramLong);
  
  private final native int nVideoTrackIndex(long paramLong);
  
  public final boolean advance()
  {
    AppMethodBeat.i(283551);
    boolean bool = false;
    if (this.nNg != 0L) {
      bool = nReadNextSample(this.nNg);
    }
    AppMethodBeat.o(283551);
    return bool;
  }
  
  public final long getSampleTime()
  {
    AppMethodBeat.i(283485);
    if (this.nNg != 0L)
    {
      long l = nGetSampleDataPtsUs(this.nNg);
      AppMethodBeat.o(283485);
      return l;
    }
    AppMethodBeat.o(283485);
    return -1L;
  }
  
  public final int getSampleTrackIndex()
  {
    AppMethodBeat.i(283576);
    if (this.nNg != 0L)
    {
      int i;
      if (nCurrentSelectTrackIndex(this.nNg) == this.videoTrackIndex)
      {
        i = this.Uas;
        AppMethodBeat.o(283576);
        return i;
      }
      if (nCurrentSelectTrackIndex(this.nNg) == this.audioTrackIndex)
      {
        i = this.Uat;
        AppMethodBeat.o(283576);
        return i;
      }
    }
    AppMethodBeat.o(283576);
    return -1;
  }
  
  public final int getTrackCount()
  {
    AppMethodBeat.i(283514);
    if (this.nNg != 0L)
    {
      int i = nGetTrackCount(this.nNg);
      AppMethodBeat.o(283514);
      return i;
    }
    AppMethodBeat.o(283514);
    return 0;
  }
  
  public final MediaFormat getTrackFormat(int paramInt)
  {
    AppMethodBeat.i(283569);
    if (paramInt == this.Uas)
    {
      localMediaFormat = this.videoFormat;
      AppMethodBeat.o(283569);
      return localMediaFormat;
    }
    if (paramInt == this.Uat)
    {
      localMediaFormat = this.audioFormat;
      AppMethodBeat.o(283569);
      return localMediaFormat;
    }
    MediaFormat localMediaFormat = new MediaFormat();
    AppMethodBeat.o(283569);
    return localMediaFormat;
  }
  
  public final boolean needMirror()
  {
    return true;
  }
  
  public final int readSampleData(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(283501);
    s.u(paramByteBuffer, "byteBuf");
    if (this.nNg != 0L)
    {
      paramByteBuffer.clear();
      paramInt = nGetSampleData(this.nNg, paramByteBuffer);
      if (paramInt > 0)
      {
        paramByteBuffer.position(0);
        paramByteBuffer.limit(paramInt);
      }
      AppMethodBeat.o(283501);
      return paramInt;
    }
    AppMethodBeat.o(283501);
    return -1;
  }
  
  public final void release()
  {
    AppMethodBeat.i(283559);
    Log.i(this.TAG, "release");
    if (this.nNg != 0L)
    {
      nDestroy(this.nNg);
      this.nNg = 0L;
    }
    AppMethodBeat.o(283559);
  }
  
  public final void seekTo(long paramLong, int paramInt)
  {
    AppMethodBeat.i(283476);
    if (this.nNg != 0L)
    {
      long l = Util.currentTicks();
      boolean bool = nSeekTo(this.nNg, paramLong);
      Log.d(this.TAG, "seekTo " + paramLong + ", ret:" + bool + ", cost:" + Util.ticksToNow(l));
    }
    AppMethodBeat.o(283476);
  }
  
  public final void selectTrack(int paramInt)
  {
    AppMethodBeat.i(283470);
    Log.i(this.TAG, s.X("selectTrack:", Integer.valueOf(paramInt)));
    if (this.nNg != 0L)
    {
      if (paramInt == this.Uas)
      {
        Log.i(this.TAG, "select video track");
        nSelectTrack(this.nNg, this.videoTrackIndex);
        AppMethodBeat.o(283470);
        return;
      }
      if (paramInt == this.Uat)
      {
        Log.i(this.TAG, "select audio track");
        nSelectTrack(this.nNg, this.audioTrackIndex);
      }
    }
    AppMethodBeat.o(283470);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(283532);
    s.u(paramString, "path");
    long l = Util.currentTicks();
    if (this.nNg != 0L)
    {
      nDestroy(this.nNg);
      this.nNg = 0L;
    }
    this.nNg = nCreate(paramString, this.Uar);
    Log.i(this.TAG, "setDataSource, path:" + paramString + ", nPtr:" + this.nNg + ", cost:" + Util.ticksToNow(l));
    this.TAG = s.X("MicroMsg.VLogAssetExtractor@", Long.valueOf(this.nNg));
    boolean bool1;
    boolean bool2;
    if (this.nNg != 0L)
    {
      bool1 = nContainVideo(this.nNg);
      bool2 = nContainAudio(this.nNg);
      if (bool1)
      {
        this.videoTrackIndex = nVideoTrackIndex(this.nNg);
        paramString = nGetVideoMime(this.nNg);
        this.videoFormat.setString("mime", paramString);
        this.videoFormat.setInteger("width", nGetWidth(this.nNg));
        this.videoFormat.setInteger("height", nGetHeight(this.nNg));
        this.videoFormat.setInteger("bitrate", nGetVideoBitrate(this.nNg));
        this.videoFormat.setLong("durationUs", nGetVideoDuration(this.nNg) * 1000L);
        int j = (int)nGetFps(this.nNg);
        int i = j;
        if (j <= 0) {
          i = 1;
        }
        this.videoFormat.setInteger("frame-rate", i);
        this.videoFormat.setInteger("max-input-size", nGetWidth(this.nNg) * nGetHeight(this.nNg));
        this.videoFormat.setInteger("rotation-degrees", nGetVideoRotate(this.nNg));
        if (!n.T(paramString, "video/avc", false)) {
          break label720;
        }
        paramString = nGetVideoSPS(this.nNg);
        if (paramString != null) {
          this.videoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(paramString));
        }
        paramString = nGetVideoPPS(this.nNg);
        if (paramString != null) {
          this.videoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(paramString));
        }
      }
      if (bool2)
      {
        this.audioTrackIndex = nAudioTrackIndex(this.nNg);
        this.audioFormat.setString("mime", nGetAudioMime(this.nNg));
        this.audioFormat.setInteger("bitrate", nGetAudioBitrate(this.nNg));
        this.audioFormat.setInteger("sample-rate", nGetAudioSampleRate(this.nNg));
        this.audioFormat.setLong("durationUs", nGetAudioDuration(this.nNg) * 1000L);
        this.audioFormat.setInteger("channel-count", nGetAudioChannelCount(this.nNg));
        paramString = nGetAudioCsdData(this.nNg);
        if (paramString != null)
        {
          this.audioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(paramString));
          this.audioFormat.setInteger("is-adts", 1);
        }
        this.audioFormat.setInteger("max-input-size", 16384);
      }
      Log.i(this.TAG, "init track data finished, hasVideo:" + bool1 + ", hasAudio:" + bool2 + ", videoFormat:" + this.videoFormat + ", audioFormat:" + this.audioFormat + ", videoTrackIndex:" + this.videoTrackIndex + ", audioTrackIndex:" + this.audioTrackIndex);
      if ((!bool1) || (!bool2)) {
        break label791;
      }
      this.Uas = 0;
      this.Uat = 1;
    }
    for (;;)
    {
      Log.i(this.TAG, "videoRetTrackIndex:" + this.Uas + ", audioRetTrackIndex:" + this.Uat);
      AppMethodBeat.o(283532);
      return;
      label720:
      if (n.T(paramString, "video/hevc", false))
      {
        paramString = nGetHevcHead(this.nNg);
        if (paramString == null) {
          break;
        }
        this.videoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(paramString));
        break;
      }
      paramString = nGetVideoExtraData(this.nNg);
      if (paramString == null) {
        break;
      }
      this.videoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(paramString));
      break;
      label791:
      if ((bool1) && (!bool2))
      {
        this.Uas = 0;
        this.Uat = -1;
      }
      else if ((bool2) && (!bool1))
      {
        this.Uat = 0;
        this.Uas = -1;
      }
      else
      {
        this.Uat = -1;
        this.Uas = -1;
      }
    }
  }
  
  public final void unselectTrack(int paramInt)
  {
    AppMethodBeat.i(283509);
    if (this.nNg != 0L) {
      nUnSelectTrack(this.nNg);
    }
    AppMethodBeat.o(283509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.VLogAssetExtractor
 * JD-Core Version:    0.7.0.1
 */