package com.tencent.mm.wear.app.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import com.tencent.mm.e.a.ak;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.b.g;
import com.tencent.mm.wear.app.b.h;
import java.io.IOException;
import java.util.Calendar;

public class StepCountService
  extends Service
{
  private SensorManager ahJ;
  private String ahK;
  private SensorEventListener ahL = new SensorEventListener()
  {
    public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
    
    public final void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
    {
      int i = (int)paramAnonymousSensorEvent.values[0];
      if ((i > 0) && (paramAnonymousSensorEvent.accuracy >= 3)) {
        StepCountService.this.d(i, System.currentTimeMillis());
      }
    }
  };
  
  private static String a(String paramString, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return paramString + ":" + localCalendar.get(1) + "-" + (localCalendar.get(2) + 1) + "-" + localCalendar.get(5);
  }
  
  public static void nF()
  {
    Object localObject1 = new a((byte)0);
    Object localObject2 = a(h.mO().mJ(), System.currentTimeMillis());
    String str = MMApplication.getContext().getSharedPreferences("pre_fitness_data", 0).getString((String)localObject2, "");
    d.c("MicroMsg.StepCountService", "sendTodayStepCount: key=%s | data=%s", new Object[] { localObject2, str });
    ((a)localObject1).T(str);
    localObject2 = new ak();
    ((ak)localObject2).Yt = ((a)localObject1).ahO;
    ((ak)localObject2).Yu = ((a)localObject1).lastUpdateTime;
    try
    {
      localObject1 = new com.tencent.mm.wear.app.f.b(11026, ((ak)localObject2).toByteArray());
      h.mP().a((com.tencent.mm.wear.app.g.a)localObject1);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  protected final void d(int paramInt, long paramLong)
  {
    d.c("MicroMsg.StepCountService", "Save Stepcount=%d", new Object[] { Integer.valueOf(paramInt) });
    String str1 = h.mO().mJ();
    Object localObject1 = MMApplication.getContext().getSharedPreferences("pre_fitness_data", 0);
    if (this.ahK.equals(str1))
    {
      str1 = a(str1, paramLong);
      localObject2 = new a((byte)0);
      localObject3 = ((SharedPreferences)localObject1).getString(str1, "");
      d.d("MicroMsg.StepCountService", "same user : get data from sp key=%s | data=%s", new Object[] { str1, localObject3 });
      ((a)localObject2).T((String)localObject3);
      if (q.D((String)localObject3))
      {
        ((a)localObject2).ahN = paramInt;
        d.c("MicroMsg.StepCountService", "today first save data: key=%s | stepcount=%s", new Object[] { str1, Integer.valueOf(paramInt) });
      }
      ((a)localObject2).lastUpdateTime = paramLong;
      if (paramInt < ((a)localObject2).ahN) {}
      for (i = paramInt + 0;; i = paramInt - ((a)localObject2).ahN + 0)
      {
        ((a)localObject2).ahN = paramInt;
        ((a)localObject2).ahO = (i + ((a)localObject2).ahO);
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putString(str1, ((a)localObject2).toString());
        ((SharedPreferences.Editor)localObject1).commit();
        return;
      }
    }
    Object localObject2 = a(this.ahK, paramLong);
    Object localObject3 = new a((byte)0);
    String str2 = ((SharedPreferences)localObject1).getString((String)localObject2, "");
    ((a)localObject3).T(str2);
    ((a)localObject3).lastUpdateTime = paramLong;
    d.d("MicroMsg.StepCountService", "different user[%s]: get data from sp key=%s | data=%s", new Object[] { this.ahK, localObject2, str2 });
    if (q.D(str2))
    {
      ((a)localObject3).ahN = paramInt;
      d.c("MicroMsg.StepCountService", "today first save data: key=%s | stepcount=%s", new Object[] { localObject2, Integer.valueOf(paramInt) });
    }
    if (paramInt < ((a)localObject3).ahN) {}
    for (int i = paramInt + 0;; i = paramInt - ((a)localObject3).ahN + 0)
    {
      ((a)localObject3).ahN = paramInt;
      ((a)localObject3).ahO = (i + ((a)localObject3).ahO);
      str2 = a(str1, paramLong);
      a locala = new a((byte)0);
      String str3 = ((SharedPreferences)localObject1).getString(str2, "");
      locala.T(str3);
      locala.lastUpdateTime = paramLong;
      d.c("MicroMsg.StepCountService", "different user[%s]: get data from sp key=%s | data=%s", new Object[] { str1, str2, str3 });
      locala.ahN = paramInt;
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putString((String)localObject2, ((a)localObject3).toString());
      ((SharedPreferences.Editor)localObject1).putString(str2, locala.toString());
      ((SharedPreferences.Editor)localObject1).commit();
      this.ahK = str1;
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.ahJ = ((SensorManager)getSystemService("sensor"));
    Sensor localSensor = this.ahJ.getDefaultSensor(19);
    boolean bool = this.ahJ.registerListener(this.ahL, localSensor, 3);
    this.ahK = h.mO().mJ();
    d.c("MicroMsg.StepCountService", "onCreate lastUpdateUserName: %s %b", new Object[] { this.ahK, Boolean.valueOf(bool) });
  }
  
  public void onDestroy()
  {
    this.ahJ.unregisterListener(this.ahL);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.service.StepCountService
 * JD-Core Version:    0.7.0.1
 */