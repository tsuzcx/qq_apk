import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class afpd
  implements Comparator<afpf>
{
  afpd(afpc paramafpc) {}
  
  public int a(afpf paramafpf1, afpf paramafpf2)
  {
    if ((paramafpf1 == null) && (paramafpf2 == null)) {}
    int j;
    int k;
    do
    {
      do
      {
        return 0;
        if ((paramafpf1 == null) && (paramafpf2 != null)) {
          return -1;
        }
        if ((paramafpf1 != null) && (paramafpf2 == null)) {
          return 1;
        }
        paramafpf1 = paramafpf1.b;
        paramafpf2 = paramafpf2.b;
      } while ((paramafpf1 == null) && (paramafpf2 == null));
      if ((paramafpf1 == null) && (paramafpf2 != null)) {
        return -1;
      }
      if ((paramafpf1 != null) && (paramafpf2 == null)) {
        return 1;
      }
      j = paramafpf1.length();
      k = paramafpf2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramafpf1.charAt(i);
        char c2 = paramafpf2.charAt(i);
        if (c1 != c2)
        {
          paramafpf1 = ChnToSpell.a(c1);
          paramafpf2 = ChnToSpell.a(c2);
          if (paramafpf1.jdField_a_of_type_Int == paramafpf2.jdField_a_of_type_Int) {
            return paramafpf1.jdField_a_of_type_JavaLangString.compareTo(paramafpf2.jdField_a_of_type_JavaLangString);
          }
          return paramafpf1.jdField_a_of_type_Int - paramafpf2.jdField_a_of_type_Int;
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
 * Qualified Name:     afpd
 * JD-Core Version:    0.7.0.1
 */