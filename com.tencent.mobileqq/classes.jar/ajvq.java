import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class ajvq
  implements Comparator<ajvt>
{
  public ajvq(PublicAccountFragment paramPublicAccountFragment) {}
  
  public int a(ajvt paramajvt1, ajvt paramajvt2)
  {
    paramajvt1 = paramajvt1.a.name;
    paramajvt2 = paramajvt2.a.name;
    if ((paramajvt1 == null) && (paramajvt2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramajvt1 == null) && (paramajvt2 != null)) {
        return -1;
      }
      if ((paramajvt1 != null) && (paramajvt2 == null)) {
        return 1;
      }
      j = paramajvt1.length();
      k = paramajvt2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramajvt1.charAt(i);
        char c2 = paramajvt2.charAt(i);
        if (c1 != c2)
        {
          paramajvt1 = ChnToSpell.a(c1, i);
          paramajvt2 = ChnToSpell.a(c2, i);
          if (paramajvt1.jdField_a_of_type_Int == paramajvt2.jdField_a_of_type_Int) {
            return paramajvt1.jdField_a_of_type_JavaLangString.compareTo(paramajvt2.jdField_a_of_type_JavaLangString);
          }
          return paramajvt1.jdField_a_of_type_Int - paramajvt2.jdField_a_of_type_Int;
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
 * Qualified Name:     ajvq
 * JD-Core Version:    0.7.0.1
 */