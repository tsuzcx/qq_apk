package com.tencent.mm.plugin.vlog.model;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.extractor.IExtractorDelegate;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/VLogAssetExtractor;", "Lcom/tencent/tav/extractor/IExtractorDelegate;", "()V", "TAG", "", "alignDtsToZero", "", "audioFormat", "Landroid/media/MediaFormat;", "audioRetTrackIndex", "", "audioTrackIndex", "nPtr", "", "videoFormat", "videoRetTrackIndex", "videoTrackIndex", "advance", "getSampleTime", "getSampleTrackIndex", "getTrackCount", "getTrackFormat", "index", "initTrackData", "", "nAudioTrackIndex", "nContainAudio", "nContainVideo", "nCreate", "path", "nCurrentSelectTrackIndex", "nDestroy", "nGetAudioBitrate", "nGetAudioChannelCount", "nGetAudioCsdData", "", "nGetAudioDuration", "", "nGetAudioMime", "nGetAudioSampleRate", "nGetFps", "nGetHeight", "nGetHevcHead", "nGetSampleData", "byteBuffer", "Ljava/nio/ByteBuffer;", "nGetSampleDataByteArray", "nGetSampleDataDtsUs", "nGetSampleDataPtsUs", "nGetTrackCount", "nGetVideoBitrate", "nGetVideoDuration", "nGetVideoExtraData", "nGetVideoMime", "nGetVideoPPS", "nGetVideoPixelFormat", "nGetVideoRotate", "nGetVideoSPS", "nGetWidth", "nReadNextSample", "nSeekTo", "timeUs", "nSelectTrack", "trackIndex", "nUnSelectTrack", "nVideoTrackIndex", "needMirror", "readSampleData", "byteBuf", "offset", "release", "seekTo", "mode", "selectTrack", "setDataSource", "unselectTrack", "plugin-vlog_release"})
public final class VLogAssetExtractor
  implements IExtractorDelegate
{
  private long NmO;
  private boolean NmP;
  private int NmQ;
  private int NmR;
  private String TAG;
  private MediaFormat audioFormat;
  private int audioTrackIndex;
  private MediaFormat videoFormat;
  private int videoTrackIndex;
  
  public VLogAssetExtractor()
  {
    AppMethodBeat.i(243363);
    this.TAG = ("MicroMsg.VLogAssetExtractor@" + this.NmO);
    this.videoFormat = new MediaFormat();
    this.audioFormat = new MediaFormat();
    this.videoTrackIndex = -1;
    this.audioTrackIndex = -1;
    this.NmR = 1;
    Log.i(this.TAG, "create VLogAssetExtractor");
    SightVideoJNI.registerALL();
    AppMethodBeat.o(243363);
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
    AppMethodBeat.i(243352);
    boolean bool = false;
    if (this.NmO != 0L) {
      bool = nReadNextSample(this.NmO);
    }
    AppMethodBeat.o(243352);
    return bool;
  }
  
  public final long getSampleTime()
  {
    AppMethodBeat.i(243345);
    if (this.NmO != 0L)
    {
      long l = nGetSampleDataPtsUs(this.NmO);
      AppMethodBeat.o(243345);
      return l;
    }
    AppMethodBeat.o(243345);
    return -1L;
  }
  
  public final int getSampleTrackIndex()
  {
    AppMethodBeat.i(243357);
    if (this.NmO != 0L)
    {
      int i;
      if (nCurrentSelectTrackIndex(this.NmO) == this.videoTrackIndex)
      {
        i = this.NmQ;
        AppMethodBeat.o(243357);
        return i;
      }
      if (nCurrentSelectTrackIndex(this.NmO) == this.audioTrackIndex)
      {
        i = this.NmR;
        AppMethodBeat.o(243357);
        return i;
      }
    }
    AppMethodBeat.o(243357);
    return -1;
  }
  
  public final int getTrackCount()
  {
    AppMethodBeat.i(243348);
    if (this.NmO != 0L)
    {
      int i = nGetTrackCount(this.NmO);
      AppMethodBeat.o(243348);
      return i;
    }
    AppMethodBeat.o(243348);
    return 0;
  }
  
  public final MediaFormat getTrackFormat(int paramInt)
  {
    AppMethodBeat.i(243356);
    if (paramInt == this.NmQ)
    {
      localMediaFormat = this.videoFormat;
      AppMethodBeat.o(243356);
      return localMediaFormat;
    }
    if (paramInt == this.NmR)
    {
      localMediaFormat = this.audioFormat;
      AppMethodBeat.o(243356);
      return localMediaFormat;
    }
    MediaFormat localMediaFormat = new MediaFormat();
    AppMethodBeat.o(243356);
    return localMediaFormat;
  }
  
  public final boolean needMirror()
  {
    return true;
  }
  
  public final int readSampleData(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(243346);
    p.k(paramByteBuffer, "byteBuf");
    if (this.NmO != 0L)
    {
      paramByteBuffer.clear();
      paramInt = nGetSampleData(this.NmO, paramByteBuffer);
      if (paramInt > 0)
      {
        paramByteBuffer.position(0);
        paramByteBuffer.limit(paramInt);
      }
      AppMethodBeat.o(243346);
      return paramInt;
    }
    AppMethodBeat.o(243346);
    return -1;
  }
  
  public final void release()
  {
    AppMethodBeat.i(243354);
    Log.i(this.TAG, "release");
    if (this.NmO != 0L)
    {
      nDestroy(this.NmO);
      this.NmO = 0L;
    }
    AppMethodBeat.o(243354);
  }
  
  public final void seekTo(long paramLong, int paramInt)
  {
    AppMethodBeat.i(243344);
    if (this.NmO != 0L)
    {
      long l = Util.currentTicks();
      boolean bool = nSeekTo(this.NmO, paramLong);
      Log.d(this.TAG, "seekTo " + paramLong + ", ret:" + bool + ", cost:" + Util.ticksToNow(l));
    }
    AppMethodBeat.o(243344);
  }
  
  public final void selectTrack(int paramInt)
  {
    AppMethodBeat.i(243343);
    Log.i(this.TAG, "selectTrack:".concat(String.valueOf(paramInt)));
    if (this.NmO != 0L)
    {
      if (paramInt == this.NmQ)
      {
        Log.i(this.TAG, "select video track");
        nSelectTrack(this.NmO, this.videoTrackIndex);
        AppMethodBeat.o(243343);
        return;
      }
      if (paramInt == this.NmR)
      {
        Log.i(this.TAG, "select audio track");
        nSelectTrack(this.NmO, this.audioTrackIndex);
      }
    }
    AppMethodBeat.o(243343);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(243351);
    p.k(paramString, "path");
    long l = Util.currentTicks();
    if (this.NmO != 0L)
    {
      nDestroy(this.NmO);
      this.NmO = 0L;
    }
    this.NmO = nCreate(paramString, this.NmP);
    Log.i(this.TAG, "setDataSource, path:" + paramString + ", nPtr:" + this.NmO + ", cost:" + Util.ticksToNow(l));
    this.TAG = ("MicroMsg.VLogAssetExtractor@" + this.NmO);
    boolean bool1;
    boolean bool2;
    if (this.NmO != 0L)
    {
      bool1 = nContainVideo(this.NmO);
      bool2 = nContainAudio(this.NmO);
      if (bool1)
      {
        this.videoTrackIndex = nVideoTrackIndex(this.NmO);
        paramString = nGetVideoMime(this.NmO);
        this.videoFormat.setString("mime", paramString);
        this.videoFormat.setInteger("width", nGetWidth(this.NmO));
        this.videoFormat.setInteger("height", nGetHeight(this.NmO));
        this.videoFormat.setInteger("bitrate", nGetVideoBitrate(this.NmO));
        this.videoFormat.setLong("durationUs", nGetVideoDuration(this.NmO) * 1000L);
        this.videoFormat.setInteger("frame-rate", (int)nGetFps(this.NmO));
        this.videoFormat.setInteger("max-input-size", nGetWidth(this.NmO) * nGetHeight(this.NmO));
        this.videoFormat.setInteger("rotation-degrees", nGetVideoRotate(this.NmO));
        if (!n.L(paramString, "video/avc", false)) {
          break label715;
        }
        paramString = nGetVideoSPS(this.NmO);
        if (paramString != null) {
          this.videoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(paramString));
        }
        paramString = nGetVideoPPS(this.NmO);
        if (paramString != null) {
          this.videoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(paramString));
        }
      }
      if (bool2)
      {
        this.audioTrackIndex = nAudioTrackIndex(this.NmO);
        this.audioFormat.setString("mime", nGetAudioMime(this.NmO));
        this.audioFormat.setInteger("bitrate", nGetAudioBitrate(this.NmO));
        this.audioFormat.setInteger("sample-rate", nGetAudioSampleRate(this.NmO));
        this.audioFormat.setLong("durationUs", nGetAudioDuration(this.NmO) * 1000L);
        this.audioFormat.setInteger("channel-count", nGetAudioChannelCount(this.NmO));
        paramString = nGetAudioCsdData(this.NmO);
        if (paramString != null)
        {
          this.audioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(paramString));
          this.audioFormat.setInteger("is-adts", 1);
        }
        this.audioFormat.setInteger("max-input-size", 16384);
      }
      Log.i(this.TAG, "init track data finished, hasVideo:" + bool1 + ", hasAudio:" + bool2 + ", videoFormat:" + this.videoFormat + ", audioFormat:" + this.audioFormat + ", videoTrackIndex:" + this.videoTrackIndex + ", audioTrackIndex:" + this.audioTrackIndex);
      if ((!bool1) || (!bool2)) {
        break label786;
      }
      this.NmQ = 0;
      this.NmR = 1;
    }
    for (;;)
    {
      Log.i(this.TAG, "videoRetTrackIndex:" + this.NmQ + ", audioRetTrackIndex:" + this.NmR);
      AppMethodBeat.o(243351);
      return;
      label715:
      if (n.L(paramString, "video/hevc", false))
      {
        paramString = nGetHevcHead(this.NmO);
        if (paramString == null) {
          break;
        }
        this.videoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(paramString));
        break;
      }
      paramString = nGetVideoExtraData(this.NmO);
      if (paramString == null) {
        break;
      }
      this.videoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(paramString));
      break;
      label786:
      if ((bool1) && (!bool2))
      {
        this.NmQ = 0;
        this.NmR = -1;
      }
      else if ((bool2) && (!bool1))
      {
        this.NmR = 0;
        this.NmQ = -1;
      }
      else
      {
        this.NmR = -1;
        this.NmQ = -1;
      }
    }
  }
  
  public final void unselectTrack(int paramInt)
  {
    AppMethodBeat.i(243347);
    if (this.NmO != 0L) {
      nUnSelectTrack(this.NmO);
    }
    AppMethodBeat.o(243347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.VLogAssetExtractor
 * JD-Core Version:    0.7.0.1
 */