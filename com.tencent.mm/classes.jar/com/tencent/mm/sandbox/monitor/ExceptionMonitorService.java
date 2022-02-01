package com.tencent.mm.sandbox.monitor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class ExceptionMonitorService
  extends Service
  implements b.a
{
  b acmX = null;
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(32607);
    super.onCreate();
    Log.i("MicroMsg.ExceptionMonitorService", "onCreate()");
    this.acmX = new b();
    this.acmX.a(this);
    AppMethodBeat.o(32607);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32610);
    super.onDestroy();
    Log.i("MicroMsg.ExceptionMonitorService", "onDestroy()");
    if (this.acmX != null)
    {
      this.acmX.onDestroy();
      this.acmX = null;
    }
    AppMethodBeat.o(32610);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(32608);
    super.onStart(paramIntent, paramInt);
    Log.i("MicroMsg.ExceptionMonitorService", "onStart()");
    if (this.acmX != null) {
      this.acmX.r(paramIntent);
    }
    AppMethodBeat.o(32608);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32609);
    Log.i("MicroMsg.ExceptionMonitorService", "onStartCommand()");
    if (this.acmX != null) {
      this.acmX.r(paramIntent);
    }
    AppMethodBeat.o(32609);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.ExceptionMonitorService
 * JD-Core Version:    0.7.0.1
 */