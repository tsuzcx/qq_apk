import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class afrh
  implements Comparator<afrk>
{
  public afrh(PublicAccountFragment paramPublicAccountFragment) {}
  
  public int a(afrk paramafrk1, afrk paramafrk2)
  {
    paramafrk1 = paramafrk1.a.name;
    paramafrk2 = paramafrk2.a.name;
    if ((paramafrk1 == null) && (paramafrk2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramafrk1 == null) && (paramafrk2 != null)) {
        return -1;
      }
      if ((paramafrk1 != null) && (paramafrk2 == null)) {
        return 1;
      }
      j = paramafrk1.length();
      k = paramafrk2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramafrk1.charAt(i);
        char c2 = paramafrk2.charAt(i);
        if (c1 != c2)
        {
          paramafrk1 = ChnToSpell.a(c1, i);
          paramafrk2 = ChnToSpell.a(c2, i);
          if (paramafrk1.jdField_a_of_type_Int == paramafrk2.jdField_a_of_type_Int) {
            return paramafrk1.jdField_a_of_type_JavaLangString.compareTo(paramafrk2.jdField_a_of_type_JavaLangString);
          }
          return paramafrk1.jdField_a_of_type_Int - paramafrk2.jdField_a_of_type_Int;
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
 * Qualified Name:     afrh
 * JD-Core Version:    0.7.0.1
 */