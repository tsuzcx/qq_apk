package com.tencent.tav.decoder.muxer;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTime;
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
    AppMethodBeat.i(218459);
    this.TAG = "DefaultMediaMuxer";
    this.isStarted = false;
    this.videoTrackIndex = -1;
    this.audioTrackIndex = -1;
    this.muxer = new MediaMuxer(paramString, paramInt);
    AppMethodBeat.o(218459);
  }
  
  public int addTrack(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(218461);
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
      AppMethodBeat.o(218461);
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
  
  public boolean ignoreHeader()
  {
    return true;
  }
  
  public boolean isMuxerStarted()
  {
    return this.isStarted;
  }
  
  public void release()
  {
    AppMethodBeat.i(218464);
    this.muxer.release();
    this.isStarted = false;
    Logger.i("DefaultMediaMuxer", "release muxer");
    AppMethodBeat.o(218464);
  }
  
  public void setExportConfig(ExportConfig paramExportConfig) {}
  
  public void start()
  {
    AppMethodBeat.i(218460);
    this.muxer.start();
    this.isStarted = true;
    AppMethodBeat.o(218460);
  }
  
  public void stop()
  {
    AppMethodBeat.i(218463);
    this.muxer.stop();
    this.isStarted = false;
    Logger.i("DefaultMediaMuxer", "stop muxer");
    AppMethodBeat.o(218463);
  }
  
  public int videoTrackIndex()
  {
    return this.videoTrackIndex;
  }
  
  public void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(218462);
    this.muxer.writeSampleData(paramInt, paramByteBuffer, paramBufferInfo);
    AppMethodBeat.o(218462);
  }
  
  public void writeSampleDataTime(boolean paramBoolean, CMTime paramCMTime) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.DefaultMediaMuxer
 * JD-Core Version:    0.7.0.1
 */