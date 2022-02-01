package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IJsRuntime;
import org.xwalk.core.XWalkV8;

public final class i
  implements IJsRuntime
{
  XWalkV8 MwP;
  private HandlerThread MwQ;
  private Handler MwR;
  
  public i()
  {
    AppMethodBeat.i(154293);
    this.MwQ = new HandlerThread("j2v8");
    this.MwQ.start();
    this.MwR = new Handler(this.MwQ.getLooper());
    AppMethodBeat.o(154293);
  }
  
  public final void init(final int paramInt)
  {
    AppMethodBeat.i(154294);
    this.MwR.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(154292);
        if (i.this.MwP != null)
        {
          AppMethodBeat.o(154292);
          return;
        }
        i.this.MwP = new XWalkV8();
        i.this.MwP.init(paramInt);
        AppMethodBeat.o(154292);
      }
    });
    AppMethodBeat.o(154294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.i
 * JD-Core Version:    0.7.0.1
 */