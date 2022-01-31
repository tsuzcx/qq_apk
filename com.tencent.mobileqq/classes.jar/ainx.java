import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.NightModeLogic;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ainx
  implements View.OnClickListener
{
  public ainx(NightModeLogic paramNightModeLogic) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putInt("start_status", 2);
    this.a.a(0, paramView);
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.jdField_a_of_type_AndroidAppDialog = null;
    try
    {
      paramView = new HashMap();
      paramView.put("param_FailCode", "3");
      StatisticCollector.a(this.a.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext()).a(((QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime).getAccount(), "VipNightThemeDialogClick", false, 1L, 0L, paramView, "", false);
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainx
 * JD-Core Version:    0.7.0.1
 */