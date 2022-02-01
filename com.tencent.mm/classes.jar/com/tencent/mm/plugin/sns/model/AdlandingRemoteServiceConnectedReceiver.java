package com.tencent.mm.plugin.sns.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AdlandingRemoteServiceConnectedReceiver
  extends BroadcastReceiver
{
  private Runnable cDO;
  
  public static void a(d paramd)
  {
    AppMethodBeat.i(95412);
    paramd.b(new Intent("com.tencnet.mm.action.adlanding.connected"));
    AppMethodBeat.o(95412);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(95411);
    if ((paramIntent != null) && ("com.tencnet.mm.action.adlanding.connected".equals(paramIntent.getAction())) && (this.cDO != null)) {
      this.cDO.run();
    }
    AppMethodBeat.o(95411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver
 * JD-Core Version:    0.7.0.1
 */