import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.QQSettingCleanActivity;
import com.tencent.mobileqq.activity.QQSettingCleanActivity.2.1;
import com.tencent.mobileqq.app.ThreadManager;

public class aerj
  implements DialogInterface.OnClickListener
{
  public aerj(QQSettingCleanActivity paramQQSettingCleanActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.executeOnNetWorkThread(new QQSettingCleanActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aerj
 * JD-Core Version:    0.7.0.1
 */