import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class abtf
  implements Comparator<abtm>
{
  public abtf(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(abtm paramabtm1, abtm paramabtm2)
  {
    paramabtm1 = paramabtm1.a.name;
    paramabtm2 = paramabtm2.a.name;
    if ((paramabtm1 == null) && (paramabtm2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramabtm1 == null) && (paramabtm2 != null)) {
        return -1;
      }
      if ((paramabtm1 != null) && (paramabtm2 == null)) {
        return 1;
      }
      j = paramabtm1.length();
      k = paramabtm2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramabtm1.charAt(i);
        char c2 = paramabtm2.charAt(i);
        if (c1 != c2)
        {
          paramabtm1 = ChnToSpell.a(c1, i);
          paramabtm2 = ChnToSpell.a(c2, i);
          if (paramabtm1.jdField_a_of_type_Int == paramabtm2.jdField_a_of_type_Int) {
            return paramabtm1.jdField_a_of_type_JavaLangString.compareTo(paramabtm2.jdField_a_of_type_JavaLangString);
          }
          return paramabtm1.jdField_a_of_type_Int - paramabtm2.jdField_a_of_type_Int;
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
 * Qualified Name:     abtf
 * JD-Core Version:    0.7.0.1
 */