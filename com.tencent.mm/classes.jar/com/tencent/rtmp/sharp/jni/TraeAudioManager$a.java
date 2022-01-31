package com.tencent.rtmp.sharp.jni;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(11)
class TraeAudioManager$a
  extends TraeAudioManager.d
  implements BluetoothProfile.ServiceListener
{
  Context a = null;
  TraeAudioManager.e b = null;
  BluetoothAdapter c = null;
  BluetoothProfile d = null;
  private final ReentrantLock f = new ReentrantLock();
  
  TraeAudioManager$a(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public void a()
  {
    AudioDeviceInterface.LogTraceEntry("_profile:" + this.d);
    this.f.lock();
    try
    {
      if (this.c != null)
      {
        if (this.d != null) {
          this.c.closeProfileProxy(1, this.d);
        }
        this.d = null;
      }
      this.f.unlock();
      AudioDeviceInterface.LogTraceExit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, " closeProfileProxy:e:" + localException.getMessage());
        }
        this.f.unlock();
      }
    }
    finally
    {
      this.f.unlock();
    }
  }
  
  void a(Context paramContext, Intent paramIntent)
  {
    int i;
    int j;
    if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
      j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
      paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE " + c(i));
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "    EXTRA_PREVIOUS_CONNECTION_STATE " + c(j));
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("    EXTRA_DEVICE ").append(paramIntent).append(" ");
        if (paramIntent != null)
        {
          paramContext = paramIntent.getName();
          QLog.w("TRAE", 2, paramContext);
        }
      }
      else
      {
        if (i != 2) {
          break label240;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "   dev:" + paramIntent.getName() + " connected,start sco...");
        }
        this.b.a("DEVICE_BLUETOOTHHEADSET", true);
        localObject = this.b;
        if (paramIntent == null) {
          break label234;
        }
        paramContext = paramIntent.getName();
        label221:
        ((TraeAudioManager.e)localObject).b(paramContext);
      }
    }
    label234:
    label240:
    do
    {
      do
      {
        do
        {
          return;
          paramContext = " ";
          break;
          paramContext = "unkown";
          break label221;
        } while (i != 0);
        this.b.a("DEVICE_BLUETOOTHHEADSET", false);
        return;
        if (!"android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(paramIntent.getAction())) {
          break label389;
        }
        i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
        j = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
        paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:" + paramContext);
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_STATE " + b(i));
        }
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_PREVIOUS_STATE " + b(j));
      return;
    } while (!"android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()));
    label389:
    paramContext = BluetoothAdapter.getDefaultAdapter();
    switch (paramContext.getProfileConnectionState(2))
    {
    case 1: 
    default: 
      QLog.w("TRAE", 2, "BluetoothA2dp" + paramContext.getProfileConnectionState(2));
      return;
    case 2: 
      QLog.w("TRAE", 2, "BluetoothA2dp STATE_CONNECTED");
      this.e.IsBluetoothA2dpExisted = true;
      return;
    }
    QLog.w("TRAE", 2, "BluetoothA2dp STATE_DISCONNECTED");
    this.e.IsBluetoothA2dpExisted = false;
  }
  
  void a(IntentFilter paramIntentFilter)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " " + c() + " _addAction");
    }
    paramIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    paramIntentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
    paramIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
  }
  
  @TargetApi(11)
  public boolean a(Context paramContext, TraeAudioManager.e parame)
  {
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramContext == null) || (parame == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " err ctx==null||_devCfg==null");
      }
    }
    do
    {
      return false;
      this.a = paramContext;
      this.b = parame;
      this.c = BluetoothAdapter.getDefaultAdapter();
      if (this.c != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, " err getDefaultAdapter fail!");
    return false;
    this.f.lock();
    try
    {
      if ((this.c.isEnabled()) && (this.d == null) && (!this.c.getProfileProxy(this.a, this, 1)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
        }
        return false;
      }
      this.f.unlock();
      AudioDeviceInterface.LogTraceExit();
      return true;
    }
    finally
    {
      this.f.unlock();
    }
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    this.f.lock();
    boolean bool1 = bool2;
    try
    {
      if (this.d != null)
      {
        List localList = this.d.getConnectedDevices();
        if (localList == null) {
          return false;
        }
        int i = localList.size();
        bool1 = bool2;
        if (i > 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally
    {
      this.f.unlock();
    }
  }
  
  public String c()
  {
    return "BluetoohHeadsetCheck";
  }
  
  @TargetApi(11)
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    AudioDeviceInterface.LogTraceEntry("_profile:" + this.d + " profile:" + paramInt + " proxy:" + paramBluetoothProfile);
    if (paramInt == 1) {
      this.f.lock();
    }
    for (;;)
    {
      try
      {
        if ((this.d != null) && (this.d != paramBluetoothProfile))
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "BluetoohHeadsetCheck: HEADSET Connected proxy:" + paramBluetoothProfile + " _profile:" + this.d);
          }
          this.c.closeProfileProxy(1, this.d);
          this.d = null;
        }
        this.d = paramBluetoothProfile;
        if (this.d == null) {
          break label446;
        }
        paramBluetoothProfile = this.d.getConnectedDevices();
        if ((paramBluetoothProfile != null) && (this.d != null))
        {
          if (!QLog.isColorLevel()) {
            break label451;
          }
          QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Connected devs:" + paramBluetoothProfile.size() + " _profile:" + this.d);
          break label451;
          if (paramInt < paramBluetoothProfile.size())
          {
            BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramBluetoothProfile.get(paramInt);
            try
            {
              if (this.d != null)
              {
                i = this.d.getConnectionState(localBluetoothDevice);
                if (i == 2) {
                  this.b.b(localBluetoothDevice.getName());
                }
                if (QLog.isColorLevel()) {
                  QLog.w("TRAE", 2, "   " + paramInt + " " + localBluetoothDevice.getName() + " ConnectionState:" + i);
                }
                paramInt += 1;
              }
            }
            catch (Exception localException)
            {
              int i = 0;
              continue;
            }
          }
        }
        this.f.unlock();
        if (this.b != null)
        {
          if (this.e._deviceConfigManager == null) {
            break label441;
          }
          paramBluetoothProfile = this.e._deviceConfigManager.d();
          if (TextUtils.isEmpty(paramBluetoothProfile)) {
            this.b.a("DEVICE_BLUETOOTHHEADSET", false);
          }
        }
        else
        {
          AudioDeviceInterface.LogTraceExit();
          return;
        }
      }
      finally
      {
        this.f.unlock();
      }
      if (b())
      {
        this.b.a("DEVICE_BLUETOOTHHEADSET", true);
        this.e.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
      }
      else
      {
        this.b.a("DEVICE_BLUETOOTHHEADSET", false);
        continue;
        label441:
        paramBluetoothProfile = null;
        continue;
        label446:
        paramBluetoothProfile = null;
        continue;
        label451:
        paramInt = 0;
      }
    }
  }
  
  @TargetApi(11)
  public void onServiceDisconnected(int paramInt)
  {
    AudioDeviceInterface.LogTraceEntry("_profile:" + this.d + " profile:" + paramInt);
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Disconnected");
      }
      if (b()) {
        this.e.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", false);
      }
      this.f.lock();
    }
    try
    {
      if (this.d != null)
      {
        this.c.closeProfileProxy(1, this.d);
        this.d = null;
      }
      this.f.unlock();
      AudioDeviceInterface.LogTraceExit();
      return;
    }
    finally
    {
      this.f.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.a
 * JD-Core Version:    0.7.0.1
 */