import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.qphone.base.util.QLog;

public class ahts
  extends BroadcastReceiver
{
  public ahts(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlowCameraActivity", 2, "receive ACTION_START_VIDEO_CHAT.");
      }
      paramContext = BaseActivity2.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131366389);
      if (paramContext != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(paramContext);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.e();
      }
      if (this.a.f) {
        this.a.m();
      }
      if ((this.a.g) && (this.a.c)) {
        this.a.c(false);
      }
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahts
 * JD-Core Version:    0.7.0.1
 */