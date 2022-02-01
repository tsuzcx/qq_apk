package com.tencent.mm.plugin.multitalk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.multitalk.model.MultiTalkingForegroundService;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class MultiTalkMainUI$3
  extends MMHandler
{
  MultiTalkMainUI$3(MultiTalkMainUI paramMultiTalkMainUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(199993);
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(199993);
      return;
      if (!MultiTalkMainUI.d(this.Fvz))
      {
        paramMessage = this.Fvz;
        Log.i("MicroMsg.MT.MultiTalkMainUI", "bindVoiceServiceIfNeed");
        try
        {
          if (d.qV(26))
          {
            paramMessage.Fvn = true;
            Intent localIntent = new Intent();
            localIntent.setClass(MMApplicationContext.getContext(), MultiTalkingForegroundService.class);
            MMApplicationContext.getContext().bindService(localIntent, paramMessage, 1);
          }
          AppMethodBeat.o(199993);
          return;
        }
        catch (Exception paramMessage)
        {
          Log.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", paramMessage, "bindVoiceServiceIfNeed error: %s", new Object[] { paramMessage.getMessage() });
          AppMethodBeat.o(199993);
          return;
        }
        ((a)h.ag(a.class)).getNotification().cancel(43);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.3
 * JD-Core Version:    0.7.0.1
 */