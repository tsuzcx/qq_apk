package com.tencent.mm.plugin.sport.service;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.a.a;
import com.tencent.mm.plugin.sport.c.c;
import com.tencent.mm.plugin.sport.c.h;
import com.tencent.mm.plugin.sport.c.i;
import com.tencent.mm.plugin.sport.c.k;
import com.tencent.mm.plugin.sport.c.n;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class SportService
  extends Service
  implements c
{
  private k ptL;
  private boolean ptM = false;
  private final a.a ptN = new a.a()
  {
    public final void P(int paramAnonymousInt, long paramAnonymousLong)
    {
      ((PluginSport)com.tencent.mm.kernel.g.t(PluginSport.class)).getSportFileStorage().setLong(paramAnonymousInt, paramAnonymousLong);
    }
    
    public final void Pu(String paramAnonymousString)
    {
      com.tencent.mm.plugin.sport.c.g.Pv(paramAnonymousString);
      if (!SportService.this.bLx()) {
        SportService.this.stopSelf();
      }
    }
    
    public final long bLd()
    {
      try
      {
        long l1 = bk.crX() / 10000L;
        long l2 = i.zl(202);
        long l3 = i.zl(201);
        long l4 = k.bLt();
        int i = (int)k.bLs();
        if (l4 == l1)
        {
          y.i("MicroMsg.Sport.SportService", "cacheTime %s cacheStep:%s", new Object[] { Long.valueOf(l4), Integer.valueOf(i) });
          return i;
        }
        if (l2 == l1)
        {
          y.i("MicroMsg.Sport.SportService", "saveTime %s saveStep:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
          return (int)l3;
        }
        y.i("MicroMsg.Sport.SportService", "getStepCount:0, new day");
        y.i("MicroMsg.Sport.SportService", "saveTime:%s, cacheTime: %S, beginOfToday:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l4), Long.valueOf(l1) });
        return 0L;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.Sport.SportService", localException, "exception in :exdevice getTodayDeviceStepCount", new Object[0]);
      }
      return 0L;
    }
    
    public final void bLe() {}
    
    public final void bLf()
    {
      ((PluginSport)com.tencent.mm.kernel.g.t(PluginSport.class)).getSportFileStorage().reset();
      Process.killProcess(Process.myPid());
    }
    
    public final long getLong(int paramAnonymousInt, long paramAnonymousLong)
    {
      return ((PluginSport)com.tencent.mm.kernel.g.t(PluginSport.class)).getSportFileStorage().getLong(paramAnonymousInt, paramAnonymousLong);
    }
  };
  private Sensor sensor;
  private SensorManager sensorManager;
  
  private boolean bLv()
  {
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)getSystemService("sensor"));
      }
      if (this.ptL == null)
      {
        this.ptL = new k();
        this.ptL.ptE = this;
      }
      if ((this.sensorManager != null) && (getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")))
      {
        this.sensor = this.sensorManager.getDefaultSensor(19);
        if (this.sensor == null)
        {
          y.i("MicroMsg.Sport.SportService", " TYPE_STEP_COUNTER sensor null");
          return false;
        }
        JSONObject localJSONObject = com.tencent.mm.plugin.sport.c.g.bLn();
        boolean bool = this.sensorManager.registerListener(this.ptL, this.sensor, localJSONObject.optInt("stepCounterRateUs", 60000));
        if (!bool) {
          bLw();
        }
        y.i("MicroMsg.Sport.SportService", "registerDetector() ok.(result : %s)", new Object[] { Boolean.valueOf(bool) });
        return bool;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.Sport.SportService", "Exception in registerDetector %s", new Object[] { localException.getMessage() });
    }
    for (;;)
    {
      return false;
      y.i("MicroMsg.Sport.SportService", "no step sensor");
    }
  }
  
  private void bLw()
  {
    try
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)getSystemService("sensor"));
      }
      this.sensorManager.unregisterListener(this.ptL);
      y.i("MicroMsg.Sport.SportService", "unregisterDetector() success!");
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.Sport.SportService", "Exception in unregisterDetector %s", new Object[] { localException.getMessage() });
    }
  }
  
  public final void bLl()
  {
    bLw();
  }
  
  public final boolean bLx()
  {
    this.ptM = n.ej(this);
    if (this.ptM)
    {
      bLw();
      return bLv();
    }
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.ptN;
  }
  
  public void onCreate()
  {
    super.onCreate();
    y.i("MicroMsg.Sport.SportService", "onCreate");
    this.ptM = n.ej(this);
    y.i("MicroMsg.Sport.SportService", "isSupportDeviceStep %b", new Object[] { Boolean.valueOf(this.ptM) });
    if (this.ptM)
    {
      bLv();
      return;
    }
    y.i("MicroMsg.Sport.SportService", "stop self");
    stopSelf();
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.Sport.SportService", "onDestroy");
    if (this.ptM) {
      bLw();
    }
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.Sport.SportService", "onStartCommand");
    try
    {
      if (this.ptM)
      {
        if (this.ptL != null) {
          this.ptL.ptE = this;
        }
        boolean bool = bLx();
        if (bool) {
          return 1;
        }
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Sport.SportService", localException, "Exception onStartCommand %s", new Object[0]);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.service.SportService
 * JD-Core Version:    0.7.0.1
 */