package com.tencent.qqmusic.mediaplayer.upstream;

public abstract interface Loader
{
  public abstract void cancelLoading();
  
  public abstract long getUpstreamSize();
  
  public abstract boolean isLoading();
  
  public abstract void prepare();
  
  public abstract void shutdown();
  
  public abstract void startLoading(Chunk paramChunk);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.Loader
 * JD-Core Version:    0.7.0.1
 */