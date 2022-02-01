package com.tencent.mm.plugin.sns.waid;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;

public final class a
{
  ArrayList<Runnable> AEk;
  HandlerThread AEl;
  Handler AEm;
  private Runnable AEn;
  private final String TAG;
  
  public a()
  {
    AppMethodBeat.i(198628);
    this.TAG = "InitTaskMgr";
    this.AEk = new ArrayList();
    this.AEn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198627);
        try
        {
          long l1 = System.currentTimeMillis();
          com.tencent.mm.plugin.sns.ad.a.a.dRg();
          long l2 = System.currentTimeMillis();
          ad.i("InitTaskMgr", "DeviceIdInitTask run, timeCost=" + (l2 - l1));
          AppMethodBeat.o(198627);
          return;
        }
        catch (Exception localException)
        {
          ad.e("InitTaskMgr", "mDeviceIdInitTask exp=" + localException.toString());
          AppMethodBeat.o(198627);
        }
      }
    };
    this.AEk.add(this.AEn);
    try
    {
      this.AEl = new HandlerThread("waidproviderInitTask");
      this.AEl.start();
      this.AEm = new Handler(this.AEl.getLooper());
      AppMethodBeat.o(198628);
      return;
    }
    catch (Exception localException)
    {
      ad.e("InitTaskMgr", "initWorkThread exp=" + localException.toString());
      AppMethodBeat.o(198628);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.a
 * JD-Core Version:    0.7.0.1
 */