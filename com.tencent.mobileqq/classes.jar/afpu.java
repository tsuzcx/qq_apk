import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import java.util.List;

public class afpu
  implements BluetoothProfile.ServiceListener
{
  public afpu(AudioPlayer paramAudioPlayer, String paramString, int paramInt, BluetoothAdapter paramBluetoothAdapter) {}
  
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    Object localObject;
    if (paramInt == 1)
    {
      paramBluetoothProfile = (BluetoothHeadset)paramBluetoothProfile;
      localObject = paramBluetoothProfile.getConnectedDevices();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label93;
      }
      localObject = (BluetoothDevice)((List)localObject).get(0);
      if ((localObject != null) && (((BluetoothDevice)localObject).getBluetoothClass() != null)) {
        break label80;
      }
      com.tencent.mobileqq.activity.aio.AudioPlayerBase.b = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, paramBluetoothProfile);
      return;
      label80:
      com.tencent.mobileqq.activity.aio.AudioPlayerBase.b = ((BluetoothDevice)localObject).getBluetoothClass().getDeviceClass();
      continue;
      label93:
      com.tencent.mobileqq.activity.aio.AudioPlayerBase.b = 0;
    }
  }
  
  public void onServiceDisconnected(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpu
 * JD-Core Version:    0.7.0.1
 */