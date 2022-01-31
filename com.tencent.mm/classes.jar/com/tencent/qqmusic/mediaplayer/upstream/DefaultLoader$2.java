package com.tencent.qqmusic.mediaplayer.upstream;

import android.os.Handler;
import android.os.Message;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;

class DefaultLoader$2
  implements UriLoader.Callback
{
  DefaultLoader$2(DefaultLoader paramDefaultLoader) {}
  
  public void onCancelled()
  {
    DefaultLoader.access$300(this.this$0).obtainMessage(5).sendToTarget();
  }
  
  public void onFailed(Throwable paramThrowable)
  {
    DefaultLoader.access$300(this.this$0).obtainMessage(4, new IOException("failed to load uri", paramThrowable)).sendToTarget();
  }
  
  public void onSucceed(StreamingRequest paramStreamingRequest)
  {
    Logger.i("DefaultLoader", "[startLoading] uriLoader.startLoading onSucceed");
    IDataSource localIDataSource = this.this$0.createUpStream(paramStreamingRequest);
    try
    {
      localIDataSource.open();
      DefaultLoader.access$202(this.this$0, localIDataSource.getSize());
      paramStreamingRequest = this.this$0.createCacheSink(paramStreamingRequest);
    }
    catch (IOException localIOException1)
    {
      try
      {
        paramStreamingRequest.open();
        DefaultLoader.access$402(this.this$0, paramStreamingRequest);
        DefaultLoader.access$502(this.this$0, localIDataSource);
        this.this$0.start();
        return;
        localIOException1 = localIOException1;
        DefaultLoader.access$300(this.this$0).obtainMessage(4, localIOException1).sendToTarget();
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          DefaultLoader.access$300(this.this$0).obtainMessage(4, localIOException2).sendToTarget();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader.2
 * JD-Core Version:    0.7.0.1
 */