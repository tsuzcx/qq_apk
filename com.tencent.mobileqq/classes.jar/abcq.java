import android.os.Build.VERSION;
import android.os.MessageQueue.IdleHandler;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class abcq
  implements MessageQueue.IdleHandler
{
  public abcq(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public boolean queueIdle()
  {
    if (CameraCompatibleList.d(CameraCompatibleList.b)) {
      this.a.a(true);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onResume();
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
      DynamicAvatarRecordActivity.a(this.a);
      if (Build.VERSION.SDK_INT < 14) {
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.a, 230).setMessage("你的系统版本过低，不支持拍摄动态头像。").setPositiveButton(this.a.getString(2131428346), new abcr(this));
      }
      try
      {
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        if (QLog.isColorLevel()) {
          QLog.i("PEAK_CAMERA", 2, "Added camera view.");
        }
        return false;
        this.a.a(false);
      }
      catch (WindowManager.BadTokenException localBadTokenException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 2, "", localBadTokenException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abcq
 * JD-Core Version:    0.7.0.1
 */