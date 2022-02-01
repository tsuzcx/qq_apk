package com.unionpay;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.unionpay.a.c;

final class d
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(207297);
    try
    {
      a.kky().sendEmptyMessageDelayed(1001, 800L);
      Object localObject = new c(a.kkz(), a.kkx());
      ((c)localObject).a();
      localObject = ((c)localObject).c;
      if (a.kky() != null)
      {
        Message localMessage = a.kky().obtainMessage();
        localMessage.what = 1002;
        localMessage.obj = localObject;
        a.kky().removeMessages(1001);
        a.kky().sendMessage(localMessage);
      }
      AppMethodBeat.o(207297);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(207297);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.d
 * JD-Core Version:    0.7.0.1
 */