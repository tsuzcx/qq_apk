import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.qphone.base.util.QLog;

public class adyj
  extends BroadcastReceiver
{
  public adyj(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("tencent.av.v2q.StartVideoChat".equals(paramContext)) || ("tencent.av.v2q.AvSwitch".equals(paramContext)))
    {
      i = paramIntent.getIntExtra("sessionType", 0);
      QLog.d("qq_Identification.act", 1, "received video chat broadcast: " + i);
      if ((i == 2) || (i == 4))
      {
        QQIdentiferActivity.a(this.a, 204, auts.a);
        QQIdentiferActivity.a(this.a, 204, auts.a);
        this.a.finish();
      }
    }
    while (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramContext))
    {
      int i;
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyj
 * JD-Core Version:    0.7.0.1
 */