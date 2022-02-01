import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class afej
  implements Comparator<afeq>
{
  public afej(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(afeq paramafeq1, afeq paramafeq2)
  {
    paramafeq1 = paramafeq1.a.name;
    paramafeq2 = paramafeq2.a.name;
    if ((paramafeq1 == null) && (paramafeq2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramafeq1 == null) && (paramafeq2 != null)) {
        return -1;
      }
      if ((paramafeq1 != null) && (paramafeq2 == null)) {
        return 1;
      }
      j = paramafeq1.length();
      k = paramafeq2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramafeq1.charAt(i);
        char c2 = paramafeq2.charAt(i);
        if (c1 != c2)
        {
          paramafeq1 = ChnToSpell.a(c1, i);
          paramafeq2 = ChnToSpell.a(c2, i);
          if (paramafeq1.jdField_a_of_type_Int == paramafeq2.jdField_a_of_type_Int) {
            return paramafeq1.jdField_a_of_type_JavaLangString.compareTo(paramafeq2.jdField_a_of_type_JavaLangString);
          }
          return paramafeq1.jdField_a_of_type_Int - paramafeq2.jdField_a_of_type_Int;
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
 * Qualified Name:     afej
 * JD-Core Version:    0.7.0.1
 */