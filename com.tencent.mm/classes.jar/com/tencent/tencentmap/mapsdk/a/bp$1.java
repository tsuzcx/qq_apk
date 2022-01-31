package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

class bp$1
  extends Handler
{
  bp$1(bp parambp, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(149917);
    if ((paramMessage != null) && (paramMessage.what == 0))
    {
      if (bp.a(this.a) != null)
      {
        paramMessage = (Bitmap)paramMessage.obj;
        bp.a(this.a).a(paramMessage);
      }
      bp.a(this.a, null);
    }
    AppMethodBeat.o(149917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bp.1
 * JD-Core Version:    0.7.0.1
 */