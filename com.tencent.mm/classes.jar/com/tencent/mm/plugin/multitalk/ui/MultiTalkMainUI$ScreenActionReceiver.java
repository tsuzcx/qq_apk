package com.tencent.mm.plugin.multitalk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class MultiTalkMainUI$ScreenActionReceiver
  extends BroadcastReceiver
{
  public MultiTalkMainUI$ScreenActionReceiver(MultiTalkMainUI paramMultiTalkMainUI) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(114662);
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equals("android.intent.action.SCREEN_OFF")))
    {
      Log.i("MicroMsg.MT.MultiTalkMainUI", "receive action screen off");
      paramContext = this.zPW;
      paramContext.zPV.removeCallbacksAndMessages(null);
      paramContext.zPV.sendEmptyMessage(0);
    }
    AppMethodBeat.o(114662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.ScreenActionReceiver
 * JD-Core Version:    0.7.0.1
 */