package com.tencent.qqmusic.mediaplayer.seektable;

import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

public abstract interface SeekTable
{
  public abstract void parse(IDataSource paramIDataSource);
  
  public abstract long seek(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.SeekTable
 * JD-Core Version:    0.7.0.1
 */