package com.tencent.wework.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;

class WWAPIImpl$2
  extends BroadcastReceiver
{
  WWAPIImpl$2(WWAPIImpl paramWWAPIImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(140105);
    try
    {
      boolean bool = WWAPIImpl.a(this.BCG).equals(paramIntent.getScheme());
      if (!bool)
      {
        AppMethodBeat.o(140105);
        return;
      }
      paramContext = BaseMessage.q(paramIntent.getData());
      if ((paramContext instanceof WWBaseRespMessage)) {
        new Handler(Looper.getMainLooper()).post(new WWAPIImpl.2.1(this, paramContext));
      }
      AppMethodBeat.o(140105);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(140105);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIImpl.2
 * JD-Core Version:    0.7.0.1
 */