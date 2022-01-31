package com.tencent.mm.plugin.notification.a;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;

final class a$1
  extends ak
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(23094);
    super.handleMessage(paramMessage);
    paramMessage = paramMessage.getData().getString("com.tencent.mm.notification.observer");
    aw.RO().o(new a.1.1(this, paramMessage), 500L);
    AppMethodBeat.o(23094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.a.a.1
 * JD-Core Version:    0.7.0.1
 */