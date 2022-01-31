package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;
import com.tencent.toybrick.f.a;
import java.lang.ref.WeakReference;

final class c$1
  extends Handler
{
  c$1(c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(113234);
    super.handleMessage(paramMessage);
    if (paramMessage.what == 2)
    {
      paramMessage = (c.c)paramMessage.obj;
      a locala = (a)c.c.a(paramMessage).get();
      if ((locala != null) && (locala.Byt.hashCode() == c.c.b(paramMessage)))
      {
        c.c.d(paramMessage).E(locala, c.c.c(paramMessage));
        AppMethodBeat.o(113234);
        return;
      }
      ak.w("WhenHandler", "[WhenHandler] has loaded! but not right,holder has changed!", new Object[0]);
      AppMethodBeat.o(113234);
      return;
    }
    if (paramMessage.what == 3)
    {
      paramMessage = (c.d)paramMessage.obj;
      c.d.c(paramMessage).d(c.d.a(paramMessage).get(), ((Boolean)c.d.b(paramMessage)).booleanValue());
    }
    AppMethodBeat.o(113234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.toybrick.e.c.1
 * JD-Core Version:    0.7.0.1
 */