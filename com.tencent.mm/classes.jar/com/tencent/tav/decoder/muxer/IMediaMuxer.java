package com.tencent.tav.decoder.muxer;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.tav.core.ExportConfig;
import java.nio.ByteBuffer;

public abstract interface IMediaMuxer
{
  public abstract int addTrack(MediaFormat paramMediaFormat);
  
  public abstract boolean ignoreHeader();
  
  public abstract void release();
  
  public abstract void setExportConfig(ExportConfig paramExportConfig);
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.IMediaMuxer
 * JD-Core Version:    0.7.0.1
 */