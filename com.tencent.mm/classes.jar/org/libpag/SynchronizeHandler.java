package org.libpag;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SynchronizeHandler
  extends Handler
{
  public SynchronizeHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final boolean runSync(TimeoutRunnable paramTimeoutRunnable, long paramLong)
  {
    AppMethodBeat.i(187340);
    if (paramTimeoutRunnable == null)
    {
      paramTimeoutRunnable = new IllegalArgumentException("runnable must not be null");
      AppMethodBeat.o(187340);
      throw paramTimeoutRunnable;
    }
    if (paramLong < 0L)
    {
      paramTimeoutRunnable = new IllegalArgumentException("timeout must be non-negative");
      AppMethodBeat.o(187340);
      throw paramTimeoutRunnable;
    }
    if (Looper.myLooper() == getLooper())
    {
      paramTimeoutRunnable.run();
      AppMethodBeat.o(187340);
      return true;
    }
    boolean bool = new BlockingRunnable(paramTimeoutRunnable).postAndWait(this, paramLong);
    AppMethodBeat.o(187340);
    return bool;
  }
  
  static final class BlockingRunnable
    implements Runnable
  {
    private boolean isTimeout = false;
    private boolean mDone;
    private final SynchronizeHandler.TimeoutRunnable mTask;
    
    public BlockingRunnable(SynchronizeHandler.TimeoutRunnable paramTimeoutRunnable)
    {
      this.mTask = paramTimeoutRunnable;
    }
    
    public final boolean postAndWait(Handler paramHandler, long paramLong)
    {
      AppMethodBeat.i(187355);
      if (!paramHandler.post(this))
      {
        AppMethodBeat.o(187355);
        return false;
      }
      if (paramLong > 0L) {}
      try
      {
        long l1 = SystemClock.uptimeMillis();
        while (!this.mDone)
        {
          long l2 = l1 + paramLong - SystemClock.uptimeMillis();
          if (l2 <= 0L)
          {
            this.isTimeout = true;
            return false;
          }
          try
          {
            wait(l2);
          }
          catch (InterruptedException paramHandler) {}
          continue;
          for (;;)
          {
            boolean bool = this.mDone;
            if (bool) {
              break;
            }
            try
            {
              wait();
            }
            catch (InterruptedException paramHandler) {}
          }
        }
        return true;
      }
      finally
      {
        AppMethodBeat.o(187355);
      }
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 60
      //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 23	org/libpag/SynchronizeHandler$BlockingRunnable:mTask	Lorg/libpag/SynchronizeHandler$TimeoutRunnable;
      //   9: invokeinterface 64 1 0
      //   14: aload_0
      //   15: monitorenter
      //   16: aload_0
      //   17: iconst_1
      //   18: putfield 52	org/libpag/SynchronizeHandler$BlockingRunnable:mDone	Z
      //   21: aload_0
      //   22: invokevirtual 67	java/lang/Object:notifyAll	()V
      //   25: aload_0
      //   26: getfield 23	org/libpag/SynchronizeHandler$BlockingRunnable:mTask	Lorg/libpag/SynchronizeHandler$TimeoutRunnable;
      //   29: aload_0
      //   30: getfield 21	org/libpag/SynchronizeHandler$BlockingRunnable:isTimeout	Z
      //   33: invokeinterface 71 2 0
      //   38: aload_0
      //   39: monitorexit
      //   40: ldc 60
      //   42: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   45: return
      //   46: astore_1
      //   47: aload_0
      //   48: monitorexit
      //   49: ldc 60
      //   51: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   54: aload_1
      //   55: athrow
      //   56: astore_1
      //   57: aload_0
      //   58: monitorenter
      //   59: aload_0
      //   60: iconst_1
      //   61: putfield 52	org/libpag/SynchronizeHandler$BlockingRunnable:mDone	Z
      //   64: aload_0
      //   65: invokevirtual 67	java/lang/Object:notifyAll	()V
      //   68: aload_0
      //   69: getfield 23	org/libpag/SynchronizeHandler$BlockingRunnable:mTask	Lorg/libpag/SynchronizeHandler$TimeoutRunnable;
      //   72: aload_0
      //   73: getfield 21	org/libpag/SynchronizeHandler$BlockingRunnable:isTimeout	Z
      //   76: invokeinterface 71 2 0
      //   81: aload_0
      //   82: monitorexit
      //   83: ldc 60
      //   85: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   88: aload_1
      //   89: athrow
      //   90: astore_1
      //   91: aload_0
      //   92: monitorexit
      //   93: ldc 60
      //   95: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   98: aload_1
      //   99: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	100	0	this	BlockingRunnable
      //   46	9	1	localObject1	Object
      //   56	33	1	localObject2	Object
      //   90	9	1	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   16	40	46	finally
      //   5	14	56	finally
      //   59	83	90	finally
    }
  }
  
  static abstract interface TimeoutRunnable
    extends Runnable
  {
    public abstract void afterRun(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.libpag.SynchronizeHandler
 * JD-Core Version:    0.7.0.1
 */