package com.tencent.qqmusic.mediaplayer.upstream;

import android.os.Looper;
import com.tencent.qqmusic.mediaplayer.downstream.FileDataSink;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;
import com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPService;
import java.io.File;

class CacheDataSource$Factory$2$1
  extends DefaultLoader
{
  CacheDataSource$Factory$2$1(CacheDataSource.Factory.2 param2, Looper paramLooper, UriLoader paramUriLoader, Loader.Listener paramListener)
  {
    super(paramLooper, paramUriLoader, paramListener);
  }
  
  protected IDataSink createCacheSink(StreamingRequest paramStreamingRequest)
  {
    return new FileDataSink(this.this$0.val$bufferFile.getAbsolutePath());
  }
  
  protected IDataSource createUpStream(StreamingRequest paramStreamingRequest)
  {
    return new HttpDataSource(paramStreamingRequest.uri, paramStreamingRequest.headers, new DefaultMediaHTTPService());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory.2.1
 * JD-Core Version:    0.7.0.1
 */