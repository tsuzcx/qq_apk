package com.tencent.qqmusic.mediaplayer.upstream;

public abstract interface IDataSourceFactory
{
  public abstract IDataSource createDataSource();
  
  public abstract INativeDataSource createNativeDataSource();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory
 * JD-Core Version:    0.7.0.1
 */