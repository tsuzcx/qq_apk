package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TraeAudioManager$BluetoohHeadsetCheckFor2x
  extends TraeAudioManager.BluetoohHeadsetCheckInterface
{
  public static final String ACTION_BLUETOOTHHEADSET_AUDIO_STATE_CHANGED = "android.bluetooth.headset.action.AUDIO_STATE_CHANGED";
  public static final String ACTION_BLUETOOTHHEADSET_STATE_CHANGED = "android.bluetooth.headset.action.STATE_CHANGED";
  public static final int AUDIO_STATE_CONNECTED = 1;
  public static final int AUDIO_STATE_DISCONNECTED = 0;
  static final int STATE_CONNECTED = 2;
  static final int STATE_DISCONNECTED = 0;
  Class<?> BluetoothHeadsetClass = null;
  Object BluetoothHeadsetObj = null;
  Class<?> ListenerClass = null;
  Context _ctx = null;
  TraeAudioManager.DeviceConfigManager _devCfg = null;
  Method getCurrentHeadsetMethod = null;
  
  TraeAudioManager$BluetoohHeadsetCheckFor2x(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  void _addAction(IntentFilter paramIntentFilter)
  {
    AppMethodBeat.i(13794);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " " + interfaceDesc() + " _addAction");
    }
    paramIntentFilter.addAction("android.bluetooth.headset.action.AUDIO_STATE_CHANGED");
    paramIntentFilter.addAction("android.bluetooth.headset.action.STATE_CHANGED");
    AppMethodBeat.o(13794);
  }
  
  void _onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(13795);
    int i;
    int j;
    int k;
    if ("android.bluetooth.headset.action.AUDIO_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
      j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
      k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "++ AUDIO_STATE_CHANGED|  STATE ".concat(String.valueOf(i)));
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "       PREVIOUS_STATE ".concat(String.valueOf(j)));
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "       AUDIO_STATE ".concat(String.valueOf(k)));
      }
      if (k == 2)
      {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
        AppMethodBeat.o(13795);
        return;
      }
      if (k == 0)
      {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
        AppMethodBeat.o(13795);
      }
    }
    else if ("android.bluetooth.headset.action.STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
      j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
      k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "++ STATE_CHANGED|  STATE ".concat(String.valueOf(i)));
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "       PREVIOUS_STATE ".concat(String.valueOf(j)));
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "       AUDIO_STATE ".concat(String.valueOf(k)));
      }
      if (k == 2)
      {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
        AppMethodBeat.o(13795);
        return;
      }
      if (k == 0) {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
      }
    }
    AppMethodBeat.o(13795);
  }
  
  public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    AppMethodBeat.i(13791);
    AudioDeviceInterface.LogTraceEntry("");
    this._ctx = paramContext;
    this._devCfg = paramDeviceConfigManager;
    if ((this._ctx == null) || (this._devCfg == null))
    {
      AppMethodBeat.o(13791);
      return false;
    }
    try
    {
      this.BluetoothHeadsetClass = Class.forName("android.bluetooth.BluetoothHeadset");
      if (this.BluetoothHeadsetClass == null)
      {
        AppMethodBeat.o(13791);
        return false;
      }
    }
    catch (Exception paramDeviceConfigManager)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset class not found");
        }
      }
      try
      {
        this.ListenerClass = Class.forName("android.bluetooth.BluetoothHeadset$ServiceListener");
      }
      catch (Exception paramDeviceConfigManager)
      {
        try
        {
          for (;;)
          {
            this.getCurrentHeadsetMethod = this.BluetoothHeadsetClass.getDeclaredMethod("getCurrentHeadset", new Class[0]);
            if (this.getCurrentHeadsetMethod != null) {
              break;
            }
            AppMethodBeat.o(13791);
            return false;
            paramDeviceConfigManager = paramDeviceConfigManager;
            if (QLog.isColorLevel()) {
              QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset.ServiceListener class not found:".concat(String.valueOf(paramDeviceConfigManager)));
            }
          }
        }
        catch (NoSuchMethodException paramDeviceConfigManager)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset NoSuchMethodException");
            }
          }
          try
          {
            this.BluetoothHeadsetObj = this.BluetoothHeadsetClass.getConstructor(new Class[] { Context.class, this.ListenerClass }).newInstance(new Object[] { paramContext, null });
            if (this.BluetoothHeadsetObj == null)
            {
              AppMethodBeat.o(13791);
              return false;
            }
          }
          catch (IllegalArgumentException paramContext)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalArgumentException");
              }
            }
          }
          catch (InstantiationException paramContext)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor InstantiationException");
              }
            }
          }
          catch (IllegalAccessException paramContext)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalAccessException");
              }
            }
          }
          catch (InvocationTargetException paramContext)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor InvocationTargetException");
              }
            }
          }
          catch (NoSuchMethodException paramContext)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor NoSuchMethodException");
              }
            }
            this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", isConnected());
            if (!isConnected()) {
              break label369;
            }
          }
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
          this.this$0.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
        }
      }
    }
    for (;;)
    {
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(13791);
      return true;
      label369:
      this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
    }
  }
  
  public String interfaceDesc()
  {
    return "BluetoohHeadsetCheckFor2x";
  }
  
  public boolean isConnected()
  {
    AppMethodBeat.i(13793);
    String str4 = null;
    if ((this.getCurrentHeadsetMethod == null) || (this.getCurrentHeadsetMethod == null))
    {
      AppMethodBeat.o(13793);
      return false;
    }
    try
    {
      Object localObject = this.getCurrentHeadsetMethod.invoke(this.BluetoothHeadsetObj, new Object[0]);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("BTLooperThread BluetoothHeadset method getCurrentHeadset res:");
        if (localObject != null)
        {
          str4 = " Y";
          QLog.w("TRAE", 2, str4);
        }
      }
      else
      {
        if (localObject == null) {
          break label167;
        }
        AppMethodBeat.o(13793);
        return true;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        String str1 = str4;
        if (QLog.isColorLevel())
        {
          QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalArgumentException");
          str1 = str4;
        }
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        String str2 = str4;
        if (QLog.isColorLevel())
        {
          QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalAccessException");
          str2 = str4;
        }
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        String str3 = str4;
        if (QLog.isColorLevel())
        {
          QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset InvocationTargetException");
          str3 = str4;
          continue;
          str4 = "N";
        }
      }
      label167:
      AppMethodBeat.o(13793);
    }
    return false;
  }
  
  public void release()
  {
    AppMethodBeat.i(13792);
    AudioDeviceInterface.LogTraceEntry("");
    if (this.BluetoothHeadsetObj == null)
    {
      AppMethodBeat.o(13792);
      return;
    }
    Object localObject;
    try
    {
      Method localMethod = this.BluetoothHeadsetClass.getDeclaredMethod("close", new Class[0]);
      if (localMethod == null)
      {
        AppMethodBeat.o(13792);
        return;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "BTLooperThread _uninitHeadsetfor2x method close NoSuchMethodException");
        }
        localObject = null;
      }
    }
    try
    {
      localObject.invoke(this.BluetoothHeadsetObj, new Object[0]);
      label85:
      this.BluetoothHeadsetClass = null;
      this.ListenerClass = null;
      this.BluetoothHeadsetObj = null;
      this.getCurrentHeadsetMethod = null;
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(13792);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label85;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label85;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label85;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheckFor2x
 * JD-Core Version:    0.7.0.1
 */