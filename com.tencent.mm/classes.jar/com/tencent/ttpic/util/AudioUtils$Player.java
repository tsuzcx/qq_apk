package com.tencent.ttpic.util;

import android.media.MediaPlayer;

public class AudioUtils$Player
  extends MediaPlayer
{
  private boolean isPlaying;
  
  public boolean isPlaying()
  {
    return this.isPlaying;
  }
  
  public void pause()
  {
    if (!this.isPlaying) {
      return;
    }
    try
    {
      super.pause();
      this.isPlaying = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void release()
  {
    try
    {
      super.release();
      this.isPlaying = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void reset()
  {
    try
    {
      super.reset();
      this.isPlaying = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void start()
  {
    if (this.isPlaying) {
      return;
    }
    try
    {
      super.start();
      this.isPlaying = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void stop()
  {
    try
    {
      super.stop();
      this.isPlaying = false;
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.AudioUtils.Player
 * JD-Core Version:    0.7.0.1
 */