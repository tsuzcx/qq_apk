package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class cd
  implements Executor
{
  private final Handler mHandler;
  
  public cd(Looper paramLooper)
  {
    this.mHandler = new Handler(paramLooper);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    this.mHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.cd
 * JD-Core Version:    0.7.0.1
 */