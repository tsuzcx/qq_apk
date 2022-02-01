package com.tencent.mm.sandbox.monitor;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.service.MMService;

public class ExceptionMonitorMMService
  extends MMService
  implements b.a
{
  b URK = null;
  
  private void q(Intent paramIntent)
  {
    AppMethodBeat.i(32606);
    if (this.URK != null) {
      this.URK.q(paramIntent);
    }
    AppMethodBeat.o(32606);
  }
  
  public final IBinder aqH()
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
    Log.i("MicroMsg.ExceptionMonitorMMService", "onCreate()");
    this.URK = new b();
    this.URK.a(this);
    AppMethodBeat.o(32602);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32605);
    super.onDestroy();
    Log.i("MicroMsg.ExceptionMonitorMMService", "onDestroy()");
    if (this.URK != null)
    {
      this.URK.onDestroy();
      this.URK = null;
    }
    AppMethodBeat.o(32605);
  }
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(32603);
    super.onStart(paramIntent, paramInt);
    Log.i("MicroMsg.ExceptionMonitorMMService", "onStart()");
    if (this.URK != null) {
      q(paramIntent);
    }
    AppMethodBeat.o(32603);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32604);
    Log.i("MicroMsg.ExceptionMonitorMMService", "onStartCommand()");
    if (this.URK != null) {
      q(paramIntent);
    }
    AppMethodBeat.o(32604);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.ExceptionMonitorMMService
 * JD-Core Version:    0.7.0.1
 */