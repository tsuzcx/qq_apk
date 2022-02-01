package com.tencent.qqmusic.mediaplayer.audiofx;

import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.BufferInfo;
import com.tencent.qqmusic.mediaplayer.FloatBufferInfo;

public abstract interface IAudioListener
{
  public abstract long getActualTime(long paramLong);
  
  public abstract boolean isEnabled();
  
  public abstract boolean isTerminal();
  
  public abstract boolean onPcm(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong);
  
  public abstract boolean onPcm(FloatBufferInfo paramFloatBufferInfo1, FloatBufferInfo paramFloatBufferInfo2, long paramLong);
  
  public abstract long onPlayerReady(int paramInt, AudioInformation paramAudioInformation, long paramLong);
  
  public abstract void onPlayerSeekComplete(long paramLong);
  
  public abstract void onPlayerStopped();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener
 * JD-Core Version:    0.7.0.1
 */