import android.text.TextUtils;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

public final class aehm
  implements Comparator<PhoneContact>
{
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    boolean bool1 = TextUtils.isEmpty(paramPhoneContact1.pinyinFirst);
    boolean bool2 = TextUtils.isEmpty(paramPhoneContact2.pinyinFirst);
    if ((bool1) || (bool2))
    {
      if ((bool1) && (bool2)) {
        return 0;
      }
      if (bool2) {
        return -1;
      }
      return 1;
    }
    return paramPhoneContact1.pinyinFirst.toLowerCase().charAt(0) - paramPhoneContact2.pinyinFirst.toLowerCase().charAt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehm
 * JD-Core Version:    0.7.0.1
 */