import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

final class alpz
  implements DialogInterface.OnClickListener
{
  alpz(QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    azmj.b(this.a, "CliOper", "", "", "0X8004C6C", "0X8004C6C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alpz
 * JD-Core Version:    0.7.0.1
 */