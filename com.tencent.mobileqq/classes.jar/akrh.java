import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.mobileqq.vashealth.PathTraceManager;
import com.tencent.mobileqq.vashealth.TracePathData;
import com.tencent.qphone.base.util.QLog;

public class akrh
  implements SensorEventListener
{
  public akrh(PathTraceManager paramPathTraceManager) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    QLog.d("PathTraceManager", 1, "step Changed:" + paramSensorEvent.values[0]);
    if (PathTraceManager.a(this.a) == 1)
    {
      PathTraceManager.a(this.a, (int)paramSensorEvent.values[0]);
      if ((PathTraceManager.a(this.a) == null) || (PathTraceManager.b(this.a) <= PathTraceManager.c(this.a)) || (PathTraceManager.c(this.a) == 0)) {
        break label331;
      }
      i = PathTraceManager.a(this.a).totalSteps;
      if (!this.a.e) {
        break label246;
      }
      paramSensorEvent = PathTraceManager.a(this.a);
      paramSensorEvent.totalSteps += (PathTraceManager.b(this.a) - PathTraceManager.c(this.a)) * (int)(20.0D * Math.random());
      PathTraceManager.b(this.a, PathTraceManager.b(this.a));
      PathTraceManager.a(this.a, null);
      if (PathTraceManager.a(this.a).type == 1)
      {
        if ((i >= PathTraceManager.a(this.a).stepsGoal) || (PathTraceManager.a(this.a).totalSteps < PathTraceManager.a(this.a).stepsGoal)) {
          break label281;
        }
        this.a.a(PathTraceManager.a(this.a), false, true);
      }
    }
    label246:
    while (PathTraceManager.c(this.a) != 0)
    {
      int i;
      do
      {
        for (;;)
        {
          return;
          paramSensorEvent = PathTraceManager.a(this.a);
          paramSensorEvent.totalSteps += PathTraceManager.b(this.a) - PathTraceManager.c(this.a);
        }
      } while (Math.floor(PathTraceManager.a(this.a).totalSteps / 1000) - Math.floor(i / 1000) <= 0.0D);
      this.a.a(PathTraceManager.a(this.a), false, false);
      return;
    }
    label281:
    label331:
    PathTraceManager.b(this.a, PathTraceManager.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akrh
 * JD-Core Version:    0.7.0.1
 */