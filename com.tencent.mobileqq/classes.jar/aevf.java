import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class aevf
  implements Comparator<aevm>
{
  public aevf(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(aevm paramaevm1, aevm paramaevm2)
  {
    paramaevm1 = paramaevm1.a.name;
    paramaevm2 = paramaevm2.a.name;
    if ((paramaevm1 == null) && (paramaevm2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramaevm1 == null) && (paramaevm2 != null)) {
        return -1;
      }
      if ((paramaevm1 != null) && (paramaevm2 == null)) {
        return 1;
      }
      j = paramaevm1.length();
      k = paramaevm2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramaevm1.charAt(i);
        char c2 = paramaevm2.charAt(i);
        if (c1 != c2)
        {
          paramaevm1 = ChnToSpell.a(c1, i);
          paramaevm2 = ChnToSpell.a(c2, i);
          if (paramaevm1.jdField_a_of_type_Int == paramaevm2.jdField_a_of_type_Int) {
            return paramaevm1.jdField_a_of_type_JavaLangString.compareTo(paramaevm2.jdField_a_of_type_JavaLangString);
          }
          return paramaevm1.jdField_a_of_type_Int - paramaevm2.jdField_a_of_type_Int;
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
 * Qualified Name:     aevf
 * JD-Core Version:    0.7.0.1
 */