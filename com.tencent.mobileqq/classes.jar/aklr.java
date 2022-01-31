import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.EcShopFirstRunMsgConfigs;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aklr
  extends bbwt
{
  public aklr(EcShopFirstRunMsgConfigs paramEcShopFirstRunMsgConfigs) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    if ((parambbwu.a == 0) && (this.a.a.app != null))
    {
      str = parambbwu.a().getString("path");
      if ((this.a.a.app != null) && (!TextUtils.isEmpty(str)))
      {
        if (!nqn.e.equals(str)) {
          break label142;
        }
        this.a.a.app.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_report_json", parambbwu.i).commit();
        ((nrf)this.a.a.app.a(88)).a();
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop", 2, "download report json success.");
        }
      }
    }
    label142:
    while (!QLog.isColorLevel())
    {
      do
      {
        String str;
        do
        {
          return;
        } while (!nqn.f.equals(str));
        this.a.a.app.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_behaviors_json", parambbwu.i).commit();
      } while (!QLog.isColorLevel());
      QLog.i("Ecshop", 2, "download behaviors json success.");
      return;
    }
    QLog.i("Ecshop", 2, "download json failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aklr
 * JD-Core Version:    0.7.0.1
 */