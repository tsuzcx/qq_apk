package com.tencent.mm.sdk.b.d;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mm.sdk.b.a.e;
import com.tencent.mm.sdk.b.d;
import com.tencent.mm.sdk.b.h;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public final class a
  extends FutureTask<Runnable>
  implements b, Comparable<a>
{
  private static final String FORMAT;
  Runnable ZC;
  final String ZD;
  public long ZI;
  public long ZL;
  private long ZP;
  private final e aaH;
  public String aaI;
  private long abA;
  volatile boolean abB = true;
  final AtomicBoolean abC = new AtomicBoolean(false);
  com.tencent.mm.sdk.b.a.g abD;
  public Throwable abE;
  private Handler abF;
  final int priority;
  public long startTime;
  public int token;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskName=%s");
    localStringBuilder.append("|addTime=%d");
    localStringBuilder.append("|usedTime=%dms");
    localStringBuilder.append("|waitTime=%dms");
    localStringBuilder.append("|started=%b");
    localStringBuilder.append("|isAlive=%b");
    localStringBuilder.append("|loopTag=%s");
    FORMAT = localStringBuilder.toString();
  }
  
  public a(Runnable paramRunnable, String paramString1, String paramString2, long paramLong, e parame, com.tencent.mm.sdk.b.a.g paramg, Handler paramHandler)
  {
    super(paramRunnable, null);
    Assert.assertNotNull("FutureRunnable arg name is null!", paramString1);
    this.ZC = paramRunnable;
    this.ZD = paramString1;
    this.abA = paramLong;
    this.priority = 5;
    this.ZI = SystemClock.uptimeMillis();
    this.aaH = parame;
    this.abD = paramg;
    this.token = hashCode();
    this.aaI = paramString2;
    this.abF = paramHandler;
  }
  
  private void a(com.tencent.mm.sdk.b.g paramg)
  {
    if (this.abF != null) {
      this.abF.removeMessages(d.aaB, paramg);
    }
  }
  
  protected final void done()
  {
    super.done();
    try
    {
      if (!isCancelled()) {
        get();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      this.abE = localThrowable;
      if ((this.abE instanceof RuntimeException)) {
        throw ((RuntimeException)this.abE);
      }
      if ((this.abE instanceof Error)) {
        throw ((Error)this.abE);
      }
      throw new Error(this.abE);
    }
  }
  
  public final String getKey()
  {
    return this.ZD;
  }
  
  public final boolean isAlive()
  {
    return this.abB;
  }
  
  public final boolean isRunning()
  {
    return (this.abB) && (this.abC.get());
  }
  
  public final Runnable lW()
  {
    return this.ZC;
  }
  
  public final com.tencent.mm.sdk.b.g lX()
  {
    com.tencent.mm.sdk.b.g localg = new com.tencent.mm.sdk.b.g(this.ZD);
    if (!this.abB) {
      localg.aaL = h.aaQ;
    }
    for (;;)
    {
      localg.aaM = this.ZI;
      localg.startTime = this.startTime;
      localg.aaN = this.ZL;
      return localg;
      if (this.abC.get()) {
        localg.aaL = h.aaP;
      } else {
        localg.aaL = h.aaO;
      }
    }
  }
  
  public final void run()
  {
    if (!this.abC.compareAndSet(false, true)) {
      this.abB = false;
    }
    for (;;)
    {
      return;
      this.startTime = SystemClock.uptimeMillis();
      this.ZP = (this.startTime - this.ZI - this.abA);
      com.tencent.mm.sdk.b.g localg = lX();
      if ((this.abF != null) && (this.abD != null))
      {
        Message localMessage = new Message();
        localMessage.what = d.aaB;
        localMessage.obj = localg;
        this.abF.sendMessageDelayed(localMessage, this.abD.lL());
      }
      try
      {
        super.run();
        return;
      }
      finally
      {
        this.abB = false;
        this.ZL = (SystemClock.uptimeMillis() - this.startTime);
        a(localg);
        if (this.aaH != null) {
          this.aaH.a(this.ZC, this.token);
        }
      }
    }
  }
  
  public final String toString()
  {
    String str2 = FORMAT;
    String str3 = this.ZD;
    long l1 = this.ZI;
    long l2 = this.ZL;
    long l3 = this.ZP;
    boolean bool1 = this.abC.get();
    boolean bool2 = this.abB;
    String str4 = this.aaI;
    if (this.abE == null) {}
    for (String str1 = "";; str1 = "|throwable=" + this.abE) {
      return String.format(str2, new Object[] { str3, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Boolean.valueOf(bool1), Boolean.valueOf(bool2), str4, str1 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.d.a
 * JD-Core Version:    0.7.0.1
 */