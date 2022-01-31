package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class OpenGlRender$a
  extends ah
{
  public OpenGlRender$a(OpenGlRender paramOpenGlRender, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    this.qbv.requestRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlRender.a
 * JD-Core Version:    0.7.0.1
 */