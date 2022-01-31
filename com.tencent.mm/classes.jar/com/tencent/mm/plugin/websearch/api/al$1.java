package com.tencent.mm.plugin.websearch.api;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class al$1
  implements Runnable
{
  al$1(al paramal, String paramString) {}
  
  public final void run()
  {
    y.i(this.qUL.TAG, "preload start");
    al.7 local7 = new al.7(this.qUL, this.val$url);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      local7.run();
      return;
    }
    ai.d(local7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.al.1
 * JD-Core Version:    0.7.0.1
 */