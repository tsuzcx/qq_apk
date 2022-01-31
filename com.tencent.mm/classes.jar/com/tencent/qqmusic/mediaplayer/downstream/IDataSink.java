package com.tencent.qqmusic.mediaplayer.downstream;

import java.io.Closeable;

public abstract interface IDataSink
  extends Closeable
{
  public abstract void open();
  
  public abstract int write(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.downstream.IDataSink
 * JD-Core Version:    0.7.0.1
 */