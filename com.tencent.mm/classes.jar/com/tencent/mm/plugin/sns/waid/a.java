package com.tencent.mm.plugin.sns.waid;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class a
{
  ArrayList<Runnable> Lvm;
  HandlerThread Lvn;
  Handler Lvo;
  private Runnable Lvp;
  private final String TAG;
  
  public a()
  {
    AppMethodBeat.i(220890);
    this.TAG = "InitTaskMgr";
    this.Lvm = new ArrayList();
    this.Lvp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(262573);
        try
        {
          long l1 = System.currentTimeMillis();
          com.tencent.mm.plugin.sns.ad.a.a.fJG();
          long l2 = System.currentTimeMillis();
          Log.i("InitTaskMgr", "DeviceIdInitTask run, timeCost=" + (l2 - l1));
          AppMethodBeat.o(262573);
          return;
        }
        catch (Exception localException)
        {
          Log.e("InitTaskMgr", "mDeviceIdInitTask exp=" + localException.toString());
          AppMethodBeat.o(262573);
        }
      }
    };
    this.Lvm.add(this.Lvp);
    try
    {
      this.Lvn = new HandlerThread("waidproviderInitTask");
      this.Lvn.start();
      this.Lvo = new Handler(this.Lvn.getLooper());
      AppMethodBeat.o(220890);
      return;
    }
    catch (Exception localException)
    {
      Log.e("InitTaskMgr", "initWorkThread exp=" + localException.toString());
      AppMethodBeat.o(220890);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.a
 * JD-Core Version:    0.7.0.1
 */