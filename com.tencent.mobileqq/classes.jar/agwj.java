import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class agwj
  extends BroadcastReceiver
{
  public agwj(TroopChatPie paramTroopChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "Confess action! ");
      }
      if (TroopChatPie.a(this.a) != null)
      {
        TroopChatPie.b(this.a).a(35);
        aojt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwj
 * JD-Core Version:    0.7.0.1
 */