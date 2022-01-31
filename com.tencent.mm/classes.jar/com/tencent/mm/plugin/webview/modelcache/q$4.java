package com.tencent.mm.plugin.webview.modelcache;

import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.mm.sdk.platformtools.ai;

final class q$4
  implements Runnable
{
  q$4(q paramq, ai paramai) {}
  
  public final void run()
  {
    Looper.myQueue().addIdleHandler(new q.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.q.4
 * JD-Core Version:    0.7.0.1
 */