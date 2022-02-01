package com.tencent.mm.plugin.sns.waid;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class a
{
  Handler Qjm;
  HandlerThread Qjn;
  ArrayList<Runnable> RYN;
  private Runnable RYO;
  private final String TAG;
  
  public a()
  {
    AppMethodBeat.i(306353);
    this.TAG = "InitTaskMgr";
    this.RYN = new ArrayList();
    this.RYO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(306347);
        try
        {
          long l1 = System.currentTimeMillis();
          com.tencent.mm.plugin.sns.ad.a.a.gZA();
          long l2 = System.currentTimeMillis();
          Log.i("InitTaskMgr", "DeviceIdInitTask run, timeCost=" + (l2 - l1));
          AppMethodBeat.o(306347);
          return;
        }
        catch (Exception localException)
        {
          Log.e("InitTaskMgr", "mDeviceIdInitTask exp=" + localException.toString());
          AppMethodBeat.o(306347);
        }
      }
    };
    this.RYN.add(this.RYO);
    try
    {
      this.Qjn = new HandlerThread("waidproviderInitTask");
      this.Qjn.start();
      this.Qjm = new Handler(this.Qjn.getLooper());
      AppMethodBeat.o(306353);
      return;
    }
    catch (Exception localException)
    {
      Log.e("InitTaskMgr", "initWorkThread exp=" + localException.toString());
      AppMethodBeat.o(306353);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.a
 * JD-Core Version:    0.7.0.1
 */