import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class adoy
  implements Comparator<adpf>
{
  public adoy(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(adpf paramadpf1, adpf paramadpf2)
  {
    paramadpf1 = paramadpf1.a.name;
    paramadpf2 = paramadpf2.a.name;
    if ((paramadpf1 == null) && (paramadpf2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramadpf1 == null) && (paramadpf2 != null)) {
        return -1;
      }
      if ((paramadpf1 != null) && (paramadpf2 == null)) {
        return 1;
      }
      j = paramadpf1.length();
      k = paramadpf2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramadpf1.charAt(i);
        char c2 = paramadpf2.charAt(i);
        if (c1 != c2)
        {
          paramadpf1 = ChnToSpell.a(c1, i);
          paramadpf2 = ChnToSpell.a(c2, i);
          if (paramadpf1.jdField_a_of_type_Int == paramadpf2.jdField_a_of_type_Int) {
            return paramadpf1.jdField_a_of_type_JavaLangString.compareTo(paramadpf2.jdField_a_of_type_JavaLangString);
          }
          return paramadpf1.jdField_a_of_type_Int - paramadpf2.jdField_a_of_type_Int;
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
 * Qualified Name:     adoy
 * JD-Core Version:    0.7.0.1
 */