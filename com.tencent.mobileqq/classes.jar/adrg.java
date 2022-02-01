import android.app.Dialog;
import android.content.DialogInterface;
import com.tencent.mobileqq.activity.AccountManageActivity;

public class adrg
  extends bbct
{
  public adrg(AccountManageActivity paramAccountManageActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((paramDialogInterface != null) && ((paramDialogInterface instanceof Dialog))) {
      ((Dialog)paramDialogInterface).setOnDismissListener(null);
    }
    if (paramDialogInterface == this.a.c) {
      this.a.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrg
 * JD-Core Version:    0.7.0.1
 */