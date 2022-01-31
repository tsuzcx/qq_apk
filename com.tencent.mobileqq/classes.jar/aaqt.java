import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.config.SplashPopupWin;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aaqt
  implements aarg
{
  public aaqt(SplashPopupWin paramSplashPopupWin, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, View paramView) {}
  
  public void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    QLog.w("WorldCupMgr", 1, "SplashPopupWin, 异步加载图片[" + paramBoolean + "]");
    if (paramBoolean)
    {
      SplashPopupWin.a(this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqt
 * JD-Core Version:    0.7.0.1
 */