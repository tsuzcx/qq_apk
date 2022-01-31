import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRecord.worldcup.ARWorldCupStateListener;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupResourceInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.worldcup.ARWorldCupMediaPlayerWrapper;
import com.tencent.qphone.base.util.QLog;

public class aafv
  implements Runnable
{
  public aafv(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable, int paramInt) {}
  
  public void run()
  {
    QLog.d("ARWorldCupGlobalSceneRenderable", 2, "switchGameStatus run status " + this.jdField_a_of_type_Int);
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      ARWorldCupGlobalSceneRenderable.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable);
      if ((ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable) != null) && (this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3))
      {
        if (this.jdField_a_of_type_Int != 9) {
          break;
        }
        ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).a(this.jdField_a_of_type_Int, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.d));
      }
      return;
      if (ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable) != null)
      {
        ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).native_switchGameStatusWithNoParams(this.jdField_a_of_type_Int);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable.b == 3)
        {
          ReportController.b(null, "dc00898", "", "", "0X8009314", "0X8009314", 0, 0, "", "", "", "");
          if (ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable) != null) {
            ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).native_switchGameStatusWithNoParams(this.jdField_a_of_type_Int);
          }
        }
        else
        {
          ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable, 4, ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).a() + "/res/worldcup/360.mp4", false);
          continue;
          ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).c();
          ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable, 12, ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).a() + "/res/worldcup/game_end.mp4", false);
        }
      }
    }
    ARWorldCupGlobalSceneRenderable.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARWorldCupGlobalSceneRenderable).a(this.jdField_a_of_type_Int, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aafv
 * JD-Core Version:    0.7.0.1
 */