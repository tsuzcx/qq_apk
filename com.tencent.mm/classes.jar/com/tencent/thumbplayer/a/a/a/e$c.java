package com.tencent.thumbplayer.a.a.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.g;

final class e$c
  implements Handler.Callback
{
  private Handler RXI;
  
  e$c(Handler paramHandler)
  {
    this.RXI = paramHandler;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(188852);
    try
    {
      this.RXI.handleMessage(paramMessage);
      AppMethodBeat.o(188852);
      return true;
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        g.e("TPSystemMediaPlayer", "mediaPlayerExceptionHook, HookCallback, " + Log.getStackTraceString(paramMessage));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.e.c
 * JD-Core Version:    0.7.0.1
 */