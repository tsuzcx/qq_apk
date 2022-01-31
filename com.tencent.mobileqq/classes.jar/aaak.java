import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.qphone.base.util.QLog;

public class aaak
  implements Runnable
{
  public aaak(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable, int[] paramArrayOfInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong) {}
  
  public void run()
  {
    ARWorldCupGlobalSceneRenderable.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable);
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.b != 1) {}
    do
    {
      return;
      ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).native_onTouchMove(this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, this.b, this.jdField_a_of_type_Long, ARWorldCupGlobalSceneRenderable.c(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable));
    } while (!QLog.isColorLevel());
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, "ACTION_MOVE native_onTouchMove");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaak
 * JD-Core Version:    0.7.0.1
 */