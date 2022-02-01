import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class ajrz
  implements Comparator<ajsb>
{
  ajrz(ajry paramajry) {}
  
  public int a(ajsb paramajsb1, ajsb paramajsb2)
  {
    if ((paramajsb1 == null) && (paramajsb2 == null)) {}
    int j;
    int k;
    do
    {
      do
      {
        return 0;
        if ((paramajsb1 == null) && (paramajsb2 != null)) {
          return -1;
        }
        if ((paramajsb1 != null) && (paramajsb2 == null)) {
          return 1;
        }
        paramajsb1 = paramajsb1.b;
        paramajsb2 = paramajsb2.b;
      } while ((paramajsb1 == null) && (paramajsb2 == null));
      if ((paramajsb1 == null) && (paramajsb2 != null)) {
        return -1;
      }
      if ((paramajsb1 != null) && (paramajsb2 == null)) {
        return 1;
      }
      j = paramajsb1.length();
      k = paramajsb2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramajsb1.charAt(i);
        char c2 = paramajsb2.charAt(i);
        if (c1 != c2)
        {
          paramajsb1 = ChnToSpell.a(c1);
          paramajsb2 = ChnToSpell.a(c2);
          if (paramajsb1.jdField_a_of_type_Int == paramajsb2.jdField_a_of_type_Int) {
            return paramajsb1.jdField_a_of_type_JavaLangString.compareTo(paramajsb2.jdField_a_of_type_JavaLangString);
          }
          return paramajsb1.jdField_a_of_type_Int - paramajsb2.jdField_a_of_type_Int;
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
 * Qualified Name:     ajrz
 * JD-Core Version:    0.7.0.1
 */