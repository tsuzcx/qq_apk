import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class afdj
  implements Comparator<afdl>
{
  afdj(afdi paramafdi) {}
  
  public int a(afdl paramafdl1, afdl paramafdl2)
  {
    if ((paramafdl1 == null) && (paramafdl2 == null)) {}
    int j;
    int k;
    do
    {
      do
      {
        return 0;
        if ((paramafdl1 == null) && (paramafdl2 != null)) {
          return -1;
        }
        if ((paramafdl1 != null) && (paramafdl2 == null)) {
          return 1;
        }
        paramafdl1 = paramafdl1.b;
        paramafdl2 = paramafdl2.b;
      } while ((paramafdl1 == null) && (paramafdl2 == null));
      if ((paramafdl1 == null) && (paramafdl2 != null)) {
        return -1;
      }
      if ((paramafdl1 != null) && (paramafdl2 == null)) {
        return 1;
      }
      j = paramafdl1.length();
      k = paramafdl2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramafdl1.charAt(i);
        char c2 = paramafdl2.charAt(i);
        if (c1 != c2)
        {
          paramafdl1 = ChnToSpell.a(c1);
          paramafdl2 = ChnToSpell.a(c2);
          if (paramafdl1.jdField_a_of_type_Int == paramafdl2.jdField_a_of_type_Int) {
            return paramafdl1.jdField_a_of_type_JavaLangString.compareTo(paramafdl2.jdField_a_of_type_JavaLangString);
          }
          return paramafdl1.jdField_a_of_type_Int - paramafdl2.jdField_a_of_type_Int;
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
 * Qualified Name:     afdj
 * JD-Core Version:    0.7.0.1
 */