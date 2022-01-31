import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class abjf
  implements Comparator<abjm>
{
  public abjf(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(abjm paramabjm1, abjm paramabjm2)
  {
    paramabjm1 = paramabjm1.a.name;
    paramabjm2 = paramabjm2.a.name;
    if ((paramabjm1 == null) && (paramabjm2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramabjm1 == null) && (paramabjm2 != null)) {
        return -1;
      }
      if ((paramabjm1 != null) && (paramabjm2 == null)) {
        return 1;
      }
      j = paramabjm1.length();
      k = paramabjm2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramabjm1.charAt(i);
        char c2 = paramabjm2.charAt(i);
        if (c1 != c2)
        {
          paramabjm1 = ChnToSpell.a(c1, i);
          paramabjm2 = ChnToSpell.a(c2, i);
          if (paramabjm1.jdField_a_of_type_Int == paramabjm2.jdField_a_of_type_Int) {
            return paramabjm1.jdField_a_of_type_JavaLangString.compareTo(paramabjm2.jdField_a_of_type_JavaLangString);
          }
          return paramabjm1.jdField_a_of_type_Int - paramabjm2.jdField_a_of_type_Int;
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
 * Qualified Name:     abjf
 * JD-Core Version:    0.7.0.1
 */