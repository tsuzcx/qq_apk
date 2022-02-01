package com.tencent.qqmusic.mediaplayer.upstream;

import java.io.IOException;

public abstract interface Loader
{
  public abstract void cancelLoading();
  
  public abstract long getUpstreamSize();
  
  public abstract boolean isLoading();
  
  public abstract void prepare();
  
  public abstract void shutdown();
  
  public abstract void startLoading(Chunk paramChunk);
  
  public static abstract interface Factory
  {
    public abstract Loader createLoader(Loader.Listener paramListener);
  }
  
  public static abstract interface Listener
  {
    public abstract void onLoadCancelled(boolean paramBoolean);
    
    public abstract void onLoadCompleted();
    
    public abstract void onLoadError(IOException paramIOException);
    
    public abstract void onLoadProgress(long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.Loader
 * JD-Core Version:    0.7.0.1
 */