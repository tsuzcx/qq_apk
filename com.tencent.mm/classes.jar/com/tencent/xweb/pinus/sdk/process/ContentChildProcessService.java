package com.tencent.xweb.pinus.sdk.process;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public class ContentChildProcessService
  extends Service
{
  private static final String TAG = "ContentChildProcessService";
  private ChildProcessServiceWrapper mService;
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(213513);
    Log.i("ContentChildProcessService", "onBind");
    if (this.mService == null)
    {
      this.mService = new ChildProcessServiceWrapper(paramIntent, this, getApplicationContext());
      this.mService.onCreate();
    }
    paramIntent = this.mService.onBind(paramIntent);
    AppMethodBeat.o(213513);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(213497);
    Log.i("ContentChildProcessService", "onCreate");
    super.onCreate();
    AppMethodBeat.o(213497);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(213502);
    Log.i("ContentChildProcessService", "onDestroy");
    super.onDestroy();
    this.mService.onDestroy();
    this.mService = null;
    AppMethodBeat.o(213502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.process.ContentChildProcessService
 * JD-Core Version:    0.7.0.1
 */