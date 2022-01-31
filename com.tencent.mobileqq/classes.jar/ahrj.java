import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class ahrj
  implements Comparator<ahrl>
{
  ahrj(ahri paramahri) {}
  
  public int a(ahrl paramahrl1, ahrl paramahrl2)
  {
    if ((paramahrl1 == null) && (paramahrl2 == null)) {}
    int j;
    int k;
    do
    {
      do
      {
        return 0;
        if ((paramahrl1 == null) && (paramahrl2 != null)) {
          return -1;
        }
        if ((paramahrl1 != null) && (paramahrl2 == null)) {
          return 1;
        }
        paramahrl1 = paramahrl1.b;
        paramahrl2 = paramahrl2.b;
      } while ((paramahrl1 == null) && (paramahrl2 == null));
      if ((paramahrl1 == null) && (paramahrl2 != null)) {
        return -1;
      }
      if ((paramahrl1 != null) && (paramahrl2 == null)) {
        return 1;
      }
      j = paramahrl1.length();
      k = paramahrl2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramahrl1.charAt(i);
        char c2 = paramahrl2.charAt(i);
        if (c1 != c2)
        {
          paramahrl1 = ChnToSpell.a(c1);
          paramahrl2 = ChnToSpell.a(c2);
          if (paramahrl1.jdField_a_of_type_Int == paramahrl2.jdField_a_of_type_Int) {
            return paramahrl1.jdField_a_of_type_JavaLangString.compareTo(paramahrl2.jdField_a_of_type_JavaLangString);
          }
          return paramahrl1.jdField_a_of_type_Int - paramahrl2.jdField_a_of_type_Int;
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
 * Qualified Name:     ahrj
 * JD-Core Version:    0.7.0.1
 */