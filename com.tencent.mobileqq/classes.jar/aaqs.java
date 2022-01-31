import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.config.SplashPopupWin;
import com.tencent.mobileqq.ar.config.WorldCup;
import com.tencent.mobileqq.ar.config.WorldCupConfigInfo;
import com.tencent.mobileqq.ar.config.WorldCupReport;
import com.tencent.mobileqq.ar.config.WorldCupStaticInstance;
import com.tencent.qphone.base.util.QLog;

public class aaqs
  implements Runnable
{
  public aaqs(SplashPopupWin paramSplashPopupWin, BaseActivity paramBaseActivity, View paramView, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (!SplashPopupWin.a(this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin))
    {
      QLog.w("WorldCupMgr", 1, "SplashPopupWin.innerShow.1, 已经取消展示");
      return;
    }
    PopupWindow localPopupWindow = SplashPopupWin.a(this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin);
    if (localPopupWindow == null)
    {
      QLog.w("WorldCupMgr", 1, "SplashPopupWin.innerShow.1, mPopupWindow为空");
      return;
    }
    try
    {
      SplashPopupWin.a(this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewView, true);
      localPopupWindow.showAtLocation(this.jdField_a_of_type_AndroidViewView, 0, 0, 0);
      WorldCupStaticInstance.a().c = true;
      WorldCupConfigInfo.b(this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin.a.a.l, WorldCupConfigInfo.a());
      WorldCupReport.c();
      WorldCup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception localException)
    {
      QLog.w("WorldCupMgr", 1, "SplashPopupWin.innerShow.1, Exception", localException);
      this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqs
 * JD-Core Version:    0.7.0.1
 */