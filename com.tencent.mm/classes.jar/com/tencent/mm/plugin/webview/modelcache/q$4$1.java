package com.tencent.mm.plugin.webview.modelcache;

import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.sdk.platformtools.ai;

final class q$4$1
  implements MessageQueue.IdleHandler
{
  q$4$1(q.4 param4) {}
  
  public final boolean queueIdle()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      this.rhI.rhH.mnU.getLooper().quitSafely();
    }
    for (;;)
    {
      return false;
      this.rhI.rhH.mnU.getLooper().quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.q.4.1
 * JD-Core Version:    0.7.0.1
 */