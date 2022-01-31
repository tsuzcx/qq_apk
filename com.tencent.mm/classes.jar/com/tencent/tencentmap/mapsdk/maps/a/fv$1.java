package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

class fv$1
  implements Executor
{
  fv$1(fv paramfv, Handler paramHandler) {}
  
  public void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(147964);
    this.a.post(paramRunnable);
    AppMethodBeat.o(147964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fv.1
 * JD-Core Version:    0.7.0.1
 */