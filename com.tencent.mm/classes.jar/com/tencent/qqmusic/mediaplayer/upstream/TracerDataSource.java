package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class TracerDataSource
  implements IDataSource
{
  private static final String TAG = "TracerDataSource";
  private final IDataSource impl;
  
  public TracerDataSource(IDataSource paramIDataSource)
  {
    this.impl = paramIDataSource;
  }
  
  public void close()
  {
    AppMethodBeat.i(76517);
    try
    {
      this.impl.close();
      AppMethodBeat.o(76517);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("TracerDataSource", "[close] failed!", localThrowable);
      AppMethodBeat.o(76517);
      throw localThrowable;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(76519);
    boolean bool = this.impl.equals(paramObject);
    AppMethodBeat.o(76519);
    return bool;
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    AppMethodBeat.i(76516);
    try
    {
      AudioFormat.AudioType localAudioType = this.impl.getAudioType();
      AppMethodBeat.o(76516);
      return localAudioType;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("TracerDataSource", "[getAudioType] failed!", localThrowable);
      AppMethodBeat.o(76516);
      throw localThrowable;
    }
  }
  
  public long getSize()
  {
    AppMethodBeat.i(76515);
    try
    {
      long l = this.impl.getSize();
      AppMethodBeat.o(76515);
      return l;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("TracerDataSource", "[getSize] failed!", localThrowable);
      AppMethodBeat.o(76515);
      throw localThrowable;
    }
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(76520);
    int i = this.impl.hashCode();
    AppMethodBeat.o(76520);
    return i;
  }
  
  public void open()
  {
    AppMethodBeat.i(76513);
    try
    {
      this.impl.open();
      AppMethodBeat.o(76513);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("TracerDataSource", "[open] failed!", localThrowable);
      AppMethodBeat.o(76513);
      throw localThrowable;
    }
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76514);
    try
    {
      int i = this.impl.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(76514);
      return i;
    }
    catch (Throwable paramArrayOfByte)
    {
      Logger.e("TracerDataSource", "[readAt] failed! pos = " + paramLong + ", offset = " + paramInt1 + ", size = " + paramInt2, paramArrayOfByte);
      AppMethodBeat.o(76514);
      throw paramArrayOfByte;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(76518);
    String str = this.impl.toString();
    AppMethodBeat.o(76518);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.TracerDataSource
 * JD-Core Version:    0.7.0.1
 */