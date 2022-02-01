package com.tencent.mm.sandbox.monitor;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.service.MMService;

public class ExceptionMonitorMMService
  extends MMService
  implements b.a
{
  b ENI = null;
  
  private void o(Intent paramIntent)
  {
    AppMethodBeat.i(32606);
    if (this.ENI != null) {
      this.ENI.o(paramIntent);
    }
    AppMethodBeat.o(32606);
  }
  
  public final IBinder TF()
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
    ad.i("MicroMsg.ExceptionMonitorMMService", "onCreate()");
    this.ENI = new b();
    this.ENI.a(this);
    AppMethodBeat.o(32602);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(32605);
    super.onDestroy();
    ad.i("MicroMsg.ExceptionMonitorMMService", "onDestroy()");
    if (this.ENI != null)
    {
      this.ENI.onDestroy();
      this.ENI = null;
    }
    AppMethodBeat.o(32605);
  }
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(32603);
    super.onStart(paramIntent, paramInt);
    ad.i("MicroMsg.ExceptionMonitorMMService", "onStart()");
    if (this.ENI != null) {
      o(paramIntent);
    }
    AppMethodBeat.o(32603);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32604);
    ad.i("MicroMsg.ExceptionMonitorMMService", "onStartCommand()");
    if (this.ENI != null) {
      o(paramIntent);
    }
    AppMethodBeat.o(32604);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.ExceptionMonitorMMService
 * JD-Core Version:    0.7.0.1
 */