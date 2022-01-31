package com.tencent.mm.sdk.g.d;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.f;
import com.tencent.mm.sdk.g.e;
import com.tencent.mm.sdk.g.e.a;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public final class a
  extends FutureTask<Runnable>
  implements b, Comparable<a>
{
  private static final String FORMAT;
  public volatile boolean bRn;
  public long cgd;
  private long cps;
  public final String eMp;
  public long fpw;
  final int priority;
  public long startTime;
  public int token;
  private long waitTime;
  public Runnable yol;
  public String ysA;
  private final com.tencent.mm.sdk.g.a.d ysz;
  final AtomicBoolean ytt;
  f ytu;
  public Throwable ytv;
  private Handler ytw;
  
  static
  {
    AppMethodBeat.i(52711);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskName=%s");
    localStringBuilder.append("|addTime=%d");
    localStringBuilder.append("|usedTime=%dms");
    localStringBuilder.append("|waitTime=%dms");
    localStringBuilder.append("|started=%b");
    localStringBuilder.append("|isAlive=%b");
    localStringBuilder.append("|loopTag=%s");
    FORMAT = localStringBuilder.toString();
    AppMethodBeat.o(52711);
  }
  
  public a(Runnable paramRunnable, String paramString1, String paramString2, long paramLong, com.tencent.mm.sdk.g.a.d paramd, f paramf, Handler paramHandler)
  {
    super(paramRunnable, null);
    AppMethodBeat.i(52702);
    this.bRn = true;
    this.ytt = new AtomicBoolean(false);
    Assert.assertNotNull("FutureRunnable arg name is null!", paramString1);
    this.yol = paramRunnable;
    this.eMp = paramString1;
    this.cps = paramLong;
    this.priority = 5;
    this.cgd = SystemClock.uptimeMillis();
    this.ysz = paramd;
    this.ytu = paramf;
    this.token = hashCode();
    this.ysA = paramString2;
    this.ytw = paramHandler;
    AppMethodBeat.o(52702);
  }
  
  private void f(e parame)
  {
    AppMethodBeat.i(52705);
    if (this.ytw != null) {
      this.ytw.removeMessages(com.tencent.mm.sdk.g.d.yst, parame);
    }
    AppMethodBeat.o(52705);
  }
  
  protected final void done()
  {
    AppMethodBeat.i(52704);
    super.done();
    try
    {
      if (!isCancelled()) {
        get();
      }
      AppMethodBeat.o(52704);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.ytv = localThrowable;
      if ((this.ytv instanceof RuntimeException))
      {
        localObject = (RuntimeException)this.ytv;
        AppMethodBeat.o(52704);
        throw ((Throwable)localObject);
      }
      if ((this.ytv instanceof Error))
      {
        localObject = (Error)this.ytv;
        AppMethodBeat.o(52704);
        throw ((Throwable)localObject);
      }
      Object localObject = new Error(this.ytv);
      AppMethodBeat.o(52704);
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean duK()
  {
    AppMethodBeat.i(52707);
    if (this.ytt.compareAndSet(false, true))
    {
      this.bRn = false;
      AppMethodBeat.o(52707);
      return true;
    }
    AppMethodBeat.o(52707);
    return false;
  }
  
  public final e duL()
  {
    AppMethodBeat.i(52709);
    e locale = new e(this.eMp);
    if (!this.bRn) {
      locale.ysD = e.a.ysH;
    }
    for (;;)
    {
      locale.ysE = this.cgd;
      locale.startTime = this.startTime;
      locale.iHc = this.fpw;
      AppMethodBeat.o(52709);
      return locale;
      if (this.ytt.get()) {
        locale.ysD = e.a.ysG;
      } else {
        locale.ysD = e.a.ysF;
      }
    }
  }
  
  public final String getKey()
  {
    return this.eMp;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(52706);
    if ((this.bRn) && (this.ytt.get()))
    {
      AppMethodBeat.o(52706);
      return true;
    }
    AppMethodBeat.o(52706);
    return false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(52703);
    if (!this.ytt.compareAndSet(false, true))
    {
      this.bRn = false;
      AppMethodBeat.o(52703);
      return;
    }
    this.startTime = SystemClock.uptimeMillis();
    this.waitTime = (this.startTime - this.cgd - this.cps);
    if (this.ysz != null) {
      this.ysz.a(this.yol, this.token);
    }
    e locale = duL();
    if ((this.ytw != null) && (this.ytu != null))
    {
      Message localMessage = new Message();
      localMessage.what = com.tencent.mm.sdk.g.d.yst;
      localMessage.obj = locale;
      this.ytw.sendMessageDelayed(localMessage, 1800000L);
    }
    try
    {
      super.run();
      return;
    }
    finally
    {
      this.bRn = false;
      this.fpw = (SystemClock.uptimeMillis() - this.startTime);
      f(locale);
      if (this.ytu != null) {
        this.ytu.E(this.eMp, this.fpw, this.waitTime);
      }
      if (this.ysz != null) {
        this.ysz.b(this.yol, this.token);
      }
      AppMethodBeat.o(52703);
    }
    AppMethodBeat.o(52703);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(52708);
    String str2 = FORMAT;
    String str3 = this.eMp;
    long l1 = this.cgd;
    long l2 = this.fpw;
    long l3 = this.waitTime;
    boolean bool1 = this.ytt.get();
    boolean bool2 = this.bRn;
    String str4 = this.ysA;
    if (this.ytv == null) {}
    for (String str1 = "";; str1 = "|throwable=" + this.ytv)
    {
      str1 = String.format(str2, new Object[] { str3, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Boolean.valueOf(bool1), Boolean.valueOf(bool2), str4, str1 });
      AppMethodBeat.o(52708);
      return str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.g.d.a
 * JD-Core Version:    0.7.0.1
 */