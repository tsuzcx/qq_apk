package com.tencent.mm.sdk.f;

import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

final class b
{
  private ThreadGroup eqG;
  private final AtomicInteger ukc = new AtomicInteger(1);
  private e.b ukd;
  
  b(e.b paramb)
  {
    this.ukd = paramb;
    this.eqG = new ThreadGroup("MM_FREE_THREAD_GROUP");
  }
  
  final Thread newThread(Runnable paramRunnable, String paramString, int paramInt)
  {
    Assert.assertNotNull("newThread arg name is null!", paramString);
    if (paramRunnable != null)
    {
      paramRunnable = new g(paramRunnable, paramString, paramInt, false, this.ukd);
      paramRunnable = new a(this.eqG, paramRunnable, "mmt_f" + paramString);
      paramRunnable.setPriority(paramInt);
      return paramRunnable;
    }
    paramRunnable = new a(this.eqG, null, "mmt_f" + paramString);
    paramRunnable.setPriority(paramInt);
    return paramRunnable;
  }
  
  static final class a
    extends Thread
  {
    private g uke;
    
    a(ThreadGroup paramThreadGroup, g paramg, String paramString)
    {
      super(paramg, paramString);
      this.uke = paramg;
    }
    
    public final void run()
    {
      super.run();
    }
    
    public final void start()
    {
      super.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.f.b
 * JD-Core Version:    0.7.0.1
 */