import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ar.config.SplashPopupWin;
import com.tencent.mobileqq.ar.config.WorldCup;
import com.tencent.mobileqq.ar.config.WorldCupConfigInfo;
import com.tencent.mobileqq.ar.config.WorldCupReport;

public class aakb
  implements View.OnClickListener
{
  public aakb(SplashPopupWin paramSplashPopupWin, aakd paramaakd, AppInterface paramAppInterface, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    if (SplashPopupWin.a(this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin) != null) {
      SplashPopupWin.a(this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin).dismiss();
    }
    if (this.jdField_a_of_type_Aakd.a.b)
    {
      WorldCup.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 1);
      WorldCupReport.d();
      RecentOptPopBar.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2L, 4096L, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakb
 * JD-Core Version:    0.7.0.1
 */