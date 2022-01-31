package com.tencent.qqmusic.mediaplayer.util;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicLong;

public class ReferenceTimer
{
  private static final String TAG = "ReferenceTimer";
  private AtomicLong mBaseTime = new AtomicLong();
  
  public long getTimeInMs()
  {
    return SystemClock.uptimeMillis() - this.mBaseTime.get();
  }
  
  public void refreshTimeInMs(long paramLong)
  {
    this.mBaseTime.set(SystemClock.uptimeMillis());
    this.mBaseTime.addAndGet(-paramLong);
  }
  
  public void restart()
  {
    this.mBaseTime.set(SystemClock.uptimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.ReferenceTimer
 * JD-Core Version:    0.7.0.1
 */