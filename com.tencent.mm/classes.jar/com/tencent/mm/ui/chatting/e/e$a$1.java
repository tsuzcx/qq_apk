package com.tencent.mm.ui.chatting.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class e$a$1
  implements d.b
{
  e$a$1(e.a parama, d.d paramd) {}
  
  public final void cN()
  {
    this.vys.vyr.c(this.vxV);
    e.a locala = this.vys;
    d.d locald = this.vxV;
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = locald;
    if ((locala.bZB) && (Looper.myLooper() == Looper.getMainLooper()))
    {
      e.d(locala.vyq).handleMessage(localMessage);
      return;
    }
    e.d(locala.vyq).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e.e.a.1
 * JD-Core Version:    0.7.0.1
 */