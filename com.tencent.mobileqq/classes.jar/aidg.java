import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.Comparator;

public class aidg
  implements Comparator<aidi>
{
  private int a(aidi paramaidi)
  {
    if ((a(paramaidi) == 0L) || (paramaidi.jdField_a_of_type_Int == 4)) {
      return paramaidi.jdField_a_of_type_Int + 3;
    }
    return paramaidi.jdField_a_of_type_Int;
  }
  
  private long a(aidi paramaidi)
  {
    if ((paramaidi.jdField_a_of_type_Atmo instanceof TroopInfo)) {
      return ((TroopInfo)paramaidi.jdField_a_of_type_Atmo).lastMsgTime;
    }
    if ((paramaidi.jdField_a_of_type_Atmo instanceof DiscussionInfo)) {
      return ((DiscussionInfo)paramaidi.jdField_a_of_type_Atmo).lastMsgTime;
    }
    return 0L;
  }
  
  public int a(aidi paramaidi1, aidi paramaidi2)
  {
    if ((paramaidi1 == null) && (paramaidi2 == null)) {
      return 0;
    }
    if (paramaidi1 == null) {
      return -1;
    }
    if (paramaidi2 == null) {
      return 1;
    }
    if (a(paramaidi1) == a(paramaidi2)) {
      return (int)(a(paramaidi2) - a(paramaidi1));
    }
    return a(paramaidi1) - a(paramaidi2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aidg
 * JD-Core Version:    0.7.0.1
 */