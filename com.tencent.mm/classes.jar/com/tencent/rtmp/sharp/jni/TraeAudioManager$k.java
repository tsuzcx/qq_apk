package com.tencent.rtmp.sharp.jni;

import android.content.Intent;
import java.util.HashMap;

abstract class TraeAudioManager$k
  extends Thread
{
  boolean b = true;
  boolean[] c = { false };
  HashMap<String, Object> d = null;
  long e = 0L;
  
  TraeAudioManager$k(TraeAudioManager paramTraeAudioManager)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " ++switchThread:" + b());
    }
  }
  
  public abstract void a();
  
  void a(int paramInt)
  {
    this.f.InternalNotifyDeviceChangableUpdate();
    AudioDeviceInterface.LogTraceEntry(b() + " err:" + paramInt);
    if (this.d == null) {
      this.f.InternalNotifyDeviceListUpdate();
    }
    do
    {
      return;
      this.f.sessionConnectedDev = this.f._deviceConfigManager.h();
      localObject = (Long)this.d.get("PARAM_SESSIONID");
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " sessonID:" + localObject);
      }
      if ((localObject != null) && (((Long)localObject).longValue() != -9223372036854775808L)) {
        break;
      }
      this.f.InternalNotifyDeviceListUpdate();
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, "processDeviceConnectRes sid null,don't send res");
    return;
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)this.d.get("PARAM_DEVICE"));
    if (this.f.sendResBroadcast((Intent)localObject, this.d, paramInt) == 0) {
      this.f.InternalNotifyDeviceListUpdate();
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void a(HashMap<String, Object> paramHashMap)
  {
    this.d = paramHashMap;
  }
  
  public abstract String b();
  
  public abstract void c();
  
  void e()
  {
    this.f._deviceConfigManager.g(b());
    a(0);
  }
  
  public void f()
  {
    AudioDeviceInterface.LogTraceEntry(b());
    this.b = false;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " quit:" + b() + " _running:" + this.b);
    }
    interrupt();
    c();
    synchronized (this.c)
    {
      int i = this.c[0];
      if (i != 0) {}
    }
    try
    {
      this.c.wait();
      label88:
      AudioDeviceInterface.LogTraceExit();
      return;
      localObject = finally;
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label88;
    }
  }
  
  public void run()
  {
    AudioDeviceInterface.LogTraceEntry(b());
    this.f._deviceConfigManager.f(b());
    this.f.InternalNotifyDeviceChangableUpdate();
    a();
    synchronized (this.c)
    {
      this.c[0] = true;
      this.c.notify();
      AudioDeviceInterface.LogTraceExit();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.k
 * JD-Core Version:    0.7.0.1
 */