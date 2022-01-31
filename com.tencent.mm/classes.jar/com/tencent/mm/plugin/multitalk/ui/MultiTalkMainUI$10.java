package com.tencent.mm.plugin.multitalk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.plugin.multitalk.model.MultiTalkingForegroundService;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;

final class MultiTalkMainUI$10
  extends ak
{
  MultiTalkMainUI$10(MultiTalkMainUI paramMultiTalkMainUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(54127);
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(54127);
      return;
      if (!MultiTalkMainUI.c(this.oVe))
      {
        paramMessage = this.oVe;
        ab.i("MicroMsg.MT.MultiTalkMainUI", "bindVoiceServiceIfNeed");
        try
        {
          if (d.fv(26))
          {
            paramMessage.oUY = true;
            Intent localIntent = new Intent();
            localIntent.setClass(ah.getContext(), MultiTalkingForegroundService.class);
            ah.getContext().bindService(localIntent, paramMessage, 1);
          }
          AppMethodBeat.o(54127);
          return;
        }
        catch (Exception paramMessage)
        {
          ab.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", paramMessage, "bindVoiceServiceIfNeed error: %s", new Object[] { paramMessage.getMessage() });
          AppMethodBeat.o(54127);
          return;
        }
        ((a)g.G(a.class)).getNotification().cancel(43);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.10
 * JD-Core Version:    0.7.0.1
 */