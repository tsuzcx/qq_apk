import com.tencent.mobileqq.data.DiscussionInfo;
import java.util.Comparator;
import java.util.HashMap;

class akin
  implements Comparator<awge>
{
  akin(akim paramakim, HashMap paramHashMap) {}
  
  public int a(awge paramawge1, awge paramawge2)
  {
    long l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(((DiscussionInfo)paramawge1).uin)).longValue();
    long l2 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(((DiscussionInfo)paramawge2).uin)).longValue();
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
 * Qualified Name:     akin
 * JD-Core Version:    0.7.0.1
 */