package com.tencent.mm.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;

public class CommonProcessService
  extends Service
{
  private static ConcurrentHashMap<String, MMService> acwi;
  private b.a acwj;
  private Handler handler;
  private long mDN;
  
  static
  {
    AppMethodBeat.i(125303);
    acwi = new ConcurrentHashMap();
    AppMethodBeat.o(125303);
  }
  
  public CommonProcessService()
  {
    AppMethodBeat.i(125295);
    this.acwj = new CommonProcessService.1(this);
    AppMethodBeat.o(125295);
  }
  
  public String getTag()
  {
    return "MicroMsg.MMProcessService";
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(125302);
    Log.i(getTag(), "onBind()");
    paramIntent = this.acwj;
    AppMethodBeat.o(125302);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(125296);
    Log.i(getTag(), "onCreate()");
    this.mDN = System.currentTimeMillis();
    this.handler = new Handler();
    super.onCreate();
    AppMethodBeat.o(125296);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125299);
    Log.i(getTag(), "onDestroy()");
    super.onDestroy();
    AppMethodBeat.o(125299);
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(125301);
    Log.i(getTag(), "onRebind()");
    super.onRebind(paramIntent);
    AppMethodBeat.o(125301);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(125297);
    Log.i(getTag(), "onStart()");
    super.onStart(paramIntent, paramInt);
    AppMethodBeat.o(125297);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(125298);
    Log.i(getTag(), "onStartCommand()");
    AppMethodBeat.o(125298);
    return 1;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(125300);
    Log.i(getTag(), "onUnbind()");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(125300);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.service.CommonProcessService
 * JD-Core Version:    0.7.0.1
 */