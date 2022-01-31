package com.tencent.mm.ui.chatting.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.y;

final class e$1
  extends Handler
{
  e$1(e parame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (e.a(this.vyq))
    {
      y.w("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] cancel update!!!");
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (d.d)paramMessage.obj;
    paramMessage.vym = e.b(this.vyq).eb(paramMessage.vyk);
    e.c(this.vyq).a(paramMessage);
    y.i("MicroMsg.ChattingLoader.ListDataLoader", "[handleMessage] UPDATE!!! result:%s", new Object[] { paramMessage.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.e.1
 * JD-Core Version:    0.7.0.1
 */