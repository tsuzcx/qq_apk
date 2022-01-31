import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.qphone.base.util.QLog;

public class aaaj
  implements Runnable
{
  public aaaj(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable, int paramInt, float paramFloat1, float paramFloat2, long paramLong) {}
  
  public void run()
  {
    ARWorldCupGlobalSceneRenderable.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable);
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.b != 1) {}
    do
    {
      return;
      ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).native_onTouchBegin(this.jdField_a_of_type_Int, this.jdField_a_of_type_Float, this.b, 0, this.jdField_a_of_type_Long, ARWorldCupGlobalSceneRenderable.c(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable));
    } while (!QLog.isColorLevel());
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, "ACTION_DOWN native_onTouchBegin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaaj
 * JD-Core Version:    0.7.0.1
 */