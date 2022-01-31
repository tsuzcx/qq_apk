import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;
import java.util.List;

class alyq
  implements Runnable
{
  alyq(alyp paramalyp) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidBluetoothBluetoothProfile != null) {}
    for (;;)
    {
      try
      {
        List localList = this.a.jdField_a_of_type_AndroidBluetoothBluetoothProfile.getConnectedDevices();
        if (localList == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Connected devs:" + localList.size() + " _profile:" + this.a.jdField_a_of_type_AndroidBluetoothBluetoothProfile);
        }
        int i = 0;
        if (i >= localList.size()) {
          break;
        }
        BluetoothDevice localBluetoothDevice = (BluetoothDevice)localList.get(i);
        int j = this.a.jdField_a_of_type_AndroidBluetoothBluetoothProfile.getConnectionState(localBluetoothDevice);
        if (j == 2) {
          this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(localBluetoothDevice.getName());
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "   " + i + " " + localBluetoothDevice.getName() + " ConnectionState:" + j);
        }
        i += 1;
        continue;
        str = null;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "onServiceConnected.run e = " + localException);
        }
      }
    }
    if (this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager != null) {
      if (this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager == null) {
        break label346;
      }
    }
    label346:
    for (String str = this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a();; str = null)
    {
      if (TextUtils.isEmpty(str))
      {
        this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET", false);
        return;
      }
      if (this.a.a())
      {
        this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET", true);
        this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.a("DEVICE_BLUETOOTHHEADSET", true);
        return;
      }
      this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_BLUETOOTHHEADSET", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alyq
 * JD-Core Version:    0.7.0.1
 */