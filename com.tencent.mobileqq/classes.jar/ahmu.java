import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class ahmu
  implements Comparator<ahmw>
{
  ahmu(ahmt paramahmt) {}
  
  public int a(ahmw paramahmw1, ahmw paramahmw2)
  {
    if ((paramahmw1 == null) && (paramahmw2 == null)) {}
    int j;
    int k;
    do
    {
      do
      {
        return 0;
        if ((paramahmw1 == null) && (paramahmw2 != null)) {
          return -1;
        }
        if ((paramahmw1 != null) && (paramahmw2 == null)) {
          return 1;
        }
        paramahmw1 = paramahmw1.b;
        paramahmw2 = paramahmw2.b;
      } while ((paramahmw1 == null) && (paramahmw2 == null));
      if ((paramahmw1 == null) && (paramahmw2 != null)) {
        return -1;
      }
      if ((paramahmw1 != null) && (paramahmw2 == null)) {
        return 1;
      }
      j = paramahmw1.length();
      k = paramahmw2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramahmw1.charAt(i);
        char c2 = paramahmw2.charAt(i);
        if (c1 != c2)
        {
          paramahmw1 = ChnToSpell.a(c1);
          paramahmw2 = ChnToSpell.a(c2);
          if (paramahmw1.jdField_a_of_type_Int == paramahmw2.jdField_a_of_type_Int) {
            return paramahmw1.jdField_a_of_type_JavaLangString.compareTo(paramahmw2.jdField_a_of_type_JavaLangString);
          }
          return paramahmw1.jdField_a_of_type_Int - paramahmw2.jdField_a_of_type_Int;
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
 * Qualified Name:     ahmu
 * JD-Core Version:    0.7.0.1
 */