import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class adxb
  implements Comparator<adxi>
{
  public adxb(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(adxi paramadxi1, adxi paramadxi2)
  {
    paramadxi1 = paramadxi1.a.name;
    paramadxi2 = paramadxi2.a.name;
    if ((paramadxi1 == null) && (paramadxi2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramadxi1 == null) && (paramadxi2 != null)) {
        return -1;
      }
      if ((paramadxi1 != null) && (paramadxi2 == null)) {
        return 1;
      }
      j = paramadxi1.length();
      k = paramadxi2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramadxi1.charAt(i);
        char c2 = paramadxi2.charAt(i);
        if (c1 != c2)
        {
          paramadxi1 = ChnToSpell.a(c1, i);
          paramadxi2 = ChnToSpell.a(c2, i);
          if (paramadxi1.jdField_a_of_type_Int == paramadxi2.jdField_a_of_type_Int) {
            return paramadxi1.jdField_a_of_type_JavaLangString.compareTo(paramadxi2.jdField_a_of_type_JavaLangString);
          }
          return paramadxi1.jdField_a_of_type_Int - paramadxi2.jdField_a_of_type_Int;
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
 * Qualified Name:     adxb
 * JD-Core Version:    0.7.0.1
 */