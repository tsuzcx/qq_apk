import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import com.tencent.mobileqq.forward.ForwardBaseOption;

public class aaih
  implements Runnable
{
  public aaih(ArkAppModuleReg.ModuleQQ paramModuleQQ, String paramString1, String paramString2) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      Intent localIntent = ArkFullScreenAppActivity.a(localBaseActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ.jdField_a_of_type_JavaLangString, this.b, localBaseActivity.getResources().getDisplayMetrics().scaledDensity);
      if (localIntent != null) {
        ForwardBaseOption.a(localBaseActivity, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaih
 * JD-Core Version:    0.7.0.1
 */