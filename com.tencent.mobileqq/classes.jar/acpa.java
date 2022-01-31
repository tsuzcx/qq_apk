import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class acpa
  implements DialogInterface.OnClickListener
{
  public acpa(DialogActivity paramDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.app.a();
    paramDialogInterface.e();
    paramDialogInterface.d();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpa
 * JD-Core Version:    0.7.0.1
 */