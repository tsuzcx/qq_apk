package com.google.android.gms.internal;

import com.google.android.gms.common.internal.d;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class ce
  implements ThreadFactory
{
  private final String RR;
  private final AtomicInteger RS = new AtomicInteger();
  private final ThreadFactory RT = Executors.defaultThreadFactory();
  private final int gz;
  
  public ce(String paramString)
  {
    this(paramString, (byte)0);
  }
  
  private ce(String paramString, byte paramByte)
  {
    this.RR = ((String)d.g(paramString, "Name must not be null"));
    this.gz = 0;
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = this.RT.newThread(new cf(paramRunnable, this.gz));
    String str = this.RR;
    int i = this.RS.getAndIncrement();
    paramRunnable.setName(String.valueOf(str).length() + 13 + str + "[" + i + "]");
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ce
 * JD-Core Version:    0.7.0.1
 */