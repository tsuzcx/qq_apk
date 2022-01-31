package com.tencent.qqmusic.mediaplayer.upstream;

public abstract interface UriLoader$Callback
{
  public abstract void onCancelled();
  
  public abstract void onFailed(Throwable paramThrowable);
  
  public abstract void onSucceed(StreamingRequest paramStreamingRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.UriLoader.Callback
 * JD-Core Version:    0.7.0.1
 */