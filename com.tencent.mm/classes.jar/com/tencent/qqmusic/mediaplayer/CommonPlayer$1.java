package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.ListPlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.util.Logger;

class CommonPlayer$1
  implements PlayerCallback
{
  CommonPlayer$1(CommonPlayer paramCommonPlayer) {}
  
  public void playThreadStart(CorePlayer paramCorePlayer) {}
  
  public void playerEnded(CorePlayer paramCorePlayer)
  {
    AppMethodBeat.i(104806);
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerEnded() callback ended");
      this.this$0.TransferStateTo(7);
      CommonPlayer.access$100(this.this$0).onCompletion(this.this$0);
      AppMethodBeat.o(104806);
      return;
    }
    Logger.i("CommonPlayer", "different playerEnded");
    AppMethodBeat.o(104806);
  }
  
  public void playerException(CorePlayer paramCorePlayer, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(104805);
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.e("CommonPlayer", "playerException() callback exception what = " + paramInt1 + ",extra = " + paramInt2 + " mAudioPlayer:" + CommonPlayer.access$000(this.this$0));
      if (CommonPlayer.access$000(this.this$0) != null)
      {
        Logger.e("CommonPlayer", "handleMessage state = ".concat(String.valueOf(CommonPlayer.access$000(this.this$0).getPlayerState())));
        Logger.e("CommonPlayer", "handleMessage isInit = " + CommonPlayer.access$000(this.this$0).isInit() + ",isStartDecode = " + CommonPlayer.access$000(this.this$0).hasDecodeData() + ",decodeSuccess = " + CommonPlayer.access$000(this.this$0).hasDecodeDataSuccess());
      }
      CommonPlayer.access$200(this.this$0, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(104805);
      return;
    }
    Logger.i("CommonPlayer", "different playerException");
    AppMethodBeat.o(104805);
  }
  
  public void playerPaused(CorePlayer paramCorePlayer)
  {
    AppMethodBeat.i(104804);
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerPaused() callback paused");
      AppMethodBeat.o(104804);
      return;
    }
    Logger.i("CommonPlayer", "different playerPaused");
    AppMethodBeat.o(104804);
  }
  
  public void playerPrepared(CorePlayer paramCorePlayer)
  {
    AppMethodBeat.i(104800);
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerPrepared() callback prepared");
      this.this$0.TransferStateTo(2);
      CommonPlayer.access$100(this.this$0).onPrepared(this.this$0);
      AppMethodBeat.o(104800);
      return;
    }
    Logger.i("CommonPlayer", "different playerPrepared");
    AppMethodBeat.o(104800);
  }
  
  public void playerSeekCompletion(CorePlayer paramCorePlayer, int paramInt)
  {
    AppMethodBeat.i(104803);
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerSeekCompletion() callback seek completion");
      CommonPlayer.access$100(this.this$0).onSeekComplete(this.this$0, paramInt);
      AppMethodBeat.o(104803);
      return;
    }
    Logger.i("CommonPlayer", "different playerSeekCompletion");
    AppMethodBeat.o(104803);
  }
  
  public void playerStarted(CorePlayer paramCorePlayer)
  {
    AppMethodBeat.i(104802);
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerStarted() callback started");
      CommonPlayer.access$100(this.this$0).onStarted(this.this$0);
      AppMethodBeat.o(104802);
      return;
    }
    Logger.i("CommonPlayer", "different playerStarted");
    AppMethodBeat.o(104802);
  }
  
  public void playerStopped(CorePlayer paramCorePlayer)
  {
    AppMethodBeat.i(104801);
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerStopped() callback stopped");
      AppMethodBeat.o(104801);
      return;
    }
    Logger.i("CommonPlayer", "different playerStopped");
    AppMethodBeat.o(104801);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CommonPlayer.1
 * JD-Core Version:    0.7.0.1
 */