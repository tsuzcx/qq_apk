import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

public class adeb
  implements DialogInterface.OnClickListener
{
  public adeb(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("AccountManageActivity", 1, "switchFail, to LoginActivity");
    paramDialogInterface = new Intent();
    paramDialogInterface.setPackage(this.a.getPackageName());
    paramDialogInterface.setClass(this.a, LoginActivity.class);
    paramDialogInterface.putExtra("is_change_account", true);
    paramDialogInterface.putExtra("login_from_account_change", true);
    if (this.a.a != null) {
      paramDialogInterface.putExtra("uin", this.a.a.getUin());
    }
    paramDialogInterface.putExtra("befault_uin", this.a.app.getCurrentAccountUin());
    this.a.startActivityForResult(paramDialogInterface, 9876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adeb
 * JD-Core Version:    0.7.0.1
 */