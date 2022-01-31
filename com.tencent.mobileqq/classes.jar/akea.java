import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class akea
  extends BroadcastReceiver
{
  public akea(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) || (paramContext.equals("mqq.intent.action.ACCOUNT_EXPIRED")) || (paramContext.equals("mqq.intent.action.FORCE_LOGOUT")) || (paramContext.equals("mqq.intent.action.LOGOUT")) || (paramContext.equals("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName())))
          {
            aqyc.a();
            return;
          }
        } while (!paramContext.equals("com.tencent.mobileqq.kickedLogin.otherDevice"));
        paramContext = paramIntent.getStringExtra("kickedUin");
      } while ((TextUtils.isEmpty(paramContext)) || (!paramContext.equals(this.a.getAccount())));
      paramContext = this.a.getKickIntent();
    } while (paramContext == null);
    paramContext.putExtra("isSameDevice", false);
    paramIntent = paramIntent.getStringExtra("msg");
    if (!TextUtils.isEmpty(paramIntent)) {
      paramContext.putExtra("msg", paramIntent);
    }
    this.a.setKickIntent(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akea
 * JD-Core Version:    0.7.0.1
 */