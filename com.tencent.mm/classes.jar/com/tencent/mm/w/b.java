package com.tencent.mm.w;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.k;

public abstract class b
{
  public k fTJ;
  private Handler handler;
  
  public abstract String acK();
  
  public final void f(final String paramString, final Object paramObject)
  {
    if (this.fTJ != null)
    {
      if (this.handler == null) {
        this.handler = new Handler(Looper.getMainLooper());
      }
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(159064);
          b.this.fTJ.a(b.this.acK() + ":" + paramString, paramObject, null);
          AppMethodBeat.o(159064);
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.w.b
 * JD-Core Version:    0.7.0.1
 */