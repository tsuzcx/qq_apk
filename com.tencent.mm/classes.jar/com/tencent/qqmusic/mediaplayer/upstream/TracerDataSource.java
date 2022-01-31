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
    AppMethodBeat.i(104587);
    try
    {
      this.impl.close();
      AppMethodBeat.o(104587);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("TracerDataSource", "[close] failed!", localThrowable);
      AppMethodBeat.o(104587);
      throw localThrowable;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(104589);
    boolean bool = this.impl.equals(paramObject);
    AppMethodBeat.o(104589);
    return bool;
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    AppMethodBeat.i(104586);
    try
    {
      AudioFormat.AudioType localAudioType = this.impl.getAudioType();
      AppMethodBeat.o(104586);
      return localAudioType;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("TracerDataSource", "[getAudioType] failed!", localThrowable);
      AppMethodBeat.o(104586);
      throw localThrowable;
    }
  }
  
  public long getSize()
  {
    AppMethodBeat.i(104585);
    try
    {
      long l = this.impl.getSize();
      AppMethodBeat.o(104585);
      return l;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("TracerDataSource", "[getSize] failed!", localThrowable);
      AppMethodBeat.o(104585);
      throw localThrowable;
    }
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(104590);
    int i = this.impl.hashCode();
    AppMethodBeat.o(104590);
    return i;
  }
  
  public void open()
  {
    AppMethodBeat.i(104583);
    try
    {
      this.impl.open();
      AppMethodBeat.o(104583);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("TracerDataSource", "[open] failed!", localThrowable);
      AppMethodBeat.o(104583);
      throw localThrowable;
    }
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104584);
    try
    {
      int i = this.impl.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(104584);
      return i;
    }
    catch (Throwable paramArrayOfByte)
    {
      Logger.e("TracerDataSource", "[readAt] failed! pos = " + paramLong + ", offset = " + paramInt1 + ", size = " + paramInt2, paramArrayOfByte);
      AppMethodBeat.o(104584);
      throw paramArrayOfByte;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(104588);
    String str = this.impl.toString();
    AppMethodBeat.o(104588);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.TracerDataSource
 * JD-Core Version:    0.7.0.1
 */