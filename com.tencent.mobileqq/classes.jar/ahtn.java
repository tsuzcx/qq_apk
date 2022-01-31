import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class ahtn
  implements Comparator<ahtq>
{
  public ahtn(PublicAccountFragment paramPublicAccountFragment) {}
  
  public int a(ahtq paramahtq1, ahtq paramahtq2)
  {
    paramahtq1 = paramahtq1.a.name;
    paramahtq2 = paramahtq2.a.name;
    if ((paramahtq1 == null) && (paramahtq2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramahtq1 == null) && (paramahtq2 != null)) {
        return -1;
      }
      if ((paramahtq1 != null) && (paramahtq2 == null)) {
        return 1;
      }
      j = paramahtq1.length();
      k = paramahtq2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramahtq1.charAt(i);
        char c2 = paramahtq2.charAt(i);
        if (c1 != c2)
        {
          paramahtq1 = ChnToSpell.a(c1, i);
          paramahtq2 = ChnToSpell.a(c2, i);
          if (paramahtq1.jdField_a_of_type_Int == paramahtq2.jdField_a_of_type_Int) {
            return paramahtq1.jdField_a_of_type_JavaLangString.compareTo(paramahtq2.jdField_a_of_type_JavaLangString);
          }
          return paramahtq1.jdField_a_of_type_Int - paramahtq2.jdField_a_of_type_Int;
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
 * Qualified Name:     ahtn
 * JD-Core Version:    0.7.0.1
 */