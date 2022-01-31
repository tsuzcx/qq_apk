import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;

public class ahbl
  extends Handler
{
  public ahbl(AddContactsActivity paramAddContactsActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.jdField_a_of_type_Ahcn.b();
      this.a.jdField_a_of_type_Boolean = false;
      return;
    }
    swe.a().a(300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbl
 * JD-Core Version:    0.7.0.1
 */