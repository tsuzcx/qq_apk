package com.tencent.qqmusic.mediaplayer.upstream;

import java.util.concurrent.TimeUnit;

public abstract interface UriLoader
{
  public abstract void cancelLoading();
  
  public abstract boolean isLoading();
  
  public abstract void startLoading(int paramInt, TimeUnit paramTimeUnit, Callback paramCallback);
  
  public static abstract interface Callback
  {
    public abstract void onCancelled();
    
    public abstract void onFailed(Throwable paramThrowable);
    
    public abstract void onSucceed(StreamingRequest paramStreamingRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.UriLoader
 * JD-Core Version:    0.7.0.1
 */