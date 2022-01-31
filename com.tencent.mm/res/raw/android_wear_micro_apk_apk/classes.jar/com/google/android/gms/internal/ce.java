package com.google.android.gms.internal;

import com.google.android.gms.common.internal.d;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class ce
  implements ThreadFactory
{
  private final String Qc;
  private final AtomicInteger Qd = new AtomicInteger();
  private final ThreadFactory Qe = Executors.defaultThreadFactory();
  private final int eK;
  
  public ce(String paramString)
  {
    this(paramString, (byte)0);
  }
  
  private ce(String paramString, byte paramByte)
  {
    this.Qc = ((String)d.e(paramString, "Name must not be null"));
    this.eK = 0;
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = this.Qe.newThread(new cf(paramRunnable, this.eK));
    String str = this.Qc;
    int i = this.Qd.getAndIncrement();
    paramRunnable.setName(String.valueOf(str).length() + 13 + str + "[" + i + "]");
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ce
 * JD-Core Version:    0.7.0.1
 */