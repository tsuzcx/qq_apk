import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

public class ajmu
  implements Comparator<PhoneContact>
{
  public ajmu(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    Object localObject2 = paramPhoneContact1.pinyinFirst;
    String str = paramPhoneContact2.pinyinFirst;
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith("#")) {
      localObject1 = "Za";
    }
    localObject2 = str;
    if (str.endsWith("#")) {
      localObject2 = "Za";
    }
    int j = ((String)localObject1).compareTo((String)localObject2);
    int i = j;
    if (j == 0) {
      i = paramPhoneContact1.pinyinAll.compareTo(paramPhoneContact2.pinyinAll);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmu
 * JD-Core Version:    0.7.0.1
 */