package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;

class StaticDecodeDataComponent$1
  implements Runnable
{
  StaticDecodeDataComponent$1(StaticDecodeDataComponent paramStaticDecodeDataComponent) {}
  
  public void run()
  {
    if (this.this$0.getPlayerState() == 8)
    {
      Logger.w("StaticDecodeDataComponent", "[run] state changed to END during postRunnable!");
      return;
    }
    this.this$0.mCallback.playerPrepared(this.this$0.mCorePlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent.1
 * JD-Core Version:    0.7.0.1
 */