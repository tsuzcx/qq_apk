package com.tencent.mm.plugin.sns.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.d;

public class AdlandingRemoteServiceConnectedReceiver
  extends BroadcastReceiver
{
  private Runnable eKD;
  
  public static void b(d paramd)
  {
    paramd.a(new Intent("com.tencnet.mm.action.adlanding.connected"));
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencnet.mm.action.adlanding.connected".equals(paramIntent.getAction())) && (this.eKD != null)) {
      this.eKD.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver
 * JD-Core Version:    0.7.0.1
 */