package com.tencent.rtmp.sharp.jni;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.d.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;

class TraeAudioManager$f
  extends Thread
{
  Handler a;
  TraeMediaPlayer b;
  long c;
  String d;
  String e;
  final boolean[] f;
  boolean g;
  TraeAudioManager h;
  String i;
  int j;
  int k;
  long l;
  String m;
  AudioManager.OnAudioFocusChangeListener n;
  int o;
  
  public TraeAudioManager$f(TraeAudioManager arg1, TraeAudioManager paramTraeAudioManager2)
  {
    AppMethodBeat.i(65674);
    this.a = null;
    this.b = null;
    this.c = -1L;
    this.d = "";
    this.e = "";
    this.f = new boolean[] { false };
    this.g = false;
    this.h = null;
    this.i = "";
    this.j = 0;
    this.k = 0;
    this.l = -1L;
    this.m = "";
    this.n = null;
    this.o = 0;
    this.h = paramTraeAudioManager2;
    long l1 = SystemClock.elapsedRealtime();
    a.dUd();
    a.iO("TRAE", "TraeAudioManagerLooper start...");
    start();
    synchronized (this.f)
    {
      int i1 = this.f[0];
      if (i1 != 0) {}
    }
    try
    {
      this.f.wait(3000L);
      label157:
      a.dUd();
      a.iO("TRAE", "  start used:" + (SystemClock.elapsedRealtime() - l1) + "ms");
      AppMethodBeat.o(65674);
      return;
      paramTraeAudioManager2 = finally;
      AppMethodBeat.o(65674);
      throw paramTraeAudioManager2;
    }
    catch (InterruptedException paramTraeAudioManager2)
    {
      break label157;
    }
  }
  
  public int a(int paramInt, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(65676);
    if (this.a == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(" fail mMsgHandler==null _enabled:");
      if (this.g) {}
      for (paramHashMap = "Y";; paramHashMap = "N")
      {
        AudioDeviceInterface.LogTraceEntry(paramHashMap + " activeMode:" + this.p._activeMode + " msg:" + paramInt);
        AppMethodBeat.o(65676);
        return -1;
      }
    }
    paramHashMap = Message.obtain(this.a, paramInt, paramHashMap);
    if (this.a.sendMessage(paramHashMap))
    {
      AppMethodBeat.o(65676);
      return 0;
    }
    AppMethodBeat.o(65676);
    return -1;
  }
  
  int a(boolean paramBoolean)
  {
    AppMethodBeat.i(65679);
    if (this.p._context == null)
    {
      AppMethodBeat.o(65679);
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_SERVICE_STATE");
    localIntent.putExtra("NOTIFY_SERVICE_STATE_DATE", paramBoolean);
    if (this.p._context != null) {
      this.p._context.sendBroadcast(localIntent);
    }
    AppMethodBeat.o(65679);
    return 0;
  }
  
  public void a()
  {
    AppMethodBeat.i(65675);
    AudioDeviceInterface.LogTraceEntry("");
    if (this.a == null)
    {
      AppMethodBeat.o(65675);
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
      label68:
      a.dUd();
      a.iO("TRAE", "  quit used:" + (SystemClock.elapsedRealtime() - l1) + "ms");
      this.a = null;
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(65675);
      return;
      localObject = finally;
      AppMethodBeat.o(65675);
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label68;
    }
  }
  
  @TargetApi(8)
  void a(int paramInt)
  {
    AppMethodBeat.i(65686);
    if (Build.VERSION.SDK_INT <= 8)
    {
      AppMethodBeat.o(65686);
      return;
    }
    if (this.n == null)
    {
      this.n = new TraeAudioManager.f.3(this);
      if (this.p._am != null) {
        try
        {
          int i1 = this.p._am.requestAudioFocus(this.n, paramInt, 1);
          if (i1 != 1)
          {
            a.dUd();
            a.iO("TRAE", "request audio focus fail. " + i1 + " mode:" + this.p._am.getMode());
          }
          this.o = paramInt;
          a.dUd();
          a.iP("TRAE", "-------requestAudioFocus _focusSteamType:" + this.o);
          AppMethodBeat.o(65686);
          return;
        }
        catch (SecurityException localSecurityException)
        {
          a.dUd();
          a.iO("TRAE", "request audio focus exception. ".concat(String.valueOf(localSecurityException)));
        }
      }
    }
    AppMethodBeat.o(65686);
  }
  
  void a(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(65677);
    String str = (String)paramHashMap.get("EXTRA_DATA_DEVICECONFIG");
    StringBuilder localStringBuilder = new StringBuilder(" _enabled:");
    if (this.g) {}
    for (paramHashMap = "Y";; paramHashMap = "N")
    {
      AudioDeviceInterface.LogTraceEntry(paramHashMap + " activeMode:" + this.p._activeMode + " cfg:" + str);
      if (this.p._context != null) {
        break;
      }
      AppMethodBeat.o(65677);
      return;
    }
    a.iP("TRAE", "   startService:".concat(String.valueOf(str)));
    if (((this.g) && (this.i.equals(str))) || (this.p._activeMode != 0))
    {
      AppMethodBeat.o(65677);
      return;
    }
    if (this.g) {
      c();
    }
    e();
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
    AppMethodBeat.o(65677);
  }
  
  int b(int paramInt)
  {
    AppMethodBeat.i(65694);
    if (this.p._context == null)
    {
      AppMethodBeat.o(65694);
      return -1;
    }
    new Handler(Looper.getMainLooper()).post(new TraeAudioManager.f.4(this, paramInt));
    AppMethodBeat.o(65694);
    return 0;
  }
  
  int b(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(65685);
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
    AppMethodBeat.o(65685);
    return 0;
  }
  
  boolean b()
  {
    AppMethodBeat.i(146944);
    if (Build.MANUFACTURER.equals("Xiaomi"))
    {
      if (Build.MODEL.equals("MI 5"))
      {
        AppMethodBeat.o(146944);
        return true;
      }
      if (Build.MODEL.equals("MI 5s"))
      {
        AppMethodBeat.o(146944);
        return true;
      }
      if (Build.MODEL.equals("MI 5s Plus"))
      {
        AppMethodBeat.o(146944);
        return true;
      }
    }
    AppMethodBeat.o(146944);
    return false;
  }
  
  int c(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(65688);
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode);
    if (paramHashMap == null)
    {
      AppMethodBeat.o(65688);
      return -1;
    }
    if (this.p._am == null)
    {
      a.dUd();
      a.iO("TRAE", " InternalVoicecallPreprocess am==null!!");
      AppMethodBeat.o(65688);
      return -1;
    }
    if (this.p._activeMode == 1)
    {
      localObject = new Intent();
      this.p.sendResBroadcast((Intent)localObject, paramHashMap, 2);
      AppMethodBeat.o(65688);
      return -1;
    }
    this.l = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
    this.m = ((String)paramHashMap.get("PARAM_OPERATION"));
    this.p._activeMode = 1;
    this.p._prevMode = this.p._am.getMode();
    Object localObject = (Integer)paramHashMap.get("PARAM_MODEPOLICY");
    if (localObject == null)
    {
      a.dUd();
      a.iO("TRAE", " params.get(PARAM_MODEPOLICY)==null!!");
      this.p._modePolicy = -1;
      a.dUd();
      a.iO("TRAE", "  _modePolicy:" + this.p._modePolicy);
      localObject = (Integer)paramHashMap.get("PARAM_STREAMTYPE");
      if (localObject != null) {
        break label378;
      }
      a.dUd();
      a.iO("TRAE", " params.get(PARAM_STREAMTYPE)==null!!");
      this.p._streamType = 0;
      label268:
      if ((!TraeAudioManager.isCloseSystemAPM(this.p._modePolicy)) || (this.p._activeMode == 2) || (this.p._deviceConfigManager == null)) {
        break label408;
      }
      if (!this.p._deviceConfigManager.h().equals("DEVICE_SPEAKERPHONE")) {
        break label392;
      }
      this.p.InternalSetMode(0);
      a(3);
    }
    for (;;)
    {
      localObject = new Intent();
      this.p.sendResBroadcast((Intent)localObject, paramHashMap, 0);
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(65688);
      return 0;
      this.p._modePolicy = ((Integer)localObject).intValue();
      break;
      label378:
      this.p._streamType = ((Integer)localObject).intValue();
      break label268;
      label392:
      this.p.InternalSetMode(3);
      a(0);
      continue;
      label408:
      this.p.InternalSetMode(TraeAudioManager.getCallAudioMode(this.p._modePolicy));
      a(this.p._streamType);
    }
  }
  
  void c()
  {
    AppMethodBeat.i(65681);
    StringBuilder localStringBuilder = new StringBuilder(" _enabled:");
    if (this.g) {}
    for (String str = "Y";; str = "N")
    {
      AudioDeviceInterface.LogTraceEntry(str + " activeMode:" + this.p._activeMode);
      if (this.g) {
        break;
      }
      AppMethodBeat.o(65681);
      return;
    }
    if (this.p._activeMode == 1) {
      i();
    }
    for (;;)
    {
      if (this.p._switchThread != null)
      {
        a.dUd();
        a.iP("TRAE", "_switchThread:" + this.p._switchThread.b());
        this.p._switchThread.g();
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
        if (b())
        {
          a.iP("TRAE", "NeedForceVolumeType: AudioManager.STREAM_MUSIC");
          TraeAudioManager.forceVolumeControlStream(this.p._am, 3);
        }
        label239:
        f();
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(65681);
        return;
        if (this.p._activeMode != 2) {
          continue;
        }
        j();
      }
      catch (Exception localException)
      {
        break label239;
      }
    }
  }
  
  int d(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(65689);
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode);
    if (this.p._am == null)
    {
      a.dUd();
      a.iO("TRAE", " InternalVoicecallPostprocess am==null!!");
      AppMethodBeat.o(65689);
      return -1;
    }
    if (this.p._activeMode != 1)
    {
      a.dUd();
      a.iO("TRAE", " not ACTIVE_VOICECALL!!");
      Intent localIntent = new Intent();
      this.p.sendResBroadcast(localIntent, paramHashMap, 3);
      AppMethodBeat.o(65689);
      return -1;
    }
    this.p._activeMode = 0;
    h();
    AudioDeviceInterface.LogTraceExit();
    AppMethodBeat.o(65689);
    return 0;
  }
  
  void d()
  {
    AppMethodBeat.i(65682);
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
      AppMethodBeat.o(65682);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.dUd();
        a.iP("TRAE", "======7");
      }
    }
  }
  
  int e(HashMap<String, Object> paramHashMap)
  {
    boolean bool1 = true;
    AppMethodBeat.i(65691);
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode);
    if (this.p._am == null)
    {
      a.dUd();
      a.iO("TRAE", " InternalStartRing am==null!!");
      AppMethodBeat.o(65691);
      return -1;
    }
    if (this.p._activeMode == 2) {
      j();
    }
    for (;;)
    {
      try
      {
        this.c = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
        this.d = ((String)paramHashMap.get("PARAM_OPERATION"));
        this.e = ((String)paramHashMap.get("PARAM_RING_USERDATA_STRING"));
        int i1 = ((Integer)paramHashMap.get("PARAM_RING_DATASOURCE")).intValue();
        a.dUd();
        a.iP("TRAE", "  dataSource:".concat(String.valueOf(i1)));
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
          a.dUd();
          a.iP("TRAE", " _ringUserdata:" + this.e + " DurationMS:" + this.b.getDuration());
          if (!this.b.hasCall()) {
            a(this.b.getStreamType());
          }
          b(this.b.getStreamType());
          AudioDeviceInterface.LogTraceExit();
          AppMethodBeat.o(65691);
          return 0;
        }
      }
      catch (Exception paramHashMap)
      {
        a.dUd();
        a.iO("TRAE", " startRing err params");
        AppMethodBeat.o(65691);
        return -1;
      }
      bool1 = false;
    }
  }
  
  void e()
  {
    AppMethodBeat.i(65683);
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
      AppMethodBeat.o(65683);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(65683);
    }
  }
  
  int f(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(65692);
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode + " _preRingMode:" + this.k);
    if ((this.p._am == null) || (this.b == null))
    {
      a.dUd();
      a.iO("TRAE", " InternalStopRing am==null!!");
      AppMethodBeat.o(65692);
      return -1;
    }
    this.b.stopRing();
    if ((!this.b.hasCall()) && (this.p._activeMode == 2))
    {
      h();
      this.p._activeMode = 0;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.e);
    this.p.sendResBroadcast(localIntent, paramHashMap, 0);
    AudioDeviceInterface.LogTraceExit();
    AppMethodBeat.o(65692);
    return 0;
  }
  
  void f()
  {
    AppMethodBeat.i(65684);
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
      AppMethodBeat.o(65684);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(65684);
    }
  }
  
  int g(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(65693);
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode + " _preRingMode:" + this.k);
    if (this.p._am == null)
    {
      a.dUd();
      a.iO("TRAE", " InternalStopRing am==null!!");
      AppMethodBeat.o(65693);
      return -1;
    }
    if (this.p._activeMode == 2) {}
    for (int i1 = this.b.getStreamType();; i1 = this.p._streamType)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("EXTRA_DATA_STREAMTYPE", i1);
      this.p.sendResBroadcast(localIntent, paramHashMap, 0);
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(65693);
      return 0;
    }
  }
  
  void g()
  {
    AppMethodBeat.i(65687);
    AudioDeviceInterface.LogTraceEntry("");
    try
    {
      c();
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
      label103:
      AudioDeviceInterface.LogTraceExit();
    }
    catch (Exception localException)
    {
      break label103;
    }
    AppMethodBeat.o(65687);
  }
  
  @TargetApi(8)
  void h()
  {
    AppMethodBeat.i(146945);
    if (Build.VERSION.SDK_INT <= 8)
    {
      AppMethodBeat.o(146945);
      return;
    }
    if ((this.p._am != null) && (this.n != null))
    {
      a.dUd();
      a.iP("TRAE", "-------abandonAudioFocus _focusSteamType:" + this.o);
      this.p._am.abandonAudioFocus(this.n);
      this.n = null;
    }
    AppMethodBeat.o(146945);
  }
  
  int i()
  {
    AppMethodBeat.i(65695);
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode);
    if (this.p._am == null)
    {
      a.dUd();
      a.iO("TRAE", " am==null!!");
      AppMethodBeat.o(65695);
      return -1;
    }
    if (this.p._activeMode != 1)
    {
      a.dUd();
      a.iO("TRAE", " not ACTIVE_RING!!");
      AppMethodBeat.o(65695);
      return -1;
    }
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
    AppMethodBeat.o(65695);
    return 0;
  }
  
  int j()
  {
    AppMethodBeat.i(146946);
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.p._activeMode + " _preRingMode:" + this.k);
    if (this.p._am == null)
    {
      a.dUd();
      a.iO("TRAE", " interruptRing am==null!!");
      AppMethodBeat.o(146946);
      return -1;
    }
    if (this.p._activeMode != 2)
    {
      a.dUd();
      a.iO("TRAE", " not ACTIVE_RING!!");
      AppMethodBeat.o(146946);
      return -1;
    }
    this.b.stopRing();
    h();
    this.p._activeMode = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(this.c));
    localHashMap.put("PARAM_OPERATION", this.d);
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.e);
    this.p.sendResBroadcast(localIntent, localHashMap, 4);
    AudioDeviceInterface.LogTraceExit();
    AppMethodBeat.o(146946);
    return 0;
  }
  
  void k()
  {
    AppMethodBeat.i(146947);
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(this.c));
    localHashMap.put("PARAM_OPERATION", "NOTIFY_RING_COMPLETION");
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.e);
    this.p.sendResBroadcast(localIntent, localHashMap, 0);
    AppMethodBeat.o(146947);
  }
  
  public void run()
  {
    AppMethodBeat.i(65680);
    AudioDeviceInterface.LogTraceEntry("");
    Looper.prepare();
    this.a = new TraeAudioManager.f.2(this);
    d();
    synchronized (this.f)
    {
      this.f[0] = true;
      this.f.notifyAll();
      Looper.loop();
      g();
    }
    synchronized (this.f)
    {
      this.f[0] = false;
      this.f.notifyAll();
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(65680);
      return;
      localObject1 = finally;
      AppMethodBeat.o(65680);
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.f
 * JD-Core Version:    0.7.0.1
 */