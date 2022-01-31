package com.tencent.rtmp.sharp.jni;

import android.content.Intent;
import com.tencent.d.a.a.a;
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
    a.dUd();
    a.iP("TRAE", " ++switchThread:" + b());
  }
  
  public abstract void a();
  
  void a(int paramInt)
  {
    this.f.InternalNotifyDeviceChangableUpdate();
    AudioDeviceInterface.LogTraceEntry(b() + " err:" + paramInt);
    if (this.d == null)
    {
      this.f.InternalNotifyDeviceListUpdate();
      return;
    }
    this.f.sessionConnectedDev = this.f._deviceConfigManager.h();
    Object localObject = (Long)this.d.get("PARAM_SESSIONID");
    a.dUd();
    a.iP("TRAE", " sessonID:".concat(String.valueOf(localObject)));
    if ((localObject == null) || (((Long)localObject).longValue() == -9223372036854775808L))
    {
      this.f.InternalNotifyDeviceListUpdate();
      a.dUd();
      a.iP("TRAE", "processDeviceConnectRes sid null,don't send res");
      return;
    }
    localObject = new Intent();
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
  
  void f()
  {
    this.f._deviceConfigManager.g(b());
    a(0);
  }
  
  public void g()
  {
    AudioDeviceInterface.LogTraceEntry(b());
    this.b = false;
    a.dUd();
    a.iP("TRAE", " quit:" + b() + " _running:" + this.b);
    interrupt();
    c();
    synchronized (this.c)
    {
      int i = this.c[0];
      if (i != 0) {}
    }
    try
    {
      this.c.wait(10000L);
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
      this.c.notifyAll();
      AudioDeviceInterface.LogTraceExit();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.k
 * JD-Core Version:    0.7.0.1
 */