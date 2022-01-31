import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;

public class aafl
  implements DialogInterface.OnClickListener
{
  public aafl(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.setClass(this.a, SubAccountBindActivity.class);
    paramDialogInterface.putExtra("fromWhere", AccountManageActivity.class.getSimpleName());
    this.a.startActivity(paramDialogInterface);
    axqw.b(this.a.app, "CliOper", "", "", "0X80040A6", "0X80040A6", 0, 0, "", "", "", "");
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aafl
 * JD-Core Version:    0.7.0.1
 */