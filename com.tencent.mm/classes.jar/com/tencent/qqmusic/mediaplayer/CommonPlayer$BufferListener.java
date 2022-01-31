package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Listener;
import com.tencent.qqmusic.mediaplayer.upstream.ListPlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;

class CommonPlayer$BufferListener
  implements CacheDataSource.Listener
{
  private CommonPlayer$BufferListener(CommonPlayer paramCommonPlayer) {}
  
  public void onBufferEnded()
  {
    AppMethodBeat.i(104690);
    Logger.i("CommonPlayer", CommonPlayer.access$700(this.this$0, "buffer ended."));
    AppMethodBeat.o(104690);
  }
  
  public void onBufferStarted(long paramLong)
  {
    AppMethodBeat.i(104689);
    Logger.i("CommonPlayer", CommonPlayer.access$700(this.this$0, "buffer started."));
    AppMethodBeat.o(104689);
  }
  
  public void onBytesTransferError(long paramLong1, long paramLong2, long paramLong3) {}
  
  public void onBytesTransferred(long paramLong1, long paramLong2) {}
  
  public void onBytesTransferring(long paramLong1, long paramLong2) {}
  
  public long onStreamingError(IOException paramIOException)
  {
    AppMethodBeat.i(104692);
    Logger.e("CommonPlayer", CommonPlayer.access$700(this.this$0, "streaming error!"), paramIOException);
    AppMethodBeat.o(104692);
    return -1L;
  }
  
  public void onStreamingFinished()
  {
    AppMethodBeat.i(104693);
    Logger.i("CommonPlayer", CommonPlayer.access$700(this.this$0, "streaming finished"));
    AppMethodBeat.o(104693);
  }
  
  public void onTransferEnd() {}
  
  public void onTransferStart() {}
  
  public void onUpStreamTransfer(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(104691);
    if ((this.this$0.getPlayerState() != 2) && (this.this$0.getPlayerState() != 4))
    {
      AppMethodBeat.o(104691);
      return;
    }
    int i = (int)Math.round(paramLong1 / paramLong2 * 100.0D);
    if (i == CommonPlayer.access$800(this.this$0))
    {
      AppMethodBeat.o(104691);
      return;
    }
    CommonPlayer.access$802(this.this$0, i);
    CommonPlayer.access$100(this.this$0).onBufferingUpdate(this.this$0, CommonPlayer.access$800(this.this$0));
    AppMethodBeat.o(104691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CommonPlayer.BufferListener
 * JD-Core Version:    0.7.0.1
 */