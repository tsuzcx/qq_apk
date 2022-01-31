package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDataSource
  implements IDataSource
{
  private long currentPosition;
  private InputStream currentStream;
  private final InputStreamDataSource.InputStreamFactory factory;
  private long size;
  
  public InputStreamDataSource(InputStreamDataSource.InputStreamFactory paramInputStreamFactory)
  {
    this.factory = paramInputStreamFactory;
  }
  
  public void close()
  {
    if (this.currentStream != null) {
      this.currentStream.close();
    }
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    return FormatDetector.getAudioFormat(this, false);
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public void open()
  {
    if (this.currentStream != null) {
      this.currentStream.close();
    }
    this.currentStream = this.factory.create();
    this.size = this.currentStream.available();
    this.currentPosition = 0L;
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramLong < this.currentPosition)
    {
      open();
      paramInt1 = readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
    }
    do
    {
      return paramInt1;
      if (paramLong > this.currentPosition)
      {
        long l1 = paramLong - this.currentPosition;
        long l3;
        long l2;
        do
        {
          do
          {
            l3 = this.currentStream.skip(l1);
            l2 = l1 - l3;
            l1 = l2;
          } while (l2 > 0L);
          l1 = l2;
        } while (l3 <= 0L);
        if (l2 < 0L) {
          throw new IOException("skipped too much bytes");
        }
        this.currentPosition = paramLong;
      }
      paramInt2 = this.currentStream.read(paramArrayOfByte, paramInt1, paramInt2);
      paramInt1 = paramInt2;
    } while (paramInt2 <= 0);
    this.currentPosition += paramInt2;
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.InputStreamDataSource
 * JD-Core Version:    0.7.0.1
 */