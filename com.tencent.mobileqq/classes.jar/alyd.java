import android.text.TextUtils;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;
import java.util.Set;

public class alyd
  implements Comparator<PhoneContact>
{
  private final alto jdField_a_of_type_Alto;
  private final Set<String> jdField_a_of_type_JavaUtilSet;
  private final int[] jdField_a_of_type_ArrayOfInt;
  
  public alyd(int[] paramArrayOfInt, Set<String> paramSet, alto paramalto)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.jdField_a_of_type_Alto = paramalto;
  }
  
  private int a(PhoneContact paramPhoneContact)
  {
    int j = bdgc.a(paramPhoneContact.detalStatusFlag, paramPhoneContact.iTermType);
    if ((j != 6) && (j != 0)) {}
    for (int i = 65536;; i = 131072) {
      switch (j)
      {
      case 5: 
      case 6: 
      default: 
        return i | (int)a(paramPhoneContact.unifiedCode);
      }
    }
    return i | 0x1;
    return i | 0x2;
    return i | 0x3;
  }
  
  private int b(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    int j = 1;
    if (("0".equals(paramPhoneContact1.uin)) || (TextUtils.isEmpty(paramPhoneContact1.uin))) {}
    for (int i = 0;; i = 1)
    {
      if (("0".equals(paramPhoneContact2.uin)) || (TextUtils.isEmpty(paramPhoneContact2.uin))) {
        j = 0;
      }
      return j - i;
    }
  }
  
  private int c(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    int i = 1;
    if (this.jdField_a_of_type_Alto == null) {
      return 0;
    }
    boolean bool1 = this.jdField_a_of_type_Alto.a(paramPhoneContact1.unifiedCode, true);
    boolean bool2 = this.jdField_a_of_type_Alto.a(paramPhoneContact2.unifiedCode, true);
    if (bool1) {}
    for (;;)
    {
      return i;
      if (bool2) {
        i = -1;
      } else {
        i = 0;
      }
    }
  }
  
  private int d(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    if ((paramPhoneContact2.samFriend > 0) && (paramPhoneContact1.samFriend > 0)) {}
    while ((paramPhoneContact2.samFriend <= 0) && (paramPhoneContact1.samFriend <= 0)) {
      return 0;
    }
    return e(paramPhoneContact1, paramPhoneContact2);
  }
  
  private int e(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    int i = 0;
    if (paramPhoneContact2.samFriend > paramPhoneContact1.samFriend) {
      i = 1;
    }
    while (paramPhoneContact2.samFriend >= paramPhoneContact1.samFriend) {
      return i;
    }
    return -1;
  }
  
  private int f(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    boolean bool1 = paramPhoneContact1.isNewRecommend;
    boolean bool2 = paramPhoneContact2.isNewRecommend;
    if (((bool1) || (bool2)) && ((!bool1) || (!bool2)))
    {
      if (bool2) {
        return 1;
      }
      return -1;
    }
    return 0;
  }
  
  private int g(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    return a(paramPhoneContact1) - a(paramPhoneContact2);
  }
  
  private int h(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
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
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    int i = 0;
    int j;
    if ((paramPhoneContact1 == null) || (paramPhoneContact2 == null)) {
      if (paramPhoneContact1 != null)
      {
        i = 1;
        j = i;
      }
    }
    int k;
    label36:
    do
    {
      return j;
      if (paramPhoneContact2 == null) {
        break;
      }
      i = -1;
      break;
      k = 0;
      i = 0;
      j = i;
    } while (k >= this.jdField_a_of_type_ArrayOfInt.length);
    switch (this.jdField_a_of_type_ArrayOfInt[k])
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      j = i;
      if (i != 0) {
        break;
      }
      k += 1;
      break label36;
      i = f(paramPhoneContact1, paramPhoneContact2);
      continue;
      i = g(paramPhoneContact1, paramPhoneContact2);
      continue;
      i = e(paramPhoneContact1, paramPhoneContact2);
      continue;
      i = h(paramPhoneContact1, paramPhoneContact2);
      continue;
      i = c(paramPhoneContact1, paramPhoneContact2);
      continue;
      i = b(paramPhoneContact1, paramPhoneContact2);
      continue;
      i = d(paramPhoneContact1, paramPhoneContact2);
    }
  }
  
  public long a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      return 0L;
    }
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {
      return 1L;
    }
    return 10L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alyd
 * JD-Core Version:    0.7.0.1
 */