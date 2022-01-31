package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.d.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TraeAudioManager$c
  extends TraeAudioManager.d
{
  Class<?> a = null;
  Class<?> b = null;
  Object c = null;
  Method d = null;
  Context e = null;
  TraeAudioManager.e f = null;
  
  TraeAudioManager$c(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public void a()
  {
    AppMethodBeat.i(65665);
    AudioDeviceInterface.LogTraceEntry("");
    if (this.c == null)
    {
      AppMethodBeat.o(65665);
      return;
    }
    Object localObject;
    try
    {
      Method localMethod = this.a.getDeclaredMethod("close", new Class[0]);
      if (localMethod == null)
      {
        AppMethodBeat.o(65665);
        return;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        a.dUd();
        a.iO("TRAE", "BTLooperThread _uninitHeadsetfor2x method close NoSuchMethodException");
        localObject = null;
      }
    }
    try
    {
      localObject.invoke(this.c, new Object[0]);
      label77:
      this.a = null;
      this.b = null;
      this.c = null;
      this.d = null;
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(65665);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label77;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label77;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label77;
    }
  }
  
  void a(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(65668);
    int i;
    int j;
    int k;
    if ("android.bluetooth.headset.action.AUDIO_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
      j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
      k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
      a.dUd();
      a.iP("TRAE", "++ AUDIO_STATE_CHANGED|  STATE ".concat(String.valueOf(i)));
      a.dUd();
      a.iP("TRAE", "       PREVIOUS_STATE ".concat(String.valueOf(j)));
      a.dUd();
      a.iP("TRAE", "       AUDIO_STATE ".concat(String.valueOf(k)));
      if (k == 2)
      {
        this.f.a("DEVICE_BLUETOOTHHEADSET", true);
        AppMethodBeat.o(65668);
        return;
      }
      if (k == 0)
      {
        this.f.a("DEVICE_BLUETOOTHHEADSET", false);
        AppMethodBeat.o(65668);
      }
    }
    else if ("android.bluetooth.headset.action.STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
      j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
      k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
      a.dUd();
      a.iP("TRAE", "++ STATE_CHANGED|  STATE ".concat(String.valueOf(i)));
      a.dUd();
      a.iP("TRAE", "       PREVIOUS_STATE ".concat(String.valueOf(j)));
      a.dUd();
      a.iP("TRAE", "       AUDIO_STATE ".concat(String.valueOf(k)));
      if (k == 2)
      {
        this.f.a("DEVICE_BLUETOOTHHEADSET", true);
        AppMethodBeat.o(65668);
        return;
      }
      if (k == 0) {
        this.f.a("DEVICE_BLUETOOTHHEADSET", false);
      }
    }
    AppMethodBeat.o(65668);
  }
  
  void a(IntentFilter paramIntentFilter)
  {
    AppMethodBeat.i(65667);
    a.dUd();
    a.iP("TRAE", " " + c() + " _addAction");
    paramIntentFilter.addAction("android.bluetooth.headset.action.AUDIO_STATE_CHANGED");
    paramIntentFilter.addAction("android.bluetooth.headset.action.STATE_CHANGED");
    AppMethodBeat.o(65667);
  }
  
  public boolean a(Context paramContext, TraeAudioManager.e parame)
  {
    AppMethodBeat.i(65664);
    AudioDeviceInterface.LogTraceEntry("");
    this.e = paramContext;
    this.f = parame;
    if ((this.e == null) || (this.f == null))
    {
      AppMethodBeat.o(65664);
      return false;
    }
    try
    {
      this.a = Class.forName("android.bluetooth.BluetoothHeadset");
      if (this.a == null)
      {
        AppMethodBeat.o(65664);
        return false;
      }
    }
    catch (Exception parame)
    {
      for (;;)
      {
        a.dUd();
        a.iO("TRAE", "BTLooperThread BluetoothHeadset class not found");
      }
      try
      {
        this.b = Class.forName("android.bluetooth.BluetoothHeadset$ServiceListener");
      }
      catch (Exception parame)
      {
        try
        {
          for (;;)
          {
            this.d = this.a.getDeclaredMethod("getCurrentHeadset", new Class[0]);
            if (this.d != null) {
              break;
            }
            AppMethodBeat.o(65664);
            return false;
            parame = parame;
            a.dUd();
            a.iO("TRAE", "BTLooperThread BluetoothHeadset.ServiceListener class not found:".concat(String.valueOf(parame)));
          }
        }
        catch (NoSuchMethodException parame)
        {
          for (;;)
          {
            a.dUd();
            a.iO("TRAE", "BTLooperThread BluetoothHeadset method getCurrentHeadset NoSuchMethodException");
          }
          try
          {
            this.c = this.a.getConstructor(new Class[] { Context.class, this.b }).newInstance(new Object[] { paramContext, null });
            if (this.c == null)
            {
              AppMethodBeat.o(65664);
              return false;
            }
          }
          catch (IllegalArgumentException paramContext)
          {
            for (;;)
            {
              a.dUd();
              a.iO("TRAE", "BTLooperThread BluetoothHeadset getConstructor IllegalArgumentException");
            }
          }
          catch (InstantiationException paramContext)
          {
            for (;;)
            {
              a.dUd();
              a.iO("TRAE", "BTLooperThread BluetoothHeadset getConstructor InstantiationException");
            }
          }
          catch (IllegalAccessException paramContext)
          {
            for (;;)
            {
              a.dUd();
              a.iO("TRAE", "BTLooperThread BluetoothHeadset getConstructor IllegalAccessException");
            }
          }
          catch (InvocationTargetException paramContext)
          {
            for (;;)
            {
              a.dUd();
              a.iO("TRAE", "BTLooperThread BluetoothHeadset getConstructor InvocationTargetException");
            }
          }
          catch (NoSuchMethodException paramContext)
          {
            for (;;)
            {
              a.dUd();
              a.iO("TRAE", "BTLooperThread BluetoothHeadset getConstructor NoSuchMethodException");
            }
            this.f.a("DEVICE_BLUETOOTHHEADSET", b());
            if (!b()) {
              break label339;
            }
          }
          this.f.a("DEVICE_BLUETOOTHHEADSET", true);
          this.g.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
        }
      }
    }
    for (;;)
    {
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(65664);
      return true;
      label339:
      this.f.a("DEVICE_BLUETOOTHHEADSET", false);
    }
  }
  
  public boolean b()
  {
    AppMethodBeat.i(65666);
    Object localObject1 = null;
    if ((this.d == null) || (this.d == null))
    {
      AppMethodBeat.o(65666);
      return false;
    }
    try
    {
      localObject2 = this.d.invoke(this.c, new Object[0]);
      localObject1 = localObject2;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject2;
        StringBuilder localStringBuilder;
        a.dUd();
        a.iP("TRAE", "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalArgumentException");
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        a.dUd();
        a.iP("TRAE", "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalAccessException");
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        a.dUd();
        a.iP("TRAE", "BTLooperThread BluetoothHeadset method getCurrentHeadset InvocationTargetException");
        continue;
        String str = "N";
      }
      label142:
      AppMethodBeat.o(65666);
    }
    a.dUd();
    localStringBuilder = new StringBuilder("BTLooperThread BluetoothHeadset method getCurrentHeadset res:");
    if (localObject1 != null)
    {
      localObject2 = " Y";
      a.iP("TRAE", (String)localObject2);
      if (localObject1 == null) {
        break label142;
      }
      AppMethodBeat.o(65666);
      return true;
    }
    return false;
  }
  
  public String c()
  {
    return "BluetoohHeadsetCheckFor2x";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.c
 * JD-Core Version:    0.7.0.1
 */