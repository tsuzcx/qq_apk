package com.tencent.rtmp.sharp.jni;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.liteav.basic.log.TXCLog;
import java.util.ArrayList;
import java.util.HashMap;

class TraeAudioManager$f
  extends Thread
{
  Handler a = null;
  TraeMediaPlayer b = null;
  long c = -1L;
  String d = "";
  String e = "";
  final boolean[] f = { false };
  boolean g = false;
  TraeAudioManager h = null;
  String i = "";
  int j = 0;
  int k = 0;
  long l = -1L;
  String m = "";
  AudioManager.OnAudioFocusChangeListener n = null;
  int o = 0;
  
  public TraeAudioManager$f(TraeAudioManager arg1, TraeAudioManager paramTraeAudioManager2)
  {
    this.h = paramTraeAudioManager2;
    long l1 = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 2, "TraeAudioManagerLooper start...");
    }
    start();
    synchronized (this.f)
    {
      int i1 = this.f[0];
      if (i1 != 0) {}
    }
    try
    {
      this.f.wait();
      label152:
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "  start used:" + (SystemClock.elapsedRealtime() - l1) + "ms");
      }
      return;
      paramTraeAudioManager2 = finally;
      throw paramTraeAudioManager2;
    }
    catch (InterruptedException paramTraeAudioManager2)
    {
      break label152;
    }
  }
  
  public int a(int paramInt, HashMap<String, Object> paramHashMap)
  {
    if (this.a == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(" fail mMsgHandler==null _enabled:");
      if (this.g) {}
      for (paramHashMap = "Y";; paramHashMap = "N")
      {
        AudioDeviceInterface.LogTraceEntry(paramHashMap + " activeMode:" + this.p._activeMode + " msg:" + paramInt);
        return -1;
      }
    }
    paramHashMap = Message.obtain(this.a, paramInt, paramHashMap);
    if (this.a.sendMessage(paramHashMap)) {
      return 0;
    }
    return -1;
  }
  
  int a(boolean paramBoolean)
  {
    if (this.p._context == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_SERVICE_STATE");
    localIntent.putExtra("NOTIFY_SERVICE_STATE_DATE", paramBoolean);
    if (this.p._context != null) {
      this.p._context.sendBroadcast(localIntent);
    }
    return 0;
  }
  
  public void a()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this.a == null) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    this.a.getLooper().quit();
    synchronized (this.f)
    {
      int i1 = this.f[0];
      if (i1 != 1) {}
    }
    try
    {
      this.f.wait(10000L);
      label58:
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "  quit used:" + (SystemClock.elapsedRealtime() - l1) + "ms");
      }
      this.a = null;
      AudioDeviceInterface.LogTraceExit();
      return;
      localObject = finally;
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label58;
    }
  }
  
  @TargetApi(8)
  void a(int paramInt)
  {
    if (Build.VERSION.SDK_INT <= 8) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.n != null);
        this.n = new TraeAudioManager.f.3(this);
      } while (this.p._am == null);
      int i1 = this.p._am.requestAudioFocus(this.n, paramInt, 1);
      if ((i1 != 1) && (QLog.isColorLevel())) {
        QLog.e("TRAE", 2, "request audio focus fail. " + i1 + " mode:" + this.p._am.getMode());
      }
      this.o = paramInt;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, "-------requestAudioFocus _focusSteamType:" + this.o);
  }
  
  void a(HashMap<String, Object> paramHashMap)
  {
    String str = (String)paramHashMap.get("EXTRA_DATA_DEVICECONFIG");
    TXCLog.w("TRAE", "startService cfg:" + str);
    StringBuilder localStringBuilder = new StringBuilder(" _enabled:");
    if (this.g)
    {
      paramHashMap = "Y";
      AudioDeviceInterface.LogTraceEntry(paramHashMap + " activeMode:" + this.p._activeMode + " cfg:" + str);
      if (this.p._context != null) {
        break label106;
      }
    }
    label106:
    do
    {
      return;
      paramHashMap = "N";
      break;
      QLog.w("TRAE", 2, "   startService:" + str);
    } while (((this.g) && (this.i.equals(str))) || (this.p._activeMode != 0));
    if (this.g) {
      b();
    }
    d();
    this.p._context.getSystemService("audio");
    this.p._deviceConfigManager.a();
    this.p._deviceConfigManager.a(str);
    this.i = str;
    if (this.p._am != null) {
      this.j = this.p._am.getMode();
    }
    this.g = true;
    if (this.b == null) {
      this.b = new TraeMediaPlayer(this.p._context, new TraeAudioManager.f.1(this));
    }
    a(this.g);
    this.p.updateDeviceStatus();
    AudioDeviceInterface.LogTraceExit();
  }
  
  int b(int paramInt)
  {
    if (this.p._context == null) {
      return -1;
    }
    new Handler(Looper.getMainLooper()).post(new TraeAudioManager.f.4(this, paramInt));
    return 0;
  }
  
  int b(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    Object localObject = this.p._deviceConfigManager.j();
    ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
    String str = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
    localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
    localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
    localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str);
    localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", (String)localObject);
    localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", this.p._deviceConfigManager.d());
    this.p.sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  void b()
  {
    StringBuilder localStringBuilder = new StringBuilder(" _enabled:");
    if (this.g) {}
    for (String str = "Y";; str = "N")
    {
      AudioDeviceInterface.LogTraceEntry(str + " activeMode:" + this.p._activeMode);
      if (this.g) {
        break;
      }
      return;
    }
    if (this.p._activeMode == 1) {
      h();
    }
    for (;;)
    {
      if (this.p._switchThread != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "_switchThread:" + this.p._switchThread.b());
        }
        this.p._switchThread.f();
        this.p._switchThread = null;
      }
      if (this.b != null) {
        this.b.stopRing();
      }
      this.b = null;
      this.g = false;
      a(this.g);
      if ((this.p._am != null) && (this.p._context != null)) {}
      try
      {
        this.p.InternalSetMode(0);
        label204:
        e();
        AudioDeviceInterface.LogTraceExit();
        return;
        if (this.p._activeMode != 2) {
          continue;
        }
        i();
      }
      catch (Exception localException)
      {
        break label204;
      }
    }
  }
  
  int c(HashMap<String, Object> paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode);
    if (paramHashMap == null) {
      return -1;
    }
    if (this.p._am == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalVoicecallPreprocess am==null!!");
      }
      return -1;
    }
    if (this.p._activeMode == 1)
    {
      localObject = new Intent();
      this.p.sendResBroadcast((Intent)localObject, paramHashMap, 2);
      return -1;
    }
    this.l = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
    this.m = ((String)paramHashMap.get("PARAM_OPERATION"));
    this.p._activeMode = 1;
    this.p._prevMode = this.p._am.getMode();
    Object localObject = (Integer)paramHashMap.get("PARAM_MODEPOLICY");
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " params.get(PARAM_MODEPOLICY)==null!!");
      }
      this.p._modePolicy = -1;
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "  _modePolicy:" + this.p._modePolicy);
      }
      localObject = (Integer)paramHashMap.get("PARAM_STREAMTYPE");
      if (localObject != null) {
        break label360;
      }
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " params.get(PARAM_STREAMTYPE)==null!!");
      }
      this.p._streamType = 0;
      label256:
      if ((!TraeAudioManager.isCloseSystemAPM(this.p._modePolicy)) || (this.p._activeMode == 2) || (this.p._deviceConfigManager == null)) {
        break label390;
      }
      if (!this.p._deviceConfigManager.h().equals("DEVICE_SPEAKERPHONE")) {
        break label374;
      }
      this.p.InternalSetMode(0);
      a(3);
    }
    for (;;)
    {
      localObject = new Intent();
      this.p.sendResBroadcast((Intent)localObject, paramHashMap, 0);
      AudioDeviceInterface.LogTraceExit();
      return 0;
      this.p._modePolicy = ((Integer)localObject).intValue();
      break;
      label360:
      this.p._streamType = ((Integer)localObject).intValue();
      break label256;
      label374:
      this.p.InternalSetMode(3);
      a(0);
      continue;
      label390:
      this.p.InternalSetMode(TraeAudioManager.getCallAudioMode(this.p._modePolicy));
      a(this.p._streamType);
    }
  }
  
  void c()
  {
    AudioDeviceInterface.LogTraceEntry("");
    try
    {
      this.p._audioSessionHost = new TraeAudioSessionHost();
      this.p._deviceConfigManager = new TraeAudioManager.e(this.p);
      TraeAudioManager._gHostProcessId = Process.myPid();
      this.p._am = ((AudioManager)this.p._context.getSystemService("audio"));
      this.p._bluetoothCheck = this.p.CreateBluetoothCheck(this.p._context, this.p._deviceConfigManager);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
      this.p._bluetoothCheck.b(localIntentFilter);
      localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      this.p._context.registerReceiver(this.h, localIntentFilter);
      AudioDeviceInterface.LogTraceExit();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "======7");
        }
      }
    }
  }
  
  int d(HashMap<String, Object> paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode);
    if (this.p._am == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalVoicecallPostprocess am==null!!");
      }
      return -1;
    }
    if (this.p._activeMode != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " not ACTIVE_VOICECALL!!");
      }
      Intent localIntent = new Intent();
      this.p.sendResBroadcast(localIntent, paramHashMap, 3);
      return -1;
    }
    this.p._activeMode = 0;
    g();
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  void d()
  {
    try
    {
      this.p._am = ((AudioManager)this.p._context.getSystemService("audio"));
      if (this.p._bluetoothCheck == null) {
        this.p._bluetoothCheck = this.p.CreateBluetoothCheck(this.p._context, this.p._deviceConfigManager);
      }
      this.p._context.unregisterReceiver(this.h);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
      this.p._bluetoothCheck.b(localIntentFilter);
      localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      this.p._context.registerReceiver(this.h, localIntentFilter);
      return;
    }
    catch (Exception localException) {}
  }
  
  int e(HashMap<String, Object> paramHashMap)
  {
    boolean bool1 = true;
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode);
    if (this.p._am == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalStartRing am==null!!");
      }
      return -1;
    }
    if (this.p._activeMode == 2) {
      i();
    }
    for (;;)
    {
      try
      {
        this.c = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
        this.d = ((String)paramHashMap.get("PARAM_OPERATION"));
        this.e = ((String)paramHashMap.get("PARAM_RING_USERDATA_STRING"));
        int i1 = ((Integer)paramHashMap.get("PARAM_RING_DATASOURCE")).intValue();
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "  dataSource:" + i1);
        }
        int i2 = ((Integer)paramHashMap.get("PARAM_RING_RSID")).intValue();
        Uri localUri = (Uri)paramHashMap.get("PARAM_RING_URI");
        String str = (String)paramHashMap.get("PARAM_RING_FILEPATH");
        boolean bool2 = ((Boolean)paramHashMap.get("PARAM_RING_LOOP")).booleanValue();
        int i3 = ((Integer)paramHashMap.get("PARAM_RING_LOOPCOUNT")).intValue();
        boolean bool3 = ((Boolean)paramHashMap.get("PARAM_RING_MODE")).booleanValue();
        if (this.p._activeMode != 1) {
          this.p._activeMode = 2;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.e);
        this.p.sendResBroadcast(localIntent, paramHashMap, 0);
        this.k = this.p._am.getMode();
        paramHashMap = this.b;
        if (this.p._activeMode == 1)
        {
          paramHashMap.playRing(i1, i2, localUri, str, bool2, i3, bool3, bool1, this.p._streamType);
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " _ringUserdata:" + this.e + " DurationMS:" + this.b.getDuration());
          }
          if (!this.b.hasCall()) {
            a(this.b.getStreamType());
          }
          b(this.b.getStreamType());
          AudioDeviceInterface.LogTraceExit();
          return 0;
        }
      }
      catch (Exception paramHashMap)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " startRing err params");
        }
        return -1;
      }
      bool1 = false;
    }
  }
  
  void e()
  {
    try
    {
      if (this.p._bluetoothCheck != null) {
        this.p._bluetoothCheck.a();
      }
      this.p._bluetoothCheck = null;
      if (this.p._context != null)
      {
        this.p._context.unregisterReceiver(this.h);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        this.p._context.registerReceiver(this.h, localIntentFilter);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  int f(HashMap<String, Object> paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode + " _preRingMode:" + this.k);
    if ((this.p._am == null) || (this.b == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalStopRing am==null!!");
      }
      return -1;
    }
    this.b.stopRing();
    if ((!this.b.hasCall()) && (this.p._activeMode == 2))
    {
      g();
      this.p._activeMode = 0;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.e);
    this.p.sendResBroadcast(localIntent, paramHashMap, 0);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  void f()
  {
    AudioDeviceInterface.LogTraceEntry("");
    try
    {
      b();
      if (this.p._bluetoothCheck != null) {
        this.p._bluetoothCheck.a();
      }
      this.p._bluetoothCheck = null;
      if (this.p._context != null)
      {
        this.p._context.unregisterReceiver(this.h);
        this.p._context = null;
      }
      if (this.p._deviceConfigManager != null) {
        this.p._deviceConfigManager.a();
      }
      this.p._deviceConfigManager = null;
      label97:
      AudioDeviceInterface.LogTraceExit();
    }
    catch (Exception localException)
    {
      break label97;
    }
  }
  
  int g(HashMap<String, Object> paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode + " _preRingMode:" + this.k);
    if (this.p._am == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " InternalStopRing am==null!!");
      }
      return -1;
    }
    if (this.p._activeMode == 2) {}
    for (int i1 = this.b.getStreamType();; i1 = this.p._streamType)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("EXTRA_DATA_STREAMTYPE", i1);
      this.p.sendResBroadcast(localIntent, paramHashMap, 0);
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
  }
  
  @TargetApi(8)
  void g()
  {
    if (Build.VERSION.SDK_INT <= 8) {}
    while ((this.p._am == null) || (this.n == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "-------abandonAudioFocus _focusSteamType:" + this.o);
    }
    this.p._am.abandonAudioFocus(this.n);
    this.n = null;
  }
  
  int h()
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode);
    if (this.p._am == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " am==null!!");
      }
    }
    do
    {
      return -1;
      if (this.p._activeMode == 1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, " not ACTIVE_RING!!");
    return -1;
    this.p._activeMode = 0;
    if (this.p._prevMode != -1) {
      this.p.InternalSetMode(this.p._prevMode);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(this.l));
    localHashMap.put("PARAM_OPERATION", this.m);
    Intent localIntent = new Intent();
    this.p.sendResBroadcast(localIntent, localHashMap, 6);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  int i()
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode + " _preRingMode:" + this.k);
    if (this.p._am == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " interruptRing am==null!!");
      }
    }
    do
    {
      return -1;
      if (this.p._activeMode == 2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, " not ACTIVE_RING!!");
    return -1;
    this.b.stopRing();
    g();
    this.p._activeMode = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(this.c));
    localHashMap.put("PARAM_OPERATION", this.d);
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.e);
    this.p.sendResBroadcast(localIntent, localHashMap, 4);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  void j()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(this.c));
    localHashMap.put("PARAM_OPERATION", "NOTIFY_RING_COMPLETION");
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.e);
    this.p.sendResBroadcast(localIntent, localHashMap, 0);
  }
  
  public void run()
  {
    AudioDeviceInterface.LogTraceEntry("");
    Looper.prepare();
    this.a = new TraeAudioManager.f.2(this);
    c();
    synchronized (this.f)
    {
      this.f[0] = true;
      this.f.notify();
      Looper.loop();
      f();
    }
    synchronized (this.f)
    {
      this.f[0] = false;
      this.f.notify();
      AudioDeviceInterface.LogTraceExit();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.f
 * JD-Core Version:    0.7.0.1
 */