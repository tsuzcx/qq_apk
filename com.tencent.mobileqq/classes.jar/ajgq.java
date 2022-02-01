import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class ajgq
  implements Comparator<ajgs>
{
  ajgq(ajgp paramajgp) {}
  
  public int a(ajgs paramajgs1, ajgs paramajgs2)
  {
    if ((paramajgs1 == null) && (paramajgs2 == null)) {}
    int j;
    int k;
    do
    {
      do
      {
        return 0;
        if ((paramajgs1 == null) && (paramajgs2 != null)) {
          return -1;
        }
        if ((paramajgs1 != null) && (paramajgs2 == null)) {
          return 1;
        }
        paramajgs1 = paramajgs1.b;
        paramajgs2 = paramajgs2.b;
      } while ((paramajgs1 == null) && (paramajgs2 == null));
      if ((paramajgs1 == null) && (paramajgs2 != null)) {
        return -1;
      }
      if ((paramajgs1 != null) && (paramajgs2 == null)) {
        return 1;
      }
      j = paramajgs1.length();
      k = paramajgs2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramajgs1.charAt(i);
        char c2 = paramajgs2.charAt(i);
        if (c1 != c2)
        {
          paramajgs1 = ChnToSpell.a(c1);
          paramajgs2 = ChnToSpell.a(c2);
          if (paramajgs1.jdField_a_of_type_Int == paramajgs2.jdField_a_of_type_Int) {
            return paramajgs1.jdField_a_of_type_JavaLangString.compareTo(paramajgs2.jdField_a_of_type_JavaLangString);
          }
          return paramajgs1.jdField_a_of_type_Int - paramajgs2.jdField_a_of_type_Int;
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
 * Qualified Name:     ajgq
 * JD-Core Version:    0.7.0.1
 */