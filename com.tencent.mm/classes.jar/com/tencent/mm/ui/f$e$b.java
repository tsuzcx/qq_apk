package com.tencent.mm.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class f$e$b
  extends ak
{
  boolean yVU;
  public final int yVV = 1;
  public final int yVW = 2;
  
  public f$e$b(f.e parame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(29178);
    super.handleMessage(paramMessage);
    if (this.yVU)
    {
      AppMethodBeat.o(29178);
      return;
    }
    synchronized (this.yVT)
    {
      this.yVT.yVR = this.yVT.dBl();
      ab.i(this.yVT.yVK.TAG, "newcursor updateWorkerRefresh status %d", new Object[] { Integer.valueOf(this.yVT.yVR) });
      if (paramMessage.what == 1)
      {
        f.d(this.yVT.yVK);
        AppMethodBeat.o(29178);
        return;
      }
    }
    if (paramMessage.what == 2) {
      f.a(this.yVT.yVK, (f.c)paramMessage.obj, false, true);
    }
    AppMethodBeat.o(29178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.f.e.b
 * JD-Core Version:    0.7.0.1
 */