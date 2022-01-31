package com.tencent.mm.plugin.multitalk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public class MultiTalkMainUI$ScreenActionReceiver
  extends BroadcastReceiver
{
  public MultiTalkMainUI$ScreenActionReceiver(MultiTalkMainUI paramMultiTalkMainUI) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(54128);
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("android.intent.action.SCREEN_OFF")))
    {
      ab.i("MicroMsg.MT.MultiTalkMainUI", "receive action screen off");
      paramContext = this.oVe;
      paramContext.oVd.removeCallbacksAndMessages(null);
      paramContext.oVd.sendEmptyMessage(0);
    }
    AppMethodBeat.o(54128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.ScreenActionReceiver
 * JD-Core Version:    0.7.0.1
 */