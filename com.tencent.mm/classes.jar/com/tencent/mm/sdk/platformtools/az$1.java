package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class az$1
  extends ak
{
  az$1(az paramaz, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(52232);
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      ((az.a)paramMessage.obj).acT();
    }
    AppMethodBeat.o(52232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.az.1
 * JD-Core Version:    0.7.0.1
 */