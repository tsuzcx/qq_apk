import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.qphone.base.util.QLog;

public class ajlu
  extends BroadcastReceiver
{
  public ajlu(TroopNoticeJsHandler paramTroopNoticeJsHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("callback");
    QLog.d("TroopReceiver", 4, paramContext);
    this.a.e(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlu
 * JD-Core Version:    0.7.0.1
 */