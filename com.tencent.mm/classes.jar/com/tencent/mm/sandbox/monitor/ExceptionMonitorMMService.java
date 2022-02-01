package com.tencent.mm.sandbox.monitor;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.service.MMService;

public class ExceptionMonitorMMService
  extends MMService
  implements b.a
{
  b IqP = null;
  
  private void o(Intent paramIntent)
  {
    AppMethodBeat.i(32606);
    if (this.IqP != null) {
      this.IqP.o(paramIntent);
    }
    AppMethodBeat.o(32606);
  }
  
  public final IBinder WY()
  {
    return null;
  }
  
  public final String getTag()
  {
    return "MicroMsg.ExceptionMonitorMMService";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(32602);
    super.onCreate();
    ae.i("MicroMsg.ExceptionMonitorMMService", "onCreate()");
    this.IqP = new b();
    this.IqP.a(this);
    AppMethodBeat.o(32602);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32605);
    super.onDestroy();
    ae.i("MicroMsg.ExceptionMonitorMMService", "onDestroy()");
    if (this.IqP != null)
    {
      this.IqP.onDestroy();
      this.IqP = null;
    }
    AppMethodBeat.o(32605);
  }
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(32603);
    super.onStart(paramIntent, paramInt);
    ae.i("MicroMsg.ExceptionMonitorMMService", "onStart()");
    if (this.IqP != null) {
      o(paramIntent);
    }
    AppMethodBeat.o(32603);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32604);
    ae.i("MicroMsg.ExceptionMonitorMMService", "onStartCommand()");
    if (this.IqP != null) {
      o(paramIntent);
    }
    AppMethodBeat.o(32604);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.ExceptionMonitorMMService
 * JD-Core Version:    0.7.0.1
 */