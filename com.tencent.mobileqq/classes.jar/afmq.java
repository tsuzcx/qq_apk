import android.os.Message;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import mqq.os.MqqHandler;

public class afmq
  extends MqqHandler
{
  public afmq(NotificationView paramNotificationView) {}
  
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
      } while (this.a.jdField_a_of_type_Afmn == null);
      this.a.i();
      this.a.jdField_a_of_type_Afmn.a = aydd.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.jdField_a_of_type_Afmn.notifyDataSetChanged();
      return;
    }
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afmq
 * JD-Core Version:    0.7.0.1
 */