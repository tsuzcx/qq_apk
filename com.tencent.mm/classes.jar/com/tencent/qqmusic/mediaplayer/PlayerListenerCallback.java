package com.tencent.qqmusic.mediaplayer;

public abstract interface PlayerListenerCallback
{
  public abstract void onBufferingUpdate(BaseMediaPlayer paramBaseMediaPlayer, int paramInt);
  
  public abstract void onCompletion(BaseMediaPlayer paramBaseMediaPlayer);
  
  public abstract void onError(BaseMediaPlayer paramBaseMediaPlayer, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onPrepared(BaseMediaPlayer paramBaseMediaPlayer);
  
  public abstract void onSeekComplete(BaseMediaPlayer paramBaseMediaPlayer, int paramInt);
  
  public abstract void onStarted(BaseMediaPlayer paramBaseMediaPlayer);
  
  public abstract void onStateChanged(BaseMediaPlayer paramBaseMediaPlayer, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
 * JD-Core Version:    0.7.0.1
 */