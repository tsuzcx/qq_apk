package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class OpenGlRender$a
  extends ak
{
  public OpenGlRender$a(OpenGlRender paramOpenGlRender, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(5070);
    this.tHf.requestRender();
    AppMethodBeat.o(5070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlRender.a
 * JD-Core Version:    0.7.0.1
 */