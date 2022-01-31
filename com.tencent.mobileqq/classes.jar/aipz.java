import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.Comparator;

public class aipz
  implements Comparator<aiqb>
{
  private int a(aiqb paramaiqb)
  {
    if ((a(paramaiqb) == 0L) || (paramaiqb.jdField_a_of_type_Int == 4)) {
      return paramaiqb.jdField_a_of_type_Int + 3;
    }
    return paramaiqb.jdField_a_of_type_Int;
  }
  
  private long a(aiqb paramaiqb)
  {
    if ((paramaiqb.jdField_a_of_type_Aukm instanceof TroopInfo)) {
      return ((TroopInfo)paramaiqb.jdField_a_of_type_Aukm).lastMsgTime;
    }
    if ((paramaiqb.jdField_a_of_type_Aukm instanceof DiscussionInfo)) {
      return ((DiscussionInfo)paramaiqb.jdField_a_of_type_Aukm).lastMsgTime;
    }
    return 0L;
  }
  
  public int a(aiqb paramaiqb1, aiqb paramaiqb2)
  {
    if ((paramaiqb1 == null) && (paramaiqb2 == null)) {
      return 0;
    }
    if (paramaiqb1 == null) {
      return -1;
    }
    if (paramaiqb2 == null) {
      return 1;
    }
    if (a(paramaiqb1) == a(paramaiqb2)) {
      return (int)(a(paramaiqb2) - a(paramaiqb1));
    }
    return a(paramaiqb1) - a(paramaiqb2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aipz
 * JD-Core Version:    0.7.0.1
 */