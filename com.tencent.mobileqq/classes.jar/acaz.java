import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acaz
  implements DialogInterface.OnClickListener
{
  public acaz(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "switchFail -> to LoginActivity which=" + paramInt);
    }
    paramDialogInterface = new Intent();
    paramDialogInterface.setPackage(this.a.getPackageName());
    paramDialogInterface.setClass(this.a, LoginActivity.class);
    paramDialogInterface.putExtra("is_change_account", true);
    paramDialogInterface.putExtra("fromsubaccount", true);
    if (this.a.a != null) {
      paramDialogInterface.putExtra("uin", this.a.a);
    }
    paramDialogInterface.putExtra("befault_uin", this.a.app.getCurrentAccountUin());
    this.a.startActivityForResult(paramDialogInterface, 1011);
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acaz
 * JD-Core Version:    0.7.0.1
 */