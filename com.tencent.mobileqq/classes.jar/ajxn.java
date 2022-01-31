import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

public class ajxn
  extends BroadcastReceiver
{
  public ajxn(WebProcessManager paramWebProcessManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("user_type", 0);
    int j = paramIntent.getIntExtra("from_type", 0);
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof QQAppInterface))
    {
      paramContext = (BabyQHandler)((QQAppInterface)paramContext).a(53);
      if (paramContext != null) {
        paramContext.a(i, j);
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessManager", 2, "babyq receiver recv user_type=" + i + ", from_type=" + j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajxn
 * JD-Core Version:    0.7.0.1
 */