import android.os.Message;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import mqq.os.MqqHandler;

public class ajow
  extends MqqHandler
{
  public ajow(NotificationView paramNotificationView) {}
  
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
      } while (this.a.jdField_a_of_type_Ajot == null);
      this.a.i();
      this.a.jdField_a_of_type_Ajot.a = bdzi.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.jdField_a_of_type_Ajot.notifyDataSetChanged();
      return;
    }
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajow
 * JD-Core Version:    0.7.0.1
 */