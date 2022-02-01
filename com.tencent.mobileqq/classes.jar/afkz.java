import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class afkz
  implements bhqe
{
  public afkz(VisitorsActivity paramVisitorsActivity, String paramString) {}
  
  public void a()
  {
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app.getCurrentAccountUin(), "thumbup", "click_getit", "", 1, 0, 0, "", this.jdField_a_of_type_JavaLangString, "");
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity, QQBrowserActivity.class);
    localIntent.putExtra("fragmentStyle", 3);
    localIntent.putExtra("url", "https://m.vip.qq.com/freedom/dbzan.html?_nav_alpha=0");
    localIntent.putExtra("isTransparentTitle", true);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.startActivity(localIntent);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "ZanDoubleDialog: onRightClick: ");
    }
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app.getCurrentAccountUin(), "thumbup", "click_pay", "", 1, 0, 0, "", this.jdField_a_of_type_JavaLangString, "");
    bhoy.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity, "mvip.n.a.dbzan_dbzan", "CJCLUBT", 3, false, true);
    VisitorsActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity).set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afkz
 * JD-Core Version:    0.7.0.1
 */