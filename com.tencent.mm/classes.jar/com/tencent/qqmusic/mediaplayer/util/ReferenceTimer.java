package com.tencent.qqmusic.mediaplayer.util;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicLong;

public class ReferenceTimer
{
  private static final String TAG = "ReferenceTimer";
  private AtomicLong mBaseTime;
  
  public ReferenceTimer()
  {
    AppMethodBeat.i(128378);
    this.mBaseTime = new AtomicLong();
    AppMethodBeat.o(128378);
  }
  
  public long getTimeInMs()
  {
    AppMethodBeat.i(128380);
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.mBaseTime.get();
    AppMethodBeat.o(128380);
    return l1 - l2;
  }
  
  public void refreshTimeInMs(long paramLong)
  {
    AppMethodBeat.i(128381);
    this.mBaseTime.set(SystemClock.uptimeMillis());
    this.mBaseTime.addAndGet(-paramLong);
    AppMethodBeat.o(128381);
  }
  
  public void restart()
  {
    AppMethodBeat.i(128379);
    this.mBaseTime.set(SystemClock.uptimeMillis());
    AppMethodBeat.o(128379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.ReferenceTimer
 * JD-Core Version:    0.7.0.1
 */