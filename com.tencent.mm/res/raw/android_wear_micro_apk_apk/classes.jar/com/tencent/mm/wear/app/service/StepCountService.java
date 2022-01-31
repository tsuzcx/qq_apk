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
  private SensorManager aeh;
  private String aei;
  private SensorEventListener aej = new SensorEventListener()
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
  
  private static String b(String paramString, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return paramString + ":" + localCalendar.get(1) + "-" + (localCalendar.get(2) + 1) + "-" + localCalendar.get(5);
  }
  
  public static void mT()
  {
    Object localObject1 = new a((byte)0);
    Object localObject2 = b(h.mb().lW(), System.currentTimeMillis());
    String str = MMApplication.getContext().getSharedPreferences("pre_fitness_data", 0).getString((String)localObject2, "");
    d.c("MicroMsg.StepCountService", "sendTodayStepCount: key=%s | data=%s", new Object[] { localObject2, str });
    ((a)localObject1).M(str);
    localObject2 = new ak();
    ((ak)localObject2).Wy = ((a)localObject1).aem;
    ((ak)localObject2).Wz = ((a)localObject1).lastUpdateTime;
    try
    {
      localObject1 = new com.tencent.mm.wear.app.f.b(11026, ((ak)localObject2).toByteArray());
      h.mc().a((com.tencent.mm.wear.app.g.a)localObject1);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  protected final void d(int paramInt, long paramLong)
  {
    d.c("MicroMsg.StepCountService", "Save Stepcount=%d", new Object[] { Integer.valueOf(paramInt) });
    String str1 = h.mb().lW();
    Object localObject1 = MMApplication.getContext().getSharedPreferences("pre_fitness_data", 0);
    if (this.aei.equals(str1))
    {
      str1 = b(str1, paramLong);
      localObject2 = new a((byte)0);
      localObject3 = ((SharedPreferences)localObject1).getString(str1, "");
      d.e("MicroMsg.StepCountService", "same user : get data from sp key=%s | data=%s", new Object[] { str1, localObject3 });
      ((a)localObject2).M((String)localObject3);
      if (q.D((String)localObject3))
      {
        ((a)localObject2).ael = paramInt;
        d.c("MicroMsg.StepCountService", "today first save data: key=%s | stepcount=%s", new Object[] { str1, Integer.valueOf(paramInt) });
      }
      ((a)localObject2).lastUpdateTime = paramLong;
      if (paramInt < ((a)localObject2).ael) {}
      for (i = paramInt + 0;; i = paramInt - ((a)localObject2).ael + 0)
      {
        ((a)localObject2).ael = paramInt;
        ((a)localObject2).aem = (i + ((a)localObject2).aem);
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putString(str1, ((a)localObject2).toString());
        ((SharedPreferences.Editor)localObject1).commit();
        return;
      }
    }
    Object localObject2 = b(this.aei, paramLong);
    Object localObject3 = new a((byte)0);
    String str2 = ((SharedPreferences)localObject1).getString((String)localObject2, "");
    ((a)localObject3).M(str2);
    ((a)localObject3).lastUpdateTime = paramLong;
    d.e("MicroMsg.StepCountService", "different user[%s]: get data from sp key=%s | data=%s", new Object[] { this.aei, localObject2, str2 });
    if (q.D(str2))
    {
      ((a)localObject3).ael = paramInt;
      d.c("MicroMsg.StepCountService", "today first save data: key=%s | stepcount=%s", new Object[] { localObject2, Integer.valueOf(paramInt) });
    }
    if (paramInt < ((a)localObject3).ael) {}
    for (int i = paramInt + 0;; i = paramInt - ((a)localObject3).ael + 0)
    {
      ((a)localObject3).ael = paramInt;
      ((a)localObject3).aem = (i + ((a)localObject3).aem);
      str2 = b(str1, paramLong);
      a locala = new a((byte)0);
      String str3 = ((SharedPreferences)localObject1).getString(str2, "");
      locala.M(str3);
      locala.lastUpdateTime = paramLong;
      d.c("MicroMsg.StepCountService", "different user[%s]: get data from sp key=%s | data=%s", new Object[] { str1, str2, str3 });
      locala.ael = paramInt;
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putString((String)localObject2, ((a)localObject3).toString());
      ((SharedPreferences.Editor)localObject1).putString(str2, locala.toString());
      ((SharedPreferences.Editor)localObject1).commit();
      this.aei = str1;
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
    this.aeh = ((SensorManager)getSystemService("sensor"));
    Sensor localSensor = this.aeh.getDefaultSensor(19);
    boolean bool = this.aeh.registerListener(this.aej, localSensor, 3);
    this.aei = h.mb().lW();
    d.c("MicroMsg.StepCountService", "onCreate lastUpdateUserName: %s %b", new Object[] { this.aei, Boolean.valueOf(bool) });
  }
  
  public void onDestroy()
  {
    this.aeh.unregisterListener(this.aej);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.service.StepCountService
 * JD-Core Version:    0.7.0.1
 */