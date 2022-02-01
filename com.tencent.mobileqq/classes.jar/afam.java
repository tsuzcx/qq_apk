import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity.7.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class afam
  implements DialogInterface.OnClickListener
{
  afam(afal paramafal) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new NotificationActivity.7.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     afam
 * JD-Core Version:    0.7.0.1
 */