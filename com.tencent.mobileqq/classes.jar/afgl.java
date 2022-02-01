import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.QLog;

public class afgl
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  
  private afgl(QQLSActivity paramQQLSActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QQLSActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)) {}
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramIntent != null) {}
          try
          {
            this.jdField_a_of_type_JavaLangString = paramIntent.getAction();
            if ("android.intent.action.SCREEN_ON".equals(this.jdField_a_of_type_JavaLangString))
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("QQLSActivity", 2, "ScreenBroadcastReceiver ACTION_SCREEN_ON");
            }
          }
          catch (Exception paramContext)
          {
            QLog.e("QQLSActivity", 1, paramContext, new Object[0]);
            return;
          }
        }
        if (!"android.intent.action.SCREEN_OFF".equals(this.jdField_a_of_type_JavaLangString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQLSActivity", 2, "ScreenBroadcastReceiver ACTION_SCREEN_OFF");
      return;
    } while (!"android.intent.action.USER_PRESENT".equals(this.jdField_a_of_type_JavaLangString));
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder().append("ScreenBroadcastReceiver ACTION_USER_PRESENTmanager.isEnterAio");
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a;
      QLog.d("QQLSActivity", 2, axac.f);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a;
    if (!axac.f) {
      QQLSActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgl
 * JD-Core Version:    0.7.0.1
 */