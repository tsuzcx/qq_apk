package com.tencent.mm.sandbox.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.ae;

public class ExceptionMonitorBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(32601);
    ae.i("MicroMsg.ExceptionMonitorBroadcastReceiver", "onReceive()");
    paramIntent.setClass(paramContext, ExceptionMonitorMMService.class);
    d.l(paramIntent, "sandbox");
    AppMethodBeat.o(32601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */