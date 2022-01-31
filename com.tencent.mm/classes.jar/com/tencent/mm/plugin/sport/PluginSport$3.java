package com.tencent.mm.plugin.sport;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sport.model.a;
import com.tencent.mm.plugin.sport.model.n;
import com.tencent.mm.sdk.platformtools.ah;

final class PluginSport$3
  extends BroadcastReceiver
{
  PluginSport$3(PluginSport paramPluginSport) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(93606);
    if (("com.tencent.mm.plugin.sport.uploadstep".equals(paramIntent.getAction())) && (n.fa(ah.getContext())) && (n.cyu())) {
      this.spg.getDeviceStepManager().cyz();
    }
    AppMethodBeat.o(93606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.PluginSport.3
 * JD-Core Version:    0.7.0.1
 */