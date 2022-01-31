package com.tencent.mm.plugin.monitor;

import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.sdk.platformtools.y;

final class b$7
  implements Runnable
{
  b$7(b paramb) {}
  
  public final void run()
  {
    long l = Thread.currentThread().getId();
    String str = Thread.currentThread().getName();
    boolean bool;
    if ((WXHardCoderJNI.getCheckEnv()) && (WXHardCoderJNI.isRunning() > 0))
    {
      bool = true;
      y.i("MicroMsg.SubCoreBaseMonitor", "reportHardCoder tid[%d, %s] running[%b]", new Object[] { Long.valueOf(l), str, Boolean.valueOf(bool) });
      WXHardCoderJNI.reportIDKey(true, 0, 1, false);
      WXHardCoderJNI.readServerAddr(true);
      if ((!WXHardCoderJNI.getCheckEnv()) || (WXHardCoderJNI.isRunning() <= 0)) {
        break label117;
      }
      i = 4;
      label87:
      WXHardCoderJNI.reportIDKey(true, i, 1, false);
      if (!WXHardCoderJNI.isHCEnable()) {
        break label122;
      }
    }
    label117:
    label122:
    for (int i = 6;; i = 7)
    {
      WXHardCoderJNI.reportIDKey(true, i, 1, false);
      return;
      bool = false;
      break;
      i = 5;
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.b.7
 * JD-Core Version:    0.7.0.1
 */