import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class ajil
  implements Comparator<ajin>
{
  ajil(ajik paramajik) {}
  
  public int a(ajin paramajin1, ajin paramajin2)
  {
    if ((paramajin1 == null) && (paramajin2 == null)) {}
    int j;
    int k;
    do
    {
      do
      {
        return 0;
        if ((paramajin1 == null) && (paramajin2 != null)) {
          return -1;
        }
        if ((paramajin1 != null) && (paramajin2 == null)) {
          return 1;
        }
        paramajin1 = paramajin1.b;
        paramajin2 = paramajin2.b;
      } while ((paramajin1 == null) && (paramajin2 == null));
      if ((paramajin1 == null) && (paramajin2 != null)) {
        return -1;
      }
      if ((paramajin1 != null) && (paramajin2 == null)) {
        return 1;
      }
      j = paramajin1.length();
      k = paramajin2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramajin1.charAt(i);
        char c2 = paramajin2.charAt(i);
        if (c1 != c2)
        {
          paramajin1 = ChnToSpell.a(c1);
          paramajin2 = ChnToSpell.a(c2);
          if (paramajin1.jdField_a_of_type_Int == paramajin2.jdField_a_of_type_Int) {
            return paramajin1.jdField_a_of_type_JavaLangString.compareTo(paramajin2.jdField_a_of_type_JavaLangString);
          }
          return paramajin1.jdField_a_of_type_Int - paramajin2.jdField_a_of_type_Int;
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
 * Qualified Name:     ajil
 * JD-Core Version:    0.7.0.1
 */