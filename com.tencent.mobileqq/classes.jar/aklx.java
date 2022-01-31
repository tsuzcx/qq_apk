import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.Comparator;

public class aklx
  implements Comparator<aklz>
{
  private int a(aklz paramaklz)
  {
    if ((a(paramaklz) == 0L) || (paramaklz.jdField_a_of_type_Int == 4)) {
      return paramaklz.jdField_a_of_type_Int + 3;
    }
    return paramaklz.jdField_a_of_type_Int;
  }
  
  private long a(aklz paramaklz)
  {
    if ((paramaklz.jdField_a_of_type_Awge instanceof TroopInfo)) {
      return ((TroopInfo)paramaklz.jdField_a_of_type_Awge).lastMsgTime;
    }
    if ((paramaklz.jdField_a_of_type_Awge instanceof DiscussionInfo)) {
      return ((DiscussionInfo)paramaklz.jdField_a_of_type_Awge).lastMsgTime;
    }
    return 0L;
  }
  
  public int a(aklz paramaklz1, aklz paramaklz2)
  {
    if ((paramaklz1 == null) && (paramaklz2 == null)) {
      return 0;
    }
    if (paramaklz1 == null) {
      return -1;
    }
    if (paramaklz2 == null) {
      return 1;
    }
    if (a(paramaklz1) == a(paramaklz2)) {
      return (int)(a(paramaklz2) - a(paramaklz1));
    }
    return a(paramaklz1) - a(paramaklz2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aklx
 * JD-Core Version:    0.7.0.1
 */