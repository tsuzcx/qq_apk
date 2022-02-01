package com.tencent.tav.decoder.muxer;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;

public class DefaultMediaMuxer
  implements IMediaMuxer
{
  private final String TAG;
  private int audioTrackIndex;
  private boolean isStarted;
  private MediaMuxer muxer;
  private int videoTrackIndex;
  
  public DefaultMediaMuxer(String paramString, int paramInt)
  {
    AppMethodBeat.i(216387);
    this.TAG = "DefaultMediaMuxer";
    this.isStarted = false;
    this.videoTrackIndex = -1;
    this.audioTrackIndex = -1;
    this.muxer = new MediaMuxer(paramString, paramInt);
    AppMethodBeat.o(216387);
  }
  
  public int addTrack(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(216448);
    int i = this.muxer.addTrack(paramMediaFormat);
    if (paramMediaFormat.containsKey("mime"))
    {
      paramMediaFormat = paramMediaFormat.getString("mime");
      Logger.i("DefaultMediaMuxer", "add track mime:".concat(String.valueOf(paramMediaFormat)));
      if (!paramMediaFormat.contains("video")) {
        break label65;
      }
      this.videoTrackIndex = i;
    }
    for (;;)
    {
      AppMethodBeat.o(216448);
      return i;
      label65:
      if (paramMediaFormat.contains("audio")) {
        this.audioTrackIndex = i;
      }
    }
  }
  
  public int audioTrackIndex()
  {
    return this.audioTrackIndex;
  }
  
  public void clearResource() {}
  
  public ExportConfig getExportConfig()
  {
    return null;
  }
  
  public boolean ignoreHeader()
  {
    return true;
  }
  
  public boolean isMuxerStarted()
  {
    return this.isStarted;
  }
  
  public void prepareParallelSegmentInfo(int paramInt, CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2) {}
  
  public void release()
  {
    AppMethodBeat.i(216509);
    this.muxer.release();
    this.isStarted = false;
    Logger.i("DefaultMediaMuxer", "release muxer");
    AppMethodBeat.o(216509);
  }
  
  public void setExportConfig(ExportConfig paramExportConfig) {}
  
  public void start()
  {
    AppMethodBeat.i(216411);
    this.muxer.start();
    this.isStarted = true;
    AppMethodBeat.o(216411);
  }
  
  public boolean stop()
  {
    AppMethodBeat.i(216497);
    this.muxer.stop();
    this.isStarted = false;
    Logger.i("DefaultMediaMuxer", "stop muxer");
    AppMethodBeat.o(216497);
    return true;
  }
  
  public int videoTrackIndex()
  {
    return this.videoTrackIndex;
  }
  
  public void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(216459);
    this.muxer.writeSampleData(paramInt, paramByteBuffer, paramBufferInfo);
    AppMethodBeat.o(216459);
  }
  
  public void writeSampleDataTime(boolean paramBoolean, CMTime paramCMTime) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.DefaultMediaMuxer
 * JD-Core Version:    0.7.0.1
 */