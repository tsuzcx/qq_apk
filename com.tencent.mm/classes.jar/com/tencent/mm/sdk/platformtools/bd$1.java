package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class bd$1
  extends ao
{
  bd$1(bd parambd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(157792);
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      ((bd.a)paramMessage.obj).aBk();
    }
    AppMethodBeat.o(157792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bd.1
 * JD-Core Version:    0.7.0.1
 */