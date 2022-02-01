import android.os.Message;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import mqq.os.MqqHandler;

public class ajeh
  extends MqqHandler
{
  public ajeh(NotificationView paramNotificationView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1013: 
    default: 
    case 1012: 
      do
      {
        return;
      } while (this.a.jdField_a_of_type_Ajed == null);
      this.a.i();
      this.a.jdField_a_of_type_Ajed.a = bdzy.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.jdField_a_of_type_Ajed.notifyDataSetChanged();
      return;
    }
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajeh
 * JD-Core Version:    0.7.0.1
 */