package com.tencent.tav.decoder.muxer;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTime;
import java.nio.ByteBuffer;

public abstract interface IMediaMuxer
{
  public abstract int addTrack(MediaFormat paramMediaFormat);
  
  public abstract int audioTrackIndex();
  
  public abstract boolean ignoreHeader();
  
  public abstract boolean isMuxerStarted();
  
  public abstract void release();
  
  public abstract void setExportConfig(ExportConfig paramExportConfig);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract int videoTrackIndex();
  
  public abstract void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo);
  
  public abstract void writeSampleDataTime(boolean paramBoolean, CMTime paramCMTime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.IMediaMuxer
 * JD-Core Version:    0.7.0.1
 */