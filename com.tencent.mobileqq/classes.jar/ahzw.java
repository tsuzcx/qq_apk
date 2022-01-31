import com.tencent.mobileqq.data.DiscussionInfo;
import java.util.Comparator;
import java.util.HashMap;

class ahzw
  implements Comparator<atmo>
{
  ahzw(ahzv paramahzv, HashMap paramHashMap) {}
  
  public int a(atmo paramatmo1, atmo paramatmo2)
  {
    long l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(((DiscussionInfo)paramatmo1).uin)).longValue();
    long l2 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(((DiscussionInfo)paramatmo2).uin)).longValue();
    if (l1 < l2) {
      return -1;
    }
    if (l1 > l2) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahzw
 * JD-Core Version:    0.7.0.1
 */