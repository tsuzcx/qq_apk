import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class abtb
  implements Comparator<abti>
{
  public abtb(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(abti paramabti1, abti paramabti2)
  {
    paramabti1 = paramabti1.a.name;
    paramabti2 = paramabti2.a.name;
    if ((paramabti1 == null) && (paramabti2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramabti1 == null) && (paramabti2 != null)) {
        return -1;
      }
      if ((paramabti1 != null) && (paramabti2 == null)) {
        return 1;
      }
      j = paramabti1.length();
      k = paramabti2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramabti1.charAt(i);
        char c2 = paramabti2.charAt(i);
        if (c1 != c2)
        {
          paramabti1 = ChnToSpell.a(c1, i);
          paramabti2 = ChnToSpell.a(c2, i);
          if (paramabti1.jdField_a_of_type_Int == paramabti2.jdField_a_of_type_Int) {
            return paramabti1.jdField_a_of_type_JavaLangString.compareTo(paramabti2.jdField_a_of_type_JavaLangString);
          }
          return paramabti1.jdField_a_of_type_Int - paramabti2.jdField_a_of_type_Int;
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
 * Qualified Name:     abtb
 * JD-Core Version:    0.7.0.1
 */