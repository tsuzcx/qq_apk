package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IJsRuntime;
import org.xwalk.core.XWalkV8;

public final class i
  implements IJsRuntime
{
  XWalkV8 SHa;
  private HandlerThread SHb;
  private Handler SHc;
  
  public i()
  {
    AppMethodBeat.i(154293);
    this.SHb = new HandlerThread("j2v8");
    this.SHb.start();
    this.SHc = new Handler(this.SHb.getLooper());
    AppMethodBeat.o(154293);
  }
  
  public final void init(final int paramInt)
  {
    AppMethodBeat.i(154294);
    this.SHc.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(154292);
        if (i.this.SHa != null)
        {
          AppMethodBeat.o(154292);
          return;
        }
        i.this.SHa = new XWalkV8();
        i.this.SHa.init(paramInt);
        AppMethodBeat.o(154292);
      }
    });
    AppMethodBeat.o(154294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.i
 * JD-Core Version:    0.7.0.1
 */