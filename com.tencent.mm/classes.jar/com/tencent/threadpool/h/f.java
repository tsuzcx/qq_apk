package com.tencent.threadpool.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.i.k;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class f
  extends a
{
  a ahCi;
  
  public f()
  {
    AppMethodBeat.i(183372);
    this.ahCi = new a((byte)0);
    AppMethodBeat.o(183372);
  }
  
  protected final void ayG()
  {
    AppMethodBeat.i(183373);
    this.ahCi.mainHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(183373);
  }
  
  public final String getName()
  {
    return "UIPool";
  }
  
  public final void i(k<?> paramk)
  {
    AppMethodBeat.i(183374);
    this.ahCi.mainHandler.removeCallbacks(paramk);
    AppMethodBeat.o(183374);
  }
  
  protected final a.a jZr()
  {
    return this.ahCi;
  }
  
  final void m(k<?> paramk)
  {
    AppMethodBeat.i(226907);
    this.ahCi.n(paramk);
    AppMethodBeat.o(226907);
  }
  
  static final class a
    implements a.a
  {
    Handler mainHandler;
    
    private a()
    {
      AppMethodBeat.i(183370);
      this.mainHandler = new Handler(Looper.getMainLooper())
      {
        public final void dispatchMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(183368);
          if ((paramAnonymousMessage.getCallback() != null) && ((paramAnonymousMessage.getCallback() instanceof k)) && (((k)paramAnonymousMessage.getCallback()).isCancelled()))
          {
            AppMethodBeat.o(183368);
            return;
          }
          super.dispatchMessage(paramAnonymousMessage);
          AppMethodBeat.o(183368);
        }
      };
      AppMethodBeat.o(183370);
    }
    
    public final void h(k<?> paramk)
    {
      AppMethodBeat.i(183371);
      this.mainHandler.postDelayed(paramk, paramk.getDelay(TimeUnit.MILLISECONDS));
      AppMethodBeat.o(183371);
    }
    
    public final void n(k<?> paramk)
    {
      AppMethodBeat.i(226904);
      this.mainHandler.postAtFrontOfQueue(paramk);
      AppMethodBeat.o(226904);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.h.f
 * JD-Core Version:    0.7.0.1
 */