import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class ajkh
  implements Comparator<ajkk>
{
  public ajkh(PublicAccountFragment paramPublicAccountFragment) {}
  
  public int a(ajkk paramajkk1, ajkk paramajkk2)
  {
    paramajkk1 = paramajkk1.a.name;
    paramajkk2 = paramajkk2.a.name;
    if ((paramajkk1 == null) && (paramajkk2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramajkk1 == null) && (paramajkk2 != null)) {
        return -1;
      }
      if ((paramajkk1 != null) && (paramajkk2 == null)) {
        return 1;
      }
      j = paramajkk1.length();
      k = paramajkk2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramajkk1.charAt(i);
        char c2 = paramajkk2.charAt(i);
        if (c1 != c2)
        {
          paramajkk1 = ChnToSpell.a(c1, i);
          paramajkk2 = ChnToSpell.a(c2, i);
          if (paramajkk1.jdField_a_of_type_Int == paramajkk2.jdField_a_of_type_Int) {
            return paramajkk1.jdField_a_of_type_JavaLangString.compareTo(paramajkk2.jdField_a_of_type_JavaLangString);
          }
          return paramajkk1.jdField_a_of_type_Int - paramajkk2.jdField_a_of_type_Int;
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
 * Qualified Name:     ajkh
 * JD-Core Version:    0.7.0.1
 */