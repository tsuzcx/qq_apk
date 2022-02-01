package com.tencent.mm.sandbox.monitor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class ExceptionMonitorService
  extends Service
  implements b.a
{
  b ENI = null;
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(32607);
    super.onCreate();
    ad.i("MicroMsg.ExceptionMonitorService", "onCreate()");
    this.ENI = new b();
    this.ENI.a(this);
    AppMethodBeat.o(32607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32610);
    super.onDestroy();
    ad.i("MicroMsg.ExceptionMonitorService", "onDestroy()");
    if (this.ENI != null)
    {
      this.ENI.onDestroy();
      this.ENI = null;
    }
    AppMethodBeat.o(32610);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(32608);
    super.onStart(paramIntent, paramInt);
    ad.i("MicroMsg.ExceptionMonitorService", "onStart()");
    if (this.ENI != null) {
      this.ENI.o(paramIntent);
    }
    AppMethodBeat.o(32608);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32609);
    ad.i("MicroMsg.ExceptionMonitorService", "onStartCommand()");
    if (this.ENI != null) {
      this.ENI.o(paramIntent);
    }
    AppMethodBeat.o(32609);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.ExceptionMonitorService
 * JD-Core Version:    0.7.0.1
 */