package com.tencent.threadpool.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.i.k;
import java.util.concurrent.Callable;

public final class e<E>
  extends k<E>
{
  a ahCM;
  public final a serial;
  
  public e(Runnable paramRunnable, long paramLong, String paramString, boolean paramBoolean)
  {
    super(paramRunnable, paramLong, paramBoolean);
    AppMethodBeat.i(183475);
    this.serial = a.bFX(paramString);
    AppMethodBeat.o(183475);
  }
  
  public e(Callable<E> paramCallable, long paramLong, String paramString, boolean paramBoolean)
  {
    super(paramCallable, paramLong, paramBoolean);
    AppMethodBeat.i(183476);
    this.serial = a.bFX(paramString);
    AppMethodBeat.o(183476);
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    AppMethodBeat.i(183478);
    if (super.cancel(paramBoolean))
    {
      if (this.ahCM != null) {
        this.ahCM.b(this);
      }
      AppMethodBeat.o(183478);
      return true;
    }
    AppMethodBeat.o(183478);
    return false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(183477);
    try
    {
      a.a(this.serial);
      super.run();
      return;
    }
    finally
    {
      a.a(null);
      if (this.ahCM != null) {
        this.ahCM.a(this.serial, this);
      }
      AppMethodBeat.o(183477);
    }
    AppMethodBeat.o(183477);
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama, e parame);
    
    public abstract void b(e parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.j.e
 * JD-Core Version:    0.7.0.1
 */