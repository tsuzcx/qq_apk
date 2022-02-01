package com.google.android.gms.internal;

import android.os.Process;

final class cf
  implements Runnable
{
  private final Runnable RU;
  private final int gz;
  
  public cf(Runnable paramRunnable, int paramInt)
  {
    this.RU = paramRunnable;
    this.gz = paramInt;
  }
  
  public final void run()
  {
    Process.setThreadPriority(this.gz);
    this.RU.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.cf
 * JD-Core Version:    0.7.0.1
 */