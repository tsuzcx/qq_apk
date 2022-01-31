package com.tencent.mm.plugin.scanner.util;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class ScanCameraLightDetector$1
  extends ah
{
  public ScanCameraLightDetector$1(ScanCameraLightDetector paramScanCameraLightDetector, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 233)
    {
      paramMessage = (ScanCameraLightDetector.a)paramMessage.obj;
      if (paramMessage != null)
      {
        long l = bk.UZ();
        boolean bool = ScanCameraLightDetector.t(paramMessage.mip, paramMessage.width, paramMessage.height);
        y.i("MicroMsg.ScanCameraLightDetector", "isYuvDark: %s, currentLight: %s, used %sms", new Object[] { Boolean.valueOf(bool), Float.valueOf(ScanCameraLightDetector.a(this.nPl)), Long.valueOf(bk.cp(l)) });
        if (!bool) {
          break label109;
        }
        y.i("MicroMsg.ScanCameraLightDetector", "is dark now");
        ai.d(new ScanCameraLightDetector.1.1(this));
      }
    }
    return;
    label109:
    y.i("MicroMsg.ScanCameraLightDetector", "not dark");
    ai.d(new ScanCameraLightDetector.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector.1
 * JD-Core Version:    0.7.0.1
 */