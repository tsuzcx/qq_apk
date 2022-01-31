import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.QQIdentiferActivity;

public class adlo
  implements DialogInterface.OnClickListener
{
  public adlo(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlo
 * JD-Core Version:    0.7.0.1
 */