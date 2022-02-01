import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

class akaz
  implements DialogInterface.OnClickListener
{
  akaz(akam paramakam) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.getIntent().removeExtra("if_check_account_same");
    this.a.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akaz
 * JD-Core Version:    0.7.0.1
 */