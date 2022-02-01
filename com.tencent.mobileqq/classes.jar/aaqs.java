import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

public class aaqs
  implements QQPermissionCallback
{
  public aaqs(NewerGuidePlugin paramNewerGuidePlugin, BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, "handleSetAvatar deny permissions");
    }
    QQCustomDialog.showPermissionSettingDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, anvx.a(2131706902));
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
 * Qualified Name:     aaqs
 * JD-Core Version:    0.7.0.1
 */