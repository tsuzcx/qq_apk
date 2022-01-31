package com.tencent.qqmusic.mediaplayer.upstream;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(104516);
    paramStreamingRequest = new FileDataSink(this.this$0.val$bufferFile.getAbsolutePath());
    AppMethodBeat.o(104516);
    return paramStreamingRequest;
  }
  
  protected IDataSource createUpStream(StreamingRequest paramStreamingRequest)
  {
    AppMethodBeat.i(104515);
    paramStreamingRequest = new HttpDataSource(paramStreamingRequest.uri, paramStreamingRequest.headers, new DefaultMediaHTTPService());
    AppMethodBeat.o(104515);
    return paramStreamingRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory.2.1
 * JD-Core Version:    0.7.0.1
 */