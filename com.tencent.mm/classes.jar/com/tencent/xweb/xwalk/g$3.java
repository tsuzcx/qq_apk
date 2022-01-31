package com.tencent.xweb.xwalk;

import android.webkit.ValueCallback;
import org.xwalk.core.XWalkV8;

final class g$3
  implements Runnable
{
  g$3(g paramg, String paramString, ValueCallback paramValueCallback) {}
  
  public final void run()
  {
    if (this.xlZ.xlX == null) {
      return;
    }
    this.xlZ.xlX.evaluateJavascript(this.xlL, this.xlM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.3
 * JD-Core Version:    0.7.0.1
 */