package com.tencent.thumbplayer.a.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.d;
import java.lang.ref.WeakReference;

final class c$a
  extends Handler
{
  private WeakReference<c> nWm;
  
  public c$a(Looper paramLooper, c paramc)
  {
    super(paramLooper);
    AppMethodBeat.i(194396);
    this.nWm = new WeakReference(paramc);
    AppMethodBeat.o(194396);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(194397);
    d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "EventHandler msg msg.what: " + paramMessage.what + ", value: " + paramMessage.what + ", arg1: " + paramMessage.arg1 + ", arg2: " + paramMessage.arg2);
    if ((c)this.nWm.get() == null)
    {
      d.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "mWeakRef is null");
      AppMethodBeat.o(194397);
      return;
    }
    int i = paramMessage.what;
    d.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "eventHandler unknow msg");
    AppMethodBeat.o(194397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */