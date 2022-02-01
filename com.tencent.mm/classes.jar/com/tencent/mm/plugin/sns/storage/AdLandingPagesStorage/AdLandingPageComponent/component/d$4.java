package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$4
  extends Handler
{
  d$4(d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(96424);
    if (paramMessage.what == 1)
    {
      this.ylX.W(((Boolean)paramMessage.obj).booleanValue());
      AppMethodBeat.o(96424);
      return;
    }
    if (paramMessage.what == 2) {
      this.ylX.X(((Boolean)paramMessage.obj).booleanValue());
    }
    AppMethodBeat.o(96424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.d.4
 * JD-Core Version:    0.7.0.1
 */