package com.tencent.mm.sdk.thread;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.thread.api.IThreadPool;

@Deprecated
public class ThreadPool
  implements IThreadPool
{
  public static final ThreadPool INSTANCE;
  public static final String TAG = "MicroMsg.ThreadPool";
  
  static
  {
    AppMethodBeat.i(158155);
    if (!ThreadPool.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      INSTANCE = new ThreadPool();
      AppMethodBeat.o(158155);
      return;
    }
  }
  
  public ThreadPool()
  {
    AppMethodBeat.i(158135);
    AppMethodBeat.o(158135);
  }
  
  @Deprecated
  public static void post(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(158143);
    INSTANCE.adapterPost(paramRunnable, paramString);
    AppMethodBeat.o(158143);
  }
  
  @Deprecated
  public static void post(Runnable paramRunnable, String paramString, int paramInt)
  {
    AppMethodBeat.i(230537);
    INSTANCE.adapterPost(paramRunnable, paramString);
    AppMethodBeat.o(230537);
  }
  
  @Deprecated
  public static void postAtFront(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(158145);
    INSTANCE.adapterPost(paramRunnable, paramString);
    AppMethodBeat.o(158145);
  }
  
  @Deprecated
  public void adapterPost(final Runnable paramRunnable, final String paramString)
  {
    AppMethodBeat.i(158142);
    if ((!$assertionsDisabled) && (paramRunnable == null))
    {
      paramRunnable = new AssertionError();
      AppMethodBeat.o(158142);
      throw paramRunnable;
    }
    com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
    {
      public String getKey()
      {
        return paramString;
      }
      
      public void run()
      {
        AppMethodBeat.i(158103);
        paramRunnable.run();
        AppMethodBeat.o(158103);
      }
    });
    AppMethodBeat.o(158142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.thread.ThreadPool
 * JD-Core Version:    0.7.0.1
 */