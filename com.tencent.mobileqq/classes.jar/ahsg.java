import com.tencent.mobileqq.data.MayKnowRecommend;
import java.util.Comparator;

class ahsg
  implements Comparator<MayKnowRecommend>
{
  ahsg(ahse paramahse) {}
  
  public int a(MayKnowRecommend paramMayKnowRecommend1, MayKnowRecommend paramMayKnowRecommend2)
  {
    long l1 = paramMayKnowRecommend1.cardDisplayTimestamp;
    long l2 = paramMayKnowRecommend2.cardDisplayTimestamp;
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsg
 * JD-Core Version:    0.7.0.1
 */