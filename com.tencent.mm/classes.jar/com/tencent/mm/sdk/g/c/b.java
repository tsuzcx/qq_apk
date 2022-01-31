package com.tencent.mm.sdk.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d.a;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

@Deprecated
public final class b
{
  private ThreadGroup cfU;
  private final AtomicInteger ytl;
  
  public b()
  {
    AppMethodBeat.i(52681);
    this.ytl = new AtomicInteger(1);
    this.cfU = new ThreadGroup("MM_FREE_THREAD_GROUP");
    AppMethodBeat.o(52681);
  }
  
  public final Thread newThread(Runnable paramRunnable, String paramString, int paramInt)
  {
    AppMethodBeat.i(52682);
    Assert.assertNotNull("newThread arg name is null!", paramString);
    if (paramRunnable != null)
    {
      paramRunnable = new a(paramRunnable, paramString, null, 0L, null, null, null);
      paramRunnable = new a(this.cfU, paramRunnable, "mmt_f".concat(String.valueOf(paramString)));
      paramRunnable.setPriority(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(52682);
      return paramRunnable;
      paramRunnable = new a(this.cfU, null, "mmt_f".concat(String.valueOf(paramString)));
      paramRunnable.setPriority(paramInt);
    }
  }
  
  static final class a
    extends Thread
  {
    private a ytm;
    
    a(ThreadGroup paramThreadGroup, a parama, String paramString)
    {
      super(parama, paramString);
      this.ytm = parama;
    }
    
    public final void run()
    {
      AppMethodBeat.i(52680);
      super.run();
      AppMethodBeat.o(52680);
    }
    
    public final void start()
    {
      AppMethodBeat.i(52679);
      super.start();
      AppMethodBeat.o(52679);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.g.c.b
 * JD-Core Version:    0.7.0.1
 */