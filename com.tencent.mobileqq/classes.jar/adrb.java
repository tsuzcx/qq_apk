import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;

public class adrb
  implements DialogInterface.OnClickListener
{
  public adrb(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdll.b(this.a.app, "CliOper", "", "", "0X80040A7", "0X80040A7", 0, 0, "", "", "", "");
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrb
 * JD-Core Version:    0.7.0.1
 */