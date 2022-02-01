import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class adqu
  implements View.OnClickListener
{
  public adqu(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    bdll.b(this.a.app, "CliOper", "", "", "0X8004038", "0X8004038", 0, 0, String.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), "", "", "");
    if (!azoz.a().a(this.a.app, this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AccountManageActivity.a(this.a, bdwt.a(this.a.app));
      if (this.a.c)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AccountManage", 2, "onClick v.hashCode()" + paramView.hashCode());
        }
      }
      else
      {
        Object localObject = paramView.getTag();
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Switch_Account", 2, "switch a non-existing account");
          }
        }
        else
        {
          int i = ((Integer)localObject).intValue();
          localObject = (SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(i);
          if (QLog.isColorLevel()) {
            QLog.d("Switch_Account", 2, "switch uin:" + ((SimpleAccount)localObject).getUin());
          }
          if ((localObject != null) && (!((SimpleAccount)localObject).getUin().equals(this.a.app.getCurrentAccountUin())))
          {
            bdll.b(this.a.app, "CliOper", "", "", "0X8009C05", "0X8009C05", 0, 0, "", "", "", "");
            this.a.f();
            this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)localObject);
            AccountManageActivity.b(this.a, true);
            AccountManageActivity.c(this.a, true);
            bdll.b(this.a.app, "dc00898", "", "", "0X800AC38", "0X800AC38", 0, 0, "", "", "", "");
            this.a.app.switchAccount((SimpleAccount)localObject, null);
            bdws.a(this.a.app, this.a);
          }
          bhkd.b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqu
 * JD-Core Version:    0.7.0.1
 */