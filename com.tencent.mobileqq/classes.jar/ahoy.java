import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class ahoy
  implements Comparator<ahpb>
{
  public ahoy(PublicAccountFragment paramPublicAccountFragment) {}
  
  public int a(ahpb paramahpb1, ahpb paramahpb2)
  {
    paramahpb1 = paramahpb1.a.name;
    paramahpb2 = paramahpb2.a.name;
    if ((paramahpb1 == null) && (paramahpb2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramahpb1 == null) && (paramahpb2 != null)) {
        return -1;
      }
      if ((paramahpb1 != null) && (paramahpb2 == null)) {
        return 1;
      }
      j = paramahpb1.length();
      k = paramahpb2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramahpb1.charAt(i);
        char c2 = paramahpb2.charAt(i);
        if (c1 != c2)
        {
          paramahpb1 = ChnToSpell.a(c1, i);
          paramahpb2 = ChnToSpell.a(c2, i);
          if (paramahpb1.jdField_a_of_type_Int == paramahpb2.jdField_a_of_type_Int) {
            return paramahpb1.jdField_a_of_type_JavaLangString.compareTo(paramahpb2.jdField_a_of_type_JavaLangString);
          }
          return paramahpb1.jdField_a_of_type_Int - paramahpb2.jdField_a_of_type_Int;
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
 * Qualified Name:     ahoy
 * JD-Core Version:    0.7.0.1
 */