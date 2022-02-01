import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class agbq
  extends BroadcastReceiver
{
  public agbq(TroopChatPie paramTroopChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag, 2, "Confess action! ");
      }
      if (this.a.root != null)
      {
        this.a.root.a(35);
        aqwc.a(this.a.app, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbq
 * JD-Core Version:    0.7.0.1
 */