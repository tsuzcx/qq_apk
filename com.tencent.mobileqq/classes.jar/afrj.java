import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class afrj
  implements Comparator<afrm>
{
  public afrj(PublicAccountFragment paramPublicAccountFragment) {}
  
  public int a(afrm paramafrm1, afrm paramafrm2)
  {
    paramafrm1 = paramafrm1.a.name;
    paramafrm2 = paramafrm2.a.name;
    if ((paramafrm1 == null) && (paramafrm2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramafrm1 == null) && (paramafrm2 != null)) {
        return -1;
      }
      if ((paramafrm1 != null) && (paramafrm2 == null)) {
        return 1;
      }
      j = paramafrm1.length();
      k = paramafrm2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramafrm1.charAt(i);
        char c2 = paramafrm2.charAt(i);
        if (c1 != c2)
        {
          paramafrm1 = ChnToSpell.a(c1, i);
          paramafrm2 = ChnToSpell.a(c2, i);
          if (paramafrm1.jdField_a_of_type_Int == paramafrm2.jdField_a_of_type_Int) {
            return paramafrm1.jdField_a_of_type_JavaLangString.compareTo(paramafrm2.jdField_a_of_type_JavaLangString);
          }
          return paramafrm1.jdField_a_of_type_Int - paramafrm2.jdField_a_of_type_Int;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afrj
 * JD-Core Version:    0.7.0.1
 */