package com.tencent.thumbplayer.a.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.f;
import java.lang.ref.WeakReference;

final class c$a
  extends Handler
{
  private WeakReference<c> npK;
  
  public c$a(Looper paramLooper, c paramc)
  {
    super(paramLooper);
    AppMethodBeat.i(187697);
    this.npK = new WeakReference(paramc);
    AppMethodBeat.o(187697);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(187698);
    f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "EventHandler msg msg.what: " + paramMessage.what + ", value: " + paramMessage.what + ", arg1: " + paramMessage.arg1 + ", arg2: " + paramMessage.arg2);
    if ((c)this.npK.get() == null)
    {
      f.e("TPThumbPlayer[TPSystemMediaPlayer.java]", "mWeakRef is null");
      AppMethodBeat.o(187698);
      return;
    }
    int i = paramMessage.what;
    f.i("TPThumbPlayer[TPSystemMediaPlayer.java]", "eventHandler unknow msg");
    AppMethodBeat.o(187698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */