package com.tencent.xweb.xwalk;

import android.os.HandlerThread;
import android.os.Looper;

final class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public final void run()
  {
    if (this.xlK.xlG == null) {
      return;
    }
    XWAppBrandEngine localXWAppBrandEngine = this.xlK.xlG;
    localXWAppBrandEngine.nativeFinalize(localXWAppBrandEngine.mInstance);
    this.xlK.xlG = null;
    this.xlK.xlH.getLooper().quit();
    this.xlK.xlH = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.3
 * JD-Core Version:    0.7.0.1
 */