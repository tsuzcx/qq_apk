import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioSenorManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class afqa
  implements SensorEventListener
{
  public afqa(AudioSenorManager paramAudioSenorManager) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i = 1;
    if (AIOUtils.isRubbishSamsun()) {}
    label141:
    label144:
    for (;;)
    {
      return;
      boolean bool;
      if (paramSensorEvent.values[0] < AudioSenorManager.c(this.a))
      {
        bool = true;
        label28:
        QLog.d("AudioPlayer_SenorManager", 2, "ProximityEventListener$onSensorChanged close =" + bool + " | mIsMoving =" + this.a.a);
        if ((!AudioHelper.c()) && (bool) && (!this.a.a)) {
          continue;
        }
        if (!bool) {
          break label141;
        }
      }
      for (;;)
      {
        if (i == AudioSenorManager.a(this.a)) {
          break label144;
        }
        AudioSenorManager.a(this.a, i);
        if (AudioSenorManager.a(this.a) == null) {
          break;
        }
        AudioSenorManager.a(this.a).a(i);
        return;
        bool = false;
        break label28;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqa
 * JD-Core Version:    0.7.0.1
 */