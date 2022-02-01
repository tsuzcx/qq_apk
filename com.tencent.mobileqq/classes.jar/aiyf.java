import com.tencent.mobileqq.data.MayKnowRecommend;
import java.util.Comparator;

class aiyf
  implements Comparator<MayKnowRecommend>
{
  aiyf(aiya paramaiya) {}
  
  public int a(MayKnowRecommend paramMayKnowRecommend1, MayKnowRecommend paramMayKnowRecommend2)
  {
    return paramMayKnowRecommend2.timestamp - paramMayKnowRecommend1.timestamp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyf
 * JD-Core Version:    0.7.0.1
 */