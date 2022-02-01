package com.tencent.mm.plugin.setting.ui.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.yo;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class SettingsSwitchAccountUI$1
  extends BroadcastReceiver
{
  SettingsSwitchAccountUI$1(SettingsSwitchAccountUI paramSettingsSwitchAccountUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(74433);
    Log.i("MicroMsg.SettingsSwitchAccountUI", "onReceive %s", new Object[] { paramIntent.getAction() });
    this.JjX.unregisterReceiver(SettingsSwitchAccountUI.a(this.JjX));
    if (Util.nullAsNil(paramIntent.getAction()).equals("action_kill_mm_process"))
    {
      h.aHE();
      b.aGF();
      h.aHH().MS("switch account ,delay logout");
      Mars.onSingalCrash(0);
      Log.appenderFlush();
      this.JjX.finish();
      Log.i("MicroMsg.SettingsSwitchAccountUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
      paramContext = new yo();
      EventCenter.instance.publish(paramContext);
    }
    AppMethodBeat.o(74433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.1
 * JD-Core Version:    0.7.0.1
 */