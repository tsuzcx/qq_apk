package com.tencent.mm.ui.chatting.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.atomic.AtomicBoolean;

final class e$1
  extends Handler
{
  e$1(e parame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(32485);
    if (e.a(this.zOM).get())
    {
      ab.w("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] cancel update!!!");
      AppMethodBeat.o(32485);
      return;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(32485);
      return;
      paramMessage = (d.d)paramMessage.obj;
      paramMessage.zOH = e.b(this.zOM).fl(paramMessage.zOF);
      e.c(this.zOM).a(paramMessage);
      ab.i("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] UPDATE!!! result:%s", new Object[] { paramMessage.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.e.1
 * JD-Core Version:    0.7.0.1
 */