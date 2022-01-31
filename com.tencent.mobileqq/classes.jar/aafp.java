import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.mobileqq.armap.sensor.SimpleSensorChangeListener;

public class aafp
  extends SimpleSensorChangeListener
{
  public aafp(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable) {}
  
  public void onRotationUpdateQuaternion(float[] paramArrayOfFloat)
  {
    ARWorldCupGlobalSceneRenderable.a(this.a).a(new aafq(this, paramArrayOfFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aafp
 * JD-Core Version:    0.7.0.1
 */