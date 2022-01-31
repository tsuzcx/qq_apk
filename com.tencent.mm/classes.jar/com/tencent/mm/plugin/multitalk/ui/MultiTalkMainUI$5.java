package com.tencent.mm.plugin.multitalk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.widget.e;

final class MultiTalkMainUI$5
  extends BroadcastReceiver
{
  MultiTalkMainUI$5(MultiTalkMainUI paramMultiTalkMainUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(54122);
    if (("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) && (p.bTF().oTr == e.oVP))
    {
      p.bTF().stopRing();
      MultiTalkMainUI.b(this.oVe);
    }
    AppMethodBeat.o(54122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.5
 * JD-Core Version:    0.7.0.1
 */