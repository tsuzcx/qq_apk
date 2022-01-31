import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class affm
  implements Comparator<affp>
{
  public affm(PublicAccountFragment paramPublicAccountFragment) {}
  
  public int a(affp paramaffp1, affp paramaffp2)
  {
    paramaffp1 = paramaffp1.a.name;
    paramaffp2 = paramaffp2.a.name;
    if ((paramaffp1 == null) && (paramaffp2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramaffp1 == null) && (paramaffp2 != null)) {
        return -1;
      }
      if ((paramaffp1 != null) && (paramaffp2 == null)) {
        return 1;
      }
      j = paramaffp1.length();
      k = paramaffp2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramaffp1.charAt(i);
        char c2 = paramaffp2.charAt(i);
        if (c1 != c2)
        {
          paramaffp1 = ChnToSpell.a(c1, i);
          paramaffp2 = ChnToSpell.a(c2, i);
          if (paramaffp1.jdField_a_of_type_Int == paramaffp2.jdField_a_of_type_Int) {
            return paramaffp1.jdField_a_of_type_JavaLangString.compareTo(paramaffp2.jdField_a_of_type_JavaLangString);
          }
          return paramaffp1.jdField_a_of_type_Int - paramaffp2.jdField_a_of_type_Int;
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
 * Qualified Name:     affm
 * JD-Core Version:    0.7.0.1
 */