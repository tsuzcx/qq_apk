import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class ajbu
  implements Comparator<PhoneContact>
{
  ajbu(ajbt paramajbt) {}
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    return paramPhoneContact1.contactID - paramPhoneContact2.contactID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbu
 * JD-Core Version:    0.7.0.1
 */