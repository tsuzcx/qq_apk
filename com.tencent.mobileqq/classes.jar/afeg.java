import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;

public class afeg
  extends Handler
{
  public afeg(AddContactsActivity paramAddContactsActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.jdField_a_of_type_Affi.b();
      this.a.jdField_a_of_type_Boolean = false;
      return;
    }
    sek.a().a(300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afeg
 * JD-Core Version:    0.7.0.1
 */