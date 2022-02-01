import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class aimw
  implements Comparator<aimy>
{
  aimw(aimv paramaimv) {}
  
  public int a(aimy paramaimy1, aimy paramaimy2)
  {
    if ((paramaimy1 == null) && (paramaimy2 == null)) {}
    int j;
    int k;
    do
    {
      do
      {
        return 0;
        if ((paramaimy1 == null) && (paramaimy2 != null)) {
          return -1;
        }
        if ((paramaimy1 != null) && (paramaimy2 == null)) {
          return 1;
        }
        paramaimy1 = paramaimy1.b;
        paramaimy2 = paramaimy2.b;
      } while ((paramaimy1 == null) && (paramaimy2 == null));
      if ((paramaimy1 == null) && (paramaimy2 != null)) {
        return -1;
      }
      if ((paramaimy1 != null) && (paramaimy2 == null)) {
        return 1;
      }
      j = paramaimy1.length();
      k = paramaimy2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramaimy1.charAt(i);
        char c2 = paramaimy2.charAt(i);
        if (c1 != c2)
        {
          paramaimy1 = ChnToSpell.a(c1);
          paramaimy2 = ChnToSpell.a(c2);
          if (paramaimy1.jdField_a_of_type_Int == paramaimy2.jdField_a_of_type_Int) {
            return paramaimy1.jdField_a_of_type_JavaLangString.compareTo(paramaimy2.jdField_a_of_type_JavaLangString);
          }
          return paramaimy1.jdField_a_of_type_Int - paramaimy2.jdField_a_of_type_Int;
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
 * Qualified Name:     aimw
 * JD-Core Version:    0.7.0.1
 */