package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
    AudioDeviceInterface.LogTraceEntry("");
    if (this.c == null) {}
    for (;;)
    {
      return;
      try
      {
        localMethod = this.a.getDeclaredMethod("close", new Class[0]);
        if (localMethod == null) {
          continue;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          Method localMethod;
          localMethod.invoke(this.c, new Object[0]);
          label44:
          this.a = null;
          this.b = null;
          this.c = null;
          this.d = null;
          AudioDeviceInterface.LogTraceExit();
          return;
          localNoSuchMethodException = localNoSuchMethodException;
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "BTLooperThread _uninitHeadsetfor2x method close NoSuchMethodException");
          }
          Object localObject = null;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          break label44;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          break label44;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          break label44;
        }
      }
    }
  }
  
  void a(Context paramContext, Intent paramIntent)
  {
    int i;
    int j;
    int k;
    if ("android.bluetooth.headset.action.AUDIO_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
      j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
      k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "++ AUDIO_STATE_CHANGED|  STATE " + i);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "       PREVIOUS_STATE " + j);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "       AUDIO_STATE " + k);
      }
      if (k != 2) {}
    }
    do
    {
      do
      {
        this.f.a("DEVICE_BLUETOOTHHEADSET", true);
        do
        {
          return;
        } while (k != 0);
        this.f.a("DEVICE_BLUETOOTHHEADSET", false);
        return;
      } while (!"android.bluetooth.headset.action.STATE_CHANGED".equals(paramIntent.getAction()));
      i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
      j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
      k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "++ STATE_CHANGED|  STATE " + i);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "       PREVIOUS_STATE " + j);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "       AUDIO_STATE " + k);
      }
      if (k == 2)
      {
        this.f.a("DEVICE_BLUETOOTHHEADSET", true);
        return;
      }
    } while (k != 0);
    this.f.a("DEVICE_BLUETOOTHHEADSET", false);
  }
  
  void a(IntentFilter paramIntentFilter)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " " + c() + " _addAction");
    }
    paramIntentFilter.addAction("android.bluetooth.headset.action.AUDIO_STATE_CHANGED");
    paramIntentFilter.addAction("android.bluetooth.headset.action.STATE_CHANGED");
  }
  
  public boolean a(Context paramContext, TraeAudioManager.e parame)
  {
    AudioDeviceInterface.LogTraceEntry("");
    this.e = paramContext;
    this.f = parame;
    if ((this.e == null) || (this.f == null)) {}
    for (;;)
    {
      return false;
      try
      {
        this.a = Class.forName("android.bluetooth.BluetoothHeadset");
        if (this.a == null) {
          continue;
        }
      }
      catch (Exception parame)
      {
        try
        {
          this.b = Class.forName("android.bluetooth.BluetoothHeadset$ServiceListener");
        }
        catch (Exception parame)
        {
          try
          {
            this.d = this.a.getDeclaredMethod("getCurrentHeadset", new Class[0]);
            if (this.d == null) {
              continue;
            }
          }
          catch (NoSuchMethodException parame)
          {
            try
            {
              do
              {
                for (;;)
                {
                  this.c = this.a.getConstructor(new Class[] { Context.class, this.b }).newInstance(new Object[] { paramContext, null });
                  if (this.c == null) {
                    break;
                  }
                  this.f.a("DEVICE_BLUETOOTHHEADSET", b());
                  if (!b()) {
                    break label334;
                  }
                  this.f.a("DEVICE_BLUETOOTHHEADSET", true);
                  this.g.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
                  AudioDeviceInterface.LogTraceExit();
                  return true;
                  parame = parame;
                  if (QLog.isColorLevel())
                  {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset class not found");
                    continue;
                    parame = parame;
                    if (QLog.isColorLevel()) {
                      QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset.ServiceListener class not found:" + parame);
                    }
                  }
                }
                parame = parame;
              } while (!QLog.isColorLevel());
              QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset NoSuchMethodException");
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
                if (QLog.isColorLevel())
                {
                  QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor NoSuchMethodException");
                  continue;
                  label334:
                  this.f.a("DEVICE_BLUETOOTHHEADSET", false);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean b()
  {
    String str4 = null;
    if ((this.d == null) || (this.d == null)) {
      return false;
    }
    try
    {
      Object localObject = this.d.invoke(this.c, new Object[0]);
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
          break label149;
        }
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
    }
    label149:
    return false;
  }
  
  public String c()
  {
    return "BluetoohHeadsetCheckFor2x";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.c
 * JD-Core Version:    0.7.0.1
 */