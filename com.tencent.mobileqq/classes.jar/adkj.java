import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class adkj
  implements Comparator<adkq>
{
  public adkj(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(adkq paramadkq1, adkq paramadkq2)
  {
    paramadkq1 = paramadkq1.a.name;
    paramadkq2 = paramadkq2.a.name;
    if ((paramadkq1 == null) && (paramadkq2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramadkq1 == null) && (paramadkq2 != null)) {
        return -1;
      }
      if ((paramadkq1 != null) && (paramadkq2 == null)) {
        return 1;
      }
      j = paramadkq1.length();
      k = paramadkq2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramadkq1.charAt(i);
        char c2 = paramadkq2.charAt(i);
        if (c1 != c2)
        {
          paramadkq1 = ChnToSpell.a(c1, i);
          paramadkq2 = ChnToSpell.a(c2, i);
          if (paramadkq1.jdField_a_of_type_Int == paramadkq2.jdField_a_of_type_Int) {
            return paramadkq1.jdField_a_of_type_JavaLangString.compareTo(paramadkq2.jdField_a_of_type_JavaLangString);
          }
          return paramadkq1.jdField_a_of_type_Int - paramadkq2.jdField_a_of_type_Int;
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
 * Qualified Name:     adkj
 * JD-Core Version:    0.7.0.1
 */