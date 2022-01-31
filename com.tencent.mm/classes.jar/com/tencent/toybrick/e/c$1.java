package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.ui.ao;
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
    super.handleMessage(paramMessage);
    if (paramMessage.what == 2)
    {
      paramMessage = (c.c)paramMessage.obj;
      locala = (a)c.c.a(paramMessage).get();
      if ((locala != null) && (locala.xbN.hashCode() == c.c.b(paramMessage))) {
        c.c.d(paramMessage).t(locala, c.c.c(paramMessage));
      }
    }
    while (paramMessage.what != 3)
    {
      a locala;
      return;
      ao.u("[WhenHandler] has loaded! but not right,holder has changed!", new Object[0]);
      return;
    }
    paramMessage = (c.d)paramMessage.obj;
    c.d.c(paramMessage).e(c.d.a(paramMessage).get(), ((Boolean)c.d.b(paramMessage)).booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.toybrick.e.c.1
 * JD-Core Version:    0.7.0.1
 */