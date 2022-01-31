package com.tencent.qqmusic.mediaplayer.upstream;

import android.os.Looper;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;

class CacheDataSource$1$1
  extends DefaultLoader
{
  CacheDataSource$1$1(CacheDataSource.1 param1, Looper paramLooper, UriLoader paramUriLoader, Loader.Listener paramListener)
  {
    super(paramLooper, paramUriLoader, paramListener);
  }
  
  protected IDataSink createCacheSink(StreamingRequest paramStreamingRequest)
  {
    return this.this$1.val$cacheSink;
  }
  
  protected IDataSource createUpStream(StreamingRequest paramStreamingRequest)
  {
    return this.this$1.val$upStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.1.1
 * JD-Core Version:    0.7.0.1
 */