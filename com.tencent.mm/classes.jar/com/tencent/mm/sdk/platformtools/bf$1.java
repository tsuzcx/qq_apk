package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class bf$1
  extends aq
{
  bf$1(bf parambf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(157792);
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      ((bf.a)paramMessage.obj).aED();
    }
    AppMethodBeat.o(157792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bf.1
 * JD-Core Version:    0.7.0.1
 */