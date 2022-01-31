import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aafg
  implements View.OnClickListener
{
  public aafg(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "add account");
    }
    if (!aumi.a().a(this.a.app, this.a)) {
      return;
    }
    if ((this.a.a != null) && (this.a.a.size() - 1 >= 8))
    {
      bcpw.a(this.a, 2131694030, 0).a();
      return;
    }
    AccountManageActivity.a(this.a, ayao.a(this.a.app));
    paramView = new Intent();
    paramView.setPackage(this.a.getPackageName());
    paramView.setClass(this.a, AddAccountActivity.class);
    this.a.startActivityForResult(paramView, 1000);
    this.a.overridePendingTransition(2130771997, 2130771990);
    ayan.c(this.a.app, this.a);
    axqw.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_acc_add", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aafg
 * JD-Core Version:    0.7.0.1
 */