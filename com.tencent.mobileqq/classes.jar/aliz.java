import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.AudioDeviceInterface;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;
import java.util.List;

public class aliz
  extends aljd
  implements BluetoothProfile.ServiceListener
{
  BluetoothAdapter jdField_a_of_type_AndroidBluetoothBluetoothAdapter = null;
  BluetoothProfile jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
  Context jdField_a_of_type_AndroidContentContext = null;
  TraeAudioManager.DeviceConfigManager jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager = null;
  
  public aliz(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public String a()
  {
    return "BluetoohHeadsetCheck";
  }
  
  public void a()
  {
    AudioDeviceInterface.LogTraceEntry("_profile:" + this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
    try
    {
      if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null)
      {
        if (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) {
          this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        }
        this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
      }
      AudioDeviceInterface.LogTraceExit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, " closeProfileProxy:e:" + localException.getMessage());
        }
      }
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
        localObject = new StringBuilder().append("    EXTRA_DEVICE ").append(paramIntent).append(" ");
        if (paramIntent != null)
        {
          paramContext = paramIntent.getName();
          QLog.w("TRAE", 2, paramContext);
        }
      }
      else
      {
        if (i != 2) {
          break label268;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("   dev:");
          if (paramIntent == null) {
            break label256;
          }
          paramContext = paramIntent.getName();
          label197:
          QLog.w("TRAE", 2, paramContext + " connected,start sco...");
        }
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET", true);
        localObject = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager;
        if (paramIntent == null) {
          break label262;
        }
        paramContext = paramIntent.getName();
        label243:
        ((TraeAudioManager.DeviceConfigManager)localObject).a(paramContext);
      }
    }
    label256:
    label262:
    label268:
    label443:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramContext = " ";
              break;
              paramContext = "null";
              break label197;
              paramContext = "unkown";
              break label243;
            } while (i != 0);
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET", false);
            return;
            if (!"android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(paramIntent.getAction())) {
              break label443;
            }
            i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
            j = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
            paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 2, "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:" + paramContext);
            }
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_STATE " + b(i) + "  Bluetooth visible:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b("DEVICE_BLUETOOTHHEADSET"));
            }
          } while (!QLog.isColorLevel());
          QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_PREVIOUS_STATE " + b(j));
          return;
        } while (!"android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()));
        paramContext = BluetoothAdapter.getDefaultAdapter();
        QLog.w("TRAE", 2, "BluetoothA2dp STATE_CHANGE: " + paramContext.getProfileConnectionState(2));
      } while (paramContext.getProfileConnectionState(2) != 1);
      QLog.w("TRAE", 2, "BluetoothA2dp STATE_CONNECTING, Bluetooth visible: " + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b("DEVICE_BLUETOOTHHEADSET") + " ConnectedDev: " + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.d());
    } while ((!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b("DEVICE_BLUETOOTHHEADSET")) || (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.d().equals("DEVICE_BLUETOOTHHEADSET")));
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b("DEVICE_BLUETOOTHHEADSET", true);
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(true);
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a("DEVICE_BLUETOOTHHEADSET", true);
  }
  
  void a(IntentFilter paramIntentFilter)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " " + a() + " _addAction");
    }
    paramIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    paramIntentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
    paramIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) {
      try
      {
        List localList = this.jdField_a_of_type_AndroidBluetoothBluetoothProfile.getConnectedDevices();
        if (localList == null) {
          return false;
        }
        int i = localList.size();
        if (i > 0) {
          return true;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " isConnected e = " + localException);
        }
      }
    }
    return false;
  }
  
  public boolean a(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramContext == null) || (paramDeviceConfigManager == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, " err ctx==null||_devCfg==null");
      }
    }
    do
    {
      do
      {
        return false;
        this.jdField_a_of_type_AndroidContentContext = paramContext;
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager = paramDeviceConfigManager;
        this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TRAE", 2, " err getDefaultAdapter fail!");
      return false;
      if ((!this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.isEnabled()) || (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) || (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.getProfileProxy(this.jdField_a_of_type_AndroidContentContext, this, 1))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
    return false;
    AudioDeviceInterface.LogTraceExit();
    return true;
  }
  
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    if (paramInt == 1)
    {
      if ((this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) && (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != paramBluetoothProfile))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "BluetoohHeadsetCheck: HEADSET Connected proxy:" + paramBluetoothProfile + " _profile:" + this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        }
        this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
      }
      this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = paramBluetoothProfile;
      ThreadManager.post(new alja(this), 5, null, false);
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void onServiceDisconnected(int paramInt)
  {
    AudioDeviceInterface.LogTraceEntry("_profile:" + this.jdField_a_of_type_AndroidBluetoothBluetoothProfile + " profile:" + paramInt);
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Disconnected");
      }
      if (a()) {
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a("DEVICE_BLUETOOTHHEADSET", false);
      }
      if (this.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null)
      {
        this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, this.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        this.jdField_a_of_type_AndroidBluetoothBluetoothProfile = null;
      }
    }
    AudioDeviceInterface.LogTraceExit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aliz
 * JD-Core Version:    0.7.0.1
 */