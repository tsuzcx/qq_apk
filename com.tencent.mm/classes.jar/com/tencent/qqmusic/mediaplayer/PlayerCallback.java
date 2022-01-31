package com.tencent.qqmusic.mediaplayer;

abstract interface PlayerCallback
{
  public abstract void playThreadStart(CorePlayer paramCorePlayer);
  
  public abstract void playerEnded(CorePlayer paramCorePlayer);
  
  public abstract void playerException(CorePlayer paramCorePlayer, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void playerPaused(CorePlayer paramCorePlayer);
  
  public abstract void playerPrepared(CorePlayer paramCorePlayer);
  
  public abstract void playerSeekCompletion(CorePlayer paramCorePlayer, int paramInt);
  
  public abstract void playerStarted(CorePlayer paramCorePlayer);
  
  public abstract void playerStopped(CorePlayer paramCorePlayer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.PlayerCallback
 * JD-Core Version:    0.7.0.1
 */