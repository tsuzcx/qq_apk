package com.tencent.tav.player;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public abstract interface IPlayer
{
  public abstract IPlayer.PlayerStatus currentStatus();
  
  public abstract CMTime duration();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract CMTime position();
  
  public abstract void release();
  
  public abstract void release(Runnable paramRunnable);
  
  public abstract void seekToTime(CMTime paramCMTime, Callback paramCallback);
  
  public abstract void setLoop(boolean paramBoolean);
  
  public abstract void setOnCompositionUpdateListener(OnCompositionUpdateListener paramOnCompositionUpdateListener);
  
  public abstract void setPlayRange(CMTimeRange paramCMTimeRange);
  
  public abstract void setPlayerListener(IPlayer.PlayerListener paramPlayerListener);
  
  public abstract void setVolume(float paramFloat);
  
  public abstract void stop();
  
  public abstract void update(PlayerItem paramPlayerItem, CMTime paramCMTime);
  
  public abstract void updateAudioClipsProperties();
  
  public abstract void updateAudioVolumeProperties();
  
  public abstract int videoHeight();
  
  public abstract int videoWidth();
  
  public abstract void waitForRelease(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tav.player.IPlayer
 * JD-Core Version:    0.7.0.1
 */