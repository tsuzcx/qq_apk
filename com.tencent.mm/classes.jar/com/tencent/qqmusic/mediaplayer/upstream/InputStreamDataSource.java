package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDataSource
  implements IDataSource
{
  private long currentPosition;
  private InputStream currentStream;
  private final InputStreamFactory factory;
  private long size;
  
  public InputStreamDataSource(InputStreamFactory paramInputStreamFactory)
  {
    this.factory = paramInputStreamFactory;
  }
  
  public void close()
  {
    AppMethodBeat.i(114302);
    if (this.currentStream != null) {
      this.currentStream.close();
    }
    AppMethodBeat.o(114302);
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    AppMethodBeat.i(114301);
    AudioFormat.AudioType localAudioType = FormatDetector.getAudioFormat(this, false);
    AppMethodBeat.o(114301);
    return localAudioType;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public void open()
  {
    AppMethodBeat.i(114299);
    if (this.currentStream != null) {
      this.currentStream.close();
    }
    this.currentStream = this.factory.create();
    this.size = this.currentStream.available();
    this.currentPosition = 0L;
    AppMethodBeat.o(114299);
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114300);
    if (paramLong < this.currentPosition)
    {
      open();
      paramInt1 = readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(114300);
      return paramInt1;
    }
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
      if (l2 < 0L)
      {
        paramArrayOfByte = new IOException("skipped too much bytes");
        AppMethodBeat.o(114300);
        throw paramArrayOfByte;
      }
      this.currentPosition = paramLong;
    }
    paramInt1 = this.currentStream.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 > 0) {
      this.currentPosition += paramInt1;
    }
    AppMethodBeat.o(114300);
    return paramInt1;
  }
  
  public static abstract interface InputStreamFactory
  {
    public abstract InputStream create();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.InputStreamDataSource
 * JD-Core Version:    0.7.0.1
 */