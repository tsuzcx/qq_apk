import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

class aekd
  extends BroadcastReceiver
{
  aekd(aejb paramaejb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "Confess action! ");
      }
      if (aejb.a(this.a) != null)
      {
        aejb.b(this.a).a(35);
        alyx.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aekd
 * JD-Core Version:    0.7.0.1
 */