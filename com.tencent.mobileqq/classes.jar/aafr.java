import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.qphone.base.util.QLog;

public class aafr
  implements Runnable
{
  public aafr(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable, int paramInt, float paramFloat1, float paramFloat2, long paramLong) {}
  
  public void run()
  {
    ARWorldCupGlobalSceneRenderable.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable);
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.b != 1) {}
    do
    {
      return;
      ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).native_onTouchEnd(this.jdField_a_of_type_Int, this.jdField_a_of_type_Float, this.b, 1, this.jdField_a_of_type_Long, ARWorldCupGlobalSceneRenderable.c(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable));
    } while (!QLog.isColorLevel());
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, "ACTION_UP native_onTouchEnd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aafr
 * JD-Core Version:    0.7.0.1
 */