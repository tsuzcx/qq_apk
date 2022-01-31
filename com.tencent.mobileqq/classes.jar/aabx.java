import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager.ARSensorTrackCallback;
import com.tencent.mobileqq.armap.sensor.SimpleSensorChangeListener;

public class aabx
  extends SimpleSensorChangeListener
{
  public aabx(SensorTrackManager paramSensorTrackManager) {}
  
  public void onRotationUpdateQuaternion(float[] paramArrayOfFloat)
  {
    if (SensorTrackManager.a(this.a) != null) {
      SensorTrackManager.a(this.a).a(paramArrayOfFloat);
    }
  }
  
  public void updateAccelerometer(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (SensorTrackManager.a(this.a) != null) {
      SensorTrackManager.a(this.a).a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aabx
 * JD-Core Version:    0.7.0.1
 */