package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.upstream.ListPlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.util.Logger;

class CommonPlayer$1
  implements PlayerCallback
{
  CommonPlayer$1(CommonPlayer paramCommonPlayer) {}
  
  public void playThreadStart(CorePlayer paramCorePlayer) {}
  
  public void playerEnded(CorePlayer paramCorePlayer)
  {
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerEnded() callback ended");
      this.this$0.TransferStateTo(7);
      CommonPlayer.access$100(this.this$0).onCompletion(this.this$0);
      return;
    }
    Logger.i("CommonPlayer", "different playerEnded");
  }
  
  public void playerException(CorePlayer paramCorePlayer, int paramInt1, int paramInt2, int paramInt3)
  {
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.e("CommonPlayer", "playerException() callback exception what = " + paramInt1 + ",extra = " + paramInt2 + " mAudioPlayer:" + CommonPlayer.access$000(this.this$0));
      if (CommonPlayer.access$000(this.this$0) != null)
      {
        int i = CommonPlayer.access$000(this.this$0).getPlayerState();
        Logger.e("CommonPlayer", "handleMessage state = " + i);
        Logger.e("CommonPlayer", "handleMessage isInit = " + CommonPlayer.access$000(this.this$0).isInit() + ",isStartDecode = " + CommonPlayer.access$000(this.this$0).hasDecodeData() + ",decodeSuccess = " + CommonPlayer.access$000(this.this$0).hasDecodeDataSuccess());
      }
      CommonPlayer.access$200(this.this$0, paramInt1, paramInt2, paramInt3);
      return;
    }
    Logger.i("CommonPlayer", "different playerException");
  }
  
  public void playerPaused(CorePlayer paramCorePlayer)
  {
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerPaused() callback paused");
      return;
    }
    Logger.i("CommonPlayer", "different playerPaused");
  }
  
  public void playerPrepared(CorePlayer paramCorePlayer)
  {
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerPrepared() callback prepared");
      this.this$0.TransferStateTo(2);
      CommonPlayer.access$100(this.this$0).onPrepared(this.this$0);
      return;
    }
    Logger.i("CommonPlayer", "different playerPrepared");
  }
  
  public void playerSeekCompletion(CorePlayer paramCorePlayer, int paramInt)
  {
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerSeekCompletion() callback seek completion");
      CommonPlayer.access$100(this.this$0).onSeekComplete(this.this$0, paramInt);
      return;
    }
    Logger.i("CommonPlayer", "different playerSeekCompletion");
  }
  
  public void playerStarted(CorePlayer paramCorePlayer)
  {
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerStarted() callback started");
      CommonPlayer.access$100(this.this$0).onStarted(this.this$0);
      return;
    }
    Logger.i("CommonPlayer", "different playerStarted");
  }
  
  public void playerStopped(CorePlayer paramCorePlayer)
  {
    if (CommonPlayer.access$000(this.this$0) == paramCorePlayer)
    {
      Logger.i("CommonPlayer", "playerStopped() callback stopped");
      return;
    }
    Logger.i("CommonPlayer", "different playerStopped");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CommonPlayer.1
 * JD-Core Version:    0.7.0.1
 */