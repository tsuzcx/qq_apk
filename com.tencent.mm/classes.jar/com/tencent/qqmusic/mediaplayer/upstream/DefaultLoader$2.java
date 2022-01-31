package com.tencent.qqmusic.mediaplayer.upstream;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;

class DefaultLoader$2
  implements UriLoader.Callback
{
  DefaultLoader$2(DefaultLoader paramDefaultLoader) {}
  
  public void onCancelled()
  {
    AppMethodBeat.i(104548);
    DefaultLoader.access$300(this.this$0).obtainMessage(5).sendToTarget();
    AppMethodBeat.o(104548);
  }
  
  public void onFailed(Throwable paramThrowable)
  {
    AppMethodBeat.i(104547);
    DefaultLoader.access$300(this.this$0).obtainMessage(4, new IOException("failed to load uri", paramThrowable)).sendToTarget();
    AppMethodBeat.o(104547);
  }
  
  public void onSucceed(StreamingRequest paramStreamingRequest)
  {
    AppMethodBeat.i(104546);
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
        AppMethodBeat.o(104546);
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