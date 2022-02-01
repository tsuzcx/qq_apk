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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(11)
class TraeAudioManager$BluetoohHeadsetCheck
  extends TraeAudioManager.BluetoohHeadsetCheckInterface
  implements BluetoothProfile.ServiceListener
{
  BluetoothAdapter _adapter;
  Context _ctx;
  TraeAudioManager.DeviceConfigManager _devCfg;
  BluetoothProfile _profile;
  private final ReentrantLock _profileLock;
  
  TraeAudioManager$BluetoohHeadsetCheck(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
    AppMethodBeat.i(13806);
    this._ctx = null;
    this._devCfg = null;
    this._adapter = null;
    this._profile = null;
    this._profileLock = new ReentrantLock();
    AppMethodBeat.o(13806);
  }
  
  void _addAction(IntentFilter paramIntentFilter)
  {
    AppMethodBeat.i(13812);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " " + interfaceDesc() + " _addAction");
    }
    paramIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    paramIntentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
    paramIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
    AppMethodBeat.o(13812);
  }
  
  void _onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(13813);
    int i;
    int j;
    if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
      j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
      paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE " + getBTAdapterConnectionState(i));
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "    EXTRA_PREVIOUS_CONNECTION_STATE " + getBTAdapterConnectionState(j));
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
          break label252;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "   dev:" + paramIntent.getName() + " connected,start sco...");
        }
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
        localObject = this._devCfg;
        if (paramIntent == null) {
          break label246;
        }
      }
      label246:
      for (paramContext = paramIntent.getName();; paramContext = "unkown")
      {
        ((TraeAudioManager.DeviceConfigManager)localObject).setBluetoothName(paramContext);
        AppMethodBeat.o(13813);
        return;
        paramContext = " ";
        break;
      }
      label252:
      if (i == 0)
      {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
        AppMethodBeat.o(13813);
      }
    }
    else if ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
      j = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
      paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:".concat(String.valueOf(paramContext)));
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_STATE " + getSCOAudioStateExtraString(i));
      }
      if (QLog.isColorLevel())
      {
        QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_PREVIOUS_STATE " + getSCOAudioStateExtraString(j));
        AppMethodBeat.o(13813);
      }
    }
    else if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      paramContext = BluetoothAdapter.getDefaultAdapter();
    }
    switch (paramContext.getProfileConnectionState(2))
    {
    case 1: 
    default: 
      QLog.w("TRAE", 2, "BluetoothA2dp" + paramContext.getProfileConnectionState(2));
      AppMethodBeat.o(13813);
      return;
    case 2: 
      QLog.w("TRAE", 2, "BluetoothA2dp STATE_CONNECTED");
      this.this$0.IsBluetoothA2dpExisted = true;
      AppMethodBeat.o(13813);
      return;
    }
    QLog.w("TRAE", 2, "BluetoothA2dp STATE_DISCONNECTED");
    this.this$0.IsBluetoothA2dpExisted = false;
    AppMethodBeat.o(13813);
  }
  
  @TargetApi(11)
  public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    AppMethodBeat.i(13807);
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramContext == null) || (paramDeviceConfigManager == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " err ctx==null||_devCfg==null");
      }
      AppMethodBeat.o(13807);
      return false;
    }
    this._ctx = paramContext;
    this._devCfg = paramDeviceConfigManager;
    this._adapter = BluetoothAdapter.getDefaultAdapter();
    if (this._adapter == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " err getDefaultAdapter fail!");
      }
      AppMethodBeat.o(13807);
      return false;
    }
    this._profileLock.lock();
    try
    {
      if ((this._adapter.isEnabled()) && (this._profile == null) && (!this._adapter.getProfileProxy(this._ctx, this, 1)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
        }
        return false;
      }
      this._profileLock.unlock();
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(13807);
      return true;
    }
    finally
    {
      this._profileLock.unlock();
      AppMethodBeat.o(13807);
    }
  }
  
  public String interfaceDesc()
  {
    return "BluetoohHeadsetCheck";
  }
  
  public boolean isConnected()
  {
    boolean bool2 = false;
    AppMethodBeat.i(13809);
    this._profileLock.lock();
    boolean bool1 = bool2;
    try
    {
      if (this._profile != null)
      {
        List localList = this._profile.getConnectedDevices();
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
      this._profileLock.unlock();
      AppMethodBeat.o(13809);
    }
  }
  
  @TargetApi(11)
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    AppMethodBeat.i(13810);
    AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile + " profile:" + paramInt + " proxy:" + paramBluetoothProfile);
    if (paramInt == 1) {
      this._profileLock.lock();
    }
    for (;;)
    {
      try
      {
        if ((this._profile != null) && (this._profile != paramBluetoothProfile))
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "BluetoohHeadsetCheck: HEADSET Connected proxy:" + paramBluetoothProfile + " _profile:" + this._profile);
          }
          this._adapter.closeProfileProxy(1, this._profile);
          this._profile = null;
        }
        this._profile = paramBluetoothProfile;
        if (this._profile == null) {
          break label471;
        }
        paramBluetoothProfile = this._profile.getConnectedDevices();
        if ((paramBluetoothProfile != null) && (this._profile != null))
        {
          if (!QLog.isColorLevel()) {
            break label476;
          }
          QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Connected devs:" + paramBluetoothProfile.size() + " _profile:" + this._profile);
          break label476;
          if (paramInt < paramBluetoothProfile.size())
          {
            BluetoothDevice localBluetoothDevice = (BluetoothDevice)paramBluetoothProfile.get(paramInt);
            try
            {
              if (this._profile != null)
              {
                i = this._profile.getConnectionState(localBluetoothDevice);
                if (i == 2) {
                  this._devCfg.setBluetoothName(localBluetoothDevice.getName());
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
        this._profileLock.unlock();
        if (this._devCfg != null)
        {
          if (this.this$0._deviceConfigManager == null) {
            break label466;
          }
          paramBluetoothProfile = this.this$0._deviceConfigManager.getBluetoothName();
          if (TextUtils.isEmpty(paramBluetoothProfile)) {
            this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
          }
        }
        else
        {
          AudioDeviceInterface.LogTraceExit();
          AppMethodBeat.o(13810);
          return;
        }
      }
      finally
      {
        this._profileLock.unlock();
        AppMethodBeat.o(13810);
      }
      if (isConnected())
      {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
        this.this$0.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
      }
      else
      {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
        continue;
        label466:
        paramBluetoothProfile = null;
        continue;
        label471:
        paramBluetoothProfile = null;
        continue;
        label476:
        paramInt = 0;
      }
    }
  }
  
  @TargetApi(11)
  public void onServiceDisconnected(int paramInt)
  {
    AppMethodBeat.i(13811);
    AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile + " profile:" + paramInt);
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Disconnected");
      }
      if (isConnected()) {
        this.this$0.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", false);
      }
      this._profileLock.lock();
    }
    try
    {
      if (this._profile != null)
      {
        this._adapter.closeProfileProxy(1, this._profile);
        this._profile = null;
      }
      this._profileLock.unlock();
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(13811);
      return;
    }
    finally
    {
      this._profileLock.unlock();
      AppMethodBeat.o(13811);
    }
  }
  
  public void release()
  {
    AppMethodBeat.i(13808);
    AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile);
    this._profileLock.lock();
    try
    {
      if (this._adapter != null)
      {
        if (this._profile != null) {
          this._adapter.closeProfileProxy(1, this._profile);
        }
        this._profile = null;
      }
      this._profileLock.unlock();
      AudioDeviceInterface.LogTraceExit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, " closeProfileProxy:e:" + localException.getMessage());
        }
        this._profileLock.unlock();
      }
    }
    finally
    {
      this._profileLock.unlock();
      AppMethodBeat.o(13808);
    }
    AppMethodBeat.o(13808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheck
 * JD-Core Version:    0.7.0.1
 */