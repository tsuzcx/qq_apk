package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ai
  extends Handler
{
  ai(ah paramah, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(139194);
    if (paramMessage.what == 150) {
      ah.a(this.a);
    }
    AppMethodBeat.o(139194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.ai
 * JD-Core Version:    0.7.0.1
 */