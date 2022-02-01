package com.tencent.mm.sandbox.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;

public class ExceptionMonitorBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(32601);
    Log.i("MicroMsg.ExceptionMonitorBroadcastReceiver", "onReceive()");
    paramIntent.setClass(paramContext, ExceptionMonitorMMService.class);
    c.n(paramIntent, "sandbox");
    AppMethodBeat.o(32601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */