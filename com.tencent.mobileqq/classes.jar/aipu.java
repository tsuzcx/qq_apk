import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.process.data.CmGameManager.GameEventReceiver.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class aipu
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      QLog.e("cmgame_process.CmGameManager", 1, "[onReceive] intent null");
    }
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "[onReceive] action=", paramContext });
        }
      } while ((!"com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext)) || (!"apolloGameWebMessage".equals(paramIntent.getStringExtra("event"))));
      paramContext = paramIntent.getStringExtra("data");
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "[onReceive] data=", paramContext });
      }
    } while (TextUtils.isEmpty(paramContext));
    ThreadManagerV2.excute(new CmGameManager.GameEventReceiver.1(this, paramContext), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aipu
 * JD-Core Version:    0.7.0.1
 */