package com.tencent.tav.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public abstract interface IPlayer
{
  public abstract PlayerStatus currentStatus();
  
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
  
  public static enum PlayerStatus
  {
    static
    {
      AppMethodBeat.i(192541);
      IDLE = new PlayerStatus("IDLE", 0);
      READY = new PlayerStatus("READY", 1);
      PLAYING = new PlayerStatus("PLAYING", 2);
      STOPPED = new PlayerStatus("STOPPED", 3);
      PAUSED = new PlayerStatus("PAUSED", 4);
      FINISHED = new PlayerStatus("FINISHED", 5);
      ERROR = new PlayerStatus("ERROR", 6);
      REPLAY = new PlayerStatus("REPLAY", 7);
      $VALUES = new PlayerStatus[] { IDLE, READY, PLAYING, STOPPED, PAUSED, FINISHED, ERROR, REPLAY };
      AppMethodBeat.o(192541);
    }
    
    private PlayerStatus() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tav.player.IPlayer
 * JD-Core Version:    0.7.0.1
 */