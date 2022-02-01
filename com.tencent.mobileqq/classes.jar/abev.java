import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

public class abev
  implements QQPermissionCallback
{
  public abev(NewerGuidePlugin paramNewerGuidePlugin, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "handleSetAvatar deny permissions");
    }
    bhpc.showPermissionSettingDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, anzj.a(2131706320));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "handleSetAvatar grant permissions");
    }
    NewerGuidePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginNewerGuidePlugin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abev
 * JD-Core Version:    0.7.0.1
 */