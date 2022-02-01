import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import mqq.os.MqqHandler;

public class aero
  implements DialogInterface.OnClickListener
{
  private int jdField_a_of_type_Int;
  
  public aero(NotificationActivity paramNotificationActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Int == 1) {
        NotificationActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity);
      }
    }
    while (paramInt != 1)
    {
      NotificationActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity).sendEmptyMessage(4);
      do
      {
        return;
      } while (this.jdField_a_of_type_Int != 2);
      NotificationActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity, NotificationActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity));
      return;
    }
    NotificationActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aero
 * JD-Core Version:    0.7.0.1
 */