package com.tencent.tav.decoder;

import android.media.MediaFormat;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import java.nio.ByteBuffer;

public abstract interface AssetWriterAudioEncoder
{
  public abstract boolean endWriteAudioSample();
  
  public abstract MediaFormat getEncodeFormat();
  
  public abstract long getEncodePresentationTimeUs();
  
  public abstract boolean isEncodeToEndOfStream();
  
  public abstract boolean prepare(ExportConfig paramExportConfig, MediaFormat paramMediaFormat);
  
  public abstract void release();
  
  public abstract void setMediaMuxer(IMediaMuxer paramIMediaMuxer);
  
  public abstract boolean start();
  
  public abstract void stop();
  
  public abstract boolean writeAudioFrame(boolean paramBoolean);
  
  public abstract long writeAudioSample(long paramLong, ByteBuffer paramByteBuffer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.AssetWriterAudioEncoder
 * JD-Core Version:    0.7.0.1
 */