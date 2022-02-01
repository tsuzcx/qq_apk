package com.tencent.tav.extractor;

import android.media.MediaFormat;
import java.nio.ByteBuffer;

public abstract interface IExtractorDelegate
{
  public abstract boolean advance();
  
  public abstract long getSampleTime();
  
  public abstract int getSampleTrackIndex();
  
  public abstract int getTrackCount();
  
  public abstract MediaFormat getTrackFormat(int paramInt);
  
  public abstract boolean needMirror();
  
  public abstract int readSampleData(ByteBuffer paramByteBuffer, int paramInt);
  
  public abstract void release();
  
  public abstract void seekTo(long paramLong, int paramInt);
  
  public abstract void selectTrack(int paramInt);
  
  public abstract void setDataSource(String paramString);
  
  public abstract void unselectTrack(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.extractor.IExtractorDelegate
 * JD-Core Version:    0.7.0.1
 */