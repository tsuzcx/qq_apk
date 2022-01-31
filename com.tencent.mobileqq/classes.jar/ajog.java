import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.AppPathInfo;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ajog
  implements ArkLocalAppMgr.IGetAppPathByNameCallback
{
  public ajog(JumpAction paramJumpAction, QQProgressDialog paramQQProgressDialog, String paramString1, ArkAppCenter paramArkAppCenter, String paramString2, String paramString3) {}
  
  public void a(int paramInt, String paramString, ArkLocalAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if ((paramAppPathInfo != null) && (paramInt == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, new Object[] { "Ark mqqapi://ligthapp/open goToLightAppOpen get path succeed, appPath: ", paramAppPathInfo.jdField_a_of_type_JavaLangString });
      }
      paramObject = this.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(paramObject)) {
        break label310;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqArkArkAppCenter;
      paramString = ArkAppCenter.c(paramAppPathInfo.jdField_a_of_type_JavaLangString);
      if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
      {
        paramInt = 0;
        paramAppPathInfo = paramObject;
      }
    }
    for (;;)
    {
      String str = this.b;
      paramObject = str;
      if (TextUtils.isEmpty(str)) {
        paramObject = "{}";
      }
      if (paramInt != 0)
      {
        ArkAppDataReport.j(null, this.c);
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.a != null) {
          ArkFullScreenAppActivity.a(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.a, this.c, paramAppPathInfo, "0.0.0.1", paramObject, this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.a.getResources().getDisplayMetrics().scaledDensity, null, 1);
        }
      }
      do
      {
        do
        {
          return;
          paramAppPathInfo = paramString;
          paramInt = 1;
          paramString = null;
          break;
          paramAppPathInfo = new Intent();
          paramAppPathInfo.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
          paramAppPathInfo.putExtra("param_force_internal_browser", true);
          paramAppPathInfo.putExtra("url", paramString);
          paramAppPathInfo.putExtra("injectrecommend", false);
          paramAppPathInfo.addFlags(603979776);
        } while (this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.a == null);
        this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.a.startActivity(paramAppPathInfo);
        return;
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction.a, 2131438818, 0).a();
      } while (!QLog.isColorLevel());
      QLog.d("JumpAction", 2, "Ark mqqapi://ligthapp/open goToLightAppOpen appPath is null ");
      return;
      label310:
      paramString = null;
      paramInt = 1;
      paramAppPathInfo = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ajog
 * JD-Core Version:    0.7.0.1
 */