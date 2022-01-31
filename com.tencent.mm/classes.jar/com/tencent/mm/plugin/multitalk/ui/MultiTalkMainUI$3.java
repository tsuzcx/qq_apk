package com.tencent.mm.plugin.multitalk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.p;
import com.tencent.mm.plugin.multitalk.ui.widget.e;

final class MultiTalkMainUI$3
  extends BroadcastReceiver
{
  MultiTalkMainUI$3(MultiTalkMainUI paramMultiTalkMainUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) && (p.blF().mtG == e.mvX))
    {
      p.blF().stopRing();
      MultiTalkMainUI.a(this.mvm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI.3
 * JD-Core Version:    0.7.0.1
 */