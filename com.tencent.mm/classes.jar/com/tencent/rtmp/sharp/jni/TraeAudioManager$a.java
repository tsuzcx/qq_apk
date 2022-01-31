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
import com.tencent.d.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(11)
class TraeAudioManager$a
  extends TraeAudioManager.d
  implements BluetoothProfile.ServiceListener
{
  Context a;
  TraeAudioManager.e b;
  BluetoothAdapter c;
  BluetoothProfile d;
  private final ReentrantLock f;
  
  TraeAudioManager$a(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
    AppMethodBeat.i(65611);
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.f = new ReentrantLock();
    AppMethodBeat.o(65611);
  }
  
  public void a()
  {
    AppMethodBeat.i(65613);
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
        a.dUd();
        a.iP("TRAE", " closeProfileProxy:e:" + localException.getMessage());
        this.f.unlock();
      }
    }
    finally
    {
      this.f.unlock();
      AppMethodBeat.o(65613);
    }
    AppMethodBeat.o(65613);
  }
  
  void a(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(65618);
    int i;
    int j;
    if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
      j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
      paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      a.dUd();
      a.iP("TRAE", "BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE " + c(i));
      a.dUd();
      a.iP("TRAE", "    EXTRA_PREVIOUS_CONNECTION_STATE " + c(j));
      a.dUd();
      Object localObject = new StringBuilder("    EXTRA_DEVICE ").append(paramIntent).append(" ");
      if (paramIntent != null)
      {
        paramContext = paramIntent.getName();
        a.iP("TRAE", paramContext);
        if (i != 2) {
          break label238;
        }
        a.dUd();
        a.iP("TRAE", "   dev:" + paramIntent.getName() + " connected,start sco...");
        this.b.a("DEVICE_BLUETOOTHHEADSET", true);
        localObject = this.b;
        if (paramIntent == null) {
          break label232;
        }
      }
      label232:
      for (paramContext = paramIntent.getName();; paramContext = "unkown")
      {
        ((TraeAudioManager.e)localObject).b(paramContext);
        AppMethodBeat.o(65618);
        return;
        paramContext = " ";
        break;
      }
      label238:
      if (i == 0)
      {
        this.b.a("DEVICE_BLUETOOTHHEADSET", false);
        AppMethodBeat.o(65618);
      }
    }
    else
    {
      if ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
        j = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
        paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        a.dUd();
        a.iP("TRAE", "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:".concat(String.valueOf(paramContext)));
        a.dUd();
        a.iP("TRAE", "   EXTRA_SCO_AUDIO_STATE " + b(i));
        a.dUd();
        a.iP("TRAE", "   EXTRA_SCO_AUDIO_PREVIOUS_STATE " + b(j));
        AppMethodBeat.o(65618);
        return;
      }
      if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction())) {
        paramContext = BluetoothAdapter.getDefaultAdapter();
      }
    }
    switch (paramContext.getProfileConnectionState(2))
    {
    case 1: 
    default: 
      a.iP("TRAE", "BluetoothA2dp" + paramContext.getProfileConnectionState(2));
      AppMethodBeat.o(65618);
      return;
    case 2: 
      a.iP("TRAE", "BluetoothA2dp STATE_CONNECTED");
      this.e.IsBluetoothA2dpExisted = true;
      AppMethodBeat.o(65618);
      return;
    }
    a.iP("TRAE", "BluetoothA2dp STATE_DISCONNECTED");
    this.e.IsBluetoothA2dpExisted = false;
    AppMethodBeat.o(65618);
  }
  
  void a(IntentFilter paramIntentFilter)
  {
    AppMethodBeat.i(65617);
    a.dUd();
    a.iP("TRAE", " " + c() + " _addAction");
    paramIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    paramIntentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
    paramIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
    AppMethodBeat.o(65617);
  }
  
  @TargetApi(11)
  public boolean a(Context paramContext, TraeAudioManager.e parame)
  {
    AppMethodBeat.i(65612);
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramContext == null) || (parame == null))
    {
      a.dUd();
      a.iO("TRAE", " err ctx==null||_devCfg==null");
      AppMethodBeat.o(65612);
      return false;
    }
    this.a = paramContext;
    this.b = parame;
    this.c = BluetoothAdapter.getDefaultAdapter();
    if (this.c == null)
    {
      a.dUd();
      a.iO("TRAE", " err getDefaultAdapter fail!");
      AppMethodBeat.o(65612);
      return false;
    }
    this.f.lock();
    try
    {
      if ((this.c.isEnabled()) && (this.d == null) && (!this.c.getProfileProxy(this.a, this, 1)))
      {
        a.dUd();
        a.iO("TRAE", "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
        return false;
      }
      this.f.unlock();
      AudioDeviceInterface.LogTraceExit();
      AppMethodBeat.o(65612);
      return true;
    }
    finally
    {
      this.f.unlock();
      AppMethodBeat.o(65612);
    }
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    AppMethodBeat.i(65614);
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
      AppMethodBeat.o(65614);
    }
  }
  
  public String c()
  {
    return "BluetoohHeadsetCheck";
  }
  
  @TargetApi(11)
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    AppMethodBeat.i(65615);
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
          a.dUd();
          a.iP("TRAE", "BluetoohHeadsetCheck: HEADSET Connected proxy:" + paramBluetoothProfile + " _profile:" + this.d);
          this.c.closeProfileProxy(1, this.d);
          this.d = null;
        }
        this.d = paramBluetoothProfile;
        if (this.d == null) {
          break label460;
        }
        paramBluetoothProfile = this.d.getConnectedDevices();
        if ((paramBluetoothProfile != null) && (this.d != null))
        {
          a.dUd();
          a.iP("TRAE", "TRAEBluetoohProxy: HEADSET Connected devs:" + paramBluetoothProfile.size() + " _profile:" + this.d);
          paramInt = 0;
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
                a.dUd();
                a.iP("TRAE", "   " + paramInt + " " + localBluetoothDevice.getName() + " ConnectionState:" + i);
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
            break label455;
          }
          paramBluetoothProfile = this.e._deviceConfigManager.d();
          if (TextUtils.isEmpty(paramBluetoothProfile)) {
            this.b.a("DEVICE_BLUETOOTHHEADSET", false);
          }
        }
        else
        {
          AudioDeviceInterface.LogTraceExit();
          AppMethodBeat.o(65615);
          return;
        }
      }
      finally
      {
        this.f.unlock();
        AppMethodBeat.o(65615);
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
        label455:
        paramBluetoothProfile = null;
        continue;
        label460:
        paramBluetoothProfile = null;
      }
    }
  }
  
  @TargetApi(11)
  public void onServiceDisconnected(int paramInt)
  {
    AppMethodBeat.i(65616);
    AudioDeviceInterface.LogTraceEntry("_profile:" + this.d + " profile:" + paramInt);
    if (paramInt == 1)
    {
      a.dUd();
      a.iP("TRAE", "TRAEBluetoohProxy: HEADSET Disconnected");
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
      AppMethodBeat.o(65616);
      return;
    }
    finally
    {
      this.f.unlock();
      AppMethodBeat.o(65616);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.a
 * JD-Core Version:    0.7.0.1
 */