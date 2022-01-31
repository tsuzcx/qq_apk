import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.mobileqq.armap.sensor.rotation.Vector3;

public class aaab
  implements Runnable
{
  public aaab(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable, Vector3 paramVector3) {}
  
  public void run()
  {
    if (ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable) != null) {
      ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).native_updateBallTanslateFromXYZ(this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector3.x, this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector3.y, this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector3.z);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaab
 * JD-Core Version:    0.7.0.1
 */