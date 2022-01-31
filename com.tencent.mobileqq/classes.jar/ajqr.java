import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.qphone.base.util.QLog;

public class ajqr
  implements amxx
{
  public ajqr(NewFlowCameraActivity paramNewFlowCameraActivity, SharedPreferences paramSharedPreferences) {}
  
  public void a(amxz paramamxz)
  {
    long l = paramamxz.jdField_a_of_type_ArrayOfLong[((int)(paramamxz.jdField_a_of_type_ArrayOfLong.length * NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity)))];
    if (QLog.isColorLevel()) {
      QLog.d("DynamicAdjustment", 2, "onDataRefresh: datatype=" + NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity) + " monitedValue=" + l);
    }
    if (paramamxz.jdField_a_of_type_Int >= 100)
    {
      if (l > NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity))
      {
        NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, true, paramamxz);
        NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).b();
      }
    }
    else {
      return;
    }
    if (l < NewFlowCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity))
    {
      NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, false, paramamxz);
      NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).b();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DynamicAdjustment", 2, "Finished. Frame count = " + paramamxz.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("SVDNAdjustment_quality_down_mark", 1).putInt("SVDNAdjustment_quality_up_mark", 1).commit();
    NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqr
 * JD-Core Version:    0.7.0.1
 */