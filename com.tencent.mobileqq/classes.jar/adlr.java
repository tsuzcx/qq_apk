import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQIdentiferLegacy;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;

public class adlr
  extends BroadcastReceiver
{
  public adlr(QQIdentiferLegacy paramQQIdentiferLegacy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("tencent.av.v2q.StartVideoChat".equals(paramContext)) || ("tencent.av.v2q.AvSwitch".equals(paramContext)))
    {
      i = paramIntent.getIntExtra("sessionType", 0);
      QLog.d("QQIdentiferLegacy", 1, "received video chat broadcast: " + i);
      if ((i == 2) || (i == 4))
      {
        paramContext = new Intent();
        paramIntent = new Bundle();
        paramIntent.putInt("ret", 204);
        paramIntent.putString("errMsg", atdf.a);
        paramContext.putExtra("data", paramIntent);
        QQIdentiferLegacy.a(this.a).setResult(2, paramContext);
        QQIdentiferLegacy.a(this.a).finish();
      }
    }
    while (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramContext))
    {
      int i;
      return;
    }
    QLog.d("QQIdentiferLegacy", 1, "received account kicked broadcast");
    QQIdentiferLegacy.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlr
 * JD-Core Version:    0.7.0.1
 */