package com.tencent.qqmusic.mediaplayer.upstream;

import java.io.IOException;

public abstract interface CacheDataSource$Listener
  extends TransferListener
{
  public abstract void onBufferEnded();
  
  public abstract void onBufferStarted(long paramLong);
  
  public abstract long onStreamingError(IOException paramIOException);
  
  public abstract void onStreamingFinished();
  
  public abstract void onUpStreamTransfer(long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Listener
 * JD-Core Version:    0.7.0.1
 */