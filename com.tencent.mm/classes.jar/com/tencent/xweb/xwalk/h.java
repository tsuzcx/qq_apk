package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.IJsRuntime;
import org.xwalk.core.XWalkV8;

public final class h
  implements IJsRuntime
{
  XWalkV8 ITN;
  private HandlerThread ITO;
  private Handler ITP;
  
  public h()
  {
    AppMethodBeat.i(154293);
    this.ITO = new HandlerThread("j2v8");
    this.ITO.start();
    this.ITP = new Handler(this.ITO.getLooper());
    AppMethodBeat.o(154293);
  }
  
  public final void init(final int paramInt)
  {
    AppMethodBeat.i(154294);
    this.ITP.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(154292);
        if (h.this.ITN != null)
        {
          AppMethodBeat.o(154292);
          return;
        }
        h.this.ITN = new XWalkV8();
        h.this.ITN.init(paramInt);
        AppMethodBeat.o(154292);
      }
    });
    AppMethodBeat.o(154294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.h
 * JD-Core Version:    0.7.0.1
 */