package com.tencent.mm.plugin.multitalk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.multitalk.model.MultiTalkingForegroundService;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;

final class MultiTalkMainUI$10
  extends ao
{
  MultiTalkMainUI$10(MultiTalkMainUI paramMultiTalkMainUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(114661);
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(114661);
      return;
      if (!MultiTalkMainUI.c(this.uYZ))
      {
        paramMessage = this.uYZ;
        ac.i("MicroMsg.MT.MultiTalkMainUI", "bindVoiceServiceIfNeed");
        try
        {
          if (d.kZ(26))
          {
            paramMessage.uYT = true;
            Intent localIntent = new Intent();
            localIntent.setClass(ai.getContext(), MultiTalkingForegroundService.class);
            ai.getContext().bindService(localIntent, paramMessage, 1);
          }
          AppMethodBeat.o(114661);
          return;
        }
        catch (Exception paramMessage)
        {
          ac.printErrStackTrace("MicroMsg.MT.MultiTalkMainUI", paramMessage, "bindVoiceServiceIfNeed error: %s", new Object[] { paramMessage.getMessage() });
          AppMethodBeat.o(114661);
          return;
        }
        ((a)g.ad(a.class)).getNotification().cancel(43);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.10
 * JD-Core Version:    0.7.0.1
 */