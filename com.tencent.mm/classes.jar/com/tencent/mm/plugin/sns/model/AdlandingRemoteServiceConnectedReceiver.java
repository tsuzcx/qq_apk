package com.tencent.mm.plugin.sns.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AdlandingRemoteServiceConnectedReceiver
  extends BroadcastReceiver
{
  private Runnable gaj;
  
  public static void a(d paramd)
  {
    AppMethodBeat.i(36098);
    paramd.c(new Intent("com.tencnet.mm.action.adlanding.connected"));
    AppMethodBeat.o(36098);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(36097);
    if ((paramIntent != null) && ("com.tencnet.mm.action.adlanding.connected".equals(paramIntent.getAction())) && (this.gaj != null)) {
      this.gaj.run();
    }
    AppMethodBeat.o(36097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver
 * JD-Core Version:    0.7.0.1
 */