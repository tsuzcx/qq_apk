import android.annotation.TargetApi;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;

public class alyy
  extends alzc
{
  public alyy(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public String a()
  {
    return "DEVICE_BLUETOOTHHEADSET";
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "bluetoothHeadsetSwitchThread start connect,sBluetoothDelayTime: " + TraeAudioManager.a());
      }
      Thread.sleep(TraeAudioManager.a());
    }
    catch (InterruptedException localInterruptedException2)
    {
      label39:
      StringBuilder localStringBuilder;
      int i;
      label264:
      break label39;
    }
    c();
    localStringBuilder = new StringBuilder(1024);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("bluetoothHeadsetSwitchThread ");
    }
    i = 0;
    for (;;)
    {
      int j;
      if (this.jdField_a_of_type_Boolean == true)
      {
        j = i + 1;
        if (i < 10) {
          if (QLog.isColorLevel())
          {
            localStringBuilder.append("i:");
            localStringBuilder.append(j);
            localStringBuilder.append(" sco:");
            if (!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()) {
              break label264;
            }
          }
        }
      }
      for (String str = "Y";; str = "N")
      {
        localStringBuilder.append(str);
        localStringBuilder.append(" :");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a());
        localStringBuilder.append("\n");
        if (!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()) {
          break;
        }
        e();
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localStringBuilder.toString());
        }
        if (!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn())
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "bluetoothHeadsetSwitchThread sco fail,remove btheadset");
          }
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(a(), false);
          a(10);
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.c();
        }
        return;
      }
      try
      {
        Thread.sleep(1000L);
        i = j;
      }
      catch (InterruptedException localInterruptedException1)
      {
        i = j;
      }
    }
  }
  
  @TargetApi(8)
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager == null) {
      return;
    }
    d();
  }
  
  @TargetApi(8)
  void c()
  {
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(true);
    if (Build.VERSION.SDK_INT > 8) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.startBluetoothSco();
    }
  }
  
  @TargetApi(8)
  void d()
  {
    if (Build.VERSION.SDK_INT > 8) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.stopBluetoothSco();
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alyy
 * JD-Core Version:    0.7.0.1
 */