import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class aeog
  implements Comparator<aeon>
{
  public aeog(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(aeon paramaeon1, aeon paramaeon2)
  {
    paramaeon1 = paramaeon1.a.name;
    paramaeon2 = paramaeon2.a.name;
    if ((paramaeon1 == null) && (paramaeon2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramaeon1 == null) && (paramaeon2 != null)) {
        return -1;
      }
      if ((paramaeon1 != null) && (paramaeon2 == null)) {
        return 1;
      }
      j = paramaeon1.length();
      k = paramaeon2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramaeon1.charAt(i);
        char c2 = paramaeon2.charAt(i);
        if (c1 != c2)
        {
          paramaeon1 = ChnToSpell.a(c1, i);
          paramaeon2 = ChnToSpell.a(c2, i);
          if (paramaeon1.jdField_a_of_type_Int == paramaeon2.jdField_a_of_type_Int) {
            return paramaeon1.jdField_a_of_type_JavaLangString.compareTo(paramaeon2.jdField_a_of_type_JavaLangString);
          }
          return paramaeon1.jdField_a_of_type_Int - paramaeon2.jdField_a_of_type_Int;
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
 * Qualified Name:     aeog
 * JD-Core Version:    0.7.0.1
 */