package com.tencent.xweb.xwalk;

import android.os.HandlerThread;
import android.os.Looper;
import org.xwalk.core.XWalkV8;

final class g$2
  implements Runnable
{
  g$2(g paramg) {}
  
  public final void run()
  {
    if (this.xlZ.xlX == null) {
      return;
    }
    this.xlZ.xlX.cleanup();
    this.xlZ.xlX = null;
    this.xlZ.xlH.getLooper().quit();
    this.xlZ.xlH = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.2
 * JD-Core Version:    0.7.0.1
 */