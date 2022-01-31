package com.tencent.mm.pluginsdk.i;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class b$a
  extends Handler
{
  int ghE = 0;
  boolean mgx = false;
  
  public b$a(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(8)
  public final void handleMessage(Message paramMessage)
  {
    Camera localCamera = (Camera)paramMessage.obj;
    Camera.Parameters localParameters = localCamera.getParameters();
    int i = localParameters.getZoom() + this.ghE;
    if (this.mgx) {
      if (i >= localParameters.getMaxZoom() / 2) {
        i = localParameters.getMaxZoom() / 2;
      }
    }
    for (;;)
    {
      localParameters.setZoom(i);
      localCamera.setParameters(localParameters);
      return;
      sendMessageDelayed(Message.obtain(this, 4353, 0, 0, paramMessage.obj), 20L);
      continue;
      if (i <= 0) {
        i = 0;
      } else {
        sendMessageDelayed(Message.obtain(this, 4353, 0, 0, paramMessage.obj), 20L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.b.a
 * JD-Core Version:    0.7.0.1
 */