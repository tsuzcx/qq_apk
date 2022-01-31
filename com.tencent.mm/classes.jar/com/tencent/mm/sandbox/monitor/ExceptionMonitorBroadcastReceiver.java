package com.tencent.mm.sandbox.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

public class ExceptionMonitorBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(28786);
    paramIntent.setClass(paramContext, ExceptionMonitorService.class);
    d.j(paramIntent, "sandbox");
    AppMethodBeat.o(28786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */