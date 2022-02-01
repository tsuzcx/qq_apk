import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TransFileController;

public class addg
  implements DialogInterface.OnClickListener
{
  public addg(DialogActivity paramDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.app.getTransFileController();
    paramDialogInterface.resumeLastRawSend();
    paramDialogInterface.resumeLastShortVideoTransfer();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addg
 * JD-Core Version:    0.7.0.1
 */