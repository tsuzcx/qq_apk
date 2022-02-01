import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class aiqn
  implements Comparator<aiqq>
{
  public aiqn(PublicAccountFragment paramPublicAccountFragment) {}
  
  public int a(aiqq paramaiqq1, aiqq paramaiqq2)
  {
    paramaiqq1 = paramaiqq1.a.name;
    paramaiqq2 = paramaiqq2.a.name;
    if ((paramaiqq1 == null) && (paramaiqq2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramaiqq1 == null) && (paramaiqq2 != null)) {
        return -1;
      }
      if ((paramaiqq1 != null) && (paramaiqq2 == null)) {
        return 1;
      }
      j = paramaiqq1.length();
      k = paramaiqq2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramaiqq1.charAt(i);
        char c2 = paramaiqq2.charAt(i);
        if (c1 != c2)
        {
          paramaiqq1 = ChnToSpell.a(c1, i);
          paramaiqq2 = ChnToSpell.a(c2, i);
          if (paramaiqq1.jdField_a_of_type_Int == paramaiqq2.jdField_a_of_type_Int) {
            return paramaiqq1.jdField_a_of_type_JavaLangString.compareTo(paramaiqq2.jdField_a_of_type_JavaLangString);
          }
          return paramaiqq1.jdField_a_of_type_Int - paramaiqq2.jdField_a_of_type_Int;
        }
        i += 1;
      }
      if (j < k) {
        return -1;
      }
    } while (j <= k);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqn
 * JD-Core Version:    0.7.0.1
 */