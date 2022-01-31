import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.qphone.base.util.QLog;

public class aixq
  extends BroadcastReceiver
{
  public aixq(TroopNoticeJsHandler paramTroopNoticeJsHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("callback");
    QLog.d("TroopReceiver", 4, paramContext);
    this.a.e(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aixq
 * JD-Core Version:    0.7.0.1
 */