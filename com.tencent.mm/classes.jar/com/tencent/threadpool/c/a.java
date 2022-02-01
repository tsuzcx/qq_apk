package com.tencent.threadpool.c;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.d;
import com.tencent.threadpool.d.f;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
{
  private static ConcurrentLinkedQueue<Long> ahBk;
  
  static
  {
    AppMethodBeat.i(183234);
    ahBk = new ConcurrentLinkedQueue();
    AppMethodBeat.o(183234);
  }
  
  public static int abd(int paramInt)
  {
    int i;
    if (paramInt <= 0) {
      i = 1;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt <= 10);
    return 10;
  }
  
  static HandlerThread ju(String paramString, int paramInt)
  {
    AppMethodBeat.i(183232);
    paramString = new HandlerThread("[GT]".concat(String.valueOf(paramString)))
    {
      public final void interrupt()
      {
        AppMethodBeat.i(183224);
        super.interrupt();
        d.ahAp.a(this, getName(), getId());
        AppMethodBeat.o(183224);
      }
      
      public final boolean quit()
      {
        AppMethodBeat.i(183222);
        d.ahAp.a(this, getName(), getId());
        boolean bool = super.quit();
        AppMethodBeat.o(183222);
        return bool;
      }
      
      public final boolean quitSafely()
      {
        AppMethodBeat.i(183223);
        d.ahAp.a(this, getName(), getId());
        boolean bool = super.quitSafely();
        AppMethodBeat.o(183223);
        return bool;
      }
      
      public final void start()
      {
        try
        {
          AppMethodBeat.i(183225);
          super.start();
          d.ahAp.b(this, getName(), getId());
          AppMethodBeat.o(183225);
          return;
        }
        finally
        {
          localObject = finally;
          throw localObject;
        }
      }
    };
    paramString.setPriority(abd(paramInt));
    AppMethodBeat.o(183232);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.c.a
 * JD-Core Version:    0.7.0.1
 */