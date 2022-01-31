package com.tencent.mm.plugin.webview.ui.tools.preload;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;

final class e$1$1
  implements MessageQueue.IdleHandler
{
  e$1$1(e.1 param1) {}
  
  public final boolean queueIdle()
  {
    Looper.myQueue().removeIdleHandler(this);
    e.d(this.rBx.rBw);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.e.1.1
 * JD-Core Version:    0.7.0.1
 */