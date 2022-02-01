package com.tencent.mm.plugin.sns.waid;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class a
{
  ArrayList<Runnable> FgH;
  HandlerThread FgI;
  Handler FgJ;
  private Runnable FgK;
  private final String TAG;
  
  public a()
  {
    AppMethodBeat.i(204036);
    this.TAG = "InitTaskMgr";
    this.FgH = new ArrayList();
    this.FgK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204035);
        try
        {
          long l1 = System.currentTimeMillis();
          com.tencent.mm.plugin.sns.ad.b.a.eWD();
          long l2 = System.currentTimeMillis();
          Log.i("InitTaskMgr", "DeviceIdInitTask run, timeCost=" + (l2 - l1));
          AppMethodBeat.o(204035);
          return;
        }
        catch (Exception localException)
        {
          Log.e("InitTaskMgr", "mDeviceIdInitTask exp=" + localException.toString());
          AppMethodBeat.o(204035);
        }
      }
    };
    this.FgH.add(this.FgK);
    try
    {
      this.FgI = new HandlerThread("waidproviderInitTask");
      this.FgI.start();
      this.FgJ = new Handler(this.FgI.getLooper());
      AppMethodBeat.o(204036);
      return;
    }
    catch (Exception localException)
    {
      Log.e("InitTaskMgr", "initWorkThread exp=" + localException.toString());
      AppMethodBeat.o(204036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.a
 * JD-Core Version:    0.7.0.1
 */