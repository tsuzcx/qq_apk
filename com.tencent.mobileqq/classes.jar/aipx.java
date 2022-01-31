import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.Comparator;

public class aipx
  implements Comparator<aipz>
{
  private int a(aipz paramaipz)
  {
    if ((a(paramaipz) == 0L) || (paramaipz.jdField_a_of_type_Int == 4)) {
      return paramaipz.jdField_a_of_type_Int + 3;
    }
    return paramaipz.jdField_a_of_type_Int;
  }
  
  private long a(aipz paramaipz)
  {
    if ((paramaipz.jdField_a_of_type_Auko instanceof TroopInfo)) {
      return ((TroopInfo)paramaipz.jdField_a_of_type_Auko).lastMsgTime;
    }
    if ((paramaipz.jdField_a_of_type_Auko instanceof DiscussionInfo)) {
      return ((DiscussionInfo)paramaipz.jdField_a_of_type_Auko).lastMsgTime;
    }
    return 0L;
  }
  
  public int a(aipz paramaipz1, aipz paramaipz2)
  {
    if ((paramaipz1 == null) && (paramaipz2 == null)) {
      return 0;
    }
    if (paramaipz1 == null) {
      return -1;
    }
    if (paramaipz2 == null) {
      return 1;
    }
    if (a(paramaipz1) == a(paramaipz2)) {
      return (int)(a(paramaipz2) - a(paramaipz1));
    }
    return a(paramaipz1) - a(paramaipz2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aipx
 * JD-Core Version:    0.7.0.1
 */