import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

public class ajcb
  implements Comparator<PhoneContact>
{
  public ajcb(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    return paramPhoneContact1.contactID - paramPhoneContact2.contactID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcb
 * JD-Core Version:    0.7.0.1
 */