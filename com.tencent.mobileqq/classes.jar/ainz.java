import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.NightModeLogic;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ainz
  implements DialogInterface.OnDismissListener
{
  public ainz(NightModeLogic paramNightModeLogic) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new Bundle();
    paramDialogInterface.putInt("start_status", 2);
    this.a.a(0, paramDialogInterface);
    this.a.jdField_a_of_type_AndroidAppDialog = null;
    try
    {
      paramDialogInterface = new HashMap();
      paramDialogInterface.put("param_FailCode", "2");
      StatisticCollector.a(this.a.jdField_a_of_type_MqqAppAppRuntime.getApplication().getApplicationContext()).a(((QQAppInterface)this.a.jdField_a_of_type_MqqAppAppRuntime).getAccount(), "VipNightThemeDialogClick", false, 1L, 0L, paramDialogInterface, "", false);
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainz
 * JD-Core Version:    0.7.0.1
 */