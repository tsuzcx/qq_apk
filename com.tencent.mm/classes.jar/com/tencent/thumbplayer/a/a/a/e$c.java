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
  private Handler ahFv;
  
  e$c(Handler paramHandler)
  {
    this.ahFv = paramHandler;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(228637);
    try
    {
      this.ahFv.handleMessage(paramMessage);
      AppMethodBeat.o(228637);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.e.c
 * JD-Core Version:    0.7.0.1
 */