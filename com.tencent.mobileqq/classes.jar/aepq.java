import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import java.util.List;

public class aepq
  implements BluetoothProfile.ServiceListener
{
  public aepq(AudioPlayer paramAudioPlayer, String paramString, int paramInt, BluetoothAdapter paramBluetoothAdapter) {}
  
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    Object localObject;
    if (paramInt == 1)
    {
      paramBluetoothProfile = (BluetoothHeadset)paramBluetoothProfile;
      localObject = paramBluetoothProfile.getConnectedDevices();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label87;
      }
      localObject = (BluetoothDevice)((List)localObject).get(0);
      if (localObject != null) {
        break label76;
      }
      paramInt = 0;
      AudioPlayer.a(paramInt);
    }
    for (;;)
    {
      AudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.closeProfileProxy(1, paramBluetoothProfile);
      return;
      label76:
      paramInt = ((BluetoothDevice)localObject).getBluetoothClass().getDeviceClass();
      break;
      label87:
      AudioPlayer.a(0);
    }
  }
  
  public void onServiceDisconnected(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aepq
 * JD-Core Version:    0.7.0.1
 */