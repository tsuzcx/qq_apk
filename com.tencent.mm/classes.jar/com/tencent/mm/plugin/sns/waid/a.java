package com.tencent.mm.plugin.sns.waid;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;

public final class a
{
  ArrayList<Runnable> AVN;
  HandlerThread AVO;
  Handler AVP;
  private Runnable AVQ;
  private final String TAG;
  
  public a()
  {
    AppMethodBeat.i(220177);
    this.TAG = "InitTaskMgr";
    this.AVN = new ArrayList();
    this.AVQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220176);
        try
        {
          long l1 = System.currentTimeMillis();
          com.tencent.mm.plugin.sns.ad.a.a.dUC();
          long l2 = System.currentTimeMillis();
          ae.i("InitTaskMgr", "DeviceIdInitTask run, timeCost=" + (l2 - l1));
          AppMethodBeat.o(220176);
          return;
        }
        catch (Exception localException)
        {
          ae.e("InitTaskMgr", "mDeviceIdInitTask exp=" + localException.toString());
          AppMethodBeat.o(220176);
        }
      }
    };
    this.AVN.add(this.AVQ);
    try
    {
      this.AVO = new HandlerThread("waidproviderInitTask");
      this.AVO.start();
      this.AVP = new Handler(this.AVO.getLooper());
      AppMethodBeat.o(220177);
      return;
    }
    catch (Exception localException)
    {
      ae.e("InitTaskMgr", "initWorkThread exp=" + localException.toString());
      AppMethodBeat.o(220177);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.a
 * JD-Core Version:    0.7.0.1
 */