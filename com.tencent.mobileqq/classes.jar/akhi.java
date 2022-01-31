import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.Comparator;

public class akhi
  implements Comparator<akhk>
{
  private int a(akhk paramakhk)
  {
    if ((a(paramakhk) == 0L) || (paramakhk.jdField_a_of_type_Int == 4)) {
      return paramakhk.jdField_a_of_type_Int + 3;
    }
    return paramakhk.jdField_a_of_type_Int;
  }
  
  private long a(akhk paramakhk)
  {
    if ((paramakhk.jdField_a_of_type_Awbv instanceof TroopInfo)) {
      return ((TroopInfo)paramakhk.jdField_a_of_type_Awbv).lastMsgTime;
    }
    if ((paramakhk.jdField_a_of_type_Awbv instanceof DiscussionInfo)) {
      return ((DiscussionInfo)paramakhk.jdField_a_of_type_Awbv).lastMsgTime;
    }
    return 0L;
  }
  
  public int a(akhk paramakhk1, akhk paramakhk2)
  {
    if ((paramakhk1 == null) && (paramakhk2 == null)) {
      return 0;
    }
    if (paramakhk1 == null) {
      return -1;
    }
    if (paramakhk2 == null) {
      return 1;
    }
    if (a(paramakhk1) == a(paramakhk2)) {
      return (int)(a(paramakhk2) - a(paramakhk1));
    }
    return a(paramakhk1) - a(paramakhk2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhi
 * JD-Core Version:    0.7.0.1
 */