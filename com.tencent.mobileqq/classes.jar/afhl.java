import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.QQSettingCleanActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class afhl
  implements DialogInterface.OnClickListener
{
  public afhl(QQSettingCleanActivity paramQQSettingCleanActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdll.b(this.a.app, "dc00898", "", "", "0X8007915", "0X8007915", 0, 0, this.a.app.getCurrentAccountUin(), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhl
 * JD-Core Version:    0.7.0.1
 */