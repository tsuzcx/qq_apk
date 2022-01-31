import com.tencent.mobileqq.data.DiscussionInfo;
import java.util.Comparator;
import java.util.HashMap;

class akdy
  implements Comparator<awbv>
{
  akdy(akdx paramakdx, HashMap paramHashMap) {}
  
  public int a(awbv paramawbv1, awbv paramawbv2)
  {
    long l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(((DiscussionInfo)paramawbv1).uin)).longValue();
    long l2 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(((DiscussionInfo)paramawbv2).uin)).longValue();
    if (l1 < l2) {
      return -1;
    }
    if (l1 > l2) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdy
 * JD-Core Version:    0.7.0.1
 */