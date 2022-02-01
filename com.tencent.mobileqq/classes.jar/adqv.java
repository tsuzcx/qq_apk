import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class adqv
  implements View.OnClickListener
{
  public adqv(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "add account");
    }
    if (!azoz.a().a(this.a.app, this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.a.a != null) && (this.a.a.size() - 1 >= 8))
      {
        QQToast.a(this.a, 2131693446, 0).a();
      }
      else
      {
        AccountManageActivity.a(this.a, bdwt.a(this.a.app));
        Intent localIntent = new Intent();
        localIntent.setPackage(this.a.getPackageName());
        localIntent.setClass(this.a, AddAccountActivity.class);
        this.a.startActivityForResult(localIntent, 1000);
        this.a.overridePendingTransition(2130771997, 2130771990);
        bdws.c(this.a.app, this.a);
        bdll.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_acc_add", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqv
 * JD-Core Version:    0.7.0.1
 */