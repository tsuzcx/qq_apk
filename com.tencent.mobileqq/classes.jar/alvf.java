import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.MessageQueue.IdleHandler;
import android.view.View;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.qphone.base.util.QLog;

public class alvf
  implements MessageQueue.IdleHandler
{
  public alvf(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean, SharedPreferences paramSharedPreferences) {}
  
  public boolean queueIdle()
  {
    if (bdax.d(bdax.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("PEAK_CAMERA", 2, "hit in black list! needChangeNewSurfaceView ");
      }
    }
    View localView = BaseActivity2.$(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131366817);
    if (localView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.F();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.c();
    if ((!NewFlowCameraActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity)) && (!NewFlowCameraActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PEAK_CAMERA", 2, "Added camera view.");
      }
      NewFlowCameraActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, false);
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_is_cancel_from_music_key", true).commit();
      NewFlowCameraActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, false);
      return false;
      if ((NewFlowCameraActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity)) && (!NewFlowCameraActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity)) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
      } else {
        QLog.d("PTV.NewFlowCameraActivity", 2, "onResume from select music and do nothing in 1");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvf
 * JD-Core Version:    0.7.0.1
 */