import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class afpf
  implements Comparator<afph>
{
  afpf(afpe paramafpe) {}
  
  public int a(afph paramafph1, afph paramafph2)
  {
    if ((paramafph1 == null) && (paramafph2 == null)) {}
    int j;
    int k;
    do
    {
      do
      {
        return 0;
        if ((paramafph1 == null) && (paramafph2 != null)) {
          return -1;
        }
        if ((paramafph1 != null) && (paramafph2 == null)) {
          return 1;
        }
        paramafph1 = paramafph1.b;
        paramafph2 = paramafph2.b;
      } while ((paramafph1 == null) && (paramafph2 == null));
      if ((paramafph1 == null) && (paramafph2 != null)) {
        return -1;
      }
      if ((paramafph1 != null) && (paramafph2 == null)) {
        return 1;
      }
      j = paramafph1.length();
      k = paramafph2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramafph1.charAt(i);
        char c2 = paramafph2.charAt(i);
        if (c1 != c2)
        {
          paramafph1 = ChnToSpell.a(c1);
          paramafph2 = ChnToSpell.a(c2);
          if (paramafph1.jdField_a_of_type_Int == paramafph2.jdField_a_of_type_Int) {
            return paramafph1.jdField_a_of_type_JavaLangString.compareTo(paramafph2.jdField_a_of_type_JavaLangString);
          }
          return paramafph1.jdField_a_of_type_Int - paramafph2.jdField_a_of_type_Int;
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
 * Qualified Name:     afpf
 * JD-Core Version:    0.7.0.1
 */