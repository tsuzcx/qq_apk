import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aafb
  implements View.OnClickListener
{
  public aafb(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    axqy.b(this.a.app, "CliOper", "", "", "0X8004038", "0X8004038", 0, 0, String.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), "", "", "");
    if (!aumk.a().a(this.a.app, this.a)) {}
    do
    {
      do
      {
        return;
        AccountManageActivity.a(this.a, ayaq.a(this.a.app));
        if (!this.a.c) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("AccountManage", 2, "onClick v.hashCode()" + paramView.hashCode());
      return;
      paramView = paramView.getTag();
      if (paramView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Switch_Account", 2, "switch a non-existing account");
    return;
    int i = ((Integer)paramView).intValue();
    paramView = (SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(i);
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "switch uin:" + paramView.getUin());
    }
    if ((paramView != null) && (!paramView.getUin().equals(this.a.app.getCurrentAccountUin())))
    {
      axqy.b(this.a.app, "CliOper", "", "", "0X8009C05", "0X8009C05", 0, 0, "", "", "", "");
      this.a.f();
      this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramView;
      AccountManageActivity.b(this.a, true);
      AccountManageActivity.c(this.a, true);
      this.a.app.switchAccount(paramView, null);
      ayap.a(this.a.app, this.a);
    }
    bbbx.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aafb
 * JD-Core Version:    0.7.0.1
 */