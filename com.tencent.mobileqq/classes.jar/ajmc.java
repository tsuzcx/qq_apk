import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class ajmc
  implements Comparator<ajmf>
{
  public ajmc(PublicAccountFragment paramPublicAccountFragment) {}
  
  public int a(ajmf paramajmf1, ajmf paramajmf2)
  {
    paramajmf1 = paramajmf1.a.name;
    paramajmf2 = paramajmf2.a.name;
    if ((paramajmf1 == null) && (paramajmf2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramajmf1 == null) && (paramajmf2 != null)) {
        return -1;
      }
      if ((paramajmf1 != null) && (paramajmf2 == null)) {
        return 1;
      }
      j = paramajmf1.length();
      k = paramajmf2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramajmf1.charAt(i);
        char c2 = paramajmf2.charAt(i);
        if (c1 != c2)
        {
          paramajmf1 = ChnToSpell.a(c1, i);
          paramajmf2 = ChnToSpell.a(c2, i);
          if (paramajmf1.jdField_a_of_type_Int == paramajmf2.jdField_a_of_type_Int) {
            return paramajmf1.jdField_a_of_type_JavaLangString.compareTo(paramajmf2.jdField_a_of_type_JavaLangString);
          }
          return paramajmf1.jdField_a_of_type_Int - paramajmf2.jdField_a_of_type_Int;
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
 * Qualified Name:     ajmc
 * JD-Core Version:    0.7.0.1
 */